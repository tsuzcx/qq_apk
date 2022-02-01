package com.tencent.mobileqq.kandian.biz.comment;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.comment.data.CommentViewItem;
import com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager;

final class CommentProteusUtil$2
  implements DialogInterface.OnClickListener
{
  CommentProteusUtil$2(ReadinjoyCommentListBaseAdapter paramReadinjoyCommentListBaseAdapter, CommentViewItem paramCommentViewItem) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter;
      if (paramDialogInterface != null)
      {
        paramDialogInterface = paramDialogInterface.a();
        if (paramDialogInterface != null)
        {
          paramDialogInterface.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem);
          this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter.notifyDataSetChanged();
        }
      }
      RIJSPUtils.a("family_comment_card_hide_timestamp", Long.valueOf(System.currentTimeMillis()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.CommentProteusUtil.2
 * JD-Core Version:    0.7.0.1
 */