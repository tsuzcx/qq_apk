package com.tencent.mobileqq.kandian.biz.comment.helper;

import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentBubbleObserver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "errorMsg", "", "invoke", "com/tencent/mobileqq/kandian/biz/comment/helper/RIJCommentNetworkHelper$patrolArbitration$1$2"}, k=3, mv={1, 1, 16})
final class RIJCommentNetworkHelper$patrolArbitration$$inlined$apply$lambda$2
  extends Lambda
  implements Function1<String, Unit>
{
  RIJCommentNetworkHelper$patrolArbitration$$inlined$apply$lambda$2(ReadInJoyCommentBubbleObserver paramReadInJoyCommentBubbleObserver)
  {
    super(1);
  }
  
  public final void invoke(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "errorMsg");
    this.$callback$inlined.a(false, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.helper.RIJCommentNetworkHelper.patrolArbitration..inlined.apply.lambda.2
 * JD-Core Version:    0.7.0.1
 */