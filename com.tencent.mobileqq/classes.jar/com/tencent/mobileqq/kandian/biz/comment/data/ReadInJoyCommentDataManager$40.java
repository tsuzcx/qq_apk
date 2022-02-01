package com.tencent.mobileqq.kandian.biz.comment.data;

import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData;

class ReadInJoyCommentDataManager$40
  extends ReadInJoyCommentDataManager.CallbackActionJob
{
  ReadInJoyCommentDataManager$40(ReadInJoyCommentDataManager paramReadInJoyCommentDataManager, BaseCommentData paramBaseCommentData)
  {
    super(paramReadInJoyCommentDataManager, null);
  }
  
  void a(ReadInJoyCommentDataManager.OnDataChangeListener paramOnDataChangeListener)
  {
    paramOnDataChangeListener.onCommentReply(true, new CommentViewItem(0, this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData, ReadInJoyCommentDataManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager.40
 * JD-Core Version:    0.7.0.1
 */