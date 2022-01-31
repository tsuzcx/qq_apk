package com.tencent.tmassistantbase.util;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class ac
{
  protected static ArrayList<WeakReference<n>> A;
  private static List<String> B;
  private static long C;
  private static Field D;
  private static Boolean E = Boolean.valueOf(true);
  private static ThreadLocal<char[]> F = new ad();
  protected static boolean a = false;
  protected static String b = "";
  protected static int c = 2;
  protected static int d = 4;
  protected static boolean e = true;
  protected static boolean f = false;
  protected static boolean g = false;
  protected static Context h;
  protected static boolean i;
  static LinkedBlockingQueue<String> j;
  protected static BufferedWriter k;
  static long l;
  static final ReentrantLock m;
  protected static int n;
  protected static String o;
  protected static String p;
  protected static long q;
  protected static SimpleDateFormat r;
  protected static AtomicBoolean s;
  protected static AtomicBoolean t;
  protected static final int[] u;
  protected static AtomicInteger v;
  protected static Handler w;
  protected static Runnable x = new ae();
  static Thread y = new ag();
  protected static ReferenceQueue<n> z;
  
  static
  {
    B = Collections.synchronizedList(new ArrayList());
    i = false;
    C = 0L;
    l = 0L;
    m = new ReentrantLock();
    o = "";
    p = "";
    q = 0L;
    r = new SimpleDateFormat("yy-MM-dd HH:mm");
    s = new AtomicBoolean(false);
    t = new AtomicBoolean(false);
    u = new int[] { 1, 2, 4, 8, 16, 29 };
    v = new AtomicInteger(0);
    w = new Handler(Looper.getMainLooper());
  }
  
  public static void a(int paramInt)
  {
    c = paramInt;
  }
  
  private static void a(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    if ((paramInt < c()) && (paramInt < b())) {
      return;
    }
    if ((!e()) || (paramInt >= b()))
    {
      if ((paramInt == 2) && (a()))
      {
        if (paramThrowable != null) {
          break label297;
        }
        Log.v(paramString1, paramString2);
      }
      label49:
      if ((paramInt == 3) && (a()))
      {
        if (paramThrowable != null) {
          break label307;
        }
        Log.d(paramString1, paramString2);
      }
      label70:
      if (paramInt == 4)
      {
        if (paramThrowable != null) {
          break label317;
        }
        Log.i(paramString1, paramString2);
      }
      label85:
      if (paramInt == 5)
      {
        if (paramThrowable != null) {
          break label327;
        }
        Log.w(paramString1, paramString2);
      }
      label100:
      if (paramInt == 6)
      {
        if (paramThrowable != null) {
          break label337;
        }
        Log.e(paramString1, paramString2);
      }
    }
    for (;;)
    {
      if (paramInt >= c()) {
        c(paramInt, paramString1, paramString2, paramThrowable);
      }
      if ((paramInt < c()) || (A == null)) {
        break;
      }
      if (B == null) {
        B = new ArrayList();
      }
      if ((B.size() < 20) && (System.currentTimeMillis() - C <= 3000L)) {
        break label347;
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(B);
      B.clear();
      C = System.currentTimeMillis();
      Object localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(A);
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (WeakReference)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          localObject2 = (n)((WeakReference)localObject2).get();
          if (localObject2 != null) {
            ((n)localObject2).a(localArrayList);
          }
        }
      }
      label297:
      Log.v(paramString1, paramString2, paramThrowable);
      break label49;
      label307:
      Log.d(paramString1, paramString2, paramThrowable);
      break label70;
      label317:
      Log.i(paramString1, paramString2, paramThrowable);
      break label85;
      label327:
      Log.w(paramString1, paramString2, paramThrowable);
      break label100;
      label337:
      Log.e(paramString1, paramString2, paramThrowable);
    }
    label347:
    B.add(b(paramInt, paramString1, paramString2, paramThrowable));
  }
  
  public static void a(Context paramContext)
  {
    try
    {
      if (!i)
      {
        h = paramContext;
        x.run();
        i = true;
      }
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("/")) && (paramString.endsWith("/"))) {
      b = paramString;
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    a(2, paramString1, paramString2, null);
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    a(4, paramString1, paramString2, paramThrowable);
  }
  
  public static void a(boolean paramBoolean)
  {
    e = paramBoolean;
  }
  
  public static boolean a()
  {
    return false;
  }
  
  public static boolean a(n paramn)
  {
    boolean bool;
    if (paramn == null) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      Object localObject;
      try
      {
        Log.d("TMLog", "registerLogListener : " + paramn);
        if (A == null) {
          A = new ArrayList();
        }
        if (z == null) {
          z = new ReferenceQueue();
        }
        localObject = z.poll();
        while (localObject != null) {
          A.remove(localObject);
        }
        localObject = A.iterator();
      }
      finally {}
      for (;;)
      {
        if (((Iterator)localObject).hasNext()) {
          if ((n)((WeakReference)((Iterator)localObject).next()).get() == paramn)
          {
            bool = true;
            break;
          }
        }
      }
      paramn = new WeakReference(paramn, z);
      A.add(paramn);
      bool = true;
    }
  }
  
  public static int b()
  {
    return c;
  }
  
  private static String b(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LL'" + c(paramInt) + "&");
    localStringBuilder.append("LTS'" + System.currentTimeMillis() + "&");
    localStringBuilder.append("LT'" + paramString1 + "&");
    localStringBuilder.append("LM'" + paramString2);
    if (paramThrowable != null) {
      localStringBuilder.append("&LW'" + Log.getStackTraceString(paramThrowable));
    }
    return localStringBuilder.toString();
  }
  
  public static void b(int paramInt)
  {
    d = paramInt;
  }
  
  public static void b(String paramString1, String paramString2)
  {
    a(3, paramString1, paramString2, null);
  }
  
  public static void b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    a(5, paramString1, paramString2, paramThrowable);
  }
  
  public static void b(boolean paramBoolean)
  {
    g = paramBoolean;
  }
  
  public static boolean b(n paramn)
  {
    boolean bool;
    if (paramn == null)
    {
      bool = false;
      return bool;
    }
    for (;;)
    {
      try
      {
        Iterator localIterator = A.iterator();
        if (localIterator.hasNext())
        {
          WeakReference localWeakReference = (WeakReference)localIterator.next();
          if ((n)localWeakReference.get() != paramn) {
            break label84;
          }
          A.remove(localWeakReference);
          i1 = 1;
          if (i1 == 0) {
            continue;
          }
          bool = true;
          break;
        }
        bool = false;
        break;
      }
      finally {}
      label84:
      int i1 = 0;
    }
  }
  
  public static int c()
  {
    return d;
  }
  
  private static String c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "D";
    case 2: 
      return "V";
    case 3: 
      return "D";
    case 4: 
      return "I";
    case 5: 
      return "W";
    }
    return "E";
  }
  
  private static void c(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (!g()) {}
    do
    {
      return;
      long l1 = Thread.currentThread().getId();
      StringBuilder localStringBuilder = l();
      if (f()) {
        localStringBuilder.append(i()).append("|");
      }
      localStringBuilder.append(c(paramInt)).append("|pid=").append(n).append("|tid=").append(String.valueOf(l1)).append("|").append(paramString1).append("|").append(paramString2).append("\n");
      paramString1 = localStringBuilder;
      if (paramThrowable != null) {
        paramString1 = localStringBuilder.append("\n").append(Log.getStackTraceString(paramThrowable)).append("\n");
      }
    } while (c(paramString1.toString()));
    Log.d("TMLog", "addLogToCache failed!");
  }
  
  public static void c(String paramString1, String paramString2)
  {
    a(4, paramString1, paramString2, null);
  }
  
  public static void c(String paramString1, String paramString2, Throwable paramThrowable)
  {
    a(6, paramString1, paramString2, paramThrowable);
  }
  
  public static void c(boolean paramBoolean)
  {
    a = paramBoolean;
  }
  
  private static boolean c(String paramString)
  {
    try
    {
      j.add(paramString);
      return true;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  private static void d(String paramString)
  {
    if (!g()) {
      return;
    }
    long l1;
    if (k == null)
    {
      Log.d("TMLog", "can not write log.");
      l1 = System.currentTimeMillis();
      if (l == 0L) {
        l = l1;
      }
    }
    for (;;)
    {
      s.compareAndSet(true, false);
      return;
      if (l1 - l > 60000L)
      {
        try
        {
          m();
          l = l1;
        }
        catch (IOException paramString)
        {
          for (;;)
          {
            paramString.printStackTrace();
          }
        }
        if (m.tryLock()) {}
        try
        {
          k.write(paramString);
          if (!d()) {
            k.flush();
          }
          m.unlock();
        }
        finally
        {
          m.unlock();
        }
        Log.d("TMLog", "addLogToCache failed!");
      }
    }
  }
  
  public static void d(String paramString1, String paramString2)
  {
    a(5, paramString1, paramString2, null);
  }
  
  public static boolean d()
  {
    return e;
  }
  
  public static void e(String paramString1, String paramString2)
  {
    a(6, paramString1, paramString2, null);
  }
  
  public static boolean e()
  {
    return f;
  }
  
  public static boolean f()
  {
    return g;
  }
  
  public static boolean g()
  {
    return a;
  }
  
  public static String h()
  {
    if (TextUtils.isEmpty(b)) {
      b = Environment.getExternalStorageDirectory().getPath() + "/tencent/TMAssistantSDK/Logs/";
    }
    return b;
  }
  
  public static String i()
  {
    try
    {
      long l1 = System.currentTimeMillis();
      if (l1 - q > 60000L)
      {
        q = l1;
        p = r.format(Long.valueOf(q));
      }
      String str = p;
      return str;
    }
    finally {}
  }
  
  private static StringBuilder l()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      if (E.booleanValue())
      {
        D = StringBuilder.class.getSuperclass().getDeclaredField("value");
        D.setAccessible(true);
        E = Boolean.valueOf(false);
      }
      if (D != null) {
        D.set(localStringBuilder, F.get());
      }
      return localStringBuilder;
    }
    catch (Exception localException) {}
    return localStringBuilder;
  }
  
  /* Error */
  private static void m()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 295
    //   6: ldc_w 493
    //   9: invokestatic 192	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   12: pop
    //   13: new 444	java/io/File
    //   16: dup
    //   17: invokestatic 495	com/tencent/tmassistantbase/util/ac:h	()Ljava/lang/String;
    //   20: invokespecial 496	java/io/File:<init>	(Ljava/lang/String;)V
    //   23: astore_1
    //   24: aload_1
    //   25: invokevirtual 499	java/io/File:exists	()Z
    //   28: ifne +8 -> 36
    //   31: aload_1
    //   32: invokevirtual 502	java/io/File:mkdirs	()Z
    //   35: pop
    //   36: new 444	java/io/File
    //   39: dup
    //   40: new 297	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 298	java/lang/StringBuilder:<init>	()V
    //   47: invokestatic 495	com/tencent/tmassistantbase/util/ac:h	()Ljava/lang/String;
    //   50: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: getstatic 106	com/tencent/tmassistantbase/util/ac:o	Ljava/lang/String;
    //   56: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: ldc_w 504
    //   62: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: invokevirtual 311	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: invokespecial 496	java/io/File:<init>	(Ljava/lang/String;)V
    //   71: astore_1
    //   72: aload_1
    //   73: invokevirtual 499	java/io/File:exists	()Z
    //   76: ifne +145 -> 221
    //   79: aload_1
    //   80: invokevirtual 507	java/io/File:createNewFile	()Z
    //   83: istore_0
    //   84: invokestatic 509	com/tencent/tmassistantbase/util/ac:n	()V
    //   87: getstatic 407	com/tencent/tmassistantbase/util/ac:k	Ljava/io/BufferedWriter;
    //   90: ifnull +102 -> 192
    //   93: invokestatic 360	com/tencent/tmassistantbase/util/ac:g	()Z
    //   96: ifeq +96 -> 192
    //   99: getstatic 407	com/tencent/tmassistantbase/util/ac:k	Ljava/io/BufferedWriter;
    //   102: new 297	java/lang/StringBuilder
    //   105: dup
    //   106: invokespecial 298	java/lang/StringBuilder:<init>	()V
    //   109: invokestatic 376	com/tencent/tmassistantbase/util/ac:i	()Ljava/lang/String;
    //   112: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: ldc_w 378
    //   118: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: getstatic 106	com/tencent/tmassistantbase/util/ac:o	Ljava/lang/String;
    //   124: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: ldc_w 378
    //   130: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: getstatic 514	android/os/Build:MODEL	Ljava/lang/String;
    //   136: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: ldc_w 516
    //   142: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: getstatic 521	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   148: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: ldc_w 523
    //   154: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: aload_1
    //   158: invokevirtual 526	java/io/File:getName	()Ljava/lang/String;
    //   161: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: ldc_w 516
    //   167: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: iload_0
    //   171: invokevirtual 529	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   174: ldc_w 392
    //   177: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: invokevirtual 311	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: invokevirtual 428	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   186: getstatic 407	com/tencent/tmassistantbase/util/ac:k	Ljava/io/BufferedWriter;
    //   189: invokevirtual 433	java/io/BufferedWriter:flush	()V
    //   192: new 425	java/io/BufferedWriter
    //   195: dup
    //   196: new 531	java/io/FileWriter
    //   199: dup
    //   200: aload_1
    //   201: iconst_1
    //   202: invokespecial 534	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   205: sipush 8192
    //   208: invokespecial 537	java/io/BufferedWriter:<init>	(Ljava/io/Writer;I)V
    //   211: putstatic 407	com/tencent/tmassistantbase/util/ac:k	Ljava/io/BufferedWriter;
    //   214: invokestatic 509	com/tencent/tmassistantbase/util/ac:n	()V
    //   217: ldc 2
    //   219: monitorexit
    //   220: return
    //   221: aload_1
    //   222: invokevirtual 540	java/io/File:length	()J
    //   225: ldc2_w 541
    //   228: lcmp
    //   229: iflt +49 -> 278
    //   232: aload_1
    //   233: invokevirtual 545	java/io/File:delete	()Z
    //   236: pop
    //   237: aload_1
    //   238: invokevirtual 507	java/io/File:createNewFile	()Z
    //   241: pop
    //   242: ldc_w 295
    //   245: new 297	java/lang/StringBuilder
    //   248: dup
    //   249: invokespecial 298	java/lang/StringBuilder:<init>	()V
    //   252: ldc_w 547
    //   255: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: aload_1
    //   259: invokevirtual 526	java/io/File:getName	()Ljava/lang/String;
    //   262: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: ldc_w 549
    //   268: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: invokevirtual 311	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   274: invokestatic 192	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   277: pop
    //   278: invokestatic 509	com/tencent/tmassistantbase/util/ac:n	()V
    //   281: getstatic 407	com/tencent/tmassistantbase/util/ac:k	Ljava/io/BufferedWriter;
    //   284: ifnull -92 -> 192
    //   287: invokestatic 360	com/tencent/tmassistantbase/util/ac:g	()Z
    //   290: ifeq -98 -> 192
    //   293: getstatic 407	com/tencent/tmassistantbase/util/ac:k	Ljava/io/BufferedWriter;
    //   296: new 297	java/lang/StringBuilder
    //   299: dup
    //   300: invokespecial 298	java/lang/StringBuilder:<init>	()V
    //   303: invokestatic 376	com/tencent/tmassistantbase/util/ac:i	()Ljava/lang/String;
    //   306: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: ldc_w 378
    //   312: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: getstatic 106	com/tencent/tmassistantbase/util/ac:o	Ljava/lang/String;
    //   318: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: ldc_w 378
    //   324: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: getstatic 514	android/os/Build:MODEL	Ljava/lang/String;
    //   330: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: ldc_w 516
    //   336: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: getstatic 521	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   342: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: ldc_w 551
    //   348: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: aload_1
    //   352: invokevirtual 526	java/io/File:getName	()Ljava/lang/String;
    //   355: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: ldc_w 553
    //   361: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: invokevirtual 311	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   367: invokevirtual 428	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   370: getstatic 407	com/tencent/tmassistantbase/util/ac:k	Ljava/io/BufferedWriter;
    //   373: invokevirtual 433	java/io/BufferedWriter:flush	()V
    //   376: goto -184 -> 192
    //   379: astore_2
    //   380: aload_2
    //   381: invokevirtual 554	java/lang/Throwable:printStackTrace	()V
    //   384: goto -192 -> 192
    //   387: astore_1
    //   388: ldc 2
    //   390: monitorexit
    //   391: aload_1
    //   392: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   83	88	0	bool	boolean
    //   23	329	1	localFile	File
    //   387	5	1	localObject	Object
    //   379	2	2	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   72	192	379	java/lang/Throwable
    //   221	278	379	java/lang/Throwable
    //   278	376	379	java/lang/Throwable
    //   3	36	387	finally
    //   36	72	387	finally
    //   72	192	387	finally
    //   192	217	387	finally
    //   221	278	387	finally
    //   278	376	387	finally
    //   380	384	387	finally
  }
  
  private static void n()
  {
    if ((k != null) && (g()))
    {
      k.write("SDK_VERSION = 1.0|BUILD_NO = {BuildNo}|RELEASE_DATE: {ReleaseDate}\r\n");
      k.flush();
    }
  }
  
  /* Error */
  private static void o()
  {
    // Byte code:
    //   0: ldc_w 560
    //   3: invokestatic 563	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   6: invokevirtual 566	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9: ifeq +465 -> 474
    //   12: new 568	java/util/Properties
    //   15: dup
    //   16: invokespecial 569	java/util/Properties:<init>	()V
    //   19: astore_1
    //   20: new 444	java/io/File
    //   23: dup
    //   24: new 297	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 298	java/lang/StringBuilder:<init>	()V
    //   31: invokestatic 442	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   34: invokevirtual 447	java/io/File:getPath	()Ljava/lang/String;
    //   37: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: ldc_w 571
    //   43: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 311	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokespecial 496	java/io/File:<init>	(Ljava/lang/String;)V
    //   52: astore_2
    //   53: aload_2
    //   54: invokevirtual 499	java/io/File:exists	()Z
    //   57: ifne +4 -> 61
    //   60: return
    //   61: aload_1
    //   62: new 573	java/io/FileInputStream
    //   65: dup
    //   66: aload_2
    //   67: invokespecial 576	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   70: invokevirtual 580	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   73: aload_1
    //   74: ldc_w 582
    //   77: ldc 68
    //   79: invokevirtual 586	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   82: astore_2
    //   83: aload_2
    //   84: invokevirtual 589	java/lang/String:trim	()Ljava/lang/String;
    //   87: ldc_w 591
    //   90: invokevirtual 566	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   93: ifeq +340 -> 433
    //   96: iconst_1
    //   97: invokestatic 593	com/tencent/tmassistantbase/util/ac:c	(Z)V
    //   100: aload_1
    //   101: ldc_w 595
    //   104: ldc 68
    //   106: invokevirtual 586	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   109: astore_3
    //   110: aload_3
    //   111: invokestatic 277	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   114: istore_0
    //   115: iload_0
    //   116: ifne +13 -> 129
    //   119: aload_3
    //   120: invokestatic 600	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   123: invokevirtual 603	java/lang/Integer:intValue	()I
    //   126: invokestatic 605	com/tencent/tmassistantbase/util/ac:b	(I)V
    //   129: aload_1
    //   130: ldc_w 607
    //   133: ldc 68
    //   135: invokevirtual 586	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   138: astore 4
    //   140: aload 4
    //   142: invokestatic 277	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   145: istore_0
    //   146: iload_0
    //   147: ifne +14 -> 161
    //   150: aload 4
    //   152: invokestatic 600	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   155: invokevirtual 603	java/lang/Integer:intValue	()I
    //   158: invokestatic 609	com/tencent/tmassistantbase/util/ac:a	(I)V
    //   161: aload_1
    //   162: ldc_w 611
    //   165: ldc 68
    //   167: invokevirtual 586	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   170: astore 5
    //   172: aload 5
    //   174: invokestatic 613	com/tencent/tmassistantbase/util/ac:a	(Ljava/lang/String;)V
    //   177: aload_1
    //   178: ldc_w 615
    //   181: ldc 68
    //   183: invokevirtual 586	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   186: astore 6
    //   188: aload 6
    //   190: invokevirtual 589	java/lang/String:trim	()Ljava/lang/String;
    //   193: ldc_w 617
    //   196: invokevirtual 566	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   199: ifeq +261 -> 460
    //   202: iconst_0
    //   203: invokestatic 619	com/tencent/tmassistantbase/util/ac:a	(Z)V
    //   206: aload_1
    //   207: ldc_w 621
    //   210: ldc 68
    //   212: invokevirtual 586	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   215: invokevirtual 589	java/lang/String:trim	()Ljava/lang/String;
    //   218: ldc_w 591
    //   221: invokevirtual 566	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   224: ifeq +243 -> 467
    //   227: iconst_1
    //   228: invokestatic 623	com/tencent/tmassistantbase/util/ac:b	(Z)V
    //   231: ldc_w 295
    //   234: new 297	java/lang/StringBuilder
    //   237: dup
    //   238: invokespecial 298	java/lang/StringBuilder:<init>	()V
    //   241: ldc_w 625
    //   244: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: aload_2
    //   248: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: ldc_w 627
    //   254: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: aload_3
    //   258: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: ldc_w 629
    //   264: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: aload 4
    //   269: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: ldc_w 631
    //   275: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: aload 5
    //   280: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: ldc_w 633
    //   286: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: aload 6
    //   291: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: ldc_w 635
    //   297: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: invokestatic 183	com/tencent/tmassistantbase/util/ac:e	()Z
    //   303: invokevirtual 529	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   306: ldc_w 637
    //   309: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: invokestatic 374	com/tencent/tmassistantbase/util/ac:f	()Z
    //   315: invokevirtual 529	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   318: invokevirtual 311	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   321: invokestatic 192	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   324: pop
    //   325: ldc_w 295
    //   328: new 297	java/lang/StringBuilder
    //   331: dup
    //   332: invokespecial 298	java/lang/StringBuilder:<init>	()V
    //   335: ldc_w 639
    //   338: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: invokestatic 360	com/tencent/tmassistantbase/util/ac:g	()Z
    //   344: invokevirtual 529	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   347: ldc_w 627
    //   350: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: invokestatic 178	com/tencent/tmassistantbase/util/ac:c	()I
    //   356: invokevirtual 385	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   359: ldc_w 629
    //   362: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: invokestatic 180	com/tencent/tmassistantbase/util/ac:b	()I
    //   368: invokevirtual 385	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   371: ldc_w 631
    //   374: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: invokestatic 495	com/tencent/tmassistantbase/util/ac:h	()Ljava/lang/String;
    //   380: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: ldc_w 633
    //   386: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: invokestatic 430	com/tencent/tmassistantbase/util/ac:d	()Z
    //   392: invokevirtual 529	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   395: ldc_w 635
    //   398: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: invokestatic 183	com/tencent/tmassistantbase/util/ac:e	()Z
    //   404: invokevirtual 529	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   407: ldc_w 637
    //   410: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: invokestatic 374	com/tencent/tmassistantbase/util/ac:f	()Z
    //   416: invokevirtual 529	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   419: invokevirtual 311	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   422: invokestatic 192	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   425: pop
    //   426: return
    //   427: astore_1
    //   428: aload_1
    //   429: invokevirtual 420	java/io/IOException:printStackTrace	()V
    //   432: return
    //   433: iconst_0
    //   434: invokestatic 593	com/tencent/tmassistantbase/util/ac:c	(Z)V
    //   437: goto -337 -> 100
    //   440: astore 4
    //   442: aload 4
    //   444: invokevirtual 640	java/lang/NumberFormatException:printStackTrace	()V
    //   447: goto -318 -> 129
    //   450: astore 5
    //   452: aload 5
    //   454: invokevirtual 640	java/lang/NumberFormatException:printStackTrace	()V
    //   457: goto -296 -> 161
    //   460: iconst_1
    //   461: invokestatic 619	com/tencent/tmassistantbase/util/ac:a	(Z)V
    //   464: goto -258 -> 206
    //   467: iconst_0
    //   468: invokestatic 623	com/tencent/tmassistantbase/util/ac:b	(Z)V
    //   471: goto -240 -> 231
    //   474: iconst_0
    //   475: invokestatic 593	com/tencent/tmassistantbase/util/ac:c	(Z)V
    //   478: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   114	33	0	bool	boolean
    //   19	188	1	localProperties	java.util.Properties
    //   427	2	1	localIOException	IOException
    //   52	196	2	localObject	Object
    //   109	149	3	str1	String
    //   138	130	4	str2	String
    //   440	3	4	localNumberFormatException1	java.lang.NumberFormatException
    //   170	109	5	str3	String
    //   450	3	5	localNumberFormatException2	java.lang.NumberFormatException
    //   186	104	6	str4	String
    // Exception table:
    //   from	to	target	type
    //   20	60	427	java/io/IOException
    //   61	100	427	java/io/IOException
    //   100	115	427	java/io/IOException
    //   119	129	427	java/io/IOException
    //   129	146	427	java/io/IOException
    //   150	161	427	java/io/IOException
    //   161	206	427	java/io/IOException
    //   206	231	427	java/io/IOException
    //   231	426	427	java/io/IOException
    //   433	437	427	java/io/IOException
    //   442	447	427	java/io/IOException
    //   452	457	427	java/io/IOException
    //   460	464	427	java/io/IOException
    //   467	471	427	java/io/IOException
    //   119	129	440	java/lang/NumberFormatException
    //   150	161	450	java/lang/NumberFormatException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tmassistantbase.util.ac
 * JD-Core Version:    0.7.0.1
 */