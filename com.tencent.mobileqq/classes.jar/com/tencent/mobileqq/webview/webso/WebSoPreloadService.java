package com.tencent.mobileqq.webview.webso;

import com.tencent.mobileqq.config.business.qvip.QVipSDKConfig;
import com.tencent.mobileqq.config.business.qvip.QVipSDKProcessor;

public class WebSoPreloadService
{
  public static void a(String paramString)
  {
    long l = System.currentTimeMillis();
    if ((WebSoUtils.b(paramString)) && (!WebSoUtils.d(paramString)) && (QVipSDKProcessor.c().b > 0))
    {
      WebSoService.a().a(paramString, null, true);
      WebSoUtils.a("preload spned time = " + (System.currentTimeMillis() - l));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.webso.WebSoPreloadService
 * JD-Core Version:    0.7.0.1
 */