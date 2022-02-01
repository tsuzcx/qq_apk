package com.tencent.tav.decoder;

import android.media.MediaCodec;
import com.tencent.tav.decoder.logger.Logger;

class MediaCodecWrapper$1
  implements Runnable
{
  MediaCodecWrapper$1(MediaCodecWrapper paramMediaCodecWrapper) {}
  
  public void run()
  {
    try
    {
      MediaCodecWrapper.access$000(this.this$0).releaseOutputBuffer();
      MediaCodecWrapper.access$100(this.this$0).stop();
      MediaCodecManager.releaseCodec(MediaCodecWrapper.access$100(this.this$0));
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Logger.e(MediaCodecWrapper.access$200(this.this$0), "release: ", localException);
        MediaCodecWrapper.access$102(this.this$0, null);
      }
    }
    finally
    {
      MediaCodecWrapper.access$102(this.this$0, null);
    }
    MediaCodecWrapper.access$102(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tav.decoder.MediaCodecWrapper.1
 * JD-Core Version:    0.7.0.1
 */