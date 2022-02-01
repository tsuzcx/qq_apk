package com.tencent.xweb.xwalk;

import android.app.AlertDialog.Builder;
import android.view.View;
import android.view.View.OnLongClickListener;

class d$39
  implements View.OnLongClickListener
{
  d$39(d paramd) {}
  
  public boolean onLongClick(View paramView)
  {
    new AlertDialog.Builder(this.a.b()).setTitle("提示").setMessage("清空保存页面文件").setPositiveButton("确定", new d.39.2(this)).setNegativeButton("取消", new d.39.1(this)).show();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.39
 * JD-Core Version:    0.7.0.1
 */