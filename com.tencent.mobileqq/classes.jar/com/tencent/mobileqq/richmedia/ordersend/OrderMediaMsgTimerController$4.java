package com.tencent.mobileqq.richmedia.ordersend;

import android.os.Handler;
import android.os.Message;
import axxi;

public class OrderMediaMsgTimerController$4
  implements Runnable
{
  public OrderMediaMsgTimerController$4(axxi paramaxxi, long paramLong, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (axxi.a(this.this$0) != null)
    {
      Message localMessage = axxi.a(this.this$0).obtainMessage(102);
      localMessage.obj = Long.valueOf(this.jdField_a_of_type_Long);
      localMessage.arg1 = this.jdField_a_of_type_Int;
      localMessage.arg2 = this.b;
      axxi.a(this.this$0).sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgTimerController.4
 * JD-Core Version:    0.7.0.1
 */