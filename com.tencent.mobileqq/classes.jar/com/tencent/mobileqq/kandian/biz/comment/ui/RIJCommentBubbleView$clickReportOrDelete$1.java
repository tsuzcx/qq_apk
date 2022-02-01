package com.tencent.mobileqq.kandian.biz.comment.ui;

import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentUtils.ReportCommentDialogClickListener;
import com.tencent.mobileqq.kandian.biz.comment.ReadinjoyCommentListBaseAdapter;
import com.tencent.mobileqq.kandian.biz.comment.data.CommentViewItem;
import com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/comment/ui/RIJCommentBubbleView$clickReportOrDelete$1", "Lcom/tencent/mobileqq/kandian/biz/comment/ReadInJoyCommentUtils$ReportCommentDialogClickListener;", "onClick", "", "msg", "", "reportType", "", "which", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJCommentBubbleView$clickReportOrDelete$1
  extends ReadInJoyCommentUtils.ReportCommentDialogClickListener
{
  public void a(@NotNull String paramString, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "msg");
    RIJCommentBubbleView.a(this.a).f().b(RIJCommentBubbleView.b(this.a).c.commentId, paramString, paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ui.RIJCommentBubbleView.clickReportOrDelete.1
 * JD-Core Version:    0.7.0.1
 */