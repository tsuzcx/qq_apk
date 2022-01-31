package com.tencent.qqmini.sdk.core.plugins;

import bejy;
import beka;
import bequ;
import besl;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;

public class AuthJsPlugin
  extends BaseJsPlugin
{
  private static final String TAG = "AuthJsPlugin";
  private ChannelProxy mChannelProxy;
  
  public void login(beka parambeka)
  {
    besl.a("AuthJsPlugin", "call API_LOGIN callbackId:" + parambeka.b + " PackageToolVersion:" + this.mApkgInfo.a.b);
    this.mChannelProxy.login(this.mApkgInfo.d, new AuthJsPlugin.1(this, parambeka));
  }
  
  public void refreshSession(beka parambeka)
  {
    this.mChannelProxy.checkSession(this.mApkgInfo.d, new AuthJsPlugin.2(this, parambeka));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.AuthJsPlugin
 * JD-Core Version:    0.7.0.1
 */