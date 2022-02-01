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
    if ((TeamWorkShareActionSheetBuilder.a(this.a) instanceof CustomWebView))
    {
      if (2 != TeamWorkShareActionSheetBuilder.a(this.a).c) {
        break label57;
      }
      ((CustomWebView)TeamWorkShareActionSheetBuilder.a(this.a)).callJs("openAdvPermissionsMobile()");
      this.a.dismiss();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label57:
      ((CustomWebView)TeamWorkShareActionSheetBuilder.a(this.a)).callJs("openCooperationMobile()");
      this.a.dismiss();
      ReportController.b(TeamWorkShareActionSheetBuilder.a(this.a).app, "dc00898", "", "", "0x8009412", "0x8009412", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkShareActionSheetBuilder.2
 * JD-Core Version:    0.7.0.1
 */