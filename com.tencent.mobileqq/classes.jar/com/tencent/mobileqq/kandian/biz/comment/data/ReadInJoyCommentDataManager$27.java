package com.tencent.mobileqq.kandian.biz.comment.data;

import java.util.List;

class ReadInJoyCommentDataManager$27
  extends ReadInJoyCommentDataManager.CallbackActionJob
{
  ReadInJoyCommentDataManager$27(ReadInJoyCommentDataManager paramReadInJoyCommentDataManager, boolean paramBoolean1, List paramList, boolean paramBoolean2)
  {
    super(paramReadInJoyCommentDataManager, null);
  }
  
  void a(ReadInJoyCommentDataManager.OnDataChangeListener paramOnDataChangeListener)
  {
    paramOnDataChangeListener.onCommentLoadMore(1, this.a, this.b, this.c, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager.27
 * JD-Core Version:    0.7.0.1
 */