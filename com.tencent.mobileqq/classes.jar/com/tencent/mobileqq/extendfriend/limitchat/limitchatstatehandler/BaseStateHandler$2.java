package com.tencent.mobileqq.extendfriend.limitchat.limitchatstatehandler;

import android.text.TextUtils;
import ashh;
import asll;
import avsr;
import bajk;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

public class BaseStateHandler$2
  implements Runnable
{
  public BaseStateHandler$2(asll paramasll, ashh paramashh) {}
  
  public void run()
  {
    boolean bool = true;
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    avsr.b((QQAppInterface)localObject, this.a.jdField_b_of_type_JavaLangString);
    avsr.a((QQAppInterface)localObject, this.a, this.a.a, 1);
    String str1 = this.a.jdField_b_of_type_JavaLangString;
    int i = this.a.jdField_b_of_type_Int;
    String str2 = this.a.f;
    if (!TextUtils.isEmpty(this.a.c)) {}
    for (;;)
    {
      avsr.a((QQAppInterface)localObject, str1, i, str2, bool, -1, false, 3);
      if (this.a.jdField_b_of_type_Int >= 2)
      {
        localObject = (bajk)((QQAppInterface)localObject).getManager(285);
        ((bajk)localObject).b(this.a.jdField_b_of_type_JavaLangString);
        ((bajk)localObject).d();
      }
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.limitchat.limitchatstatehandler.BaseStateHandler.2
 * JD-Core Version:    0.7.0.1
 */