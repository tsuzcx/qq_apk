package com.tencent.mobileqq.pluginsdk;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabContentFactory;
import android.widget.TabHost.TabSpec;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class PluginTab
  extends PluginActivity
  implements TabHost.OnTabChangeListener, TabHost.TabContentFactory
{
  private TabHost.OnTabChangeListener mOnTabChangeListener;
  private PluginTabHost mPluginTabHost;
  private String mPreTag;
  
  protected final void addTabSpec(TabHost.TabSpec paramTabSpec, String paramString, Intent paramIntent)
  {
    if (this.mPluginTabHost == null) {
      return;
    }
    if (DebugHelper.sDebug)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PluginTab addTabSpec:");
      localStringBuilder.append(paramTabSpec.getTag());
      localStringBuilder.append(", ");
      localStringBuilder.append(paramString);
      DebugHelper.log("plugin_tag", localStringBuilder.toString());
    }
    paramTabSpec.setContent(this);
    this.mPluginTabHost.addPluginInfo(paramTabSpec.getTag(), paramString, paramIntent);
    this.mPluginTabHost.addTab(paramTabSpec);
  }
  
  public View createTabContent(String paramString)
  {
    if (DebugHelper.sDebug)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("PluginTab createTabContent:");
      ((StringBuilder)localObject1).append(paramString);
      DebugHelper.log("plugin_tag", ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = this.mPluginTabHost.getPluginInfo(paramString);
    paramString = null;
    Object localObject1 = null;
    if (localObject2 != null)
    {
      paramString = (String)localObject1;
      try
      {
        ClassLoader localClassLoader = getBaseContext().getClassLoader();
        paramString = (String)localObject1;
        IPluginActivity localIPluginActivity = (IPluginActivity)localClassLoader.loadClass(((PluginTabHost.TabSpecPluginInfo)localObject2).mActivityName).newInstance();
        paramString = (String)localObject1;
        if (DebugHelper.sDebug)
        {
          paramString = (String)localObject1;
          StringBuilder localStringBuilder = new StringBuilder();
          paramString = (String)localObject1;
          localStringBuilder.append("PluginTab Activity:");
          paramString = (String)localObject1;
          localStringBuilder.append(localIPluginActivity);
          paramString = (String)localObject1;
          DebugHelper.log("plugin_tag", localStringBuilder.toString());
        }
        paramString = (String)localObject1;
        localIPluginActivity.IInit(this.mPluginID, this.mApkFilePath, this, localClassLoader, this.mPackageInfo, this.mUseSkinEngine, this.mPluginResourcesType);
        paramString = (String)localObject1;
        localIPluginActivity.ISetIsTab();
        paramString = (String)localObject1;
        localIPluginActivity.ISetParent(this);
        paramString = (String)localObject1;
        localIPluginActivity.ISetIntent(((PluginTabHost.TabSpecPluginInfo)localObject2).mIntent);
        paramString = (String)localObject1;
        localIPluginActivity.IOnSetTheme();
        paramString = (String)localObject1;
        localIPluginActivity.IOnCreate(null);
        paramString = (String)localObject1;
        localObject1 = localIPluginActivity.IGetContentView();
        paramString = (String)localObject1;
        ((PluginTabHost.TabSpecPluginInfo)localObject2).mActivity = localIPluginActivity;
        return localObject1;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.mPluginID);
        ((StringBuilder)localObject2).append(" createTabContent fail");
        QLog.e("plugin_tag", 1, ((StringBuilder)localObject2).toString(), localException);
        PluginRuntime.handleCrash(localException, this.mPluginID, this);
      }
    }
    return paramString;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected IPluginActivity getActivityByTag(String paramString)
  {
    if (paramString != null)
    {
      PluginTabHost localPluginTabHost = this.mPluginTabHost;
      if (localPluginTabHost != null)
      {
        paramString = localPluginTabHost.getPluginInfo(paramString);
        if (paramString != null) {
          return paramString.mActivity;
        }
      }
    }
    return null;
  }
  
  protected IPluginActivity getCurrentActivity()
  {
    PluginTabHost localPluginTabHost = this.mPluginTabHost;
    if (localPluginTabHost == null) {
      return null;
    }
    return getActivityByTag(localPluginTabHost.getCurrentTabTag());
  }
  
  public PluginTabHost getTabHost()
  {
    return this.mPluginTabHost;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    IPluginActivity localIPluginActivity = getCurrentActivity();
    if (localIPluginActivity != null) {
      localIPluginActivity.IOnActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    int j = this.mPluginTabHost.getTabCount();
    int i = 0;
    while (i < j)
    {
      Object localObject = this.mPluginTabHost.getTabAt(i);
      if (localObject != null)
      {
        localObject = this.mPluginTabHost.getPluginInfo(((TabHost.TabSpec)localObject).getTag());
        if (localObject != null) {
          localObject = ((PluginTabHost.TabSpecPluginInfo)localObject).mActivity;
        }
      }
      i += 1;
    }
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.mPluginTabHost;
    if (localObject == null) {
      return;
    }
    int j = ((PluginTabHost)localObject).getTabCount();
    int i = 0;
    while (i < j)
    {
      localObject = this.mPluginTabHost.getTabAt(i);
      if (localObject != null)
      {
        localObject = this.mPluginTabHost.getPluginInfo(((TabHost.TabSpec)localObject).getTag());
        if ((localObject != null) && (((PluginTabHost.TabSpecPluginInfo)localObject).mActivity != null)) {
          ((PluginTabHost.TabSpecPluginInfo)localObject).mActivity.IOnDestroy();
        }
      }
      i += 1;
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    IPluginActivity localIPluginActivity = getCurrentActivity();
    if (localIPluginActivity != null) {
      localIPluginActivity.IOnPause();
    }
  }
  
  protected void onRestart()
  {
    super.onRestart();
    IPluginActivity localIPluginActivity = getCurrentActivity();
    if (localIPluginActivity != null) {
      localIPluginActivity.IOnRestart();
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    IPluginActivity localIPluginActivity = getCurrentActivity();
    if (localIPluginActivity != null) {
      localIPluginActivity.IOnResume();
    }
  }
  
  protected void onStart()
  {
    super.onStart();
    IPluginActivity localIPluginActivity = getCurrentActivity();
    if (localIPluginActivity != null) {
      localIPluginActivity.IOnStart();
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    IPluginActivity localIPluginActivity = getCurrentActivity();
    if (localIPluginActivity != null) {
      localIPluginActivity.IOnStop();
    }
  }
  
  public void onTabChanged(String paramString)
  {
    if (DebugHelper.sDebug)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("PluginTab onTabChanged:");
      ((StringBuilder)localObject).append(paramString);
      DebugHelper.log("plugin_tag", ((StringBuilder)localObject).toString());
    }
    Object localObject = getActivityByTag(this.mPreTag);
    if (localObject != null) {
      ((IPluginActivity)localObject).IOnPause();
    }
    this.mPreTag = paramString;
    localObject = getCurrentActivity();
    if (localObject != null) {
      ((IPluginActivity)localObject).IOnResume();
    }
    localObject = this.mOnTabChangeListener;
    if (localObject != null) {
      ((TabHost.OnTabChangeListener)localObject).onTabChanged(paramString);
    }
  }
  
  public void setOnTabChangedListener(TabHost.OnTabChangeListener paramOnTabChangeListener)
  {
    this.mOnTabChangeListener = paramOnTabChangeListener;
  }
  
  protected final void setPluginTabHost(PluginTabHost paramPluginTabHost)
  {
    if (DebugHelper.sDebug)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PluginTab setPluginTabHost:");
      localStringBuilder.append(paramPluginTabHost);
      DebugHelper.log("plugin_tag", localStringBuilder.toString());
    }
    this.mPluginTabHost = paramPluginTabHost;
    this.mPluginTabHost.setup();
    this.mPluginTabHost.setOnTabChangedListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginTab
 * JD-Core Version:    0.7.0.1
 */