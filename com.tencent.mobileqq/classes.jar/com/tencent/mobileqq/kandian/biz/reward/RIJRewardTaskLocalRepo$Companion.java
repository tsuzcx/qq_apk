package com.tencent.mobileqq.kandian.biz.reward;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/reward/RIJRewardTaskLocalRepo$Companion;", "", "()V", "KEY_CURRENT_TASK", "", "KEY_LAST_TASK", "KEY_LAST_UPDATE_LEVEL_TS", "KEY_LAST_UPDATE_TS", "KEY_PREFIX", "KEY_TASK_COMPLETED_COUNT", "KEY_TASK_LEVEL_PROGRESS_IN_MS", "KEY_TASK_PROGRESS_IN_MS", "MAX_SIZE_TASK_TIME_CACHE", "", "TAG", "instance", "Lcom/tencent/mobileqq/kandian/biz/reward/RIJRewardTaskLocalRepo;", "get", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJRewardTaskLocalRepo$Companion
{
  @JvmStatic
  @NotNull
  public final RIJRewardTaskLocalRepo a()
  {
    RIJRewardTaskLocalRepo localRIJRewardTaskLocalRepo = RIJRewardTaskLocalRepo.a();
    if (localRIJRewardTaskLocalRepo != null) {
      return localRIJRewardTaskLocalRepo;
    }
    try
    {
      localRIJRewardTaskLocalRepo = new RIJRewardTaskLocalRepo(null);
      RIJRewardTaskLocalRepo.a(localRIJRewardTaskLocalRepo);
      return localRIJRewardTaskLocalRepo;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reward.RIJRewardTaskLocalRepo.Companion
 * JD-Core Version:    0.7.0.1
 */