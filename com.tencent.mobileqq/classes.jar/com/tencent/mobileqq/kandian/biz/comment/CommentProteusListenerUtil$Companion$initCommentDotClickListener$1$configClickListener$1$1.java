package com.tencent.mobileqq.kandian.biz.comment;

import android.graphics.Color;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.widget.BubblePopupWindow.OnDismissListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "onDismiss"}, k=3, mv={1, 1, 16})
final class CommentProteusListenerUtil$Companion$initCommentDotClickListener$1$configClickListener$1$1
  implements BubblePopupWindow.OnDismissListener
{
  CommentProteusListenerUtil$Companion$initCommentDotClickListener$1$configClickListener$1$1(CommentProteusListenerUtil.Companion.initCommentDotClickListener.1.configClickListener.1 param1) {}
  
  public final void onDismiss()
  {
    ViewBase localViewBase = this.a.a;
    Intrinsics.checkExpressionValueIsNotNull(localViewBase, "commentContentView");
    localViewBase.getNativeView().setBackgroundColor(Color.parseColor("#FFFFFF"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.CommentProteusListenerUtil.Companion.initCommentDotClickListener.1.configClickListener.1.1
 * JD-Core Version:    0.7.0.1
 */