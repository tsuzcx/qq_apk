package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class d$7
  implements View.OnClickListener
{
  d$7(d paramd) {}
  
  public void onClick(View paramView)
  {
    this.a.b(true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.7
 * JD-Core Version:    0.7.0.1
 */