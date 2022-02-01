package com.tencent.tav.decoder;

class AudioDecoder$1
  implements Runnable
{
  AudioDecoder$1(AudioDecoder paramAudioDecoder) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	com/tencent/tav/decoder/AudioDecoder$1:this$0	Lcom/tencent/tav/decoder/AudioDecoder;
    //   4: invokestatic 24	com/tencent/tav/decoder/AudioDecoder:access$000	(Lcom/tencent/tav/decoder/AudioDecoder;)V
    //   7: aload_0
    //   8: getfield 12	com/tencent/tav/decoder/AudioDecoder$1:this$0	Lcom/tencent/tav/decoder/AudioDecoder;
    //   11: invokestatic 28	com/tencent/tav/decoder/AudioDecoder:access$100	(Lcom/tencent/tav/decoder/AudioDecoder;)Landroid/media/MediaCodec;
    //   14: invokevirtual 33	android/media/MediaCodec:stop	()V
    //   17: aload_0
    //   18: getfield 12	com/tencent/tav/decoder/AudioDecoder$1:this$0	Lcom/tencent/tav/decoder/AudioDecoder;
    //   21: invokestatic 28	com/tencent/tav/decoder/AudioDecoder:access$100	(Lcom/tencent/tav/decoder/AudioDecoder;)Landroid/media/MediaCodec;
    //   24: invokestatic 39	com/tencent/tav/decoder/MediaCodecManager:releaseCodec	(Landroid/media/MediaCodec;)V
    //   27: invokestatic 43	com/tencent/tav/decoder/AudioDecoder:access$200	()Ljava/util/ArrayList;
    //   30: aload_0
    //   31: getfield 12	com/tencent/tav/decoder/AudioDecoder$1:this$0	Lcom/tencent/tav/decoder/AudioDecoder;
    //   34: invokestatic 28	com/tencent/tav/decoder/AudioDecoder:access$100	(Lcom/tencent/tav/decoder/AudioDecoder;)Landroid/media/MediaCodec;
    //   37: invokevirtual 47	java/lang/Object:toString	()Ljava/lang/String;
    //   40: invokevirtual 53	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   43: pop
    //   44: goto +21 -> 65
    //   47: astore_1
    //   48: goto +27 -> 75
    //   51: astore_1
    //   52: aload_0
    //   53: getfield 12	com/tencent/tav/decoder/AudioDecoder$1:this$0	Lcom/tencent/tav/decoder/AudioDecoder;
    //   56: invokestatic 57	com/tencent/tav/decoder/AudioDecoder:access$300	(Lcom/tencent/tav/decoder/AudioDecoder;)Ljava/lang/String;
    //   59: ldc 59
    //   61: aload_1
    //   62: invokestatic 65	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   65: aload_0
    //   66: getfield 12	com/tencent/tav/decoder/AudioDecoder$1:this$0	Lcom/tencent/tav/decoder/AudioDecoder;
    //   69: aconst_null
    //   70: invokestatic 69	com/tencent/tav/decoder/AudioDecoder:access$102	(Lcom/tencent/tav/decoder/AudioDecoder;Landroid/media/MediaCodec;)Landroid/media/MediaCodec;
    //   73: pop
    //   74: return
    //   75: aload_0
    //   76: getfield 12	com/tencent/tav/decoder/AudioDecoder$1:this$0	Lcom/tencent/tav/decoder/AudioDecoder;
    //   79: aconst_null
    //   80: invokestatic 69	com/tencent/tav/decoder/AudioDecoder:access$102	(Lcom/tencent/tav/decoder/AudioDecoder;Landroid/media/MediaCodec;)Landroid/media/MediaCodec;
    //   83: pop
    //   84: aload_1
    //   85: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	this	1
    //   47	1	1	localObject	Object
    //   51	34	1	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   7	44	47	finally
    //   52	65	47	finally
    //   7	44	51	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.decoder.AudioDecoder.1
 * JD-Core Version:    0.7.0.1
 */