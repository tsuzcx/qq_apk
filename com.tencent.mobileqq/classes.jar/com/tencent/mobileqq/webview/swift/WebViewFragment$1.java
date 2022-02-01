package com.tencent.mobileqq.webview.swift;

import android.os.Bundle;
import com.tencent.mobileqq.webview.swift.scheduler.SwiftBrowserStateMachineScheduler.StateMachine;
import com.tencent.qphone.base.util.QLog;

class WebViewFragment$1
  implements SwiftBrowserStateMachineScheduler.StateMachine
{
  WebViewFragment$1(WebViewFragment paramWebViewFragment) {}
  
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
      QLog.i("WebLog_WebViewFragment", 1, "CreateLoop:step[" + j + "] -> step[" + this.a.mCreateLoopNextStep + "] cost" + (System.currentTimeMillis() - l) + " ms.");
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
      i = this.a.doCreateLoopStep_InitUIFrame(paramBundle);
      continue;
      i = this.a.doCreateLoopStep_InitUIContent(paramBundle);
      continue;
      i = this.a.doCreateLoopStep_InitTitleBar(paramBundle);
      continue;
      i = this.a.doCreateLoopStep_InitBottomBar(paramBundle);
      continue;
      i = this.a.doCreateLoopStep_Final(paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewFragment.1
 * JD-Core Version:    0.7.0.1
 */