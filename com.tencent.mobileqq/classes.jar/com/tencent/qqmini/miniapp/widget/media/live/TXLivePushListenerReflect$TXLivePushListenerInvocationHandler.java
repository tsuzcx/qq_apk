package com.tencent.qqmini.miniapp.widget.media.live;

import android.os.Bundle;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

class TXLivePushListenerReflect$TXLivePushListenerInvocationHandler
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
      if (((paramArrayOfObject[0] instanceof Integer)) && ((paramArrayOfObject[1] instanceof Bundle)))
      {
        if (QMLog.isColorLevel()) {
          QMLog.e("TXLivePushListenerRefle", "onPushEvent code:" + paramArrayOfObject[0]);
        }
        if (this.listener != null) {
          this.listener.onPushEvent(((Integer)paramArrayOfObject[0]).intValue(), (Bundle)paramArrayOfObject[1]);
        }
      }
      if ((paramArrayOfObject[1] instanceof Bundle))
      {
        paramArrayOfObject = (Bundle)paramArrayOfObject[1];
        if (QMLog.isColorLevel()) {
          QMLog.e("TXLivePushListenerRefle", "onPushEvent params:" + paramArrayOfObject.toString());
        }
      }
    }
  }
  
  private void liverPushOnNetStatus(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length == 1) && ((paramArrayOfObject[0] instanceof Bundle)))
    {
      paramArrayOfObject = (Bundle)paramArrayOfObject[0];
      if (QMLog.isColorLevel()) {
        QMLog.e("TXLivePushListenerRefle", "onNetStatus params:" + paramArrayOfObject.toString());
      }
      if (this.listener != null) {
        this.listener.onNetStatus(paramArrayOfObject);
      }
    }
  }
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    QMLog.e("TXLivePushListenerRefle", "TXLivePushListenerInvocationHandler invoke:" + paramMethod.getName());
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
    }
    for (;;)
    {
      return null;
      if ("onPushEvent".equals(paramMethod.getName())) {
        livePushOnPushEvent(paramArrayOfObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.media.live.TXLivePushListenerReflect.TXLivePushListenerInvocationHandler
 * JD-Core Version:    0.7.0.1
 */