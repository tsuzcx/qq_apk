package com.tencent.mobileqq.mini.sdk;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

final class MiniAppController$4
  extends ResultReceiver
{
  MiniAppController$4(Handler paramHandler, MiniAppLauncher.MiniAppLaunchListener paramMiniAppLaunchListener)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    MiniAppLauncher.MiniAppLaunchListener localMiniAppLaunchListener = this.val$listener;
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    localMiniAppLaunchListener.onLaunchResult(bool, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.sdk.MiniAppController.4
 * JD-Core Version:    0.7.0.1
 */