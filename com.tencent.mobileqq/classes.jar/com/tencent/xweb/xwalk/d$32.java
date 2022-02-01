package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.v;

class d$32
  implements View.OnClickListener
{
  d$32(d paramd) {}
  
  public void onClick(View paramView)
  {
    v.a().a("tools", WebView.c.d);
    v.a().a("toolsmp", WebView.c.d);
    v.a().a("appbrand", WebView.c.d);
    v.a().a("support", WebView.c.d);
    v.a().a("mm", WebView.c.d);
    this.a.a("已使用system，点任意位置重启进程生效\n", true, true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.32
 * JD-Core Version:    0.7.0.1
 */