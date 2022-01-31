package com.tencent.mobileqq.richmedia.ordersend;

import android.os.Handler;
import android.os.Message;
import avbf;

public class OrderMediaMsgTimerController$3
  implements Runnable
{
  public OrderMediaMsgTimerController$3(avbf paramavbf, long paramLong) {}
  
  public void run()
  {
    if (avbf.a(this.this$0) != null)
    {
      Message localMessage = avbf.a(this.this$0).obtainMessage(101);
      localMessage.obj = Long.valueOf(this.a);
      avbf.a(this.this$0).sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgTimerController.3
 * JD-Core Version:    0.7.0.1
 */