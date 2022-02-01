package com.tencent.mtt.hippy.uimanager;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class g$b
  extends Handler
{
  private g a;
  private g.a b;
  
  public g$b(g paramg)
  {
    super(Looper.getMainLooper());
    this.a = paramg;
    this.b = g.a(this.a);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      this.b.handle("onPressIn", -1.0F, -1.0F);
      g.a(this.a, true);
      return;
    }
    this.b.handle("onPressOut", -1.0F, -1.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.uimanager.g.b
 * JD-Core Version:    0.7.0.1
 */