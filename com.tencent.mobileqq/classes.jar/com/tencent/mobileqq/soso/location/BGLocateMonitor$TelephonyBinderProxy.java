package com.tencent.mobileqq.soso.location;

import android.os.IBinder;
import android.os.IInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class BGLocateMonitor$TelephonyBinderProxy
  implements InvocationHandler
{
  IBinder mBase;
  Class<?> mInterface;
  Class<?> mStub;
  
  BGLocateMonitor$TelephonyBinderProxy(IBinder paramIBinder)
  {
    this.mBase = paramIBinder;
    try
    {
      this.mStub = Class.forName("com.android.internal.telephony.ITelephony$Stub");
      this.mInterface = Class.forName("com.android.internal.telephony.ITelephony");
      return;
    }
    catch (Exception paramIBinder)
    {
      QLog.d("BGLocateMonitor", 1, "TelephonyBinderProxy init", paramIBinder);
    }
  }
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    if ("queryLocalInterface".equals(paramMethod.getName()))
    {
      paramObject = paramObject.getClass().getClassLoader();
      paramMethod = this.mInterface;
      paramArrayOfObject = new BGLocateMonitor.ITelephonyManagerProxy(this.mBase, this.mStub);
      return Proxy.newProxyInstance(paramObject, new Class[] { IBinder.class, IInterface.class, paramMethod }, paramArrayOfObject);
    }
    return paramMethod.invoke(this.mBase, paramArrayOfObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.soso.location.BGLocateMonitor.TelephonyBinderProxy
 * JD-Core Version:    0.7.0.1
 */