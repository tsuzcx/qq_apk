package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class for
{
  public static Context j;
  
  public static int a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (paramBoolean) {
      return 1 << paramInt2 | paramInt1;
    }
    return 0 << paramInt2 | paramInt1;
  }
  
  public static int a(SparseArray<Object> paramSparseArray)
  {
    paramSparseArray = (Integer)a(paramSparseArray, 0, Integer.class);
    if (paramSparseArray == null) {
      return -1;
    }
    return paramSparseArray.intValue();
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
  
  public static SparseArray<Object> a()
  {
    return new SparseArray();
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
  
  public static String a(int paramInt)
  {
    String str = "";
    try
    {
      Object localObject = Locale.ENGLISH;
      localObject = a(String.format((Locale)localObject, "/proc/%d/cmdline", new Object[] { Integer.valueOf(paramInt) }), 100);
      if (localObject != null) {
        str = new String((byte[])localObject, 0, a((byte[])localObject, 0, '\000'));
      }
      localObject = str;
      byte[] arrayOfByte;
      if (TextUtils.isEmpty(str))
      {
        localObject = Locale.ENGLISH;
        arrayOfByte = a(String.format((Locale)localObject, "/proc/%d/status", new Object[] { Integer.valueOf(paramInt) }), 150);
        localObject = str;
        if (arrayOfByte != null)
        {
          paramInt = a(arrayOfByte, 7, '\n');
          if (paramInt != 0) {
            break label111;
          }
          localObject = "";
        }
      }
      return localObject;
      label111:
      str = new String(arrayOfByte, 6, paramInt - 6);
      return str;
    }
    catch (Throwable localThrowable) {}
    return "";
  }
  
  public static String a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if (paramString1 == null) {}
    for (;;)
    {
      return null;
      int i = paramString1.indexOf('/');
      if (i == -1) {
        continue;
      }
      String str = paramString1.substring(i).trim();
      if (!str.startsWith("/data/")) {
        continue;
      }
      paramString1 = "/data/data/" + paramString2 + "/";
      if ((str.startsWith(paramString1)) || (str.startsWith("/data/app/" + paramString2)) || (Pattern.compile("^/data/user/\\d+/" + paramString2).matcher(str).find())) {
        continue;
      }
      boolean bool = str.endsWith(".so");
      if ((!bool) && (str.endsWith(".jar")))
      {
        i = 1;
        if ((!bool) && (i == 0)) {
          continue;
        }
        if (bool) {
          paramString1 = new File(paramString1 + "lib");
        }
      }
      try
      {
        paramString1 = paramString1.getCanonicalPath();
        if ((paramString1 == null) || (str.startsWith(paramString1))) {
          continue;
        }
        return str;
        i = 0;
      }
      catch (IOException paramString1)
      {
        for (;;)
        {
          paramString1 = null;
        }
      }
    }
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
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences("turingfd_protect_105668_38_xqMini", 0).edit();
      paramContext.putInt(paramString, paramInt);
      paramContext.commit();
      return;
    }
    catch (Throwable paramContext) {}
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
    int k = 0;
    int m = paramArrayOfByte.length;
    int i = 0;
    while (i < m >> 2)
    {
      int n = k + 1;
      paramArrayOfByte[k] &= 0xFF;
      int i1 = paramArrayOfInt[i];
      k = n + 1;
      paramArrayOfInt[i] = (i1 | (paramArrayOfByte[n] & 0xFF) << 8);
      i1 = paramArrayOfInt[i];
      n = k + 1;
      paramArrayOfInt[i] = (i1 | (paramArrayOfByte[k] & 0xFF) << 16);
      paramArrayOfInt[i] |= (paramArrayOfByte[n] & 0xFF) << 24;
      i += 1;
      k = n + 1;
    }
    if (k < paramArrayOfByte.length)
    {
      m = k + 1;
      paramArrayOfByte[k] &= 0xFF;
      k = 8;
      while (m < paramArrayOfByte.length)
      {
        paramArrayOfInt[i] |= (paramArrayOfByte[m] & 0xFF) << k;
        m += 1;
        k += 8;
      }
    }
  }
  
  public static void a(int[] paramArrayOfInt, int paramInt, byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length >> 2;
    int k = i;
    if (i > paramInt) {
      k = paramInt;
    }
    i = 0;
    int m = 0;
    while (i < k)
    {
      int n = m + 1;
      paramArrayOfByte[m] = ((byte)(paramArrayOfInt[i] & 0xFF));
      m = n + 1;
      paramArrayOfByte[n] = ((byte)(paramArrayOfInt[i] >>> 8 & 0xFF));
      n = m + 1;
      paramArrayOfByte[m] = ((byte)(paramArrayOfInt[i] >>> 16 & 0xFF));
      m = n + 1;
      paramArrayOfByte[n] = ((byte)(paramArrayOfInt[i] >>> 24 & 0xFF));
      i += 1;
    }
    if ((paramInt > k) && (m < paramArrayOfByte.length))
    {
      paramInt = m + 1;
      paramArrayOfByte[m] = ((byte)(paramArrayOfInt[i] & 0xFF));
      k = 8;
      while ((k <= 24) && (paramInt < paramArrayOfByte.length))
      {
        paramArrayOfByte[paramInt] = ((byte)(paramArrayOfInt[i] >>> k & 0xFF));
        k += 8;
        paramInt += 1;
      }
    }
  }
  
  public static boolean a(File paramFile)
  {
    if (!paramFile.exists()) {
      return true;
    }
    if (!paramFile.isDirectory()) {}
    try
    {
      bool = paramFile.delete();
      return bool;
    }
    catch (Throwable paramFile)
    {
      try
      {
        File[] arrayOfFile;
        int k;
        int i;
        boolean bool = paramFile.delete();
        return bool;
      }
      catch (Throwable paramFile) {}
      paramFile = paramFile;
      return false;
    }
    arrayOfFile = paramFile.listFiles();
    if (arrayOfFile != null)
    {
      k = arrayOfFile.length;
      i = 0;
      while (i < k)
      {
        a(arrayOfFile[i]);
        i += 1;
      }
    }
    return false;
  }
  
  /* Error */
  public static byte[] a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: new 148	java/io/File
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 153	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: astore_0
    //   11: aload_0
    //   12: invokevirtual 219	java/io/File:exists	()Z
    //   15: ifne +5 -> 20
    //   18: aconst_null
    //   19: areturn
    //   20: new 233	java/io/FileInputStream
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 236	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   28: astore_0
    //   29: iload_1
    //   30: newarray byte
    //   32: astore 5
    //   34: aload_0
    //   35: aload 5
    //   37: iload_2
    //   38: iload_1
    //   39: iload_2
    //   40: isub
    //   41: invokevirtual 240	java/io/FileInputStream:read	([BII)I
    //   44: istore 4
    //   46: iload_2
    //   47: istore_3
    //   48: iload 4
    //   50: iconst_m1
    //   51: if_icmpeq +15 -> 66
    //   54: iload_2
    //   55: iload 4
    //   57: iadd
    //   58: istore_3
    //   59: iload_3
    //   60: istore_2
    //   61: iload_3
    //   62: iload_1
    //   63: if_icmplt -29 -> 34
    //   66: iload_3
    //   67: ifne +9 -> 76
    //   70: aload_0
    //   71: invokestatic 243	com/tencent/turingfd/sdk/xq/for:b	(Ljava/io/Closeable;)V
    //   74: aconst_null
    //   75: areturn
    //   76: iload_3
    //   77: iload_1
    //   78: if_icmpge +65 -> 143
    //   81: iload_3
    //   82: newarray byte
    //   84: astore 6
    //   86: aload 5
    //   88: iconst_0
    //   89: aload 6
    //   91: iconst_0
    //   92: iload_3
    //   93: invokestatic 249	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   96: aload 6
    //   98: astore 5
    //   100: aload_0
    //   101: invokestatic 243	com/tencent/turingfd/sdk/xq/for:b	(Ljava/io/Closeable;)V
    //   104: aload 5
    //   106: areturn
    //   107: astore 6
    //   109: aload_0
    //   110: astore 5
    //   112: aload 6
    //   114: astore_0
    //   115: aload 5
    //   117: invokestatic 243	com/tencent/turingfd/sdk/xq/for:b	(Ljava/io/Closeable;)V
    //   120: aload_0
    //   121: athrow
    //   122: astore_0
    //   123: aconst_null
    //   124: astore 5
    //   126: goto -11 -> 115
    //   129: astore_0
    //   130: aconst_null
    //   131: astore_0
    //   132: aload_0
    //   133: invokestatic 243	com/tencent/turingfd/sdk/xq/for:b	(Ljava/io/Closeable;)V
    //   136: aconst_null
    //   137: areturn
    //   138: astore 5
    //   140: goto -8 -> 132
    //   143: goto -43 -> 100
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	paramString	String
    //   0	146	1	paramInt	int
    //   1	60	2	i	int
    //   47	46	3	k	int
    //   44	14	4	m	int
    //   32	93	5	localObject1	Object
    //   138	1	5	localThrowable	Throwable
    //   84	13	6	arrayOfByte	byte[]
    //   107	6	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   29	34	107	finally
    //   34	46	107	finally
    //   81	96	107	finally
    //   20	29	122	finally
    //   20	29	129	java/lang/Throwable
    //   29	34	138	java/lang/Throwable
    //   34	46	138	java/lang/Throwable
    //   81	96	138	java/lang/Throwable
  }
  
  public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = d(paramArrayOfByte2);
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
      k = i;
      if (i < 4) {
        k = 4;
      }
      paramArrayOfByte1 = new int[k];
      i = 0;
      while (i < k)
      {
        paramArrayOfByte1[i] = 0;
        i += 1;
      }
    }
    a(arrayOfByte, paramArrayOfByte1);
    int n = paramArrayOfByte2.length - 1;
    i = paramArrayOfByte2[n];
    i = paramArrayOfByte2[0];
    int k = (52 / (n + 1) + 6) * -1640531527;
    while (k != 0)
    {
      int i1 = k >>> 2 & 0x3;
      int m = n;
      while (m > 0)
      {
        i2 = paramArrayOfByte2[(m - 1)];
        i = paramArrayOfByte2[m] - ((i ^ k) + (i2 ^ paramArrayOfByte1[(m & 0x3 ^ i1)]) ^ (i2 >>> 5 ^ i << 2) + (i >>> 3 ^ i2 << 4));
        paramArrayOfByte2[m] = i;
        m -= 1;
      }
      int i2 = paramArrayOfByte2[n];
      i = paramArrayOfByte2[0] - ((i ^ k) + (paramArrayOfByte1[(m & 0x3 ^ i1)] ^ i2) ^ (i2 >>> 5 ^ i << 2) + (i >>> 3 ^ i2 << 4));
      paramArrayOfByte2[0] = i;
      k += 1640531527;
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
    //   7: invokevirtual 267	java/util/jar/JarFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   10: astore_0
    //   11: aload_0
    //   12: aload_2
    //   13: iconst_0
    //   14: aload_2
    //   15: arraylength
    //   16: invokevirtual 270	java/io/InputStream:read	([BII)I
    //   19: iconst_m1
    //   20: if_icmpne -9 -> 11
    //   23: aload 4
    //   25: astore_2
    //   26: aload_1
    //   27: ifnull +8 -> 35
    //   30: aload_1
    //   31: invokevirtual 276	java/util/jar/JarEntry:getCertificates	()[Ljava/security/cert/Certificate;
    //   34: astore_2
    //   35: aload_0
    //   36: invokevirtual 277	java/io/InputStream:close	()V
    //   39: aload_2
    //   40: areturn
    //   41: astore_1
    //   42: aconst_null
    //   43: astore_0
    //   44: aload_0
    //   45: ifnull +7 -> 52
    //   48: aload_0
    //   49: invokevirtual 277	java/io/InputStream:close	()V
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
    //   64: invokevirtual 277	java/io/InputStream:close	()V
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
  
  public static double b(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        str1 = a(paramInt);
      }
      catch (Throwable localThrowable1)
      {
        String str1;
        Object localObject1;
        Object localObject2;
        String[] arrayOfString;
        int n;
        int m;
        String str2 = null;
        int k = -1;
        i = -1;
        continue;
        return new double(paramInt, i, str2, m, null, k);
      }
      try
      {
        localObject1 = Locale.ENGLISH;
        localObject2 = new String(b(String.format((Locale)localObject1, "/proc/%d/status", new Object[] { Integer.valueOf(paramInt) })));
        localObject1 = new HashMap();
        localObject2 = ((String)localObject2).split("\n");
        k = localObject2.length;
        if (i >= k) {
          continue;
        }
        arrayOfString = localObject2[i];
        arrayOfString = arrayOfString.split(":");
        if (arrayOfString.length < 2) {
          break label252;
        }
        ((HashMap)localObject1).put(arrayOfString[0].trim(), arrayOfString[1].trim());
      }
      catch (Throwable localThrowable2)
      {
        i = -1;
        k = -1;
        n = -1;
        m = k;
        k = n;
        if (str1 == null) {
          continue;
        }
      }
      if ((i == -1) || (m == -1))
      {
        return null;
        i = Integer.parseInt((String)localThrowable2.get("PPid"));
        try
        {
          localObject2 = (String)localThrowable2.get("Uid");
          m = Integer.parseInt(localObject2.split("\\s+")[0]);
          try
          {
            k = Integer.parseInt((String)localThrowable2.get("TracerPid"));
          }
          catch (Throwable localThrowable3)
          {
            k = m;
          }
        }
        catch (Throwable localThrowable4)
        {
          k = -1;
        }
      }
      else
      {
        label252:
        i += 1;
      }
    }
  }
  
  public static String b(SparseArray<Object> paramSparseArray)
  {
    String str = (String)a(paramSparseArray, 106, String.class);
    paramSparseArray = str;
    if (str == null) {
      paramSparseArray = "";
    }
    return paramSparseArray;
  }
  
  /* Error */
  public static java.util.List<String> b(File paramFile)
  {
    // Byte code:
    //   0: new 327	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 328	java/util/ArrayList:<init>	()V
    //   7: astore_3
    //   8: new 263	java/util/jar/JarFile
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 329	java/util/jar/JarFile:<init>	(Ljava/io/File;)V
    //   16: astore_0
    //   17: aload_0
    //   18: aload_0
    //   19: ldc_w 331
    //   22: invokevirtual 335	java/util/jar/JarFile:getJarEntry	(Ljava/lang/String;)Ljava/util/jar/JarEntry;
    //   25: sipush 8192
    //   28: newarray byte
    //   30: invokestatic 337	com/tencent/turingfd/sdk/xq/for:a	(Ljava/util/jar/JarFile;Ljava/util/jar/JarEntry;[B)[Ljava/security/cert/Certificate;
    //   33: astore 4
    //   35: aload 4
    //   37: ifnull +47 -> 84
    //   40: aload 4
    //   42: arraylength
    //   43: istore_2
    //   44: iconst_0
    //   45: istore_1
    //   46: iload_1
    //   47: iload_2
    //   48: if_icmpge +36 -> 84
    //   51: aload_3
    //   52: aload 4
    //   54: iload_1
    //   55: aaload
    //   56: invokevirtual 343	java/security/cert/Certificate:getEncoded	()[B
    //   59: invokestatic 346	com/tencent/turingfd/sdk/xq/for:c	([B)Ljava/lang/String;
    //   62: invokeinterface 351 2 0
    //   67: pop
    //   68: iload_1
    //   69: iconst_1
    //   70: iadd
    //   71: istore_1
    //   72: goto -26 -> 46
    //   75: astore_3
    //   76: aload_0
    //   77: invokevirtual 352	java/util/jar/JarFile:close	()V
    //   80: aload_3
    //   81: athrow
    //   82: astore 4
    //   84: aload_0
    //   85: invokevirtual 352	java/util/jar/JarFile:close	()V
    //   88: aload_3
    //   89: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	paramFile	File
    //   45	27	1	i	int
    //   43	6	2	k	int
    //   7	45	3	localArrayList	java.util.ArrayList
    //   75	14	3	localList	java.util.List<String>
    //   33	20	4	arrayOfCertificate	java.security.cert.Certificate[]
    //   82	1	4	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   17	35	75	finally
    //   40	44	75	finally
    //   51	68	75	finally
    //   17	35	82	java/lang/Exception
    //   40	44	82	java/lang/Exception
    //   51	68	82	java/lang/Exception
  }
  
  public static void b(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Throwable paramCloseable) {}
  }
  
  public static final boolean b()
  {
    try
    {
      localObject = Class.forName("android.app.ActivityThread");
      localObject = ((Class)localObject).getMethod("currentApplication", new Class[0]);
      ((Method)localObject).setAccessible(true);
      localObject = (Context)((Method)localObject).invoke(null, new Object[0]);
    }
    catch (Exception localException)
    {
      Context localContext;
      for (;;)
      {
        Object localObject;
        Log.e("OpenIdHelper", "ActivityThread:currentApplication --> " + localException.toString());
        localContext = null;
      }
      return try.d().a(localContext, false);
    }
    if (localObject == null) {
      return false;
    }
  }
  
  /* Error */
  public static byte[] b(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: new 233	java/io/FileInputStream
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 395	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   12: astore_0
    //   13: new 397	java/io/ByteArrayOutputStream
    //   16: dup
    //   17: aload_0
    //   18: invokevirtual 400	java/io/FileInputStream:available	()I
    //   21: invokespecial 401	java/io/ByteArrayOutputStream:<init>	(I)V
    //   24: astore_3
    //   25: sipush 4096
    //   28: newarray byte
    //   30: astore_2
    //   31: aload_0
    //   32: aload_2
    //   33: invokevirtual 404	java/io/InputStream:read	([B)I
    //   36: istore_1
    //   37: iconst_m1
    //   38: iload_1
    //   39: if_icmpeq +33 -> 72
    //   42: aload_3
    //   43: aload_2
    //   44: iconst_0
    //   45: iload_1
    //   46: invokevirtual 409	java/io/OutputStream:write	([BII)V
    //   49: goto -18 -> 31
    //   52: astore_2
    //   53: new 88	java/io/IOException
    //   56: dup
    //   57: invokespecial 410	java/io/IOException:<init>	()V
    //   60: athrow
    //   61: astore_2
    //   62: aload_0
    //   63: invokestatic 243	com/tencent/turingfd/sdk/xq/for:b	(Ljava/io/Closeable;)V
    //   66: aload_3
    //   67: invokestatic 243	com/tencent/turingfd/sdk/xq/for:b	(Ljava/io/Closeable;)V
    //   70: aload_2
    //   71: athrow
    //   72: aload_3
    //   73: invokevirtual 413	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   76: astore_2
    //   77: aload_2
    //   78: ifnull +13 -> 91
    //   81: aload_0
    //   82: invokestatic 243	com/tencent/turingfd/sdk/xq/for:b	(Ljava/io/Closeable;)V
    //   85: aload_3
    //   86: invokestatic 243	com/tencent/turingfd/sdk/xq/for:b	(Ljava/io/Closeable;)V
    //   89: aload_2
    //   90: areturn
    //   91: ldc 50
    //   93: invokevirtual 416	java/lang/String:getBytes	()[B
    //   96: astore_2
    //   97: goto -16 -> 81
    //   100: astore_2
    //   101: aconst_null
    //   102: astore_3
    //   103: goto -41 -> 62
    //   106: astore_2
    //   107: aconst_null
    //   108: astore_3
    //   109: goto -56 -> 53
    //   112: astore_2
    //   113: aconst_null
    //   114: astore 4
    //   116: aload_3
    //   117: astore_0
    //   118: aload 4
    //   120: astore_3
    //   121: goto -59 -> 62
    //   124: astore_0
    //   125: aconst_null
    //   126: astore_3
    //   127: aload_2
    //   128: astore_0
    //   129: goto -76 -> 53
    //   132: astore_2
    //   133: goto -71 -> 62
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	paramString	String
    //   36	10	1	i	int
    //   3	41	2	arrayOfByte1	byte[]
    //   52	1	2	localThrowable1	Throwable
    //   61	10	2	localObject1	Object
    //   76	21	2	arrayOfByte2	byte[]
    //   100	1	2	localObject2	Object
    //   106	1	2	localThrowable2	Throwable
    //   112	16	2	localObject3	Object
    //   132	1	2	localObject4	Object
    //   1	126	3	localObject5	Object
    //   114	5	4	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   25	31	52	java/lang/Throwable
    //   31	37	52	java/lang/Throwable
    //   42	49	52	java/lang/Throwable
    //   72	77	52	java/lang/Throwable
    //   91	97	52	java/lang/Throwable
    //   53	61	61	finally
    //   13	25	100	finally
    //   13	25	106	java/lang/Throwable
    //   4	13	112	finally
    //   4	13	124	java/lang/Throwable
    //   25	31	132	finally
    //   31	37	132	finally
    //   42	49	132	finally
    //   72	77	132	finally
    //   91	97	132	finally
  }
  
  public static byte[] b(byte[] paramArrayOfByte)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance(new String(c("4D4435")));
      localMessageDigest.update(paramArrayOfByte);
      paramArrayOfByte = localMessageDigest.digest();
      return paramArrayOfByte;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte) {}
    return null;
  }
  
  public static byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = d(paramArrayOfByte2);
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
      k = i;
      if (i < 4) {
        k = 4;
      }
      paramArrayOfByte1 = new int[k];
      i = 0;
      while (i < k)
      {
        paramArrayOfByte1[i] = 0;
        i += 1;
      }
      i = (paramArrayOfByte1.length >>> 2) + 2;
      break;
    }
    a(arrayOfByte, paramArrayOfByte1);
    int i2 = paramArrayOfByte2.length - 1;
    i = paramArrayOfByte2[i2];
    int k = paramArrayOfByte2[0];
    k = 52 / (i2 + 1) + 6;
    int n;
    for (int m = 0; k > 0; m = n)
    {
      n = m - 1640531527;
      int i3 = n >>> 2 & 0x3;
      int i1 = 0;
      m = i;
      for (i = i1; i < i2; i = i1)
      {
        i1 = i + 1;
        int i4 = paramArrayOfByte2[i1];
        int i5 = paramArrayOfByte2[i];
        m = ((m ^ paramArrayOfByte1[(i & 0x3 ^ i3)]) + (i4 ^ n) ^ (m >>> 5 ^ i4 << 2) + (i4 >>> 3 ^ m << 4)) + i5;
        paramArrayOfByte2[i] = m;
      }
      i1 = paramArrayOfByte2[0];
      i = paramArrayOfByte2[i2] + ((paramArrayOfByte1[(i & 0x3 ^ i3)] ^ m) + (i1 ^ n) ^ (m >>> 5 ^ i1 << 2) + (i1 >>> 3 ^ m << 4));
      paramArrayOfByte2[i2] = i;
      k -= 1;
    }
    paramArrayOfByte1 = new byte[paramArrayOfByte2.length << 2];
    a(paramArrayOfByte2, paramArrayOfByte2.length, paramArrayOfByte1);
    return paramArrayOfByte1;
  }
  
  public static File c(Context paramContext)
  {
    paramContext = paramContext.getDir("turingfd", 0);
    if (paramContext == null) {
      return null;
    }
    return new File(paramContext, "mpdc1");
  }
  
  public static String c(byte[] paramArrayOfByte)
  {
    return a(b(paramArrayOfByte));
  }
  
  public static byte[] c()
  {
    int i = 0;
    try
    {
      Object localObject = new StringBuffer();
      while (i < 21)
      {
        ((StringBuffer)localObject).append((char)("http://pmir.3g.qq.com".charAt(i) + new int[] { -36, -46, -45, -77, -22, -10, 47, -77, -72, -69, -32, 25, 21, -21, -6, -75, -71, 31, -39, -49, -49 }[i]));
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
  
  public static byte[] c(String paramString)
  {
    int k = paramString.length() / 2;
    byte[] arrayOfByte = new byte[k];
    int i = 0;
    while (i < k)
    {
      int m = i * 2;
      arrayOfByte[i] = Integer.valueOf(paramString.substring(m, m + 2), 16).byteValue();
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static int d(Context paramContext)
  {
    return paramContext.getSharedPreferences("turingfd_protect_105668_38_xqMini", 0).getInt("301", 0);
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
      localObject = ((MessageDigest)localObject).digest();
      return localObject;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte) {}
    return null;
  }
  
  /* Error */
  public static String e(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: invokevirtual 492	android/content/Context:getPackageName	()Ljava/lang/String;
    //   7: astore 15
    //   9: aload 15
    //   11: invokestatic 82	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: ifeq +19 -> 33
    //   17: goto +1122 -> 1139
    //   20: aload 15
    //   22: ifnonnull +395 -> 417
    //   25: ldc 50
    //   27: astore_0
    //   28: ldc 2
    //   30: monitorexit
    //   31: aload_0
    //   32: areturn
    //   33: aload_0
    //   34: invokevirtual 496	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   37: astore 12
    //   39: aload 12
    //   41: aload 15
    //   43: bipush 64
    //   45: invokevirtual 502	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   48: astore 12
    //   50: aload 12
    //   52: getfield 508	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   55: astore 14
    //   57: aload 14
    //   59: ifnull +1080 -> 1139
    //   62: aload 14
    //   64: getfield 514	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   67: astore 17
    //   69: aload 17
    //   71: ifnull +1068 -> 1139
    //   74: new 148	java/io/File
    //   77: dup
    //   78: aload 17
    //   80: invokespecial 153	java/io/File:<init>	(Ljava/lang/String;)V
    //   83: astore 13
    //   85: aload 14
    //   87: getfield 518	android/content/pm/ApplicationInfo:flags	I
    //   90: istore_1
    //   91: aload 13
    //   93: invokevirtual 521	java/io/File:length	()J
    //   96: lstore_3
    //   97: aload 13
    //   99: invokevirtual 524	java/io/File:lastModified	()J
    //   102: ldc2_w 525
    //   105: ldiv
    //   106: lstore 5
    //   108: aload 12
    //   110: getfield 529	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   113: invokestatic 531	com/tencent/turingfd/sdk/xq/for:a	(Ljava/lang/String;)Ljava/lang/String;
    //   116: astore 16
    //   118: aload 12
    //   120: getfield 534	android/content/pm/PackageInfo:versionCode	I
    //   123: istore_2
    //   124: aload 12
    //   126: getfield 538	android/content/pm/PackageInfo:firstInstallTime	J
    //   129: lstore 7
    //   131: aload 12
    //   133: getfield 541	android/content/pm/PackageInfo:lastUpdateTime	J
    //   136: lstore 9
    //   138: invokestatic 544	java/lang/System:currentTimeMillis	()J
    //   141: pop2
    //   142: ldc 50
    //   144: astore 13
    //   146: aload 12
    //   148: getfield 548	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   151: astore 14
    //   153: aload 13
    //   155: astore 12
    //   157: aload 14
    //   159: ifnull +68 -> 227
    //   162: aload 13
    //   164: astore 12
    //   166: aload 14
    //   168: arraylength
    //   169: ifle +58 -> 227
    //   172: aload 14
    //   174: iconst_0
    //   175: aaload
    //   176: astore 12
    //   178: new 550	java/io/ByteArrayInputStream
    //   181: dup
    //   182: aload 12
    //   184: invokevirtual 553	android/content/pm/Signature:toByteArray	()[B
    //   187: invokespecial 554	java/io/ByteArrayInputStream:<init>	([B)V
    //   190: astore 12
    //   192: ldc_w 556
    //   195: invokestatic 561	java/security/cert/CertificateFactory:getInstance	(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;
    //   198: aload 12
    //   200: invokevirtual 565	java/security/cert/CertificateFactory:generateCertificate	(Ljava/io/InputStream;)Ljava/security/cert/Certificate;
    //   203: checkcast 567	java/security/cert/X509Certificate
    //   206: invokevirtual 568	java/security/cert/X509Certificate:getEncoded	()[B
    //   209: invokestatic 346	com/tencent/turingfd/sdk/xq/for:c	([B)Ljava/lang/String;
    //   212: astore 14
    //   214: aload 14
    //   216: astore 13
    //   218: aload 12
    //   220: invokestatic 243	com/tencent/turingfd/sdk/xq/for:b	(Ljava/io/Closeable;)V
    //   223: aload 13
    //   225: astore 12
    //   227: aload 12
    //   229: invokestatic 82	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   232: istore 11
    //   234: iload 11
    //   236: ifeq +943 -> 1179
    //   239: new 148	java/io/File
    //   242: dup
    //   243: aload 17
    //   245: invokespecial 153	java/io/File:<init>	(Ljava/lang/String;)V
    //   248: invokestatic 570	com/tencent/turingfd/sdk/xq/for:b	(Ljava/io/File;)Ljava/util/List;
    //   251: astore 13
    //   253: aload 13
    //   255: invokeinterface 573 1 0
    //   260: ifle +919 -> 1179
    //   263: aload 13
    //   265: iconst_0
    //   266: invokeinterface 574 2 0
    //   271: checkcast 64	java/lang/String
    //   274: invokestatic 531	com/tencent/turingfd/sdk/xq/for:a	(Ljava/lang/String;)Ljava/lang/String;
    //   277: astore 13
    //   279: aload 13
    //   281: astore 12
    //   283: new 107	java/lang/StringBuilder
    //   286: dup
    //   287: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   290: lload_3
    //   291: invokevirtual 577	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   294: ldc_w 297
    //   297: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: aload 12
    //   302: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: ldc_w 297
    //   308: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: aload 15
    //   313: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: ldc_w 297
    //   319: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: aload 16
    //   324: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: ldc_w 297
    //   330: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: iload_2
    //   334: invokevirtual 580	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   337: ldc_w 297
    //   340: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: lload 7
    //   345: invokevirtual 577	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   348: ldc_w 297
    //   351: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: lload 9
    //   356: invokevirtual 577	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   359: ldc_w 297
    //   362: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: iload_1
    //   366: invokevirtual 580	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   369: ldc_w 297
    //   372: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: lload 5
    //   377: invokevirtual 577	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   380: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   383: astore 15
    //   385: goto -365 -> 20
    //   388: aload 12
    //   390: invokestatic 243	com/tencent/turingfd/sdk/xq/for:b	(Ljava/io/Closeable;)V
    //   393: aload 13
    //   395: astore 12
    //   397: goto -170 -> 227
    //   400: astore_0
    //   401: ldc 2
    //   403: monitorexit
    //   404: aload_0
    //   405: athrow
    //   406: astore_0
    //   407: aconst_null
    //   408: astore 12
    //   410: aload 12
    //   412: invokestatic 243	com/tencent/turingfd/sdk/xq/for:b	(Ljava/io/Closeable;)V
    //   415: aload_0
    //   416: athrow
    //   417: aload 15
    //   419: invokevirtual 416	java/lang/String:getBytes	()[B
    //   422: invokestatic 448	com/tencent/turingfd/sdk/xq/for:b	([B)[B
    //   425: invokestatic 450	com/tencent/turingfd/sdk/xq/for:a	([B)Ljava/lang/String;
    //   428: astore 20
    //   430: aload_0
    //   431: invokestatic 582	com/tencent/turingfd/sdk/xq/for:c	(Landroid/content/Context;)Ljava/io/File;
    //   434: astore 13
    //   436: aload 13
    //   438: ifnonnull +9 -> 447
    //   441: aconst_null
    //   442: astore 13
    //   444: goto +738 -> 1182
    //   447: aload 13
    //   449: invokevirtual 219	java/io/File:exists	()Z
    //   452: ifne +10 -> 462
    //   455: ldc 50
    //   457: astore 13
    //   459: goto +723 -> 1182
    //   462: aload 13
    //   464: invokevirtual 585	java/io/File:isFile	()Z
    //   467: ifne +16 -> 483
    //   470: aload 13
    //   472: invokestatic 231	com/tencent/turingfd/sdk/xq/for:a	(Ljava/io/File;)Z
    //   475: pop
    //   476: ldc 50
    //   478: astore 13
    //   480: goto +702 -> 1182
    //   483: aconst_null
    //   484: astore 12
    //   486: aconst_null
    //   487: astore 17
    //   489: new 397	java/io/ByteArrayOutputStream
    //   492: dup
    //   493: invokespecial 586	java/io/ByteArrayOutputStream:<init>	()V
    //   496: astore 21
    //   498: aconst_null
    //   499: astore 16
    //   501: aconst_null
    //   502: astore 14
    //   504: new 588	java/io/RandomAccessFile
    //   507: dup
    //   508: aload 13
    //   510: ldc_w 590
    //   513: invokespecial 591	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   516: astore 13
    //   518: aload 13
    //   520: invokevirtual 595	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   523: astore 18
    //   525: aload 18
    //   527: astore 12
    //   529: aload 12
    //   531: invokevirtual 601	java/nio/channels/FileChannel:lock	()Ljava/nio/channels/FileLock;
    //   534: astore 17
    //   536: aload 17
    //   538: astore 16
    //   540: bipush 32
    //   542: invokestatic 607	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   545: astore 14
    //   547: aload 12
    //   549: aload 14
    //   551: invokevirtual 610	java/nio/channels/FileChannel:read	(Ljava/nio/ByteBuffer;)I
    //   554: istore_1
    //   555: iload_1
    //   556: ifle +82 -> 638
    //   559: aload 21
    //   561: aload 14
    //   563: invokevirtual 613	java/nio/ByteBuffer:array	()[B
    //   566: iconst_0
    //   567: iload_1
    //   568: invokevirtual 614	java/io/ByteArrayOutputStream:write	([BII)V
    //   571: goto -24 -> 547
    //   574: astore 14
    //   576: aconst_null
    //   577: astore 19
    //   579: aload 16
    //   581: ifnull +544 -> 1125
    //   584: aload 16
    //   586: invokevirtual 619	java/nio/channels/FileLock:isValid	()Z
    //   589: istore 11
    //   591: iload 11
    //   593: ifeq +532 -> 1125
    //   596: aload 13
    //   598: astore 17
    //   600: aload 12
    //   602: astore 18
    //   604: aload 16
    //   606: invokevirtual 622	java/nio/channels/FileLock:release	()V
    //   609: aconst_null
    //   610: astore 16
    //   612: aload 13
    //   614: astore 14
    //   616: aload 16
    //   618: astore 13
    //   620: aload 12
    //   622: invokestatic 243	com/tencent/turingfd/sdk/xq/for:b	(Ljava/io/Closeable;)V
    //   625: aload 14
    //   627: invokestatic 243	com/tencent/turingfd/sdk/xq/for:b	(Ljava/io/Closeable;)V
    //   630: aload 21
    //   632: invokestatic 243	com/tencent/turingfd/sdk/xq/for:b	(Ljava/io/Closeable;)V
    //   635: goto +547 -> 1182
    //   638: aload 21
    //   640: invokevirtual 623	java/io/ByteArrayOutputStream:toString	()Ljava/lang/String;
    //   643: astore 14
    //   645: aload 13
    //   647: astore 17
    //   649: aload 14
    //   651: astore 19
    //   653: aload 12
    //   655: astore 18
    //   657: aload 16
    //   659: ifnull +552 -> 1211
    //   662: aload 16
    //   664: invokevirtual 619	java/nio/channels/FileLock:isValid	()Z
    //   667: istore 11
    //   669: aload 13
    //   671: astore 17
    //   673: aload 14
    //   675: astore 19
    //   677: aload 12
    //   679: astore 18
    //   681: iload 11
    //   683: ifeq +528 -> 1211
    //   686: aload 13
    //   688: astore 17
    //   690: aload 14
    //   692: astore 19
    //   694: aload 12
    //   696: astore 18
    //   698: aload 16
    //   700: invokevirtual 622	java/nio/channels/FileLock:release	()V
    //   703: aload 13
    //   705: astore 16
    //   707: aload 14
    //   709: astore 13
    //   711: aload 16
    //   713: astore 14
    //   715: goto -95 -> 620
    //   718: astore_0
    //   719: aconst_null
    //   720: astore 13
    //   722: aload 16
    //   724: ifnull +20 -> 744
    //   727: aload 16
    //   729: invokevirtual 619	java/nio/channels/FileLock:isValid	()Z
    //   732: istore 11
    //   734: iload 11
    //   736: ifeq +8 -> 744
    //   739: aload 16
    //   741: invokevirtual 622	java/nio/channels/FileLock:release	()V
    //   744: aload 12
    //   746: invokestatic 243	com/tencent/turingfd/sdk/xq/for:b	(Ljava/io/Closeable;)V
    //   749: aload 13
    //   751: invokestatic 243	com/tencent/turingfd/sdk/xq/for:b	(Ljava/io/Closeable;)V
    //   754: aload 21
    //   756: invokestatic 243	com/tencent/turingfd/sdk/xq/for:b	(Ljava/io/Closeable;)V
    //   759: aload_0
    //   760: athrow
    //   761: aload 13
    //   763: aload 20
    //   765: invokestatic 627	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   768: ifeq +9 -> 777
    //   771: ldc 50
    //   773: astore_0
    //   774: goto -746 -> 28
    //   777: aload_0
    //   778: invokestatic 582	com/tencent/turingfd/sdk/xq/for:c	(Landroid/content/Context;)Ljava/io/File;
    //   781: astore 12
    //   783: aload 15
    //   785: astore_0
    //   786: aload 12
    //   788: ifnull -760 -> 28
    //   791: aconst_null
    //   792: astore 13
    //   794: aconst_null
    //   795: astore 14
    //   797: new 588	java/io/RandomAccessFile
    //   800: dup
    //   801: aload 12
    //   803: ldc_w 590
    //   806: invokespecial 591	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   809: astore 12
    //   811: aload 12
    //   813: invokevirtual 595	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   816: astore_0
    //   817: aload_0
    //   818: invokevirtual 601	java/nio/channels/FileChannel:lock	()Ljava/nio/channels/FileLock;
    //   821: astore 16
    //   823: aload 16
    //   825: astore 13
    //   827: aload 20
    //   829: invokevirtual 416	java/lang/String:getBytes	()[B
    //   832: astore 14
    //   834: aload 14
    //   836: arraylength
    //   837: invokestatic 607	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   840: astore 16
    //   842: aload 16
    //   844: aload 14
    //   846: invokevirtual 630	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   849: pop
    //   850: aload 16
    //   852: invokevirtual 634	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   855: pop
    //   856: aload 16
    //   858: invokevirtual 637	java/nio/ByteBuffer:hasRemaining	()Z
    //   861: ifeq +74 -> 935
    //   864: aload_0
    //   865: aload 16
    //   867: invokevirtual 639	java/nio/channels/FileChannel:write	(Ljava/nio/ByteBuffer;)I
    //   870: pop
    //   871: goto -15 -> 856
    //   874: astore 14
    //   876: aload 12
    //   878: astore 14
    //   880: aload_0
    //   881: astore 16
    //   883: aload 13
    //   885: ifnull +34 -> 919
    //   888: aload 13
    //   890: invokevirtual 619	java/nio/channels/FileLock:isValid	()Z
    //   893: istore 11
    //   895: aload 12
    //   897: astore 14
    //   899: aload_0
    //   900: astore 16
    //   902: iload 11
    //   904: ifeq +15 -> 919
    //   907: aload 13
    //   909: invokevirtual 622	java/nio/channels/FileLock:release	()V
    //   912: aload_0
    //   913: astore 16
    //   915: aload 12
    //   917: astore 14
    //   919: aload 16
    //   921: invokestatic 243	com/tencent/turingfd/sdk/xq/for:b	(Ljava/io/Closeable;)V
    //   924: aload 14
    //   926: invokestatic 243	com/tencent/turingfd/sdk/xq/for:b	(Ljava/io/Closeable;)V
    //   929: aload 15
    //   931: astore_0
    //   932: goto -904 -> 28
    //   935: aload_0
    //   936: aload 14
    //   938: arraylength
    //   939: i2l
    //   940: invokevirtual 643	java/nio/channels/FileChannel:truncate	(J)Ljava/nio/channels/FileChannel;
    //   943: pop
    //   944: aload 12
    //   946: astore 14
    //   948: aload_0
    //   949: astore 16
    //   951: aload 13
    //   953: ifnull -34 -> 919
    //   956: aload 12
    //   958: astore 14
    //   960: aload_0
    //   961: astore 16
    //   963: aload 13
    //   965: invokevirtual 619	java/nio/channels/FileLock:isValid	()Z
    //   968: ifeq -49 -> 919
    //   971: goto -64 -> 907
    //   974: aload 13
    //   976: ifnull +20 -> 996
    //   979: aload 13
    //   981: invokevirtual 619	java/nio/channels/FileLock:isValid	()Z
    //   984: istore 11
    //   986: iload 11
    //   988: ifeq +8 -> 996
    //   991: aload 13
    //   993: invokevirtual 622	java/nio/channels/FileLock:release	()V
    //   996: aload_0
    //   997: invokestatic 243	com/tencent/turingfd/sdk/xq/for:b	(Ljava/io/Closeable;)V
    //   1000: aload 12
    //   1002: invokestatic 243	com/tencent/turingfd/sdk/xq/for:b	(Ljava/io/Closeable;)V
    //   1005: aload 14
    //   1007: athrow
    //   1008: astore_0
    //   1009: aconst_null
    //   1010: astore_0
    //   1011: aload 14
    //   1013: astore 13
    //   1015: goto -139 -> 876
    //   1018: astore 14
    //   1020: aconst_null
    //   1021: astore 12
    //   1023: aconst_null
    //   1024: astore_0
    //   1025: goto -51 -> 974
    //   1028: astore_0
    //   1029: aconst_null
    //   1030: astore 12
    //   1032: aconst_null
    //   1033: astore_0
    //   1034: aload 14
    //   1036: astore 13
    //   1038: goto -162 -> 876
    //   1041: astore 12
    //   1043: goto +96 -> 1139
    //   1046: astore 12
    //   1048: aload 17
    //   1050: astore 12
    //   1052: aload 14
    //   1054: astore 16
    //   1056: goto -480 -> 576
    //   1059: astore_0
    //   1060: goto -338 -> 722
    //   1063: astore 16
    //   1065: aload 14
    //   1067: astore 16
    //   1069: goto -493 -> 576
    //   1072: astore_0
    //   1073: goto -351 -> 722
    //   1076: astore 14
    //   1078: goto -334 -> 744
    //   1081: astore 13
    //   1083: aload 14
    //   1085: astore 13
    //   1087: goto -211 -> 876
    //   1090: astore 14
    //   1092: goto -118 -> 974
    //   1095: astore 13
    //   1097: goto -101 -> 996
    //   1100: astore 13
    //   1102: aload 12
    //   1104: astore 14
    //   1106: aload_0
    //   1107: astore 16
    //   1109: goto -190 -> 919
    //   1112: astore 14
    //   1114: goto -140 -> 974
    //   1117: astore_0
    //   1118: goto -396 -> 722
    //   1121: astore_0
    //   1122: goto -712 -> 410
    //   1125: aconst_null
    //   1126: astore 16
    //   1128: aload 13
    //   1130: astore 14
    //   1132: aload 16
    //   1134: astore 13
    //   1136: goto -516 -> 620
    //   1139: aconst_null
    //   1140: astore 15
    //   1142: goto -1122 -> 20
    //   1145: astore 14
    //   1147: ldc2_w 644
    //   1150: lstore_3
    //   1151: goto -1054 -> 97
    //   1154: astore 13
    //   1156: ldc2_w 644
    //   1159: lstore 5
    //   1161: goto -1053 -> 108
    //   1164: astore 14
    //   1166: goto -778 -> 388
    //   1169: astore 12
    //   1171: aconst_null
    //   1172: astore 12
    //   1174: goto -786 -> 388
    //   1177: astore 13
    //   1179: goto -896 -> 283
    //   1182: aload 13
    //   1184: ifnonnull -423 -> 761
    //   1187: ldc 50
    //   1189: astore_0
    //   1190: goto -1162 -> 28
    //   1193: astore 12
    //   1195: aconst_null
    //   1196: astore 13
    //   1198: aload 17
    //   1200: astore 12
    //   1202: aload 14
    //   1204: astore 16
    //   1206: goto -630 -> 576
    //   1209: astore 12
    //   1211: aload 19
    //   1213: astore 13
    //   1215: aload 17
    //   1217: astore 14
    //   1219: aload 18
    //   1221: astore 12
    //   1223: goto -603 -> 620
    //   1226: astore 14
    //   1228: aconst_null
    //   1229: astore_0
    //   1230: goto -256 -> 974
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1233	0	paramContext	Context
    //   90	478	1	i	int
    //   123	211	2	k	int
    //   96	1055	3	l1	long
    //   106	1054	5	l2	long
    //   129	215	7	l3	long
    //   136	219	9	l4	long
    //   232	755	11	bool	boolean
    //   37	994	12	localObject1	Object
    //   1041	1	12	localThrowable1	Throwable
    //   1046	1	12	localThrowable2	Throwable
    //   1050	53	12	localObject2	Object
    //   1169	1	12	localThrowable3	Throwable
    //   1172	1	12	localObject3	Object
    //   1193	1	12	localThrowable4	Throwable
    //   1200	1	12	localObject4	Object
    //   1209	1	12	localIOException1	IOException
    //   1221	1	12	localObject5	Object
    //   83	954	13	localObject6	Object
    //   1081	1	13	localThrowable5	Throwable
    //   1085	1	13	localIOException2	IOException
    //   1095	1	13	localIOException3	IOException
    //   1100	29	13	localIOException4	IOException
    //   1134	1	13	localObject7	Object
    //   1154	1	13	localThrowable6	Throwable
    //   1177	6	13	localThrowable7	Throwable
    //   1196	18	13	localObject8	Object
    //   55	507	14	localObject9	Object
    //   574	1	14	localThrowable8	Throwable
    //   614	231	14	localObject10	Object
    //   874	1	14	localThrowable9	Throwable
    //   878	134	14	localObject11	Object
    //   1018	48	14	localObject12	Object
    //   1076	8	14	localIOException5	IOException
    //   1090	1	14	localObject13	Object
    //   1104	1	14	localObject14	Object
    //   1112	1	14	localObject15	Object
    //   1130	1	14	localObject16	Object
    //   1145	1	14	localThrowable10	Throwable
    //   1164	39	14	localThrowable11	Throwable
    //   1217	1	14	localObject17	Object
    //   1226	1	14	localObject18	Object
    //   7	1134	15	str1	String
    //   116	939	16	localObject19	Object
    //   1063	1	16	localThrowable12	Throwable
    //   1067	138	16	localObject20	Object
    //   67	1149	17	localObject21	Object
    //   523	697	18	localObject22	Object
    //   577	635	19	localObject23	Object
    //   428	400	20	str2	String
    //   496	259	21	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   3	17	400	finally
    //   33	39	400	finally
    //   39	50	400	finally
    //   50	57	400	finally
    //   62	69	400	finally
    //   74	91	400	finally
    //   91	97	400	finally
    //   97	108	400	finally
    //   108	142	400	finally
    //   146	153	400	finally
    //   166	172	400	finally
    //   218	223	400	finally
    //   227	234	400	finally
    //   239	279	400	finally
    //   283	385	400	finally
    //   388	393	400	finally
    //   410	417	400	finally
    //   417	436	400	finally
    //   447	455	400	finally
    //   462	476	400	finally
    //   489	498	400	finally
    //   584	591	400	finally
    //   604	609	400	finally
    //   620	635	400	finally
    //   662	669	400	finally
    //   698	703	400	finally
    //   727	734	400	finally
    //   739	744	400	finally
    //   744	761	400	finally
    //   761	771	400	finally
    //   777	783	400	finally
    //   888	895	400	finally
    //   907	912	400	finally
    //   919	929	400	finally
    //   963	971	400	finally
    //   979	986	400	finally
    //   991	996	400	finally
    //   996	1008	400	finally
    //   178	192	406	finally
    //   540	547	574	java/lang/Throwable
    //   547	555	574	java/lang/Throwable
    //   559	571	574	java/lang/Throwable
    //   638	645	574	java/lang/Throwable
    //   504	518	718	finally
    //   827	856	874	java/lang/Throwable
    //   856	871	874	java/lang/Throwable
    //   935	944	874	java/lang/Throwable
    //   811	817	1008	java/lang/Throwable
    //   797	811	1018	finally
    //   797	811	1028	java/lang/Throwable
    //   39	50	1041	java/lang/Throwable
    //   518	525	1046	java/lang/Throwable
    //   518	525	1059	finally
    //   529	536	1063	java/lang/Throwable
    //   529	536	1072	finally
    //   739	744	1076	java/io/IOException
    //   817	823	1081	java/lang/Throwable
    //   817	823	1090	finally
    //   991	996	1095	java/io/IOException
    //   907	912	1100	java/io/IOException
    //   827	856	1112	finally
    //   856	871	1112	finally
    //   935	944	1112	finally
    //   540	547	1117	finally
    //   547	555	1117	finally
    //   559	571	1117	finally
    //   638	645	1117	finally
    //   192	214	1121	finally
    //   91	97	1145	java/lang/Throwable
    //   97	108	1154	java/lang/Throwable
    //   192	214	1164	java/lang/Throwable
    //   178	192	1169	java/lang/Throwable
    //   239	279	1177	java/lang/Throwable
    //   504	518	1193	java/lang/Throwable
    //   604	609	1209	java/io/IOException
    //   698	703	1209	java/io/IOException
    //   811	817	1226	finally
  }
  
  /* Error */
  public static boolean f(Context paramContext)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: getstatic 649	com/tencent/turingfd/sdk/xq/for:j	Landroid/content/Context;
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
    //   28: invokevirtual 653	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   31: astore_0
    //   32: aload_0
    //   33: ifnonnull +8 -> 41
    //   36: iconst_0
    //   37: istore_1
    //   38: goto -25 -> 13
    //   41: aload_0
    //   42: putstatic 649	com/tencent/turingfd/sdk/xq/for:j	Landroid/content/Context;
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
  
  public static Context get()
  {
    try
    {
      Context localContext = j;
      return localContext;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.for
 * JD-Core Version:    0.7.0.1
 */