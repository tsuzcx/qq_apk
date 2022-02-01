package com.tencent.tav.decoder;

class MediaCodecWrapper$1
  implements Runnable
{
  MediaCodecWrapper$1(MediaCodecWrapper paramMediaCodecWrapper) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	com/tencent/tav/decoder/MediaCodecWrapper$1:this$0	Lcom/tencent/tav/decoder/MediaCodecWrapper;
    //   4: invokestatic 25	com/tencent/tav/decoder/MediaCodecWrapper:access$000	(Lcom/tencent/tav/decoder/MediaCodecWrapper;)Lcom/tencent/tav/decoder/VideoDecoder;
    //   7: invokevirtual 30	com/tencent/tav/decoder/VideoDecoder:releaseOutputBuffer	()V
    //   10: aload_0
    //   11: getfield 12	com/tencent/tav/decoder/MediaCodecWrapper$1:this$0	Lcom/tencent/tav/decoder/MediaCodecWrapper;
    //   14: invokestatic 34	com/tencent/tav/decoder/MediaCodecWrapper:access$100	(Lcom/tencent/tav/decoder/MediaCodecWrapper;)Landroid/media/MediaCodec;
    //   17: invokevirtual 39	android/media/MediaCodec:stop	()V
    //   20: aload_0
    //   21: getfield 12	com/tencent/tav/decoder/MediaCodecWrapper$1:this$0	Lcom/tencent/tav/decoder/MediaCodecWrapper;
    //   24: invokestatic 34	com/tencent/tav/decoder/MediaCodecWrapper:access$100	(Lcom/tencent/tav/decoder/MediaCodecWrapper;)Landroid/media/MediaCodec;
    //   27: invokestatic 45	com/tencent/tav/decoder/MediaCodecManager:releaseCodec	(Landroid/media/MediaCodec;)V
    //   30: goto +21 -> 51
    //   33: astore_1
    //   34: goto +36 -> 70
    //   37: astore_1
    //   38: aload_0
    //   39: getfield 12	com/tencent/tav/decoder/MediaCodecWrapper$1:this$0	Lcom/tencent/tav/decoder/MediaCodecWrapper;
    //   42: invokestatic 49	com/tencent/tav/decoder/MediaCodecWrapper:access$200	(Lcom/tencent/tav/decoder/MediaCodecWrapper;)Ljava/lang/String;
    //   45: ldc 51
    //   47: aload_1
    //   48: invokestatic 57	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   51: aload_0
    //   52: getfield 12	com/tencent/tav/decoder/MediaCodecWrapper$1:this$0	Lcom/tencent/tav/decoder/MediaCodecWrapper;
    //   55: aconst_null
    //   56: invokestatic 61	com/tencent/tav/decoder/MediaCodecWrapper:access$102	(Lcom/tencent/tav/decoder/MediaCodecWrapper;Landroid/media/MediaCodec;)Landroid/media/MediaCodec;
    //   59: pop
    //   60: aload_0
    //   61: getfield 12	com/tencent/tav/decoder/MediaCodecWrapper$1:this$0	Lcom/tencent/tav/decoder/MediaCodecWrapper;
    //   64: aconst_null
    //   65: invokestatic 61	com/tencent/tav/decoder/MediaCodecWrapper:access$102	(Lcom/tencent/tav/decoder/MediaCodecWrapper;Landroid/media/MediaCodec;)Landroid/media/MediaCodec;
    //   68: pop
    //   69: return
    //   70: aload_0
    //   71: getfield 12	com/tencent/tav/decoder/MediaCodecWrapper$1:this$0	Lcom/tencent/tav/decoder/MediaCodecWrapper;
    //   74: aconst_null
    //   75: invokestatic 61	com/tencent/tav/decoder/MediaCodecWrapper:access$102	(Lcom/tencent/tav/decoder/MediaCodecWrapper;Landroid/media/MediaCodec;)Landroid/media/MediaCodec;
    //   78: pop
    //   79: aload_1
    //   80: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	1
    //   33	1	1	localObject	Object
    //   37	43	1	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   0	30	33	finally
    //   38	51	33	finally
    //   0	30	37	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tav.decoder.MediaCodecWrapper.1
 * JD-Core Version:    0.7.0.1
 */