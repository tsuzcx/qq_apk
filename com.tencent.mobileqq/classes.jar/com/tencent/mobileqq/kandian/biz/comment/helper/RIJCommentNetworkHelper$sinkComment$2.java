package com.tencent.mobileqq.kandian.biz.comment.helper;

import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentObserver;
import com.tencent.mobileqq.kandian.biz.comment.entity.FirstCommentSinkData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class RIJCommentNetworkHelper$sinkComment$2
  extends Lambda
  implements Function0<Unit>
{
  RIJCommentNetworkHelper$sinkComment$2(ReadInJoyCommentObserver paramReadInJoyCommentObserver, FirstCommentSinkData paramFirstCommentSinkData)
  {
    super(0);
  }
  
  public final void invoke()
  {
    this.$callback.a(this.$commentSinkData.b(), this.$commentSinkData.a(), true, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.helper.RIJCommentNetworkHelper.sinkComment.2
 * JD-Core Version:    0.7.0.1
 */