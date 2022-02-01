package com.tencent.mobileqq.kandian.biz.comment.data;

import java.util.ArrayList;

class ReadInJoyCommentDataManager$8
  extends ReadInJoyCommentDataManager.CallbackActionJob
{
  ReadInJoyCommentDataManager$8(ReadInJoyCommentDataManager paramReadInJoyCommentDataManager, int paramInt)
  {
    super(paramReadInJoyCommentDataManager, null);
  }
  
  void a(ReadInJoyCommentDataManager.OnDataChangeListener paramOnDataChangeListener)
  {
    if (paramOnDataChangeListener == null) {
      return;
    }
    int i = this.jdField_a_of_type_Int;
    if (i == 1)
    {
      paramOnDataChangeListener.onCommentListLoad(1, false, new ArrayList(), false, 2, 2);
      return;
    }
    if (i == 2) {
      paramOnDataChangeListener.onCommentLoadMore(1, false, new ArrayList(), false, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager.8
 * JD-Core Version:    0.7.0.1
 */