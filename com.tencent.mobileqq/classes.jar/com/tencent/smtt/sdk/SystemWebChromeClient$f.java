package com.tencent.smtt.sdk;

class SystemWebChromeClient$f
  implements WebStorage.QuotaUpdater
{
  android.webkit.WebStorage.QuotaUpdater a;
  
  SystemWebChromeClient$f(SystemWebChromeClient paramSystemWebChromeClient, android.webkit.WebStorage.QuotaUpdater paramQuotaUpdater)
  {
    this.a = paramQuotaUpdater;
  }
  
  public void updateQuota(long paramLong)
  {
    this.a.updateQuota(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.SystemWebChromeClient.f
 * JD-Core Version:    0.7.0.1
 */