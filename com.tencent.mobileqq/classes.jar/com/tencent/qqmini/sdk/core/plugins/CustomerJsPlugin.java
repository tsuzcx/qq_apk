package com.tencent.qqmini.sdk.core.plugins;

import bekp;
import bekr;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;

public class CustomerJsPlugin
  extends BaseJsPlugin
{
  private static final String TAG = "CustomerJsPlugin";
  private ChannelProxy mChannelProxy;
  
  public void openCustomerServiceConversation(bekr parambekr)
  {
    this.mChannelProxy.getRobotUin(this.mApkgInfo.d, new CustomerJsPlugin.1(this, parambekr));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.CustomerJsPlugin
 * JD-Core Version:    0.7.0.1
 */