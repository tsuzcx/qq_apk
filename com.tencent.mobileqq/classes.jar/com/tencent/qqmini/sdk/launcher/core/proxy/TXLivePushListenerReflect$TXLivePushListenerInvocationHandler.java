package com.tencent.qqmini.sdk.launcher.core.proxy;

import android.os.Bundle;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TXLivePushListenerReflect$TXLivePushListenerInvocationHandler
  implements InvocationHandler
{
  private TXLivePushListenerReflect.ITXLivePushListener listener;
  
  public TXLivePushListenerReflect$TXLivePushListenerInvocationHandler(TXLivePushListenerReflect.ITXLivePushListener paramITXLivePushListener)
  {
    this.listener = paramITXLivePushListener;
  }
  
  private void livePushOnPushEvent(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length == 2))
    {
      Object localObject;
      if (((paramArrayOfObject[0] instanceof Integer)) && ((paramArrayOfObject[1] instanceof Bundle)))
      {
        if (QMLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onPushEvent code:");
          ((StringBuilder)localObject).append(paramArrayOfObject[0]);
          QMLog.e("TXLivePushListenerRefle", ((StringBuilder)localObject).toString());
        }
        localObject = this.listener;
        if (localObject != null) {
          ((TXLivePushListenerReflect.ITXLivePushListener)localObject).onPushEvent(((Integer)paramArrayOfObject[0]).intValue(), (Bundle)paramArrayOfObject[1]);
        }
      }
      if ((paramArrayOfObject[1] instanceof Bundle))
      {
        paramArrayOfObject = (Bundle)paramArrayOfObject[1];
        if (QMLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onPushEvent params:");
          ((StringBuilder)localObject).append(paramArrayOfObject.toString());
          QMLog.e("TXLivePushListenerRefle", ((StringBuilder)localObject).toString());
        }
      }
    }
  }
  
  private void liverPushOnNetStatus(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length == 1) && ((paramArrayOfObject[0] instanceof Bundle)))
    {
      paramArrayOfObject = (Bundle)paramArrayOfObject[0];
      if (QMLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onNetStatus params:");
        ((StringBuilder)localObject).append(paramArrayOfObject.toString());
        QMLog.e("TXLivePushListenerRefle", ((StringBuilder)localObject).toString());
      }
      Object localObject = this.listener;
      if (localObject != null) {
        ((TXLivePushListenerReflect.ITXLivePushListener)localObject).onNetStatus(paramArrayOfObject);
      }
    }
  }
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    paramObject = new StringBuilder();
    paramObject.append("TXLivePushListenerInvocationHandler invoke:");
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
    if ("onNetStatus".equals(paramMethod.getName())) {
      liverPushOnNetStatus(paramArrayOfObject);
    } else if ("onPushEvent".equals(paramMethod.getName())) {
      livePushOnPushEvent(paramArrayOfObject);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.proxy.TXLivePushListenerReflect.TXLivePushListenerInvocationHandler
 * JD-Core Version:    0.7.0.1
 */