package com.tencent.mobileqq.msf.core;

class k$d
  implements Runnable
{
  private static final String a = "WorkerThreadMonitor";
  private static final long d = 14400000L;
  private static final int e = 1;
  private static final int f = 2;
  private static final int g = 3;
  private boolean b = false;
  private final k.a c = new k.a(40);
  private long h = 0L;
  private long i = 0L;
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: ldc 52
    //   2: astore 13
    //   4: aload_0
    //   5: getfield 40	com/tencent/mobileqq/msf/core/k$d:c	Lcom/tencent/mobileqq/msf/core/k$a;
    //   8: getstatic 58	com/tencent/mobileqq/msf/core/MsfCore:sCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   11: getfield 62	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ad;
    //   14: getfield 67	com/tencent/mobileqq/msf/core/ad:g	Ljava/util/concurrent/LinkedBlockingDeque;
    //   17: invokevirtual 73	java/util/concurrent/LinkedBlockingDeque:size	()I
    //   20: invokevirtual 76	com/tencent/mobileqq/msf/core/k$a:a	(I)Z
    //   23: istore_3
    //   24: getstatic 58	com/tencent/mobileqq/msf/core/MsfCore:sCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   27: getfield 62	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ad;
    //   30: getfield 67	com/tencent/mobileqq/msf/core/ad:g	Ljava/util/concurrent/LinkedBlockingDeque;
    //   33: invokevirtual 73	java/util/concurrent/LinkedBlockingDeque:size	()I
    //   36: istore_1
    //   37: iload_1
    //   38: i2l
    //   39: lstore 4
    //   41: iload_3
    //   42: ifeq +694 -> 736
    //   45: aload_0
    //   46: getfield 33	com/tencent/mobileqq/msf/core/k$d:b	Z
    //   49: ifne +687 -> 736
    //   52: aload_0
    //   53: iconst_1
    //   54: putfield 33	com/tencent/mobileqq/msf/core/k$d:b	Z
    //   57: aload_0
    //   58: getfield 40	com/tencent/mobileqq/msf/core/k$d:c	Lcom/tencent/mobileqq/msf/core/k$a;
    //   61: invokevirtual 78	com/tencent/mobileqq/msf/core/k$a:a	()V
    //   64: ldc 10
    //   66: iconst_1
    //   67: iconst_2
    //   68: anewarray 4	java/lang/Object
    //   71: dup
    //   72: iconst_0
    //   73: ldc 80
    //   75: aastore
    //   76: dup
    //   77: iconst_1
    //   78: lload 4
    //   80: invokestatic 86	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   83: aastore
    //   84: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   87: ldc 93
    //   89: astore 13
    //   91: iconst_1
    //   92: istore_1
    //   93: goto +3 -> 96
    //   96: aload_0
    //   97: getstatic 58	com/tencent/mobileqq/msf/core/MsfCore:sCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   100: getfield 62	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ad;
    //   103: invokevirtual 96	com/tencent/mobileqq/msf/core/ad:a	()J
    //   106: putfield 42	com/tencent/mobileqq/msf/core/k$d:h	J
    //   109: invokestatic 101	android/os/SystemClock:uptimeMillis	()J
    //   112: aload_0
    //   113: getfield 42	com/tencent/mobileqq/msf/core/k$d:h	J
    //   116: lsub
    //   117: invokestatic 107	java/lang/Math:abs	(J)J
    //   120: lstore 6
    //   122: getstatic 58	com/tencent/mobileqq/msf/core/MsfCore:sCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   125: getfield 62	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ad;
    //   128: invokevirtual 109	com/tencent/mobileqq/msf/core/ad:b	()J
    //   131: lstore 8
    //   133: aload 13
    //   135: astore 12
    //   137: iload_1
    //   138: istore_2
    //   139: lload 6
    //   141: ldc2_w 13
    //   144: lcmp
    //   145: iflt +74 -> 219
    //   148: aload 13
    //   150: astore 12
    //   152: iload_1
    //   153: istore_2
    //   154: aload_0
    //   155: getfield 33	com/tencent/mobileqq/msf/core/k$d:b	Z
    //   158: ifne +61 -> 219
    //   161: aload 13
    //   163: astore 12
    //   165: iload_1
    //   166: istore_2
    //   167: lload 8
    //   169: ldc2_w 110
    //   172: lcmp
    //   173: iflt +46 -> 219
    //   176: aload_0
    //   177: iconst_1
    //   178: putfield 33	com/tencent/mobileqq/msf/core/k$d:b	Z
    //   181: ldc 10
    //   183: iconst_1
    //   184: iconst_2
    //   185: anewarray 4	java/lang/Object
    //   188: dup
    //   189: iconst_0
    //   190: ldc 113
    //   192: aastore
    //   193: dup
    //   194: iconst_1
    //   195: lload 6
    //   197: invokestatic 86	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   200: aastore
    //   201: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   204: getstatic 58	com/tencent/mobileqq/msf/core/MsfCore:sCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   207: getfield 62	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ad;
    //   210: invokevirtual 115	com/tencent/mobileqq/msf/core/ad:c	()V
    //   213: ldc 93
    //   215: astore 12
    //   217: iconst_2
    //   218: istore_2
    //   219: aload_0
    //   220: getstatic 58	com/tencent/mobileqq/msf/core/MsfCore:sCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   223: getfield 62	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ad;
    //   226: getfield 118	com/tencent/mobileqq/msf/core/ad:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   229: invokevirtual 124	com/tencent/mobileqq/msf/core/net/n:l	()Lcom/tencent/mobileqq/msf/core/net/m;
    //   232: invokevirtual 128	com/tencent/mobileqq/msf/core/net/m:f	()J
    //   235: putfield 44	com/tencent/mobileqq/msf/core/k$d:i	J
    //   238: invokestatic 101	android/os/SystemClock:uptimeMillis	()J
    //   241: lstore 10
    //   243: lload 10
    //   245: aload_0
    //   246: getfield 44	com/tencent/mobileqq/msf/core/k$d:i	J
    //   249: lsub
    //   250: invokestatic 107	java/lang/Math:abs	(J)J
    //   253: lstore 10
    //   255: aload 12
    //   257: astore 13
    //   259: iload_2
    //   260: istore_1
    //   261: lload 10
    //   263: ldc2_w 13
    //   266: lcmp
    //   267: iflt +50 -> 317
    //   270: aload 12
    //   272: astore 13
    //   274: iload_2
    //   275: istore_1
    //   276: aload_0
    //   277: getfield 33	com/tencent/mobileqq/msf/core/k$d:b	Z
    //   280: ifne +37 -> 317
    //   283: aload_0
    //   284: iconst_1
    //   285: putfield 33	com/tencent/mobileqq/msf/core/k$d:b	Z
    //   288: ldc 10
    //   290: iconst_1
    //   291: iconst_2
    //   292: anewarray 4	java/lang/Object
    //   295: dup
    //   296: iconst_0
    //   297: ldc 130
    //   299: aastore
    //   300: dup
    //   301: iconst_1
    //   302: lload 10
    //   304: invokestatic 86	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   307: aastore
    //   308: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   311: ldc 132
    //   313: astore 13
    //   315: iconst_3
    //   316: istore_1
    //   317: ldc 10
    //   319: iconst_1
    //   320: bipush 8
    //   322: anewarray 4	java/lang/Object
    //   325: dup
    //   326: iconst_0
    //   327: ldc 134
    //   329: aastore
    //   330: dup
    //   331: iconst_1
    //   332: lload 4
    //   334: invokestatic 86	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   337: aastore
    //   338: dup
    //   339: iconst_2
    //   340: ldc 136
    //   342: aastore
    //   343: dup
    //   344: iconst_3
    //   345: lload 6
    //   347: invokestatic 86	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   350: aastore
    //   351: dup
    //   352: iconst_4
    //   353: ldc 138
    //   355: aastore
    //   356: dup
    //   357: iconst_5
    //   358: lload 10
    //   360: invokestatic 86	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   363: aastore
    //   364: dup
    //   365: bipush 6
    //   367: ldc 140
    //   369: aastore
    //   370: dup
    //   371: bipush 7
    //   373: lload 8
    //   375: invokestatic 86	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   378: aastore
    //   379: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   382: aload_0
    //   383: getfield 33	com/tencent/mobileqq/msf/core/k$d:b	Z
    //   386: ifeq +300 -> 686
    //   389: aload 13
    //   391: invokestatic 146	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getThreadStackString	(Ljava/lang/String;)Ljava/lang/String;
    //   394: astore 14
    //   396: getstatic 58	com/tencent/mobileqq/msf/core/MsfCore:sCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   399: invokevirtual 150	com/tencent/mobileqq/msf/core/MsfCore:getAccountCenter	()Lcom/tencent/mobileqq/msf/core/auth/b;
    //   402: invokevirtual 155	com/tencent/mobileqq/msf/core/auth/b:i	()Ljava/lang/String;
    //   405: astore 12
    //   407: new 157	java/util/HashMap
    //   410: dup
    //   411: invokespecial 158	java/util/HashMap:<init>	()V
    //   414: astore 15
    //   416: aload 15
    //   418: ldc 160
    //   420: aload 13
    //   422: invokevirtual 164	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   425: pop
    //   426: aload 15
    //   428: ldc 166
    //   430: invokestatic 171	java/lang/System:currentTimeMillis	()J
    //   433: invokestatic 176	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   436: invokevirtual 164	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   439: pop
    //   440: aload 12
    //   442: ifnull +299 -> 741
    //   445: goto +3 -> 448
    //   448: aload 15
    //   450: ldc 178
    //   452: aload 12
    //   454: invokevirtual 164	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   457: pop
    //   458: aload 14
    //   460: ifnull +289 -> 749
    //   463: aload 14
    //   465: astore 12
    //   467: goto +3 -> 470
    //   470: aload 15
    //   472: ldc 180
    //   474: aload 12
    //   476: invokevirtual 164	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   479: pop
    //   480: aload 15
    //   482: ldc 182
    //   484: iload_1
    //   485: invokestatic 185	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   488: invokevirtual 164	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   491: pop
    //   492: aload 15
    //   494: ldc 187
    //   496: lload 4
    //   498: invokestatic 176	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   501: invokevirtual 164	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   504: pop
    //   505: aload 15
    //   507: ldc 189
    //   509: lload 6
    //   511: invokestatic 176	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   514: invokevirtual 164	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   517: pop
    //   518: aload 15
    //   520: ldc 191
    //   522: lload 10
    //   524: invokestatic 176	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   527: invokevirtual 164	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   530: pop
    //   531: aload 15
    //   533: ldc 193
    //   535: lload 8
    //   537: invokestatic 176	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   540: invokevirtual 164	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   543: pop
    //   544: invokestatic 199	com/tencent/mobileqq/msf/service/MsfService:getCore	()Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   547: invokevirtual 203	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/d/j;
    //   550: ifnull +21 -> 571
    //   553: invokestatic 199	com/tencent/mobileqq/msf/service/MsfService:getCore	()Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   556: invokevirtual 203	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/d/j;
    //   559: ldc 205
    //   561: iconst_1
    //   562: lconst_0
    //   563: lconst_0
    //   564: aload 15
    //   566: iconst_0
    //   567: iconst_0
    //   568: invokevirtual 210	com/tencent/mobileqq/msf/core/d/j:a	(Ljava/lang/String;ZJJLjava/util/Map;ZZ)V
    //   571: invokestatic 214	java/lang/Math:random	()D
    //   574: ldc2_w 215
    //   577: dcmpg
    //   578: ifgt +179 -> 757
    //   581: iconst_1
    //   582: istore_1
    //   583: goto +3 -> 586
    //   586: iload_1
    //   587: ifeq +87 -> 674
    //   590: new 218	java/lang/StringBuilder
    //   593: dup
    //   594: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   597: astore 12
    //   599: aload 12
    //   601: aload 13
    //   603: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   606: pop
    //   607: aload 12
    //   609: ldc 225
    //   611: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   614: pop
    //   615: new 227	com/tencent/mobileqq/msf/sdk/b/b
    //   618: dup
    //   619: aload 12
    //   621: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   624: invokespecial 233	com/tencent/mobileqq/msf/sdk/b/b:<init>	(Ljava/lang/String;)V
    //   627: astore 12
    //   629: new 218	java/lang/StringBuilder
    //   632: dup
    //   633: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   636: astore 15
    //   638: aload 15
    //   640: aload 13
    //   642: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   645: pop
    //   646: aload 15
    //   648: ldc 235
    //   650: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   653: pop
    //   654: aload 15
    //   656: aload 14
    //   658: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   661: pop
    //   662: aload 12
    //   664: aload 15
    //   666: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   669: aload 14
    //   671: invokestatic 240	com/tencent/mobileqq/msf/sdk/b/a:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   674: ldc2_w 241
    //   677: invokestatic 248	java/lang/Thread:sleep	(J)V
    //   680: invokestatic 253	android/os/Process:myPid	()I
    //   683: invokestatic 256	android/os/Process:killProcess	(I)V
    //   686: invokestatic 259	com/tencent/mobileqq/msf/core/k:c	()V
    //   689: return
    //   690: astore 12
    //   692: goto +32 -> 724
    //   695: astore 12
    //   697: aload 12
    //   699: invokevirtual 262	java/lang/Exception:printStackTrace	()V
    //   702: invokestatic 266	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   705: ifeq -19 -> 686
    //   708: ldc 10
    //   710: iconst_2
    //   711: aload 12
    //   713: invokevirtual 269	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   716: aload 12
    //   718: invokestatic 272	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   721: goto -35 -> 686
    //   724: invokestatic 259	com/tencent/mobileqq/msf/core/k:c	()V
    //   727: goto +6 -> 733
    //   730: aload 12
    //   732: athrow
    //   733: goto -3 -> 730
    //   736: iconst_0
    //   737: istore_1
    //   738: goto -642 -> 96
    //   741: ldc_w 274
    //   744: astore 12
    //   746: goto -298 -> 448
    //   749: ldc_w 276
    //   752: astore 12
    //   754: goto -284 -> 470
    //   757: iconst_0
    //   758: istore_1
    //   759: goto -173 -> 586
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	762	0	this	d
    //   36	723	1	j	int
    //   138	137	2	k	int
    //   23	19	3	bool	boolean
    //   39	458	4	l1	long
    //   120	390	6	l2	long
    //   131	405	8	l3	long
    //   241	282	10	l4	long
    //   135	528	12	localObject1	Object
    //   690	1	12	localObject2	Object
    //   695	36	12	localException	java.lang.Exception
    //   744	9	12	str1	String
    //   2	639	13	localObject3	Object
    //   394	276	14	str2	String
    //   414	251	15	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   4	37	690	finally
    //   45	87	690	finally
    //   96	133	690	finally
    //   154	161	690	finally
    //   176	213	690	finally
    //   219	243	690	finally
    //   243	255	690	finally
    //   276	311	690	finally
    //   317	440	690	finally
    //   448	458	690	finally
    //   470	571	690	finally
    //   571	581	690	finally
    //   590	674	690	finally
    //   674	686	690	finally
    //   697	721	690	finally
    //   4	37	695	java/lang/Exception
    //   45	87	695	java/lang/Exception
    //   96	133	695	java/lang/Exception
    //   154	161	695	java/lang/Exception
    //   176	213	695	java/lang/Exception
    //   219	243	695	java/lang/Exception
    //   243	255	695	java/lang/Exception
    //   276	311	695	java/lang/Exception
    //   317	440	695	java/lang/Exception
    //   448	458	695	java/lang/Exception
    //   470	571	695	java/lang/Exception
    //   571	581	695	java/lang/Exception
    //   590	674	695	java/lang/Exception
    //   674	686	695	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.k.d
 * JD-Core Version:    0.7.0.1
 */