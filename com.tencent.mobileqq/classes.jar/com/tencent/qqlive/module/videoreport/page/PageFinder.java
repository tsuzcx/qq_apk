package com.tencent.qqlive.module.videoreport.page;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import com.tencent.qqlive.module.videoreport.Log;
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
    if ((paramView == null) || (paramView.getRootView() == null)) {
      return null;
    }
    PageFinder.PageExposureCallback localPageExposureCallback = new PageFinder.PageExposureCallback(getPageViewAndParents(paramView.getRootView().getContext()), null);
    ExposureDetector.detect(paramView, false, null, localPageExposureCallback);
    SimpleTracer.end("PagePageFinder.findExposurePage");
    return localPageExposureCallback.targetPageInfo;
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
    if (paramPageInfo != null)
    {
      paramPageInfo = (Boolean)DataEntityOperator.getInnerParam(paramPageInfo, "page_report_ignore");
      if (VideoReportInner.getInstance().isDebugMode()) {
        Log.d("PageFinder", "isIgnorePageInOutEvent: ignoreReport=" + paramPageInfo);
      }
      return (paramPageInfo != null) && (paramPageInfo.booleanValue());
    }
    return false;
  }
  
  public static boolean isPage(Object paramObject)
  {
    if (paramObject == null) {}
    while (TextUtils.isEmpty(DataEntityOperator.getPageId(DataBinder.getDataEntity(paramObject)))) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.page.PageFinder
 * JD-Core Version:    0.7.0.1
 */