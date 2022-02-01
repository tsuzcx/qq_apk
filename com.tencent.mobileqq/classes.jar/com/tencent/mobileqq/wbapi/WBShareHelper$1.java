package com.tencent.mobileqq.wbapi;

import android.app.Activity;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.tencent.qphone.base.util.QLog;

class WBShareHelper$1
  implements Runnable
{
  WBShareHelper$1(WBShareHelper paramWBShareHelper, Activity paramActivity, WeiboMultiMessage paramWeiboMultiMessage) {}
  
  public void run()
  {
    QLog.d("WBShareHelper", 1, "WBQIPCClient installWBSdk onCallback");
    WBShareHelper.a(this.this$0, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComSinaWeiboSdkApiWeiboMultiMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.wbapi.WBShareHelper.1
 * JD-Core Version:    0.7.0.1
 */