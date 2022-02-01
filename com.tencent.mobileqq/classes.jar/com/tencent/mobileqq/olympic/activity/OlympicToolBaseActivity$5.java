package com.tencent.mobileqq.olympic.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class OlympicToolBaseActivity$5
  implements View.OnClickListener
{
  OlympicToolBaseActivity$5(OlympicToolBaseActivity paramOlympicToolBaseActivity) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.a();
      continue;
      this.a.b();
      continue;
      this.a.c();
      continue;
      this.a.doOnBackPressed();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.activity.OlympicToolBaseActivity.5
 * JD-Core Version:    0.7.0.1
 */