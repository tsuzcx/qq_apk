package com.tencent.qqmini.sdk.core.plugins;

import bgod;
import bgok;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;

public class CustomerJsPlugin
  extends BaseJsPlugin
{
  private static final String TAG = "CustomerJsPlugin";
  private ChannelProxy mChannelProxy;
  
  public void openCustomerServiceConversation(bgok parambgok)
  {
    this.mChannelProxy.getRobotUin(this.mApkgInfo.appId, new CustomerJsPlugin.1(this, parambgok));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.CustomerJsPlugin
 * JD-Core Version:    0.7.0.1
 */