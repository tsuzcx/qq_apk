package com.tencent.qqlive.module.videoreport.page;

import android.view.View;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import java.util.Map;
import java.util.WeakHashMap;

public class PageBodyStatistician
{
  private static final String TAG = "PageBodyStatistician";
  private Map<View, PageBodyStatistician.BodyInfoHandler> mHandlerMap = new WeakHashMap();
  
  public static PageBodyStatistician getInstance()
  {
    return PageBodyStatistician.InstanceHolder.INSTANCE;
  }
  
  public void markAsPageBodyView(View paramView, IScrollReader paramIScrollReader)
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("markAsPageBodyView: view = ");
      localStringBuilder.append(paramView);
      localStringBuilder.append(", scrollReader = ");
      localStringBuilder.append(paramIScrollReader);
      Log.d("PageBodyStatistician", localStringBuilder.toString());
    }
    if (paramView != null)
    {
      if (this.mHandlerMap.containsKey(paramView)) {
        return;
      }
      paramIScrollReader = new PageBodyStatistician.BodyInfoHandler(paramView, paramIScrollReader);
      this.mHandlerMap.put(paramView, paramIScrollReader);
    }
  }
  
  public void setPageBodyContentRange(View paramView, int paramInt1, int paramInt2)
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setPageBodyContentRange: rangeStart = ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", rangeEnd = ");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(", view = ");
      ((StringBuilder)localObject).append(paramView);
      Log.d("PageBodyStatistician", ((StringBuilder)localObject).toString());
    }
    if (paramView == null) {
      return;
    }
    Object localObject = (PageBodyStatistician.BodyInfoHandler)this.mHandlerMap.get(paramView);
    if (localObject != null)
    {
      ((PageBodyStatistician.BodyInfoHandler)localObject).updateRange(paramInt1, paramInt2);
      return;
    }
    if (VideoReportInner.getInstance().isDebugMode())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("please mark view as page body first, view = ");
      ((StringBuilder)localObject).append(paramView);
      Log.d("PageBodyStatistician", ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.page.PageBodyStatistician
 * JD-Core Version:    0.7.0.1
 */