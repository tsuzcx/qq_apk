package com.tencent.qqmini.sdk.runtime;

class AppUIProxy$4$1
  extends AppRuntimeEventCenter.RuntimeStateObserver
{
  AppUIProxy$4$1(AppUIProxy.4 param4) {}
  
  public void onStateChange(AppRuntimeEventCenter.MiniAppStateMessage paramMiniAppStateMessage)
  {
    if (paramMiniAppStateMessage.what == 11) {
      this.this$1.this$0.hideLoading();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.AppUIProxy.4.1
 * JD-Core Version:    0.7.0.1
 */