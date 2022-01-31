package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import bbdj;
import bbgu;
import bcql;

class ShareProxyImpl$4$1
  implements Runnable
{
  ShareProxyImpl$4$1(ShareProxyImpl.4 param4, long paramLong, String paramString) {}
  
  public void run()
  {
    if ((this.val$finalErrCode == -100070004L) || (this.val$finalErrCode == -1000710003L))
    {
      bbdj.a(this.this$1.val$activity, 233, this.this$1.val$activity.getString(2131719491), this.val$finalErrMsg, new ShareProxyImpl.4.1.1(this), null).show();
      return;
    }
    bcql.a(this.this$1.val$activity, 1, 2131694283, 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ShareProxyImpl.4.1
 * JD-Core Version:    0.7.0.1
 */