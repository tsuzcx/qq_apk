package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.xweb.v;

class d$4
  implements View.OnClickListener
{
  d$4(d paramd, Button paramButton) {}
  
  public void onClick(View paramView)
  {
    boolean bool = v.a().e() ^ true;
    v.a().c(bool);
    this.b.a(bool, this.a, true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.4
 * JD-Core Version:    0.7.0.1
 */