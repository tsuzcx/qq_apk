package com.tencent.trackrecordlib.core;

import android.os.Handler;
import android.os.MessageQueue.IdleHandler;

class b$1
  implements MessageQueue.IdleHandler
{
  b$1(b paramb) {}
  
  public boolean queueIdle()
  {
    if (b.a() != null)
    {
      b.a(false);
      b.b().post(b.a());
      b.b(null);
      return true;
    }
    b.a(true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.trackrecordlib.core.b.1
 * JD-Core Version:    0.7.0.1
 */