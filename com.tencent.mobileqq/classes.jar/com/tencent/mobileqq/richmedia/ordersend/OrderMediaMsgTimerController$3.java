package com.tencent.mobileqq.richmedia.ordersend;

import android.os.Handler;
import android.os.Message;

class OrderMediaMsgTimerController$3
  implements Runnable
{
  OrderMediaMsgTimerController$3(OrderMediaMsgTimerController paramOrderMediaMsgTimerController, long paramLong) {}
  
  public void run()
  {
    if (OrderMediaMsgTimerController.a(this.this$0) != null)
    {
      Message localMessage = OrderMediaMsgTimerController.a(this.this$0).obtainMessage(101);
      localMessage.obj = Long.valueOf(this.a);
      OrderMediaMsgTimerController.a(this.this$0).sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgTimerController.3
 * JD-Core Version:    0.7.0.1
 */