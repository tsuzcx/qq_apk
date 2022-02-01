package com.tencent.mobileqq.extendfriend.limitchat.limitchatstatehandler;

import arnn;
import arnq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

public class BaseStateHandler$1
  implements Runnable
{
  public BaseStateHandler$1(arnq paramarnq, String paramString1, String paramString2) {}
  
  public void run()
  {
    arnn.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.limitchat.limitchatstatehandler.BaseStateHandler.1
 * JD-Core Version:    0.7.0.1
 */