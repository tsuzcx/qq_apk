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
    if (paramDataEntity == null) {
      return null;
    }
    return (View)paramDataEntity.get();
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
    View localView;
    do
    {
      localView = findParent(paramView, paramDataEntity);
      if (localView == null) {
        return null;
      }
      paramDataEntity = DataBinder.getDataEntity(localView);
      if (PathDataUtils.canCollect(paramDataEntity)) {
        return localView;
      }
      paramView = localView;
    } while (PageFinder.findRelatedPage(localView) == null);
    return localView;
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
    if (paramDataEntity == null) {
      return d;
    }
    return paramDataEntity.doubleValue();
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
    if (paramDataEntity == null) {
      return l;
    }
    return paramDataEntity.longValue();
  }
  
  @NonNull
  public static EndExposurePolicy getScrollEndExposePolicy(DataEntity paramDataEntity)
  {
    EndExposurePolicy localEndExposurePolicy = (EndExposurePolicy)DataEntityOperator.getInnerParam(paramDataEntity, "element_scroll_end_expose_policy");
    paramDataEntity = localEndExposurePolicy;
    if (localEndExposurePolicy == null) {
      paramDataEntity = VideoReportInner.getInstance().getConfiguration().getElementScrollEndExposePolicy();
    }
    return paramDataEntity;
  }
  
  @NonNull
  public static ExposurePolicy getScrollExposePolicy(DataEntity paramDataEntity)
  {
    ExposurePolicy localExposurePolicy = (ExposurePolicy)DataEntityOperator.getInnerParam(paramDataEntity, "element_scroll_expose_policy");
    paramDataEntity = localExposurePolicy;
    if (localExposurePolicy == null) {
      paramDataEntity = VideoReportInner.getInstance().getConfiguration().getElementScrollExposePolicy();
    }
    return paramDataEntity;
  }
  
  private static boolean handleReportFirstPolicy(Object paramObject, String paramString, View paramView, boolean paramBoolean)
  {
    paramObject = ExposurePolicyHelper.getEleExposeInfo(paramObject, paramView, paramString, paramBoolean);
    if (paramObject == null) {
      return true;
    }
    if (!paramObject.hasReport()) {
      return true;
    }
    return paramObject.reportOverTime();
  }
  
  static boolean isViewExposed(View paramView, double paramDouble)
  {
    boolean bool2 = false;
    if (paramView == null) {
      return false;
    }
    double d = getElementExposureMinRate(DataBinder.getDataEntity(paramView));
    boolean bool1 = bool2;
    if (paramDouble > 0.0D)
    {
      bool1 = bool2;
      if (paramDouble >= d) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean reportClick(@Nullable DataEntity paramDataEntity)
  {
    boolean bool2 = emptyElementId(paramDataEntity);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if (getClickPolicy(paramDataEntity) == ClickPolicy.REPORT_ALL) {
      bool1 = true;
    }
    return bool1;
  }
  
  public static boolean reportEndExposure(@Nullable View paramView, boolean paramBoolean)
  {
    paramView = DataBinder.getDataEntity(paramView);
    boolean bool2 = emptyElementId(paramView);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if (paramBoolean) {
      paramView = getScrollEndExposePolicy(paramView);
    } else {
      paramView = getEndExposePolicy(paramView);
    }
    paramBoolean = bool1;
    if (EndExposurePolicy.REPORT_ALL == paramView) {
      paramBoolean = true;
    }
    return paramBoolean;
  }
  
  static boolean reportExposure(Object paramObject, String paramString, View paramView)
  {
    return reportExposure(paramObject, paramString, paramView, false);
  }
  
  public static boolean reportExposure(Object paramObject, String paramString, View paramView, boolean paramBoolean)
  {
    Object localObject = DataBinder.getDataEntity(paramView);
    if (emptyElementId((DataEntity)localObject)) {
      return false;
    }
    if (paramBoolean) {
      localObject = getScrollExposePolicy((DataEntity)localObject);
    } else {
      localObject = getExposePolicy((DataEntity)localObject);
    }
    if (localObject == ExposurePolicy.REPORT_NONE) {
      return false;
    }
    if (localObject == ExposurePolicy.REPORT_ALL) {
      return true;
    }
    if (localObject == ExposurePolicy.REPORT_FIRST) {
      return handleReportFirstPolicy(paramObject, paramString, paramView, paramBoolean);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.element.ReportHelper
 * JD-Core Version:    0.7.0.1
 */