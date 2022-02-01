package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class d$18
  implements View.OnClickListener
{
  d$18(d paramd) {}
  
  public void onClick(View paramView)
  {
    d.a(this.a.b(), d.h(this.a), false, true, new d.18.1(this));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.18
 * JD-Core Version:    0.7.0.1
 */