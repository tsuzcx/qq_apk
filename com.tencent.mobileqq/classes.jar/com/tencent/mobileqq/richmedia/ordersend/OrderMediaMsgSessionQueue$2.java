package com.tencent.mobileqq.richmedia.ordersend;

import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.shortvideo.VideoCompressProcessor;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentLinkedQueue;

class OrderMediaMsgSessionQueue$2
  extends MessageObserver
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
    if (localOrderMediaMsgItem != null) {
      if ((paramLong == localOrderMediaMsgItem.jdField_a_of_type_Long) && (localOrderMediaMsgItem.c == 4))
      {
        localOrderMediaMsgItem.c = 5;
        OrderMediaMsgSessionQueue.a(this.a).remove(localOrderMediaMsgItem);
        if (localOrderMediaMsgItem.jdField_a_of_type_ComTencentMobileqqAppMessageObserver != null) {
          localOrderMediaMsgItem.jdField_a_of_type_ComTencentMobileqqAppMessageObserver.onNotifyResultAfterSendRich(paramBoolean, paramLong, paramStatictisInfo);
        }
        if (localOrderMediaMsgItem.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgManager$IMsgSendingListener != null) {
          localOrderMediaMsgItem.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgManager$IMsgSendingListener.onSendEnd(paramBoolean, paramLong);
        }
        if (localOrderMediaMsgItem.jdField_a_of_type_Boolean) {
          VideoCompressProcessor.a().a(paramLong);
        }
        OrderMediaMsgSessionQueue.a(this.a).b(localOrderMediaMsgItem.jdField_a_of_type_Long);
        if (QLog.isColorLevel())
        {
          paramStatictisInfo = new StringBuilder();
          paramStatictisInfo.append("OrderSendObserver remove uniseq:").append(paramLong).append(", queue size:").append(OrderMediaMsgSessionQueue.a(this.a).size()).append(", mNeedCompress:").append(localOrderMediaMsgItem.jdField_a_of_type_Boolean).append(", issuccess:").append(paramBoolean);
          QLog.d(OrderMediaMsgSessionQueue.a, 2, paramStatictisInfo.toString());
        }
      }
    }
    for (;;)
    {
      OrderMediaMsgSessionQueue.a(this.a);
      return;
      QLog.d(OrderMediaMsgSessionQueue.a, 1, new Object[] { "OrderSendObserver peekFirst but fail, status:", Integer.valueOf(localOrderMediaMsgItem.c), ", uniseq:", Long.valueOf(localOrderMediaMsgItem.jdField_a_of_type_Long) });
      continue;
      QLog.d(OrderMediaMsgSessionQueue.a, 1, new Object[] { "OrderSendObserver peekFirst is null. uniseq:", Long.valueOf(paramLong), ", issuccess:", Boolean.valueOf(paramBoolean) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgSessionQueue.2
 * JD-Core Version:    0.7.0.1
 */