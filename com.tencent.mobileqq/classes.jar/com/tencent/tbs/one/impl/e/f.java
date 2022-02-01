package com.tencent.tbs.one.impl.e;

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
import com.tencent.tbs.one.impl.a.c;
import com.tencent.tbs.one.impl.a.i;
import com.tencent.tbs.one.impl.a.j;
import com.tencent.tbs.one.impl.a.k;
import com.tencent.tbs.one.impl.a.k.a;
import com.tencent.tbs.one.impl.common.b;
import com.tencent.tbs.one.impl.common.d.a;
import com.tencent.tbs.one.impl.common.e;
import com.tencent.tbs.one.impl.common.e.a;
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

public class f
{
  public static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = Math.min(Math.max(0, paramInt1), 100);
    float f = paramInt2;
    return (int)(paramInt1 / 100.0F * (paramInt3 - paramInt2) + f);
  }
  
  private static int a(com.tencent.tbs.one.impl.common.d paramd, String paramString)
  {
    if (paramd != null)
    {
      paramd = paramd.b(paramString);
      if (paramd != null) {
        return paramd.c;
      }
    }
    return -1;
  }
  
  private static String a(String paramString1, String paramString2)
  {
    return paramString1.substring(paramString2.length(), paramString1.length() - 3);
  }
  
  private static String a(byte[] paramArrayOfByte)
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
  
  public static MessageDigest a()
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      return localMessageDigest;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      throw new TBSOneException(106, "Failed to find md5 algorithm, error: " + localNoSuchAlgorithmException.getMessage(), localNoSuchAlgorithmException);
    }
  }
  
  public static void a(Context paramContext)
  {
    com.tencent.tbs.one.impl.a.f.a("Cleaning proc directory", new Object[0]);
    File[] arrayOfFile = com.tencent.tbs.one.impl.common.f.b(paramContext).listFiles();
    if (arrayOfFile == null)
    {
      com.tencent.tbs.one.impl.a.f.a("Empty proc directory", new Object[0]);
      return;
    }
    int k = Process.myPid();
    if ((arrayOfFile.length == 1) && (arrayOfFile[0].getName().equals(String.valueOf(k))))
    {
      com.tencent.tbs.one.impl.a.f.a("No need to clean", new Object[0]);
      return;
    }
    paramContext = com.tencent.tbs.one.impl.a.d.d(paramContext);
    if (paramContext == null)
    {
      com.tencent.tbs.one.impl.a.f.a("Cannot get running process infos, disabled is %s", new Object[] { Boolean.valueOf(com.tencent.tbs.one.impl.a.d.e()) });
      return;
    }
    int m = arrayOfFile.length;
    int j = 0;
    label106:
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
        label147:
        if (localIterator.hasNext())
        {
          if (((ActivityManager.RunningAppProcessInfo)localIterator.next()).pid != n) {
            break label197;
          }
          i = 1;
        }
      }
    }
    label197:
    for (;;)
    {
      break label147;
      if (i == 0) {
        c.a(localFile);
      }
      j += 1;
      break label106;
      break;
    }
  }
  
  public static void a(File paramFile)
  {
    if (paramFile == null) {}
    try
    {
      com.tencent.tbs.one.impl.a.f.a("setDirectoryExcutableIfNeeded,dir=null,return", new Object[0]);
      return;
    }
    catch (Exception paramFile)
    {
      com.tencent.tbs.one.impl.a.f.a("setDirectoryExcutableIfNeeded,exception=%s", new Object[] { Log.getStackTraceString(paramFile) });
      return;
    }
    paramFile = paramFile.listFiles();
    if (paramFile == null)
    {
      com.tencent.tbs.one.impl.a.f.a("setDirectoryExcutableIfNeeded,subdir=null,return", new Object[0]);
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
        a(localFile);
      }
      i += 1;
    }
  }
  
  public static void a(File paramFile, int paramInt)
  {
    Object localObject1 = e.a(new File(paramFile, "MANIFEST"));
    int i = ((e)localObject1).a;
    if (paramInt != i) {
      throw new TBSOneException(417, "Failed to verify version code, expected " + paramInt + " but was " + i);
    }
    e.a[] arrayOfa = ((e)localObject1).e;
    if (arrayOfa != null)
    {
      i = arrayOfa.length;
      localObject1 = null;
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = arrayOfa[paramInt];
        File localFile = new File(paramFile, ((e.a)localObject2).a);
        if (!localFile.exists()) {
          throw new TBSOneException(105, "Failed to find component file " + localFile.getAbsolutePath());
        }
        String str = ((e.a)localObject2).b;
        localObject2 = localObject1;
        if (!TextUtils.isEmpty(str))
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = a();
          }
          a((MessageDigest)localObject2, localFile, str);
        }
        paramInt += 1;
        localObject1 = localObject2;
      }
    }
  }
  
  public static void a(File paramFile, long paramLong)
  {
    paramFile = com.tencent.tbs.one.impl.common.f.e(paramFile, ".failed");
    try
    {
      if ((paramFile.exists()) || (paramFile.createNewFile()))
      {
        if (!paramFile.setLastModified(paramLong)) {
          com.tencent.tbs.one.impl.a.f.c("Failed to touch file %s, cannot set last modified with %d", new Object[] { paramFile.getAbsolutePath(), Long.valueOf(paramLong) });
        }
      }
      else
      {
        com.tencent.tbs.one.impl.a.f.c("Failed to touch file %s, cannot create new file", new Object[] { paramFile.getAbsolutePath() });
        return;
      }
    }
    catch (IOException localIOException)
    {
      com.tencent.tbs.one.impl.a.f.c("Failed to touch file %s", new Object[] { paramFile.getAbsolutePath(), localIOException });
    }
  }
  
  public static void a(File paramFile1, File paramFile2)
  {
    com.tencent.tbs.one.impl.a.f.a("Extracting from installation package %s to %s", new Object[] { paramFile1.getAbsolutePath(), paramFile2.getAbsolutePath() });
    File localFile1 = new File(paramFile1, "jni");
    File localFile2 = new File(paramFile1, "lib");
    String[] arrayOfString;
    int k;
    int i;
    if (Build.VERSION.SDK_INT < 21)
    {
      arrayOfString = new String[2];
      arrayOfString[0] = Build.CPU_ABI;
      arrayOfString[1] = Build.CPU_ABI2;
      k = arrayOfString.length;
      i = 0;
    }
    for (;;)
    {
      if (i >= k) {
        break label440;
      }
      String str2 = arrayOfString[i];
      Object localObject1 = new File(localFile1, str2);
      if (((File)localObject1).exists())
      {
        File[] arrayOfFile = ((File)localObject1).listFiles();
        if ((arrayOfFile != null) && (arrayOfFile.length > 0))
        {
          com.tencent.tbs.one.impl.a.f.a("  ABI: %s", new Object[] { str2 });
          int m = arrayOfFile.length;
          int j = 0;
          label158:
          if (j < m)
          {
            File localFile3 = arrayOfFile[j];
            String str1 = localFile3.getName();
            Object localObject2;
            if (str1.startsWith("libtbs="))
            {
              localObject2 = new String(Base64.decode(a(str1, "libtbs="), 2), b.b);
              localObject1 = localObject2;
              if (((String)localObject2).contains(File.separator)) {
                localObject1 = ((String)localObject2).substring(((String)localObject2).indexOf(File.separatorChar) + 1);
              }
              label244:
              localObject2 = new File(paramFile2, (String)localObject1);
              if (!((File)localObject2).exists()) {
                break label330;
              }
              com.tencent.tbs.one.impl.a.f.a("    %s -> %s, already exist", new Object[] { str1, localObject1 });
            }
            for (;;)
            {
              j += 1;
              break label158;
              arrayOfString = Build.SUPPORTED_ABIS;
              break;
              if (str1.startsWith("libtbs"))
              {
                localObject1 = a(str1, "libtbs");
                break label244;
              }
              localObject1 = str1;
              break label244;
              label330:
              com.tencent.tbs.one.impl.a.f.a("    %s -> %s", new Object[] { str1, localObject1 });
              try
              {
                c.c(localFile3, (File)localObject2);
              }
              catch (IOException paramFile1)
              {
                throw new TBSOneException(316, "Failed to extract component files in " + paramFile2.getAbsolutePath() + ", error: " + paramFile1.getMessage(), paramFile1);
              }
            }
          }
        }
      }
      localObject1 = new File(localFile2, str2);
      if (((File)localObject1).exists()) {
        b((File)localObject1, paramFile2);
      }
      i += 1;
    }
    label440:
    b(new File(paramFile1, "assets/webkit"), paramFile2);
  }
  
  public static void a(File paramFile1, String paramString1, String paramString2, File paramFile2)
  {
    c.a(com.tencent.tbs.one.impl.common.f.a(paramFile1, paramString1, paramString2), paramFile2);
  }
  
  public static void a(InputStream paramInputStream, String paramString, long paramLong, File paramFile1, File paramFile2, k.a parama)
  {
    com.tencent.tbs.one.impl.a.f.a("Unzipping from download stream to %s, sdcard backup file is %s", new Object[] { paramFile1.getAbsolutePath(), paramFile2 });
    if (!TextUtils.isEmpty(paramString)) {}
    for (MessageDigest localMessageDigest = a();; localMessageDigest = null)
    {
      if (localMessageDigest != null) {}
      for (paramInputStream = new k(new DigestInputStream(paramInputStream, localMessageDigest), paramLong);; paramInputStream = new k(paramInputStream, paramLong))
      {
        paramInputStream.b = parama;
        try
        {
          c.a(paramInputStream, paramFile1, paramFile2);
          if (paramLong <= 0L) {
            break;
          }
          long l = paramInputStream.a;
          if (l == paramLong) {
            break;
          }
          throw new TBSOneException(221, "Failed to verify download stream length, expected " + paramLong + " but was " + l);
        }
        catch (IOException paramInputStream)
        {
          throw new TBSOneException(315, "Failed to unzip online component to " + paramFile1.getAbsolutePath() + ", error: " + paramInputStream.getMessage(), paramInputStream);
        }
      }
      if (localMessageDigest != null)
      {
        paramInputStream = com.tencent.tbs.one.impl.a.d.a(localMessageDigest.digest());
        if (!paramInputStream.equals(paramString)) {
          throw new TBSOneException(108, "Failed to verify download stream md5, expected " + paramString + " but was " + paramInputStream);
        }
      }
      return;
    }
  }
  
  public static void a(MessageDigest paramMessageDigest, File paramFile, String paramString)
  {
    try
    {
      c.a(new DigestInputStream(new FileInputStream(paramFile), paramMessageDigest), i.a);
      paramMessageDigest = com.tencent.tbs.one.impl.a.d.a(paramMessageDigest.digest());
      if (!paramMessageDigest.equals(paramString)) {
        throw new TBSOneException(108, "Failed to verify md5 for component file " + paramFile.getAbsolutePath() + ", expected " + paramString + " but was " + paramMessageDigest);
      }
    }
    catch (IOException paramMessageDigest)
    {
      throw new TBSOneException(107, "Failed to compute md5 for component file " + paramFile.getAbsolutePath() + ", error: " + paramMessageDigest.getMessage(), paramMessageDigest);
    }
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    int i = -1;
    try
    {
      switch (paramString.hashCode())
      {
      case -973170826: 
        if (!paramString.equals("com.tencent.mm")) {
          break label158;
        }
        i = 0;
      }
    }
    catch (Exception paramContext)
    {
      com.tencent.tbs.one.impl.a.f.c("verify app exception,e=" + Log.getStackTraceString(paramContext), new Object[0]);
      return false;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      return false;
    }
    if (paramString.equals("com.tencent.mobileqq"))
    {
      i = 1;
      break label158;
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
          label158:
          str = "30820253308201bca00302010202044bbb0361300d06092a864886f70d0101050500306d310e300c060355040613054368696e61310f300d06035504080c06e58c97e4baac310f300d06035504070c06e58c97e4baac310f300d060355040a0c06e885bee8aeaf311b3019060355040b0c12e697a0e7babfe4b89ae58aa1e7b3bbe7bb9f310b30090603550403130251513020170d3130303430363039343831375a180f32323834303132303039343831375a306d310e300c060355040613054368696e61310f300d06035504080c06e58c97e4baac310f300d06035504070c06e58c97e4baac310f300d060355040a0c06e885bee8aeaf311b3019060355040b0c12e697a0e7babfe4b89ae58aa1e7b3bbe7bb9f310b300906035504031302515130819f300d06092a864886f70d010101050003818d0030818902818100a15e9756216f694c5915e0b529095254367c4e64faeff07ae13488d946615a58ddc31a415f717d019edc6d30b9603d3e2a7b3de0ab7e0cf52dfee39373bc472fa997027d798d59f81d525a69ecf156e885fd1e2790924386b2230cc90e3b7adc95603ddcf4c40bdc72f22db0f216a99c371d3bf89cba6578c60699e8a0d536950203010001300d06092a864886f70d01010505000381810094a9b80e80691645dd42d6611775a855f71bcd4d77cb60a8e29404035a5e00b21bcc5d4a562482126bd91b6b0e50709377ceb9ef8c2efd12cc8b16afd9a159f350bb270b14204ff065d843832720702e28b41491fbc3a205f5f2f42526d67f17614d8a974de6487b2c866efede3b4e49a0f916baa3c1336fd2ee1b1629652049";
        }
      }
    }
  }
  
  private static Certificate[] a(JarFile paramJarFile, JarEntry paramJarEntry, byte[] paramArrayOfByte)
  {
    paramJarFile = paramJarFile.getInputStream(paramJarEntry);
    while (paramJarFile.read(paramArrayOfByte, 0, 8192) != -1) {}
    paramJarFile.close();
    if (paramJarEntry != null) {
      return paramJarEntry.getCertificates();
    }
    return null;
  }
  
  public static void b(File paramFile)
  {
    com.tencent.tbs.one.impl.a.f.a("shareFileIfNeeded,directory=%s", new Object[] { paramFile });
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
              b(paramFile[i]);
              i += 1;
            }
          }
        }
        return;
      }
      catch (Exception paramFile)
      {
        com.tencent.tbs.one.impl.a.f.a("shareFileIfNeeded,exception=%s", new Object[] { Log.getStackTraceString(paramFile) });
      }
    }
  }
  
  private static void b(File paramFile1, File paramFile2)
  {
    try
    {
      if (paramFile1.exists())
      {
        File[] arrayOfFile = paramFile1.listFiles();
        if ((arrayOfFile != null) && (arrayOfFile.length > 0))
        {
          int j = arrayOfFile.length;
          int i = 0;
          while (i < j)
          {
            File localFile = arrayOfFile[i];
            c.c(localFile, new File(paramFile2, localFile.getName()));
            i += 1;
          }
        }
      }
      return;
    }
    catch (IOException localIOException)
    {
      throw new TBSOneException(316, "extractFromUnzipDirToTarget failed,unzip Dir=" + paramFile1 + ";target=" + paramFile2 + ", error: " + localIOException.getMessage(), localIOException);
    }
  }
  
  public static boolean b(Context paramContext, String paramString)
  {
    paramContext = com.tencent.tbs.one.impl.common.f.b(paramContext).listFiles();
    if (paramContext == null) {}
    for (;;)
    {
      return false;
      int j = paramContext.length;
      int i = 0;
      while (i < j)
      {
        File localFile = paramContext[i];
        if ((!localFile.getName().equals(String.valueOf(Process.myPid()))) && (com.tencent.tbs.one.impl.common.f.d(localFile, paramString).exists()))
        {
          com.tencent.tbs.one.impl.a.f.a("[%s] The category is being used by process %s", new Object[] { paramString, localFile.getName() });
          return true;
        }
        i += 1;
      }
    }
  }
  
  public static int c(File paramFile)
  {
    paramFile = paramFile.listFiles(new f.1());
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
    if (g(localFile)) {}
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
        com.tencent.tbs.one.impl.a.f.c("Failed to parse component version from path %s", new Object[] { localFile.getAbsolutePath(), localException });
        j = -1;
        continue;
      }
      j = i;
    }
  }
  
  public static void d(File paramFile)
  {
    String str1 = paramFile.getName();
    com.tencent.tbs.one.impl.a.f.a("[%s] Cleaning useless components", new Object[] { str1 });
    Object localObject1 = com.tencent.tbs.one.impl.common.f.b(paramFile);
    if (!((File)localObject1).exists())
    {
      com.tencent.tbs.one.impl.a.f.a("[%s] %s no DEPS file exists", new Object[] { str1, "Early out for cleanup useless components," });
      return;
    }
    Object localObject2 = j.a(com.tencent.tbs.one.impl.common.f.e((File)localObject1, ".lock"));
    if (localObject2 == null)
    {
      com.tencent.tbs.one.impl.a.f.a("[%s] %s the DEPS installation lock is busy", new Object[] { str1, "Early out for cleanup useless components," });
      return;
    }
    Object localObject4 = com.tencent.tbs.one.impl.common.f.c(paramFile);
    Object localObject3 = j.a(com.tencent.tbs.one.impl.common.f.e((File)localObject4, ".lock"));
    localObject2 = new f.2((j)localObject2, (j)localObject3);
    if (localObject3 == null)
    {
      com.tencent.tbs.one.impl.a.f.a("[%s] %s the update lock is busy", new Object[] { str1, "Early out for cleanup useless components," });
      ((Runnable)localObject2).run();
      return;
    }
    try
    {
      localObject3 = com.tencent.tbs.one.impl.common.d.a((File)localObject1);
      localObject1 = null;
      if (((File)localObject4).exists()) {}
      k = paramFile.length;
    }
    catch (TBSOneException paramFile)
    {
      try
      {
        localObject1 = com.tencent.tbs.one.impl.common.d.a((File)localObject4);
        paramFile = com.tencent.tbs.one.impl.common.f.d(paramFile).listFiles();
        if (paramFile != null) {
          break label276;
        }
        ((Runnable)localObject2).run();
        return;
      }
      catch (TBSOneException paramFile)
      {
        com.tencent.tbs.one.impl.a.f.c("[%s] Failed to parse latest DEPS %s", new Object[] { str1, " to clean useless components", paramFile });
        ((Runnable)localObject2).run();
        return;
      }
      paramFile = paramFile;
      com.tencent.tbs.one.impl.a.f.c("[%s] Failed to parse current DEPS %s", new Object[] { str1, " to clean useless components", paramFile });
      ((Runnable)localObject2).run();
      return;
    }
    label276:
    int k;
    int i = 0;
    if (i < k)
    {
      localObject4 = paramFile[i];
      String str2 = ((File)localObject4).getName();
      int m = a((com.tencent.tbs.one.impl.common.d)localObject3, str2);
      int n = a((com.tencent.tbs.one.impl.common.d)localObject1, str2);
      if ((m == -1) && (n == -1)) {
        c.a((File)localObject4);
      }
      do
      {
        i += 1;
        break;
        localObject4 = ((File)localObject4).listFiles();
      } while (localObject4 == null);
      int i1 = localObject4.length;
      int j = 0;
      label360:
      String str3;
      if (j < i1)
      {
        str2 = localObject4[j];
        if (!str2.isDirectory()) {
          break label449;
        }
        str3 = str2.getName();
        if ((!str3.equals(String.valueOf(m))) && (!str3.equals(String.valueOf(n))))
        {
          com.tencent.tbs.one.impl.a.f.a("[%s] Deleting unreferenced component version directory %s", new Object[] { str1, str2.getAbsolutePath() });
          c.a(str2);
        }
      }
      for (;;)
      {
        j += 1;
        break label360;
        break;
        label449:
        str3 = str2.getName();
        if (str3.endsWith(".incomplete"))
        {
          if (!new File(str2.getParent(), str3.substring(0, str3.length() - 11)).exists())
          {
            com.tencent.tbs.one.impl.a.f.a("[%s] Deleting unused incomplete flag file %s", new Object[] { str1, str2.getAbsolutePath() });
            c.a(str2);
          }
        }
        else if (str3.endsWith(".failed"))
        {
          if (System.currentTimeMillis() - str2.lastModified() >= 86400000L)
          {
            com.tencent.tbs.one.impl.a.f.a("[%s] Deleting expired failed flag file %s", new Object[] { str1, str2.getAbsolutePath() });
            c.a(str2);
          }
        }
        else
        {
          com.tencent.tbs.one.impl.a.f.a("[%s] Deleting unknown file %s", new Object[] { str1, str2.getAbsolutePath() });
          c.a(str2);
        }
      }
    }
    ((Runnable)localObject2).run();
  }
  
  public static void e(File paramFile)
  {
    paramFile = com.tencent.tbs.one.impl.common.f.e(paramFile, ".incomplete");
    if (!paramFile.exists()) {
      c.b(paramFile);
    }
  }
  
  public static void f(File paramFile)
  {
    paramFile = com.tencent.tbs.one.impl.common.f.e(paramFile, ".incomplete");
    if (paramFile.exists()) {
      c.c(paramFile);
    }
  }
  
  public static boolean g(File paramFile)
  {
    return !com.tencent.tbs.one.impl.common.f.e(paramFile, ".incomplete").exists();
  }
  
  /* Error */
  public static e h(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc 2
    //   4: monitorenter
    //   5: new 464	java/util/jar/JarFile
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 600	java/util/jar/JarFile:<init>	(Ljava/io/File;)V
    //   13: astore_1
    //   14: aload_1
    //   15: astore_0
    //   16: aload_1
    //   17: ldc_w 602
    //   20: invokevirtual 606	java/util/jar/JarFile:getJarEntry	(Ljava/lang/String;)Ljava/util/jar/JarEntry;
    //   23: astore_2
    //   24: aload_2
    //   25: ifnonnull +12 -> 37
    //   28: aload_1
    //   29: invokevirtual 607	java/util/jar/JarFile:close	()V
    //   32: ldc 2
    //   34: monitorexit
    //   35: aconst_null
    //   36: areturn
    //   37: aload_1
    //   38: astore_0
    //   39: aload_1
    //   40: aload_2
    //   41: invokevirtual 468	java/util/jar/JarFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   44: invokestatic 610	com/tencent/tbs/one/impl/common/e:a	(Ljava/io/InputStream;)Lcom/tencent/tbs/one/impl/common/e;
    //   47: astore_2
    //   48: aload_2
    //   49: astore_0
    //   50: aload_1
    //   51: invokevirtual 607	java/util/jar/JarFile:close	()V
    //   54: ldc 2
    //   56: monitorexit
    //   57: aload_0
    //   58: areturn
    //   59: astore_0
    //   60: ldc 2
    //   62: monitorexit
    //   63: aload_0
    //   64: athrow
    //   65: astore_2
    //   66: aconst_null
    //   67: astore_1
    //   68: aload_1
    //   69: astore_0
    //   70: aload_2
    //   71: invokevirtual 613	java/lang/Exception:printStackTrace	()V
    //   74: aload_3
    //   75: astore_0
    //   76: aload_1
    //   77: ifnull -23 -> 54
    //   80: aload_1
    //   81: invokevirtual 607	java/util/jar/JarFile:close	()V
    //   84: aload_3
    //   85: astore_0
    //   86: goto -32 -> 54
    //   89: astore_0
    //   90: aload_3
    //   91: astore_0
    //   92: goto -38 -> 54
    //   95: astore_1
    //   96: aconst_null
    //   97: astore_0
    //   98: aload_0
    //   99: ifnull +7 -> 106
    //   102: aload_0
    //   103: invokevirtual 607	java/util/jar/JarFile:close	()V
    //   106: aload_1
    //   107: athrow
    //   108: astore_0
    //   109: goto -77 -> 32
    //   112: astore_1
    //   113: goto -59 -> 54
    //   116: astore_0
    //   117: goto -11 -> 106
    //   120: astore_1
    //   121: goto -23 -> 98
    //   124: astore_2
    //   125: goto -57 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	paramFile	File
    //   13	68	1	localJarFile	JarFile
    //   95	12	1	localObject1	Object
    //   112	1	1	localException1	Exception
    //   120	1	1	localObject2	Object
    //   23	26	2	localObject3	Object
    //   65	6	2	localException2	Exception
    //   124	1	2	localException3	Exception
    //   1	90	3	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   28	32	59	finally
    //   32	35	59	finally
    //   50	54	59	finally
    //   54	57	59	finally
    //   60	63	59	finally
    //   80	84	59	finally
    //   102	106	59	finally
    //   106	108	59	finally
    //   5	14	65	java/lang/Exception
    //   80	84	89	java/lang/Exception
    //   5	14	95	finally
    //   28	32	108	java/lang/Exception
    //   50	54	112	java/lang/Exception
    //   102	106	116	java/lang/Exception
    //   16	24	120	finally
    //   39	48	120	finally
    //   70	74	120	finally
    //   16	24	124	java/lang/Exception
    //   39	48	124	java/lang/Exception
  }
  
  public static boolean i(File paramFile)
  {
    com.tencent.tbs.one.impl.a.f.a("verifyPkgLegality,path=%s", new Object[] { paramFile });
    if ((paramFile == null) || (!paramFile.exists()))
    {
      com.tencent.tbs.one.impl.a.f.a("verify file signature failed,path=", new Object[] { paramFile });
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
          com.tencent.tbs.one.impl.a.f.a("verifyPkgLegality failed,exception=%s,stack=", new Object[] { paramFile, Log.getStackTraceString(paramFile) });
          continue;
          break label268;
          Object localObject1 = localObject2;
        }
      }
      if (!localEnumeration.hasMoreElements()) {
        break;
      }
      localJarEntry = (JarEntry)localEnumeration.nextElement();
    } while ((localJarEntry.isDirectory()) || (localJarEntry.getName().startsWith("META-INF/")));
    localObject2 = a(localJarFile, localJarEntry, arrayOfByte);
    if (localObject2 != null)
    {
      localObject2 = a(localObject2[0].getEncoded());
      if (localObject1 == null) {
        break label266;
      }
      if (!localObject1.equals(localObject2))
      {
        com.tencent.tbs.one.impl.a.f.a("verify file signature failed,origin entry=%s,signature=%s,target=%s", new Object[] { localJarEntry.getName(), localObject2, localObject1 });
        return false;
      }
    }
    else
    {
      com.tencent.tbs.one.impl.a.f.a("verify file signature failed,origin entry=%s,signature is null", new Object[] { localJarEntry.getName() });
      return false;
      if ((localObject1 != null) && ("3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a".equals(localObject1)))
      {
        com.tencent.tbs.one.impl.a.f.a("verify file signature success,path=%s", new Object[] { paramFile });
        return true;
      }
      com.tencent.tbs.one.impl.a.f.a("verify file not success,signature=%s", new Object[] { localObject1 });
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tbs.one.impl.e.f
 * JD-Core Version:    0.7.0.1
 */