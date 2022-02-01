package com.tencent.mobileqq.emoticon;

import arev;
import arey;
import com.tencent.qphone.base.util.QLog;

public class QQSysAndEmojiResReloader$1
  implements Runnable
{
  public QQSysAndEmojiResReloader$1(arey paramarey) {}
  
  public void run()
  {
    if (arev.a() != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSysAndEmojiResReloader", 2, "trigger downloadEmoticonRes");
      }
      arev.a().a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.QQSysAndEmojiResReloader.1
 * JD-Core Version:    0.7.0.1
 */