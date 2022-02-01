package com.tencent.mobileqq.profilecard.bussiness.achievement.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.profilecard.bussiness.achievement.LifeAchivementHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LifeAchivementPanelView$1
  implements View.OnClickListener
{
  LifeAchivementPanelView$1(LifeAchivementPanelView paramLifeAchivementPanelView) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LifeAchivementPanelView", 2, "addAchivementBtn onClicked");
    }
    LifeAchivementHelper.jumpToLifeAchivementMiniAppAddPage(LifeAchivementPanelView.access$000(this.this$0));
    ReportController.b(null, "", "", "", "0X800AE54", "0X800AE54", 1, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.achievement.view.LifeAchivementPanelView.1
 * JD-Core Version:    0.7.0.1
 */