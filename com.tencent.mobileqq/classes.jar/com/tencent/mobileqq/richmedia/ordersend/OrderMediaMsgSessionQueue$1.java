package com.tencent.mobileqq.richmedia.ordersend;

import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

class OrderMediaMsgSessionQueue$1
  implements OrderMediaMsgStatusCallback.IStatusErrorListener
{
  OrderMediaMsgSessionQueue$1(OrderMediaMsgSessionQueue paramOrderMediaMsgSessionQueue) {}
  
  public void a(long paramLong)
  {
    Iterator localIterator = OrderMediaMsgSessionQueue.a(this.a).iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      OrderMediaMsgItem localOrderMediaMsgItem = (OrderMediaMsgItem)localIterator.next();
      if ((paramLong != localOrderMediaMsgItem.jdField_a_of_type_Long) || (!OrderMediaMsgSessionQueue.a(this.a).a(localOrderMediaMsgItem.jdField_a_of_type_ComTencentMobileqqDataMessageRecord))) {
        break label114;
      }
      this.a.a(paramLong);
      bool = true;
    }
    label114:
    for (;;)
    {
      break;
      QLog.d(OrderMediaMsgSessionQueue.a, 1, new Object[] { "notifyCheckStatus uniseq:", Long.valueOf(paramLong), ", invalid:", Boolean.valueOf(bool) });
      return;
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    QLog.d(OrderMediaMsgSessionQueue.a, 1, new Object[] { "notifyError uniseq:", Long.valueOf(paramLong), ", errCode:", Integer.valueOf(paramInt) });
    this.a.a(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgSessionQueue.1
 * JD-Core Version:    0.7.0.1
 */