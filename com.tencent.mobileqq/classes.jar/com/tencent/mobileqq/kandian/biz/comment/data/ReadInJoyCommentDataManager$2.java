package com.tencent.mobileqq.kandian.biz.comment.data;

class ReadInJoyCommentDataManager$2
  extends ReadInJoyCommentDataManager.CallbackActionJob
{
  ReadInJoyCommentDataManager$2(ReadInJoyCommentDataManager paramReadInJoyCommentDataManager)
  {
    super(paramReadInJoyCommentDataManager, null);
  }
  
  void a(ReadInJoyCommentDataManager.OnDataChangeListener paramOnDataChangeListener)
  {
    paramOnDataChangeListener.onCommentListLoad(1, true, this.a.k(), ReadInJoyCommentDataManager.b(this.a), 2, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager.2
 * JD-Core Version:    0.7.0.1
 */