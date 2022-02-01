package com.tencent.mobileqq.kandian.biz.fastweb.event;

import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;

public class ItemShowDispatcher$AdPostionReportManager
{
  public int a;
  public Long b;
  public long c;
  public float d;
  public BaseData e;
  public long f;
  
  public ItemShowDispatcher$AdPostionReportManager(int paramInt, Long paramLong, BaseData paramBaseData)
  {
    this.a = paramInt;
    this.b = paramLong;
    this.c = 0L;
    this.d = 0.0F;
    this.e = paramBaseData;
    this.f = 0L;
  }
  
  public void a(AdPostionReportManager paramAdPostionReportManager)
  {
    if (paramAdPostionReportManager != null)
    {
      this.b = paramAdPostionReportManager.b;
      this.c = paramAdPostionReportManager.c;
      this.d = paramAdPostionReportManager.d;
      this.e = paramAdPostionReportManager.e;
      this.f = paramAdPostionReportManager.f;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.event.ItemShowDispatcher.AdPostionReportManager
 * JD-Core Version:    0.7.0.1
 */