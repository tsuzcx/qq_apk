package com.tencent.viola.ui.view.list;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.viola.utils.ViolaLogUtils;

class PagerSnapHelper$OnLayoutChangedListenerImpl
  implements View.OnLayoutChangeListener
{
  private PagerSnapHelper$OnLayoutChangedListenerImpl(PagerSnapHelper paramPagerSnapHelper) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    PagerSnapHelper.access$1300(this.this$0).removeOnLayoutChangeListener(this);
    if (PagerSnapHelper.access$200(this.this$0).getItemCount() > PagerSnapHelper.access$2400(this.this$0) + PagerSnapHelper.access$2500(this.this$0))
    {
      paramView = this.this$0;
      paramView = paramView.findCenterView(PagerSnapHelper.access$200(paramView));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onLayoutChange: centerView=");
      localStringBuilder.append(paramView);
      ViolaLogUtils.d("PagerSnapHelper", localStringBuilder.toString());
      if (!this.this$0.snapToTargetView(paramView)) {
        PagerSnapHelper.access$400(this.this$0, paramView, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.view.list.PagerSnapHelper.OnLayoutChangedListenerImpl
 * JD-Core Version:    0.7.0.1
 */