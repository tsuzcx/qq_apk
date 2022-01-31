package com.tencent.mobileqq.highway.conn;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

class TcpConnection$ConnWorker
  extends Handler
{
  public static final int CONN = 1;
  public static final int QUIT = 3;
  public static final int SEND = 2;
  
  public TcpConnection$ConnWorker(TcpConnection paramTcpConnection, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      TcpConnection.access$900(this.this$0, TcpConnection.access$800(this.this$0));
    }
    do
    {
      return;
      if (paramMessage.what == 2)
      {
        TcpConnection.access$1000(this.this$0);
        return;
      }
    } while (paramMessage.what != 3);
    TcpConnection.access$1100(this.this$0).quit();
    TcpConnection.access$1102(this.this$0, null);
    TcpConnection.access$1202(this.this$0, null);
  }
  
  public void notifyToQuit()
  {
    if (TcpConnection.access$1200(this.this$0) != null) {
      TcpConnection.access$1200(this.this$0).sendEmptyMessage(3);
    }
  }
  
  public void wakeupToWrite()
  {
    ConnWorker localConnWorker = TcpConnection.access$1200(this.this$0);
    if (localConnWorker != null) {
      localConnWorker.sendEmptyMessage(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.conn.TcpConnection.ConnWorker
 * JD-Core Version:    0.7.0.1
 */