package com.tencent.mobileqq.troop.logic;

import amdu;
import amnz;
import android.text.TextUtils;
import bcgz;
import bcha;
import bdfx;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class TroopSearchLogic$TroopSearchTask
  implements Runnable
{
  bcha jdField_a_of_type_Bcha;
  ArrayList<ResultRecord> jdField_a_of_type_JavaUtilArrayList;
  
  TroopSearchLogic$TroopSearchTask(bcha parambcha, ArrayList<ResultRecord> paramArrayList)
  {
    this.jdField_a_of_type_Bcha = paramArrayList;
    Object localObject;
    this.jdField_a_of_type_JavaUtilArrayList = localObject;
  }
  
  private void a(ArrayList<bcgz> paramArrayList)
  {
    if (this.jdField_a_of_type_Bcha != null) {
      this.jdField_a_of_type_Bcha.a(paramArrayList);
    }
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (paramInt2 <= 5)
    {
      if (paramInt1 <= 20) {}
    }
    else {
      do
      {
        return false;
        if ((paramInt2 <= 6) || (paramInt2 >= 20) || (paramInt1 <= 50)) {
          break;
        }
      } while (paramInt1 > 50);
    }
    while ((paramInt2 < 20) || (paramInt1 <= 100)) {
      return true;
    }
    return false;
  }
  
  public void run()
  {
    Object localObject1 = (amdu)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
    localObject1 = new ArrayList();
    Object localObject2 = new ArrayList(this.this$0.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a());
    if ((localObject2 == null) || (((List)localObject2).size() == 0))
    {
      a((ArrayList)localObject1);
      return;
    }
    int i = ((List)localObject2).size() - 1;
    TroopInfo localTroopInfo;
    while (i >= 0)
    {
      localTroopInfo = (TroopInfo)((List)localObject2).get(i);
      if (!a(localTroopInfo.wMemberNum, this.jdField_a_of_type_JavaUtilArrayList.size())) {
        ((List)localObject2).remove(localTroopInfo);
      }
      i -= 1;
    }
    int k = this.jdField_a_of_type_JavaUtilArrayList.size();
    localObject2 = ((List)localObject2).iterator();
    List localList;
    Object localObject3;
    for (;;)
    {
      if (((Iterator)localObject2).hasNext())
      {
        localTroopInfo = (TroopInfo)((Iterator)localObject2).next();
        localList = this.this$0.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(localTroopInfo.troopuin);
        if ((localList != null) && (localList.size() > 0) && (a(localList.size(), this.jdField_a_of_type_JavaUtilArrayList.size())) && (this.jdField_a_of_type_JavaUtilArrayList.size() == localList.size()))
        {
          localObject3 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          i = 1;
          label253:
          if (((Iterator)localObject3).hasNext())
          {
            ResultRecord localResultRecord = (ResultRecord)((Iterator)localObject3).next();
            Iterator localIterator = localList.iterator();
            TroopMemberInfo localTroopMemberInfo;
            do
            {
              if (!localIterator.hasNext()) {
                break;
              }
              localTroopMemberInfo = (TroopMemberInfo)localIterator.next();
            } while (!TextUtils.equals(localResultRecord.jdField_a_of_type_JavaLangString, localTroopMemberInfo.memberuin));
          }
        }
      }
    }
    for (int j = 1;; j = 0)
    {
      if (j == 0) {
        i = 0;
      }
      for (;;)
      {
        break label253;
        if (i == 0) {
          break label451;
        }
        localObject3 = new bcgz();
        ((bcgz)localObject3).jdField_a_of_type_ComTencentMobileqqDataTroopInfo = localTroopInfo;
        ((bcgz)localObject3).jdField_a_of_type_Int = localList.size();
        ((bcgz)localObject3).jdField_a_of_type_JavaLangString = ChnToSpell.a(localTroopInfo.getTroopName(), 1).jdField_a_of_type_JavaLangString;
        localTroopInfo.lastMsgTime = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(localTroopInfo.troopuin, 1).lastmsgtime;
        if (k != ((bcgz)localObject3).jdField_a_of_type_Int) {
          break;
        }
        ((bcgz)localObject3).b = 1;
        ((ArrayList)localObject1).add(localObject3);
        break;
        Collections.sort((List)localObject1);
        a((ArrayList)localObject1);
        return;
      }
      label451:
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.logic.TroopSearchLogic.TroopSearchTask
 * JD-Core Version:    0.7.0.1
 */