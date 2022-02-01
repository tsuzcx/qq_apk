package com.tencent.mobileqq.kandian.biz.comment;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.kandian.biz.comment.data.CommentViewItem;
import com.tencent.mobileqq.kandian.biz.comment.ui.CommentContentView;
import com.tencent.widget.BubblePopupWindow.OnDismissListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class CommentProteusListenerUtil$Companion$initCommentDotClickListener$1$configClickListener$1
  implements ViewBase.OnClickListener
{
  CommentProteusListenerUtil$Companion$initCommentDotClickListener$1$configClickListener$1(ViewBase paramViewBase, ReadinjoyCommentListBaseAdapter paramReadinjoyCommentListBaseAdapter, CommentViewItem paramCommentViewItem) {}
  
  public final void onClick(ViewBase paramViewBase)
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase;
    paramViewBase = (ViewBase)localObject;
    if (!(localObject instanceof CommentContentView)) {
      paramViewBase = null;
    }
    paramViewBase = (CommentContentView)paramViewBase;
    if (paramViewBase != null)
    {
      paramViewBase = paramViewBase.getNativeView();
      if (paramViewBase != null) {
        paramViewBase.setBackgroundColor(Color.parseColor("#DBE5EF"));
      }
    }
    paramViewBase = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter;
    if (paramViewBase != null)
    {
      localObject = (Activity)paramViewBase.a;
      ViewBase localViewBase = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase;
      Intrinsics.checkExpressionValueIsNotNull(localViewBase, "commentContentView");
      paramViewBase.a((Activity)localObject, localViewBase.getNativeView(), this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataCommentViewItem, (BubblePopupWindow.OnDismissListener)new CommentProteusListenerUtil.Companion.initCommentDotClickListener.1.configClickListener.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.CommentProteusListenerUtil.Companion.initCommentDotClickListener.1.configClickListener.1
 * JD-Core Version:    0.7.0.1
 */