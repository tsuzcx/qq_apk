package com.tencent.mobileqq.vas.hippy.view;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.view.View;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.views.custom.HippyCustomPropsController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@HippyController(name="CustomProps")
public class HippyDTReportController
  extends HippyCustomPropsController
{
  private static final String TAG = "HippyDTReportController";
  
  public void dispatchFunction(View paramView, String paramString, HippyArray paramHippyArray)
  {
    if (("report_event".equals(paramString)) && (paramHippyArray.size() == 2)) {
      try
      {
        String str = (String)paramHippyArray.get(0);
        Object localObject2 = (HippyMap)paramHippyArray.get(1);
        localObject1 = new HashMap();
        if (((HippyMap)localObject2).size() > 0)
        {
          localObject2 = ((HippyMap)localObject2).entrySet().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
            ((HashMap)localObject1).put(localEntry.getKey(), localEntry.getValue());
          }
        }
        VideoReport.reportEvent(str, paramView, (Map)localObject1);
      }
      catch (Exception localException)
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("call report_event Exception :");
        ((StringBuilder)localObject1).append(localException);
        QLog.e("HippyDTReportController", 1, ((StringBuilder)localObject1).toString());
      }
    }
    super.dispatchFunction(paramView, paramString, paramHippyArray);
  }
  
  @HippyControllerProps(defaultType="string", name="dt_interactReportPolicy")
  public void setClickPolicy(@NonNull View paramView, String paramString)
  {
    try
    {
      VideoReport.setElementClickPolicy(paramView, ClickPolicy.valueOf(paramString));
      return;
    }
    catch (Exception localException)
    {
      label9:
      StringBuilder localStringBuilder;
      break label9;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("clickPolicy Invalid exception, view is");
    localStringBuilder.append(paramView);
    localStringBuilder.append(" clickPolicy:");
    localStringBuilder.append(paramString);
    QLog.e("HippyDTReportController", 1, localStringBuilder.toString());
  }
  
  @HippyControllerProps(defaultType="string", name="dt_elementId")
  public void setElementId(@NonNull View paramView, String paramString)
  {
    if (ViewCompat.isAttachedToWindow(paramView))
    {
      VideoReport.setElementId(paramView, paramString);
      return;
    }
    paramView.addOnAttachStateChangeListener(new HippyDTReportController.2(this, paramView, paramString));
  }
  
  @HippyControllerProps(defaultType="map", name="dt_elementParams")
  public void setElementParams(@NonNull View paramView, HippyMap paramHippyMap)
  {
    if (paramHippyMap == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    paramHippyMap = paramHippyMap.entrySet().iterator();
    while (paramHippyMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramHippyMap.next();
      localHashMap.put(localEntry.getKey(), localEntry.getValue());
    }
    VideoReport.setElementParams(paramView, localHashMap);
  }
  
  @HippyControllerProps(defaultType="string", name="dt_endExposureReportPolicy")
  public void setEndExposePolicy(@NonNull View paramView, String paramString)
  {
    try
    {
      VideoReport.setElementEndExposePolicy(paramView, EndExposurePolicy.valueOf(paramString));
      return;
    }
    catch (Exception localException)
    {
      label9:
      StringBuilder localStringBuilder;
      break label9;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("endExposePolicy Invalid exception, view is");
    localStringBuilder.append(paramView);
    localStringBuilder.append(" endExposePolicy:");
    localStringBuilder.append(paramString);
    QLog.e("HippyDTReportController", 1, localStringBuilder.toString());
  }
  
  @HippyControllerProps(defaultType="string", name="dt_exposureReportPolicy")
  public void setExposePolicy(@NonNull View paramView, String paramString)
  {
    try
    {
      VideoReport.setElementExposePolicy(paramView, ExposurePolicy.valueOf(paramString));
      return;
    }
    catch (Exception localException)
    {
      label9:
      StringBuilder localStringBuilder;
      break label9;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("exposePolicy Invalid exception, view is");
    localStringBuilder.append(paramView);
    localStringBuilder.append(" exposePolicy:");
    localStringBuilder.append(paramString);
    QLog.e("HippyDTReportController", 1, localStringBuilder.toString());
  }
  
  @HippyControllerProps(defaultType="boolean", name="dt_ignorePageInOutEvent")
  public void setIgnorePageInOutEvent(@NonNull View paramView, boolean paramBoolean)
  {
    VideoReport.ignorePageInOutEvent(paramView, paramBoolean);
  }
  
  @HippyControllerProps(defaultType="boolean", name="dt_pageBodyView")
  public void setMarkAsPageBodyView(@NonNull View paramView, boolean paramBoolean)
  {
    if (paramBoolean) {
      VideoReport.markAsPageBodyView(paramView);
    }
  }
  
  @HippyControllerProps(defaultType="string", name="dt_pageContentId")
  public void setPageContentId(@NonNull View paramView, String paramString)
  {
    VideoReport.setPageContentId(paramView, paramString);
  }
  
  @HippyControllerProps(defaultType="string", name="dt_pageId")
  public void setPageId(@NonNull View paramView, String paramString)
  {
    if (ViewCompat.isAttachedToWindow(paramView))
    {
      VideoReport.setPageId(paramView, paramString);
      return;
    }
    paramView.addOnAttachStateChangeListener(new HippyDTReportController.1(this, paramView, paramString));
  }
  
  @HippyControllerProps(defaultType="map", name="dt_pageParams")
  public void setPageParams(@NonNull View paramView, HippyMap paramHippyMap)
  {
    if (paramHippyMap != null)
    {
      if (paramHippyMap.size() <= 0) {
        return;
      }
      HashMap localHashMap = new HashMap();
      paramHippyMap = paramHippyMap.entrySet().iterator();
      while (paramHippyMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramHippyMap.next();
        localHashMap.put(localEntry.getKey(), localEntry.getValue());
      }
      if (ViewCompat.isAttachedToWindow(paramView))
      {
        VideoReport.setPageParams(paramView, new PageParams(localHashMap));
        return;
      }
      paramView.addOnAttachStateChangeListener(new HippyDTReportController.3(this, paramView, localHashMap));
    }
  }
  
  @HippyControllerProps(defaultType="number", name="dt_pageSearchMode")
  public void setPageSearchMode(@NonNull View paramView, int paramInt)
  {
    VideoReport.setPageSearchMode(paramView, paramInt);
  }
  
  @HippyControllerProps(defaultType="map", name="dt_publicParams")
  public void setPublicParams(@NonNull View paramView, HippyMap paramHippyMap)
  {
    if ((paramHippyMap != null) && (paramHippyMap.size() > 0))
    {
      paramView = new HashMap();
      paramHippyMap = paramHippyMap.entrySet().iterator();
      while (paramHippyMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramHippyMap.next();
        paramView.put(localEntry.getKey(), localEntry.getValue());
      }
      VideoReport.registerEventDynamicParams(new HippyDTReportController.4(this, paramView));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.hippy.view.HippyDTReportController
 * JD-Core Version:    0.7.0.1
 */