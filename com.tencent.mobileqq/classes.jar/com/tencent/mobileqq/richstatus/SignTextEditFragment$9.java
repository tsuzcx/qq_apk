package com.tencent.mobileqq.richstatus;

import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppActivity;
import mqq.app.QQPermissionCallback;

class SignTextEditFragment$9
  implements QQPermissionCallback
{
  SignTextEditFragment$9(SignTextEditFragment paramSignTextEditFragment, AppActivity paramAppActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SignTextEditFragment", 2, "requestPermission user denied");
    }
    DialogUtil.a(this.a, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SignTextEditFragment", 2, "requestPermission user grant");
    }
    this.b.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignTextEditFragment.9
 * JD-Core Version:    0.7.0.1
 */