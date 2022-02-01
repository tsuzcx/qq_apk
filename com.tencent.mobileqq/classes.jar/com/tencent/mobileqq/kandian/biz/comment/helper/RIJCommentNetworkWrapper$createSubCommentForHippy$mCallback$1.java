package com.tencent.mobileqq.kandian.biz.comment.helper;

import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentUtils.CustomDialogClickListener;
import com.tencent.mobileqq.kandian.biz.comment.base.ReadInJoyCommentEntrance;
import com.tencent.mobileqq.kandian.biz.comment.entity.SubCommentCreateData;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/comment/helper/RIJCommentNetworkWrapper$createSubCommentForHippy$mCallback$1", "Lcom/tencent/mobileqq/kandian/biz/comment/ReadInJoyCommentUtils$CustomDialogClickListener;", "onNegativeBottomClick", "", "onPositiveBottomClick", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJCommentNetworkWrapper$createSubCommentForHippy$mCallback$1
  implements ReadInJoyCommentUtils.CustomDialogClickListener
{
  RIJCommentNetworkWrapper$createSubCommentForHippy$mCallback$1(SubCommentCreateData paramSubCommentCreateData, RIJCommentNetworkHelper.RIJCreateCommentForHippyObserver paramRIJCreateCommentForHippyObserver, boolean paramBoolean, String paramString) {}
  
  public void a()
  {
    RIJCommentNetworkWrapper.INSTANCE.createSubCommentForHippy(this.a, this.b, this.c, this.d);
  }
  
  public void b()
  {
    ReadInJoyCommentEntrance.a(this.a.b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.helper.RIJCommentNetworkWrapper.createSubCommentForHippy.mCallback.1
 * JD-Core Version:    0.7.0.1
 */