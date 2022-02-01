package com.tencent.mobileqq.kandian.ad.api.impl;

import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.report_action.ReadInJoyAdReportUtils;
import com.tencent.mobileqq.kandian.ad.api.IRIJFastWebAdReportService;

public class RIJFastWebAdReportServiceImpl
  implements IRIJFastWebAdReportService
{
  public void report(ReportAction paramReportAction, Integer paramInteger, AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    ReadInJoyAdReportUtils.a(paramReportAction, paramInteger, paramAdvertisementInfo, paramInt1, paramInt2, paramInt3, paramBoolean);
  }
  
  public void report(AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2, int paramInt3)
  {
    ReadInJoyAdReportUtils.a(paramAdvertisementInfo, paramInt1, paramInt2, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.impl.RIJFastWebAdReportServiceImpl
 * JD-Core Version:    0.7.0.1
 */