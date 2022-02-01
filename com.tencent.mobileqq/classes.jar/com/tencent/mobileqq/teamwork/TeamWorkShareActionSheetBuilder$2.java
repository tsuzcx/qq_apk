package com.tencent.mobileqq.teamwork;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TeamWorkShareActionSheetBuilder$2
  implements View.OnClickListener
{
  TeamWorkShareActionSheetBuilder$2(TeamWorkShareActionSheetBuilder paramTeamWorkShareActionSheetBuilder) {}
  
  public void onClick(View paramView)
  {
    if ((TeamWorkShareActionSheetBuilder.g(this.a) instanceof CustomWebView)) {
      if (2 == TeamWorkShareActionSheetBuilder.h(this.a).h)
      {
        ((CustomWebView)TeamWorkShareActionSheetBuilder.g(this.a)).callJs("openAdvPermissionsMobile()");
        this.a.dismiss();
      }
      else
      {
        ((CustomWebView)TeamWorkShareActionSheetBuilder.g(this.a)).callJs("openCooperationMobile()");
        this.a.dismiss();
        ReportController.b(TeamWorkShareActionSheetBuilder.f(this.a).getAppRuntime(), "dc00898", "", "", "0x8009412", "0x8009412", 0, 0, "", "", "", "");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkShareActionSheetBuilder.2
 * JD-Core Version:    0.7.0.1
 */