package com.tencent.mobileqq.magicface.model;

class MagicfaceXBigDecoder$1
  implements Runnable
{
  MagicfaceXBigDecoder$1(MagicfaceXBigDecoder paramMagicfaceXBigDecoder) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: lconst_0
    //   3: lstore 5
    //   5: aload_0
    //   6: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   9: getfield 27	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:f	Z
    //   12: ifeq +580 -> 592
    //   15: invokestatic 33	java/lang/System:currentTimeMillis	()J
    //   18: lstore_3
    //   19: aload_0
    //   20: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   23: aload_0
    //   24: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   27: getfield 37	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:h	[B
    //   30: aload_0
    //   31: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   34: getfield 41	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:l	I
    //   37: invokevirtual 45	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:a	([BI)I
    //   40: istore_2
    //   41: aload_0
    //   42: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   45: iload_2
    //   46: aload_0
    //   47: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   50: getfield 41	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:l	I
    //   53: isub
    //   54: putfield 48	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:k	I
    //   57: aload_0
    //   58: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   61: getfield 48	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:k	I
    //   64: ifgt +4 -> 68
    //   67: return
    //   68: aload_0
    //   69: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   72: aload_0
    //   73: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   76: getfield 48	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:k	I
    //   79: aload_0
    //   80: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   83: getfield 41	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:l	I
    //   86: aload_0
    //   87: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   90: getfield 37	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:h	[B
    //   93: invokevirtual 51	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:a	(II[B)V
    //   96: aload_0
    //   97: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   100: iload_2
    //   101: putfield 41	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:l	I
    //   104: invokestatic 33	java/lang/System:currentTimeMillis	()J
    //   107: lstore 7
    //   109: aload_0
    //   110: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   113: getfield 55	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:g	Lcom/tencent/mobileqq/magicface/DecoderUtil;
    //   116: aload_0
    //   117: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   120: getfield 58	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:i	[B
    //   123: aload_0
    //   124: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   127: getfield 48	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:k	I
    //   130: aload_0
    //   131: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   134: getfield 61	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:j	[B
    //   137: invokevirtual 67	com/tencent/mobileqq/magicface/DecoderUtil:decodeVideoDecoder	([BI[B)I
    //   140: pop
    //   141: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   144: ifeq +64 -> 208
    //   147: new 75	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   154: astore 10
    //   156: aload 10
    //   158: ldc 78
    //   160: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: aload 10
    //   166: invokestatic 33	java/lang/System:currentTimeMillis	()J
    //   169: lload 7
    //   171: lsub
    //   172: invokevirtual 85	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: aload 10
    //   178: ldc 87
    //   180: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload 10
    //   186: aload_0
    //   187: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   190: getfield 48	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:k	I
    //   193: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: ldc 92
    //   199: iconst_2
    //   200: aload 10
    //   202: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: invokestatic 100	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   208: aload_0
    //   209: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   212: getfield 103	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:m	I
    //   215: iconst_m1
    //   216: if_icmpne +61 -> 277
    //   219: aload_0
    //   220: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   223: aload_0
    //   224: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   227: getfield 55	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:g	Lcom/tencent/mobileqq/magicface/DecoderUtil;
    //   230: invokevirtual 107	com/tencent/mobileqq/magicface/DecoderUtil:getWidthVideoDecoder	()I
    //   233: putfield 103	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:m	I
    //   236: aload_0
    //   237: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   240: aload_0
    //   241: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   244: getfield 55	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:g	Lcom/tencent/mobileqq/magicface/DecoderUtil;
    //   247: invokevirtual 110	com/tencent/mobileqq/magicface/DecoderUtil:getHeightVideoDecoder	()I
    //   250: putfield 113	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:n	I
    //   253: aload_0
    //   254: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   257: aload_0
    //   258: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   261: getfield 113	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:n	I
    //   264: aload_0
    //   265: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   268: getfield 103	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:m	I
    //   271: imul
    //   272: newarray int
    //   274: putfield 117	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:v	[I
    //   277: aload_0
    //   278: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   281: getfield 121	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:w	Ljava/lang/Object;
    //   284: astore 10
    //   286: aload 10
    //   288: monitorenter
    //   289: aload_0
    //   290: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   293: getfield 124	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:y	Z
    //   296: istore 9
    //   298: iload 9
    //   300: ifne +13 -> 313
    //   303: aload_0
    //   304: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   307: getfield 121	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:w	Ljava/lang/Object;
    //   310: invokevirtual 127	java/lang/Object:wait	()V
    //   313: aload 10
    //   315: monitorexit
    //   316: aload_0
    //   317: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   320: aload_0
    //   321: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   324: getfield 61	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:j	[B
    //   327: aload_0
    //   328: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   331: getfield 130	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:q	[B
    //   334: invokevirtual 133	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:a	([B[B)[I
    //   337: astore 10
    //   339: aload_0
    //   340: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   343: getfield 137	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:c	Lcom/tencent/mobileqq/magicface/model/MagicfaceDecoder$MagicfaceRenderListener;
    //   346: ifnull +31 -> 377
    //   349: aload_0
    //   350: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   353: getfield 137	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:c	Lcom/tencent/mobileqq/magicface/model/MagicfaceDecoder$MagicfaceRenderListener;
    //   356: aload 10
    //   358: aload_0
    //   359: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   362: getfield 103	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:m	I
    //   365: aload_0
    //   366: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   369: getfield 113	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:n	I
    //   372: invokeinterface 142 4 0
    //   377: invokestatic 33	java/lang/System:currentTimeMillis	()J
    //   380: lload_3
    //   381: lsub
    //   382: lstore 7
    //   384: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   387: ifeq +39 -> 426
    //   390: new 75	java/lang/StringBuilder
    //   393: dup
    //   394: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   397: astore 10
    //   399: aload 10
    //   401: ldc 144
    //   403: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: pop
    //   407: aload 10
    //   409: lload 7
    //   411: invokevirtual 85	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   414: pop
    //   415: ldc 92
    //   417: iconst_2
    //   418: aload 10
    //   420: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   423: invokestatic 100	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   426: lload 7
    //   428: aload_0
    //   429: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   432: getfield 147	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:e	I
    //   435: i2l
    //   436: lcmp
    //   437: ifge +62 -> 499
    //   440: lload 5
    //   442: lconst_0
    //   443: lcmp
    //   444: ifle +35 -> 479
    //   447: aload_0
    //   448: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   451: getfield 147	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:e	I
    //   454: i2l
    //   455: lload 7
    //   457: lsub
    //   458: lstore_3
    //   459: lload_3
    //   460: lload 5
    //   462: lcmp
    //   463: ifle +152 -> 615
    //   466: lload_3
    //   467: lload 5
    //   469: lsub
    //   470: invokestatic 153	java/lang/Thread:sleep	(J)V
    //   473: lload 5
    //   475: lstore_3
    //   476: goto +47 -> 523
    //   479: aload_0
    //   480: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   483: getfield 147	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:e	I
    //   486: i2l
    //   487: lload 7
    //   489: lsub
    //   490: invokestatic 153	java/lang/Thread:sleep	(J)V
    //   493: lload 5
    //   495: lstore_3
    //   496: goto +27 -> 523
    //   499: lload 5
    //   501: lstore_3
    //   502: iload_1
    //   503: ifne +20 -> 523
    //   506: aload_0
    //   507: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   510: getfield 147	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:e	I
    //   513: istore_1
    //   514: lload 5
    //   516: lload 7
    //   518: iload_1
    //   519: i2l
    //   520: lsub
    //   521: ladd
    //   522: lstore_3
    //   523: iconst_0
    //   524: istore_1
    //   525: aload_0
    //   526: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   529: getfield 156	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:x	Ljava/lang/Object;
    //   532: astore 10
    //   534: aload 10
    //   536: monitorenter
    //   537: aload_0
    //   538: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   541: getfield 156	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:x	Ljava/lang/Object;
    //   544: invokevirtual 159	java/lang/Object:notify	()V
    //   547: aload 10
    //   549: monitorexit
    //   550: lload_3
    //   551: lstore 5
    //   553: goto -548 -> 5
    //   556: astore 11
    //   558: aload 10
    //   560: monitorexit
    //   561: aload 11
    //   563: athrow
    //   564: astore 11
    //   566: aload 10
    //   568: monitorexit
    //   569: aload 11
    //   571: athrow
    //   572: astore 10
    //   574: goto +19 -> 593
    //   577: astore 10
    //   579: aload 10
    //   581: invokevirtual 162	java/lang/OutOfMemoryError:printStackTrace	()V
    //   584: return
    //   585: astore 10
    //   587: aload 10
    //   589: invokevirtual 163	java/lang/Exception:printStackTrace	()V
    //   592: return
    //   593: goto +6 -> 599
    //   596: aload 10
    //   598: athrow
    //   599: goto -3 -> 596
    //   602: astore 11
    //   604: goto -291 -> 313
    //   607: astore 10
    //   609: lload_3
    //   610: lstore 5
    //   612: goto -607 -> 5
    //   615: lload 5
    //   617: lload_3
    //   618: lsub
    //   619: lstore_3
    //   620: goto -97 -> 523
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	623	0	this	1
    //   1	524	1	i	int
    //   40	61	2	j	int
    //   18	602	3	l1	long
    //   3	613	5	l2	long
    //   107	410	7	l3	long
    //   296	3	9	bool	boolean
    //   572	1	10	localObject2	Object
    //   577	3	10	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   585	12	10	localException1	java.lang.Exception
    //   607	1	10	localException2	java.lang.Exception
    //   556	6	11	localObject3	Object
    //   564	6	11	localObject4	Object
    //   602	1	11	localException3	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   537	550	556	finally
    //   558	561	556	finally
    //   289	298	564	finally
    //   303	313	564	finally
    //   313	316	564	finally
    //   566	569	564	finally
    //   5	67	572	finally
    //   68	208	572	finally
    //   208	277	572	finally
    //   277	289	572	finally
    //   316	377	572	finally
    //   377	426	572	finally
    //   426	440	572	finally
    //   447	459	572	finally
    //   466	473	572	finally
    //   479	493	572	finally
    //   506	514	572	finally
    //   525	537	572	finally
    //   561	564	572	finally
    //   569	572	572	finally
    //   579	584	572	finally
    //   587	592	572	finally
    //   5	67	577	java/lang/OutOfMemoryError
    //   68	208	577	java/lang/OutOfMemoryError
    //   208	277	577	java/lang/OutOfMemoryError
    //   277	289	577	java/lang/OutOfMemoryError
    //   316	377	577	java/lang/OutOfMemoryError
    //   377	426	577	java/lang/OutOfMemoryError
    //   426	440	577	java/lang/OutOfMemoryError
    //   447	459	577	java/lang/OutOfMemoryError
    //   466	473	577	java/lang/OutOfMemoryError
    //   479	493	577	java/lang/OutOfMemoryError
    //   506	514	577	java/lang/OutOfMemoryError
    //   525	537	577	java/lang/OutOfMemoryError
    //   561	564	577	java/lang/OutOfMemoryError
    //   569	572	577	java/lang/OutOfMemoryError
    //   5	67	585	java/lang/Exception
    //   68	208	585	java/lang/Exception
    //   208	277	585	java/lang/Exception
    //   277	289	585	java/lang/Exception
    //   316	377	585	java/lang/Exception
    //   377	426	585	java/lang/Exception
    //   426	440	585	java/lang/Exception
    //   447	459	585	java/lang/Exception
    //   466	473	585	java/lang/Exception
    //   479	493	585	java/lang/Exception
    //   506	514	585	java/lang/Exception
    //   569	572	585	java/lang/Exception
    //   303	313	602	java/lang/Exception
    //   525	537	607	java/lang/Exception
    //   561	564	607	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.model.MagicfaceXBigDecoder.1
 * JD-Core Version:    0.7.0.1
 */