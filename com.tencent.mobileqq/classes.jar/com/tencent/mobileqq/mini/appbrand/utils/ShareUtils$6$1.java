package com.tencent.mobileqq.mini.appbrand.utils;

import android.app.Activity;
import bhdj;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;

class ShareUtils$6$1
  implements Runnable
{
  ShareUtils$6$1(ShareUtils.6 param6, long paramLong, String paramString) {}
  
  public void run()
  {
    if ((this.val$finalErrCode == -100070004L) || (this.val$finalErrCode == -1000710003L))
    {
      bhdj.a(this.this$0.val$activity, 233, this.this$0.val$activity.getString(2131718769), this.val$finalErrMsg, new ShareUtils.6.1.1(this), null).show();
      return;
    }
    QQToast.a(this.this$0.val$activity, 1, 2131694008, 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.utils.ShareUtils.6.1
 * JD-Core Version:    0.7.0.1
 */