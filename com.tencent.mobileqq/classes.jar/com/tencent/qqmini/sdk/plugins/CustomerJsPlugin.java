package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;

@JsPlugin
public class CustomerJsPlugin
  extends BaseJsPlugin
{
  private static final String TAG = "CustomerJsPlugin";
  private ChannelProxy mChannelProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
  
  @JsEvent({"enterContact", "openCustomerServiceConversation"})
  public void openCustomerServiceConversation(RequestEvent paramRequestEvent)
  {
    this.mChannelProxy.getRobotUin(this.mApkgInfo.appId, new CustomerJsPlugin.1(this, paramRequestEvent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.CustomerJsPlugin
 * JD-Core Version:    0.7.0.1
 */