package com.tencent.mobileqq.config.business;

import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import dov.com.qq.im.capture.util.ConfigSimplifier.ConfigDownloadCallback;

class QIMMusicConfigProcessor$1
  implements ConfigSimplifier.ConfigDownloadCallback
{
  QIMMusicConfigProcessor$1(QIMMusicConfigProcessor paramQIMMusicConfigProcessor) {}
  
  public void a(String paramString)
  {
    ((QIMMusicConfigManager)QIMManager.a(2)).a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.QIMMusicConfigProcessor.1
 * JD-Core Version:    0.7.0.1
 */