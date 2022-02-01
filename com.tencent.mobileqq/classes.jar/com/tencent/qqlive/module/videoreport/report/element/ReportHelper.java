package com.tencent.qqlive.module.videoreport.report.element;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import com.tencent.qqlive.module.videoreport.Configuration;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
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
  
  @NonNull
  public static ClickPolicy getClickPolicy(DataEntity paramDataEntity)
  {
    ClickPolicy localClickPolicy = (ClickPolicy)DataEntityOperator.getInnerParam(paramDataEntity, "element_click_policy");
    paramDataEntity = localClickPolicy;
    if (localClickPolicy == null) {
      paramDataEntity = VideoReportInner.getInstance().getConfiguration().getElementClickPolicy();
    }
    return paramDataEntity;
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
  
  @NonNull
  public static EndExposurePolicy getEndExposePolicy(DataEntity paramDataEntity)
  {
    EndExposurePolicy localEndExposurePolicy = (EndExposurePolicy)DataEntityOperator.getInnerParam(paramDataEntity, "element_end_expose_policy");
    paramDataEntity = localEndExposurePolicy;
    if (localEndExposurePolicy == null) {
      paramDataEntity = VideoReportInner.getInstance().getConfiguration().getElementEndExposePolicy();
    }
    return paramDataEntity;
  }
  
  @NonNull
  public static ExposurePolicy getExposePolicy(DataEntity paramDataEntity)
  {
    ExposurePolicy localExposurePolicy = (ExposurePolicy)DataEntityOperator.getInnerParam(paramDataEntity, "element_expose_policy");
    paramDataEntity = localExposurePolicy;
    if (localExposurePolicy == null) {
      paramDataEntity = VideoReportInner.getInstance().getConfiguration().getElementExposePolicy();
    }
    return paramDataEntity;
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
  
  private static boolean handleReportFirstPolicy(Object paramObject, String paramString, View paramView)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return true;
      paramObject = ExposurePolicyHelper.getEleExposeInfo(paramObject, paramView, paramString);
    } while ((paramObject == null) || (!paramObject.hasReport()));
    return paramObject.reportOverTime();
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
    if (emptyElementId(paramDataEntity)) {}
    while (getClickPolicy(paramDataEntity) != ClickPolicy.REPORT_ALL) {
      return false;
    }
    return true;
  }
  
  static boolean reportEndExposure(@Nullable View paramView)
  {
    paramView = DataBinder.getDataEntity(paramView);
    if (emptyElementId(paramView)) {}
    while (EndExposurePolicy.REPORT_ALL != getEndExposePolicy(paramView)) {
      return false;
    }
    return true;
  }
  
  static boolean reportExposure(Object paramObject, String paramString, View paramView)
  {
    Object localObject = DataBinder.getDataEntity(paramView);
    if (emptyElementId((DataEntity)localObject)) {}
    do
    {
      do
      {
        return false;
        localObject = getExposePolicy((DataEntity)localObject);
      } while (localObject == ExposurePolicy.REPORT_NONE);
      if (localObject == ExposurePolicy.REPORT_ALL) {
        return true;
      }
    } while (localObject != ExposurePolicy.REPORT_FIRST);
    return handleReportFirstPolicy(paramObject, paramString, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.element.ReportHelper
 * JD-Core Version:    0.7.0.1
 */