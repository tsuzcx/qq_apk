package com.tencent.mobileqq.kandian.biz.hippy.tuwen.subcomment;

import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.kandian.biz.hippy.api.ParamsFetcher;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.receiver.common.TKDHippy2NativeEventSimpleReceiver;
import com.tencent.mobileqq.kandian.biz.hippy.tuwen.util.TKDTuWenCommentUtil;
import com.tencent.mtt.hippy.views.list.HippyListView;
import org.jetbrains.annotations.NotNull;

class TKDTuWenSubCommentFragment$MyHippyCommentEventListener
  extends TKDHippy2NativeEventSimpleReceiver
{
  private TKDTuWenSubCommentFragment$MyHippyCommentEventListener(TKDTuWenSubCommentFragment paramTKDTuWenSubCommentFragment) {}
  
  private void doExposureReport()
  {
    if (TKDTuWenSubCommentFragment.access$500(this.this$0) != null)
    {
      HippyListView localHippyListView = (HippyListView)TKDTuWenCommentUtil.rFindView(TKDTuWenSubCommentFragment.access$600(this.this$0).getHippyRootView(), HippyListView.class);
      if (localHippyListView != null)
      {
        int i = localHippyListView.getScrollState();
        localHippyListView.onScrollStateChanged(i, i);
      }
    }
  }
  
  private void removeReportThrottle()
  {
    Object localObject = (HippyListView)TKDTuWenCommentUtil.rFindView(TKDTuWenSubCommentFragment.access$400(this.this$0).getHippyRootView(), HippyListView.class);
    if (localObject != null)
    {
      localObject = ((HippyListView)localObject).getAdapter();
      if ((localObject instanceof HippyTKDListViewAdapter))
      {
        localObject = (HippyTKDListViewAdapter)localObject;
        ((HippyTKDListViewAdapter)localObject).setScrollEventThrottle(0);
        ((HippyTKDListViewAdapter)localObject).setScrollForReportThrottle(0);
      }
    }
  }
  
  public void biuComment(@NotNull ParamsFetcher paramParamsFetcher)
  {
    paramParamsFetcher.onGetParams(TKDTuWenSubCommentFragment.access$100(this.this$0), TKDTuWenSubCommentFragment.access$200(this.this$0), TKDTuWenSubCommentFragment.access$300(this.this$0), "");
  }
  
  public void onCommentViewLayout()
  {
    doExposureReport();
    removeReportThrottle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.hippy.tuwen.subcomment.TKDTuWenSubCommentFragment.MyHippyCommentEventListener
 * JD-Core Version:    0.7.0.1
 */