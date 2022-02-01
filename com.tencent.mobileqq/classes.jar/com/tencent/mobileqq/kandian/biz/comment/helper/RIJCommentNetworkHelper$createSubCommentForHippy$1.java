package com.tencent.mobileqq.kandian.biz.comment.helper;

import com.tencent.mobileqq.kandian.biz.comment.entity.SimpleCommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.SubCommentCreateData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "comment", "", "commentId", "", "invoke"}, k=3, mv={1, 1, 16})
final class RIJCommentNetworkHelper$createSubCommentForHippy$1
  extends Lambda
  implements Function2<String, Integer, Unit>
{
  RIJCommentNetworkHelper$createSubCommentForHippy$1(boolean paramBoolean, RIJCommentNetworkHelper.RIJCreateCommentForHippyObserver paramRIJCreateCommentForHippyObserver, SubCommentCreateData paramSubCommentCreateData, long paramLong)
  {
    super(2);
  }
  
  public final void invoke(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "comment");
    boolean bool = this.$needBiuAfterComment;
    int i = 1;
    if (!bool) {
      this.$callback.onCreateCommentResult(true, 0, paramString);
    } else {
      RIJBiuNetworkHelper.a.a((SimpleCommentData)this.$requestData, (Function2)new RIJCommentNetworkHelper.createSubCommentForHippy.1.1(this, paramString));
    }
    RIJCommentNetworkHelper.a(RIJCommentNetworkHelper.a, 0, System.currentTimeMillis() - this.$requestTime);
    if (((CharSequence)this.$requestData.c()).length() <= 0) {
      i = 0;
    }
    if (i != 0) {
      paramString = this.$requestData.c();
    } else {
      paramString = this.$requestData.d();
    }
    RIJCommentNetworkHelper.a(RIJCommentNetworkHelper.a, this.$requestData.g(), paramString, this.$requestData.a(), this.$requestData.f(), String.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.helper.RIJCommentNetworkHelper.createSubCommentForHippy.1
 * JD-Core Version:    0.7.0.1
 */