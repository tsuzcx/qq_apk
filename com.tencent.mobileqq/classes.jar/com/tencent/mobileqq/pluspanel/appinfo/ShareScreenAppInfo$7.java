package com.tencent.mobileqq.pluspanel.appinfo;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.screenshare.ScreenShareReportHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;

class ShareScreenAppInfo$7
  implements View.OnClickListener
{
  ShareScreenAppInfo$7(ShareScreenAppInfo paramShareScreenAppInfo, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView)
  {
    ScreenShareReportHelper.a("0X800B8A0", 1);
    this.a.superDismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.ShareScreenAppInfo.7
 * JD-Core Version:    0.7.0.1
 */