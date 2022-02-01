package com.tencent.mobileqq.config.business;

import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.paster.QIMPasterConfigManager;
import dov.com.qq.im.capture.util.ConfigSimplifier.ConfigDownloadCallback;

class QIMPasterConfigProcessor$1
  implements ConfigSimplifier.ConfigDownloadCallback
{
  QIMPasterConfigProcessor$1(QIMPasterConfigProcessor paramQIMPasterConfigProcessor) {}
  
  public void a(String paramString)
  {
    ((QIMPasterConfigManager)QIMManager.a(1)).a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.QIMPasterConfigProcessor.1
 * JD-Core Version:    0.7.0.1
 */