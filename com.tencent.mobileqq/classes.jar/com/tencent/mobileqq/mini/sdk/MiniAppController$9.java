package com.tencent.mobileqq.mini.sdk;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

final class MiniAppController$9
  extends ResultReceiver
{
  MiniAppController$9(Handler paramHandler, MiniAppLauncher.MiniAppLaunchListener paramMiniAppLaunchListener)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    paramBundle = this.val$listener;
    if (paramBundle != null)
    {
      boolean bool;
      if (paramInt == 0) {
        bool = true;
      } else {
        bool = false;
      }
      paramBundle.onLaunchResult(bool, new Bundle());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.sdk.MiniAppController.9
 * JD-Core Version:    0.7.0.1
 */