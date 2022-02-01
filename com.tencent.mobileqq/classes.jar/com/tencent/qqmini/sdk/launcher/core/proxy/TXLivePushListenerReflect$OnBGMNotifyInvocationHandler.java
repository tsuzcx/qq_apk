package com.tencent.qqmini.sdk.launcher.core.proxy;

import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TXLivePushListenerReflect$OnBGMNotifyInvocationHandler
  implements InvocationHandler
{
  private TXLivePushListenerReflect.OnBGMNotify listener;
  
  public TXLivePushListenerReflect$OnBGMNotifyInvocationHandler(TXLivePushListenerReflect.OnBGMNotify paramOnBGMNotify)
  {
    this.listener = paramOnBGMNotify;
  }
  
  private void onBGMComplete(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length == 1) && ((paramArrayOfObject[0] instanceof Integer)))
    {
      TXLivePushListenerReflect.OnBGMNotify localOnBGMNotify = this.listener;
      if (localOnBGMNotify != null) {
        localOnBGMNotify.onBGMComplete(((Integer)paramArrayOfObject[0]).intValue());
      }
    }
  }
  
  private void onBGMProgress(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length == 2) && ((paramArrayOfObject[0] instanceof Long)) && ((paramArrayOfObject[1] instanceof Long)))
    {
      TXLivePushListenerReflect.OnBGMNotify localOnBGMNotify = this.listener;
      if (localOnBGMNotify != null) {
        localOnBGMNotify.onBGMProgress(((Long)paramArrayOfObject[0]).longValue(), ((Long)paramArrayOfObject[1]).longValue());
      }
    }
  }
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    paramObject = new StringBuilder();
    paramObject.append("OnBGMNotifyInvocationHandler invoke:");
    paramObject.append(paramMethod.getName());
    QMLog.e("TXLivePushListenerRefle", paramObject.toString());
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
    if ("onBGMStart".equals(paramMethod.getName()))
    {
      paramObject = this.listener;
      if (paramObject != null) {
        paramObject.onBGMStart();
      }
    }
    else if ("onBGMProgress".equals(paramMethod.getName()))
    {
      onBGMProgress(paramArrayOfObject);
    }
    if ("onBGMComplete".equals(paramMethod.getName())) {
      onBGMComplete(paramArrayOfObject);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.proxy.TXLivePushListenerReflect.OnBGMNotifyInvocationHandler
 * JD-Core Version:    0.7.0.1
 */