package com.tencent.mobileqq.kandian.biz.reward;

import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyEntityManagerFactory;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class RIJRewardTaskLocalRepo$getEntityManagerFactory$1$1
  implements Runnable
{
  RIJRewardTaskLocalRepo$getEntityManagerFactory$1$1(ReadInJoyEntityManagerFactory paramReadInJoyEntityManagerFactory) {}
  
  public final void run()
  {
    this.a.verifyAuthentication();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reward.RIJRewardTaskLocalRepo.getEntityManagerFactory.1.1
 * JD-Core Version:    0.7.0.1
 */