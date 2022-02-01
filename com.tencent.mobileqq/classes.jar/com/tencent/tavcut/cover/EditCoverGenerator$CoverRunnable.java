package com.tencent.tavcut.cover;

class EditCoverGenerator$CoverRunnable
  implements Runnable
{
  private EditCoverGenerator$CoverRunnable(EditCoverGenerator paramEditCoverGenerator) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aload_0
    //   4: getfield 12	com/tencent/tavcut/cover/EditCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/cover/EditCoverGenerator;
    //   7: invokestatic 30	com/tencent/tavcut/cover/EditCoverGenerator:access$400	(Lcom/tencent/tavcut/cover/EditCoverGenerator;)Ljava/util/concurrent/BlockingQueue;
    //   10: ifnull +450 -> 460
    //   13: aload_0
    //   14: getfield 12	com/tencent/tavcut/cover/EditCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/cover/EditCoverGenerator;
    //   17: invokestatic 30	com/tencent/tavcut/cover/EditCoverGenerator:access$400	(Lcom/tencent/tavcut/cover/EditCoverGenerator;)Ljava/util/concurrent/BlockingQueue;
    //   20: invokeinterface 36 1 0
    //   25: ifne +435 -> 460
    //   28: aload_0
    //   29: getfield 12	com/tencent/tavcut/cover/EditCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/cover/EditCoverGenerator;
    //   32: invokestatic 40	com/tencent/tavcut/cover/EditCoverGenerator:access$500	(Lcom/tencent/tavcut/cover/EditCoverGenerator;)Lcom/tencent/tavkit/component/TAVSourceImageGenerator;
    //   35: ifnull +425 -> 460
    //   38: aload_0
    //   39: getfield 12	com/tencent/tavcut/cover/EditCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/cover/EditCoverGenerator;
    //   42: invokestatic 44	com/tencent/tavcut/cover/EditCoverGenerator:access$600	(Lcom/tencent/tavcut/cover/EditCoverGenerator;)Z
    //   45: ifne +415 -> 460
    //   48: aload_0
    //   49: getfield 12	com/tencent/tavcut/cover/EditCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/cover/EditCoverGenerator;
    //   52: invokestatic 47	com/tencent/tavcut/cover/EditCoverGenerator:access$700	(Lcom/tencent/tavcut/cover/EditCoverGenerator;)Z
    //   55: ifne +405 -> 460
    //   58: aload_0
    //   59: getfield 12	com/tencent/tavcut/cover/EditCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/cover/EditCoverGenerator;
    //   62: invokestatic 30	com/tencent/tavcut/cover/EditCoverGenerator:access$400	(Lcom/tencent/tavcut/cover/EditCoverGenerator;)Ljava/util/concurrent/BlockingQueue;
    //   65: invokeinterface 51 1 0
    //   70: checkcast 53	com/tencent/tavcut/cover/EditCoverGenerator$CoverTask
    //   73: astore 8
    //   75: ldc 55
    //   77: new 57	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   84: ldc 60
    //   86: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload 8
    //   91: invokestatic 68	com/tencent/tavcut/cover/EditCoverGenerator$CoverTask:access$800	(Lcom/tencent/tavcut/cover/EditCoverGenerator$CoverTask;)I
    //   94: invokevirtual 71	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   97: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokestatic 81	com/tencent/tavcut/util/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   103: ldc 55
    //   105: new 57	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   112: ldc 83
    //   114: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: aload 8
    //   119: invokestatic 87	com/tencent/tavcut/cover/EditCoverGenerator$CoverTask:access$900	(Lcom/tencent/tavcut/cover/EditCoverGenerator$CoverTask;)J
    //   122: invokevirtual 90	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   125: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokestatic 81	com/tencent/tavcut/util/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   131: aload 8
    //   133: astore 9
    //   135: aload 9
    //   137: ifnull -134 -> 3
    //   140: aload 9
    //   142: iconst_1
    //   143: invokestatic 94	com/tencent/tavcut/cover/EditCoverGenerator$CoverTask:access$102	(Lcom/tencent/tavcut/cover/EditCoverGenerator$CoverTask;Z)Z
    //   146: pop
    //   147: aload_0
    //   148: getfield 12	com/tencent/tavcut/cover/EditCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/cover/EditCoverGenerator;
    //   151: invokestatic 40	com/tencent/tavcut/cover/EditCoverGenerator:access$500	(Lcom/tencent/tavcut/cover/EditCoverGenerator;)Lcom/tencent/tavkit/component/TAVSourceImageGenerator;
    //   154: ifnull +409 -> 563
    //   157: ldc 55
    //   159: ldc 96
    //   161: invokestatic 81	com/tencent/tavcut/util/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   164: aload_0
    //   165: getfield 12	com/tencent/tavcut/cover/EditCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/cover/EditCoverGenerator;
    //   168: invokestatic 40	com/tencent/tavcut/cover/EditCoverGenerator:access$500	(Lcom/tencent/tavcut/cover/EditCoverGenerator;)Lcom/tencent/tavkit/component/TAVSourceImageGenerator;
    //   171: aload 9
    //   173: invokestatic 100	com/tencent/tavcut/cover/EditCoverGenerator$CoverTask:access$200	(Lcom/tencent/tavcut/cover/EditCoverGenerator$CoverTask;)Lcom/tencent/tav/coremedia/CMTime;
    //   176: invokevirtual 106	com/tencent/tavkit/component/TAVSourceImageGenerator:generateThumbnailAtTimeSync	(Lcom/tencent/tav/coremedia/CMTime;)Landroid/graphics/Bitmap;
    //   179: astore 8
    //   181: ldc 55
    //   183: ldc 108
    //   185: invokestatic 81	com/tencent/tavcut/util/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   188: aload 8
    //   190: ifnull +367 -> 557
    //   193: aload 8
    //   195: invokevirtual 114	android/graphics/Bitmap:getWidth	()I
    //   198: istore_2
    //   199: aload 8
    //   201: invokevirtual 117	android/graphics/Bitmap:getHeight	()I
    //   204: istore_3
    //   205: new 119	android/graphics/Matrix
    //   208: dup
    //   209: invokespecial 120	android/graphics/Matrix:<init>	()V
    //   212: astore 10
    //   214: aload 10
    //   216: fconst_1
    //   217: fconst_1
    //   218: invokevirtual 124	android/graphics/Matrix:postScale	(FF)Z
    //   221: pop
    //   222: iload_2
    //   223: i2f
    //   224: aload_0
    //   225: getfield 12	com/tencent/tavcut/cover/EditCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/cover/EditCoverGenerator;
    //   228: invokestatic 128	com/tencent/tavcut/cover/EditCoverGenerator:access$1000	(Lcom/tencent/tavcut/cover/EditCoverGenerator;)F
    //   231: fconst_1
    //   232: fmul
    //   233: fsub
    //   234: fconst_2
    //   235: fdiv
    //   236: f2i
    //   237: istore_1
    //   238: iload_3
    //   239: i2f
    //   240: aload_0
    //   241: getfield 12	com/tencent/tavcut/cover/EditCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/cover/EditCoverGenerator;
    //   244: invokestatic 131	com/tencent/tavcut/cover/EditCoverGenerator:access$1100	(Lcom/tencent/tavcut/cover/EditCoverGenerator;)F
    //   247: fconst_1
    //   248: fmul
    //   249: fsub
    //   250: fconst_2
    //   251: fdiv
    //   252: f2i
    //   253: istore 4
    //   255: aload_0
    //   256: getfield 12	com/tencent/tavcut/cover/EditCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/cover/EditCoverGenerator;
    //   259: invokestatic 128	com/tencent/tavcut/cover/EditCoverGenerator:access$1000	(Lcom/tencent/tavcut/cover/EditCoverGenerator;)F
    //   262: fconst_1
    //   263: fmul
    //   264: f2i
    //   265: istore 7
    //   267: aload_0
    //   268: getfield 12	com/tencent/tavcut/cover/EditCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/cover/EditCoverGenerator;
    //   271: invokestatic 131	com/tencent/tavcut/cover/EditCoverGenerator:access$1100	(Lcom/tencent/tavcut/cover/EditCoverGenerator;)F
    //   274: fconst_1
    //   275: fmul
    //   276: f2i
    //   277: istore 6
    //   279: iload_1
    //   280: ifgt +271 -> 551
    //   283: iconst_0
    //   284: istore_1
    //   285: iload 4
    //   287: ifgt +258 -> 545
    //   290: iconst_0
    //   291: istore 4
    //   293: aload 8
    //   295: iload_1
    //   296: iload 4
    //   298: iload_2
    //   299: iload_3
    //   300: aload 10
    //   302: iconst_0
    //   303: invokestatic 135	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   306: astore 10
    //   308: aload 8
    //   310: invokevirtual 138	android/graphics/Bitmap:isRecycled	()Z
    //   313: ifne +8 -> 321
    //   316: aload 8
    //   318: invokevirtual 141	android/graphics/Bitmap:recycle	()V
    //   321: aload 10
    //   323: astore 8
    //   325: aload 8
    //   327: ifnull +106 -> 433
    //   330: aload_0
    //   331: getfield 12	com/tencent/tavcut/cover/EditCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/cover/EditCoverGenerator;
    //   334: invokestatic 145	com/tencent/tavcut/cover/EditCoverGenerator:access$1200	(Lcom/tencent/tavcut/cover/EditCoverGenerator;)Lcom/tencent/tavcut/cover/CoverCache;
    //   337: ifnull +20 -> 357
    //   340: aload_0
    //   341: getfield 12	com/tencent/tavcut/cover/EditCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/cover/EditCoverGenerator;
    //   344: invokestatic 145	com/tencent/tavcut/cover/EditCoverGenerator:access$1200	(Lcom/tencent/tavcut/cover/EditCoverGenerator;)Lcom/tencent/tavcut/cover/CoverCache;
    //   347: aload 9
    //   349: invokestatic 68	com/tencent/tavcut/cover/EditCoverGenerator$CoverTask:access$800	(Lcom/tencent/tavcut/cover/EditCoverGenerator$CoverTask;)I
    //   352: aload 8
    //   354: invokevirtual 151	com/tencent/tavcut/cover/CoverCache:addCover	(ILandroid/graphics/Bitmap;)V
    //   357: aload_0
    //   358: getfield 12	com/tencent/tavcut/cover/EditCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/cover/EditCoverGenerator;
    //   361: invokestatic 155	com/tencent/tavcut/cover/EditCoverGenerator:access$300	(Lcom/tencent/tavcut/cover/EditCoverGenerator;)Ljava/util/concurrent/ConcurrentHashMap;
    //   364: ifnull -361 -> 3
    //   367: aload_0
    //   368: getfield 12	com/tencent/tavcut/cover/EditCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/cover/EditCoverGenerator;
    //   371: invokestatic 155	com/tencent/tavcut/cover/EditCoverGenerator:access$300	(Lcom/tencent/tavcut/cover/EditCoverGenerator;)Ljava/util/concurrent/ConcurrentHashMap;
    //   374: aload 9
    //   376: invokestatic 68	com/tencent/tavcut/cover/EditCoverGenerator$CoverTask:access$800	(Lcom/tencent/tavcut/cover/EditCoverGenerator$CoverTask;)I
    //   379: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   382: invokevirtual 167	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   385: pop
    //   386: goto -383 -> 3
    //   389: astore 9
    //   391: aconst_null
    //   392: astore 8
    //   394: ldc 55
    //   396: ldc 169
    //   398: invokestatic 81	com/tencent/tavcut/util/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   401: aload 9
    //   403: invokevirtual 172	java/lang/InterruptedException:printStackTrace	()V
    //   406: aload 8
    //   408: astore 9
    //   410: goto -275 -> 135
    //   413: astore 10
    //   415: aconst_null
    //   416: astore 8
    //   418: ldc 55
    //   420: ldc 174
    //   422: invokestatic 81	com/tencent/tavcut/util/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   425: aload 10
    //   427: invokevirtual 175	java/lang/Exception:printStackTrace	()V
    //   430: goto -242 -> 188
    //   433: aload_0
    //   434: getfield 12	com/tencent/tavcut/cover/EditCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/cover/EditCoverGenerator;
    //   437: invokestatic 30	com/tencent/tavcut/cover/EditCoverGenerator:access$400	(Lcom/tencent/tavcut/cover/EditCoverGenerator;)Ljava/util/concurrent/BlockingQueue;
    //   440: aload 9
    //   442: invokeinterface 179 2 0
    //   447: goto -444 -> 3
    //   450: astore 8
    //   452: aload 8
    //   454: invokevirtual 172	java/lang/InterruptedException:printStackTrace	()V
    //   457: goto -454 -> 3
    //   460: aload_0
    //   461: getfield 12	com/tencent/tavcut/cover/EditCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/cover/EditCoverGenerator;
    //   464: invokestatic 47	com/tencent/tavcut/cover/EditCoverGenerator:access$700	(Lcom/tencent/tavcut/cover/EditCoverGenerator;)Z
    //   467: ifeq +11 -> 478
    //   470: aload_0
    //   471: getfield 12	com/tencent/tavcut/cover/EditCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/cover/EditCoverGenerator;
    //   474: invokestatic 182	com/tencent/tavcut/cover/EditCoverGenerator:access$1300	(Lcom/tencent/tavcut/cover/EditCoverGenerator;)V
    //   477: return
    //   478: aload_0
    //   479: getfield 12	com/tencent/tavcut/cover/EditCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/cover/EditCoverGenerator;
    //   482: invokestatic 155	com/tencent/tavcut/cover/EditCoverGenerator:access$300	(Lcom/tencent/tavcut/cover/EditCoverGenerator;)Ljava/util/concurrent/ConcurrentHashMap;
    //   485: ifnull +16 -> 501
    //   488: aload_0
    //   489: getfield 12	com/tencent/tavcut/cover/EditCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/cover/EditCoverGenerator;
    //   492: invokestatic 155	com/tencent/tavcut/cover/EditCoverGenerator:access$300	(Lcom/tencent/tavcut/cover/EditCoverGenerator;)Ljava/util/concurrent/ConcurrentHashMap;
    //   495: invokevirtual 183	java/util/concurrent/ConcurrentHashMap:isEmpty	()Z
    //   498: ifne +16 -> 514
    //   501: iload 5
    //   503: istore_1
    //   504: aload_0
    //   505: getfield 12	com/tencent/tavcut/cover/EditCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/cover/EditCoverGenerator;
    //   508: invokestatic 44	com/tencent/tavcut/cover/EditCoverGenerator:access$600	(Lcom/tencent/tavcut/cover/EditCoverGenerator;)Z
    //   511: ifeq +5 -> 516
    //   514: iconst_1
    //   515: istore_1
    //   516: iload_1
    //   517: ifeq -40 -> 477
    //   520: aload_0
    //   521: getfield 12	com/tencent/tavcut/cover/EditCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/cover/EditCoverGenerator;
    //   524: invokestatic 186	com/tencent/tavcut/cover/EditCoverGenerator:access$1400	(Lcom/tencent/tavcut/cover/EditCoverGenerator;)V
    //   527: aload_0
    //   528: getfield 12	com/tencent/tavcut/cover/EditCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/cover/EditCoverGenerator;
    //   531: invokestatic 189	com/tencent/tavcut/cover/EditCoverGenerator:access$1500	(Lcom/tencent/tavcut/cover/EditCoverGenerator;)V
    //   534: return
    //   535: astore 10
    //   537: goto -119 -> 418
    //   540: astore 9
    //   542: goto -148 -> 394
    //   545: iload 6
    //   547: istore_3
    //   548: goto -255 -> 293
    //   551: iload 7
    //   553: istore_2
    //   554: goto -269 -> 285
    //   557: aconst_null
    //   558: astore 8
    //   560: goto -235 -> 325
    //   563: aconst_null
    //   564: astore 8
    //   566: goto -378 -> 188
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	569	0	this	CoverRunnable
    //   237	280	1	i	int
    //   198	356	2	j	int
    //   204	344	3	k	int
    //   253	44	4	m	int
    //   1	501	5	n	int
    //   277	269	6	i1	int
    //   265	287	7	i2	int
    //   73	344	8	localObject1	Object
    //   450	3	8	localInterruptedException1	java.lang.InterruptedException
    //   558	7	8	localObject2	Object
    //   133	242	9	localObject3	Object
    //   389	13	9	localInterruptedException2	java.lang.InterruptedException
    //   408	33	9	localObject4	Object
    //   540	1	9	localInterruptedException3	java.lang.InterruptedException
    //   212	110	10	localObject5	Object
    //   413	13	10	localException1	java.lang.Exception
    //   535	1	10	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   58	75	389	java/lang/InterruptedException
    //   147	181	413	java/lang/Exception
    //   433	447	450	java/lang/InterruptedException
    //   181	188	535	java/lang/Exception
    //   75	131	540	java/lang/InterruptedException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavcut.cover.EditCoverGenerator.CoverRunnable
 * JD-Core Version:    0.7.0.1
 */