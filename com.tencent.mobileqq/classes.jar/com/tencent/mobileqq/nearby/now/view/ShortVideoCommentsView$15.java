package com.tencent.mobileqq.nearby.now.view;

import android.view.View;
import com.tencent.mobileqq.nearby.now.model.Comments.Comment;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class ShortVideoCommentsView$15
  implements ActionSheet.OnButtonClickListener
{
  ShortVideoCommentsView$15(ShortVideoCommentsView paramShortVideoCommentsView, Comments.Comment paramComment, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt == 1) {
        ShortVideoCommentsView.access$2200(this.c, this.a);
      }
    }
    else {
      this.c.jump2Report(this.a);
    }
    paramView = this.b;
    if (paramView != null) {
      paramView.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView.15
 * JD-Core Version:    0.7.0.1
 */