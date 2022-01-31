package com.tencent.tvkbeacon.core.c;

import android.content.Context;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.http.util.EncodingUtils;

public final class a
{
  private static final AtomicInteger a = new AtomicInteger(0);
  private static String b;
  
  public static int a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    int j = paramInt1;
    if (paramString != null) {}
    try
    {
      i = Integer.valueOf(paramString).intValue();
      j = paramInt1;
      if (i >= paramInt2)
      {
        j = paramInt1;
        if (i <= paramInt3) {
          j = i;
        }
      }
      return j;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        int i = paramInt1;
      }
    }
    catch (Throwable paramString)
    {
      c.a(paramString);
    }
    return paramInt1;
  }
  
  public static long a(long paramLong)
  {
    return new Date().getTime() + paramLong;
  }
  
  public static long a(String paramString, long paramLong)
  {
    long l2 = paramLong;
    if (paramString != null) {}
    try
    {
      l1 = Long.valueOf(paramString).longValue();
      l2 = paramLong;
      if (l1 >= 1000L)
      {
        l2 = paramLong;
        if (l1 <= 20000L) {
          l2 = l1;
        }
      }
      return l2;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        long l1 = paramLong;
      }
    }
    catch (Throwable paramString)
    {
      c.a(paramString);
    }
    return paramLong;
  }
  
  /* Error */
  public static Object a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +8 -> 9
    //   4: aload_0
    //   5: arraylength
    //   6: ifge +5 -> 11
    //   9: aconst_null
    //   10: areturn
    //   11: new 64	java/io/ByteArrayInputStream
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 67	java/io/ByteArrayInputStream:<init>	([B)V
    //   19: astore_3
    //   20: new 69	java/io/ObjectInputStream
    //   23: dup
    //   24: aload_3
    //   25: invokespecial 72	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   28: astore_1
    //   29: aload_1
    //   30: astore_0
    //   31: aload_1
    //   32: invokevirtual 76	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   35: astore_2
    //   36: aload_1
    //   37: invokestatic 79	com/tencent/tvkbeacon/core/c/a:a	(Ljava/io/Closeable;)V
    //   40: aload_3
    //   41: invokestatic 79	com/tencent/tvkbeacon/core/c/a:a	(Ljava/io/Closeable;)V
    //   44: aload_2
    //   45: areturn
    //   46: astore_2
    //   47: aconst_null
    //   48: astore_1
    //   49: aload_1
    //   50: astore_0
    //   51: aload_2
    //   52: invokestatic 39	com/tencent/tvkbeacon/core/c/c:a	(Ljava/lang/Throwable;)V
    //   55: aload_1
    //   56: astore_0
    //   57: aload_2
    //   58: invokevirtual 83	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   61: iconst_0
    //   62: anewarray 4	java/lang/Object
    //   65: invokestatic 87	com/tencent/tvkbeacon/core/c/c:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   68: aload_1
    //   69: invokestatic 79	com/tencent/tvkbeacon/core/c/a:a	(Ljava/io/Closeable;)V
    //   72: aload_3
    //   73: invokestatic 79	com/tencent/tvkbeacon/core/c/a:a	(Ljava/io/Closeable;)V
    //   76: aconst_null
    //   77: areturn
    //   78: astore_0
    //   79: aconst_null
    //   80: astore_2
    //   81: aload_0
    //   82: astore_1
    //   83: aload_2
    //   84: invokestatic 79	com/tencent/tvkbeacon/core/c/a:a	(Ljava/io/Closeable;)V
    //   87: aload_3
    //   88: invokestatic 79	com/tencent/tvkbeacon/core/c/a:a	(Ljava/io/Closeable;)V
    //   91: aload_1
    //   92: athrow
    //   93: astore_1
    //   94: aload_0
    //   95: astore_2
    //   96: goto -13 -> 83
    //   99: astore_2
    //   100: goto -51 -> 49
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	paramArrayOfByte	byte[]
    //   28	64	1	localObject1	Object
    //   93	1	1	localObject2	Object
    //   35	10	2	localObject3	Object
    //   46	12	2	localThrowable1	Throwable
    //   80	16	2	localObject4	Object
    //   99	1	2	localThrowable2	Throwable
    //   19	69	3	localByteArrayInputStream	ByteArrayInputStream
    // Exception table:
    //   from	to	target	type
    //   20	29	46	java/lang/Throwable
    //   20	29	78	finally
    //   31	36	93	finally
    //   51	55	93	finally
    //   57	68	93	finally
    //   31	36	99	java/lang/Throwable
  }
  
  public static String a()
  {
    try
    {
      String str = new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(new Date());
      return str;
    }
    catch (Throwable localThrowable)
    {
      c.a(localThrowable);
    }
    return "";
  }
  
  public static String a(Context paramContext)
  {
    try
    {
      String str2 = com.tencent.tvkbeacon.core.info.c.a(paramContext).d();
      String str1 = "";
      com.tencent.tvkbeacon.core.info.b localb = com.tencent.tvkbeacon.core.info.b.a(paramContext);
      paramContext = str1;
      if (localb != null) {
        paramContext = localb.b();
      }
      int i = (int)(Math.random() * 2147483647.0D);
      paramContext = e(paramContext + "_" + str2 + "_" + new Date().getTime() + "_" + i);
      return paramContext;
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  public static String a(Context paramContext, int paramInt, String paramString)
  {
    try
    {
      paramContext = e(String.format("%1$s_%2$s_%3$s_%4$s_%5$s", new Object[] { com.tencent.tvkbeacon.core.info.c.a(paramContext).d(), paramString, Long.valueOf(new Date().getTime()), Integer.valueOf(a.addAndGet(1)), Integer.valueOf(paramInt) }));
      return paramContext;
    }
    catch (Exception paramContext)
    {
      c.d("get Rid error", new Object[] { paramContext });
    }
    return null;
  }
  
  /* Error */
  public static ArrayList<String> a(String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 174	java/util/ArrayList
    //   5: dup
    //   6: invokespecial 175	java/util/ArrayList:<init>	()V
    //   9: astore 4
    //   11: invokestatic 181	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   14: aload_0
    //   15: invokevirtual 185	java/lang/Runtime:exec	([Ljava/lang/String;)Ljava/lang/Process;
    //   18: astore_0
    //   19: new 187	java/io/BufferedReader
    //   22: dup
    //   23: new 189	java/io/InputStreamReader
    //   26: dup
    //   27: aload_0
    //   28: invokevirtual 195	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   31: invokespecial 196	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   34: invokespecial 199	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   37: astore_1
    //   38: aload_1
    //   39: invokevirtual 202	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   42: astore_2
    //   43: aload_2
    //   44: ifnull +36 -> 80
    //   47: aload 4
    //   49: aload_2
    //   50: invokevirtual 206	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   53: pop
    //   54: goto -16 -> 38
    //   57: astore 4
    //   59: aconst_null
    //   60: astore_0
    //   61: aload_0
    //   62: astore_3
    //   63: aload_1
    //   64: astore_2
    //   65: aload 4
    //   67: invokestatic 39	com/tencent/tvkbeacon/core/c/c:a	(Ljava/lang/Throwable;)V
    //   70: aload_1
    //   71: invokestatic 79	com/tencent/tvkbeacon/core/c/a:a	(Ljava/io/Closeable;)V
    //   74: aload_0
    //   75: invokestatic 79	com/tencent/tvkbeacon/core/c/a:a	(Ljava/io/Closeable;)V
    //   78: aconst_null
    //   79: areturn
    //   80: new 187	java/io/BufferedReader
    //   83: dup
    //   84: new 189	java/io/InputStreamReader
    //   87: dup
    //   88: aload_0
    //   89: invokevirtual 209	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
    //   92: invokespecial 196	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   95: invokespecial 199	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   98: astore_0
    //   99: aload_0
    //   100: astore_3
    //   101: aload_1
    //   102: astore_2
    //   103: aload_0
    //   104: invokevirtual 202	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   107: astore 5
    //   109: aload 5
    //   111: ifnull +23 -> 134
    //   114: aload_0
    //   115: astore_3
    //   116: aload_1
    //   117: astore_2
    //   118: aload 4
    //   120: aload 5
    //   122: invokevirtual 206	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   125: pop
    //   126: goto -27 -> 99
    //   129: astore 4
    //   131: goto -70 -> 61
    //   134: aload_1
    //   135: invokestatic 79	com/tencent/tvkbeacon/core/c/a:a	(Ljava/io/Closeable;)V
    //   138: aload_0
    //   139: invokestatic 79	com/tencent/tvkbeacon/core/c/a:a	(Ljava/io/Closeable;)V
    //   142: aload 4
    //   144: areturn
    //   145: astore_0
    //   146: aconst_null
    //   147: astore_1
    //   148: aload_1
    //   149: invokestatic 79	com/tencent/tvkbeacon/core/c/a:a	(Ljava/io/Closeable;)V
    //   152: aload_3
    //   153: invokestatic 79	com/tencent/tvkbeacon/core/c/a:a	(Ljava/io/Closeable;)V
    //   156: aload_0
    //   157: athrow
    //   158: astore_0
    //   159: goto -11 -> 148
    //   162: astore_0
    //   163: aload_2
    //   164: astore_1
    //   165: goto -17 -> 148
    //   168: astore 4
    //   170: aconst_null
    //   171: astore_0
    //   172: aconst_null
    //   173: astore_1
    //   174: goto -113 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	paramArrayOfString	String[]
    //   37	137	1	localObject1	Object
    //   42	122	2	localObject2	Object
    //   1	152	3	arrayOfString	String[]
    //   9	39	4	localArrayList	ArrayList
    //   57	62	4	localThrowable1	Throwable
    //   129	14	4	localThrowable2	Throwable
    //   168	1	4	localThrowable3	Throwable
    //   107	14	5	str	String
    // Exception table:
    //   from	to	target	type
    //   38	43	57	java/lang/Throwable
    //   47	54	57	java/lang/Throwable
    //   80	99	57	java/lang/Throwable
    //   103	109	129	java/lang/Throwable
    //   118	126	129	java/lang/Throwable
    //   11	38	145	finally
    //   38	43	158	finally
    //   47	54	158	finally
    //   80	99	158	finally
    //   65	70	162	finally
    //   103	109	162	finally
    //   118	126	162	finally
    //   11	38	168	java/lang/Throwable
  }
  
  public static Date a(String paramString)
  {
    if ((paramString == null) || (paramString.trim().length() <= 0)) {
      return null;
    }
    try
    {
      paramString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).parse(paramString);
      return paramString;
    }
    catch (ParseException paramString)
    {
      c.a(paramString);
    }
    return null;
  }
  
  public static HashSet<String> a(ArrayList<String> paramArrayList)
  {
    int i = paramArrayList.size();
    if ((paramArrayList != null) && (i > 0))
    {
      HashSet localHashSet = new HashSet(i);
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        localHashSet.add((String)paramArrayList.next());
      }
      return localHashSet;
    }
    return null;
  }
  
  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable)
    {
      paramCloseable.printStackTrace();
    }
  }
  
  public static boolean a(String paramString, boolean paramBoolean)
  {
    if (paramString != null) {
      try
      {
        if (paramString.toLowerCase().equals("y")) {
          return true;
        }
        boolean bool = paramString.toLowerCase().equals("n");
        if (bool) {
          return false;
        }
      }
      catch (Throwable paramString)
      {
        c.a(paramString);
      }
    }
    return paramBoolean;
  }
  
  /* Error */
  public static byte[] a(Object paramObject)
  {
    // Byte code:
    //   0: ldc_w 271
    //   3: iconst_0
    //   4: anewarray 4	java/lang/Object
    //   7: invokestatic 273	com/tencent/tvkbeacon/core/c/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   10: aload_0
    //   11: ifnull +13 -> 24
    //   14: ldc_w 275
    //   17: aload_0
    //   18: invokevirtual 280	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   21: ifne +15 -> 36
    //   24: ldc_w 282
    //   27: iconst_0
    //   28: anewarray 4	java/lang/Object
    //   31: invokestatic 87	com/tencent/tvkbeacon/core/c/c:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   34: aconst_null
    //   35: areturn
    //   36: new 284	java/io/ByteArrayOutputStream
    //   39: dup
    //   40: invokespecial 285	java/io/ByteArrayOutputStream:<init>	()V
    //   43: astore 4
    //   45: new 287	java/io/ObjectOutputStream
    //   48: dup
    //   49: aload 4
    //   51: invokespecial 290	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   54: astore_2
    //   55: aload_2
    //   56: astore_1
    //   57: aload_2
    //   58: aload_0
    //   59: invokevirtual 294	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   62: aload_2
    //   63: astore_1
    //   64: aload_2
    //   65: invokevirtual 297	java/io/ObjectOutputStream:flush	()V
    //   68: aload_2
    //   69: astore_1
    //   70: aload 4
    //   72: invokevirtual 301	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   75: astore_0
    //   76: aload_2
    //   77: invokestatic 79	com/tencent/tvkbeacon/core/c/a:a	(Ljava/io/Closeable;)V
    //   80: aload 4
    //   82: invokestatic 79	com/tencent/tvkbeacon/core/c/a:a	(Ljava/io/Closeable;)V
    //   85: aload_0
    //   86: areturn
    //   87: astore_3
    //   88: aconst_null
    //   89: astore_0
    //   90: aload_0
    //   91: astore_1
    //   92: aload_3
    //   93: invokestatic 39	com/tencent/tvkbeacon/core/c/c:a	(Ljava/lang/Throwable;)V
    //   96: aload_0
    //   97: astore_1
    //   98: aload_3
    //   99: invokevirtual 83	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   102: iconst_0
    //   103: anewarray 4	java/lang/Object
    //   106: invokestatic 87	com/tencent/tvkbeacon/core/c/c:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   109: aload_0
    //   110: invokestatic 79	com/tencent/tvkbeacon/core/c/a:a	(Ljava/io/Closeable;)V
    //   113: aload 4
    //   115: invokestatic 79	com/tencent/tvkbeacon/core/c/a:a	(Ljava/io/Closeable;)V
    //   118: aconst_null
    //   119: areturn
    //   120: astore_0
    //   121: aconst_null
    //   122: astore_1
    //   123: aload_1
    //   124: invokestatic 79	com/tencent/tvkbeacon/core/c/a:a	(Ljava/io/Closeable;)V
    //   127: aload 4
    //   129: invokestatic 79	com/tencent/tvkbeacon/core/c/a:a	(Ljava/io/Closeable;)V
    //   132: aload_0
    //   133: athrow
    //   134: astore_0
    //   135: goto -12 -> 123
    //   138: astore_3
    //   139: aload_2
    //   140: astore_0
    //   141: goto -51 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	paramObject	Object
    //   56	68	1	localObject	Object
    //   54	86	2	localObjectOutputStream	java.io.ObjectOutputStream
    //   87	12	3	localThrowable1	Throwable
    //   138	1	3	localThrowable2	Throwable
    //   43	85	4	localByteArrayOutputStream	ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   45	55	87	java/lang/Throwable
    //   45	55	120	finally
    //   57	62	134	finally
    //   64	68	134	finally
    //   70	76	134	finally
    //   92	96	134	finally
    //   98	109	134	finally
    //   57	62	138	java/lang/Throwable
    //   64	68	138	java/lang/Throwable
    //   70	76	138	java/lang/Throwable
  }
  
  public static byte[] a(byte[] paramArrayOfByte, String paramString)
  {
    if (paramArrayOfByte == null) {
      return paramArrayOfByte;
    }
    c.b("enD:} %d %d", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(3) });
    if ((paramString == null) || (paramArrayOfByte == null)) {
      return null;
    }
    try
    {
      int i = paramString.length();
      while (i < 16)
      {
        paramString = paramString + "0";
        i += 1;
      }
      paramString = paramString.substring(0, 16);
      SecretKeySpec localSecretKeySpec = new SecretKeySpec(paramString.getBytes(), "AES");
      Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      localCipher.init(1, localSecretKeySpec, new IvParameterSpec(paramString.getBytes()));
      paramArrayOfByte = localCipher.doFinal(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      c.a(paramArrayOfByte);
      c.d("err enD: %s", new Object[] { paramArrayOfByte.toString() });
    }
    return null;
  }
  
  public static String b(long paramLong)
  {
    try
    {
      Object localObject = new Date(paramLong);
      localObject = new SimpleDateFormat("yyyy-MM-dd", Locale.US).format((Date)localObject);
      return localObject;
    }
    catch (Throwable localThrowable) {}
    return "";
  }
  
  public static String b(Context paramContext)
  {
    try
    {
      if (i.a(b))
      {
        String str = "on_app_first_install_time_" + com.tencent.tvkbeacon.core.info.a.g(paramContext);
        long l2 = com.tencent.tvkbeacon.core.a.c.a(paramContext).b(str);
        long l1 = l2;
        if (l2 == 0L)
        {
          l1 = new Date().getTime();
          com.tencent.tvkbeacon.core.a.b.d().a(new a.1(paramContext, str, l1));
        }
        b = String.valueOf(l1);
        c.b("[cover] process: %s, getAppFirstInstallTime: %s", new Object[] { str, b });
      }
      c.b("[cover] getAppFirstInstallTime: %s", new Object[] { b });
      paramContext = b;
      return paramContext;
    }
    finally {}
  }
  
  public static String b(String paramString)
  {
    String str2 = "";
    String str1 = str2;
    try
    {
      FileInputStream localFileInputStream = new FileInputStream(paramString);
      str1 = str2;
      byte[] arrayOfByte = new byte[localFileInputStream.available()];
      str1 = str2;
      localFileInputStream.read(arrayOfByte);
      str1 = str2;
      str2 = EncodingUtils.getString(arrayOfByte, "UTF-8");
      str1 = str2;
      localFileInputStream.close();
      return str2;
    }
    catch (Exception localException)
    {
      c.d("Read file %s failed.", new Object[] { paramString });
    }
    return str1;
  }
  
  private static byte[] b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return paramArrayOfByte;
    }
    c.b("zp: %s len: %s", new Object[] { Integer.valueOf(2), Integer.valueOf(paramArrayOfByte.length) });
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(localByteArrayOutputStream);
      localGZIPOutputStream.write(paramArrayOfByte);
      localGZIPOutputStream.finish();
      localGZIPOutputStream.close();
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      localByteArrayOutputStream.close();
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      c.a(paramArrayOfByte);
      c.d("err zp : %s", new Object[] { paramArrayOfByte.toString() });
    }
    return null;
  }
  
  public static byte[] b(byte[] paramArrayOfByte, String paramString)
  {
    if (paramArrayOfByte == null) {
      return paramArrayOfByte;
    }
    if ((paramString == null) || (paramArrayOfByte == null)) {
      return null;
    }
    try
    {
      int i = paramString.length();
      while (i < 16)
      {
        paramString = paramString + "0";
        i += 1;
      }
      paramString = paramString.substring(0, 16);
      SecretKeySpec localSecretKeySpec = new SecretKeySpec(paramString.getBytes(), "AES");
      Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      localCipher.init(2, localSecretKeySpec, new IvParameterSpec(paramString.getBytes()));
      paramArrayOfByte = localCipher.doFinal(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      c.a(paramArrayOfByte);
      c.d("err unD: %s", new Object[] { paramArrayOfByte.toString() });
    }
    return null;
  }
  
  public static boolean c(String paramString)
  {
    return paramString.startsWith("rqd_");
  }
  
  private static byte[] c(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return paramArrayOfByte;
    }
    c.b("unzp: %s len: %s", new Object[] { Integer.valueOf(2), Integer.valueOf(paramArrayOfByte.length) });
    GZIPInputStream localGZIPInputStream;
    byte[] arrayOfByte;
    ByteArrayOutputStream localByteArrayOutputStream;
    try
    {
      paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
      localGZIPInputStream = new GZIPInputStream(paramArrayOfByte);
      arrayOfByte = new byte[1024];
      localByteArrayOutputStream = new ByteArrayOutputStream();
      for (;;)
      {
        int i = localGZIPInputStream.read(arrayOfByte, 0, 1024);
        if (i == -1) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      arrayOfByte = localByteArrayOutputStream.toByteArray();
    }
    catch (Throwable paramArrayOfByte)
    {
      c.a(paramArrayOfByte);
      c.d("err unzp}" + paramArrayOfByte.toString(), new Object[0]);
      return null;
    }
    localByteArrayOutputStream.flush();
    localByteArrayOutputStream.close();
    localGZIPInputStream.close();
    paramArrayOfByte.close();
    return arrayOfByte;
  }
  
  public static byte[] c(byte[] paramArrayOfByte, String paramString)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    try
    {
      paramArrayOfByte = a(b(paramArrayOfByte), paramString);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      c.a(paramArrayOfByte);
    }
    return null;
  }
  
  private static String d(String paramString)
  {
    int i = 0;
    try
    {
      Object localObject = MessageDigest.getInstance("MD5").digest(paramString.getBytes());
      StringBuilder localStringBuilder = new StringBuilder();
      int j = localObject.length;
      while (i < j)
      {
        int k = localObject[i] & 0xFF;
        if (k < 16) {
          localStringBuilder.append(0);
        }
        localStringBuilder.append(Integer.toHexString(k));
        i += 1;
      }
      localObject = localStringBuilder.toString();
      return localObject;
    }
    catch (Exception localException)
    {
      c.a(localException);
    }
    return paramString;
  }
  
  public static byte[] d(byte[] paramArrayOfByte, String paramString)
  {
    try
    {
      paramArrayOfByte = c(b(paramArrayOfByte, paramString));
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      c.a(paramArrayOfByte);
    }
    return null;
  }
  
  private static String e(String paramString)
  {
    String str = d(paramString);
    paramString = str;
    if (str != null) {}
    try
    {
      paramString = str.substring(8, 24);
      return paramString;
    }
    catch (Exception paramString) {}
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.core.c.a
 * JD-Core Version:    0.7.0.1
 */