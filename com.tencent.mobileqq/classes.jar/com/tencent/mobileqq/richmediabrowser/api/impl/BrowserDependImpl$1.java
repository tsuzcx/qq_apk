package com.tencent.mobileqq.richmediabrowser.api.impl;

import android.app.Activity;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class BrowserDependImpl$1
  implements EIPCResultCallback
{
  BrowserDependImpl$1(BrowserDependImpl paramBrowserDependImpl, Activity paramActivity) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (-102 == paramEIPCResult.code) {
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.api.impl.BrowserDependImpl.1
 * JD-Core Version:    0.7.0.1
 */