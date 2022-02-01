package com.tencent.mobileqq.config.business;

import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.util.ConfigSimplifier.ConfigDownloadCallback;
import dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager;

class QIMTemplateConfigProcessor$1
  implements ConfigSimplifier.ConfigDownloadCallback
{
  QIMTemplateConfigProcessor$1(QIMTemplateConfigProcessor paramQIMTemplateConfigProcessor) {}
  
  public void a(String paramString)
  {
    ((QIMPtvTemplateManager)QIMManager.a(3)).a(paramString, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.QIMTemplateConfigProcessor.1
 * JD-Core Version:    0.7.0.1
 */