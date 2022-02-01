package com.tencent.smtt.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
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
    catch (Exception localException)
    {
      label20:
      break label20;
    }
    return Build.MODEL;
  }
  
  public static String a(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageName();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      label7:
      break label7;
    }
    return null;
  }
  
  private static String a(Context paramContext, File paramFile)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageArchiveInfo(paramFile.getAbsolutePath(), 65);
      if (paramContext == null) {
        break label107;
      }
      if ((paramContext.signatures != null) && (paramContext.signatures.length > 0)) {
        paramContext = paramContext.signatures[0];
      } else {
        TbsLog.w("AppUtil", "[getSignatureFromApk] pkgInfo is not null BUT signatures is null!");
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        continue;
        label107:
        paramContext = null;
      }
    }
    if (paramContext != null)
    {
      paramContext = paramContext.toCharsString();
      return paramContext;
      paramContext = new StringBuilder();
      paramContext.append("getSign ");
      paramContext.append(paramFile);
      paramContext.append("failed");
      TbsLog.i("AppUtil", paramContext.toString());
    }
    return null;
  }
  
  public static String a(Context paramContext, String paramString)
  {
    try
    {
      String str = paramContext.getPackageName();
      paramContext = String.valueOf(paramContext.getPackageManager().getApplicationInfo(str, 128).metaData.get(paramString));
    }
    catch (Exception paramContext)
    {
      label40:
      break label40;
    }
    try
    {
      paramString = String.valueOf(Integer.toHexString(Integer.parseInt(paramContext)));
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
    return paramContext;
  }
  
  /* Error */
  public static String a(Context paramContext, boolean paramBoolean, File paramFile)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +279 -> 280
    //   4: aload_2
    //   5: invokevirtual 141	java/io/File:exists	()Z
    //   8: ifne +6 -> 14
    //   11: ldc 8
    //   13: areturn
    //   14: iload_1
    //   15: ifeq +132 -> 147
    //   18: iconst_2
    //   19: newarray byte
    //   21: astore 5
    //   23: new 143	java/io/RandomAccessFile
    //   26: dup
    //   27: aload_2
    //   28: ldc 145
    //   30: invokespecial 148	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   33: astore 4
    //   35: aload 4
    //   37: astore_3
    //   38: aload 4
    //   40: aload 5
    //   42: invokevirtual 152	java/io/RandomAccessFile:read	([B)I
    //   45: pop
    //   46: aload 4
    //   48: astore_3
    //   49: new 20	java/lang/String
    //   52: dup
    //   53: aload 5
    //   55: invokespecial 155	java/lang/String:<init>	([B)V
    //   58: ldc 157
    //   60: invokevirtual 161	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   63: istore_1
    //   64: iload_1
    //   65: ifne +19 -> 84
    //   68: aload 4
    //   70: invokevirtual 164	java/io/RandomAccessFile:close	()V
    //   73: ldc 8
    //   75: areturn
    //   76: astore_0
    //   77: aload_0
    //   78: invokevirtual 167	java/io/IOException:printStackTrace	()V
    //   81: ldc 8
    //   83: areturn
    //   84: aload 4
    //   86: invokevirtual 164	java/io/RandomAccessFile:close	()V
    //   89: goto +58 -> 147
    //   92: astore 5
    //   94: goto +14 -> 108
    //   97: astore_0
    //   98: aconst_null
    //   99: astore_3
    //   100: goto +33 -> 133
    //   103: astore 5
    //   105: aconst_null
    //   106: astore 4
    //   108: aload 4
    //   110: astore_3
    //   111: aload 5
    //   113: invokevirtual 168	java/lang/Exception:printStackTrace	()V
    //   116: aload 4
    //   118: invokevirtual 164	java/io/RandomAccessFile:close	()V
    //   121: goto +26 -> 147
    //   124: astore_3
    //   125: aload_3
    //   126: invokevirtual 167	java/io/IOException:printStackTrace	()V
    //   129: goto +18 -> 147
    //   132: astore_0
    //   133: aload_3
    //   134: invokevirtual 164	java/io/RandomAccessFile:close	()V
    //   137: goto +8 -> 145
    //   140: astore_2
    //   141: aload_2
    //   142: invokevirtual 167	java/io/IOException:printStackTrace	()V
    //   145: aload_0
    //   146: athrow
    //   147: aload_0
    //   148: invokevirtual 172	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   151: invokevirtual 43	android/content/Context:getPackageName	()Ljava/lang/String;
    //   154: ldc 174
    //   156: invokevirtual 178	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   159: ifeq +35 -> 194
    //   162: ldc 67
    //   164: ldc 180
    //   166: invokestatic 101	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   169: aload_2
    //   170: invokestatic 183	com/tencent/smtt/utils/b:a	(Ljava/io/File;)Ljava/lang/String;
    //   173: astore_3
    //   174: aload_3
    //   175: ifnull +19 -> 194
    //   178: ldc 67
    //   180: ldc 185
    //   182: invokestatic 101	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   185: aload_3
    //   186: areturn
    //   187: ldc 67
    //   189: ldc 187
    //   191: invokestatic 101	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   194: ldc 67
    //   196: ldc 189
    //   198: invokestatic 101	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   201: aload_0
    //   202: aload_2
    //   203: invokestatic 191	com/tencent/smtt/utils/b:a	(Landroid/content/Context;Ljava/io/File;)Ljava/lang/String;
    //   206: astore_3
    //   207: new 82	java/lang/StringBuilder
    //   210: dup
    //   211: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   214: astore_0
    //   215: aload_0
    //   216: ldc 193
    //   218: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: pop
    //   222: aload_0
    //   223: aload_3
    //   224: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: pop
    //   228: ldc 67
    //   230: aload_0
    //   231: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   234: invokestatic 101	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   237: aload_3
    //   238: astore_0
    //   239: aload_3
    //   240: ifnonnull +38 -> 278
    //   243: aload_2
    //   244: invokestatic 183	com/tencent/smtt/utils/b:a	(Ljava/io/File;)Ljava/lang/String;
    //   247: astore_0
    //   248: new 82	java/lang/StringBuilder
    //   251: dup
    //   252: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   255: astore_2
    //   256: aload_2
    //   257: ldc 195
    //   259: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: pop
    //   263: aload_2
    //   264: aload_0
    //   265: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: ldc 67
    //   271: aload_2
    //   272: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   275: invokestatic 101	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   278: aload_0
    //   279: areturn
    //   280: ldc 8
    //   282: areturn
    //   283: astore_3
    //   284: goto -97 -> 187
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	287	0	paramContext	Context
    //   0	287	1	paramBoolean	boolean
    //   0	287	2	paramFile	File
    //   37	74	3	localRandomAccessFile1	java.io.RandomAccessFile
    //   124	10	3	localIOException	java.io.IOException
    //   173	67	3	str	String
    //   283	1	3	localThrowable	Throwable
    //   33	84	4	localRandomAccessFile2	java.io.RandomAccessFile
    //   21	33	5	arrayOfByte	byte[]
    //   92	1	5	localException1	Exception
    //   103	9	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   68	73	76	java/io/IOException
    //   38	46	92	java/lang/Exception
    //   49	64	92	java/lang/Exception
    //   18	35	97	finally
    //   18	35	103	java/lang/Exception
    //   84	89	124	java/io/IOException
    //   116	121	124	java/io/IOException
    //   38	46	132	finally
    //   49	64	132	finally
    //   111	116	132	finally
    //   133	137	140	java/io/IOException
    //   147	174	283	java/lang/Throwable
    //   178	185	283	java/lang/Throwable
  }
  
  private static String a(File paramFile)
  {
    for (;;)
    {
      try
      {
        JarFile localJarFile = new JarFile(paramFile);
        paramFile = localJarFile.getJarEntry("AndroidManifest.xml");
        byte[] arrayOfByte = new byte[8192];
        String str1 = a(a(localJarFile, paramFile, arrayOfByte)[0].getEncoded());
        Enumeration localEnumeration = localJarFile.entries();
        if (localEnumeration.hasMoreElements())
        {
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
        else
        {
          return str1;
        }
      }
      catch (Exception paramFile)
      {
        paramFile.printStackTrace();
        return null;
      }
      paramFile = null;
    }
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
    //   0: getstatic 272	com/tencent/smtt/utils/b:c	Ljava/lang/String;
    //   3: invokestatic 277	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifne +7 -> 13
    //   9: getstatic 272	com/tencent/smtt/utils/b:c	Ljava/lang/String;
    //   12: areturn
    //   13: aconst_null
    //   14: astore_1
    //   15: aconst_null
    //   16: astore_2
    //   17: aconst_null
    //   18: astore 5
    //   20: new 279	java/io/InputStreamReader
    //   23: dup
    //   24: invokestatic 285	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   27: ldc_w 287
    //   30: invokevirtual 291	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   33: invokevirtual 296	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   36: invokespecial 299	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   39: astore_0
    //   40: aload_0
    //   41: astore_2
    //   42: new 301	java/io/BufferedReader
    //   45: dup
    //   46: aload_0
    //   47: invokespecial 304	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   50: astore_3
    //   51: aload_3
    //   52: invokevirtual 307	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   55: ldc_w 309
    //   58: invokevirtual 178	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   61: ifeq +15 -> 76
    //   64: ldc_w 311
    //   67: astore_1
    //   68: aload_1
    //   69: invokestatic 313	com/tencent/smtt/utils/b:a	(Ljava/lang/String;)Ljava/lang/String;
    //   72: astore_1
    //   73: goto +13 -> 86
    //   76: ldc_w 315
    //   79: invokestatic 320	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   82: astore_1
    //   83: goto -15 -> 68
    //   86: aload_3
    //   87: invokevirtual 321	java/io/BufferedReader:close	()V
    //   90: aload_0
    //   91: invokevirtual 322	java/io/InputStreamReader:close	()V
    //   94: aload_1
    //   95: areturn
    //   96: astore_1
    //   97: aload_3
    //   98: astore_2
    //   99: goto +81 -> 180
    //   102: astore 4
    //   104: goto +24 -> 128
    //   107: astore 4
    //   109: aload 5
    //   111: astore_3
    //   112: goto +16 -> 128
    //   115: astore_1
    //   116: aconst_null
    //   117: astore_0
    //   118: goto +62 -> 180
    //   121: astore 4
    //   123: aconst_null
    //   124: astore_0
    //   125: aload 5
    //   127: astore_3
    //   128: aload_3
    //   129: astore_1
    //   130: aload_0
    //   131: astore_2
    //   132: ldc_w 315
    //   135: invokestatic 320	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   138: invokestatic 313	com/tencent/smtt/utils/b:a	(Ljava/lang/String;)Ljava/lang/String;
    //   141: astore 5
    //   143: aload_3
    //   144: astore_1
    //   145: aload_0
    //   146: astore_2
    //   147: aload 4
    //   149: invokevirtual 323	java/lang/Throwable:printStackTrace	()V
    //   152: aload_3
    //   153: ifnull +7 -> 160
    //   156: aload_3
    //   157: invokevirtual 321	java/io/BufferedReader:close	()V
    //   160: aload_0
    //   161: ifnull +9 -> 170
    //   164: aload 5
    //   166: astore_1
    //   167: goto -77 -> 90
    //   170: aload 5
    //   172: areturn
    //   173: astore_3
    //   174: aload_2
    //   175: astore_0
    //   176: aload_1
    //   177: astore_2
    //   178: aload_3
    //   179: astore_1
    //   180: aload_2
    //   181: ifnull +7 -> 188
    //   184: aload_2
    //   185: invokevirtual 321	java/io/BufferedReader:close	()V
    //   188: aload_0
    //   189: ifnull +7 -> 196
    //   192: aload_0
    //   193: invokevirtual 322	java/io/InputStreamReader:close	()V
    //   196: goto +5 -> 201
    //   199: aload_1
    //   200: athrow
    //   201: goto -2 -> 199
    //   204: astore_2
    //   205: goto -115 -> 90
    //   208: astore_0
    //   209: aload_1
    //   210: areturn
    //   211: astore_1
    //   212: goto -52 -> 160
    //   215: astore_2
    //   216: goto -28 -> 188
    //   219: astore_0
    //   220: goto -24 -> 196
    // Local variable table:
    //   start	length	slot	name	signature
    //   39	154	0	localObject1	Object
    //   208	1	0	localIOException1	java.io.IOException
    //   219	1	0	localIOException2	java.io.IOException
    //   14	81	1	str1	String
    //   96	1	1	localObject2	Object
    //   115	1	1	localObject3	Object
    //   129	81	1	localObject4	Object
    //   211	1	1	localIOException3	java.io.IOException
    //   16	169	2	localObject5	Object
    //   204	1	2	localIOException4	java.io.IOException
    //   215	1	2	localIOException5	java.io.IOException
    //   50	107	3	localObject6	Object
    //   173	6	3	localObject7	Object
    //   102	1	4	localThrowable1	Throwable
    //   107	1	4	localThrowable2	Throwable
    //   121	27	4	localThrowable3	Throwable
    //   18	153	5	str2	String
    // Exception table:
    //   from	to	target	type
    //   51	64	96	finally
    //   68	73	96	finally
    //   76	83	96	finally
    //   51	64	102	java/lang/Throwable
    //   68	73	102	java/lang/Throwable
    //   76	83	102	java/lang/Throwable
    //   42	51	107	java/lang/Throwable
    //   20	40	115	finally
    //   20	40	121	java/lang/Throwable
    //   42	51	173	finally
    //   132	143	173	finally
    //   147	152	173	finally
    //   86	90	204	java/io/IOException
    //   90	94	208	java/io/IOException
    //   156	160	211	java/io/IOException
    //   184	188	215	java/io/IOException
    //   192	196	219	java/io/IOException
  }
  
  public static void b(Context paramContext, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("saveGuid guid is ");
    localStringBuilder.append(paramString);
    Log.d("0816", localStringBuilder.toString());
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
    catch (Exception localException)
    {
      label133:
      break label133;
    }
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
    catch (Exception paramContext)
    {
      label20:
      break label20;
    }
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
    Object localObject = "";
    try
    {
      paramContext = TbsDownloadConfig.getInstance(paramContext).mPreferences.getString("tbs_guid", "");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getGuid guid is ");
      ((StringBuilder)localObject).append(paramContext);
      Log.d("0816", ((StringBuilder)localObject).toString());
      return paramContext;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext = (Context)localObject;
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
    if (TextUtils.isEmpty(d)) {
      if (Build.VERSION.SDK_INT < 23) {
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
          TbsLog.i(paramContext);
        }
      }
    }
    for (paramContext = paramContext.getMacAddress();; paramContext = "")
    {
      d = paramContext;
      break label74;
      d = c();
      label74:
      return d;
      if (paramContext != null) {
        break;
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
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.smtt.utils.b
 * JD-Core Version:    0.7.0.1
 */