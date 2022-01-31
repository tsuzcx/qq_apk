package com.tencent.qqmini.sdk.core.proxy.service;

import android.app.Activity;
import android.app.ProgressDialog;
import besj;

class ShareProxyDefault$5
  implements Runnable
{
  ShareProxyDefault$5(ShareProxyDefault paramShareProxyDefault, Activity paramActivity, besj parambesj) {}
  
  public void run()
  {
    ProgressDialog localProgressDialog = new ProgressDialog(this.val$activity);
    localProgressDialog.setMessage("分享中，请稍候");
    localProgressDialog.show();
    ShareProxyDefault.access$100(this.this$0, this.val$shareData.b, new ShareProxyDefault.5.1(this, localProgressDialog));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.ShareProxyDefault.5
 * JD-Core Version:    0.7.0.1
 */