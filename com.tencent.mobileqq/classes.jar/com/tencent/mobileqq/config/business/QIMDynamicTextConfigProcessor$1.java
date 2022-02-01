package com.tencent.mobileqq.config.business;

import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.text.DynamicTextConfigManager;
import dov.com.qq.im.capture.util.ConfigSimplifier.ConfigDownloadCallback;

class QIMDynamicTextConfigProcessor$1
  implements ConfigSimplifier.ConfigDownloadCallback
{
  QIMDynamicTextConfigProcessor$1(QIMDynamicTextConfigProcessor paramQIMDynamicTextConfigProcessor) {}
  
  public void a(String paramString)
  {
    ((DynamicTextConfigManager)QIMManager.a(7)).a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.QIMDynamicTextConfigProcessor.1
 * JD-Core Version:    0.7.0.1
 */