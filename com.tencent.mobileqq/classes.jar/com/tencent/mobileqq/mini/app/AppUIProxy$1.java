package com.tencent.mobileqq.mini.app;

import aofp;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.mini.appbrand.ui.InternalAppBrandUI;
import com.tencent.mobileqq.mini.util.AnimUtil;

class AppUIProxy$1
  implements aofp
{
  AppUIProxy$1(AppUIProxy paramAppUIProxy, BaseActivity paramBaseActivity) {}
  
  public void onColorNoteAnimFinish()
  {
    if ((this.val$activity instanceof InternalAppBrandUI)) {
      this.val$activity.finish();
    }
    for (;;)
    {
      AnimUtil.clearAnim(this.val$activity);
      return;
      if (!this.val$activity.moveTaskToBack(false)) {
        this.val$activity.finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.app.AppUIProxy.1
 * JD-Core Version:    0.7.0.1
 */