package com.tencent.mobileqq.portal;

import android.content.Intent;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

class RedPacketServlet$1
  implements Runnable
{
  RedPacketServlet$1(RedPacketServlet paramRedPacketServlet, Intent paramIntent) {}
  
  public void run()
  {
    this.this$0.getAppRuntime().startServlet((NewIntent)this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.portal.RedPacketServlet.1
 * JD-Core Version:    0.7.0.1
 */