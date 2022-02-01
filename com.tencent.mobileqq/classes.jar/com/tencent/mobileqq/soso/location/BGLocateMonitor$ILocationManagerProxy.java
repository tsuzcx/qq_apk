package com.tencent.mobileqq.soso.location;

import android.os.IBinder;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

class BGLocateMonitor$ILocationManagerProxy
  implements InvocationHandler
{
  Object mBase;
  
  BGLocateMonitor$ILocationManagerProxy(IBinder paramIBinder, Class<?> paramClass)
  {
    try
    {
      this.mBase = paramClass.getDeclaredMethod("asInterface", new Class[] { IBinder.class }).invoke(null, new Object[] { paramIBinder });
      return;
    }
    catch (Exception paramIBinder)
    {
      QLog.d("BGLocateMonitor", 1, "FixBinder init", paramIBinder);
    }
  }
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    if (BGLocateMonitor.access$100(paramMethod.getName(), BGLocateMonitor.access$000())) {
      BGLocateMonitor.access$200(paramMethod.getName());
    }
    return paramMethod.invoke(this.mBase, paramArrayOfObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.soso.location.BGLocateMonitor.ILocationManagerProxy
 * JD-Core Version:    0.7.0.1
 */