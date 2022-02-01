package com.tencent.shadow.core.runtime.skin.loader;

import android.app.Application;
import android.content.Context;
import java.lang.reflect.Method;

public class ContextHolder
{
  private static Context sApplicationContext;
  
  public static Context getContext()
  {
    Object localObject = sApplicationContext;
    if (localObject == null) {
      try
      {
        localObject = (Application)Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, (Object[])null);
        if (localObject != null)
        {
          sApplicationContext = (Context)localObject;
          return localObject;
        }
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        try
        {
          Application localApplication = (Application)Class.forName("android.app.AppGlobals").getMethod("getInitialApplication", new Class[0]).invoke(null, (Object[])null);
          if (localApplication != null)
          {
            sApplicationContext = localApplication;
            return localApplication;
          }
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
        }
        throw new IllegalStateException("ContextHolder is not initialed, it is recommend to init with application context.");
      }
    }
    return localException2;
  }
  
  public static void setContext(Context paramContext)
  {
    sApplicationContext = paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.shadow.core.runtime.skin.loader.ContextHolder
 * JD-Core Version:    0.7.0.1
 */