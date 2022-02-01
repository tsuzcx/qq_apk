package com.tencent.mobileqq.kandian.glue.viola.utils;

import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;

final class ViolaBizUtils$1
  implements IReadInJoyUserInfoModule.RefreshUserInfoCallBack
{
  ViolaBizUtils$1(BridgeModule paramBridgeModule, String paramString) {}
  
  public void onLoadUserInfoFailed(String paramString1, String paramString2)
  {
    this.a.invokeErrorCallJS(this.b, paramString2);
  }
  
  public void onLoadUserInfoSucceed(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    ViolaBizUtils.a(this.a, paramReadInJoyUserInfo, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.utils.ViolaBizUtils.1
 * JD-Core Version:    0.7.0.1
 */