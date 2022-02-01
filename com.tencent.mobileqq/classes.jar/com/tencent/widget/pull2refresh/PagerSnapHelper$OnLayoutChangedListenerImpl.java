package com.tencent.widget.pull2refresh;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.qphone.base.util.QLog;

class PagerSnapHelper$OnLayoutChangedListenerImpl
  implements View.OnLayoutChangeListener
{
  private boolean b = false;
  
  private PagerSnapHelper$OnLayoutChangedListenerImpl(PagerSnapHelper paramPagerSnapHelper) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    PagerSnapHelper.b(this.a).removeOnLayoutChangeListener(this);
    if (PagerSnapHelper.a(this.a).getItemCount() > PagerSnapHelper.o(this.a) + PagerSnapHelper.p(this.a))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PagerSnapHelper", 2, "onLayoutChange: ");
      }
      paramView = this.a;
      paramView = paramView.a(PagerSnapHelper.a(paramView));
      if ((!this.a.a(paramView)) || (this.b)) {
        PagerSnapHelper.a(this.a, paramView, this.b);
      }
      this.b = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.pull2refresh.PagerSnapHelper.OnLayoutChangedListenerImpl
 * JD-Core Version:    0.7.0.1
 */