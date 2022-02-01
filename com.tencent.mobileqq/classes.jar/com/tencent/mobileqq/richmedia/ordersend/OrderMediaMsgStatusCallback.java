package com.tencent.mobileqq.richmedia.ordersend;

import android.view.View;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.activity.aio.FileTransferManager.Callback;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.os.MqqHandler;

public class OrderMediaMsgStatusCallback
  implements FileTransferManager.Callback
{
  private OrderMediaMsgStatusCallback.IStatusErrorListener jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgStatusCallback$IStatusErrorListener;
  private Long jdField_a_of_type_JavaLangLong;
  private String jdField_a_of_type_JavaLangString;
  private ConcurrentHashMap<Long, OrderMediaMsgStatusCallback.CallbackWrapper> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private ConcurrentLinkedQueue<Long> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  
  public OrderMediaMsgStatusCallback(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private FileMsg a()
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.isEmpty())
    {
      this.jdField_a_of_type_JavaLangLong = ((Long)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.peek());
      if ((this.jdField_a_of_type_JavaLangLong != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(this.jdField_a_of_type_JavaLangLong)))
      {
        OrderMediaMsgStatusCallback.CallbackWrapper localCallbackWrapper = (OrderMediaMsgStatusCallback.CallbackWrapper)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(this.jdField_a_of_type_JavaLangLong);
        if (localCallbackWrapper != null) {
          return localCallbackWrapper.a();
        }
      }
    }
    return null;
  }
  
  private void a(FileMsg paramFileMsg)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramFileMsg.uniseq))))
    {
      Object localObject = (OrderMediaMsgStatusCallback.CallbackWrapper)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramFileMsg.uniseq));
      if (localObject == null) {
        break label150;
      }
      View localView = ((OrderMediaMsgStatusCallback.CallbackWrapper)localObject).a();
      localObject = ((OrderMediaMsgStatusCallback.CallbackWrapper)localObject).a();
      if ((localView != null) && (localObject != null))
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("realHandleMessage1 status:").append(paramFileMsg.status).append(" ,uniseq").append(paramFileMsg.uniseq);
          QLog.d("OrderMediaMsgStatusCallback", 2, localStringBuilder.toString());
        }
        ((FileTransferManager.Callback)localObject).a(localView, paramFileMsg, paramFileMsg.status, paramFileMsg.errorCode);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramFileMsg.uniseq));
    return;
    label150:
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramFileMsg.uniseq));
  }
  
  private void a(FileMsg paramFileMsg, boolean paramBoolean)
  {
    if (paramFileMsg == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            this.jdField_a_of_type_JavaLangLong = ((Long)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.peek());
            if ((this.jdField_a_of_type_JavaLangLong == null) || (paramFileMsg.uniseq != this.jdField_a_of_type_JavaLangLong.longValue())) {
              break;
            }
            a(paramFileMsg);
          } while (paramFileMsg.status != 1003);
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.remove(this.jdField_a_of_type_JavaLangLong);
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(this.jdField_a_of_type_JavaLangLong);
          if (QLog.isColorLevel()) {
            QLog.d("OrderMediaMsgStatusCallback", 2, "remove callback:" + this.jdField_a_of_type_JavaLangLong);
          }
          a(a(), false);
          return;
        } while ((!paramBoolean) || (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramFileMsg.uniseq))));
        localObject = (OrderMediaMsgStatusCallback.CallbackWrapper)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramFileMsg.uniseq));
      } while (localObject == null);
      ((OrderMediaMsgStatusCallback.CallbackWrapper)localObject).a(paramFileMsg);
    } while (!QLog.isColorLevel());
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("needCache fileStatus:").append(paramFileMsg.status).append(" ,uniseq:").append(paramFileMsg.uniseq);
    QLog.d("OrderMediaMsgStatusCallback", 2, ((StringBuilder)localObject).toString());
  }
  
  private boolean a(long paramLong, int paramInt)
  {
    boolean bool1 = false;
    if (MediaMsgController.b(paramInt))
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.remove(Long.valueOf(paramLong));
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgStatusCallback$IStatusErrorListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgStatusCallback$IStatusErrorListener.a(paramLong, paramInt);
      }
      boolean bool2 = true;
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleErrorMessage status:").append(paramInt).append(" ,uniseq:").append(paramLong);
        QLog.d("OrderMediaMsgStatusCallback", 2, localStringBuilder.toString());
        bool1 = bool2;
      }
    }
    return bool1;
  }
  
  private void c(long paramLong)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong))))
    {
      localObject = (OrderMediaMsgStatusCallback.CallbackWrapper)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
      if (localObject != null)
      {
        localView = ((OrderMediaMsgStatusCallback.CallbackWrapper)localObject).a();
        localCallback = ((OrderMediaMsgStatusCallback.CallbackWrapper)localObject).a();
        localObject = ((OrderMediaMsgStatusCallback.CallbackWrapper)localObject).a();
        if ((localView != null) && (localCallback != null) && (localObject != null))
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("realHandleMessage2 status:").append(((FileMsg)localObject).status).append(" ,uniseq:").append(((FileMsg)localObject).uniseq);
            QLog.d("OrderMediaMsgStatusCallback", 2, localStringBuilder.toString());
          }
          ThreadManager.getUIHandler().post(new OrderMediaMsgStatusCallback.1(this, localCallback, localView, (FileMsg)localObject));
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      Object localObject;
      View localView;
      FileTransferManager.Callback localCallback;
      StringBuilder localStringBuilder;
      return;
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramLong));
      return;
    }
    QLog.d("OrderMediaMsgStatusCallback", 2, "CallbackWrapperMap not contain:" + paramLong);
  }
  
  public int a(long paramLong)
  {
    int i = 0;
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.contains(Long.valueOf(paramLong)))
    {
      if (((Long)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.peek()).longValue() == paramLong) {
        i = 1;
      }
    }
    else {
      return i;
    }
    return 2;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = null;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.clear();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgStatusCallback$IStatusErrorListener = null;
  }
  
  public void a(long paramLong)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.contains(Long.valueOf(paramLong))) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.offer(Long.valueOf(paramLong));
    }
  }
  
  public void a(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.contains(Long.valueOf(paramFileMsg.uniseq)))
    {
      a(paramFileMsg);
      if (QLog.isColorLevel()) {
        QLog.d("OrderMediaMsgStatusCallback", 2, "not exist in uniseqlist:" + paramFileMsg.uniseq);
      }
      return;
    }
    boolean bool = true;
    paramView = paramFileMsg;
    if (a(paramFileMsg.uniseq, paramInt1))
    {
      a(paramFileMsg);
      paramView = a();
      bool = false;
    }
    a(paramView, bool);
  }
  
  public void a(OrderMediaMsgStatusCallback.IStatusErrorListener paramIStatusErrorListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgStatusCallback$IStatusErrorListener = paramIStatusErrorListener;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, long paramLong, View paramView, FileTransferManager.Callback paramCallback)
  {
    if ((paramQQAppInterface == null) || (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue == null) || (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.contains(Long.valueOf(paramLong)))) {
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    }
    Object localObject = FileTransferManager.a(paramQQAppInterface);
    if (localObject != null) {
      ((FileTransferManager)localObject).a(paramView, this);
    }
    int i;
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong)))
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong), new OrderMediaMsgStatusCallback.CallbackWrapper(this, paramView, paramCallback));
      if (QLog.isColorLevel()) {
        QLog.d("OrderMediaMsgStatusCallback", 2, "callback add success:" + paramLong);
      }
      paramQQAppInterface = ((ITransFileController)paramQQAppInterface.getRuntimeService(ITransFileController.class)).findProcessor(this.jdField_a_of_type_JavaLangString, paramLong);
      if (paramQQAppInterface == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("OrderMediaMsgStatusCallback", 2, "addCallback processor is null " + paramLong);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgStatusCallback$IStatusErrorListener == null) {
          break label512;
        }
        this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgStatusCallback$IStatusErrorListener.a(paramLong);
        i = -1;
        if (QLog.isDevelopLevel())
        {
          localObject = new StringBuilder();
          StringBuilder localStringBuilder = ((StringBuilder)localObject).append("addCallback uniseq:").append(paramLong).append(" ,status:").append(i).append(" ,view:");
          if (paramView != null) {
            break label518;
          }
          paramQQAppInterface = "";
          label259:
          paramView = localStringBuilder.append(paramQQAppInterface).append(" ,callback:");
          if (paramCallback != null) {
            break label527;
          }
        }
      }
    }
    label512:
    label518:
    label527:
    for (paramQQAppInterface = "";; paramQQAppInterface = paramCallback.toString())
    {
      paramView.append(paramQQAppInterface);
      QLog.d("OrderMediaMsgStatusCallback", 2, ((StringBuilder)localObject).toString());
      return true;
      if ((paramQQAppInterface instanceof BaseTransProcessor))
      {
        paramQQAppInterface = (BaseTransProcessor)paramQQAppInterface;
        i = (int)paramQQAppInterface.getFileStatus();
        if (!a(paramLong, i))
        {
          this.jdField_a_of_type_JavaLangLong = ((Long)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.peek());
          if ((paramLong != 0L) && (this.jdField_a_of_type_JavaLangLong != null) && (paramLong != this.jdField_a_of_type_JavaLangLong.longValue()))
          {
            if (paramCallback != null)
            {
              paramCallback.a(paramView, paramQQAppInterface.getFileMsg(), i, paramQQAppInterface.errCode);
              localObject = (OrderMediaMsgStatusCallback.CallbackWrapper)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
              if (localObject != null) {
                ((OrderMediaMsgStatusCallback.CallbackWrapper)localObject).a(paramQQAppInterface.getFileMsg());
              }
            }
            if (QLog.isColorLevel())
            {
              paramQQAppInterface = new StringBuilder();
              paramQQAppInterface.append("Not the first! status:").append(i).append(" ,uniseq:").append(paramLong);
              QLog.d("OrderMediaMsgStatusCallback", 2, paramQQAppInterface.toString());
            }
          }
        }
        break;
        paramQQAppInterface = (OrderMediaMsgStatusCallback.CallbackWrapper)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
        paramQQAppInterface.a = new WeakReference(paramView);
        paramQQAppInterface.b = new WeakReference(paramCallback);
      }
      i = -1;
      break;
      paramQQAppInterface = paramView.toString();
      break label259;
    }
  }
  
  public void b(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.contains(Long.valueOf(paramLong)))
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.remove(Long.valueOf(paramLong));
      if (QLog.isColorLevel()) {
        QLog.d("OrderMediaMsgStatusCallback", 2, "removeUniseqFromOrderList " + paramLong);
      }
      c(paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgStatusCallback
 * JD-Core Version:    0.7.0.1
 */