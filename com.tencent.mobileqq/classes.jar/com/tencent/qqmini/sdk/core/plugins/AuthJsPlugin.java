package com.tencent.qqmini.sdk.core.plugins;

import bgjw;
import bgkd;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.model.AppConfigInfo;
import com.tencent.qqmini.sdk.log.QMLog;

public class AuthJsPlugin
  extends BaseJsPlugin
{
  private static final String TAG = "AuthJsPlugin";
  private ChannelProxy mChannelProxy;
  
  public void login(bgkd parambgkd)
  {
    QMLog.d("AuthJsPlugin", "call API_LOGIN callbackId:" + parambgkd.b + " PackageToolVersion:" + this.mApkgInfo.a.PackageToolVersion);
    this.mChannelProxy.login(this.mApkgInfo.appId, new AuthJsPlugin.1(this, parambgkd));
  }
  
  public void refreshSession(bgkd parambgkd)
  {
    this.mChannelProxy.checkSession(this.mApkgInfo.appId, new AuthJsPlugin.2(this, parambgkd));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.AuthJsPlugin
 * JD-Core Version:    0.7.0.1
 */