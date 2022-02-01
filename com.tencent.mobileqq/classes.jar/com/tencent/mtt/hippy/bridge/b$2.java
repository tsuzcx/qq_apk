package com.tencent.mtt.hippy.bridge;

import android.os.Handler;
import android.os.Message;
import com.tencent.mtt.hippy.HippyRootView;
import java.util.ArrayList;

class b$2
  extends NativeCallback
{
  b$2(b paramb, Handler paramHandler, String paramString, HippyRootView paramHippyRootView)
  {
    super(paramHandler);
  }
  
  public void Call(long paramLong, Message paramMessage, String paramString)
  {
    int i;
    if (paramLong == 1L) {
      i = 1;
    }
    while (i != 0)
    {
      if (this.c.h == null) {
        this.c.h = new ArrayList();
      }
      this.c.h.add(this.a);
      if (this.b != null)
      {
        b.a(this.c, 0, null, this.b);
        return;
        i = 0;
      }
      else
      {
        b.a(this.c, -150, "load module error. loader.load failed. check the file.", null);
        return;
      }
    }
    b.a(this.c, -150, "load module error. loader.load failed. check the file.", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.bridge.b.2
 * JD-Core Version:    0.7.0.1
 */