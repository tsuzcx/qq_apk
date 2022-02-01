package com.tencent.mobileqq.kandian.biz.comment.data;

class ReadInJoyCommentDataManager$14
  extends ReadInJoyCommentDataManager.CallbackActionJob
{
  ReadInJoyCommentDataManager$14(ReadInJoyCommentDataManager paramReadInJoyCommentDataManager, int paramInt1, CommentViewItem paramCommentViewItem, int paramInt2)
  {
    super(paramReadInJoyCommentDataManager, null);
  }
  
  void a(ReadInJoyCommentDataManager.OnDataChangeListener paramOnDataChangeListener)
  {
    paramOnDataChangeListener.onCommentDelete(this.jdField_a_of_type_Int, true, this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager.14
 * JD-Core Version:    0.7.0.1
 */