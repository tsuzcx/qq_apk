package com.tencent.mobileqq.kandian.biz.hippy.module;

import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.follow.FollowListInfoModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class TKDCommentBizModule$onClickFollow$1
  implements Runnable
{
  TKDCommentBizModule$onClickFollow$1(HippyMap paramHippyMap) {}
  
  public final void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onClickFollow --> params:");
    ((StringBuilder)localObject).append(this.$params);
    QLog.d("TKDCommentBizModule", 1, ((StringBuilder)localObject).toString());
    long l = this.$params.getLong("uin");
    if (l != 0L)
    {
      localObject = ReadInJoyLogicEngine.a();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "ReadInJoyLogicEngine.getInstance()");
      ((ReadInJoyLogicEngine)localObject).W().a(l, 2);
      ReadInJoyLogicEngineEventDispatcher.a().a(l, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.hippy.module.TKDCommentBizModule.onClickFollow.1
 * JD-Core Version:    0.7.0.1
 */