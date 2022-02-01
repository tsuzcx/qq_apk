package dov.com.qq.im.ae.gif.video;

class GIFCreator$1
  implements Runnable
{
  GIFCreator$1(GIFCreator paramGIFCreator, GIFCreator.Callback paramCallback) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 28	dov/com/qq/im/ae/gif/video/GIFCreator:a	()Ljava/lang/String;
    //   3: iconst_4
    //   4: ldc 30
    //   6: invokestatic 36	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   9: aload_0
    //   10: getfield 14	dov/com/qq/im/ae/gif/video/GIFCreator$1:this$0	Ldov/com/qq/im/ae/gif/video/GIFCreator;
    //   13: invokestatic 39	dov/com/qq/im/ae/gif/video/GIFCreator:a	(Ldov/com/qq/im/ae/gif/video/GIFCreator;)Ldov/com/qq/im/video/GifEncoder;
    //   16: sipush 320
    //   19: sipush 320
    //   22: aload_0
    //   23: getfield 14	dov/com/qq/im/ae/gif/video/GIFCreator$1:this$0	Ldov/com/qq/im/ae/gif/video/GIFCreator;
    //   26: invokestatic 42	dov/com/qq/im/ae/gif/video/GIFCreator:a	(Ldov/com/qq/im/ae/gif/video/GIFCreator;)Ljava/lang/String;
    //   29: invokevirtual 47	dov/com/qq/im/video/GifEncoder:a	(IILjava/lang/String;)V
    //   32: aload_0
    //   33: getfield 14	dov/com/qq/im/ae/gif/video/GIFCreator$1:this$0	Ldov/com/qq/im/ae/gif/video/GIFCreator;
    //   36: invokestatic 39	dov/com/qq/im/ae/gif/video/GIFCreator:a	(Ldov/com/qq/im/ae/gif/video/GIFCreator;)Ldov/com/qq/im/video/GifEncoder;
    //   39: iconst_0
    //   40: invokevirtual 50	dov/com/qq/im/video/GifEncoder:a	(Z)V
    //   43: invokestatic 56	java/lang/System:currentTimeMillis	()J
    //   46: lstore_3
    //   47: aload_0
    //   48: getfield 14	dov/com/qq/im/ae/gif/video/GIFCreator$1:this$0	Ldov/com/qq/im/ae/gif/video/GIFCreator;
    //   51: invokestatic 59	dov/com/qq/im/ae/gif/video/GIFCreator:a	(Ldov/com/qq/im/ae/gif/video/GIFCreator;)Ljava/util/List;
    //   54: invokeinterface 65 1 0
    //   59: astore 5
    //   61: aload 5
    //   63: invokeinterface 71 1 0
    //   68: ifeq +402 -> 470
    //   71: aload 5
    //   73: invokeinterface 75 1 0
    //   78: checkcast 77	java/lang/String
    //   81: astore 6
    //   83: aload 6
    //   85: sipush 320
    //   88: sipush 320
    //   91: iconst_0
    //   92: invokestatic 82	dov/com/qq/im/Util:a	(Ljava/lang/String;IIZ)Landroid/graphics/Bitmap;
    //   95: astore 7
    //   97: aload 7
    //   99: ifnull +121 -> 220
    //   102: invokestatic 28	dov/com/qq/im/ae/gif/video/GIFCreator:a	()Ljava/lang/String;
    //   105: iconst_4
    //   106: ldc 84
    //   108: invokestatic 36	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   111: aload_0
    //   112: getfield 14	dov/com/qq/im/ae/gif/video/GIFCreator$1:this$0	Ldov/com/qq/im/ae/gif/video/GIFCreator;
    //   115: invokestatic 39	dov/com/qq/im/ae/gif/video/GIFCreator:a	(Ldov/com/qq/im/ae/gif/video/GIFCreator;)Ldov/com/qq/im/video/GifEncoder;
    //   118: aload 7
    //   120: bipush 55
    //   122: invokevirtual 87	dov/com/qq/im/video/GifEncoder:a	(Landroid/graphics/Bitmap;I)Z
    //   125: pop
    //   126: invokestatic 28	dov/com/qq/im/ae/gif/video/GIFCreator:a	()Ljava/lang/String;
    //   129: iconst_4
    //   130: ldc 89
    //   132: invokestatic 36	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   135: aload 7
    //   137: invokevirtual 94	android/graphics/Bitmap:recycle	()V
    //   140: goto -79 -> 61
    //   143: astore 5
    //   145: invokestatic 28	dov/com/qq/im/ae/gif/video/GIFCreator:a	()Ljava/lang/String;
    //   148: iconst_4
    //   149: new 96	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   156: ldc 99
    //   158: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: aload_0
    //   162: getfield 14	dov/com/qq/im/ae/gif/video/GIFCreator$1:this$0	Ldov/com/qq/im/ae/gif/video/GIFCreator;
    //   165: invokestatic 42	dov/com/qq/im/ae/gif/video/GIFCreator:a	(Ldov/com/qq/im/ae/gif/video/GIFCreator;)Ljava/lang/String;
    //   168: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: ldc 105
    //   173: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: aload 5
    //   178: invokevirtual 108	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   181: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokestatic 36	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   190: aload_0
    //   191: getfield 16	dov/com/qq/im/ae/gif/video/GIFCreator$1:a	Ldov/com/qq/im/ae/gif/video/GIFCreator$Callback;
    //   194: ifnull +12 -> 206
    //   197: aload_0
    //   198: getfield 16	dov/com/qq/im/ae/gif/video/GIFCreator$1:a	Ldov/com/qq/im/ae/gif/video/GIFCreator$Callback;
    //   201: invokeinterface 115 1 0
    //   206: aload_0
    //   207: getfield 14	dov/com/qq/im/ae/gif/video/GIFCreator$1:this$0	Ldov/com/qq/im/ae/gif/video/GIFCreator;
    //   210: invokestatic 118	dov/com/qq/im/ae/gif/video/GIFCreator:a	(Ldov/com/qq/im/ae/gif/video/GIFCreator;)Landroid/os/Handler;
    //   213: invokevirtual 124	android/os/Handler:getLooper	()Landroid/os/Looper;
    //   216: invokevirtual 129	android/os/Looper:quit	()V
    //   219: return
    //   220: invokestatic 28	dov/com/qq/im/ae/gif/video/GIFCreator:a	()Ljava/lang/String;
    //   223: iconst_4
    //   224: iconst_2
    //   225: anewarray 4	java/lang/Object
    //   228: dup
    //   229: iconst_0
    //   230: ldc 131
    //   232: aastore
    //   233: dup
    //   234: iconst_1
    //   235: aload 6
    //   237: aastore
    //   238: invokestatic 134	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   241: iconst_0
    //   242: istore_1
    //   243: aload_0
    //   244: getfield 14	dov/com/qq/im/ae/gif/video/GIFCreator$1:this$0	Ldov/com/qq/im/ae/gif/video/GIFCreator;
    //   247: invokestatic 39	dov/com/qq/im/ae/gif/video/GIFCreator:a	(Ldov/com/qq/im/ae/gif/video/GIFCreator;)Ldov/com/qq/im/video/GifEncoder;
    //   250: invokevirtual 135	dov/com/qq/im/video/GifEncoder:a	()V
    //   253: invokestatic 28	dov/com/qq/im/ae/gif/video/GIFCreator:a	()Ljava/lang/String;
    //   256: iconst_4
    //   257: new 96	java/lang/StringBuilder
    //   260: dup
    //   261: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   264: ldc 137
    //   266: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: invokestatic 56	java/lang/System:currentTimeMillis	()J
    //   272: lload_3
    //   273: lsub
    //   274: invokevirtual 140	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   277: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   280: invokestatic 36	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   283: aload_0
    //   284: getfield 14	dov/com/qq/im/ae/gif/video/GIFCreator$1:this$0	Ldov/com/qq/im/ae/gif/video/GIFCreator;
    //   287: invokestatic 143	dov/com/qq/im/ae/gif/video/GIFCreator:b	(Ldov/com/qq/im/ae/gif/video/GIFCreator;)Ljava/lang/String;
    //   290: invokestatic 149	com/tencent/mobileqq/filemanager/util/FileUtil:c	(Ljava/lang/String;)Z
    //   293: pop
    //   294: invokestatic 56	java/lang/System:currentTimeMillis	()J
    //   297: lstore_3
    //   298: aload_0
    //   299: getfield 14	dov/com/qq/im/ae/gif/video/GIFCreator$1:this$0	Ldov/com/qq/im/ae/gif/video/GIFCreator;
    //   302: invokestatic 42	dov/com/qq/im/ae/gif/video/GIFCreator:a	(Ldov/com/qq/im/ae/gif/video/GIFCreator;)Ljava/lang/String;
    //   305: aload_0
    //   306: getfield 14	dov/com/qq/im/ae/gif/video/GIFCreator$1:this$0	Ldov/com/qq/im/ae/gif/video/GIFCreator;
    //   309: invokestatic 143	dov/com/qq/im/ae/gif/video/GIFCreator:b	(Ldov/com/qq/im/ae/gif/video/GIFCreator;)Ljava/lang/String;
    //   312: bipush 30
    //   314: invokestatic 155	com/tencent/common/GifUtil:compressGif	(Ljava/lang/String;Ljava/lang/String;I)I
    //   317: istore_2
    //   318: invokestatic 28	dov/com/qq/im/ae/gif/video/GIFCreator:a	()Ljava/lang/String;
    //   321: iconst_4
    //   322: new 96	java/lang/StringBuilder
    //   325: dup
    //   326: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   329: ldc 157
    //   331: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: invokestatic 56	java/lang/System:currentTimeMillis	()J
    //   337: lload_3
    //   338: lsub
    //   339: invokevirtual 140	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   342: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   345: invokestatic 36	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   348: invokestatic 28	dov/com/qq/im/ae/gif/video/GIFCreator:a	()Ljava/lang/String;
    //   351: iconst_4
    //   352: new 96	java/lang/StringBuilder
    //   355: dup
    //   356: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   359: ldc 159
    //   361: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: iload_2
    //   365: invokevirtual 162	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   368: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   371: invokestatic 36	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   374: iload_2
    //   375: ifgt +5 -> 380
    //   378: iconst_0
    //   379: istore_1
    //   380: aload_0
    //   381: getfield 14	dov/com/qq/im/ae/gif/video/GIFCreator$1:this$0	Ldov/com/qq/im/ae/gif/video/GIFCreator;
    //   384: invokestatic 42	dov/com/qq/im/ae/gif/video/GIFCreator:a	(Ldov/com/qq/im/ae/gif/video/GIFCreator;)Ljava/lang/String;
    //   387: invokestatic 149	com/tencent/mobileqq/filemanager/util/FileUtil:c	(Ljava/lang/String;)Z
    //   390: pop
    //   391: invokestatic 28	dov/com/qq/im/ae/gif/video/GIFCreator:a	()Ljava/lang/String;
    //   394: iconst_4
    //   395: iconst_2
    //   396: anewarray 4	java/lang/Object
    //   399: dup
    //   400: iconst_0
    //   401: ldc 164
    //   403: aastore
    //   404: dup
    //   405: iconst_1
    //   406: aload_0
    //   407: getfield 14	dov/com/qq/im/ae/gif/video/GIFCreator$1:this$0	Ldov/com/qq/im/ae/gif/video/GIFCreator;
    //   410: invokestatic 143	dov/com/qq/im/ae/gif/video/GIFCreator:b	(Ldov/com/qq/im/ae/gif/video/GIFCreator;)Ljava/lang/String;
    //   413: aastore
    //   414: invokestatic 134	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   417: aload_0
    //   418: getfield 16	dov/com/qq/im/ae/gif/video/GIFCreator$1:a	Ldov/com/qq/im/ae/gif/video/GIFCreator$Callback;
    //   421: ifnull +23 -> 444
    //   424: iload_1
    //   425: ifeq +33 -> 458
    //   428: aload_0
    //   429: getfield 16	dov/com/qq/im/ae/gif/video/GIFCreator$1:a	Ldov/com/qq/im/ae/gif/video/GIFCreator$Callback;
    //   432: aload_0
    //   433: getfield 14	dov/com/qq/im/ae/gif/video/GIFCreator$1:this$0	Ldov/com/qq/im/ae/gif/video/GIFCreator;
    //   436: invokestatic 143	dov/com/qq/im/ae/gif/video/GIFCreator:b	(Ldov/com/qq/im/ae/gif/video/GIFCreator;)Ljava/lang/String;
    //   439: invokeinterface 167 2 0
    //   444: aload_0
    //   445: getfield 14	dov/com/qq/im/ae/gif/video/GIFCreator$1:this$0	Ldov/com/qq/im/ae/gif/video/GIFCreator;
    //   448: invokestatic 118	dov/com/qq/im/ae/gif/video/GIFCreator:a	(Ldov/com/qq/im/ae/gif/video/GIFCreator;)Landroid/os/Handler;
    //   451: invokevirtual 124	android/os/Handler:getLooper	()Landroid/os/Looper;
    //   454: invokevirtual 129	android/os/Looper:quit	()V
    //   457: return
    //   458: aload_0
    //   459: getfield 16	dov/com/qq/im/ae/gif/video/GIFCreator$1:a	Ldov/com/qq/im/ae/gif/video/GIFCreator$Callback;
    //   462: invokeinterface 115 1 0
    //   467: goto -23 -> 444
    //   470: iconst_1
    //   471: istore_1
    //   472: goto -229 -> 243
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	475	0	this	1
    //   242	230	1	i	int
    //   317	58	2	j	int
    //   46	292	3	l	long
    //   59	13	5	localIterator	java.util.Iterator
    //   143	34	5	localFileNotFoundException	java.io.FileNotFoundException
    //   81	155	6	str	java.lang.String
    //   95	41	7	localBitmap	android.graphics.Bitmap
    // Exception table:
    //   from	to	target	type
    //   9	43	143	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.video.GIFCreator.1
 * JD-Core Version:    0.7.0.1
 */