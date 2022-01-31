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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class ab
{
  protected static ArrayList<WeakReference<m>> A;
  private static List<String> B;
  private static long C;
  private static Boolean D = Boolean.valueOf(true);
  private static ThreadLocal<char[]> E = new ac();
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
  protected static Runnable x = new ad();
  static Thread y = new af();
  protected static ReferenceQueue<m> z;
  
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
    if ((paramInt < c()) && (paramInt < b())) {}
    label131:
    label141:
    label149:
    for (;;)
    {
      return;
      if (paramInt >= b())
      {
        if ((paramInt == 2) && (a()))
        {
          if (paramThrowable == null) {
            Log.v(paramString1, paramString2);
          }
        }
        else
        {
          if ((paramInt == 3) && (a()))
          {
            if (paramThrowable != null) {
              break label121;
            }
            Log.d(paramString1, paramString2);
          }
          label64:
          if (paramInt == 4)
          {
            if (paramThrowable != null) {
              break label131;
            }
            Log.i(paramString1, paramString2);
          }
          label79:
          if (paramInt == 5)
          {
            if (paramThrowable != null) {
              break label141;
            }
            Log.w(paramString1, paramString2);
          }
        }
        for (;;)
        {
          if (paramInt != 6) {
            break label149;
          }
          if (paramThrowable != null) {
            break label151;
          }
          Log.e(paramString1, paramString2);
          return;
          Log.v(paramString1, paramString2, paramThrowable);
          break;
          label121:
          Log.d(paramString1, paramString2, paramThrowable);
          break label64;
          Log.i(paramString1, paramString2, paramThrowable);
          break label79;
          Log.w(paramString1, paramString2, paramThrowable);
        }
      }
    }
    label151:
    Log.e(paramString1, paramString2, paramThrowable);
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
  
  public static boolean a(m paramm)
  {
    boolean bool;
    if (paramm == null) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      Object localObject;
      try
      {
        Log.d("TMLog", "registerLogListener : " + paramm);
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
          if ((m)((WeakReference)((Iterator)localObject).next()).get() == paramm)
          {
            bool = true;
            break;
          }
        }
      }
      paramm = new WeakReference(paramm, z);
      A.add(paramm);
      bool = true;
    }
  }
  
  public static int b()
  {
    return c;
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
  
  public static boolean b(m paramm)
  {
    boolean bool;
    if (paramm == null)
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
          if ((m)localWeakReference.get() != paramm) {
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
          l();
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
  
  /* Error */
  private static void l()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 237
    //   5: ldc_w 376
    //   8: invokestatic 188	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   11: pop
    //   12: new 356	java/io/File
    //   15: dup
    //   16: invokestatic 378	com/tencent/tmassistantbase/util/ab:h	()Ljava/lang/String;
    //   19: invokespecial 379	java/io/File:<init>	(Ljava/lang/String;)V
    //   22: astore_1
    //   23: aload_1
    //   24: invokevirtual 382	java/io/File:exists	()Z
    //   27: ifne +8 -> 35
    //   30: aload_1
    //   31: invokevirtual 385	java/io/File:mkdirs	()Z
    //   34: pop
    //   35: new 356	java/io/File
    //   38: dup
    //   39: new 239	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 240	java/lang/StringBuilder:<init>	()V
    //   46: invokestatic 378	com/tencent/tmassistantbase/util/ab:h	()Ljava/lang/String;
    //   49: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: getstatic 104	com/tencent/tmassistantbase/util/ab:o	Ljava/lang/String;
    //   55: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: ldc_w 387
    //   61: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokespecial 379	java/io/File:<init>	(Ljava/lang/String;)V
    //   70: astore_1
    //   71: aload_1
    //   72: invokevirtual 382	java/io/File:exists	()Z
    //   75: ifne +145 -> 220
    //   78: aload_1
    //   79: invokevirtual 390	java/io/File:createNewFile	()Z
    //   82: istore_0
    //   83: invokestatic 392	com/tencent/tmassistantbase/util/ab:m	()V
    //   86: getstatic 309	com/tencent/tmassistantbase/util/ab:k	Ljava/io/BufferedWriter;
    //   89: ifnull +102 -> 191
    //   92: invokestatic 307	com/tencent/tmassistantbase/util/ab:g	()Z
    //   95: ifeq +96 -> 191
    //   98: getstatic 309	com/tencent/tmassistantbase/util/ab:k	Ljava/io/BufferedWriter;
    //   101: new 239	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 240	java/lang/StringBuilder:<init>	()V
    //   108: invokestatic 394	com/tencent/tmassistantbase/util/ab:i	()Ljava/lang/String;
    //   111: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: ldc_w 396
    //   117: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: getstatic 104	com/tencent/tmassistantbase/util/ab:o	Ljava/lang/String;
    //   123: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: ldc_w 396
    //   129: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: getstatic 401	android/os/Build:MODEL	Ljava/lang/String;
    //   135: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: ldc_w 403
    //   141: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: getstatic 408	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   147: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: ldc_w 410
    //   153: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: aload_1
    //   157: invokevirtual 413	java/io/File:getName	()Ljava/lang/String;
    //   160: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: ldc_w 403
    //   166: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: iload_0
    //   170: invokevirtual 416	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   173: ldc_w 418
    //   176: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: invokevirtual 336	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   185: getstatic 309	com/tencent/tmassistantbase/util/ab:k	Ljava/io/BufferedWriter;
    //   188: invokevirtual 341	java/io/BufferedWriter:flush	()V
    //   191: new 333	java/io/BufferedWriter
    //   194: dup
    //   195: new 420	java/io/FileWriter
    //   198: dup
    //   199: aload_1
    //   200: iconst_1
    //   201: invokespecial 423	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   204: sipush 8192
    //   207: invokespecial 426	java/io/BufferedWriter:<init>	(Ljava/io/Writer;I)V
    //   210: putstatic 309	com/tencent/tmassistantbase/util/ab:k	Ljava/io/BufferedWriter;
    //   213: invokestatic 392	com/tencent/tmassistantbase/util/ab:m	()V
    //   216: ldc 2
    //   218: monitorexit
    //   219: return
    //   220: aload_1
    //   221: invokevirtual 429	java/io/File:length	()J
    //   224: ldc2_w 430
    //   227: lcmp
    //   228: iflt +48 -> 276
    //   231: aload_1
    //   232: invokevirtual 434	java/io/File:delete	()Z
    //   235: pop
    //   236: aload_1
    //   237: invokevirtual 390	java/io/File:createNewFile	()Z
    //   240: pop
    //   241: ldc 237
    //   243: new 239	java/lang/StringBuilder
    //   246: dup
    //   247: invokespecial 240	java/lang/StringBuilder:<init>	()V
    //   250: ldc_w 436
    //   253: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: aload_1
    //   257: invokevirtual 413	java/io/File:getName	()Ljava/lang/String;
    //   260: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: ldc_w 438
    //   266: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   272: invokestatic 188	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   275: pop
    //   276: invokestatic 392	com/tencent/tmassistantbase/util/ab:m	()V
    //   279: getstatic 309	com/tencent/tmassistantbase/util/ab:k	Ljava/io/BufferedWriter;
    //   282: ifnull -91 -> 191
    //   285: invokestatic 307	com/tencent/tmassistantbase/util/ab:g	()Z
    //   288: ifeq -97 -> 191
    //   291: getstatic 309	com/tencent/tmassistantbase/util/ab:k	Ljava/io/BufferedWriter;
    //   294: new 239	java/lang/StringBuilder
    //   297: dup
    //   298: invokespecial 240	java/lang/StringBuilder:<init>	()V
    //   301: invokestatic 394	com/tencent/tmassistantbase/util/ab:i	()Ljava/lang/String;
    //   304: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: ldc_w 396
    //   310: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: getstatic 104	com/tencent/tmassistantbase/util/ab:o	Ljava/lang/String;
    //   316: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: ldc_w 396
    //   322: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: getstatic 401	android/os/Build:MODEL	Ljava/lang/String;
    //   328: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: ldc_w 403
    //   334: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: getstatic 408	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   340: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: ldc_w 440
    //   346: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: aload_1
    //   350: invokevirtual 413	java/io/File:getName	()Ljava/lang/String;
    //   353: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: ldc_w 442
    //   359: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   365: invokevirtual 336	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   368: getstatic 309	com/tencent/tmassistantbase/util/ab:k	Ljava/io/BufferedWriter;
    //   371: invokevirtual 341	java/io/BufferedWriter:flush	()V
    //   374: goto -183 -> 191
    //   377: astore_2
    //   378: aload_2
    //   379: invokevirtual 443	java/lang/Throwable:printStackTrace	()V
    //   382: goto -191 -> 191
    //   385: astore_1
    //   386: ldc 2
    //   388: monitorexit
    //   389: aload_1
    //   390: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   82	88	0	bool	boolean
    //   22	328	1	localFile	File
    //   385	5	1	localObject	Object
    //   377	2	2	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   71	191	377	java/lang/Throwable
    //   220	276	377	java/lang/Throwable
    //   276	374	377	java/lang/Throwable
    //   3	35	385	finally
    //   35	71	385	finally
    //   71	191	385	finally
    //   191	216	385	finally
    //   220	276	385	finally
    //   276	374	385	finally
    //   378	382	385	finally
  }
  
  private static void m()
  {
    if ((k != null) && (g()))
    {
      k.write("SDK_VERSION = 1.0|BUILD_NO = {BuildNo}|RELEASE_DATE: {ReleaseDate}\r\n");
      k.flush();
    }
  }
  
  /* Error */
  private static void n()
  {
    // Byte code:
    //   0: ldc_w 449
    //   3: invokestatic 452	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   6: invokevirtual 455	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9: ifeq +463 -> 472
    //   12: new 457	java/util/Properties
    //   15: dup
    //   16: invokespecial 458	java/util/Properties:<init>	()V
    //   19: astore_1
    //   20: new 356	java/io/File
    //   23: dup
    //   24: new 239	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 240	java/lang/StringBuilder:<init>	()V
    //   31: invokestatic 354	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   34: invokevirtual 359	java/io/File:getPath	()Ljava/lang/String;
    //   37: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: ldc_w 460
    //   43: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokespecial 379	java/io/File:<init>	(Ljava/lang/String;)V
    //   52: astore_2
    //   53: aload_2
    //   54: invokevirtual 382	java/io/File:exists	()Z
    //   57: ifne +4 -> 61
    //   60: return
    //   61: aload_1
    //   62: new 462	java/io/FileInputStream
    //   65: dup
    //   66: aload_2
    //   67: invokespecial 465	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   70: invokevirtual 469	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   73: aload_1
    //   74: ldc_w 471
    //   77: ldc 66
    //   79: invokevirtual 475	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   82: astore_2
    //   83: aload_2
    //   84: invokevirtual 478	java/lang/String:trim	()Ljava/lang/String;
    //   87: ldc_w 480
    //   90: invokevirtual 455	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   93: ifeq +338 -> 431
    //   96: iconst_1
    //   97: invokestatic 482	com/tencent/tmassistantbase/util/ab:c	(Z)V
    //   100: aload_1
    //   101: ldc_w 484
    //   104: ldc 66
    //   106: invokevirtual 475	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   109: astore_3
    //   110: aload_3
    //   111: invokestatic 219	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   114: istore_0
    //   115: iload_0
    //   116: ifne +13 -> 129
    //   119: aload_3
    //   120: invokestatic 489	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   123: invokevirtual 492	java/lang/Integer:intValue	()I
    //   126: invokestatic 494	com/tencent/tmassistantbase/util/ab:b	(I)V
    //   129: aload_1
    //   130: ldc_w 496
    //   133: ldc 66
    //   135: invokevirtual 475	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   138: astore 4
    //   140: aload 4
    //   142: invokestatic 219	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   145: istore_0
    //   146: iload_0
    //   147: ifne +14 -> 161
    //   150: aload 4
    //   152: invokestatic 489	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   155: invokevirtual 492	java/lang/Integer:intValue	()I
    //   158: invokestatic 498	com/tencent/tmassistantbase/util/ab:a	(I)V
    //   161: aload_1
    //   162: ldc_w 500
    //   165: ldc 66
    //   167: invokevirtual 475	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   170: astore 5
    //   172: aload 5
    //   174: invokestatic 502	com/tencent/tmassistantbase/util/ab:a	(Ljava/lang/String;)V
    //   177: aload_1
    //   178: ldc_w 504
    //   181: ldc 66
    //   183: invokevirtual 475	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   186: astore 6
    //   188: aload 6
    //   190: invokevirtual 478	java/lang/String:trim	()Ljava/lang/String;
    //   193: ldc_w 506
    //   196: invokevirtual 455	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   199: ifeq +259 -> 458
    //   202: iconst_0
    //   203: invokestatic 508	com/tencent/tmassistantbase/util/ab:a	(Z)V
    //   206: aload_1
    //   207: ldc_w 510
    //   210: ldc 66
    //   212: invokevirtual 475	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   215: invokevirtual 478	java/lang/String:trim	()Ljava/lang/String;
    //   218: ldc_w 480
    //   221: invokevirtual 455	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   224: ifeq +241 -> 465
    //   227: iconst_1
    //   228: invokestatic 512	com/tencent/tmassistantbase/util/ab:b	(Z)V
    //   231: ldc 237
    //   233: new 239	java/lang/StringBuilder
    //   236: dup
    //   237: invokespecial 240	java/lang/StringBuilder:<init>	()V
    //   240: ldc_w 514
    //   243: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: aload_2
    //   247: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: ldc_w 516
    //   253: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: aload_3
    //   257: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: ldc_w 518
    //   263: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: aload 4
    //   268: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: ldc_w 520
    //   274: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: aload 5
    //   279: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: ldc_w 522
    //   285: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: aload 6
    //   290: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: ldc_w 524
    //   296: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: invokestatic 526	com/tencent/tmassistantbase/util/ab:e	()Z
    //   302: invokevirtual 416	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   305: ldc_w 528
    //   308: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: invokestatic 530	com/tencent/tmassistantbase/util/ab:f	()Z
    //   314: invokevirtual 416	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   317: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   320: invokestatic 188	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   323: pop
    //   324: ldc 237
    //   326: new 239	java/lang/StringBuilder
    //   329: dup
    //   330: invokespecial 240	java/lang/StringBuilder:<init>	()V
    //   333: ldc_w 532
    //   336: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: invokestatic 307	com/tencent/tmassistantbase/util/ab:g	()Z
    //   342: invokevirtual 416	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   345: ldc_w 516
    //   348: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: invokestatic 176	com/tencent/tmassistantbase/util/ab:c	()I
    //   354: invokevirtual 535	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   357: ldc_w 518
    //   360: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: invokestatic 178	com/tencent/tmassistantbase/util/ab:b	()I
    //   366: invokevirtual 535	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   369: ldc_w 520
    //   372: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: invokestatic 378	com/tencent/tmassistantbase/util/ab:h	()Ljava/lang/String;
    //   378: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: ldc_w 522
    //   384: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: invokestatic 338	com/tencent/tmassistantbase/util/ab:d	()Z
    //   390: invokevirtual 416	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   393: ldc_w 524
    //   396: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: invokestatic 526	com/tencent/tmassistantbase/util/ab:e	()Z
    //   402: invokevirtual 416	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   405: ldc_w 528
    //   408: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: invokestatic 530	com/tencent/tmassistantbase/util/ab:f	()Z
    //   414: invokevirtual 416	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   417: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   420: invokestatic 188	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   423: pop
    //   424: return
    //   425: astore_1
    //   426: aload_1
    //   427: invokevirtual 328	java/io/IOException:printStackTrace	()V
    //   430: return
    //   431: iconst_0
    //   432: invokestatic 482	com/tencent/tmassistantbase/util/ab:c	(Z)V
    //   435: goto -335 -> 100
    //   438: astore 4
    //   440: aload 4
    //   442: invokevirtual 536	java/lang/NumberFormatException:printStackTrace	()V
    //   445: goto -316 -> 129
    //   448: astore 5
    //   450: aload 5
    //   452: invokevirtual 536	java/lang/NumberFormatException:printStackTrace	()V
    //   455: goto -294 -> 161
    //   458: iconst_1
    //   459: invokestatic 508	com/tencent/tmassistantbase/util/ab:a	(Z)V
    //   462: goto -256 -> 206
    //   465: iconst_0
    //   466: invokestatic 512	com/tencent/tmassistantbase/util/ab:b	(Z)V
    //   469: goto -238 -> 231
    //   472: iconst_0
    //   473: invokestatic 482	com/tencent/tmassistantbase/util/ab:c	(Z)V
    //   476: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   114	33	0	bool	boolean
    //   19	188	1	localProperties	java.util.Properties
    //   425	2	1	localIOException	IOException
    //   52	195	2	localObject	Object
    //   109	148	3	str1	String
    //   138	129	4	str2	String
    //   438	3	4	localNumberFormatException1	java.lang.NumberFormatException
    //   170	108	5	str3	String
    //   448	3	5	localNumberFormatException2	java.lang.NumberFormatException
    //   186	103	6	str4	String
    // Exception table:
    //   from	to	target	type
    //   20	60	425	java/io/IOException
    //   61	100	425	java/io/IOException
    //   100	115	425	java/io/IOException
    //   119	129	425	java/io/IOException
    //   129	146	425	java/io/IOException
    //   150	161	425	java/io/IOException
    //   161	206	425	java/io/IOException
    //   206	231	425	java/io/IOException
    //   231	424	425	java/io/IOException
    //   431	435	425	java/io/IOException
    //   440	445	425	java/io/IOException
    //   450	455	425	java/io/IOException
    //   458	462	425	java/io/IOException
    //   465	469	425	java/io/IOException
    //   119	129	438	java/lang/NumberFormatException
    //   150	161	448	java/lang/NumberFormatException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tmassistantbase.util.ab
 * JD-Core Version:    0.7.0.1
 */