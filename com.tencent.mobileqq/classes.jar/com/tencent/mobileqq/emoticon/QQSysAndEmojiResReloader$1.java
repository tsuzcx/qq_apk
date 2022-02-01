package com.tencent.mobileqq.emoticon;

import com.tencent.qphone.base.util.QLog;

class QQSysAndEmojiResReloader$1
  implements Runnable
{
  QQSysAndEmojiResReloader$1(QQSysAndEmojiResReloader paramQQSysAndEmojiResReloader) {}
  
  public void run()
  {
    if (QQSysAndEmojiResMgr.getInstance() != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSysAndEmojiResReloader", 2, "trigger downloadEmoticonRes");
      }
      QQSysAndEmojiResMgr.getInstance().downloadEmoticonRes();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.QQSysAndEmojiResReloader.1
 * JD-Core Version:    0.7.0.1
 */