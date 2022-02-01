package com.tencent.mobileqq.flashshow.api;

import com.tencent.mobileqq.flashshow.api.data.FSRedPointData;
import com.tencent.mobileqq.flashshow.data.ReportExtraInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;
import qflash.QFlashBadge.QFlashBadgeInfo;

@QAPI(process={"all"})
public abstract interface IFlashShowRedPointService
  extends QRouteApi
{
  public abstract void clearPedPoint();
  
  public abstract FSRedPointData getBottomRedPointInfo();
  
  public abstract FSRedPointData getBubbleRedPointInfo();
  
  public abstract FSRedPointData getPreBottomRedPointInfo();
  
  public abstract List<FSRedPointData> getTabRedPointInfos();
  
  public abstract void handleRedPointInfos(List<QFlashBadge.QFlashBadgeInfo> paramList);
  
  public abstract void onBottomRedPointClick();
  
  public abstract void onBottomRedPointExposure(ReportExtraInfo paramReportExtraInfo);
  
  public abstract void setBottomRedPointReaded();
  
  public abstract void setBubbleRedPointReaded();
  
  public abstract void setTabRedPointReaded(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.api.IFlashShowRedPointService
 * JD-Core Version:    0.7.0.1
 */