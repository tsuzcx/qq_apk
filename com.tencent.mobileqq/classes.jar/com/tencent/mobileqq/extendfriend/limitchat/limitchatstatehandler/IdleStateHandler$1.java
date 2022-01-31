package com.tencent.mobileqq.extendfriend.limitchat.limitchatstatehandler;

import anpe;
import antf;
import aqux;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

public class IdleStateHandler$1
  implements Runnable
{
  public IdleStateHandler$1(antf paramantf, anpe paramanpe) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    aqux.b(localQQAppInterface, this.a.b);
    aqux.a(localQQAppInterface, this.a.c, this.a.b, this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.limitchat.limitchatstatehandler.IdleStateHandler.1
 * JD-Core Version:    0.7.0.1
 */