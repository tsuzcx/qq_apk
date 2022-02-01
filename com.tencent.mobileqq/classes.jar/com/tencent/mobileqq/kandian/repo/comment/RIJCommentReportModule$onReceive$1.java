package com.tencent.mobileqq.kandian.repo.comment;

import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class RIJCommentReportModule$onReceive$1
  implements Runnable
{
  RIJCommentReportModule$onReceive$1(boolean paramBoolean, int paramInt, String paramString, CommentReportInfo paramCommentReportInfo) {}
  
  public final void run()
  {
    ReadInJoyLogicEngineEventDispatcher.a().a(this.a, this.b, this.c, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.comment.RIJCommentReportModule.onReceive.1
 * JD-Core Version:    0.7.0.1
 */