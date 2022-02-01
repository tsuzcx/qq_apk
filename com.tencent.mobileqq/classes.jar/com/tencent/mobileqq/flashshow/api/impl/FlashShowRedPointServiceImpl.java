package com.tencent.mobileqq.flashshow.api.impl;

import com.tencent.mobileqq.flashshow.api.IFlashShowRedPointService;
import com.tencent.mobileqq.flashshow.api.data.FSRedPointData;
import com.tencent.mobileqq.flashshow.data.ReportExtraInfo;
import com.tencent.mobileqq.flashshow.redpoint.BaseRedPoinManagerDelegate;
import com.tencent.mobileqq.flashshow.redpoint.EeveeRedPointManagerDelegate;
import java.util.List;
import qflash.QFlashBadge.QFlashBadgeInfo;

public class FlashShowRedPointServiceImpl
  implements IFlashShowRedPointService
{
  private BaseRedPoinManagerDelegate mCurrentRedPointManagerDelegate = new EeveeRedPointManagerDelegate();
  
  private BaseRedPoinManagerDelegate getCurrentRedPointManagerDelegate()
  {
    return this.mCurrentRedPointManagerDelegate;
  }
  
  public void clearPedPoint()
  {
    getCurrentRedPointManagerDelegate().h();
  }
  
  public FSRedPointData getBottomRedPointInfo()
  {
    return getCurrentRedPointManagerDelegate().a();
  }
  
  public FSRedPointData getBubbleRedPointInfo()
  {
    return getCurrentRedPointManagerDelegate().g();
  }
  
  public FSRedPointData getPreBottomRedPointInfo()
  {
    return getCurrentRedPointManagerDelegate().e();
  }
  
  public List<FSRedPointData> getTabRedPointInfos()
  {
    return getCurrentRedPointManagerDelegate().d();
  }
  
  public void handleRedPointInfos(List<QFlashBadge.QFlashBadgeInfo> paramList)
  {
    getCurrentRedPointManagerDelegate().a(paramList);
  }
  
  public void onBottomRedPointClick()
  {
    getCurrentRedPointManagerDelegate().b();
  }
  
  public void onBottomRedPointExposure(ReportExtraInfo paramReportExtraInfo)
  {
    getCurrentRedPointManagerDelegate().a(paramReportExtraInfo);
  }
  
  public void setBottomRedPointReaded()
  {
    getCurrentRedPointManagerDelegate().c();
  }
  
  public void setBubbleRedPointReaded()
  {
    getCurrentRedPointManagerDelegate().f();
  }
  
  public void setTabRedPointReaded(int paramInt)
  {
    getCurrentRedPointManagerDelegate().a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.api.impl.FlashShowRedPointServiceImpl
 * JD-Core Version:    0.7.0.1
 */