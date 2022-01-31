package com.tencent.qqmini.sdk.core.plugins;

import bgod;
import bgok;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.model.AppConfigInfo;
import com.tencent.qqmini.sdk.log.QMLog;

public class AuthJsPlugin
  extends BaseJsPlugin
{
  private static final String TAG = "AuthJsPlugin";
  private ChannelProxy mChannelProxy;
  
  public void login(bgok parambgok)
  {
    QMLog.d("AuthJsPlugin", "call API_LOGIN callbackId:" + parambgok.b + " PackageToolVersion:" + this.mApkgInfo.a.PackageToolVersion);
    this.mChannelProxy.login(this.mApkgInfo.appId, new AuthJsPlugin.1(this, parambgok));
  }
  
  public void refreshSession(bgok parambgok)
  {
    this.mChannelProxy.checkSession(this.mApkgInfo.appId, new AuthJsPlugin.2(this, parambgok));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.AuthJsPlugin
 * JD-Core Version:    0.7.0.1
 */