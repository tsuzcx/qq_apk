package com.tencent.tav.decoder;

import android.media.MediaCodec;
import com.tencent.tav.decoder.logger.Logger;
import java.util.ArrayList;

class AudioDecoder$1
  implements Runnable
{
  AudioDecoder$1(AudioDecoder paramAudioDecoder) {}
  
  public void run()
  {
    AudioDecoder.access$000(this.this$0);
    try
    {
      AudioDecoder.access$100(this.this$0).stop();
      MediaCodecManager.releaseCodec(AudioDecoder.access$100(this.this$0));
      AudioDecoder.access$200().remove(AudioDecoder.access$100(this.this$0).toString());
      return;
    }
    catch (Exception localException)
    {
      Logger.e(AudioDecoder.access$300(this.this$0), "release: ", localException);
      return;
    }
    finally
    {
      AudioDecoder.access$102(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tav.decoder.AudioDecoder.1
 * JD-Core Version:    0.7.0.1
 */