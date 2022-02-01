package com.tencent.rfw.barrage.util;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;

public class RFWBarragePlayerTimerUtils
{
  private static volatile RFWBarragePlayerTimerUtils d;
  private int a = 0;
  private Handler b;
  private HandlerThread c;
  
  private RFWBarragePlayerTimerUtils()
  {
    h();
  }
  
  public static RFWBarragePlayerTimerUtils a()
  {
    if (d == null) {
      try
      {
        if (d == null) {
          d = new RFWBarragePlayerTimerUtils();
        }
      }
      finally {}
    }
    return d;
  }
  
  private void a(Message paramMessage)
  {
    if (paramMessage.what == 17)
    {
      j();
      return;
    }
    if (paramMessage.what == 19)
    {
      k();
      return;
    }
    if (paramMessage.what == 18)
    {
      j();
      return;
    }
    if (paramMessage.what == 20)
    {
      k();
      return;
    }
    if (paramMessage.what == 21)
    {
      j();
      return;
    }
    if (paramMessage.what == 22) {
      i();
    }
  }
  
  private void h()
  {
    this.a = 0;
    this.c = new HandlerThread("RFWBarragePlayerTimerUtils_HandlerThread");
    this.c.start();
    this.b = new RFWBarragePlayerTimerUtils.1(this, this.c.getLooper());
  }
  
  private void i()
  {
    Handler localHandler = this.b;
    if (localHandler != null) {
      localHandler.removeCallbacksAndMessages(null);
    }
  }
  
  private void j()
  {
    this.a += 1000;
    Message localMessage = new Message();
    localMessage.what = 18;
    this.b.sendMessageDelayed(localMessage, 1000L);
  }
  
  private void k()
  {
    this.a = 0;
    Handler localHandler = this.b;
    if (localHandler == null)
    {
      RFWBarrageLogger.b("RFWBarragePlayerTimerUtils", "[handlerStopUpdate] handler should not be null.");
      return;
    }
    localHandler.removeCallbacksAndMessages(null);
  }
  
  public void b()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 17;
    Handler localHandler = this.b;
    if (localHandler == null)
    {
      RFWBarrageLogger.b("RFWBarragePlayerTimerUtils", "[start] handler should not be null.");
      return;
    }
    this.a = 0;
    localHandler.sendMessage(localMessage);
  }
  
  public void c()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 19;
    Handler localHandler = this.b;
    if (localHandler == null)
    {
      RFWBarrageLogger.b("RFWBarragePlayerTimerUtils", "[stop] handler should not be null.");
      return;
    }
    localHandler.sendMessage(localMessage);
  }
  
  public void d()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 20;
    Handler localHandler = this.b;
    if (localHandler == null)
    {
      RFWBarrageLogger.b("RFWBarragePlayerTimerUtils", "[pause] handler should not be null.");
      return;
    }
    localHandler.sendMessage(localMessage);
  }
  
  public void e()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 21;
    Handler localHandler = this.b;
    if (localHandler == null)
    {
      RFWBarrageLogger.b("RFWBarragePlayerTimerUtils", "[resume] handler should not be null.");
      return;
    }
    localHandler.sendMessage(localMessage);
  }
  
  public void f()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 22;
    Handler localHandler = this.b;
    if (localHandler == null)
    {
      RFWBarrageLogger.b("RFWBarragePlayerTimerUtils", "[release] handler should not be null.");
      return;
    }
    localHandler.sendMessage(localMessage);
  }
  
  public int g()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rfw.barrage.util.RFWBarragePlayerTimerUtils
 * JD-Core Version:    0.7.0.1
 */