package com.tencent.mobileqq.multicard.manager;

import auot;
import auou;
import awgf;
import awgg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.multicard.RecommendPerson;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class TroopMemberRecommendManager$2
  implements Runnable
{
  public TroopMemberRecommendManager$2(auou paramauou, String paramString) {}
  
  public void run()
  {
    Object localObject1 = new LinkedHashMap();
    awgf localawgf = auou.a(this.this$0).getEntityManagerFactory().createEntityManager();
    if (localawgf != null) {}
    for (;;)
    {
      try
      {
        Object localObject3 = (ArrayList)localawgf.a(RecommendPerson.class, true, "troopUin=?", new String[] { this.a }, "cardTypeID", null, "addedIndex asc", null);
        auou.a(this.this$0).put(this.a, localObject3);
        this.this$0.a(this.a, true);
        localObject3 = this.this$0.a((List)auou.a(this.this$0).get(this.a), this.a);
        localObject1 = localObject3;
        localawgf.a();
        bool = true;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        localawgf.a();
        bool = false;
        continue;
      }
      finally
      {
        localawgf.a();
      }
      auou.a(this.this$0).notifyUI(1, bool, new Object[] { localObject1, this.a, Integer.valueOf(2) });
      return;
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.manager.TroopMemberRecommendManager.2
 * JD-Core Version:    0.7.0.1
 */