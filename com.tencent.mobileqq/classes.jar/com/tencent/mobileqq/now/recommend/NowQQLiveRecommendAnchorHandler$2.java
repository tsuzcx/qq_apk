package com.tencent.mobileqq.now.recommend;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class NowQQLiveRecommendAnchorHandler$2
  implements View.OnClickListener
{
  NowQQLiveRecommendAnchorHandler$2(BaseActivity paramBaseActivity, NoDataViewHolder paramNoDataViewHolder) {}
  
  public void onClick(View paramView)
  {
    NowQQLiveRecommendAnchorHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqNowRecommendNoDataViewHolder);
    SimpleEventBus.getInstance().dispatchEvent(new NoRecommendDataEvent());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.now.recommend.NowQQLiveRecommendAnchorHandler.2
 * JD-Core Version:    0.7.0.1
 */