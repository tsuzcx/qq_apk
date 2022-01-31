package com.tencent.smtt.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.security.cert.Certificate;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class AppUtil
{
  private static final String LOGTAG = "AppUtil";
  public static String mAndroidID = "";
  public static String mCpu;
  public static String mImei = "";
  public static String mImsi = "";
  public static String mMac;
  
  static
  {
    mCpu = "";
    mMac = "";
  }
  
  public static String getAndroidID(Context paramContext)
  {
    if (!TextUtils.isEmpty(mAndroidID)) {
      return mAndroidID;
    }
    try
    {
      mAndroidID = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      return mAndroidID;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  /* Error */
  public static String getAppMetadata(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 64	android/content/Context:getPackageName	()Ljava/lang/String;
    //   4: astore_2
    //   5: aload_0
    //   6: invokevirtual 68	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   9: aload_2
    //   10: sipush 128
    //   13: invokevirtual 74	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   16: getfield 80	android/content/pm/ApplicationInfo:metaData	Landroid/os/Bundle;
    //   19: aload_1
    //   20: invokevirtual 86	android/os/Bundle:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   23: invokestatic 92	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   26: astore_0
    //   27: aload_0
    //   28: invokestatic 98	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   31: invokestatic 102	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   34: invokestatic 92	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   37: astore_1
    //   38: aload_1
    //   39: areturn
    //   40: astore_0
    //   41: aconst_null
    //   42: areturn
    //   43: astore_1
    //   44: aload_0
    //   45: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	paramContext	Context
    //   0	46	1	paramString	String
    //   4	6	2	str	String
    // Exception table:
    //   from	to	target	type
    //   0	27	40	java/lang/Exception
    //   27	38	43	java/lang/Exception
  }
  
  public static int getAppVersionCode(Context paramContext)
  {
    try
    {
      String str = paramContext.getPackageName();
      int i = paramContext.getPackageManager().getPackageInfo(str, 0).versionCode;
      return i;
    }
    catch (Exception paramContext) {}
    return 0;
  }
  
  public static String getAppVersionName(Context paramContext)
  {
    try
    {
      String str = paramContext.getPackageName();
      paramContext = paramContext.getPackageManager().getPackageInfo(str, 0).versionName;
      return paramContext;
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  /* Error */
  public static String getDeviceCpuabi()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_0
    //   4: aconst_null
    //   5: astore 4
    //   7: getstatic 23	com/tencent/smtt/utils/AppUtil:mCpu	Ljava/lang/String;
    //   10: invokestatic 41	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifne +9 -> 22
    //   16: getstatic 23	com/tencent/smtt/utils/AppUtil:mCpu	Ljava/lang/String;
    //   19: astore_2
    //   20: aload_2
    //   21: areturn
    //   22: new 125	java/io/InputStreamReader
    //   25: dup
    //   26: invokestatic 131	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   29: ldc 133
    //   31: invokevirtual 137	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   34: invokevirtual 143	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   37: invokespecial 146	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   40: astore_1
    //   41: aload_0
    //   42: astore_2
    //   43: aload_1
    //   44: astore_0
    //   45: new 148	java/io/BufferedReader
    //   48: dup
    //   49: aload_1
    //   50: invokespecial 151	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   53: astore_3
    //   54: aload_3
    //   55: invokevirtual 154	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   58: ldc 156
    //   60: invokevirtual 159	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   63: ifeq +34 -> 97
    //   66: ldc 161
    //   68: invokestatic 165	com/tencent/smtt/utils/AppUtil:notNullString	(Ljava/lang/String;)Ljava/lang/String;
    //   71: astore_0
    //   72: aload_3
    //   73: ifnull +7 -> 80
    //   76: aload_3
    //   77: invokevirtual 168	java/io/BufferedReader:close	()V
    //   80: aload_0
    //   81: astore_2
    //   82: aload_1
    //   83: ifnull -63 -> 20
    //   86: aload_0
    //   87: astore_2
    //   88: aload_1
    //   89: invokevirtual 169	java/io/InputStreamReader:close	()V
    //   92: aload_0
    //   93: areturn
    //   94: astore_0
    //   95: aload_2
    //   96: areturn
    //   97: ldc 171
    //   99: invokestatic 176	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   102: invokestatic 165	com/tencent/smtt/utils/AppUtil:notNullString	(Ljava/lang/String;)Ljava/lang/String;
    //   105: astore_0
    //   106: goto -34 -> 72
    //   109: astore_3
    //   110: aconst_null
    //   111: astore_1
    //   112: aload 4
    //   114: astore_2
    //   115: aload_1
    //   116: astore_0
    //   117: ldc 171
    //   119: invokestatic 176	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   122: invokestatic 165	com/tencent/smtt/utils/AppUtil:notNullString	(Ljava/lang/String;)Ljava/lang/String;
    //   125: astore 5
    //   127: aload 4
    //   129: astore_2
    //   130: aload_1
    //   131: astore_0
    //   132: aload_3
    //   133: invokevirtual 177	java/lang/Throwable:printStackTrace	()V
    //   136: aload 4
    //   138: ifnull +8 -> 146
    //   141: aload 4
    //   143: invokevirtual 168	java/io/BufferedReader:close	()V
    //   146: aload 5
    //   148: astore_2
    //   149: aload_1
    //   150: ifnull -130 -> 20
    //   153: aload 5
    //   155: astore_2
    //   156: aload_1
    //   157: invokevirtual 169	java/io/InputStreamReader:close	()V
    //   160: aload 5
    //   162: areturn
    //   163: astore_3
    //   164: aconst_null
    //   165: astore_0
    //   166: aload_2
    //   167: ifnull +7 -> 174
    //   170: aload_2
    //   171: invokevirtual 168	java/io/BufferedReader:close	()V
    //   174: aload_0
    //   175: ifnull +7 -> 182
    //   178: aload_0
    //   179: invokevirtual 169	java/io/InputStreamReader:close	()V
    //   182: aload_3
    //   183: athrow
    //   184: astore_1
    //   185: goto -11 -> 174
    //   188: astore_0
    //   189: goto -7 -> 182
    //   192: astore_0
    //   193: goto -47 -> 146
    //   196: astore_2
    //   197: goto -117 -> 80
    //   200: astore_3
    //   201: goto -35 -> 166
    //   204: astore_0
    //   205: aload_3
    //   206: astore_2
    //   207: aload_0
    //   208: astore_3
    //   209: aload_1
    //   210: astore_0
    //   211: goto -45 -> 166
    //   214: astore_3
    //   215: goto -103 -> 112
    //   218: astore_0
    //   219: aload_3
    //   220: astore 4
    //   222: aload_0
    //   223: astore_3
    //   224: goto -112 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   3	90	0	localObject1	Object
    //   94	1	0	localIOException1	java.io.IOException
    //   105	74	0	localObject2	Object
    //   188	1	0	localIOException2	java.io.IOException
    //   192	1	0	localIOException3	java.io.IOException
    //   204	4	0	localObject3	Object
    //   210	1	0	localObject4	Object
    //   218	5	0	localThrowable1	Throwable
    //   40	117	1	localInputStreamReader	java.io.InputStreamReader
    //   184	26	1	localIOException4	java.io.IOException
    //   1	170	2	localObject5	Object
    //   196	1	2	localIOException5	java.io.IOException
    //   206	1	2	localObject6	Object
    //   53	24	3	localBufferedReader	java.io.BufferedReader
    //   109	24	3	localThrowable2	Throwable
    //   163	20	3	localObject7	Object
    //   200	6	3	localObject8	Object
    //   208	1	3	localObject9	Object
    //   214	6	3	localThrowable3	Throwable
    //   223	1	3	localThrowable4	Throwable
    //   5	216	4	localObject10	Object
    //   125	36	5	str	String
    // Exception table:
    //   from	to	target	type
    //   88	92	94	java/io/IOException
    //   156	160	94	java/io/IOException
    //   22	41	109	java/lang/Throwable
    //   22	41	163	finally
    //   170	174	184	java/io/IOException
    //   178	182	188	java/io/IOException
    //   141	146	192	java/io/IOException
    //   76	80	196	java/io/IOException
    //   45	54	200	finally
    //   117	127	200	finally
    //   132	136	200	finally
    //   54	72	204	finally
    //   97	106	204	finally
    //   45	54	214	java/lang/Throwable
    //   54	72	218	java/lang/Throwable
    //   97	106	218	java/lang/Throwable
  }
  
  public static String getImei(Context paramContext)
  {
    if (!TextUtils.isEmpty(mImei)) {
      return mImei;
    }
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return "";
  }
  
  public static String getImsi(Context paramContext)
  {
    if (!TextUtils.isEmpty(mImsi)) {
      return mImsi;
    }
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getSubscriberId();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return "";
  }
  
  public static String getMacAddress(Context paramContext)
  {
    if (!TextUtils.isEmpty(mMac)) {
      return mMac;
    }
    do
    {
      try
      {
        paramContext = (WifiManager)paramContext.getApplicationContext().getSystemService("wifi");
        if (paramContext == null) {
          paramContext = null;
        } else {
          paramContext = paramContext.getConnectionInfo();
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        return "";
      }
      paramContext = paramContext.getMacAddress();
      return paramContext;
    } while (paramContext != null);
    return "";
  }
  
  private static PackageInfo getPackageArchiveInfo(String paramString, int paramInt)
  {
    for (;;)
    {
      int i;
      try
      {
        Object localObject2 = Class.forName("android.content.pm.PackageParser");
        Object localObject1 = ((Class)localObject2).getDeclaredClasses();
        int j = localObject1.length;
        i = 0;
        if (i < j)
        {
          localMethod1 = localObject1[i];
          if (localMethod1.getName().compareTo("android.content.pm.PackageParser$Package") != 0) {
            break label345;
          }
          Object localObject3 = ((Class)localObject2).getConstructor(new Class[] { String.class });
          Method localMethod2 = ((Class)localObject2).getDeclaredMethod("parsePackage", new Class[] { File.class, String.class, DisplayMetrics.class, Integer.TYPE });
          localObject1 = ((Class)localObject2).getDeclaredMethod("collectCertificates", new Class[] { localMethod1, Integer.TYPE });
          localMethod1 = ((Class)localObject2).getDeclaredMethod("generatePackageInfo", new Class[] { localMethod1, [I.class, Integer.TYPE, Long.TYPE, Long.TYPE });
          ((Constructor)localObject3).setAccessible(true);
          localMethod2.setAccessible(true);
          ((Method)localObject1).setAccessible(true);
          localMethod1.setAccessible(true);
          localObject2 = ((Constructor)localObject3).newInstance(new Object[] { paramString });
          localObject3 = new DisplayMetrics();
          ((DisplayMetrics)localObject3).setToDefaults();
          paramString = localMethod2.invoke(localObject2, new Object[] { new File(paramString), paramString, localObject3, Integer.valueOf(0) });
          if (paramString == null) {
            return null;
          }
          if ((paramInt & 0x40) != 0) {
            ((Method)localObject1).invoke(localObject2, new Object[] { paramString, Integer.valueOf(0) });
          }
          paramString = (PackageInfo)localMethod1.invoke(null, new Object[] { paramString, null, Integer.valueOf(paramInt), Integer.valueOf(0), Integer.valueOf(0) });
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      Method localMethod1 = null;
      continue;
      label345:
      i += 1;
    }
  }
  
  public static String getSignatureFromApk(Context paramContext, File paramFile)
  {
    try
    {
      if (!paramContext.getApplicationContext().getPackageName().contains("com.jd.jrapp")) {
        break label52;
      }
      TbsLog.i("AppUtil", "[AppUtil.getSignatureFromApk]  #1");
      localObject2 = getSignatureFromApk(paramFile);
      if (localObject2 == null) {
        break label52;
      }
      TbsLog.i("AppUtil", "[AppUtil.getSignatureFromApk]  #2");
    }
    catch (Throwable localThrowable)
    {
      label52:
      Object localObject1;
      do
      {
        TbsLog.i("AppUtil", "[AppUtil.getSignatureFromApk]  #3");
        TbsLog.i("AppUtil", "[AppUtil.getSignatureFromApk]  #4");
        Object localObject2 = getSignatureFromApk(paramContext, paramFile, false);
        TbsLog.i("AppUtil", "[AppUtil.getSignatureFromApk]  android api signature=" + (String)localObject2);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = getSignatureFromApk(paramFile);
          TbsLog.i("AppUtil", "[AppUtil.getSignatureFromApk]  java get signature=" + (String)localObject1);
        }
        localObject2 = localObject1;
      } while (localObject1 != null);
      paramContext = getSignatureFromApk(paramContext, paramFile, true);
      TbsLog.i("AppUtil", "[AppUtil.getSignatureFromApk]  android reflection signature=" + paramContext);
    }
    return localObject2;
    return paramContext;
  }
  
  private static String getSignatureFromApk(Context paramContext, File paramFile, boolean paramBoolean)
  {
    Object localObject = null;
    if (paramBoolean)
    {
      paramContext = getPackageArchiveInfo(paramFile.getAbsolutePath(), 65);
      if (paramContext == null) {
        break label80;
      }
      if ((paramContext.signatures == null) || (paramContext.signatures.length <= 0)) {
        break label72;
      }
    }
    label72:
    label80:
    for (paramContext = paramContext.signatures[0];; paramContext = null)
    {
      paramFile = localObject;
      if (paramContext != null) {
        paramFile = paramContext.toCharsString();
      }
      return paramFile;
      paramContext = paramContext.getPackageManager().getPackageArchiveInfo(paramFile.getAbsolutePath(), 65);
      break;
      TbsLog.w("AppUtil", "[getSignatureFromApk] pkgInfo is not null BUT signatures is null!");
    }
  }
  
  private static String getSignatureFromApk(File paramFile)
  {
    String str1;
    for (;;)
    {
      try
      {
        JarFile localJarFile = new JarFile(paramFile);
        paramFile = localJarFile.getJarEntry("AndroidManifest.xml");
        byte[] arrayOfByte = new byte[8192];
        str1 = toCharsString(loadCertificates(localJarFile, paramFile, arrayOfByte)[0].getEncoded());
        Enumeration localEnumeration = localJarFile.entries();
        if (!localEnumeration.hasMoreElements()) {
          break;
        }
        paramFile = (JarEntry)localEnumeration.nextElement();
        String str2 = paramFile.getName();
        if (str2 == null) {
          continue;
        }
        paramFile = loadCertificates(localJarFile, paramFile, arrayOfByte);
        if (paramFile != null)
        {
          paramFile = toCharsString(paramFile[0].getEncoded());
          if (paramFile == null)
          {
            if (str2.startsWith("META-INF/")) {
              continue;
            }
            return null;
          }
          boolean bool = paramFile.equals(str1);
          if (bool) {
            continue;
          }
          return null;
        }
      }
      catch (Exception paramFile)
      {
        paramFile.printStackTrace();
        return null;
      }
      paramFile = null;
    }
    return str1;
  }
  
  private static Certificate[] loadCertificates(JarFile paramJarFile, JarEntry paramJarEntry, byte[] paramArrayOfByte)
    throws Exception
  {
    paramJarFile = paramJarFile.getInputStream(paramJarEntry);
    while (paramJarFile.read(paramArrayOfByte, 0, paramArrayOfByte.length) != -1) {}
    paramJarFile.close();
    if (paramJarEntry != null) {
      return paramJarEntry.getCertificates();
    }
    return null;
  }
  
  private static String notNullString(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.utils.AppUtil
 * JD-Core Version:    0.7.0.1
 */