package com.tencent.mobileqq.extendfriend.limitchat.limitchatstatehandler;

import aknv;
import aofp;
import aojq;
import arqn;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

public class BaseStateHandler$2
  implements Runnable
{
  public BaseStateHandler$2(aojq paramaojq, aofp paramaofp) {}
  
  public void run()
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    arqn.b((QQAppInterface)localObject, this.a.jdField_b_of_type_JavaLangString);
    arqn.a((QQAppInterface)localObject, this.a, this.a.a, 1);
    arqn.c((QQAppInterface)localObject, this.a.jdField_b_of_type_JavaLangString);
    if (this.a.jdField_b_of_type_Int >= 2)
    {
      localObject = (aknv)((QQAppInterface)localObject).getManager(285);
      ((aknv)localObject).b(this.a.jdField_b_of_type_JavaLangString);
      ((aknv)localObject).d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.limitchat.limitchatstatehandler.BaseStateHandler.2
 * JD-Core Version:    0.7.0.1
 */