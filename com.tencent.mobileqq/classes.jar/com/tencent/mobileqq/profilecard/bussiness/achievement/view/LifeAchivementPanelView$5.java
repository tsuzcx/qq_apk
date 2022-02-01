package com.tencent.mobileqq.profilecard.bussiness.achievement.view;

import android.content.res.Resources;
import android.view.View;
import com.tencent.mobileqq.profilecard.bussiness.achievement.LifeAchivementHelper;
import com.tencent.mobileqq.profilecard.bussiness.achievement.bean.LifeAchivementData;
import com.tencent.mobileqq.profilecard.bussiness.achievement.handler.LifeAchievementHandler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class LifeAchivementPanelView$5
  implements LifeAchivementAdapter.OnItemClickListener
{
  LifeAchivementPanelView$5(LifeAchivementPanelView paramLifeAchivementPanelView) {}
  
  public void onClickAchivement(View paramView, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("onClickAchivement position = ");
      paramView.append(paramInt);
      QLog.i("LifeAchivementPanelView", 2, paramView.toString());
    }
    paramView = this.this$0.achivementAdapter.getDataByPosition(paramInt);
    if (paramView != null)
    {
      if (paramView.type == 2)
      {
        LifeAchivementHelper.jumpToLifeAchivementMiniAppAchivementListPage(LifeAchivementPanelView.access$300(this.this$0), this.this$0.userOpenID);
        if (LifeAchivementPanelView.access$200(this.this$0)) {
          paramInt = 1;
        } else {
          paramInt = 2;
        }
        ReportController.b(null, "", "", "", "0X800AE59", "0X800AE59", paramInt, 0, "", "", "", "");
        return;
      }
      if (paramView.type == 1)
      {
        LifeAchivementHelper.jumpToLifeAchivementMiniAppAddPage(LifeAchivementPanelView.access$400(this.this$0));
        ReportController.b(null, "", "", "", "0X800AE54", "0X800AE54", 2, 0, "", "", "", "");
        return;
      }
      LifeAchivementHelper.jumpToLifeAchivementMiniAppAchiivementDetailPage(LifeAchivementPanelView.access$500(this.this$0), this.this$0.userOpenID, paramView.id);
      if (LifeAchivementPanelView.access$200(this.this$0)) {
        paramInt = 1;
      } else {
        paramInt = 2;
      }
      ReportController.b(null, "", "", "", "0X800AE58", "0X800AE58", paramInt, 0, "", "", "", "");
    }
  }
  
  public void onClickPraise(View paramView, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onClickPraise position = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",isSelf = ");
      localStringBuilder.append(LifeAchivementPanelView.access$200(this.this$0));
      localStringBuilder.append(",isFriend = ");
      localStringBuilder.append(LifeAchivementPanelView.access$600(this.this$0));
      QLog.i("LifeAchivementPanelView", 2, localStringBuilder.toString());
    }
    LifeAchivementHelper.setViewClickInterval(paramView);
    if ((!LifeAchivementPanelView.access$200(this.this$0)) && (!LifeAchivementPanelView.access$600(this.this$0)))
    {
      QQToast.makeText(LifeAchivementPanelView.access$700(this.this$0), paramView.getResources().getString(2131896970), 0).show();
      return;
    }
    paramView = this.this$0.achivementAdapter.getDataByPosition(paramInt);
    if (paramView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("LifeAchivementPanelView", 2, "onClickPraise return for null data");
      }
      return;
    }
    int i;
    if (paramView.hasPraised) {
      i = 2;
    } else {
      i = 1;
    }
    LifeAchivementPanelView.access$800(this.this$0, paramView, paramInt, i);
    if (this.this$0.lifeAchievementHandler != null) {
      this.this$0.lifeAchievementHandler.praiseLifeAchievement(this.this$0.userUin, paramView.id, i);
    }
    if (LifeAchivementPanelView.access$200(this.this$0)) {
      paramInt = 1;
    } else {
      paramInt = 2;
    }
    ReportController.b(null, "", "", "", "0X800AE56", "0X800AE56", paramInt, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.achievement.view.LifeAchivementPanelView.5
 * JD-Core Version:    0.7.0.1
 */