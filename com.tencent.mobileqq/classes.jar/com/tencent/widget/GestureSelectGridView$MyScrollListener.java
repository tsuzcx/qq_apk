package com.tencent.widget;

class GestureSelectGridView$MyScrollListener
  implements AbsListView.OnScrollListener
{
  GestureSelectGridView$MyScrollListener(GestureSelectGridView paramGestureSelectGridView) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.this$0.mIsScrolling)
    {
      int i = paramInt1 + paramInt2;
      GestureSelectGridView localGestureSelectGridView;
      if ((this.this$0.mIsScrollingFromTop) && (Math.abs(i - this.this$0.mEndSelectPosition) >= 3) && (Math.abs(i - this.this$0.mEndSelectPosition) <= 5))
      {
        i = this.this$0.mEndSelectPosition;
        int j = paramInt3 - 1;
        if (i + 3 > j)
        {
          this.this$0.mEndSelectPosition = j;
        }
        else
        {
          localGestureSelectGridView = this.this$0;
          localGestureSelectGridView.mEndSelectPosition += 3;
        }
        this.this$0.mOnSelectChangedListener.onSelectChanged(this.this$0.mBeginSelectPosition, this.this$0.mEndSelectPosition);
      }
      else if ((!this.this$0.mIsScrollingFromTop) && (Math.abs(paramInt1 - this.this$0.mEndSelectPosition) >= 3) && (Math.abs(paramInt1 - this.this$0.mEndSelectPosition) <= 5))
      {
        if (this.this$0.mEndSelectPosition - 3 < 0)
        {
          this.this$0.mEndSelectPosition = 0;
        }
        else
        {
          localGestureSelectGridView = this.this$0;
          localGestureSelectGridView.mEndSelectPosition -= 3;
        }
        this.this$0.mOnSelectChangedListener.onSelectChanged(this.this$0.mBeginSelectPosition, this.this$0.mEndSelectPosition);
      }
    }
    if (this.this$0.mSubOnScrollListener != null) {
      this.this$0.mSubOnScrollListener.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.this$0.mSubOnScrollListener != null) {
      this.this$0.mSubOnScrollListener.onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.GestureSelectGridView.MyScrollListener
 * JD-Core Version:    0.7.0.1
 */