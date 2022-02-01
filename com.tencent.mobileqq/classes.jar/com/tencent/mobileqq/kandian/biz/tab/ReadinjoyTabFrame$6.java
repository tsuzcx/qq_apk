package com.tencent.mobileqq.kandian.biz.tab;

import com.tencent.mobileqq.kandian.biz.diandian.RecommendFeedsDiandianEntranceManager;
import com.tencent.mobileqq.kandian.biz.push.RIJPushNotifyManager;
import com.tencent.mobileqq.kandian.biz.push.RIJPushNotifyManager.Companion;
import com.tencent.mobileqq.kandian.biz.reddot.ColorBandVideoEntranceButton;

class ReadinjoyTabFrame$6
  implements ReadInJoyChannelViewPagerController.OnChannelChangeListener
{
  ReadinjoyTabFrame$6(ReadinjoyTabFrame paramReadinjoyTabFrame) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((!ReadinjoyTabFrame.e(this.a)) && (ReadinjoyTabFrame.f(this.a) != null) && (ReadinjoyTabFrame.f(this.a).getVisibility() == 0)) {
      RecommendFeedsDiandianEntranceManager.getInstance().reportEntryIconExposure(0, paramInt2);
    }
    RIJPushNotifyManager.Companion.a().dismiss(true, "MATCH_ALL_UIN");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.ReadinjoyTabFrame.6
 * JD-Core Version:    0.7.0.1
 */