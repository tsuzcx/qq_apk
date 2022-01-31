package com.tencent.mobileqq.extendfriend.limitchat.limitchatstatehandler;

import amjx;
import android.text.TextUtils;
import aqcl;
import aqgg;
import atlt;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

public class BaseStateHandler$2
  implements Runnable
{
  public BaseStateHandler$2(aqgg paramaqgg, aqcl paramaqcl) {}
  
  public void run()
  {
    boolean bool = true;
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    atlt.b((QQAppInterface)localObject, this.a.jdField_b_of_type_JavaLangString);
    atlt.a((QQAppInterface)localObject, this.a, this.a.a, 1);
    String str1 = this.a.jdField_b_of_type_JavaLangString;
    int i = this.a.jdField_b_of_type_Int;
    String str2 = this.a.f;
    if (!TextUtils.isEmpty(this.a.c)) {}
    for (;;)
    {
      atlt.a((QQAppInterface)localObject, str1, i, str2, bool);
      if (this.a.jdField_b_of_type_Int >= 2)
      {
        localObject = (amjx)((QQAppInterface)localObject).getManager(285);
        ((amjx)localObject).b(this.a.jdField_b_of_type_JavaLangString);
        ((amjx)localObject).d();
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