package com.tencent.mobileqq.search.activity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class UniteSearchActivity$9
  implements View.OnClickListener
{
  UniteSearchActivity$9(UniteSearchActivity paramUniteSearchActivity) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = this.a.getIntent();
    localIntent.putExtra("keyword", this.a.p);
    this.a.setResult(2, localIntent);
    this.a.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.activity.UniteSearchActivity.9
 * JD-Core Version:    0.7.0.1
 */