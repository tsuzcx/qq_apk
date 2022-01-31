package com.tencent.mobileqq.richmedia.ordersend;

import android.os.Handler;
import android.os.Message;
import axxi;

public class OrderMediaMsgTimerController$3
  implements Runnable
{
  public OrderMediaMsgTimerController$3(axxi paramaxxi, long paramLong) {}
  
  public void run()
  {
    if (axxi.a(this.this$0) != null)
    {
      Message localMessage = axxi.a(this.this$0).obtainMessage(101);
      localMessage.obj = Long.valueOf(this.a);
      axxi.a(this.this$0).sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgTimerController.3
 * JD-Core Version:    0.7.0.1
 */