package com.tencent.mobileqq.multicard.manager;

import axhz;
import axia;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.multicard.RecommendPerson;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class TroopMemberRecommendManager$2
  implements Runnable
{
  public TroopMemberRecommendManager$2(axia paramaxia, String paramString) {}
  
  public void run()
  {
    Object localObject1 = new LinkedHashMap();
    EntityManager localEntityManager = axia.a(this.this$0).getEntityManagerFactory().createEntityManager();
    if (localEntityManager != null) {}
    for (;;)
    {
      try
      {
        Object localObject3 = (ArrayList)localEntityManager.query(RecommendPerson.class, true, "troopUin=?", new String[] { this.a }, "cardTypeID", null, "addedIndex asc", null);
        axia.a(this.this$0).put(this.a, localObject3);
        this.this$0.a(this.a, true);
        localObject3 = this.this$0.a((List)axia.a(this.this$0).get(this.a), this.a);
        localObject1 = localObject3;
        localEntityManager.close();
        bool = true;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        localEntityManager.close();
        bool = false;
        continue;
      }
      finally
      {
        localEntityManager.close();
      }
      axia.a(this.this$0).notifyUI(1, bool, new Object[] { localObject1, this.a, Integer.valueOf(2) });
      return;
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.manager.TroopMemberRecommendManager.2
 * JD-Core Version:    0.7.0.1
 */