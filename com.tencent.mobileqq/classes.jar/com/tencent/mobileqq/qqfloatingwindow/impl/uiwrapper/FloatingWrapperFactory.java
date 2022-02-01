package com.tencent.mobileqq.qqfloatingwindow.impl.uiwrapper;

import android.content.Context;
import com.tencent.mobileqq.qqfloatingwindow.FloatingBaseProxyWrapper;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class FloatingWrapperFactory
{
  private Map<String, FloatingBaseProxyWrapper> a = new HashMap();
  
  public FloatingBaseProxyWrapper a(Context paramContext, String paramString)
  {
    FloatingBaseProxyWrapper localFloatingBaseProxyWrapper = (FloatingBaseProxyWrapper)this.a.get(paramString);
    Object localObject = localFloatingBaseProxyWrapper;
    if (localFloatingBaseProxyWrapper == null)
    {
      localObject = localFloatingBaseProxyWrapper;
      if (paramContext != null)
      {
        try
        {
          localObject = Class.forName(paramString).getDeclaredConstructor(new Class[] { Context.class });
          ((Constructor)localObject).setAccessible(true);
          paramContext = (FloatingBaseProxyWrapper)((Constructor)localObject).newInstance(new Object[] { paramContext });
          try
          {
            this.a.put(paramString, paramContext);
            return paramContext;
          }
          catch (Exception paramString) {}
          QLog.e("FloatingScreenManager", 1, paramString, new Object[0]);
        }
        catch (Exception paramString)
        {
          paramContext = localFloatingBaseProxyWrapper;
        }
        localObject = paramContext;
      }
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqfloatingwindow.impl.uiwrapper.FloatingWrapperFactory
 * JD-Core Version:    0.7.0.1
 */