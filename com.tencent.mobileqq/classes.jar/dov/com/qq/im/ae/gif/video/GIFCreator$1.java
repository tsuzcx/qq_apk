package dov.com.qq.im.ae.gif.video;

import blah;
import blaj;

public class GIFCreator$1
  implements Runnable
{
  public GIFCreator$1(blah paramblah, blaj paramblaj) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 28	blah:a	()Ljava/lang/String;
    //   3: iconst_4
    //   4: ldc 30
    //   6: invokestatic 36	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   9: aload_0
    //   10: getfield 14	dov/com/qq/im/ae/gif/video/GIFCreator$1:this$0	Lblah;
    //   13: invokestatic 39	blah:a	(Lblah;)Ldov/com/qq/im/video/GifEncoder;
    //   16: sipush 320
    //   19: sipush 320
    //   22: aload_0
    //   23: getfield 14	dov/com/qq/im/ae/gif/video/GIFCreator$1:this$0	Lblah;
    //   26: invokestatic 42	blah:a	(Lblah;)Ljava/lang/String;
    //   29: invokevirtual 47	dov/com/qq/im/video/GifEncoder:a	(IILjava/lang/String;)V
    //   32: invokestatic 53	java/lang/System:currentTimeMillis	()J
    //   35: lstore_3
    //   36: aload_0
    //   37: getfield 14	dov/com/qq/im/ae/gif/video/GIFCreator$1:this$0	Lblah;
    //   40: invokestatic 56	blah:a	(Lblah;)Ljava/util/List;
    //   43: invokeinterface 62 1 0
    //   48: astore 5
    //   50: aload 5
    //   52: invokeinterface 68 1 0
    //   57: ifeq +402 -> 459
    //   60: aload 5
    //   62: invokeinterface 72 1 0
    //   67: checkcast 74	java/lang/String
    //   70: astore 6
    //   72: aload 6
    //   74: sipush 320
    //   77: sipush 320
    //   80: iconst_0
    //   81: invokestatic 79	bkkd:a	(Ljava/lang/String;IIZ)Landroid/graphics/Bitmap;
    //   84: astore 7
    //   86: aload 7
    //   88: ifnull +121 -> 209
    //   91: invokestatic 28	blah:a	()Ljava/lang/String;
    //   94: iconst_4
    //   95: ldc 81
    //   97: invokestatic 36	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   100: aload_0
    //   101: getfield 14	dov/com/qq/im/ae/gif/video/GIFCreator$1:this$0	Lblah;
    //   104: invokestatic 39	blah:a	(Lblah;)Ldov/com/qq/im/video/GifEncoder;
    //   107: aload 7
    //   109: bipush 55
    //   111: invokevirtual 84	dov/com/qq/im/video/GifEncoder:a	(Landroid/graphics/Bitmap;I)Z
    //   114: pop
    //   115: invokestatic 28	blah:a	()Ljava/lang/String;
    //   118: iconst_4
    //   119: ldc 86
    //   121: invokestatic 36	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   124: aload 7
    //   126: invokevirtual 91	android/graphics/Bitmap:recycle	()V
    //   129: goto -79 -> 50
    //   132: astore 5
    //   134: invokestatic 28	blah:a	()Ljava/lang/String;
    //   137: iconst_4
    //   138: new 93	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   145: ldc 96
    //   147: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: aload_0
    //   151: getfield 14	dov/com/qq/im/ae/gif/video/GIFCreator$1:this$0	Lblah;
    //   154: invokestatic 42	blah:a	(Lblah;)Ljava/lang/String;
    //   157: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: ldc 102
    //   162: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: aload 5
    //   167: invokevirtual 105	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   170: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: invokestatic 36	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   179: aload_0
    //   180: getfield 16	dov/com/qq/im/ae/gif/video/GIFCreator$1:a	Lblaj;
    //   183: ifnull +12 -> 195
    //   186: aload_0
    //   187: getfield 16	dov/com/qq/im/ae/gif/video/GIFCreator$1:a	Lblaj;
    //   190: invokeinterface 112 1 0
    //   195: aload_0
    //   196: getfield 14	dov/com/qq/im/ae/gif/video/GIFCreator$1:this$0	Lblah;
    //   199: invokestatic 115	blah:a	(Lblah;)Landroid/os/Handler;
    //   202: invokevirtual 121	android/os/Handler:getLooper	()Landroid/os/Looper;
    //   205: invokevirtual 126	android/os/Looper:quit	()V
    //   208: return
    //   209: invokestatic 28	blah:a	()Ljava/lang/String;
    //   212: iconst_4
    //   213: iconst_2
    //   214: anewarray 4	java/lang/Object
    //   217: dup
    //   218: iconst_0
    //   219: ldc 128
    //   221: aastore
    //   222: dup
    //   223: iconst_1
    //   224: aload 6
    //   226: aastore
    //   227: invokestatic 131	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   230: iconst_0
    //   231: istore_1
    //   232: aload_0
    //   233: getfield 14	dov/com/qq/im/ae/gif/video/GIFCreator$1:this$0	Lblah;
    //   236: invokestatic 39	blah:a	(Lblah;)Ldov/com/qq/im/video/GifEncoder;
    //   239: invokevirtual 132	dov/com/qq/im/video/GifEncoder:a	()V
    //   242: invokestatic 28	blah:a	()Ljava/lang/String;
    //   245: iconst_4
    //   246: new 93	java/lang/StringBuilder
    //   249: dup
    //   250: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   253: ldc 134
    //   255: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: invokestatic 53	java/lang/System:currentTimeMillis	()J
    //   261: lload_3
    //   262: lsub
    //   263: invokevirtual 137	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   266: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   269: invokestatic 36	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   272: aload_0
    //   273: getfield 14	dov/com/qq/im/ae/gif/video/GIFCreator$1:this$0	Lblah;
    //   276: invokestatic 140	blah:b	(Lblah;)Ljava/lang/String;
    //   279: invokestatic 146	arof:c	(Ljava/lang/String;)Z
    //   282: pop
    //   283: invokestatic 53	java/lang/System:currentTimeMillis	()J
    //   286: lstore_3
    //   287: aload_0
    //   288: getfield 14	dov/com/qq/im/ae/gif/video/GIFCreator$1:this$0	Lblah;
    //   291: invokestatic 42	blah:a	(Lblah;)Ljava/lang/String;
    //   294: aload_0
    //   295: getfield 14	dov/com/qq/im/ae/gif/video/GIFCreator$1:this$0	Lblah;
    //   298: invokestatic 140	blah:b	(Lblah;)Ljava/lang/String;
    //   301: bipush 30
    //   303: invokestatic 152	com/tencent/common/GifUtil:compressGif	(Ljava/lang/String;Ljava/lang/String;I)I
    //   306: istore_2
    //   307: invokestatic 28	blah:a	()Ljava/lang/String;
    //   310: iconst_4
    //   311: new 93	java/lang/StringBuilder
    //   314: dup
    //   315: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   318: ldc 154
    //   320: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: invokestatic 53	java/lang/System:currentTimeMillis	()J
    //   326: lload_3
    //   327: lsub
    //   328: invokevirtual 137	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   331: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   334: invokestatic 36	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   337: invokestatic 28	blah:a	()Ljava/lang/String;
    //   340: iconst_4
    //   341: new 93	java/lang/StringBuilder
    //   344: dup
    //   345: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   348: ldc 156
    //   350: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: iload_2
    //   354: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   357: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   360: invokestatic 36	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   363: iload_2
    //   364: ifgt +5 -> 369
    //   367: iconst_0
    //   368: istore_1
    //   369: aload_0
    //   370: getfield 14	dov/com/qq/im/ae/gif/video/GIFCreator$1:this$0	Lblah;
    //   373: invokestatic 42	blah:a	(Lblah;)Ljava/lang/String;
    //   376: invokestatic 146	arof:c	(Ljava/lang/String;)Z
    //   379: pop
    //   380: invokestatic 28	blah:a	()Ljava/lang/String;
    //   383: iconst_4
    //   384: iconst_2
    //   385: anewarray 4	java/lang/Object
    //   388: dup
    //   389: iconst_0
    //   390: ldc 161
    //   392: aastore
    //   393: dup
    //   394: iconst_1
    //   395: aload_0
    //   396: getfield 14	dov/com/qq/im/ae/gif/video/GIFCreator$1:this$0	Lblah;
    //   399: invokestatic 140	blah:b	(Lblah;)Ljava/lang/String;
    //   402: aastore
    //   403: invokestatic 131	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   406: aload_0
    //   407: getfield 16	dov/com/qq/im/ae/gif/video/GIFCreator$1:a	Lblaj;
    //   410: ifnull +23 -> 433
    //   413: iload_1
    //   414: ifeq +33 -> 447
    //   417: aload_0
    //   418: getfield 16	dov/com/qq/im/ae/gif/video/GIFCreator$1:a	Lblaj;
    //   421: aload_0
    //   422: getfield 14	dov/com/qq/im/ae/gif/video/GIFCreator$1:this$0	Lblah;
    //   425: invokestatic 140	blah:b	(Lblah;)Ljava/lang/String;
    //   428: invokeinterface 164 2 0
    //   433: aload_0
    //   434: getfield 14	dov/com/qq/im/ae/gif/video/GIFCreator$1:this$0	Lblah;
    //   437: invokestatic 115	blah:a	(Lblah;)Landroid/os/Handler;
    //   440: invokevirtual 121	android/os/Handler:getLooper	()Landroid/os/Looper;
    //   443: invokevirtual 126	android/os/Looper:quit	()V
    //   446: return
    //   447: aload_0
    //   448: getfield 16	dov/com/qq/im/ae/gif/video/GIFCreator$1:a	Lblaj;
    //   451: invokeinterface 112 1 0
    //   456: goto -23 -> 433
    //   459: iconst_1
    //   460: istore_1
    //   461: goto -229 -> 232
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	464	0	this	1
    //   231	230	1	i	int
    //   306	58	2	j	int
    //   35	292	3	l	long
    //   48	13	5	localIterator	java.util.Iterator
    //   132	34	5	localFileNotFoundException	java.io.FileNotFoundException
    //   70	155	6	str	java.lang.String
    //   84	41	7	localBitmap	android.graphics.Bitmap
    // Exception table:
    //   from	to	target	type
    //   9	32	132	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.video.GIFCreator.1
 * JD-Core Version:    0.7.0.1
 */