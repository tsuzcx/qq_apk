package com.tencent.qqmini.sdk.core.proxy.service;

import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMiniAppNotifyProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

@ProxyService(proxy=IMiniAppNotifyProxy.class)
public class MiniAppNotifyProxyDefault
  implements IMiniAppNotifyProxy
{
  public void report(String paramString1, int paramInt, String paramString2, String paramString3, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("appid:");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" scene:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" via:");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(" event:");
    localStringBuilder.append(paramString3);
    localStringBuilder.append(" timestamp:");
    localStringBuilder.append(paramLong);
    QMLog.d("IMiniAppNotifyProxy", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.MiniAppNotifyProxyDefault
 * JD-Core Version:    0.7.0.1
 */