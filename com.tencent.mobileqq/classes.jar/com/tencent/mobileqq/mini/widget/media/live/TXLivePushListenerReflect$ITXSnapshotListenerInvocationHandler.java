package com.tencent.mobileqq.mini.widget.media.live;

import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

class TXLivePushListenerReflect$ITXSnapshotListenerInvocationHandler
  implements InvocationHandler
{
  private TXLivePushListenerReflect.ITXSnapshotListener listener;
  
  public TXLivePushListenerReflect$ITXSnapshotListenerInvocationHandler(TXLivePushListenerReflect.ITXSnapshotListener paramITXSnapshotListener)
  {
    this.listener = paramITXSnapshotListener;
  }
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    QLog.e("TXLivePushListenerRefle", 1, "ITXSnapshotListenerInvocationHandler invoke:" + paramMethod.getName());
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
    if (("onSnapshot".equals(paramMethod.getName())) && (paramArrayOfObject != null) && (paramArrayOfObject.length == 1) && ((paramArrayOfObject[0] instanceof Bitmap)) && (this.listener != null)) {
      this.listener.onSnapshot((Bitmap)paramArrayOfObject[0]);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.live.TXLivePushListenerReflect.ITXSnapshotListenerInvocationHandler
 * JD-Core Version:    0.7.0.1
 */