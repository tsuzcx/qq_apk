package com.tencent.qqmini.sdk.launcher.core.proxy;

import android.graphics.Bitmap;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TXLivePushListenerReflect$ITXSnapshotListenerInvocationHandler
  implements InvocationHandler
{
  private TXLivePushListenerReflect.ITXSnapshotListener listener;
  
  public TXLivePushListenerReflect$ITXSnapshotListenerInvocationHandler(TXLivePushListenerReflect.ITXSnapshotListener paramITXSnapshotListener)
  {
    this.listener = paramITXSnapshotListener;
  }
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    paramObject = new StringBuilder();
    paramObject.append("ITXSnapshotListenerInvocationHandler invoke:");
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
    if (("onSnapshot".equals(paramMethod.getName())) && (paramArrayOfObject != null) && (paramArrayOfObject.length == 1) && ((paramArrayOfObject[0] instanceof Bitmap)))
    {
      paramObject = this.listener;
      if (paramObject != null) {
        paramObject.onSnapshot((Bitmap)paramArrayOfObject[0]);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.proxy.TXLivePushListenerReflect.ITXSnapshotListenerInvocationHandler
 * JD-Core Version:    0.7.0.1
 */