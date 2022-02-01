package com.tencent.smtt.sdk;

import com.tencent.smtt.export.external.interfaces.QuotaUpdater;

class h$a
  implements WebStorage.QuotaUpdater
{
  QuotaUpdater a;
  
  h$a(h paramh, QuotaUpdater paramQuotaUpdater)
  {
    this.a = paramQuotaUpdater;
  }
  
  public void updateQuota(long paramLong)
  {
    this.a.updateQuota(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.smtt.sdk.h.a
 * JD-Core Version:    0.7.0.1
 */