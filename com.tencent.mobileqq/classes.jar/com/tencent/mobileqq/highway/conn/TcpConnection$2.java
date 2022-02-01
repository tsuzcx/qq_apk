package com.tencent.mobileqq.highway.conn;

import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.config.HwServlet;

class TcpConnection$2
  implements Runnable
{
  TcpConnection$2(TcpConnection paramTcpConnection, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    HwServlet.reportTraffic4PicUp(TcpConnection.access$000(this.this$0).engine.app, TcpConnection.access$100(this.this$0).serverIp, TcpConnection.access$100(this.this$0).port, true, this.val$dataUpLen);
    HwServlet.reportTraffic4PicUp(TcpConnection.access$000(this.this$0).engine.app, TcpConnection.access$100(this.this$0).serverIp, TcpConnection.access$100(this.this$0).port, false, this.val$dataDwLen);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.highway.conn.TcpConnection.2
 * JD-Core Version:    0.7.0.1
 */