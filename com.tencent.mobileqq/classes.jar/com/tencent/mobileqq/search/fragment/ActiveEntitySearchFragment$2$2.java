package com.tencent.mobileqq.search.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ActiveEntitySearchFragment$2$2
  implements View.OnClickListener
{
  ActiveEntitySearchFragment$2$2(ActiveEntitySearchFragment.2 param2) {}
  
  public void onClick(View paramView)
  {
    this.a.a.b(this.a.a.b);
    this.a.a.v.setVisibility(0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.ActiveEntitySearchFragment.2.2
 * JD-Core Version:    0.7.0.1
 */