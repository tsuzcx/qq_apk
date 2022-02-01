package com.tencent.mobileqq.kandian.biz.comment.helper;

import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentUtils.CustomDialogClickListener;
import com.tencent.mobileqq.kandian.biz.comment.base.ReadInJoyCommentEntrance;
import com.tencent.mobileqq.kandian.biz.comment.entity.FirstCommentCreateData;
import com.tencent.mobileqq.kandian.biz.comment.util.api.IRIJCommentNetworkHelper.RIJCreateCommentObserver;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/comment/helper/RIJCommentNetworkWrapper$createFirstComment$mCallback$1", "Lcom/tencent/mobileqq/kandian/biz/comment/ReadInJoyCommentUtils$CustomDialogClickListener;", "onNegativeBottomClick", "", "onPositiveBottomClick", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJCommentNetworkWrapper$createFirstComment$mCallback$1
  implements ReadInJoyCommentUtils.CustomDialogClickListener
{
  RIJCommentNetworkWrapper$createFirstComment$mCallback$1(FirstCommentCreateData paramFirstCommentCreateData, IRIJCommentNetworkHelper.RIJCreateCommentObserver paramRIJCreateCommentObserver, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void a()
  {
    RIJCommentNetworkWrapper.INSTANCE.createFirstComment(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityFirstCommentCreateData, this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentUtilApiIRIJCommentNetworkHelper$RIJCreateCommentObserver, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean, this.b);
  }
  
  public void b()
  {
    ReadInJoyCommentEntrance.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityFirstCommentCreateData.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.helper.RIJCommentNetworkWrapper.createFirstComment.mCallback.1
 * JD-Core Version:    0.7.0.1
 */