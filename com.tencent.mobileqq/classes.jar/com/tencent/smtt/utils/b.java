package com.tencent.smtt.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import java.io.File;
import java.io.InputStream;
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

public class b
{
  public static String a = "";
  public static String b = "";
  public static String c = "";
  public static String d = "";
  public static String e = "";
  
  public static String a()
  {
    try
    {
      String str = new String(Build.MODEL.getBytes("UTF-8"), "ISO8859-1");
      return str;
    }
    catch (Exception localException) {}
    return Build.MODEL;
  }
  
  public static String a(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageName();
      return paramContext;
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  private static String a(Context paramContext, File paramFile)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageArchiveInfo(paramFile.getAbsolutePath(), 65);
      if (paramContext != null) {
        if ((paramContext.signatures == null) || (paramContext.signatures.length <= 0)) {}
      }
      for (paramContext = paramContext.signatures[0]; paramContext != null; paramContext = null)
      {
        return paramContext.toCharsString();
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
  public static String a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 53	android/content/Context:getPackageName	()Ljava/lang/String;
    //   4: astore_2
    //   5: aload_0
    //   6: invokevirtual 58	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   9: aload_2
    //   10: sipush 128
    //   13: invokevirtual 116	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   16: getfield 122	android/content/pm/ApplicationInfo:metaData	Landroid/os/Bundle;
    //   19: aload_1
    //   20: invokevirtual 128	android/os/Bundle:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   23: invokestatic 132	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   26: astore_0
    //   27: aload_0
    //   28: invokestatic 138	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   31: invokestatic 142	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   34: invokestatic 132	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
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
  
  /* Error */
  public static String a(Context paramContext, boolean paramBoolean, File paramFile)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +10 -> 11
    //   4: aload_2
    //   5: invokevirtual 151	java/io/File:exists	()Z
    //   8: ifne +8 -> 16
    //   11: ldc 14
    //   13: astore_0
    //   14: aload_0
    //   15: areturn
    //   16: iload_1
    //   17: ifeq +72 -> 89
    //   20: iconst_2
    //   21: newarray byte
    //   23: astore 5
    //   25: new 153	java/io/RandomAccessFile
    //   28: dup
    //   29: aload_2
    //   30: ldc 155
    //   32: invokespecial 158	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   35: astore 4
    //   37: aload 4
    //   39: astore_3
    //   40: aload 4
    //   42: aload 5
    //   44: invokevirtual 162	java/io/RandomAccessFile:read	([B)I
    //   47: pop
    //   48: aload 4
    //   50: astore_3
    //   51: new 30	java/lang/String
    //   54: dup
    //   55: aload 5
    //   57: invokespecial 165	java/lang/String:<init>	([B)V
    //   60: ldc 167
    //   62: invokevirtual 171	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   65: ifne +19 -> 84
    //   68: aload 4
    //   70: invokevirtual 174	java/io/RandomAccessFile:close	()V
    //   73: ldc 14
    //   75: areturn
    //   76: astore_0
    //   77: aload_0
    //   78: invokevirtual 177	java/io/IOException:printStackTrace	()V
    //   81: ldc 14
    //   83: areturn
    //   84: aload 4
    //   86: invokevirtual 174	java/io/RandomAccessFile:close	()V
    //   89: aload_0
    //   90: invokevirtual 181	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   93: invokevirtual 53	android/content/Context:getPackageName	()Ljava/lang/String;
    //   96: ldc 183
    //   98: invokevirtual 187	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   101: ifeq +36 -> 137
    //   104: ldc 82
    //   106: ldc 189
    //   108: invokestatic 111	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   111: aload_2
    //   112: invokestatic 192	com/tencent/smtt/utils/b:a	(Ljava/io/File;)Ljava/lang/String;
    //   115: astore_3
    //   116: aload_3
    //   117: ifnull +20 -> 137
    //   120: ldc 82
    //   122: ldc 194
    //   124: invokestatic 111	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   127: aload_3
    //   128: areturn
    //   129: astore_3
    //   130: ldc 82
    //   132: ldc 196
    //   134: invokestatic 111	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   137: ldc 82
    //   139: ldc 198
    //   141: invokestatic 111	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   144: aload_0
    //   145: aload_2
    //   146: invokestatic 200	com/tencent/smtt/utils/b:a	(Landroid/content/Context;Ljava/io/File;)Ljava/lang/String;
    //   149: astore_3
    //   150: ldc 82
    //   152: new 92	java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   159: ldc 202
    //   161: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: aload_3
    //   165: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: invokestatic 111	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   174: aload_3
    //   175: astore_0
    //   176: aload_3
    //   177: ifnonnull -163 -> 14
    //   180: aload_2
    //   181: invokestatic 192	com/tencent/smtt/utils/b:a	(Ljava/io/File;)Ljava/lang/String;
    //   184: astore_0
    //   185: ldc 82
    //   187: new 92	java/lang/StringBuilder
    //   190: dup
    //   191: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   194: ldc 204
    //   196: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: aload_0
    //   200: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: invokestatic 111	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   209: aload_0
    //   210: areturn
    //   211: astore_3
    //   212: aload_3
    //   213: invokevirtual 177	java/io/IOException:printStackTrace	()V
    //   216: goto -127 -> 89
    //   219: astore 5
    //   221: aconst_null
    //   222: astore 4
    //   224: aload 4
    //   226: astore_3
    //   227: aload 5
    //   229: invokevirtual 205	java/lang/Exception:printStackTrace	()V
    //   232: aload 4
    //   234: invokevirtual 174	java/io/RandomAccessFile:close	()V
    //   237: goto -148 -> 89
    //   240: astore_3
    //   241: aload_3
    //   242: invokevirtual 177	java/io/IOException:printStackTrace	()V
    //   245: goto -156 -> 89
    //   248: astore_0
    //   249: aconst_null
    //   250: astore_3
    //   251: aload_3
    //   252: invokevirtual 174	java/io/RandomAccessFile:close	()V
    //   255: aload_0
    //   256: athrow
    //   257: astore_2
    //   258: aload_2
    //   259: invokevirtual 177	java/io/IOException:printStackTrace	()V
    //   262: goto -7 -> 255
    //   265: astore_0
    //   266: goto -15 -> 251
    //   269: astore 5
    //   271: goto -47 -> 224
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	274	0	paramContext	Context
    //   0	274	1	paramBoolean	boolean
    //   0	274	2	paramFile	File
    //   39	89	3	localObject1	Object
    //   129	1	3	localThrowable	Throwable
    //   149	28	3	str	String
    //   211	2	3	localIOException1	java.io.IOException
    //   226	1	3	localRandomAccessFile1	java.io.RandomAccessFile
    //   240	2	3	localIOException2	java.io.IOException
    //   250	2	3	localObject2	Object
    //   35	198	4	localRandomAccessFile2	java.io.RandomAccessFile
    //   23	33	5	arrayOfByte	byte[]
    //   219	9	5	localException1	Exception
    //   269	1	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   68	73	76	java/io/IOException
    //   89	116	129	java/lang/Throwable
    //   120	127	129	java/lang/Throwable
    //   84	89	211	java/io/IOException
    //   20	37	219	java/lang/Exception
    //   232	237	240	java/io/IOException
    //   20	37	248	finally
    //   251	255	257	java/io/IOException
    //   40	48	265	finally
    //   51	68	265	finally
    //   227	232	265	finally
    //   40	48	269	java/lang/Exception
    //   51	68	269	java/lang/Exception
  }
  
  private static String a(File paramFile)
  {
    String str1;
    for (;;)
    {
      try
      {
        JarFile localJarFile = new JarFile(paramFile);
        paramFile = localJarFile.getJarEntry("AndroidManifest.xml");
        byte[] arrayOfByte = new byte[8192];
        str1 = a(a(localJarFile, paramFile, arrayOfByte)[0].getEncoded());
        Enumeration localEnumeration = localJarFile.entries();
        if (!localEnumeration.hasMoreElements()) {
          break;
        }
        paramFile = (JarEntry)localEnumeration.nextElement();
        String str2 = paramFile.getName();
        if (str2 == null) {
          continue;
        }
        paramFile = a(localJarFile, paramFile, arrayOfByte);
        if (paramFile != null)
        {
          paramFile = a(paramFile[0].getEncoded());
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
  
  private static String a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
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
  
  private static Certificate[] a(JarFile paramJarFile, JarEntry paramJarEntry, byte[] paramArrayOfByte)
  {
    paramJarFile = paramJarFile.getInputStream(paramJarEntry);
    while (paramJarFile.read(paramArrayOfByte, 0, paramArrayOfByte.length) != -1) {}
    paramJarFile.close();
    if (paramJarEntry != null) {
      return paramJarEntry.getCertificates();
    }
    return null;
  }
  
  public static int b(Context paramContext)
  {
    return Build.VERSION.SDK_INT;
  }
  
  /* Error */
  public static String b()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_1
    //   4: aconst_null
    //   5: astore 4
    //   7: getstatic 20	com/tencent/smtt/utils/b:c	Ljava/lang/String;
    //   10: invokestatic 285	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifne +9 -> 22
    //   16: getstatic 20	com/tencent/smtt/utils/b:c	Ljava/lang/String;
    //   19: astore_2
    //   20: aload_2
    //   21: areturn
    //   22: new 287	java/io/InputStreamReader
    //   25: dup
    //   26: invokestatic 293	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   29: ldc_w 295
    //   32: invokevirtual 299	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   35: invokevirtual 304	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   38: invokespecial 307	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   41: astore_0
    //   42: aload_1
    //   43: astore_2
    //   44: aload_0
    //   45: astore_1
    //   46: new 309	java/io/BufferedReader
    //   49: dup
    //   50: aload_0
    //   51: invokespecial 312	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   54: astore_3
    //   55: aload_3
    //   56: invokevirtual 315	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   59: ldc_w 317
    //   62: invokevirtual 187	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   65: ifeq +33 -> 98
    //   68: ldc_w 319
    //   71: invokestatic 321	com/tencent/smtt/utils/b:a	(Ljava/lang/String;)Ljava/lang/String;
    //   74: astore_1
    //   75: aload_3
    //   76: ifnull +7 -> 83
    //   79: aload_3
    //   80: invokevirtual 322	java/io/BufferedReader:close	()V
    //   83: aload_1
    //   84: astore_2
    //   85: aload_0
    //   86: ifnull -66 -> 20
    //   89: aload_0
    //   90: invokevirtual 323	java/io/InputStreamReader:close	()V
    //   93: aload_1
    //   94: areturn
    //   95: astore_0
    //   96: aload_1
    //   97: areturn
    //   98: ldc_w 325
    //   101: invokestatic 330	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   104: invokestatic 321	com/tencent/smtt/utils/b:a	(Ljava/lang/String;)Ljava/lang/String;
    //   107: astore_1
    //   108: goto -33 -> 75
    //   111: astore_3
    //   112: aconst_null
    //   113: astore_0
    //   114: aload 4
    //   116: astore_2
    //   117: aload_0
    //   118: astore_1
    //   119: ldc_w 325
    //   122: invokestatic 330	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   125: invokestatic 321	com/tencent/smtt/utils/b:a	(Ljava/lang/String;)Ljava/lang/String;
    //   128: astore 5
    //   130: aload 4
    //   132: astore_2
    //   133: aload_0
    //   134: astore_1
    //   135: aload_3
    //   136: invokevirtual 331	java/lang/Throwable:printStackTrace	()V
    //   139: aload 4
    //   141: ifnull +8 -> 149
    //   144: aload 4
    //   146: invokevirtual 322	java/io/BufferedReader:close	()V
    //   149: aload 5
    //   151: astore_2
    //   152: aload_0
    //   153: ifnull -133 -> 20
    //   156: aload_0
    //   157: invokevirtual 323	java/io/InputStreamReader:close	()V
    //   160: aload 5
    //   162: areturn
    //   163: astore_0
    //   164: aload 5
    //   166: areturn
    //   167: astore_3
    //   168: aconst_null
    //   169: astore_0
    //   170: aload_2
    //   171: ifnull +7 -> 178
    //   174: aload_2
    //   175: invokevirtual 322	java/io/BufferedReader:close	()V
    //   178: aload_0
    //   179: ifnull +7 -> 186
    //   182: aload_0
    //   183: invokevirtual 323	java/io/InputStreamReader:close	()V
    //   186: aload_3
    //   187: athrow
    //   188: astore_2
    //   189: goto -106 -> 83
    //   192: astore_1
    //   193: goto -44 -> 149
    //   196: astore_1
    //   197: goto -19 -> 178
    //   200: astore_0
    //   201: goto -15 -> 186
    //   204: astore_3
    //   205: aload_1
    //   206: astore_0
    //   207: goto -37 -> 170
    //   210: astore_1
    //   211: aload_3
    //   212: astore_2
    //   213: aload_1
    //   214: astore_3
    //   215: goto -45 -> 170
    //   218: astore_3
    //   219: goto -105 -> 114
    //   222: astore_1
    //   223: aload_3
    //   224: astore 4
    //   226: aload_1
    //   227: astore_3
    //   228: goto -114 -> 114
    // Local variable table:
    //   start	length	slot	name	signature
    //   41	49	0	localInputStreamReader	java.io.InputStreamReader
    //   95	1	0	localIOException1	java.io.IOException
    //   113	44	0	localObject1	Object
    //   163	1	0	localIOException2	java.io.IOException
    //   169	14	0	localObject2	Object
    //   200	1	0	localIOException3	java.io.IOException
    //   206	1	0	localIOException4	java.io.IOException
    //   3	132	1	localObject3	Object
    //   192	1	1	localIOException5	java.io.IOException
    //   196	10	1	localIOException6	java.io.IOException
    //   210	4	1	localObject4	Object
    //   222	5	1	localThrowable1	Throwable
    //   1	174	2	localObject5	Object
    //   188	1	2	localIOException7	java.io.IOException
    //   212	1	2	localObject6	Object
    //   54	26	3	localBufferedReader	java.io.BufferedReader
    //   111	25	3	localThrowable2	Throwable
    //   167	20	3	localObject7	Object
    //   204	8	3	localObject8	Object
    //   214	1	3	localObject9	Object
    //   218	6	3	localThrowable3	Throwable
    //   227	1	3	localThrowable4	Throwable
    //   5	220	4	localObject10	Object
    //   128	37	5	str	String
    // Exception table:
    //   from	to	target	type
    //   89	93	95	java/io/IOException
    //   22	42	111	java/lang/Throwable
    //   156	160	163	java/io/IOException
    //   22	42	167	finally
    //   79	83	188	java/io/IOException
    //   144	149	192	java/io/IOException
    //   174	178	196	java/io/IOException
    //   182	186	200	java/io/IOException
    //   46	55	204	finally
    //   119	130	204	finally
    //   135	139	204	finally
    //   55	75	210	finally
    //   98	108	210	finally
    //   46	55	218	java/lang/Throwable
    //   55	75	222	java/lang/Throwable
    //   98	108	222	java/lang/Throwable
  }
  
  public static void b(Context paramContext, String paramString)
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
  
  public static String c()
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
  
  public static String c(Context paramContext)
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
  
  public static int d(Context paramContext)
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
  
  public static boolean d()
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
  
  public static String e(Context paramContext)
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
  
  public static String f(Context paramContext)
  {
    if (!TextUtils.isEmpty(a)) {
      return a;
    }
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      TbsLog.i(paramContext);
    }
    return "";
  }
  
  public static String g(Context paramContext)
  {
    if (!TextUtils.isEmpty(b)) {
      return b;
    }
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getSubscriberId();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      TbsLog.i(paramContext);
    }
    return "";
  }
  
  public static String h(Context paramContext)
  {
    if ((!TextUtils.isEmpty(d)) || (Build.VERSION.SDK_INT < 23)) {}
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
        TbsLog.i(paramContext);
        continue;
      }
      d = paramContext;
      return d;
      paramContext = paramContext.getConnectionInfo();
      break label81;
      paramContext = paramContext.getMacAddress();
      continue;
      d = c();
      continue;
      label81:
      if (paramContext == null) {
        paramContext = "";
      }
    }
  }
  
  public static String i(Context paramContext)
  {
    if (!TextUtils.isEmpty(e)) {
      return e;
    }
    try
    {
      e = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      return e;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.smtt.utils.b
 * JD-Core Version:    0.7.0.1
 */