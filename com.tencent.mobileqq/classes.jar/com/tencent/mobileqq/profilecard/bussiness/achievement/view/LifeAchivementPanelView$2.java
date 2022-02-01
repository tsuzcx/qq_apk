package com.tencent.mobileqq.profilecard.bussiness.achievement.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.profilecard.bussiness.achievement.LifeAchivementHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LifeAchivementPanelView$2
  implements View.OnClickListener
{
  LifeAchivementPanelView$2(LifeAchivementPanelView paramLifeAchivementPanelView) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LifeAchivementPanelView", 2, "DATA_TYPE_LIFE_ACHIVEMENT_TITLE on click");
    }
    LifeAchivementHelper.jumpToLifeAchivementMiniAppAchivementListPage(LifeAchivementPanelView.access$100(this.this$0), this.this$0.userOpenID);
    int i;
    if (LifeAchivementPanelView.access$200(this.this$0)) {
      i = 1;
    } else {
      i = 2;
    }
    ReportController.b(null, "", "", "", "0X800AE57", "0X800AE57", i, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.achievement.view.LifeAchivementPanelView.2
 * JD-Core Version:    0.7.0.1
 */