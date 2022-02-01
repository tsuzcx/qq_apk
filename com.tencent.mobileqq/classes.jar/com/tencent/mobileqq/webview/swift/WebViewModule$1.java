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
    long l = System.currentTimeMillis();
    int i = this.a.mCreateLoopNextStep;
    if (i != 2)
    {
      if (i != 4)
      {
        if (i != 8)
        {
          if (i != 16)
          {
            if (i != 32)
            {
              if (i != 1024) {
                i = -1;
              } else {
                i = this.a.doCreateLoopStep_Final(paramBundle);
              }
            }
            else {
              i = this.a.doCreateLoopStep_LoadUrl(paramBundle);
            }
          }
          else {
            i = this.a.doCreateLoopStep_InitWebView(paramBundle);
          }
        }
        else {
          i = this.a.doCreateLoopStep_InitAppAndWebVieEngine(paramBundle);
        }
      }
      else {
        i = this.a.doCreateLoopStep_InitX5Environment(paramBundle);
      }
    }
    else {
      i = this.a.doCreateLoopStep_InitData(paramBundle);
    }
    paramBundle = new StringBuilder("CreateLoop:step[");
    paramBundle.append(j);
    paramBundle.append("] -> step[");
    paramBundle.append(this.a.mCreateLoopNextStep);
    paramBundle.append("] cost");
    paramBundle.append(System.currentTimeMillis() - l);
    paramBundle.append(" ms.");
    QLog.i("WebViewModule", 1, paramBundle.toString());
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewModule.1
 * JD-Core Version:    0.7.0.1
 */