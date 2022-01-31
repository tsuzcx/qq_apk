package com.tencent.smtt.sdk;

class SystemWebChromeClient$QuotaUpdaterImpl
  implements WebStorage.QuotaUpdater
{
  android.webkit.WebStorage.QuotaUpdater mQuotaUpdater;
  
  SystemWebChromeClient$QuotaUpdaterImpl(SystemWebChromeClient paramSystemWebChromeClient, android.webkit.WebStorage.QuotaUpdater paramQuotaUpdater)
  {
    this.mQuotaUpdater = paramQuotaUpdater;
  }
  
  public void updateQuota(long paramLong)
  {
    this.mQuotaUpdater.updateQuota(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.smtt.sdk.SystemWebChromeClient.QuotaUpdaterImpl
 * JD-Core Version:    0.7.0.1
 */