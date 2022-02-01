package com.tencent.mobileqq.webview.swift;

import android.os.Bundle;
import com.tencent.mobileqq.webview.swift.scheduler.SwiftBrowserStateMachineScheduler.StateMachine;
import com.tencent.qphone.base.util.QLog;

class WebViewKernel$1
  implements SwiftBrowserStateMachineScheduler.StateMachine
{
  WebViewKernel$1(WebViewKernel paramWebViewKernel) {}
  
  public int a(Bundle paramBundle)
  {
    int j = WebViewKernel.a(this.a);
    long l = System.currentTimeMillis();
    int i = WebViewKernel.a(this.a);
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
              if (i != 64)
              {
                if (i != 128)
                {
                  if (i != 256)
                  {
                    if (i != 512)
                    {
                      if (i != 1024) {
                        i = -1;
                      } else {
                        i = this.a.f(paramBundle);
                      }
                    }
                    else {
                      i = WebViewKernel.d(this.a, paramBundle);
                    }
                  }
                  else {
                    i = this.a.e(paramBundle);
                  }
                }
                else {
                  i = this.a.d(paramBundle);
                }
              }
              else {
                i = this.a.c(paramBundle);
              }
            }
            else {
              i = WebViewKernel.c(this.a, paramBundle);
            }
          }
          else {
            i = this.a.b(paramBundle);
          }
        }
        else {
          i = WebViewKernel.b(this.a, paramBundle);
        }
      }
      else {
        i = WebViewKernel.a(this.a, paramBundle);
      }
    }
    else {
      i = this.a.a(paramBundle);
    }
    paramBundle = new StringBuilder("CreateLoop:step[");
    paramBundle.append(j);
    paramBundle.append("] -> step[");
    paramBundle.append(WebViewKernel.a(this.a));
    paramBundle.append("] cost");
    paramBundle.append(System.currentTimeMillis() - l);
    paramBundle.append(" ms.");
    QLog.i("WebViewKernel", 1, paramBundle.toString());
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewKernel.1
 * JD-Core Version:    0.7.0.1
 */