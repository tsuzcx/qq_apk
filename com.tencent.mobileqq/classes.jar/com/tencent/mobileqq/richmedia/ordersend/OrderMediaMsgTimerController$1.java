package com.tencent.mobileqq.richmedia.ordersend;

import android.os.Handler;
import android.os.Message;
import away;

public class OrderMediaMsgTimerController$1
  implements Runnable
{
  public OrderMediaMsgTimerController$1(away paramaway, long paramLong) {}
  
  public void run()
  {
    if (away.a(this.this$0) != null)
    {
      Message localMessage = away.a(this.this$0).obtainMessage(100);
      localMessage.obj = Long.valueOf(this.a);
      away.a(this.this$0).sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgTimerController.1
 * JD-Core Version:    0.7.0.1
 */