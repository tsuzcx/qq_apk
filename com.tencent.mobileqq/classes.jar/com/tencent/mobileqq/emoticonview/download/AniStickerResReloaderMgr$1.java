package com.tencent.mobileqq.emoticonview.download;

import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.qphone.base.util.QLog;

class AniStickerResReloaderMgr$1
  implements Runnable
{
  AniStickerResReloaderMgr$1(AniStickerResReloaderMgr paramAniStickerResReloaderMgr) {}
  
  public void run()
  {
    if (QQSysAndEmojiResMgr.getInstance() != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AniStickerResReloaderMgr", 2, "trigger downloadEmoticonRes");
      }
      QQSysAndEmojiResMgr.getInstance().downloadEmoticonRes();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.download.AniStickerResReloaderMgr.1
 * JD-Core Version:    0.7.0.1
 */