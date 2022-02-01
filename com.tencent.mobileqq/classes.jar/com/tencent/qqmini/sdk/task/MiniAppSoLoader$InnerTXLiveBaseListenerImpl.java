package com.tencent.qqmini.sdk.task;

import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MiniAppSoLoader$InnerTXLiveBaseListenerImpl
  implements InvocationHandler
{
  public MiniAppSoLoader$InnerTXLiveBaseListenerImpl(MiniAppSoLoader paramMiniAppSoLoader) {}
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    if (Object.class.equals(paramMethod.getDeclaringClass()))
    {
      paramObject = new StringBuilder();
      paramObject.append("InnerTXLiveBaseListenerImpl invoke:");
      paramObject.append(paramMethod.getName());
      QMLog.e("MiniAppSoLoader", paramObject.toString());
      try
      {
        paramObject = paramMethod.invoke(this, paramArrayOfObject);
        return paramObject;
      }
      catch (Throwable paramObject)
      {
        paramObject.printStackTrace();
      }
    }
    else if ("OnLog".equals(paramMethod.getName()))
    {
      MiniAppSoLoader.access$100(this.a, paramArrayOfObject);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.task.MiniAppSoLoader.InnerTXLiveBaseListenerImpl
 * JD-Core Version:    0.7.0.1
 */