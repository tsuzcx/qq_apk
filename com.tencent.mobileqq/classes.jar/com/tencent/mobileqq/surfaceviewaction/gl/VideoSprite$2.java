package com.tencent.mobileqq.surfaceviewaction.gl;

import android.media.MediaPlayer;
import bdfn;
import bdga;
import com.tencent.qphone.base.util.QLog;

public class VideoSprite$2
  implements Runnable
{
  VideoSprite$2(VideoSprite paramVideoSprite, String paramString, int paramInt) {}
  
  public void run()
  {
    if (((this.this$0.b == null) || (!this.this$0.b.equals(this.jdField_a_of_type_JavaLangString)) || (!this.this$0.g)) && (this.this$0.jdField_a_of_type_AndroidMediaMediaPlayer != null))
    {
      this.this$0.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
      this.this$0.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
    }
    try
    {
      this.this$0.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(this.jdField_a_of_type_JavaLangString);
      this.this$0.jdField_a_of_type_AndroidMediaMediaPlayer.prepare();
      this.this$0.n = this.this$0.jdField_a_of_type_AndroidMediaMediaPlayer.getVideoWidth();
      this.this$0.o = this.this$0.jdField_a_of_type_AndroidMediaMediaPlayer.getVideoHeight();
      this.this$0.jdField_a_of_type_AndroidMediaMediaPlayer.setOnSeekCompleteListener(new bdga(this));
      this.this$0.jdField_a_of_type_AndroidMediaMediaPlayer.seekTo(this.jdField_a_of_type_Int);
      this.this$0.b = this.jdField_a_of_type_JavaLangString;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("VideoSprite", 2, "playVideo Exception: " + QLog.getStackTraceString(localException));
        }
        if (this.this$0.jdField_a_of_type_Bdfn != null) {
          this.this$0.jdField_a_of_type_Bdfn.a();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite.2
 * JD-Core Version:    0.7.0.1
 */