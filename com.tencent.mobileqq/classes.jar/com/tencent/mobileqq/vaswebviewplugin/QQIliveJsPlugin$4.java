package com.tencent.mobileqq.vaswebviewplugin;

import com.tencent.mobileqq.qqgift.api.service.IQQGiftWalletIdentifyModule.QQGiftWalletIdentifyCallback;

class QQIliveJsPlugin$4
  implements IQQGiftWalletIdentifyModule.QQGiftWalletIdentifyCallback
{
  QQIliveJsPlugin$4(QQIliveJsPlugin paramQQIliveJsPlugin) {}
  
  public void identifyFinish(boolean paramBoolean, int paramInt, String paramString)
  {
    if (paramBoolean)
    {
      QQIliveJsPlugin.access$600(this.this$0);
      return;
    }
    QQIliveJsPlugin.access$700(this.this$0, paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QQIliveJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */