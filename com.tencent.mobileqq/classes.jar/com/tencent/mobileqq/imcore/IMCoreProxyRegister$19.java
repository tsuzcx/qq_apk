package com.tencent.mobileqq.imcore;

import android.graphics.drawable.Drawable;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.RecentFaceDecoder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.imcore.proxy.business.RecentFaceDecoderProxy.Proxy;

final class IMCoreProxyRegister$19
  implements RecentFaceDecoderProxy.Proxy
{
  public Drawable a(BaseQQAppInterface paramBaseQQAppInterface, int paramInt, String paramString)
  {
    if (!(paramBaseQQAppInterface instanceof QQAppInterface)) {
      return null;
    }
    return new RecentFaceDecoder((QQAppInterface)paramBaseQQAppInterface).a(paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.IMCoreProxyRegister.19
 * JD-Core Version:    0.7.0.1
 */