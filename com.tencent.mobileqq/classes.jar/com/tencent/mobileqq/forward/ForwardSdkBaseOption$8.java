package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import aqes;
import axut;
import com.tencent.mobileqq.app.QQAppInterface;

public class ForwardSdkBaseOption$8
  implements Runnable
{
  public ForwardSdkBaseOption$8(aqes paramaqes, String paramString) {}
  
  public void run()
  {
    String str = axut.a(this.this$0.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), this.a);
    if (!TextUtils.isEmpty(str))
    {
      this.this$0.jdField_a_of_type_AndroidOsBundle.putString("video_url", str);
      this.this$0.jdField_a_of_type_AndroidOsBundle.putBoolean("video_url_load", true);
    }
    this.this$0.K();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSdkBaseOption.8
 * JD-Core Version:    0.7.0.1
 */