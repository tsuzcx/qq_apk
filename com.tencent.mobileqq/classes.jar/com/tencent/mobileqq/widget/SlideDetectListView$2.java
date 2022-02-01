package com.tencent.mobileqq.widget;

import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

class SlideDetectListView$2
  implements AbsListView.OnScrollListener
{
  SlideDetectListView$2(SlideDetectListView paramSlideDetectListView) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (SlideDetectListView.access$100(this.this$0) != null) {
      SlideDetectListView.access$100(this.this$0).onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    if (SlideDetectListView.access$200(this.this$0) != null) {
      SlideDetectListView.access$200(this.this$0).onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.this$0.mScrollState = paramInt;
    if (SlideDetectListView.access$100(this.this$0) != null) {
      SlideDetectListView.access$100(this.this$0).onScrollStateChanged(paramAbsListView, paramInt);
    }
    if (SlideDetectListView.access$200(this.this$0) != null) {
      SlideDetectListView.access$200(this.this$0).onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.SlideDetectListView.2
 * JD-Core Version:    0.7.0.1
 */