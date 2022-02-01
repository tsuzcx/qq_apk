package com.tencent.mtt.hippy.views.hippylist;

import android.view.View;
import com.tencent.mtt.a.a.a.a.a;
import com.tencent.mtt.a.a.a.a.b;
import com.tencent.mtt.hippy.uimanager.HippyViewEvent;

class PullFooterEventHelper
  implements b
{
  public static final String EVENT_ON_END_REACHED = "onLoadMore";
  private a footerExposureHelper;
  private HippyViewEvent onEndReachedEvent;
  private final HippyRecyclerView recyclerView;
  
  PullFooterEventHelper(HippyRecyclerView paramHippyRecyclerView)
  {
    this.recyclerView = paramHippyRecyclerView;
  }
  
  public void disableFooter()
  {
    a locala = this.footerExposureHelper;
    if (locala != null)
    {
      this.recyclerView.removeOnScrollListener(locala);
      this.footerExposureHelper = null;
    }
  }
  
  public void enableFooter(View paramView)
  {
    disableFooter();
    this.footerExposureHelper = new a();
    this.footerExposureHelper.a(this);
    this.footerExposureHelper.a(paramView);
    this.recyclerView.addOnScrollListener(this.footerExposureHelper);
  }
  
  protected HippyViewEvent getOnEndReachedEvent()
  {
    if (this.onEndReachedEvent == null) {
      this.onEndReachedEvent = new HippyViewEvent("onLoadMore");
    }
    return this.onEndReachedEvent;
  }
  
  public void onFooterLoadMore()
  {
    getOnEndReachedEvent().send((View)this.recyclerView.getParent(), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.hippylist.PullFooterEventHelper
 * JD-Core Version:    0.7.0.1
 */