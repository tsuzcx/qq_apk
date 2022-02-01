package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.Proxy;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Process;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.tencent.mobileqq.qmethodmonitor.monitor.NetworkMonitor;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class const
{
  public static Context a;
  
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
  
  /* Error */
  public static else a(else paramelse, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +297 -> 298
    //   4: aload_1
    //   5: arraylength
    //   6: ifne +5 -> 11
    //   9: aload_0
    //   10: areturn
    //   11: aload_1
    //   12: invokestatic 18	com/tencent/turingfd/sdk/xq/const:g	()[B
    //   15: invokestatic 21	com/tencent/turingfd/sdk/xq/const:a	([B[B)[B
    //   18: astore_1
    //   19: aload_1
    //   20: ifnull +278 -> 298
    //   23: aload_1
    //   24: arraylength
    //   25: ifne +5 -> 30
    //   28: aload_0
    //   29: areturn
    //   30: new 23	java/io/ByteArrayInputStream
    //   33: dup
    //   34: aload_1
    //   35: invokespecial 27	java/io/ByteArrayInputStream:<init>	([B)V
    //   38: astore_3
    //   39: new 29	java/util/zip/InflaterInputStream
    //   42: dup
    //   43: aload_3
    //   44: invokespecial 32	java/util/zip/InflaterInputStream:<init>	(Ljava/io/InputStream;)V
    //   47: astore 4
    //   49: new 34	java/io/ByteArrayOutputStream
    //   52: dup
    //   53: invokespecial 37	java/io/ByteArrayOutputStream:<init>	()V
    //   56: astore 5
    //   58: aload 4
    //   60: invokevirtual 41	java/util/zip/InflaterInputStream:read	()I
    //   63: istore_2
    //   64: iload_2
    //   65: iconst_m1
    //   66: if_icmpeq +12 -> 78
    //   69: aload 5
    //   71: iload_2
    //   72: invokevirtual 45	java/io/ByteArrayOutputStream:write	(I)V
    //   75: goto -17 -> 58
    //   78: aload 5
    //   80: invokevirtual 48	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   83: astore_1
    //   84: aload_3
    //   85: invokevirtual 51	java/io/ByteArrayInputStream:close	()V
    //   88: aload 4
    //   90: invokevirtual 52	java/util/zip/InflaterInputStream:close	()V
    //   93: aload 5
    //   95: invokevirtual 53	java/io/ByteArrayOutputStream:close	()V
    //   98: goto +60 -> 158
    //   101: astore_3
    //   102: aload_3
    //   103: invokevirtual 56	java/io/IOException:printStackTrace	()V
    //   106: goto +52 -> 158
    //   109: astore_0
    //   110: aload_3
    //   111: invokevirtual 51	java/io/ByteArrayInputStream:close	()V
    //   114: aload 4
    //   116: invokevirtual 52	java/util/zip/InflaterInputStream:close	()V
    //   119: aload 5
    //   121: invokevirtual 53	java/io/ByteArrayOutputStream:close	()V
    //   124: goto +8 -> 132
    //   127: astore_1
    //   128: aload_1
    //   129: invokevirtual 56	java/io/IOException:printStackTrace	()V
    //   132: aload_0
    //   133: athrow
    //   134: aconst_null
    //   135: astore_1
    //   136: aload_3
    //   137: invokevirtual 51	java/io/ByteArrayInputStream:close	()V
    //   140: aload 4
    //   142: invokevirtual 52	java/util/zip/InflaterInputStream:close	()V
    //   145: aload 5
    //   147: invokevirtual 53	java/io/ByteArrayOutputStream:close	()V
    //   150: goto +8 -> 158
    //   153: astore_3
    //   154: aload_3
    //   155: invokevirtual 56	java/io/IOException:printStackTrace	()V
    //   158: aload_1
    //   159: ifnull +139 -> 298
    //   162: aload_1
    //   163: arraylength
    //   164: ifne +5 -> 169
    //   167: aload_0
    //   168: areturn
    //   169: new 58	com/tencent/turingfd/sdk/xq/Ara
    //   172: dup
    //   173: invokespecial 59	com/tencent/turingfd/sdk/xq/Ara:<init>	()V
    //   176: astore_3
    //   177: aload_1
    //   178: arraylength
    //   179: iconst_4
    //   180: if_icmplt +108 -> 288
    //   183: new 61	com/tencent/turingfd/sdk/xq/try
    //   186: dup
    //   187: aload_1
    //   188: iconst_4
    //   189: invokespecial 64	com/tencent/turingfd/sdk/xq/try:<init>	([BI)V
    //   192: astore_1
    //   193: aload_1
    //   194: ldc 66
    //   196: putfield 70	com/tencent/turingfd/sdk/xq/try:b	Ljava/lang/String;
    //   199: aload_3
    //   200: getfield 73	com/tencent/turingfd/sdk/xq/Ara:b	Lcom/tencent/turingfd/sdk/xq/if;
    //   203: aload_1
    //   204: invokevirtual 78	com/tencent/turingfd/sdk/xq/if:a	(Lcom/tencent/turingfd/sdk/xq/try;)V
    //   207: aload_1
    //   208: aload_3
    //   209: getfield 73	com/tencent/turingfd/sdk/xq/Ara:b	Lcom/tencent/turingfd/sdk/xq/if;
    //   212: getfield 82	com/tencent/turingfd/sdk/xq/if:j	[B
    //   215: invokestatic 88	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   218: putfield 91	com/tencent/turingfd/sdk/xq/try:a	Ljava/nio/ByteBuffer;
    //   221: getstatic 94	com/tencent/turingfd/sdk/xq/Ara:a	Ljava/util/HashMap;
    //   224: ifnonnull +28 -> 252
    //   227: new 96	java/util/HashMap
    //   230: dup
    //   231: invokespecial 97	java/util/HashMap:<init>	()V
    //   234: astore 4
    //   236: aload 4
    //   238: putstatic 94	com/tencent/turingfd/sdk/xq/Ara:a	Ljava/util/HashMap;
    //   241: aload 4
    //   243: ldc 99
    //   245: iconst_0
    //   246: newarray byte
    //   248: invokevirtual 103	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   251: pop
    //   252: aload_3
    //   253: aload_1
    //   254: getstatic 94	com/tencent/turingfd/sdk/xq/Ara:a	Ljava/util/HashMap;
    //   257: iconst_0
    //   258: iconst_0
    //   259: invokevirtual 106	com/tencent/turingfd/sdk/xq/try:a	(Ljava/util/Map;IZ)Ljava/util/HashMap;
    //   262: putfield 109	com/tencent/turingfd/sdk/xq/Ara:c	Ljava/util/HashMap;
    //   265: aload_3
    //   266: ldc 111
    //   268: aload_0
    //   269: invokevirtual 114	com/tencent/turingfd/sdk/xq/Ara:a	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   272: checkcast 116	com/tencent/turingfd/sdk/xq/else
    //   275: astore_1
    //   276: aload_1
    //   277: areturn
    //   278: astore_0
    //   279: new 118	java/lang/RuntimeException
    //   282: dup
    //   283: aload_0
    //   284: invokespecial 121	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   287: athrow
    //   288: new 123	java/lang/IllegalArgumentException
    //   291: dup
    //   292: ldc 125
    //   294: invokespecial 128	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   297: athrow
    //   298: aload_0
    //   299: areturn
    //   300: astore_1
    //   301: goto -167 -> 134
    //   304: astore_1
    //   305: aload_0
    //   306: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	307	0	paramelse	else
    //   0	307	1	paramArrayOfByte	byte[]
    //   63	9	2	i	int
    //   38	47	3	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   101	36	3	localIOException1	IOException
    //   153	2	3	localIOException2	IOException
    //   176	90	3	localAra	Ara
    //   47	195	4	localObject	Object
    //   56	90	5	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   84	98	101	java/io/IOException
    //   58	64	109	finally
    //   69	75	109	finally
    //   78	84	109	finally
    //   110	124	127	java/io/IOException
    //   136	150	153	java/io/IOException
    //   183	193	278	java/lang/Exception
    //   193	241	278	java/lang/Exception
    //   241	252	278	java/lang/Exception
    //   252	265	278	java/lang/Exception
    //   58	64	300	java/lang/Exception
    //   69	75	300	java/lang/Exception
    //   78	84	300	java/lang/Exception
    //   265	276	304	finally
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
  
  public static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = Process.myPid();
    Object localObject = b(-1);
    if (localObject == null) {
      return localStringBuilder.toString();
    }
    int j = ((Aquila)localObject).e;
    if (j == 0) {
      return localStringBuilder.toString();
    }
    if (j == i) {
      return localStringBuilder.toString();
    }
    localStringBuilder.append(i);
    localStringBuilder.append(",");
    localStringBuilder.append(((Aquila)localObject).b);
    localStringBuilder.append(",");
    localStringBuilder.append(((Aquila)localObject).c);
    localStringBuilder.append(",");
    localStringBuilder.append(j);
    localStringBuilder.append(",");
    localObject = ((ArrayList)h()).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Aquila localAquila = (Aquila)((Iterator)localObject).next();
      if (localAquila.a == j) {
        localStringBuilder.append(localAquila.d);
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String a(int paramInt)
  {
    for (;;)
    {
      try
      {
        Object localObject4 = Locale.ENGLISH;
        Object localObject1 = instanceof.a(String.format((Locale)localObject4, "/proc/%d/cmdline", new Object[] { Integer.valueOf(paramInt) }), 100);
        if (localObject1 != null)
        {
          localObject1 = new String((byte[])localObject1, 0, a((byte[])localObject1, 0, '\000'));
          boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
          Object localObject3 = localObject1;
          if (bool)
          {
            localObject4 = instanceof.a(String.format((Locale)localObject4, "/proc/%d/status", new Object[] { Integer.valueOf(paramInt) }), 150);
            localObject3 = localObject1;
            if (localObject4 != null)
            {
              paramInt = a((byte[])localObject4, 7, '\n');
              if (paramInt == 0) {
                return "";
              }
              localObject3 = new String((byte[])localObject4, 6, paramInt - 6);
            }
          }
          return localObject3;
        }
      }
      finally
      {
        localObject2.printStackTrace();
        return "";
      }
      String str = "";
    }
  }
  
  public static String a(Context paramContext)
  {
    System.currentTimeMillis();
    Object localObject1 = new HashSet();
    int j = 0;
    try
    {
      localObject2 = new String(instanceof.a(import.a(import.n))).split("\\n");
      paramContext = paramContext.getPackageName();
      k = localObject2.length;
      i = 0;
      if (i < k)
      {
        localObject3 = a(localObject2[i], paramContext);
        if (localObject3 != null) {
          ((HashSet)localObject1).add(localObject3);
        }
        i += 1;
      }
    }
    finally
    {
      Object localObject2;
      int k;
      int i;
      Object localObject3;
      label85:
      break label85;
    }
    paramContext = volatile.a;
    paramContext = new HashSet();
    localObject2 = volatile.a;
    localObject3 = ((HashSet)localObject1).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      String str = (String)((Iterator)localObject3).next();
      k = localObject2.length;
      i = 0;
      while (i < k)
      {
        if (Pattern.compile(localObject2[i]).matcher(str).find()) {
          paramContext.add(str);
        }
        i += 1;
      }
    }
    ((Set)localObject1).removeAll(paramContext);
    if (((HashSet)localObject1).size() > 0)
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
  
  /* Error */
  public static String a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: invokevirtual 329	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   7: invokevirtual 333	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   10: astore_0
    //   11: aload_0
    //   12: ifnull +22 -> 34
    //   15: aload_0
    //   16: aload_1
    //   17: iconst_0
    //   18: invokevirtual 339	android/content/pm/PackageManager:getPackageArchiveInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   21: astore_0
    //   22: aload_0
    //   23: ifnull +11 -> 34
    //   26: aload_0
    //   27: getfield 344	android/content/pm/PackageInfo:packageName	Ljava/lang/String;
    //   30: astore_0
    //   31: goto +5 -> 36
    //   34: aconst_null
    //   35: astore_0
    //   36: aload_0
    //   37: ifnull +5 -> 42
    //   40: aload_0
    //   41: areturn
    //   42: new 346	java/util/zip/ZipFile
    //   45: dup
    //   46: aload_1
    //   47: invokespecial 347	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   50: astore_3
    //   51: aload_3
    //   52: aload_3
    //   53: ldc_w 349
    //   56: invokevirtual 353	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   59: invokevirtual 357	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   62: astore_1
    //   63: new 359	com/tencent/turingfd/sdk/xq/strictfp
    //   66: dup
    //   67: invokespecial 360	com/tencent/turingfd/sdk/xq/strictfp:<init>	()V
    //   70: aload_1
    //   71: invokevirtual 363	com/tencent/turingfd/sdk/xq/strictfp:a	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   74: invokeinterface 369 1 0
    //   79: iconst_0
    //   80: invokeinterface 375 2 0
    //   85: invokeinterface 381 1 0
    //   90: ldc_w 383
    //   93: invokeinterface 389 2 0
    //   98: invokeinterface 392 1 0
    //   103: astore 4
    //   105: aload_1
    //   106: invokestatic 395	com/tencent/turingfd/sdk/xq/const:a	(Ljava/io/Closeable;)V
    //   109: aload 4
    //   111: astore_1
    //   112: invokestatic 399	com/tencent/turingfd/sdk/xq/implements:a	()I
    //   115: istore_2
    //   116: aload_3
    //   117: astore 6
    //   119: aload 4
    //   121: astore 5
    //   123: iload_2
    //   124: bipush 19
    //   126: if_icmplt +45 -> 171
    //   129: aload 4
    //   131: astore_0
    //   132: goto +31 -> 163
    //   135: goto +8 -> 143
    //   138: aconst_null
    //   139: astore_3
    //   140: aload 4
    //   142: astore_1
    //   143: aload_1
    //   144: invokestatic 395	com/tencent/turingfd/sdk/xq/const:a	(Ljava/io/Closeable;)V
    //   147: aload_3
    //   148: astore 6
    //   150: aload_0
    //   151: astore 5
    //   153: aload_0
    //   154: astore_1
    //   155: invokestatic 399	com/tencent/turingfd/sdk/xq/implements:a	()I
    //   158: bipush 19
    //   160: if_icmplt +11 -> 171
    //   163: aload_0
    //   164: astore_1
    //   165: aload_3
    //   166: invokestatic 395	com/tencent/turingfd/sdk/xq/const:a	(Ljava/io/Closeable;)V
    //   169: aload_0
    //   170: areturn
    //   171: aload 5
    //   173: astore_1
    //   174: aload 6
    //   176: invokevirtual 400	java/util/zip/ZipFile:close	()V
    //   179: aload 5
    //   181: areturn
    //   182: astore_0
    //   183: goto -149 -> 34
    //   186: astore_1
    //   187: goto -49 -> 138
    //   190: astore_1
    //   191: aload 4
    //   193: astore_1
    //   194: goto -51 -> 143
    //   197: astore 4
    //   199: goto -64 -> 135
    //   202: astore_0
    //   203: aload_1
    //   204: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	205	0	paramContext	Context
    //   0	205	1	paramString	String
    //   115	12	2	i	int
    //   50	116	3	localZipFile1	java.util.zip.ZipFile
    //   1	191	4	str	String
    //   197	1	4	localObject1	Object
    //   121	59	5	localObject2	Object
    //   117	58	6	localZipFile2	java.util.zip.ZipFile
    // Exception table:
    //   from	to	target	type
    //   3	11	182	finally
    //   15	22	182	finally
    //   26	31	182	finally
    //   42	51	186	finally
    //   51	63	190	finally
    //   63	105	197	finally
    //   112	116	202	finally
    //   155	163	202	finally
    //   165	169	202	finally
    //   174	179	202	finally
  }
  
  public static String a(String paramString)
  {
    paramString = paramString.getBytes();
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance(new String(c("4D4435")));
      localMessageDigest.update(paramString);
      paramString = localMessageDigest.digest();
    }
    catch (NoSuchAlgorithmException paramString)
    {
      label35:
      break label35;
    }
    paramString = null;
    return a(paramString);
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
    String str = paramString1.substring(i).trim();
    if (!str.startsWith("/data/")) {
      return null;
    }
    paramString1 = new StringBuilder();
    paramString1.append("/data/data/");
    paramString1.append(paramString2);
    paramString1.append("/");
    paramString1 = paramString1.toString();
    if (str.startsWith(paramString1)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("/data/app/");
    localStringBuilder.append(paramString2);
    if (str.startsWith(localStringBuilder.toString())) {
      return null;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("^/data/user/\\d+/");
    localStringBuilder.append(paramString2);
    if (Pattern.compile(localStringBuilder.toString()).matcher(str).find()) {
      return null;
    }
    boolean bool = str.endsWith(".so");
    if ((!bool) && (str.endsWith(".jar"))) {
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
      paramString2.append(paramString1);
      paramString2.append("lib");
      paramString1 = new File(paramString2.toString());
    }
    try
    {
      paramString1 = paramString1.getCanonicalPath();
    }
    catch (IOException paramString1)
    {
      label262:
      break label262;
    }
    paramString1 = null;
    if ((paramString1 == null) || (str.startsWith(paramString1))) {
      return null;
    }
    return str;
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    String str = paramString3;
    if (!TextUtils.isEmpty(paramString3)) {
      str = paramString3.replace(paramString1, paramString2);
    }
    return str;
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
  
  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    finally {}
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
    if (arrayOfByte != null)
    {
      if (paramArrayOfByte1.length == 0) {
        return paramArrayOfByte1;
      }
      if (paramArrayOfByte1.length % 4 == 0)
      {
        if (paramArrayOfByte1.length < 8) {
          return null;
        }
        int k = paramArrayOfByte1.length >>> 2;
        paramArrayOfByte2 = new int[k];
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
        int m = k - 1;
        i = paramArrayOfByte2[m];
        i = paramArrayOfByte2[0];
        j = (52 / (m + 1) + 6) * -1640531527;
        while (j != 0)
        {
          int n = j >>> 2 & 0x3;
          k = i;
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
        i = paramArrayOfByte2[m];
        if (i >= 0)
        {
          if (i > m << 2) {
            return null;
          }
          paramArrayOfByte1 = new byte[i];
          a(paramArrayOfByte2, m, paramArrayOfByte1);
          return paramArrayOfByte1;
        }
      }
      return null;
    }
    return paramArrayOfByte1;
  }
  
  public static int b(Context paramContext)
  {
    boolean bool2 = h(paramContext);
    boolean bool1 = false;
    int i = a(0, bool2, 0);
    if (Settings.Secure.getInt(paramContext.getContentResolver(), "development_settings_enabled", 0) > 0) {
      bool1 = true;
    }
    return a(i, bool1, 1);
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
  public static Aquila b(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: iload_0
    //   4: invokestatic 538	com/tencent/turingfd/sdk/xq/const:a	(I)Ljava/lang/String;
    //   7: astore 5
    //   9: iload_0
    //   10: iconst_m1
    //   11: if_icmpeq +41 -> 52
    //   14: getstatic 213	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   17: astore 6
    //   19: new 223	java/lang/String
    //   22: dup
    //   23: aload 6
    //   25: ldc 245
    //   27: iconst_1
    //   28: anewarray 4	java/lang/Object
    //   31: dup
    //   32: iconst_0
    //   33: iload_0
    //   34: invokestatic 221	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   37: aastore
    //   38: invokestatic 227	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   41: invokestatic 270	com/tencent/turingfd/sdk/xq/instanceof:a	(Ljava/lang/String;)[B
    //   44: invokespecial 271	java/lang/String:<init>	([B)V
    //   47: astore 6
    //   49: goto +32 -> 81
    //   52: getstatic 213	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   55: astore 6
    //   57: new 223	java/lang/String
    //   60: dup
    //   61: aload 6
    //   63: ldc_w 540
    //   66: iconst_0
    //   67: anewarray 4	java/lang/Object
    //   70: invokestatic 227	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   73: invokestatic 270	com/tencent/turingfd/sdk/xq/instanceof:a	(Ljava/lang/String;)[B
    //   76: invokespecial 271	java/lang/String:<init>	([B)V
    //   79: astore 6
    //   81: new 96	java/util/HashMap
    //   84: dup
    //   85: invokespecial 97	java/util/HashMap:<init>	()V
    //   88: astore 8
    //   90: aload 6
    //   92: ldc_w 542
    //   95: invokevirtual 277	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   98: astore 6
    //   100: aload 6
    //   102: arraylength
    //   103: istore_2
    //   104: iconst_0
    //   105: istore_1
    //   106: iload_1
    //   107: iload_2
    //   108: if_icmpge +48 -> 156
    //   111: aload 6
    //   113: iload_1
    //   114: aaload
    //   115: ldc_w 544
    //   118: invokevirtual 277	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   121: astore 9
    //   123: aload 9
    //   125: arraylength
    //   126: iconst_2
    //   127: if_icmpge +6 -> 133
    //   130: goto +170 -> 300
    //   133: aload 8
    //   135: aload 9
    //   137: iconst_0
    //   138: aaload
    //   139: invokevirtual 435	java/lang/String:trim	()Ljava/lang/String;
    //   142: aload 9
    //   144: iconst_1
    //   145: aaload
    //   146: invokevirtual 435	java/lang/String:trim	()Ljava/lang/String;
    //   149: invokevirtual 103	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   152: pop
    //   153: goto +147 -> 300
    //   156: aload 8
    //   158: ldc_w 546
    //   161: invokevirtual 548	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   164: checkcast 223	java/lang/String
    //   167: invokestatic 552	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   170: istore_1
    //   171: aload 8
    //   173: ldc_w 554
    //   176: invokevirtual 548	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   179: checkcast 223	java/lang/String
    //   182: ldc_w 556
    //   185: invokevirtual 277	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   188: iconst_0
    //   189: aaload
    //   190: invokestatic 552	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   193: istore_3
    //   194: aload 8
    //   196: ldc_w 558
    //   199: invokevirtual 548	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   202: checkcast 223	java/lang/String
    //   205: invokestatic 552	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   208: istore_2
    //   209: iload_2
    //   210: istore 4
    //   212: goto +17 -> 229
    //   215: aconst_null
    //   216: astore 5
    //   218: iconst_m1
    //   219: istore_2
    //   220: iconst_m1
    //   221: istore_1
    //   222: iconst_m1
    //   223: istore 4
    //   225: iload_1
    //   226: istore_3
    //   227: iload_2
    //   228: istore_1
    //   229: aload 7
    //   231: astore 6
    //   233: aload 5
    //   235: ifnull +36 -> 271
    //   238: aload 7
    //   240: astore 6
    //   242: iload_1
    //   243: iconst_m1
    //   244: if_icmpeq +27 -> 271
    //   247: iload_3
    //   248: iconst_m1
    //   249: if_icmpne +5 -> 254
    //   252: aconst_null
    //   253: areturn
    //   254: new 164	com/tencent/turingfd/sdk/xq/Aquila
    //   257: dup
    //   258: iload_0
    //   259: iload_1
    //   260: aload 5
    //   262: iload_3
    //   263: aconst_null
    //   264: iload 4
    //   266: invokespecial 561	com/tencent/turingfd/sdk/xq/Aquila:<init>	(IILjava/lang/String;ILjava/lang/String;I)V
    //   269: astore 6
    //   271: aload 6
    //   273: areturn
    //   274: astore 5
    //   276: goto -61 -> 215
    //   279: astore 6
    //   281: goto -63 -> 218
    //   284: astore 6
    //   286: iload_1
    //   287: istore_2
    //   288: goto -68 -> 220
    //   291: astore 6
    //   293: iload_1
    //   294: istore_2
    //   295: iload_3
    //   296: istore_1
    //   297: goto -75 -> 222
    //   300: iload_1
    //   301: iconst_1
    //   302: iadd
    //   303: istore_1
    //   304: goto -198 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	307	0	paramInt	int
    //   105	199	1	i	int
    //   103	192	2	j	int
    //   193	103	3	k	int
    //   210	55	4	m	int
    //   7	254	5	str	String
    //   274	1	5	localObject1	Object
    //   17	255	6	localObject2	Object
    //   279	1	6	localObject3	Object
    //   284	1	6	localObject4	Object
    //   291	1	6	localObject5	Object
    //   1	238	7	localObject6	Object
    //   88	107	8	localHashMap	java.util.HashMap
    //   121	22	9	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   3	9	274	finally
    //   14	19	279	finally
    //   19	49	279	finally
    //   52	57	279	finally
    //   57	81	279	finally
    //   81	104	279	finally
    //   111	130	279	finally
    //   133	153	279	finally
    //   156	171	279	finally
    //   171	194	284	finally
    //   194	209	291	finally
  }
  
  public static String b()
  {
    Iterator localIterator = ((ArrayList)extends.a()).iterator();
    while (localIterator.hasNext())
    {
      Lynx localLynx = (Lynx)localIterator.next();
      if (localLynx.a.contains(return.c)) {
        return localLynx.b;
      }
    }
    return "";
  }
  
  public static byte[] b(String paramString)
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
  public static byte[] b(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 34	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 37	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_1
    //   8: new 587	java/util/zip/DeflaterOutputStream
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 590	java/util/zip/DeflaterOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   16: astore_2
    //   17: aload_2
    //   18: aload_0
    //   19: invokevirtual 592	java/util/zip/DeflaterOutputStream:write	([B)V
    //   22: aload_2
    //   23: invokevirtual 595	java/util/zip/DeflaterOutputStream:finish	()V
    //   26: aload_1
    //   27: invokevirtual 48	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   30: astore_0
    //   31: aload_1
    //   32: invokevirtual 53	java/io/ByteArrayOutputStream:close	()V
    //   35: aload_2
    //   36: invokevirtual 596	java/util/zip/DeflaterOutputStream:close	()V
    //   39: aload_0
    //   40: areturn
    //   41: astore_1
    //   42: aload_1
    //   43: invokevirtual 56	java/io/IOException:printStackTrace	()V
    //   46: aload_0
    //   47: areturn
    //   48: astore_0
    //   49: aload_1
    //   50: invokevirtual 53	java/io/ByteArrayOutputStream:close	()V
    //   53: aload_2
    //   54: invokevirtual 596	java/util/zip/DeflaterOutputStream:close	()V
    //   57: goto +8 -> 65
    //   60: astore_1
    //   61: aload_1
    //   62: invokevirtual 56	java/io/IOException:printStackTrace	()V
    //   65: aload_0
    //   66: athrow
    //   67: aload_1
    //   68: invokevirtual 53	java/io/ByteArrayOutputStream:close	()V
    //   71: aload_2
    //   72: invokevirtual 596	java/util/zip/DeflaterOutputStream:close	()V
    //   75: aconst_null
    //   76: areturn
    //   77: astore_0
    //   78: aload_0
    //   79: invokevirtual 56	java/io/IOException:printStackTrace	()V
    //   82: aconst_null
    //   83: areturn
    //   84: astore_0
    //   85: goto -18 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	paramArrayOfByte	byte[]
    //   7	25	1	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   41	9	1	localIOException1	IOException
    //   60	8	1	localIOException2	IOException
    //   16	56	2	localDeflaterOutputStream	java.util.zip.DeflaterOutputStream
    // Exception table:
    //   from	to	target	type
    //   31	39	41	java/io/IOException
    //   17	31	48	finally
    //   49	57	60	java/io/IOException
    //   67	75	77	java/io/IOException
    //   17	31	84	java/lang/Exception
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
        int j;
        if (paramArrayOfByte1.length % 4 == 0) {
          j = (paramArrayOfByte1.length >>> 2) + 1;
        } else {
          j = (paramArrayOfByte1.length >>> 2) + 2;
        }
        int[] arrayOfInt = new int[j];
        a(paramArrayOfByte1, arrayOfInt);
        int i2 = j - 1;
        arrayOfInt[i2] = paramArrayOfByte1.length;
        if (arrayOfByte.length % 4 == 0) {
          i = arrayOfByte.length >>> 2;
        } else {
          i = (arrayOfByte.length >>> 2) + 1;
        }
        int k = i;
        if (i < 4) {
          k = 4;
        }
        paramArrayOfByte1 = new int[k];
        int i = 0;
        while (i < k)
        {
          paramArrayOfByte1[i] = 0;
          i += 1;
        }
        a(arrayOfByte, paramArrayOfByte1);
        i = arrayOfInt[i2];
        k = arrayOfInt[0];
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
            i4 = arrayOfInt[i1];
            int i5 = arrayOfInt[i];
            m = ((m >>> 5 ^ i4 << 2) + (i4 >>> 3 ^ m << 4) ^ (i4 ^ n) + (m ^ paramArrayOfByte1[(i & 0x3 ^ i3)])) + i5;
            arrayOfInt[i] = m;
          }
          i1 = arrayOfInt[0];
          int i4 = arrayOfInt[i2];
          i = ((m >>> 5 ^ i1 << 2) + (i1 >>> 3 ^ m << 4) ^ (i1 ^ n) + (paramArrayOfByte1[(i & 0x3 ^ i3)] ^ m)) + i4;
          arrayOfInt[i2] = i;
          k -= 1;
        }
        paramArrayOfByte2 = new byte[j << 2];
        a(arrayOfInt, j, paramArrayOfByte2);
      }
    }
    return paramArrayOfByte2;
  }
  
  public static String c()
  {
    try
    {
      Object localObject1 = new File("/system/lib");
      if (((File)localObject1).canRead())
      {
        localObject1 = ((File)localObject1).listFiles();
        int j = localObject1.length;
        int i = 0;
        if (i < j)
        {
          Object localObject3 = localObject1[i];
          if (localObject3.getName().contains("rockchip"))
          {
            localObject1 = localObject3.getAbsolutePath();
            return localObject1;
          }
          i += 1;
        }
      }
    }
    finally
    {
      label64:
      break label64;
    }
    return "";
  }
  
  public static String c(byte[] paramArrayOfByte)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance(new String(c("4D4435")));
      localMessageDigest.update(paramArrayOfByte);
      paramArrayOfByte = localMessageDigest.digest();
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      label30:
      break label30;
    }
    paramArrayOfByte = null;
    return a(paramArrayOfByte);
  }
  
  public static boolean c(Context paramContext)
  {
    int i = Build.VERSION.SDK_INT;
    if (i < 14) {
      return (!TextUtils.isEmpty(Proxy.getHost(paramContext))) && (Proxy.getPort(paramContext) != -1);
    }
    if ((!TextUtils.isEmpty(System.getProperty("http.proxyHost"))) && (!TextUtils.equals(System.getProperty("http.proxyPort"), "-1"))) {
      return true;
    }
    Object localObject3 = (WifiManager)paramContext.getApplicationContext().getSystemService("wifi");
    if (paramContext.checkPermission("android.permission.ACCESS_WIFI_STATE", Process.myPid(), Process.myUid()) != 0) {
      return false;
    }
    try
    {
      localObject2 = NetworkMonitor.getConnectionInfo((WifiManager)localObject3);
      if (localObject2 != null)
      {
        if (((WifiInfo)localObject2).getNetworkId() == -1) {
          return false;
        }
        localObject1 = null;
      }
    }
    finally
    {
      Object localObject2;
      Object localObject1;
      label125:
      return false;
    }
    try
    {
      paramContext = ((WifiManager)localObject3).getConfiguredNetworks();
    }
    finally
    {
      break label125;
    }
    paramContext = null;
    if (paramContext == null) {
      return false;
    }
    localObject2 = ((WifiInfo)localObject2).getSSID();
    localObject3 = paramContext.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      paramContext = (WifiConfiguration)((Iterator)localObject3).next();
      if (!TextUtils.equals(paramContext.SSID, (CharSequence)localObject2))
      {
        String str = paramContext.SSID;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("\"");
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append("\"");
        if (!TextUtils.equals(str, localStringBuilder.toString())) {
          break;
        }
      }
      else
      {
        if (i < 21)
        {
          paramContext = transient.a(WifiConfiguration.class, "proxySettings", paramContext);
          localObject1 = "android.net.wifi.WifiConfiguration$ProxySettings";
        }
        else
        {
          localObject2 = transient.a;
          try
          {
            localObject2 = transient.a(WifiConfiguration.class, "getProxySettings", new Class[0]);
            if (localObject2 == null) {
              paramContext = (Context)localObject1;
            } else {
              paramContext = ((Method)localObject2).invoke(paramContext, new Object[0]);
            }
          }
          finally
          {
            paramContext.printStackTrace();
            paramContext = (Context)localObject1;
          }
          localObject1 = "android.net.IpConfiguration$ProxySettings";
        }
        localObject2 = transient.a((String)localObject1, "STATIC");
        if ((localObject2 != null) && (localObject2 == paramContext)) {
          return true;
        }
        if (i >= 19)
        {
          localObject1 = transient.a((String)localObject1, "PAC");
          if ((localObject1 != null) && (localObject1 == paramContext)) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public static byte[] c(String paramString)
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
  
  public static int d(Context paramContext)
  {
    IntentFilter localIntentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    Object localObject = null;
    try
    {
      paramContext = paramContext.registerReceiver(null, localIntentFilter);
      if (paramContext == null) {
        return 0;
      }
      int i = paramContext.getIntExtra("status", -1);
      if ((i != 2) && (i != 5)) {
        i = 0;
      } else {
        i = 1;
      }
      if (i == 0) {
        return 1;
      }
      i = paramContext.getIntExtra("plugged", -1);
      if (i == 2) {
        return 3;
      }
      if (i == 1) {
        return 2;
      }
      return 0;
    }
    finally
    {
      for (;;)
      {
        paramContext = localObject;
      }
    }
  }
  
  public static String d()
  {
    Iterator localIterator = ((ArrayList)extends.a()).iterator();
    while (localIterator.hasNext())
    {
      Lynx localLynx = (Lynx)localIterator.next();
      if (localLynx.a.contains(return.d)) {
        return localLynx.b;
      }
    }
    return "";
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
    finally
    {
      label34:
      break label34;
    }
    localObject = null;
    return localObject;
  }
  
  public static byte e(Context paramContext)
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
    finally
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
  
  public static Context e()
  {
    try
    {
      Context localContext = a;
      return localContext;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static int f(Context paramContext)
  {
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
    finally
    {
      paramContext = paramContext.getMessage();
      int j = -3;
      int i = j;
      if (paramContext != null)
      {
        i = j;
        if (paramContext.contains("ACCESS_NETWORK_STATE")) {
          i = -2;
        }
      }
      return i;
    }
  }
  
  public static boolean f()
  {
    try
    {
      Object localObject1 = NetworkMonitor.getNetworkInterfaces();
      if (localObject1 != null)
      {
        localObject1 = Collections.list((Enumeration)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          NetworkInterface localNetworkInterface = (NetworkInterface)((Iterator)localObject1).next();
          if ((localNetworkInterface.isUp()) && (localNetworkInterface.getInterfaceAddresses().size() != 0))
          {
            boolean bool = localNetworkInterface.getName().matches("tun\\d+");
            if (bool) {
              return true;
            }
          }
        }
      }
    }
    finally
    {
      label74:
      break label74;
    }
    return false;
  }
  
  /* Error */
  public static int g(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 618	android/os/Build$VERSION:SDK_INT	I
    //   3: istore_2
    //   4: iconst_0
    //   5: istore_1
    //   6: iload_2
    //   7: bipush 24
    //   9: if_icmplt +5 -> 14
    //   12: iconst_0
    //   13: ireturn
    //   14: new 460	java/io/File
    //   17: dup
    //   18: getstatic 811	com/tencent/turingfd/sdk/xq/import:n0	[I
    //   21: invokestatic 267	com/tencent/turingfd/sdk/xq/import:a	([I)Ljava/lang/String;
    //   24: invokespecial 461	java/io/File:<init>	(Ljava/lang/String;)V
    //   27: astore_3
    //   28: ldc 99
    //   30: astore 4
    //   32: new 813	java/io/BufferedReader
    //   35: dup
    //   36: new 815	java/io/FileReader
    //   39: dup
    //   40: aload_3
    //   41: invokespecial 818	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   44: invokespecial 821	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   47: astore 5
    //   49: aload 5
    //   51: invokevirtual 824	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   54: astore_3
    //   55: goto +19 -> 74
    //   58: aconst_null
    //   59: astore_3
    //   60: aload 4
    //   62: astore 5
    //   64: aload_3
    //   65: ifnull +17 -> 82
    //   68: aload_3
    //   69: astore 5
    //   71: aload 4
    //   73: astore_3
    //   74: aload 5
    //   76: invokestatic 825	com/tencent/turingfd/sdk/xq/instanceof:a	(Ljava/io/Closeable;)V
    //   79: aload_3
    //   80: astore 5
    //   82: aload 5
    //   84: invokestatic 243	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   87: ifeq +5 -> 92
    //   90: iconst_0
    //   91: ireturn
    //   92: ldc_w 827
    //   95: aload 5
    //   97: invokevirtual 829	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   100: ifeq +32 -> 132
    //   103: aload_0
    //   104: invokevirtual 523	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   107: ldc_w 831
    //   110: iconst_0
    //   111: invokestatic 531	android/provider/Settings$Secure:getInt	(Landroid/content/ContentResolver;Ljava/lang/String;I)I
    //   114: istore_2
    //   115: iload_2
    //   116: ifle +8 -> 124
    //   119: iconst_1
    //   120: istore_1
    //   121: goto +3 -> 124
    //   124: iload_1
    //   125: ifeq +5 -> 130
    //   128: iconst_1
    //   129: ireturn
    //   130: iconst_3
    //   131: ireturn
    //   132: ldc_w 833
    //   135: aload 5
    //   137: invokevirtual 829	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   140: ifeq +5 -> 145
    //   143: iconst_2
    //   144: ireturn
    //   145: ldc_w 834
    //   148: aload 5
    //   150: invokevirtual 829	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   153: ifeq +5 -> 158
    //   156: iconst_3
    //   157: ireturn
    //   158: iconst_0
    //   159: ireturn
    //   160: astore_3
    //   161: goto -103 -> 58
    //   164: astore_3
    //   165: aload 5
    //   167: astore_3
    //   168: goto -108 -> 60
    //   171: astore_0
    //   172: goto -48 -> 124
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	paramContext	Context
    //   5	120	1	i	int
    //   3	113	2	j	int
    //   27	53	3	localObject1	Object
    //   160	1	3	localObject2	Object
    //   164	1	3	localObject3	Object
    //   167	1	3	localObject4	Object
    //   30	42	4	str	String
    //   47	119	5	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   32	49	160	finally
    //   49	55	164	finally
    //   103	115	171	finally
  }
  
  public static byte[] g()
  {
    try
    {
      Object localObject = new StringBuffer();
      String str = import.a(import.D0);
      int i = 0;
      while (i < str.length())
      {
        ((StringBuffer)localObject).append((char)(str.charAt(i) + new int[] { -36, -46, -45, -77, -22, -10, 47, -77, -72, -69, -32, 25, 21, -21, -6, -75, -71, 31, -39, -49, -49 }[i]));
        i += 1;
      }
      localObject = ((StringBuffer)localObject).toString().getBytes("UTF-8");
      return localObject;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
    return null;
  }
  
  public static List<Aquila> h()
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
          localObject = b(Integer.parseInt((String)localObject));
          if (localObject != null) {
            localArrayList.add(localObject);
          }
        }
      }
      catch (Exception localException)
      {
        label102:
        break label102;
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static boolean h(Context paramContext)
  {
    int i = Build.VERSION.SDK_INT;
    boolean bool = false;
    if (i >= 17 ? Settings.Secure.getInt(paramContext.getContentResolver(), "adb_enabled", 0) > 0 : Settings.Secure.getInt(paramContext.getContentResolver(), "adb_enabled", 0) > 0) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean i(Context paramContext)
  {
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext == null) {
        return false;
      }
      paramContext = paramContext.getActiveNetworkInfo();
      if (paramContext != null)
      {
        boolean bool = paramContext.isConnected();
        if (bool) {
          return true;
        }
      }
      return false;
    }
    finally
    {
      Ginkgo localGinkgo = Ginkgo.a();
      localGinkgo.getClass();
      localGinkgo.a("1", Log.getStackTraceString(paramContext));
      paramContext = paramContext.getMessage();
      if ((paramContext != null) && (paramContext.contains("ACCESS_NETWORK_STATE"))) {
        return true;
      }
    }
    return false;
  }
  
  public static String j(Context paramContext)
  {
    Object localObject = finally.a;
    localObject = new ArrayList();
    String str = paramContext.getPackageName();
    if (!TextUtils.isEmpty(str))
    {
      paramContext = Andromeda.a(paramContext, str);
      Lynx localLynx = new Lynx();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(return.a);
      localStringBuilder.append(return.b);
      localLynx.a = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("_");
      localStringBuilder.append(paramContext);
      localLynx.b = localStringBuilder.toString();
      ((ArrayList)localObject).add(localLynx);
    }
    if (((ArrayList)localObject).size() != 0) {
      return ((Lynx)((ArrayList)localObject).get(0)).b;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.const
 * JD-Core Version:    0.7.0.1
 */