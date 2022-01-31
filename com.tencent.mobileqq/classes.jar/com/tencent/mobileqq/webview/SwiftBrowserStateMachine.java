package com.tencent.mobileqq.webview;

import android.os.Bundle;
import com.tencent.mobileqq.webview.swift.scheduler.SwiftBrowserStateMachineScheduler.StateMachine;
import com.tencent.qphone.base.util.QLog;

public class SwiftBrowserStateMachine
  implements SwiftBrowserStateMachineScheduler.StateMachine
{
  protected int a = 1;
  
  public int a(Bundle paramBundle)
  {
    int j = this.a;
    int i = -1;
    switch (this.a)
    {
    }
    for (;;)
    {
      QLog.i("WebLog_SwiftBrowserStateMachine", 1, "mCreateLoopScheduler.next:currentStep(" + j + "),nextStep(" + this.a + "), next action(" + i + ").");
      return i;
      i = b(paramBundle);
      continue;
      i = c(paramBundle);
      continue;
      i = d(paramBundle);
      continue;
      i = e(paramBundle);
      continue;
      i = f(paramBundle);
      continue;
      i = g(paramBundle);
      continue;
      i = h(paramBundle);
      continue;
      i = i(paramBundle);
      continue;
      i = j(paramBundle);
    }
  }
  
  public int b(Bundle paramBundle)
  {
    return 0;
  }
  
  public int c(Bundle paramBundle)
  {
    return 0;
  }
  
  public int d(Bundle paramBundle)
  {
    return 0;
  }
  
  public int e(Bundle paramBundle)
  {
    return 0;
  }
  
  public int f(Bundle paramBundle)
  {
    return 1;
  }
  
  public int g(Bundle paramBundle)
  {
    return 1;
  }
  
  public int h(Bundle paramBundle)
  {
    return 1;
  }
  
  public int i(Bundle paramBundle)
  {
    return 1;
  }
  
  public int j(Bundle paramBundle)
  {
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.webview.SwiftBrowserStateMachine
 * JD-Core Version:    0.7.0.1
 */