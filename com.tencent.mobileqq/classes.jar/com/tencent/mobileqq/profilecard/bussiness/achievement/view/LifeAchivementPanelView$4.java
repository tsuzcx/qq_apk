package com.tencent.mobileqq.profilecard.bussiness.achievement.view;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.mobileqq.statistics.ReportController;

class LifeAchivementPanelView$4
  extends RecyclerView.OnScrollListener
{
  LifeAchivementPanelView$4(LifeAchivementPanelView paramLifeAchivementPanelView) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if (paramInt == 0)
    {
      if (LifeAchivementPanelView.access$200(this.this$0)) {
        paramInt = 1;
      } else {
        paramInt = 2;
      }
      ReportController.b(null, "", "", "", "0X800AE55", "0X800AE55", paramInt, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.achievement.view.LifeAchivementPanelView.4
 * JD-Core Version:    0.7.0.1
 */