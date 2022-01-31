package com.tencent.qqmini.proxyimpl;

import ajya;
import android.app.Activity;
import bcqf;
import besj;
import com.tencent.mobileqq.app.ThreadManager;

class ShareProxyImpl$5
  implements Runnable
{
  ShareProxyImpl$5(ShareProxyImpl paramShareProxyImpl, Activity paramActivity, besj parambesj) {}
  
  public void run()
  {
    bcqf localbcqf = new bcqf(this.val$activity);
    localbcqf.a(ajya.a(2131702742));
    localbcqf.show();
    ThreadManager.excute(new ShareProxyImpl.5.1(this, localbcqf), 128, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ShareProxyImpl.5
 * JD-Core Version:    0.7.0.1
 */