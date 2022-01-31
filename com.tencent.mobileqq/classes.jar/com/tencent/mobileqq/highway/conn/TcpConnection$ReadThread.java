package com.tencent.mobileqq.highway.conn;

import com.tencent.mobileqq.highway.codec.TcpProtocolDataCodec;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qphone.base.util.MsfSocketInputBuffer;
import java.util.concurrent.atomic.AtomicBoolean;

class TcpConnection$ReadThread
  extends Thread
{
  TcpConnection$ReadThread(TcpConnection paramTcpConnection) {}
  
  public void run()
  {
    while (TcpConnection.access$200(this.this$0).get()) {
      try
      {
        ??? = TcpConnection.access$300(this.this$0);
        if (??? == null) {
          return;
        }
        while (!((MsfSocketInputBuffer)???).isDataAvailable(30000)) {
          if (!TcpConnection.access$200(this.this$0).get()) {
            return;
          }
        }
        if (TcpConnection.access$200(this.this$0).get())
        {
          int i = ((MsfSocketInputBuffer)???).getBufferlen();
          ConnReportInfo localConnReportInfo = TcpConnection.access$100(this.this$0);
          localConnReportInfo.receiveDataLen += i;
          TcpConnection.access$000(this.this$0).increaseDataFlowDw(i);
          TcpConnection.access$402(this.this$0, i + TcpConnection.access$400(this.this$0));
          TcpConnection.access$500(this.this$0).onRecvData((MsfSocketInputBuffer)???);
          ((MsfSocketInputBuffer)???).reset();
        }
      }
      catch (Exception localException)
      {
        BdhLogUtil.LogException("C", "ReadThread Error.", localException);
        synchronized (TcpConnection.access$600(this.this$0))
        {
          TcpConnection.access$600(this.this$0).append("By ReadThread : " + localException.getMessage() + ";");
          TcpConnection.access$700(this.this$0, 1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.conn.TcpConnection.ReadThread
 * JD-Core Version:    0.7.0.1
 */