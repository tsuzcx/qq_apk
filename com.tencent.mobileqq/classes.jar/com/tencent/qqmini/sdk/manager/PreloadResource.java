package com.tencent.qqmini.sdk.manager;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.Configuration;
import com.tencent.qqmini.sdk.launcher.Configuration.ProcessInfo;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.shell.ProcessType;
import com.tencent.qqmini.sdk.runtime.AppUIProxy.DebugLayout;
import com.tencent.qqmini.sdk.runtime.AppUIProxy.LoadingUI;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import java.util.Iterator;
import java.util.List;

public class PreloadResource
{
  private static final String TAG = "minisdk-start_PreloadResource";
  private static volatile PreloadResource instance;
  private static volatile byte[] lock = new byte[0];
  private AppUIProxy.DebugLayout mAppDebugLayout;
  private AppUIProxy.LoadingUI mAppLadingUI;
  
  public static PreloadResource g()
  {
    if (instance == null) {}
    synchronized (lock)
    {
      if (instance == null) {
        instance = new PreloadResource();
      }
      return instance;
    }
  }
  
  private String getCurrProcessName()
  {
    return AppLoaderFactory.g().getProcessName();
  }
  
  private void preloadUI(Context paramContext, Configuration paramConfiguration)
  {
    if (isMiniAppProcess(paramContext, paramConfiguration))
    {
      getAppLoadingUI(paramContext);
      getAppDebugUI(paramContext);
    }
  }
  
  public AppUIProxy.DebugLayout getAppDebugUI(Context paramContext)
  {
    if (this.mAppDebugLayout == null) {}
    try
    {
      if (this.mAppDebugLayout == null)
      {
        QMLog.w("minisdk-start_PreloadResource", "preload getAppDebugUI");
        this.mAppDebugLayout = new AppUIProxy.DebugLayout(paramContext);
        this.mAppDebugLayout.setBackgroundColor(-822083584);
        paramContext = new TextView(paramContext);
        paramContext.setTextColor(-1);
        paramContext.setTextSize(30.0F);
        paramContext.setText("调试断点中...");
        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
        localLayoutParams.gravity = 17;
        this.mAppDebugLayout.addView(paramContext, localLayoutParams);
        this.mAppDebugLayout.setVisibility(4);
      }
      return this.mAppDebugLayout;
    }
    finally {}
  }
  
  public AppUIProxy.LoadingUI getAppLoadingUI(Context paramContext)
  {
    if (this.mAppLadingUI == null) {}
    try
    {
      if (this.mAppLadingUI == null)
      {
        QMLog.w("minisdk-start_PreloadResource", "preload getAppLoadingUI");
        this.mAppLadingUI = new AppUIProxy.LoadingUI(paramContext);
      }
      return this.mAppLadingUI;
    }
    finally {}
  }
  
  public boolean isMiniAppProcess(Context paramContext, Configuration paramConfiguration)
  {
    if ((paramConfiguration == null) || (paramConfiguration.processInfoList == null)) {
      return false;
    }
    paramContext = getCurrProcessName();
    paramConfiguration = paramConfiguration.processInfoList.iterator();
    while (paramConfiguration.hasNext())
    {
      Configuration.ProcessInfo localProcessInfo = (Configuration.ProcessInfo)paramConfiguration.next();
      if ((localProcessInfo.processType == ProcessType.MINI_APP) && (!TextUtils.isEmpty(paramContext)) && (paramContext.equals(localProcessInfo.name))) {
        return true;
      }
    }
    return false;
  }
  
  public void preload(Context paramContext, Configuration paramConfiguration)
  {
    QMLog.w("minisdk-start_PreloadResource", "preload start");
    QMLog.w("minisdk-start_PreloadResource", "preload QUAUtil.getSimpleDeviceInfo");
    QUAUtil.getSimpleDeviceInfo(paramContext);
    QMLog.w("minisdk-start_PreloadResource", "preload QUAUtil.getSystemUA");
    QUAUtil.getSystemUA();
    preloadUI(paramContext, paramConfiguration);
    QMLog.w("minisdk-start_PreloadResource", "preload end");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.PreloadResource
 * JD-Core Version:    0.7.0.1
 */