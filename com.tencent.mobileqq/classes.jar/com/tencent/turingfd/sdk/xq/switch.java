package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class switch
{
  public static switch Yb = new switch();
  public static long Zb = TimeUnit.MINUTES.toMillis(30L);
  public static int[] _b = { 0, 15, 30, 90, 240, 360, 600, 1200, 2400, 3200, 4800, 7200 };
  public case ac;
  public Handler bc;
  public boolean cc = false;
  public extends dc;
  public final Object ec = new Object();
  public final AtomicReference<public> fc = new AtomicReference(null);
  public final AtomicReference<Boolean> gc = new AtomicReference(Boolean.valueOf(false));
  public public hc;
  
  public final int a(public parampublic)
  {
    int j = 3;
    int i;
    if ((parampublic.Rb != 0) || (TextUtils.isEmpty(parampublic.Pb))) {
      i = 2;
    }
    long l1;
    long l2;
    do
    {
      do
      {
        return i;
        l1 = System.currentTimeMillis() / 1000L;
        i = j;
      } while (l1 >= parampublic.Qb);
      l2 = this.dc.r(for.get());
      i = j;
    } while (Math.abs(l1 - this.dc.b(for.get(), "108")) >= l2);
    return 1;
  }
  
  /* Error */
  public final public a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 154
    //   3: invokevirtual 160	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   6: checkcast 162	android/net/ConnectivityManager
    //   9: astore 12
    //   11: aload 12
    //   13: ifnonnull +18 -> 31
    //   16: iconst_0
    //   17: istore 5
    //   19: iload 5
    //   21: ifne +95 -> 116
    //   24: sipush -10012
    //   27: invokestatic 166	com/tencent/turingfd/sdk/xq/public:c	(I)Lcom/tencent/turingfd/sdk/xq/public;
    //   30: areturn
    //   31: aload 12
    //   33: invokevirtual 170	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   36: astore 12
    //   38: aload 12
    //   40: ifnull +21 -> 61
    //   43: aload 12
    //   45: invokevirtual 176	android/net/NetworkInfo:isConnected	()Z
    //   48: istore 4
    //   50: iload 4
    //   52: ifeq +9 -> 61
    //   55: iconst_1
    //   56: istore 5
    //   58: goto -39 -> 19
    //   61: iconst_0
    //   62: istore 5
    //   64: goto -45 -> 19
    //   67: astore 12
    //   69: invokestatic 182	com/tencent/turingfd/sdk/xq/private:getInstance	()Lcom/tencent/turingfd/sdk/xq/private;
    //   72: aload 12
    //   74: invokevirtual 185	com/tencent/turingfd/sdk/xq/private:b	(Ljava/lang/Throwable;)V
    //   77: aload 12
    //   79: invokevirtual 189	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   82: astore 12
    //   84: iconst_0
    //   85: istore 6
    //   87: iload 6
    //   89: istore 5
    //   91: aload 12
    //   93: ifnull -74 -> 19
    //   96: iload 6
    //   98: istore 5
    //   100: aload 12
    //   102: ldc 191
    //   104: invokevirtual 196	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   107: ifeq -88 -> 19
    //   110: iconst_1
    //   111: istore 5
    //   113: goto -94 -> 19
    //   116: invokestatic 130	com/tencent/turingfd/sdk/xq/for:get	()Landroid/content/Context;
    //   119: astore 12
    //   121: invokestatic 117	java/lang/System:currentTimeMillis	()J
    //   124: ldc2_w 118
    //   127: ldiv
    //   128: aload_0
    //   129: getfield 124	com/tencent/turingfd/sdk/xq/switch:dc	Lcom/tencent/turingfd/sdk/xq/extends;
    //   132: aload 12
    //   134: invokevirtual 199	com/tencent/turingfd/sdk/xq/extends:v	(Landroid/content/Context;)J
    //   137: ldc2_w 118
    //   140: ldiv
    //   141: lsub
    //   142: invokestatic 146	java/lang/Math:abs	(J)J
    //   145: ldc2_w 200
    //   148: lcmp
    //   149: ifgt +26 -> 175
    //   152: iconst_0
    //   153: istore 5
    //   155: iload 5
    //   157: ifne +24 -> 181
    //   160: iconst_0
    //   161: istore 5
    //   163: iload 5
    //   165: ifne +260 -> 425
    //   168: sipush -10011
    //   171: invokestatic 166	com/tencent/turingfd/sdk/xq/public:c	(I)Lcom/tencent/turingfd/sdk/xq/public;
    //   174: areturn
    //   175: iconst_1
    //   176: istore 5
    //   178: goto -23 -> 155
    //   181: aload_0
    //   182: getfield 124	com/tencent/turingfd/sdk/xq/switch:dc	Lcom/tencent/turingfd/sdk/xq/extends;
    //   185: invokestatic 130	com/tencent/turingfd/sdk/xq/for:get	()Landroid/content/Context;
    //   188: bipush 6
    //   190: invokevirtual 204	com/tencent/turingfd/sdk/xq/extends:a	(Landroid/content/Context;I)Lcom/tencent/turingfd/sdk/xq/while;
    //   193: astore 12
    //   195: aload 12
    //   197: invokevirtual 210	com/tencent/turingfd/sdk/xq/while:size	()I
    //   200: ifne +9 -> 209
    //   203: iconst_1
    //   204: istore 5
    //   206: goto -43 -> 163
    //   209: aload_0
    //   210: getfield 124	com/tencent/turingfd/sdk/xq/switch:dc	Lcom/tencent/turingfd/sdk/xq/extends;
    //   213: invokestatic 130	com/tencent/turingfd/sdk/xq/for:get	()Landroid/content/Context;
    //   216: invokevirtual 213	com/tencent/turingfd/sdk/xq/extends:p	(Landroid/content/Context;)J
    //   219: lstore 8
    //   221: lload 8
    //   223: lconst_0
    //   224: lcmp
    //   225: ifgt +18 -> 243
    //   228: iconst_1
    //   229: istore 5
    //   231: iload 5
    //   233: ifne +144 -> 377
    //   236: iload_3
    //   237: ifeq -77 -> 160
    //   240: goto -37 -> 203
    //   243: aload 12
    //   245: getfield 217	com/tencent/turingfd/sdk/xq/while:Kb	Ljava/util/LinkedList;
    //   248: invokevirtual 223	java/util/LinkedList:getLast	()Ljava/lang/Object;
    //   251: checkcast 225	java/lang/Long
    //   254: invokevirtual 228	java/lang/Long:longValue	()J
    //   257: lstore 10
    //   259: invokestatic 117	java/lang/System:currentTimeMillis	()J
    //   262: lload 10
    //   264: lsub
    //   265: invokestatic 146	java/lang/Math:abs	(J)J
    //   268: lstore 10
    //   270: getstatic 50	com/tencent/turingfd/sdk/xq/switch:_b	[I
    //   273: astore 13
    //   275: lload 8
    //   277: aload 13
    //   279: arraylength
    //   280: i2l
    //   281: lcmp
    //   282: ifge +85 -> 367
    //   285: lload 8
    //   287: l2i
    //   288: istore 5
    //   290: iload 5
    //   292: iconst_1
    //   293: if_icmplt -65 -> 228
    //   296: getstatic 50	com/tencent/turingfd/sdk/xq/switch:_b	[I
    //   299: astore 13
    //   301: aload 13
    //   303: iload 5
    //   305: iconst_1
    //   306: isub
    //   307: iaload
    //   308: istore 6
    //   310: aload 13
    //   312: iload 5
    //   314: iaload
    //   315: istore 5
    //   317: iload 6
    //   319: iload 5
    //   321: if_icmpge +4690 -> 5011
    //   324: new 230	java/util/Random
    //   327: dup
    //   328: invokespecial 231	java/util/Random:<init>	()V
    //   331: iload 5
    //   333: iload 6
    //   335: isub
    //   336: iconst_1
    //   337: iadd
    //   338: invokevirtual 235	java/util/Random:nextInt	(I)I
    //   341: istore 5
    //   343: lload 10
    //   345: getstatic 238	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   348: iload 5
    //   350: iload 6
    //   352: iadd
    //   353: i2l
    //   354: invokevirtual 46	java/util/concurrent/TimeUnit:toMillis	(J)J
    //   357: lcmp
    //   358: ifgt -130 -> 228
    //   361: iconst_0
    //   362: istore 5
    //   364: goto -133 -> 231
    //   367: aload 13
    //   369: arraylength
    //   370: iconst_1
    //   371: isub
    //   372: istore 5
    //   374: goto -84 -> 290
    //   377: aload 12
    //   379: getfield 217	com/tencent/turingfd/sdk/xq/while:Kb	Ljava/util/LinkedList;
    //   382: invokevirtual 241	java/util/LinkedList:getFirst	()Ljava/lang/Object;
    //   385: checkcast 225	java/lang/Long
    //   388: astore 13
    //   390: aload 12
    //   392: invokevirtual 210	com/tencent/turingfd/sdk/xq/while:size	()I
    //   395: aload 12
    //   397: getfield 244	com/tencent/turingfd/sdk/xq/while:limit	I
    //   400: if_icmplt -197 -> 203
    //   403: invokestatic 117	java/lang/System:currentTimeMillis	()J
    //   406: aload 13
    //   408: invokevirtual 228	java/lang/Long:longValue	()J
    //   411: lsub
    //   412: invokestatic 146	java/lang/Math:abs	(J)J
    //   415: getstatic 48	com/tencent/turingfd/sdk/xq/switch:Zb	J
    //   418: lcmp
    //   419: iflt -259 -> 160
    //   422: goto -219 -> 203
    //   425: aload_0
    //   426: getfield 124	com/tencent/turingfd/sdk/xq/switch:dc	Lcom/tencent/turingfd/sdk/xq/extends;
    //   429: invokestatic 130	com/tencent/turingfd/sdk/xq/for:get	()Landroid/content/Context;
    //   432: bipush 6
    //   434: invokevirtual 204	com/tencent/turingfd/sdk/xq/extends:a	(Landroid/content/Context;I)Lcom/tencent/turingfd/sdk/xq/while;
    //   437: astore 12
    //   439: aload 12
    //   441: invokestatic 117	java/lang/System:currentTimeMillis	()J
    //   444: invokestatic 247	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   447: invokevirtual 250	com/tencent/turingfd/sdk/xq/while:offer	(Ljava/lang/Object;)V
    //   450: aload_0
    //   451: getfield 124	com/tencent/turingfd/sdk/xq/switch:dc	Lcom/tencent/turingfd/sdk/xq/extends;
    //   454: invokestatic 130	com/tencent/turingfd/sdk/xq/for:get	()Landroid/content/Context;
    //   457: aload 12
    //   459: invokevirtual 253	com/tencent/turingfd/sdk/xq/extends:a	(Landroid/content/Context;Lcom/tencent/turingfd/sdk/xq/while;)V
    //   462: aload_1
    //   463: invokestatic 257	com/tencent/turingfd/sdk/xq/for:e	(Landroid/content/Context;)Ljava/lang/String;
    //   466: astore 12
    //   468: aload 12
    //   470: invokestatic 111	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   473: ifne +13 -> 486
    //   476: aload_0
    //   477: getfield 124	com/tencent/turingfd/sdk/xq/switch:dc	Lcom/tencent/turingfd/sdk/xq/extends;
    //   480: aload_1
    //   481: aload 12
    //   483: invokevirtual 261	com/tencent/turingfd/sdk/xq/extends:d	(Landroid/content/Context;Ljava/lang/String;)V
    //   486: invokestatic 117	java/lang/System:currentTimeMillis	()J
    //   489: lstore 8
    //   491: aload_1
    //   492: invokestatic 264	com/tencent/turingfd/sdk/xq/for:d	(Landroid/content/Context;)I
    //   495: bipush 10
    //   497: if_icmplt +47 -> 544
    //   500: iconst_1
    //   501: istore 5
    //   503: iload 5
    //   505: ifeq +45 -> 550
    //   508: sipush -10005
    //   511: invokestatic 269	com/tencent/turingfd/sdk/xq/throws:c	(I)Lcom/tencent/turingfd/sdk/xq/throws;
    //   514: astore 12
    //   516: aload 12
    //   518: invokevirtual 272	com/tencent/turingfd/sdk/xq/throws:getErrorCode	()I
    //   521: ifeq +3834 -> 4355
    //   524: aload 12
    //   526: invokevirtual 272	com/tencent/turingfd/sdk/xq/throws:getErrorCode	()I
    //   529: invokestatic 166	com/tencent/turingfd/sdk/xq/public:c	(I)Lcom/tencent/turingfd/sdk/xq/public;
    //   532: astore 12
    //   534: aload_0
    //   535: aload_1
    //   536: aload 12
    //   538: invokevirtual 275	com/tencent/turingfd/sdk/xq/switch:a	(Landroid/content/Context;Lcom/tencent/turingfd/sdk/xq/public;)V
    //   541: aload 12
    //   543: areturn
    //   544: iconst_0
    //   545: istore 5
    //   547: goto -44 -> 503
    //   550: new 277	java/util/HashMap
    //   553: dup
    //   554: invokespecial 278	java/util/HashMap:<init>	()V
    //   557: astore 15
    //   559: getstatic 284	com/tencent/turingfd/sdk/xq/volatile:rc	Lcom/tencent/turingfd/sdk/xq/interface;
    //   562: astore 12
    //   564: aload 12
    //   566: ifnull +199 -> 765
    //   569: aload 12
    //   571: getfield 287	com/tencent/turingfd/sdk/xq/interface:Rb	I
    //   574: ifeq +191 -> 765
    //   577: aload 15
    //   579: ldc_w 289
    //   582: aload 12
    //   584: getfield 292	com/tencent/turingfd/sdk/xq/interface:tc	Ljava/lang/String;
    //   587: invokevirtual 296	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   590: pop
    //   591: aload 15
    //   593: ldc_w 298
    //   596: aload_0
    //   597: getfield 75	com/tencent/turingfd/sdk/xq/switch:ac	Lcom/tencent/turingfd/sdk/xq/case;
    //   600: invokevirtual 302	com/tencent/turingfd/sdk/xq/case:e	()Ljava/lang/String;
    //   603: invokevirtual 296	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   606: pop
    //   607: aload 15
    //   609: ldc_w 304
    //   612: aload_1
    //   613: invokestatic 309	com/tencent/turingfd/sdk/xq/class:h	(Landroid/content/Context;)Ljava/lang/String;
    //   616: invokevirtual 296	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   619: pop
    //   620: aload 15
    //   622: ldc_w 311
    //   625: aload_0
    //   626: getfield 124	com/tencent/turingfd/sdk/xq/switch:dc	Lcom/tencent/turingfd/sdk/xq/extends;
    //   629: aload_1
    //   630: invokevirtual 314	com/tencent/turingfd/sdk/xq/extends:w	(Landroid/content/Context;)Lcom/tencent/turingfd/sdk/xq/public;
    //   633: getfield 105	com/tencent/turingfd/sdk/xq/public:Pb	Ljava/lang/String;
    //   636: invokevirtual 296	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   639: pop
    //   640: aload 15
    //   642: ldc_w 316
    //   645: aload_0
    //   646: getfield 75	com/tencent/turingfd/sdk/xq/switch:ac	Lcom/tencent/turingfd/sdk/xq/case;
    //   649: invokevirtual 319	com/tencent/turingfd/sdk/xq/case:getUserId	()Ljava/lang/String;
    //   652: invokevirtual 296	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   655: pop
    //   656: aload 15
    //   658: ldc_w 321
    //   661: aload_1
    //   662: iload_2
    //   663: iconst_1
    //   664: invokestatic 326	com/tencent/turingfd/sdk/xq/abstract:a	(Landroid/content/Context;ZI)Ljava/lang/String;
    //   667: invokevirtual 296	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   670: pop
    //   671: new 328	java/util/HashSet
    //   674: dup
    //   675: invokespecial 329	java/util/HashSet:<init>	()V
    //   678: astore 12
    //   680: new 193	java/lang/String
    //   683: dup
    //   684: getstatic 334	com/tencent/turingfd/sdk/xq/else:ba	[I
    //   687: invokestatic 337	com/tencent/turingfd/sdk/xq/else:get	([I)Ljava/lang/String;
    //   690: invokestatic 340	com/tencent/turingfd/sdk/xq/for:b	(Ljava/lang/String;)[B
    //   693: invokespecial 343	java/lang/String:<init>	([B)V
    //   696: astore 13
    //   698: aload 13
    //   700: ldc_w 345
    //   703: invokevirtual 349	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   706: astore 13
    //   708: aload_1
    //   709: invokevirtual 352	android/content/Context:getPackageName	()Ljava/lang/String;
    //   712: astore 14
    //   714: aload 13
    //   716: arraylength
    //   717: istore 6
    //   719: iconst_0
    //   720: istore 5
    //   722: iload 5
    //   724: iload 6
    //   726: if_icmpge +155 -> 881
    //   729: aload 13
    //   731: iload 5
    //   733: aaload
    //   734: aload 14
    //   736: invokestatic 355	com/tencent/turingfd/sdk/xq/for:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   739: astore 16
    //   741: aload 16
    //   743: ifnull +13 -> 756
    //   746: aload 12
    //   748: aload 16
    //   750: invokeinterface 361 2 0
    //   755: pop
    //   756: iload 5
    //   758: iconst_1
    //   759: iadd
    //   760: istore 5
    //   762: goto -40 -> 722
    //   765: getstatic 365	com/tencent/turingfd/sdk/xq/volatile:qc	Ljava/util/Map;
    //   768: getstatic 368	com/tencent/turingfd/sdk/xq/volatile:sc	Ljava/lang/String;
    //   771: invokeinterface 373 2 0
    //   776: ifne +13 -> 789
    //   779: bipush 246
    //   781: invokestatic 376	com/tencent/turingfd/sdk/xq/interface:c	(I)Lcom/tencent/turingfd/sdk/xq/interface;
    //   784: astore 12
    //   786: goto -209 -> 577
    //   789: ldc_w 378
    //   792: invokestatic 384	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   795: invokevirtual 387	java/lang/Thread:getName	()Ljava/lang/String;
    //   798: invokevirtual 390	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   801: ifeq +13 -> 814
    //   804: bipush 245
    //   806: invokestatic 376	com/tencent/turingfd/sdk/xq/interface:c	(I)Lcom/tencent/turingfd/sdk/xq/interface;
    //   809: astore 12
    //   811: goto -234 -> 577
    //   814: getstatic 365	com/tencent/turingfd/sdk/xq/volatile:qc	Ljava/util/Map;
    //   817: getstatic 368	com/tencent/turingfd/sdk/xq/volatile:sc	Ljava/lang/String;
    //   820: invokeinterface 393 2 0
    //   825: checkcast 395	com/tencent/turingfd/sdk/xq/volatile$do
    //   828: astore 12
    //   830: aload 12
    //   832: ifnull +39 -> 871
    //   835: aload 12
    //   837: getfield 398	com/tencent/turingfd/sdk/xq/volatile$do:pc	I
    //   840: istore 5
    //   842: iload 5
    //   844: iconst_3
    //   845: if_icmpgt +26 -> 871
    //   848: aload 12
    //   850: iload 5
    //   852: iconst_1
    //   853: iadd
    //   854: putfield 398	com/tencent/turingfd/sdk/xq/volatile$do:pc	I
    //   857: aload 12
    //   859: invokestatic 401	com/tencent/turingfd/sdk/xq/volatile$do:a	(Lcom/tencent/turingfd/sdk/xq/volatile$do;)Lcom/tencent/turingfd/sdk/xq/continue;
    //   862: aload_1
    //   863: invokeinterface 406 2 0
    //   868: putstatic 284	com/tencent/turingfd/sdk/xq/volatile:rc	Lcom/tencent/turingfd/sdk/xq/interface;
    //   871: getstatic 284	com/tencent/turingfd/sdk/xq/volatile:rc	Lcom/tencent/turingfd/sdk/xq/interface;
    //   874: astore 12
    //   876: goto -299 -> 577
    //   879: astore 13
    //   881: aload 12
    //   883: invokestatic 411	com/tencent/turingfd/sdk/xq/short:b	(Ljava/util/Set;)Ljava/util/Set;
    //   886: astore 13
    //   888: aload 13
    //   890: invokeinterface 412 1 0
    //   895: ifle +960 -> 1855
    //   898: new 414	java/lang/StringBuilder
    //   901: dup
    //   902: invokespecial 415	java/lang/StringBuilder:<init>	()V
    //   905: astore 12
    //   907: new 417	java/util/ArrayList
    //   910: dup
    //   911: invokespecial 418	java/util/ArrayList:<init>	()V
    //   914: astore 14
    //   916: aload 14
    //   918: aload 13
    //   920: invokevirtual 422	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   923: pop
    //   924: aload 14
    //   926: invokevirtual 426	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   929: astore 13
    //   931: iconst_0
    //   932: istore 5
    //   934: aload 13
    //   936: invokeinterface 431 1 0
    //   941: ifeq +32 -> 973
    //   944: iload 5
    //   946: iconst_1
    //   947: iadd
    //   948: istore 5
    //   950: aload 12
    //   952: aload 13
    //   954: invokeinterface 434 1 0
    //   959: checkcast 193	java/lang/String
    //   962: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   965: pop
    //   966: iload 5
    //   968: bipush 8
    //   970: if_icmplt +863 -> 1833
    //   973: aload 12
    //   975: invokevirtual 441	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   978: astore 12
    //   980: aload 12
    //   982: astore 13
    //   984: aload 12
    //   986: ifnonnull +8 -> 994
    //   989: ldc_w 443
    //   992: astore 13
    //   994: aload 15
    //   996: ldc_w 445
    //   999: aload 13
    //   1001: invokevirtual 296	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1004: pop
    //   1005: aload_1
    //   1006: invokevirtual 449	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1009: astore 13
    //   1011: aload 13
    //   1013: ifnonnull +850 -> 1863
    //   1016: iconst_0
    //   1017: istore_3
    //   1018: iconst_0
    //   1019: iload_3
    //   1020: iconst_0
    //   1021: invokestatic 452	com/tencent/turingfd/sdk/xq/for:a	(IZI)I
    //   1024: istore 6
    //   1026: new 193	java/lang/String
    //   1029: dup
    //   1030: getstatic 334	com/tencent/turingfd/sdk/xq/else:ba	[I
    //   1033: invokestatic 337	com/tencent/turingfd/sdk/xq/else:get	([I)Ljava/lang/String;
    //   1036: invokestatic 340	com/tencent/turingfd/sdk/xq/for:b	(Ljava/lang/String;)[B
    //   1039: invokespecial 343	java/lang/String:<init>	([B)V
    //   1042: astore 12
    //   1044: aload 12
    //   1046: invokestatic 111	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1049: istore_3
    //   1050: iload_3
    //   1051: ifeq +896 -> 1947
    //   1054: iconst_0
    //   1055: istore_3
    //   1056: iload 6
    //   1058: iload_3
    //   1059: iconst_1
    //   1060: invokestatic 452	com/tencent/turingfd/sdk/xq/for:a	(IZI)I
    //   1063: ifle +955 -> 2018
    //   1066: ldc_w 454
    //   1069: astore 12
    //   1071: aload 15
    //   1073: ldc_w 456
    //   1076: aload 12
    //   1078: invokevirtual 296	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1081: pop
    //   1082: aload_1
    //   1083: invokevirtual 460	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   1086: astore 12
    //   1088: aload 12
    //   1090: ldc_w 462
    //   1093: iconst_0
    //   1094: invokestatic 468	android/provider/Settings$Secure:getInt	(Landroid/content/ContentResolver;Ljava/lang/String;I)I
    //   1097: istore 5
    //   1099: iload 5
    //   1101: ifeq +927 -> 2028
    //   1104: iconst_1
    //   1105: istore 5
    //   1107: iload 5
    //   1109: ifeq +925 -> 2034
    //   1112: ldc_w 454
    //   1115: astore 12
    //   1117: aload 15
    //   1119: ldc_w 470
    //   1122: aload 12
    //   1124: invokevirtual 296	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1127: pop
    //   1128: new 414	java/lang/StringBuilder
    //   1131: dup
    //   1132: invokespecial 415	java/lang/StringBuilder:<init>	()V
    //   1135: ldc_w 443
    //   1138: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1141: astore 16
    //   1143: getstatic 475	android/os/Build$VERSION:SDK_INT	I
    //   1146: bipush 24
    //   1148: if_icmplt +894 -> 2042
    //   1151: iconst_0
    //   1152: istore 5
    //   1154: aload 15
    //   1156: ldc_w 477
    //   1159: aload 16
    //   1161: iload 5
    //   1163: invokevirtual 480	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1166: invokevirtual 441	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1169: invokevirtual 296	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1172: pop
    //   1173: new 414	java/lang/StringBuilder
    //   1176: dup
    //   1177: invokespecial 415	java/lang/StringBuilder:<init>	()V
    //   1180: ldc_w 443
    //   1183: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1186: astore 13
    //   1188: new 482	android/content/IntentFilter
    //   1191: dup
    //   1192: ldc_w 484
    //   1195: invokespecial 487	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   1198: astore 12
    //   1200: aload_1
    //   1201: aconst_null
    //   1202: aload 12
    //   1204: invokevirtual 491	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   1207: astore 12
    //   1209: aload 12
    //   1211: ifnonnull +1033 -> 2244
    //   1214: iconst_0
    //   1215: istore 5
    //   1217: aload 15
    //   1219: ldc_w 493
    //   1222: aload 13
    //   1224: iload 5
    //   1226: invokevirtual 480	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1229: invokevirtual 441	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1232: invokevirtual 296	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1235: pop
    //   1236: new 414	java/lang/StringBuilder
    //   1239: dup
    //   1240: invokespecial 415	java/lang/StringBuilder:<init>	()V
    //   1243: ldc_w 443
    //   1246: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1249: astore 12
    //   1251: aload_1
    //   1252: aconst_null
    //   1253: new 482	android/content/IntentFilter
    //   1256: dup
    //   1257: ldc_w 484
    //   1260: invokespecial 487	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   1263: invokevirtual 491	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   1266: astore 13
    //   1268: aload 13
    //   1270: ifnonnull +1052 -> 2322
    //   1273: getstatic 498	com/tencent/turingfd/sdk/xq/catch:sb	I
    //   1276: istore 5
    //   1278: aload 15
    //   1280: ldc_w 500
    //   1283: aload 12
    //   1285: iload 5
    //   1287: invokevirtual 480	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1290: invokevirtual 441	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1293: invokevirtual 296	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1296: pop
    //   1297: getstatic 506	com/tencent/turingfd/sdk/xq/const:Cb	Ljava/util/List;
    //   1300: astore 12
    //   1302: aload 12
    //   1304: ifnull +1136 -> 2440
    //   1307: aload 12
    //   1309: invokeinterface 509 1 0
    //   1314: astore 12
    //   1316: aload 12
    //   1318: invokeinterface 431 1 0
    //   1323: ifeq +2868 -> 4191
    //   1326: aload 12
    //   1328: invokeinterface 434 1 0
    //   1333: checkcast 511	com/tencent/turingfd/sdk/xq/import
    //   1336: astore 13
    //   1338: aload 13
    //   1340: getfield 514	com/tencent/turingfd/sdk/xq/import:Nb	Ljava/lang/String;
    //   1343: getstatic 519	com/tencent/turingfd/sdk/xq/void:nb	Ljava/lang/String;
    //   1346: invokevirtual 196	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1349: ifeq -33 -> 1316
    //   1352: aload 13
    //   1354: getfield 522	com/tencent/turingfd/sdk/xq/import:Ob	Ljava/lang/String;
    //   1357: astore 12
    //   1359: aload 12
    //   1361: astore 13
    //   1363: aload 12
    //   1365: ifnonnull +8 -> 1373
    //   1368: ldc_w 443
    //   1371: astore 13
    //   1373: aload 15
    //   1375: ldc_w 524
    //   1378: aload 13
    //   1380: invokevirtual 296	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1383: pop
    //   1384: aload_1
    //   1385: invokestatic 530	com/tencent/turingfd/sdk/xq/final:i	(Landroid/content/Context;)Ljava/util/ArrayList;
    //   1388: astore 12
    //   1390: aload 12
    //   1392: invokeinterface 531 1 0
    //   1397: ifeq +2802 -> 4199
    //   1400: aload 12
    //   1402: iconst_0
    //   1403: invokeinterface 534 2 0
    //   1408: checkcast 511	com/tencent/turingfd/sdk/xq/import
    //   1411: getfield 522	com/tencent/turingfd/sdk/xq/import:Ob	Ljava/lang/String;
    //   1414: astore 12
    //   1416: aload 12
    //   1418: astore 13
    //   1420: aload 12
    //   1422: ifnonnull +8 -> 1430
    //   1425: ldc_w 443
    //   1428: astore 13
    //   1430: aload 15
    //   1432: ldc_w 536
    //   1435: aload 13
    //   1437: invokevirtual 296	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1440: pop
    //   1441: aload 15
    //   1443: ldc_w 538
    //   1446: new 414	java/lang/StringBuilder
    //   1449: dup
    //   1450: invokespecial 415	java/lang/StringBuilder:<init>	()V
    //   1453: ldc_w 443
    //   1456: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1459: aload_0
    //   1460: getfield 75	com/tencent/turingfd/sdk/xq/switch:ac	Lcom/tencent/turingfd/sdk/xq/case;
    //   1463: invokevirtual 541	com/tencent/turingfd/sdk/xq/case:f	()I
    //   1466: invokevirtual 480	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1469: invokevirtual 441	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1472: invokevirtual 296	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1475: pop
    //   1476: aload 15
    //   1478: ldc_w 543
    //   1481: aload_0
    //   1482: getfield 75	com/tencent/turingfd/sdk/xq/switch:ac	Lcom/tencent/turingfd/sdk/xq/case;
    //   1485: invokevirtual 546	com/tencent/turingfd/sdk/xq/case:g	()Ljava/lang/String;
    //   1488: invokevirtual 296	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1491: pop
    //   1492: aload 15
    //   1494: ldc_w 548
    //   1497: aload_0
    //   1498: getfield 75	com/tencent/turingfd/sdk/xq/switch:ac	Lcom/tencent/turingfd/sdk/xq/case;
    //   1501: invokevirtual 550	com/tencent/turingfd/sdk/xq/case:i	()Ljava/lang/String;
    //   1504: invokevirtual 296	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1507: pop
    //   1508: aload 15
    //   1510: ldc_w 552
    //   1513: aload_0
    //   1514: getfield 75	com/tencent/turingfd/sdk/xq/switch:ac	Lcom/tencent/turingfd/sdk/xq/case;
    //   1517: invokevirtual 554	com/tencent/turingfd/sdk/xq/case:h	()Ljava/lang/String;
    //   1520: invokevirtual 296	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1523: pop
    //   1524: aload 15
    //   1526: ldc_w 556
    //   1529: aload_0
    //   1530: getfield 124	com/tencent/turingfd/sdk/xq/switch:dc	Lcom/tencent/turingfd/sdk/xq/extends;
    //   1533: aload_1
    //   1534: invokevirtual 559	com/tencent/turingfd/sdk/xq/extends:n	(Landroid/content/Context;)Ljava/lang/String;
    //   1537: invokevirtual 296	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1540: pop
    //   1541: aload 15
    //   1543: ldc_w 561
    //   1546: aload_0
    //   1547: getfield 124	com/tencent/turingfd/sdk/xq/switch:dc	Lcom/tencent/turingfd/sdk/xq/extends;
    //   1550: aload_1
    //   1551: invokevirtual 564	com/tencent/turingfd/sdk/xq/extends:u	(Landroid/content/Context;)Ljava/lang/String;
    //   1554: invokevirtual 296	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1557: pop
    //   1558: aload 15
    //   1560: ldc_w 566
    //   1563: aload_0
    //   1564: getfield 124	com/tencent/turingfd/sdk/xq/switch:dc	Lcom/tencent/turingfd/sdk/xq/extends;
    //   1567: aload_1
    //   1568: invokevirtual 569	com/tencent/turingfd/sdk/xq/extends:o	(Landroid/content/Context;)Ljava/lang/String;
    //   1571: invokevirtual 296	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1574: pop
    //   1575: aload 15
    //   1577: ldc_w 571
    //   1580: invokestatic 573	com/tencent/turingfd/sdk/xq/class:p	()Ljava/lang/String;
    //   1583: invokevirtual 296	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1586: pop
    //   1587: new 414	java/lang/StringBuilder
    //   1590: dup
    //   1591: invokespecial 415	java/lang/StringBuilder:<init>	()V
    //   1594: ldc_w 443
    //   1597: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1600: astore 12
    //   1602: aload_1
    //   1603: ldc 154
    //   1605: invokevirtual 160	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   1608: checkcast 162	android/net/ConnectivityManager
    //   1611: invokevirtual 170	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   1614: astore 13
    //   1616: aload 13
    //   1618: ifnull +33 -> 1651
    //   1621: aload 13
    //   1623: invokevirtual 577	android/net/NetworkInfo:getState	()Landroid/net/NetworkInfo$State;
    //   1626: getstatic 583	android/net/NetworkInfo$State:CONNECTING	Landroid/net/NetworkInfo$State;
    //   1629: if_acmpeq +2578 -> 4207
    //   1632: aload 13
    //   1634: invokevirtual 577	android/net/NetworkInfo:getState	()Landroid/net/NetworkInfo$State;
    //   1637: astore 14
    //   1639: getstatic 586	android/net/NetworkInfo$State:CONNECTED	Landroid/net/NetworkInfo$State;
    //   1642: astore 16
    //   1644: aload 14
    //   1646: aload 16
    //   1648: if_acmpeq +2559 -> 4207
    //   1651: iconst_m1
    //   1652: istore 5
    //   1654: aload 15
    //   1656: ldc_w 588
    //   1659: aload 12
    //   1661: iload 5
    //   1663: invokevirtual 480	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1666: invokevirtual 441	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1669: invokevirtual 296	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1672: pop
    //   1673: aload 15
    //   1675: ldc_w 590
    //   1678: aload_0
    //   1679: getfield 124	com/tencent/turingfd/sdk/xq/switch:dc	Lcom/tencent/turingfd/sdk/xq/extends;
    //   1682: aload_1
    //   1683: invokevirtual 593	com/tencent/turingfd/sdk/xq/extends:t	(Landroid/content/Context;)Ljava/lang/String;
    //   1686: invokevirtual 296	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1689: pop
    //   1690: iload_2
    //   1691: ifeq +15 -> 1706
    //   1694: aload 15
    //   1696: ldc_w 595
    //   1699: ldc_w 454
    //   1702: invokevirtual 296	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1705: pop
    //   1706: aload_1
    //   1707: ldc_w 597
    //   1710: aload_1
    //   1711: ldc_w 599
    //   1714: iconst_0
    //   1715: invokevirtual 603	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   1718: ldc_w 597
    //   1721: iconst_0
    //   1722: invokeinterface 608 3 0
    //   1727: invokestatic 611	com/tencent/turingfd/sdk/xq/for:a	(Landroid/content/Context;Ljava/lang/String;I)V
    //   1730: invokestatic 614	com/tencent/turingfd/sdk/xq/for:a	()Landroid/util/SparseArray;
    //   1733: aload_1
    //   1734: aload 15
    //   1736: iconst_1
    //   1737: invokestatic 619	com/tencent/turingfd/sdk/xq/TuringDIDService$aa:a	(Landroid/util/SparseArray;Landroid/content/Context;Ljava/util/Map;I)Landroid/util/SparseArray;
    //   1740: astore 12
    //   1742: aload_1
    //   1743: ldc_w 597
    //   1746: iconst_0
    //   1747: invokestatic 611	com/tencent/turingfd/sdk/xq/for:a	(Landroid/content/Context;Ljava/lang/String;I)V
    //   1750: aload_0
    //   1751: getfield 124	com/tencent/turingfd/sdk/xq/switch:dc	Lcom/tencent/turingfd/sdk/xq/extends;
    //   1754: aload_1
    //   1755: invokestatic 117	java/lang/System:currentTimeMillis	()J
    //   1758: lload 8
    //   1760: lsub
    //   1761: invokevirtual 622	com/tencent/turingfd/sdk/xq/extends:b	(Landroid/content/Context;J)V
    //   1764: aload 12
    //   1766: invokestatic 625	com/tencent/turingfd/sdk/xq/for:a	(Landroid/util/SparseArray;)I
    //   1769: istore 5
    //   1771: aload 12
    //   1773: iconst_1
    //   1774: ldc_w 627
    //   1777: invokestatic 630	com/tencent/turingfd/sdk/xq/for:a	(Landroid/util/SparseArray;ILjava/lang/Class;)Ljava/lang/Object;
    //   1780: checkcast 627	[B
    //   1783: astore 13
    //   1785: aload 13
    //   1787: astore 12
    //   1789: aload 13
    //   1791: ifnonnull +8 -> 1799
    //   1794: iconst_0
    //   1795: newarray byte
    //   1797: astore 12
    //   1799: aload_0
    //   1800: getfield 124	com/tencent/turingfd/sdk/xq/switch:dc	Lcom/tencent/turingfd/sdk/xq/extends;
    //   1803: aload_1
    //   1804: aload 12
    //   1806: arraylength
    //   1807: i2l
    //   1808: invokevirtual 632	com/tencent/turingfd/sdk/xq/extends:c	(Landroid/content/Context;J)V
    //   1811: aload_0
    //   1812: getfield 75	com/tencent/turingfd/sdk/xq/switch:ac	Lcom/tencent/turingfd/sdk/xq/case;
    //   1815: invokevirtual 635	com/tencent/turingfd/sdk/xq/case:l	()V
    //   1818: iload 5
    //   1820: ifeq +2482 -> 4302
    //   1823: iload 5
    //   1825: invokestatic 269	com/tencent/turingfd/sdk/xq/throws:c	(I)Lcom/tencent/turingfd/sdk/xq/throws;
    //   1828: astore 12
    //   1830: goto -1314 -> 516
    //   1833: aload 13
    //   1835: invokeinterface 431 1 0
    //   1840: ifeq +3237 -> 5077
    //   1843: aload 12
    //   1845: ldc_w 637
    //   1848: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1851: pop
    //   1852: goto -918 -> 934
    //   1855: ldc_w 443
    //   1858: astore 12
    //   1860: goto -880 -> 980
    //   1863: aconst_null
    //   1864: astore 12
    //   1866: aload 13
    //   1868: sipush 128
    //   1871: invokevirtual 643	android/content/pm/PackageManager:getInstalledApplications	(I)Ljava/util/List;
    //   1874: astore 13
    //   1876: aload 13
    //   1878: astore 12
    //   1880: aload 12
    //   1882: ifnull -866 -> 1016
    //   1885: getstatic 646	com/tencent/turingfd/sdk/xq/else:W	[I
    //   1888: invokestatic 337	com/tencent/turingfd/sdk/xq/else:get	([I)Ljava/lang/String;
    //   1891: astore 13
    //   1893: aload 12
    //   1895: invokeinterface 509 1 0
    //   1900: astore 12
    //   1902: aload 12
    //   1904: invokeinterface 431 1 0
    //   1909: ifeq -893 -> 1016
    //   1912: aload 12
    //   1914: invokeinterface 434 1 0
    //   1919: checkcast 648	android/content/pm/ApplicationInfo
    //   1922: astore 14
    //   1924: aload 14
    //   1926: ifnull -24 -> 1902
    //   1929: aload 13
    //   1931: aload 14
    //   1933: getfield 651	android/content/pm/ApplicationInfo:packageName	Ljava/lang/String;
    //   1936: invokevirtual 390	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1939: ifeq -37 -> 1902
    //   1942: iconst_1
    //   1943: istore_3
    //   1944: goto -926 -> 1018
    //   1947: aload 12
    //   1949: ldc_w 345
    //   1952: invokevirtual 349	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1955: astore 12
    //   1957: aload 12
    //   1959: ifnull -905 -> 1054
    //   1962: aload 12
    //   1964: arraylength
    //   1965: ifeq -911 -> 1054
    //   1968: aload_1
    //   1969: invokevirtual 352	android/content/Context:getPackageName	()Ljava/lang/String;
    //   1972: astore 13
    //   1974: aload 12
    //   1976: arraylength
    //   1977: istore 7
    //   1979: iconst_0
    //   1980: istore 5
    //   1982: iload 5
    //   1984: iload 7
    //   1986: if_icmpge -932 -> 1054
    //   1989: aload 13
    //   1991: aload 12
    //   1993: iload 5
    //   1995: aaload
    //   1996: invokestatic 656	com/tencent/turingfd/sdk/xq/float:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1999: istore_3
    //   2000: iload_3
    //   2001: ifeq +8 -> 2009
    //   2004: iconst_1
    //   2005: istore_3
    //   2006: goto -950 -> 1056
    //   2009: iload 5
    //   2011: iconst_1
    //   2012: iadd
    //   2013: istore 5
    //   2015: goto -33 -> 1982
    //   2018: ldc_w 658
    //   2021: astore 12
    //   2023: goto -952 -> 1071
    //   2026: astore 12
    //   2028: iconst_0
    //   2029: istore 5
    //   2031: goto -924 -> 1107
    //   2034: ldc_w 658
    //   2037: astore 12
    //   2039: goto -922 -> 1117
    //   2042: new 660	java/io/File
    //   2045: dup
    //   2046: getstatic 663	com/tencent/turingfd/sdk/xq/else:Ya	[I
    //   2049: invokestatic 337	com/tencent/turingfd/sdk/xq/else:get	([I)Ljava/lang/String;
    //   2052: invokespecial 664	java/io/File:<init>	(Ljava/lang/String;)V
    //   2055: astore 12
    //   2057: ldc_w 443
    //   2060: astore 14
    //   2062: new 666	java/io/BufferedReader
    //   2065: dup
    //   2066: new 668	java/io/FileReader
    //   2069: dup
    //   2070: aload 12
    //   2072: invokespecial 671	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   2075: invokespecial 674	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   2078: astore 12
    //   2080: aload 12
    //   2082: invokevirtual 677	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   2085: astore 13
    //   2087: aload 12
    //   2089: invokestatic 680	com/tencent/turingfd/sdk/xq/for:a	(Ljava/io/Closeable;)V
    //   2092: aload 13
    //   2094: astore 12
    //   2096: aload 12
    //   2098: invokestatic 111	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2101: ifne -950 -> 1151
    //   2104: ldc_w 682
    //   2107: aload 12
    //   2109: invokevirtual 390	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2112: ifeq +90 -> 2202
    //   2115: iconst_0
    //   2116: istore 5
    //   2118: aload_1
    //   2119: invokevirtual 460	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   2122: astore 12
    //   2124: aload 12
    //   2126: ldc_w 684
    //   2129: iconst_0
    //   2130: invokestatic 468	android/provider/Settings$Secure:getInt	(Landroid/content/ContentResolver;Ljava/lang/String;I)I
    //   2133: istore 6
    //   2135: iload 6
    //   2137: ifle +59 -> 2196
    //   2140: iconst_1
    //   2141: istore 5
    //   2143: iload 5
    //   2145: ifeq +85 -> 2230
    //   2148: iconst_1
    //   2149: istore 5
    //   2151: goto -997 -> 1154
    //   2154: astore_1
    //   2155: aconst_null
    //   2156: astore 12
    //   2158: aload 12
    //   2160: ifnull +8 -> 2168
    //   2163: aload 12
    //   2165: invokestatic 680	com/tencent/turingfd/sdk/xq/for:a	(Ljava/io/Closeable;)V
    //   2168: aload_1
    //   2169: athrow
    //   2170: astore 12
    //   2172: aconst_null
    //   2173: astore 13
    //   2175: aload 14
    //   2177: astore 12
    //   2179: aload 13
    //   2181: ifnull -85 -> 2096
    //   2184: aload 13
    //   2186: invokestatic 680	com/tencent/turingfd/sdk/xq/for:a	(Ljava/io/Closeable;)V
    //   2189: aload 14
    //   2191: astore 12
    //   2193: goto -97 -> 2096
    //   2196: iconst_0
    //   2197: istore 5
    //   2199: goto -56 -> 2143
    //   2202: ldc_w 686
    //   2205: aload 12
    //   2207: invokevirtual 390	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2210: ifeq +9 -> 2219
    //   2213: iconst_2
    //   2214: istore 5
    //   2216: goto -1062 -> 1154
    //   2219: ldc_w 687
    //   2222: aload 12
    //   2224: invokevirtual 390	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2227: ifeq -1076 -> 1151
    //   2230: iconst_3
    //   2231: istore 5
    //   2233: goto -1079 -> 1154
    //   2236: astore 12
    //   2238: aconst_null
    //   2239: astore 12
    //   2241: goto -1032 -> 1209
    //   2244: aload 12
    //   2246: ldc_w 689
    //   2249: iconst_m1
    //   2250: invokevirtual 694	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   2253: istore 5
    //   2255: iload 5
    //   2257: iconst_2
    //   2258: if_icmpeq +9 -> 2267
    //   2261: iload 5
    //   2263: iconst_5
    //   2264: if_icmpne +17 -> 2281
    //   2267: iconst_1
    //   2268: istore 5
    //   2270: iload 5
    //   2272: ifne +15 -> 2287
    //   2275: iconst_1
    //   2276: istore 5
    //   2278: goto -1061 -> 1217
    //   2281: iconst_0
    //   2282: istore 5
    //   2284: goto -14 -> 2270
    //   2287: aload 12
    //   2289: ldc_w 696
    //   2292: iconst_m1
    //   2293: invokevirtual 694	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   2296: istore 5
    //   2298: iload 5
    //   2300: iconst_2
    //   2301: if_icmpne +9 -> 2310
    //   2304: iconst_3
    //   2305: istore 5
    //   2307: goto -1090 -> 1217
    //   2310: iload 5
    //   2312: iconst_1
    //   2313: if_icmpne -1099 -> 1214
    //   2316: iconst_2
    //   2317: istore 5
    //   2319: goto -1102 -> 1217
    //   2322: aload 13
    //   2324: invokevirtual 699	android/content/Intent:getAction	()Ljava/lang/String;
    //   2327: ldc_w 484
    //   2330: invokestatic 702	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   2333: ifne +11 -> 2344
    //   2336: getstatic 498	com/tencent/turingfd/sdk/xq/catch:sb	I
    //   2339: istore 5
    //   2341: goto -1063 -> 1278
    //   2344: aload 13
    //   2346: ldc_w 704
    //   2349: iconst_0
    //   2350: invokevirtual 694	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   2353: istore 5
    //   2355: aload 13
    //   2357: ldc_w 706
    //   2360: bipush 100
    //   2362: invokevirtual 694	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   2365: istore 6
    //   2367: iload 6
    //   2369: ifne +11 -> 2380
    //   2372: getstatic 498	com/tencent/turingfd/sdk/xq/catch:sb	I
    //   2375: istore 5
    //   2377: goto -1099 -> 1278
    //   2380: iload 5
    //   2382: bipush 100
    //   2384: imul
    //   2385: iload 6
    //   2387: idiv
    //   2388: istore 5
    //   2390: iload 5
    //   2392: istore 6
    //   2394: iload 5
    //   2396: ifge +6 -> 2402
    //   2399: iconst_0
    //   2400: istore 6
    //   2402: iload 6
    //   2404: istore 5
    //   2406: iload 6
    //   2408: bipush 100
    //   2410: if_icmple -1132 -> 1278
    //   2413: bipush 100
    //   2415: istore 5
    //   2417: goto -1139 -> 1278
    //   2420: astore 13
    //   2422: getstatic 498	com/tencent/turingfd/sdk/xq/catch:sb	I
    //   2425: istore 5
    //   2427: goto -1149 -> 1278
    //   2430: astore 13
    //   2432: getstatic 498	com/tencent/turingfd/sdk/xq/catch:sb	I
    //   2435: istore 5
    //   2437: goto -1159 -> 1278
    //   2440: new 417	java/util/ArrayList
    //   2443: dup
    //   2444: invokespecial 418	java/util/ArrayList:<init>	()V
    //   2447: astore 13
    //   2449: new 417	java/util/ArrayList
    //   2452: dup
    //   2453: invokespecial 418	java/util/ArrayList:<init>	()V
    //   2456: astore 16
    //   2458: new 660	java/io/File
    //   2461: dup
    //   2462: ldc_w 708
    //   2465: invokespecial 664	java/io/File:<init>	(Ljava/lang/String;)V
    //   2468: invokevirtual 712	java/io/File:list	()[Ljava/lang/String;
    //   2471: astore 12
    //   2473: aload 12
    //   2475: ifnonnull +71 -> 2546
    //   2478: new 417	java/util/ArrayList
    //   2481: dup
    //   2482: invokespecial 418	java/util/ArrayList:<init>	()V
    //   2485: astore 14
    //   2487: invokestatic 717	android/os/Process:myPid	()I
    //   2490: istore 6
    //   2492: aload 16
    //   2494: invokeinterface 509 1 0
    //   2499: astore 12
    //   2501: iconst_0
    //   2502: istore 5
    //   2504: aload 12
    //   2506: invokeinterface 431 1 0
    //   2511: ifeq +129 -> 2640
    //   2514: aload 12
    //   2516: invokeinterface 434 1 0
    //   2521: checkcast 719	com/tencent/turingfd/sdk/xq/double
    //   2524: astore 17
    //   2526: iload 6
    //   2528: aload 17
    //   2530: getfield 722	com/tencent/turingfd/sdk/xq/double:pid	I
    //   2533: if_icmpne -29 -> 2504
    //   2536: aload 17
    //   2538: getfield 725	com/tencent/turingfd/sdk/xq/double:Mb	I
    //   2541: istore 5
    //   2543: goto -39 -> 2504
    //   2546: aload 12
    //   2548: arraylength
    //   2549: istore 6
    //   2551: iconst_0
    //   2552: istore 5
    //   2554: iload 5
    //   2556: iload 6
    //   2558: if_icmpge -80 -> 2478
    //   2561: aload 12
    //   2563: iload 5
    //   2565: aaload
    //   2566: astore 14
    //   2568: aload 14
    //   2570: invokestatic 111	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2573: ifeq +12 -> 2585
    //   2576: iload 5
    //   2578: iconst_1
    //   2579: iadd
    //   2580: istore 5
    //   2582: goto -28 -> 2554
    //   2585: aload 14
    //   2587: iconst_0
    //   2588: invokevirtual 729	java/lang/String:charAt	(I)C
    //   2591: istore 7
    //   2593: iload 7
    //   2595: bipush 57
    //   2597: if_icmpgt -21 -> 2576
    //   2600: iload 7
    //   2602: bipush 48
    //   2604: if_icmplt -28 -> 2576
    //   2607: aload 14
    //   2609: invokestatic 735	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   2612: invokestatic 738	com/tencent/turingfd/sdk/xq/for:b	(I)Lcom/tencent/turingfd/sdk/xq/double;
    //   2615: astore 14
    //   2617: aload 14
    //   2619: ifnull -43 -> 2576
    //   2622: aload 16
    //   2624: aload 14
    //   2626: invokeinterface 739 2 0
    //   2631: pop
    //   2632: goto -56 -> 2576
    //   2635: astore 14
    //   2637: goto -61 -> 2576
    //   2640: iload 5
    //   2642: ifne +130 -> 2772
    //   2645: aload 13
    //   2647: aload 14
    //   2649: invokeinterface 740 2 0
    //   2654: pop
    //   2655: new 414	java/lang/StringBuilder
    //   2658: dup
    //   2659: invokespecial 415	java/lang/StringBuilder:<init>	()V
    //   2662: astore 14
    //   2664: new 417	java/util/ArrayList
    //   2667: dup
    //   2668: invokespecial 418	java/util/ArrayList:<init>	()V
    //   2671: astore 12
    //   2673: aload 16
    //   2675: invokeinterface 509 1 0
    //   2680: astore 17
    //   2682: aload 17
    //   2684: invokeinterface 431 1 0
    //   2689: ifeq +203 -> 2892
    //   2692: aload 17
    //   2694: invokeinterface 434 1 0
    //   2699: checkcast 719	com/tencent/turingfd/sdk/xq/double
    //   2702: astore 18
    //   2704: getstatic 744	com/tencent/turingfd/sdk/xq/const:Ab	Ljava/util/Set;
    //   2707: invokeinterface 745 1 0
    //   2712: astore 19
    //   2714: aload 19
    //   2716: invokeinterface 431 1 0
    //   2721: ifeq -39 -> 2682
    //   2724: aload 19
    //   2726: invokeinterface 434 1 0
    //   2731: checkcast 193	java/lang/String
    //   2734: astore 20
    //   2736: aload 18
    //   2738: getfield 748	com/tencent/turingfd/sdk/xq/double:name	Ljava/lang/String;
    //   2741: aload 20
    //   2743: invokevirtual 196	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2746: ifeq -32 -> 2714
    //   2749: aload 14
    //   2751: aload 18
    //   2753: getfield 748	com/tencent/turingfd/sdk/xq/double:name	Ljava/lang/String;
    //   2756: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2759: pop
    //   2760: aload 14
    //   2762: ldc_w 637
    //   2765: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2768: pop
    //   2769: goto -55 -> 2714
    //   2772: aload 16
    //   2774: invokeinterface 509 1 0
    //   2779: astore 17
    //   2781: ldc_w 443
    //   2784: astore 12
    //   2786: aload 17
    //   2788: invokeinterface 431 1 0
    //   2793: ifeq +35 -> 2828
    //   2796: aload 17
    //   2798: invokeinterface 434 1 0
    //   2803: checkcast 719	com/tencent/turingfd/sdk/xq/double
    //   2806: astore 18
    //   2808: iload 5
    //   2810: aload 18
    //   2812: getfield 722	com/tencent/turingfd/sdk/xq/double:pid	I
    //   2815: if_icmpne -29 -> 2786
    //   2818: aload 18
    //   2820: getfield 748	com/tencent/turingfd/sdk/xq/double:name	Ljava/lang/String;
    //   2823: astore 12
    //   2825: goto -39 -> 2786
    //   2828: aload 12
    //   2830: invokestatic 111	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2833: ifne -188 -> 2645
    //   2836: new 511	com/tencent/turingfd/sdk/xq/import
    //   2839: dup
    //   2840: invokespecial 749	com/tencent/turingfd/sdk/xq/import:<init>	()V
    //   2843: astore 17
    //   2845: aload 17
    //   2847: new 414	java/lang/StringBuilder
    //   2850: dup
    //   2851: invokespecial 415	java/lang/StringBuilder:<init>	()V
    //   2854: getstatic 752	com/tencent/turingfd/sdk/xq/void:lb	Ljava/lang/String;
    //   2857: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2860: getstatic 755	com/tencent/turingfd/sdk/xq/void:rb	Ljava/lang/String;
    //   2863: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2866: invokevirtual 441	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2869: putfield 514	com/tencent/turingfd/sdk/xq/import:Nb	Ljava/lang/String;
    //   2872: aload 17
    //   2874: aload 12
    //   2876: putfield 522	com/tencent/turingfd/sdk/xq/import:Ob	Ljava/lang/String;
    //   2879: aload 14
    //   2881: aload 17
    //   2883: invokeinterface 739 2 0
    //   2888: pop
    //   2889: goto -244 -> 2645
    //   2892: aload 14
    //   2894: invokevirtual 441	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2897: astore 14
    //   2899: aload 14
    //   2901: invokestatic 111	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2904: ifne +61 -> 2965
    //   2907: new 511	com/tencent/turingfd/sdk/xq/import
    //   2910: dup
    //   2911: invokespecial 749	com/tencent/turingfd/sdk/xq/import:<init>	()V
    //   2914: astore 17
    //   2916: aload 17
    //   2918: new 414	java/lang/StringBuilder
    //   2921: dup
    //   2922: invokespecial 415	java/lang/StringBuilder:<init>	()V
    //   2925: getstatic 752	com/tencent/turingfd/sdk/xq/void:lb	Ljava/lang/String;
    //   2928: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2931: getstatic 519	com/tencent/turingfd/sdk/xq/void:nb	Ljava/lang/String;
    //   2934: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2937: invokevirtual 441	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2940: putfield 514	com/tencent/turingfd/sdk/xq/import:Nb	Ljava/lang/String;
    //   2943: aload 17
    //   2945: aload 14
    //   2947: iconst_1
    //   2948: iconst_0
    //   2949: invokestatic 760	com/tencent/turingfd/sdk/xq/do:a	(Ljava/lang/String;II)Ljava/lang/String;
    //   2952: putfield 522	com/tencent/turingfd/sdk/xq/import:Ob	Ljava/lang/String;
    //   2955: aload 12
    //   2957: aload 17
    //   2959: invokeinterface 739 2 0
    //   2964: pop
    //   2965: aload 13
    //   2967: aload 12
    //   2969: invokeinterface 740 2 0
    //   2974: pop
    //   2975: new 417	java/util/ArrayList
    //   2978: dup
    //   2979: invokespecial 418	java/util/ArrayList:<init>	()V
    //   2982: astore 12
    //   2984: new 414	java/lang/StringBuilder
    //   2987: dup
    //   2988: invokespecial 415	java/lang/StringBuilder:<init>	()V
    //   2991: astore 14
    //   2993: new 328	java/util/HashSet
    //   2996: dup
    //   2997: invokespecial 329	java/util/HashSet:<init>	()V
    //   3000: astore 17
    //   3002: aload 16
    //   3004: invokeinterface 509 1 0
    //   3009: astore 18
    //   3011: iconst_0
    //   3012: istore 5
    //   3014: aload 18
    //   3016: invokeinterface 431 1 0
    //   3021: ifeq +289 -> 3310
    //   3024: aload 18
    //   3026: invokeinterface 434 1 0
    //   3031: checkcast 719	com/tencent/turingfd/sdk/xq/double
    //   3034: astore 19
    //   3036: aload 19
    //   3038: getfield 763	com/tencent/turingfd/sdk/xq/double:uid	I
    //   3041: ifne -27 -> 3014
    //   3044: aload 19
    //   3046: getfield 748	com/tencent/turingfd/sdk/xq/double:name	Ljava/lang/String;
    //   3049: ldc_w 765
    //   3052: invokevirtual 769	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   3055: ifeq -41 -> 3014
    //   3058: aload 19
    //   3060: getfield 748	com/tencent/turingfd/sdk/xq/double:name	Ljava/lang/String;
    //   3063: ldc_w 771
    //   3066: invokevirtual 769	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   3069: ifne -55 -> 3014
    //   3072: aload 19
    //   3074: getfield 748	com/tencent/turingfd/sdk/xq/double:name	Ljava/lang/String;
    //   3077: ldc_w 773
    //   3080: invokevirtual 769	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   3083: ifne -69 -> 3014
    //   3086: aload 19
    //   3088: getfield 748	com/tencent/turingfd/sdk/xq/double:name	Ljava/lang/String;
    //   3091: ldc_w 775
    //   3094: invokevirtual 769	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   3097: ifne -83 -> 3014
    //   3100: aload 19
    //   3102: getfield 748	com/tencent/turingfd/sdk/xq/double:name	Ljava/lang/String;
    //   3105: ldc_w 777
    //   3108: invokevirtual 769	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   3111: ifne -97 -> 3014
    //   3114: aload 19
    //   3116: getfield 748	com/tencent/turingfd/sdk/xq/double:name	Ljava/lang/String;
    //   3119: ldc_w 779
    //   3122: invokevirtual 769	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   3125: ifne -111 -> 3014
    //   3128: aload 19
    //   3130: getfield 748	com/tencent/turingfd/sdk/xq/double:name	Ljava/lang/String;
    //   3133: ldc_w 781
    //   3136: invokevirtual 769	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   3139: ifne -125 -> 3014
    //   3142: aload 19
    //   3144: getfield 748	com/tencent/turingfd/sdk/xq/double:name	Ljava/lang/String;
    //   3147: ldc_w 783
    //   3150: invokevirtual 769	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   3153: ifne -139 -> 3014
    //   3156: aload 19
    //   3158: getfield 748	com/tencent/turingfd/sdk/xq/double:name	Ljava/lang/String;
    //   3161: ldc_w 785
    //   3164: invokevirtual 196	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3167: ifne -153 -> 3014
    //   3170: aload 19
    //   3172: getfield 748	com/tencent/turingfd/sdk/xq/double:name	Ljava/lang/String;
    //   3175: ldc_w 787
    //   3178: invokevirtual 790	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   3181: ifne -167 -> 3014
    //   3184: getstatic 744	com/tencent/turingfd/sdk/xq/const:Ab	Ljava/util/Set;
    //   3187: invokeinterface 745 1 0
    //   3192: astore 20
    //   3194: aload 20
    //   3196: invokeinterface 431 1 0
    //   3201: ifeq +1870 -> 5071
    //   3204: aload 20
    //   3206: invokeinterface 434 1 0
    //   3211: checkcast 193	java/lang/String
    //   3214: astore 21
    //   3216: aload 19
    //   3218: getfield 748	com/tencent/turingfd/sdk/xq/double:name	Ljava/lang/String;
    //   3221: aload 21
    //   3223: invokevirtual 196	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3226: ifeq -32 -> 3194
    //   3229: iconst_1
    //   3230: istore 6
    //   3232: iload 6
    //   3234: ifne -220 -> 3014
    //   3237: getstatic 793	com/tencent/turingfd/sdk/xq/const:Db	Ljava/util/Set;
    //   3240: invokeinterface 745 1 0
    //   3245: astore 20
    //   3247: aload 20
    //   3249: invokeinterface 431 1 0
    //   3254: ifeq +1811 -> 5065
    //   3257: aload 20
    //   3259: invokeinterface 434 1 0
    //   3264: checkcast 193	java/lang/String
    //   3267: astore 21
    //   3269: aload 19
    //   3271: getfield 748	com/tencent/turingfd/sdk/xq/double:name	Ljava/lang/String;
    //   3274: aload 21
    //   3276: invokevirtual 196	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3279: ifeq -32 -> 3247
    //   3282: iconst_1
    //   3283: istore 6
    //   3285: iload 6
    //   3287: ifne -273 -> 3014
    //   3290: aload 17
    //   3292: aload 19
    //   3294: getfield 748	com/tencent/turingfd/sdk/xq/double:name	Ljava/lang/String;
    //   3297: invokeinterface 361 2 0
    //   3302: pop
    //   3303: iload 5
    //   3305: bipush 8
    //   3307: if_icmplt +1749 -> 5056
    //   3310: aload 17
    //   3312: invokeinterface 412 1 0
    //   3317: ifle +115 -> 3432
    //   3320: aload 17
    //   3322: invokeinterface 745 1 0
    //   3327: astore 17
    //   3329: aload 17
    //   3331: invokeinterface 431 1 0
    //   3336: ifeq +31 -> 3367
    //   3339: aload 14
    //   3341: aload 17
    //   3343: invokeinterface 434 1 0
    //   3348: checkcast 193	java/lang/String
    //   3351: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3354: pop
    //   3355: aload 14
    //   3357: ldc_w 637
    //   3360: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3363: pop
    //   3364: goto -35 -> 3329
    //   3367: aload 14
    //   3369: invokevirtual 441	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3372: astore 14
    //   3374: new 511	com/tencent/turingfd/sdk/xq/import
    //   3377: dup
    //   3378: invokespecial 749	com/tencent/turingfd/sdk/xq/import:<init>	()V
    //   3381: astore 17
    //   3383: aload 17
    //   3385: new 414	java/lang/StringBuilder
    //   3388: dup
    //   3389: invokespecial 415	java/lang/StringBuilder:<init>	()V
    //   3392: getstatic 752	com/tencent/turingfd/sdk/xq/void:lb	Ljava/lang/String;
    //   3395: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3398: getstatic 796	com/tencent/turingfd/sdk/xq/void:ob	Ljava/lang/String;
    //   3401: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3404: invokevirtual 441	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3407: putfield 514	com/tencent/turingfd/sdk/xq/import:Nb	Ljava/lang/String;
    //   3410: aload 17
    //   3412: aload 14
    //   3414: iconst_1
    //   3415: iconst_0
    //   3416: invokestatic 760	com/tencent/turingfd/sdk/xq/do:a	(Ljava/lang/String;II)Ljava/lang/String;
    //   3419: putfield 522	com/tencent/turingfd/sdk/xq/import:Ob	Ljava/lang/String;
    //   3422: aload 12
    //   3424: aload 17
    //   3426: invokeinterface 739 2 0
    //   3431: pop
    //   3432: aload 13
    //   3434: aload 12
    //   3436: invokeinterface 740 2 0
    //   3441: pop
    //   3442: new 193	java/lang/String
    //   3445: dup
    //   3446: getstatic 799	com/tencent/turingfd/sdk/xq/else:Za	[I
    //   3449: invokestatic 337	com/tencent/turingfd/sdk/xq/else:get	([I)Ljava/lang/String;
    //   3452: invokestatic 340	com/tencent/turingfd/sdk/xq/for:b	(Ljava/lang/String;)[B
    //   3455: invokespecial 343	java/lang/String:<init>	([B)V
    //   3458: astore 12
    //   3460: aload 12
    //   3462: invokestatic 111	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3465: ifeq +81 -> 3546
    //   3468: getstatic 803	com/tencent/turingfd/sdk/xq/const:Bb	[Ljava/lang/String;
    //   3471: astore 12
    //   3473: new 277	java/util/HashMap
    //   3476: dup
    //   3477: invokespecial 278	java/util/HashMap:<init>	()V
    //   3480: astore 17
    //   3482: new 328	java/util/HashSet
    //   3485: dup
    //   3486: invokespecial 329	java/util/HashSet:<init>	()V
    //   3489: astore 14
    //   3491: getstatic 806	com/tencent/turingfd/sdk/xq/else:gb	[I
    //   3494: invokestatic 337	com/tencent/turingfd/sdk/xq/else:get	([I)Ljava/lang/String;
    //   3497: invokestatic 812	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   3500: astore 18
    //   3502: aload 12
    //   3504: arraylength
    //   3505: istore 6
    //   3507: iconst_0
    //   3508: istore 5
    //   3510: iload 5
    //   3512: iload 6
    //   3514: if_icmpge +184 -> 3698
    //   3517: aload 18
    //   3519: aload 12
    //   3521: iload 5
    //   3523: aaload
    //   3524: invokevirtual 816	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   3527: astore 19
    //   3529: aload 19
    //   3531: invokevirtual 821	java/util/regex/Matcher:find	()Z
    //   3534: ifne +55 -> 3589
    //   3537: iload 5
    //   3539: iconst_1
    //   3540: iadd
    //   3541: istore 5
    //   3543: goto -33 -> 3510
    //   3546: aload 12
    //   3548: ldc_w 823
    //   3551: invokevirtual 349	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   3554: astore 14
    //   3556: aload 14
    //   3558: ifnull +13 -> 3571
    //   3561: aload 14
    //   3563: astore 12
    //   3565: aload 14
    //   3567: arraylength
    //   3568: ifne -95 -> 3473
    //   3571: getstatic 803	com/tencent/turingfd/sdk/xq/const:Bb	[Ljava/lang/String;
    //   3574: astore 12
    //   3576: goto -103 -> 3473
    //   3579: astore 12
    //   3581: getstatic 803	com/tencent/turingfd/sdk/xq/const:Bb	[Ljava/lang/String;
    //   3584: astore 12
    //   3586: goto -113 -> 3473
    //   3589: ldc_w 825
    //   3592: aload 19
    //   3594: iconst_4
    //   3595: invokevirtual 829	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   3598: invokevirtual 390	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3601: ifeq -64 -> 3537
    //   3604: ldc_w 831
    //   3607: aload 19
    //   3609: iconst_3
    //   3610: invokevirtual 829	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   3613: invokevirtual 390	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3616: ifeq +44 -> 3660
    //   3619: aload 19
    //   3621: iconst_1
    //   3622: invokevirtual 829	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   3625: ldc_w 833
    //   3628: invokevirtual 349	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   3631: astore 19
    //   3633: aload 19
    //   3635: ifnull -98 -> 3537
    //   3638: aload 19
    //   3640: arraylength
    //   3641: iconst_2
    //   3642: if_icmplt -105 -> 3537
    //   3645: aload 14
    //   3647: aload 19
    //   3649: iconst_1
    //   3650: aaload
    //   3651: invokeinterface 361 2 0
    //   3656: pop
    //   3657: goto -120 -> 3537
    //   3660: ldc_w 835
    //   3663: aload 19
    //   3665: iconst_3
    //   3666: invokevirtual 829	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   3669: invokevirtual 390	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3672: ifeq -135 -> 3537
    //   3675: aload 17
    //   3677: aload 19
    //   3679: iconst_1
    //   3680: invokevirtual 829	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   3683: aload 19
    //   3685: iconst_2
    //   3686: invokevirtual 829	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   3689: invokeinterface 836 3 0
    //   3694: pop
    //   3695: goto -158 -> 3537
    //   3698: new 277	java/util/HashMap
    //   3701: dup
    //   3702: aload 17
    //   3704: invokespecial 839	java/util/HashMap:<init>	(Ljava/util/Map;)V
    //   3707: astore 18
    //   3709: new 328	java/util/HashSet
    //   3712: dup
    //   3713: invokespecial 329	java/util/HashSet:<init>	()V
    //   3716: astore 12
    //   3718: aload 17
    //   3720: invokeinterface 843 1 0
    //   3725: invokeinterface 745 1 0
    //   3730: astore 19
    //   3732: aload 19
    //   3734: invokeinterface 431 1 0
    //   3739: ifeq +114 -> 3853
    //   3742: aload 19
    //   3744: invokeinterface 434 1 0
    //   3749: checkcast 193	java/lang/String
    //   3752: astore 20
    //   3754: aload 17
    //   3756: aload 20
    //   3758: invokeinterface 393 2 0
    //   3763: checkcast 193	java/lang/String
    //   3766: astore 21
    //   3768: aload 18
    //   3770: aload 21
    //   3772: invokeinterface 393 2 0
    //   3777: ifnull -45 -> 3732
    //   3780: aload 20
    //   3782: aload 18
    //   3784: aload 21
    //   3786: invokeinterface 393 2 0
    //   3791: checkcast 193	java/lang/String
    //   3794: invokevirtual 390	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3797: ifeq -65 -> 3732
    //   3800: aload 20
    //   3802: ldc_w 833
    //   3805: invokevirtual 349	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   3808: astore 20
    //   3810: aload 20
    //   3812: ifnull -80 -> 3732
    //   3815: aload 20
    //   3817: arraylength
    //   3818: iconst_2
    //   3819: if_icmplt -87 -> 3732
    //   3822: aload 20
    //   3824: iconst_1
    //   3825: aaload
    //   3826: astore 20
    //   3828: aload 14
    //   3830: aload 20
    //   3832: invokeinterface 845 2 0
    //   3837: ifeq -105 -> 3732
    //   3840: aload 12
    //   3842: aload 20
    //   3844: invokeinterface 361 2 0
    //   3849: pop
    //   3850: goto -118 -> 3732
    //   3853: aload 16
    //   3855: invokestatic 848	com/tencent/turingfd/sdk/xq/const:a	(Ljava/util/List;)Ljava/util/Set;
    //   3858: astore 19
    //   3860: new 417	java/util/ArrayList
    //   3863: dup
    //   3864: invokespecial 418	java/util/ArrayList:<init>	()V
    //   3867: astore 17
    //   3869: aload 14
    //   3871: invokeinterface 412 1 0
    //   3876: aload 12
    //   3878: invokeinterface 412 1 0
    //   3883: iadd
    //   3884: aload 19
    //   3886: invokeinterface 412 1 0
    //   3891: iadd
    //   3892: ifne +56 -> 3948
    //   3895: aload 13
    //   3897: aload 17
    //   3899: invokeinterface 740 2 0
    //   3904: pop
    //   3905: new 417	java/util/ArrayList
    //   3908: dup
    //   3909: invokespecial 418	java/util/ArrayList:<init>	()V
    //   3912: astore 12
    //   3914: aload 16
    //   3916: invokestatic 848	com/tencent/turingfd/sdk/xq/const:a	(Ljava/util/List;)Ljava/util/Set;
    //   3919: astore 16
    //   3921: aload 16
    //   3923: invokeinterface 412 1 0
    //   3928: ifne +139 -> 4067
    //   3931: aload 13
    //   3933: aload 12
    //   3935: invokeinterface 740 2 0
    //   3940: pop
    //   3941: aload 13
    //   3943: astore 12
    //   3945: goto -2638 -> 1307
    //   3948: new 414	java/lang/StringBuilder
    //   3951: dup
    //   3952: invokespecial 415	java/lang/StringBuilder:<init>	()V
    //   3955: astore 18
    //   3957: aload 18
    //   3959: aload 14
    //   3961: invokestatic 851	com/tencent/turingfd/sdk/xq/const:a	(Ljava/util/Set;)Ljava/lang/String;
    //   3964: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3967: pop
    //   3968: aload 18
    //   3970: ldc_w 853
    //   3973: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3976: pop
    //   3977: aload 18
    //   3979: aload 12
    //   3981: invokestatic 851	com/tencent/turingfd/sdk/xq/const:a	(Ljava/util/Set;)Ljava/lang/String;
    //   3984: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3987: pop
    //   3988: aload 18
    //   3990: ldc_w 853
    //   3993: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3996: pop
    //   3997: aload 18
    //   3999: aload 19
    //   4001: invokestatic 851	com/tencent/turingfd/sdk/xq/const:a	(Ljava/util/Set;)Ljava/lang/String;
    //   4004: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4007: pop
    //   4008: new 511	com/tencent/turingfd/sdk/xq/import
    //   4011: dup
    //   4012: invokespecial 749	com/tencent/turingfd/sdk/xq/import:<init>	()V
    //   4015: astore 12
    //   4017: aload 12
    //   4019: new 414	java/lang/StringBuilder
    //   4022: dup
    //   4023: invokespecial 415	java/lang/StringBuilder:<init>	()V
    //   4026: getstatic 752	com/tencent/turingfd/sdk/xq/void:lb	Ljava/lang/String;
    //   4029: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4032: getstatic 856	com/tencent/turingfd/sdk/xq/void:pb	Ljava/lang/String;
    //   4035: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4038: invokevirtual 441	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4041: putfield 514	com/tencent/turingfd/sdk/xq/import:Nb	Ljava/lang/String;
    //   4044: aload 12
    //   4046: aload 18
    //   4048: invokevirtual 441	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4051: putfield 522	com/tencent/turingfd/sdk/xq/import:Ob	Ljava/lang/String;
    //   4054: aload 17
    //   4056: aload 12
    //   4058: invokeinterface 739 2 0
    //   4063: pop
    //   4064: goto -169 -> 3895
    //   4067: new 414	java/lang/StringBuilder
    //   4070: dup
    //   4071: invokespecial 415	java/lang/StringBuilder:<init>	()V
    //   4074: astore 14
    //   4076: aload 16
    //   4078: invokeinterface 745 1 0
    //   4083: astore 16
    //   4085: aload 16
    //   4087: invokeinterface 431 1 0
    //   4092: ifeq +31 -> 4123
    //   4095: aload 14
    //   4097: aload 16
    //   4099: invokeinterface 434 1 0
    //   4104: checkcast 193	java/lang/String
    //   4107: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4110: pop
    //   4111: aload 14
    //   4113: ldc_w 637
    //   4116: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4119: pop
    //   4120: goto -35 -> 4085
    //   4123: aload 14
    //   4125: invokevirtual 441	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4128: astore 14
    //   4130: new 511	com/tencent/turingfd/sdk/xq/import
    //   4133: dup
    //   4134: invokespecial 749	com/tencent/turingfd/sdk/xq/import:<init>	()V
    //   4137: astore 16
    //   4139: aload 16
    //   4141: new 414	java/lang/StringBuilder
    //   4144: dup
    //   4145: invokespecial 415	java/lang/StringBuilder:<init>	()V
    //   4148: getstatic 752	com/tencent/turingfd/sdk/xq/void:lb	Ljava/lang/String;
    //   4151: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4154: getstatic 859	com/tencent/turingfd/sdk/xq/void:qb	Ljava/lang/String;
    //   4157: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4160: invokevirtual 441	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4163: putfield 514	com/tencent/turingfd/sdk/xq/import:Nb	Ljava/lang/String;
    //   4166: aload 16
    //   4168: aload 14
    //   4170: iconst_1
    //   4171: iconst_0
    //   4172: invokestatic 760	com/tencent/turingfd/sdk/xq/do:a	(Ljava/lang/String;II)Ljava/lang/String;
    //   4175: putfield 522	com/tencent/turingfd/sdk/xq/import:Ob	Ljava/lang/String;
    //   4178: aload 12
    //   4180: aload 16
    //   4182: invokeinterface 739 2 0
    //   4187: pop
    //   4188: goto -257 -> 3931
    //   4191: ldc_w 443
    //   4194: astore 12
    //   4196: goto -2837 -> 1359
    //   4199: ldc_w 443
    //   4202: astore 12
    //   4204: goto -2788 -> 1416
    //   4207: aload 13
    //   4209: invokevirtual 862	android/net/NetworkInfo:getType	()I
    //   4212: iconst_1
    //   4213: if_icmpne +9 -> 4222
    //   4216: iconst_0
    //   4217: istore 5
    //   4219: goto -2565 -> 1654
    //   4222: aload 13
    //   4224: invokevirtual 862	android/net/NetworkInfo:getType	()I
    //   4227: ifne -2576 -> 1651
    //   4230: invokestatic 867	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   4233: ifnonnull +14 -> 4247
    //   4236: aload_1
    //   4237: invokestatic 870	android/net/Proxy:getHost	(Landroid/content/Context;)Ljava/lang/String;
    //   4240: astore 13
    //   4242: aload 13
    //   4244: ifnull +9 -> 4253
    //   4247: iconst_2
    //   4248: istore 5
    //   4250: goto -2596 -> 1654
    //   4253: iconst_1
    //   4254: istore 5
    //   4256: goto -2602 -> 1654
    //   4259: astore 13
    //   4261: aload 13
    //   4263: invokevirtual 189	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   4266: astore 13
    //   4268: bipush 253
    //   4270: istore 6
    //   4272: iload 6
    //   4274: istore 5
    //   4276: aload 13
    //   4278: ifnull -2624 -> 1654
    //   4281: iload 6
    //   4283: istore 5
    //   4285: aload 13
    //   4287: ldc 191
    //   4289: invokevirtual 196	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   4292: ifeq -2638 -> 1654
    //   4295: bipush 254
    //   4297: istore 5
    //   4299: goto -2645 -> 1654
    //   4302: aload 12
    //   4304: arraylength
    //   4305: ifne +14 -> 4319
    //   4308: sipush -10003
    //   4311: invokestatic 269	com/tencent/turingfd/sdk/xq/throws:c	(I)Lcom/tencent/turingfd/sdk/xq/throws;
    //   4314: astore 12
    //   4316: goto -3800 -> 516
    //   4319: new 266	com/tencent/turingfd/sdk/xq/throws
    //   4322: dup
    //   4323: iconst_0
    //   4324: aload 12
    //   4326: invokespecial 873	com/tencent/turingfd/sdk/xq/throws:<init>	(I[B)V
    //   4329: astore 12
    //   4331: goto -3815 -> 516
    //   4334: astore 12
    //   4336: invokestatic 182	com/tencent/turingfd/sdk/xq/private:getInstance	()Lcom/tencent/turingfd/sdk/xq/private;
    //   4339: aload 12
    //   4341: invokevirtual 875	com/tencent/turingfd/sdk/xq/private:a	(Ljava/lang/Throwable;)V
    //   4344: sipush -10006
    //   4347: invokestatic 269	com/tencent/turingfd/sdk/xq/throws:c	(I)Lcom/tencent/turingfd/sdk/xq/throws;
    //   4350: astore 12
    //   4352: goto -3836 -> 516
    //   4355: aload 12
    //   4357: getfield 878	com/tencent/turingfd/sdk/xq/throws:ic	[B
    //   4360: astore 12
    //   4362: invokestatic 117	java/lang/System:currentTimeMillis	()J
    //   4365: lstore 8
    //   4367: aload_0
    //   4368: getfield 75	com/tencent/turingfd/sdk/xq/switch:ac	Lcom/tencent/turingfd/sdk/xq/case;
    //   4371: invokevirtual 881	com/tencent/turingfd/sdk/xq/case:m	()Lcom/tencent/turingfd/sdk/xq/goto;
    //   4374: astore 13
    //   4376: aload 13
    //   4378: ifnonnull +40 -> 4418
    //   4381: sipush -20000
    //   4384: invokestatic 886	com/tencent/turingfd/sdk/xq/boolean:c	(I)Lcom/tencent/turingfd/sdk/xq/boolean;
    //   4387: astore 12
    //   4389: aload 12
    //   4391: getfield 887	com/tencent/turingfd/sdk/xq/boolean:Rb	I
    //   4394: ifeq +96 -> 4490
    //   4397: aload 12
    //   4399: getfield 887	com/tencent/turingfd/sdk/xq/boolean:Rb	I
    //   4402: ifeq +254 -> 4656
    //   4405: aload 12
    //   4407: invokevirtual 888	com/tencent/turingfd/sdk/xq/boolean:getErrorCode	()I
    //   4410: invokestatic 166	com/tencent/turingfd/sdk/xq/public:c	(I)Lcom/tencent/turingfd/sdk/xq/public;
    //   4413: astore 12
    //   4415: goto -3881 -> 534
    //   4418: invokestatic 117	java/lang/System:currentTimeMillis	()J
    //   4421: pop2
    //   4422: aload 13
    //   4424: checkcast 890	com/tencent/turingfd/sdk/xq/super
    //   4427: astore 13
    //   4429: aload 13
    //   4431: iconst_1
    //   4432: aload 12
    //   4434: invokevirtual 893	com/tencent/turingfd/sdk/xq/super:b	(I[B)Lcom/tencent/turingfd/sdk/xq/goto$do;
    //   4437: astore 12
    //   4439: aload 12
    //   4441: getfield 898	com/tencent/turingfd/sdk/xq/goto$do:jb	I
    //   4444: ifeq +20 -> 4464
    //   4447: aload 12
    //   4449: getfield 898	com/tencent/turingfd/sdk/xq/goto$do:jb	I
    //   4452: sipush 20000
    //   4455: isub
    //   4456: invokestatic 886	com/tencent/turingfd/sdk/xq/boolean:c	(I)Lcom/tencent/turingfd/sdk/xq/boolean;
    //   4459: astore 12
    //   4461: goto -72 -> 4389
    //   4464: aload 12
    //   4466: getfield 901	com/tencent/turingfd/sdk/xq/goto$do:data	[B
    //   4469: invokestatic 904	com/tencent/turingfd/sdk/xq/boolean:f	([B)Lcom/tencent/turingfd/sdk/xq/boolean;
    //   4472: astore 12
    //   4474: goto -85 -> 4389
    //   4477: astore 12
    //   4479: sipush -20000
    //   4482: invokestatic 886	com/tencent/turingfd/sdk/xq/boolean:c	(I)Lcom/tencent/turingfd/sdk/xq/boolean;
    //   4485: astore 12
    //   4487: goto -98 -> 4389
    //   4490: aload_1
    //   4491: ldc 154
    //   4493: invokevirtual 160	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   4496: checkcast 162	android/net/ConnectivityManager
    //   4499: invokevirtual 170	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   4502: astore 13
    //   4504: aload 13
    //   4506: ifnull +33 -> 4539
    //   4509: aload 13
    //   4511: invokevirtual 577	android/net/NetworkInfo:getState	()Landroid/net/NetworkInfo$State;
    //   4514: getstatic 583	android/net/NetworkInfo$State:CONNECTING	Landroid/net/NetworkInfo$State;
    //   4517: if_acmpeq +44 -> 4561
    //   4520: aload 13
    //   4522: invokevirtual 577	android/net/NetworkInfo:getState	()Landroid/net/NetworkInfo$State;
    //   4525: astore 14
    //   4527: getstatic 586	android/net/NetworkInfo$State:CONNECTED	Landroid/net/NetworkInfo$State;
    //   4530: astore 15
    //   4532: aload 14
    //   4534: aload 15
    //   4536: if_acmpeq +25 -> 4561
    //   4539: iconst_m1
    //   4540: istore 5
    //   4542: aload_0
    //   4543: getfield 124	com/tencent/turingfd/sdk/xq/switch:dc	Lcom/tencent/turingfd/sdk/xq/extends;
    //   4546: aload_1
    //   4547: iload 5
    //   4549: invokestatic 117	java/lang/System:currentTimeMillis	()J
    //   4552: lload 8
    //   4554: lsub
    //   4555: invokevirtual 907	com/tencent/turingfd/sdk/xq/extends:a	(Landroid/content/Context;IJ)V
    //   4558: goto -161 -> 4397
    //   4561: aload 13
    //   4563: invokevirtual 862	android/net/NetworkInfo:getType	()I
    //   4566: iconst_1
    //   4567: if_icmpne +6 -> 4573
    //   4570: goto +510 -> 5080
    //   4573: aload 13
    //   4575: invokevirtual 862	android/net/NetworkInfo:getType	()I
    //   4578: ifne -39 -> 4539
    //   4581: invokestatic 867	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   4584: ifnonnull +14 -> 4598
    //   4587: aload_1
    //   4588: invokestatic 870	android/net/Proxy:getHost	(Landroid/content/Context;)Ljava/lang/String;
    //   4591: astore 13
    //   4593: aload 13
    //   4595: ifnull +9 -> 4604
    //   4598: iconst_2
    //   4599: istore 5
    //   4601: goto -59 -> 4542
    //   4604: iconst_1
    //   4605: istore 5
    //   4607: goto -65 -> 4542
    //   4610: astore 13
    //   4612: aload 13
    //   4614: invokevirtual 189	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   4617: astore 13
    //   4619: iconst_0
    //   4620: istore 6
    //   4622: iload 6
    //   4624: istore 5
    //   4626: aload 13
    //   4628: ifnull +20 -> 4648
    //   4631: iload 6
    //   4633: istore 5
    //   4635: aload 13
    //   4637: ldc 191
    //   4639: invokevirtual 196	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   4642: ifeq +6 -> 4648
    //   4645: iconst_1
    //   4646: istore 5
    //   4648: iload 5
    //   4650: ifeq -111 -> 4539
    //   4653: goto +427 -> 5080
    //   4656: aload 12
    //   4658: getfield 910	com/tencent/turingfd/sdk/xq/boolean:jc	[B
    //   4661: astore 12
    //   4663: invokestatic 614	com/tencent/turingfd/sdk/xq/for:a	()Landroid/util/SparseArray;
    //   4666: aload 12
    //   4668: iconst_1
    //   4669: invokestatic 913	com/tencent/turingfd/sdk/xq/TuringDIDService$aa:b	(Landroid/util/SparseArray;[BI)Landroid/util/SparseArray;
    //   4672: astore 15
    //   4674: aload 15
    //   4676: invokestatic 625	com/tencent/turingfd/sdk/xq/for:a	(Landroid/util/SparseArray;)I
    //   4679: istore 5
    //   4681: iload 5
    //   4683: ifeq +13 -> 4696
    //   4686: iload 5
    //   4688: invokestatic 166	com/tencent/turingfd/sdk/xq/public:c	(I)Lcom/tencent/turingfd/sdk/xq/public;
    //   4691: astore 12
    //   4693: goto -4159 -> 534
    //   4696: aload 15
    //   4698: bipush 102
    //   4700: ldc_w 731
    //   4703: invokestatic 630	com/tencent/turingfd/sdk/xq/for:a	(Landroid/util/SparseArray;ILjava/lang/Class;)Ljava/lang/Object;
    //   4706: checkcast 731	java/lang/Integer
    //   4709: astore 14
    //   4711: aload 14
    //   4713: ifnonnull +14 -> 4727
    //   4716: sipush -30000
    //   4719: invokestatic 166	com/tencent/turingfd/sdk/xq/public:c	(I)Lcom/tencent/turingfd/sdk/xq/public;
    //   4722: astore 12
    //   4724: goto -4190 -> 534
    //   4727: aload 14
    //   4729: invokevirtual 916	java/lang/Integer:intValue	()I
    //   4732: ifge +20 -> 4752
    //   4735: aload 14
    //   4737: invokevirtual 916	java/lang/Integer:intValue	()I
    //   4740: sipush 30000
    //   4743: isub
    //   4744: invokestatic 166	com/tencent/turingfd/sdk/xq/public:c	(I)Lcom/tencent/turingfd/sdk/xq/public;
    //   4747: astore 12
    //   4749: goto -4215 -> 534
    //   4752: aload 15
    //   4754: bipush 101
    //   4756: ldc 193
    //   4758: invokestatic 630	com/tencent/turingfd/sdk/xq/for:a	(Landroid/util/SparseArray;ILjava/lang/Class;)Ljava/lang/Object;
    //   4761: checkcast 193	java/lang/String
    //   4764: astore 13
    //   4766: aload 13
    //   4768: astore 12
    //   4770: aload 13
    //   4772: ifnonnull +8 -> 4780
    //   4775: ldc_w 443
    //   4778: astore 12
    //   4780: aload 12
    //   4782: invokestatic 111	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4785: ifeq +20 -> 4805
    //   4788: aload 14
    //   4790: invokevirtual 916	java/lang/Integer:intValue	()I
    //   4793: sipush 10010
    //   4796: isub
    //   4797: invokestatic 166	com/tencent/turingfd/sdk/xq/public:c	(I)Lcom/tencent/turingfd/sdk/xq/public;
    //   4800: astore 12
    //   4802: goto -4268 -> 534
    //   4805: aload 15
    //   4807: bipush 104
    //   4809: ldc 193
    //   4811: invokestatic 630	com/tencent/turingfd/sdk/xq/for:a	(Landroid/util/SparseArray;ILjava/lang/Class;)Ljava/lang/Object;
    //   4814: checkcast 193	java/lang/String
    //   4817: astore 13
    //   4819: aload 13
    //   4821: ifnonnull +232 -> 5053
    //   4824: ldc_w 443
    //   4827: astore 13
    //   4829: aload 15
    //   4831: bipush 105
    //   4833: ldc 193
    //   4835: invokestatic 630	com/tencent/turingfd/sdk/xq/for:a	(Landroid/util/SparseArray;ILjava/lang/Class;)Ljava/lang/Object;
    //   4838: checkcast 193	java/lang/String
    //   4841: astore 14
    //   4843: aload 14
    //   4845: ifnonnull +205 -> 5050
    //   4848: ldc_w 443
    //   4851: astore 14
    //   4853: aload 15
    //   4855: invokestatic 919	com/tencent/turingfd/sdk/xq/for:b	(Landroid/util/SparseArray;)Ljava/lang/String;
    //   4858: astore 17
    //   4860: aload 15
    //   4862: bipush 107
    //   4864: ldc_w 731
    //   4867: invokestatic 630	com/tencent/turingfd/sdk/xq/for:a	(Landroid/util/SparseArray;ILjava/lang/Class;)Ljava/lang/Object;
    //   4870: checkcast 731	java/lang/Integer
    //   4873: astore 16
    //   4875: aload 16
    //   4877: ifnull +18 -> 4895
    //   4880: aload 16
    //   4882: astore 15
    //   4884: aload 16
    //   4886: invokevirtual 916	java/lang/Integer:intValue	()I
    //   4889: sipush 3600
    //   4892: if_icmpge +11 -> 4903
    //   4895: sipush 3600
    //   4898: invokestatic 922	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   4901: astore 15
    //   4903: invokestatic 117	java/lang/System:currentTimeMillis	()J
    //   4906: ldc2_w 118
    //   4909: ldiv
    //   4910: lstore 8
    //   4912: aload 15
    //   4914: invokevirtual 916	java/lang/Integer:intValue	()I
    //   4917: i2l
    //   4918: lstore 10
    //   4920: iconst_0
    //   4921: invokestatic 926	com/tencent/turingfd/sdk/xq/public:create	(I)Lcom/tencent/turingfd/sdk/xq/public$do;
    //   4924: astore 16
    //   4926: aload 16
    //   4928: lload 8
    //   4930: lload 10
    //   4932: ladd
    //   4933: putfield 929	com/tencent/turingfd/sdk/xq/public$do:Qb	J
    //   4936: aload 16
    //   4938: aload 12
    //   4940: putfield 930	com/tencent/turingfd/sdk/xq/public$do:Pb	Ljava/lang/String;
    //   4943: aload 16
    //   4945: aload 13
    //   4947: putfield 933	com/tencent/turingfd/sdk/xq/public$do:Tb	Ljava/lang/String;
    //   4950: aload 16
    //   4952: aload 14
    //   4954: putfield 936	com/tencent/turingfd/sdk/xq/public$do:Ub	Ljava/lang/String;
    //   4957: aload 16
    //   4959: aload 17
    //   4961: putfield 939	com/tencent/turingfd/sdk/xq/public$do:Vb	Ljava/lang/String;
    //   4964: aload 16
    //   4966: invokevirtual 943	com/tencent/turingfd/sdk/xq/public$do:build	()Lcom/tencent/turingfd/sdk/xq/public;
    //   4969: astore 12
    //   4971: aload_0
    //   4972: getfield 124	com/tencent/turingfd/sdk/xq/switch:dc	Lcom/tencent/turingfd/sdk/xq/extends;
    //   4975: aload_1
    //   4976: aload 12
    //   4978: invokevirtual 945	com/tencent/turingfd/sdk/xq/extends:b	(Landroid/content/Context;Lcom/tencent/turingfd/sdk/xq/public;)V
    //   4981: aload_0
    //   4982: getfield 124	com/tencent/turingfd/sdk/xq/switch:dc	Lcom/tencent/turingfd/sdk/xq/extends;
    //   4985: aload_1
    //   4986: aload 15
    //   4988: invokevirtual 916	java/lang/Integer:intValue	()I
    //   4991: i2l
    //   4992: invokevirtual 947	com/tencent/turingfd/sdk/xq/extends:d	(Landroid/content/Context;J)V
    //   4995: goto -4461 -> 534
    //   4998: astore 12
    //   5000: sipush -10007
    //   5003: invokestatic 166	com/tencent/turingfd/sdk/xq/public:c	(I)Lcom/tencent/turingfd/sdk/xq/public;
    //   5006: astore 12
    //   5008: goto -4474 -> 534
    //   5011: new 949	java/lang/IllegalArgumentException
    //   5014: dup
    //   5015: ldc_w 443
    //   5018: invokespecial 950	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   5021: athrow
    //   5022: astore 13
    //   5024: goto -3144 -> 1880
    //   5027: astore 13
    //   5029: aload 12
    //   5031: astore 13
    //   5033: goto -2858 -> 2175
    //   5036: astore_1
    //   5037: goto -2879 -> 2158
    //   5040: astore 12
    //   5042: goto -2899 -> 2143
    //   5045: astore 12
    //   5047: goto -3993 -> 1054
    //   5050: goto -197 -> 4853
    //   5053: goto -224 -> 4829
    //   5056: iload 5
    //   5058: iconst_1
    //   5059: iadd
    //   5060: istore 5
    //   5062: goto -2048 -> 3014
    //   5065: iconst_0
    //   5066: istore 6
    //   5068: goto -1783 -> 3285
    //   5071: iconst_0
    //   5072: istore 6
    //   5074: goto -1842 -> 3232
    //   5077: goto -4143 -> 934
    //   5080: iconst_0
    //   5081: istore 5
    //   5083: goto -541 -> 4542
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	5086	0	this	switch
    //   0	5086	1	paramContext	Context
    //   0	5086	2	paramBoolean1	boolean
    //   0	5086	3	paramBoolean2	boolean
    //   0	5086	4	paramBoolean3	boolean
    //   17	5065	5	i	int
    //   85	4988	6	j	int
    //   1977	628	7	k	int
    //   219	4710	8	l1	long
    //   257	4674	10	l2	long
    //   9	35	12	localObject1	Object
    //   67	11	12	localThrowable1	java.lang.Throwable
    //   82	1940	12	localObject2	Object
    //   2026	1	12	localThrowable2	java.lang.Throwable
    //   2037	127	12	localObject3	Object
    //   2170	1	12	localThrowable3	java.lang.Throwable
    //   2177	46	12	localObject4	Object
    //   2236	1	12	localThrowable4	java.lang.Throwable
    //   2239	1336	12	localObject5	Object
    //   3579	1	12	localThrowable5	java.lang.Throwable
    //   3584	746	12	localObject6	Object
    //   4334	6	12	localThrowable6	java.lang.Throwable
    //   4350	123	12	localObject7	Object
    //   4477	1	12	localThrowable7	java.lang.Throwable
    //   4485	492	12	localObject8	Object
    //   4998	1	12	localThrowable8	java.lang.Throwable
    //   5006	24	12	localpublic1	public
    //   5040	1	12	localThrowable9	java.lang.Throwable
    //   5045	1	12	localThrowable10	java.lang.Throwable
    //   273	457	13	localObject9	Object
    //   879	1	13	localIOException	java.io.IOException
    //   886	1470	13	localObject10	Object
    //   2420	1	13	localThrowable11	java.lang.Throwable
    //   2430	1	13	localThrowable12	java.lang.Throwable
    //   2447	1796	13	localObject11	Object
    //   4259	3	13	localThrowable13	java.lang.Throwable
    //   4266	328	13	localObject12	Object
    //   4610	3	13	localThrowable14	java.lang.Throwable
    //   4617	329	13	str1	java.lang.String
    //   5022	1	13	localThrowable15	java.lang.Throwable
    //   5027	1	13	localThrowable16	java.lang.Throwable
    //   5031	1	13	localpublic2	public
    //   712	1913	14	localObject13	Object
    //   2635	13	14	localException	java.lang.Exception
    //   2662	2291	14	localObject14	Object
    //   557	4430	15	localObject15	Object
    //   739	4226	16	localObject16	Object
    //   2524	2436	17	localObject17	Object
    //   2702	1345	18	localObject18	Object
    //   2712	1288	19	localObject19	Object
    //   2734	1109	20	localObject20	Object
    //   3214	571	21	str2	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   0	11	67	java/lang/Throwable
    //   31	38	67	java/lang/Throwable
    //   43	50	67	java/lang/Throwable
    //   680	698	879	java/io/IOException
    //   698	719	879	java/io/IOException
    //   729	741	879	java/io/IOException
    //   746	756	879	java/io/IOException
    //   1082	1088	2026	java/lang/Throwable
    //   1088	1099	2026	java/lang/Throwable
    //   2062	2080	2154	finally
    //   2062	2080	2170	java/lang/Throwable
    //   1200	1209	2236	java/lang/Throwable
    //   2344	2355	2420	java/lang/Throwable
    //   2355	2367	2420	java/lang/Throwable
    //   1251	1268	2430	java/lang/Throwable
    //   2585	2593	2635	java/lang/Exception
    //   2607	2617	2635	java/lang/Exception
    //   2622	2632	2635	java/lang/Exception
    //   3442	3460	3579	java/lang/Throwable
    //   1602	1616	4259	java/lang/Throwable
    //   1621	1644	4259	java/lang/Throwable
    //   4207	4216	4259	java/lang/Throwable
    //   4222	4242	4259	java/lang/Throwable
    //   1730	1742	4334	java/lang/Throwable
    //   4418	4422	4477	java/lang/Throwable
    //   4429	4461	4477	java/lang/Throwable
    //   4464	4474	4477	java/lang/Throwable
    //   4490	4504	4610	java/lang/Throwable
    //   4509	4532	4610	java/lang/Throwable
    //   4561	4570	4610	java/lang/Throwable
    //   4573	4593	4610	java/lang/Throwable
    //   4663	4674	4998	java/lang/Throwable
    //   1866	1876	5022	java/lang/Throwable
    //   2080	2087	5027	java/lang/Throwable
    //   2080	2087	5036	finally
    //   2118	2124	5040	java/lang/Throwable
    //   2124	2135	5040	java/lang/Throwable
    //   1026	1050	5045	java/lang/Throwable
    //   1947	1957	5045	java/lang/Throwable
    //   1962	1979	5045	java/lang/Throwable
    //   1989	2000	5045	java/lang/Throwable
  }
  
  public final public a(public parampublic, Context paramContext, boolean paramBoolean)
  {
    synchronized (this.ec)
    {
      ??? = l(paramContext);
      if ((??? != parampublic) && (a((public)???) == 1)) {
        return ???;
      }
      synchronized (this.gc)
      {
        if (!((Boolean)this.gc.get()).booleanValue())
        {
          this.gc.set(Boolean.valueOf(true));
          this.bc.post(new static(this, paramContext, paramBoolean));
        }
      }
    }
    try
    {
      this.gc.wait(this.ac.getTimeout());
      label107:
      paramContext = l(paramContext);
      if (paramContext != parampublic)
      {
        return paramContext;
        parampublic = finally;
        throw parampublic;
      }
      parampublic = public.c(-10004);
      return parampublic;
      parampublic = finally;
      throw parampublic;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label107;
    }
  }
  
  public final void a(Context paramContext, public parampublic)
  {
    long l;
    if (parampublic.Rb == -30015)
    {
      this.dc.f(paramContext, System.currentTimeMillis());
      l = this.dc.p(paramContext);
      if (parampublic.Rb >= 0) {
        break label112;
      }
      this.dc.e(paramContext, l + 1L);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.dc.t(paramContext))) {
        this.dc.d(paramContext, "");
      }
      this.dc.a(paramContext, parampublic.Rb);
      return;
      if (this.dc.v(paramContext) == 0L) {
        break;
      }
      this.dc.f(paramContext, 0L);
      break;
      label112:
      if (l != 0L) {
        this.dc.e(paramContext, 0L);
      }
    }
  }
  
  public void a(case paramcase)
  {
    this.ac = paramcase;
    if (this.cc) {
      return;
    }
    this.cc = true;
    for.f(paramcase.getContext());
    HandlerThread localHandlerThread = new HandlerThread("TuringFdCore");
    localHandlerThread.start();
    this.bc = new switch.do(this, localHandlerThread.getLooper(), paramcase.getContext());
    this.dc = new extends(this.bc);
    paramcase = paramcase.getContext();
    if (!volatile.qc.containsKey(volatile.sc)) {}
    for (;;)
    {
      new return(this).start();
      return;
      new strictfp((volatile.do)volatile.qc.get(volatile.sc), paramcase).start();
    }
  }
  
  /* Error */
  public final void a(public parampublic, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 63	com/tencent/turingfd/sdk/xq/switch:fc	Ljava/util/concurrent/atomic/AtomicReference;
    //   4: astore_3
    //   5: aload_3
    //   6: monitorenter
    //   7: aload_1
    //   8: ifnonnull +6 -> 14
    //   11: aload_3
    //   12: monitorexit
    //   13: return
    //   14: iload_2
    //   15: ifne +18 -> 33
    //   18: aload_1
    //   19: getfield 101	com/tencent/turingfd/sdk/xq/public:Rb	I
    //   22: ifeq +11 -> 33
    //   25: aload_3
    //   26: monitorexit
    //   27: return
    //   28: astore_1
    //   29: aload_3
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    //   33: aload_0
    //   34: getfield 63	com/tencent/turingfd/sdk/xq/switch:fc	Ljava/util/concurrent/atomic/AtomicReference;
    //   37: aload_1
    //   38: invokevirtual 965	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
    //   41: aload_3
    //   42: monitorexit
    //   43: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	switch
    //   0	44	1	parampublic	public
    //   0	44	2	paramBoolean	boolean
    //   4	38	3	localAtomicReference	AtomicReference
    // Exception table:
    //   from	to	target	type
    //   11	13	28	finally
    //   18	27	28	finally
    //   29	31	28	finally
    //   33	43	28	finally
  }
  
  public final void b(Context arg1, boolean paramBoolean)
  {
    boolean bool = this.dc.q(???);
    int i = 0;
    for (;;)
    {
      public localpublic;
      if (i < this.ac.j())
      {
        localpublic = a(???, paramBoolean, bool, false);
        a(localpublic, true);
        if (localpublic.Rb != 0) {}
      }
      else
      {
        label49:
        if (bool) {
          this.dc.c(???, false);
        }
      }
      synchronized (this.gc)
      {
        this.gc.set(Boolean.valueOf(false));
        this.gc.notifyAll();
        return;
        if (localpublic.Rb == -30014) {
          break label49;
        }
        i += 1;
      }
    }
  }
  
  public final public l(Context paramContext)
  {
    synchronized (this.fc)
    {
      public localpublic2 = (public)this.fc.get();
      public localpublic1 = localpublic2;
      if (localpublic2 == null)
      {
        localpublic1 = this.dc.w(paramContext);
        this.fc.set(localpublic1);
      }
      return localpublic1;
    }
  }
  
  public final public m(Context paramContext)
  {
    public localpublic = l(paramContext);
    int i = a(localpublic);
    if (i == 1) {}
    do
    {
      return localpublic;
      if (i == 2)
      {
        if (Looper.myLooper() == Looper.getMainLooper())
        {
          r();
          return public.c(-10008);
        }
        return a(localpublic, paramContext, false);
      }
    } while (i != 3);
    r();
    return localpublic;
  }
  
  public final void r()
  {
    synchronized (this.gc)
    {
      if (((Boolean)this.gc.get()).booleanValue()) {
        return;
      }
      this.gc.set(Boolean.valueOf(true));
      this.bc.sendEmptyMessage(2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.switch
 * JD-Core Version:    0.7.0.1
 */