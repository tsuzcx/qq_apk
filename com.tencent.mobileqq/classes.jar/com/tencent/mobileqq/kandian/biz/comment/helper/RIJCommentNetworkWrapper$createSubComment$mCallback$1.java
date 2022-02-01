package com.tencent.mobileqq.kandian.biz.comment.helper;

import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentUtils.CustomDialogClickListener;
import com.tencent.mobileqq.kandian.biz.comment.base.ReadInJoyCommentEntrance;
import com.tencent.mobileqq.kandian.biz.comment.entity.SubCommentCreateData;
import com.tencent.mobileqq.kandian.biz.comment.util.api.IRIJCommentNetworkHelper.RIJCreateCommentObserver;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/comment/helper/RIJCommentNetworkWrapper$createSubComment$mCallback$1", "Lcom/tencent/mobileqq/kandian/biz/comment/ReadInJoyCommentUtils$CustomDialogClickListener;", "onNegativeBottomClick", "", "onPositiveBottomClick", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJCommentNetworkWrapper$createSubComment$mCallback$1
  implements ReadInJoyCommentUtils.CustomDialogClickListener
{
  RIJCommentNetworkWrapper$createSubComment$mCallback$1(SubCommentCreateData paramSubCommentCreateData, IRIJCommentNetworkHelper.RIJCreateCommentObserver paramRIJCreateCommentObserver, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void a()
  {
    RIJCommentNetworkWrapper.INSTANCE.createSubComment(this.a, this.b, this.c, this.d, this.e, this.f);
  }
  
  public void b()
  {
    ReadInJoyCommentEntrance.a(this.a.b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.helper.RIJCommentNetworkWrapper.createSubComment.mCallback.1
 * JD-Core Version:    0.7.0.1
 */