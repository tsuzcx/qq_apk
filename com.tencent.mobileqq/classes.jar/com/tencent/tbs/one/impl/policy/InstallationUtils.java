package com.tencent.tbs.one.impl.policy;

import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.impl.base.FileUtils;
import com.tencent.tbs.one.impl.base.GlobalUtils;
import com.tencent.tbs.one.impl.base.Logging;
import com.tencent.tbs.one.impl.base.NullOutputStream;
import com.tencent.tbs.one.impl.base.ProcessLock;
import com.tencent.tbs.one.impl.base.ProgressInputStream;
import com.tencent.tbs.one.impl.base.ProgressInputStream.Client;
import com.tencent.tbs.one.impl.common.Constants;
import com.tencent.tbs.one.impl.common.DEPSConfig;
import com.tencent.tbs.one.impl.common.DEPSConfig.ComponentConfig;
import com.tencent.tbs.one.impl.common.ManifestConfig;
import com.tencent.tbs.one.impl.common.ManifestConfig.FileConfig;
import com.tencent.tbs.one.impl.common.PathService;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class InstallationUtils
{
  public static final String APP_DEMO = "com.tencent.tbs";
  public static final String APP_MM = "com.tencent.mm";
  public static final String APP_QQ = "com.tencent.mobileqq";
  private static final String FAILED_FLAG_FILENAME_SUFFIX = ".failed";
  private static final String INCOMPLETE_FLAG_FILENAME_SUFFIX = ".incomplete";
  private static final String MM_SIG = "308202eb30820254a00302010202044d36f7a4300d06092a864886f70d01010505003081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e74301e170d3131303131393134333933325a170d3431303131313134333933325a3081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e7430819f300d06092a864886f70d010101050003818d0030818902818100c05f34b231b083fb1323670bfbe7bdab40c0c0a6efc87ef2072a1ff0d60cc67c8edb0d0847f210bea6cbfaa241be70c86daf56be08b723c859e52428a064555d80db448cdcacc1aea2501eba06f8bad12a4fa49d85cacd7abeb68945a5cb5e061629b52e3254c373550ee4e40cb7c8ae6f7a8151ccd8df582d446f39ae0c5e930203010001300d06092a864886f70d0101050500038181009c8d9d7f2f908c42081b4c764c377109a8b2c70582422125ce545842d5f520aea69550b6bd8bfd94e987b75a3077eb04ad341f481aac266e89d3864456e69fba13df018acdc168b9a19dfd7ad9d9cc6f6ace57c746515f71234df3a053e33ba93ece5cd0fc15f3e389a3f365588a9fcb439e069d3629cd7732a13fff7b891499";
  private static final String QQ_SIG = "30820253308201bca00302010202044bbb0361300d06092a864886f70d0101050500306d310e300c060355040613054368696e61310f300d06035504080c06e58c97e4baac310f300d06035504070c06e58c97e4baac310f300d060355040a0c06e885bee8aeaf311b3019060355040b0c12e697a0e7babfe4b89ae58aa1e7b3bbe7bb9f310b30090603550403130251513020170d3130303430363039343831375a180f32323834303132303039343831375a306d310e300c060355040613054368696e61310f300d06035504080c06e58c97e4baac310f300d06035504070c06e58c97e4baac310f300d060355040a0c06e885bee8aeaf311b3019060355040b0c12e697a0e7babfe4b89ae58aa1e7b3bbe7bb9f310b300906035504031302515130819f300d06092a864886f70d010101050003818d0030818902818100a15e9756216f694c5915e0b529095254367c4e64faeff07ae13488d946615a58ddc31a415f717d019edc6d30b9603d3e2a7b3de0ab7e0cf52dfee39373bc472fa997027d798d59f81d525a69ecf156e885fd1e2790924386b2230cc90e3b7adc95603ddcf4c40bdc72f22db0f216a99c371d3bf89cba6578c60699e8a0d536950203010001300d06092a864886f70d01010505000381810094a9b80e80691645dd42d6611775a855f71bcd4d77cb60a8e29404035a5e00b21bcc5d4a562482126bd91b6b0e50709377ceb9ef8c2efd12cc8b16afd9a159f350bb270b14204ff065d843832720702e28b41491fbc3a205f5f2f42526d67f17614d8a974de6487b2c866efede3b4e49a0f916baa3c1336fd2ee1b1629652049";
  private static final String TBS_APK_SIG = "3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a";
  
  public static void cleanProcDirectory(Context paramContext)
  {
    Logging.i("Cleaning Proc directory", new Object[0]);
    File[] arrayOfFile = PathService.getProcDirectory(paramContext).listFiles();
    if (arrayOfFile == null) {}
    int k;
    do
    {
      do
      {
        return;
        k = Process.myPid();
      } while ((arrayOfFile.length == 1) && (arrayOfFile[0].getName().equals(String.valueOf(k))));
      paramContext = GlobalUtils.getAllRunningProcesses(paramContext);
    } while (paramContext == null);
    int m = arrayOfFile.length;
    int j = 0;
    label68:
    File localFile;
    int i;
    if (j < m)
    {
      localFile = arrayOfFile[j];
      int n = Integer.valueOf(localFile.getName()).intValue();
      if (n != k)
      {
        Iterator localIterator = paramContext.iterator();
        i = 0;
        label109:
        if (localIterator.hasNext())
        {
          if (((ActivityManager.RunningAppProcessInfo)localIterator.next()).pid != n) {
            break label159;
          }
          i = 1;
        }
      }
    }
    label159:
    for (;;)
    {
      break label109;
      if (i == 0) {
        FileUtils.recursivelyDeleteFile(localFile);
      }
      j += 1;
      break label68;
      break;
    }
  }
  
  public static void cleanUselessComponents(File paramFile)
  {
    String str1 = paramFile.getName();
    Logging.i("[%s] Cleaning useless components", new Object[] { str1 });
    Object localObject1 = PathService.getDEPSFile(paramFile);
    if (!((File)localObject1).exists())
    {
      Logging.i("[%s] %s no DEPS file exists", new Object[] { str1, "Early out for cleanup useless components," });
      return;
    }
    Object localObject2 = ProcessLock.tryAcquire(PathService.getProcessLockFile((File)localObject1));
    if (localObject2 == null)
    {
      Logging.i("[%s] %s the DEPS installation lock is busy", new Object[] { str1, "Early out for cleanup useless components," });
      return;
    }
    Object localObject4 = PathService.getLatestDEPSFile(paramFile);
    Object localObject3 = ProcessLock.tryAcquire(PathService.getProcessLockFile((File)localObject4));
    localObject2 = new InstallationUtils.2((ProcessLock)localObject2, (ProcessLock)localObject3);
    if (localObject3 == null)
    {
      Logging.i("[%s] %s the update lock is busy", new Object[] { str1, "Early out for cleanup useless components," });
      ((Runnable)localObject2).run();
      return;
    }
    try
    {
      localObject3 = DEPSConfig.parse((File)localObject1);
      localObject1 = null;
      if (((File)localObject4).exists()) {}
      k = paramFile.length;
    }
    catch (TBSOneException paramFile)
    {
      try
      {
        localObject1 = DEPSConfig.parse((File)localObject4);
        paramFile = PathService.getComponentsDirectory(paramFile).listFiles();
        if (paramFile != null) {
          break label259;
        }
        ((Runnable)localObject2).run();
        return;
      }
      catch (TBSOneException paramFile)
      {
        Logging.e("[%s] Failed to parse latest DEPS %s", new Object[] { str1, " to clean useless components", paramFile });
        ((Runnable)localObject2).run();
        return;
      }
      paramFile = paramFile;
      Logging.e("[%s] Failed to parse current DEPS %s", new Object[] { str1, " to clean useless components", paramFile });
      ((Runnable)localObject2).run();
      return;
    }
    label259:
    int k;
    int i = 0;
    if (i < k)
    {
      localObject4 = paramFile[i];
      String str2 = ((File)localObject4).getName();
      int m = getComponentVersionCode((DEPSConfig)localObject3, str2);
      int n = getComponentVersionCode((DEPSConfig)localObject1, str2);
      if ((m == -1) && (n == -1)) {
        FileUtils.recursivelyDeleteFile((File)localObject4);
      }
      do
      {
        i += 1;
        break;
        localObject4 = ((File)localObject4).listFiles();
      } while (localObject4 == null);
      int i1 = localObject4.length;
      int j = 0;
      label343:
      String str3;
      if (j < i1)
      {
        str2 = localObject4[j];
        if (!str2.isDirectory()) {
          break label431;
        }
        str3 = str2.getName();
        if ((!str3.equals(String.valueOf(m))) && (!str3.equals(String.valueOf(n))))
        {
          Logging.i("[%s] Deleting unreferenced component version directory %s", new Object[] { str1, str2.getAbsolutePath() });
          FileUtils.recursivelyDeleteFile(str2);
        }
      }
      for (;;)
      {
        j += 1;
        break label343;
        break;
        label431:
        str3 = str2.getName();
        if (str3.endsWith(".incomplete"))
        {
          if (!new File(str2.getParent(), str3.substring(0, str3.length() - ".incomplete".length())).exists())
          {
            Logging.i("[%s] Deleting unused incomplete flag file %s", new Object[] { str1, str2.getAbsolutePath() });
            FileUtils.recursivelyDeleteFile(str2);
          }
        }
        else if (str3.endsWith(".failed"))
        {
          if (System.currentTimeMillis() - str2.lastModified() >= 86400000L)
          {
            Logging.i("[%s] Deleting expired failed flag file %s", new Object[] { str1, str2.getAbsolutePath() });
            FileUtils.recursivelyDeleteFile(str2);
          }
        }
        else
        {
          Logging.i("[%s] Deleting unknown file %s", new Object[] { str1, str2.getAbsolutePath() });
          FileUtils.recursivelyDeleteFile(str2);
        }
      }
    }
    ((Runnable)localObject2).run();
  }
  
  public static void clearLastFailedTimeMillis(File paramFile)
  {
    FileUtils.deleteFileWithWarning(PathService.getSuffixedFile(paramFile, ".failed"));
  }
  
  public static int computeProgress(int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = Math.min(Math.max(0, paramInt1), 100);
    float f = paramInt2;
    return (int)(paramInt1 / 100.0F * (paramInt3 - paramInt2) + f);
  }
  
  public static void createIncompleteFlag(File paramFile)
  {
    paramFile = PathService.getSuffixedFile(paramFile, ".incomplete");
    if (!paramFile.exists()) {
      FileUtils.createFileWithWarning(paramFile);
    }
  }
  
  private static String decodeFromLibraryName(String paramString)
  {
    return new String(Base64.decode(unescapeFromLibraryName(paramString, "libtbs="), 2), Constants.UTF8_CHARSET);
  }
  
  public static void deleteIncompleteFlag(File paramFile)
  {
    paramFile = PathService.getSuffixedFile(paramFile, ".incomplete");
    if (paramFile.exists()) {
      FileUtils.deleteFileWithWarning(paramFile);
    }
  }
  
  public static void extractFromInstallationPackage(File paramFile1, File paramFile2)
  {
    Logging.i("Extracting from installation package %s to %s", new Object[] { paramFile1.getAbsolutePath(), paramFile2.getAbsolutePath() });
    File localFile = new File(paramFile1, "jni");
    String[] arrayOfString;
    int m;
    int i;
    if (Build.VERSION.SDK_INT < 21)
    {
      arrayOfString = new String[2];
      arrayOfString[0] = Build.CPU_ABI;
      arrayOfString[1] = Build.CPU_ABI2;
      m = arrayOfString.length;
      i = 0;
    }
    int k;
    for (int j = 1;; j = k)
    {
      if (i >= m) {
        break label198;
      }
      String str = arrayOfString[i];
      Object localObject = new File(localFile, str);
      k = j;
      if (((File)localObject).exists())
      {
        localObject = ((File)localObject).listFiles();
        k = j;
        if (localObject != null)
        {
          k = j;
          if (localObject.length > 0)
          {
            Logging.i("  ABI: %s", new Object[] { str });
            k = localObject.length;
            j = 0;
            for (;;)
            {
              if (j < k)
              {
                extractFromJNILibsDirectory(localObject[j], paramFile2);
                j += 1;
                continue;
                arrayOfString = Build.SUPPORTED_ABIS;
                break;
              }
            }
            k = 0;
          }
        }
      }
      i += 1;
    }
    label198:
    if (j != 0) {
      Logging.w("No files to extract from %s", new Object[] { paramFile1.getAbsolutePath() });
    }
  }
  
  private static void extractFromJNILibsDirectory(File paramFile1, File paramFile2)
  {
    String str = paramFile1.getName();
    Object localObject2;
    Object localObject1;
    if (str.startsWith("libtbs="))
    {
      localObject2 = decodeFromLibraryName(str);
      localObject1 = localObject2;
      if (((String)localObject2).contains(File.separator)) {
        localObject1 = ((String)localObject2).substring(((String)localObject2).indexOf(File.separatorChar) + 1);
      }
    }
    for (;;)
    {
      localObject2 = new File(paramFile2, (String)localObject1);
      if (!((File)localObject2).exists()) {
        break;
      }
      Logging.i("    %s -> %s, already exist", new Object[] { str, localObject1 });
      return;
      if (str.startsWith("libtbs")) {
        localObject1 = unescapeFromLibraryName(str, "libtbs");
      } else {
        localObject1 = str;
      }
    }
    Logging.i("    %s -> %s", new Object[] { str, localObject1 });
    try
    {
      FileUtils.renameOrCopyFile(paramFile1, (File)localObject2);
      return;
    }
    catch (IOException paramFile1)
    {
      throw new TBSOneException(316, "Failed to extract component files in " + paramFile2.getAbsolutePath(), paramFile1);
    }
  }
  
  public static void extractFromNativeLibraryDirectory(File paramFile1, String paramString1, String paramString2, File paramFile2)
  {
    FileUtils.copyFile(PathService.getComponentFileInNativeLibraryDirectory(paramFile1, paramString1, paramString2), paramFile2);
  }
  
  private static int getComponentVersionCode(DEPSConfig paramDEPSConfig, String paramString)
  {
    if (paramDEPSConfig != null)
    {
      paramDEPSConfig = paramDEPSConfig.getComponentConfig(paramString);
      if (paramDEPSConfig != null) {
        return paramDEPSConfig.getVersionCode();
      }
    }
    return -1;
  }
  
  public static long getLastFailedTimeMillis(File paramFile)
  {
    paramFile = PathService.getSuffixedFile(paramFile, ".failed");
    if (paramFile.exists()) {
      return paramFile.lastModified();
    }
    return 0L;
  }
  
  public static int getLocalComponentVersion(File paramFile)
  {
    paramFile = paramFile.listFiles(new InstallationUtils.1());
    int j;
    if (paramFile == null) {
      j = -1;
    }
    int m;
    int k;
    int i;
    do
    {
      return j;
      m = paramFile.length;
      k = 0;
      i = -1;
      j = i;
    } while (k >= m);
    File localFile = paramFile[k];
    if (isArchiveComplete(localFile)) {}
    for (;;)
    {
      try
      {
        j = Integer.parseInt(localFile.getName());
        if ((j != -1) && (j > i))
        {
          k += 1;
          i = j;
        }
      }
      catch (Exception localException)
      {
        Logging.e("Failed to parse component version from path %s", new Object[] { localFile.getAbsolutePath(), localException });
        j = -1;
        continue;
      }
      j = i;
    }
  }
  
  public static MessageDigest getMD5Digest()
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      return localMessageDigest;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      throw new TBSOneException(106, "Failed to find md5 algorithm", localNoSuchAlgorithmException);
    }
  }
  
  public static boolean isArchiveComplete(File paramFile)
  {
    return !PathService.getSuffixedFile(paramFile, ".incomplete").exists();
  }
  
  public static boolean isCategoryBeingUsedByOtherProcesses(Context paramContext, String paramString)
  {
    paramContext = PathService.getProcDirectory(paramContext).listFiles();
    if (paramContext == null) {
      return false;
    }
    int j = paramContext.length;
    int i = 0;
    label19:
    File localFile;
    if (i < j)
    {
      localFile = paramContext[i];
      if (!localFile.getName().equals(String.valueOf(Process.myPid()))) {
        break label53;
      }
    }
    label53:
    while (!PathService.getInUseCategoryFlagFile(localFile, paramString).exists())
    {
      i += 1;
      break label19;
      break;
    }
    Logging.i("[%s] The category is being used by process %s", new Object[] { paramString, localFile.getName() });
    return true;
  }
  
  private static Certificate[] loadCertificates(JarFile paramJarFile, JarEntry paramJarEntry, byte[] paramArrayOfByte)
  {
    paramJarFile = paramJarFile.getInputStream(paramJarEntry);
    while (paramJarFile.read(paramArrayOfByte, 0, paramArrayOfByte.length) != -1) {}
    paramJarFile.close();
    if (paramJarEntry != null) {
      return paramJarEntry.getCertificates();
    }
    return null;
  }
  
  public static void setDirectoryExcutableIfNeeded(File paramFile)
  {
    if (paramFile == null) {}
    try
    {
      Logging.i("setDirectoryExcutableIfNeeded,dir=null,return", new Object[0]);
      return;
    }
    catch (Exception paramFile)
    {
      Logging.i("setDirectoryExcutableIfNeeded,exception=%s", new Object[] { Log.getStackTraceString(paramFile) });
      return;
    }
    paramFile = paramFile.listFiles();
    if (paramFile == null)
    {
      Logging.i("setDirectoryExcutableIfNeeded,subdir=null,return", new Object[0]);
      return;
    }
    int j = paramFile.length;
    int i = 0;
    while (i < j)
    {
      File localFile = paramFile[i];
      if (localFile.isDirectory())
      {
        localFile.setExecutable(true, false);
        setDirectoryExcutableIfNeeded(localFile);
      }
      i += 1;
    }
  }
  
  public static void setLastFailedTimeMillis(File paramFile, long paramLong)
  {
    FileUtils.touchWithWarning(PathService.getSuffixedFile(paramFile, ".failed"), paramLong);
  }
  
  public static void shareFile(File paramFile)
  {
    Logging.i("shareFileIfNeeded,directory=%s", new Object[] { paramFile });
    if (paramFile != null) {
      try
      {
        if (paramFile.exists())
        {
          paramFile.setReadable(true, false);
          if (paramFile.isDirectory())
          {
            paramFile = paramFile.listFiles();
            int j = paramFile.length;
            int i = 0;
            while (i < j)
            {
              shareFile(paramFile[i]);
              i += 1;
            }
          }
        }
        return;
      }
      catch (Exception paramFile)
      {
        Logging.i("shareFileIfNeeded,exception=%s", new Object[] { Log.getStackTraceString(paramFile) });
      }
    }
  }
  
  private static String toCharsString(byte[] paramArrayOfByte)
  {
    int k = paramArrayOfByte.length;
    char[] arrayOfChar = new char[k * 2];
    int i = 0;
    if (i < k)
    {
      int m = paramArrayOfByte[i];
      int j = m >> 4 & 0xF;
      if (j >= 10)
      {
        j = j + 97 - 10;
        label44:
        arrayOfChar[(i * 2)] = ((char)j);
        j = m & 0xF;
        if (j < 10) {
          break label97;
        }
        j = j + 97 - 10;
      }
      for (;;)
      {
        arrayOfChar[(i * 2 + 1)] = ((char)j);
        i += 1;
        break;
        j += 48;
        break label44;
        label97:
        j += 48;
      }
    }
    return new String(arrayOfChar);
  }
  
  private static String unescapeFromLibraryName(String paramString1, String paramString2)
  {
    return paramString1.substring(paramString2.length(), paramString1.length() - ".so".length());
  }
  
  public static void unzipFromDownloadStream(InputStream paramInputStream, String paramString, long paramLong, File paramFile1, File paramFile2, ProgressInputStream.Client paramClient)
  {
    Logging.i("Unzipping from download stream to %s, sdcard backup file is %s", new Object[] { paramFile1.getAbsolutePath(), paramFile2 });
    if (!TextUtils.isEmpty(paramString)) {}
    for (MessageDigest localMessageDigest = getMD5Digest();; localMessageDigest = null)
    {
      if (localMessageDigest != null) {}
      for (paramInputStream = new ProgressInputStream(new DigestInputStream(paramInputStream, localMessageDigest), paramLong);; paramInputStream = new ProgressInputStream(paramInputStream, paramLong))
      {
        paramInputStream.setClient(paramClient);
        try
        {
          FileUtils.unzipStream(paramInputStream, paramFile1, paramFile2);
          if (paramLong <= 0L) {
            break;
          }
          long l = paramInputStream.getTotalBytesRead();
          if (l == paramLong) {
            break;
          }
          throw new TBSOneException(221, "Failed to verify download stream length, expected " + paramLong + " but was " + l);
        }
        catch (IOException paramInputStream)
        {
          throw new TBSOneException(315, "Failed to unzip online component from " + paramFile1.getAbsolutePath() + " to " + paramFile1.getAbsolutePath(), paramInputStream);
        }
      }
      if (localMessageDigest != null)
      {
        paramInputStream = GlobalUtils.bytesToHexString(localMessageDigest.digest());
        if (!paramInputStream.equals(paramString)) {
          throw new TBSOneException(108, "Failed to verify download stream md5, expected " + paramString + " but was " + paramInputStream);
        }
      }
      return;
    }
  }
  
  public static void verifyFileMd5(MessageDigest paramMessageDigest, File paramFile, String paramString)
  {
    try
    {
      FileUtils.copyStream(new DigestInputStream(new FileInputStream(paramFile), paramMessageDigest), NullOutputStream.NULL_OUTPUT_STREAM);
      paramMessageDigest = GlobalUtils.bytesToHexString(paramMessageDigest.digest());
      if (!paramMessageDigest.equals(paramString)) {
        throw new TBSOneException(108, "Failed to verify md5 for component file " + paramFile.getAbsolutePath() + ", expected " + paramString + " but was " + paramMessageDigest);
      }
    }
    catch (IOException paramMessageDigest)
    {
      throw new TBSOneException(107, "Failed to compute md5 for component file " + paramFile.getAbsolutePath(), paramMessageDigest);
    }
  }
  
  public static void verifyInstallationDirectory(File paramFile, int paramInt)
  {
    Object localObject1 = ManifestConfig.parse(new File(paramFile, "MANIFEST"));
    int i = ((ManifestConfig)localObject1).getVersionCode();
    if (paramInt != i) {
      throw new TBSOneException(417, "Failed to verify version code, expected " + paramInt + " but was " + i);
    }
    ManifestConfig.FileConfig[] arrayOfFileConfig = ((ManifestConfig)localObject1).getFileConfigs();
    if (arrayOfFileConfig != null)
    {
      i = arrayOfFileConfig.length;
      localObject1 = null;
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = arrayOfFileConfig[paramInt];
        File localFile = new File(paramFile, ((ManifestConfig.FileConfig)localObject2).getPath());
        if (!localFile.exists()) {
          throw new TBSOneException(105, "Failed to find component file " + localFile.getAbsolutePath());
        }
        String str = ((ManifestConfig.FileConfig)localObject2).getMD5();
        localObject2 = localObject1;
        if (!TextUtils.isEmpty(str))
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = getMD5Digest();
          }
          verifyFileMd5((MessageDigest)localObject2, localFile, str);
        }
        paramInt += 1;
        localObject1 = localObject2;
      }
    }
  }
  
  public static boolean verifyPkgLegality(File paramFile)
  {
    Logging.i("verifyPkgLegality,path=%s", new Object[] { paramFile });
    if ((paramFile == null) || (!paramFile.exists()))
    {
      Logging.i("verify file signature failed,path=", new Object[] { paramFile });
      return false;
    }
    do
    {
      try
      {
        localJarFile = new JarFile(paramFile);
        localEnumeration = localJarFile.entries();
        localObject1 = null;
        arrayOfByte = new byte[8192];
      }
      catch (Exception paramFile)
      {
        for (;;)
        {
          JarFile localJarFile;
          Enumeration localEnumeration;
          byte[] arrayOfByte;
          JarEntry localJarEntry;
          Object localObject2;
          Logging.i("verifyPkgLegality failed,exception=%s,stack=", new Object[] { paramFile, Log.getStackTraceString(paramFile) });
          continue;
          break label267;
          Object localObject1 = localObject2;
        }
      }
      if (!localEnumeration.hasMoreElements()) {
        break;
      }
      localJarEntry = (JarEntry)localEnumeration.nextElement();
    } while ((localJarEntry.isDirectory()) || (localJarEntry.getName().startsWith("META-INF/")));
    localObject2 = loadCertificates(localJarFile, localJarEntry, arrayOfByte);
    if (localObject2 != null)
    {
      localObject2 = toCharsString(localObject2[0].getEncoded());
      if (localObject1 == null) {
        break label265;
      }
      if (!localObject1.equals(localObject2))
      {
        Logging.i("verify file signature failed,origin entry=%s,signature=%s,target=%s", new Object[] { localJarEntry.getName(), localObject2, localObject1 });
        return false;
      }
    }
    else
    {
      Logging.i("verify file signature failed,origin entry=%s,signature is null", new Object[] { localJarEntry.getName() });
      return false;
      if ((localObject1 != null) && ("3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a".equals(localObject1)))
      {
        Logging.i("verify file signature success,path=%s", new Object[] { paramFile });
        return true;
      }
      Logging.i("verify file not success,signature=%s", new Object[] { localObject1 });
      return false;
    }
  }
  
  public static boolean vertificateApp(Context paramContext, String paramString)
  {
    int i = -1;
    try
    {
      switch (paramString.hashCode())
      {
      case -973170826: 
        if (!paramString.equals("com.tencent.mm")) {
          break label157;
        }
        i = 0;
      }
    }
    catch (Exception paramContext)
    {
      Logging.e("verify app exception,e=" + Log.getStackTraceString(paramContext), new Object[0]);
      return false;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      return false;
    }
    if (paramString.equals("com.tencent.mobileqq"))
    {
      i = 1;
      break label157;
      if (paramString.equals("com.tencent.tbs")) {
        i = 2;
      }
    }
    for (;;)
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 64);
      String str;
      if ((paramContext != null) && (str.equals(paramContext.signatures[0].toCharsString())))
      {
        return true;
        str = "3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a";
      }
      else
      {
        switch (i)
        {
        case 2: 
        default: 
          return false;
        case 0: 
          str = "308202eb30820254a00302010202044d36f7a4300d06092a864886f70d01010505003081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e74301e170d3131303131393134333933325a170d3431303131313134333933325a3081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e7430819f300d06092a864886f70d010101050003818d0030818902818100c05f34b231b083fb1323670bfbe7bdab40c0c0a6efc87ef2072a1ff0d60cc67c8edb0d0847f210bea6cbfaa241be70c86daf56be08b723c859e52428a064555d80db448cdcacc1aea2501eba06f8bad12a4fa49d85cacd7abeb68945a5cb5e061629b52e3254c373550ee4e40cb7c8ae6f7a8151ccd8df582d446f39ae0c5e930203010001300d06092a864886f70d0101050500038181009c8d9d7f2f908c42081b4c764c377109a8b2c70582422125ce545842d5f520aea69550b6bd8bfd94e987b75a3077eb04ad341f481aac266e89d3864456e69fba13df018acdc168b9a19dfd7ad9d9cc6f6ace57c746515f71234df3a053e33ba93ece5cd0fc15f3e389a3f365588a9fcb439e069d3629cd7732a13fff7b891499";
          break;
        case 1: 
          label157:
          str = "30820253308201bca00302010202044bbb0361300d06092a864886f70d0101050500306d310e300c060355040613054368696e61310f300d06035504080c06e58c97e4baac310f300d06035504070c06e58c97e4baac310f300d060355040a0c06e885bee8aeaf311b3019060355040b0c12e697a0e7babfe4b89ae58aa1e7b3bbe7bb9f310b30090603550403130251513020170d3130303430363039343831375a180f32323834303132303039343831375a306d310e300c060355040613054368696e61310f300d06035504080c06e58c97e4baac310f300d06035504070c06e58c97e4baac310f300d060355040a0c06e885bee8aeaf311b3019060355040b0c12e697a0e7babfe4b89ae58aa1e7b3bbe7bb9f310b300906035504031302515130819f300d06092a864886f70d010101050003818d0030818902818100a15e9756216f694c5915e0b529095254367c4e64faeff07ae13488d946615a58ddc31a415f717d019edc6d30b9603d3e2a7b3de0ab7e0cf52dfee39373bc472fa997027d798d59f81d525a69ecf156e885fd1e2790924386b2230cc90e3b7adc95603ddcf4c40bdc72f22db0f216a99c371d3bf89cba6578c60699e8a0d536950203010001300d06092a864886f70d01010505000381810094a9b80e80691645dd42d6611775a855f71bcd4d77cb60a8e29404035a5e00b21bcc5d4a562482126bd91b6b0e50709377ceb9ef8c2efd12cc8b16afd9a159f350bb270b14204ff065d843832720702e28b41491fbc3a205f5f2f42526d67f17614d8a974de6487b2c866efede3b4e49a0f916baa3c1336fd2ee1b1629652049";
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.policy.InstallationUtils
 * JD-Core Version:    0.7.0.1
 */