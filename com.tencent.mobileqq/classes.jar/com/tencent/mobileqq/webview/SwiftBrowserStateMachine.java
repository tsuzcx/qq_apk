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
    int i;
    if (j != 2)
    {
      if (j != 4)
      {
        if (j != 8)
        {
          if (j != 16)
          {
            if (j != 32)
            {
              if (j != 64)
              {
                if (j != 128)
                {
                  if (j != 256)
                  {
                    if (j != 512) {
                      i = -1;
                    } else {
                      i = j(paramBundle);
                    }
                  }
                  else {
                    i = i(paramBundle);
                  }
                }
                else {
                  i = h(paramBundle);
                }
              }
              else {
                i = g(paramBundle);
              }
            }
            else {
              i = f(paramBundle);
            }
          }
          else {
            i = e(paramBundle);
          }
        }
        else {
          i = d(paramBundle);
        }
      }
      else {
        i = c(paramBundle);
      }
    }
    else {
      i = b(paramBundle);
    }
    paramBundle = new StringBuilder();
    paramBundle.append("mCreateLoopScheduler.next:currentStep(");
    paramBundle.append(j);
    paramBundle.append("),nextStep(");
    paramBundle.append(this.a);
    paramBundle.append("), next action(");
    paramBundle.append(i);
    paramBundle.append(").");
    QLog.i("WebLog_SwiftBrowserStateMachine", 1, paramBundle.toString());
    return i;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.SwiftBrowserStateMachine
 * JD-Core Version:    0.7.0.1
 */