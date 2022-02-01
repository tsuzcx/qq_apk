package com.tencent.mobileqq.kandian.ad.api.impl;

import android.app.Activity;
import android.content.Context;
import android.hardware.SensorManager;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.alphaplayer.AlphaPlayerView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdMiniGuide;
import com.tencent.mobileqq.app.ShakeListener;
import com.tencent.mobileqq.kandian.biz.video.feeds.api.IVideoPlayManager;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;

class RIJAdShakeManagerImpl$2
  extends ShakeListener
{
  RIJAdShakeManagerImpl$2(RIJAdShakeManagerImpl paramRIJAdShakeManagerImpl) {}
  
  protected void a()
  {
    if (RIJAdShakeManagerImpl.access$1300(this.a))
    {
      if (RIJAdShakeManagerImpl.access$1000(this.a) == null) {
        return;
      }
      if (RIJAdShakeManagerImpl.access$1400(this.a) != null) {
        RIJAdShakeManagerImpl.access$1400(this.a).c();
      }
      RIJAdShakeManagerImpl.access$1502(this.a, true);
      RIJAdShakeManagerImpl.access$1600(this.a);
      ((SensorManager)RIJAdShakeManagerImpl.access$1000(this.a).getSystemService("sensor")).unregisterListener(this);
      if (RIJAdShakeManagerImpl.access$400(this.a) != null) {
        RIJAdShakeManagerImpl.access$400(this.a).c();
      }
      RIJAdShakeManagerImpl localRIJAdShakeManagerImpl = this.a;
      RIJAdShakeManagerImpl.access$1702(localRIJAdShakeManagerImpl, (FrameLayout)((Activity)RIJAdShakeManagerImpl.access$1000(localRIJAdShakeManagerImpl)).getWindow().getDecorView().getRootView().findViewById(16908290));
      if (RIJAdShakeManagerImpl.access$1700(this.a) != null)
      {
        if ((RIJAdShakeManagerImpl.access$1800(this.a) != null) && (RIJAdShakeManagerImpl.access$1800(this.a).getParent() != null)) {
          return;
        }
        localRIJAdShakeManagerImpl = this.a;
        RIJAdShakeManagerImpl.access$002(localRIJAdShakeManagerImpl, RIJAdShakeManagerImpl.access$2000(localRIJAdShakeManagerImpl, RIJAdShakeManagerImpl.access$1700(localRIJAdShakeManagerImpl), RIJAdShakeManagerImpl.access$1900(this.a), false, 0));
        RIJAdShakeManagerImpl.access$000(this.a).setOnClickListener(RIJAdShakeManagerImpl.access$2100(this.a));
        RIJAdShakeManagerImpl.access$2202(false);
        if (RIJAdShakeManagerImpl.access$500(this.a) != null)
        {
          localRIJAdShakeManagerImpl = this.a;
          RIJAdShakeManagerImpl.access$2300(localRIJAdShakeManagerImpl, RIJAdShakeManagerImpl.access$1000(localRIJAdShakeManagerImpl), (AdvertisementInfo)RIJAdShakeManagerImpl.access$500(this.a).D, 0);
        }
        RIJAdShakeManagerImpl.access$2400(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.impl.RIJAdShakeManagerImpl.2
 * JD-Core Version:    0.7.0.1
 */