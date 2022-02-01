package com.tencent.mobileqq.kandian.biz.comment.data;

import java.util.List;

class ReadInJoyCommentDataManager$20
  extends ReadInJoyCommentDataManager.CallbackActionJob
{
  ReadInJoyCommentDataManager$20(ReadInJoyCommentDataManager paramReadInJoyCommentDataManager, boolean paramBoolean1, List paramList, boolean paramBoolean2, int paramInt)
  {
    super(paramReadInJoyCommentDataManager, null);
  }
  
  void a(ReadInJoyCommentDataManager.OnDataChangeListener paramOnDataChangeListener)
  {
    boolean bool1 = this.a;
    List localList = this.b;
    boolean bool2 = this.c;
    int i = this.d;
    paramOnDataChangeListener.onCommentListLoad(1, bool1, localList, bool2, i, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager.20
 * JD-Core Version:    0.7.0.1
 */