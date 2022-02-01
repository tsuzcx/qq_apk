package com.tencent.mobileqq.kandian.biz.comment;

import android.graphics.Rect;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;

class ReadInJoyCommentComponentFragment$12
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  ReadInJoyCommentComponentFragment$12(ReadInJoyCommentComponentFragment paramReadInJoyCommentComponentFragment) {}
  
  public void onGlobalLayout()
  {
    Object localObject = new Rect();
    this.a.P.getWindowVisibleDisplayFrame((Rect)localObject);
    int j = ((Rect)localObject).bottom;
    int i = j;
    if (!this.a.O) {
      i = j - this.a.N;
    }
    if (i != this.a.M)
    {
      localObject = this.a;
      ((ReadInJoyCommentComponentFragment)localObject).M = i;
      ((ReadInJoyCommentComponentFragment)localObject).Q.height = this.a.M;
      this.a.P.requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentComponentFragment.12
 * JD-Core Version:    0.7.0.1
 */