package com.tencent.mobileqq.kandian.ad.api.impl;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.biz.video.feeds.api.IVideoPlayManager;

class RIJAdShakeManagerImpl$1
  implements View.OnClickListener
{
  RIJAdShakeManagerImpl$1(RIJAdShakeManagerImpl paramRIJAdShakeManagerImpl) {}
  
  public void onClick(View paramView)
  {
    if (paramView == RIJAdShakeManagerImpl.access$000(this.a)) {
      return;
    }
    RIJAdShakeManagerImpl.access$102(true);
    if (paramView == RIJAdShakeManagerImpl.access$200(this.a))
    {
      RIJAdShakeManagerImpl.access$300(this.a);
      if ((RIJAdShakeManagerImpl.access$400(this.a) != null) && (RIJAdShakeManagerImpl.access$500(this.a) != null)) {
        RIJAdShakeManagerImpl.access$400(this.a).a(RIJAdShakeManagerImpl.access$500(this.a));
      }
      RIJAdShakeManagerImpl.access$600(this.a);
      return;
    }
    RIJAdShakeManagerImpl.access$700(this.a, 1000);
    RIJAdShakeManagerImpl.access$800(this.a);
    RIJAdShakeManagerImpl.access$902(this.a, true);
    paramView = this.a;
    RIJAdShakeManagerImpl.access$1200(paramView, (Activity)RIJAdShakeManagerImpl.access$1000(paramView), RIJAdShakeManagerImpl.access$500(this.a), RIJAdShakeManagerImpl.access$1100(), false, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.impl.RIJAdShakeManagerImpl.1
 * JD-Core Version:    0.7.0.1
 */