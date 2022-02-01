package com.tencent.mobileqq.kandian.biz.comment;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.kandian.biz.comment.data.CommentViewItem;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.follow.FollowListInfoModule;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class CommentProteusListenerUtil$Companion$initCommentFollowOnClickListener$1$configClickListener$1
  implements ViewBase.OnClickListener
{
  CommentProteusListenerUtil$Companion$initCommentFollowOnClickListener$1$configClickListener$1(CommentViewItem paramCommentViewItem) {}
  
  public final void onClick(ViewBase paramViewBase)
  {
    this.a.c();
    if ((this.a.c != null) && (this.a.c.uin != null))
    {
      paramViewBase = (Long)null;
      try
      {
        Object localObject = this.a.c.uin;
        Intrinsics.checkExpressionValueIsNotNull(localObject, "(commentViewItem.commentData.uin)");
        localObject = Long.valueOf(Long.parseLong((String)localObject));
        paramViewBase = (ViewBase)localObject;
      }
      catch (Throwable localThrowable)
      {
        QLog.w("CommentProteusUtil", 2, "initCommentFollowOnClickListener: ", localThrowable);
      }
      if (paramViewBase != null)
      {
        ReadInJoyLogicEngine localReadInJoyLogicEngine = ReadInJoyLogicEngine.a();
        Intrinsics.checkExpressionValueIsNotNull(localReadInJoyLogicEngine, "ReadInJoyLogicEngine.getInstance()");
        localReadInJoyLogicEngine.W().a(paramViewBase.longValue(), 2);
      }
      if (paramViewBase != null)
      {
        long l = ((Number)paramViewBase).longValue();
        ReadInJoyLogicEngineEventDispatcher.a().a(l, 2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.CommentProteusListenerUtil.Companion.initCommentFollowOnClickListener.1.configClickListener.1
 * JD-Core Version:    0.7.0.1
 */