package com.tencent.mobileqq.richmedia.ordersend;

import android.os.Handler;
import android.os.Message;

class OrderMediaMsgTimerController$5
  implements Runnable
{
  OrderMediaMsgTimerController$5(OrderMediaMsgTimerController paramOrderMediaMsgTimerController, long paramLong) {}
  
  public void run()
  {
    if (OrderMediaMsgTimerController.a(this.this$0) != null)
    {
      Message localMessage = OrderMediaMsgTimerController.a(this.this$0).obtainMessage(103);
      localMessage.obj = Long.valueOf(this.a);
      OrderMediaMsgTimerController.a(this.this$0).sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgTimerController.5
 * JD-Core Version:    0.7.0.1
 */