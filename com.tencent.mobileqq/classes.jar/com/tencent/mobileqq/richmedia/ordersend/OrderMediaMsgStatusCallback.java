package com.tencent.mobileqq.richmedia.ordersend;

import android.view.View;
import com.tencent.mobileqq.activity.aio.Callback;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class OrderMediaMsgStatusCallback
  implements Callback
{
  private ConcurrentHashMap<Long, OrderMediaMsgStatusCallback.CallbackWrapper> a;
  private ConcurrentLinkedQueue<Long> b = new ConcurrentLinkedQueue();
  private OrderMediaMsgStatusCallback.IStatusErrorListener c;
  private String d;
  private Long e;
  
  public OrderMediaMsgStatusCallback(String paramString)
  {
    this.d = paramString;
  }
  
  private void a(FileMsg paramFileMsg)
  {
    Object localObject1 = this.a;
    if ((localObject1 != null) && (((ConcurrentHashMap)localObject1).containsKey(Long.valueOf(paramFileMsg.uniseq))))
    {
      Object localObject2 = (OrderMediaMsgStatusCallback.CallbackWrapper)this.a.get(Long.valueOf(paramFileMsg.uniseq));
      if (localObject2 != null)
      {
        localObject1 = ((OrderMediaMsgStatusCallback.CallbackWrapper)localObject2).b();
        localObject2 = ((OrderMediaMsgStatusCallback.CallbackWrapper)localObject2).c();
        if ((localObject1 != null) && (localObject2 != null))
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("realHandleMessage1 status:");
            localStringBuilder.append(paramFileMsg.status);
            localStringBuilder.append(" ,uniseq");
            localStringBuilder.append(paramFileMsg.uniseq);
            QLog.d("OrderMediaMsgStatusCallback", 2, localStringBuilder.toString());
          }
          ((Callback)localObject2).handleMessage((View)localObject1, paramFileMsg, paramFileMsg.status, paramFileMsg.errorCode);
          return;
        }
        this.a.remove(Long.valueOf(paramFileMsg.uniseq));
        return;
      }
      this.a.remove(Long.valueOf(paramFileMsg.uniseq));
    }
  }
  
  private void a(FileMsg paramFileMsg, boolean paramBoolean)
  {
    if (paramFileMsg == null) {
      return;
    }
    this.e = ((Long)this.b.peek());
    if ((this.e != null) && (paramFileMsg.uniseq == this.e.longValue()))
    {
      a(paramFileMsg);
      if (paramFileMsg.status == 1003)
      {
        this.b.remove(this.e);
        this.a.remove(this.e);
        if (QLog.isColorLevel())
        {
          paramFileMsg = new StringBuilder();
          paramFileMsg.append("remove callback:");
          paramFileMsg.append(this.e);
          QLog.d("OrderMediaMsgStatusCallback", 2, paramFileMsg.toString());
        }
        a(b(), false);
      }
    }
    else if ((paramBoolean) && (this.a.containsKey(Long.valueOf(paramFileMsg.uniseq))))
    {
      Object localObject = (OrderMediaMsgStatusCallback.CallbackWrapper)this.a.get(Long.valueOf(paramFileMsg.uniseq));
      if (localObject != null)
      {
        ((OrderMediaMsgStatusCallback.CallbackWrapper)localObject).a(paramFileMsg);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("needCache fileStatus:");
          ((StringBuilder)localObject).append(paramFileMsg.status);
          ((StringBuilder)localObject).append(" ,uniseq:");
          ((StringBuilder)localObject).append(paramFileMsg.uniseq);
          QLog.d("OrderMediaMsgStatusCallback", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
  }
  
  private boolean a(long paramLong, int paramInt)
  {
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    boolean bool;
    if ((localObject != null) && (((IOrderMediaMsgService)((AppRuntime)localObject).getRuntimeService(IOrderMediaMsgService.class, "")).getMsgController().a(paramInt))) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool)
    {
      this.b.remove(Long.valueOf(paramLong));
      localObject = this.c;
      if (localObject != null) {
        ((OrderMediaMsgStatusCallback.IStatusErrorListener)localObject).a(paramLong, paramInt);
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleErrorMessage status:");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append(" ,uniseq:");
        ((StringBuilder)localObject).append(paramLong);
        QLog.d("OrderMediaMsgStatusCallback", 2, ((StringBuilder)localObject).toString());
      }
    }
    return bool;
  }
  
  private FileMsg b()
  {
    if (!this.b.isEmpty())
    {
      this.e = ((Long)this.b.peek());
      Object localObject = this.e;
      if ((localObject != null) && (this.a.containsKey(localObject)))
      {
        localObject = (OrderMediaMsgStatusCallback.CallbackWrapper)this.a.get(this.e);
        if (localObject != null) {
          return ((OrderMediaMsgStatusCallback.CallbackWrapper)localObject).a();
        }
      }
    }
    return null;
  }
  
  private void d(long paramLong)
  {
    Object localObject1 = this.a;
    if ((localObject1 != null) && (((ConcurrentHashMap)localObject1).containsKey(Long.valueOf(paramLong))))
    {
      Object localObject2 = (OrderMediaMsgStatusCallback.CallbackWrapper)this.a.get(Long.valueOf(paramLong));
      if (localObject2 != null)
      {
        localObject1 = ((OrderMediaMsgStatusCallback.CallbackWrapper)localObject2).b();
        Callback localCallback = ((OrderMediaMsgStatusCallback.CallbackWrapper)localObject2).c();
        localObject2 = ((OrderMediaMsgStatusCallback.CallbackWrapper)localObject2).a();
        if ((localObject1 != null) && (localCallback != null) && (localObject2 != null))
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("realHandleMessage2 status:");
            localStringBuilder.append(((FileMsg)localObject2).status);
            localStringBuilder.append(" ,uniseq:");
            localStringBuilder.append(((FileMsg)localObject2).uniseq);
            QLog.d("OrderMediaMsgStatusCallback", 2, localStringBuilder.toString());
          }
          ThreadManager.getUIHandler().post(new OrderMediaMsgStatusCallback.1(this, localCallback, (View)localObject1, (FileMsg)localObject2));
        }
      }
      else
      {
        this.a.remove(Long.valueOf(paramLong));
      }
    }
    else if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("CallbackWrapperMap not contain:");
      ((StringBuilder)localObject1).append(paramLong);
      QLog.d("OrderMediaMsgStatusCallback", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  public int a(long paramLong)
  {
    if (this.b.contains(Long.valueOf(paramLong)))
    {
      if (((Long)this.b.peek()).longValue() == paramLong) {
        return 1;
      }
      return 2;
    }
    return 0;
  }
  
  public void a()
  {
    ConcurrentHashMap localConcurrentHashMap = this.a;
    if (localConcurrentHashMap != null)
    {
      localConcurrentHashMap.clear();
      this.a = null;
    }
    this.b.clear();
    this.c = null;
  }
  
  public void a(OrderMediaMsgStatusCallback.IStatusErrorListener paramIStatusErrorListener)
  {
    this.c = paramIStatusErrorListener;
  }
  
  public boolean a(AppRuntime paramAppRuntime, long paramLong, View paramView, Callback paramCallback)
  {
    if (paramAppRuntime != null)
    {
      Object localObject1 = this.b;
      if ((localObject1 != null) && (((ConcurrentLinkedQueue)localObject1).contains(Long.valueOf(paramLong))))
      {
        if (this.a == null) {
          this.a = new ConcurrentHashMap();
        }
        int j = -1;
        localObject1 = "";
        ((IOrderMediaMsgService)paramAppRuntime.getRuntimeService(IOrderMediaMsgService.class, "")).getMsgController().a(paramView, this);
        Object localObject2;
        int i;
        if (!this.a.containsKey(Long.valueOf(paramLong)))
        {
          this.a.put(Long.valueOf(paramLong), new OrderMediaMsgStatusCallback.CallbackWrapper(this, paramView, paramCallback));
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("callback add success:");
            ((StringBuilder)localObject2).append(paramLong);
            QLog.d("OrderMediaMsgStatusCallback", 2, ((StringBuilder)localObject2).toString());
          }
          paramAppRuntime = ((ITransFileController)paramAppRuntime.getRuntimeService(ITransFileController.class, "")).findProcessor(this.d, paramLong);
          if (paramAppRuntime == null)
          {
            if (QLog.isColorLevel())
            {
              paramAppRuntime = new StringBuilder();
              paramAppRuntime.append("addCallback processor is null ");
              paramAppRuntime.append(paramLong);
              QLog.d("OrderMediaMsgStatusCallback", 2, paramAppRuntime.toString());
            }
            paramAppRuntime = this.c;
            i = j;
            if (paramAppRuntime != null)
            {
              paramAppRuntime.a(paramLong);
              i = j;
            }
          }
          else
          {
            i = j;
            if ((paramAppRuntime instanceof BaseTransProcessor))
            {
              paramAppRuntime = (BaseTransProcessor)paramAppRuntime;
              i = (int)paramAppRuntime.getFileStatus();
              if (!a(paramLong, i))
              {
                this.e = ((Long)this.b.peek());
                if (paramLong != 0L)
                {
                  localObject2 = this.e;
                  if ((localObject2 != null) && (paramLong != ((Long)localObject2).longValue()))
                  {
                    if (paramCallback != null)
                    {
                      paramCallback.handleMessage(paramView, paramAppRuntime.getFileMsg(), i, paramAppRuntime.mProcessorReport.errCode);
                      localObject2 = (OrderMediaMsgStatusCallback.CallbackWrapper)this.a.get(Long.valueOf(paramLong));
                      if (localObject2 != null) {
                        ((OrderMediaMsgStatusCallback.CallbackWrapper)localObject2).a(paramAppRuntime.getFileMsg());
                      }
                    }
                    if (QLog.isColorLevel())
                    {
                      paramAppRuntime = new StringBuilder();
                      paramAppRuntime.append("Not the first! status:");
                      paramAppRuntime.append(i);
                      paramAppRuntime.append(" ,uniseq:");
                      paramAppRuntime.append(paramLong);
                      QLog.d("OrderMediaMsgStatusCallback", 2, paramAppRuntime.toString());
                    }
                  }
                }
              }
            }
          }
        }
        else
        {
          paramAppRuntime = (OrderMediaMsgStatusCallback.CallbackWrapper)this.a.get(Long.valueOf(paramLong));
          paramAppRuntime.a = new WeakReference(paramView);
          paramAppRuntime.b = new WeakReference(paramCallback);
          i = j;
        }
        if (QLog.isDevelopLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("addCallback uniseq:");
          ((StringBuilder)localObject2).append(paramLong);
          ((StringBuilder)localObject2).append(" ,status:");
          ((StringBuilder)localObject2).append(i);
          ((StringBuilder)localObject2).append(" ,view:");
          if (paramView == null) {
            paramAppRuntime = "";
          } else {
            paramAppRuntime = paramView.toString();
          }
          ((StringBuilder)localObject2).append(paramAppRuntime);
          ((StringBuilder)localObject2).append(" ,callback:");
          if (paramCallback == null) {
            paramAppRuntime = (AppRuntime)localObject1;
          } else {
            paramAppRuntime = paramCallback.toString();
          }
          ((StringBuilder)localObject2).append(paramAppRuntime);
          QLog.d("OrderMediaMsgStatusCallback", 2, ((StringBuilder)localObject2).toString());
        }
        return true;
      }
    }
    return false;
  }
  
  public void b(long paramLong)
  {
    if (!this.b.contains(Long.valueOf(paramLong))) {
      this.b.offer(Long.valueOf(paramLong));
    }
  }
  
  public void c(long paramLong)
  {
    if (this.b.contains(Long.valueOf(paramLong)))
    {
      this.b.remove(Long.valueOf(paramLong));
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("removeUniseqFromOrderList ");
        localStringBuilder.append(paramLong);
        QLog.d("OrderMediaMsgStatusCallback", 2, localStringBuilder.toString());
      }
      d(paramLong);
    }
  }
  
  public void handleMessage(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    if (!this.b.contains(Long.valueOf(paramFileMsg.uniseq)))
    {
      a(paramFileMsg);
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("not exist in uniseqlist:");
        paramView.append(paramFileMsg.uniseq);
        QLog.d("OrderMediaMsgStatusCallback", 2, paramView.toString());
      }
      return;
    }
    boolean bool = true;
    paramView = paramFileMsg;
    if (a(paramFileMsg.uniseq, paramInt1))
    {
      a(paramFileMsg);
      paramView = b();
      bool = false;
    }
    a(paramView, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgStatusCallback
 * JD-Core Version:    0.7.0.1
 */