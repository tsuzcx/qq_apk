package com.tencent.mobileqq.kandian.biz.comment.data;

import java.util.List;

class ReadInJoyCommentDataManager$30
  extends ReadInJoyCommentDataManager.CallbackActionJob
{
  ReadInJoyCommentDataManager$30(ReadInJoyCommentDataManager paramReadInJoyCommentDataManager, boolean paramBoolean1, boolean paramBoolean2, List paramList)
  {
    super(paramReadInJoyCommentDataManager, null);
  }
  
  void a(ReadInJoyCommentDataManager.OnDataChangeListener paramOnDataChangeListener)
  {
    if (!this.a)
    {
      paramOnDataChangeListener.onCommentLoadMore(2, this.b, this.c, ReadInJoyCommentDataManager.j(this.d), 4);
      return;
    }
    paramOnDataChangeListener.onCommentListLoad(2, this.b, this.c, ReadInJoyCommentDataManager.j(this.d), 4, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager.30
 * JD-Core Version:    0.7.0.1
 */