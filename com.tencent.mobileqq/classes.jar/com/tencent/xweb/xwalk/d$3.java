package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class d$3
  implements View.OnClickListener
{
  d$3(d paramd) {}
  
  public void onClick(View paramView)
  {
    d.d(this.a).setVisibility(8);
    this.a.e();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.3
 * JD-Core Version:    0.7.0.1
 */