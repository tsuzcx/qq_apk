package com.tencent.mobileqq.mini.appbrand.utils;

import android.app.Activity;
import bbcv;
import bbgg;
import bcpw;

class ShareUtils$6$1
  implements Runnable
{
  ShareUtils$6$1(ShareUtils.6 param6, long paramLong, String paramString) {}
  
  public void run()
  {
    if ((this.val$finalErrCode == -100070004L) || (this.val$finalErrCode == -1000710003L))
    {
      bbcv.a(this.this$0.val$activity, 233, this.this$0.val$activity.getString(2131719480), this.val$finalErrMsg, new ShareUtils.6.1.1(this), null).show();
      return;
    }
    bcpw.a(this.this$0.val$activity, 1, 2131694282, 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.utils.ShareUtils.6.1
 * JD-Core Version:    0.7.0.1
 */