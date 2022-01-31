package com.tencent.mobileqq.richmedia.conn;

import auwu;
import com.tencent.qphone.base.util.MsfSocketInputBuffer;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

class LiteTcpConnection$ReadRunnable
  implements Runnable
{
  LiteTcpConnection$ReadRunnable(LiteTcpConnection paramLiteTcpConnection) {}
  
  public void run()
  {
    while (LiteTcpConnection.a(this.this$0).get()) {
      try
      {
        MsfSocketInputBuffer localMsfSocketInputBuffer = LiteTcpConnection.a(this.this$0);
        if (localMsfSocketInputBuffer == null) {
          return;
        }
        while (!localMsfSocketInputBuffer.isDataAvailable(10000)) {
          if (!LiteTcpConnection.a(this.this$0).get()) {
            return;
          }
        }
        if (!LiteTcpConnection.a(this.this$0).get()) {
          break;
        }
        LiteTcpConnection.a(this.this$0).a(localMsfSocketInputBuffer);
        localMsfSocketInputBuffer.reset();
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PeakAudioTransHandler LiteTcpConnection", 2, "read exception " + localException.getMessage() + ";");
        }
        LiteTcpConnection.a(this.this$0, 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.conn.LiteTcpConnection.ReadRunnable
 * JD-Core Version:    0.7.0.1
 */