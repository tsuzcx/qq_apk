package com.tencent.mobileqq.richmedia.ordersend;

import android.os.Handler;
import android.os.Message;

class OrderMediaMsgTimerController$4
  implements Runnable
{
  OrderMediaMsgTimerController$4(OrderMediaMsgTimerController paramOrderMediaMsgTimerController, long paramLong, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (OrderMediaMsgTimerController.a(this.this$0) != null)
    {
      Message localMessage = OrderMediaMsgTimerController.a(this.this$0).obtainMessage(102);
      localMessage.obj = Long.valueOf(this.a);
      localMessage.arg1 = this.b;
      localMessage.arg2 = this.c;
      OrderMediaMsgTimerController.a(this.this$0).sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgTimerController.4
 * JD-Core Version:    0.7.0.1
 */