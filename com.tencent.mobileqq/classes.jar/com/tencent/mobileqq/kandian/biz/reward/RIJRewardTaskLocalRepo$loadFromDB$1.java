package com.tencent.mobileqq.kandian.biz.reward;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import mqq.os.MqqHandler;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class RIJRewardTaskLocalRepo$loadFromDB$1
  implements Runnable
{
  RIJRewardTaskLocalRepo$loadFromDB$1(RIJRewardTaskLocalRepo paramRIJRewardTaskLocalRepo) {}
  
  public final void run()
  {
    try
    {
      List localList2 = RIJRewardTaskLocalRepo.a(this.this$0).createEntityManager().query(RedPacketTaskData.class, true, null, null, null, null, "insertTime desc", "500");
      localList1 = localList2;
      if ((localList2 instanceof List)) {
        break label78;
      }
      localList1 = null;
    }
    catch (Exception localException)
    {
      List localList1;
      QLog.e("RIJRewardTaskRepo", 1, QLog.getStackTraceString((Throwable)localException));
      return;
    }
    localList1 = CollectionsKt.emptyList();
    for (;;)
    {
      ThreadManager.getUIHandler().post((Runnable)new RIJRewardTaskLocalRepo.loadFromDB.1.1(this, localList1));
      return;
      label78:
      if (localException == null) {
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reward.RIJRewardTaskLocalRepo.loadFromDB.1
 * JD-Core Version:    0.7.0.1
 */