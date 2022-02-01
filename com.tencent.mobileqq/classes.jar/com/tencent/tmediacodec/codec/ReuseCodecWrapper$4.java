package com.tencent.tmediacodec.codec;

class ReuseCodecWrapper$4
  implements Runnable
{
  ReuseCodecWrapper$4(ReuseCodecWrapper paramReuseCodecWrapper) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	com/tencent/tmediacodec/codec/ReuseCodecWrapper$4:this$0	Lcom/tencent/tmediacodec/codec/ReuseCodecWrapper;
    //   4: invokestatic 25	com/tencent/tmediacodec/codec/ReuseCodecWrapper:access$300	(Lcom/tencent/tmediacodec/codec/ReuseCodecWrapper;)Landroid/media/MediaCodec;
    //   7: invokevirtual 30	android/media/MediaCodec:stop	()V
    //   10: aload_0
    //   11: getfield 12	com/tencent/tmediacodec/codec/ReuseCodecWrapper$4:this$0	Lcom/tencent/tmediacodec/codec/ReuseCodecWrapper;
    //   14: invokestatic 25	com/tencent/tmediacodec/codec/ReuseCodecWrapper:access$300	(Lcom/tencent/tmediacodec/codec/ReuseCodecWrapper;)Landroid/media/MediaCodec;
    //   17: invokevirtual 33	android/media/MediaCodec:release	()V
    //   20: aload_0
    //   21: getfield 12	com/tencent/tmediacodec/codec/ReuseCodecWrapper$4:this$0	Lcom/tencent/tmediacodec/codec/ReuseCodecWrapper;
    //   24: iconst_0
    //   25: invokestatic 37	com/tencent/tmediacodec/codec/ReuseCodecWrapper:access$400	(Lcom/tencent/tmediacodec/codec/ReuseCodecWrapper;Z)V
    //   28: aload_0
    //   29: getfield 12	com/tencent/tmediacodec/codec/ReuseCodecWrapper$4:this$0	Lcom/tencent/tmediacodec/codec/ReuseCodecWrapper;
    //   32: invokestatic 41	com/tencent/tmediacodec/codec/ReuseCodecWrapper:access$500	(Lcom/tencent/tmediacodec/codec/ReuseCodecWrapper;)Lcom/tencent/tmediacodec/callback/CodecCallback;
    //   35: ifnull +15 -> 50
    //   38: aload_0
    //   39: getfield 12	com/tencent/tmediacodec/codec/ReuseCodecWrapper$4:this$0	Lcom/tencent/tmediacodec/codec/ReuseCodecWrapper;
    //   42: invokestatic 41	com/tencent/tmediacodec/codec/ReuseCodecWrapper:access$500	(Lcom/tencent/tmediacodec/codec/ReuseCodecWrapper;)Lcom/tencent/tmediacodec/callback/CodecCallback;
    //   45: invokeinterface 46 1 0
    //   50: return
    //   51: astore_1
    //   52: aload_0
    //   53: getfield 12	com/tencent/tmediacodec/codec/ReuseCodecWrapper$4:this$0	Lcom/tencent/tmediacodec/codec/ReuseCodecWrapper;
    //   56: invokestatic 25	com/tencent/tmediacodec/codec/ReuseCodecWrapper:access$300	(Lcom/tencent/tmediacodec/codec/ReuseCodecWrapper;)Landroid/media/MediaCodec;
    //   59: invokevirtual 33	android/media/MediaCodec:release	()V
    //   62: aload_1
    //   63: athrow
    //   64: astore_1
    //   65: ldc 48
    //   67: ldc 50
    //   69: aload_1
    //   70: invokestatic 56	com/tencent/tmediacodec/util/LogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   73: goto -45 -> 28
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	4
    //   51	12	1	localObject	Object
    //   64	6	1	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   0	10	51	finally
    //   10	28	64	java/lang/Throwable
    //   52	64	64	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tmediacodec.codec.ReuseCodecWrapper.4
 * JD-Core Version:    0.7.0.1
 */