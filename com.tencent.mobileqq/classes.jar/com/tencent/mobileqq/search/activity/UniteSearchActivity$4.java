package com.tencent.mobileqq.search.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class UniteSearchActivity$4
  implements View.OnClickListener
{
  UniteSearchActivity$4(UniteSearchActivity paramUniteSearchActivity) {}
  
  public void onClick(View paramView)
  {
    UniteSearchActivity.o = 1;
    this.a.q.setText("");
    this.a.d();
    UniteSearchReportController.a(this.a.app, 0, this.a.e, "0X8009D2B", 0, 0, null, null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.activity.UniteSearchActivity.4
 * JD-Core Version:    0.7.0.1
 */