package com.tencent.mobileqq.richmedia.ordersend;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class OrderMediaMsgTimerController
  implements Handler.Callback
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), null);
  private OrderMediaMsgTimerController.IMsgTimeoutListener jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgTimerController$IMsgTimeoutListener;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private HashMap<Long, Runnable> jdField_a_of_type_JavaUtilHashMap;
  private Handler jdField_b_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  private Runnable jdField_b_of_type_JavaLangRunnable;
  
  public OrderMediaMsgTimerController(OrderMediaMsgTimerController.IMsgTimeoutListener paramIMsgTimeoutListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgTimerController$IMsgTimeoutListener = paramIMsgTimeoutListener;
  }
  
  public Runnable a(long paramLong)
  {
    OrderMediaMsgTimerController.1 local1 = new OrderMediaMsgTimerController.1(this, paramLong);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(local1, 8000L);
    return local1;
  }
  
  public Runnable a(String paramString)
  {
    paramString = new OrderMediaMsgTimerController.2(this, paramString);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(paramString, 8000L);
    return paramString;
  }
  
  public void a()
  {
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null)
    {
      localHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_JavaLangRunnable = null;
    }
  }
  
  public void a(long paramLong)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilHashMap;
    if ((localObject != null) && (((HashMap)localObject).containsKey(Long.valueOf(paramLong))))
    {
      localObject = this.jdField_a_of_type_AndroidOsHandler;
      if (localObject != null) {
        ((Handler)localObject).removeCallbacks((Runnable)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong)));
      }
      this.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(paramLong));
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramLong))) {
      return;
    }
    OrderMediaMsgTimerController.4 local4 = new OrderMediaMsgTimerController.4(this, paramLong, paramInt1, paramInt2);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(local4, 30000L);
    this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong), local4);
  }
  
  public void a(Runnable paramRunnable)
  {
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null) {
      localHandler.removeCallbacks(paramRunnable);
    }
  }
  
  public boolean a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      return false;
    }
    this.jdField_a_of_type_JavaLangRunnable = new OrderMediaMsgTimerController.3(this, paramLong);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 30000L);
    return true;
  }
  
  public void b()
  {
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null)
    {
      localHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_b_of_type_JavaLangRunnable = null;
    }
  }
  
  public boolean b(long paramLong)
  {
    if (this.jdField_b_of_type_JavaLangRunnable != null) {
      return false;
    }
    this.jdField_b_of_type_JavaLangRunnable = new OrderMediaMsgTimerController.5(this, paramLong);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 30000L);
    return true;
  }
  
  public void c()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilHashMap;
    if (localObject != null)
    {
      localObject = ((HashMap)localObject).values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Runnable localRunnable = (Runnable)((Iterator)localObject).next();
        Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
        if (localHandler != null) {
          localHandler.removeCallbacks(localRunnable);
        }
      }
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      this.jdField_a_of_type_JavaUtilHashMap = null;
    }
    localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null)
    {
      ((Handler)localObject).removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    localObject = this.jdField_b_of_type_AndroidOsHandler;
    if (localObject != null)
    {
      ((Handler)localObject).removeCallbacksAndMessages(null);
      this.jdField_b_of_type_AndroidOsHandler = null;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    long l = 0L;
    OrderMediaMsgTimerController.IMsgTimeoutListener localIMsgTimeoutListener;
    switch (i)
    {
    default: 
      break;
    case 103: 
      if (paramMessage.obj != null) {
        l = ((Long)paramMessage.obj).longValue();
      }
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgTimerController$IMsgTimeoutListener;
      if (paramMessage != null) {
        paramMessage.b(l);
      }
      break;
    case 102: 
      if (paramMessage.obj != null) {
        l = ((Long)paramMessage.obj).longValue();
      }
      localIMsgTimeoutListener = this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgTimerController$IMsgTimeoutListener;
      if (localIMsgTimeoutListener != null) {
        localIMsgTimeoutListener.a(l, paramMessage.arg1, paramMessage.arg2);
      }
      break;
    case 101: 
      if (paramMessage.obj != null) {
        l = ((Long)paramMessage.obj).longValue();
      }
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgTimerController$IMsgTimeoutListener;
      if (paramMessage != null) {
        paramMessage.a(l);
      }
      break;
    case 100: 
      if (paramMessage.obj != null)
      {
        localIMsgTimeoutListener = this.jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgTimerController$IMsgTimeoutListener;
        if (localIMsgTimeoutListener != null) {
          localIMsgTimeoutListener.a(paramMessage.obj);
        }
      }
      break;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgTimerController
 * JD-Core Version:    0.7.0.1
 */