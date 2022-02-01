package com.tencent.mobileqq.vashealth;

import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.superplayer.api.ISuperPlayer;

class HealthBusinessPlugin$17$1
  implements Runnable
{
  HealthBusinessPlugin$17$1(HealthBusinessPlugin.17 param17, TextView paramTextView, ISuperPlayer paramISuperPlayer) {}
  
  public void run()
  {
    ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).setTimeTextForTextView(this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getDurationMs() - this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getCurrentPositionMs());
    ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).setTimeTextForTextView(this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin$17.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getCurrentPositionMs());
    ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).setTimeTextForTextView(this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin$17.b, this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getDurationMs());
    this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin$17.jdField_a_of_type_AndroidWidgetSeekBar.setProgress((int)Math.ceil((float)this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getCurrentPositionMs() * 1.0F / (float)this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getDurationMs() * this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin$17.jdField_a_of_type_AndroidWidgetSeekBar.getMax()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.HealthBusinessPlugin.17.1
 * JD-Core Version:    0.7.0.1
 */