package com.tencent.mobileqq.profilecard.bussiness.achievement.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LifeAchivementAdapter$2
  implements View.OnClickListener
{
  LifeAchivementAdapter$2(LifeAchivementAdapter paramLifeAchivementAdapter, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.itemClickListener != null) {
      this.this$0.itemClickListener.onClickPraise(paramView, this.val$position);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.achievement.view.LifeAchivementAdapter.2
 * JD-Core Version:    0.7.0.1
 */