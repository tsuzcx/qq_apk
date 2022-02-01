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

public class b
{
  public static String a = "";
  public static String b = "";
  public static String c = "";
  public static String d = "";
  public static String e = "";
  
  private static PackageInfo a(String paramString, int paramInt)
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
  
  private static String a(Context paramContext, File paramFile, boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      paramContext = a(paramFile.getAbsolutePath(), 65);
      if (paramContext != null) {
        if ((paramContext.signatures == null) || (paramContext.signatures.length <= 0)) {}
      }
      for (paramContext = paramContext.signatures[0];; paramContext = null)
      {
        if (paramContext == null) {
          break label108;
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
  public static String a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 138	android/content/Context:getPackageName	()Ljava/lang/String;
    //   4: astore_2
    //   5: aload_0
    //   6: invokevirtual 157	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   9: aload_2
    //   10: sipush 128
    //   13: invokevirtual 197	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   16: getfield 203	android/content/pm/ApplicationInfo:metaData	Landroid/os/Bundle;
    //   19: aload_1
    //   20: invokevirtual 209	android/os/Bundle:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   23: invokestatic 212	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   26: astore_0
    //   27: aload_0
    //   28: invokestatic 215	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   31: invokestatic 219	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   34: invokestatic 212	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
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
    //   5: invokevirtual 228	java/io/File:exists	()Z
    //   8: ifne +10 -> 18
    //   11: ldc 14
    //   13: astore 4
    //   15: aload 4
    //   17: areturn
    //   18: iload_1
    //   19: ifeq +72 -> 91
    //   22: iconst_2
    //   23: newarray byte
    //   25: astore 5
    //   27: new 230	java/io/RandomAccessFile
    //   30: dup
    //   31: aload_2
    //   32: ldc 232
    //   34: invokespecial 235	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   37: astore 4
    //   39: aload 4
    //   41: astore_3
    //   42: aload 4
    //   44: aload 5
    //   46: invokevirtual 239	java/io/RandomAccessFile:read	([B)I
    //   49: pop
    //   50: aload 4
    //   52: astore_3
    //   53: new 48	java/lang/String
    //   56: dup
    //   57: aload 5
    //   59: invokespecial 242	java/lang/String:<init>	([B)V
    //   62: ldc 244
    //   64: invokevirtual 248	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   67: ifne +19 -> 86
    //   70: aload 4
    //   72: invokevirtual 251	java/io/RandomAccessFile:close	()V
    //   75: ldc 14
    //   77: areturn
    //   78: astore_0
    //   79: aload_0
    //   80: invokevirtual 252	java/io/IOException:printStackTrace	()V
    //   83: ldc 14
    //   85: areturn
    //   86: aload 4
    //   88: invokevirtual 251	java/io/RandomAccessFile:close	()V
    //   91: aload_0
    //   92: invokevirtual 256	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   95: invokevirtual 138	android/content/Context:getPackageName	()Ljava/lang/String;
    //   98: ldc_w 258
    //   101: invokevirtual 262	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   104: ifeq +39 -> 143
    //   107: ldc 164
    //   109: ldc_w 264
    //   112: invokestatic 192	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   115: aload_2
    //   116: invokestatic 267	com/tencent/smtt/utils/b:a	(Ljava/io/File;)Ljava/lang/String;
    //   119: astore_3
    //   120: aload_3
    //   121: ifnull +22 -> 143
    //   124: ldc 164
    //   126: ldc_w 269
    //   129: invokestatic 192	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   132: aload_3
    //   133: areturn
    //   134: astore_3
    //   135: ldc 164
    //   137: ldc_w 271
    //   140: invokestatic 192	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   143: ldc 164
    //   145: ldc_w 273
    //   148: invokestatic 192	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   151: aload_0
    //   152: aload_2
    //   153: iconst_0
    //   154: invokestatic 275	com/tencent/smtt/utils/b:a	(Landroid/content/Context;Ljava/io/File;Z)Ljava/lang/String;
    //   157: astore 4
    //   159: ldc 164
    //   161: new 174	java/lang/StringBuilder
    //   164: dup
    //   165: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   168: ldc_w 277
    //   171: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: aload 4
    //   176: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: invokestatic 192	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   185: aload 4
    //   187: astore_3
    //   188: aload 4
    //   190: ifnonnull +33 -> 223
    //   193: aload_2
    //   194: invokestatic 267	com/tencent/smtt/utils/b:a	(Ljava/io/File;)Ljava/lang/String;
    //   197: astore_3
    //   198: ldc 164
    //   200: new 174	java/lang/StringBuilder
    //   203: dup
    //   204: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   207: ldc_w 279
    //   210: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: aload_3
    //   214: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: invokestatic 192	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   223: aload_3
    //   224: astore 4
    //   226: aload_3
    //   227: ifnonnull -212 -> 15
    //   230: aload_0
    //   231: aload_2
    //   232: iconst_1
    //   233: invokestatic 275	com/tencent/smtt/utils/b:a	(Landroid/content/Context;Ljava/io/File;Z)Ljava/lang/String;
    //   236: astore_0
    //   237: ldc 164
    //   239: new 174	java/lang/StringBuilder
    //   242: dup
    //   243: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   246: ldc_w 281
    //   249: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: aload_0
    //   253: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: invokestatic 192	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   262: aload_0
    //   263: areturn
    //   264: astore_3
    //   265: aload_3
    //   266: invokevirtual 252	java/io/IOException:printStackTrace	()V
    //   269: goto -178 -> 91
    //   272: astore 5
    //   274: aconst_null
    //   275: astore 4
    //   277: aload 4
    //   279: astore_3
    //   280: aload 5
    //   282: invokevirtual 116	java/lang/Exception:printStackTrace	()V
    //   285: aload 4
    //   287: invokevirtual 251	java/io/RandomAccessFile:close	()V
    //   290: goto -199 -> 91
    //   293: astore_3
    //   294: aload_3
    //   295: invokevirtual 252	java/io/IOException:printStackTrace	()V
    //   298: goto -207 -> 91
    //   301: astore_0
    //   302: aconst_null
    //   303: astore_3
    //   304: aload_3
    //   305: invokevirtual 251	java/io/RandomAccessFile:close	()V
    //   308: aload_0
    //   309: athrow
    //   310: astore_2
    //   311: aload_2
    //   312: invokevirtual 252	java/io/IOException:printStackTrace	()V
    //   315: goto -7 -> 308
    //   318: astore_0
    //   319: goto -15 -> 304
    //   322: astore 5
    //   324: goto -47 -> 277
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	327	0	paramContext	Context
    //   0	327	1	paramBoolean	boolean
    //   0	327	2	paramFile	File
    //   41	92	3	localObject1	Object
    //   134	1	3	localThrowable	Throwable
    //   187	40	3	localObject2	Object
    //   264	2	3	localIOException1	java.io.IOException
    //   279	1	3	localObject3	Object
    //   293	2	3	localIOException2	java.io.IOException
    //   303	2	3	localObject4	Object
    //   13	273	4	localObject5	Object
    //   25	33	5	arrayOfByte	byte[]
    //   272	9	5	localException1	Exception
    //   322	1	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   70	75	78	java/io/IOException
    //   91	120	134	java/lang/Throwable
    //   124	132	134	java/lang/Throwable
    //   86	91	264	java/io/IOException
    //   22	39	272	java/lang/Exception
    //   285	290	293	java/io/IOException
    //   22	39	301	finally
    //   304	308	310	java/io/IOException
    //   42	50	318	finally
    //   53	70	318	finally
    //   280	285	318	finally
    //   42	50	322	java/lang/Exception
    //   53	70	322	java/lang/Exception
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
    //   10: invokestatic 359	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifne +9 -> 22
    //   16: getstatic 20	com/tencent/smtt/utils/b:c	Ljava/lang/String;
    //   19: astore_2
    //   20: aload_2
    //   21: areturn
    //   22: new 361	java/io/InputStreamReader
    //   25: dup
    //   26: invokestatic 367	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   29: ldc_w 369
    //   32: invokevirtual 373	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   35: invokevirtual 378	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   38: invokespecial 381	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   41: astore_0
    //   42: aload_1
    //   43: astore_2
    //   44: aload_0
    //   45: astore_1
    //   46: new 383	java/io/BufferedReader
    //   49: dup
    //   50: aload_0
    //   51: invokespecial 386	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   54: astore_3
    //   55: aload_3
    //   56: invokevirtual 389	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   59: ldc_w 391
    //   62: invokevirtual 262	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   65: ifeq +33 -> 98
    //   68: ldc_w 393
    //   71: invokestatic 395	com/tencent/smtt/utils/b:a	(Ljava/lang/String;)Ljava/lang/String;
    //   74: astore_1
    //   75: aload_3
    //   76: ifnull +7 -> 83
    //   79: aload_3
    //   80: invokevirtual 396	java/io/BufferedReader:close	()V
    //   83: aload_1
    //   84: astore_2
    //   85: aload_0
    //   86: ifnull -66 -> 20
    //   89: aload_0
    //   90: invokevirtual 397	java/io/InputStreamReader:close	()V
    //   93: aload_1
    //   94: areturn
    //   95: astore_0
    //   96: aload_1
    //   97: areturn
    //   98: ldc_w 399
    //   101: invokestatic 404	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   104: invokestatic 395	com/tencent/smtt/utils/b:a	(Ljava/lang/String;)Ljava/lang/String;
    //   107: astore_1
    //   108: goto -33 -> 75
    //   111: astore_3
    //   112: aconst_null
    //   113: astore_0
    //   114: aload 4
    //   116: astore_2
    //   117: aload_0
    //   118: astore_1
    //   119: ldc_w 399
    //   122: invokestatic 404	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   125: invokestatic 395	com/tencent/smtt/utils/b:a	(Ljava/lang/String;)Ljava/lang/String;
    //   128: astore 5
    //   130: aload 4
    //   132: astore_2
    //   133: aload_0
    //   134: astore_1
    //   135: aload_3
    //   136: invokevirtual 405	java/lang/Throwable:printStackTrace	()V
    //   139: aload 4
    //   141: ifnull +8 -> 149
    //   144: aload 4
    //   146: invokevirtual 396	java/io/BufferedReader:close	()V
    //   149: aload 5
    //   151: astore_2
    //   152: aload_0
    //   153: ifnull -133 -> 20
    //   156: aload_0
    //   157: invokevirtual 397	java/io/InputStreamReader:close	()V
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
    //   175: invokevirtual 396	java/io/BufferedReader:close	()V
    //   178: aload_0
    //   179: ifnull +7 -> 186
    //   182: aload_0
    //   183: invokevirtual 397	java/io/InputStreamReader:close	()V
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
      paramContext.printStackTrace();
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
      paramContext.printStackTrace();
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
        paramContext.printStackTrace();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.smtt.utils.b
 * JD-Core Version:    0.7.0.1
 */