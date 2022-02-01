package com.tencent.qqmini.proxyimpl;

import com.tencent.mobileqq.mini.share.MiniProgramShareUtils.OnShareListener;
import com.tencent.qqmini.sdk.launcher.model.InnerShareData;

class ShareProxyImpl$1
  implements MiniProgramShareUtils.OnShareListener
{
  ShareProxyImpl$1(ShareProxyImpl paramShareProxyImpl, InnerShareData paramInnerShareData) {}
  
  public void onShared(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      InnerShareData localInnerShareData = this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelInnerShareData;
      localInnerShareData.notifyShareResult(localInnerShareData.fromActivity, paramBoolean2 ^ true, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ShareProxyImpl.1
 * JD-Core Version:    0.7.0.1
 */