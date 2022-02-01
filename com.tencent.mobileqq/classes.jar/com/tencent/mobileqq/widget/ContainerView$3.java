package com.tencent.mobileqq.widget;

import com.tencent.mobileqq.activity.selectable.AIOSelectableDelegateImpl;
import com.tencent.widget.ScrollView;
import com.tencent.widget.ScrollView.OnScrollStateChangedListener;

class ContainerView$3
  implements ScrollView.OnScrollStateChangedListener
{
  ContainerView$3(ContainerView paramContainerView) {}
  
  public void onScrollStateChanged(ScrollView paramScrollView, int paramInt, boolean paramBoolean)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return;
        }
        ContainerView.b(this.a, true);
      }
      paramScrollView = AIOSelectableDelegateImpl.a();
      if ((paramScrollView.l()) && (paramScrollView.i())) {
        paramScrollView.j();
      }
    }
    else if ((!paramBoolean) || (ContainerView.c(this.a)))
    {
      paramScrollView = AIOSelectableDelegateImpl.a();
      if ((paramScrollView.l()) && (!paramScrollView.i())) {
        paramScrollView.h();
      }
      ContainerView.b(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ContainerView.3
 * JD-Core Version:    0.7.0.1
 */