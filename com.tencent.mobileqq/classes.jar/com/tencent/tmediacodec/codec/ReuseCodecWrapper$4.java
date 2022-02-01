package com.tencent.tmediacodec.codec;

import android.media.MediaCodec;
import com.tencent.tmediacodec.callback.CodecCallback;
import com.tencent.tmediacodec.util.LogUtils;

class ReuseCodecWrapper$4
  implements Runnable
{
  ReuseCodecWrapper$4(ReuseCodecWrapper paramReuseCodecWrapper) {}
  
  public void run()
  {
    try
    {
      ReuseCodecWrapper.access$300(this.this$0).stop();
      return;
    }
    finally
    {
      try
      {
        ReuseCodecWrapper.access$300(this.this$0).release();
        ReuseCodecWrapper.access$400(this.this$0, false);
      }
      catch (Throwable localThrowable)
      {
        LogUtils.w(this.this$0.TAG, "recycle codec ignore error,", localThrowable);
        if (ReuseCodecWrapper.access$500(this.this$0) == null) {
          return;
        }
        ReuseCodecWrapper.access$500(this.this$0).onRealRelease();
      }
      localObject = finally;
      ReuseCodecWrapper.access$300(this.this$0).release();
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmediacodec.codec.ReuseCodecWrapper.4
 * JD-Core Version:    0.7.0.1
 */