package com.tencent.mobileqq.kandian.biz.comment.data;

import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData;

class ReadInJoyCommentDataManager$40
  extends ReadInJoyCommentDataManager.CallbackActionJob
{
  ReadInJoyCommentDataManager$40(ReadInJoyCommentDataManager paramReadInJoyCommentDataManager, BaseCommentData paramBaseCommentData)
  {
    super(paramReadInJoyCommentDataManager, null);
  }
  
  void a(ReadInJoyCommentDataManager.OnDataChangeListener paramOnDataChangeListener)
  {
    paramOnDataChangeListener.onCommentReply(true, new CommentViewItem(0, this.a, ReadInJoyCommentDataManager.k(this.b)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager.40
 * JD-Core Version:    0.7.0.1
 */