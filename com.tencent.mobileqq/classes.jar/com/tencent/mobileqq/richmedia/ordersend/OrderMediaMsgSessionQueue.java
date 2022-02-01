package com.tencent.mobileqq.richmedia.ordersend;

import android.text.TextUtils;
import com.tencent.mobileqq.app.MediaMessageObserver;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class OrderMediaMsgSessionQueue
  implements OrderMediaMsgTimerController.IMsgTimeoutListener
{
  public static String a = "OrderMediaMsgSessionQueue";
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 0L;
  MediaMessageObserver jdField_a_of_type_ComTencentMobileqqAppMediaMessageObserver = new OrderMediaMsgSessionQueue.2(this);
  private IMediaMsgApi jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendIMediaMsgApi;
  private OrderMediaMsgSessionQueue.IMsgPhaseListener jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgSessionQueue$IMsgPhaseListener;
  protected OrderMediaMsgStatusCallback.IStatusErrorListener a;
  private OrderMediaMsgStatusCallback jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgStatusCallback;
  private OrderMediaMsgTimerController jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgTimerController;
  private Iterator<OrderMediaMsgItem> jdField_a_of_type_JavaUtilIterator;
  private ConcurrentLinkedQueue<OrderMediaMsgItem> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue;
  private String b;
  
  public OrderMediaMsgSessionQueue(String paramString, IMediaMsgApi paramIMediaMsgApi)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgStatusCallback$IStatusErrorListener = new OrderMediaMsgSessionQueue.1(this);
    this.b = paramString;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendIMediaMsgApi = paramIMediaMsgApi;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgStatusCallback = new OrderMediaMsgStatusCallback(this.b);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgStatusCallback.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgStatusCallback$IStatusErrorListener);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgTimerController = new OrderMediaMsgTimerController(this);
  }
  
  private MessageRecord a(long paramLong)
  {
    Object localObject = null;
    MessageRecord localMessageRecord = null;
    if (paramLong != 0L)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
      for (;;)
      {
        localObject = localMessageRecord;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (OrderMediaMsgItem)localIterator.next();
        if (paramLong == ((OrderMediaMsgItem)localObject).jdField_a_of_type_Long) {
          localMessageRecord = ((OrderMediaMsgItem)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        }
      }
    }
    return localObject;
  }
  
  private void a(OrderMediaMsgItem paramOrderMediaMsgItem)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doNextAddSend ");
      localStringBuilder.append(paramOrderMediaMsgItem.jdField_a_of_type_Int);
      localStringBuilder.append(", uniseq:");
      localStringBuilder.append(paramOrderMediaMsgItem.jdField_a_of_type_Long);
      localStringBuilder.append(", addStatus:");
      localStringBuilder.append(paramOrderMediaMsgItem.jdField_b_of_type_Int);
      localStringBuilder.append(", sendStatus:");
      localStringBuilder.append(paramOrderMediaMsgItem.c);
      QLog.d(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgStatusCallback.b(paramOrderMediaMsgItem.jdField_a_of_type_Long);
    if (paramOrderMediaMsgItem.a()) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendIMediaMsgApi.a(paramOrderMediaMsgItem.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    }
    if (paramOrderMediaMsgItem.c()) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendIMediaMsgApi.a(paramOrderMediaMsgItem.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, paramOrderMediaMsgItem.jdField_a_of_type_ComTencentMobileqqAppMediaMessageObserver, paramOrderMediaMsgItem.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendIOrderMediaMsgService$IMsgSendingListener);
    }
    b();
    c();
  }
  
  private void b()
  {
    try
    {
      Object localObject2 = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        OrderMediaMsgItem localOrderMediaMsgItem = (OrderMediaMsgItem)((Iterator)localObject2).next();
        if (localOrderMediaMsgItem.a())
        {
          localOrderMediaMsgItem.jdField_b_of_type_Int = 2;
          this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgStatusCallback.a(localOrderMediaMsgItem.jdField_a_of_type_Long);
          this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendIMediaMsgApi.a(localOrderMediaMsgItem.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
          Object localObject3;
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("success in add ");
            ((StringBuilder)localObject3).append(localOrderMediaMsgItem.jdField_a_of_type_Int);
            ((StringBuilder)localObject3).append(", uniseq:");
            ((StringBuilder)localObject3).append(localOrderMediaMsgItem.jdField_a_of_type_Long);
            ((StringBuilder)localObject3).append(", path:");
            ((StringBuilder)localObject3).append(localOrderMediaMsgItem.jdField_a_of_type_JavaLangString);
            ((StringBuilder)localObject3).append(", status:");
            ((StringBuilder)localObject3).append(localOrderMediaMsgItem.jdField_b_of_type_Int);
            QLog.d(jdField_a_of_type_JavaLangString, 2, ((StringBuilder)localObject3).toString());
          }
          StringBuilder localStringBuilder;
          if (localOrderMediaMsgItem.jdField_a_of_type_JavaLangRunnable != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgTimerController.a(localOrderMediaMsgItem.jdField_a_of_type_JavaLangRunnable);
            localOrderMediaMsgItem.jdField_a_of_type_JavaLangRunnable = null;
            if (QLog.isColorLevel())
            {
              localObject3 = jdField_a_of_type_JavaLangString;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("remove mAddTimeoutRunable1 uniseq:");
              localStringBuilder.append(localOrderMediaMsgItem.jdField_a_of_type_Long);
              QLog.d((String)localObject3, 2, localStringBuilder.toString());
            }
          }
          if (localOrderMediaMsgItem.jdField_b_of_type_Boolean)
          {
            if (QLog.isColorLevel())
            {
              localObject3 = jdField_a_of_type_JavaLangString;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("invalid msg:");
              localStringBuilder.append(localOrderMediaMsgItem.jdField_a_of_type_Long);
              QLog.d((String)localObject3, 2, localStringBuilder.toString());
            }
            a(localOrderMediaMsgItem.jdField_a_of_type_Long);
          }
        }
        else if (!localOrderMediaMsgItem.b())
        {
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("not ready to add ");
            ((StringBuilder)localObject2).append(localOrderMediaMsgItem.jdField_a_of_type_Int);
            ((StringBuilder)localObject2).append(", path:");
            ((StringBuilder)localObject2).append(localOrderMediaMsgItem.jdField_a_of_type_JavaLangString);
            ((StringBuilder)localObject2).append(", mStatus:");
            ((StringBuilder)localObject2).append(localOrderMediaMsgItem.jdField_b_of_type_Int);
            QLog.d(jdField_a_of_type_JavaLangString, 2, ((StringBuilder)localObject2).toString());
          }
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject1;
    }
  }
  
  private void c()
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.isEmpty())
      {
        OrderMediaMsgReporter.a(this.jdField_a_of_type_Int, System.currentTimeMillis() - this.jdField_a_of_type_Long);
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgSessionQueue$IMsgPhaseListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgSessionQueue$IMsgPhaseListener.onAllCompleted(this.b);
        }
        this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgTimerController.c();
        this.jdField_a_of_type_Long = 0L;
        this.jdField_a_of_type_Int = 0;
        return;
      }
      OrderMediaMsgItem localOrderMediaMsgItem = (OrderMediaMsgItem)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.peek();
      if (localOrderMediaMsgItem != null)
      {
        StringBuilder localStringBuilder;
        if (localOrderMediaMsgItem.c())
        {
          localOrderMediaMsgItem.c = 4;
          this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgTimerController.a();
          this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgTimerController.b(localOrderMediaMsgItem.jdField_a_of_type_Long);
          this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendIMediaMsgApi.a(localOrderMediaMsgItem.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppMediaMessageObserver, localOrderMediaMsgItem.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendIOrderMediaMsgService$IMsgSendingListener);
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("success in send ");
            localStringBuilder.append(localOrderMediaMsgItem.jdField_a_of_type_Int);
            localStringBuilder.append(", uniseq:");
            localStringBuilder.append(localOrderMediaMsgItem.jdField_a_of_type_Long);
            localStringBuilder.append(", dest:");
            localStringBuilder.append(localOrderMediaMsgItem.jdField_a_of_type_JavaLangString);
            localStringBuilder.append(", status:");
            localStringBuilder.append(localOrderMediaMsgItem.c);
            QLog.d(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
          }
        }
        else if (!localOrderMediaMsgItem.d())
        {
          if (this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendIMediaMsgApi.b(localOrderMediaMsgItem.jdField_a_of_type_ComTencentMobileqqDataMessageRecord)) {
            localOrderMediaMsgItem.jdField_a_of_type_Boolean = true;
          }
          boolean bool = this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgTimerController.a(localOrderMediaMsgItem.jdField_a_of_type_Long);
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("not ready to send ");
            localStringBuilder.append(localOrderMediaMsgItem.jdField_a_of_type_Int);
            localStringBuilder.append(", uniseq:");
            localStringBuilder.append(localOrderMediaMsgItem.jdField_a_of_type_Long);
            localStringBuilder.append(", dest:");
            localStringBuilder.append(localOrderMediaMsgItem.jdField_a_of_type_JavaLangString);
            localStringBuilder.append(", status:");
            localStringBuilder.append(localOrderMediaMsgItem.c);
            localStringBuilder.append(", needCompress:");
            localStringBuilder.append(localOrderMediaMsgItem.jdField_a_of_type_Boolean);
            localStringBuilder.append(", addSuccess:");
            localStringBuilder.append(bool);
            QLog.d(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
          }
        }
        QLog.d(jdField_a_of_type_JavaLangString, 1, new Object[] { "queue peek", localOrderMediaMsgItem.toString() });
      }
      else
      {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "queue peek is empty!");
      }
      return;
    }
    finally {}
  }
  
  public OrderMediaMsgItem a(long paramLong)
  {
    this.jdField_a_of_type_JavaUtilIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
    while (this.jdField_a_of_type_JavaUtilIterator.hasNext())
    {
      OrderMediaMsgItem localOrderMediaMsgItem = (OrderMediaMsgItem)this.jdField_a_of_type_JavaUtilIterator.next();
      if (paramLong == localOrderMediaMsgItem.jdField_a_of_type_Long)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("removeMediaMsgByUniseq ");
          localStringBuilder.append(localOrderMediaMsgItem.jdField_a_of_type_Int);
          localStringBuilder.append(", uniseq:");
          localStringBuilder.append(localOrderMediaMsgItem.jdField_a_of_type_Long);
          QLog.d(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
        }
        this.jdField_a_of_type_JavaUtilIterator.remove();
        a(localOrderMediaMsgItem);
        return localOrderMediaMsgItem;
      }
    }
    return null;
  }
  
  public OrderMediaMsgItem a(String paramString)
  {
    this.jdField_a_of_type_JavaUtilIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
    while (this.jdField_a_of_type_JavaUtilIterator.hasNext())
    {
      OrderMediaMsgItem localOrderMediaMsgItem = (OrderMediaMsgItem)this.jdField_a_of_type_JavaUtilIterator.next();
      if (paramString.equals(localOrderMediaMsgItem.jdField_a_of_type_JavaLangString))
      {
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("removeMediaMsgByPath ");
          paramString.append(localOrderMediaMsgItem.jdField_a_of_type_Int);
          paramString.append(", uniseq:");
          paramString.append(localOrderMediaMsgItem.jdField_a_of_type_Long);
          QLog.d(jdField_a_of_type_JavaLangString, 2, paramString.toString());
        }
        this.jdField_a_of_type_JavaUtilIterator.remove();
        a(localOrderMediaMsgItem);
        return localOrderMediaMsgItem;
      }
    }
    return null;
  }
  
  public OrderMediaMsgStatusCallback a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgStatusCallback;
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgStatusCallback;
    if (localObject != null)
    {
      ((OrderMediaMsgStatusCallback)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgStatusCallback = null;
    }
    localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue;
    if (localObject != null)
    {
      ((ConcurrentLinkedQueue)localObject).clear();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgTimerController;
    if (localObject != null)
    {
      ((OrderMediaMsgTimerController)localObject).c();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgTimerController = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgSessionQueue$IMsgPhaseListener = null;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgTimerController.a();
    Object localObject1 = null;
    Object localObject2 = null;
    if (paramLong != 0L)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendIMediaMsgApi.a(a(paramLong))) {
        localObject1 = a(paramLong);
      }
    }
    else if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.isEmpty())
    {
      OrderMediaMsgItem localOrderMediaMsgItem = (OrderMediaMsgItem)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.peek();
      localObject1 = localObject2;
      if (localOrderMediaMsgItem != null)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendIMediaMsgApi.a(localOrderMediaMsgItem.jdField_a_of_type_ComTencentMobileqqDataMessageRecord)) {
          localObject1 = a(localOrderMediaMsgItem.jdField_a_of_type_Long);
        }
      }
      QLog.d(jdField_a_of_type_JavaLangString, 1, new Object[] { "uniseq is invalid:", Long.valueOf(paramLong) });
    }
    int i;
    boolean bool;
    if (localObject1 != null)
    {
      if (((OrderMediaMsgItem)localObject1).jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null) {
        i = 0;
      } else {
        i = ((OrderMediaMsgItem)localObject1).jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype;
      }
      bool = true;
    }
    else
    {
      i = -1;
      bool = false;
    }
    OrderMediaMsgReporter.a(i, bool);
    if (!bool)
    {
      int j = this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendIMediaMsgApi.a(a(paramLong));
      this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgTimerController.a(paramLong, j, 3);
    }
    QLog.d(jdField_a_of_type_JavaLangString, 1, new Object[] { "timeout!!! upload msg:", Long.valueOf(paramLong), " ,invalid:", Boolean.valueOf(bool), " ,msgtype:", Integer.valueOf(i) });
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgTimerController.a(paramLong);
    if (paramInt2 == 0)
    {
      a(paramLong);
      QLog.d(jdField_a_of_type_JavaLangString, 1, new Object[] { "blocking!!! count zero ", Long.valueOf(paramLong) });
      return;
    }
    if (paramInt1 == -1)
    {
      paramInt1 = this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendIMediaMsgApi.a(a(paramLong));
      this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgTimerController.a(paramLong, paramInt1, paramInt2 - 1);
      return;
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendIMediaMsgApi.a(a(paramLong));
    if (i > paramInt1)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgTimerController.a(paramLong, i, paramInt2);
      return;
    }
    a(paramLong);
    QLog.d(jdField_a_of_type_JavaLangString, 1, new Object[] { "blocking!!! progress stuck ", Long.valueOf(paramLong) });
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if ((paramLong1 != 0L) && (paramLong2 != 0L))
    {
      boolean bool = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.isEmpty();
      int j = 1;
      if (!bool)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
        while (localIterator.hasNext())
        {
          OrderMediaMsgItem localOrderMediaMsgItem = (OrderMediaMsgItem)localIterator.next();
          if (paramLong1 == localOrderMediaMsgItem.jdField_a_of_type_Long)
          {
            localOrderMediaMsgItem.jdField_a_of_type_Long = paramLong2;
            if (localOrderMediaMsgItem.jdField_a_of_type_JavaLangRunnable != null)
            {
              this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgTimerController.a(localOrderMediaMsgItem.jdField_a_of_type_JavaLangRunnable);
              localOrderMediaMsgItem.jdField_a_of_type_JavaLangRunnable = this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgTimerController.a(paramLong2);
            }
            i = j;
            if (!QLog.isColorLevel()) {
              break label169;
            }
            QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "updateMediaMsgByUniseq old:", Long.valueOf(paramLong1), ", new:", Long.valueOf(paramLong2) });
            i = j;
            break label169;
          }
        }
      }
      int i = 0;
      label169:
      if (i == 0) {
        a(paramLong2, "");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "oldSeq and newSeq should not be zero");
    }
  }
  
  public void a(long paramLong, String paramString)
  {
    a(paramLong, paramString, false);
  }
  
  public void a(long paramLong, String paramString, boolean paramBoolean)
  {
    Object localObject = new OrderMediaMsgItem();
    ((OrderMediaMsgItem)localObject).jdField_a_of_type_Long = paramLong;
    ((OrderMediaMsgItem)localObject).jdField_a_of_type_JavaLangString = paramString;
    ((OrderMediaMsgItem)localObject).jdField_b_of_type_Boolean = paramBoolean;
    int i = this.jdField_a_of_type_Int + 1;
    this.jdField_a_of_type_Int = i;
    ((OrderMediaMsgItem)localObject).jdField_a_of_type_Int = i;
    ((OrderMediaMsgItem)localObject).jdField_b_of_type_Int = 0;
    ((OrderMediaMsgItem)localObject).c = 0;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.offer(localObject);
    if (paramLong != 0L) {
      ((OrderMediaMsgItem)localObject).jdField_a_of_type_JavaLangRunnable = this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgTimerController.a(paramLong);
    } else {
      ((OrderMediaMsgItem)localObject).jdField_a_of_type_JavaLangRunnable = this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgTimerController.a(paramString);
    }
    if (this.jdField_a_of_type_Long == 0L) {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("enqueueMediaMsg msgSize:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      ((StringBuilder)localObject).append(", uniseq:");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(", path:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", queue:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
      QLog.d(jdField_a_of_type_JavaLangString, 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(MessageRecord paramMessageRecord, long paramLong, String paramString, boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("addOrderMsgRecord");
      ((StringBuilder)localObject).append(" uniseq:");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(", path:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", realadd:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d(jdField_a_of_type_JavaLangString, 2, ((StringBuilder)localObject).toString());
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
    while (localIterator.hasNext())
    {
      localObject = (OrderMediaMsgItem)localIterator.next();
      if ((((OrderMediaMsgItem)localObject).jdField_a_of_type_Long != 0L) && (paramLong == ((OrderMediaMsgItem)localObject).jdField_a_of_type_Long))
      {
        ((OrderMediaMsgItem)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
        if (paramBoolean)
        {
          ((OrderMediaMsgItem)localObject).jdField_b_of_type_Int = 1;
        }
        else
        {
          ((OrderMediaMsgItem)localObject).jdField_b_of_type_Int = 2;
          if (((OrderMediaMsgItem)localObject).jdField_a_of_type_JavaLangRunnable != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgTimerController.a(((OrderMediaMsgItem)localObject).jdField_a_of_type_JavaLangRunnable);
            ((OrderMediaMsgItem)localObject).jdField_a_of_type_JavaLangRunnable = null;
            if (QLog.isColorLevel())
            {
              paramMessageRecord = jdField_a_of_type_JavaLangString;
              paramString = new StringBuilder();
              paramString.append("remove mAddTimeoutRunable2 uniseq:");
              paramString.append(((OrderMediaMsgItem)localObject).jdField_a_of_type_Long);
              QLog.d(paramMessageRecord, 2, paramString.toString());
            }
          }
        }
      }
      else if ((((OrderMediaMsgItem)localObject).jdField_a_of_type_Long == 0L) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(((OrderMediaMsgItem)localObject).jdField_a_of_type_JavaLangString)))
      {
        ((OrderMediaMsgItem)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
        ((OrderMediaMsgItem)localObject).jdField_a_of_type_Long = paramLong;
        if (paramBoolean)
        {
          ((OrderMediaMsgItem)localObject).jdField_b_of_type_Int = 1;
        }
        else
        {
          ((OrderMediaMsgItem)localObject).jdField_b_of_type_Int = 2;
          if (((OrderMediaMsgItem)localObject).jdField_a_of_type_JavaLangRunnable != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgTimerController.a(((OrderMediaMsgItem)localObject).jdField_a_of_type_JavaLangRunnable);
            ((OrderMediaMsgItem)localObject).jdField_a_of_type_JavaLangRunnable = null;
            if (QLog.isColorLevel())
            {
              paramMessageRecord = jdField_a_of_type_JavaLangString;
              paramString = new StringBuilder();
              paramString.append("remove mAddTimeoutRunable3 uniseq:");
              paramString.append(((OrderMediaMsgItem)localObject).jdField_a_of_type_Long);
              QLog.d(paramMessageRecord, 2, paramString.toString());
            }
          }
        }
      }
    }
    if (paramBoolean) {
      b();
    }
  }
  
  public void a(MessageRecord paramMessageRecord, MediaMessageObserver paramMediaMessageObserver, IOrderMediaMsgService.IMsgSendingListener paramIMsgSendingListener)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("sendOrderMsgRecord:");
      ((StringBuilder)localObject2).append(paramMessageRecord.uniseq);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (OrderMediaMsgItem)((Iterator)localObject2).next();
      if (paramMessageRecord.uniseq == ((OrderMediaMsgItem)localObject1).jdField_a_of_type_Long)
      {
        ((OrderMediaMsgItem)localObject1).jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
        ((OrderMediaMsgItem)localObject1).jdField_a_of_type_ComTencentMobileqqAppMediaMessageObserver = paramMediaMessageObserver;
        ((OrderMediaMsgItem)localObject1).jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendIOrderMediaMsgService$IMsgSendingListener = paramIMsgSendingListener;
        ((OrderMediaMsgItem)localObject1).c = 3;
        if (QLog.isColorLevel())
        {
          paramMessageRecord = new StringBuilder();
          paramMessageRecord.append("ready to send ");
          paramMessageRecord.append(((OrderMediaMsgItem)localObject1).jdField_a_of_type_Int);
          paramMessageRecord.append(", uniseq:");
          paramMessageRecord.append(((OrderMediaMsgItem)localObject1).jdField_a_of_type_Long);
          paramMessageRecord.append(", addStatus:");
          paramMessageRecord.append(((OrderMediaMsgItem)localObject1).jdField_b_of_type_Int);
          paramMessageRecord.append(", sendStatus:");
          paramMessageRecord.append(((OrderMediaMsgItem)localObject1).c);
          QLog.d(jdField_a_of_type_JavaLangString, 2, paramMessageRecord.toString());
        }
      }
    }
    c();
  }
  
  public void a(OrderMediaMsgSessionQueue.IMsgPhaseListener paramIMsgPhaseListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgSessionQueue$IMsgPhaseListener = paramIMsgPhaseListener;
  }
  
  public void a(Object paramObject)
  {
    OrderMediaMsgItem localOrderMediaMsgItem;
    int i;
    if ((paramObject instanceof Long))
    {
      localOrderMediaMsgItem = a(((Long)paramObject).longValue());
      i = 1;
    }
    else if ((paramObject instanceof String))
    {
      localOrderMediaMsgItem = a((String)paramObject);
      i = 2;
    }
    else
    {
      localOrderMediaMsgItem = null;
      i = 0;
    }
    int j;
    if ((localOrderMediaMsgItem != null) && (localOrderMediaMsgItem.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)) {
      j = localOrderMediaMsgItem.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype;
    } else {
      j = -1;
    }
    OrderMediaMsgReporter.a(j, i);
    QLog.d(jdField_a_of_type_JavaLangString, 1, new Object[] { "timeout!!! add msg:", paramObject, " ,msgtype:", Integer.valueOf(j) });
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.isEmpty();
  }
  
  public boolean a(long paramLong, String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
    while (localIterator.hasNext())
    {
      OrderMediaMsgItem localOrderMediaMsgItem = (OrderMediaMsgItem)localIterator.next();
      if ((localOrderMediaMsgItem.jdField_a_of_type_Long != 0L) && (paramLong == localOrderMediaMsgItem.jdField_a_of_type_Long)) {
        return true;
      }
      if ((localOrderMediaMsgItem.jdField_a_of_type_Long == 0L) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(localOrderMediaMsgItem.jdField_a_of_type_JavaLangString))) {
        return true;
      }
    }
    return false;
  }
  
  public void b(long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgTimerController.b();
    OrderMediaMsgItem localOrderMediaMsgItem = a(paramLong);
    if (localOrderMediaMsgItem != null)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, new Object[] { "timeout!!! send msg:", Long.valueOf(paramLong), localOrderMediaMsgItem.toString() });
      return;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 1, new Object[] { "timeout!!! send msg:", Long.valueOf(paramLong) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgSessionQueue
 * JD-Core Version:    0.7.0.1
 */