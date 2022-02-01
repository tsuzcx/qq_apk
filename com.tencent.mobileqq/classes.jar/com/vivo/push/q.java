package com.vivo.push;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.vivo.push.util.o;

public abstract class q
{
  protected Context a;
  protected Handler b;
  private final Object c = new Object();
  
  public q()
  {
    HandlerThread localHandlerThread = new HandlerThread(getClass().getSimpleName(), 1);
    localHandlerThread.start();
    this.b = new q.a(this, localHandlerThread.getLooper());
  }
  
  public final void a(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public final void a(Message paramMessage)
  {
    synchronized (this.c)
    {
      if (this.b == null)
      {
        Object localObject2 = new StringBuilder("Dead worker dropping a message: ");
        ((StringBuilder)localObject2).append(paramMessage.what);
        paramMessage = ((StringBuilder)localObject2).toString();
        localObject2 = getClass().getSimpleName();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramMessage);
        localStringBuilder.append(" (Thread ");
        localStringBuilder.append(Thread.currentThread().getId());
        localStringBuilder.append(")");
        o.e((String)localObject2, localStringBuilder.toString());
      }
      else
      {
        this.b.sendMessage(paramMessage);
      }
      return;
    }
  }
  
  public abstract void b(Message paramMessage);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.q
 * JD-Core Version:    0.7.0.1
 */