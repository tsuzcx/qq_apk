package com.tencent.mobileqq.mini.out.webPlugins;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

class MiniAppPlugin$5$1
  extends ResultReceiver
{
  MiniAppPlugin$5$1(MiniAppPlugin.5 param5, Handler paramHandler)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    if (paramInt == 0) {
      this.this$1.val$activity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.webPlugins.MiniAppPlugin.5.1
 * JD-Core Version:    0.7.0.1
 */