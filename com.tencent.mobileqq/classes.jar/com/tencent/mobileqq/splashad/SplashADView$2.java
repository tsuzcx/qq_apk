package com.tencent.mobileqq.splashad;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SplashADView$2
  implements View.OnClickListener
{
  SplashADView$2(SplashADView paramSplashADView) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      if (this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getOutputMute())
      {
        this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOutputMute(false);
        this.a.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850806);
      }
      else
      {
        this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOutputMute(true);
        this.a.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850807);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.splashad.SplashADView.2
 * JD-Core Version:    0.7.0.1
 */