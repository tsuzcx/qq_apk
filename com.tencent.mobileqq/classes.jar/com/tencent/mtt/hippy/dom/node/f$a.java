package com.tencent.mtt.hippy.dom.node;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class f$a
  extends Handler
{
  public f$a(f paramf)
  {
    super(Looper.getMainLooper());
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 3) {
      this.a.a = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.dom.node.f.a
 * JD-Core Version:    0.7.0.1
 */