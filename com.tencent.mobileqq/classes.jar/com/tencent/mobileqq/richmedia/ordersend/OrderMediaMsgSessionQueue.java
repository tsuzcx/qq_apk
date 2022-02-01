package com.tencent.mobileqq.richmedia.ordersend;

import android.text.TextUtils;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class OrderMediaMsgSessionQueue
  implements OrderMediaMsgTimerController.IMsgTimeoutListener
{
  public static String a;
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 0L;
  MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new OrderMediaMsgSessionQueue.2(this);
  private MediaMsgController jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendMediaMsgController;
  private OrderMediaMsgSessionQueue.IMsgPhaseListener jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgSessionQueue$IMsgPhaseListener;
  protected OrderMediaMsgStatusCallback.IStatusErrorListener a;
  private OrderMediaMsgStatusCallback jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgStatusCallback;
  private OrderMediaMsgTimerController jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgTimerController;
  private Iterator<OrderMediaMsgItem> jdField_a_of_type_JavaUtilIterator;
  private ConcurrentLinkedQueue<OrderMediaMsgItem> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue;
  private String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = "OrderMediaMsgSessionQueue";
  }
  
  public OrderMediaMsgSessionQueue(String paramString, MediaMsgController paramMediaMsgController)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgStatusCallback$IStatusErrorListener = new OrderMediaMsgSessionQueue.1(this);
    this.b = paramString;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendMediaMsgController = paramMediaMsgController;
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
      localObject = localMessageRecord;
      if (localIterator.hasNext())
      {
        localObject = (OrderMediaMsgItem)localIterator.next();
        if (paramLong != ((OrderMediaMsgItem)localObject).jdField_a_of_type_Long) {
          break label67;
        }
        localMessageRecord = ((OrderMediaMsgItem)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      }
    }
    label67:
    for (;;)
    {
      break;
      return localObject;
    }
  }
  
  private void a(OrderMediaMsgItem paramOrderMediaMsgItem)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doNextAddSend ").append(paramOrderMediaMsgItem.jdField_a_of_type_Int).append(", uniseq:").append(paramOrderMediaMsgItem.jdField_a_of_type_Long).append(", addStatus:").append(paramOrderMediaMsgItem.jdField_b_of_type_Int).append(", sendStatus:").append(paramOrderMediaMsgItem.c);
      QLog.d(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgStatusCallback.b(paramOrderMediaMsgItem.jdField_a_of_type_Long);
    if (paramOrderMediaMsgItem.a()) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendMediaMsgController.a(paramOrderMediaMsgItem.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    }
    if (paramOrderMediaMsgItem.c()) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendMediaMsgController.a(paramOrderMediaMsgItem.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, paramOrderMediaMsgItem.jdField_a_of_type_ComTencentMobileqqAppMessageObserver, paramOrderMediaMsgItem.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgManager$IMsgSendingListener);
    }
    b();
    c();
  }
  
  private void b()
  {
    Object localObject2;
    try
    {
      localObject2 = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
      do
      {
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label325;
          }
          OrderMediaMsgItem localOrderMediaMsgItem = (OrderMediaMsgItem)((Iterator)localObject2).next();
          if (!localOrderMediaMsgItem.a()) {
            break;
          }
          localOrderMediaMsgItem.jdField_b_of_type_Int = 2;
          this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgStatusCallback.a(localOrderMediaMsgItem.jdField_a_of_type_Long);
          this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendMediaMsgController.a(localOrderMediaMsgItem.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("success in add ").append(localOrderMediaMsgItem.jdField_a_of_type_Int).append(", uniseq:").append(localOrderMediaMsgItem.jdField_a_of_type_Long).append(", path:").append(localOrderMediaMsgItem.jdField_a_of_type_JavaLangString).append(", status:").append(localOrderMediaMsgItem.jdField_b_of_type_Int);
            QLog.d(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
          }
          if (localOrderMediaMsgItem.jdField_a_of_type_JavaLangRunnable != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgTimerController.a(localOrderMediaMsgItem.jdField_a_of_type_JavaLangRunnable);
            localOrderMediaMsgItem.jdField_a_of_type_JavaLangRunnable = null;
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "remove mAddTimeoutRunable1 uniseq:" + localOrderMediaMsgItem.jdField_a_of_type_Long);
            }
          }
          if (localOrderMediaMsgItem.jdField_b_of_type_Boolean)
          {
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "invalid msg:" + localOrderMediaMsgItem.jdField_a_of_type_Long);
            }
            a(localOrderMediaMsgItem.jdField_a_of_type_Long);
          }
        }
      } while (localObject1.b());
    }
    finally {}
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("not ready to add ").append(localObject1.jdField_a_of_type_Int).append(", path:").append(localObject1.jdField_a_of_type_JavaLangString).append(", mStatus:").append(localObject1.jdField_b_of_type_Int);
      QLog.d(jdField_a_of_type_JavaLangString, 2, ((StringBuilder)localObject2).toString());
    }
    label325:
  }
  
  private void c()
  {
    for (;;)
    {
      StringBuilder localStringBuilder;
      try
      {
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.isEmpty())
        {
          OrderMediaMsgReporter.a(this.jdField_a_of_type_Int, System.currentTimeMillis() - this.jdField_a_of_type_Long);
          if (this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgSessionQueue$IMsgPhaseListener != null) {
            this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgSessionQueue$IMsgPhaseListener.a(this.b);
          }
          this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgTimerController.b();
          this.jdField_a_of_type_Long = 0L;
          this.jdField_a_of_type_Int = 0;
          return;
        }
        OrderMediaMsgItem localOrderMediaMsgItem = (OrderMediaMsgItem)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.peek();
        if (localOrderMediaMsgItem == null) {
          continue;
        }
        if (localOrderMediaMsgItem.c())
        {
          localOrderMediaMsgItem.c = 4;
          this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgTimerController.a();
          this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendMediaMsgController.a(localOrderMediaMsgItem.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver, localOrderMediaMsgItem.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgManager$IMsgSendingListener);
          if (!QLog.isColorLevel()) {
            continue;
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("success in send ").append(localOrderMediaMsgItem.jdField_a_of_type_Int).append(", uniseq:").append(localOrderMediaMsgItem.jdField_a_of_type_Long).append(", dest:").append(localOrderMediaMsgItem.jdField_a_of_type_JavaLangString).append(", status:").append(localOrderMediaMsgItem.c);
          QLog.d(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
          continue;
        }
        if (localObject.d()) {
          continue;
        }
      }
      finally {}
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendMediaMsgController.c(localObject.jdField_a_of_type_ComTencentMobileqqDataMessageRecord)) {
        localObject.jdField_a_of_type_Boolean = true;
      }
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgTimerController.a(localObject.jdField_a_of_type_Long);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("not ready to send ").append(localObject.jdField_a_of_type_Int).append(", uniseq:").append(localObject.jdField_a_of_type_Long).append(", dest:").append(localObject.jdField_a_of_type_JavaLangString).append(", status:").append(localObject.c).append(", needCompress:").append(localObject.jdField_a_of_type_Boolean).append(", addSuccess:").append(bool);
        QLog.d(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
      }
    }
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
          localStringBuilder.append("removeMediaMsgByUniseq ").append(localOrderMediaMsgItem.jdField_a_of_type_Int).append(", uniseq:").append(localOrderMediaMsgItem.jdField_a_of_type_Long);
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
          paramString.append("removeMediaMsgByPath ").append(localOrderMediaMsgItem.jdField_a_of_type_Int).append(", uniseq:").append(localOrderMediaMsgItem.jdField_a_of_type_Long);
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
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgStatusCallback != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgStatusCallback.a();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgStatusCallback = null;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.clear();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgTimerController != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgTimerController.b();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgTimerController = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgSessionQueue$IMsgPhaseListener = null;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgTimerController.a();
    OrderMediaMsgItem localOrderMediaMsgItem = null;
    if (paramLong != 0L) {
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendMediaMsgController.a(a(paramLong))) {
        localOrderMediaMsgItem = a(paramLong);
      }
    }
    int i;
    label53:
    boolean bool;
    for (;;)
    {
      if (localOrderMediaMsgItem != null) {
        if (localOrderMediaMsgItem.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null)
        {
          i = 0;
          bool = true;
          label56:
          OrderMediaMsgReporter.a(i, bool);
          if (!bool)
          {
            int j = this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendMediaMsgController.b(a(paramLong));
            this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgTimerController.a(paramLong, j, 3);
          }
          QLog.d(jdField_a_of_type_JavaLangString, 1, new Object[] { "timeout!!! send msg:", Long.valueOf(paramLong), " ,invalid:", Boolean.valueOf(bool), " ,msgtype:", Integer.valueOf(i) });
          return;
          if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.isEmpty()) {
            continue;
          }
          localOrderMediaMsgItem = (OrderMediaMsgItem)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.peek();
          if ((localOrderMediaMsgItem == null) || (!this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendMediaMsgController.a(localOrderMediaMsgItem.jdField_a_of_type_ComTencentMobileqqDataMessageRecord))) {
            break label245;
          }
        }
      }
    }
    label245:
    for (localOrderMediaMsgItem = a(localOrderMediaMsgItem.jdField_a_of_type_Long);; localOrderMediaMsgItem = null)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, new Object[] { "uniseq is invalid:", Long.valueOf(paramLong) });
      break;
      i = localOrderMediaMsgItem.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype;
      break label53;
      i = -1;
      bool = false;
      break label56;
    }
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
      paramInt1 = this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendMediaMsgController.b(a(paramLong));
      this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgTimerController.a(paramLong, paramInt1, paramInt2 - 1);
      return;
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendMediaMsgController.b(a(paramLong));
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
    if ((paramLong1 == 0L) || (paramLong2 == 0L)) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "oldSeq and newSeq should not be zero");
      }
    }
    for (;;)
    {
      return;
      int i;
      if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.isEmpty())
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
        for (;;)
        {
          if (localIterator.hasNext())
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
              if (QLog.isColorLevel())
              {
                QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "updateMediaMsgByUniseq old:", Long.valueOf(paramLong1), ", new:", Long.valueOf(paramLong2) });
                i = 1;
              }
            }
          }
        }
      }
      while (i == 0)
      {
        a(paramLong2, "");
        return;
        i = 1;
        continue;
        i = 0;
      }
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
    if (paramLong != 0L) {}
    for (((OrderMediaMsgItem)localObject).jdField_a_of_type_JavaLangRunnable = this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgTimerController.a(paramLong);; ((OrderMediaMsgItem)localObject).jdField_a_of_type_JavaLangRunnable = this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgTimerController.a(paramString))
    {
      if (this.jdField_a_of_type_Long == 0L) {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("enqueueMediaMsg msgSize:").append(this.jdField_a_of_type_Int).append(", uniseq:").append(paramLong).append(", path:").append(paramString).append(", queue:").append(this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
        QLog.d(jdField_a_of_type_JavaLangString, 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
  }
  
  public void a(MessageRecord paramMessageRecord, long paramLong, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("addOrderMsgRecord").append(" uniseq:").append(paramLong).append(", path:").append(paramString).append(", realadd:").append(paramBoolean);
      QLog.d(jdField_a_of_type_JavaLangString, 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
    OrderMediaMsgItem localOrderMediaMsgItem;
    if (((Iterator)localObject).hasNext())
    {
      localOrderMediaMsgItem = (OrderMediaMsgItem)((Iterator)localObject).next();
      if ((localOrderMediaMsgItem.jdField_a_of_type_Long == 0L) || (paramLong != localOrderMediaMsgItem.jdField_a_of_type_Long)) {
        break label217;
      }
      localOrderMediaMsgItem.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
      if (!paramBoolean) {
        break label145;
      }
      localOrderMediaMsgItem.jdField_b_of_type_Int = 1;
    }
    for (;;)
    {
      if (paramBoolean) {
        b();
      }
      return;
      label145:
      localOrderMediaMsgItem.jdField_b_of_type_Int = 2;
      if (localOrderMediaMsgItem.jdField_a_of_type_JavaLangRunnable != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgTimerController.a(localOrderMediaMsgItem.jdField_a_of_type_JavaLangRunnable);
        localOrderMediaMsgItem.jdField_a_of_type_JavaLangRunnable = null;
        if (QLog.isColorLevel())
        {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "remove mAddTimeoutRunable2 uniseq:" + localOrderMediaMsgItem.jdField_a_of_type_Long);
          continue;
          label217:
          if ((localOrderMediaMsgItem.jdField_a_of_type_Long != 0L) || (TextUtils.isEmpty(paramString)) || (!paramString.equals(localOrderMediaMsgItem.jdField_a_of_type_JavaLangString))) {
            break;
          }
          localOrderMediaMsgItem.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
          localOrderMediaMsgItem.jdField_a_of_type_Long = paramLong;
          if (paramBoolean)
          {
            localOrderMediaMsgItem.jdField_b_of_type_Int = 1;
          }
          else
          {
            localOrderMediaMsgItem.jdField_b_of_type_Int = 2;
            if (localOrderMediaMsgItem.jdField_a_of_type_JavaLangRunnable != null)
            {
              this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgTimerController.a(localOrderMediaMsgItem.jdField_a_of_type_JavaLangRunnable);
              localOrderMediaMsgItem.jdField_a_of_type_JavaLangRunnable = null;
              if (QLog.isColorLevel()) {
                QLog.d(jdField_a_of_type_JavaLangString, 2, "remove mAddTimeoutRunable3 uniseq:" + localOrderMediaMsgItem.jdField_a_of_type_Long);
              }
            }
          }
        }
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord, MessageObserver paramMessageObserver, OrderMediaMsgManager.IMsgSendingListener paramIMsgSendingListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "sendOrderMsgRecord:" + paramMessageRecord.uniseq);
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
    while (localIterator.hasNext())
    {
      OrderMediaMsgItem localOrderMediaMsgItem = (OrderMediaMsgItem)localIterator.next();
      if (paramMessageRecord.uniseq == localOrderMediaMsgItem.jdField_a_of_type_Long)
      {
        localOrderMediaMsgItem.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
        localOrderMediaMsgItem.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = paramMessageObserver;
        localOrderMediaMsgItem.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgManager$IMsgSendingListener = paramIMsgSendingListener;
        localOrderMediaMsgItem.c = 3;
        if (QLog.isColorLevel())
        {
          paramMessageRecord = new StringBuilder();
          paramMessageRecord.append("ready to send ").append(localOrderMediaMsgItem.jdField_a_of_type_Int).append(", uniseq:").append(localOrderMediaMsgItem.jdField_a_of_type_Long).append(", addStatus:").append(localOrderMediaMsgItem.jdField_b_of_type_Int).append(", sendStatus:").append(localOrderMediaMsgItem.c);
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
    OrderMediaMsgItem localOrderMediaMsgItem = null;
    int i;
    if ((paramObject instanceof Long))
    {
      localOrderMediaMsgItem = a(((Long)paramObject).longValue());
      i = 1;
    }
    for (;;)
    {
      if ((localOrderMediaMsgItem != null) && (localOrderMediaMsgItem.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)) {}
      for (int j = localOrderMediaMsgItem.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype;; j = -1)
      {
        OrderMediaMsgReporter.a(j, i);
        QLog.d(jdField_a_of_type_JavaLangString, 1, new Object[] { "timeout!!! add msg:", paramObject, " ,msgtype:", Integer.valueOf(j) });
        return;
        if (!(paramObject instanceof String)) {
          break label114;
        }
        localOrderMediaMsgItem = a((String)paramObject);
        i = 2;
        break;
      }
      label114:
      i = 0;
    }
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgSessionQueue
 * JD-Core Version:    0.7.0.1
 */