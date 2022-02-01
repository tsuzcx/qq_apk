package com.tencent.mobileqq.guild.handler.api.impl;

import com.tencent.mobileqq.qqguildsdk.callback.IResultWithSecurityCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;

class QQGuildHandler$7
  implements IResultWithSecurityCallback
{
  QQGuildHandler$7(QQGuildHandler paramQQGuildHandler, IResultWithSecurityCallback paramIResultWithSecurityCallback) {}
  
  public void a(int paramInt, String paramString, IGProSecurityResult paramIGProSecurityResult)
  {
    IResultWithSecurityCallback localIResultWithSecurityCallback = this.a;
    if (localIResultWithSecurityCallback != null) {
      localIResultWithSecurityCallback.a(paramInt, paramString, paramIGProSecurityResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.handler.api.impl.QQGuildHandler.7
 * JD-Core Version:    0.7.0.1
 */