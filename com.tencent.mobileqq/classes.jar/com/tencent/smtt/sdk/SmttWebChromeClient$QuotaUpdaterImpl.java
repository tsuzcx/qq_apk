package com.tencent.smtt.sdk;

import com.tencent.smtt.export.external.interfaces.QuotaUpdater;

class SmttWebChromeClient$QuotaUpdaterImpl
  implements WebStorage.QuotaUpdater
{
  QuotaUpdater mQuotaUpdater;
  
  SmttWebChromeClient$QuotaUpdaterImpl(SmttWebChromeClient paramSmttWebChromeClient, QuotaUpdater paramQuotaUpdater)
  {
    this.mQuotaUpdater = paramQuotaUpdater;
  }
  
  public void updateQuota(long paramLong)
  {
    this.mQuotaUpdater.updateQuota(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.smtt.sdk.SmttWebChromeClient.QuotaUpdaterImpl
 * JD-Core Version:    0.7.0.1
 */