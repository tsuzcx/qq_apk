package com.tencent.mobileqq.vastrash;

import android.media.MediaPlayer;
import android.widget.ProgressBar;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;

class ColorRingPlayer$3$1
  implements Runnable
{
  ColorRingPlayer$3$1(ColorRingPlayer.3 param3, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$3.this$0.jdField_a_of_type_AndroidMediaMediaPlayer == null) {
        break label64;
      }
      bool1 = this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$3.this$0.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying();
    }
    catch (IllegalStateException localIllegalStateException)
    {
      label34:
      break label34;
    }
    this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$3.this$0.jdField_a_of_type_AndroidMediaMediaPlayer = null;
    this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$3.this$0.jdField_a_of_type_AndroidMediaMediaPlayer = new ReportMediaPlayer();
    bool1 = bool2;
    label64:
    if ((this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$3.this$0.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (bool1)) {
      this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$3.this$0.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(this.jdField_a_of_type_Int * 100 / this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vastrash.ColorRingPlayer.3.1
 * JD-Core Version:    0.7.0.1
 */