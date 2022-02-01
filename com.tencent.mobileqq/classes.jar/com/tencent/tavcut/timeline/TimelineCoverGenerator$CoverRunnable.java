package com.tencent.tavcut.timeline;

public class TimelineCoverGenerator$CoverRunnable
  implements Runnable
{
  public TimelineCoverGenerator$CoverRunnable(TimelineCoverGenerator paramTimelineCoverGenerator) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/timeline/TimelineCoverGenerator;
    //   4: getfield 27	com/tencent/tavcut/timeline/TimelineCoverGenerator:mCoverTaskQueue	Ljava/util/concurrent/BlockingQueue;
    //   7: ifnull +613 -> 620
    //   10: aload_0
    //   11: getfield 12	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/timeline/TimelineCoverGenerator;
    //   14: getfield 27	com/tencent/tavcut/timeline/TimelineCoverGenerator:mCoverTaskQueue	Ljava/util/concurrent/BlockingQueue;
    //   17: invokeinterface 33 1 0
    //   22: ifne +598 -> 620
    //   25: aload_0
    //   26: getfield 12	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/timeline/TimelineCoverGenerator;
    //   29: getfield 37	com/tencent/tavcut/timeline/TimelineCoverGenerator:mImageGenerator	Lcom/tencent/tavkit/component/TAVSourceImageGenerator;
    //   32: ifnull +588 -> 620
    //   35: aload_0
    //   36: getfield 12	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/timeline/TimelineCoverGenerator;
    //   39: getfield 41	com/tencent/tavcut/timeline/TimelineCoverGenerator:mReleased	Z
    //   42: ifne +578 -> 620
    //   45: aload_0
    //   46: getfield 12	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/timeline/TimelineCoverGenerator;
    //   49: getfield 27	com/tencent/tavcut/timeline/TimelineCoverGenerator:mCoverTaskQueue	Ljava/util/concurrent/BlockingQueue;
    //   52: invokeinterface 45 1 0
    //   57: checkcast 47	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverTask
    //   60: astore 7
    //   62: ldc 49
    //   64: new 51	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   71: ldc 54
    //   73: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: aload 7
    //   78: invokestatic 62	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverTask:access$000	(Lcom/tencent/tavcut/timeline/TimelineCoverGenerator$CoverTask;)I
    //   81: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   84: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokestatic 75	com/tencent/tavcut/util/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   90: ldc 49
    //   92: new 51	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   99: ldc 77
    //   101: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: aload 7
    //   106: invokestatic 81	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverTask:access$200	(Lcom/tencent/tavcut/timeline/TimelineCoverGenerator$CoverTask;)J
    //   109: invokevirtual 84	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   112: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokestatic 75	com/tencent/tavcut/util/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   118: aload 7
    //   120: astore 9
    //   122: aload 9
    //   124: ifnull -124 -> 0
    //   127: aload 9
    //   129: iconst_1
    //   130: invokestatic 88	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverTask:access$102	(Lcom/tencent/tavcut/timeline/TimelineCoverGenerator$CoverTask;Z)Z
    //   133: pop
    //   134: aload_0
    //   135: getfield 12	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/timeline/TimelineCoverGenerator;
    //   138: getfield 37	com/tencent/tavcut/timeline/TimelineCoverGenerator:mImageGenerator	Lcom/tencent/tavkit/component/TAVSourceImageGenerator;
    //   141: ifnull +577 -> 718
    //   144: ldc 49
    //   146: ldc 90
    //   148: invokestatic 75	com/tencent/tavcut/util/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   151: aload_0
    //   152: getfield 12	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/timeline/TimelineCoverGenerator;
    //   155: getfield 37	com/tencent/tavcut/timeline/TimelineCoverGenerator:mImageGenerator	Lcom/tencent/tavkit/component/TAVSourceImageGenerator;
    //   158: new 92	com/tencent/tav/coremedia/CMTime
    //   161: dup
    //   162: aload 9
    //   164: invokestatic 95	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverTask:access$300	(Lcom/tencent/tavcut/timeline/TimelineCoverGenerator$CoverTask;)J
    //   167: l2f
    //   168: ldc 96
    //   170: fdiv
    //   171: invokespecial 99	com/tencent/tav/coremedia/CMTime:<init>	(F)V
    //   174: invokevirtual 105	com/tencent/tavkit/component/TAVSourceImageGenerator:generateThumbnailAtTimeSync	(Lcom/tencent/tav/coremedia/CMTime;)Landroid/graphics/Bitmap;
    //   177: astore 8
    //   179: ldc 49
    //   181: ldc 107
    //   183: invokestatic 75	com/tencent/tavcut/util/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   186: aload 8
    //   188: ifnull +524 -> 712
    //   191: aload 8
    //   193: invokevirtual 113	android/graphics/Bitmap:getWidth	()I
    //   196: istore_2
    //   197: aload 8
    //   199: invokevirtual 116	android/graphics/Bitmap:getHeight	()I
    //   202: istore_3
    //   203: new 118	android/graphics/Matrix
    //   206: dup
    //   207: invokespecial 119	android/graphics/Matrix:<init>	()V
    //   210: astore 7
    //   212: aload 7
    //   214: ldc 120
    //   216: ldc 120
    //   218: invokevirtual 124	android/graphics/Matrix:postScale	(FF)Z
    //   221: pop
    //   222: iload_2
    //   223: i2f
    //   224: aload_0
    //   225: getfield 12	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/timeline/TimelineCoverGenerator;
    //   228: getfield 128	com/tencent/tavcut/timeline/TimelineCoverGenerator:mCoverWidth	F
    //   231: ldc 129
    //   233: fmul
    //   234: fsub
    //   235: fconst_2
    //   236: fdiv
    //   237: f2i
    //   238: istore_1
    //   239: iload_3
    //   240: i2f
    //   241: aload_0
    //   242: getfield 12	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/timeline/TimelineCoverGenerator;
    //   245: getfield 132	com/tencent/tavcut/timeline/TimelineCoverGenerator:mCoverHeight	F
    //   248: ldc 129
    //   250: fmul
    //   251: fsub
    //   252: fconst_2
    //   253: fdiv
    //   254: f2i
    //   255: istore 4
    //   257: aload_0
    //   258: getfield 12	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/timeline/TimelineCoverGenerator;
    //   261: getfield 128	com/tencent/tavcut/timeline/TimelineCoverGenerator:mCoverWidth	F
    //   264: ldc 129
    //   266: fmul
    //   267: f2i
    //   268: istore 6
    //   270: aload_0
    //   271: getfield 12	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/timeline/TimelineCoverGenerator;
    //   274: getfield 132	com/tencent/tavcut/timeline/TimelineCoverGenerator:mCoverHeight	F
    //   277: ldc 129
    //   279: fmul
    //   280: f2i
    //   281: istore 5
    //   283: iload_1
    //   284: ifgt +422 -> 706
    //   287: iconst_0
    //   288: istore_1
    //   289: iload 4
    //   291: ifgt +409 -> 700
    //   294: iconst_0
    //   295: istore 4
    //   297: aload 8
    //   299: iload_1
    //   300: iload 4
    //   302: iload_2
    //   303: iload_3
    //   304: aload 7
    //   306: iconst_0
    //   307: invokestatic 136	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   310: astore 10
    //   312: aload 10
    //   314: astore 7
    //   316: aload 8
    //   318: invokevirtual 139	android/graphics/Bitmap:isRecycled	()Z
    //   321: ifne +12 -> 333
    //   324: aload 8
    //   326: invokevirtual 142	android/graphics/Bitmap:recycle	()V
    //   329: aload 10
    //   331: astore 7
    //   333: aload 7
    //   335: ifnull +258 -> 593
    //   338: aload 9
    //   340: invokestatic 62	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverTask:access$000	(Lcom/tencent/tavcut/timeline/TimelineCoverGenerator$CoverTask;)I
    //   343: aload_0
    //   344: getfield 12	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/timeline/TimelineCoverGenerator;
    //   347: getfield 146	com/tencent/tavcut/timeline/TimelineCoverGenerator:mItemCount	I
    //   350: iconst_1
    //   351: isub
    //   352: if_icmpne +341 -> 693
    //   355: aload_0
    //   356: getfield 12	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/timeline/TimelineCoverGenerator;
    //   359: getfield 149	com/tencent/tavcut/timeline/TimelineCoverGenerator:mLastCoverWidth	F
    //   362: aload_0
    //   363: getfield 12	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/timeline/TimelineCoverGenerator;
    //   366: getfield 128	com/tencent/tavcut/timeline/TimelineCoverGenerator:mCoverWidth	F
    //   369: invokestatic 154	com/tencent/tavcut/util/FloatUtils:isEquals	(FF)Z
    //   372: ifne +321 -> 693
    //   375: aload 7
    //   377: iconst_0
    //   378: iconst_0
    //   379: fconst_1
    //   380: aload_0
    //   381: getfield 12	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/timeline/TimelineCoverGenerator;
    //   384: getfield 149	com/tencent/tavcut/timeline/TimelineCoverGenerator:mLastCoverWidth	F
    //   387: fmul
    //   388: aload_0
    //   389: getfield 12	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/timeline/TimelineCoverGenerator;
    //   392: getfield 128	com/tencent/tavcut/timeline/TimelineCoverGenerator:mCoverWidth	F
    //   395: fdiv
    //   396: aload 7
    //   398: invokevirtual 113	android/graphics/Bitmap:getWidth	()I
    //   401: i2f
    //   402: fmul
    //   403: f2i
    //   404: aload 7
    //   406: invokevirtual 116	android/graphics/Bitmap:getHeight	()I
    //   409: invokestatic 157	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   412: astore 10
    //   414: aload 10
    //   416: astore 8
    //   418: aload 7
    //   420: invokevirtual 139	android/graphics/Bitmap:isRecycled	()Z
    //   423: ifne +12 -> 435
    //   426: aload 7
    //   428: invokevirtual 142	android/graphics/Bitmap:recycle	()V
    //   431: aload 10
    //   433: astore 8
    //   435: aload_0
    //   436: getfield 12	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/timeline/TimelineCoverGenerator;
    //   439: getfield 161	com/tencent/tavcut/timeline/TimelineCoverGenerator:mCoverCache	Lcom/tencent/tavcut/cover/CoverCache;
    //   442: ifnull +20 -> 462
    //   445: aload_0
    //   446: getfield 12	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/timeline/TimelineCoverGenerator;
    //   449: getfield 161	com/tencent/tavcut/timeline/TimelineCoverGenerator:mCoverCache	Lcom/tencent/tavcut/cover/CoverCache;
    //   452: aload 9
    //   454: invokestatic 62	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverTask:access$000	(Lcom/tencent/tavcut/timeline/TimelineCoverGenerator$CoverTask;)I
    //   457: aload 8
    //   459: invokevirtual 167	com/tencent/tavcut/cover/CoverCache:addCover	(ILandroid/graphics/Bitmap;)V
    //   462: aload_0
    //   463: getfield 12	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/timeline/TimelineCoverGenerator;
    //   466: getfield 171	com/tencent/tavcut/timeline/TimelineCoverGenerator:mCoverTaskMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   469: ifnull +22 -> 491
    //   472: aload_0
    //   473: getfield 12	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/timeline/TimelineCoverGenerator;
    //   476: getfield 171	com/tencent/tavcut/timeline/TimelineCoverGenerator:mCoverTaskMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   479: aload 9
    //   481: invokestatic 95	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverTask:access$300	(Lcom/tencent/tavcut/timeline/TimelineCoverGenerator$CoverTask;)J
    //   484: invokestatic 177	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   487: invokevirtual 183	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   490: pop
    //   491: aload_0
    //   492: getfield 12	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/timeline/TimelineCoverGenerator;
    //   495: getfield 161	com/tencent/tavcut/timeline/TimelineCoverGenerator:mCoverCache	Lcom/tencent/tavcut/cover/CoverCache;
    //   498: ifnull -498 -> 0
    //   501: aload_0
    //   502: getfield 12	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/timeline/TimelineCoverGenerator;
    //   505: getfield 161	com/tencent/tavcut/timeline/TimelineCoverGenerator:mCoverCache	Lcom/tencent/tavcut/cover/CoverCache;
    //   508: invokevirtual 186	com/tencent/tavcut/cover/CoverCache:getCacheSize	()I
    //   511: aload_0
    //   512: getfield 12	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/timeline/TimelineCoverGenerator;
    //   515: getfield 146	com/tencent/tavcut/timeline/TimelineCoverGenerator:mItemCount	I
    //   518: if_icmpne -518 -> 0
    //   521: aload_0
    //   522: getfield 12	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/timeline/TimelineCoverGenerator;
    //   525: getfield 37	com/tencent/tavcut/timeline/TimelineCoverGenerator:mImageGenerator	Lcom/tencent/tavkit/component/TAVSourceImageGenerator;
    //   528: invokevirtual 190	com/tencent/tavkit/component/TAVSourceImageGenerator:getAssetImageGenerator	()Lcom/tencent/tav/core/AssetImageGenerator;
    //   531: invokevirtual 195	com/tencent/tav/core/AssetImageGenerator:release	()V
    //   534: aload_0
    //   535: getfield 12	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/timeline/TimelineCoverGenerator;
    //   538: aconst_null
    //   539: putfield 37	com/tencent/tavcut/timeline/TimelineCoverGenerator:mImageGenerator	Lcom/tencent/tavkit/component/TAVSourceImageGenerator;
    //   542: goto -542 -> 0
    //   545: astore 8
    //   547: aconst_null
    //   548: astore 7
    //   550: ldc 49
    //   552: ldc 197
    //   554: invokestatic 75	com/tencent/tavcut/util/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   557: aload 8
    //   559: invokevirtual 200	java/lang/InterruptedException:printStackTrace	()V
    //   562: aload 7
    //   564: astore 9
    //   566: goto -444 -> 122
    //   569: astore 8
    //   571: aconst_null
    //   572: astore 7
    //   574: ldc 49
    //   576: ldc 202
    //   578: invokestatic 75	com/tencent/tavcut/util/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   581: aload 8
    //   583: invokevirtual 203	java/lang/Exception:printStackTrace	()V
    //   586: aload 7
    //   588: astore 8
    //   590: goto -404 -> 186
    //   593: aload_0
    //   594: getfield 12	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/timeline/TimelineCoverGenerator;
    //   597: getfield 27	com/tencent/tavcut/timeline/TimelineCoverGenerator:mCoverTaskQueue	Ljava/util/concurrent/BlockingQueue;
    //   600: aload 9
    //   602: invokeinterface 207 2 0
    //   607: goto -607 -> 0
    //   610: astore 7
    //   612: aload 7
    //   614: invokevirtual 200	java/lang/InterruptedException:printStackTrace	()V
    //   617: goto -617 -> 0
    //   620: aload_0
    //   621: getfield 12	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/timeline/TimelineCoverGenerator;
    //   624: getfield 171	com/tencent/tavcut/timeline/TimelineCoverGenerator:mCoverTaskMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   627: ifnull +30 -> 657
    //   630: aload_0
    //   631: getfield 12	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/timeline/TimelineCoverGenerator;
    //   634: getfield 171	com/tencent/tavcut/timeline/TimelineCoverGenerator:mCoverTaskMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   637: invokevirtual 208	java/util/concurrent/ConcurrentHashMap:isEmpty	()Z
    //   640: ifeq +17 -> 657
    //   643: aload_0
    //   644: getfield 12	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/timeline/TimelineCoverGenerator;
    //   647: invokestatic 211	com/tencent/tavcut/timeline/TimelineCoverGenerator:access$400	(Lcom/tencent/tavcut/timeline/TimelineCoverGenerator;)V
    //   650: aload_0
    //   651: getfield 12	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/timeline/TimelineCoverGenerator;
    //   654: invokestatic 214	com/tencent/tavcut/timeline/TimelineCoverGenerator:access$500	(Lcom/tencent/tavcut/timeline/TimelineCoverGenerator;)V
    //   657: aload_0
    //   658: getfield 12	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/timeline/TimelineCoverGenerator;
    //   661: getfield 41	com/tencent/tavcut/timeline/TimelineCoverGenerator:mReleased	Z
    //   664: ifeq +10 -> 674
    //   667: aload_0
    //   668: getfield 12	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/timeline/TimelineCoverGenerator;
    //   671: invokestatic 217	com/tencent/tavcut/timeline/TimelineCoverGenerator:access$600	(Lcom/tencent/tavcut/timeline/TimelineCoverGenerator;)V
    //   674: return
    //   675: astore 10
    //   677: aload 8
    //   679: astore 7
    //   681: aload 10
    //   683: astore 8
    //   685: goto -111 -> 574
    //   688: astore 8
    //   690: goto -140 -> 550
    //   693: aload 7
    //   695: astore 8
    //   697: goto -262 -> 435
    //   700: iload 5
    //   702: istore_3
    //   703: goto -406 -> 297
    //   706: iload 6
    //   708: istore_2
    //   709: goto -420 -> 289
    //   712: aconst_null
    //   713: astore 7
    //   715: goto -382 -> 333
    //   718: aconst_null
    //   719: astore 8
    //   721: goto -535 -> 186
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	724	0	this	CoverRunnable
    //   238	62	1	i	int
    //   196	513	2	j	int
    //   202	501	3	k	int
    //   255	46	4	m	int
    //   281	420	5	n	int
    //   268	439	6	i1	int
    //   60	527	7	localObject1	Object
    //   610	3	7	localInterruptedException1	java.lang.InterruptedException
    //   679	35	7	localObject2	Object
    //   177	281	8	localObject3	Object
    //   545	13	8	localInterruptedException2	java.lang.InterruptedException
    //   569	13	8	localException1	java.lang.Exception
    //   588	96	8	localObject4	Object
    //   688	1	8	localInterruptedException3	java.lang.InterruptedException
    //   695	25	8	localObject5	Object
    //   120	481	9	localObject6	Object
    //   310	122	10	localBitmap	android.graphics.Bitmap
    //   675	7	10	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   45	62	545	java/lang/InterruptedException
    //   134	179	569	java/lang/Exception
    //   593	607	610	java/lang/InterruptedException
    //   179	186	675	java/lang/Exception
    //   62	118	688	java/lang/InterruptedException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.timeline.TimelineCoverGenerator.CoverRunnable
 * JD-Core Version:    0.7.0.1
 */