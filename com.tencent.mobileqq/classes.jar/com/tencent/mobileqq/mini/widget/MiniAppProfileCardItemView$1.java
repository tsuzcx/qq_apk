package com.tencent.mobileqq.mini.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;

class MiniAppProfileCardItemView$1
  implements View.OnClickListener
{
  MiniAppProfileCardItemView$1(MiniAppProfileCardItemView paramMiniAppProfileCardItemView) {}
  
  public void onClick(View paramView)
  {
    MiniAppCmdUtil.getInstance().getAppInfoById(null, MiniAppProfileCardItemView.access$000(this.this$0), "", "", new MiniAppProfileCardItemView.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.MiniAppProfileCardItemView.1
 * JD-Core Version:    0.7.0.1
 */