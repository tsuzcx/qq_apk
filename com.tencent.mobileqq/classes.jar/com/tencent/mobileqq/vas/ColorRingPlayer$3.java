package com.tencent.mobileqq.vas;

import android.media.MediaPlayer;
import android.os.Handler;
import bgdv;

public class ColorRingPlayer$3
  implements Runnable
{
  public ColorRingPlayer$3(bgdv parambgdv) {}
  
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
        if ((this.this$0.jdField_a_of_type_AndroidMediaMediaPlayer == null) || (!bool)) {
          break;
        }
        int i = this.this$0.jdField_a_of_type_AndroidMediaMediaPlayer.getDuration();
        int j = this.this$0.jdField_a_of_type_AndroidMediaMediaPlayer.getCurrentPosition();
        this.this$0.jdField_a_of_type_AndroidOsHandler.post(new ColorRingPlayer.3.1(this, j, i));
      }
      catch (IllegalStateException localIllegalStateException)
      {
        for (;;)
        {
          this.this$0.jdField_a_of_type_AndroidMediaMediaPlayer = null;
          this.this$0.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
        }
      }
      finally {}
      try
      {
        Thread.sleep(50L);
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ColorRingPlayer.3
 * JD-Core Version:    0.7.0.1
 */