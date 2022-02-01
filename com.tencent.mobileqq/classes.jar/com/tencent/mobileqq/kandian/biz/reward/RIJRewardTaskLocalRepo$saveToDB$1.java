package com.tencent.mobileqq.kandian.biz.reward;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class RIJRewardTaskLocalRepo$saveToDB$1
  implements Runnable
{
  RIJRewardTaskLocalRepo$saveToDB$1(RIJRewardTaskLocalRepo paramRIJRewardTaskLocalRepo, String paramString) {}
  
  public final void run()
  {
    try
    {
      EntityManager localEntityManager = RIJRewardTaskLocalRepo.a(this.this$0).createEntityManager();
      RedPacketTaskData localRedPacketTaskData = new RedPacketTaskData();
      localRedPacketTaskData.rowKey = this.a;
      localRedPacketTaskData.insertTime = System.currentTimeMillis();
      localEntityManager.persistOrReplace((Entity)localRedPacketTaskData);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("RIJRewardTaskRepo", 1, QLog.getStackTraceString((Throwable)localException));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reward.RIJRewardTaskLocalRepo.saveToDB.1
 * JD-Core Version:    0.7.0.1
 */