package com.tencent.xweb.xwalk;

import android.app.AlertDialog.Builder;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class d$1
  implements View.OnClickListener
{
  d$1(d paramd) {}
  
  public void onClick(View paramView)
  {
    new AlertDialog.Builder(this.a.b()).setTitle("保存页面").setMessage("确定保存页面？").setPositiveButton("确定", new d.1.2(this)).setNegativeButton("取消", new d.1.1(this)).show();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.1
 * JD-Core Version:    0.7.0.1
 */