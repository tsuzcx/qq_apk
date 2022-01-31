package com.tencent.qqmini.proxyimpl;

import alpo;
import android.app.Activity;
import bepp;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqmini.sdk.core.model.InnerShareData;

class ShareProxyImpl$5
  implements Runnable
{
  ShareProxyImpl$5(ShareProxyImpl paramShareProxyImpl, Activity paramActivity, InnerShareData paramInnerShareData) {}
  
  public void run()
  {
    bepp localbepp = new bepp(this.val$activity);
    localbepp.a(alpo.a(2131703114));
    localbepp.show();
    ThreadManager.excute(new ShareProxyImpl.5.1(this, localbepp), 128, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ShareProxyImpl.5
 * JD-Core Version:    0.7.0.1
 */