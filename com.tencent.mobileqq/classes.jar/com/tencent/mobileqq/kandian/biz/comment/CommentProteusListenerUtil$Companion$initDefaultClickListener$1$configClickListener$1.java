package com.tencent.mobileqq.kandian.biz.comment;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.kandian.biz.ad.RIJCommentAdUtils;
import com.tencent.mobileqq.kandian.biz.comment.data.CommentViewItem;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "viewBase", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class CommentProteusListenerUtil$Companion$initDefaultClickListener$1$configClickListener$1
  implements ViewBase.OnClickListener
{
  CommentProteusListenerUtil$Companion$initDefaultClickListener$1$configClickListener$1(CommentViewItem paramCommentViewItem, ReadinjoyCommentListBaseAdapter paramReadinjoyCommentListBaseAdapter, Container paramContainer) {}
  
  public final void onClick(ViewBase paramViewBase)
  {
    if (RIJCommentAdUtils.a(this.a))
    {
      paramViewBase = this.b.m();
      Intrinsics.checkExpressionValueIsNotNull(paramViewBase, "adapter.vafContext");
      RIJCommentAdUtils.a(paramViewBase.getContext(), this.c, this.a, 1000);
      return;
    }
    if (this.a.c != null)
    {
      Object localObject = this.b.m();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "adapter.vafContext");
      localObject = ((VafContext)localObject).getContext();
      Intrinsics.checkExpressionValueIsNotNull(paramViewBase, "viewBase");
      ReadInJoyUtils.a((Context)localObject, paramViewBase.getEventAttachedData());
      if (this.b.q() != null) {
        this.b.q().e(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.CommentProteusListenerUtil.Companion.initDefaultClickListener.1.configClickListener.1
 * JD-Core Version:    0.7.0.1
 */