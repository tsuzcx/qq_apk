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
      if ((paramLong == localOrderMediaMsgItem.jdField_a_of_type_Long) && (localOrderMediaMsgItem.c == 4))
      {
        localOrderMediaMsgItem.c = 5;
        OrderMediaMsgSessionQueue.a(this.a).remove(localOrderMediaMsgItem);
        OrderMediaMsgSessionQueue.a(this.a).b();
        if (localOrderMediaMsgItem.jdField_a_of_type_ComTencentMobileqqAppMediaMessageObserver != null) {
          localOrderMediaMsgItem.jdField_a_of_type_ComTencentMobileqqAppMediaMessageObserver.onNotifyResultAfterSendRich(paramBoolean, paramLong, paramStatictisInfo);
        }
        if (localOrderMediaMsgItem.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendIOrderMediaMsgService$IMsgSendingListener != null) {
          localOrderMediaMsgItem.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendIOrderMediaMsgService$IMsgSendingListener.onSendEnd(paramBoolean, paramLong);
        }
        if (localOrderMediaMsgItem.jdField_a_of_type_Boolean) {
          OrderMediaMsgSessionQueue.a(this.a).a(paramLong);
        }
        OrderMediaMsgSessionQueue.a(this.a).b(localOrderMediaMsgItem.jdField_a_of_type_Long);
        if (QLog.isColorLevel())
        {
          paramStatictisInfo = new StringBuilder();
          paramStatictisInfo.append("OrderSendObserver remove uniseq:");
          paramStatictisInfo.append(paramLong);
          paramStatictisInfo.append(", queue size:");
          paramStatictisInfo.append(OrderMediaMsgSessionQueue.a(this.a).size());
          paramStatictisInfo.append(", mNeedCompress:");
          paramStatictisInfo.append(localOrderMediaMsgItem.jdField_a_of_type_Boolean);
          paramStatictisInfo.append(", issuccess:");
          paramStatictisInfo.append(paramBoolean);
          QLog.d(OrderMediaMsgSessionQueue.a, 2, paramStatictisInfo.toString());
        }
      }
      else
      {
        QLog.d(OrderMediaMsgSessionQueue.a, 1, new Object[] { "OrderSendObserver peekFirst but fail, status:", Integer.valueOf(localOrderMediaMsgItem.c), ", uniseq:", Long.valueOf(localOrderMediaMsgItem.jdField_a_of_type_Long) });
      }
    }
    else {
      QLog.d(OrderMediaMsgSessionQueue.a, 1, new Object[] { "OrderSendObserver peekFirst is null. uniseq:", Long.valueOf(paramLong), ", issuccess:", Boolean.valueOf(paramBoolean) });
    }
    OrderMediaMsgSessionQueue.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgSessionQueue.2
 * JD-Core Version:    0.7.0.1
 */