package com.tencent.mobileqq.kandian.biz.comment.data;

import java.util.ArrayList;

class ReadInJoyCommentDataManager$12
  extends ReadInJoyCommentDataManager.CallbackActionJob
{
  ReadInJoyCommentDataManager$12(ReadInJoyCommentDataManager paramReadInJoyCommentDataManager, int paramInt)
  {
    super(paramReadInJoyCommentDataManager, null);
  }
  
  void a(ReadInJoyCommentDataManager.OnDataChangeListener paramOnDataChangeListener)
  {
    int i = this.a;
    if (i == 1)
    {
      paramOnDataChangeListener.onCommentListLoad(1, false, new ArrayList(), false, 6, 6);
      return;
    }
    if (i == 2) {
      paramOnDataChangeListener.onCommentLoadMore(1, false, new ArrayList(), false, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager.12
 * JD-Core Version:    0.7.0.1
 */