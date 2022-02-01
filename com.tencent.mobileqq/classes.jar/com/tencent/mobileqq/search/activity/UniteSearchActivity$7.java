package com.tencent.mobileqq.search.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class UniteSearchActivity$7
  implements View.OnClickListener
{
  UniteSearchActivity$7(UniteSearchActivity paramUniteSearchActivity) {}
  
  public void onClick(View paramView)
  {
    UniteSearchActivity.e = 1;
    this.a.a.setText("");
    this.a.a();
    UniteSearchReportController.a(this.a.app, 0, this.a.c, "0X8009D2B", 0, 0, null, null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.activity.UniteSearchActivity.7
 * JD-Core Version:    0.7.0.1
 */