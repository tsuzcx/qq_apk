package com.tencent.mobileqq.extendfriend.utils;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.mini.ui.dialog.DialogFromBottom;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class CampusHelper$1
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    if (this.a.isShowing())
    {
      this.a.dismiss();
      ReportController.b(null, "dc00898", "", "", "0X800AD9C", "0X800AD9C", 2, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.utils.CampusHelper.1
 * JD-Core Version:    0.7.0.1
 */