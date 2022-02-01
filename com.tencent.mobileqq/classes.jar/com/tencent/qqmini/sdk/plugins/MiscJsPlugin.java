package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.AppMode;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

@JsPlugin
public class MiscJsPlugin
  extends BaseJsPlugin
{
  private static final String TAG = "MiscJsPlugin";
  
  @JsEvent({"saveAppToDesktop"})
  public void saveAppToDesktop(RequestEvent paramRequestEvent)
  {
    try
    {
      if (this.mMiniAppInfo.appMode.isLimitedAccess)
      {
        QMLog.e("MiscJsPlugin", "app is limited access");
        paramRequestEvent.fail();
        return;
      }
      ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).addShortcut(this.mMiniAppContext.getAttachedActivity(), this.mMiniAppInfo, new MiscJsPlugin.1(this, paramRequestEvent));
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("MiscJsPlugin", localException.getMessage(), localException);
      paramRequestEvent.fail();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.MiscJsPlugin
 * JD-Core Version:    0.7.0.1
 */