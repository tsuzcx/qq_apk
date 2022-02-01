package com.tencent.mobileqq.richmedia.ordersend;

import android.os.Handler;
import android.os.Message;
import bavj;

public class OrderMediaMsgTimerController$1
  implements Runnable
{
  public OrderMediaMsgTimerController$1(bavj parambavj, long paramLong) {}
  
  public void run()
  {
    if (bavj.a(this.this$0) != null)
    {
      Message localMessage = bavj.a(this.this$0).obtainMessage(100);
      localMessage.obj = Long.valueOf(this.a);
      bavj.a(this.this$0).sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgTimerController.1
 * JD-Core Version:    0.7.0.1
 */