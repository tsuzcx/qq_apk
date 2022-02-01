package com.tencent.shadow.core.runtime.qcircle.reflect;

import android.app.Activity;
import java.lang.reflect.Method;
import java.util.HashMap;

public abstract class DtBaseReflect
{
  protected HashMap<String, Method> mMethodMap = new HashMap();
  private Object mObject;
  
  protected boolean getInstance(Activity paramActivity, String paramString1, String paramString2)
  {
    paramActivity = loadClass(paramActivity, paramString1);
    if (paramActivity == null) {
      return false;
    }
    try
    {
      this.mObject = paramActivity.getMethod(paramString2, new Class[0]).invoke(null, new Object[0]);
      return true;
    }
    catch (Exception paramActivity)
    {
      paramActivity.printStackTrace();
    }
    return false;
  }
  
  protected Object getObject(Activity paramActivity)
  {
    if (this.mObject == null) {
      initObject(paramActivity);
    }
    return this.mObject;
  }
  
  protected abstract void initObject(Activity paramActivity);
  
  protected Class<?> loadClass(Activity paramActivity, String paramString)
  {
    if (paramActivity == null) {
      return null;
    }
    paramActivity = paramActivity.getClassLoader();
    if (paramActivity == null) {
      return null;
    }
    paramActivity = paramActivity.getParent();
    if (paramActivity == null) {
      return null;
    }
    try
    {
      paramActivity = paramActivity.loadClass(paramString);
      return paramActivity;
    }
    catch (ClassNotFoundException paramActivity)
    {
      paramActivity.printStackTrace();
    }
    return null;
  }
  
  protected boolean newInstance(Activity paramActivity, String paramString)
  {
    paramActivity = loadClass(paramActivity, paramString);
    if (paramActivity == null) {
      return false;
    }
    try
    {
      this.mObject = paramActivity.newInstance();
      return true;
    }
    catch (Exception paramActivity)
    {
      paramActivity.printStackTrace();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.shadow.core.runtime.qcircle.reflect.DtBaseReflect
 * JD-Core Version:    0.7.0.1
 */