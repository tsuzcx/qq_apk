package com.tencent.mobileqq.vastrash;

import android.media.MediaPlayer;
import android.os.Handler;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;

class ColorRingPlayer$3
  implements Runnable
{
  ColorRingPlayer$3(ColorRingPlayer paramColorRingPlayer) {}
  
  public void run()
  {
    for (;;)
    {
      Object localObject1 = this.this$0.jdField_a_of_type_JavaLangObject;
      boolean bool = false;
      try
      {
        if (this.this$0.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
          bool = this.this$0.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying();
        }
        if ((this.this$0.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (bool))
        {
          int i = this.this$0.jdField_a_of_type_AndroidMediaMediaPlayer.getDuration();
          int j = this.this$0.jdField_a_of_type_AndroidMediaMediaPlayer.getCurrentPosition();
          this.this$0.jdField_a_of_type_AndroidOsHandler.post(new ColorRingPlayer.3.1(this, j, i));
          break label121;
        }
        return;
      }
      catch (IllegalStateException localIllegalStateException) {}finally
      {
        label121:
        break;
      }
      this.this$0.jdField_a_of_type_AndroidMediaMediaPlayer = null;
      this.this$0.jdField_a_of_type_AndroidMediaMediaPlayer = new ReportMediaPlayer();
      try
      {
        Thread.sleep(50L);
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
    }
    for (;;)
    {
      Object localObject2;
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vastrash.ColorRingPlayer.3
 * JD-Core Version:    0.7.0.1
 */