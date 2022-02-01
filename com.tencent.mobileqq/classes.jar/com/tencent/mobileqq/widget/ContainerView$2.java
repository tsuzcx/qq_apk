package com.tencent.mobileqq.widget;

import com.tencent.mobileqq.activity.selectable.AIOSelectableDelegateImpl;
import com.tencent.widget.ScrollView;
import com.tencent.widget.ScrollView.OnScrollStateChangedListener;

class ContainerView$2
  implements ScrollView.OnScrollStateChangedListener
{
  ContainerView$2(ContainerView paramContainerView) {}
  
  public void onScrollStateChanged(ScrollView paramScrollView, int paramInt, boolean paramBoolean)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
      } while ((paramBoolean) && (!ContainerView.b(this.a)));
      paramScrollView = AIOSelectableDelegateImpl.a();
      if ((paramScrollView.c()) && (!paramScrollView.a())) {
        paramScrollView.a();
      }
      ContainerView.b(this.a, false);
      return;
      ContainerView.b(this.a, true);
      paramScrollView = AIOSelectableDelegateImpl.a();
    } while ((!paramScrollView.c()) || (!paramScrollView.a()));
    paramScrollView.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ContainerView.2
 * JD-Core Version:    0.7.0.1
 */