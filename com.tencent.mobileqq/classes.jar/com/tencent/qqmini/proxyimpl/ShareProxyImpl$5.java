package com.tencent.qqmini.proxyimpl;

import ajyc;
import android.app.Activity;
import bcpq;
import bers;
import com.tencent.mobileqq.app.ThreadManager;

class ShareProxyImpl$5
  implements Runnable
{
  ShareProxyImpl$5(ShareProxyImpl paramShareProxyImpl, Activity paramActivity, bers parambers) {}
  
  public void run()
  {
    bcpq localbcpq = new bcpq(this.val$activity);
    localbcpq.a(ajyc.a(2131702731));
    localbcpq.show();
    ThreadManager.excute(new ShareProxyImpl.5.1(this, localbcpq), 128, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ShareProxyImpl.5
 * JD-Core Version:    0.7.0.1
 */