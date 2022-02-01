package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.v;

class d$31
  implements View.OnClickListener
{
  d$31(d paramd) {}
  
  public void onClick(View paramView)
  {
    v.a().a("tools", WebView.c.c);
    v.a().a("toolsmp", WebView.c.c);
    v.a().a("appbrand", WebView.c.c);
    v.a().a("support", WebView.c.c);
    v.a().a("mm", WebView.c.c);
    if (WebView.getInstalledTbsCoreVersion(this.a.b()) <= 0) {
      this.a.b("已切换x5，但是x5未ready，点任意位置重启进程生效\n", true);
    } else {
      this.a.a("已使用x5，点任意位置重启进程生效\n", true, true);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.31
 * JD-Core Version:    0.7.0.1
 */