package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.structmsg.CGILoader;

class ForwardSdkBaseOption$7
  implements Runnable
{
  ForwardSdkBaseOption$7(ForwardSdkBaseOption paramForwardSdkBaseOption, String paramString) {}
  
  public void run()
  {
    String str = CGILoader.a(this.this$0.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), this.a);
    if (!TextUtils.isEmpty(str))
    {
      this.this$0.jdField_a_of_type_AndroidOsBundle.putString("video_url", str);
      this.this$0.jdField_a_of_type_AndroidOsBundle.putBoolean("video_url_load", true);
    }
    this.this$0.M();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSdkBaseOption.7
 * JD-Core Version:    0.7.0.1
 */