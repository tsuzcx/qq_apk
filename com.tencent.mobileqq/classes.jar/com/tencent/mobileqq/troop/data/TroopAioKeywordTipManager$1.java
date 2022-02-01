package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.data.MessageRecord;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class TroopAioKeywordTipManager$1
  implements Runnable
{
  TroopAioKeywordTipManager$1(TroopAioKeywordTipManager paramTroopAioKeywordTipManager, List paramList) {}
  
  public void run()
  {
    Object localObject1 = this.a.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (MessageRecord)((Iterator)localObject1).next();
      TroopAioKeywordTipManager.a(this.this$0, (MessageRecord)localObject2);
    }
    localObject1 = null;
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      localObject2 = (MessageRecord)localIterator.next();
      List localList = TroopAioKeywordTipManager.a(this.this$0, (MessageRecord)localObject2);
      if (localList != null)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new ArrayList();
        }
        ((List)localObject2).addAll(localList);
        localObject1 = localObject2;
      }
    }
    if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
      TroopAioKeywordTipManager.a(this.this$0, (List)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAioKeywordTipManager.1
 * JD-Core Version:    0.7.0.1
 */