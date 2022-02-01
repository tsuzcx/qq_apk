package com.tencent.mobileqq.pluginsdk;

import android.app.Fragment;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.util.HashMap;

public abstract class PluginProxyFragmentActivity
  extends PluginProxyActivity
{
  private static final String TAG = "PluginProxyFragmentActivity";
  private static final HashMap<String, String> pluginInstalledPathMap = new HashMap();
  
  protected void attachBaseContext(Context paramContext)
  {
    for (;;)
    {
      try
      {
        long l = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("PluginProxyFragmentActivity", 2, "new PluginContext start");
        }
        String str = (String)pluginInstalledPathMap.get(getPluginID());
        if (TextUtils.isEmpty(str))
        {
          str = PluginUtils.getInstalledPluginPath(paramContext, getPluginID()).getAbsolutePath();
          pluginInstalledPathMap.put(getPluginID(), str);
          paramContext = new PluginContext(paramContext, getThemeResId(), str, PluginStatic.getOrCreateClassLoader(paramContext, getPluginID()), paramContext.getResources(), getPluginResType());
          if (QLog.isColorLevel()) {
            QLog.d("PluginProxyFragmentActivity", 2, new Object[] { "new PluginContext end ,cost:", Long.valueOf(System.currentTimeMillis() - l) });
          }
          super.attachBaseContext(paramContext);
          return;
        }
      }
      catch (Throwable paramContext)
      {
        QLog.e("PluginProxyFragmentActivity", 1, new Object[] { "attachBaseContext", QLog.getStackTraceString(paramContext) });
        return;
      }
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public Intent getIntent()
  {
    Intent localIntent = super.getIntent();
    localIntent.setExtrasClassLoader(getClassLoader());
    Bundle localBundle = localIntent.getBundleExtra("pluginsdk_inner_intent_extras");
    if (localBundle != null)
    {
      localIntent.removeExtra("pluginsdk_inner_intent_extras");
      localIntent.putExtras(localBundle);
    }
    setIntent(localIntent);
    return localIntent;
  }
  
  protected abstract int getPluginResType();
  
  protected abstract int getThemeResId();
  
  public void onAttachFragment(Fragment paramFragment)
  {
    super.onAttachFragment(paramFragment);
    if (this.mPluginActivity != null) {
      this.mPluginActivity.IOnAttachFragment(paramFragment);
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    if ((this.mPluginActivity != null) && ((this.mPluginActivity instanceof BasePluginActivity)) && (((BasePluginActivity)this.mPluginActivity).isSamePackage2(paramIntent))) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        paramIntent.putExtra("pluginsdk_IsPluginActivity", true);
      }
      super.startActivityForResult(paramIntent, paramInt);
      return;
    }
  }
  
  public void startActivityFromFragment(@NonNull Fragment paramFragment, Intent paramIntent, int paramInt)
  {
    startActivityFromFragment(paramFragment, paramIntent, paramInt, null);
  }
  
  public void startActivityFromFragment(@NonNull Fragment paramFragment, Intent paramIntent, int paramInt, @Nullable Bundle paramBundle)
  {
    int i;
    if ((this.mPluginActivity != null) && ((this.mPluginActivity instanceof BasePluginActivity)) && (((BasePluginActivity)this.mPluginActivity).isSamePackage2(paramIntent))) {
      i = 1;
    }
    while (i != 0)
    {
      String str = null;
      ComponentName localComponentName = paramIntent.getComponent();
      if (localComponentName != null) {
        str = localComponentName.getClassName();
      }
      paramIntent.putExtra("pluginsdk_IsPluginActivity", false);
      if ((str != null) && (str.length() > 0))
      {
        startPluginActivityFromFragment(paramFragment, str, paramIntent, paramInt, paramBundle);
        return;
        i = 0;
      }
      else
      {
        QLog.e("PluginProxyFragmentActivity", 1, "startActivityFromFragment activityName==null");
        return;
      }
    }
    super.startActivityFromFragment(paramFragment, paramIntent, paramInt, paramBundle);
  }
  
  public void startPluginActivityFromFragment(@NonNull Fragment paramFragment, String paramString, Intent paramIntent, int paramInt, @Nullable Bundle paramBundle)
  {
    Intent localIntent = new Intent(this, getProxyActivity(paramString));
    localIntent.putExtra("pluginsdk_pluginName", this.mPluginName);
    localIntent.putExtra("pluginsdk_pluginLocation", this.mPluginID);
    localIntent.putExtra("pluginsdk_pluginpath", this.mPluginApkFilePath);
    localIntent.putExtra("pluginsdk_launchActivity", paramString);
    localIntent.putExtra("useSkinEngine", this.mUseSkinEngine);
    if ((this.mPluginResoucesType == 1) || (this.mPluginResoucesType == -1) || (this.mPluginResoucesType == 2)) {
      localIntent.putExtra("userQqResources", this.mPluginResoucesType);
    }
    if (paramIntent != null)
    {
      localIntent.addFlags(paramIntent.getFlags());
      if (paramIntent.getExtras() != null) {
        localIntent.putExtra("pluginsdk_inner_intent_extras", new Bundle(paramIntent.getExtras()));
      }
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      super.startActivityFromFragment(paramFragment, localIntent, paramInt, paramBundle);
      return;
    }
    super.startActivityFromFragment(paramFragment, localIntent, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginProxyFragmentActivity
 * JD-Core Version:    0.7.0.1
 */