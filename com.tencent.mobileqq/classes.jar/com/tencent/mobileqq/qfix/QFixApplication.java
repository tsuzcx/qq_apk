package com.tencent.mobileqq.qfix;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import dalvik.system.PathClassLoader;

public abstract class QFixApplication
  extends Application
{
  public ApplicationDelegate applicationLike;
  public String mApplicationDelegateName;
  
  public QFixApplication(String paramString)
  {
    this.mApplicationDelegateName = paramString;
  }
  
  protected void attachBaseContext(Context paramContext)
  {
    super.attachBaseContext(paramContext);
    ClassLoader localClassLoader2 = super.getClassLoader();
    Object localObject = localClassLoader2;
    ClassLoader localClassLoader1;
    if (Build.VERSION.SDK_INT >= 24)
    {
      localObject = localClassLoader2;
      if (isAndroidNPatchEnable()) {
        try
        {
          localObject = AndroidNClassLoader.inject((PathClassLoader)super.getClassLoader(), this);
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
          localClassLoader1 = super.getClassLoader();
        }
      }
    }
    try
    {
      this.applicationLike = ((ApplicationDelegate)localClassLoader1.loadClass(this.mApplicationDelegateName).newInstance());
    }
    catch (Exception localException2)
    {
      localException2.printStackTrace();
    }
    this.applicationLike.proxyAttachBaseContext(paramContext, this);
  }
  
  public boolean isAndroidNPatchEnable()
  {
    return false;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    ApplicationDelegate localApplicationDelegate = this.applicationLike;
    if (localApplicationDelegate != null) {
      localApplicationDelegate.onConfigurationChanged(paramConfiguration);
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.applicationLike.onCreate();
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    ApplicationDelegate localApplicationDelegate = this.applicationLike;
    if (localApplicationDelegate != null) {
      localApplicationDelegate.onLowMemory();
    }
  }
  
  public void onTerminate()
  {
    super.onTerminate();
    ApplicationDelegate localApplicationDelegate = this.applicationLike;
    if (localApplicationDelegate != null) {
      localApplicationDelegate.onTerminate();
    }
  }
  
  public void onTrimMemory(int paramInt)
  {
    super.onTrimMemory(paramInt);
    ApplicationDelegate localApplicationDelegate = this.applicationLike;
    if (localApplicationDelegate != null) {
      localApplicationDelegate.onTrimMemory(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qfix.QFixApplication
 * JD-Core Version:    0.7.0.1
 */