package com.tencent.qqmini.sdk.core.plugins;

import bdfx;
import bdfz;
import bdml;
import bdnw;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;

public class AuthJsPlugin
  extends BaseJsPlugin
{
  private static final String TAG = "AuthJsPlugin";
  private ChannelProxy mChannelProxy;
  
  public void login(bdfz parambdfz)
  {
    bdnw.a("AuthJsPlugin", "call API_LOGIN callbackId:" + parambdfz.b + " PackageToolVersion:" + this.mApkgInfo.a.b);
    this.mChannelProxy.login(this.mApkgInfo.d, new AuthJsPlugin.1(this, parambdfz));
  }
  
  public void refreshSession(bdfz parambdfz)
  {
    this.mChannelProxy.checkSession(this.mApkgInfo.d, new AuthJsPlugin.2(this, parambdfz));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.AuthJsPlugin
 * JD-Core Version:    0.7.0.1
 */