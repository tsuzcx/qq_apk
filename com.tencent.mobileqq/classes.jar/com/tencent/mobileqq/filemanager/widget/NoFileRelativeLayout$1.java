package com.tencent.mobileqq.filemanager.widget;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.fileassistant.FileAssistantActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NoFileRelativeLayout$1
  implements View.OnClickListener
{
  NoFileRelativeLayout$1(NoFileRelativeLayout paramNoFileRelativeLayout) {}
  
  public void onClick(View paramView)
  {
    TeamWorkUtils.a((Activity)this.a.getContext(), "s_qq_myfile_yindao", -1);
    if ((this.a.getContext() instanceof FMActivity)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.a.getContext() instanceof FileAssistantActivity)) {
        ReportController.b(((FileAssistantActivity)this.a.getContext()).app, "dc00898", "", "", "0X800A226", "0X800A226", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.NoFileRelativeLayout.1
 * JD-Core Version:    0.7.0.1
 */