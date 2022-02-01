package com.tencent.qqmini.sdk.core;

import android.content.Context;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.manager.ObserverManager;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppFileManager;
import com.tencent.qqmini.sdk.report.MiniAppRealTimeLogReporter;
import java.util.Map;

public abstract class BaseRuntimeImpl
  extends BaseRuntime
{
  protected Context mContext;
  
  public BaseRuntimeImpl(Context paramContext)
  {
    this.mContext = paramContext;
    paramContext = new MiniAppFileManager();
    this.mManagerMap.put(MiniAppFileManager.class, paramContext);
    this.mManagerMap.put(IMiniAppFileManager.class, paramContext);
    paramContext = new BaseRuntimeImpl.BaselibProvider(this);
    this.mManagerMap.put(BaseRuntimeImpl.BaselibProvider.class, paramContext);
    paramContext = new MiniAppRealTimeLogReporter();
    this.mManagerMap.put(MiniAppRealTimeLogReporter.class, paramContext);
    paramContext = new ObserverManager();
    this.mManagerMap.put(ObserverManager.class, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.BaseRuntimeImpl
 * JD-Core Version:    0.7.0.1
 */