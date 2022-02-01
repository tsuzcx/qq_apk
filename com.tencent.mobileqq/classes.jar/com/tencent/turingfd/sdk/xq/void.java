package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.Proxy;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Process;
import android.text.TextUtils;
import android.util.SparseArray;
import java.io.Closeable;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class void
{
  public static Context td;
  
  public static int a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    int i;
    if (paramBoolean) {
      i = 1;
    } else {
      i = 0;
    }
    return paramInt1 | i << paramInt2;
  }
  
  public static int a(byte[] paramArrayOfByte, int paramInt, char paramChar)
  {
    paramInt -= 1;
    int i;
    for (;;)
    {
      i = paramInt + 1;
      if (paramInt >= paramArrayOfByte.length) {
        break label36;
      }
      if (i == paramArrayOfByte.length) {
        break;
      }
      if (paramArrayOfByte[i] == paramChar) {
        return i;
      }
      paramInt = i;
    }
    return i;
    label36:
    return 0;
  }
  
  public static case a(case paramcase, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length == 0) {
        return paramcase;
      }
      paramArrayOfByte = a(paramArrayOfByte, m());
      if (paramArrayOfByte != null)
      {
        if (paramArrayOfByte.length == 0) {
          return paramcase;
        }
        Object localObject = d(paramArrayOfByte);
        if (localObject != null)
        {
          if (localObject.length == 0) {
            return paramcase;
          }
          paramArrayOfByte = new volatile();
          if (localObject.length >= 4) {
            try
            {
              localObject = new try((byte[])localObject, 4);
              ((try)localObject).c(paramArrayOfByte.ug);
              paramArrayOfByte.vg.a((try)localObject);
              ((try)localObject).wrap(paramArrayOfByte.vg.C);
              if (volatile.tg == null)
              {
                volatile.tg = new HashMap();
                HashMap localHashMap = volatile.tg;
                localHashMap.put("", new byte[0]);
              }
              paramArrayOfByte.wg = ((try)localObject).a(volatile.tg, 0, false);
              throw new IllegalArgumentException("decode package must include size head");
            }
            catch (Exception paramcase)
            {
              try
              {
                paramArrayOfByte = (case)paramArrayOfByte.a("resp", paramcase);
                return paramArrayOfByte;
              }
              catch (Throwable paramArrayOfByte) {}
              paramcase = paramcase;
              throw new RuntimeException(paramcase);
            }
          }
        }
      }
    }
    return paramcase;
    return paramcase;
  }
  
  public static package a(Context paramContext, String paramString)
  {
    package localpackage = new package();
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 64);
      localpackage.versionName = paramContext.versionName;
      localpackage.versionCode = paramContext.versionCode;
      return localpackage;
    }
    catch (Throwable paramContext) {}
    return localpackage;
  }
  
  public static <E> E a(SparseArray<Object> paramSparseArray, int paramInt, Class<E> paramClass)
  {
    Object localObject1 = null;
    if (paramSparseArray == null) {
      return null;
    }
    Object localObject2 = paramSparseArray.get(paramInt);
    paramSparseArray = localObject1;
    if (paramClass.isInstance(localObject2)) {
      paramSparseArray = paramClass.cast(localObject2);
    }
    return paramSparseArray;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return null;
    }
    int i = paramString1.indexOf('/');
    if (i == -1) {
      return null;
    }
    paramString1 = paramString1.substring(i).trim();
    if (!paramString1.startsWith("/data/")) {
      return null;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("/data/data/");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append("/");
    localObject = ((StringBuilder)localObject).toString();
    if (paramString1.startsWith((String)localObject)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("/data/app/");
    localStringBuilder.append(paramString2);
    if (paramString1.startsWith(localStringBuilder.toString())) {
      return null;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("^/data/user/\\d+/");
    localStringBuilder.append(paramString2);
    if (Pattern.compile(localStringBuilder.toString()).matcher(paramString1).find()) {
      return null;
    }
    boolean bool = paramString1.endsWith(".so");
    if ((!bool) && (paramString1.endsWith(".jar"))) {
      i = 1;
    } else {
      i = 0;
    }
    if ((!bool) && (i == 0)) {
      return null;
    }
    if (bool)
    {
      paramString2 = new StringBuilder();
      paramString2.append((String)localObject);
      paramString2.append("lib");
      paramString2 = abstract.c(new File(paramString2.toString()));
      if ((paramString2 == null) || (paramString1.startsWith(paramString2))) {
        return null;
      }
    }
    return paramString1;
  }
  
  /* Error */
  public static List<String> a(File paramFile)
  {
    // Byte code:
    //   0: new 221	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 222	java/util/ArrayList:<init>	()V
    //   7: astore_3
    //   8: new 224	java/util/jar/JarFile
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 227	java/util/jar/JarFile:<init>	(Ljava/io/File;)V
    //   16: astore_0
    //   17: aload_0
    //   18: aload_0
    //   19: ldc 229
    //   21: invokevirtual 233	java/util/jar/JarFile:getJarEntry	(Ljava/lang/String;)Ljava/util/jar/JarEntry;
    //   24: sipush 8192
    //   27: newarray byte
    //   29: invokestatic 236	com/tencent/turingfd/sdk/xq/void:a	(Ljava/util/jar/JarFile;Ljava/util/jar/JarEntry;[B)[Ljava/security/cert/Certificate;
    //   32: astore 4
    //   34: aload 4
    //   36: ifnull +45 -> 81
    //   39: aload 4
    //   41: arraylength
    //   42: istore_2
    //   43: iconst_0
    //   44: istore_1
    //   45: iload_1
    //   46: iload_2
    //   47: if_icmpge +34 -> 81
    //   50: aload_3
    //   51: aload 4
    //   53: iload_1
    //   54: aaload
    //   55: invokevirtual 241	java/security/cert/Certificate:getEncoded	()[B
    //   58: invokestatic 245	com/tencent/turingfd/sdk/xq/void:f	([B)Ljava/lang/String;
    //   61: invokeinterface 250 2 0
    //   66: pop
    //   67: iload_1
    //   68: iconst_1
    //   69: iadd
    //   70: istore_1
    //   71: goto -26 -> 45
    //   74: astore_3
    //   75: aload_0
    //   76: invokevirtual 253	java/util/jar/JarFile:close	()V
    //   79: aload_3
    //   80: athrow
    //   81: aload_0
    //   82: invokevirtual 253	java/util/jar/JarFile:close	()V
    //   85: aload_3
    //   86: areturn
    //   87: astore 4
    //   89: goto -8 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	paramFile	File
    //   44	27	1	i	int
    //   42	6	2	j	int
    //   7	44	3	localArrayList	ArrayList
    //   74	12	3	localList	List<String>
    //   32	20	4	arrayOfCertificate	java.security.cert.Certificate[]
    //   87	1	4	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   17	34	74	finally
    //   39	43	74	finally
    //   50	67	74	finally
    //   17	34	87	java/lang/Exception
    //   39	43	87	java/lang/Exception
    //   50	67	87	java/lang/Exception
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
    int k = paramArrayOfByte.length;
    int i = 0;
    int m;
    for (int j = 0; i < k >> 2; j = m + 1)
    {
      m = j + 1;
      paramArrayOfByte[j] &= 0xFF;
      int n = paramArrayOfInt[i];
      j = m + 1;
      paramArrayOfInt[i] = (n | (paramArrayOfByte[m] & 0xFF) << 8);
      n = paramArrayOfInt[i];
      m = j + 1;
      paramArrayOfInt[i] = (n | (paramArrayOfByte[j] & 0xFF) << 16);
      paramArrayOfInt[i] |= (paramArrayOfByte[m] & 0xFF) << 24;
      i += 1;
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
    int m;
    for (;;)
    {
      m = 8;
      if (i >= j) {
        break;
      }
      m = k + 1;
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
      j = m;
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
    byte[] arrayOfByte = g(paramArrayOfByte2);
    if ((paramArrayOfByte1 != null) && (arrayOfByte != null))
    {
      if (paramArrayOfByte1.length == 0) {
        return paramArrayOfByte1;
      }
      if (paramArrayOfByte1.length % 4 == 0)
      {
        if (paramArrayOfByte1.length < 8) {
          return null;
        }
        paramArrayOfByte2 = new int[paramArrayOfByte1.length >>> 2];
        a(paramArrayOfByte1, paramArrayOfByte2);
        if (arrayOfByte.length % 4 == 0) {
          i = arrayOfByte.length >>> 2;
        } else {
          i = (arrayOfByte.length >>> 2) + 1;
        }
        int j = i;
        if (i < 4) {
          j = 4;
        }
        paramArrayOfByte1 = new int[j];
        int i = 0;
        while (i < j)
        {
          paramArrayOfByte1[i] = 0;
          i += 1;
        }
        a(arrayOfByte, paramArrayOfByte1);
        int m = paramArrayOfByte2.length - 1;
        i = paramArrayOfByte2[m];
        i = paramArrayOfByte2[0];
        j = (52 / (m + 1) + 6) * -1640531527;
        while (j != 0)
        {
          int n = j >>> 2 & 0x3;
          int k = i;
          i = m;
          while (i > 0)
          {
            i1 = paramArrayOfByte2[(i - 1)];
            k = paramArrayOfByte2[i] - ((k ^ j) + (i1 ^ paramArrayOfByte1[(i & 0x3 ^ n)]) ^ (i1 >>> 5 ^ k << 2) + (k >>> 3 ^ i1 << 4));
            paramArrayOfByte2[i] = k;
            i -= 1;
          }
          int i1 = paramArrayOfByte2[m];
          i = paramArrayOfByte2[0] - ((i1 >>> 5 ^ k << 2) + (k >>> 3 ^ i1 << 4) ^ (k ^ j) + (paramArrayOfByte1[(i & 0x3 ^ n)] ^ i1));
          paramArrayOfByte2[0] = i;
          j += 1640531527;
        }
        i = paramArrayOfByte2[(paramArrayOfByte2.length - 1)];
        if (i >= 0)
        {
          if (i > paramArrayOfByte2.length - 1 << 2) {
            return null;
          }
          paramArrayOfByte1 = new byte[i];
          a(paramArrayOfByte2, paramArrayOfByte2.length - 1, paramArrayOfByte1);
          return paramArrayOfByte1;
        }
      }
      return null;
    }
    return paramArrayOfByte1;
  }
  
  /* Error */
  public static java.security.cert.Certificate[] a(java.util.jar.JarFile paramJarFile, java.util.jar.JarEntry paramJarEntry, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: aload_1
    //   4: invokevirtual 280	java/util/jar/JarFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   7: astore_0
    //   8: aload_0
    //   9: aload_2
    //   10: iconst_0
    //   11: aload_2
    //   12: arraylength
    //   13: invokevirtual 286	java/io/InputStream:read	([BII)I
    //   16: iconst_m1
    //   17: if_icmpeq +6 -> 23
    //   20: goto -12 -> 8
    //   23: aload_3
    //   24: astore_2
    //   25: aload_1
    //   26: ifnull +8 -> 34
    //   29: aload_1
    //   30: invokevirtual 292	java/util/jar/JarEntry:getCertificates	()[Ljava/security/cert/Certificate;
    //   33: astore_2
    //   34: aload_0
    //   35: invokevirtual 293	java/io/InputStream:close	()V
    //   38: aload_2
    //   39: areturn
    //   40: astore_2
    //   41: aload_0
    //   42: astore_1
    //   43: aload_2
    //   44: astore_0
    //   45: goto +6 -> 51
    //   48: astore_0
    //   49: aconst_null
    //   50: astore_1
    //   51: aload_1
    //   52: ifnull +7 -> 59
    //   55: aload_1
    //   56: invokevirtual 293	java/io/InputStream:close	()V
    //   59: aload_0
    //   60: athrow
    //   61: aconst_null
    //   62: astore_0
    //   63: aload_0
    //   64: ifnull +7 -> 71
    //   67: aload_0
    //   68: invokevirtual 293	java/io/InputStream:close	()V
    //   71: aconst_null
    //   72: areturn
    //   73: astore_0
    //   74: goto -13 -> 61
    //   77: astore_1
    //   78: goto -15 -> 63
    //   81: astore_0
    //   82: aload_2
    //   83: areturn
    //   84: astore_1
    //   85: goto -26 -> 59
    //   88: astore_0
    //   89: aconst_null
    //   90: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	paramJarFile	java.util.jar.JarFile
    //   0	91	1	paramJarEntry	java.util.jar.JarEntry
    //   0	91	2	paramArrayOfByte	byte[]
    //   1	23	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   8	20	40	finally
    //   29	34	40	finally
    //   2	8	48	finally
    //   2	8	73	java/io/IOException
    //   8	20	77	java/io/IOException
    //   29	34	77	java/io/IOException
    //   34	38	81	java/io/IOException
    //   55	59	84	java/io/IOException
    //   67	71	88	java/io/IOException
  }
  
  public static int b(SparseArray<Object> paramSparseArray)
  {
    paramSparseArray = (Integer)a(paramSparseArray, 0, Integer.class);
    if (paramSparseArray == null) {
      return -1;
    }
    return paramSparseArray.intValue();
  }
  
  /* Error */
  public static String b(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore 4
    //   5: aconst_null
    //   6: astore 5
    //   8: aconst_null
    //   9: astore 6
    //   11: aload_0
    //   12: invokevirtual 307	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   15: invokevirtual 110	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   18: astore_0
    //   19: aload_0
    //   20: ifnull +22 -> 42
    //   23: aload_0
    //   24: aload_1
    //   25: iconst_0
    //   26: invokevirtual 310	android/content/pm/PackageManager:getPackageArchiveInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   29: astore_0
    //   30: aload_0
    //   31: ifnull +11 -> 42
    //   34: aload_0
    //   35: getfield 313	android/content/pm/PackageInfo:packageName	Ljava/lang/String;
    //   38: astore_0
    //   39: goto +5 -> 44
    //   42: aconst_null
    //   43: astore_0
    //   44: aload_0
    //   45: ifnull +5 -> 50
    //   48: aload_0
    //   49: areturn
    //   50: new 315	java/util/zip/ZipFile
    //   53: dup
    //   54: aload_1
    //   55: invokespecial 316	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   58: astore_3
    //   59: aload 6
    //   61: astore_1
    //   62: aload 5
    //   64: astore_2
    //   65: aload_3
    //   66: aload_3
    //   67: ldc 229
    //   69: invokevirtual 320	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   72: invokevirtual 321	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   75: astore 4
    //   77: aload 4
    //   79: astore_1
    //   80: aload 4
    //   82: astore_2
    //   83: new 323	com/tencent/turingfd/sdk/xq/throws
    //   86: dup
    //   87: invokespecial 324	com/tencent/turingfd/sdk/xq/throws:<init>	()V
    //   90: aload 4
    //   92: invokevirtual 327	com/tencent/turingfd/sdk/xq/throws:a	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   95: invokeinterface 333 1 0
    //   100: iconst_0
    //   101: invokeinterface 339 2 0
    //   106: invokeinterface 345 1 0
    //   111: astore 5
    //   113: aload 4
    //   115: astore_1
    //   116: aload 4
    //   118: astore_2
    //   119: aload 5
    //   121: ldc_w 347
    //   124: invokeinterface 353 2 0
    //   129: invokeinterface 356 1 0
    //   134: astore 5
    //   136: aload 4
    //   138: invokestatic 358	com/tencent/turingfd/sdk/xq/void:a	(Ljava/io/Closeable;)V
    //   141: aload 5
    //   143: astore_1
    //   144: invokestatic 363	com/tencent/turingfd/sdk/xq/private:J	()I
    //   147: bipush 19
    //   149: if_icmplt +13 -> 162
    //   152: aload 5
    //   154: astore_1
    //   155: aload_3
    //   156: invokestatic 358	com/tencent/turingfd/sdk/xq/void:a	(Ljava/io/Closeable;)V
    //   159: aload 5
    //   161: areturn
    //   162: aload 5
    //   164: astore_1
    //   165: aload_3
    //   166: invokevirtual 364	java/util/zip/ZipFile:close	()V
    //   169: aload 5
    //   171: areturn
    //   172: astore_0
    //   173: goto +8 -> 181
    //   176: astore_0
    //   177: aconst_null
    //   178: astore_3
    //   179: aload_2
    //   180: astore_1
    //   181: aload_1
    //   182: invokestatic 358	com/tencent/turingfd/sdk/xq/void:a	(Ljava/io/Closeable;)V
    //   185: invokestatic 363	com/tencent/turingfd/sdk/xq/private:J	()I
    //   188: bipush 19
    //   190: if_icmplt +10 -> 200
    //   193: aload_3
    //   194: invokestatic 358	com/tencent/turingfd/sdk/xq/void:a	(Ljava/io/Closeable;)V
    //   197: goto +7 -> 204
    //   200: aload_3
    //   201: invokevirtual 364	java/util/zip/ZipFile:close	()V
    //   204: aload_0
    //   205: athrow
    //   206: aconst_null
    //   207: astore_3
    //   208: aload 4
    //   210: astore_2
    //   211: aload_2
    //   212: invokestatic 358	com/tencent/turingfd/sdk/xq/void:a	(Ljava/io/Closeable;)V
    //   215: aload_0
    //   216: astore_1
    //   217: invokestatic 363	com/tencent/turingfd/sdk/xq/private:J	()I
    //   220: bipush 19
    //   222: if_icmplt +11 -> 233
    //   225: aload_0
    //   226: astore_1
    //   227: aload_3
    //   228: invokestatic 358	com/tencent/turingfd/sdk/xq/void:a	(Ljava/io/Closeable;)V
    //   231: aload_0
    //   232: areturn
    //   233: aload_0
    //   234: astore_1
    //   235: aload_3
    //   236: invokevirtual 364	java/util/zip/ZipFile:close	()V
    //   239: aload_0
    //   240: areturn
    //   241: astore_0
    //   242: goto -200 -> 42
    //   245: astore_1
    //   246: goto -40 -> 206
    //   249: astore_1
    //   250: goto -39 -> 211
    //   253: astore_0
    //   254: aload_1
    //   255: areturn
    //   256: astore_1
    //   257: goto -53 -> 204
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	260	0	paramContext	Context
    //   0	260	1	paramString	String
    //   1	211	2	localObject1	Object
    //   58	178	3	localZipFile	java.util.zip.ZipFile
    //   3	206	4	localInputStream	java.io.InputStream
    //   6	164	5	localObject2	Object
    //   9	51	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   65	77	172	finally
    //   83	113	172	finally
    //   119	136	172	finally
    //   50	59	176	finally
    //   11	19	241	java/lang/Throwable
    //   23	30	241	java/lang/Throwable
    //   34	39	241	java/lang/Throwable
    //   50	59	245	java/lang/Throwable
    //   65	77	249	java/lang/Throwable
    //   83	113	249	java/lang/Throwable
    //   119	136	249	java/lang/Throwable
    //   144	152	253	java/lang/Throwable
    //   155	159	253	java/lang/Throwable
    //   165	169	253	java/lang/Throwable
    //   217	225	253	java/lang/Throwable
    //   227	231	253	java/lang/Throwable
    //   235	239	253	java/lang/Throwable
    //   185	197	256	java/lang/Throwable
    //   200	204	256	java/lang/Throwable
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
    byte[] arrayOfByte = g(paramArrayOfByte2);
    paramArrayOfByte2 = paramArrayOfByte1;
    if (paramArrayOfByte1 != null)
    {
      paramArrayOfByte2 = paramArrayOfByte1;
      if (arrayOfByte != null)
      {
        if (paramArrayOfByte1.length == 0) {
          return paramArrayOfByte1;
        }
        if (paramArrayOfByte1.length % 4 == 0) {
          i = (paramArrayOfByte1.length >>> 2) + 1;
        } else {
          i = (paramArrayOfByte1.length >>> 2) + 2;
        }
        int[] arrayOfInt = new int[i];
        a(paramArrayOfByte1, arrayOfInt);
        arrayOfInt[(i - 1)] = paramArrayOfByte1.length;
        if (arrayOfByte.length % 4 == 0) {
          i = arrayOfByte.length >>> 2;
        } else {
          i = (arrayOfByte.length >>> 2) + 1;
        }
        int j = i;
        if (i < 4) {
          j = 4;
        }
        paramArrayOfByte1 = new int[j];
        int i = 0;
        while (i < j)
        {
          paramArrayOfByte1[i] = 0;
          i += 1;
        }
        a(arrayOfByte, paramArrayOfByte1);
        int i1 = arrayOfInt.length - 1;
        i = arrayOfInt[i1];
        j = arrayOfInt[0];
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
            i3 = arrayOfInt[n];
            int i4 = arrayOfInt[i];
            k = ((k >>> 5 ^ i3 << 2) + (i3 >>> 3 ^ k << 4) ^ (i3 ^ m) + (k ^ paramArrayOfByte1[(i & 0x3 ^ i2)])) + i4;
            arrayOfInt[i] = k;
          }
          n = arrayOfInt[0];
          int i3 = arrayOfInt[i1];
          i = ((k >>> 5 ^ n << 2) + (n >>> 3 ^ k << 4) ^ (n ^ m) + (paramArrayOfByte1[(i & 0x3 ^ i2)] ^ k)) + i3;
          arrayOfInt[i1] = i;
          j -= 1;
        }
        paramArrayOfByte2 = new byte[arrayOfInt.length << 2];
        a(arrayOfInt, arrayOfInt.length, paramArrayOfByte2);
      }
    }
    return paramArrayOfByte2;
  }
  
  /* Error */
  public static String c(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 110	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   4: astore_2
    //   5: new 394	java/io/ByteArrayInputStream
    //   8: dup
    //   9: aload_2
    //   10: aload_2
    //   11: aload_0
    //   12: invokevirtual 110	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   15: aload_1
    //   16: iconst_0
    //   17: invokevirtual 398	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   20: getfield 403	android/content/pm/ApplicationInfo:uid	I
    //   23: invokevirtual 407	android/content/pm/PackageManager:getPackagesForUid	(I)[Ljava/lang/String;
    //   26: iconst_0
    //   27: aaload
    //   28: bipush 64
    //   30: invokevirtual 116	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   33: getfield 411	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   36: iconst_0
    //   37: aaload
    //   38: invokevirtual 416	android/content/pm/Signature:toByteArray	()[B
    //   41: invokespecial 418	java/io/ByteArrayInputStream:<init>	([B)V
    //   44: astore_0
    //   45: ldc_w 420
    //   48: invokestatic 426	java/security/cert/CertificateFactory:getInstance	(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;
    //   51: aload_0
    //   52: invokevirtual 430	java/security/cert/CertificateFactory:generateCertificate	(Ljava/io/InputStream;)Ljava/security/cert/Certificate;
    //   55: checkcast 432	java/security/cert/X509Certificate
    //   58: invokevirtual 433	java/security/cert/X509Certificate:getEncoded	()[B
    //   61: invokestatic 245	com/tencent/turingfd/sdk/xq/void:f	([B)Ljava/lang/String;
    //   64: astore_1
    //   65: aload_0
    //   66: invokevirtual 434	java/io/ByteArrayInputStream:close	()V
    //   69: aload_1
    //   70: areturn
    //   71: astore_1
    //   72: goto +6 -> 78
    //   75: astore_1
    //   76: aconst_null
    //   77: astore_0
    //   78: aload_0
    //   79: ifnull +7 -> 86
    //   82: aload_0
    //   83: invokevirtual 434	java/io/ByteArrayInputStream:close	()V
    //   86: aload_1
    //   87: athrow
    //   88: aconst_null
    //   89: astore_0
    //   90: aload_0
    //   91: ifnull +7 -> 98
    //   94: aload_0
    //   95: invokevirtual 434	java/io/ByteArrayInputStream:close	()V
    //   98: ldc 71
    //   100: areturn
    //   101: astore_0
    //   102: goto -14 -> 88
    //   105: astore_1
    //   106: goto -16 -> 90
    //   109: astore_0
    //   110: aload_1
    //   111: areturn
    //   112: astore_0
    //   113: goto -27 -> 86
    //   116: astore_0
    //   117: goto -19 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	paramContext	Context
    //   0	120	1	paramString	String
    //   4	7	2	localPackageManager	PackageManager
    // Exception table:
    //   from	to	target	type
    //   45	65	71	finally
    //   0	45	75	finally
    //   0	45	101	java/lang/Throwable
    //   45	65	105	java/lang/Throwable
    //   65	69	109	java/lang/Throwable
    //   82	86	112	java/lang/Throwable
    //   94	98	116	java/lang/Throwable
  }
  
  /* Error */
  public static byte[] c(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 436	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 437	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_1
    //   8: new 439	java/util/zip/DeflaterOutputStream
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 442	java/util/zip/DeflaterOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   16: astore_2
    //   17: aload_2
    //   18: aload_0
    //   19: invokevirtual 445	java/util/zip/DeflaterOutputStream:write	([B)V
    //   22: aload_2
    //   23: invokevirtual 448	java/util/zip/DeflaterOutputStream:finish	()V
    //   26: aload_1
    //   27: invokevirtual 449	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   30: astore_0
    //   31: aload_1
    //   32: invokevirtual 450	java/io/ByteArrayOutputStream:close	()V
    //   35: aload_2
    //   36: invokevirtual 451	java/util/zip/DeflaterOutputStream:close	()V
    //   39: aload_0
    //   40: areturn
    //   41: astore_1
    //   42: aload_1
    //   43: invokevirtual 454	java/io/IOException:printStackTrace	()V
    //   46: aload_0
    //   47: areturn
    //   48: astore_0
    //   49: aload_1
    //   50: invokevirtual 450	java/io/ByteArrayOutputStream:close	()V
    //   53: aload_2
    //   54: invokevirtual 451	java/util/zip/DeflaterOutputStream:close	()V
    //   57: goto +8 -> 65
    //   60: astore_1
    //   61: aload_1
    //   62: invokevirtual 454	java/io/IOException:printStackTrace	()V
    //   65: aload_0
    //   66: athrow
    //   67: aload_1
    //   68: invokevirtual 450	java/io/ByteArrayOutputStream:close	()V
    //   71: aload_2
    //   72: invokevirtual 451	java/util/zip/DeflaterOutputStream:close	()V
    //   75: aconst_null
    //   76: areturn
    //   77: astore_0
    //   78: aload_0
    //   79: invokevirtual 454	java/io/IOException:printStackTrace	()V
    //   82: aconst_null
    //   83: areturn
    //   84: astore_0
    //   85: goto -18 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	paramArrayOfByte	byte[]
    //   7	25	1	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   41	9	1	localIOException1	java.io.IOException
    //   60	8	1	localIOException2	java.io.IOException
    //   16	56	2	localDeflaterOutputStream	java.util.zip.DeflaterOutputStream
    // Exception table:
    //   from	to	target	type
    //   31	39	41	java/io/IOException
    //   17	31	48	finally
    //   49	57	60	java/io/IOException
    //   67	75	77	java/io/IOException
    //   17	31	84	java/lang/Exception
  }
  
  public static String d(int paramInt)
  {
    for (;;)
    {
      try
      {
        Object localObject1 = Locale.ENGLISH;
        localObject1 = abstract.c(String.format((Locale)localObject1, "/proc/%d/cmdline", new Object[] { Integer.valueOf(paramInt) }), 100);
        if (localObject1 != null)
        {
          localObject1 = new String((byte[])localObject1, 0, a((byte[])localObject1, 0, '\000'));
          Object localObject2 = localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject2 = Locale.ENGLISH;
            byte[] arrayOfByte = abstract.c(String.format((Locale)localObject2, "/proc/%d/status", new Object[] { Integer.valueOf(paramInt) }), 150);
            localObject2 = localObject1;
            if (arrayOfByte != null)
            {
              paramInt = a(arrayOfByte, 7, '\n');
              if (paramInt == 0) {
                return "";
              }
              localObject2 = new String(arrayOfByte, 6, paramInt - 6);
            }
          }
          return localObject2;
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        return "";
      }
      String str = "";
    }
  }
  
  public static String d(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  /* Error */
  public static byte[] d(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 394	java/io/ByteArrayInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 418	java/io/ByteArrayInputStream:<init>	([B)V
    //   8: astore_0
    //   9: new 488	java/util/zip/InflaterInputStream
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 491	java/util/zip/InflaterInputStream:<init>	(Ljava/io/InputStream;)V
    //   17: astore_2
    //   18: new 436	java/io/ByteArrayOutputStream
    //   21: dup
    //   22: invokespecial 437	java/io/ByteArrayOutputStream:<init>	()V
    //   25: astore_3
    //   26: aload_2
    //   27: invokevirtual 493	java/util/zip/InflaterInputStream:read	()I
    //   30: istore_1
    //   31: iload_1
    //   32: iconst_m1
    //   33: if_icmpeq +11 -> 44
    //   36: aload_3
    //   37: iload_1
    //   38: invokevirtual 495	java/io/ByteArrayOutputStream:write	(I)V
    //   41: goto -15 -> 26
    //   44: aload_3
    //   45: invokevirtual 449	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   48: astore 4
    //   50: aload_0
    //   51: invokevirtual 434	java/io/ByteArrayInputStream:close	()V
    //   54: aload_2
    //   55: invokevirtual 496	java/util/zip/InflaterInputStream:close	()V
    //   58: aload_3
    //   59: invokevirtual 450	java/io/ByteArrayOutputStream:close	()V
    //   62: aload 4
    //   64: areturn
    //   65: astore_0
    //   66: aload_0
    //   67: invokevirtual 454	java/io/IOException:printStackTrace	()V
    //   70: aload 4
    //   72: areturn
    //   73: astore 4
    //   75: aload_0
    //   76: invokevirtual 434	java/io/ByteArrayInputStream:close	()V
    //   79: aload_2
    //   80: invokevirtual 496	java/util/zip/InflaterInputStream:close	()V
    //   83: aload_3
    //   84: invokevirtual 450	java/io/ByteArrayOutputStream:close	()V
    //   87: goto +8 -> 95
    //   90: astore_0
    //   91: aload_0
    //   92: invokevirtual 454	java/io/IOException:printStackTrace	()V
    //   95: aload 4
    //   97: athrow
    //   98: aload_0
    //   99: invokevirtual 434	java/io/ByteArrayInputStream:close	()V
    //   102: aload_2
    //   103: invokevirtual 496	java/util/zip/InflaterInputStream:close	()V
    //   106: aload_3
    //   107: invokevirtual 450	java/io/ByteArrayOutputStream:close	()V
    //   110: aconst_null
    //   111: areturn
    //   112: astore_0
    //   113: aload_0
    //   114: invokevirtual 454	java/io/IOException:printStackTrace	()V
    //   117: aconst_null
    //   118: areturn
    //   119: astore 4
    //   121: goto -23 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	paramArrayOfByte	byte[]
    //   30	8	1	i	int
    //   17	86	2	localInflaterInputStream	java.util.zip.InflaterInputStream
    //   25	82	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   48	23	4	arrayOfByte	byte[]
    //   73	23	4	localObject	Object
    //   119	1	4	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   50	62	65	java/io/IOException
    //   26	31	73	finally
    //   36	41	73	finally
    //   44	50	73	finally
    //   75	87	90	java/io/IOException
    //   98	110	112	java/io/IOException
    //   26	31	119	java/lang/Exception
    //   36	41	119	java/lang/Exception
    //   44	50	119	java/lang/Exception
  }
  
  public static strictfp e(int paramInt)
  {
    Object localObject2 = null;
    try
    {
      str = d(paramInt);
      if (paramInt == -1) {}
    }
    catch (Throwable localThrowable1)
    {
      String str;
      Object localObject1;
      label82:
      HashMap localHashMap;
      label107:
      int m;
      label228:
      break label228;
    }
    try
    {
      localObject1 = Locale.ENGLISH;
      localObject1 = new String(abstract.i(String.format((Locale)localObject1, "/proc/%d/status", new Object[] { Integer.valueOf(paramInt) })));
      break label82;
      localObject1 = Locale.ENGLISH;
      localObject1 = new String(abstract.i(String.format((Locale)localObject1, "/proc/self/status", new Object[0])));
      localHashMap = new HashMap();
      localObject1 = ((String)localObject1).split("\n");
      j = localObject1.length;
      i = 0;
      if (i < j)
      {
        String[] arrayOfString = localObject1[i];
        arrayOfString = arrayOfString.split(":");
        if (arrayOfString.length >= 2) {
          localHashMap.put(arrayOfString[0].trim(), arrayOfString[1].trim());
        }
        i += 1;
        break label107;
      }
      i = Integer.parseInt((String)localHashMap.get("PPid"));
    }
    catch (Throwable localThrowable2)
    {
      break label231;
    }
    try
    {
      localObject1 = (String)localHashMap.get("Uid");
      k = Integer.parseInt(localObject1.split("\\s+")[0]);
    }
    catch (Throwable localThrowable3)
    {
      j = i;
      break label233;
    }
    try
    {
      j = Integer.parseInt((String)localHashMap.get("TracerPid"));
      m = j;
    }
    catch (Throwable localThrowable4)
    {
      j = i;
      i = k;
      break label235;
    }
    str = null;
    label231:
    j = -1;
    label233:
    i = -1;
    label235:
    m = -1;
    k = i;
    i = j;
    localObject1 = localObject2;
    if (str != null)
    {
      localObject1 = localObject2;
      if (i != -1)
      {
        if (k == -1) {
          return null;
        }
        localObject1 = new strictfp(paramInt, i, str, k, null, m);
      }
    }
    return localObject1;
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
  
  public static byte[] e(byte[] paramArrayOfByte)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance(new String(f("4D4435")));
      localMessageDigest.update(paramArrayOfByte);
      paramArrayOfByte = localMessageDigest.digest();
      return paramArrayOfByte;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      label29:
      break label29;
    }
    return null;
  }
  
  public static String f(byte[] paramArrayOfByte)
  {
    return b(e(paramArrayOfByte));
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
  
  public static byte[] g(byte[] paramArrayOfByte)
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
      paramArrayOfByte = ((MessageDigest)localObject).digest();
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      label34:
      break label34;
    }
    localObject = null;
    return localObject;
  }
  
  public static Context get()
  {
    try
    {
      Context localContext = td;
      return localContext;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static SparseArray<Object> k()
  {
    return new SparseArray();
  }
  
  public static String k(Context paramContext)
  {
    System.currentTimeMillis();
    Object localObject1 = new HashSet();
    int j = 0;
    try
    {
      localObject2 = new String(abstract.i(final.get(final.ae)));
      localObject2 = ((String)localObject2).split("\\n");
      paramContext = paramContext.getPackageName();
      int k = localObject2.length;
      i = 0;
      while (i < k)
      {
        String str = a(localObject2[i], paramContext);
        if (str != null) {
          ((Set)localObject1).add(str);
        }
        i += 1;
      }
    }
    catch (Throwable paramContext)
    {
      Object localObject2;
      int i;
      label91:
      break label91;
    }
    localObject1 = boolean.a((Set)localObject1);
    if (((Set)localObject1).size() > 0)
    {
      paramContext = new StringBuilder();
      localObject2 = new ArrayList();
      ((ArrayList)localObject2).addAll((Collection)localObject1);
      localObject1 = ((ArrayList)localObject2).iterator();
      i = j;
      while (((Iterator)localObject1).hasNext())
      {
        j = i + 1;
        paramContext.append((String)((Iterator)localObject1).next());
        if (j >= 8) {
          break;
        }
        i = j;
        if (((Iterator)localObject1).hasNext())
        {
          paramContext.append("_");
          i = j;
        }
      }
      return paramContext.toString();
    }
    return "";
  }
  
  public static boolean l()
  {
    try
    {
      Object localObject1 = NetworkInterface.getNetworkInterfaces();
      if (localObject1 != null)
      {
        localObject1 = Collections.list((Enumeration)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (NetworkInterface)((Iterator)localObject1).next();
          if ((((NetworkInterface)localObject2).isUp()) && (((NetworkInterface)localObject2).getInterfaceAddresses().size() != 0))
          {
            localObject2 = ((NetworkInterface)localObject2).getName();
            boolean bool = ((String)localObject2).matches("tun\\d+");
            if (bool) {
              return true;
            }
          }
        }
      }
    }
    catch (Throwable localThrowable)
    {
      label76:
      break label76;
    }
    return false;
  }
  
  public static boolean l(Context paramContext)
  {
    int i = Build.VERSION.SDK_INT;
    if (i < 14) {
      return (!TextUtils.isEmpty(Proxy.getHost(paramContext))) && (Proxy.getPort(paramContext) != -1);
    }
    if ((!TextUtils.isEmpty(System.getProperty("http.proxyHost"))) && (!TextUtils.equals(System.getProperty("http.proxyPort"), "-1"))) {
      return true;
    }
    Object localObject1 = (WifiManager)paramContext.getApplicationContext().getSystemService("wifi");
    if (paramContext.checkPermission("android.permission.ACCESS_WIFI_STATE", Process.myPid(), Process.myUid()) != 0) {
      return false;
    }
    try
    {
      localObject2 = ((WifiManager)localObject1).getConnectionInfo();
      if (localObject2 != null)
      {
        if (((WifiInfo)localObject2).getNetworkId() == -1) {
          return false;
        }
        paramContext = null;
      }
    }
    catch (Throwable paramContext)
    {
      Object localObject2;
      label121:
      return false;
    }
    try
    {
      localObject1 = ((WifiManager)localObject1).getConfiguredNetworks();
      paramContext = (Context)localObject1;
    }
    catch (Throwable localThrowable)
    {
      break label121;
    }
    if (paramContext == null) {
      return false;
    }
    localObject1 = ((WifiInfo)localObject2).getSSID();
    paramContext = paramContext.iterator();
    while (paramContext.hasNext())
    {
      localObject2 = (WifiConfiguration)paramContext.next();
      if (!TextUtils.equals(((WifiConfiguration)localObject2).SSID, (CharSequence)localObject1))
      {
        String str = ((WifiConfiguration)localObject2).SSID;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("\"");
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append("\"");
        if (!TextUtils.equals(str, localStringBuilder.toString())) {
          break;
        }
      }
      else
      {
        if (i < 21)
        {
          paramContext = finally.a(WifiConfiguration.class, "proxySettings", localObject2);
          localObject1 = "android.net.wifi.WifiConfiguration$ProxySettings";
        }
        else
        {
          paramContext = finally.b(WifiConfiguration.class, "getProxySettings", localObject2);
          localObject1 = "android.net.IpConfiguration$ProxySettings";
        }
        localObject2 = finally.c((String)localObject1, "STATIC");
        if ((localObject2 != null) && (localObject2 == paramContext)) {
          return true;
        }
        if (i >= 19)
        {
          localObject1 = finally.c((String)localObject1, "PAC");
          if ((localObject1 != null) && (localObject1 == paramContext)) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public static byte m(Context paramContext)
  {
    int i = 1;
    byte b = -1;
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
            if (paramContext == null) {
              return 1;
            }
          }
          return 2;
        }
      }
      return -1;
    }
    catch (Throwable paramContext)
    {
      paramContext = paramContext.getMessage();
      if ((paramContext == null) || (!paramContext.contains("ACCESS_NETWORK_STATE"))) {
        i = 0;
      }
      if (i != 0) {
        b = 0;
      }
    }
    return b;
  }
  
  public static byte[] m()
  {
    try
    {
      Object localObject = new StringBuffer();
      String str = final.get(final.lf);
      int i = 0;
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
  
  public static List<strictfp> n()
  {
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = new File("/proc").list();
    if (arrayOfString == null) {
      return localArrayList;
    }
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = arrayOfString[i];
      if (!TextUtils.isEmpty((CharSequence)localObject)) {}
      try
      {
        int k = ((String)localObject).charAt(0);
        if ((k <= 57) && (k >= 48))
        {
          localObject = e(Integer.parseInt((String)localObject));
          if (localObject != null) {
            localArrayList.add(localObject);
          }
        }
      }
      catch (Exception localException)
      {
        label104:
        break label104;
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static boolean n(Context paramContext)
  {
    try
    {
      Context localContext = td;
      if (localContext != null) {
        return true;
      }
      if (paramContext == null) {
        return false;
      }
      paramContext = paramContext.getApplicationContext();
      if (paramContext == null) {
        return false;
      }
      td = paramContext;
      return true;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.void
 * JD-Core Version:    0.7.0.1
 */