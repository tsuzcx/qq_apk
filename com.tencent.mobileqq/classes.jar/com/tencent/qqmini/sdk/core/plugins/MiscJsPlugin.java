package com.tencent.qqmini.sdk.core.plugins;

import bglv;
import bgok;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.AppMode;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.log.QMLog;

public class MiscJsPlugin
  extends BaseJsPlugin
{
  private static final String TAG = "MiscJsPlugin";
  
  public void saveAppToDesktop(bgok parambgok)
  {
    try
    {
      if (this.mMiniAppInfo.appMode.isLimitedAccess)
      {
        QMLog.e("MiscJsPlugin", "app is limited access");
        parambgok.b();
        return;
      }
      ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).addShortcut(this.mMiniAppContext.a(), this.mMiniAppInfo, new MiscJsPlugin.1(this, parambgok));
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("MiscJsPlugin", localException.getMessage(), localException);
      parambgok.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.MiscJsPlugin
 * JD-Core Version:    0.7.0.1
 */