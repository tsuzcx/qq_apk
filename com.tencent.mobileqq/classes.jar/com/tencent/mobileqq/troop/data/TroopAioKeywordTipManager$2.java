package com.tencent.mobileqq.troop.data;

import android.util.SparseArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.api.ITroopAioKeywordService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class TroopAioKeywordTipManager$2
  implements Runnable
{
  TroopAioKeywordTipManager$2(TroopAioKeywordTipManager paramTroopAioKeywordTipManager, List paramList) {}
  
  public void run()
  {
    int i;
    synchronized (this.this$0.e)
    {
      synchronized (this.this$0.d)
      {
        Iterator localIterator = this.a.iterator();
        Object localObject6 = null;
        Object localObject1 = null;
        Integer localInteger;
        while (localIterator.hasNext())
        {
          localInteger = (Integer)localIterator.next();
          if (this.this$0.d.get(localInteger.intValue()) != null)
          {
            ??? = (TroopAioKeywordTipInfo)this.this$0.e.get(localInteger.intValue());
            if (??? == null)
            {
              ??? = localObject6;
              if (localObject6 == null) {
                ??? = new ArrayList();
              }
              ((List)???).add(localInteger);
              localObject6 = ???;
            }
            else if (((TroopAioKeywordTipInfo)???).version != ((TroopAioKeywordRuleInfo)this.this$0.d.get(localInteger.intValue())).f)
            {
              ??? = localObject1;
              if (localObject1 == null) {
                ??? = new ArrayList();
              }
              localObject1 = ???;
              if (!((List)???).contains(localInteger))
              {
                ((List)???).add(localInteger);
                localObject1 = ???;
              }
            }
          }
        }
        ??? = localObject1;
        if (localObject6 != null)
        {
          ??? = localObject1;
          if (((List)localObject6).size() > 0)
          {
            int j = ((List)localObject6).size();
            ??? = new String[j];
            i = 0;
            while (i < j)
            {
              ???[i] = String.valueOf(((List)localObject6).get(i));
              i += 1;
            }
            ??? = TroopAioKeywordHelper.a(this.this$0.a, (String[])???);
            synchronized (this.this$0.e)
            {
              synchronized (this.this$0.d)
              {
                localIterator = ((List)localObject6).iterator();
                while (localIterator.hasNext())
                {
                  localInteger = (Integer)localIterator.next();
                  localObject6 = ((List)???).iterator();
                  TroopAioKeywordTipInfo localTroopAioKeywordTipInfo;
                  do
                  {
                    if (!((Iterator)localObject6).hasNext()) {
                      break;
                    }
                    localTroopAioKeywordTipInfo = (TroopAioKeywordTipInfo)((Iterator)localObject6).next();
                  } while ((localTroopAioKeywordTipInfo.ruleId != localInteger.intValue()) || (((TroopAioKeywordRuleInfo)this.this$0.d.get(localInteger.intValue())).f != localTroopAioKeywordTipInfo.version));
                  this.this$0.e.put(localInteger.intValue(), localTroopAioKeywordTipInfo);
                  i = 1;
                  if (i == 0)
                  {
                    localObject6 = localObject1;
                    if (localObject1 == null) {
                      localObject6 = new ArrayList();
                    }
                    localObject1 = localObject6;
                    if (!((List)localObject6).contains(localInteger))
                    {
                      ((List)localObject6).add(localInteger);
                      localObject1 = localObject6;
                    }
                  }
                }
                ??? = localObject1;
              }
            }
          }
        }
        if ((??? != null) && (((List)???).size() > 0)) {
          ((ITroopAioKeywordService)this.this$0.a.getRuntimeService(ITroopAioKeywordService.class, "")).getTroopAioKeywordTipInfo((List)???, new TroopAioKeywordTipManager.2.1(this));
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAioKeywordTipManager.2
 * JD-Core Version:    0.7.0.1
 */