package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class Cranberry
{
  public static Cranberry a = new Cranberry();
  public static long b = TimeUnit.MINUTES.toMillis(30L);
  public static int[] c = { 0, 15, 30, 90, 240, 360, 600, 1200, 2400, 3200, 4800, 7200 };
  public final d;
  public Handler e;
  public boolean f = false;
  public Date g;
  public final Object h = new Object();
  public final AtomicReference<Chestnut> i = new AtomicReference(null);
  public final AtomicReference<Boolean> j = new AtomicReference(Boolean.FALSE);
  
  /* Error */
  public static void a(Cranberry paramCranberry)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 76	java/lang/Object:getClass	()Ljava/lang/Class;
    //   4: pop
    //   5: ldc 78
    //   7: monitorenter
    //   8: getstatic 81	com/tencent/turingfd/sdk/xq/const:a	Landroid/content/Context;
    //   11: astore 8
    //   13: ldc 78
    //   15: monitorexit
    //   16: aload 8
    //   18: aload_0
    //   19: getfield 83	com/tencent/turingfd/sdk/xq/Cranberry:g	Lcom/tencent/turingfd/sdk/xq/Date;
    //   22: invokestatic 88	com/tencent/turingfd/sdk/xq/Grapefruit:a	(Landroid/content/Context;Lcom/tencent/turingfd/sdk/xq/Date;)V
    //   25: aload_0
    //   26: getfield 90	com/tencent/turingfd/sdk/xq/Cranberry:d	Lcom/tencent/turingfd/sdk/xq/final;
    //   29: getfield 95	com/tencent/turingfd/sdk/xq/final:t	J
    //   32: invokestatic 101	java/lang/Thread:sleep	(J)V
    //   35: iconst_1
    //   36: istore_2
    //   37: aload_0
    //   38: aload 8
    //   40: iconst_1
    //   41: iconst_1
    //   42: invokevirtual 104	com/tencent/turingfd/sdk/xq/Cranberry:a	(Landroid/content/Context;IZ)J
    //   45: pop2
    //   46: getstatic 109	com/tencent/turingfd/sdk/xq/Filbert:a	Lcom/tencent/turingfd/sdk/xq/Filbert;
    //   49: bipush 39
    //   51: invokevirtual 112	com/tencent/turingfd/sdk/xq/Filbert:a	(I)Z
    //   54: ifeq +335 -> 389
    //   57: new 114	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   64: astore 9
    //   66: new 117	java/lang/String
    //   69: dup
    //   70: ldc 119
    //   72: invokestatic 124	com/tencent/turingfd/sdk/xq/instanceof:a	(Ljava/lang/String;)[B
    //   75: invokespecial 127	java/lang/String:<init>	([B)V
    //   78: ldc 129
    //   80: invokevirtual 133	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   83: astore 10
    //   85: new 135	java/util/HashSet
    //   88: dup
    //   89: invokespecial 136	java/util/HashSet:<init>	()V
    //   92: astore 11
    //   94: aload 10
    //   96: arraylength
    //   97: istore_3
    //   98: iconst_0
    //   99: istore_1
    //   100: iload_1
    //   101: iload_3
    //   102: if_icmpge +222 -> 324
    //   105: aload 10
    //   107: iload_1
    //   108: aaload
    //   109: ldc 138
    //   111: invokevirtual 133	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   114: astore 6
    //   116: aload 6
    //   118: arraylength
    //   119: iconst_2
    //   120: if_icmpge +6 -> 126
    //   123: goto +194 -> 317
    //   126: aload 6
    //   128: aload 6
    //   130: arraylength
    //   131: iconst_1
    //   132: isub
    //   133: aaload
    //   134: invokevirtual 142	java/lang/String:trim	()Ljava/lang/String;
    //   137: astore 12
    //   139: aconst_null
    //   140: astore 6
    //   142: new 144	java/io/File
    //   145: dup
    //   146: aload 12
    //   148: invokespecial 147	java/io/File:<init>	(Ljava/lang/String;)V
    //   151: astore 7
    //   153: aload 7
    //   155: invokevirtual 151	java/io/File:exists	()Z
    //   158: ifne +6 -> 164
    //   161: goto +156 -> 317
    //   164: aload 7
    //   166: invokevirtual 154	java/io/File:getName	()Ljava/lang/String;
    //   169: astore 7
    //   171: aload 7
    //   173: astore 6
    //   175: aload 6
    //   177: ifnonnull +6 -> 183
    //   180: goto +137 -> 317
    //   183: aload 6
    //   185: ldc 156
    //   187: invokevirtual 160	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   190: ifne +6 -> 196
    //   193: goto +124 -> 317
    //   196: aload 6
    //   198: ldc 162
    //   200: invokevirtual 166	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   203: ifne +6 -> 209
    //   206: goto +111 -> 317
    //   209: aload 6
    //   211: ldc 168
    //   213: invokevirtual 160	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   216: ifeq +6 -> 222
    //   219: goto +98 -> 317
    //   222: ldc 170
    //   224: aload 12
    //   226: invokestatic 176	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   229: ifeq +6 -> 235
    //   232: goto +85 -> 317
    //   235: aload 11
    //   237: aload 12
    //   239: invokevirtual 179	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   242: ifeq +6 -> 248
    //   245: goto +72 -> 317
    //   248: aload 11
    //   250: aload 12
    //   252: invokevirtual 182	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   255: pop
    //   256: aload 8
    //   258: aload 12
    //   260: invokestatic 185	com/tencent/turingfd/sdk/xq/const:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   263: astore 6
    //   265: aload 6
    //   267: ifnull +50 -> 317
    //   270: aload 6
    //   272: ldc 187
    //   274: invokestatic 176	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   277: ifne +40 -> 317
    //   280: aload 6
    //   282: ldc 189
    //   284: invokestatic 176	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   287: ifeq +6 -> 293
    //   290: goto +27 -> 317
    //   293: aload 9
    //   295: invokevirtual 193	java/lang/StringBuilder:length	()I
    //   298: ifle +11 -> 309
    //   301: aload 9
    //   303: ldc 195
    //   305: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: pop
    //   309: aload 9
    //   311: aload 6
    //   313: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: pop
    //   317: iload_1
    //   318: iconst_1
    //   319: iadd
    //   320: istore_1
    //   321: goto -221 -> 100
    //   324: aload 9
    //   326: ldc 201
    //   328: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: pop
    //   332: invokestatic 207	android/content/res/Resources:getSystem	()Landroid/content/res/Resources;
    //   335: invokevirtual 76	java/lang/Object:getClass	()Ljava/lang/Class;
    //   338: invokevirtual 210	java/lang/Class:getName	()Ljava/lang/String;
    //   341: astore 6
    //   343: ldc 212
    //   345: aload 6
    //   347: invokestatic 176	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   350: ifne +11 -> 361
    //   353: aload 9
    //   355: aload 6
    //   357: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: pop
    //   361: aload 9
    //   363: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   366: ldc 217
    //   368: ldc 219
    //   370: invokevirtual 223	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   373: astore 6
    //   375: aload_0
    //   376: getfield 83	com/tencent/turingfd/sdk/xq/Cranberry:g	Lcom/tencent/turingfd/sdk/xq/Date;
    //   379: aload 8
    //   381: ldc 225
    //   383: aload 6
    //   385: iconst_1
    //   386: invokevirtual 230	com/tencent/turingfd/sdk/xq/Date:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)V
    //   389: aload_0
    //   390: getfield 90	com/tencent/turingfd/sdk/xq/Cranberry:d	Lcom/tencent/turingfd/sdk/xq/final;
    //   393: getfield 233	com/tencent/turingfd/sdk/xq/final:q	Z
    //   396: ifeq +227 -> 623
    //   399: aload_0
    //   400: getfield 83	com/tencent/turingfd/sdk/xq/Cranberry:g	Lcom/tencent/turingfd/sdk/xq/Date;
    //   403: astore 7
    //   405: getstatic 238	com/tencent/turingfd/sdk/xq/Marc:b	I
    //   408: istore_1
    //   409: getstatic 109	com/tencent/turingfd/sdk/xq/Filbert:a	Lcom/tencent/turingfd/sdk/xq/Filbert;
    //   412: bipush 45
    //   414: invokevirtual 112	com/tencent/turingfd/sdk/xq/Filbert:a	(I)Z
    //   417: ifne +6 -> 423
    //   420: goto +203 -> 623
    //   423: aload 7
    //   425: invokevirtual 76	java/lang/Object:getClass	()Ljava/lang/Class;
    //   428: pop
    //   429: aload 8
    //   431: ldc 240
    //   433: invokestatic 242	com/tencent/turingfd/sdk/xq/Date:b	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   436: invokestatic 248	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   439: invokevirtual 252	java/lang/Long:longValue	()J
    //   442: lstore 4
    //   444: goto +6 -> 450
    //   447: lconst_0
    //   448: lstore 4
    //   450: lload 4
    //   452: invokestatic 257	java/lang/System:currentTimeMillis	()J
    //   455: lsub
    //   456: invokestatic 262	java/lang/Math:abs	(J)J
    //   459: getstatic 264	com/tencent/turingfd/sdk/xq/Marc:a	J
    //   462: lcmp
    //   463: iflt +8 -> 471
    //   466: iconst_1
    //   467: istore_1
    //   468: goto +5 -> 473
    //   471: iconst_0
    //   472: istore_1
    //   473: iload_1
    //   474: ifne +6 -> 480
    //   477: goto +146 -> 623
    //   480: aload 8
    //   482: ldc_w 266
    //   485: invokestatic 242	com/tencent/turingfd/sdk/xq/Date:b	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   488: invokestatic 269	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   491: ifeq +8 -> 499
    //   494: iload_2
    //   495: istore_1
    //   496: goto +48 -> 544
    //   499: lload 4
    //   501: invokestatic 257	java/lang/System:currentTimeMillis	()J
    //   504: lsub
    //   505: invokestatic 262	java/lang/Math:abs	(J)J
    //   508: lstore 4
    //   510: getstatic 274	com/tencent/turingfd/sdk/xq/Fig:b	Lcom/tencent/turingfd/sdk/xq/Fig;
    //   513: invokevirtual 76	java/lang/Object:getClass	()Ljava/lang/Class;
    //   516: pop
    //   517: lload 4
    //   519: aload 8
    //   521: ldc_w 276
    //   524: getstatic 277	com/tencent/turingfd/sdk/xq/Fig:a	J
    //   527: ldc2_w 278
    //   530: invokestatic 282	com/tencent/turingfd/sdk/xq/Fig:a	(Landroid/content/Context;Ljava/lang/String;JJ)J
    //   533: lcmp
    //   534: iflt +8 -> 542
    //   537: iload_2
    //   538: istore_1
    //   539: goto +5 -> 544
    //   542: iconst_0
    //   543: istore_1
    //   544: iload_1
    //   545: ifeq +68 -> 613
    //   548: aload 8
    //   550: invokestatic 287	com/tencent/turingfd/sdk/xq/Nectarine:a	(Landroid/content/Context;)Lcom/tencent/turingfd/sdk/xq/Mango;
    //   553: astore 6
    //   555: aload 6
    //   557: getfield 291	com/tencent/turingfd/sdk/xq/Mango:a	I
    //   560: ifne +6 -> 566
    //   563: goto +8 -> 571
    //   566: invokestatic 294	com/tencent/turingfd/sdk/xq/Nectarine:a	()Lcom/tencent/turingfd/sdk/xq/Mango;
    //   569: astore 6
    //   571: aload 6
    //   573: getfield 291	com/tencent/turingfd/sdk/xq/Mango:a	I
    //   576: ifne +37 -> 613
    //   579: aload 6
    //   581: getfield 297	com/tencent/turingfd/sdk/xq/Mango:d	Ljava/lang/String;
    //   584: astore 6
    //   586: new 299	java/util/HashMap
    //   589: dup
    //   590: invokespecial 300	java/util/HashMap:<init>	()V
    //   593: astore 9
    //   595: aload 9
    //   597: ldc_w 266
    //   600: aload 6
    //   602: invokevirtual 304	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   605: pop
    //   606: aload 8
    //   608: aload 9
    //   610: invokestatic 307	com/tencent/turingfd/sdk/xq/Date:a	(Landroid/content/Context;Ljava/util/Map;)V
    //   613: aload 7
    //   615: aload 8
    //   617: invokestatic 257	java/lang/System:currentTimeMillis	()J
    //   620: invokevirtual 310	com/tencent/turingfd/sdk/xq/Date:b	(Landroid/content/Context;J)V
    //   623: aload_0
    //   624: getfield 90	com/tencent/turingfd/sdk/xq/Cranberry:d	Lcom/tencent/turingfd/sdk/xq/final;
    //   627: astore 6
    //   629: aload 6
    //   631: getfield 313	com/tencent/turingfd/sdk/xq/final:n	Z
    //   634: ifne +4 -> 638
    //   637: return
    //   638: aload_0
    //   639: aload 6
    //   641: getfield 315	com/tencent/turingfd/sdk/xq/final:b	Landroid/content/Context;
    //   644: iconst_0
    //   645: iconst_0
    //   646: invokevirtual 318	com/tencent/turingfd/sdk/xq/Cranberry:a	(Landroid/content/Context;ZI)Lcom/tencent/turingfd/sdk/xq/Chestnut;
    //   649: pop
    //   650: return
    //   651: astore_0
    //   652: ldc 78
    //   654: monitorexit
    //   655: goto +5 -> 660
    //   658: aload_0
    //   659: athrow
    //   660: goto -2 -> 658
    //   663: astore 6
    //   665: goto -630 -> 35
    //   668: astore 6
    //   670: goto -346 -> 324
    //   673: astore 7
    //   675: goto -500 -> 175
    //   678: astore 6
    //   680: goto -233 -> 447
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	683	0	paramCranberry	Cranberry
    //   99	446	1	k	int
    //   36	502	2	m	int
    //   97	6	3	n	int
    //   442	76	4	l	long
    //   114	526	6	localObject1	Object
    //   663	1	6	localInterruptedException	InterruptedException
    //   668	1	6	localObject2	Object
    //   678	1	6	localObject3	Object
    //   151	463	7	localObject4	Object
    //   673	1	7	localObject5	Object
    //   11	605	8	localContext	Context
    //   64	545	9	localObject6	Object
    //   83	23	10	arrayOfString	java.lang.String[]
    //   92	157	11	localHashSet	java.util.HashSet
    //   137	122	12	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   8	13	651	finally
    //   25	35	663	java/lang/InterruptedException
    //   66	98	668	finally
    //   105	123	668	finally
    //   126	139	668	finally
    //   183	193	668	finally
    //   196	206	668	finally
    //   209	219	668	finally
    //   222	232	668	finally
    //   235	245	668	finally
    //   248	265	668	finally
    //   270	290	668	finally
    //   293	309	668	finally
    //   309	317	668	finally
    //   142	161	673	finally
    //   164	171	673	finally
    //   429	444	678	finally
  }
  
  public final int a(Chestnut paramChestnut)
  {
    if (this.d.o) {
      return 2;
    }
    if (paramChestnut.d == 0)
    {
      if (TextUtils.isEmpty(paramChestnut.b)) {
        return 2;
      }
      long l2 = System.currentTimeMillis() / 1000L;
      if (l2 >= paramChestnut.c)
      {
        this.d.getClass();
        return 3;
      }
      paramChestnut = this.g;
      Context localContext;
      long l1;
      label101:
      try
      {
        localContext = const.a;
        paramChestnut.getClass();
        paramChestnut = Date.b(localContext, "107");
      }
      finally {}
    }
    try
    {
      l1 = Long.valueOf(paramChestnut).longValue();
    }
    finally
    {
      break label101;
    }
    l1 = 0L;
    paramChestnut = this.g;
    try
    {
      localContext = const.a;
      if (Math.abs(l2 - paramChestnut.a(localContext, "108")) >= l1)
      {
        this.d.getClass();
        return 3;
      }
      return 1;
    }
    finally {}
    return 2;
  }
  
  public final long a(Context paramContext, int paramInt, boolean paramBoolean)
  {
    long l3 = 0L;
    l1 = l3;
    if (paramBoolean) {
      l2 = l3;
    }
    try
    {
      l1 = System.currentTimeMillis();
      l2 = l3;
      a(paramContext, paramInt);
      l2 = l3;
      l1 = System.currentTimeMillis() - l1;
      l2 = l1;
      a(paramBoolean);
      l2 = l1;
      Filbert.a.a(paramContext);
    }
    finally
    {
      for (;;)
      {
        l1 = l2;
      }
    }
    return l1;
  }
  
  public final Chestnut a(Context paramContext)
  {
    label79:
    synchronized (this.i)
    {
      Chestnut localChestnut = (Chestnut)this.i.get();
      Object localObject = localChestnut;
      if (localChestnut == null)
      {
        localObject = this.g;
        if (localObject != null)
        {
          paramContext = ((Date)localObject).b(paramContext);
        }
        else
        {
          paramContext = Chestnut.a(1);
          break label79;
          this.i.set(paramContext);
          localObject = paramContext;
        }
      }
      else
      {
        return localObject;
      }
    }
  }
  
  public final Chestnut a(Context paramContext, boolean paramBoolean, int paramInt)
  {
    Chestnut localChestnut = a(paramContext);
    if (this.d == null) {
      return Chestnut.a(-10002);
    }
    int k = a(localChestnut);
    if (k == 1) {
      return localChestnut;
    }
    if (k == 2)
    {
      if (Looper.myLooper() == Looper.getMainLooper())
      {
        a();
        return Chestnut.a(-10008);
      }
      synchronized (this.h)
      {
        ??? = a(paramContext);
        if ((??? != localChestnut) && (a((Chestnut)???) == 1)) {
          paramContext = (Context)???;
        }
        synchronized (this.j)
        {
          if (!((Boolean)this.j.get()).booleanValue())
          {
            this.j.set(Boolean.TRUE);
            this.e.post(new Core(this, paramContext, false, paramInt));
          }
          try
          {
            localAtomicReference = this.j;
            if (!paramBoolean) {
              break label268;
            }
            l = this.d.r;
          }
          catch (InterruptedException localInterruptedException)
          {
            for (;;)
            {
              AtomicReference localAtomicReference;
              continue;
              long l = 10000L;
            }
          }
          localAtomicReference.wait(l);
          paramContext = a(paramContext);
          if (paramContext != localChestnut) {
            break label221;
          }
          paramContext = Chestnut.a(-10004);
          label221:
          if (paramContext.d == 0) {
            a(4, 3000L);
          }
          return paramContext;
        }
      }
    }
    else
    {
      if (k == 3) {
        a();
      }
      return localChestnut;
    }
  }
  
  public final Chestnut a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final Damson a(int paramInt, byte[] paramArrayOfByte)
  {
    catch localcatch = this.d.b();
    try
    {
      System.currentTimeMillis();
      paramArrayOfByte = ((interface)localcatch).a(paramInt, paramArrayOfByte, 0, 0);
      paramInt = paramArrayOfByte.a;
      if (paramInt != 0) {
        paramArrayOfByte = Damson.a(paramInt - 20000);
      } else {
        paramArrayOfByte = new Damson(0, paramArrayOfByte.b, 0, 0);
      }
    }
    finally
    {
      label63:
      break label63;
    }
    paramArrayOfByte = Damson.a(-20000);
    if (paramArrayOfByte.b != 0) {}
    return paramArrayOfByte;
  }
  
  public final void a()
  {
    a(3, 0L);
  }
  
  public final void a(int paramInt, long paramLong)
  {
    synchronized (this.j)
    {
      if (((Boolean)this.j.get()).booleanValue()) {
        return;
      }
      this.j.set(Boolean.TRUE);
      Message localMessage = Message.obtain(this.e, 2, Integer.valueOf(paramInt));
      this.e.sendMessageDelayed(localMessage, paramLong);
      return;
    }
  }
  
  public final void a(Context paramContext, int paramInt)
  {
    try
    {
      if (Filbert.a.a(paramContext, paramInt, this.d.a(), this.g.a(paramContext, "501"), a(paramContext).b))
      {
        Date localDate = this.g;
        localDate.getClass();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(System.currentTimeMillis());
        localDate.a(paramContext, "501", localStringBuilder.toString(), true);
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public final void a(Chestnut paramChestnut, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 61	com/tencent/turingfd/sdk/xq/Cranberry:i	Ljava/util/concurrent/atomic/AtomicReference;
    //   4: astore_3
    //   5: aload_3
    //   6: monitorenter
    //   7: aload_1
    //   8: ifnonnull +6 -> 14
    //   11: aload_3
    //   12: monitorexit
    //   13: return
    //   14: iload_2
    //   15: ifne +13 -> 28
    //   18: aload_1
    //   19: getfield 326	com/tencent/turingfd/sdk/xq/Chestnut:d	I
    //   22: ifeq +6 -> 28
    //   25: aload_3
    //   26: monitorexit
    //   27: return
    //   28: aload_0
    //   29: getfield 61	com/tencent/turingfd/sdk/xq/Cranberry:i	Ljava/util/concurrent/atomic/AtomicReference;
    //   32: aload_1
    //   33: invokevirtual 361	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
    //   36: aload_3
    //   37: monitorexit
    //   38: return
    //   39: aload_3
    //   40: monitorexit
    //   41: aload_1
    //   42: athrow
    //   43: astore_1
    //   44: goto -5 -> 39
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	Cranberry
    //   0	47	1	paramChestnut	Chestnut
    //   0	47	2	paramBoolean	boolean
    //   4	36	3	localAtomicReference	AtomicReference
    // Exception table:
    //   from	to	target	type
    //   11	13	43	finally
    //   18	27	43	finally
    //   28	38	43	finally
    //   39	41	43	finally
  }
  
  public final void a(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final Chestnut b(Context paramContext, boolean paramBoolean, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Cranberry
 * JD-Core Version:    0.7.0.1
 */