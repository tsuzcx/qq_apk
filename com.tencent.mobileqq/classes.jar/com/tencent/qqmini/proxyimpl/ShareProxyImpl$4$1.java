package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import bdcd;
import bdfq;
import com.tencent.mobileqq.widget.QQToast;

class ShareProxyImpl$4$1
  implements Runnable
{
  ShareProxyImpl$4$1(ShareProxyImpl.4 param4, long paramLong, String paramString) {}
  
  public void run()
  {
    if ((this.val$finalErrCode == -100070004L) || (this.val$finalErrCode == -1000710003L))
    {
      bdcd.a(this.this$1.val$activity, 233, this.this$1.val$activity.getString(2131720023), this.val$finalErrMsg, new ShareProxyImpl.4.1.1(this), null).show();
      return;
    }
    QQToast.a(this.this$1.val$activity, 1, 2131694432, 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ShareProxyImpl.4.1
 * JD-Core Version:    0.7.0.1
 */