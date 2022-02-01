package com.tencent.mobileqq.leba;

import com.tencent.mobileqq.tianshu.api.IRedTouchServer;
import mqq.app.AppRuntime;

class Leba$2
  implements Runnable
{
  Leba$2(Leba paramLeba) {}
  
  public void run()
  {
    ((IRedTouchServer)this.this$0.a.getRuntimeService(IRedTouchServer.class, "")).sendRedpointReq(false, false, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.Leba.2
 * JD-Core Version:    0.7.0.1
 */