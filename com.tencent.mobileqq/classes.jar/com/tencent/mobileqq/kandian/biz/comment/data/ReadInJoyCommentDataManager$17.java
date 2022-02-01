package com.tencent.mobileqq.kandian.biz.comment.data;

import com.tencent.mobileqq.kandian.biz.comment.entity.CreateCommentResult;
import com.tencent.mobileqq.kandian.biz.comment.helper.RIJCommentNetworkHelper;
import com.tencent.mobileqq.kandian.biz.comment.util.api.IRIJCommentNetworkHelper.RIJCreateCommentObserver;
import org.jetbrains.annotations.NotNull;

class ReadInJoyCommentDataManager$17
  implements IRIJCommentNetworkHelper.RIJCreateCommentObserver
{
  ReadInJoyCommentDataManager$17(ReadInJoyCommentDataManager paramReadInJoyCommentDataManager) {}
  
  public void a(@NotNull CreateCommentResult paramCreateCommentResult)
  {
    if (paramCreateCommentResult.j) {
      ReadInJoyCommentDataManager.a(this.a, paramCreateCommentResult);
    } else {
      ReadInJoyCommentDataManager.b(this.a, paramCreateCommentResult);
    }
    if (!paramCreateCommentResult.b) {
      RIJCommentNetworkHelper.a(paramCreateCommentResult.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager.17
 * JD-Core Version:    0.7.0.1
 */