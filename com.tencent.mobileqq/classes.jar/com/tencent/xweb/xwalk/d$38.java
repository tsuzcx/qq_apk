package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.xweb.v;

class d$38
  implements View.OnClickListener
{
  d$38(d paramd) {}
  
  public void onClick(View paramView)
  {
    boolean bool = v.a().f() ^ true;
    v.a().d(bool);
    d.b(d.k(this.a));
    String str;
    if (bool) {
      str = "打开显示fps";
    } else {
      str = "关闭显示fps";
    }
    this.a.a(str, true, false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.38
 * JD-Core Version:    0.7.0.1
 */