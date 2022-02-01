package com.tencent.timi.game.datareport.impl;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.timi.game.utils.Logger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TimiGameDataReportImpl
{
  private String a = "";
  
  public TimiGameDataReportImpl(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a("0S200MNJT807V3GE");
      VideoReport.addReporter(new TimiGameDataReportImpl.1(this));
    }
  }
  
  private Map<String, String> a(@NonNull Map<String, String> paramMap)
  {
    paramMap.put("dt_appkey", this.a);
    paramMap.put("is_online", String.valueOf(1));
    return paramMap;
  }
  
  public void a(@NonNull View paramView, boolean paramBoolean, @Nullable String paramString1, @NonNull String paramString2, @NonNull Map<String, String> paramMap)
  {
    try
    {
      a(paramMap);
      VideoReport.setElementId(paramView, paramString2);
      VideoReport.setElementExposePolicy(paramView, ExposurePolicy.REPORT_ALL);
      VideoReport.setElementEndExposePolicy(paramView, EndExposurePolicy.REPORT_ALL);
      VideoReport.setElementClickPolicy(paramView, ClickPolicy.REPORT_NONE);
      VideoReport.setElementParams(paramView, paramMap);
      if (paramString1 != null) {
        VideoReport.setElementReuseIdentifier(paramView, paramString1);
      }
      if (paramBoolean) {
        VideoReport.traverseExposure();
      }
      return;
    }
    finally {}
  }
  
  public void a(@NonNull View paramView, boolean paramBoolean1, @Nullable String paramString1, @NonNull String paramString2, @NonNull Map<String, String> paramMap, boolean paramBoolean2)
  {
    try
    {
      a(paramMap);
      VideoReport.setElementId(paramView, paramString2);
      if (paramBoolean2)
      {
        VideoReport.setElementExposePolicy(paramView, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementEndExposePolicy(paramView, EndExposurePolicy.REPORT_NONE);
      }
      else
      {
        VideoReport.setElementExposePolicy(paramView, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(paramView, EndExposurePolicy.REPORT_ALL);
      }
      VideoReport.setElementClickPolicy(paramView, ClickPolicy.REPORT_ALL);
      VideoReport.setElementParams(paramView, paramMap);
      if (paramString1 != null) {
        VideoReport.setElementReuseIdentifier(paramView, paramString1);
      }
      if (paramBoolean1) {
        VideoReport.traverseExposure();
      }
      return;
    }
    finally {}
  }
  
  public void a(@Nullable Object paramObject1, @NonNull Object paramObject2, @NonNull String paramString, Map<String, String> paramMap)
  {
    try
    {
      if (((paramObject1 instanceof Activity)) || ((paramObject1 instanceof Fragment)) || ((paramObject1 instanceof View)) || ((paramObject1 instanceof Dialog)))
      {
        if ((paramObject1 instanceof Fragment)) {
          VideoReport.addToDetectionWhitelist(((Fragment)paramObject1).getActivity());
        }
        if ((paramObject1 instanceof Activity)) {
          VideoReport.addToDetectionWhitelist((Activity)paramObject1);
        }
      }
      a(paramObject2, paramString, paramMap);
      return;
    }
    finally {}
  }
  
  public void a(@NonNull Object paramObject, @NonNull String paramString, Map<String, String> paramMap)
  {
    try
    {
      if ((!(paramObject instanceof Activity)) && (!(paramObject instanceof Fragment)) && (!(paramObject instanceof View)) && (!(paramObject instanceof Dialog)))
      {
        Logger.c("TimiGameDataReportImpl", "页面不是Activity Fragment或者View");
      }
      else
      {
        if ((paramObject instanceof Fragment)) {
          VideoReport.addToDetectionWhitelist(((Fragment)paramObject).getActivity());
        }
        if ((paramObject instanceof Activity)) {
          VideoReport.addToDetectionWhitelist((Activity)paramObject);
        }
        Object localObject = paramMap;
        if (paramMap == null) {
          localObject = new ConcurrentHashMap();
        }
        paramMap = new PageParams(a(new ConcurrentHashMap((Map)localObject)));
        VideoReport.setPageId(paramObject, paramString);
        VideoReport.setPageParams(paramObject, paramMap);
      }
      return;
    }
    finally {}
  }
  
  public void a(String paramString)
  {
    try
    {
      this.a = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(@NonNull String paramString, @NonNull Object paramObject, @NonNull Map<String, String> paramMap)
  {
    try
    {
      a(paramMap);
      VideoReport.reportEvent(paramString, paramObject, paramMap);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(@NonNull String paramString, @NonNull Map<String, String> paramMap)
  {
    try
    {
      a(paramMap);
      VideoReport.reportEvent(paramString, paramMap);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.datareport.impl.TimiGameDataReportImpl
 * JD-Core Version:    0.7.0.1
 */