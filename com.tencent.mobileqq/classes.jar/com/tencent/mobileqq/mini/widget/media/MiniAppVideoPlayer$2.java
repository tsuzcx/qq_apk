package com.tencent.mobileqq.mini.widget.media;

class MiniAppVideoPlayer$2
  implements Runnable
{
  MiniAppVideoPlayer$2(MiniAppVideoPlayer paramMiniAppVideoPlayer) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: new 21	android/media/MediaExtractor
    //   3: dup
    //   4: invokespecial 22	android/media/MediaExtractor:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: astore_2
    //   10: aload_3
    //   11: aload_0
    //   12: getfield 12	com/tencent/mobileqq/mini/widget/media/MiniAppVideoPlayer$2:this$0	Lcom/tencent/mobileqq/mini/widget/media/MiniAppVideoPlayer;
    //   15: getfield 28	com/tencent/mobileqq/mini/widget/media/MiniAppVideoPlayer:mUrls	Ljava/lang/String;
    //   18: invokevirtual 32	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;)V
    //   21: aload_3
    //   22: astore_2
    //   23: aload_3
    //   24: invokestatic 38	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/VideoJsPlugin:getAndSelectVideoTrackIndex	(Landroid/media/MediaExtractor;)I
    //   27: istore_1
    //   28: iload_1
    //   29: iconst_m1
    //   30: if_icmple +75 -> 105
    //   33: aload_3
    //   34: astore_2
    //   35: aload_3
    //   36: iload_1
    //   37: invokevirtual 42	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   40: astore 4
    //   42: aload_3
    //   43: astore_2
    //   44: aload 4
    //   46: ldc 44
    //   48: invokevirtual 50	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   51: ifeq +20 -> 71
    //   54: aload_3
    //   55: astore_2
    //   56: aload_0
    //   57: getfield 12	com/tencent/mobileqq/mini/widget/media/MiniAppVideoPlayer$2:this$0	Lcom/tencent/mobileqq/mini/widget/media/MiniAppVideoPlayer;
    //   60: aload 4
    //   62: ldc 44
    //   64: invokevirtual 54	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   67: invokestatic 58	com/tencent/mobileqq/mini/widget/media/MiniAppVideoPlayer:access$002	(Lcom/tencent/mobileqq/mini/widget/media/MiniAppVideoPlayer;I)I
    //   70: pop
    //   71: aload_3
    //   72: astore_2
    //   73: aload_0
    //   74: getfield 12	com/tencent/mobileqq/mini/widget/media/MiniAppVideoPlayer$2:this$0	Lcom/tencent/mobileqq/mini/widget/media/MiniAppVideoPlayer;
    //   77: aload 4
    //   79: ldc 60
    //   81: invokevirtual 54	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   84: invokestatic 63	com/tencent/mobileqq/mini/widget/media/MiniAppVideoPlayer:access$102	(Lcom/tencent/mobileqq/mini/widget/media/MiniAppVideoPlayer;I)I
    //   87: pop
    //   88: aload_3
    //   89: astore_2
    //   90: aload_0
    //   91: getfield 12	com/tencent/mobileqq/mini/widget/media/MiniAppVideoPlayer$2:this$0	Lcom/tencent/mobileqq/mini/widget/media/MiniAppVideoPlayer;
    //   94: aload 4
    //   96: ldc 65
    //   98: invokevirtual 54	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   101: invokestatic 68	com/tencent/mobileqq/mini/widget/media/MiniAppVideoPlayer:access$202	(Lcom/tencent/mobileqq/mini/widget/media/MiniAppVideoPlayer;I)I
    //   104: pop
    //   105: aload_3
    //   106: ifnull +7 -> 113
    //   109: aload_3
    //   110: invokevirtual 71	android/media/MediaExtractor:release	()V
    //   113: return
    //   114: astore 4
    //   116: aconst_null
    //   117: astore_3
    //   118: aload_3
    //   119: astore_2
    //   120: ldc 73
    //   122: ldc 75
    //   124: aload 4
    //   126: invokestatic 81	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   129: pop
    //   130: aload_3
    //   131: ifnull -18 -> 113
    //   134: aload_3
    //   135: invokevirtual 71	android/media/MediaExtractor:release	()V
    //   138: return
    //   139: astore_3
    //   140: aconst_null
    //   141: astore_2
    //   142: aload_2
    //   143: ifnull +7 -> 150
    //   146: aload_2
    //   147: invokevirtual 71	android/media/MediaExtractor:release	()V
    //   150: aload_3
    //   151: athrow
    //   152: astore_3
    //   153: goto -11 -> 142
    //   156: astore 4
    //   158: goto -40 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	161	0	this	2
    //   27	10	1	i	int
    //   9	138	2	localMediaExtractor1	android.media.MediaExtractor
    //   7	128	3	localMediaExtractor2	android.media.MediaExtractor
    //   139	12	3	localObject1	Object
    //   152	1	3	localObject2	Object
    //   40	55	4	localMediaFormat	android.media.MediaFormat
    //   114	11	4	localThrowable1	java.lang.Throwable
    //   156	1	4	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   0	8	114	java/lang/Throwable
    //   0	8	139	finally
    //   10	21	152	finally
    //   23	28	152	finally
    //   35	42	152	finally
    //   44	54	152	finally
    //   56	71	152	finally
    //   73	88	152	finally
    //   90	105	152	finally
    //   120	130	152	finally
    //   10	21	156	java/lang/Throwable
    //   23	28	156	java/lang/Throwable
    //   35	42	156	java/lang/Throwable
    //   44	54	156	java/lang/Throwable
    //   56	71	156	java/lang/Throwable
    //   73	88	156	java/lang/Throwable
    //   90	105	156	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.MiniAppVideoPlayer.2
 * JD-Core Version:    0.7.0.1
 */