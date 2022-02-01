package com.tencent.mobileqq.mini.apkg;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletApi;

class ApkgConfigHolder$1
  implements Runnable
{
  ApkgConfigHolder$1(ApkgConfigHolder paramApkgConfigHolder) {}
  
  public void run()
  {
    synchronized (ApkgConfigHolder.access$000(this.this$0))
    {
      ((IQWalletApi)QRoute.api(IQWalletApi.class)).saveObject(this.this$0, ApkgConfigHolder.access$100(this.this$0));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.ApkgConfigHolder.1
 * JD-Core Version:    0.7.0.1
 */