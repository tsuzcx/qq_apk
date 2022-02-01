package com.tencent.mobileqq.kandian.biz.comment;

import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.kandian.biz.comment.data.CommentViewItem;
import com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "viewBase", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class CommentProteusListenerUtil$Companion$initCommentMediaClickListener$1$configClickListener$1
  implements ViewBase.OnClickListener
{
  CommentProteusListenerUtil$Companion$initCommentMediaClickListener$1$configClickListener$1(ReadinjoyCommentListBaseAdapter paramReadinjoyCommentListBaseAdapter, CommentViewItem paramCommentViewItem) {}
  
  public final void onClick(ViewBase paramViewBase)
  {
    ArrayList localArrayList = new ArrayList();
    Intrinsics.checkExpressionValueIsNotNull(paramViewBase, "viewBase");
    localArrayList.add(paramViewBase.getEventAttachedData());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("comment media url : ");
    localStringBuilder.append(paramViewBase.getEventAttachedData());
    QLog.d("CommentProteusUtil", 2, localStringBuilder.toString());
    TroopNoticeJsHandler.a((Activity)this.a.n(), 0, localArrayList, true, "", 1888);
    if (this.a.q() != null) {
      this.a.q().f(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.CommentProteusListenerUtil.Companion.initCommentMediaClickListener.1.configClickListener.1
 * JD-Core Version:    0.7.0.1
 */