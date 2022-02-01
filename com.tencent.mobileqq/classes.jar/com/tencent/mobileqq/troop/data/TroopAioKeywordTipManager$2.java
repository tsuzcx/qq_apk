package com.tencent.mobileqq.troop.data;

import android.util.SparseArray;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class TroopAioKeywordTipManager$2
  implements Runnable
{
  TroopAioKeywordTipManager$2(TroopAioKeywordTipManager paramTroopAioKeywordTipManager, List paramList) {}
  
  public void run()
  {
    Object localObject7 = null;
    Object localObject10;
    Object localObject11;
    label119:
    int i;
    synchronized (this.this$0.b)
    {
      synchronized (this.this$0.jdField_a_of_type_AndroidUtilSparseArray)
      {
        localObject10 = this.a.iterator();
        Object localObject1 = null;
        while (((Iterator)localObject10).hasNext())
        {
          localObject11 = (Integer)((Iterator)localObject10).next();
          if (this.this$0.jdField_a_of_type_AndroidUtilSparseArray.get(((Integer)localObject11).intValue()) != null)
          {
            ??? = (TroopAioKeywordTipInfo)this.this$0.b.get(((Integer)localObject11).intValue());
            if (??? == null)
            {
              if (localObject7 != null) {
                break label587;
              }
              localObject7 = new ArrayList();
              ((List)localObject7).add(localObject11);
              ??? = localObject1;
              localObject1 = localObject7;
              localObject7 = ???;
              break label590;
            }
            if (((TroopAioKeywordTipInfo)???).version == ((TroopAioKeywordRuleInfo)this.this$0.jdField_a_of_type_AndroidUtilSparseArray.get(((Integer)localObject11).intValue())).e) {
              break label574;
            }
            if (localObject1 != null) {
              break label568;
            }
            ??? = new ArrayList();
            label184:
            if (((List)???).contains(localObject11)) {
              break label603;
            }
            ((List)???).add(localObject11);
            break label603;
          }
        }
        ??? = localObject1;
        if (localObject7 == null) {
          break label500;
        }
        ??? = localObject1;
        if (((List)localObject7).size() <= 0) {
          break label500;
        }
        int j = ((List)localObject7).size();
        ??? = new String[j];
        i = 0;
        if (i < j)
        {
          ???[i] = String.valueOf(((List)localObject7).get(i));
          i += 1;
        }
      }
    }
    ??? = TroopAioKeywordHelper.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String[])???);
    label560:
    label563:
    label568:
    label574:
    label587:
    label590:
    label603:
    label613:
    for (;;)
    {
      synchronized (this.this$0.b)
      {
        synchronized (this.this$0.jdField_a_of_type_AndroidUtilSparseArray)
        {
          localObject7 = ((List)localObject7).iterator();
          ArrayList localArrayList;
          if (((Iterator)localObject7).hasNext())
          {
            localObject10 = (Integer)((Iterator)localObject7).next();
            localObject11 = ((List)???).iterator();
            if (!((Iterator)localObject11).hasNext()) {
              break label563;
            }
            TroopAioKeywordTipInfo localTroopAioKeywordTipInfo = (TroopAioKeywordTipInfo)((Iterator)localObject11).next();
            if ((localTroopAioKeywordTipInfo.ruleId != ((Integer)localObject10).intValue()) || (((TroopAioKeywordRuleInfo)this.this$0.jdField_a_of_type_AndroidUtilSparseArray.get(((Integer)localObject10).intValue())).e != localTroopAioKeywordTipInfo.version)) {
              continue;
            }
            this.this$0.b.put(((Integer)localObject10).intValue(), localTroopAioKeywordTipInfo);
            i = 1;
            if (i != 0) {
              break label560;
            }
            if (localObject3 == null)
            {
              localArrayList = new ArrayList();
              if (localArrayList.contains(localObject10)) {
                break label613;
              }
              localArrayList.add(localObject10);
              break label613;
            }
          }
          else
          {
            ??? = localArrayList;
            label500:
            if ((??? != null) && (((List)???).size() > 0)) {
              ((TroopHandler)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).a((List)???, new TroopAioKeywordTipManager.2.1(this));
            }
            return;
          }
        }
      }
      continue;
      break label613;
      i = 0;
      continue;
      ??? = localObject5;
      break label184;
      ??? = localObject5;
      Object localObject6 = localObject7;
      localObject7 = ???;
      break label590;
      break label119;
      for (;;)
      {
        ??? = localObject7;
        localObject7 = localObject6;
        localObject6 = ???;
        break;
        localObject6 = localObject7;
        localObject7 = ???;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAioKeywordTipManager.2
 * JD-Core Version:    0.7.0.1
 */