package com.tencent.mobileqq.widget;

import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

class SlideDetectListView$2
  implements AbsListView.OnScrollListener
{
  SlideDetectListView$2(SlideDetectListView paramSlideDetectListView) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (SlideDetectListView.b(this.a) != null) {
      SlideDetectListView.b(this.a).onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    if (SlideDetectListView.c(this.a) != null) {
      SlideDetectListView.c(this.a).onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    SlideDetectListView localSlideDetectListView = this.a;
    localSlideDetectListView.f = paramInt;
    if (SlideDetectListView.b(localSlideDetectListView) != null) {
      SlideDetectListView.b(this.a).onScrollStateChanged(paramAbsListView, paramInt);
    }
    if (SlideDetectListView.c(this.a) != null) {
      SlideDetectListView.c(this.a).onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.SlideDetectListView.2
 * JD-Core Version:    0.7.0.1
 */