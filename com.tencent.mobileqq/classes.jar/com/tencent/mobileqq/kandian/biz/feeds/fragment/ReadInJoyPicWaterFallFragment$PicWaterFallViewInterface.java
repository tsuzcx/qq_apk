package com.tencent.mobileqq.kandian.biz.feeds.fragment;

import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils.ExposureReportItem;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.report.BaseReportData;
import java.util.Map;
import java.util.Set;

public abstract interface ReadInJoyPicWaterFallFragment$PicWaterFallViewInterface
  extends ReadInJoyFragmentWithSubChannel.ReadInjoyViewInterface<AbsBaseArticleInfo>
{
  public abstract void a(Map<Long, BaseReportData> paramMap, boolean paramBoolean);
  
  public abstract void a(Map<Long, BaseReportData> paramMap, boolean paramBoolean, Map<Long, ReadinjoyReportUtils.ExposureReportItem> paramMap1, String paramString);
  
  public abstract void a(Set<Long> paramSet, Map<Long, BaseReportData> paramMap);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract void a(boolean paramBoolean, String paramString);
  
  public abstract void b(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoyPicWaterFallFragment.PicWaterFallViewInterface
 * JD-Core Version:    0.7.0.1
 */