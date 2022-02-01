package com.tencent.mobileqq.kandian.biz.comment.data;

import com.tencent.mobileqq.kandian.repo.comment.CommentReportInfo;

class ReadInJoyCommentDataManager$18
  extends ReadInJoyCommentDataManager.CallbackActionJob
{
  ReadInJoyCommentDataManager$18(ReadInJoyCommentDataManager paramReadInJoyCommentDataManager, int paramInt, boolean paramBoolean, CommentReportInfo paramCommentReportInfo)
  {
    super(paramReadInJoyCommentDataManager, null);
  }
  
  void a(ReadInJoyCommentDataManager.OnDataChangeListener paramOnDataChangeListener)
  {
    paramOnDataChangeListener.onCommentReport(this.a, this.b, this.c.b(), this.c.c());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager.18
 * JD-Core Version:    0.7.0.1
 */