package com.tencent.mobileqq.mini.app;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.mini.MiniAppInterface;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.sdk.BaseLibInfo;

public abstract interface BaseAppLoaderManager
{
  public abstract void addListener(Handler paramHandler);
  
  public abstract BaseLibInfo getBaseLibInfo();
  
  public abstract String getBasePageFrameStr();
  
  public abstract Context getContext();
  
  public abstract MiniAppInterface getMiniAppInterface();
  
  public abstract String getMiniAppWebviewStr();
  
  public abstract boolean hasPreload();
  
  public abstract void loadApkgByConfig(MiniAppConfig paramMiniAppConfig);
  
  public abstract void notifyMessage(Message paramMessage);
  
  public abstract void onBaseLibUpdateResult(int paramInt);
  
  public abstract void onBaselibUpdated(Context paramContext, MiniAppConfig paramMiniAppConfig);
  
  public abstract void preloadNextRuntime();
  
  public abstract void removeListner(Handler paramHandler);
  
  public abstract void setMiniAppInterface(MiniAppInterface paramMiniAppInterface);
  
  public abstract void start(Context paramContext);
  
  public abstract String waConsoleJsStr();
  
  public abstract String waRemoteDebugJsStr();
  
  public abstract String waServiceJsStr();
  
  public abstract String waWebviewJsStr();
  
  public abstract String waWorkerStr();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.app.BaseAppLoaderManager
 * JD-Core Version:    0.7.0.1
 */