package com.tencent.mobileqq.now.recommend;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.now.roport.NowQQLiveDataReport;
import com.tencent.mobileqq.now.utils.NowRoomUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class NowQQLiveRecommendAnchorHandler$1
  implements View.OnClickListener
{
  NowQQLiveRecommendAnchorHandler$1(BaseActivity paramBaseActivity, RecommendAnchorInfo paramRecommendAnchorInfo, int paramInt) {}
  
  public void onClick(View paramView)
  {
    NowRoomUtil.a(this.a, this.b.g, this.b.c, 60011);
    NowQQLiveDataReport.b(this.b.h, this.c);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.now.recommend.NowQQLiveRecommendAnchorHandler.1
 * JD-Core Version:    0.7.0.1
 */