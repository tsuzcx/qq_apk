package com.tencent.mobileqq.qqfloatingwindow.impl.uiwrapper;

import android.content.Context;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class FloatingWrapperFactory
{
  private Map<String, FloatingBaseWrapper> a = new HashMap();
  
  public FloatingBaseWrapper a(Context paramContext, String paramString)
  {
    FloatingBaseWrapper localFloatingBaseWrapper = (FloatingBaseWrapper)this.a.get(paramString);
    Object localObject = localFloatingBaseWrapper;
    if (localFloatingBaseWrapper == null)
    {
      localObject = localFloatingBaseWrapper;
      if (paramContext != null) {
        localObject = localFloatingBaseWrapper;
      }
    }
    try
    {
      Constructor localConstructor = Class.forName(paramString).getDeclaredConstructor(new Class[] { Context.class });
      localObject = localFloatingBaseWrapper;
      localConstructor.setAccessible(true);
      localObject = localFloatingBaseWrapper;
      paramContext = (FloatingBaseWrapper)localConstructor.newInstance(new Object[] { paramContext });
      localObject = paramContext;
      this.a.put(paramString, paramContext);
      localObject = paramContext;
      return localObject;
    }
    catch (Exception paramContext)
    {
      QLog.e("FloatingScreenManager", 1, paramContext, new Object[0]);
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qqfloatingwindow.impl.uiwrapper.FloatingWrapperFactory
 * JD-Core Version:    0.7.0.1
 */