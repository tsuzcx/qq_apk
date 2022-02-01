package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class d$8
  implements View.OnClickListener
{
  d$8(d paramd, Button paramButton) {}
  
  public void onClick(View paramView)
  {
    d.a(this.b, this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.8
 * JD-Core Version:    0.7.0.1
 */