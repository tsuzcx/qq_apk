package com.tencent.mobileqq.kandian.biz.comment;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.kandian.biz.ad.RIJCommentAdUtils;
import com.tencent.mobileqq.kandian.biz.comment.data.CommentViewItem;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class CommentProteusListenerUtil$Companion$initHeadMedalClickListener$1$configClickListener$1
  implements ViewBase.OnClickListener
{
  CommentProteusListenerUtil$Companion$initHeadMedalClickListener$1$configClickListener$1(CommentViewItem paramCommentViewItem, ReadinjoyCommentListBaseAdapter paramReadinjoyCommentListBaseAdapter, Container paramContainer) {}
  
  public final void onClick(ViewBase paramViewBase)
  {
    if (this.a.c == null) {
      return;
    }
    if (RIJCommentAdUtils.a(this.a))
    {
      paramViewBase = this.b.m();
      Intrinsics.checkExpressionValueIsNotNull(paramViewBase, "adapter.vafContext");
      RIJCommentAdUtils.a(paramViewBase.getContext(), this.c, this.a, 2);
      return;
    }
    paramViewBase = this.a.c.medalInfo;
    if (paramViewBase != null)
    {
      Container localContainer = this.c;
      if (localContainer != null) {
        RIJMedalUtils.a(localContainer.getContext(), paramViewBase);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.CommentProteusListenerUtil.Companion.initHeadMedalClickListener.1.configClickListener.1
 * JD-Core Version:    0.7.0.1
 */