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
    if (this.a.b != null) {
      if (this.a.b.getOutputMute())
      {
        this.a.b.setOutputMute(false);
        this.a.d.setImageResource(2130852636);
      }
      else
      {
        this.a.b.setOutputMute(true);
        this.a.d.setImageResource(2130852637);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.splashad.SplashADView.2
 * JD-Core Version:    0.7.0.1
 */