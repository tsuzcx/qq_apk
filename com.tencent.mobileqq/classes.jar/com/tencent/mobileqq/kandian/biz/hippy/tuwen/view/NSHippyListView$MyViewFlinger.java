package com.tencent.mobileqq.kandian.biz.hippy.tuwen.view;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.kandian.biz.hippy.tuwen.util.ReflectWrapper;
import com.tencent.mobileqq.kandian.biz.hippy.tuwen.util.TKDTuWenCommentUtil;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.LayoutManager;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.SmoothScroller;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.ViewFlinger;
import com.tencent.mtt.supportui.views.recyclerview.Scroller;

public class NSHippyListView$MyViewFlinger
  extends RecyclerViewBase.ViewFlinger
{
  public NSHippyListView$MyViewFlinger(NSHippyListView paramNSHippyListView)
  {
    super(paramNSHippyListView);
  }
  
  private void checkIfDoneScrolling(Scroller paramScroller, int paramInt1, int paramInt2)
  {
    int i = paramScroller.getCurrX();
    int j = paramScroller.getFinalX();
    int k = 0;
    if (i == j) {
      j = 1;
    } else {
      j = 0;
    }
    if (paramScroller.getCurrY() == paramScroller.getFinalY()) {
      i = 1;
    } else {
      i = 0;
    }
    if ((j == 0) && (paramInt1 == 0)) {
      paramInt1 = 0;
    } else {
      paramInt1 = 1;
    }
    if ((i == 0) && (paramInt2 == 0)) {
      paramInt2 = 0;
    } else {
      paramInt2 = 1;
    }
    if (!paramScroller.isFinished())
    {
      i = k;
      if (paramInt1 != 0)
      {
        i = k;
        if (paramInt2 == 0) {}
      }
    }
    else
    {
      i = 1;
    }
    if (i != 0) {
      paramScroller.forceFinished(true);
    }
  }
  
  private void doScroll(Scroller paramScroller, RecyclerViewBase.SmoothScroller paramSmoothScroller)
  {
    int j = paramScroller.getCurrX();
    int k = paramScroller.getCurrY();
    int m = j - getInt("mLastFlingX");
    int i = k - getInt("mLastFlingY");
    setFieldValue0("mLastFlingX", Integer.valueOf(j));
    setFieldValue0("mLastFlingY", Integer.valueOf(k));
    NSHippyListView.access$800(this.this$0)[0] = 0;
    NSHippyListView.access$800(this.this$0)[1] = 0;
    NSHippyListView localNSHippyListView = this.this$0;
    localNSHippyListView.dispatchNestedPreScroll(m, i, NSHippyListView.access$800(localNSHippyListView), null, 1);
    m -= NSHippyListView.access$800(this.this$0)[0];
    k = i - NSHippyListView.access$800(this.this$0)[1];
    if (this.this$0.mAdapter != null)
    {
      NSHippyListView.access$800(this.this$0)[0] = 0;
      NSHippyListView.access$800(this.this$0)[1] = 0;
      NSHippyListView.access$900(this.this$0)[0] = m;
      NSHippyListView.access$900(this.this$0)[1] = k;
      scrollStep0(m, k, reflectCareSpringBackMaxDistance(), paramScroller, paramSmoothScroller, NSHippyListView.access$800(this.this$0), NSHippyListView.access$900(this.this$0));
      i = NSHippyListView.access$800(this.this$0)[0];
      j = NSHippyListView.access$800(this.this$0)[1];
      m -= i;
      k -= j;
    }
    else
    {
      i = 0;
      j = 0;
    }
    this.this$0.reflectInvalidateDecorations();
    NSHippyListView.access$800(this.this$0)[0] = 0;
    NSHippyListView.access$800(this.this$0)[1] = 0;
    paramSmoothScroller = this.this$0;
    paramSmoothScroller.dispatchNestedScroll(i, j, m, k, null, 1, NSHippyListView.access$800(paramSmoothScroller));
    m -= NSHippyListView.access$800(this.this$0)[0];
    k -= NSHippyListView.access$800(this.this$0)[1];
    if (!TKDTuWenCommentUtil.isAllZero(new double[] { i, j }))
    {
      NSHippyListView.access$1000(this.this$0);
      this.this$0.reflectNotifyScrollListener(m, k);
    }
    this.this$0.invalidate();
    if (k < 0) {
      checkIfDoneScrolling(paramScroller, m, k);
    }
  }
  
  @Nullable
  private <T> T getFieldValue0(String paramString)
  {
    return NSHippyListView.access$500(this.this$0).getFieldValue(this, paramString);
  }
  
  private int getInt(String paramString)
  {
    paramString = (Integer)getFieldValue0(paramString);
    if (paramString == null) {
      return 0;
    }
    return paramString.intValue();
  }
  
  private boolean reflectCareSpringBackMaxDistance()
  {
    Boolean localBoolean = (Boolean)getFieldValue0("mCareSpringBackMaxDistance");
    return (localBoolean != null) && (localBoolean.booleanValue());
  }
  
  private void reflectOnAnimation(RecyclerViewBase.SmoothScroller paramSmoothScroller, int paramInt1, int paramInt2)
  {
    if ((paramSmoothScroller != null) && (!paramSmoothScroller.isPendingInitialRun()) && (paramSmoothScroller.isRunning())) {
      NSHippyListView.access$500(this.this$0).invokeMethodWithPrimaryType(paramSmoothScroller, "onAnimation", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    }
  }
  
  private void reflectReportFinishState()
  {
    NSHippyListView.access$500(this.this$0).invokeMethodWithPrimaryType(this, "reportFinishState", new Object[0]);
  }
  
  private void scrollStep0(int paramInt1, int paramInt2, boolean paramBoolean, Scroller paramScroller, RecyclerViewBase.SmoothScroller paramSmoothScroller, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    NSHippyListView.access$1100(this.this$0);
    if (!TKDTuWenCommentUtil.isAllZero(new double[] { paramInt1, paramInt2 }))
    {
      paramScroller = NSHippyListView.access$1200(this.this$0, paramInt1, paramInt2, paramBoolean, paramScroller, false);
      paramInt2 = paramScroller[0];
      paramInt1 = paramScroller[1];
      paramArrayOfInt1[0] = this.this$0.mLayout.scrollHorizontallyBy(paramInt2, NSHippyListView.access$1300(this.this$0), this.this$0.mState);
      paramArrayOfInt1[1] = this.this$0.mLayout.scrollVerticallyBy(paramInt1, NSHippyListView.access$1400(this.this$0), this.this$0.mState);
      paramArrayOfInt2[0] -= paramArrayOfInt1[0];
      paramArrayOfInt2[1] -= paramArrayOfInt1[1];
      paramInt2 -= paramArrayOfInt1[0];
      paramInt1 -= paramArrayOfInt1[1];
    }
    else
    {
      paramInt1 = 0;
      paramInt2 = 0;
    }
    reflectOnAnimation(paramSmoothScroller, paramArrayOfInt2[0] - paramInt2, paramArrayOfInt2[1] - paramInt1);
    NSHippyListView.access$1500(this.this$0, false);
  }
  
  private void setFieldValue0(String paramString, Object paramObject)
  {
    NSHippyListView.access$500(this.this$0).setFieldValue(this, paramString, paramObject);
  }
  
  public void run()
  {
    NSHippyListView.access$400(this.this$0);
    Scroller localScroller = getScroller();
    RecyclerViewBase.SmoothScroller localSmoothScroller = this.this$0.mLayout.mSmoothScroller;
    if (localScroller.computeScrollOffset()) {
      doScroll(localScroller, localSmoothScroller);
    }
    if ((localSmoothScroller != null) && (localSmoothScroller.isPendingInitialRun())) {
      NSHippyListView.access$500(this.this$0).invokeMethodWithPrimaryType(localSmoothScroller, "onAnimation", new Object[] { Integer.valueOf(0), Integer.valueOf(0) });
    }
    if (localScroller.isFinished())
    {
      reflectReportFinishState();
      NSHippyListView.access$600(this.this$0);
      this.this$0.reflectSetScrollState(0);
      NSHippyListView.access$700(this.this$0, localScroller.isFling() ^ true, false);
      this.this$0.reflectResetStopAtTitle();
      this.this$0.stopNestedScroll(1);
      return;
    }
    postOnAnimation();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.hippy.tuwen.view.NSHippyListView.MyViewFlinger
 * JD-Core Version:    0.7.0.1
 */