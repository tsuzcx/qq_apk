package com.tencent.mobileqq.kandian.biz.comment.helper;

import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentUtils.CustomDialogClickListener;
import com.tencent.mobileqq.kandian.biz.comment.base.ReadInJoyCommentEntrance;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/comment/helper/RIJCommentNetworkWrapper$wrapHippyCallback$1", "Lcom/tencent/mobileqq/kandian/biz/comment/helper/RIJCommentNetworkHelper$RIJCreateCommentForHippyObserver;", "onCreateCommentResult", "", "success", "", "errorCode", "", "comment", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJCommentNetworkWrapper$wrapHippyCallback$1
  implements RIJCommentNetworkHelper.RIJCreateCommentForHippyObserver
{
  RIJCommentNetworkWrapper$wrapHippyCallback$1(ReadInJoyCommentUtils.CustomDialogClickListener paramCustomDialogClickListener, RIJCommentNetworkHelper.RIJCreateCommentForHippyObserver paramRIJCreateCommentForHippyObserver) {}
  
  public void onCreateCommentResult(boolean paramBoolean, int paramInt, @Nullable String paramString)
  {
    if ((paramInt == -4097) && (ReadInJoyCommentEntrance.a()))
    {
      ReadInJoyCommentEntrance.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadInJoyCommentUtils$CustomDialogClickListener);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentHelperRIJCommentNetworkHelper$RIJCreateCommentForHippyObserver.onCreateCommentResult(paramBoolean, paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.helper.RIJCommentNetworkWrapper.wrapHippyCallback.1
 * JD-Core Version:    0.7.0.1
 */