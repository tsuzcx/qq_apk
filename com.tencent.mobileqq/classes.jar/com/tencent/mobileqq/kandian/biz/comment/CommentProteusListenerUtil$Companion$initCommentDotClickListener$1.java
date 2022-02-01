package com.tencent.mobileqq.kandian.biz.comment;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.kandian.biz.comment.data.CommentViewItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/comment/CommentProteusListenerUtil$Companion$initCommentDotClickListener$1", "Lcom/tencent/mobileqq/kandian/biz/comment/CommentProteusListenerUtil$CommentProteusOnClickListener;", "configClickListener", "", "cmdStrId", "", "container", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/container/Container;", "adapter", "Lcom/tencent/mobileqq/kandian/biz/comment/ReadinjoyCommentListBaseAdapter;", "commentViewItem", "Lcom/tencent/mobileqq/kandian/biz/comment/data/CommentViewItem;", "viewBase", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class CommentProteusListenerUtil$Companion$initCommentDotClickListener$1
  implements CommentProteusListenerUtil.CommentProteusOnClickListener
{
  public void a(int paramInt, @NotNull Container paramContainer, @NotNull ReadinjoyCommentListBaseAdapter paramReadinjoyCommentListBaseAdapter, @NotNull CommentViewItem paramCommentViewItem, @NotNull ViewBase paramViewBase)
  {
    Intrinsics.checkParameterIsNotNull(paramContainer, "container");
    Intrinsics.checkParameterIsNotNull(paramReadinjoyCommentListBaseAdapter, "adapter");
    Intrinsics.checkParameterIsNotNull(paramCommentViewItem, "commentViewItem");
    Intrinsics.checkParameterIsNotNull(paramViewBase, "viewBase");
    paramViewBase.setOnClickListener((ViewBase.OnClickListener)new CommentProteusListenerUtil.Companion.initCommentDotClickListener.1.configClickListener.1(paramCommentViewItem, paramContainer, paramReadinjoyCommentListBaseAdapter, paramContainer.getVirtualView().findViewBaseByName("id_first_comment_view")));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.CommentProteusListenerUtil.Companion.initCommentDotClickListener.1
 * JD-Core Version:    0.7.0.1
 */