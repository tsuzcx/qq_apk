package com.tencent.open.agent.util;

import android.app.Activity;
import com.tencent.mobileqq.widget.QQToast;

public final class AuthorityUtil$1
  implements Runnable
{
  public AuthorityUtil$1(Activity paramActivity, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    QQToast localQQToast = new QQToast(this.jdField_a_of_type_AndroidAppActivity);
    if (this.jdField_a_of_type_Boolean)
    {
      localQQToast.a(QQToast.a(2));
      localQQToast.b(2);
    }
    for (;;)
    {
      localQQToast.d(1);
      localQQToast.a(this.jdField_a_of_type_JavaLangString);
      localQQToast.a();
      return;
      localQQToast.a(QQToast.a(1));
      localQQToast.b(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.agent.util.AuthorityUtil.1
 * JD-Core Version:    0.7.0.1
 */