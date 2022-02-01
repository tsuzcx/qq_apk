package com.tencent.tav.decoder;

import android.media.MediaCodec;

class MediaCodecWrapper$1
  extends Thread
{
  MediaCodecWrapper$1(MediaCodecWrapper paramMediaCodecWrapper) {}
  
  public void run()
  {
    try
    {
      MediaCodecWrapper.access$000(this.this$0).releaseOutputBuffer();
      MediaCodecWrapper.access$100(this.this$0).stop();
      try
      {
        MediaCodecWrapper.access$100(this.this$0).release();
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localException2.printStackTrace();
          MediaCodecWrapper.access$102(this.this$0, null);
        }
      }
      finally
      {
        MediaCodecWrapper.access$102(this.this$0, null);
      }
      MediaCodecWrapper.access$102(this.this$0, null);
      return;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        localException1.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tav.decoder.MediaCodecWrapper.1
 * JD-Core Version:    0.7.0.1
 */