package com.tencent.mobileqq.emoticon;

import asjb;
import asje;
import com.tencent.qphone.base.util.QLog;

public class QQSysAndEmojiResReloader$1
  implements Runnable
{
  public QQSysAndEmojiResReloader$1(asje paramasje) {}
  
  public void run()
  {
    if (asjb.a() != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSysAndEmojiResReloader", 2, "trigger downloadEmoticonRes");
      }
      asjb.a().a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.QQSysAndEmojiResReloader.1
 * JD-Core Version:    0.7.0.1
 */