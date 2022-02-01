package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class d$14
  implements View.OnClickListener
{
  d$14(d paramd) {}
  
  public void onClick(View paramView)
  {
    d.a(this.a.b());
    Toast.makeText(this.a.b(), "开始检测插件更新", 0).show();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.14
 * JD-Core Version:    0.7.0.1
 */