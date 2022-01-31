package com.tencent.mobileqq.mini.sdk;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

final class MiniAppController$5
  extends ResultReceiver
{
  MiniAppController$5(Handler paramHandler, MiniAppLauncher.MiniAppLaunchListener paramMiniAppLaunchListener)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    MiniAppLauncher.MiniAppLaunchListener localMiniAppLaunchListener = this.val$listener;
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localMiniAppLaunchListener.onLaunchResult(bool, paramBundle);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.sdk.MiniAppController.5
 * JD-Core Version:    0.7.0.1
 */