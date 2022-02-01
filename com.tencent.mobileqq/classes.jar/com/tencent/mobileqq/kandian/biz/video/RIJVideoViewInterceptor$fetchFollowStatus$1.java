package com.tencent.mobileqq.kandian.biz.video;

import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.follow.FollowListInfoModule;
import com.tencent.mobileqq.kandian.repo.follow.FollowingMember;
import com.tencent.mobileqq.kandian.repo.follow.IFollowStatusObserver;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/video/RIJVideoViewInterceptor$fetchFollowStatus$1", "Lcom/tencent/mobileqq/kandian/repo/follow/IFollowStatusObserver;", "requestFollowStatusBack", "", "result", "", "uinsFollowStatus", "", "", "Lcom/tencent/mobileqq/kandian/repo/follow/FollowingMember;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJVideoViewInterceptor$fetchFollowStatus$1
  implements IFollowStatusObserver
{
  RIJVideoViewInterceptor$fetchFollowStatus$1(AbsBaseArticleInfo paramAbsBaseArticleInfo) {}
  
  public void a(int paramInt, @Nullable Map<Long, FollowingMember> paramMap)
  {
    paramMap = ReadInJoyLogicEngine.a();
    Intrinsics.checkExpressionValueIsNotNull(paramMap, "ReadInJoyLogicEngine.getInstance()");
    paramMap = paramMap.W();
    if (paramMap != null) {
      paramMap.b((IFollowStatusObserver)this);
    }
    this.a.hasRequestFollowStatus = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.RIJVideoViewInterceptor.fetchFollowStatus.1
 * JD-Core Version:    0.7.0.1
 */