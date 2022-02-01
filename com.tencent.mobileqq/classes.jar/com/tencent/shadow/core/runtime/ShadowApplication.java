package com.tencent.shadow.core.runtime;

import android.annotation.TargetApi;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.Application.OnProvideAssistDataListener;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Configuration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class ShadowApplication
  extends ShadowContext
{
  public boolean isCallOnCreate;
  private Map<ShadowActivityLifecycleCallbacks, Application.ActivityLifecycleCallbacks> mActivityLifecycleCallbacksMap = new HashMap();
  private Map<String, List<String>> mBroadcasts;
  private Application mHostApplication;
  
  public void attachBaseContext(Context paramContext) {}
  
  public Context getApplicationContext()
  {
    return this;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void onCreate()
  {
    this.isCallOnCreate = true;
    Iterator localIterator = this.mBroadcasts.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      try
      {
        BroadcastReceiver localBroadcastReceiver = (BroadcastReceiver)this.mPluginClassLoader.loadClass((String)((Map.Entry)localObject).getKey()).newInstance();
        IntentFilter localIntentFilter = new IntentFilter();
        localObject = ((List)((Map.Entry)localObject).getValue()).iterator();
        while (((Iterator)localObject).hasNext()) {
          localIntentFilter.addAction((String)((Iterator)localObject).next());
        }
        this.mHostApplication.registerReceiver(localBroadcastReceiver, localIntentFilter);
      }
      catch (Exception localException)
      {
        throw new RuntimeException(localException);
      }
    }
    this.mHostApplication.registerComponentCallbacks(new ShadowApplication.1(this));
  }
  
  public void onLowMemory() {}
  
  public void onTerminate()
  {
    throw new UnsupportedOperationException();
  }
  
  public void onTrimMemory(int paramInt) {}
  
  public void registerActivityLifecycleCallbacks(ShadowActivityLifecycleCallbacks paramShadowActivityLifecycleCallbacks)
  {
    ShadowActivityLifecycleCallbacks.Wrapper localWrapper = new ShadowActivityLifecycleCallbacks.Wrapper(paramShadowActivityLifecycleCallbacks, this);
    this.mActivityLifecycleCallbacksMap.put(paramShadowActivityLifecycleCallbacks, localWrapper);
    this.mHostApplication.registerActivityLifecycleCallbacks(localWrapper);
  }
  
  public void registerComponentCallbacks(ComponentCallbacks paramComponentCallbacks)
  {
    this.mHostApplication.registerComponentCallbacks(paramComponentCallbacks);
  }
  
  @TargetApi(18)
  public void registerOnProvideAssistDataListener(Application.OnProvideAssistDataListener paramOnProvideAssistDataListener)
  {
    this.mHostApplication.registerOnProvideAssistDataListener(paramOnProvideAssistDataListener);
  }
  
  public void setBroadcasts(Map<String, List<String>> paramMap)
  {
    this.mBroadcasts = paramMap;
  }
  
  public void setHostApplicationContextAsBase(Context paramContext)
  {
    super.attachBaseContext(paramContext);
    this.mHostApplication = ((Application)paramContext);
  }
  
  public void unregisterActivityLifecycleCallbacks(ShadowActivityLifecycleCallbacks paramShadowActivityLifecycleCallbacks)
  {
    Application.ActivityLifecycleCallbacks localActivityLifecycleCallbacks = (Application.ActivityLifecycleCallbacks)this.mActivityLifecycleCallbacksMap.get(paramShadowActivityLifecycleCallbacks);
    if (localActivityLifecycleCallbacks != null)
    {
      this.mHostApplication.unregisterActivityLifecycleCallbacks(localActivityLifecycleCallbacks);
      this.mActivityLifecycleCallbacksMap.remove(paramShadowActivityLifecycleCallbacks);
    }
  }
  
  public void unregisterComponentCallbacks(ComponentCallbacks paramComponentCallbacks)
  {
    this.mHostApplication.unregisterComponentCallbacks(paramComponentCallbacks);
  }
  
  @TargetApi(18)
  public void unregisterOnProvideAssistDataListener(Application.OnProvideAssistDataListener paramOnProvideAssistDataListener)
  {
    this.mHostApplication.unregisterOnProvideAssistDataListener(paramOnProvideAssistDataListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.shadow.core.runtime.ShadowApplication
 * JD-Core Version:    0.7.0.1
 */