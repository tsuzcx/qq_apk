package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import com.tencent.mobileqq.mini.share.MiniProgramShareUtils.OnShareListener;
import com.tencent.qqmini.sdk.core.model.InnerShareData;

class ShareProxyImpl$1
  implements MiniProgramShareUtils.OnShareListener
{
  ShareProxyImpl$1(ShareProxyImpl paramShareProxyImpl, InnerShareData paramInnerShareData) {}
  
  public void onShared(boolean paramBoolean1, boolean paramBoolean2)
  {
    InnerShareData localInnerShareData;
    Activity localActivity;
    if (paramBoolean1)
    {
      localInnerShareData = this.val$shareData;
      localActivity = this.val$shareData.a;
      if (!paramBoolean2) {
        break label35;
      }
    }
    label35:
    for (int i = 0;; i = 1)
    {
      localInnerShareData.notifyShareResult(localActivity, i, true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ShareProxyImpl.1
 * JD-Core Version:    0.7.0.1
 */