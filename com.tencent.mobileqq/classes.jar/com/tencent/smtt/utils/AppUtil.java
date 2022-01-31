package com.tencent.smtt.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
    //   3: astore_1
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
    //   40: astore_0
    //   41: aload_1
    //   42: astore_2
    //   43: aload_0
    //   44: astore_1
    //   45: new 148	java/io/BufferedReader
    //   48: dup
    //   49: aload_0
    //   50: invokespecial 151	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   53: astore_3
    //   54: aload_3
    //   55: invokevirtual 154	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   58: ldc 156
    //   60: invokevirtual 159	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   63: ifeq +32 -> 95
    //   66: ldc 161
    //   68: invokestatic 165	com/tencent/smtt/utils/AppUtil:notNullString	(Ljava/lang/String;)Ljava/lang/String;
    //   71: astore_1
    //   72: aload_3
    //   73: ifnull +7 -> 80
    //   76: aload_3
    //   77: invokevirtual 168	java/io/BufferedReader:close	()V
    //   80: aload_1
    //   81: astore_2
    //   82: aload_0
    //   83: ifnull -63 -> 20
    //   86: aload_0
    //   87: invokevirtual 169	java/io/InputStreamReader:close	()V
    //   90: aload_1
    //   91: areturn
    //   92: astore_0
    //   93: aload_1
    //   94: areturn
    //   95: ldc 171
    //   97: invokestatic 176	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   100: invokestatic 165	com/tencent/smtt/utils/AppUtil:notNullString	(Ljava/lang/String;)Ljava/lang/String;
    //   103: astore_1
    //   104: goto -32 -> 72
    //   107: astore_3
    //   108: aconst_null
    //   109: astore_0
    //   110: aload 4
    //   112: astore_2
    //   113: aload_0
    //   114: astore_1
    //   115: ldc 171
    //   117: invokestatic 176	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   120: invokestatic 165	com/tencent/smtt/utils/AppUtil:notNullString	(Ljava/lang/String;)Ljava/lang/String;
    //   123: astore 5
    //   125: aload 4
    //   127: astore_2
    //   128: aload_0
    //   129: astore_1
    //   130: aload_3
    //   131: invokevirtual 177	java/lang/Throwable:printStackTrace	()V
    //   134: aload 4
    //   136: ifnull +8 -> 144
    //   139: aload 4
    //   141: invokevirtual 168	java/io/BufferedReader:close	()V
    //   144: aload 5
    //   146: astore_2
    //   147: aload_0
    //   148: ifnull -128 -> 20
    //   151: aload_0
    //   152: invokevirtual 169	java/io/InputStreamReader:close	()V
    //   155: aload 5
    //   157: areturn
    //   158: astore_0
    //   159: aload 5
    //   161: areturn
    //   162: astore_3
    //   163: aconst_null
    //   164: astore_0
    //   165: aload_2
    //   166: ifnull +7 -> 173
    //   169: aload_2
    //   170: invokevirtual 168	java/io/BufferedReader:close	()V
    //   173: aload_0
    //   174: ifnull +7 -> 181
    //   177: aload_0
    //   178: invokevirtual 169	java/io/InputStreamReader:close	()V
    //   181: aload_3
    //   182: athrow
    //   183: astore_2
    //   184: goto -104 -> 80
    //   187: astore_1
    //   188: goto -44 -> 144
    //   191: astore_1
    //   192: goto -19 -> 173
    //   195: astore_0
    //   196: goto -15 -> 181
    //   199: astore_3
    //   200: aload_1
    //   201: astore_0
    //   202: goto -37 -> 165
    //   205: astore_1
    //   206: aload_3
    //   207: astore_2
    //   208: aload_1
    //   209: astore_3
    //   210: goto -45 -> 165
    //   213: astore_3
    //   214: goto -104 -> 110
    //   217: astore_1
    //   218: aload_3
    //   219: astore 4
    //   221: aload_1
    //   222: astore_3
    //   223: goto -113 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   40	47	0	localInputStreamReader	java.io.InputStreamReader
    //   92	1	0	localIOException1	java.io.IOException
    //   109	43	0	localObject1	Object
    //   158	1	0	localIOException2	java.io.IOException
    //   164	14	0	localObject2	Object
    //   195	1	0	localIOException3	java.io.IOException
    //   201	1	0	localIOException4	java.io.IOException
    //   3	127	1	localObject3	Object
    //   187	1	1	localIOException5	java.io.IOException
    //   191	10	1	localIOException6	java.io.IOException
    //   205	4	1	localObject4	Object
    //   217	5	1	localThrowable1	Throwable
    //   1	169	2	localObject5	Object
    //   183	1	2	localIOException7	java.io.IOException
    //   207	1	2	localObject6	Object
    //   53	24	3	localBufferedReader	java.io.BufferedReader
    //   107	24	3	localThrowable2	Throwable
    //   162	20	3	localObject7	Object
    //   199	8	3	localObject8	Object
    //   209	1	3	localObject9	Object
    //   213	6	3	localThrowable3	Throwable
    //   222	1	3	localThrowable4	Throwable
    //   5	215	4	localObject10	Object
    //   123	37	5	str	String
    // Exception table:
    //   from	to	target	type
    //   86	90	92	java/io/IOException
    //   22	41	107	java/lang/Throwable
    //   151	155	158	java/io/IOException
    //   22	41	162	finally
    //   76	80	183	java/io/IOException
    //   139	144	187	java/io/IOException
    //   169	173	191	java/io/IOException
    //   177	181	195	java/io/IOException
    //   45	54	199	finally
    //   115	125	199	finally
    //   130	134	199	finally
    //   54	72	205	finally
    //   95	104	205	finally
    //   45	54	213	java/lang/Throwable
    //   54	72	217	java/lang/Throwable
    //   95	104	217	java/lang/Throwable
  }
  
  public static String getGuid(Context paramContext)
  {
    String str = "";
    try
    {
      paramContext = TbsDownloadConfig.getInstance(paramContext).mPreferences.getString("tbs_guid", "");
      Log.d("0816", "getGuid guid is " + paramContext);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext = str;
      }
    }
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
    if ((!TextUtils.isEmpty(mMac)) || (Build.VERSION.SDK_INT < 23)) {}
    for (;;)
    {
      try
      {
        paramContext = (WifiManager)paramContext.getApplicationContext().getSystemService("wifi");
        if (paramContext != null) {
          continue;
        }
        paramContext = null;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        continue;
      }
      mMac = paramContext;
      return mMac;
      paramContext = paramContext.getConnectionInfo();
      break label80;
      paramContext = paramContext.getMacAddress();
      continue;
      mMac = getMacAddressByNetworkInterfaceName();
      continue;
      label80:
      if (paramContext == null) {
        paramContext = "";
      }
    }
  }
  
  public static String getMacAddressByNetworkInterfaceName()
  {
    try
    {
      Object localObject1 = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (NetworkInterface)((Iterator)localObject1).next();
        if (((NetworkInterface)localObject2).getName().equalsIgnoreCase("wlan0"))
        {
          localObject1 = ((NetworkInterface)localObject2).getHardwareAddress();
          if (localObject1 == null) {
            return "";
          }
          localObject2 = new StringBuilder();
          int j = localObject1.length;
          int i = 0;
          while (i < j)
          {
            ((StringBuilder)localObject2).append(String.format("%02X:", new Object[] { Byte.valueOf(localObject1[i]) }));
            i += 1;
          }
          if (((StringBuilder)localObject2).length() > 0) {
            ((StringBuilder)localObject2).deleteCharAt(((StringBuilder)localObject2).length() - 1);
          }
          localObject1 = ((StringBuilder)localObject2).toString();
          return localObject1;
        }
      }
    }
    catch (Exception localException) {}
    return "02:00:00:00:00:00";
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
            break label353;
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
      label353:
      i += 1;
    }
  }
  
  private static String getSignatureFromApk(Context paramContext, File paramFile, boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      paramContext = getPackageArchiveInfo(paramFile.getAbsolutePath(), 65);
      if (paramContext != null) {
        if ((paramContext.signatures == null) || (paramContext.signatures.length <= 0)) {}
      }
      for (paramContext = paramContext.signatures[0];; paramContext = null)
      {
        if (paramContext == null) {
          break label111;
        }
        return paramContext.toCharsString();
        paramContext = paramContext.getPackageManager().getPackageArchiveInfo(paramFile.getAbsolutePath(), 65);
        break;
        TbsLog.w("AppUtil", "[getSignatureFromApk] pkgInfo is not null BUT signatures is null!");
      }
      return null;
    }
    catch (Exception paramContext)
    {
      TbsLog.i("AppUtil", "getSign " + paramFile + "failed");
    }
  }
  
  /* Error */
  public static String getSignatureFromApk(Context paramContext, boolean paramBoolean, File paramFile)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +10 -> 11
    //   4: aload_2
    //   5: invokevirtual 429	java/io/File:exists	()Z
    //   8: ifne +10 -> 18
    //   11: ldc 17
    //   13: astore 4
    //   15: aload 4
    //   17: areturn
    //   18: iload_1
    //   19: ifeq +74 -> 93
    //   22: iconst_2
    //   23: newarray byte
    //   25: astore 5
    //   27: new 431	java/io/RandomAccessFile
    //   30: dup
    //   31: aload_2
    //   32: ldc_w 433
    //   35: invokespecial 436	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   38: astore 4
    //   40: aload 4
    //   42: astore_3
    //   43: aload 4
    //   45: aload 5
    //   47: invokevirtual 440	java/io/RandomAccessFile:read	([B)I
    //   50: pop
    //   51: aload 4
    //   53: astore_3
    //   54: new 88	java/lang/String
    //   57: dup
    //   58: aload 5
    //   60: invokespecial 443	java/lang/String:<init>	([B)V
    //   63: ldc_w 445
    //   66: invokevirtual 292	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   69: ifne +19 -> 88
    //   72: aload 4
    //   74: invokevirtual 446	java/io/RandomAccessFile:close	()V
    //   77: ldc 17
    //   79: areturn
    //   80: astore_0
    //   81: aload_0
    //   82: invokevirtual 447	java/io/IOException:printStackTrace	()V
    //   85: ldc 17
    //   87: areturn
    //   88: aload 4
    //   90: invokevirtual 446	java/io/RandomAccessFile:close	()V
    //   93: aload_0
    //   94: invokevirtual 240	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   97: invokevirtual 64	android/content/Context:getPackageName	()Ljava/lang/String;
    //   100: ldc_w 449
    //   103: invokevirtual 159	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   106: ifeq +39 -> 145
    //   109: ldc 8
    //   111: ldc_w 451
    //   114: invokestatic 425	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   117: aload_2
    //   118: invokestatic 454	com/tencent/smtt/utils/AppUtil:getSignatureFromApk	(Ljava/io/File;)Ljava/lang/String;
    //   121: astore_3
    //   122: aload_3
    //   123: ifnull +22 -> 145
    //   126: ldc 8
    //   128: ldc_w 456
    //   131: invokestatic 425	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   134: aload_3
    //   135: areturn
    //   136: astore_3
    //   137: ldc 8
    //   139: ldc_w 458
    //   142: invokestatic 425	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   145: ldc 8
    //   147: ldc_w 460
    //   150: invokestatic 425	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   153: aload_0
    //   154: aload_2
    //   155: iconst_0
    //   156: invokestatic 462	com/tencent/smtt/utils/AppUtil:getSignatureFromApk	(Landroid/content/Context;Ljava/io/File;Z)Ljava/lang/String;
    //   159: astore 4
    //   161: ldc 8
    //   163: new 199	java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   170: ldc_w 464
    //   173: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: aload 4
    //   178: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokestatic 425	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   187: aload 4
    //   189: astore_3
    //   190: aload 4
    //   192: ifnonnull +33 -> 225
    //   195: aload_2
    //   196: invokestatic 454	com/tencent/smtt/utils/AppUtil:getSignatureFromApk	(Ljava/io/File;)Ljava/lang/String;
    //   199: astore_3
    //   200: ldc 8
    //   202: new 199	java/lang/StringBuilder
    //   205: dup
    //   206: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   209: ldc_w 466
    //   212: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: aload_3
    //   216: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: invokestatic 425	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   225: aload_3
    //   226: astore 4
    //   228: aload_3
    //   229: ifnonnull -214 -> 15
    //   232: aload_0
    //   233: aload_2
    //   234: iconst_1
    //   235: invokestatic 462	com/tencent/smtt/utils/AppUtil:getSignatureFromApk	(Landroid/content/Context;Ljava/io/File;Z)Ljava/lang/String;
    //   238: astore_0
    //   239: ldc 8
    //   241: new 199	java/lang/StringBuilder
    //   244: dup
    //   245: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   248: ldc_w 468
    //   251: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: aload_0
    //   255: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   261: invokestatic 425	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   264: aload_0
    //   265: areturn
    //   266: astore_3
    //   267: aload_3
    //   268: invokevirtual 447	java/io/IOException:printStackTrace	()V
    //   271: goto -178 -> 93
    //   274: astore 5
    //   276: aconst_null
    //   277: astore 4
    //   279: aload 4
    //   281: astore_3
    //   282: aload 5
    //   284: invokevirtual 58	java/lang/Exception:printStackTrace	()V
    //   287: aload 4
    //   289: invokevirtual 446	java/io/RandomAccessFile:close	()V
    //   292: goto -199 -> 93
    //   295: astore_3
    //   296: aload_3
    //   297: invokevirtual 447	java/io/IOException:printStackTrace	()V
    //   300: goto -207 -> 93
    //   303: astore_0
    //   304: aconst_null
    //   305: astore_3
    //   306: aload_3
    //   307: invokevirtual 446	java/io/RandomAccessFile:close	()V
    //   310: aload_0
    //   311: athrow
    //   312: astore_2
    //   313: aload_2
    //   314: invokevirtual 447	java/io/IOException:printStackTrace	()V
    //   317: goto -7 -> 310
    //   320: astore_0
    //   321: goto -15 -> 306
    //   324: astore 5
    //   326: goto -47 -> 279
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	329	0	paramContext	Context
    //   0	329	1	paramBoolean	boolean
    //   0	329	2	paramFile	File
    //   42	93	3	localObject1	Object
    //   136	1	3	localThrowable	Throwable
    //   189	40	3	localObject2	Object
    //   266	2	3	localIOException1	java.io.IOException
    //   281	1	3	localObject3	Object
    //   295	2	3	localIOException2	java.io.IOException
    //   305	2	3	localObject4	Object
    //   13	275	4	localObject5	Object
    //   25	34	5	arrayOfByte	byte[]
    //   274	9	5	localException1	Exception
    //   324	1	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   72	77	80	java/io/IOException
    //   93	122	136	java/lang/Throwable
    //   126	134	136	java/lang/Throwable
    //   88	93	266	java/io/IOException
    //   22	40	274	java/lang/Exception
    //   287	292	295	java/io/IOException
    //   22	40	303	finally
    //   306	310	312	java/io/IOException
    //   43	51	320	finally
    //   54	72	320	finally
    //   282	287	320	finally
    //   43	51	324	java/lang/Exception
    //   54	72	324	java/lang/Exception
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
  
  public static boolean is64BitImpl()
  {
    try
    {
      if (Build.VERSION.SDK_INT < 21) {
        return false;
      }
      Object localObject1 = Class.forName("dalvik.system.VMRuntime");
      if (localObject1 == null) {
        return false;
      }
      Object localObject2 = ((Class)localObject1).getDeclaredMethod("getRuntime", new Class[0]);
      if (localObject2 == null) {
        return false;
      }
      localObject2 = ((Method)localObject2).invoke(null, new Object[0]);
      if (localObject2 == null) {
        return false;
      }
      localObject1 = ((Class)localObject1).getDeclaredMethod("is64Bit", new Class[0]);
      if (localObject1 == null) {
        return false;
      }
      localObject1 = ((Method)localObject1).invoke(localObject2, new Object[0]);
      if ((localObject1 instanceof Boolean))
      {
        boolean bool = ((Boolean)localObject1).booleanValue();
        return bool;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return false;
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
  
  private static String notNullString(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public static void saveGuid(Context paramContext, String paramString)
  {
    Log.d("0816", "saveGuid guid is " + paramString);
    try
    {
      paramContext = TbsDownloadConfig.getInstance(paramContext);
      paramContext.mSyncMap.put("tbs_guid", paramString);
      paramContext.commit();
      return;
    }
    catch (Exception paramContext) {}
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