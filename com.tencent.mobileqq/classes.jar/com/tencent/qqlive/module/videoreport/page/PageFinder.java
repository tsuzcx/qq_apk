package com.tencent.qqlive.module.videoreport.page;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import com.tencent.qqlive.module.videoreport.Configuration;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.data.DataBinder;
import com.tencent.qqlive.module.videoreport.data.DataEntityOperator;
import com.tencent.qqlive.module.videoreport.exposure.ExposureDetector;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.trace.SimpleTracer;
import com.tencent.qqlive.module.videoreport.utils.BaseUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class PageFinder
{
  private static final String TAG = "PageFinder";
  
  static PageInfo findExposurePage(View paramView)
  {
    SimpleTracer.begin("PagePageFinder.findExposurePage");
    if (paramView != null)
    {
      if (paramView.getRootView() == null) {
        return null;
      }
      PageFinder.PageExposureCallback localPageExposureCallback = new PageFinder.PageExposureCallback(getPageViewAndParents(paramView.getRootView().getContext()), null);
      ExposureDetector.detect(paramView, false, null, localPageExposureCallback);
      SimpleTracer.end("PagePageFinder.findExposurePage");
      printPageLink(localPageExposureCallback.targetPageInfo);
      return localPageExposureCallback.targetPageInfo;
    }
    return null;
  }
  
  public static PageInfo findOwnerPage(View paramView)
  {
    while ((paramView instanceof View))
    {
      paramView = (View)paramView;
      PageInfo localPageInfo = findRelatedPage(paramView);
      if (localPageInfo != null) {
        return localPageInfo;
      }
      paramView = paramView.getParent();
    }
    return null;
  }
  
  public static PageInfo findRelatedPage(View paramView)
  {
    if (isPage(paramView)) {
      return new PageInfo(paramView, paramView);
    }
    Object localObject = ViewContainerBinder.getInstance().getBoundContainer(paramView);
    if (isPage(localObject)) {
      return new PageInfo(localObject, paramView);
    }
    return null;
  }
  
  private static View getDecorView(Window paramWindow)
  {
    if (paramWindow == null) {
      return null;
    }
    return paramWindow.getDecorView();
  }
  
  public static View getPageView(Object paramObject)
  {
    if (!isPage(paramObject)) {
      return null;
    }
    if ((paramObject instanceof Activity)) {
      return getDecorView(((Activity)paramObject).getWindow());
    }
    if ((paramObject instanceof Dialog)) {
      return getDecorView(((Dialog)paramObject).getWindow());
    }
    if ((paramObject instanceof View)) {
      return (View)paramObject;
    }
    return null;
  }
  
  private static Set<View> getPageViewAndParents(@NonNull Context paramContext)
  {
    paramContext = VideoReportInner.getInstance().getPageCache(paramContext);
    if (BaseUtils.isEmpty(paramContext)) {
      return null;
    }
    HashSet localHashSet = new HashSet();
    Iterator localIterator = paramContext.iterator();
    while (localIterator.hasNext())
    {
      paramContext = (View)localIterator.next();
      if (paramContext != null)
      {
        localHashSet.add(paramContext);
        for (paramContext = paramContext.getParent(); (paramContext instanceof View); paramContext = paramContext.getParent()) {
          localHashSet.add((View)paramContext);
        }
      }
    }
    return localHashSet;
  }
  
  public static boolean isIgnorePageInOutEvent(PageInfo paramPageInfo)
  {
    paramPageInfo = DataBinder.getDataEntity(paramPageInfo.getPage());
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramPageInfo != null)
    {
      paramPageInfo = (Boolean)DataEntityOperator.getInnerParam(paramPageInfo, "page_report_ignore");
      if (VideoReportInner.getInstance().isDebugMode())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isIgnorePageInOutEvent: ignoreReport=");
        localStringBuilder.append(paramPageInfo);
        Log.d("PageFinder", localStringBuilder.toString());
      }
      bool1 = bool2;
      if (paramPageInfo != null)
      {
        bool1 = bool2;
        if (paramPageInfo.booleanValue()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean isPage(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    return TextUtils.isEmpty(DataEntityOperator.getPageId(DataBinder.getDataEntity(paramObject))) ^ true;
  }
  
  private static boolean isTerminatePage(@NonNull PageInfo paramPageInfo)
  {
    if (!VideoReportInner.getInstance().getConfiguration().isEnablePageLink()) {
      return true;
    }
    Integer localInteger2 = VideoReportInner.getInstance().getPageSearchMode(paramPageInfo.getPage());
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null) {
      localInteger1 = VideoReportInner.getInstance().getPageSearchMode(paramPageInfo.getPageView());
    }
    return (localInteger1 != null) && (1 == localInteger1.intValue());
  }
  
  private static void printPageLink(PageInfo paramPageInfo)
  {
    if (paramPageInfo == null) {
      return;
    }
    if (VideoReport.isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PageLink —— ");
      localStringBuilder.append(paramPageInfo);
      Log.i("PageFinder", localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.page.PageFinder
 * JD-Core Version:    0.7.0.1
 */