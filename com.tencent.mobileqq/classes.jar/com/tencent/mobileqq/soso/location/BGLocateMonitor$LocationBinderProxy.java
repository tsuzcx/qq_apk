package com.tencent.mobileqq.soso.location;

import android.os.IBinder;
import android.os.IInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class BGLocateMonitor$LocationBinderProxy
  implements InvocationHandler
{
  IBinder mBase;
  Class<?> mInterface;
  Class<?> mStub;
  
  BGLocateMonitor$LocationBinderProxy(IBinder paramIBinder)
  {
    this.mBase = paramIBinder;
    try
    {
      this.mStub = Class.forName("android.location.ILocationManager$Stub");
      this.mInterface = Class.forName("android.location.ILocationManager");
      return;
    }
    catch (Exception paramIBinder)
    {
      QLog.d("BGLocateMonitor", 1, "LocationBinderProxy init", paramIBinder);
    }
  }
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    if ("queryLocalInterface".equals(paramMethod.getName()))
    {
      paramObject = paramObject.getClass().getClassLoader();
      paramMethod = this.mInterface;
      paramArrayOfObject = new BGLocateMonitor.ILocationManagerProxy(this.mBase, this.mStub);
      return Proxy.newProxyInstance(paramObject, new Class[] { IBinder.class, IInterface.class, paramMethod }, paramArrayOfObject);
    }
    return paramMethod.invoke(this.mBase, paramArrayOfObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.soso.location.BGLocateMonitor.LocationBinderProxy
 * JD-Core Version:    0.7.0.1
 */