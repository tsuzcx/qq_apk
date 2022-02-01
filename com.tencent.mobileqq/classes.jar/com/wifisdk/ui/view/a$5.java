package com.wifisdk.ui.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import wf7.hv;

class a$5
  implements View.OnClickListener
{
  a$5(a parama) {}
  
  public void onClick(View paramView)
  {
    a.a(this.uU, true);
    hv.fD().a(a.l(this.uU), 1);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.wifisdk.ui.view.a.5
 * JD-Core Version:    0.7.0.1
 */