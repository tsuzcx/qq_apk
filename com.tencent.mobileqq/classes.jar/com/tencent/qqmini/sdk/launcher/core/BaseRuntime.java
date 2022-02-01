package com.tencent.qqmini.sdk.launcher.core;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.core.action.GetScreenshot.Callback;
import com.tencent.qqmini.sdk.launcher.core.plugins.engine.IJsPluginEngine;
import com.tencent.qqmini.sdk.launcher.core.utils.ICaptureImageCallback;
import com.tencent.qqmini.sdk.launcher.model.AdReportData;
import com.tencent.qqmini.sdk.launcher.model.EntryModel;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.ShareState;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class BaseRuntime
  implements IMiniAppContext, IRuntime
{
  public static final int LOADING_AD_DISABLE = 0;
  public static final int LOADING_AD_DONE = 3;
  public static final int LOADING_AD_SELECTING = 1;
  public static final int LOADING_AD_SHOWING = 2;
  protected long lastStayTime;
  protected IRuntimeLifecycleListener mLifecycleListener;
  private int mLoadingAdStatus = 0;
  protected Map<Class, Object> mManagerMap = new HashMap();
  protected BaseRuntime.RuntimeMsgObserver mRuntimeObserver;
  protected long onResumeTime;
  protected long startTime;
  
  private String getSceneSn(MiniAppInfo paramMiniAppInfo)
  {
    try
    {
      if (paramMiniAppInfo.launchParam.entryModel != null) {
        return String.valueOf(paramMiniAppInfo.launchParam.entryModel.uin);
      }
      paramMiniAppInfo = paramMiniAppInfo.launchParam.fromMiniAppId;
      return paramMiniAppInfo;
    }
    catch (Exception paramMiniAppInfo)
    {
      label34:
      break label34;
    }
    return "";
  }
  
  public boolean canLaunchApp()
  {
    return false;
  }
  
  public void captureImage(ICaptureImageCallback paramICaptureImageCallback) {}
  
  public AdReportData getAdReportData()
  {
    long l1 = System.currentTimeMillis();
    AdReportData localAdReportData = new AdReportData();
    long l2 = this.onResumeTime;
    localAdReportData.lastOnResumeTime = l2;
    localAdReportData.stayTime = (this.lastStayTime + (l1 - l2));
    localAdReportData.startTime = this.startTime;
    localAdReportData.baseLibVersion = getBaseLibVersion();
    MiniAppInfo localMiniAppInfo = getMiniAppInfo();
    if ((localMiniAppInfo != null) && (localMiniAppInfo.launchParam != null))
    {
      localAdReportData.scene = localMiniAppInfo.launchParam.scene;
      localAdReportData.scene_sn = getSceneSn(localMiniAppInfo);
    }
    return localAdReportData;
  }
  
  public long getCurrentDrawCount()
  {
    return 0L;
  }
  
  public abstract IJsPluginEngine getJsPluginEngine();
  
  public abstract IJsService getJsService();
  
  public int getLaunchAppScene()
  {
    return 0;
  }
  
  public <T> T getManager(Class<T> paramClass)
  {
    if (paramClass == null) {
      return null;
    }
    if (this.mManagerMap.containsKey(paramClass)) {
      return this.mManagerMap.get(paramClass);
    }
    Iterator localIterator = this.mManagerMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Class localClass = (Class)localIterator.next();
      if ((localClass != null) && (localClass.getName().equals(paramClass.getName()))) {
        return this.mManagerMap.get(localClass);
      }
    }
    return null;
  }
  
  public abstract IPage getPage();
  
  public void getScreenshot(GetScreenshot.Callback paramCallback) {}
  
  public abstract ShareState getShareState();
  
  public void handleFocusGain() {}
  
  public void handleFocusLoss() {}
  
  public abstract boolean isForground();
  
  public boolean isLoadingAdShowing()
  {
    return this.mLoadingAdStatus == 2;
  }
  
  public abstract void loadMiniApp(MiniAppInfo paramMiniAppInfo);
  
  public void notifyRuntimeMsgObserver(int paramInt, Object paramObject)
  {
    BaseRuntime.RuntimeMsgObserver localRuntimeMsgObserver = this.mRuntimeObserver;
    if (localRuntimeMsgObserver != null) {
      localRuntimeMsgObserver.onRuntimeMessage(paramInt, paramObject);
    }
  }
  
  public abstract void onLoadMiniAppInfo(MiniAppInfo paramMiniAppInfo, boolean paramBoolean, String paramString);
  
  public abstract void onRuntimeAttachActivity(Activity paramActivity, ViewGroup paramViewGroup);
  
  public abstract void onRuntimeCreate();
  
  public abstract void onRuntimeDetachActivity(Activity paramActivity);
  
  public abstract void onRuntimePause();
  
  public abstract void onRuntimeResume();
  
  public abstract void onRuntimeStart();
  
  public abstract void onRuntimeStop();
  
  public void onUpdateMiniAppInfo(MiniAppInfo paramMiniAppInfo) {}
  
  public Object performAction(Action paramAction)
  {
    if (paramAction != null) {
      return paramAction.perform(this);
    }
    return null;
  }
  
  public void setLoadingAdStatus(int paramInt)
  {
    this.mLoadingAdStatus = paramInt;
  }
  
  public void setRuntimeLifecycleListener(IRuntimeLifecycleListener paramIRuntimeLifecycleListener)
  {
    this.mLifecycleListener = paramIRuntimeLifecycleListener;
  }
  
  public void setRuntimeMsgObserver(BaseRuntime.RuntimeMsgObserver paramRuntimeMsgObserver)
  {
    this.mRuntimeObserver = paramRuntimeMsgObserver;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.BaseRuntime
 * JD-Core Version:    0.7.0.1
 */