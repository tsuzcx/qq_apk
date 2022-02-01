package com.tencent.mobileqq.utils;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class JumpActionLegacy$11
  implements View.OnClickListener
{
  JumpActionLegacy$11(JumpActionLegacy paramJumpActionLegacy) {}
  
  public void onClick(View paramView)
  {
    if ((JumpActionLegacy.g(this.a) != null) && (JumpActionLegacy.g(this.a).isShowing())) {
      JumpActionLegacy.g(this.a).dismiss();
    }
    ((QBaseActivity)this.a.b).finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.JumpActionLegacy.11
 * JD-Core Version:    0.7.0.1
 */