package com.tencent.mobileqq.richmedia.ordersend;

import android.os.Handler;
import android.os.Message;

class OrderMediaMsgTimerController$2
  implements Runnable
{
  OrderMediaMsgTimerController$2(OrderMediaMsgTimerController paramOrderMediaMsgTimerController, String paramString) {}
  
  public void run()
  {
    if (OrderMediaMsgTimerController.a(this.this$0) != null)
    {
      Message localMessage = OrderMediaMsgTimerController.a(this.this$0).obtainMessage(100);
      localMessage.obj = this.a;
      OrderMediaMsgTimerController.a(this.this$0).sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgTimerController.2
 * JD-Core Version:    0.7.0.1
 */