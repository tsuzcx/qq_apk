package com.tencent.mobileqq.imcore.proxy.business;

import android.graphics.drawable.Drawable;
import com.tencent.common.app.business.BaseQQAppInterface;

public class RecentFaceDecoderProxy
{
  private static RecentFaceDecoderProxy.Proxy a;
  
  public static Drawable a(BaseQQAppInterface paramBaseQQAppInterface, int paramInt, String paramString)
  {
    RecentFaceDecoderProxy.Proxy localProxy = a;
    if (localProxy == null) {
      return null;
    }
    return localProxy.a(paramBaseQQAppInterface, paramInt, paramString);
  }
  
  public static void a(RecentFaceDecoderProxy.Proxy paramProxy)
  {
    a = paramProxy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.proxy.business.RecentFaceDecoderProxy
 * JD-Core Version:    0.7.0.1
 */