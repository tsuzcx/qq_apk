package com.tencent.mobileqq.richmedia.ordersend;

import android.os.Handler;
import android.os.Message;
import bahx;

public class OrderMediaMsgTimerController$1
  implements Runnable
{
  public OrderMediaMsgTimerController$1(bahx parambahx, long paramLong) {}
  
  public void run()
  {
    if (bahx.a(this.this$0) != null)
    {
      Message localMessage = bahx.a(this.this$0).obtainMessage(100);
      localMessage.obj = Long.valueOf(this.a);
      bahx.a(this.this$0).sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgTimerController.1
 * JD-Core Version:    0.7.0.1
 */