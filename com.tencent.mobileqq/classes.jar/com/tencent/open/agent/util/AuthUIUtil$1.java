package com.tencent.open.agent.util;

import android.app.Activity;
import com.tencent.mobileqq.widget.QQToast;

final class AuthUIUtil$1
  implements Runnable
{
  AuthUIUtil$1(Activity paramActivity, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    QQToast localQQToast = new QQToast(this.jdField_a_of_type_AndroidAppActivity);
    if (this.jdField_a_of_type_Boolean)
    {
      localQQToast.a(QQToast.a(2));
      localQQToast.b(2);
    }
    else
    {
      localQQToast.a(QQToast.a(1));
      localQQToast.b(1);
    }
    localQQToast.d(1);
    localQQToast.a(this.jdField_a_of_type_JavaLangString);
    localQQToast.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.util.AuthUIUtil.1
 * JD-Core Version:    0.7.0.1
 */