package com.tencent.mobileqq.kandian.biz.hippy.tuwen.adapter;

import android.os.Looper;
import android.os.MessageQueue;
import com.tencent.mobileqq.kandian.biz.hippy.api.ParamsFetcher;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.receiver.common.TKDHippy2NativeEventSimpleReceiver;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.receiver.tuwen.ITKDHippy2TuWenEventReceiver;
import com.tencent.mobileqq.kandian.biz.hippy.tuwen.util.TKDTuWenCommentUtil;
import com.tencent.mobileqq.kandian.biz.hippy.tuwen.view.HippyRootLayout;
import com.tencent.mobileqq.kandian.biz.hippy.tuwen.view.NSHippyListView;
import com.tencent.mobileqq.kandian.biz.hippy.tuwen.view.NSRIJCommentListView;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;

class TKDTuWenHippyCommentAdapter$HippyCommentEventReceiver
  extends TKDHippy2NativeEventSimpleReceiver
  implements ITKDHippy2TuWenEventReceiver
{
  private TKDTuWenHippyCommentAdapter$HippyCommentEventReceiver(TKDTuWenHippyCommentAdapter paramTKDTuWenHippyCommentAdapter) {}
  
  private void doExposureReport()
  {
    if (TKDTuWenHippyCommentAdapter.access$900(this.this$0) != null)
    {
      int i = TKDTuWenHippyCommentAdapter.access$900(this.this$0).getScrollState();
      TKDTuWenHippyCommentAdapter.access$900(this.this$0).onScrollStateChanged(i, i);
    }
  }
  
  public void biuComment(@NotNull ParamsFetcher paramParamsFetcher)
  {
    paramParamsFetcher.onGetParams(this.this$0.mArticleInfo, TKDTuWenHippyCommentAdapter.access$600(this.this$0), TKDTuWenHippyCommentAdapter.access$700(this.this$0), "");
  }
  
  public void forbidScroll(boolean paramBoolean)
  {
    if ((this.this$0.vList instanceof NSRIJCommentListView)) {
      ((NSRIJCommentListView)this.this$0.vList).setForbidScroll(paramBoolean);
    }
  }
  
  public void onCommentNumChanged(long paramLong)
  {
    if (TKDTuWenHippyCommentAdapter.access$500(this.this$0) != null) {
      TKDTuWenHippyCommentAdapter.access$500(this.this$0).onCommentNumChanged(paramLong);
    }
  }
  
  public void onCommentViewLayout()
  {
    if (TKDTuWenHippyCommentAdapter.access$900(this.this$0) == null)
    {
      TKDTuWenHippyCommentAdapter localTKDTuWenHippyCommentAdapter = this.this$0;
      TKDTuWenHippyCommentAdapter.access$902(localTKDTuWenHippyCommentAdapter, (NSHippyListView)TKDTuWenCommentUtil.rFindView(TKDTuWenHippyCommentAdapter.access$800(localTKDTuWenHippyCommentAdapter), NSHippyListView.class, true));
      if ((TKDTuWenHippyCommentAdapter.access$900(this.this$0) != null) && (TKDTuWenHippyCommentAdapter.access$1000(this.this$0) != null)) {
        TKDTuWenHippyCommentAdapter.access$900(this.this$0).addOnListScrollListener(TKDTuWenHippyCommentAdapter.access$1000(this.this$0));
      }
    }
    doExposureReport();
  }
  
  public void onHippyForbiddenChanged(int paramInt)
  {
    if (TKDTuWenHippyCommentAdapter.access$500(this.this$0) == null) {
      return;
    }
    TKDTuWenHippyCommentAdapter.access$500(this.this$0).onHippyForbiddenChanged(paramInt);
  }
  
  public void onHippyLoadStatusChanged(int paramInt)
  {
    if ((TKDTuWenHippyCommentAdapter.access$800(this.this$0) != null) && ((this.this$0.vList instanceof NSRIJCommentListView)))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onHippyLoadStatusChanged: status=");
      localStringBuilder.append(paramInt);
      QLog.d("TKDTuWenHippyCommentAdapter", 1, localStringBuilder.toString());
      TKDTuWenHippyCommentAdapter.access$800(this.this$0).setStatus(paramInt);
      if (paramInt == 1) {
        doExposureReport();
      }
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onHippyLoadStatusChanged: vContainer is null, status=");
    localStringBuilder.append(paramInt);
    QLog.d("TKDTuWenHippyCommentAdapter", 1, localStringBuilder.toString());
  }
  
  public void openSubCommentPage(String paramString1, String paramString2)
  {
    TKDTuWenHippyCommentAdapter.access$500(this.this$0).openSubCommentPage(paramString1, paramString2);
  }
  
  public void scrollToNew()
  {
    Looper.myQueue().addIdleHandler(new TKDTuWenHippyCommentAdapter.HippyCommentEventReceiver.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.hippy.tuwen.adapter.TKDTuWenHippyCommentAdapter.HippyCommentEventReceiver
 * JD-Core Version:    0.7.0.1
 */