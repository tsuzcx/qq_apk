package com.tencent.mobileqq.kandian.biz.comment.helper;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "isSuccess", "", "errorCode", "", "invoke"}, k=3, mv={1, 1, 16})
final class RIJCommentNetworkHelper$createSubCommentForHippy$1$1
  extends Lambda
  implements Function2<Boolean, Integer, Unit>
{
  RIJCommentNetworkHelper$createSubCommentForHippy$1$1(RIJCommentNetworkHelper.createSubCommentForHippy.1 param1, String paramString)
  {
    super(2);
  }
  
  public final void invoke(boolean paramBoolean, int paramInt)
  {
    this.this$0.$callback.onCreateCommentResult(paramBoolean, paramInt, this.$comment);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.helper.RIJCommentNetworkHelper.createSubCommentForHippy.1.1
 * JD-Core Version:    0.7.0.1
 */