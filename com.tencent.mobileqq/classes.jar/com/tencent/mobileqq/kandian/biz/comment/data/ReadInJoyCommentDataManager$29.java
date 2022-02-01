package com.tencent.mobileqq.kandian.biz.comment.data;

import java.util.List;

class ReadInJoyCommentDataManager$29
  extends ReadInJoyCommentDataManager.CallbackActionJob
{
  ReadInJoyCommentDataManager$29(ReadInJoyCommentDataManager paramReadInJoyCommentDataManager, boolean paramBoolean, List paramList)
  {
    super(paramReadInJoyCommentDataManager, null);
  }
  
  void a(ReadInJoyCommentDataManager.OnDataChangeListener paramOnDataChangeListener)
  {
    paramOnDataChangeListener.onCommentLoadMore(1, this.a, this.b, ReadInJoyCommentDataManager.c(this.c), 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager.29
 * JD-Core Version:    0.7.0.1
 */