package com.tencent.mobileqq.kandian.biz.comment.data;

class ReadInJoyCommentDataManager$1
  extends ReadInJoyCommentDataManager.CallbackActionJob
{
  ReadInJoyCommentDataManager$1(ReadInJoyCommentDataManager paramReadInJoyCommentDataManager)
  {
    super(paramReadInJoyCommentDataManager, null);
  }
  
  void a(ReadInJoyCommentDataManager.OnDataChangeListener paramOnDataChangeListener)
  {
    paramOnDataChangeListener.onCommentListLoad(1, true, this.a.j(), ReadInJoyCommentDataManager.a(this.a), 3, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager.1
 * JD-Core Version:    0.7.0.1
 */