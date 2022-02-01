package com.tencent.mobileqq.kandian.biz.comment.helper;

import com.tencent.mobileqq.kandian.biz.comment.entity.FirstCommentCreateData;
import com.tencent.mobileqq.kandian.biz.comment.entity.SimpleCommentData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "comment", "", "commentId", "invoke"}, k=3, mv={1, 1, 16})
final class RIJCommentNetworkHelper$createFirstCommentForHippy$1
  extends Lambda
  implements Function2<String, String, Unit>
{
  RIJCommentNetworkHelper$createFirstCommentForHippy$1(boolean paramBoolean, RIJCommentNetworkHelper.RIJCreateCommentForHippyObserver paramRIJCreateCommentForHippyObserver, FirstCommentCreateData paramFirstCommentCreateData, long paramLong)
  {
    super(2);
  }
  
  public final void invoke(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "comment");
    Intrinsics.checkParameterIsNotNull(paramString2, "commentId");
    boolean bool = this.$needBiuAfterComment;
    int i = 1;
    if (!bool) {
      this.$callback.onCreateCommentResult(true, 0, paramString1);
    } else {
      RIJBiuNetworkHelper.a.a((SimpleCommentData)this.$requestData, (Function2)new RIJCommentNetworkHelper.createFirstCommentForHippy.1.1(this, paramString1));
    }
    RIJCommentNetworkHelper.a(RIJCommentNetworkHelper.a, 0, System.currentTimeMillis() - this.$requestTime);
    if (((CharSequence)this.$requestData.d()).length() <= 0) {
      i = 0;
    }
    if (i != 0) {
      paramString1 = this.$requestData.d();
    } else {
      paramString1 = this.$requestData.e();
    }
    RIJCommentNetworkHelper.a(RIJCommentNetworkHelper.a, this.$requestData.c(), paramString1, "", "", paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.helper.RIJCommentNetworkHelper.createFirstCommentForHippy.1
 * JD-Core Version:    0.7.0.1
 */