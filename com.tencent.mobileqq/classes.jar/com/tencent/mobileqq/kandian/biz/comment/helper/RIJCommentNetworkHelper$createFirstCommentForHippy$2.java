package com.tencent.mobileqq.kandian.biz.comment.helper;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "errorCode", "", "<anonymous parameter 1>", "", "invoke"}, k=3, mv={1, 1, 16})
final class RIJCommentNetworkHelper$createFirstCommentForHippy$2
  extends Lambda
  implements Function2<Integer, String, Unit>
{
  RIJCommentNetworkHelper$createFirstCommentForHippy$2(RIJCommentNetworkHelper.RIJCreateCommentForHippyObserver paramRIJCreateCommentForHippyObserver, long paramLong)
  {
    super(2);
  }
  
  public final void invoke(int paramInt, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<anonymous parameter 1>");
    this.$callback.onCreateCommentResult(false, paramInt, "");
    RIJCommentNetworkHelper.a(RIJCommentNetworkHelper.a, -1, System.currentTimeMillis() - this.$requestTime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.helper.RIJCommentNetworkHelper.createFirstCommentForHippy.2
 * JD-Core Version:    0.7.0.1
 */