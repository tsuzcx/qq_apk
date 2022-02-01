package com.tencent.mobileqq.mini.api.impl;

import android.os.Bundle;
import com.tencent.mobileqq.mini.api.MiniAppLaunchListener;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher.MiniAppLaunchListener;

class MiniAppServiceImpl$7
  implements MiniAppLauncher.MiniAppLaunchListener
{
  MiniAppServiceImpl$7(MiniAppServiceImpl paramMiniAppServiceImpl, MiniAppLaunchListener paramMiniAppLaunchListener) {}
  
  public void onLaunchResult(boolean paramBoolean, Bundle paramBundle)
  {
    MiniAppLaunchListener localMiniAppLaunchListener = this.val$listener;
    if (localMiniAppLaunchListener != null) {
      localMiniAppLaunchListener.onLaunchResult(paramBoolean, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.api.impl.MiniAppServiceImpl.7
 * JD-Core Version:    0.7.0.1
 */