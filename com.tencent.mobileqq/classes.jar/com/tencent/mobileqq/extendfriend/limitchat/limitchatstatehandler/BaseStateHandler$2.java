package com.tencent.mobileqq.extendfriend.limitchat.limitchatstatehandler;

import android.text.TextUtils;
import ariy;
import arnq;
import auyo;
import azwy;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

public class BaseStateHandler$2
  implements Runnable
{
  public BaseStateHandler$2(arnq paramarnq, ariy paramariy) {}
  
  public void run()
  {
    boolean bool = true;
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    auyo.b((QQAppInterface)localObject, this.a.jdField_b_of_type_JavaLangString);
    auyo.a((QQAppInterface)localObject, this.a, this.a.a, 1);
    String str1 = this.a.jdField_b_of_type_JavaLangString;
    int i = this.a.jdField_b_of_type_Int;
    String str2 = this.a.f;
    if (!TextUtils.isEmpty(this.a.c)) {}
    for (;;)
    {
      auyo.a((QQAppInterface)localObject, str1, i, str2, bool, -1, false, 3);
      if (this.a.jdField_b_of_type_Int >= 2)
      {
        localObject = (azwy)((QQAppInterface)localObject).getManager(285);
        ((azwy)localObject).b(this.a.jdField_b_of_type_JavaLangString);
        ((azwy)localObject).d();
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