package com.tencent.tav.decoder;

import android.media.MediaCodec;
import java.util.ArrayList;

class AudioDecoder$1
  extends Thread
{
  AudioDecoder$1(AudioDecoder paramAudioDecoder) {}
  
  public void run()
  {
    AudioDecoder.access$000(this.this$0);
    try
    {
      AudioDecoder.access$100(this.this$0).stop();
      try
      {
        AudioDecoder.access$100(this.this$0).release();
        AudioDecoder.access$200().remove(AudioDecoder.access$100(this.this$0).toString());
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localException2.printStackTrace();
          AudioDecoder.access$102(this.this$0, null);
        }
      }
      finally
      {
        AudioDecoder.access$102(this.this$0, null);
      }
      AudioDecoder.access$102(this.this$0, null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.tav.decoder.AudioDecoder.1
 * JD-Core Version:    0.7.0.1
 */