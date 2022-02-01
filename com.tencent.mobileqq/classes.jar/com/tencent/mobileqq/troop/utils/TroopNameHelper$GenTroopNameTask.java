package com.tencent.mobileqq.troop.utils;

import amsw;
import anca;
import android.text.TextUtils;
import bfdd;
import bfde;
import bfdm;
import bftf;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class TroopNameHelper$GenTroopNameTask
  extends TroopNameHelper.Task
{
  bfdd jdField_a_of_type_Bfdd;
  String jdField_a_of_type_JavaLangString;
  
  TroopNameHelper$GenTroopNameTask(TroopNameHelper paramTroopNameHelper, String paramString, bfdd parambfdd)
  {
    super(paramTroopNameHelper);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Bfdd = parambfdd;
  }
  
  public void a()
  {
    Object localObject1 = null;
    Object localObject2 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(this.jdField_a_of_type_JavaLangString);
    localObject2 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(this.jdField_a_of_type_JavaLangString, (List)localObject2);
    ArrayList localArrayList = new ArrayList();
    TroopInfo localTroopInfo = this.this$0.jdField_a_of_type_ComTencentMobileqqAppTroopManager.c(this.jdField_a_of_type_JavaLangString);
    if (localTroopInfo == null) {}
    do
    {
      return;
      if (TextUtils.isEmpty(localTroopInfo.troopowneruin))
      {
        this.this$0.jdField_a_of_type_Anca.a(Long.parseLong(this.jdField_a_of_type_JavaLangString), 0L, 1, 0, 0);
        this.this$0.b.put(this.jdField_a_of_type_JavaLangString, this);
        return;
      }
      if ((localObject2 != null) && (((List)localObject2).size() != 0) && ((localTroopInfo.wMemberNum <= 1) || (((List)localObject2).size() > 1))) {
        break;
      }
      localObject1 = (Long)this.this$0.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(this.jdField_a_of_type_JavaLangString);
    } while ((localObject1 != null) && (System.currentTimeMillis() - ((Long)localObject1).longValue() <= 86400000L));
    this.this$0.jdField_a_of_type_Anca.o(this.jdField_a_of_type_JavaLangString);
    this.this$0.b.put(this.jdField_a_of_type_JavaLangString, this);
    this.this$0.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(this.jdField_a_of_type_JavaLangString, Long.valueOf(System.currentTimeMillis()));
    return;
    bfdm localbfdm = (bfdm)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
    Iterator localIterator = ((List)localObject2).iterator();
    Object localObject3 = null;
    for (;;)
    {
      label262:
      if (localIterator.hasNext())
      {
        Object localObject4 = (TroopMemberInfo)localIterator.next();
        if ((bftf.d(((TroopMemberInfo)localObject4).memberuin)) && (!localbfdm.b(((TroopMemberInfo)localObject4).memberuin)) && (!((TroopMemberInfo)localObject4).memberuin.equals("50000000")))
        {
          localObject2 = new bfde(this);
          ((bfde)localObject2).jdField_a_of_type_JavaLangString = ((TroopMemberInfo)localObject4).memberuin;
          ((bfde)localObject2).jdField_b_of_type_JavaLangString = ((TroopMemberInfo)localObject4).friendnick;
          ((bfde)localObject2).c = ((TroopMemberInfo)localObject4).troopnick;
          ((bfde)localObject2).jdField_a_of_type_Boolean = TroopUtils.isTroopOwner(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, ((bfde)localObject2).jdField_a_of_type_JavaLangString);
          ((bfde)localObject2).jdField_b_of_type_Boolean = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(((bfde)localObject2).jdField_a_of_type_JavaLangString);
          localObject4 = this.this$0.jdField_a_of_type_Amsw.e(((bfde)localObject2).jdField_a_of_type_JavaLangString);
          if ((localObject4 != null) && (((Friends)localObject4).isFriend()))
          {
            ((bfde)localObject2).d = ((Friends)localObject4).remark;
            ((bfde)localObject2).jdField_b_of_type_JavaLangString = ((Friends)localObject4).name;
          }
          if ((localObject4 != null) && (((bfde)localObject2).jdField_b_of_type_Boolean)) {
            ((bfde)localObject2).jdField_b_of_type_JavaLangString = ((Friends)localObject4).name;
          }
          if (!TextUtils.isEmpty(((bfde)localObject2).c))
          {
            ((bfde)localObject2).e = ((bfde)localObject2).c;
            ((bfde)localObject2).f = ChnToSpell.a(((bfde)localObject2).c, 2);
            label498:
            if ((!((bfde)localObject2).jdField_b_of_type_Boolean) && (!((bfde)localObject2).jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(((bfde)localObject2).e))) {
              localArrayList.add(localObject2);
            }
            if (((bfde)localObject2).jdField_a_of_type_Boolean) {
              localObject3 = localObject2;
            }
            if (!((bfde)localObject2).jdField_b_of_type_Boolean) {
              break label827;
            }
            localObject1 = localObject2;
          }
        }
      }
    }
    label827:
    for (;;)
    {
      break label262;
      if (!TextUtils.isEmpty(((bfde)localObject2).d))
      {
        ((bfde)localObject2).e = ((bfde)localObject2).d;
        ((bfde)localObject2).f = ChnToSpell.a(((bfde)localObject2).d, 2);
        break label498;
      }
      if (TextUtils.isEmpty(((bfde)localObject2).jdField_b_of_type_JavaLangString)) {
        break label498;
      }
      ((bfde)localObject2).e = ((bfde)localObject2).jdField_b_of_type_JavaLangString;
      ((bfde)localObject2).f = ChnToSpell.a(((bfde)localObject2).jdField_b_of_type_JavaLangString, 2);
      break label498;
      Collections.sort(localArrayList);
      if ((localObject3 != null) && (localObject1 != null))
      {
        if (!((bfde)localObject3).jdField_a_of_type_JavaLangString.equals(((bfde)localObject1).jdField_a_of_type_JavaLangString)) {
          break label717;
        }
        localArrayList.add(localArrayList.size(), localObject3);
      }
      for (;;)
      {
        localObject1 = new ArrayList();
        localObject2 = localArrayList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (bfde)((Iterator)localObject2).next();
          if (!TextUtils.isEmpty(((bfde)localObject3).e)) {
            ((ArrayList)localObject1).add(((bfde)localObject3).e);
          }
        }
        label717:
        localArrayList.add(0, localObject3);
        localArrayList.add(localArrayList.size(), localObject1);
      }
      localObject1 = TroopNameHelper.a((ArrayList)localObject1);
      localTroopInfo.newTroopName = ((String)localObject1);
      localTroopInfo.newTroopNameTimeStamp = System.currentTimeMillis();
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(localTroopInfo);
      localObject2 = this.jdField_a_of_type_JavaLangString;
      this.this$0.jdField_a_of_type_Anca.notifyUI(116, true, new Object[] { localObject2, localObject1 });
      if (this.jdField_a_of_type_Bfdd == null) {
        break;
      }
      this.jdField_a_of_type_Bfdd.a(this.jdField_a_of_type_JavaLangString, (String)localObject1);
      return;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof GenTroopNameTask)) {
      return ((GenTroopNameTask)paramObject).jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString);
    }
    return super.equals(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopNameHelper.GenTroopNameTask
 * JD-Core Version:    0.7.0.1
 */