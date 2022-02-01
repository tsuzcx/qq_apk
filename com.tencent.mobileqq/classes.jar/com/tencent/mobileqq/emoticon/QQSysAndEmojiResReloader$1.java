package com.tencent.mobileqq.emoticon;

import asky;
import aslb;
import com.tencent.qphone.base.util.QLog;

public class QQSysAndEmojiResReloader$1
  implements Runnable
{
  public QQSysAndEmojiResReloader$1(aslb paramaslb) {}
  
  public void run()
  {
    if (asky.a() != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSysAndEmojiResReloader", 2, "trigger downloadEmoticonRes");
      }
      asky.a().a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.QQSysAndEmojiResReloader.1
 * JD-Core Version:    0.7.0.1
 */