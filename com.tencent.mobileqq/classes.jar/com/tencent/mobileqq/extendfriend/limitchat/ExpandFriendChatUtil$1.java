package com.tencent.mobileqq.extendfriend.limitchat;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;

final class ExpandFriendChatUtil$1
  implements Runnable
{
  ExpandFriendChatUtil$1(String paramString) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    ReportController.b(localQQAppInterface, "dc00898", "", "", "0X800A801", "0X800A801", 0, 0, "", "", ExpandFriendChatUtil.a(localQQAppInterface, this.a), "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.limitchat.ExpandFriendChatUtil.1
 * JD-Core Version:    0.7.0.1
 */