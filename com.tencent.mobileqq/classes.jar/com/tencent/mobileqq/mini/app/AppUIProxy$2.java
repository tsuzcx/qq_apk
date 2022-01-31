package com.tencent.mobileqq.mini.app;

import amgq;
import android.os.Bundle;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

class AppUIProxy$2
  extends amgq
{
  AppUIProxy$2(AppUIProxy paramAppUIProxy, BaseActivity paramBaseActivity) {}
  
  public void onAddColorNote(Bundle paramBundle, boolean paramBoolean)
  {
    super.onAddColorNote(paramBundle, paramBoolean);
    if (this.this$0.doNotMoveTaskToBackThisTime)
    {
      QLog.d("miniapp-start_AppUIProxy", 1, "onAddColorNote doNotMoveTaskToBackThisTime");
      this.this$0.doNotMoveTaskToBackThisTime = false;
      return;
    }
    this.this$0.moveTaskToBack(this.val$activity, true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.app.AppUIProxy.2
 * JD-Core Version:    0.7.0.1
 */