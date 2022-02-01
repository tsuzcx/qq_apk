package com.tencent.mobileqq.together.writetogether.websocket;

import android.os.SystemClock;
import beqn;
import com.tencent.mobileqq.together.writetogether.websocket.msg.BaseToWriteTogetherMsg;
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
      if (!WriteTogetherWebSocketSender.a(this.this$0).a()) {
        for (;;)
        {
          try
          {
            if (this.this$0.a()) {
              WriteTogetherWebSocketSender.a(this.this$0).a();
            }
            WriteTogetherWebSocketSender.a(this.this$0).set(true);
          }
          catch (InterruptedException localInterruptedException)
          {
            QLog.e("WriteTogether.WriteTogetherWebSocketSender", 1, localInterruptedException, new Object[0]);
            continue;
          }
          synchronized (WriteTogetherWebSocketSender.a(this.this$0))
          {
            WriteTogetherWebSocketSender.a(this.this$0).wait(30000L);
            if (this.this$0.a) {
              break;
            }
            return true;
          }
        }
      }
    }
    WriteTogetherWebSocketSender.a(this.this$0, 2000);
    return false;
  }
  
  public void run()
  {
    for (;;)
    {
      if (!this.this$0.a) {}
      BaseToWriteTogetherMsg localBaseToWriteTogetherMsg;
      do
      {
        return;
        localBaseToWriteTogetherMsg = (BaseToWriteTogetherMsg)WriteTogetherWebSocketSender.a(this.this$0).peek();
      } while ((!this.this$0.a) || (a()));
      if (localBaseToWriteTogetherMsg != null)
      {
        WriteTogetherWebSocketSender.a(this.this$0).a(localBaseToWriteTogetherMsg);
        WriteTogetherWebSocketSender.a(this.this$0).removeFirst();
      }
      SystemClock.sleep(10L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.together.writetogether.websocket.WriteTogetherWebSocketSender.Worker
 * JD-Core Version:    0.7.0.1
 */