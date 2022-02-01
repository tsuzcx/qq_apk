package com.tencent.mobileqq.writetogether.websocket;

import android.os.SystemClock;
import com.tencent.mobileqq.writetogether.websocket.msg.BaseToWriteTogetherMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

class WriteTogetherWebSocketSender$Worker
  extends Thread
{
  private WriteTogetherWebSocketSender$Worker(WriteTogetherWebSocketSender paramWriteTogetherWebSocketSender) {}
  
  private boolean a()
  {
    for (;;)
    {
      if (WriteTogetherWebSocketSender.a(this.this$0).a()) {
        break label101;
      }
      try
      {
        if (this.this$0.a()) {
          WriteTogetherWebSocketSender.a(this.this$0).a();
        }
        WriteTogetherWebSocketSender.a(this.this$0).set(true);
        synchronized (WriteTogetherWebSocketSender.a(this.this$0))
        {
          WriteTogetherWebSocketSender.a(this.this$0).wait(30000L);
        }
        if (this.this$0.a) {}
      }
      catch (InterruptedException localInterruptedException)
      {
        QLog.e("WriteTogether.WriteTogetherWebSocketSender", 1, localInterruptedException, new Object[0]);
      }
    }
    return true;
    label101:
    WriteTogetherWebSocketSender.a(this.this$0, 2000);
    return false;
  }
  
  public void run()
  {
    for (;;)
    {
      if (!this.this$0.a) {
        return;
      }
      BaseToWriteTogetherMsg localBaseToWriteTogetherMsg = (BaseToWriteTogetherMsg)WriteTogetherWebSocketSender.a(this.this$0).peek();
      if (!this.this$0.a) {
        return;
      }
      if (a()) {
        return;
      }
      if (localBaseToWriteTogetherMsg != null)
      {
        WriteTogetherWebSocketSender.a(this.this$0).a(localBaseToWriteTogetherMsg);
        WriteTogetherWebSocketSender.a(this.this$0).removeFirst();
      }
      SystemClock.sleep(10L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.websocket.WriteTogetherWebSocketSender.Worker
 * JD-Core Version:    0.7.0.1
 */