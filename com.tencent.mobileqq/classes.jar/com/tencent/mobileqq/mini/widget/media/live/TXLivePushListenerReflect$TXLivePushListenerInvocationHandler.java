package com.tencent.mobileqq.mini.widget.media.live;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
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
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    QLog.e("TXLivePushListenerRefle", 1, "TXLivePushListenerInvocationHandler invoke:" + paramMethod.getName());
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
    if ("onNetStatus".equals(paramMethod.getName())) {
      if ((paramArrayOfObject != null) && (paramArrayOfObject.length == 1) && ((paramArrayOfObject[0] instanceof Bundle)))
      {
        paramObject = (Bundle)paramArrayOfObject[0];
        if (QLog.isColorLevel()) {
          QLog.e("TXLivePushListenerRefle", 1, "onNetStatus params:" + paramObject.toString());
        }
        if (this.listener != null) {
          this.listener.onNetStatus(paramObject);
        }
      }
    }
    for (;;)
    {
      return null;
      if (("onPushEvent".equals(paramMethod.getName())) && (paramArrayOfObject != null) && (paramArrayOfObject.length == 2))
      {
        if (((paramArrayOfObject[0] instanceof Integer)) && ((paramArrayOfObject[1] instanceof Bundle)))
        {
          if (QLog.isColorLevel()) {
            QLog.e("TXLivePushListenerRefle", 1, "onPushEvent code:" + paramArrayOfObject[0]);
          }
          if (this.listener != null) {
            this.listener.onPushEvent(((Integer)paramArrayOfObject[0]).intValue(), (Bundle)paramArrayOfObject[1]);
          }
        }
        if ((paramArrayOfObject[1] instanceof Bundle))
        {
          paramObject = (Bundle)paramArrayOfObject[1];
          if (QLog.isColorLevel()) {
            QLog.e("TXLivePushListenerRefle", 1, "onPushEvent params:" + paramObject.toString());
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.live.TXLivePushListenerReflect.TXLivePushListenerInvocationHandler
 * JD-Core Version:    0.7.0.1
 */