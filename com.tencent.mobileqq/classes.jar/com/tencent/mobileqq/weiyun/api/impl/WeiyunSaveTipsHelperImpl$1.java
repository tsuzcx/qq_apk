package com.tencent.mobileqq.weiyun.api.impl;

import android.app.Activity;
import android.os.Build.VERSION;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.widget.QQToast;

class WeiyunSaveTipsHelperImpl$1
  implements Runnable
{
  WeiyunSaveTipsHelperImpl$1(WeiyunSaveTipsHelperImpl paramWeiyunSaveTipsHelperImpl, Activity paramActivity, int paramInt, AppInterface paramAppInterface) {}
  
  public void run()
  {
    if (Build.VERSION.SDK_INT >= 28)
    {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), 2, 2131697389, 1).b(this.jdField_a_of_type_Int);
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), 2, 2131691300, 1).b(this.jdField_a_of_type_Int, 2131563083, new WeiyunSaveTipsHelperImpl.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.api.impl.WeiyunSaveTipsHelperImpl.1
 * JD-Core Version:    0.7.0.1
 */