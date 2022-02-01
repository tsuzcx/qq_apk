package com.tencent.qqlive.module.videoreport.report.element;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import com.tencent.qqlive.module.videoreport.Configuration;
import com.tencent.qqlive.module.videoreport.constants.ReportPolicy;
import com.tencent.qqlive.module.videoreport.data.DataBinder;
import com.tencent.qqlive.module.videoreport.data.DataEntity;
import com.tencent.qqlive.module.videoreport.data.DataEntityOperator;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.page.PageFinder;
import com.tencent.qqlive.module.videoreport.reportdata.PathDataUtils;
import java.lang.ref.WeakReference;

public class ReportHelper
{
  private static boolean emptyElementId(@Nullable DataEntity paramDataEntity)
  {
    return (paramDataEntity == null) || (TextUtils.isEmpty(DataEntityOperator.getElementId(paramDataEntity)));
  }
  
  private static View findLogicParent(DataEntity paramDataEntity)
  {
    if (paramDataEntity == null) {
      return null;
    }
    paramDataEntity = (WeakReference)DataEntityOperator.getInnerParam(paramDataEntity, "logic_parent");
    if (paramDataEntity == null) {}
    for (paramDataEntity = null;; paramDataEntity = (View)paramDataEntity.get()) {
      return paramDataEntity;
    }
  }
  
  static View findParent(View paramView, DataEntity paramDataEntity)
  {
    paramDataEntity = findLogicParent(paramDataEntity);
    if (paramDataEntity != null) {
      return paramDataEntity;
    }
    paramView = paramView.getParent();
    if ((paramView instanceof View)) {
      return (View)paramView;
    }
    return null;
  }
  
  static View findPathParent(View paramView, DataEntity paramDataEntity)
  {
    DataEntity localDataEntity = paramDataEntity;
    paramDataEntity = paramView;
    do
    {
      paramView = findParent(paramDataEntity, localDataEntity);
      if (paramView == null) {
        paramDataEntity = null;
      }
      do
      {
        return paramDataEntity;
        localDataEntity = DataBinder.getDataEntity(paramView);
        paramDataEntity = paramView;
      } while (PathDataUtils.canCollect(localDataEntity));
      paramDataEntity = paramView;
    } while (PageFinder.findRelatedPage(paramView) == null);
    return paramView;
  }
  
  private static double getElementExposureMinRate(@Nullable DataEntity paramDataEntity)
  {
    double d = VideoReportInner.getInstance().getConfiguration().getElementExposureMinRate();
    if (paramDataEntity == null) {
      return d;
    }
    paramDataEntity = (Double)DataEntityOperator.getInnerParam(paramDataEntity, "element_exposure_min_rate");
    if (paramDataEntity == null) {}
    for (;;)
    {
      return d;
      d = paramDataEntity.doubleValue();
    }
  }
  
  static long getExposureMinTime(@Nullable DataEntity paramDataEntity)
  {
    long l = VideoReportInner.getInstance().getConfiguration().getElementExposureMinTime();
    if (paramDataEntity == null) {
      return l;
    }
    paramDataEntity = (Long)DataEntityOperator.getInnerParam(paramDataEntity, "element_exposure_min_time");
    if (paramDataEntity == null) {}
    for (;;)
    {
      return l;
      l = paramDataEntity.longValue();
    }
  }
  
  @NonNull
  private static ReportPolicy getReportPolicy(DataEntity paramDataEntity)
  {
    Object localObject = (ReportPolicy)DataEntityOperator.getInnerParam(paramDataEntity, "element_report_policy");
    paramDataEntity = (DataEntity)localObject;
    if (localObject == null) {
      paramDataEntity = VideoReportInner.getInstance().getConfiguration().getElementReportPolicy();
    }
    localObject = paramDataEntity;
    if (paramDataEntity == null) {
      localObject = ReportPolicy.REPORT_POLICY_ALL;
    }
    return localObject;
  }
  
  static boolean isViewExposed(View paramView, double paramDouble)
  {
    if (paramView == null) {}
    double d;
    do
    {
      return false;
      d = getElementExposureMinRate(DataBinder.getDataEntity(paramView));
    } while ((paramDouble <= 0.0D) || (paramDouble < d));
    return true;
  }
  
  static boolean reportClick(@Nullable DataEntity paramDataEntity)
  {
    if (emptyElementId(paramDataEntity)) {
      return false;
    }
    return getReportPolicy(paramDataEntity).reportClick;
  }
  
  static boolean reportExposure(@Nullable DataEntity paramDataEntity)
  {
    if (emptyElementId(paramDataEntity)) {
      return false;
    }
    return getReportPolicy(paramDataEntity).reportExposure;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.element.ReportHelper
 * JD-Core Version:    0.7.0.1
 */