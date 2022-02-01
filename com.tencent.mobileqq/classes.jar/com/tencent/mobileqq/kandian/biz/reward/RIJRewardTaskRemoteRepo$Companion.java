package com.tencent.mobileqq.kandian.biz.reward;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/reward/RIJRewardTaskRemoteRepo$Companion;", "", "()V", "TAG", "", "instance", "Lcom/tencent/mobileqq/kandian/biz/reward/RIJRewardTaskRemoteRepo;", "get", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJRewardTaskRemoteRepo$Companion
{
  @JvmStatic
  @NotNull
  public final RIJRewardTaskRemoteRepo a()
  {
    RIJRewardTaskRemoteRepo localRIJRewardTaskRemoteRepo = RIJRewardTaskRemoteRepo.a();
    if (localRIJRewardTaskRemoteRepo != null) {
      return localRIJRewardTaskRemoteRepo;
    }
    try
    {
      localRIJRewardTaskRemoteRepo = new RIJRewardTaskRemoteRepo(null);
      RIJRewardTaskRemoteRepo.a(localRIJRewardTaskRemoteRepo);
      return localRIJRewardTaskRemoteRepo;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reward.RIJRewardTaskRemoteRepo.Companion
 * JD-Core Version:    0.7.0.1
 */