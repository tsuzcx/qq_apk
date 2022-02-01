package com.tencent.mobileqq.qqexpand.chat.utils;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;

final class ExpandChatUtil$2
  implements Runnable
{
  ExpandChatUtil$2(String paramString) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    ReportController.b(localQQAppInterface, "dc00898", "", "", "0X800A801", "0X800A801", 0, 0, "", "", ExpandChatUtil.b(localQQAppInterface, this.a), "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.chat.utils.ExpandChatUtil.2
 * JD-Core Version:    0.7.0.1
 */