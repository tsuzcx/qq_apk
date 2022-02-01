package com.tencent.mobileqq.kandian.biz.comment.data;

import java.util.ArrayList;

class ReadInJoyCommentDataManager$13
  extends ReadInJoyCommentDataManager.CallbackActionJob
{
  ReadInJoyCommentDataManager$13(ReadInJoyCommentDataManager paramReadInJoyCommentDataManager, int paramInt)
  {
    super(paramReadInJoyCommentDataManager, null);
  }
  
  void a(ReadInJoyCommentDataManager.OnDataChangeListener paramOnDataChangeListener)
  {
    int i = this.a;
    if (i == 1)
    {
      paramOnDataChangeListener.onCommentListLoad(2, false, new ArrayList(), false, 4, 4);
      return;
    }
    if (i == 2) {
      paramOnDataChangeListener.onCommentLoadMore(2, false, new ArrayList(), false, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager.13
 * JD-Core Version:    0.7.0.1
 */