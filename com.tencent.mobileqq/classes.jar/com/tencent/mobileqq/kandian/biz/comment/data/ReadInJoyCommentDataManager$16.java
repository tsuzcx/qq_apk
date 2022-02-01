package com.tencent.mobileqq.kandian.biz.comment.data;

import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.CreateCommentResult;
import com.tencent.mobileqq.kandian.biz.comment.helper.RIJCommentNetworkHelper;
import com.tencent.mobileqq.kandian.biz.comment.util.api.IRIJCommentNetworkHelper.RIJCreateCommentObserver;
import com.tencent.util.LongSparseArray;
import com.tencent.util.Pair;
import org.jetbrains.annotations.NotNull;

class ReadInJoyCommentDataManager$16
  implements IRIJCommentNetworkHelper.RIJCreateCommentObserver
{
  ReadInJoyCommentDataManager$16(ReadInJoyCommentDataManager paramReadInJoyCommentDataManager, String paramString, BaseCommentData paramBaseCommentData) {}
  
  public void a(@NotNull CreateCommentResult paramCreateCommentResult)
  {
    if (paramCreateCommentResult.a != -1L) {
      ReadInJoyCommentDataManager.h(this.c).c(paramCreateCommentResult.a, new Pair(this.a, this.b));
    }
    if (paramCreateCommentResult.j) {
      ReadInJoyCommentDataManager.a(this.c, paramCreateCommentResult);
    } else {
      ReadInJoyCommentDataManager.b(this.c, paramCreateCommentResult);
    }
    if (!paramCreateCommentResult.b) {
      RIJCommentNetworkHelper.a(paramCreateCommentResult.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager.16
 * JD-Core Version:    0.7.0.1
 */