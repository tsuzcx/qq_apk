package com.tencent.mobileqq.microapp.appbrand.b;

import android.os.Environment;
import android.os.Process;
import android.util.LruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.pool.RecyclablePool;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedWriter;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import mqq.app.AppRuntime;

public class c
{
  private static long a;
  private static StringBuilder b = new StringBuilder(10240);
  private static String c = "";
  private static final int d = Process.myPid();
  private static String e = "";
  private static c.a f = null;
  private static c.a g = null;
  private static RecyclablePool h;
  private static volatile c.b i;
  private static String j = "";
  private static HashMap k = new HashMap();
  private static Map l = new HashMap();
  private static final String m;
  private static SimpleDateFormat n;
  private static SimpleDateFormat o;
  private static Map p;
  private static LinkedBlockingQueue q;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory().getPath());
    localStringBuilder.append("/miniApp/files/miniprogramLog/");
    m = localStringBuilder.toString();
    n = new SimpleDateFormat("yy.MM.dd.HH");
    o = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
    p = new HashMap();
    q = new LinkedBlockingQueue(256);
    new LruCache(5);
  }
  
  public static Boolean a(String paramString)
  {
    boolean bool;
    if ((k.get(paramString) != null) && (((Boolean)k.get(paramString)).booleanValue())) {
      bool = true;
    } else {
      bool = false;
    }
    return Boolean.valueOf(bool);
  }
  
  public static void a()
  {
    if ((h == null) && (BaseApplicationImpl.getApplication() != null))
    {
      j = AppSetting.b();
      e = BaseApplicationImpl.getApplication().getProcessName();
      BaseApplicationImpl.getApplication().getPackageName();
      h = new RecyclablePool(c.a.class, 512);
    }
  }
  
  public static void a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    b(paramString1, paramInt, paramString2, paramString3, null);
  }
  
  public static void a(String paramString1, int paramInt, String paramString2, String paramString3, Throwable paramThrowable)
  {
    if (a(paramString2).booleanValue()) {
      a(paramString2, paramString1, paramInt, paramString3, paramThrowable);
    }
    if (QLog.isColorLevel()) {
      QLog.e(paramString1, paramInt, paramString3, paramThrowable);
    }
  }
  
  public static void a(String paramString1, int paramInt, String paramString2, Throwable paramThrowable, Object... paramVarArgs)
  {
    int i3 = paramVarArgs.length;
    int i2 = 0;
    if (paramThrowable == null) {
      i1 = 0;
    } else {
      i1 = 128;
    }
    StringBuilder localStringBuilder = new StringBuilder(i3 * 30 + i1);
    int i1 = i2;
    while (i1 < paramVarArgs.length)
    {
      localStringBuilder.append(paramVarArgs[i1]);
      i1 += 1;
    }
    a(paramString1, paramInt, paramString2, localStringBuilder.toString(), paramThrowable);
  }
  
  private static void a(String arg0, String paramString2, int paramInt, String paramString3, Throwable paramThrowable)
  {
    if (h != null)
    {
      if (StringUtil.isEmpty(???)) {
        return;
      }
      c.a locala = (c.a)h.obtain(c.a.class);
      if (locala == null) {
        return;
      }
      locala.a = System.currentTimeMillis();
      locala.b = Process.myTid();
      locala.c = paramInt;
      locala.d = paramString2;
      locala.e = paramString3;
      locala.f = paramThrowable;
      locala.g = ???;
      synchronized (e)
      {
        if (f == null)
        {
          f = locala;
          g = locala;
        }
        else
        {
          g.changeNext(locala, true);
          g = locala;
        }
        g();
        i.removeMessages(1);
        i.sendEmptyMessageDelayed(1, 1000L);
        return;
      }
    }
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    k.put(paramString, Boolean.valueOf(paramBoolean));
  }
  
  public static void b(String paramString1, int paramInt, String paramString2, String paramString3, Throwable paramThrowable)
  {
    if (a(paramString2).booleanValue()) {
      a(paramString2, paramString1, paramInt, paramString3, paramThrowable);
    }
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, paramInt, paramString3, paramThrowable);
    }
  }
  
  public static boolean b(String paramString)
  {
    return (a(paramString).booleanValue()) || (QLog.isColorLevel());
  }
  
  public static String c(String paramString)
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(m);
    localStringBuilder.append(MD5.toMD5(paramString));
    localStringBuilder.append("/");
    localStringBuilder.append(str);
    localStringBuilder.append("/");
    return localStringBuilder.toString();
  }
  
  private static String d(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(e.replace(":", "_"));
    localStringBuilder.append(".");
    localStringBuilder.append(paramString);
    localStringBuilder.append(".log");
    return localStringBuilder.toString();
  }
  
  private static void g()
  {
    if (i == null) {
      try
      {
        if (i == null) {
          i = new c.b(ThreadManager.getSubThreadLooper(), null);
        }
        return;
      }
      finally {}
    }
  }
  
  /* Error */
  private static void h()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 56	com/tencent/mobileqq/microapp/appbrand/b/c:e	Ljava/lang/String;
    //   6: astore_3
    //   7: aload_3
    //   8: monitorenter
    //   9: getstatic 60	com/tencent/mobileqq/microapp/appbrand/b/c:g	Lcom/tencent/mobileqq/microapp/appbrand/b/c$a;
    //   12: astore 5
    //   14: getstatic 58	com/tencent/mobileqq/microapp/appbrand/b/c:f	Lcom/tencent/mobileqq/microapp/appbrand/b/c$a;
    //   17: astore_2
    //   18: aconst_null
    //   19: putstatic 60	com/tencent/mobileqq/microapp/appbrand/b/c:g	Lcom/tencent/mobileqq/microapp/appbrand/b/c$a;
    //   22: aconst_null
    //   23: putstatic 58	com/tencent/mobileqq/microapp/appbrand/b/c:f	Lcom/tencent/mobileqq/microapp/appbrand/b/c$a;
    //   26: aload_3
    //   27: monitorexit
    //   28: aload_2
    //   29: astore_3
    //   30: aload_2
    //   31: ifnonnull +10 -> 41
    //   34: invokestatic 292	com/tencent/mobileqq/microapp/appbrand/b/c:i	()V
    //   37: ldc 2
    //   39: monitorexit
    //   40: return
    //   41: aload_3
    //   42: getfield 200	com/tencent/mobileqq/microapp/appbrand/b/c$a:a	J
    //   45: lstore_0
    //   46: lload_0
    //   47: getstatic 293	com/tencent/mobileqq/microapp/appbrand/b/c:a	J
    //   50: ldc2_w 229
    //   53: ladd
    //   54: lcmp
    //   55: ifge +11 -> 66
    //   58: lload_0
    //   59: getstatic 293	com/tencent/mobileqq/microapp/appbrand/b/c:a	J
    //   62: lcmp
    //   63: ifge +76 -> 139
    //   66: getstatic 107	com/tencent/mobileqq/microapp/appbrand/b/c:o	Ljava/text/SimpleDateFormat;
    //   69: lload_0
    //   70: invokestatic 298	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   73: invokevirtual 302	java/text/SimpleDateFormat:format	(Ljava/lang/Object;)Ljava/lang/String;
    //   76: putstatic 46	com/tencent/mobileqq/microapp/appbrand/b/c:c	Ljava/lang/String;
    //   79: lload_0
    //   80: getstatic 293	com/tencent/mobileqq/microapp/appbrand/b/c:a	J
    //   83: ldc2_w 229
    //   86: ladd
    //   87: lcmp
    //   88: iflt +28 -> 116
    //   91: lload_0
    //   92: getstatic 293	com/tencent/mobileqq/microapp/appbrand/b/c:a	J
    //   95: ldc2_w 303
    //   98: ladd
    //   99: lcmp
    //   100: ifge +16 -> 116
    //   103: getstatic 293	com/tencent/mobileqq/microapp/appbrand/b/c:a	J
    //   106: ldc2_w 229
    //   109: ladd
    //   110: putstatic 293	com/tencent/mobileqq/microapp/appbrand/b/c:a	J
    //   113: goto +26 -> 139
    //   116: invokestatic 310	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   119: astore_2
    //   120: aload_2
    //   121: lload_0
    //   122: invokevirtual 314	java/util/Calendar:setTimeInMillis	(J)V
    //   125: aload_2
    //   126: bipush 14
    //   128: iconst_0
    //   129: invokevirtual 318	java/util/Calendar:set	(II)V
    //   132: aload_2
    //   133: invokevirtual 321	java/util/Calendar:getTimeInMillis	()J
    //   136: putstatic 293	com/tencent/mobileqq/microapp/appbrand/b/c:a	J
    //   139: new 36	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   146: astore_2
    //   147: aload_2
    //   148: aload_3
    //   149: getfield 215	com/tencent/mobileqq/microapp/appbrand/b/c$a:g	Ljava/lang/String;
    //   152: invokestatic 323	com/tencent/mobileqq/microapp/appbrand/b/c:c	(Ljava/lang/String;)Ljava/lang/String;
    //   155: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: pop
    //   159: aload_2
    //   160: getstatic 103	com/tencent/mobileqq/microapp/appbrand/b/c:n	Ljava/text/SimpleDateFormat;
    //   163: invokestatic 198	java/lang/System:currentTimeMillis	()J
    //   166: invokestatic 298	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   169: invokevirtual 302	java/text/SimpleDateFormat:format	(Ljava/lang/Object;)Ljava/lang/String;
    //   172: invokestatic 325	com/tencent/mobileqq/microapp/appbrand/b/c:d	(Ljava/lang/String;)Ljava/lang/String;
    //   175: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: aload_2
    //   180: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: astore 6
    //   185: new 79	java/io/File
    //   188: dup
    //   189: aload 6
    //   191: invokespecial 326	java/io/File:<init>	(Ljava/lang/String;)V
    //   194: astore 7
    //   196: aload 7
    //   198: invokevirtual 329	java/io/File:exists	()Z
    //   201: ifne +105 -> 306
    //   204: aload 6
    //   206: invokestatic 335	com/tencent/mobileqq/utils/FileUtils:createFile	(Ljava/lang/String;)Ljava/io/File;
    //   209: pop
    //   210: new 337	java/io/BufferedWriter
    //   213: dup
    //   214: new 339	com/tencent/mobileqq/microapp/appbrand/b/g
    //   217: dup
    //   218: aload 7
    //   220: iconst_1
    //   221: invokespecial 342	com/tencent/mobileqq/microapp/appbrand/b/g:<init>	(Ljava/io/File;Z)V
    //   224: sipush 8192
    //   227: invokespecial 345	java/io/BufferedWriter:<init>	(Ljava/io/Writer;I)V
    //   230: astore_2
    //   231: new 36	java/lang/StringBuilder
    //   234: dup
    //   235: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   238: astore 4
    //   240: aload 4
    //   242: getstatic 46	com/tencent/mobileqq/microapp/appbrand/b/c:c	Ljava/lang/String;
    //   245: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: pop
    //   249: aload 4
    //   251: ldc_w 347
    //   254: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: pop
    //   258: aload 4
    //   260: getstatic 56	com/tencent/mobileqq/microapp/appbrand/b/c:e	Ljava/lang/String;
    //   263: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: pop
    //   267: aload 4
    //   269: ldc_w 349
    //   272: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: pop
    //   276: aload 4
    //   278: getstatic 62	com/tencent/mobileqq/microapp/appbrand/b/c:j	Ljava/lang/String;
    //   281: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: pop
    //   285: aload 4
    //   287: ldc_w 351
    //   290: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: pop
    //   294: aload_2
    //   295: aload 4
    //   297: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   300: invokevirtual 354	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   303: goto +47 -> 350
    //   306: getstatic 70	com/tencent/mobileqq/microapp/appbrand/b/c:l	Ljava/util/Map;
    //   309: aload 6
    //   311: invokeinterface 357 2 0
    //   316: checkcast 337	java/io/BufferedWriter
    //   319: astore 4
    //   321: aload 4
    //   323: astore_2
    //   324: aload 4
    //   326: ifnonnull +24 -> 350
    //   329: new 337	java/io/BufferedWriter
    //   332: dup
    //   333: new 339	com/tencent/mobileqq/microapp/appbrand/b/g
    //   336: dup
    //   337: aload 7
    //   339: iconst_1
    //   340: invokespecial 342	com/tencent/mobileqq/microapp/appbrand/b/g:<init>	(Ljava/io/File;Z)V
    //   343: sipush 8192
    //   346: invokespecial 345	java/io/BufferedWriter:<init>	(Ljava/io/Writer;I)V
    //   349: astore_2
    //   350: getstatic 42	com/tencent/mobileqq/microapp/appbrand/b/c:b	Ljava/lang/StringBuilder;
    //   353: iconst_0
    //   354: getstatic 42	com/tencent/mobileqq/microapp/appbrand/b/c:b	Ljava/lang/StringBuilder;
    //   357: invokevirtual 360	java/lang/StringBuilder:length	()I
    //   360: invokevirtual 364	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   363: astore 4
    //   365: aload 4
    //   367: getstatic 46	com/tencent/mobileqq/microapp/appbrand/b/c:c	Ljava/lang/String;
    //   370: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: pop
    //   374: aload 4
    //   376: bipush 124
    //   378: invokevirtual 367	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   381: pop
    //   382: aload 4
    //   384: aload_3
    //   385: getfield 200	com/tencent/mobileqq/microapp/appbrand/b/c$a:a	J
    //   388: invokevirtual 370	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   391: pop
    //   392: aload 4
    //   394: aload_3
    //   395: getfield 215	com/tencent/mobileqq/microapp/appbrand/b/c$a:g	Ljava/lang/String;
    //   398: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: pop
    //   402: aload 4
    //   404: bipush 91
    //   406: invokevirtual 367	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   409: pop
    //   410: aload 4
    //   412: getstatic 54	com/tencent/mobileqq/microapp/appbrand/b/c:d	I
    //   415: invokevirtual 373	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   418: pop
    //   419: aload 4
    //   421: bipush 93
    //   423: invokevirtual 367	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   426: pop
    //   427: aload 4
    //   429: aload_3
    //   430: getfield 205	com/tencent/mobileqq/microapp/appbrand/b/c$a:b	I
    //   433: invokevirtual 373	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   436: pop
    //   437: aload 4
    //   439: bipush 124
    //   441: invokevirtual 367	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   444: pop
    //   445: aload 4
    //   447: aload_3
    //   448: getfield 207	com/tencent/mobileqq/microapp/appbrand/b/c$a:c	I
    //   451: invokestatic 377	com/tencent/qphone/base/util/QLog:getReportLevel	(I)Ljava/lang/String;
    //   454: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: pop
    //   458: aload 4
    //   460: bipush 124
    //   462: invokevirtual 367	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   465: pop
    //   466: aload 4
    //   468: aload_3
    //   469: getfield 209	com/tencent/mobileqq/microapp/appbrand/b/c$a:d	Ljava/lang/String;
    //   472: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: pop
    //   476: aload 4
    //   478: bipush 124
    //   480: invokevirtual 367	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   483: pop
    //   484: aload 4
    //   486: aload_3
    //   487: getfield 210	com/tencent/mobileqq/microapp/appbrand/b/c$a:e	Ljava/lang/String;
    //   490: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: pop
    //   494: aload 4
    //   496: bipush 10
    //   498: invokevirtual 367	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   501: pop
    //   502: aload_2
    //   503: aload 4
    //   505: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   508: invokevirtual 354	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   511: aload_3
    //   512: getfield 213	com/tencent/mobileqq/microapp/appbrand/b/c$a:f	Ljava/lang/Throwable;
    //   515: ifnull +20 -> 535
    //   518: aload_2
    //   519: aload_3
    //   520: getfield 213	com/tencent/mobileqq/microapp/appbrand/b/c$a:f	Ljava/lang/Throwable;
    //   523: invokestatic 383	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   526: invokevirtual 354	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   529: aload_2
    //   530: bipush 10
    //   532: invokevirtual 385	java/io/BufferedWriter:write	(I)V
    //   535: getstatic 70	com/tencent/mobileqq/microapp/appbrand/b/c:l	Ljava/util/Map;
    //   538: aload 6
    //   540: aload_2
    //   541: invokeinterface 386 3 0
    //   546: pop
    //   547: aload_3
    //   548: invokevirtual 390	com/tencent/mobileqq/microapp/appbrand/b/c$a:getNext	()Lcom/tencent/commonsdk/pool/RecyclablePool$Recyclable;
    //   551: checkcast 156	com/tencent/mobileqq/microapp/appbrand/b/c$a
    //   554: astore_2
    //   555: getstatic 136	com/tencent/mobileqq/microapp/appbrand/b/c:h	Lcom/tencent/commonsdk/pool/RecyclablePool;
    //   558: aload_3
    //   559: invokevirtual 394	com/tencent/commonsdk/pool/RecyclablePool:recycle	(Lcom/tencent/commonsdk/pool/RecyclablePool$Recyclable;)V
    //   562: aload_3
    //   563: aload 5
    //   565: if_acmpne +12 -> 577
    //   568: invokestatic 292	com/tencent/mobileqq/microapp/appbrand/b/c:i	()V
    //   571: invokestatic 292	com/tencent/mobileqq/microapp/appbrand/b/c:i	()V
    //   574: goto +45 -> 619
    //   577: aload_2
    //   578: astore_3
    //   579: goto -538 -> 41
    //   582: astore_2
    //   583: aload_3
    //   584: monitorexit
    //   585: aload_2
    //   586: athrow
    //   587: astore_2
    //   588: goto +35 -> 623
    //   591: astore_2
    //   592: aload_2
    //   593: invokevirtual 397	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   596: ifnull -25 -> 571
    //   599: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   602: ifeq -31 -> 571
    //   605: ldc_w 399
    //   608: iconst_2
    //   609: aload_2
    //   610: invokevirtual 397	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   613: invokestatic 402	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   616: goto -45 -> 571
    //   619: ldc 2
    //   621: monitorexit
    //   622: return
    //   623: invokestatic 292	com/tencent/mobileqq/microapp/appbrand/b/c:i	()V
    //   626: aload_2
    //   627: athrow
    //   628: astore_2
    //   629: ldc 2
    //   631: monitorexit
    //   632: goto +5 -> 637
    //   635: aload_2
    //   636: athrow
    //   637: goto -2 -> 635
    // Local variable table:
    //   start	length	slot	name	signature
    //   45	77	0	l1	long
    //   17	561	2	localObject1	Object
    //   582	4	2	localObject2	Object
    //   587	1	2	localObject3	Object
    //   591	36	2	localThrowable	Throwable
    //   628	8	2	localObject4	Object
    //   238	266	4	localObject6	Object
    //   12	552	5	locala	c.a
    //   183	356	6	str	String
    //   194	144	7	localFile	File
    // Exception table:
    //   from	to	target	type
    //   9	28	582	finally
    //   583	585	582	finally
    //   3	9	587	finally
    //   41	66	587	finally
    //   66	113	587	finally
    //   116	139	587	finally
    //   139	303	587	finally
    //   306	321	587	finally
    //   329	350	587	finally
    //   350	535	587	finally
    //   535	562	587	finally
    //   568	571	587	finally
    //   585	587	587	finally
    //   592	616	587	finally
    //   3	9	591	java/lang/Throwable
    //   41	66	591	java/lang/Throwable
    //   66	113	591	java/lang/Throwable
    //   116	139	591	java/lang/Throwable
    //   139	303	591	java/lang/Throwable
    //   306	321	591	java/lang/Throwable
    //   329	350	591	java/lang/Throwable
    //   350	535	591	java/lang/Throwable
    //   535	562	591	java/lang/Throwable
    //   568	571	591	java/lang/Throwable
    //   585	587	591	java/lang/Throwable
    //   34	37	628	finally
    //   571	574	628	finally
    //   623	628	628	finally
  }
  
  private static void i()
  {
    Iterator localIterator = l.values().iterator();
    while (localIterator.hasNext())
    {
      BufferedWriter localBufferedWriter = (BufferedWriter)localIterator.next();
      if (localBufferedWriter != null) {
        try
        {
          localBufferedWriter.flush();
          localBufferedWriter.close();
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
    l.clear();
  }
  
  /* Error */
  private static void j()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 114	com/tencent/mobileqq/microapp/appbrand/b/c:q	Ljava/util/concurrent/LinkedBlockingQueue;
    //   6: invokevirtual 437	java/util/concurrent/LinkedBlockingQueue:isEmpty	()Z
    //   9: ifne +144 -> 153
    //   12: getstatic 114	com/tencent/mobileqq/microapp/appbrand/b/c:q	Ljava/util/concurrent/LinkedBlockingQueue;
    //   15: invokevirtual 440	java/util/concurrent/LinkedBlockingQueue:poll	()Ljava/lang/Object;
    //   18: checkcast 442	com/tencent/mobileqq/microapp/a/c
    //   21: astore_2
    //   22: aload_2
    //   23: ifnull -20 -> 3
    //   26: aload_2
    //   27: getfield 443	com/tencent/mobileqq/microapp/a/c:g	Ljava/lang/String;
    //   30: invokestatic 188	com/tencent/mobileqq/utils/StringUtil:isEmpty	(Ljava/lang/String;)Z
    //   33: ifeq +6 -> 39
    //   36: goto -33 -> 3
    //   39: aload_2
    //   40: getfield 443	com/tencent/mobileqq/microapp/a/c:g	Ljava/lang/String;
    //   43: astore_3
    //   44: new 79	java/io/File
    //   47: dup
    //   48: aload_3
    //   49: invokespecial 326	java/io/File:<init>	(Ljava/lang/String;)V
    //   52: astore 4
    //   54: aload 4
    //   56: invokevirtual 329	java/io/File:exists	()Z
    //   59: ifne +32 -> 91
    //   62: aload_3
    //   63: invokestatic 335	com/tencent/mobileqq/utils/FileUtils:createFile	(Ljava/lang/String;)Ljava/io/File;
    //   66: pop
    //   67: new 337	java/io/BufferedWriter
    //   70: dup
    //   71: new 339	com/tencent/mobileqq/microapp/appbrand/b/g
    //   74: dup
    //   75: aload 4
    //   77: iconst_1
    //   78: invokespecial 342	com/tencent/mobileqq/microapp/appbrand/b/g:<init>	(Ljava/io/File;Z)V
    //   81: sipush 8192
    //   84: invokespecial 345	java/io/BufferedWriter:<init>	(Ljava/io/Writer;I)V
    //   87: astore_0
    //   88: goto +43 -> 131
    //   91: getstatic 109	com/tencent/mobileqq/microapp/appbrand/b/c:p	Ljava/util/Map;
    //   94: aload_3
    //   95: invokeinterface 357 2 0
    //   100: checkcast 337	java/io/BufferedWriter
    //   103: astore_1
    //   104: aload_1
    //   105: astore_0
    //   106: aload_1
    //   107: ifnonnull +24 -> 131
    //   110: new 337	java/io/BufferedWriter
    //   113: dup
    //   114: new 339	com/tencent/mobileqq/microapp/appbrand/b/g
    //   117: dup
    //   118: aload 4
    //   120: iconst_1
    //   121: invokespecial 342	com/tencent/mobileqq/microapp/appbrand/b/g:<init>	(Ljava/io/File;Z)V
    //   124: sipush 8192
    //   127: invokespecial 345	java/io/BufferedWriter:<init>	(Ljava/io/Writer;I)V
    //   130: astore_0
    //   131: aload_0
    //   132: aload_2
    //   133: getfield 445	com/tencent/mobileqq/microapp/a/c:h	Ljava/lang/String;
    //   136: invokevirtual 354	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   139: getstatic 109	com/tencent/mobileqq/microapp/appbrand/b/c:p	Ljava/util/Map;
    //   142: aload_3
    //   143: aload_0
    //   144: invokeinterface 386 3 0
    //   149: pop
    //   150: goto -147 -> 3
    //   153: invokestatic 447	com/tencent/mobileqq/microapp/appbrand/b/c:k	()V
    //   156: goto +35 -> 191
    //   159: astore_0
    //   160: goto +35 -> 195
    //   163: astore_0
    //   164: aload_0
    //   165: invokevirtual 397	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   168: ifnull -15 -> 153
    //   171: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   174: ifeq -21 -> 153
    //   177: ldc_w 399
    //   180: iconst_2
    //   181: aload_0
    //   182: invokevirtual 397	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   185: invokestatic 402	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   188: goto -35 -> 153
    //   191: ldc 2
    //   193: monitorexit
    //   194: return
    //   195: invokestatic 447	com/tencent/mobileqq/microapp/appbrand/b/c:k	()V
    //   198: aload_0
    //   199: athrow
    //   200: astore_0
    //   201: ldc 2
    //   203: monitorexit
    //   204: goto +5 -> 209
    //   207: aload_0
    //   208: athrow
    //   209: goto -2 -> 207
    // Local variable table:
    //   start	length	slot	name	signature
    //   87	57	0	localObject1	Object
    //   159	1	0	localObject2	Object
    //   163	36	0	localThrowable	Throwable
    //   200	8	0	localObject3	Object
    //   103	4	1	localBufferedWriter	BufferedWriter
    //   21	112	2	localc	com.tencent.mobileqq.microapp.a.c
    //   43	100	3	str	String
    //   52	67	4	localFile	File
    // Exception table:
    //   from	to	target	type
    //   3	22	159	finally
    //   26	36	159	finally
    //   39	88	159	finally
    //   91	104	159	finally
    //   110	131	159	finally
    //   131	150	159	finally
    //   164	188	159	finally
    //   3	22	163	java/lang/Throwable
    //   26	36	163	java/lang/Throwable
    //   39	88	163	java/lang/Throwable
    //   91	104	163	java/lang/Throwable
    //   110	131	163	java/lang/Throwable
    //   131	150	163	java/lang/Throwable
    //   153	156	200	finally
    //   195	200	200	finally
  }
  
  private static void k()
  {
    Iterator localIterator = p.values().iterator();
    while (localIterator.hasNext())
    {
      BufferedWriter localBufferedWriter = (BufferedWriter)localIterator.next();
      if (localBufferedWriter != null) {
        try
        {
          localBufferedWriter.flush();
          localBufferedWriter.close();
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
    p.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.b.c
 * JD-Core Version:    0.7.0.1
 */