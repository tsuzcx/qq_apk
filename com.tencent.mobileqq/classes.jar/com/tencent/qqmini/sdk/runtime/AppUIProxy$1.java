package com.tencent.qqmini.sdk.runtime;

class AppUIProxy$1
  extends AppRuntimeEventCenter.RuntimeStateObserver
{
  AppUIProxy$1(AppUIProxy paramAppUIProxy) {}
  
  public void onStateChange(AppRuntimeEventCenter.MiniAppStateMessage paramMiniAppStateMessage)
  {
    if (paramMiniAppStateMessage.what == 100) {
      this.this$0.enableBreak();
    }
    while (paramMiniAppStateMessage.what != 101) {
      return;
    }
    this.this$0.disableBreak();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.AppUIProxy.1
 * JD-Core Version:    0.7.0.1
 */