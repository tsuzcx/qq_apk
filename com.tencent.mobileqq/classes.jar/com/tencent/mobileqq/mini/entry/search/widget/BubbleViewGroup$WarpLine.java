package com.tencent.mobileqq.mini.entry.search.widget;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

class BubbleViewGroup$WarpLine
{
  private List<View> bubbleViews = new ArrayList();
  private int height;
  private int lineWidth = this.this$0.getPaddingLeft() + this.this$0.getPaddingRight();
  
  private BubbleViewGroup$WarpLine(BubbleViewGroup paramBubbleViewGroup) {}
  
  private void addView(View paramView)
  {
    if (this.bubbleViews.size() != 0) {
      this.lineWidth += BubbleViewGroup.HORIZONTAL_SPACE;
    }
    if (this.height > paramView.getMeasuredHeight()) {}
    for (int i = this.height;; i = paramView.getMeasuredHeight())
    {
      this.height = i;
      this.lineWidth += paramView.getMeasuredWidth();
      this.bubbleViews.add(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.search.widget.BubbleViewGroup.WarpLine
 * JD-Core Version:    0.7.0.1
 */