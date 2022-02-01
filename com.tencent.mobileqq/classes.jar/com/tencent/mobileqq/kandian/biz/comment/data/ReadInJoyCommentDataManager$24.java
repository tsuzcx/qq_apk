package com.tencent.mobileqq.kandian.biz.comment.data;

import java.util.List;

class ReadInJoyCommentDataManager$24
  extends ReadInJoyCommentDataManager.CallbackActionJob
{
  ReadInJoyCommentDataManager$24(ReadInJoyCommentDataManager paramReadInJoyCommentDataManager, List paramList)
  {
    super(paramReadInJoyCommentDataManager, null);
  }
  
  void a(ReadInJoyCommentDataManager.OnDataChangeListener paramOnDataChangeListener)
  {
    paramOnDataChangeListener.onCommentListLoad(1, true, this.a, ReadInJoyCommentDataManager.a(this.b), 3, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager.24
 * JD-Core Version:    0.7.0.1
 */