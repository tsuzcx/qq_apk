package com.tencent.mobileqq.kandian.biz.comment.data;

class ReadInJoyCommentDataManager$31
  extends ReadInJoyCommentDataManager.CallbackActionJob
{
  ReadInJoyCommentDataManager$31(ReadInJoyCommentDataManager paramReadInJoyCommentDataManager, int paramInt1, CommentViewItem paramCommentViewItem, int paramInt2)
  {
    super(paramReadInJoyCommentDataManager, null);
  }
  
  void a(ReadInJoyCommentDataManager.OnDataChangeListener paramOnDataChangeListener)
  {
    paramOnDataChangeListener.onCommentDelete(this.a, true, this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager.31
 * JD-Core Version:    0.7.0.1
 */