package com.tencent.mobileqq.extendfriend.limitchat.limitchatstatehandler;

import android.text.TextUtils;
import aswv;
import atbi;
import awlm;
import bbcd;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

public class BaseStateHandler$2
  implements Runnable
{
  public BaseStateHandler$2(atbi paramatbi, aswv paramaswv) {}
  
  public void run()
  {
    boolean bool = true;
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    awlm.b((QQAppInterface)localObject, this.a.jdField_b_of_type_JavaLangString);
    awlm.a((QQAppInterface)localObject, this.a, this.a.a, 1);
    String str1 = this.a.jdField_b_of_type_JavaLangString;
    int i = this.a.jdField_b_of_type_Int;
    String str2 = this.a.f;
    if (!TextUtils.isEmpty(this.a.c)) {}
    for (;;)
    {
      awlm.a((QQAppInterface)localObject, str1, i, str2, bool, -1, false, 3);
      if (this.a.jdField_b_of_type_Int >= 2)
      {
        localObject = (bbcd)((QQAppInterface)localObject).getManager(285);
        ((bbcd)localObject).b(this.a.jdField_b_of_type_JavaLangString);
        ((bbcd)localObject).d();
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