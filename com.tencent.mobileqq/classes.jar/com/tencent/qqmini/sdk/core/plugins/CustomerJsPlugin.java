package com.tencent.qqmini.sdk.core.plugins;

import bgjw;
import bgkd;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;

public class CustomerJsPlugin
  extends BaseJsPlugin
{
  private static final String TAG = "CustomerJsPlugin";
  private ChannelProxy mChannelProxy;
  
  public void openCustomerServiceConversation(bgkd parambgkd)
  {
    this.mChannelProxy.getRobotUin(this.mApkgInfo.appId, new CustomerJsPlugin.1(this, parambgkd));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.CustomerJsPlugin
 * JD-Core Version:    0.7.0.1
 */