package com.tencent.mobileqq.kandian.biz.comment;

import android.graphics.Rect;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;

class ReadInJoyCommentComponentFragment$11
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  ReadInJoyCommentComponentFragment$11(ReadInJoyCommentComponentFragment paramReadInJoyCommentComponentFragment) {}
  
  public void onGlobalLayout()
  {
    Object localObject = new Rect();
    this.a.jdField_a_of_type_AndroidWidgetFrameLayout.getWindowVisibleDisplayFrame((Rect)localObject);
    int j = ((Rect)localObject).bottom;
    int i = j;
    if (!this.a.e) {
      i = j - this.a.g;
    }
    if (i != this.a.f)
    {
      localObject = this.a;
      ((ReadInJoyCommentComponentFragment)localObject).f = i;
      ((ReadInJoyCommentComponentFragment)localObject).jdField_a_of_type_AndroidViewViewGroup$LayoutParams.height = this.a.f;
      this.a.jdField_a_of_type_AndroidWidgetFrameLayout.requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentComponentFragment.11
 * JD-Core Version:    0.7.0.1
 */