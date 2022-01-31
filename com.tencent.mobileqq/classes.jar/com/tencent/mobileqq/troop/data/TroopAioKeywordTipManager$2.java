package com.tencent.mobileqq.troop.data;

import akhp;
import android.util.SparseArray;
import azmt;
import azmv;
import azne;
import aznf;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TroopAioKeywordTipManager$2
  implements Runnable
{
  public TroopAioKeywordTipManager$2(azne paramazne, List paramList) {}
  
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
                break label586;
              }
              localObject7 = new ArrayList();
              ((List)localObject7).add(localObject11);
              ??? = localObject1;
              localObject1 = localObject7;
              localObject7 = ???;
              break label589;
            }
            if (((TroopAioKeywordTipInfo)???).version == ((azmv)this.this$0.jdField_a_of_type_AndroidUtilSparseArray.get(((Integer)localObject11).intValue())).e) {
              break label573;
            }
            if (localObject1 != null) {
              break label567;
            }
            ??? = new ArrayList();
            label184:
            if (((List)???).contains(localObject11)) {
              break label602;
            }
            ((List)???).add(localObject11);
            break label602;
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
    ??? = azmt.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String[])???);
    label559:
    label562:
    label567:
    label573:
    label586:
    label589:
    label602:
    label612:
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
              break label562;
            }
            TroopAioKeywordTipInfo localTroopAioKeywordTipInfo = (TroopAioKeywordTipInfo)((Iterator)localObject11).next();
            if ((localTroopAioKeywordTipInfo.ruleId != ((Integer)localObject10).intValue()) || (((azmv)this.this$0.jdField_a_of_type_AndroidUtilSparseArray.get(((Integer)localObject10).intValue())).e != localTroopAioKeywordTipInfo.version)) {
              continue;
            }
            this.this$0.b.put(((Integer)localObject10).intValue(), localTroopAioKeywordTipInfo);
            i = 1;
            if (i != 0) {
              break label559;
            }
            if (localObject3 == null)
            {
              localArrayList = new ArrayList();
              if (localArrayList.contains(localObject10)) {
                break label612;
              }
              localArrayList.add(localObject10);
              break label612;
            }
          }
          else
          {
            ??? = localArrayList;
            label500:
            if ((??? != null) && (((List)???).size() > 0)) {
              ((akhp)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a((List)???, new aznf(this));
            }
            return;
          }
        }
      }
      continue;
      break label612;
      i = 0;
      continue;
      ??? = localObject5;
      break label184;
      ??? = localObject5;
      Object localObject6 = localObject7;
      localObject7 = ???;
      break label589;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAioKeywordTipManager.2
 * JD-Core Version:    0.7.0.1
 */