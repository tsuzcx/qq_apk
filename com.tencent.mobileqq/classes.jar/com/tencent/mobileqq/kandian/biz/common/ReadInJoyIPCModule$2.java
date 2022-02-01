package com.tencent.mobileqq.kandian.biz.common;

import android.os.Bundle;
import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.mobileqq.qroute.QRoute;
import eipc.EIPCResult;

class ReadInJoyIPCModule$2
  implements IReadInJoyUserInfoModule.RefreshUserInfoCallBack
{
  ReadInJoyIPCModule$2(ReadInJoyIPCModule paramReadInJoyIPCModule, int paramInt) {}
  
  public void onLoadUserInfoFailed(String paramString1, String paramString2)
  {
    paramString1 = new Bundle();
    paramString1.putString("action_get_user_info", ((IPublicAccountH5AbilityPlugin)QRoute.api(IPublicAccountH5AbilityPlugin.class)).getUserInfoFailStr(paramString2));
    paramString1 = EIPCResult.createResult(0, paramString1);
    this.b.callbackResult(this.a, paramString1);
  }
  
  public void onLoadUserInfoSucceed(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    paramString = new Bundle();
    paramString.putString("action_get_user_info", ReadInJoyLegacyUtils.a(paramReadInJoyUserInfo));
    paramString = EIPCResult.createResult(0, paramString);
    this.b.callbackResult(this.a, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.ReadInJoyIPCModule.2
 * JD-Core Version:    0.7.0.1
 */