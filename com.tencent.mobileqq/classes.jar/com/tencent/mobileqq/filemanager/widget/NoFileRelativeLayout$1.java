package com.tencent.mobileqq.filemanager.widget;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NoFileRelativeLayout$1
  implements View.OnClickListener
{
  NoFileRelativeLayout$1(NoFileRelativeLayout paramNoFileRelativeLayout) {}
  
  public void onClick(View paramView)
  {
    ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).jumpToTencentDocIndex((Activity)this.a.getContext(), "s_qq_myfile_yindao", -1);
    ReportController.b(null, "dc00898", "", "", "0X800A226", "0X800A226", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.NoFileRelativeLayout.1
 * JD-Core Version:    0.7.0.1
 */