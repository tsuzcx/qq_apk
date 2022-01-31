package com.tencent.mobileqq.mini.widget.media.live;

import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

class TXLivePushListenerReflect$OnBGMNotifyInvocationHandler
  implements InvocationHandler
{
  private TXLivePushListenerReflect.OnBGMNotify listener;
  
  public TXLivePushListenerReflect$OnBGMNotifyInvocationHandler(TXLivePushListenerReflect.OnBGMNotify paramOnBGMNotify)
  {
    this.listener = paramOnBGMNotify;
  }
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    QLog.e("TXLivePushListenerRefle", 1, "OnBGMNotifyInvocationHandler invoke:" + paramMethod.getName());
    if (Object.class.equals(paramMethod.getDeclaringClass())) {
      try
      {
        paramObject = paramMethod.invoke(this, paramArrayOfObject);
        return paramObject;
      }
      catch (Throwable paramObject)
      {
        QLog.e("TXLivePushListenerRefle", 1, "invoke", paramObject);
      }
    }
    if ("onBGMStart".equals(paramMethod.getName())) {
      if (this.listener != null) {
        this.listener.onBGMStart();
      }
    }
    for (;;)
    {
      if (("onBGMComplete".equals(paramMethod.getName())) && (paramArrayOfObject != null) && (paramArrayOfObject.length == 1) && ((paramArrayOfObject[0] instanceof Integer)) && (this.listener != null)) {
        this.listener.onBGMComplete(((Integer)paramArrayOfObject[0]).intValue());
      }
      return null;
      if (("onBGMProgress".equals(paramMethod.getName())) && (paramArrayOfObject != null) && (paramArrayOfObject.length == 2) && ((paramArrayOfObject[0] instanceof Long)) && ((paramArrayOfObject[1] instanceof Long)) && (this.listener != null)) {
        this.listener.onBGMProgress(((Long)paramArrayOfObject[0]).longValue(), ((Long)paramArrayOfObject[1]).longValue());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.live.TXLivePushListenerReflect.OnBGMNotifyInvocationHandler
 * JD-Core Version:    0.7.0.1
 */