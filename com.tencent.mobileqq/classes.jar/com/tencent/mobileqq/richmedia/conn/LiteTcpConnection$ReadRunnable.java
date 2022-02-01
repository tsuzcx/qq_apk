package com.tencent.mobileqq.richmedia.conn;

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
        MsfSocketInputBuffer localMsfSocketInputBuffer = LiteTcpConnection.b(this.this$0);
        if (localMsfSocketInputBuffer == null) {
          return;
        }
        while (!localMsfSocketInputBuffer.isDataAvailable(10000)) {
          if (!LiteTcpConnection.a(this.this$0).get()) {
            return;
          }
        }
        if (!LiteTcpConnection.a(this.this$0).get()) {
          return;
        }
        LiteTcpConnection.c(this.this$0).a(localMsfSocketInputBuffer);
        localMsfSocketInputBuffer.reset();
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("read exception ");
          localStringBuilder.append(localException.getMessage());
          localStringBuilder.append(";");
          QLog.e("PeakAudioTransHandler LiteTcpConnection", 2, localStringBuilder.toString());
        }
        LiteTcpConnection.a(this.this$0, 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.conn.LiteTcpConnection.ReadRunnable
 * JD-Core Version:    0.7.0.1
 */