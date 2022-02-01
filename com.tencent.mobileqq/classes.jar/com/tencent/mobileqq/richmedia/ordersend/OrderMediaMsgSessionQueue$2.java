package com.tencent.mobileqq.richmedia.ordersend;

import com.tencent.mobileqq.app.MediaMessageObserver;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentLinkedQueue;

class OrderMediaMsgSessionQueue$2
  extends MediaMessageObserver
{
  OrderMediaMsgSessionQueue$2(OrderMediaMsgSessionQueue paramOrderMediaMsgSessionQueue) {}
  
  public void onNotifyResultAfterSendRich(boolean paramBoolean, long paramLong, StatictisInfo paramStatictisInfo)
  {
    if (OrderMediaMsgSessionQueue.a(this.a) == null)
    {
      QLog.d(OrderMediaMsgSessionQueue.a, 1, new Object[] { "return because queue is null, isSuccess:", Boolean.valueOf(paramBoolean), " ,uniseq:", Long.valueOf(paramLong) });
      return;
    }
    OrderMediaMsgItem localOrderMediaMsgItem = (OrderMediaMsgItem)OrderMediaMsgSessionQueue.a(this.a).peek();
    if (localOrderMediaMsgItem != null)
    {
      if ((paramLong == localOrderMediaMsgItem.d) && (localOrderMediaMsgItem.c == 4))
      {
        localOrderMediaMsgItem.c = 5;
        OrderMediaMsgSessionQueue.a(this.a).remove(localOrderMediaMsgItem);
        OrderMediaMsgSessionQueue.c(this.a).b();
        if (localOrderMediaMsgItem.i != null) {
          localOrderMediaMsgItem.i.onNotifyResultAfterSendRich(paramBoolean, paramLong, paramStatictisInfo);
        }
        if (localOrderMediaMsgItem.j != null) {
          localOrderMediaMsgItem.j.onSendEnd(paramBoolean, paramLong);
        }
        if (localOrderMediaMsgItem.f) {
          OrderMediaMsgSessionQueue.b(this.a).a(paramLong);
        }
        OrderMediaMsgSessionQueue.d(this.a).c(localOrderMediaMsgItem.d);
        if (QLog.isColorLevel())
        {
          paramStatictisInfo = new StringBuilder();
          paramStatictisInfo.append("OrderSendObserver remove uniseq:");
          paramStatictisInfo.append(paramLong);
          paramStatictisInfo.append(", queue size:");
          paramStatictisInfo.append(OrderMediaMsgSessionQueue.a(this.a).size());
          paramStatictisInfo.append(", mNeedCompress:");
          paramStatictisInfo.append(localOrderMediaMsgItem.f);
          paramStatictisInfo.append(", issuccess:");
          paramStatictisInfo.append(paramBoolean);
          QLog.d(OrderMediaMsgSessionQueue.a, 2, paramStatictisInfo.toString());
        }
      }
      else
      {
        QLog.d(OrderMediaMsgSessionQueue.a, 1, new Object[] { "OrderSendObserver peekFirst but fail, status:", Integer.valueOf(localOrderMediaMsgItem.c), ", uniseq:", Long.valueOf(localOrderMediaMsgItem.d) });
      }
    }
    else {
      QLog.d(OrderMediaMsgSessionQueue.a, 1, new Object[] { "OrderSendObserver peekFirst is null. uniseq:", Long.valueOf(paramLong), ", issuccess:", Boolean.valueOf(paramBoolean) });
    }
    OrderMediaMsgSessionQueue.e(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgSessionQueue.2
 * JD-Core Version:    0.7.0.1
 */