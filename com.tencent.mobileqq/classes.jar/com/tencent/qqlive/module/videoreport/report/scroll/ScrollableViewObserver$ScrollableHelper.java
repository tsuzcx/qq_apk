package com.tencent.qqlive.module.videoreport.report.scroll;

import android.view.View;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.page.PageSwitchObserver;

class ScrollableViewObserver$ScrollableHelper
  extends ScrollStateObserver
{
  protected void onIdle(View paramView)
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onIdle: source=");
      localStringBuilder.append(paramView);
      Log.d("ScrollableViewObserver", localStringBuilder.toString());
    }
    PageSwitchObserver.getInstance().onPageViewVisible(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.scroll.ScrollableViewObserver.ScrollableHelper
 * JD-Core Version:    0.7.0.1
 */