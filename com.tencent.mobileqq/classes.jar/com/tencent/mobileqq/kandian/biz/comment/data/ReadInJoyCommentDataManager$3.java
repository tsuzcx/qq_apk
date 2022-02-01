package com.tencent.mobileqq.kandian.biz.comment.data;

class ReadInJoyCommentDataManager$3
  extends ReadInJoyCommentDataManager.CallbackActionJob
{
  ReadInJoyCommentDataManager$3(ReadInJoyCommentDataManager paramReadInJoyCommentDataManager)
  {
    super(paramReadInJoyCommentDataManager, null);
  }
  
  void a(ReadInJoyCommentDataManager.OnDataChangeListener paramOnDataChangeListener)
  {
    paramOnDataChangeListener.onCommentListLoad(1, true, this.a.l(), ReadInJoyCommentDataManager.c(this.a), 6, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager.3
 * JD-Core Version:    0.7.0.1
 */