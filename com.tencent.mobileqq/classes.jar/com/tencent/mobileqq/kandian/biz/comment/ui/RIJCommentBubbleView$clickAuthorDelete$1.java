package com.tencent.mobileqq.kandian.biz.comment.ui;

import android.view.View;
import com.tencent.mobileqq.kandian.biz.comment.ReadinjoyCommentListBaseAdapter;
import com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import com.tencent.widget.BubblePopupWindow;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "clickedView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "which", "", "onClick"}, k=3, mv={1, 1, 16})
final class RIJCommentBubbleView$clickAuthorDelete$1
  implements ActionSheet.OnButtonClickListener
{
  RIJCommentBubbleView$clickAuthorDelete$1(RIJCommentBubbleView paramRIJCommentBubbleView, ActionSheet paramActionSheet) {}
  
  public final void onClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      RIJCommentBubbleView.a(this.a).f().b(RIJCommentBubbleView.b(this.a), RIJCommentBubbleView.a(this.a).o());
      RIJCommentBubbleView.c(this.a).dismiss();
    }
    this.b.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ui.RIJCommentBubbleView.clickAuthorDelete.1
 * JD-Core Version:    0.7.0.1
 */