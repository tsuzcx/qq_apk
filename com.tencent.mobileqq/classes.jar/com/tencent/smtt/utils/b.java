package com.tencent.smtt.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.qmethodmonitor.monitor.PhoneInfoMonitor;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.sdk.c;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.security.cert.Certificate;
import java.util.Enumeration;
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
  public static String f = "";
  private static String g = "";
  private static boolean h = false;
  private static boolean i = false;
  private static boolean j = false;
  private static boolean k = false;
  private static boolean l = false;
  
  /* Error */
  public static String a()
  {
    // Byte code:
    //   0: getstatic 31	com/tencent/smtt/utils/b:j	Z
    //   3: ifne +251 -> 254
    //   6: aconst_null
    //   7: astore_2
    //   8: aconst_null
    //   9: astore 6
    //   11: new 33	java/io/InputStreamReader
    //   14: dup
    //   15: invokestatic 39	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   18: ldc 41
    //   20: invokevirtual 45	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   23: invokevirtual 51	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   26: invokespecial 55	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   29: astore_0
    //   30: new 57	java/io/BufferedReader
    //   33: dup
    //   34: aload_0
    //   35: invokespecial 60	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   38: astore_1
    //   39: aload 6
    //   41: astore_2
    //   42: aload_1
    //   43: astore_3
    //   44: aload_0
    //   45: astore 4
    //   47: aload_1
    //   48: invokevirtual 63	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   51: ldc 65
    //   53: invokevirtual 71	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   56: ifeq +25 -> 81
    //   59: ldc 73
    //   61: astore 5
    //   63: aload 6
    //   65: astore_2
    //   66: aload_1
    //   67: astore_3
    //   68: aload_0
    //   69: astore 4
    //   71: aload 5
    //   73: invokestatic 76	com/tencent/smtt/utils/b:a	(Ljava/lang/String;)Ljava/lang/String;
    //   76: astore 5
    //   78: goto +21 -> 99
    //   81: aload 6
    //   83: astore_2
    //   84: aload_1
    //   85: astore_3
    //   86: aload_0
    //   87: astore 4
    //   89: ldc 78
    //   91: invokestatic 83	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   94: astore 5
    //   96: goto -33 -> 63
    //   99: aload 5
    //   101: invokestatic 88	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   104: ifeq +8 -> 112
    //   107: aload 5
    //   109: putstatic 90	com/tencent/smtt/utils/b:c	Ljava/lang/String;
    //   112: aload_1
    //   113: invokevirtual 93	java/io/BufferedReader:close	()V
    //   116: aload_0
    //   117: invokevirtual 94	java/io/InputStreamReader:close	()V
    //   120: goto +94 -> 214
    //   123: astore 5
    //   125: goto +30 -> 155
    //   128: astore_1
    //   129: aconst_null
    //   130: astore_3
    //   131: goto +94 -> 225
    //   134: astore 5
    //   136: aconst_null
    //   137: astore_1
    //   138: goto +17 -> 155
    //   141: astore_1
    //   142: aconst_null
    //   143: astore_3
    //   144: aload_3
    //   145: astore_0
    //   146: goto +79 -> 225
    //   149: astore 5
    //   151: aconst_null
    //   152: astore_1
    //   153: aload_1
    //   154: astore_0
    //   155: aload 6
    //   157: astore_2
    //   158: aload_1
    //   159: astore_3
    //   160: aload_0
    //   161: astore 4
    //   163: ldc 78
    //   165: invokestatic 83	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   168: invokestatic 76	com/tencent/smtt/utils/b:a	(Ljava/lang/String;)Ljava/lang/String;
    //   171: astore 6
    //   173: aload 6
    //   175: astore_2
    //   176: aload_1
    //   177: astore_3
    //   178: aload_0
    //   179: astore 4
    //   181: aload 5
    //   183: invokevirtual 97	java/lang/Throwable:printStackTrace	()V
    //   186: aload 6
    //   188: invokestatic 88	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   191: ifeq +8 -> 199
    //   194: aload 6
    //   196: putstatic 90	com/tencent/smtt/utils/b:c	Ljava/lang/String;
    //   199: aload_1
    //   200: ifnull +7 -> 207
    //   203: aload_1
    //   204: invokevirtual 93	java/io/BufferedReader:close	()V
    //   207: aload_0
    //   208: ifnull +6 -> 214
    //   211: goto -95 -> 116
    //   214: iconst_1
    //   215: putstatic 31	com/tencent/smtt/utils/b:j	Z
    //   218: goto +36 -> 254
    //   221: astore_1
    //   222: aload 4
    //   224: astore_0
    //   225: aload_2
    //   226: invokestatic 88	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   229: ifeq +7 -> 236
    //   232: aload_2
    //   233: putstatic 90	com/tencent/smtt/utils/b:c	Ljava/lang/String;
    //   236: aload_3
    //   237: ifnull +7 -> 244
    //   240: aload_3
    //   241: invokevirtual 93	java/io/BufferedReader:close	()V
    //   244: aload_0
    //   245: ifnull +7 -> 252
    //   248: aload_0
    //   249: invokevirtual 94	java/io/InputStreamReader:close	()V
    //   252: aload_1
    //   253: athrow
    //   254: getstatic 90	com/tencent/smtt/utils/b:c	Ljava/lang/String;
    //   257: areturn
    //   258: astore_1
    //   259: goto -143 -> 116
    //   262: astore_0
    //   263: goto -49 -> 214
    //   266: astore_1
    //   267: goto -60 -> 207
    //   270: astore_2
    //   271: goto -27 -> 244
    //   274: astore_0
    //   275: goto -23 -> 252
    // Local variable table:
    //   start	length	slot	name	signature
    //   29	220	0	localObject1	Object
    //   262	1	0	localIOException1	java.io.IOException
    //   274	1	0	localIOException2	java.io.IOException
    //   38	75	1	localBufferedReader	java.io.BufferedReader
    //   128	1	1	localObject2	Object
    //   137	1	1	localObject3	Object
    //   141	1	1	localObject4	Object
    //   152	52	1	localObject5	Object
    //   221	32	1	localObject6	Object
    //   258	1	1	localIOException3	java.io.IOException
    //   266	1	1	localIOException4	java.io.IOException
    //   7	226	2	localObject7	Object
    //   270	1	2	localIOException5	java.io.IOException
    //   43	198	3	localObject8	Object
    //   45	178	4	localObject9	Object
    //   61	47	5	str1	String
    //   123	1	5	localThrowable1	Throwable
    //   134	1	5	localThrowable2	Throwable
    //   149	33	5	localThrowable3	Throwable
    //   9	186	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   47	59	123	java/lang/Throwable
    //   71	78	123	java/lang/Throwable
    //   89	96	123	java/lang/Throwable
    //   30	39	128	finally
    //   30	39	134	java/lang/Throwable
    //   11	30	141	finally
    //   11	30	149	java/lang/Throwable
    //   47	59	221	finally
    //   71	78	221	finally
    //   89	96	221	finally
    //   163	173	221	finally
    //   181	186	221	finally
    //   112	116	258	java/io/IOException
    //   116	120	262	java/io/IOException
    //   203	207	266	java/io/IOException
    //   240	244	270	java/io/IOException
    //   248	252	274	java/io/IOException
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
    //   5: invokevirtual 198	java/io/File:exists	()Z
    //   8: ifne +6 -> 14
    //   11: ldc 8
    //   13: areturn
    //   14: iload_1
    //   15: ifeq +132 -> 147
    //   18: iconst_2
    //   19: newarray byte
    //   21: astore 5
    //   23: new 200	java/io/RandomAccessFile
    //   26: dup
    //   27: aload_2
    //   28: ldc 202
    //   30: invokespecial 205	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   33: astore 4
    //   35: aload 4
    //   37: astore_3
    //   38: aload 4
    //   40: aload 5
    //   42: invokevirtual 209	java/io/RandomAccessFile:read	([B)I
    //   45: pop
    //   46: aload 4
    //   48: astore_3
    //   49: new 67	java/lang/String
    //   52: dup
    //   53: aload 5
    //   55: invokespecial 212	java/lang/String:<init>	([B)V
    //   58: ldc 214
    //   60: invokevirtual 218	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   63: istore_1
    //   64: iload_1
    //   65: ifne +19 -> 84
    //   68: aload 4
    //   70: invokevirtual 219	java/io/RandomAccessFile:close	()V
    //   73: ldc 8
    //   75: areturn
    //   76: astore_0
    //   77: aload_0
    //   78: invokevirtual 220	java/io/IOException:printStackTrace	()V
    //   81: ldc 8
    //   83: areturn
    //   84: aload 4
    //   86: invokevirtual 219	java/io/RandomAccessFile:close	()V
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
    //   113: invokevirtual 221	java/lang/Exception:printStackTrace	()V
    //   116: aload 4
    //   118: invokevirtual 219	java/io/RandomAccessFile:close	()V
    //   121: goto +26 -> 147
    //   124: astore_3
    //   125: aload_3
    //   126: invokevirtual 220	java/io/IOException:printStackTrace	()V
    //   129: goto +18 -> 147
    //   132: astore_0
    //   133: aload_3
    //   134: invokevirtual 219	java/io/RandomAccessFile:close	()V
    //   137: goto +8 -> 145
    //   140: astore_2
    //   141: aload_2
    //   142: invokevirtual 220	java/io/IOException:printStackTrace	()V
    //   145: aload_0
    //   146: athrow
    //   147: aload_0
    //   148: invokevirtual 225	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   151: invokevirtual 105	android/content/Context:getPackageName	()Ljava/lang/String;
    //   154: ldc 227
    //   156: invokevirtual 71	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   159: ifeq +35 -> 194
    //   162: ldc 129
    //   164: ldc 229
    //   166: invokestatic 162	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   169: aload_2
    //   170: invokestatic 232	com/tencent/smtt/utils/b:a	(Ljava/io/File;)Ljava/lang/String;
    //   173: astore_3
    //   174: aload_3
    //   175: ifnull +19 -> 194
    //   178: ldc 129
    //   180: ldc 234
    //   182: invokestatic 162	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   185: aload_3
    //   186: areturn
    //   187: ldc 129
    //   189: ldc 236
    //   191: invokestatic 162	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   194: ldc 129
    //   196: ldc 238
    //   198: invokestatic 162	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   201: aload_0
    //   202: aload_2
    //   203: invokestatic 240	com/tencent/smtt/utils/b:a	(Landroid/content/Context;Ljava/io/File;)Ljava/lang/String;
    //   206: astore_3
    //   207: new 144	java/lang/StringBuilder
    //   210: dup
    //   211: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   214: astore_0
    //   215: aload_0
    //   216: ldc 242
    //   218: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: pop
    //   222: aload_0
    //   223: aload_3
    //   224: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: pop
    //   228: ldc 129
    //   230: aload_0
    //   231: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   234: invokestatic 162	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   237: aload_3
    //   238: astore_0
    //   239: aload_3
    //   240: ifnonnull +38 -> 278
    //   243: aload_2
    //   244: invokestatic 232	com/tencent/smtt/utils/b:a	(Ljava/io/File;)Ljava/lang/String;
    //   247: astore_0
    //   248: new 144	java/lang/StringBuilder
    //   251: dup
    //   252: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   255: astore_2
    //   256: aload_2
    //   257: ldc 244
    //   259: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: pop
    //   263: aload_2
    //   264: aload_0
    //   265: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: ldc 129
    //   271: aload_2
    //   272: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   275: invokestatic 162	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
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
    int i1 = paramArrayOfByte.length;
    char[] arrayOfChar = new char[i1 * 2];
    int m = 0;
    while (m < i1)
    {
      int i3 = paramArrayOfByte[m];
      int n = i3 >> 4 & 0xF;
      int i2 = m * 2;
      if (n >= 10) {
        n = n + 97 - 10;
      } else {
        n += 48;
      }
      arrayOfChar[i2] = ((char)n);
      n = i3 & 0xF;
      if (n >= 10) {
        n = n + 97 - 10;
      } else {
        n += 48;
      }
      arrayOfChar[(i2 + 1)] = ((char)n);
      m += 1;
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
  
  public static boolean b()
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
  
  public static String c(Context paramContext)
  {
    if (!l) {
      paramContext = q.d(paramContext);
    }
    try
    {
      f = new String(paramContext.getBytes("UTF-8"), "ISO8859-1");
    }
    catch (Exception localException)
    {
      label34:
      break label34;
    }
    f = paramContext;
    l = true;
    return f;
  }
  
  public static String d(Context paramContext)
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
  
  public static int e(Context paramContext)
  {
    try
    {
      String str = paramContext.getPackageName();
      int m = paramContext.getPackageManager().getPackageInfo(str, 0).versionCode;
      return m;
    }
    catch (Exception paramContext) {}
    return 0;
  }
  
  public static String f(Context paramContext)
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
  
  public static boolean g(Context paramContext)
  {
    boolean bool1 = false;
    try
    {
      boolean bool2 = paramContext.getSharedPreferences("sai", 0).getBoolean("gi", false);
      bool1 = bool2;
      localStringBuilder = new StringBuilder();
      bool1 = bool2;
      localStringBuilder.append("getImeiEnable is ");
      bool1 = bool2;
      localStringBuilder.append(bool2);
      bool1 = bool2;
      Log.d("AppUtil", localStringBuilder.toString());
      bool1 = bool2;
      localStringBuilder = new StringBuilder();
      bool1 = bool2;
      localStringBuilder.append("getImeiEnable is ");
      bool1 = bool2;
      localStringBuilder.append(bool2);
      bool1 = bool2;
      TbsLog.i("AppUtil", localStringBuilder.toString());
      bool1 = bool2;
      c.a().a(paramContext, Integer.valueOf(1001), new b.1(paramContext));
      return bool2;
    }
    catch (Throwable paramContext)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("stack is ");
      localStringBuilder.append(Log.getStackTraceString(paramContext));
      TbsLog.i("AppUtil", localStringBuilder.toString());
    }
    return bool1;
  }
  
  public static String h(Context paramContext)
  {
    if (!QbSdk.isEnableSensitiveApi())
    {
      TbsLog.i("AppUtil", "getImei isEnableSensitiveApi = false");
      return "";
    }
    if (!h)
    {
      try
      {
        a = l(paramContext);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" getDeviceID is ");
        localStringBuilder.append(a);
        Log.d("AppUtil", localStringBuilder.toString());
        if (TextUtils.isEmpty(a))
        {
          a = j.a(paramContext);
          paramContext = new StringBuilder();
          paramContext.append(" getSDKUID is ");
          paramContext.append(a);
          Log.d("AppUtil", paramContext.toString());
        }
      }
      catch (Exception paramContext)
      {
        TbsLog.i(paramContext);
      }
      h = true;
    }
    return a;
  }
  
  public static String i(Context paramContext)
  {
    if (!QbSdk.isEnableSensitiveApi()) {}
    for (paramContext = "getImsi isEnableSensitiveApi = false";; paramContext = "getImsi isEnableCanGetSubscriberId is false")
    {
      TbsLog.i("AppUtil", paramContext);
      return "";
      if (QbSdk.isEnableCanGetSubscriberId()) {
        break;
      }
    }
    if (!i)
    {
      try
      {
        b = PhoneInfoMonitor.getSubscriberId((TelephonyManager)paramContext.getSystemService("phone"));
      }
      catch (Exception paramContext)
      {
        TbsLog.i(paramContext);
      }
      i = true;
    }
    return b;
  }
  
  public static String j(Context paramContext)
  {
    return "02:00:00:00:00:00";
  }
  
  public static String k(Context paramContext)
  {
    if (!QbSdk.isEnableSensitiveApi()) {}
    for (paramContext = "getAndroidID isEnableSensitiveApi = false";; paramContext = "getAndroidID isEnableGetAndroidID is false")
    {
      TbsLog.i("AppUtil", paramContext);
      return "";
      if (QbSdk.isEnableGetAndroidID()) {
        break;
      }
    }
    if (!k)
    {
      try
      {
        e = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
      k = true;
    }
    return e;
  }
  
  private static String l(Context paramContext)
  {
    try
    {
      boolean bool = QbSdk.isEnableGetDeviceID();
      if (!bool)
      {
        TbsLog.i("AppUtil", "getDeviceID isEnableGetDeviceID is false");
        return "";
      }
      if (!m(paramContext))
      {
        TbsLog.i("AppUtil", "getDeviceID isDeviceIDEnable is false");
        return "";
      }
      g = PhoneInfoMonitor.getDeviceId((TelephonyManager)paramContext.getSystemService("phone"));
    }
    catch (Exception paramContext)
    {
      TbsLog.i(paramContext);
    }
    return g;
  }
  
  private static boolean m(Context paramContext)
  {
    boolean bool1 = true;
    try
    {
      boolean bool2 = paramContext.getSharedPreferences("sai", 0).getBoolean("pdi", true);
      bool1 = bool2;
      localStringBuilder = new StringBuilder();
      bool1 = bool2;
      localStringBuilder.append("isDeviceIDEnable is ");
      bool1 = bool2;
      localStringBuilder.append(bool2);
      bool1 = bool2;
      Log.d("AppUtil", localStringBuilder.toString());
      bool1 = bool2;
      localStringBuilder = new StringBuilder();
      bool1 = bool2;
      localStringBuilder.append("isDeviceIDEnable is ");
      bool1 = bool2;
      localStringBuilder.append(bool2);
      bool1 = bool2;
      TbsLog.i("AppUtil", localStringBuilder.toString());
      bool1 = bool2;
      c.a().a(paramContext, Integer.valueOf(1004), new b.2(paramContext));
      return bool2;
    }
    catch (Throwable paramContext)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("stack is ");
      localStringBuilder.append(Log.getStackTraceString(paramContext));
      TbsLog.i("AppUtil", localStringBuilder.toString());
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.utils.b
 * JD-Core Version:    0.7.0.1
 */