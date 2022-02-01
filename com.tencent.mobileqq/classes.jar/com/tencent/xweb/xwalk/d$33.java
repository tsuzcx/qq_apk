package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.v;
import org.xwalk.core.XWalkEnvironment;

class d$33
  implements View.OnClickListener
{
  d$33(d paramd) {}
  
  public void onClick(View paramView)
  {
    XWalkEnvironment.setGrayValueForTest(0);
    XWalkEnvironment.setTestDownLoadUrl(d.i(this.a), "");
    v.a().a("tools", WebView.c.a);
    v.a().a("toolsmp", WebView.c.a);
    v.a().a("appbrand", WebView.c.a);
    v.a().a("support", WebView.c.a);
    v.a().a("mm", WebView.c.a);
    this.a.a("已使用AUTO，点任意位置重启进程生效\n", true, true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.33
 * JD-Core Version:    0.7.0.1
 */