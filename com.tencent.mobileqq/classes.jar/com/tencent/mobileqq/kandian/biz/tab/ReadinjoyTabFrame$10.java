package com.tencent.mobileqq.kandian.biz.tab;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.diandian.RecommendFeedsDiandianEntranceManager;
import com.tencent.mobileqq.kandian.biz.reddot.ColorBandVideoEntranceButton;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ReadinjoyTabFrame$10
  implements View.OnClickListener
{
  ReadinjoyTabFrame$10(ReadinjoyTabFrame paramReadinjoyTabFrame) {}
  
  public void onClick(View paramView)
  {
    EventCollector.getInstance().onViewClicked(ReadinjoyTabFrame.a(this.a));
    ReadinjoyTabFrame.a(this.a).postDelayed(new ReadinjoyTabFrame.10.1(this, paramView), 300L);
    if ((!RecommendFeedsDiandianEntranceManager.getInstance().isVideoFeedsType()) && (!ReadInJoyHelper.v())) {
      RecommendFeedsDiandianEntranceManager.getInstance().reportEntryIconClick(0, this.a.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.ReadinjoyTabFrame.10
 * JD-Core Version:    0.7.0.1
 */