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
  protected OrderMediaMsgStatusCallback.IStatusErrorListener b = new OrderMediaMsgSessionQueue.1(this);
  MediaMessageObserver c = new OrderMediaMsgSessionQueue.2(this);
  private ConcurrentLinkedQueue<OrderMediaMsgItem> d;
  private OrderMediaMsgTimerController e;
  private OrderMediaMsgStatusCallback f;
  private IMediaMsgApi g;
  private OrderMediaMsgSessionQueue.IMsgPhaseListener h;
  private Iterator<OrderMediaMsgItem> i;
  private String j;
  private int k = 0;
  private long l = 0L;
  
  public OrderMediaMsgSessionQueue(String paramString, IMediaMsgApi paramIMediaMsgApi)
  {
    this.j = paramString;
    this.g = paramIMediaMsgApi;
    this.d = new ConcurrentLinkedQueue();
    this.f = new OrderMediaMsgStatusCallback(this.j);
    this.f.a(this.b);
    this.e = new OrderMediaMsgTimerController(this);
  }
  
  private void a(OrderMediaMsgItem paramOrderMediaMsgItem)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doNextAddSend ");
      localStringBuilder.append(paramOrderMediaMsgItem.a);
      localStringBuilder.append(", uniseq:");
      localStringBuilder.append(paramOrderMediaMsgItem.d);
      localStringBuilder.append(", addStatus:");
      localStringBuilder.append(paramOrderMediaMsgItem.b);
      localStringBuilder.append(", sendStatus:");
      localStringBuilder.append(paramOrderMediaMsgItem.c);
      QLog.d(a, 2, localStringBuilder.toString());
    }
    this.f.c(paramOrderMediaMsgItem.d);
    if (paramOrderMediaMsgItem.a()) {
      this.g.d(paramOrderMediaMsgItem.h);
    }
    if (paramOrderMediaMsgItem.c()) {
      this.g.a(paramOrderMediaMsgItem.h, paramOrderMediaMsgItem.i, paramOrderMediaMsgItem.j);
    }
    d();
    e();
  }
  
  private MessageRecord d(long paramLong)
  {
    Object localObject = null;
    MessageRecord localMessageRecord = null;
    if (paramLong != 0L)
    {
      Iterator localIterator = this.d.iterator();
      for (;;)
      {
        localObject = localMessageRecord;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (OrderMediaMsgItem)localIterator.next();
        if (paramLong == ((OrderMediaMsgItem)localObject).d) {
          localMessageRecord = ((OrderMediaMsgItem)localObject).h;
        }
      }
    }
    return localObject;
  }
  
  private void d()
  {
    try
    {
      Object localObject2 = this.d.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        OrderMediaMsgItem localOrderMediaMsgItem = (OrderMediaMsgItem)((Iterator)localObject2).next();
        if (localOrderMediaMsgItem.a())
        {
          localOrderMediaMsgItem.b = 2;
          this.f.b(localOrderMediaMsgItem.d);
          this.g.d(localOrderMediaMsgItem.h);
          Object localObject3;
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("success in add ");
            ((StringBuilder)localObject3).append(localOrderMediaMsgItem.a);
            ((StringBuilder)localObject3).append(", uniseq:");
            ((StringBuilder)localObject3).append(localOrderMediaMsgItem.d);
            ((StringBuilder)localObject3).append(", path:");
            ((StringBuilder)localObject3).append(localOrderMediaMsgItem.e);
            ((StringBuilder)localObject3).append(", status:");
            ((StringBuilder)localObject3).append(localOrderMediaMsgItem.b);
            QLog.d(a, 2, ((StringBuilder)localObject3).toString());
          }
          StringBuilder localStringBuilder;
          if (localOrderMediaMsgItem.k != null)
          {
            this.e.a(localOrderMediaMsgItem.k);
            localOrderMediaMsgItem.k = null;
            if (QLog.isColorLevel())
            {
              localObject3 = a;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("remove mAddTimeoutRunable1 uniseq:");
              localStringBuilder.append(localOrderMediaMsgItem.d);
              QLog.d((String)localObject3, 2, localStringBuilder.toString());
            }
          }
          if (localOrderMediaMsgItem.g)
          {
            if (QLog.isColorLevel())
            {
              localObject3 = a;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("invalid msg:");
              localStringBuilder.append(localOrderMediaMsgItem.d);
              QLog.d((String)localObject3, 2, localStringBuilder.toString());
            }
            a(localOrderMediaMsgItem.d);
          }
        }
        else if (!localOrderMediaMsgItem.b())
        {
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("not ready to add ");
            ((StringBuilder)localObject2).append(localOrderMediaMsgItem.a);
            ((StringBuilder)localObject2).append(", path:");
            ((StringBuilder)localObject2).append(localOrderMediaMsgItem.e);
            ((StringBuilder)localObject2).append(", mStatus:");
            ((StringBuilder)localObject2).append(localOrderMediaMsgItem.b);
            QLog.d(a, 2, ((StringBuilder)localObject2).toString());
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
  
  private void e()
  {
    try
    {
      if (this.d.isEmpty())
      {
        OrderMediaMsgReporter.a(this.k, System.currentTimeMillis() - this.l);
        if (this.h != null) {
          this.h.onAllCompleted(this.j);
        }
        this.e.c();
        this.l = 0L;
        this.k = 0;
        return;
      }
      OrderMediaMsgItem localOrderMediaMsgItem = (OrderMediaMsgItem)this.d.peek();
      if (localOrderMediaMsgItem != null)
      {
        StringBuilder localStringBuilder;
        if (localOrderMediaMsgItem.c())
        {
          localOrderMediaMsgItem.c = 4;
          this.e.a();
          this.e.d(localOrderMediaMsgItem.d);
          this.g.a(localOrderMediaMsgItem.h, this.c, localOrderMediaMsgItem.j);
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("success in send ");
            localStringBuilder.append(localOrderMediaMsgItem.a);
            localStringBuilder.append(", uniseq:");
            localStringBuilder.append(localOrderMediaMsgItem.d);
            localStringBuilder.append(", dest:");
            localStringBuilder.append(localOrderMediaMsgItem.e);
            localStringBuilder.append(", status:");
            localStringBuilder.append(localOrderMediaMsgItem.c);
            QLog.d(a, 2, localStringBuilder.toString());
          }
        }
        else if (!localOrderMediaMsgItem.d())
        {
          if (this.g.e(localOrderMediaMsgItem.h)) {
            localOrderMediaMsgItem.f = true;
          }
          boolean bool = this.e.b(localOrderMediaMsgItem.d);
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("not ready to send ");
            localStringBuilder.append(localOrderMediaMsgItem.a);
            localStringBuilder.append(", uniseq:");
            localStringBuilder.append(localOrderMediaMsgItem.d);
            localStringBuilder.append(", dest:");
            localStringBuilder.append(localOrderMediaMsgItem.e);
            localStringBuilder.append(", status:");
            localStringBuilder.append(localOrderMediaMsgItem.c);
            localStringBuilder.append(", needCompress:");
            localStringBuilder.append(localOrderMediaMsgItem.f);
            localStringBuilder.append(", addSuccess:");
            localStringBuilder.append(bool);
            QLog.d(a, 2, localStringBuilder.toString());
          }
        }
        QLog.d(a, 1, new Object[] { "queue peek", localOrderMediaMsgItem.toString() });
      }
      else
      {
        QLog.d(a, 1, "queue peek is empty!");
      }
      return;
    }
    finally {}
  }
  
  public OrderMediaMsgItem a(long paramLong)
  {
    this.i = this.d.iterator();
    while (this.i.hasNext())
    {
      OrderMediaMsgItem localOrderMediaMsgItem = (OrderMediaMsgItem)this.i.next();
      if (paramLong == localOrderMediaMsgItem.d)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("removeMediaMsgByUniseq ");
          localStringBuilder.append(localOrderMediaMsgItem.a);
          localStringBuilder.append(", uniseq:");
          localStringBuilder.append(localOrderMediaMsgItem.d);
          QLog.d(a, 2, localStringBuilder.toString());
        }
        this.i.remove();
        a(localOrderMediaMsgItem);
        return localOrderMediaMsgItem;
      }
    }
    return null;
  }
  
  public OrderMediaMsgItem a(String paramString)
  {
    this.i = this.d.iterator();
    while (this.i.hasNext())
    {
      OrderMediaMsgItem localOrderMediaMsgItem = (OrderMediaMsgItem)this.i.next();
      if (paramString.equals(localOrderMediaMsgItem.e))
      {
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("removeMediaMsgByPath ");
          paramString.append(localOrderMediaMsgItem.a);
          paramString.append(", uniseq:");
          paramString.append(localOrderMediaMsgItem.d);
          QLog.d(a, 2, paramString.toString());
        }
        this.i.remove();
        a(localOrderMediaMsgItem);
        return localOrderMediaMsgItem;
      }
    }
    return null;
  }
  
  public OrderMediaMsgStatusCallback a()
  {
    return this.f;
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    this.e.c(paramLong);
    if (paramInt2 == 0)
    {
      a(paramLong);
      QLog.d(a, 1, new Object[] { "blocking!!! count zero ", Long.valueOf(paramLong) });
      return;
    }
    if (paramInt1 == -1)
    {
      paramInt1 = this.g.a(d(paramLong));
      this.e.a(paramLong, paramInt1, paramInt2 - 1);
      return;
    }
    int m = this.g.a(d(paramLong));
    if (m > paramInt1)
    {
      this.e.a(paramLong, m, paramInt2);
      return;
    }
    a(paramLong);
    QLog.d(a, 1, new Object[] { "blocking!!! progress stuck ", Long.valueOf(paramLong) });
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if ((paramLong1 != 0L) && (paramLong2 != 0L))
    {
      boolean bool = this.d.isEmpty();
      int n = 1;
      if (!bool)
      {
        Iterator localIterator = this.d.iterator();
        while (localIterator.hasNext())
        {
          OrderMediaMsgItem localOrderMediaMsgItem = (OrderMediaMsgItem)localIterator.next();
          if (paramLong1 == localOrderMediaMsgItem.d)
          {
            localOrderMediaMsgItem.d = paramLong2;
            if (localOrderMediaMsgItem.k != null)
            {
              this.e.a(localOrderMediaMsgItem.k);
              localOrderMediaMsgItem.k = this.e.a(paramLong2);
            }
            m = n;
            if (!QLog.isColorLevel()) {
              break label169;
            }
            QLog.d(a, 2, new Object[] { "updateMediaMsgByUniseq old:", Long.valueOf(paramLong1), ", new:", Long.valueOf(paramLong2) });
            m = n;
            break label169;
          }
        }
      }
      int m = 0;
      label169:
      if (m == 0) {
        a(paramLong2, "");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "oldSeq and newSeq should not be zero");
    }
  }
  
  public void a(long paramLong, String paramString)
  {
    a(paramLong, paramString, false);
  }
  
  public void a(long paramLong, String paramString, boolean paramBoolean)
  {
    Object localObject = new OrderMediaMsgItem();
    ((OrderMediaMsgItem)localObject).d = paramLong;
    ((OrderMediaMsgItem)localObject).e = paramString;
    ((OrderMediaMsgItem)localObject).g = paramBoolean;
    int m = this.k + 1;
    this.k = m;
    ((OrderMediaMsgItem)localObject).a = m;
    ((OrderMediaMsgItem)localObject).b = 0;
    ((OrderMediaMsgItem)localObject).c = 0;
    this.d.offer(localObject);
    if (paramLong != 0L) {
      ((OrderMediaMsgItem)localObject).k = this.e.a(paramLong);
    } else {
      ((OrderMediaMsgItem)localObject).k = this.e.a(paramString);
    }
    if (this.l == 0L) {
      this.l = System.currentTimeMillis();
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("enqueueMediaMsg msgSize:");
      ((StringBuilder)localObject).append(this.k);
      ((StringBuilder)localObject).append(", uniseq:");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(", path:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", queue:");
      ((StringBuilder)localObject).append(this.d.size());
      QLog.d(a, 2, ((StringBuilder)localObject).toString());
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
      QLog.d(a, 2, ((StringBuilder)localObject).toString());
    }
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      localObject = (OrderMediaMsgItem)localIterator.next();
      if ((((OrderMediaMsgItem)localObject).d != 0L) && (paramLong == ((OrderMediaMsgItem)localObject).d))
      {
        ((OrderMediaMsgItem)localObject).h = paramMessageRecord;
        if (paramBoolean)
        {
          ((OrderMediaMsgItem)localObject).b = 1;
        }
        else
        {
          ((OrderMediaMsgItem)localObject).b = 2;
          if (((OrderMediaMsgItem)localObject).k != null)
          {
            this.e.a(((OrderMediaMsgItem)localObject).k);
            ((OrderMediaMsgItem)localObject).k = null;
            if (QLog.isColorLevel())
            {
              paramMessageRecord = a;
              paramString = new StringBuilder();
              paramString.append("remove mAddTimeoutRunable2 uniseq:");
              paramString.append(((OrderMediaMsgItem)localObject).d);
              QLog.d(paramMessageRecord, 2, paramString.toString());
            }
          }
        }
      }
      else if ((((OrderMediaMsgItem)localObject).d == 0L) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(((OrderMediaMsgItem)localObject).e)))
      {
        ((OrderMediaMsgItem)localObject).h = paramMessageRecord;
        ((OrderMediaMsgItem)localObject).d = paramLong;
        if (paramBoolean)
        {
          ((OrderMediaMsgItem)localObject).b = 1;
        }
        else
        {
          ((OrderMediaMsgItem)localObject).b = 2;
          if (((OrderMediaMsgItem)localObject).k != null)
          {
            this.e.a(((OrderMediaMsgItem)localObject).k);
            ((OrderMediaMsgItem)localObject).k = null;
            if (QLog.isColorLevel())
            {
              paramMessageRecord = a;
              paramString = new StringBuilder();
              paramString.append("remove mAddTimeoutRunable3 uniseq:");
              paramString.append(((OrderMediaMsgItem)localObject).d);
              QLog.d(paramMessageRecord, 2, paramString.toString());
            }
          }
        }
      }
    }
    if (paramBoolean) {
      d();
    }
  }
  
  public void a(MessageRecord paramMessageRecord, MediaMessageObserver paramMediaMessageObserver, IOrderMediaMsgService.IMsgSendingListener paramIMsgSendingListener)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("sendOrderMsgRecord:");
      ((StringBuilder)localObject2).append(paramMessageRecord.uniseq);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = this.d.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (OrderMediaMsgItem)((Iterator)localObject2).next();
      if (paramMessageRecord.uniseq == ((OrderMediaMsgItem)localObject1).d)
      {
        ((OrderMediaMsgItem)localObject1).h = paramMessageRecord;
        ((OrderMediaMsgItem)localObject1).i = paramMediaMessageObserver;
        ((OrderMediaMsgItem)localObject1).j = paramIMsgSendingListener;
        ((OrderMediaMsgItem)localObject1).c = 3;
        if (QLog.isColorLevel())
        {
          paramMessageRecord = new StringBuilder();
          paramMessageRecord.append("ready to send ");
          paramMessageRecord.append(((OrderMediaMsgItem)localObject1).a);
          paramMessageRecord.append(", uniseq:");
          paramMessageRecord.append(((OrderMediaMsgItem)localObject1).d);
          paramMessageRecord.append(", addStatus:");
          paramMessageRecord.append(((OrderMediaMsgItem)localObject1).b);
          paramMessageRecord.append(", sendStatus:");
          paramMessageRecord.append(((OrderMediaMsgItem)localObject1).c);
          QLog.d(a, 2, paramMessageRecord.toString());
        }
      }
    }
    e();
  }
  
  public void a(OrderMediaMsgSessionQueue.IMsgPhaseListener paramIMsgPhaseListener)
  {
    this.h = paramIMsgPhaseListener;
  }
  
  public void a(Object paramObject)
  {
    OrderMediaMsgItem localOrderMediaMsgItem;
    int m;
    if ((paramObject instanceof Long))
    {
      localOrderMediaMsgItem = a(((Long)paramObject).longValue());
      m = 1;
    }
    else if ((paramObject instanceof String))
    {
      localOrderMediaMsgItem = a((String)paramObject);
      m = 2;
    }
    else
    {
      localOrderMediaMsgItem = null;
      m = 0;
    }
    int n;
    if ((localOrderMediaMsgItem != null) && (localOrderMediaMsgItem.h != null)) {
      n = localOrderMediaMsgItem.h.msgtype;
    } else {
      n = -1;
    }
    OrderMediaMsgReporter.a(n, m);
    QLog.d(a, 1, new Object[] { "timeout!!! add msg:", paramObject, " ,msgtype:", Integer.valueOf(n) });
  }
  
  public void b(long paramLong)
  {
    this.e.a();
    Object localObject1 = null;
    Object localObject2 = null;
    if (paramLong != 0L)
    {
      if (this.g.c(d(paramLong))) {
        localObject1 = a(paramLong);
      }
    }
    else if (!this.d.isEmpty())
    {
      OrderMediaMsgItem localOrderMediaMsgItem = (OrderMediaMsgItem)this.d.peek();
      localObject1 = localObject2;
      if (localOrderMediaMsgItem != null)
      {
        localObject1 = localObject2;
        if (this.g.c(localOrderMediaMsgItem.h)) {
          localObject1 = a(localOrderMediaMsgItem.d);
        }
      }
      QLog.d(a, 1, new Object[] { "uniseq is invalid:", Long.valueOf(paramLong) });
    }
    int m;
    boolean bool;
    if (localObject1 != null)
    {
      if (((OrderMediaMsgItem)localObject1).h == null) {
        m = 0;
      } else {
        m = ((OrderMediaMsgItem)localObject1).h.msgtype;
      }
      bool = true;
    }
    else
    {
      m = -1;
      bool = false;
    }
    OrderMediaMsgReporter.a(m, bool);
    if (!bool)
    {
      int n = this.g.a(d(paramLong));
      this.e.a(paramLong, n, 3);
    }
    QLog.d(a, 1, new Object[] { "timeout!!! upload msg:", Long.valueOf(paramLong), " ,invalid:", Boolean.valueOf(bool), " ,msgtype:", Integer.valueOf(m) });
  }
  
  public boolean b()
  {
    return this.d.isEmpty();
  }
  
  public boolean b(long paramLong, String paramString)
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      OrderMediaMsgItem localOrderMediaMsgItem = (OrderMediaMsgItem)localIterator.next();
      if ((localOrderMediaMsgItem.d != 0L) && (paramLong == localOrderMediaMsgItem.d)) {
        return true;
      }
      if ((localOrderMediaMsgItem.d == 0L) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(localOrderMediaMsgItem.e))) {
        return true;
      }
    }
    return false;
  }
  
  public void c()
  {
    Object localObject = this.f;
    if (localObject != null)
    {
      ((OrderMediaMsgStatusCallback)localObject).a();
      this.f = null;
    }
    localObject = this.d;
    if (localObject != null)
    {
      ((ConcurrentLinkedQueue)localObject).clear();
      this.d = null;
    }
    localObject = this.e;
    if (localObject != null)
    {
      ((OrderMediaMsgTimerController)localObject).c();
      this.e = null;
    }
    this.h = null;
  }
  
  public void c(long paramLong)
  {
    this.e.b();
    OrderMediaMsgItem localOrderMediaMsgItem = a(paramLong);
    if (localOrderMediaMsgItem != null)
    {
      QLog.d(a, 1, new Object[] { "timeout!!! send msg:", Long.valueOf(paramLong), localOrderMediaMsgItem.toString() });
      return;
    }
    QLog.d(a, 1, new Object[] { "timeout!!! send msg:", Long.valueOf(paramLong) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgSessionQueue
 * JD-Core Version:    0.7.0.1
 */