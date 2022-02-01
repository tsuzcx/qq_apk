package com.vivo.push.util;

import android.content.Context;
import java.lang.reflect.Method;

public class ContextDelegate
{
  private static final String TAG = "ContextDelegate";
  private static Context mContext;
  private static ContextDelegate mContextDelegate;
  private static Method mCreateCredentialProtectedStorageContext;
  private static Method mCreateDeviceProtectedStorageContext;
  private static boolean mDelegateEnable = false;
  private static Boolean mIsFbeProject;
  
  private static Context createCredentialProtectedStorageContext(Context paramContext)
  {
    try
    {
      if (mCreateCredentialProtectedStorageContext == null) {
        mCreateCredentialProtectedStorageContext = Context.class.getMethod("createCredentialProtectedStorageContext", new Class[0]);
      }
      Context localContext = (Context)mCreateCredentialProtectedStorageContext.invoke(paramContext, new Object[0]);
      return localContext;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return paramContext;
  }
  
  private static Context createDeviceProtectedStorageContext(Context paramContext)
  {
    try
    {
      if (mCreateDeviceProtectedStorageContext == null) {
        mCreateDeviceProtectedStorageContext = Context.class.getMethod("createDeviceProtectedStorageContext", new Class[0]);
      }
      Context localContext = (Context)mCreateDeviceProtectedStorageContext.invoke(paramContext, new Object[0]);
      return localContext;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return paramContext;
  }
  
  public static Context getContext(Context paramContext)
  {
    Context localContext = paramContext;
    if (isFBEProject())
    {
      if (paramContext == null) {
        return paramContext;
      }
      localContext = mContext;
      if (localContext != null) {
        return localContext;
      }
      setContext(paramContext);
      localContext = mContext;
    }
    return localContext;
  }
  
  public static ContextDelegate getInstance()
  {
    return ContextDelegate.a.a();
  }
  
  public static boolean isFBEProject()
  {
    if (mIsFbeProject == null) {}
    for (;;)
    {
      try
      {
        if (!"file".equals(j.a("ro.crypto.type", "unknow"))) {
          break label112;
        }
        bool = true;
        mIsFbeProject = Boolean.valueOf(bool);
        StringBuilder localStringBuilder1 = new StringBuilder("mIsFbeProject = ");
        localStringBuilder1.append(mIsFbeProject.toString());
        o.b("ContextDelegate", localStringBuilder1.toString());
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder2 = new StringBuilder("mIsFbeProject = ");
        localStringBuilder2.append(localException.getMessage());
        o.a("ContextDelegate", localStringBuilder2.toString());
      }
      Boolean localBoolean = mIsFbeProject;
      if (localBoolean == null) {
        return false;
      }
      return localBoolean.booleanValue();
      label112:
      boolean bool = false;
    }
  }
  
  private static void setAppContext()
  {
    Context localContext = mContext;
    if (localContext == null) {
      return;
    }
    setContext(localContext);
  }
  
  private static void setContext(Context paramContext)
  {
    if (!mDelegateEnable)
    {
      mContext = createCredentialProtectedStorageContext(paramContext);
      return;
    }
    mContext = createDeviceProtectedStorageContext(paramContext);
  }
  
  public static void setEnable(boolean paramBoolean)
  {
    mDelegateEnable = paramBoolean;
    setAppContext();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.util.ContextDelegate
 * JD-Core Version:    0.7.0.1
 */