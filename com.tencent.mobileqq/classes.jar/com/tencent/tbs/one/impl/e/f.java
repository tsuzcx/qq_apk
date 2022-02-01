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
    return (int)(paramInt2 + paramInt1 / 100.0F * (paramInt3 - paramInt2));
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
    while (i < k)
    {
      int n = paramArrayOfByte[i];
      int j = n >> 4 & 0xF;
      int m = i * 2;
      if (j >= 10) {
        j = j + 97 - 10;
      } else {
        j += 48;
      }
      arrayOfChar[m] = ((char)j);
      j = n & 0xF;
      if (j >= 10) {
        j = j + 97 - 10;
      } else {
        j += 48;
      }
      arrayOfChar[(m + 1)] = ((char)j);
      i += 1;
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
      StringBuilder localStringBuilder = new StringBuilder("Failed to find md5 algorithm, error: ");
      localStringBuilder.append(localNoSuchAlgorithmException.getMessage());
      throw new TBSOneException(106, localStringBuilder.toString(), localNoSuchAlgorithmException);
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
    int i = 0;
    while (i < m)
    {
      File localFile = arrayOfFile[i];
      int n = Integer.valueOf(localFile.getName()).intValue();
      if (n != k)
      {
        Iterator localIterator = paramContext.iterator();
        int j = 0;
        while (localIterator.hasNext()) {
          if (((ActivityManager.RunningAppProcessInfo)localIterator.next()).pid == n) {
            j = 1;
          }
        }
        if (j == 0) {
          c.a(localFile);
        }
      }
      i += 1;
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
      int j;
      int i;
      com.tencent.tbs.one.impl.a.f.a("setDirectoryExcutableIfNeeded,exception=%s", new Object[] { Log.getStackTraceString(paramFile) });
    }
    paramFile = paramFile.listFiles();
    if (paramFile == null)
    {
      com.tencent.tbs.one.impl.a.f.a("setDirectoryExcutableIfNeeded,subdir=null,return", new Object[0]);
      return;
    }
    j = paramFile.length;
    i = 0;
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
    return;
  }
  
  public static void a(File paramFile, int paramInt)
  {
    Object localObject1 = e.a(new File(paramFile, "MANIFEST"));
    int i = ((e)localObject1).a;
    if (paramInt == i)
    {
      e.a[] arrayOfa = ((e)localObject1).e;
      if (arrayOfa != null)
      {
        localObject1 = null;
        i = arrayOfa.length;
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = arrayOfa[paramInt];
          File localFile = new File(paramFile, ((e.a)localObject2).a);
          if (localFile.exists())
          {
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
          else
          {
            paramFile = new StringBuilder("Failed to find component file ");
            paramFile.append(localFile.getAbsolutePath());
            throw new TBSOneException(105, paramFile.toString());
          }
        }
      }
      return;
    }
    paramFile = new StringBuilder("Failed to verify version code, expected ");
    paramFile.append(paramInt);
    paramFile.append(" but was ");
    paramFile.append(i);
    paramFile = new TBSOneException(417, paramFile.toString());
    for (;;)
    {
      throw paramFile;
    }
  }
  
  public static void a(File paramFile, long paramLong)
  {
    paramFile = com.tencent.tbs.one.impl.common.f.e(paramFile, ".failed");
    try
    {
      if ((!paramFile.exists()) && (!paramFile.createNewFile()))
      {
        com.tencent.tbs.one.impl.a.f.c("Failed to touch file %s, cannot create new file", new Object[] { paramFile.getAbsolutePath() });
        return;
      }
      if (!paramFile.setLastModified(paramLong)) {
        com.tencent.tbs.one.impl.a.f.c("Failed to touch file %s, cannot set last modified with %d", new Object[] { paramFile.getAbsolutePath(), Long.valueOf(paramLong) });
      }
      return;
    }
    catch (IOException localIOException)
    {
      com.tencent.tbs.one.impl.a.f.c("Failed to touch file %s", new Object[] { paramFile.getAbsolutePath(), localIOException });
    }
  }
  
  public static void a(File paramFile1, File paramFile2)
  {
    com.tencent.tbs.one.impl.a.f.a("Extracting from installation package %s to %s", new Object[] { paramFile1.getAbsolutePath(), paramFile2.getAbsolutePath() });
    Object localObject1 = new File(paramFile1, "jni");
    File localFile1 = new File(paramFile1, "lib");
    String[] arrayOfString;
    if (Build.VERSION.SDK_INT < 21)
    {
      arrayOfString = new String[2];
      arrayOfString[0] = Build.CPU_ABI;
      arrayOfString[1] = Build.CPU_ABI2;
    }
    else
    {
      arrayOfString = Build.SUPPORTED_ABIS;
    }
    int k = arrayOfString.length;
    int i = 0;
    while (i < k)
    {
      String str = arrayOfString[i];
      Object localObject2 = new File((File)localObject1, str);
      Object localObject3 = localObject1;
      if (((File)localObject2).exists())
      {
        File[] arrayOfFile = ((File)localObject2).listFiles();
        localObject3 = localObject1;
        if (arrayOfFile != null)
        {
          localObject3 = localObject1;
          if (arrayOfFile.length > 0)
          {
            com.tencent.tbs.one.impl.a.f.a("  ABI: %s", new Object[] { str });
            int m = arrayOfFile.length;
            int j = 0;
            localObject2 = localObject1;
            for (;;)
            {
              localObject3 = localObject2;
              if (j < m)
              {
                File localFile2 = arrayOfFile[j];
                localObject3 = localFile2.getName();
                if (((String)localObject3).startsWith("libtbs="))
                {
                  localObject1 = new String(Base64.decode(a((String)localObject3, "libtbs="), 2), b.b);
                  if (((String)localObject1).contains(File.separator)) {
                    localObject1 = ((String)localObject1).substring(((String)localObject1).indexOf(File.separatorChar) + 1);
                  }
                }
                else if (((String)localObject3).startsWith("libtbs"))
                {
                  localObject1 = a((String)localObject3, "libtbs");
                }
                else
                {
                  localObject1 = localObject3;
                }
                File localFile3 = new File(paramFile2, (String)localObject1);
                if (localFile3.exists()) {
                  com.tencent.tbs.one.impl.a.f.a("    %s -> %s, already exist", new Object[] { localObject3, localObject1 });
                } else {
                  com.tencent.tbs.one.impl.a.f.a("    %s -> %s", new Object[] { localObject3, localObject1 });
                }
                try
                {
                  c.c(localFile2, localFile3);
                  j += 1;
                }
                catch (IOException paramFile1)
                {
                  localObject1 = new StringBuilder("Failed to extract component files in ");
                  ((StringBuilder)localObject1).append(paramFile2.getAbsolutePath());
                  ((StringBuilder)localObject1).append(", error: ");
                  ((StringBuilder)localObject1).append(paramFile1.getMessage());
                  throw new TBSOneException(316, ((StringBuilder)localObject1).toString(), paramFile1);
                }
              }
            }
          }
        }
      }
      localObject1 = new File(localFile1, str);
      if (((File)localObject1).exists()) {
        b((File)localObject1, paramFile2);
      }
      i += 1;
      localObject1 = localObject3;
    }
    b(new File(paramFile1, "assets/webkit"), paramFile2);
  }
  
  public static void a(File paramFile1, String paramString1, String paramString2, File paramFile2)
  {
    c.a(com.tencent.tbs.one.impl.common.f.a(paramFile1, paramString1, paramString2), paramFile2);
  }
  
  public static void a(InputStream paramInputStream, String paramString, long paramLong, File paramFile1, File paramFile2, k.a parama)
  {
    com.tencent.tbs.one.impl.a.f.a("Unzipping from download stream to %s, sdcard backup file is %s", new Object[] { paramFile1.getAbsolutePath(), paramFile2 });
    MessageDigest localMessageDigest;
    if (!TextUtils.isEmpty(paramString)) {
      localMessageDigest = a();
    } else {
      localMessageDigest = null;
    }
    if (localMessageDigest != null) {
      paramInputStream = new k(new DigestInputStream(paramInputStream, localMessageDigest), paramLong);
    } else {
      paramInputStream = new k(paramInputStream, paramLong);
    }
    paramInputStream.b = parama;
    try
    {
      c.a(paramInputStream, paramFile1, paramFile2);
      if (paramLong > 0L)
      {
        long l = paramInputStream.a;
        if (l != paramLong)
        {
          paramInputStream = new StringBuilder("Failed to verify download stream length, expected ");
          paramInputStream.append(paramLong);
          paramInputStream.append(" but was ");
          paramInputStream.append(l);
          throw new TBSOneException(221, paramInputStream.toString());
        }
      }
      if (localMessageDigest != null)
      {
        paramInputStream = com.tencent.tbs.one.impl.a.d.a(localMessageDigest.digest());
        if (paramInputStream.equals(paramString)) {
          return;
        }
        paramFile1 = new StringBuilder("Failed to verify download stream md5, expected ");
        paramFile1.append(paramString);
        paramFile1.append(" but was ");
        paramFile1.append(paramInputStream);
        throw new TBSOneException(108, paramFile1.toString());
      }
      return;
    }
    catch (IOException paramInputStream)
    {
      paramString = new StringBuilder("Failed to unzip online component to ");
      paramString.append(paramFile1.getAbsolutePath());
      paramString.append(", error: ");
      paramString.append(paramInputStream.getMessage());
      throw new TBSOneException(315, paramString.toString(), paramInputStream);
    }
  }
  
  public static void a(MessageDigest paramMessageDigest, File paramFile, String paramString)
  {
    try
    {
      c.a(new DigestInputStream(new FileInputStream(paramFile), paramMessageDigest), i.a);
      paramMessageDigest = com.tencent.tbs.one.impl.a.d.a(paramMessageDigest.digest());
      if (paramMessageDigest.equals(paramString)) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder("Failed to verify md5 for component file ");
      localStringBuilder.append(paramFile.getAbsolutePath());
      localStringBuilder.append(", expected ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" but was ");
      localStringBuilder.append(paramMessageDigest);
      throw new TBSOneException(108, localStringBuilder.toString());
    }
    catch (IOException paramMessageDigest)
    {
      paramString = new StringBuilder("Failed to compute md5 for component file ");
      paramString.append(paramFile.getAbsolutePath());
      paramString.append(", error: ");
      paramString.append(paramMessageDigest.getMessage());
      throw new TBSOneException(107, paramString.toString(), paramMessageDigest);
    }
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    int i = -1;
    for (;;)
    {
      String str;
      try
      {
        int j = paramString.hashCode();
        if (j != -973170826)
        {
          if (j != -103518033)
          {
            if ((j == 361910168) && (paramString.equals("com.tencent.mobileqq"))) {
              i = 1;
            }
          }
          else if (paramString.equals("com.tencent.tbs")) {
            i = 2;
          }
        }
        else if (paramString.equals("com.tencent.mm")) {
          i = 0;
        }
      }
      catch (Exception paramContext)
      {
        boolean bool;
        paramString = new StringBuilder("verify app exception,e=");
        paramString.append(Log.getStackTraceString(paramContext));
        com.tencent.tbs.one.impl.a.f.c(paramString.toString(), new Object[0]);
        return false;
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        return false;
      }
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 64);
      if (paramContext == null) {
        return false;
      }
      bool = str.equals(paramContext.signatures[0].toCharsString());
      if (bool) {
        return true;
      }
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2) {
            return false;
          }
          str = "3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a";
        }
        else
        {
          str = "30820253308201bca00302010202044bbb0361300d06092a864886f70d0101050500306d310e300c060355040613054368696e61310f300d06035504080c06e58c97e4baac310f300d06035504070c06e58c97e4baac310f300d060355040a0c06e885bee8aeaf311b3019060355040b0c12e697a0e7babfe4b89ae58aa1e7b3bbe7bb9f310b30090603550403130251513020170d3130303430363039343831375a180f32323834303132303039343831375a306d310e300c060355040613054368696e61310f300d06035504080c06e58c97e4baac310f300d06035504070c06e58c97e4baac310f300d060355040a0c06e885bee8aeaf311b3019060355040b0c12e697a0e7babfe4b89ae58aa1e7b3bbe7bb9f310b300906035504031302515130819f300d06092a864886f70d010101050003818d0030818902818100a15e9756216f694c5915e0b529095254367c4e64faeff07ae13488d946615a58ddc31a415f717d019edc6d30b9603d3e2a7b3de0ab7e0cf52dfee39373bc472fa997027d798d59f81d525a69ecf156e885fd1e2790924386b2230cc90e3b7adc95603ddcf4c40bdc72f22db0f216a99c371d3bf89cba6578c60699e8a0d536950203010001300d06092a864886f70d01010505000381810094a9b80e80691645dd42d6611775a855f71bcd4d77cb60a8e29404035a5e00b21bcc5d4a562482126bd91b6b0e50709377ceb9ef8c2efd12cc8b16afd9a159f350bb270b14204ff065d843832720702e28b41491fbc3a205f5f2f42526d67f17614d8a974de6487b2c866efede3b4e49a0f916baa3c1336fd2ee1b1629652049";
        }
      }
      else {
        str = "308202eb30820254a00302010202044d36f7a4300d06092a864886f70d01010505003081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e74301e170d3131303131393134333933325a170d3431303131313134333933325a3081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e7430819f300d06092a864886f70d010101050003818d0030818902818100c05f34b231b083fb1323670bfbe7bdab40c0c0a6efc87ef2072a1ff0d60cc67c8edb0d0847f210bea6cbfaa241be70c86daf56be08b723c859e52428a064555d80db448cdcacc1aea2501eba06f8bad12a4fa49d85cacd7abeb68945a5cb5e061629b52e3254c373550ee4e40cb7c8ae6f7a8151ccd8df582d446f39ae0c5e930203010001300d06092a864886f70d0101050500038181009c8d9d7f2f908c42081b4c764c377109a8b2c70582422125ce545842d5f520aea69550b6bd8bfd94e987b75a3077eb04ad341f481aac266e89d3864456e69fba13df018acdc168b9a19dfd7ad9d9cc6f6ace57c746515f71234df3a053e33ba93ece5cd0fc15f3e389a3f365588a9fcb439e069d3629cd7732a13fff7b891499";
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
            localObject = arrayOfFile[i];
            c.c((File)localObject, new File(paramFile2, ((File)localObject).getName()));
            i += 1;
          }
        }
      }
      return;
    }
    catch (IOException localIOException)
    {
      Object localObject = new StringBuilder("extractFromUnzipDirToTarget failed,unzip Dir=");
      ((StringBuilder)localObject).append(paramFile1);
      ((StringBuilder)localObject).append(";target=");
      ((StringBuilder)localObject).append(paramFile2);
      ((StringBuilder)localObject).append(", error: ");
      ((StringBuilder)localObject).append(localIOException.getMessage());
      paramFile1 = new TBSOneException(316, ((StringBuilder)localObject).toString(), localIOException);
    }
    for (;;)
    {
      throw paramFile1;
    }
  }
  
  public static boolean b(Context paramContext, String paramString)
  {
    paramContext = com.tencent.tbs.one.impl.common.f.b(paramContext).listFiles();
    if (paramContext == null) {
      return false;
    }
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
    return false;
  }
  
  public static int c(File paramFile)
  {
    paramFile = paramFile.listFiles(new f.1());
    if (paramFile == null) {
      return -1;
    }
    int n = paramFile.length;
    int j = 0;
    int m;
    for (int k = -1; j < n; k = m)
    {
      File localFile = paramFile[j];
      m = k;
      if (g(localFile))
      {
        int i;
        try
        {
          i = Integer.parseInt(localFile.getName());
        }
        catch (Exception localException)
        {
          com.tencent.tbs.one.impl.a.f.c("Failed to parse component version from path %s", new Object[] { localFile.getAbsolutePath(), localException });
          i = -1;
        }
        m = k;
        if (i != -1)
        {
          m = k;
          if (i > k) {
            m = i;
          }
        }
      }
      j += 1;
    }
    return k;
  }
  
  public static void d(File paramFile)
  {
    String str = paramFile.getName();
    com.tencent.tbs.one.impl.a.f.a("[%s] Cleaning useless components", new Object[] { str });
    Object localObject2 = com.tencent.tbs.one.impl.common.f.b(paramFile);
    if (!((File)localObject2).exists())
    {
      com.tencent.tbs.one.impl.a.f.a("[%s] %s no DEPS file exists", new Object[] { str, "Early out for cleanup useless components," });
      return;
    }
    Object localObject4 = j.a(com.tencent.tbs.one.impl.common.f.e((File)localObject2, ".lock"));
    if (localObject4 == null)
    {
      com.tencent.tbs.one.impl.a.f.a("[%s] %s the DEPS installation lock is busy", new Object[] { str, "Early out for cleanup useless components," });
      return;
    }
    Object localObject1 = com.tencent.tbs.one.impl.common.f.c(paramFile);
    Object localObject3 = j.a(com.tencent.tbs.one.impl.common.f.e((File)localObject1, ".lock"));
    f.2 local2 = new f.2((j)localObject4, (j)localObject3);
    if (localObject3 == null)
    {
      com.tencent.tbs.one.impl.a.f.a("[%s] %s the update lock is busy", new Object[] { str, "Early out for cleanup useless components," });
      local2.run();
      return;
    }
    try
    {
      localObject2 = com.tencent.tbs.one.impl.common.d.a((File)localObject2);
      localObject4 = null;
      if (((File)localObject1).exists()) {
        try
        {
          localObject4 = com.tencent.tbs.one.impl.common.d.a((File)localObject1);
        }
        catch (TBSOneException paramFile)
        {
          com.tencent.tbs.one.impl.a.f.c("[%s] Failed to parse latest DEPS %s", new Object[] { str, " to clean useless components", paramFile });
          local2.run();
          return;
        }
      }
      localObject1 = com.tencent.tbs.one.impl.common.f.d(paramFile).listFiles();
      if (localObject1 == null)
      {
        local2.run();
        return;
      }
      int k = localObject1.length;
      int i = 0;
      for (paramFile = (File)localObject2; i < k; paramFile = (File)localObject2)
      {
        localObject2 = localObject1[i];
        localObject3 = ((File)localObject2).getName();
        int m = a(paramFile, (String)localObject3);
        int n = a((com.tencent.tbs.one.impl.common.d)localObject4, (String)localObject3);
        if ((m == -1) && (n == -1))
        {
          c.a((File)localObject2);
          localObject2 = paramFile;
          localObject3 = localObject1;
        }
        else
        {
          File[] arrayOfFile = ((File)localObject2).listFiles();
          localObject2 = paramFile;
          localObject3 = localObject1;
          if (arrayOfFile != null)
          {
            int i1 = arrayOfFile.length;
            int j = 0;
            for (;;)
            {
              localObject2 = paramFile;
              localObject3 = localObject1;
              if (j >= i1) {
                break;
              }
              localObject2 = arrayOfFile[j];
              if (((File)localObject2).isDirectory())
              {
                localObject3 = ((File)localObject2).getName();
                if ((!((String)localObject3).equals(String.valueOf(m))) && (!((String)localObject3).equals(String.valueOf(n))))
                {
                  com.tencent.tbs.one.impl.a.f.a("[%s] Deleting unreferenced component version directory %s", new Object[] { str, ((File)localObject2).getAbsolutePath() });
                  c.a((File)localObject2);
                }
              }
              else
              {
                localObject3 = ((File)localObject2).getName();
                if (((String)localObject3).endsWith(".incomplete"))
                {
                  if (!new File(((File)localObject2).getParent(), ((String)localObject3).substring(0, ((String)localObject3).length() - 11)).exists())
                  {
                    com.tencent.tbs.one.impl.a.f.a("[%s] Deleting unused incomplete flag file %s", new Object[] { str, ((File)localObject2).getAbsolutePath() });
                    c.a((File)localObject2);
                  }
                }
                else if (((String)localObject3).endsWith(".failed"))
                {
                  if (System.currentTimeMillis() - ((File)localObject2).lastModified() >= 86400000L)
                  {
                    com.tencent.tbs.one.impl.a.f.a("[%s] Deleting expired failed flag file %s", new Object[] { str, ((File)localObject2).getAbsolutePath() });
                    c.a((File)localObject2);
                  }
                }
                else
                {
                  com.tencent.tbs.one.impl.a.f.a("[%s] Deleting unknown file %s", new Object[] { str, ((File)localObject2).getAbsolutePath() });
                  c.a((File)localObject2);
                }
              }
              j += 1;
            }
          }
        }
        i += 1;
        localObject1 = localObject3;
      }
      local2.run();
      return;
    }
    catch (TBSOneException paramFile)
    {
      com.tencent.tbs.one.impl.a.f.c("[%s] Failed to parse current DEPS %s", new Object[] { str, " to clean useless components", paramFile });
      local2.run();
    }
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
    //   0: ldc 2
    //   2: monitorenter
    //   3: aconst_null
    //   4: astore 4
    //   6: aconst_null
    //   7: astore_3
    //   8: new 467	java/util/jar/JarFile
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 603	java/util/jar/JarFile:<init>	(Ljava/io/File;)V
    //   16: astore_0
    //   17: aload_0
    //   18: astore_1
    //   19: aload_0
    //   20: ldc_w 605
    //   23: invokevirtual 609	java/util/jar/JarFile:getJarEntry	(Ljava/lang/String;)Ljava/util/jar/JarEntry;
    //   26: astore_2
    //   27: aload_2
    //   28: ifnonnull +12 -> 40
    //   31: aload_0
    //   32: invokevirtual 610	java/util/jar/JarFile:close	()V
    //   35: ldc 2
    //   37: monitorexit
    //   38: aconst_null
    //   39: areturn
    //   40: aload_0
    //   41: astore_1
    //   42: aload_0
    //   43: aload_2
    //   44: invokevirtual 471	java/util/jar/JarFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   47: invokestatic 613	com/tencent/tbs/one/impl/common/e:a	(Ljava/io/InputStream;)Lcom/tencent/tbs/one/impl/common/e;
    //   50: astore_2
    //   51: aload_2
    //   52: astore_1
    //   53: goto +31 -> 84
    //   56: astore_2
    //   57: goto +12 -> 69
    //   60: astore_0
    //   61: aconst_null
    //   62: astore_1
    //   63: goto +38 -> 101
    //   66: astore_2
    //   67: aconst_null
    //   68: astore_0
    //   69: aload_0
    //   70: astore_1
    //   71: aload_2
    //   72: invokevirtual 616	java/lang/Exception:printStackTrace	()V
    //   75: aload 4
    //   77: astore_1
    //   78: aload_0
    //   79: ifnull +16 -> 95
    //   82: aload_3
    //   83: astore_1
    //   84: aload_0
    //   85: invokevirtual 610	java/util/jar/JarFile:close	()V
    //   88: goto +7 -> 95
    //   91: astore_0
    //   92: goto +19 -> 111
    //   95: ldc 2
    //   97: monitorexit
    //   98: aload_1
    //   99: areturn
    //   100: astore_0
    //   101: aload_1
    //   102: ifnull +7 -> 109
    //   105: aload_1
    //   106: invokevirtual 610	java/util/jar/JarFile:close	()V
    //   109: aload_0
    //   110: athrow
    //   111: ldc 2
    //   113: monitorexit
    //   114: aload_0
    //   115: athrow
    //   116: astore_0
    //   117: goto -82 -> 35
    //   120: astore_0
    //   121: goto -26 -> 95
    //   124: astore_1
    //   125: goto -16 -> 109
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	paramFile	File
    //   18	88	1	localObject1	Object
    //   124	1	1	localException1	Exception
    //   26	26	2	localObject2	Object
    //   56	1	2	localException2	Exception
    //   66	6	2	localException3	Exception
    //   7	76	3	localObject3	Object
    //   4	72	4	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   19	27	56	java/lang/Exception
    //   42	51	56	java/lang/Exception
    //   8	17	60	finally
    //   8	17	66	java/lang/Exception
    //   31	35	91	finally
    //   35	38	91	finally
    //   84	88	91	finally
    //   95	98	91	finally
    //   105	109	91	finally
    //   109	111	91	finally
    //   111	114	91	finally
    //   19	27	100	finally
    //   42	51	100	finally
    //   71	75	100	finally
    //   31	35	116	java/lang/Exception
    //   84	88	120	java/lang/Exception
    //   105	109	124	java/lang/Exception
  }
  
  public static boolean i(File paramFile)
  {
    com.tencent.tbs.one.impl.a.f.a("verifyPkgLegality,path=%s", new Object[] { paramFile });
    if ((paramFile != null) && (paramFile.exists())) {}
    for (;;)
    {
      Object localObject2;
      try
      {
        JarFile localJarFile = new JarFile(paramFile);
        Enumeration localEnumeration = localJarFile.entries();
        localObject1 = null;
        byte[] arrayOfByte = new byte[8192];
        if (localEnumeration.hasMoreElements())
        {
          JarEntry localJarEntry = (JarEntry)localEnumeration.nextElement();
          if ((localJarEntry.isDirectory()) || (localJarEntry.getName().startsWith("META-INF/"))) {
            continue;
          }
          localObject2 = a(localJarFile, localJarEntry, arrayOfByte);
          if (localObject2 != null)
          {
            localObject2 = a(localObject2[0].getEncoded());
            if (localObject1 == null) {
              break label265;
            }
            if (localObject1.equals(localObject2)) {
              continue;
            }
            com.tencent.tbs.one.impl.a.f.a("verify file signature failed,origin entry=%s,signature=%s,target=%s", new Object[] { localJarEntry.getName(), localObject2, localObject1 });
            return false;
          }
          com.tencent.tbs.one.impl.a.f.a("verify file signature failed,origin entry=%s,signature is null", new Object[] { localJarEntry.getName() });
          return false;
        }
        if ((localObject1 != null) && ("3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a".equals(localObject1)))
        {
          com.tencent.tbs.one.impl.a.f.a("verify file signature success,path=%s", new Object[] { paramFile });
          return true;
        }
        com.tencent.tbs.one.impl.a.f.a("verify file not success,signature=%s", new Object[] { localObject1 });
        return false;
      }
      catch (Exception paramFile)
      {
        com.tencent.tbs.one.impl.a.f.a("verifyPkgLegality failed,exception=%s,stack=", new Object[] { paramFile, Log.getStackTraceString(paramFile) });
        return false;
      }
      com.tencent.tbs.one.impl.a.f.a("verify file signature failed,path=", new Object[] { paramFile });
      return false;
      label265:
      Object localObject1 = localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tbs.one.impl.e.f
 * JD-Core Version:    0.7.0.1
 */