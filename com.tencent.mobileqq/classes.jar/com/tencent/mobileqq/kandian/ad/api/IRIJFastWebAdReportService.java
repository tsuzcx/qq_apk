package com.tencent.mobileqq.kandian.ad.api;

import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IRIJFastWebAdReportService
  extends QRouteApi
{
  public abstract void report(ReportAction paramReportAction, Integer paramInteger, AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean);
  
  public abstract void report(AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2, int paramInt3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.IRIJFastWebAdReportService
 * JD-Core Version:    0.7.0.1
 */