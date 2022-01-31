package com.tencent.qqmini.proxyimpl;

import ajjy;
import android.app.Activity;
import bbms;
import bdng;
import com.tencent.mobileqq.app.ThreadManager;

class ShareProxyImpl$5
  implements Runnable
{
  ShareProxyImpl$5(ShareProxyImpl paramShareProxyImpl, Activity paramActivity, bdng parambdng) {}
  
  public void run()
  {
    bbms localbbms = new bbms(this.val$activity);
    localbbms.a(ajjy.a(2131636947));
    localbbms.show();
    ThreadManager.excute(new ShareProxyImpl.5.1(this, localbbms), 128, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ShareProxyImpl.5
 * JD-Core Version:    0.7.0.1
 */