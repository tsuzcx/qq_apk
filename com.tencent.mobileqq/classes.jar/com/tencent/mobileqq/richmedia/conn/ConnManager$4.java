package com.tencent.mobileqq.richmedia.conn;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.richmedia.server.PeakAudioTransHandler;

class ConnManager$4
  implements Runnable
{
  ConnManager$4(ConnManager paramConnManager, long paramLong) {}
  
  public void run()
  {
    ((PeakAudioTransHandler)ConnManager.a(this.this$0).getBusinessHandler(PeakAppInterface.a)).a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.conn.ConnManager.4
 * JD-Core Version:    0.7.0.1
 */