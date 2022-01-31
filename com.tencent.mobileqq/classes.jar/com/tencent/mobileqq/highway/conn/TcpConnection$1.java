package com.tencent.mobileqq.highway.conn;

import com.tencent.mobileqq.highway.utils.BdhLogUtil;

final class TcpConnection$1
  extends Thread
{
  public void run()
  {
    TcpConnection.IsRunTimeShutDown = true;
    BdhLogUtil.LogEvent("C", "TcpConnection,Runtime ShutDown");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.conn.TcpConnection.1
 * JD-Core Version:    0.7.0.1
 */