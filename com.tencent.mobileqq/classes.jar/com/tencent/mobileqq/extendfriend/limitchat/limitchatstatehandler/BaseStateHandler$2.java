package com.tencent.mobileqq.extendfriend.limitchat.limitchatstatehandler;

import aknu;
import aofu;
import aojv;
import arqp;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

public class BaseStateHandler$2
  implements Runnable
{
  public BaseStateHandler$2(aojv paramaojv, aofu paramaofu) {}
  
  public void run()
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    arqp.b((QQAppInterface)localObject, this.a.jdField_b_of_type_JavaLangString);
    arqp.a((QQAppInterface)localObject, this.a, this.a.a, 1);
    arqp.c((QQAppInterface)localObject, this.a.jdField_b_of_type_JavaLangString);
    if (this.a.jdField_b_of_type_Int >= 2)
    {
      localObject = (aknu)((QQAppInterface)localObject).getManager(285);
      ((aknu)localObject).b(this.a.jdField_b_of_type_JavaLangString);
      ((aknu)localObject).d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.limitchat.limitchatstatehandler.BaseStateHandler.2
 * JD-Core Version:    0.7.0.1
 */