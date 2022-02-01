package com.tencent.mobileqq.utils;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class JumpActionLegacy$10
  implements View.OnClickListener
{
  JumpActionLegacy$10(JumpActionLegacy paramJumpActionLegacy) {}
  
  public void onClick(View paramView)
  {
    if ((JumpActionLegacy.g(this.a) != null) && (JumpActionLegacy.g(this.a).isShowing())) {
      JumpActionLegacy.g(this.a).dismiss();
    }
    JumpActionLegacy.h(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.JumpActionLegacy.10
 * JD-Core Version:    0.7.0.1
 */