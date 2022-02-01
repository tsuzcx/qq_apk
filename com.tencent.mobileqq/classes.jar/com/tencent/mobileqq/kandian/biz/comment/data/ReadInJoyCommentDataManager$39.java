package com.tencent.mobileqq.kandian.biz.comment.data;

class ReadInJoyCommentDataManager$39
  extends ReadInJoyCommentDataManager.CallbackActionJob
{
  ReadInJoyCommentDataManager$39(ReadInJoyCommentDataManager paramReadInJoyCommentDataManager, CommentViewItem paramCommentViewItem, boolean paramBoolean, int paramInt)
  {
    super(paramReadInJoyCommentDataManager, null);
  }
  
  void a(ReadInJoyCommentDataManager.OnDataChangeListener paramOnDataChangeListener)
  {
    paramOnDataChangeListener.onCommentCreate(true, this.a, this.b, this.d.d(this.c), this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager.39
 * JD-Core Version:    0.7.0.1
 */