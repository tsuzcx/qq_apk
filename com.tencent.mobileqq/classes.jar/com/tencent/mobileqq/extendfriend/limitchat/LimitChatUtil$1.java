package com.tencent.mobileqq.extendfriend.limitchat;

import asrt;
import bdla;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

public final class LimitChatUtil$1
  implements Runnable
{
  public LimitChatUtil$1(String paramString) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    bdla.b(localQQAppInterface, "dc00898", "", "", "0X800A801", "0X800A801", 0, 0, "", "", asrt.a(localQQAppInterface, this.a), "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.limitchat.LimitChatUtil.1
 * JD-Core Version:    0.7.0.1
 */