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
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.d("PageBodyStatistician", "markAsPageBodyView: view = " + paramView + ", scrollReader = " + paramIScrollReader);
    }
    if ((paramView == null) || (this.mHandlerMap.containsKey(paramView))) {
      return;
    }
    paramIScrollReader = new PageBodyStatistician.BodyInfoHandler(paramView, paramIScrollReader);
    this.mHandlerMap.put(paramView, paramIScrollReader);
  }
  
  public void setPageBodyContentRange(View paramView, int paramInt1, int paramInt2)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.d("PageBodyStatistician", "setPageBodyContentRange: rangeStart = " + paramInt1 + ", rangeEnd = " + paramInt2 + ", view = " + paramView);
    }
    if (paramView == null) {}
    do
    {
      return;
      PageBodyStatistician.BodyInfoHandler localBodyInfoHandler = (PageBodyStatistician.BodyInfoHandler)this.mHandlerMap.get(paramView);
      if (localBodyInfoHandler != null)
      {
        localBodyInfoHandler.updateRange(paramInt1, paramInt2);
        return;
      }
    } while (!VideoReportInner.getInstance().isDebugMode());
    Log.d("PageBodyStatistician", "please mark view as page body first, view = " + paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.page.PageBodyStatistician
 * JD-Core Version:    0.7.0.1
 */