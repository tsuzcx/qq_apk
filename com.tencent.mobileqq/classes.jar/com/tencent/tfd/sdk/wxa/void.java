package com.tencent.tfd.sdk.wxa;

import android.content.Context;
import android.net.Proxy;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Process;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.qmethodmonitor.monitor.NetworkMonitor;
import java.io.Closeable;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class void
{
  public static Context ba;
  
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
  
  /* Error */
  public static String a(Context paramContext, String paramString)
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
    //   12: invokevirtual 38	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   15: invokevirtual 42	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   18: astore_0
    //   19: aload_0
    //   20: ifnull +22 -> 42
    //   23: aload_0
    //   24: aload_1
    //   25: iconst_0
    //   26: invokevirtual 48	android/content/pm/PackageManager:getPackageArchiveInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   29: astore_0
    //   30: aload_0
    //   31: ifnull +11 -> 42
    //   34: aload_0
    //   35: getfield 54	android/content/pm/PackageInfo:packageName	Ljava/lang/String;
    //   38: astore_0
    //   39: goto +5 -> 44
    //   42: aconst_null
    //   43: astore_0
    //   44: aload_0
    //   45: ifnull +5 -> 50
    //   48: aload_0
    //   49: areturn
    //   50: new 56	java/util/zip/ZipFile
    //   53: dup
    //   54: aload_1
    //   55: invokespecial 60	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   58: astore_3
    //   59: aload 6
    //   61: astore_1
    //   62: aload 5
    //   64: astore_2
    //   65: aload_3
    //   66: aload_3
    //   67: ldc 62
    //   69: invokevirtual 66	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   72: invokevirtual 70	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   75: astore 4
    //   77: aload 4
    //   79: astore_1
    //   80: aload 4
    //   82: astore_2
    //   83: new 72	com/tencent/tfd/sdk/wxa/switch
    //   86: dup
    //   87: invokespecial 75	com/tencent/tfd/sdk/wxa/switch:<init>	()V
    //   90: aload 4
    //   92: invokevirtual 78	com/tencent/tfd/sdk/wxa/switch:a	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   95: invokeinterface 84 1 0
    //   100: iconst_0
    //   101: invokeinterface 90 2 0
    //   106: invokeinterface 96 1 0
    //   111: astore 5
    //   113: aload 4
    //   115: astore_1
    //   116: aload 4
    //   118: astore_2
    //   119: aload 5
    //   121: ldc 98
    //   123: invokeinterface 104 2 0
    //   128: invokeinterface 108 1 0
    //   133: astore 5
    //   135: aload 4
    //   137: invokestatic 111	com/tencent/tfd/sdk/wxa/void:a	(Ljava/io/Closeable;)V
    //   140: aload 5
    //   142: astore_1
    //   143: invokestatic 117	com/tencent/tfd/sdk/wxa/finally:G	()I
    //   146: bipush 19
    //   148: if_icmplt +13 -> 161
    //   151: aload 5
    //   153: astore_1
    //   154: aload_3
    //   155: invokestatic 111	com/tencent/tfd/sdk/wxa/void:a	(Ljava/io/Closeable;)V
    //   158: aload 5
    //   160: areturn
    //   161: aload 5
    //   163: astore_1
    //   164: aload_3
    //   165: invokevirtual 120	java/util/zip/ZipFile:close	()V
    //   168: aload 5
    //   170: areturn
    //   171: astore_0
    //   172: goto +8 -> 180
    //   175: astore_0
    //   176: aconst_null
    //   177: astore_3
    //   178: aload_2
    //   179: astore_1
    //   180: aload_1
    //   181: invokestatic 111	com/tencent/tfd/sdk/wxa/void:a	(Ljava/io/Closeable;)V
    //   184: invokestatic 117	com/tencent/tfd/sdk/wxa/finally:G	()I
    //   187: bipush 19
    //   189: if_icmplt +10 -> 199
    //   192: aload_3
    //   193: invokestatic 111	com/tencent/tfd/sdk/wxa/void:a	(Ljava/io/Closeable;)V
    //   196: goto +7 -> 203
    //   199: aload_3
    //   200: invokevirtual 120	java/util/zip/ZipFile:close	()V
    //   203: aload_0
    //   204: athrow
    //   205: aconst_null
    //   206: astore_3
    //   207: aload 4
    //   209: astore_2
    //   210: aload_2
    //   211: invokestatic 111	com/tencent/tfd/sdk/wxa/void:a	(Ljava/io/Closeable;)V
    //   214: aload_0
    //   215: astore_1
    //   216: invokestatic 117	com/tencent/tfd/sdk/wxa/finally:G	()I
    //   219: bipush 19
    //   221: if_icmplt +11 -> 232
    //   224: aload_0
    //   225: astore_1
    //   226: aload_3
    //   227: invokestatic 111	com/tencent/tfd/sdk/wxa/void:a	(Ljava/io/Closeable;)V
    //   230: aload_0
    //   231: areturn
    //   232: aload_0
    //   233: astore_1
    //   234: aload_3
    //   235: invokevirtual 120	java/util/zip/ZipFile:close	()V
    //   238: aload_0
    //   239: areturn
    //   240: astore_0
    //   241: goto -199 -> 42
    //   244: astore_1
    //   245: goto -40 -> 205
    //   248: astore_1
    //   249: goto -39 -> 210
    //   252: astore_0
    //   253: aload_1
    //   254: areturn
    //   255: astore_1
    //   256: goto -53 -> 203
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	259	0	paramContext	Context
    //   0	259	1	paramString	String
    //   1	210	2	localObject1	Object
    //   58	177	3	localZipFile	java.util.zip.ZipFile
    //   3	205	4	localInputStream	java.io.InputStream
    //   6	163	5	localObject2	Object
    //   9	51	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   65	77	171	finally
    //   83	113	171	finally
    //   119	135	171	finally
    //   50	59	175	finally
    //   11	19	240	java/lang/Throwable
    //   23	30	240	java/lang/Throwable
    //   34	39	240	java/lang/Throwable
    //   50	59	244	java/lang/Throwable
    //   65	77	248	java/lang/Throwable
    //   83	113	248	java/lang/Throwable
    //   119	135	248	java/lang/Throwable
    //   143	151	252	java/lang/Throwable
    //   154	158	252	java/lang/Throwable
    //   164	168	252	java/lang/Throwable
    //   216	224	252	java/lang/Throwable
    //   226	230	252	java/lang/Throwable
    //   234	238	252	java/lang/Throwable
    //   184	196	255	java/lang/Throwable
    //   199	203	255	java/lang/Throwable
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
      paramString2 = package.c(new File(paramString2.toString()));
      if ((paramString2 == null) || (paramString1.startsWith(paramString2))) {
        return null;
      }
    }
    return paramString1;
  }
  
  public static String a(byte[] paramArrayOfByte)
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
  
  /* Error */
  public static List<String> a(File paramFile)
  {
    // Byte code:
    //   0: new 228	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 229	java/util/ArrayList:<init>	()V
    //   7: astore_3
    //   8: new 231	java/util/jar/JarFile
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 234	java/util/jar/JarFile:<init>	(Ljava/io/File;)V
    //   16: astore_0
    //   17: aload_0
    //   18: aload_0
    //   19: ldc 62
    //   21: invokevirtual 238	java/util/jar/JarFile:getJarEntry	(Ljava/lang/String;)Ljava/util/jar/JarEntry;
    //   24: sipush 8192
    //   27: newarray byte
    //   29: invokestatic 241	com/tencent/tfd/sdk/wxa/void:a	(Ljava/util/jar/JarFile;Ljava/util/jar/JarEntry;[B)[Ljava/security/cert/Certificate;
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
    //   55: invokevirtual 247	java/security/cert/Certificate:getEncoded	()[B
    //   58: invokestatic 249	com/tencent/tfd/sdk/wxa/void:c	([B)Ljava/lang/String;
    //   61: invokeinterface 254 2 0
    //   66: pop
    //   67: iload_1
    //   68: iconst_1
    //   69: iadd
    //   70: istore_1
    //   71: goto -26 -> 45
    //   74: astore_3
    //   75: aload_0
    //   76: invokevirtual 255	java/util/jar/JarFile:close	()V
    //   79: aload_3
    //   80: athrow
    //   81: aload_0
    //   82: invokevirtual 255	java/util/jar/JarFile:close	()V
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
    byte[] arrayOfByte = d(paramArrayOfByte2);
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
    //   4: invokevirtual 281	java/util/jar/JarFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   7: astore_0
    //   8: aload_0
    //   9: aload_2
    //   10: iconst_0
    //   11: aload_2
    //   12: arraylength
    //   13: invokevirtual 287	java/io/InputStream:read	([BII)I
    //   16: iconst_m1
    //   17: if_icmpeq +6 -> 23
    //   20: goto -12 -> 8
    //   23: aload_3
    //   24: astore_2
    //   25: aload_1
    //   26: ifnull +8 -> 34
    //   29: aload_1
    //   30: invokevirtual 293	java/util/jar/JarEntry:getCertificates	()[Ljava/security/cert/Certificate;
    //   33: astore_2
    //   34: aload_0
    //   35: invokevirtual 294	java/io/InputStream:close	()V
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
    //   56: invokevirtual 294	java/io/InputStream:close	()V
    //   59: aload_0
    //   60: athrow
    //   61: aconst_null
    //   62: astore_0
    //   63: aload_0
    //   64: ifnull +7 -> 71
    //   67: aload_0
    //   68: invokevirtual 294	java/io/InputStream:close	()V
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
  
  public static byte[] b(byte[] paramArrayOfByte)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance(new String(d("4D4435")));
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
  
  public static byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = d(paramArrayOfByte2);
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
  
  public static String c(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public static String c(byte[] paramArrayOfByte)
  {
    return a(b(paramArrayOfByte));
  }
  
  public static String d(int paramInt)
  {
    for (;;)
    {
      try
      {
        Object localObject1 = Locale.ENGLISH;
        localObject1 = package.c(String.format((Locale)localObject1, "/proc/%d/cmdline", new Object[] { Integer.valueOf(paramInt) }), 100);
        if (localObject1 != null)
        {
          localObject1 = new String((byte[])localObject1, 0, a((byte[])localObject1, 0, '\000'));
          Object localObject2 = localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject2 = Locale.ENGLISH;
            byte[] arrayOfByte = package.c(String.format((Locale)localObject2, "/proc/%d/status", new Object[] { Integer.valueOf(paramInt) }), 150);
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
  
  public static byte[] d(String paramString)
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
  
  public static byte[] d(byte[] paramArrayOfByte)
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
  
  public static abstract e(int paramInt)
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
      localObject1 = new String(package.f(String.format((Locale)localObject1, "/proc/%d/status", new Object[] { Integer.valueOf(paramInt) })));
      break label82;
      localObject1 = Locale.ENGLISH;
      localObject1 = new String(package.f(String.format((Locale)localObject1, "/proc/self/status", new Object[0])));
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
        localObject1 = new abstract(paramInt, i, str, k, null, m);
      }
    }
    return localObject1;
  }
  
  public static Context get()
  {
    try
    {
      Context localContext = ba;
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
  
  public static boolean k(Context paramContext)
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
      localObject2 = NetworkMonitor.getConnectionInfo((WifiManager)localObject1);
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
          paramContext = extends.a(WifiConfiguration.class, "proxySettings", localObject2);
          localObject1 = "android.net.wifi.WifiConfiguration$ProxySettings";
        }
        else
        {
          paramContext = extends.b(WifiConfiguration.class, "getProxySettings", localObject2);
          localObject1 = "android.net.IpConfiguration$ProxySettings";
        }
        localObject2 = extends.c((String)localObject1, "STATIC");
        if ((localObject2 != null) && (localObject2 == paramContext)) {
          return true;
        }
        if (i >= 19)
        {
          localObject1 = extends.c((String)localObject1, "PAC");
          if ((localObject1 != null) && (localObject1 == paramContext)) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public static boolean l(Context paramContext)
  {
    try
    {
      Context localContext = ba;
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
      ba = paramContext;
      return true;
    }
    finally {}
  }
  
  public static byte[] l()
  {
    try
    {
      Object localObject = new StringBuffer();
      String str = const.get(const.Mb);
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
  
  public static List<abstract> m()
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tfd.sdk.wxa.void
 * JD-Core Version:    0.7.0.1
 */