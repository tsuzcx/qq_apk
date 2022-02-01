package com.tencent.mobileqq.vashealth;

import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.superplayer.api.ISuperPlayer;

class HealthBusinessPlugin$15$1
  implements Runnable
{
  HealthBusinessPlugin$15$1(HealthBusinessPlugin.15 param15, TextView paramTextView, ISuperPlayer paramISuperPlayer) {}
  
  public void run()
  {
    VideoFeedsHelper.a(this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getDurationMs() - this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getCurrentPositionMs());
    VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin$15.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getCurrentPositionMs());
    VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin$15.b, this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getDurationMs());
    this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin$15.jdField_a_of_type_AndroidWidgetSeekBar.setProgress((int)Math.ceil(1.0F * (float)this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getCurrentPositionMs() / (float)this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getDurationMs() * this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin$15.jdField_a_of_type_AndroidWidgetSeekBar.getMax()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.HealthBusinessPlugin.15.1
 * JD-Core Version:    0.7.0.1
 */