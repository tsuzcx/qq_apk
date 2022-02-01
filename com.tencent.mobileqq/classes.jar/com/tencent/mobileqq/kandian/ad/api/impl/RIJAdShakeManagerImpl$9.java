package com.tencent.mobileqq.kandian.ad.api.impl;

import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.alphaplayer.AlphaPlayerListener;

class RIJAdShakeManagerImpl$9
  implements AlphaPlayerListener
{
  RIJAdShakeManagerImpl$9(RIJAdShakeManagerImpl paramRIJAdShakeManagerImpl, int paramInt) {}
  
  public void a(int paramInt) {}
  
  public void a(View paramView)
  {
    int i = this.a;
    if (i == 0)
    {
      paramView = this.b;
      RIJAdShakeManagerImpl.access$2800(paramView, RIJAdShakeManagerImpl.access$000(paramView));
      if ((RIJAdShakeManagerImpl.access$2900()) && ((!TextUtils.isEmpty(RIJAdShakeManagerImpl.access$3000(this.b))) || (!TextUtils.isEmpty(RIJAdShakeManagerImpl.access$3100(this.b)))))
      {
        paramView = this.b;
        RIJAdShakeManagerImpl.access$3200(paramView, RIJAdShakeManagerImpl.access$1700(paramView));
        return;
      }
      RIJAdShakeManagerImpl.access$2700(this.b, true);
      return;
    }
    if (i == 1)
    {
      paramView = this.b;
      RIJAdShakeManagerImpl.access$2800(paramView, RIJAdShakeManagerImpl.access$3300(paramView));
    }
  }
  
  public void b(View paramView) {}
  
  public void c(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.impl.RIJAdShakeManagerImpl.9
 * JD-Core Version:    0.7.0.1
 */