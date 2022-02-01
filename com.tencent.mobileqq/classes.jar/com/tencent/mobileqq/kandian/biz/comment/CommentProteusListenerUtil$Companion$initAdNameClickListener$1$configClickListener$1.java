package com.tencent.mobileqq.kandian.biz.comment;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.kandian.biz.ad.RIJCommentAdUtils;
import com.tencent.mobileqq.kandian.biz.comment.data.CommentViewItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class CommentProteusListenerUtil$Companion$initAdNameClickListener$1$configClickListener$1
  implements ViewBase.OnClickListener
{
  CommentProteusListenerUtil$Companion$initAdNameClickListener$1$configClickListener$1(ReadinjoyCommentListBaseAdapter paramReadinjoyCommentListBaseAdapter, Container paramContainer, CommentViewItem paramCommentViewItem, int paramInt) {}
  
  public final void onClick(ViewBase paramViewBase)
  {
    paramViewBase = this.a.m();
    Intrinsics.checkExpressionValueIsNotNull(paramViewBase, "adapter.vafContext");
    paramViewBase = paramViewBase.getContext();
    Container localContainer = this.b;
    CommentViewItem localCommentViewItem = this.c;
    int i;
    if (this.d == 1182) {
      i = 1;
    } else {
      i = 3;
    }
    RIJCommentAdUtils.a(paramViewBase, localContainer, localCommentViewItem, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.CommentProteusListenerUtil.Companion.initAdNameClickListener.1.configClickListener.1
 * JD-Core Version:    0.7.0.1
 */