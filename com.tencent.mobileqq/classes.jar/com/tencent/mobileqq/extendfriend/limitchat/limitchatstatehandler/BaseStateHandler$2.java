package com.tencent.mobileqq.extendfriend.limitchat.limitchatstatehandler;

import amfi;
import android.text.TextUtils;
import apyc;
import aqbx;
import athk;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

public class BaseStateHandler$2
  implements Runnable
{
  public BaseStateHandler$2(aqbx paramaqbx, apyc paramapyc) {}
  
  public void run()
  {
    boolean bool = true;
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    athk.b((QQAppInterface)localObject, this.a.jdField_b_of_type_JavaLangString);
    athk.a((QQAppInterface)localObject, this.a, this.a.a, 1);
    String str1 = this.a.jdField_b_of_type_JavaLangString;
    int i = this.a.jdField_b_of_type_Int;
    String str2 = this.a.f;
    if (!TextUtils.isEmpty(this.a.c)) {}
    for (;;)
    {
      athk.a((QQAppInterface)localObject, str1, i, str2, bool);
      if (this.a.jdField_b_of_type_Int >= 2)
      {
        localObject = (amfi)((QQAppInterface)localObject).getManager(285);
        ((amfi)localObject).b(this.a.jdField_b_of_type_JavaLangString);
        ((amfi)localObject).d();
      }
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.limitchat.limitchatstatehandler.BaseStateHandler.2
 * JD-Core Version:    0.7.0.1
 */