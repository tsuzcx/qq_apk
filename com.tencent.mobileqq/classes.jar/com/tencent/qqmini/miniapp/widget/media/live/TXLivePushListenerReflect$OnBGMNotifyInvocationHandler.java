package com.tencent.qqmini.miniapp.widget.media.live;

import com.tencent.qqmini.sdk.launcher.log.QMLog;
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
    QMLog.e("TXLivePushListenerRefle", "OnBGMNotifyInvocationHandler invoke:" + paramMethod.getName());
    if (Object.class.equals(paramMethod.getDeclaringClass())) {
      try
      {
        paramObject = paramMethod.invoke(this, paramArrayOfObject);
        return paramObject;
      }
      catch (Throwable paramObject)
      {
        QMLog.e("TXLivePushListenerRefle", "invoke", paramObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.media.live.TXLivePushListenerReflect.OnBGMNotifyInvocationHandler
 * JD-Core Version:    0.7.0.1
 */