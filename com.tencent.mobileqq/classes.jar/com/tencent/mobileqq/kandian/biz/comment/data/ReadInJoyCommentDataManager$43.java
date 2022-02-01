package com.tencent.mobileqq.kandian.biz.comment.data;

import com.tencent.util.Pair;

class ReadInJoyCommentDataManager$43
  extends ReadInJoyCommentDataManager.CallbackActionJob
{
  ReadInJoyCommentDataManager$43(ReadInJoyCommentDataManager paramReadInJoyCommentDataManager, int paramInt, Pair paramPair)
  {
    super(paramReadInJoyCommentDataManager, null);
  }
  
  void a(ReadInJoyCommentDataManager.OnDataChangeListener paramOnDataChangeListener)
  {
    paramOnDataChangeListener.onCommentBlock(this.a, true, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager.43
 * JD-Core Version:    0.7.0.1
 */