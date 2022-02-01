package com.tencent.mobileqq.flashshow.redpoint;

import com.tencent.mobileqq.flashshow.api.data.FSRedPointData;
import com.tencent.mobileqq.flashshow.data.ReportExtraInfo;
import java.util.List;
import qflash.QFlashBadge.QFlashBadgeInfo;

public abstract interface BaseRedPoinManagerDelegate
{
  public abstract FSRedPointData a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(ReportExtraInfo paramReportExtraInfo);
  
  public abstract void a(List<QFlashBadge.QFlashBadgeInfo> paramList);
  
  public abstract void b();
  
  public abstract void c();
  
  public abstract List<FSRedPointData> d();
  
  public abstract FSRedPointData e();
  
  public abstract void f();
  
  public abstract FSRedPointData g();
  
  public abstract void h();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.redpoint.BaseRedPoinManagerDelegate
 * JD-Core Version:    0.7.0.1
 */