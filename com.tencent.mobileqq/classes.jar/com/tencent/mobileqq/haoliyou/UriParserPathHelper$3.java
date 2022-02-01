package com.tencent.mobileqq.haoliyou;

import android.net.Uri;
import java.io.InputStream;

class UriParserPathHelper$3
  implements Runnable
{
  UriParserPathHelper$3(UriParserPathHelper paramUriParserPathHelper, String paramString, InputStream paramInputStream, long paramLong, Uri paramUri) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 15
    //   3: new 37	java/io/File
    //   6: dup
    //   7: aload_0
    //   8: getfield 22	com/tencent/mobileqq/haoliyou/UriParserPathHelper$3:a	Ljava/lang/String;
    //   11: invokespecial 40	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: astore 13
    //   16: aload 13
    //   18: invokevirtual 44	java/io/File:exists	()Z
    //   21: istore 6
    //   23: iload 6
    //   25: ifne +56 -> 81
    //   28: aload 13
    //   30: invokevirtual 47	java/io/File:createNewFile	()Z
    //   33: ifne +48 -> 81
    //   36: aload_0
    //   37: getfield 20	com/tencent/mobileqq/haoliyou/UriParserPathHelper$3:this$0	Lcom/tencent/mobileqq/haoliyou/UriParserPathHelper;
    //   40: invokestatic 52	com/tencent/mobileqq/haoliyou/UriParserPathHelper:c	(Lcom/tencent/mobileqq/haoliyou/UriParserPathHelper;)Lmqq/os/MqqHandler;
    //   43: iconst_1
    //   44: invokevirtual 58	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   47: pop
    //   48: aload_0
    //   49: getfield 20	com/tencent/mobileqq/haoliyou/UriParserPathHelper$3:this$0	Lcom/tencent/mobileqq/haoliyou/UriParserPathHelper;
    //   52: invokestatic 61	com/tencent/mobileqq/haoliyou/UriParserPathHelper:d	(Lcom/tencent/mobileqq/haoliyou/UriParserPathHelper;)Ljava/util/concurrent/atomic/AtomicInteger;
    //   55: invokevirtual 67	java/util/concurrent/atomic/AtomicInteger:decrementAndGet	()I
    //   58: pop
    //   59: aload_0
    //   60: getfield 24	com/tencent/mobileqq/haoliyou/UriParserPathHelper$3:b	Ljava/io/InputStream;
    //   63: invokestatic 73	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   66: aconst_null
    //   67: invokestatic 76	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   70: return
    //   71: astore 13
    //   73: goto +468 -> 541
    //   76: astore 16
    //   78: goto +474 -> 552
    //   81: new 78	java/io/FileOutputStream
    //   84: dup
    //   85: aload_0
    //   86: getfield 22	com/tencent/mobileqq/haoliyou/UriParserPathHelper$3:a	Ljava/lang/String;
    //   89: invokespecial 79	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   92: astore 14
    //   94: invokestatic 85	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   97: sipush 8192
    //   100: invokevirtual 89	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   103: astore 16
    //   105: lconst_0
    //   106: lstore 7
    //   108: lconst_0
    //   109: lstore 9
    //   111: aload_0
    //   112: getfield 24	com/tencent/mobileqq/haoliyou/UriParserPathHelper$3:b	Ljava/io/InputStream;
    //   115: aload 16
    //   117: invokevirtual 95	java/io/InputStream:read	([B)I
    //   120: istore 5
    //   122: iload 5
    //   124: iconst_m1
    //   125: if_icmpeq +142 -> 267
    //   128: aload_0
    //   129: getfield 20	com/tencent/mobileqq/haoliyou/UriParserPathHelper$3:this$0	Lcom/tencent/mobileqq/haoliyou/UriParserPathHelper;
    //   132: invokevirtual 97	com/tencent/mobileqq/haoliyou/UriParserPathHelper:a	()Z
    //   135: ifeq +132 -> 267
    //   138: iload 5
    //   140: i2l
    //   141: lload 7
    //   143: ladd
    //   144: lstore 7
    //   146: aload 14
    //   148: aload 16
    //   150: iconst_0
    //   151: iload 5
    //   153: invokevirtual 101	java/io/FileOutputStream:write	([BII)V
    //   156: lload 7
    //   158: lload 9
    //   160: lsub
    //   161: l2d
    //   162: dstore_1
    //   163: aload_0
    //   164: getfield 26	com/tencent/mobileqq/haoliyou/UriParserPathHelper$3:c	J
    //   167: lstore 11
    //   169: lload 11
    //   171: l2d
    //   172: dstore_3
    //   173: dload_1
    //   174: invokestatic 107	java/lang/Double:isNaN	(D)Z
    //   177: pop
    //   178: dload_3
    //   179: invokestatic 107	java/lang/Double:isNaN	(D)Z
    //   182: pop
    //   183: dload_1
    //   184: dload_3
    //   185: ddiv
    //   186: ldc2_w 108
    //   189: dcmpl
    //   190: ifle +491 -> 681
    //   193: aload_0
    //   194: getfield 20	com/tencent/mobileqq/haoliyou/UriParserPathHelper$3:this$0	Lcom/tencent/mobileqq/haoliyou/UriParserPathHelper;
    //   197: invokestatic 52	com/tencent/mobileqq/haoliyou/UriParserPathHelper:c	(Lcom/tencent/mobileqq/haoliyou/UriParserPathHelper;)Lmqq/os/MqqHandler;
    //   200: astore 15
    //   202: aload_0
    //   203: getfield 20	com/tencent/mobileqq/haoliyou/UriParserPathHelper$3:this$0	Lcom/tencent/mobileqq/haoliyou/UriParserPathHelper;
    //   206: invokestatic 52	com/tencent/mobileqq/haoliyou/UriParserPathHelper:c	(Lcom/tencent/mobileqq/haoliyou/UriParserPathHelper;)Lmqq/os/MqqHandler;
    //   209: astore 17
    //   211: lload 7
    //   213: l2d
    //   214: dstore_1
    //   215: aload_0
    //   216: getfield 26	com/tencent/mobileqq/haoliyou/UriParserPathHelper$3:c	J
    //   219: lstore 9
    //   221: lload 9
    //   223: l2d
    //   224: dstore_3
    //   225: dload_1
    //   226: invokestatic 107	java/lang/Double:isNaN	(D)Z
    //   229: pop
    //   230: dload_3
    //   231: invokestatic 107	java/lang/Double:isNaN	(D)Z
    //   234: pop
    //   235: dload_1
    //   236: dload_3
    //   237: ddiv
    //   238: ldc2_w 110
    //   241: dmul
    //   242: d2i
    //   243: istore 5
    //   245: aload 15
    //   247: aload 17
    //   249: iconst_3
    //   250: iload 5
    //   252: iconst_0
    //   253: invokevirtual 115	mqq/os/MqqHandler:obtainMessage	(III)Landroid/os/Message;
    //   256: invokevirtual 119	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   259: pop
    //   260: lload 7
    //   262: lstore 9
    //   264: goto +417 -> 681
    //   267: lload 7
    //   269: lconst_0
    //   270: lcmp
    //   271: ifne +63 -> 334
    //   274: aload_0
    //   275: getfield 28	com/tencent/mobileqq/haoliyou/UriParserPathHelper$3:d	Landroid/net/Uri;
    //   278: invokevirtual 125	android/net/Uri:toString	()Ljava/lang/String;
    //   281: ldc 127
    //   283: invokevirtual 133	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   286: ifeq +21 -> 307
    //   289: aload_0
    //   290: getfield 20	com/tencent/mobileqq/haoliyou/UriParserPathHelper$3:this$0	Lcom/tencent/mobileqq/haoliyou/UriParserPathHelper;
    //   293: getfield 136	com/tencent/mobileqq/haoliyou/UriParserPathHelper:a	Landroid/content/Context;
    //   296: ldc 137
    //   298: invokevirtual 143	android/content/Context:getString	(I)Ljava/lang/String;
    //   301: putstatic 145	com/tencent/mobileqq/haoliyou/UriParserPathHelper:b	Ljava/lang/String;
    //   304: goto +18 -> 322
    //   307: aload_0
    //   308: getfield 20	com/tencent/mobileqq/haoliyou/UriParserPathHelper$3:this$0	Lcom/tencent/mobileqq/haoliyou/UriParserPathHelper;
    //   311: getfield 136	com/tencent/mobileqq/haoliyou/UriParserPathHelper:a	Landroid/content/Context;
    //   314: ldc 146
    //   316: invokevirtual 143	android/content/Context:getString	(I)Ljava/lang/String;
    //   319: putstatic 145	com/tencent/mobileqq/haoliyou/UriParserPathHelper:b	Ljava/lang/String;
    //   322: aload_0
    //   323: getfield 20	com/tencent/mobileqq/haoliyou/UriParserPathHelper$3:this$0	Lcom/tencent/mobileqq/haoliyou/UriParserPathHelper;
    //   326: invokestatic 52	com/tencent/mobileqq/haoliyou/UriParserPathHelper:c	(Lcom/tencent/mobileqq/haoliyou/UriParserPathHelper;)Lmqq/os/MqqHandler;
    //   329: iconst_1
    //   330: invokevirtual 58	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   333: pop
    //   334: aload_0
    //   335: getfield 20	com/tencent/mobileqq/haoliyou/UriParserPathHelper$3:this$0	Lcom/tencent/mobileqq/haoliyou/UriParserPathHelper;
    //   338: invokevirtual 97	com/tencent/mobileqq/haoliyou/UriParserPathHelper:a	()Z
    //   341: ifeq +108 -> 449
    //   344: aload_0
    //   345: getfield 20	com/tencent/mobileqq/haoliyou/UriParserPathHelper$3:this$0	Lcom/tencent/mobileqq/haoliyou/UriParserPathHelper;
    //   348: invokestatic 149	com/tencent/mobileqq/haoliyou/UriParserPathHelper:b	(Lcom/tencent/mobileqq/haoliyou/UriParserPathHelper;)Lcom/tencent/mobileqq/haoliyou/UriParserPathHelper$IOnFileCopyFinishListener;
    //   351: ifnull +36 -> 387
    //   354: aload_0
    //   355: getfield 20	com/tencent/mobileqq/haoliyou/UriParserPathHelper$3:this$0	Lcom/tencent/mobileqq/haoliyou/UriParserPathHelper;
    //   358: invokestatic 149	com/tencent/mobileqq/haoliyou/UriParserPathHelper:b	(Lcom/tencent/mobileqq/haoliyou/UriParserPathHelper;)Lcom/tencent/mobileqq/haoliyou/UriParserPathHelper$IOnFileCopyFinishListener;
    //   361: aload 13
    //   363: invokevirtual 152	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   366: aload 13
    //   368: invokevirtual 155	java/io/File:getName	()Ljava/lang/String;
    //   371: lload 7
    //   373: invokeinterface 160 5 0
    //   378: aload_0
    //   379: getfield 20	com/tencent/mobileqq/haoliyou/UriParserPathHelper$3:this$0	Lcom/tencent/mobileqq/haoliyou/UriParserPathHelper;
    //   382: aconst_null
    //   383: invokestatic 163	com/tencent/mobileqq/haoliyou/UriParserPathHelper:a	(Lcom/tencent/mobileqq/haoliyou/UriParserPathHelper;Lcom/tencent/mobileqq/haoliyou/UriParserPathHelper$IOnFileCopyFinishListener;)Lcom/tencent/mobileqq/haoliyou/UriParserPathHelper$IOnFileCopyFinishListener;
    //   386: pop
    //   387: invokestatic 166	com/tencent/mobileqq/haoliyou/UriParserPathHelper:c	()Ljava/util/concurrent/ConcurrentHashMap;
    //   390: aload_0
    //   391: getfield 28	com/tencent/mobileqq/haoliyou/UriParserPathHelper$3:d	Landroid/net/Uri;
    //   394: invokevirtual 125	android/net/Uri:toString	()Ljava/lang/String;
    //   397: aload 13
    //   399: invokevirtual 152	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   402: invokevirtual 172	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   405: pop
    //   406: aload_0
    //   407: getfield 20	com/tencent/mobileqq/haoliyou/UriParserPathHelper$3:this$0	Lcom/tencent/mobileqq/haoliyou/UriParserPathHelper;
    //   410: invokestatic 52	com/tencent/mobileqq/haoliyou/UriParserPathHelper:c	(Lcom/tencent/mobileqq/haoliyou/UriParserPathHelper;)Lmqq/os/MqqHandler;
    //   413: aload_0
    //   414: getfield 20	com/tencent/mobileqq/haoliyou/UriParserPathHelper$3:this$0	Lcom/tencent/mobileqq/haoliyou/UriParserPathHelper;
    //   417: invokestatic 52	com/tencent/mobileqq/haoliyou/UriParserPathHelper:c	(Lcom/tencent/mobileqq/haoliyou/UriParserPathHelper;)Lmqq/os/MqqHandler;
    //   420: iconst_3
    //   421: bipush 100
    //   423: iconst_0
    //   424: invokevirtual 115	mqq/os/MqqHandler:obtainMessage	(III)Landroid/os/Message;
    //   427: invokevirtual 119	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   430: pop
    //   431: aload_0
    //   432: getfield 20	com/tencent/mobileqq/haoliyou/UriParserPathHelper$3:this$0	Lcom/tencent/mobileqq/haoliyou/UriParserPathHelper;
    //   435: invokestatic 52	com/tencent/mobileqq/haoliyou/UriParserPathHelper:c	(Lcom/tencent/mobileqq/haoliyou/UriParserPathHelper;)Lmqq/os/MqqHandler;
    //   438: iconst_2
    //   439: ldc2_w 173
    //   442: invokevirtual 178	mqq/os/MqqHandler:sendEmptyMessageDelayed	(IJ)Z
    //   445: pop
    //   446: goto +14 -> 460
    //   449: aload 14
    //   451: invokestatic 76	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   454: aload 13
    //   456: invokevirtual 181	java/io/File:delete	()Z
    //   459: pop
    //   460: aload 14
    //   462: astore 17
    //   464: aload 16
    //   466: ifnull +132 -> 598
    //   469: invokestatic 85	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   472: aload 16
    //   474: invokevirtual 185	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   477: aload 14
    //   479: astore 17
    //   481: goto +117 -> 598
    //   484: astore 13
    //   486: aload 14
    //   488: astore 15
    //   490: aload 16
    //   492: astore 14
    //   494: goto +142 -> 636
    //   497: astore 13
    //   499: aload 16
    //   501: astore 15
    //   503: aload 13
    //   505: astore 16
    //   507: aload 14
    //   509: astore 13
    //   511: goto +44 -> 555
    //   514: astore 13
    //   516: aconst_null
    //   517: astore 16
    //   519: aload 14
    //   521: astore 15
    //   523: aload 16
    //   525: astore 14
    //   527: goto +109 -> 636
    //   530: astore 16
    //   532: aload 14
    //   534: astore 13
    //   536: goto +19 -> 555
    //   539: astore 13
    //   541: aconst_null
    //   542: astore 15
    //   544: aconst_null
    //   545: astore 14
    //   547: goto +89 -> 636
    //   550: astore 16
    //   552: aconst_null
    //   553: astore 13
    //   555: ldc 187
    //   557: iconst_1
    //   558: ldc 189
    //   560: aload 16
    //   562: invokestatic 195	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   565: aload_0
    //   566: getfield 20	com/tencent/mobileqq/haoliyou/UriParserPathHelper$3:this$0	Lcom/tencent/mobileqq/haoliyou/UriParserPathHelper;
    //   569: invokestatic 52	com/tencent/mobileqq/haoliyou/UriParserPathHelper:c	(Lcom/tencent/mobileqq/haoliyou/UriParserPathHelper;)Lmqq/os/MqqHandler;
    //   572: iconst_1
    //   573: invokevirtual 58	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   576: pop
    //   577: aload 13
    //   579: astore 17
    //   581: aload 15
    //   583: ifnull +15 -> 598
    //   586: invokestatic 85	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   589: aload 15
    //   591: invokevirtual 185	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   594: aload 13
    //   596: astore 17
    //   598: aload_0
    //   599: getfield 20	com/tencent/mobileqq/haoliyou/UriParserPathHelper$3:this$0	Lcom/tencent/mobileqq/haoliyou/UriParserPathHelper;
    //   602: invokestatic 61	com/tencent/mobileqq/haoliyou/UriParserPathHelper:d	(Lcom/tencent/mobileqq/haoliyou/UriParserPathHelper;)Ljava/util/concurrent/atomic/AtomicInteger;
    //   605: invokevirtual 67	java/util/concurrent/atomic/AtomicInteger:decrementAndGet	()I
    //   608: pop
    //   609: aload_0
    //   610: getfield 24	com/tencent/mobileqq/haoliyou/UriParserPathHelper$3:b	Ljava/io/InputStream;
    //   613: invokestatic 73	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   616: aload 17
    //   618: invokestatic 76	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   621: return
    //   622: astore 16
    //   624: aload 15
    //   626: astore 14
    //   628: aload 13
    //   630: astore 15
    //   632: aload 16
    //   634: astore 13
    //   636: aload 14
    //   638: ifnull +11 -> 649
    //   641: invokestatic 85	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   644: aload 14
    //   646: invokevirtual 185	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   649: aload_0
    //   650: getfield 20	com/tencent/mobileqq/haoliyou/UriParserPathHelper$3:this$0	Lcom/tencent/mobileqq/haoliyou/UriParserPathHelper;
    //   653: invokestatic 61	com/tencent/mobileqq/haoliyou/UriParserPathHelper:d	(Lcom/tencent/mobileqq/haoliyou/UriParserPathHelper;)Ljava/util/concurrent/atomic/AtomicInteger;
    //   656: invokevirtual 67	java/util/concurrent/atomic/AtomicInteger:decrementAndGet	()I
    //   659: pop
    //   660: aload_0
    //   661: getfield 24	com/tencent/mobileqq/haoliyou/UriParserPathHelper$3:b	Ljava/io/InputStream;
    //   664: invokestatic 73	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   667: aload 15
    //   669: invokestatic 76	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   672: goto +6 -> 678
    //   675: aload 13
    //   677: athrow
    //   678: goto -3 -> 675
    //   681: goto -570 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	684	0	this	3
    //   162	74	1	d1	double
    //   172	65	3	d2	double
    //   120	131	5	i	int
    //   21	3	6	bool	boolean
    //   106	266	7	l1	long
    //   109	154	9	l2	long
    //   167	3	11	l3	long
    //   14	15	13	localFile	java.io.File
    //   71	384	13	localObject1	Object
    //   484	1	13	localObject2	Object
    //   497	7	13	localException1	java.lang.Exception
    //   509	1	13	localObject3	Object
    //   514	1	13	localObject4	Object
    //   534	1	13	localObject5	Object
    //   539	1	13	localObject6	Object
    //   553	123	13	localObject7	Object
    //   92	553	14	localObject8	Object
    //   1	667	15	localObject9	Object
    //   76	1	16	localException2	java.lang.Exception
    //   103	421	16	localObject10	Object
    //   530	1	16	localException3	java.lang.Exception
    //   550	11	16	localException4	java.lang.Exception
    //   622	11	16	localObject11	Object
    //   209	408	17	localObject12	Object
    // Exception table:
    //   from	to	target	type
    //   28	48	71	finally
    //   28	48	76	java/lang/Exception
    //   111	122	484	finally
    //   128	138	484	finally
    //   146	156	484	finally
    //   163	169	484	finally
    //   193	211	484	finally
    //   215	221	484	finally
    //   245	260	484	finally
    //   274	304	484	finally
    //   307	322	484	finally
    //   322	334	484	finally
    //   334	387	484	finally
    //   387	446	484	finally
    //   449	460	484	finally
    //   111	122	497	java/lang/Exception
    //   128	138	497	java/lang/Exception
    //   146	156	497	java/lang/Exception
    //   163	169	497	java/lang/Exception
    //   193	211	497	java/lang/Exception
    //   215	221	497	java/lang/Exception
    //   245	260	497	java/lang/Exception
    //   274	304	497	java/lang/Exception
    //   307	322	497	java/lang/Exception
    //   322	334	497	java/lang/Exception
    //   334	387	497	java/lang/Exception
    //   387	446	497	java/lang/Exception
    //   449	460	497	java/lang/Exception
    //   94	105	514	finally
    //   94	105	530	java/lang/Exception
    //   3	23	539	finally
    //   81	94	539	finally
    //   3	23	550	java/lang/Exception
    //   81	94	550	java/lang/Exception
    //   555	577	622	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.haoliyou.UriParserPathHelper.3
 * JD-Core Version:    0.7.0.1
 */