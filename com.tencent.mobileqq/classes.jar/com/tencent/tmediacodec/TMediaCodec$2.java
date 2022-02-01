package com.tencent.tmediacodec;

import com.tencent.tmediacodec.callback.CodecCallback;
import com.tencent.tmediacodec.statistics.MediaCodecStatistics;

class TMediaCodec$2
  implements Runnable
{
  TMediaCodec$2(TMediaCodec paramTMediaCodec) {}
  
  public void run()
  {
    if (TMediaCodec.access$100(this.this$0) != null) {
      TMediaCodec.access$100(this.this$0).onStarted(Boolean.valueOf(this.this$0.isReUsed), TMediaCodec.access$200(this.this$0).getData());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tmediacodec.TMediaCodec.2
 * JD-Core Version:    0.7.0.1
 */