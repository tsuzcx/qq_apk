package com.tencent.mobileqq.richmedia.conn;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

class LiteTcpConnection$ConnWorker
  extends Handler
{
  public LiteTcpConnection$ConnWorker(LiteTcpConnection paramLiteTcpConnection, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void a()
  {
    if (LiteTcpConnection.g(this.a) != null) {
      LiteTcpConnection.g(this.a).sendEmptyMessage(3);
    }
  }
  
  public void b()
  {
    ConnWorker localConnWorker = LiteTcpConnection.g(this.a);
    if (localConnWorker != null) {
      localConnWorker.sendEmptyMessage(2);
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      paramMessage = this.a;
      LiteTcpConnection.a(paramMessage, LiteTcpConnection.d(paramMessage));
      return;
    }
    if (paramMessage.what == 2)
    {
      LiteTcpConnection.e(this.a);
      return;
    }
    if (paramMessage.what == 3)
    {
      LiteTcpConnection.f(this.a).quit();
      LiteTcpConnection.a(this.a, null);
      LiteTcpConnection.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.conn.LiteTcpConnection.ConnWorker
 * JD-Core Version:    0.7.0.1
 */