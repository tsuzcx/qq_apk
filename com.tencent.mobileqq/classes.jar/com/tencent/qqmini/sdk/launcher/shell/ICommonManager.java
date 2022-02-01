package com.tencent.qqmini.sdk.launcher.shell;

import com.tencent.qqmini.sdk.launcher.action.EngineChannel;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public abstract interface ICommonManager
{
  public abstract void addActivityResultListener(IActivityResultListener paramIActivityResultListener);
  
  public abstract void fetchPeriodicCacheIfNeed(MiniAppInfo paramMiniAppInfo);
  
  public abstract EngineChannel getChannelForType(int paramInt);
  
  @Deprecated
  public abstract BaseRuntime getCurrentRuntime();
  
  public abstract String getTissueSoPath();
  
  public abstract void removeActivityResultListener(IActivityResultListener paramIActivityResultListener);
  
  public abstract void setTissueSoPath(String paramString);
  
  public abstract boolean verifyTissueEngine(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.shell.ICommonManager
 * JD-Core Version:    0.7.0.1
 */