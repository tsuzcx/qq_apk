package com.tencent.tkd.topicsdk.widget.videocrop;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/widget/videocrop/VideoFramesRetriever$FrameFetchRunnable;", "Ljava/lang/Runnable;", "(Lcom/tencent/tkd/topicsdk/widget/videocrop/VideoFramesRetriever;)V", "run", "", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class VideoFramesRetriever$FrameFetchRunnable
  implements Runnable
{
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 28	com/tencent/tkd/topicsdk/widget/videocrop/VideoFramesRetriever$FrameFetchRunnable:this$0	Lcom/tencent/tkd/topicsdk/widget/videocrop/VideoFramesRetriever;
    //   4: invokestatic 41	com/tencent/tkd/topicsdk/widget/videocrop/VideoFramesRetriever:c	(Lcom/tencent/tkd/topicsdk/widget/videocrop/VideoFramesRetriever;)Landroid/media/MediaMetadataRetriever;
    //   7: ifnonnull +4 -> 11
    //   10: return
    //   11: aload_0
    //   12: getfield 28	com/tencent/tkd/topicsdk/widget/videocrop/VideoFramesRetriever$FrameFetchRunnable:this$0	Lcom/tencent/tkd/topicsdk/widget/videocrop/VideoFramesRetriever;
    //   15: invokestatic 45	com/tencent/tkd/topicsdk/widget/videocrop/VideoFramesRetriever:d	(Lcom/tencent/tkd/topicsdk/widget/videocrop/VideoFramesRetriever;)Z
    //   18: ifne +423 -> 441
    //   21: aload_0
    //   22: getfield 28	com/tencent/tkd/topicsdk/widget/videocrop/VideoFramesRetriever$FrameFetchRunnable:this$0	Lcom/tencent/tkd/topicsdk/widget/videocrop/VideoFramesRetriever;
    //   25: invokestatic 49	com/tencent/tkd/topicsdk/widget/videocrop/VideoFramesRetriever:e	(Lcom/tencent/tkd/topicsdk/widget/videocrop/VideoFramesRetriever;)Ljava/util/concurrent/BlockingQueue;
    //   28: invokeinterface 55 1 0
    //   33: astore 6
    //   35: aload 6
    //   37: ldc 57
    //   39: invokestatic 63	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   42: aload 6
    //   44: checkcast 65	com/tencent/tkd/topicsdk/widget/videocrop/VideoFramesRetriever$FrameFetchTask
    //   47: astore 7
    //   49: aload_0
    //   50: getfield 28	com/tencent/tkd/topicsdk/widget/videocrop/VideoFramesRetriever$FrameFetchRunnable:this$0	Lcom/tencent/tkd/topicsdk/widget/videocrop/VideoFramesRetriever;
    //   53: invokestatic 45	com/tencent/tkd/topicsdk/widget/videocrop/VideoFramesRetriever:d	(Lcom/tencent/tkd/topicsdk/widget/videocrop/VideoFramesRetriever;)Z
    //   56: ifeq +4 -> 60
    //   59: return
    //   60: invokestatic 71	java/lang/System:currentTimeMillis	()J
    //   63: lstore 4
    //   65: aload_0
    //   66: getfield 28	com/tencent/tkd/topicsdk/widget/videocrop/VideoFramesRetriever$FrameFetchRunnable:this$0	Lcom/tencent/tkd/topicsdk/widget/videocrop/VideoFramesRetriever;
    //   69: invokestatic 41	com/tencent/tkd/topicsdk/widget/videocrop/VideoFramesRetriever:c	(Lcom/tencent/tkd/topicsdk/widget/videocrop/VideoFramesRetriever;)Landroid/media/MediaMetadataRetriever;
    //   72: astore 6
    //   74: aload 6
    //   76: ifnonnull +6 -> 82
    //   79: invokestatic 74	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   82: aload 6
    //   84: aload 7
    //   86: invokevirtual 78	com/tencent/tkd/topicsdk/widget/videocrop/VideoFramesRetriever$FrameFetchTask:b	()I
    //   89: aload 7
    //   91: invokevirtual 81	com/tencent/tkd/topicsdk/widget/videocrop/VideoFramesRetriever$FrameFetchTask:a	()I
    //   94: iadd
    //   95: iconst_2
    //   96: idiv
    //   97: i2l
    //   98: ldc2_w 82
    //   101: lmul
    //   102: invokevirtual 89	android/media/MediaMetadataRetriever:getFrameAtTime	(J)Landroid/graphics/Bitmap;
    //   105: astore 8
    //   107: aload 8
    //   109: ifnonnull +13 -> 122
    //   112: ldc 91
    //   114: ldc 93
    //   116: invokestatic 98	com/tencent/tkd/topicsdk/framework/TLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   119: goto -108 -> 11
    //   122: aload 8
    //   124: invokevirtual 103	android/graphics/Bitmap:getWidth	()I
    //   127: aload 8
    //   129: invokevirtual 106	android/graphics/Bitmap:getHeight	()I
    //   132: if_icmple +319 -> 451
    //   135: iconst_1
    //   136: istore_2
    //   137: goto +3 -> 140
    //   140: iload_2
    //   141: ifeq +25 -> 166
    //   144: aload_0
    //   145: getfield 28	com/tencent/tkd/topicsdk/widget/videocrop/VideoFramesRetriever$FrameFetchRunnable:this$0	Lcom/tencent/tkd/topicsdk/widget/videocrop/VideoFramesRetriever;
    //   148: invokestatic 110	com/tencent/tkd/topicsdk/widget/videocrop/VideoFramesRetriever:f	(Lcom/tencent/tkd/topicsdk/widget/videocrop/VideoFramesRetriever;)F
    //   151: fstore_1
    //   152: aload 8
    //   154: invokevirtual 106	android/graphics/Bitmap:getHeight	()I
    //   157: istore_3
    //   158: fload_1
    //   159: iload_3
    //   160: i2f
    //   161: fdiv
    //   162: fstore_1
    //   163: goto +20 -> 183
    //   166: aload_0
    //   167: getfield 28	com/tencent/tkd/topicsdk/widget/videocrop/VideoFramesRetriever$FrameFetchRunnable:this$0	Lcom/tencent/tkd/topicsdk/widget/videocrop/VideoFramesRetriever;
    //   170: invokestatic 110	com/tencent/tkd/topicsdk/widget/videocrop/VideoFramesRetriever:f	(Lcom/tencent/tkd/topicsdk/widget/videocrop/VideoFramesRetriever;)F
    //   173: fstore_1
    //   174: aload 8
    //   176: invokevirtual 103	android/graphics/Bitmap:getWidth	()I
    //   179: istore_3
    //   180: goto -22 -> 158
    //   183: new 112	android/graphics/Matrix
    //   186: dup
    //   187: invokespecial 113	android/graphics/Matrix:<init>	()V
    //   190: astore 6
    //   192: aload 6
    //   194: fload_1
    //   195: fload_1
    //   196: invokevirtual 117	android/graphics/Matrix:postScale	(FF)Z
    //   199: pop
    //   200: iload_2
    //   201: ifeq +47 -> 248
    //   204: aload 8
    //   206: aload 8
    //   208: invokevirtual 103	android/graphics/Bitmap:getWidth	()I
    //   211: aload 8
    //   213: invokevirtual 106	android/graphics/Bitmap:getHeight	()I
    //   216: isub
    //   217: iconst_2
    //   218: idiv
    //   219: iconst_0
    //   220: aload 8
    //   222: invokevirtual 106	android/graphics/Bitmap:getHeight	()I
    //   225: aload 8
    //   227: invokevirtual 106	android/graphics/Bitmap:getHeight	()I
    //   230: aload 6
    //   232: iconst_1
    //   233: invokestatic 121	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   236: astore 6
    //   238: aload 6
    //   240: ldc 123
    //   242: invokestatic 63	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   245: goto +44 -> 289
    //   248: aload 8
    //   250: iconst_0
    //   251: aload 8
    //   253: invokevirtual 106	android/graphics/Bitmap:getHeight	()I
    //   256: aload 8
    //   258: invokevirtual 103	android/graphics/Bitmap:getWidth	()I
    //   261: isub
    //   262: iconst_2
    //   263: idiv
    //   264: aload 8
    //   266: invokevirtual 103	android/graphics/Bitmap:getWidth	()I
    //   269: aload 8
    //   271: invokevirtual 103	android/graphics/Bitmap:getWidth	()I
    //   274: aload 6
    //   276: iconst_1
    //   277: invokestatic 121	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   280: astore 6
    //   282: aload 6
    //   284: ldc 123
    //   286: invokestatic 63	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   289: aload 8
    //   291: invokevirtual 126	android/graphics/Bitmap:recycle	()V
    //   294: new 128	com/tencent/tkd/topicsdk/widget/videocrop/FramesProcessor$Frame
    //   297: dup
    //   298: invokespecial 129	com/tencent/tkd/topicsdk/widget/videocrop/FramesProcessor$Frame:<init>	()V
    //   301: astore 8
    //   303: aload 8
    //   305: aload 6
    //   307: getstatic 135	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   310: iconst_1
    //   311: invokevirtual 139	android/graphics/Bitmap:copy	(Landroid/graphics/Bitmap$Config;Z)Landroid/graphics/Bitmap;
    //   314: invokevirtual 142	com/tencent/tkd/topicsdk/widget/videocrop/FramesProcessor$Frame:a	(Landroid/graphics/Bitmap;)V
    //   317: aload 8
    //   319: aload 7
    //   321: invokevirtual 78	com/tencent/tkd/topicsdk/widget/videocrop/VideoFramesRetriever$FrameFetchTask:b	()I
    //   324: aload_0
    //   325: getfield 28	com/tencent/tkd/topicsdk/widget/videocrop/VideoFramesRetriever$FrameFetchRunnable:this$0	Lcom/tencent/tkd/topicsdk/widget/videocrop/VideoFramesRetriever;
    //   328: invokestatic 146	com/tencent/tkd/topicsdk/widget/videocrop/VideoFramesRetriever:g	(Lcom/tencent/tkd/topicsdk/widget/videocrop/VideoFramesRetriever;)I
    //   331: idiv
    //   332: invokevirtual 149	com/tencent/tkd/topicsdk/widget/videocrop/FramesProcessor$Frame:a	(I)V
    //   335: aload 6
    //   337: invokevirtual 126	android/graphics/Bitmap:recycle	()V
    //   340: new 151	java/lang/StringBuilder
    //   343: dup
    //   344: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   347: astore 6
    //   349: aload 6
    //   351: ldc 154
    //   353: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: pop
    //   357: aload 6
    //   359: invokestatic 71	java/lang/System:currentTimeMillis	()J
    //   362: lload 4
    //   364: lsub
    //   365: invokevirtual 161	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   368: pop
    //   369: ldc 91
    //   371: aload 6
    //   373: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   376: invokestatic 167	com/tencent/tkd/topicsdk/framework/TLog:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   379: aload_0
    //   380: getfield 28	com/tencent/tkd/topicsdk/widget/videocrop/VideoFramesRetriever$FrameFetchRunnable:this$0	Lcom/tencent/tkd/topicsdk/widget/videocrop/VideoFramesRetriever;
    //   383: invokestatic 171	com/tencent/tkd/topicsdk/widget/videocrop/VideoFramesRetriever:h	(Lcom/tencent/tkd/topicsdk/widget/videocrop/VideoFramesRetriever;)Lcom/tencent/tkd/topicsdk/widget/videocrop/FrameAdapter;
    //   386: astore 6
    //   388: aload 6
    //   390: ifnonnull +6 -> 396
    //   393: invokestatic 74	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   396: aload 6
    //   398: aload 8
    //   400: invokevirtual 176	com/tencent/tkd/topicsdk/widget/videocrop/FrameAdapter:a	(Lcom/tencent/tkd/topicsdk/widget/videocrop/FramesProcessor$Frame;)V
    //   403: aload_0
    //   404: getfield 28	com/tencent/tkd/topicsdk/widget/videocrop/VideoFramesRetriever$FrameFetchRunnable:this$0	Lcom/tencent/tkd/topicsdk/widget/videocrop/VideoFramesRetriever;
    //   407: invokestatic 179	com/tencent/tkd/topicsdk/widget/videocrop/VideoFramesRetriever:b	(Lcom/tencent/tkd/topicsdk/widget/videocrop/VideoFramesRetriever;)Ljava/util/concurrent/ConcurrentHashMap;
    //   410: aload 7
    //   412: invokevirtual 78	com/tencent/tkd/topicsdk/widget/videocrop/VideoFramesRetriever$FrameFetchTask:b	()I
    //   415: invokestatic 185	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   418: invokevirtual 191	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   421: pop
    //   422: goto -411 -> 11
    //   425: astore 6
    //   427: goto +15 -> 442
    //   430: astore 6
    //   432: ldc 91
    //   434: ldc 193
    //   436: aload 6
    //   438: invokestatic 196	com/tencent/tkd/topicsdk/framework/TLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   441: return
    //   442: goto +6 -> 448
    //   445: aload 6
    //   447: athrow
    //   448: goto -3 -> 445
    //   451: iconst_0
    //   452: istore_2
    //   453: goto -313 -> 140
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	456	0	this	FrameFetchRunnable
    //   151	45	1	f	float
    //   136	317	2	i	int
    //   157	23	3	j	int
    //   63	300	4	l	long
    //   33	364	6	localObject1	Object
    //   425	1	6	localObject2	Object
    //   430	16	6	localThrowable	java.lang.Throwable
    //   47	364	7	localFrameFetchTask	VideoFramesRetriever.FrameFetchTask
    //   105	294	8	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   11	59	425	finally
    //   60	74	425	finally
    //   79	82	425	finally
    //   82	107	425	finally
    //   112	119	425	finally
    //   122	135	425	finally
    //   144	158	425	finally
    //   158	163	425	finally
    //   166	180	425	finally
    //   183	200	425	finally
    //   204	245	425	finally
    //   248	289	425	finally
    //   289	388	425	finally
    //   393	396	425	finally
    //   396	422	425	finally
    //   432	441	425	finally
    //   11	59	430	java/lang/Throwable
    //   60	74	430	java/lang/Throwable
    //   79	82	430	java/lang/Throwable
    //   82	107	430	java/lang/Throwable
    //   112	119	430	java/lang/Throwable
    //   122	135	430	java/lang/Throwable
    //   144	158	430	java/lang/Throwable
    //   158	163	430	java/lang/Throwable
    //   166	180	430	java/lang/Throwable
    //   183	200	430	java/lang/Throwable
    //   204	245	430	java/lang/Throwable
    //   248	289	430	java/lang/Throwable
    //   289	388	430	java/lang/Throwable
    //   393	396	430	java/lang/Throwable
    //   396	422	430	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.videocrop.VideoFramesRetriever.FrameFetchRunnable
 * JD-Core Version:    0.7.0.1
 */