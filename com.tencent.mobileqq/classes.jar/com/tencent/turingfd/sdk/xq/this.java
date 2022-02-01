package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.Proxy;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.SparseArray;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.InflaterInputStream;

public class this
{
  public static Context od;
  
  public static int a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (paramBoolean) {
      return 1 << paramInt2 | paramInt1;
    }
    return 0 << paramInt2 | paramInt1;
  }
  
  public static int a(byte[] paramArrayOfByte, int paramInt, char paramChar)
  {
    paramInt -= 1;
    for (;;)
    {
      int i = paramInt + 1;
      if (paramInt < paramArrayOfByte.length)
      {
        if ((i == paramArrayOfByte.length) || (paramArrayOfByte[i] == paramChar)) {
          return i;
        }
      }
      else {
        return 0;
      }
      paramInt = i;
    }
  }
  
  public static case a(case paramcase, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {}
    for (;;)
    {
      return paramcase;
      paramArrayOfByte = a(paramArrayOfByte, e());
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
      {
        Object localObject1 = new ByteArrayInputStream(paramArrayOfByte);
        Object localObject2 = new InflaterInputStream((InputStream)localObject1);
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        try
        {
          for (;;)
          {
            int i = ((InflaterInputStream)localObject2).read();
            if (i == -1) {
              break;
            }
            localByteArrayOutputStream.write(i);
          }
        }
        catch (Exception paramArrayOfByte)
        {
          for (;;)
          {
            try
            {
              ((ByteArrayInputStream)localObject1).close();
              ((InflaterInputStream)localObject2).close();
              localByteArrayOutputStream.close();
              paramArrayOfByte = null;
            }
            catch (IOException paramArrayOfByte)
            {
              paramArrayOfByte.printStackTrace();
              paramArrayOfByte = null;
              continue;
            }
            if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
              break;
            }
            localObject1 = new private();
            if (paramArrayOfByte.length < 4) {
              break label294;
            }
            try
            {
              paramArrayOfByte = new try(paramArrayOfByte, 4);
              paramArrayOfByte.b(((private)localObject1).ag);
              ((private)localObject1).bg.a(paramArrayOfByte);
              paramArrayOfByte.wrap(((private)localObject1).bg.t);
              if (private._f == null)
              {
                private._f = new HashMap();
                localObject2 = private._f;
                ((HashMap)localObject2).put("", new byte[0]);
              }
              ((private)localObject1).cg = paramArrayOfByte.a(private._f, 0, false);
              try
              {
                paramArrayOfByte = (case)((private)localObject1).a("resp", paramcase);
                paramcase = paramArrayOfByte;
              }
              catch (Throwable paramArrayOfByte)
              {
                continue;
              }
              return paramcase;
            }
            catch (Exception paramcase)
            {
              throw new RuntimeException(paramcase);
            }
            paramArrayOfByte = localByteArrayOutputStream.toByteArray();
            try
            {
              ((ByteArrayInputStream)localObject1).close();
              ((InflaterInputStream)localObject2).close();
              localByteArrayOutputStream.close();
            }
            catch (IOException localIOException)
            {
              localIOException.printStackTrace();
            }
          }
        }
        finally
        {
          try
          {
            localIOException.close();
            ((InflaterInputStream)localObject2).close();
            localByteArrayOutputStream.close();
            throw paramcase;
          }
          catch (IOException paramArrayOfByte)
          {
            for (;;)
            {
              paramArrayOfByte.printStackTrace();
            }
          }
        }
      }
    }
    label294:
    throw new IllegalArgumentException("decode package must include size head");
  }
  
  public static <E> E a(SparseArray<Object> paramSparseArray, int paramInt, Class<E> paramClass)
  {
    if (paramSparseArray == null) {}
    do
    {
      return null;
      paramSparseArray = paramSparseArray.get(paramInt);
    } while (!paramClass.isInstance(paramSparseArray));
    return paramClass.cast(paramSparseArray);
  }
  
  /* Error */
  public static String a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: invokevirtual 155	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   6: invokevirtual 159	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   9: astore_0
    //   10: aload_0
    //   11: ifnull +26 -> 37
    //   14: aload_0
    //   15: aload_1
    //   16: iconst_0
    //   17: invokevirtual 165	android/content/pm/PackageManager:getPackageArchiveInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   20: astore_0
    //   21: aload_0
    //   22: ifnull +15 -> 37
    //   25: aload_0
    //   26: getfield 170	android/content/pm/PackageInfo:packageName	Ljava/lang/String;
    //   29: astore_0
    //   30: aload_0
    //   31: ifnull +11 -> 42
    //   34: aload_0
    //   35: areturn
    //   36: astore_0
    //   37: aconst_null
    //   38: astore_0
    //   39: goto -9 -> 30
    //   42: new 172	java/util/zip/ZipFile
    //   45: dup
    //   46: aload_1
    //   47: invokespecial 173	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   50: astore_3
    //   51: aload_3
    //   52: aload_3
    //   53: ldc 175
    //   55: invokevirtual 179	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   58: invokevirtual 183	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   61: astore_1
    //   62: new 185	com/tencent/turingfd/sdk/xq/static
    //   65: dup
    //   66: invokespecial 186	com/tencent/turingfd/sdk/xq/static:<init>	()V
    //   69: aload_1
    //   70: invokevirtual 189	com/tencent/turingfd/sdk/xq/static:a	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   73: invokeinterface 195 1 0
    //   78: iconst_0
    //   79: invokeinterface 201 2 0
    //   84: invokeinterface 207 1 0
    //   89: astore_2
    //   90: aload_2
    //   91: ldc 209
    //   93: invokeinterface 215 2 0
    //   98: invokeinterface 219 1 0
    //   103: astore_2
    //   104: aload_1
    //   105: invokestatic 222	com/tencent/turingfd/sdk/xq/this:a	(Ljava/io/Closeable;)V
    //   108: invokestatic 225	com/tencent/turingfd/sdk/xq/this:d	()I
    //   111: bipush 19
    //   113: if_icmplt +12 -> 125
    //   116: aload_3
    //   117: invokestatic 222	com/tencent/turingfd/sdk/xq/this:a	(Ljava/io/Closeable;)V
    //   120: aload_2
    //   121: astore_0
    //   122: goto +107 -> 229
    //   125: aload_3
    //   126: invokevirtual 226	java/util/zip/ZipFile:close	()V
    //   129: aload_2
    //   130: astore_0
    //   131: goto +98 -> 229
    //   134: astore_0
    //   135: aload_2
    //   136: astore_0
    //   137: goto +92 -> 229
    //   140: astore_2
    //   141: aload_1
    //   142: invokestatic 222	com/tencent/turingfd/sdk/xq/this:a	(Ljava/io/Closeable;)V
    //   145: invokestatic 225	com/tencent/turingfd/sdk/xq/this:d	()I
    //   148: bipush 19
    //   150: if_icmplt +58 -> 208
    //   153: aload_3
    //   154: invokestatic 222	com/tencent/turingfd/sdk/xq/this:a	(Ljava/io/Closeable;)V
    //   157: goto +72 -> 229
    //   160: astore_0
    //   161: aconst_null
    //   162: astore_1
    //   163: aload_1
    //   164: invokestatic 222	com/tencent/turingfd/sdk/xq/this:a	(Ljava/io/Closeable;)V
    //   167: invokestatic 225	com/tencent/turingfd/sdk/xq/this:d	()I
    //   170: bipush 19
    //   172: if_icmplt +17 -> 189
    //   175: aload_3
    //   176: invokestatic 222	com/tencent/turingfd/sdk/xq/this:a	(Ljava/io/Closeable;)V
    //   179: aload_0
    //   180: athrow
    //   181: astore_0
    //   182: aconst_null
    //   183: astore_1
    //   184: aconst_null
    //   185: astore_3
    //   186: goto -23 -> 163
    //   189: aload_3
    //   190: invokevirtual 226	java/util/zip/ZipFile:close	()V
    //   193: goto -14 -> 179
    //   196: astore_1
    //   197: goto -18 -> 179
    //   200: astore_1
    //   201: aconst_null
    //   202: astore_3
    //   203: aload_2
    //   204: astore_1
    //   205: goto -64 -> 141
    //   208: aload_3
    //   209: invokevirtual 226	java/util/zip/ZipFile:close	()V
    //   212: goto -55 -> 157
    //   215: astore_1
    //   216: goto -59 -> 157
    //   219: astore_1
    //   220: aload_2
    //   221: astore_1
    //   222: goto -81 -> 141
    //   225: astore_0
    //   226: goto -63 -> 163
    //   229: aload_0
    //   230: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	231	0	paramContext	Context
    //   0	231	1	paramString	String
    //   1	135	2	localObject	Object
    //   140	81	2	localThrowable	Throwable
    //   50	159	3	localZipFile	java.util.zip.ZipFile
    // Exception table:
    //   from	to	target	type
    //   2	10	36	java/lang/Throwable
    //   14	21	36	java/lang/Throwable
    //   25	30	36	java/lang/Throwable
    //   108	120	134	java/lang/Throwable
    //   125	129	134	java/lang/Throwable
    //   62	90	140	java/lang/Throwable
    //   90	104	140	java/lang/Throwable
    //   51	62	160	finally
    //   42	51	181	finally
    //   167	179	196	java/lang/Throwable
    //   189	193	196	java/lang/Throwable
    //   42	51	200	java/lang/Throwable
    //   145	157	215	java/lang/Throwable
    //   208	212	215	java/lang/Throwable
    //   51	62	219	java/lang/Throwable
    //   62	90	225	finally
    //   90	104	225	finally
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if (paramString1 == null) {}
    label217:
    for (;;)
    {
      return null;
      int i = paramString1.indexOf('/');
      if (i != -1)
      {
        paramString1 = paramString1.substring(i).trim();
        if (paramString1.startsWith("/data/"))
        {
          String str = "/data/data/" + paramString2 + "/";
          if ((!paramString1.startsWith(str)) && (!paramString1.startsWith("/data/app/" + paramString2)) && (!Pattern.compile("^/data/user/\\d+/" + paramString2).matcher(paramString1).find()))
          {
            boolean bool = paramString1.endsWith(".so");
            if ((!bool) && (paramString1.endsWith(".jar"))) {}
            for (i = 1;; i = 0)
            {
              if ((!bool) && (i == 0)) {
                break label217;
              }
              if (bool)
              {
                paramString2 = extends.c(new File(str + "lib"));
                if ((paramString2 == null) || (paramString1.startsWith(paramString2))) {
                  break;
                }
              }
              return paramString1;
            }
          }
        }
      }
    }
  }
  
  /* Error */
  public static String a(boolean paramBoolean)
  {
    // Byte code:
    //   0: new 301	java/io/FileInputStream
    //   3: dup
    //   4: ldc_w 303
    //   7: invokespecial 304	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   10: astore_2
    //   11: new 306	java/io/BufferedReader
    //   14: dup
    //   15: new 308	java/io/InputStreamReader
    //   18: dup
    //   19: aload_2
    //   20: invokespecial 309	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   23: sipush 8192
    //   26: invokespecial 312	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   29: astore_3
    //   30: new 248	java/lang/StringBuilder
    //   33: dup
    //   34: ldc 94
    //   36: invokespecial 313	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   39: astore_1
    //   40: aload_3
    //   41: invokevirtual 316	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   44: astore 4
    //   46: aload 4
    //   48: ifnull +34 -> 82
    //   51: aload_1
    //   52: aload 4
    //   54: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: goto -18 -> 40
    //   61: astore 4
    //   63: aload_3
    //   64: invokevirtual 317	java/io/BufferedReader:close	()V
    //   67: aload_2
    //   68: invokevirtual 318	java/io/FileInputStream:close	()V
    //   71: aload_1
    //   72: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: astore_1
    //   76: iload_0
    //   77: ifne +38 -> 115
    //   80: aload_1
    //   81: areturn
    //   82: aload_3
    //   83: invokevirtual 317	java/io/BufferedReader:close	()V
    //   86: aload_2
    //   87: invokevirtual 318	java/io/FileInputStream:close	()V
    //   90: goto -19 -> 71
    //   93: astore_2
    //   94: goto -23 -> 71
    //   97: astore 4
    //   99: aload_3
    //   100: invokevirtual 317	java/io/BufferedReader:close	()V
    //   103: aload_2
    //   104: invokevirtual 318	java/io/FileInputStream:close	()V
    //   107: aload_1
    //   108: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: pop
    //   112: aload 4
    //   114: athrow
    //   115: aload_1
    //   116: ifnull +43 -> 159
    //   119: aload_1
    //   120: ldc 94
    //   122: invokevirtual 321	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   125: ifne +34 -> 159
    //   128: aload_1
    //   129: aload_1
    //   130: ldc_w 323
    //   133: invokevirtual 325	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   136: bipush 8
    //   138: iadd
    //   139: invokevirtual 237	java/lang/String:substring	(I)Ljava/lang/String;
    //   142: astore_1
    //   143: aload_1
    //   144: iconst_0
    //   145: aload_1
    //   146: ldc_w 327
    //   149: invokevirtual 325	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   152: invokevirtual 330	java/lang/String:substring	(II)Ljava/lang/String;
    //   155: astore_1
    //   156: aload_1
    //   157: areturn
    //   158: astore_1
    //   159: ldc 94
    //   161: areturn
    //   162: astore_1
    //   163: ldc 94
    //   165: areturn
    //   166: astore_3
    //   167: goto -81 -> 86
    //   170: astore_3
    //   171: goto -68 -> 103
    //   174: astore_2
    //   175: goto -68 -> 107
    //   178: astore_3
    //   179: goto -112 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	paramBoolean	boolean
    //   39	118	1	localObject1	Object
    //   158	1	1	localThrowable1	Throwable
    //   162	1	1	localThrowable2	Throwable
    //   10	77	2	localFileInputStream	java.io.FileInputStream
    //   93	11	2	localThrowable3	Throwable
    //   174	1	2	localThrowable4	Throwable
    //   29	71	3	localBufferedReader	java.io.BufferedReader
    //   166	1	3	localThrowable5	Throwable
    //   170	1	3	localThrowable6	Throwable
    //   178	1	3	localThrowable7	Throwable
    //   44	9	4	str	String
    //   61	1	4	localThrowable8	Throwable
    //   97	16	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   40	46	61	java/lang/Throwable
    //   51	58	61	java/lang/Throwable
    //   67	71	93	java/lang/Throwable
    //   86	90	93	java/lang/Throwable
    //   40	46	97	finally
    //   51	58	97	finally
    //   128	143	158	java/lang/Throwable
    //   143	156	158	java/lang/Throwable
    //   0	11	162	java/lang/Throwable
    //   82	86	166	java/lang/Throwable
    //   99	103	170	java/lang/Throwable
    //   103	107	174	java/lang/Throwable
    //   63	67	178	java/lang/Throwable
  }
  
  /* Error */
  public static List<String> a(File paramFile)
  {
    // Byte code:
    //   0: new 333	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 334	java/util/ArrayList:<init>	()V
    //   7: astore_3
    //   8: new 336	java/util/jar/JarFile
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 339	java/util/jar/JarFile:<init>	(Ljava/io/File;)V
    //   16: astore_0
    //   17: aload_0
    //   18: aload_0
    //   19: ldc 175
    //   21: invokevirtual 343	java/util/jar/JarFile:getJarEntry	(Ljava/lang/String;)Ljava/util/jar/JarEntry;
    //   24: sipush 8192
    //   27: newarray byte
    //   29: invokestatic 346	com/tencent/turingfd/sdk/xq/this:a	(Ljava/util/jar/JarFile;Ljava/util/jar/JarEntry;[B)[Ljava/security/cert/Certificate;
    //   32: astore 4
    //   34: aload 4
    //   36: ifnull +47 -> 83
    //   39: aload 4
    //   41: arraylength
    //   42: istore_2
    //   43: iconst_0
    //   44: istore_1
    //   45: iload_1
    //   46: iload_2
    //   47: if_icmpge +36 -> 83
    //   50: aload_3
    //   51: aload 4
    //   53: iload_1
    //   54: aaload
    //   55: invokevirtual 351	java/security/cert/Certificate:getEncoded	()[B
    //   58: invokestatic 354	com/tencent/turingfd/sdk/xq/this:e	([B)Ljava/lang/String;
    //   61: invokeinterface 359 2 0
    //   66: pop
    //   67: iload_1
    //   68: iconst_1
    //   69: iadd
    //   70: istore_1
    //   71: goto -26 -> 45
    //   74: astore_3
    //   75: aload_0
    //   76: invokevirtual 360	java/util/jar/JarFile:close	()V
    //   79: aload_3
    //   80: athrow
    //   81: astore 4
    //   83: aload_0
    //   84: invokevirtual 360	java/util/jar/JarFile:close	()V
    //   87: aload_3
    //   88: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	paramFile	File
    //   44	27	1	i	int
    //   42	6	2	j	int
    //   7	44	3	localArrayList	java.util.ArrayList
    //   74	14	3	localList	List<String>
    //   32	20	4	arrayOfCertificate	java.security.cert.Certificate[]
    //   81	1	4	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   17	34	74	finally
    //   39	43	74	finally
    //   50	67	74	finally
    //   17	34	81	java/lang/Exception
    //   39	43	81	java/lang/Exception
    //   50	67	81	java/lang/Exception
  }
  
  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Throwable paramCloseable) {}
  }
  
  public static void a(byte[] paramArrayOfByte, int[] paramArrayOfInt)
  {
    int j = 0;
    int k = paramArrayOfByte.length;
    int i = 0;
    while (i < k >> 2)
    {
      int m = j + 1;
      paramArrayOfByte[j] &= 0xFF;
      int n = paramArrayOfInt[i];
      j = m + 1;
      paramArrayOfInt[i] = (n | (paramArrayOfByte[m] & 0xFF) << 8);
      n = paramArrayOfInt[i];
      m = j + 1;
      paramArrayOfInt[i] = (n | (paramArrayOfByte[j] & 0xFF) << 16);
      paramArrayOfInt[i] |= (paramArrayOfByte[m] & 0xFF) << 24;
      i += 1;
      j = m + 1;
    }
    if (j < paramArrayOfByte.length)
    {
      k = j + 1;
      paramArrayOfByte[j] &= 0xFF;
      j = 8;
      while (k < paramArrayOfByte.length)
      {
        paramArrayOfInt[i] |= (paramArrayOfByte[k] & 0xFF) << j;
        k += 1;
        j += 8;
      }
    }
  }
  
  public static void a(int[] paramArrayOfInt, int paramInt, byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length >> 2;
    int j = i;
    if (i > paramInt) {
      j = paramInt;
    }
    i = 0;
    int k = 0;
    while (i < j)
    {
      int m = k + 1;
      paramArrayOfByte[k] = ((byte)(paramArrayOfInt[i] & 0xFF));
      k = m + 1;
      paramArrayOfByte[m] = ((byte)(paramArrayOfInt[i] >>> 8 & 0xFF));
      m = k + 1;
      paramArrayOfByte[k] = ((byte)(paramArrayOfInt[i] >>> 16 & 0xFF));
      k = m + 1;
      paramArrayOfByte[m] = ((byte)(paramArrayOfInt[i] >>> 24 & 0xFF));
      i += 1;
    }
    if ((paramInt > j) && (k < paramArrayOfByte.length))
    {
      paramInt = k + 1;
      paramArrayOfByte[k] = ((byte)(paramArrayOfInt[i] & 0xFF));
      j = 8;
      while ((j <= 24) && (paramInt < paramArrayOfByte.length))
      {
        paramArrayOfByte[paramInt] = ((byte)(paramArrayOfInt[i] >>> j & 0xFF));
        j += 8;
        paramInt += 1;
      }
    }
  }
  
  public static byte[] a(SparseArray<Object> paramSparseArray)
  {
    byte[] arrayOfByte = (byte[])a(paramSparseArray, 1, [B.class);
    paramSparseArray = arrayOfByte;
    if (arrayOfByte == null) {
      paramSparseArray = new byte[0];
    }
    return paramSparseArray;
  }
  
  public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = f(paramArrayOfByte2);
    if ((paramArrayOfByte1 == null) || (arrayOfByte == null) || (paramArrayOfByte1.length == 0)) {
      return paramArrayOfByte1;
    }
    if ((paramArrayOfByte1.length % 4 != 0) || (paramArrayOfByte1.length < 8)) {
      return null;
    }
    paramArrayOfByte2 = new int[paramArrayOfByte1.length >>> 2];
    a(paramArrayOfByte1, paramArrayOfByte2);
    if (arrayOfByte.length % 4 == 0) {}
    for (int i = arrayOfByte.length >>> 2;; i = (arrayOfByte.length >>> 2) + 1)
    {
      j = i;
      if (i < 4) {
        j = 4;
      }
      paramArrayOfByte1 = new int[j];
      i = 0;
      while (i < j)
      {
        paramArrayOfByte1[i] = 0;
        i += 1;
      }
    }
    a(arrayOfByte, paramArrayOfByte1);
    int m = paramArrayOfByte2.length - 1;
    i = paramArrayOfByte2[m];
    i = paramArrayOfByte2[0];
    int j = (52 / (m + 1) + 6) * -1640531527;
    while (j != 0)
    {
      int n = j >>> 2 & 0x3;
      int k = m;
      while (k > 0)
      {
        i1 = paramArrayOfByte2[(k - 1)];
        i = paramArrayOfByte2[k] - ((i ^ j) + (i1 ^ paramArrayOfByte1[(k & 0x3 ^ n)]) ^ (i1 >>> 5 ^ i << 2) + (i >>> 3 ^ i1 << 4));
        paramArrayOfByte2[k] = i;
        k -= 1;
      }
      int i1 = paramArrayOfByte2[m];
      i = paramArrayOfByte2[0] - ((i ^ j) + (paramArrayOfByte1[(k & 0x3 ^ n)] ^ i1) ^ (i1 >>> 5 ^ i << 2) + (i >>> 3 ^ i1 << 4));
      paramArrayOfByte2[0] = i;
      j += 1640531527;
    }
    i = paramArrayOfByte2[(paramArrayOfByte2.length - 1)];
    if ((i < 0) || (i > paramArrayOfByte2.length - 1 << 2)) {
      return null;
    }
    paramArrayOfByte1 = new byte[i];
    a(paramArrayOfByte2, paramArrayOfByte2.length - 1, paramArrayOfByte1);
    return paramArrayOfByte1;
  }
  
  /* Error */
  public static java.security.cert.Certificate[] a(java.util.jar.JarFile paramJarFile, java.util.jar.JarEntry paramJarEntry, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_0
    //   6: aload_1
    //   7: invokevirtual 382	java/util/jar/JarFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   10: astore_0
    //   11: aload_0
    //   12: aload_2
    //   13: iconst_0
    //   14: aload_2
    //   15: arraylength
    //   16: invokevirtual 387	java/io/InputStream:read	([BII)I
    //   19: iconst_m1
    //   20: if_icmpne -9 -> 11
    //   23: aload 4
    //   25: astore_2
    //   26: aload_1
    //   27: ifnull +8 -> 35
    //   30: aload_1
    //   31: invokevirtual 393	java/util/jar/JarEntry:getCertificates	()[Ljava/security/cert/Certificate;
    //   34: astore_2
    //   35: aload_0
    //   36: invokevirtual 394	java/io/InputStream:close	()V
    //   39: aload_2
    //   40: areturn
    //   41: astore_1
    //   42: aconst_null
    //   43: astore_0
    //   44: aload_0
    //   45: ifnull +7 -> 52
    //   48: aload_0
    //   49: invokevirtual 394	java/io/InputStream:close	()V
    //   52: aload_1
    //   53: athrow
    //   54: astore_0
    //   55: aconst_null
    //   56: astore_0
    //   57: aload_3
    //   58: astore_2
    //   59: aload_0
    //   60: ifnull -21 -> 39
    //   63: aload_0
    //   64: invokevirtual 394	java/io/InputStream:close	()V
    //   67: aconst_null
    //   68: areturn
    //   69: astore_0
    //   70: aconst_null
    //   71: areturn
    //   72: astore_0
    //   73: aload_2
    //   74: areturn
    //   75: astore_0
    //   76: goto -24 -> 52
    //   79: astore_1
    //   80: goto -23 -> 57
    //   83: astore_1
    //   84: goto -40 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	paramJarFile	java.util.jar.JarFile
    //   0	87	1	paramJarEntry	java.util.jar.JarEntry
    //   0	87	2	paramArrayOfByte	byte[]
    //   1	57	3	localObject1	Object
    //   3	21	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   5	11	41	finally
    //   5	11	54	java/io/IOException
    //   63	67	69	java/io/IOException
    //   35	39	72	java/io/IOException
    //   48	52	75	java/io/IOException
    //   11	23	79	java/io/IOException
    //   30	35	79	java/io/IOException
    //   11	23	83	finally
    //   30	35	83	finally
  }
  
  public static int b(SparseArray<Object> paramSparseArray)
  {
    paramSparseArray = (Integer)a(paramSparseArray, 0, Integer.class);
    if (paramSparseArray == null) {
      return -1;
    }
    return paramSparseArray.intValue();
  }
  
  public static String b(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer(paramArrayOfByte.length);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() < 2) {
        localStringBuffer.append(0);
      }
      localStringBuffer.append(str.toUpperCase(Locale.getDefault()));
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = f(paramArrayOfByte2);
    if ((paramArrayOfByte1 == null) || (arrayOfByte == null) || (paramArrayOfByte1.length == 0)) {
      return paramArrayOfByte1;
    }
    if (paramArrayOfByte1.length % 4 == 0)
    {
      i = (paramArrayOfByte1.length >>> 2) + 1;
      paramArrayOfByte2 = new int[i];
      a(paramArrayOfByte1, paramArrayOfByte2);
      paramArrayOfByte2[(i - 1)] = paramArrayOfByte1.length;
      if (arrayOfByte.length % 4 != 0) {
        break label107;
      }
    }
    label107:
    for (int i = arrayOfByte.length >>> 2;; i = (arrayOfByte.length >>> 2) + 1)
    {
      j = i;
      if (i < 4) {
        j = 4;
      }
      paramArrayOfByte1 = new int[j];
      i = 0;
      while (i < j)
      {
        paramArrayOfByte1[i] = 0;
        i += 1;
      }
      i = (paramArrayOfByte1.length >>> 2) + 2;
      break;
    }
    a(arrayOfByte, paramArrayOfByte1);
    int i1 = paramArrayOfByte2.length - 1;
    i = paramArrayOfByte2[i1];
    int j = paramArrayOfByte2[0];
    j = 52 / (i1 + 1) + 6;
    int m;
    for (int k = 0; j > 0; k = m)
    {
      m = k - 1640531527;
      int i2 = m >>> 2 & 0x3;
      int n = 0;
      k = i;
      for (i = n; i < i1; i = n)
      {
        n = i + 1;
        int i3 = paramArrayOfByte2[n];
        int i4 = paramArrayOfByte2[i];
        k = ((k ^ paramArrayOfByte1[(i & 0x3 ^ i2)]) + (i3 ^ m) ^ (k >>> 5 ^ i3 << 2) + (i3 >>> 3 ^ k << 4)) + i4;
        paramArrayOfByte2[i] = k;
      }
      n = paramArrayOfByte2[0];
      i = paramArrayOfByte2[i1] + ((paramArrayOfByte1[(i & 0x3 ^ i2)] ^ k) + (n ^ m) ^ (k >>> 5 ^ n << 2) + (n >>> 3 ^ k << 4));
      paramArrayOfByte2[i1] = i;
      j -= 1;
    }
    paramArrayOfByte1 = new byte[paramArrayOfByte2.length << 2];
    a(paramArrayOfByte2, paramArrayOfByte2.length, paramArrayOfByte1);
    return paramArrayOfByte1;
  }
  
  public static SparseArray<Object> c()
  {
    return new SparseArray();
  }
  
  public static String c(int paramInt)
  {
    String str = "";
    try
    {
      Object localObject = Locale.ENGLISH;
      localObject = extends.c(String.format((Locale)localObject, "/proc/%d/cmdline", new Object[] { Integer.valueOf(paramInt) }), 100);
      if (localObject != null) {
        str = new String((byte[])localObject, 0, a((byte[])localObject, 0, '\000'));
      }
      localObject = str;
      byte[] arrayOfByte;
      if (TextUtils.isEmpty(str))
      {
        localObject = Locale.ENGLISH;
        arrayOfByte = extends.c(String.format((Locale)localObject, "/proc/%d/status", new Object[] { Integer.valueOf(paramInt) }), 150);
        localObject = str;
        if (arrayOfByte != null)
        {
          paramInt = a(arrayOfByte, 7, '\n');
          if (paramInt != 0) {
            break label113;
          }
          localObject = "";
        }
      }
      return localObject;
      label113:
      str = new String(arrayOfByte, 6, paramInt - 6);
      return str;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return "";
  }
  
  public static String c(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public static boolean c(Context paramContext)
  {
    boolean bool2 = false;
    int i = Build.VERSION.SDK_INT;
    boolean bool1;
    if (i < 14) {
      if ((!TextUtils.isEmpty(Proxy.getHost(paramContext))) && (Proxy.getPort(paramContext) != -1)) {
        bool1 = true;
      }
    }
    for (;;)
    {
      return bool1;
      bool1 = false;
      continue;
      if ((!TextUtils.isEmpty(System.getProperty("http.proxyHost"))) && (!TextUtils.equals(System.getProperty("http.proxyPort"), "-1"))) {
        return true;
      }
      Object localObject2 = (WifiManager)paramContext.getApplicationContext().getSystemService("wifi");
      bool1 = bool2;
      if (paramContext.checkPermission("android.permission.ACCESS_WIFI_STATE", Process.myPid(), Process.myUid()) == 0) {
        try
        {
          Object localObject1 = ((WifiManager)localObject2).getConnectionInfo();
          bool1 = bool2;
          if (localObject1 != null)
          {
            bool1 = bool2;
            if (((WifiInfo)localObject1).getNetworkId() != -1)
            {
              try
              {
                paramContext = ((WifiManager)localObject2).getConfiguredNetworks();
                bool1 = bool2;
                if (paramContext == null) {
                  continue;
                }
                localObject1 = ((WifiInfo)localObject1).getSSID();
                paramContext = paramContext.iterator();
                do
                {
                  bool1 = bool2;
                  if (!paramContext.hasNext()) {
                    break;
                  }
                  localObject2 = (WifiConfiguration)paramContext.next();
                } while ((!TextUtils.equals(((WifiConfiguration)localObject2).SSID, (CharSequence)localObject1)) && (!TextUtils.equals(((WifiConfiguration)localObject2).SSID, "\"" + (String)localObject1 + "\"")));
                if (i < 21)
                {
                  paramContext = default.a(WifiConfiguration.class, "proxySettings", localObject2);
                  localObject1 = "android.net.wifi.WifiConfiguration$ProxySettings";
                  localObject2 = default.c((String)localObject1, "STATIC");
                  if ((localObject2 == null) || (localObject2 != paramContext)) {
                    break label297;
                  }
                  return true;
                }
              }
              catch (Throwable paramContext)
              {
                for (;;)
                {
                  paramContext = null;
                  continue;
                  paramContext = default.b(WifiConfiguration.class, "getProxySettings", localObject2);
                  localObject1 = "android.net.IpConfiguration$ProxySettings";
                }
                label297:
                bool1 = bool2;
              }
              if (i >= 19)
              {
                localObject1 = default.c((String)localObject1, "PAC");
                bool1 = bool2;
                if (localObject1 != null)
                {
                  bool1 = bool2;
                  if (localObject1 == paramContext) {
                    return true;
                  }
                }
              }
            }
          }
        }
        catch (Throwable paramContext) {}
      }
    }
    return false;
  }
  
  /* Error */
  public static byte[] c(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 37	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 40	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_1
    //   8: new 576	java/util/zip/DeflaterOutputStream
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 579	java/util/zip/DeflaterOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   16: astore_2
    //   17: aload_2
    //   18: aload_0
    //   19: invokevirtual 581	java/util/zip/DeflaterOutputStream:write	([B)V
    //   22: aload_2
    //   23: invokevirtual 584	java/util/zip/DeflaterOutputStream:finish	()V
    //   26: aload_1
    //   27: invokevirtual 114	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   30: astore_0
    //   31: aload_1
    //   32: invokevirtual 53	java/io/ByteArrayOutputStream:close	()V
    //   35: aload_2
    //   36: invokevirtual 585	java/util/zip/DeflaterOutputStream:close	()V
    //   39: aload_0
    //   40: areturn
    //   41: astore_1
    //   42: aload_1
    //   43: invokevirtual 117	java/io/IOException:printStackTrace	()V
    //   46: aload_0
    //   47: areturn
    //   48: astore_0
    //   49: aload_1
    //   50: invokevirtual 53	java/io/ByteArrayOutputStream:close	()V
    //   53: aload_2
    //   54: invokevirtual 585	java/util/zip/DeflaterOutputStream:close	()V
    //   57: aload_0
    //   58: athrow
    //   59: astore_1
    //   60: aload_1
    //   61: invokevirtual 117	java/io/IOException:printStackTrace	()V
    //   64: goto -7 -> 57
    //   67: astore_0
    //   68: aload_1
    //   69: invokevirtual 53	java/io/ByteArrayOutputStream:close	()V
    //   72: aload_2
    //   73: invokevirtual 585	java/util/zip/DeflaterOutputStream:close	()V
    //   76: aconst_null
    //   77: areturn
    //   78: astore_0
    //   79: aload_0
    //   80: invokevirtual 117	java/io/IOException:printStackTrace	()V
    //   83: aconst_null
    //   84: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	paramArrayOfByte	byte[]
    //   7	25	1	localByteArrayOutputStream	ByteArrayOutputStream
    //   41	9	1	localIOException1	IOException
    //   59	10	1	localIOException2	IOException
    //   16	57	2	localDeflaterOutputStream	java.util.zip.DeflaterOutputStream
    // Exception table:
    //   from	to	target	type
    //   31	39	41	java/io/IOException
    //   17	31	48	finally
    //   49	57	59	java/io/IOException
    //   17	31	67	java/lang/Exception
    //   68	76	78	java/io/IOException
  }
  
  public static int d()
  {
    try
    {
      int i = Integer.parseInt(Build.VERSION.SDK);
      return i;
    }
    catch (Throwable localThrowable) {}
    return 0;
  }
  
  public static package d(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        str1 = c(paramInt);
      }
      catch (Throwable localThrowable1)
      {
        String str1;
        Object localObject1;
        Object localObject2;
        String[] arrayOfString;
        int m;
        int k;
        String str2 = null;
        int j = -1;
        i = -1;
        continue;
        return new package(paramInt, i, str2, k, null, j);
      }
      try
      {
        localObject1 = Locale.ENGLISH;
        localObject2 = new String(extends.h(String.format((Locale)localObject1, "/proc/%d/status", new Object[] { Integer.valueOf(paramInt) })));
        localObject1 = new HashMap();
        localObject2 = ((String)localObject2).split("\n");
        j = localObject2.length;
        if (i >= j) {
          continue;
        }
        arrayOfString = localObject2[i];
        arrayOfString = arrayOfString.split(":");
        if (arrayOfString.length < 2) {
          break label253;
        }
        ((HashMap)localObject1).put(arrayOfString[0].trim(), arrayOfString[1].trim());
      }
      catch (Throwable localThrowable2)
      {
        i = -1;
        j = -1;
        m = -1;
        k = j;
        j = m;
        if (str1 == null) {
          continue;
        }
      }
      if ((i == -1) || (k == -1))
      {
        return null;
        i = Integer.parseInt((String)localThrowable2.get("PPid"));
        try
        {
          localObject2 = (String)localThrowable2.get("Uid");
          k = Integer.parseInt(localObject2.split("\\s+")[0]);
          try
          {
            j = Integer.parseInt((String)localThrowable2.get("TracerPid"));
          }
          catch (Throwable localThrowable3)
          {
            j = k;
          }
        }
        catch (Throwable localThrowable4)
        {
          j = -1;
        }
      }
      else
      {
        label253:
        i += 1;
      }
    }
  }
  
  public static String d(Context paramContext)
  {
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return "";
  }
  
  public static String d(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    return str;
  }
  
  public static byte[] d(byte[] paramArrayOfByte)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance(new String(f("4D4435")));
      localMessageDigest.update(paramArrayOfByte);
      paramArrayOfByte = localMessageDigest.digest();
      return paramArrayOfByte;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte) {}
    return null;
  }
  
  public static byte e(Context paramContext)
  {
    int i = 1;
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (localNetworkInfo != null)
      {
        if ((localNetworkInfo.getState() != NetworkInfo.State.CONNECTING) && (localNetworkInfo.getState() != NetworkInfo.State.CONNECTED)) {
          return -1;
        }
        if (localNetworkInfo.getType() == 1) {
          return 0;
        }
        if (localNetworkInfo.getType() == 0)
        {
          if (Proxy.getDefaultHost() == null)
          {
            paramContext = Proxy.getHost(paramContext);
            if (paramContext == null) {}
          }
          else
          {
            return 2;
          }
          return 1;
        }
      }
    }
    catch (Throwable paramContext)
    {
      paramContext = paramContext.getMessage();
      if ((paramContext != null) && (paramContext.contains("ACCESS_NETWORK_STATE"))) {}
      for (;;)
      {
        if (i != 0) {}
        for (byte b = 0;; b = -1) {
          return b;
        }
        i = 0;
      }
    }
    return -1;
  }
  
  public static String e(byte[] paramArrayOfByte)
  {
    return b(d(paramArrayOfByte));
  }
  
  public static byte[] e()
  {
    int i = 0;
    try
    {
      Object localObject = new StringBuffer();
      String str = const.get(const.df);
      while (i < str.length())
      {
        ((StringBuffer)localObject).append((char)(str.charAt(i) + new int[] { -36, -46, -45, -77, -22, -10, 47, -77, -72, -69, -32, 25, 21, -21, -6, -75, -71, 31, -39, -49, -49 }[i]));
        i += 1;
      }
      localObject = ((StringBuffer)localObject).toString();
      localObject = ((String)localObject).getBytes("UTF-8");
      return localObject;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
    return null;
  }
  
  public static byte[] e(String paramString)
  {
    int j = paramString.length() / 2;
    byte[] arrayOfByte = new byte[j];
    paramString = paramString.toUpperCase().toCharArray();
    int i = 0;
    while (i < j)
    {
      int k = i * 2;
      int m = (byte)"0123456789ABCDEF".indexOf(paramString[k]);
      arrayOfByte[i] = ((byte)((byte)"0123456789ABCDEF".indexOf(paramString[(k + 1)]) | m << 4));
      i += 1;
    }
    return arrayOfByte;
  }
  
  /* Error */
  public static boolean f(Context paramContext)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: getstatic 724	com/tencent/turingfd/sdk/xq/this:od	Landroid/content/Context;
    //   8: astore_2
    //   9: aload_2
    //   10: ifnull +8 -> 18
    //   13: ldc 2
    //   15: monitorexit
    //   16: iload_1
    //   17: ireturn
    //   18: aload_0
    //   19: ifnonnull +8 -> 27
    //   22: iconst_0
    //   23: istore_1
    //   24: goto -11 -> 13
    //   27: aload_0
    //   28: invokevirtual 155	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   31: astore_0
    //   32: aload_0
    //   33: ifnonnull +8 -> 41
    //   36: iconst_0
    //   37: istore_1
    //   38: goto -25 -> 13
    //   41: aload_0
    //   42: putstatic 724	com/tencent/turingfd/sdk/xq/this:od	Landroid/content/Context;
    //   45: goto -32 -> 13
    //   48: astore_0
    //   49: ldc 2
    //   51: monitorexit
    //   52: aload_0
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	paramContext	Context
    //   1	37	1	bool	boolean
    //   8	2	2	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   5	9	48	finally
    //   27	32	48	finally
    //   41	45	48	finally
  }
  
  public static byte[] f(String paramString)
  {
    int j = paramString.length() / 2;
    byte[] arrayOfByte = new byte[j];
    int i = 0;
    while (i < j)
    {
      int k = i * 2;
      arrayOfByte[i] = Integer.valueOf(paramString.substring(k, k + 2), 16).byteValue();
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static byte[] f(byte[] paramArrayOfByte)
  {
    Object localObject = paramArrayOfByte;
    if (paramArrayOfByte != null)
    {
      localObject = paramArrayOfByte;
      if (paramArrayOfByte.length <= 16) {}
    }
    try
    {
      localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramArrayOfByte);
      localObject = ((MessageDigest)localObject).digest();
      return localObject;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte) {}
    return null;
  }
  
  public static Context get()
  {
    try
    {
      Context localContext = od;
      return localContext;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.this
 * JD-Core Version:    0.7.0.1
 */