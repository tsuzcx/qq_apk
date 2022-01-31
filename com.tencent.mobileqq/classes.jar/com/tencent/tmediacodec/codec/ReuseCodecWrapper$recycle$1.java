package com.tencent.tmediacodec.codec;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 15})
final class ReuseCodecWrapper$recycle$1
  extends Lambda
  implements Function0<Unit>
{
  ReuseCodecWrapper$recycle$1(ReuseCodecWrapper paramReuseCodecWrapper)
  {
    super(0);
  }
  
  /* Error */
  public final void invoke()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 27	com/tencent/tmediacodec/codec/ReuseCodecWrapper$recycle$1:this$0	Lcom/tencent/tmediacodec/codec/ReuseCodecWrapper;
    //   4: invokevirtual 49	com/tencent/tmediacodec/codec/ReuseCodecWrapper:getCodec	()Landroid/media/MediaCodec;
    //   7: invokevirtual 54	android/media/MediaCodec:stop	()V
    //   10: aload_0
    //   11: getfield 27	com/tencent/tmediacodec/codec/ReuseCodecWrapper$recycle$1:this$0	Lcom/tencent/tmediacodec/codec/ReuseCodecWrapper;
    //   14: invokevirtual 49	com/tencent/tmediacodec/codec/ReuseCodecWrapper:getCodec	()Landroid/media/MediaCodec;
    //   17: invokevirtual 57	android/media/MediaCodec:release	()V
    //   20: aload_0
    //   21: getfield 27	com/tencent/tmediacodec/codec/ReuseCodecWrapper$recycle$1:this$0	Lcom/tencent/tmediacodec/codec/ReuseCodecWrapper;
    //   24: iconst_0
    //   25: invokestatic 61	com/tencent/tmediacodec/codec/ReuseCodecWrapper:access$releaseStoreSurfaceTexture	(Lcom/tencent/tmediacodec/codec/ReuseCodecWrapper;Z)V
    //   28: aload_0
    //   29: getfield 27	com/tencent/tmediacodec/codec/ReuseCodecWrapper$recycle$1:this$0	Lcom/tencent/tmediacodec/codec/ReuseCodecWrapper;
    //   32: invokevirtual 65	com/tencent/tmediacodec/codec/ReuseCodecWrapper:getCallback	()Lcom/tencent/tmediacodec/callback/CodecCallback;
    //   35: astore_1
    //   36: aload_1
    //   37: ifnull +9 -> 46
    //   40: aload_1
    //   41: invokeinterface 70 1 0
    //   46: return
    //   47: astore_1
    //   48: aload_0
    //   49: getfield 27	com/tencent/tmediacodec/codec/ReuseCodecWrapper$recycle$1:this$0	Lcom/tencent/tmediacodec/codec/ReuseCodecWrapper;
    //   52: invokevirtual 49	com/tencent/tmediacodec/codec/ReuseCodecWrapper:getCodec	()Landroid/media/MediaCodec;
    //   55: invokevirtual 57	android/media/MediaCodec:release	()V
    //   58: aload_1
    //   59: athrow
    //   60: astore_1
    //   61: getstatic 75	com/tencent/tmediacodec/util/LogUtils:INSTANCE	Lcom/tencent/tmediacodec/util/LogUtils;
    //   64: ldc 77
    //   66: ldc 79
    //   68: aload_1
    //   69: invokevirtual 83	com/tencent/tmediacodec/util/LogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   72: goto -44 -> 28
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	1
    //   35	6	1	localCodecCallback	com.tencent.tmediacodec.callback.CodecCallback
    //   47	12	1	localObject	java.lang.Object
    //   60	9	1	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   0	10	47	finally
    //   10	28	60	java/lang/Throwable
    //   48	60	60	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmediacodec.codec.ReuseCodecWrapper.recycle.1
 * JD-Core Version:    0.7.0.1
 */