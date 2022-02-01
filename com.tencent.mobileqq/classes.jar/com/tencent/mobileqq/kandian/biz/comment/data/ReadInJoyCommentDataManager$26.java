package com.tencent.mobileqq.kandian.biz.comment.data;

import java.util.List;

class ReadInJoyCommentDataManager$26
  extends ReadInJoyCommentDataManager.CallbackActionJob
{
  ReadInJoyCommentDataManager$26(ReadInJoyCommentDataManager paramReadInJoyCommentDataManager, boolean paramBoolean, List paramList)
  {
    super(paramReadInJoyCommentDataManager, null);
  }
  
  void a(ReadInJoyCommentDataManager.OnDataChangeListener paramOnDataChangeListener)
  {
    paramOnDataChangeListener.onCommentListLoad(1, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaUtilList, ReadInJoyCommentDataManager.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager), 3, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager.26
 * JD-Core Version:    0.7.0.1
 */