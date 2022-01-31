package com.tencent.qqmini.proxyimpl;

import alud;
import android.app.Activity;
import bety;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqmini.sdk.core.model.InnerShareData;

class ShareProxyImpl$5
  implements Runnable
{
  ShareProxyImpl$5(ShareProxyImpl paramShareProxyImpl, Activity paramActivity, InnerShareData paramInnerShareData) {}
  
  public void run()
  {
    bety localbety = new bety(this.val$activity);
    localbety.a(alud.a(2131703126));
    localbety.show();
    ThreadManager.excute(new ShareProxyImpl.5.1(this, localbety), 128, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ShareProxyImpl.5
 * JD-Core Version:    0.7.0.1
 */