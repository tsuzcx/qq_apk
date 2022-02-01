package com.tencent.mobileqq.extendfriend.limitchat.limitchatstatehandler;

import android.text.TextUtils;
import asne;
import asrw;
import aweo;
import bbdh;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

public class BaseStateHandler$2
  implements Runnable
{
  public BaseStateHandler$2(asrw paramasrw, asne paramasne) {}
  
  public void run()
  {
    boolean bool = true;
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    aweo.b((QQAppInterface)localObject, this.a.jdField_b_of_type_JavaLangString);
    aweo.a((QQAppInterface)localObject, this.a, this.a.a, 1);
    String str1 = this.a.jdField_b_of_type_JavaLangString;
    int i = this.a.jdField_b_of_type_Int;
    String str2 = this.a.f;
    if (!TextUtils.isEmpty(this.a.c)) {}
    for (;;)
    {
      aweo.a((QQAppInterface)localObject, str1, i, str2, bool, -1, false, 3);
      if (this.a.jdField_b_of_type_Int >= 2)
      {
        localObject = (bbdh)((QQAppInterface)localObject).getManager(QQManagerFactory.ICE_BREAKING_MNG);
        ((bbdh)localObject).b(this.a.jdField_b_of_type_JavaLangString);
        ((bbdh)localObject).d();
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