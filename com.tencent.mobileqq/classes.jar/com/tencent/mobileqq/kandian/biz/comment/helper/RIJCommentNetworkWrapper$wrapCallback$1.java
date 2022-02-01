package com.tencent.mobileqq.kandian.biz.comment.helper;

import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentUtils.CustomDialogClickListener;
import com.tencent.mobileqq.kandian.biz.comment.base.ReadInJoyCommentEntrance;
import com.tencent.mobileqq.kandian.biz.comment.entity.CreateCommentResult;
import com.tencent.mobileqq.kandian.biz.comment.util.api.IRIJCommentNetworkHelper.RIJCreateCommentObserver;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/comment/helper/RIJCommentNetworkWrapper$wrapCallback$1", "Lcom/tencent/mobileqq/kandian/biz/comment/util/api/IRIJCommentNetworkHelper$RIJCreateCommentObserver;", "onCreateCommentResult", "", "createCommentResult", "Lcom/tencent/mobileqq/kandian/biz/comment/entity/CreateCommentResult;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJCommentNetworkWrapper$wrapCallback$1
  implements IRIJCommentNetworkHelper.RIJCreateCommentObserver
{
  RIJCommentNetworkWrapper$wrapCallback$1(ReadInJoyCommentUtils.CustomDialogClickListener paramCustomDialogClickListener, IRIJCommentNetworkHelper.RIJCreateCommentObserver paramRIJCreateCommentObserver) {}
  
  public void a(@Nullable CreateCommentResult paramCreateCommentResult)
  {
    if ((paramCreateCommentResult != null) && (paramCreateCommentResult.c == -4097) && (ReadInJoyCommentEntrance.c()))
    {
      ReadInJoyCommentEntrance.a(this.a);
      return;
    }
    IRIJCommentNetworkHelper.RIJCreateCommentObserver localRIJCreateCommentObserver = this.b;
    if (localRIJCreateCommentObserver != null) {
      localRIJCreateCommentObserver.a(paramCreateCommentResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.helper.RIJCommentNetworkWrapper.wrapCallback.1
 * JD-Core Version:    0.7.0.1
 */