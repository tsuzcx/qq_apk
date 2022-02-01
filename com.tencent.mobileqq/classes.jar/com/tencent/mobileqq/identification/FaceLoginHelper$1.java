package com.tencent.mobileqq.identification;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.observer.LoginVerifyObserver;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.oidb_0x87a.RspBody;

final class FaceLoginHelper$1
  extends LoginVerifyObserver
{
  FaceLoginHelper$1(String paramString, Activity paramActivity, Runnable paramRunnable) {}
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    QLog.e("FaceLoginHelper", 1, new Object[] { "cmd : ", paramString1, " code : ", Integer.valueOf(paramInt), " message : ", paramString2 });
    if (paramInt == 89) {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131698848), 0).a();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_JavaLangRunnable != null) {
        this.jdField_a_of_type_JavaLangRunnable.run();
      }
      return;
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, paramString2, 0).a();
    }
  }
  
  public void a(oidb_0x87a.RspBody paramRspBody)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("keyFrom", "f_SetFaceData");
    if (this.jdField_a_of_type_JavaLangString == null) {}
    for (paramRspBody = "";; paramRspBody = this.jdField_a_of_type_JavaLangString)
    {
      localIntent.putExtra("phone_num", paramRspBody);
      RouteUtils.a(this.jdField_a_of_type_AndroidAppActivity, localIntent, "/base/login/authDevVerifyCode", 11);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.identification.FaceLoginHelper.1
 * JD-Core Version:    0.7.0.1
 */