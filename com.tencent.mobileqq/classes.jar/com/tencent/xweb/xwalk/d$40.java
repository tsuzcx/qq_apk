package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.xweb.WebView;

class d$40
  implements View.OnClickListener
{
  d$40(d paramd) {}
  
  public void onClick(View paramView)
  {
    d.d(this.a).setVisibility(8);
    d.k(this.a).startLongScreenshot(new d.40.1(this), true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.40
 * JD-Core Version:    0.7.0.1
 */