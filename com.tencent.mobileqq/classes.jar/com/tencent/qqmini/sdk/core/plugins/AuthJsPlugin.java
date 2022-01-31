package com.tencent.qqmini.sdk.core.plugins;

import bekp;
import bekr;
import berl;
import betc;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;

public class AuthJsPlugin
  extends BaseJsPlugin
{
  private static final String TAG = "AuthJsPlugin";
  private ChannelProxy mChannelProxy;
  
  public void login(bekr parambekr)
  {
    betc.a("AuthJsPlugin", "call API_LOGIN callbackId:" + parambekr.b + " PackageToolVersion:" + this.mApkgInfo.a.b);
    this.mChannelProxy.login(this.mApkgInfo.d, new AuthJsPlugin.1(this, parambekr));
  }
  
  public void refreshSession(bekr parambekr)
  {
    this.mChannelProxy.checkSession(this.mApkgInfo.d, new AuthJsPlugin.2(this, parambekr));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.AuthJsPlugin
 * JD-Core Version:    0.7.0.1
 */