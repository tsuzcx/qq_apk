package com.tencent.qqmini.sdk.core.proxy.service;

import beld;
import bene;
import benn;

class ShareProxyDefault$4$2
  implements Runnable
{
  ShareProxyDefault$4$2(ShareProxyDefault.4 param4, long paramLong, String paramString) {}
  
  public void run()
  {
    if ((this.val$finalErrCode == -100070004L) || (this.val$finalErrCode == -1000710003L))
    {
      beld.a(this.this$1.val$activity, 230, "分享失败", this.val$finalErrMsg, new ShareProxyDefault.4.2.1(this), null).show();
      return;
    }
    benn.a(this.this$1.val$activity, 1, "小程序分享失败，参数错误", 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.ShareProxyDefault.4.2
 * JD-Core Version:    0.7.0.1
 */