package com.tencent.mobileqq.extendfriend.utils;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class ProfileGuideDialogUtils$3
  implements View.OnClickListener
{
  ProfileGuideDialogUtils$3(Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(null, "dc00898", "", "", "kuolie", "0X80097DF", 0, 0, "", "", "", "");
    if ((this.a != null) && (this.a.isShowing())) {
      this.a.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.utils.ProfileGuideDialogUtils.3
 * JD-Core Version:    0.7.0.1
 */