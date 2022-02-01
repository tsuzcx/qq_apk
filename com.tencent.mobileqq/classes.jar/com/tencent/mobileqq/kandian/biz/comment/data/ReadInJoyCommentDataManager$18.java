package com.tencent.mobileqq.kandian.biz.comment.data;

import com.tencent.mobileqq.kandian.repo.comment.CommentReportInfo;

class ReadInJoyCommentDataManager$18
  extends ReadInJoyCommentDataManager.CallbackActionJob
{
  ReadInJoyCommentDataManager$18(ReadInJoyCommentDataManager paramReadInJoyCommentDataManager, int paramInt, boolean paramBoolean, CommentReportInfo paramCommentReportInfo)
  {
    super(paramReadInJoyCommentDataManager, null);
  }
  
  void a(ReadInJoyCommentDataManager.OnDataChangeListener paramOnDataChangeListener)
  {
    paramOnDataChangeListener.onCommentReport(this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommentCommentReportInfo.b(), this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommentCommentReportInfo.c());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager.18
 * JD-Core Version:    0.7.0.1
 */