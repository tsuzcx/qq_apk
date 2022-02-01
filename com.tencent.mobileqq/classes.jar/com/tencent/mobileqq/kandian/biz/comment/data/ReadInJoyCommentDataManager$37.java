package com.tencent.mobileqq.kandian.biz.comment.data;

import com.tencent.mobileqq.kandian.biz.comment.entity.CreateCommentResult;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;

class ReadInJoyCommentDataManager$37
  implements Runnable
{
  ReadInJoyCommentDataManager$37(ReadInJoyCommentDataManager paramReadInJoyCommentDataManager, CreateCommentResult paramCreateCommentResult) {}
  
  public void run()
  {
    int i;
    if (this.a.b) {
      i = 0;
    } else {
      i = -1;
    }
    ReadInJoyLogicEngineEventDispatcher.a().a(i, ReadInJoyCommentDataManager.k(this.this$0), this.a.f, this.a.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager.37
 * JD-Core Version:    0.7.0.1
 */