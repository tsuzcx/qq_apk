package com.tencent.mobileqq.kandian.biz.comment.ui;

import android.view.View;
import com.tencent.mobileqq.kandian.biz.comment.data.CommentViewItem;
import com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "clickedView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "which", "", "OnClick"}, k=3, mv={1, 1, 16})
final class RIJCommentBubbleView$clickStickyButton$1
  implements ActionSheet.OnButtonClickListener
{
  RIJCommentBubbleView$clickStickyButton$1(RIJCommentBubbleView paramRIJCommentBubbleView, ReadInJoyCommentDataManager paramReadInJoyCommentDataManager, boolean paramBoolean, ActionSheet paramActionSheet) {}
  
  public final void OnClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      ReadInJoyCommentDataManager localReadInJoyCommentDataManager = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager;
      paramView = RIJCommentBubbleView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentUiRIJCommentBubbleView).a;
      if (paramView != null) {
        paramView = paramView.commentId;
      } else {
        paramView = null;
      }
      localReadInJoyCommentDataManager.c(paramView, this.jdField_a_of_type_Boolean);
      RIJCommentBubbleView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentUiRIJCommentBubbleView, 6);
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ui.RIJCommentBubbleView.clickStickyButton.1
 * JD-Core Version:    0.7.0.1
 */