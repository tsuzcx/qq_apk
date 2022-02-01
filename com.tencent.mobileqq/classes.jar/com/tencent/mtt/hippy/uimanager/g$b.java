package com.tencent.mtt.hippy.uimanager;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class g$b
  extends Handler
{
  private final g a;
  private final g.a b;
  
  public g$b(g paramg)
  {
    super(Looper.getMainLooper());
    this.a = paramg;
    this.b = g.a(this.a);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2) {
        return;
      }
      this.b.handle("onPressOut", -1.0F, -1.0F);
      return;
    }
    this.b.handle("onPressIn", -1.0F, -1.0F);
    this.a.a = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.uimanager.g.b
 * JD-Core Version:    0.7.0.1
 */