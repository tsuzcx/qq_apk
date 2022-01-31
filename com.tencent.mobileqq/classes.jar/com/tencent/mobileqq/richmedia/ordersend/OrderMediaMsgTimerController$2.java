package com.tencent.mobileqq.richmedia.ordersend;

import android.os.Handler;
import android.os.Message;
import axxi;

public class OrderMediaMsgTimerController$2
  implements Runnable
{
  public OrderMediaMsgTimerController$2(axxi paramaxxi, String paramString) {}
  
  public void run()
  {
    if (axxi.a(this.this$0) != null)
    {
      Message localMessage = axxi.a(this.this$0).obtainMessage(100);
      localMessage.obj = this.a;
      axxi.a(this.this$0).sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgTimerController.2
 * JD-Core Version:    0.7.0.1
 */