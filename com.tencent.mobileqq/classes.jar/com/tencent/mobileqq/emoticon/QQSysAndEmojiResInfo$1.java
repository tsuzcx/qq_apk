package com.tencent.mobileqq.emoticon;

final class QQSysAndEmojiResInfo$1
  implements Runnable
{
  public void run()
  {
    if (QQSysAndEmojiResMgr.getInstance() != null) {
      QQSysAndEmojiResMgr.getInstance().downloadEmoticonRes();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo.1
 * JD-Core Version:    0.7.0.1
 */