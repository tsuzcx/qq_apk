package com.tencent.mobileqq.kandian.biz.comment;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.kandian.biz.comment.data.CommentViewItem;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class CommentProteusListenerUtil$Companion$initCommentActivityClickListener$1$configClickListener$1
  implements ViewBase.OnClickListener
{
  CommentProteusListenerUtil$Companion$initCommentActivityClickListener$1$configClickListener$1(ReadinjoyCommentListBaseAdapter paramReadinjoyCommentListBaseAdapter, CommentViewItem paramCommentViewItem) {}
  
  public final void onClick(ViewBase paramViewBase)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter.a() != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem.a == null) {
        return;
      }
      paramViewBase = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter.a();
      Intrinsics.checkExpressionValueIsNotNull(paramViewBase, "adapter.vafContext");
      ReadInJoyUtils.a(paramViewBase.getContext(), this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem.a.activityJumpUrl);
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter.a() != null) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter.a().e(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.CommentProteusListenerUtil.Companion.initCommentActivityClickListener.1.configClickListener.1
 * JD-Core Version:    0.7.0.1
 */