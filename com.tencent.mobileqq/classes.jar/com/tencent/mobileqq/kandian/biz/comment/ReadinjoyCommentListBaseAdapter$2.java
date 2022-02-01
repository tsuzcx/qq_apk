package com.tencent.mobileqq.kandian.biz.comment;

import android.view.View;
import com.tencent.mobileqq.kandian.biz.comment.data.CommentViewItem;
import com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class ReadinjoyCommentListBaseAdapter$2
  implements ActionSheet.OnButtonClickListener
{
  ReadinjoyCommentListBaseAdapter$2(ReadinjoyCommentListBaseAdapter paramReadinjoyCommentListBaseAdapter, CommentViewItem paramCommentViewItem, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter.a();
      if (paramView != null) {
        paramView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem, this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter.c);
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter.notifyDataSetChanged();
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ReadinjoyCommentListBaseAdapter.2
 * JD-Core Version:    0.7.0.1
 */