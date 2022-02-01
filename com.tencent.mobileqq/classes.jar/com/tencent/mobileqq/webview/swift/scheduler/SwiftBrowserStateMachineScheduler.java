package com.tencent.mobileqq.webview.swift.scheduler;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.util.WeakReferenceHandler;

public class SwiftBrowserStateMachineScheduler
  implements Handler.Callback
{
  private final SwiftBrowserStateMachineScheduler.StateMachine a;
  private final Handler b;
  private boolean c = true;
  private boolean d = false;
  
  public SwiftBrowserStateMachineScheduler(SwiftBrowserStateMachineScheduler.StateMachine paramStateMachine)
  {
    this.a = paramStateMachine;
    this.b = new WeakReferenceHandler(Looper.getMainLooper(), this);
  }
  
  public void a()
  {
    this.c = false;
  }
  
  public void a(Bundle paramBundle)
  {
    this.d = false;
    while (!this.d)
    {
      int i = this.a.a(paramBundle);
      if (i != -1) {
        if ((i == 1) && (this.c))
        {
          Message localMessage = this.b.obtainMessage(1);
          localMessage.setData(paramBundle);
          this.b.sendMessage(localMessage);
        }
      }
    }
  }
  
  public void b()
  {
    this.d = true;
    this.b.removeMessages(1);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return false;
    }
    if (!this.d) {
      a(paramMessage.getData());
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.scheduler.SwiftBrowserStateMachineScheduler
 * JD-Core Version:    0.7.0.1
 */