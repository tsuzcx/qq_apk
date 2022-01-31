package com.tencent.mobileqq.multicard.manager;

import arxh;
import arxi;
import atmp;
import atmq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.multicard.RecommendPerson;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class TroopMemberRecommendManager$2
  implements Runnable
{
  public TroopMemberRecommendManager$2(arxi paramarxi, String paramString) {}
  
  public void run()
  {
    Object localObject1 = new LinkedHashMap();
    atmp localatmp = arxi.a(this.this$0).getEntityManagerFactory().createEntityManager();
    if (localatmp != null) {}
    for (;;)
    {
      try
      {
        Object localObject3 = (ArrayList)localatmp.a(RecommendPerson.class, true, "troopUin=?", new String[] { this.a }, "cardTypeID", null, "addedIndex asc", null);
        arxi.a(this.this$0).put(this.a, localObject3);
        this.this$0.a(this.a, true);
        localObject3 = this.this$0.a((List)arxi.a(this.this$0).get(this.a), this.a);
        localObject1 = localObject3;
        localatmp.a();
        bool = true;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        localatmp.a();
        bool = false;
        continue;
      }
      finally
      {
        localatmp.a();
      }
      arxi.a(this.this$0).notifyUI(1, bool, new Object[] { localObject1, this.a, Integer.valueOf(2) });
      return;
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.manager.TroopMemberRecommendManager.2
 * JD-Core Version:    0.7.0.1
 */