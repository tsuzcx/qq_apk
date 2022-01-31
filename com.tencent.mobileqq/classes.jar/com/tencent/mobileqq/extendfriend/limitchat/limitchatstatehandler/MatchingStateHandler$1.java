package com.tencent.mobileqq.extendfriend.limitchat.limitchatstatehandler;

import anpe;
import anti;
import aqux;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class MatchingStateHandler$1
  implements Runnable
{
  public MatchingStateHandler$1(anti paramanti) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    aqux.b(localQQAppInterface, this.this$0.a.b);
    aqux.a(localQQAppInterface, this.this$0.a.c, this.this$0.a.b, this.this$0.a.a);
    ThreadManager.getUIHandler().post(new MatchingStateHandler.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.limitchat.limitchatstatehandler.MatchingStateHandler.1
 * JD-Core Version:    0.7.0.1
 */