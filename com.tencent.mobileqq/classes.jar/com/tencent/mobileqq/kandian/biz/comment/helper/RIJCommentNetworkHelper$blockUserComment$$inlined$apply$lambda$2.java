package com.tencent.mobileqq.kandian.biz.comment.helper;

import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentBubbleObserver;
import com.tencent.mobileqq.kandian.biz.comment.data.CommentViewItem;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "isOverTimes", "", "errorMsg", "", "invoke", "com/tencent/mobileqq/kandian/biz/comment/helper/RIJCommentNetworkHelper$blockUserComment$1$2"}, k=3, mv={1, 1, 16})
final class RIJCommentNetworkHelper$blockUserComment$$inlined$apply$lambda$2
  extends Lambda
  implements Function2<Boolean, String, Unit>
{
  RIJCommentNetworkHelper$blockUserComment$$inlined$apply$lambda$2(ReadInJoyCommentBubbleObserver paramReadInJoyCommentBubbleObserver, CommentViewItem paramCommentViewItem)
  {
    super(2);
  }
  
  public final void invoke(boolean paramBoolean, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "errorMsg");
    this.$callback$inlined.a(false, this.$commentViewItem$inlined, paramString, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.helper.RIJCommentNetworkHelper.blockUserComment..inlined.apply.lambda.2
 * JD-Core Version:    0.7.0.1
 */