package com.tencent.mobileqq.kandian.biz.comment;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.kandian.biz.comment.data.CommentViewItem;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class CommentProteusListenerUtil$Companion$initExposeSubCommentOneClickListener$1$configClickListener$1
  implements ViewBase.OnClickListener
{
  CommentProteusListenerUtil$Companion$initExposeSubCommentOneClickListener$1$configClickListener$1(ReadinjoyCommentListBaseAdapter paramReadinjoyCommentListBaseAdapter, CommentViewItem paramCommentViewItem) {}
  
  public final void onClick(ViewBase paramViewBase)
  {
    paramViewBase = this.a;
    if (paramViewBase != null)
    {
      paramViewBase = (ReadInJoyCommentListAdapter)paramViewBase;
      CommentViewItem localCommentViewItem = this.b;
      paramViewBase.a(localCommentViewItem, CommentProteusUtil.a(localCommentViewItem, 0), 2);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentListAdapter");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.CommentProteusListenerUtil.Companion.initExposeSubCommentOneClickListener.1.configClickListener.1
 * JD-Core Version:    0.7.0.1
 */