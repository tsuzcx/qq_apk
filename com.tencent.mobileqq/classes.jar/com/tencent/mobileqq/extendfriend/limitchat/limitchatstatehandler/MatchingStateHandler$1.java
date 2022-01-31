package com.tencent.mobileqq.extendfriend.limitchat.limitchatstatehandler;

import aknv;
import aofp;
import aoju;
import arqn;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class MatchingStateHandler$1
  implements Runnable
{
  public MatchingStateHandler$1(aoju paramaoju) {}
  
  public void run()
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    arqn.b((QQAppInterface)localObject, this.this$0.a.jdField_b_of_type_JavaLangString);
    arqn.a((QQAppInterface)localObject, this.this$0.a, this.this$0.a.a, 2);
    arqn.c((QQAppInterface)localObject, this.this$0.a.jdField_b_of_type_JavaLangString);
    if (this.this$0.a.jdField_b_of_type_Int >= 2)
    {
      localObject = (aknv)((QQAppInterface)localObject).getManager(285);
      ((aknv)localObject).b(this.this$0.a.jdField_b_of_type_JavaLangString);
      ((aknv)localObject).d();
    }
    ThreadManager.getUIHandler().post(new MatchingStateHandler.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.limitchat.limitchatstatehandler.MatchingStateHandler.1
 * JD-Core Version:    0.7.0.1
 */