package com.tencent.qqmini.sdk.runtime;

class AppUIProxy$5
  extends AppRuntimeEventCenter.RuntimeStateObserver
{
  AppUIProxy$5(AppUIProxy paramAppUIProxy) {}
  
  public void onStateChange(AppRuntimeEventCenter.MiniAppStateMessage paramMiniAppStateMessage)
  {
    if (paramMiniAppStateMessage.what == 11) {
      this.this$0.hideLoading();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.AppUIProxy.5
 * JD-Core Version:    0.7.0.1
 */