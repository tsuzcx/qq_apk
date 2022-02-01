package com.tencent.mobileqq.webview.swift;

import android.os.Bundle;
import com.tencent.mobileqq.webview.swift.scheduler.SwiftBrowserStateMachineScheduler.StateMachine;
import com.tencent.qphone.base.util.QLog;

class WebViewModule$1
  implements SwiftBrowserStateMachineScheduler.StateMachine
{
  WebViewModule$1(WebViewModule paramWebViewModule) {}
  
  public int a(Bundle paramBundle)
  {
    int j = this.a.mCreateLoopNextStep;
    int i = -1;
    long l = System.currentTimeMillis();
    switch (this.a.mCreateLoopNextStep)
    {
    }
    for (;;)
    {
      QLog.i("WebViewModule", 1, "CreateLoop:step[" + j + "] -> step[" + this.a.mCreateLoopNextStep + "] cost" + (System.currentTimeMillis() - l) + " ms.");
      return i;
      i = this.a.doCreateLoopStep_InitData(paramBundle);
      continue;
      i = this.a.doCreateLoopStep_InitX5Environment(paramBundle);
      continue;
      i = this.a.doCreateLoopStep_InitAppAndWebVieEngine(paramBundle);
      continue;
      i = this.a.doCreateLoopStep_InitWebView(paramBundle);
      continue;
      i = this.a.doCreateLoopStep_LoadUrl(paramBundle);
      continue;
      i = this.a.doCreateLoopStep_Final(paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewModule.1
 * JD-Core Version:    0.7.0.1
 */