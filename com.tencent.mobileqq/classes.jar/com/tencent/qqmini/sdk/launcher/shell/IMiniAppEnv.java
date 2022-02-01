package com.tencent.qqmini.sdk.launcher.shell;

import android.content.Context;
import android.content.Intent;
import com.tencent.qqmini.sdk.launcher.Configuration;
import com.tencent.qqmini.sdk.launcher.IUIProxy;
import com.tencent.qqmini.sdk.launcher.ipc.IMiniServiceManager;
import com.tencent.qqmini.sdk.launcher.model.LoginInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public abstract interface IMiniAppEnv
{
  public abstract IActivityResultManager getActivityResultManager();
  
  public abstract BaselibLoader getBaselibLoader();
  
  public abstract LoginInfo getLoginInfo();
  
  public abstract String getMenuStyle();
  
  public abstract IMiniServiceManager getMiniServiceManager();
  
  public abstract IReceiverProxy getReceiverProxy();
  
  public abstract IShareManager getShareManager();
  
  public abstract IUIProxy getUIProxy(MiniAppInfo paramMiniAppInfo);
  
  public abstract void init(Context paramContext, Configuration paramConfiguration);
  
  public abstract void setupWithIntent(Intent paramIntent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv
 * JD-Core Version:    0.7.0.1
 */