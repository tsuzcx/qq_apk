package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.AppConfigInfo;

@JsPlugin
public class AuthJsPlugin
  extends BaseJsPlugin
{
  private static final String TAG = "AuthJsPlugin";
  private ChannelProxy mChannelProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
  
  @JsEvent({"login"})
  public void login(RequestEvent paramRequestEvent)
  {
    QMLog.d("AuthJsPlugin", "call API_LOGIN callbackId:" + paramRequestEvent.callbackId + " PackageToolVersion:" + this.mApkgInfo.mAppConfigInfo.packageToolVersion);
    this.mChannelProxy.login(this.mApkgInfo.appId, new AuthJsPlugin.1(this, paramRequestEvent));
  }
  
  @JsEvent({"refreshSession"})
  public void refreshSession(RequestEvent paramRequestEvent)
  {
    this.mChannelProxy.checkSession(this.mApkgInfo.appId, new AuthJsPlugin.2(this, paramRequestEvent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.AuthJsPlugin
 * JD-Core Version:    0.7.0.1
 */