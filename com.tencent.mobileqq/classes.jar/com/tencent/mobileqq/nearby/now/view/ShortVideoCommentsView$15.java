package com.tencent.mobileqq.nearby.now.view;

import android.view.View;
import com.tencent.mobileqq.nearby.now.model.Comments.Comment;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class ShortVideoCommentsView$15
  implements ActionSheet.OnButtonClickListener
{
  ShortVideoCommentsView$15(ShortVideoCommentsView paramShortVideoCommentsView, Comments.Comment paramComment, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt == 1) {
        ShortVideoCommentsView.access$2200(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView, this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments$Comment);
      }
    }
    else {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView.jump2Report(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments$Comment);
    }
    paramView = this.jdField_a_of_type_ComTencentWidgetActionSheet;
    if (paramView != null) {
      paramView.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView.15
 * JD-Core Version:    0.7.0.1
 */