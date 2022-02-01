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
    ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).setTimeTextForTextView(this.a, this.b.getDurationMs() - this.b.getCurrentPositionMs());
    ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).setTimeTextForTextView(this.c.c, this.b.getCurrentPositionMs());
    ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).setTimeTextForTextView(this.c.d, this.b.getDurationMs());
    this.c.e.setProgress((int)Math.ceil((float)this.b.getCurrentPositionMs() * 1.0F / (float)this.b.getDurationMs() * this.c.e.getMax()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.HealthBusinessPlugin.17.1
 * JD-Core Version:    0.7.0.1
 */