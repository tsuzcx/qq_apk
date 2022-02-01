package com.tencent.mobileqq.mini.api.impl;

import android.os.Bundle;
import com.tencent.mobileqq.mini.api.MiniAppLaunchListener;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher.MiniAppLaunchListener;

class MiniAppServiceImpl$1
  implements MiniAppLauncher.MiniAppLaunchListener
{
  MiniAppServiceImpl$1(MiniAppServiceImpl paramMiniAppServiceImpl, MiniAppLaunchListener paramMiniAppLaunchListener) {}
  
  public void onLaunchResult(boolean paramBoolean, Bundle paramBundle)
  {
    if (this.val$listener != null) {
      this.val$listener.onLaunchResult(paramBoolean, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.api.impl.MiniAppServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */