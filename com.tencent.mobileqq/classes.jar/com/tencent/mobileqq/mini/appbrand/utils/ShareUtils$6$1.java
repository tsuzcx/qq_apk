package com.tencent.mobileqq.mini.appbrand.utils;

import android.app.Activity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;

class ShareUtils$6$1
  implements Runnable
{
  ShareUtils$6$1(ShareUtils.6 param6, long paramLong, String paramString) {}
  
  public void run()
  {
    long l = this.val$finalErrCode;
    if ((l != -100070004L) && (l != -1000710003L))
    {
      QQToast.makeText(this.this$0.val$activity, 1, 2131891804, 1).show();
      return;
    }
    DialogUtil.a(this.this$0.val$activity, 233, this.this$0.val$activity.getString(2131916547), this.val$finalErrMsg, new ShareUtils.6.1.1(this), null).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.utils.ShareUtils.6.1
 * JD-Core Version:    0.7.0.1
 */