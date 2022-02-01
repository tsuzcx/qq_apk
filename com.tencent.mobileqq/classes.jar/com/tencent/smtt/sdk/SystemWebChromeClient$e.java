package com.tencent.smtt.sdk;

class SystemWebChromeClient$e
  implements WebStorage.QuotaUpdater
{
  android.webkit.WebStorage.QuotaUpdater a;
  
  SystemWebChromeClient$e(SystemWebChromeClient paramSystemWebChromeClient, android.webkit.WebStorage.QuotaUpdater paramQuotaUpdater)
  {
    this.a = paramQuotaUpdater;
  }
  
  public void updateQuota(long paramLong)
  {
    this.a.updateQuota(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.sdk.SystemWebChromeClient.e
 * JD-Core Version:    0.7.0.1
 */