package com.tencent.mobileqq.kandian.ad.api.impl;

import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdLogService;

public class RIJAdLogServiceImpl
  implements IRIJAdLogService
{
  public void d(String paramString1, String paramString2)
  {
    ReadInJoyAdLog.a(paramString1, paramString2);
  }
  
  public void e(String paramString1, String paramString2)
  {
    ReadInJoyAdLog.b(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.impl.RIJAdLogServiceImpl
 * JD-Core Version:    0.7.0.1
 */