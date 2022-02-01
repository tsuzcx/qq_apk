package com.tencent.mobileqq.utils;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class JumpAction$11
  implements View.OnClickListener
{
  JumpAction$11(JumpAction paramJumpAction) {}
  
  public void onClick(View paramView)
  {
    if ((JumpAction.a(this.a) != null) && (JumpAction.a(this.a).isShowing())) {
      JumpAction.a(this.a).dismiss();
    }
    JumpAction.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.JumpAction.11
 * JD-Core Version:    0.7.0.1
 */