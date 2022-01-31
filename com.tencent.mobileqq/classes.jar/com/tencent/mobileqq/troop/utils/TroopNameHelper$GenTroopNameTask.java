package com.tencent.mobileqq.troop.utils;

import ajjj;
import ajtg;
import android.text.TextUtils;
import azkk;
import azkl;
import azks;
import azlj;
import azzz;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class TroopNameHelper$GenTroopNameTask
  extends TroopNameHelper.Task
{
  azkk jdField_a_of_type_Azkk;
  String jdField_a_of_type_JavaLangString;
  
  TroopNameHelper$GenTroopNameTask(TroopNameHelper paramTroopNameHelper, String paramString, azkk paramazkk)
  {
    super(paramTroopNameHelper);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Azkk = paramazkk;
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
        this.this$0.jdField_a_of_type_Ajtg.a(Long.parseLong(this.jdField_a_of_type_JavaLangString), 0L, 1, 0, 0);
        this.this$0.b.put(this.jdField_a_of_type_JavaLangString, this);
        return;
      }
      if ((localObject2 != null) && (((List)localObject2).size() != 0) && ((localTroopInfo.wMemberNum <= 1) || (((List)localObject2).size() > 1))) {
        break;
      }
      localObject1 = (Long)this.this$0.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(this.jdField_a_of_type_JavaLangString);
    } while ((localObject1 != null) && (System.currentTimeMillis() - ((Long)localObject1).longValue() <= 86400000L));
    this.this$0.jdField_a_of_type_Ajtg.o(this.jdField_a_of_type_JavaLangString);
    this.this$0.b.put(this.jdField_a_of_type_JavaLangString, this);
    this.this$0.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(this.jdField_a_of_type_JavaLangString, Long.valueOf(System.currentTimeMillis()));
    return;
    azks localazks = (azks)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
    Iterator localIterator = ((List)localObject2).iterator();
    Object localObject3 = null;
    for (;;)
    {
      label262:
      if (localIterator.hasNext())
      {
        Object localObject4 = (TroopMemberInfo)localIterator.next();
        if ((azzz.d(((TroopMemberInfo)localObject4).memberuin)) && (!localazks.b(((TroopMemberInfo)localObject4).memberuin)) && (!((TroopMemberInfo)localObject4).memberuin.equals("50000000")))
        {
          localObject2 = new azkl(this);
          ((azkl)localObject2).jdField_a_of_type_JavaLangString = ((TroopMemberInfo)localObject4).memberuin;
          ((azkl)localObject2).jdField_b_of_type_JavaLangString = ((TroopMemberInfo)localObject4).friendnick;
          ((azkl)localObject2).c = ((TroopMemberInfo)localObject4).troopnick;
          ((azkl)localObject2).jdField_a_of_type_Boolean = azlj.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, ((azkl)localObject2).jdField_a_of_type_JavaLangString);
          ((azkl)localObject2).jdField_b_of_type_Boolean = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(((azkl)localObject2).jdField_a_of_type_JavaLangString);
          localObject4 = this.this$0.jdField_a_of_type_Ajjj.e(((azkl)localObject2).jdField_a_of_type_JavaLangString);
          if ((localObject4 != null) && (((Friends)localObject4).isFriend()))
          {
            ((azkl)localObject2).d = ((Friends)localObject4).remark;
            ((azkl)localObject2).jdField_b_of_type_JavaLangString = ((Friends)localObject4).name;
          }
          if ((localObject4 != null) && (((azkl)localObject2).jdField_b_of_type_Boolean)) {
            ((azkl)localObject2).jdField_b_of_type_JavaLangString = ((Friends)localObject4).name;
          }
          if (!TextUtils.isEmpty(((azkl)localObject2).c))
          {
            ((azkl)localObject2).e = ((azkl)localObject2).c;
            ((azkl)localObject2).f = ChnToSpell.a(((azkl)localObject2).c, 2);
            label498:
            if ((!((azkl)localObject2).jdField_b_of_type_Boolean) && (!((azkl)localObject2).jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(((azkl)localObject2).e))) {
              localArrayList.add(localObject2);
            }
            if (((azkl)localObject2).jdField_a_of_type_Boolean) {
              localObject3 = localObject2;
            }
            if (!((azkl)localObject2).jdField_b_of_type_Boolean) {
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
      if (!TextUtils.isEmpty(((azkl)localObject2).d))
      {
        ((azkl)localObject2).e = ((azkl)localObject2).d;
        ((azkl)localObject2).f = ChnToSpell.a(((azkl)localObject2).d, 2);
        break label498;
      }
      if (TextUtils.isEmpty(((azkl)localObject2).jdField_b_of_type_JavaLangString)) {
        break label498;
      }
      ((azkl)localObject2).e = ((azkl)localObject2).jdField_b_of_type_JavaLangString;
      ((azkl)localObject2).f = ChnToSpell.a(((azkl)localObject2).jdField_b_of_type_JavaLangString, 2);
      break label498;
      Collections.sort(localArrayList);
      if ((localObject3 != null) && (localObject1 != null))
      {
        if (!((azkl)localObject3).jdField_a_of_type_JavaLangString.equals(((azkl)localObject1).jdField_a_of_type_JavaLangString)) {
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
          localObject3 = (azkl)((Iterator)localObject2).next();
          if (!TextUtils.isEmpty(((azkl)localObject3).e)) {
            ((ArrayList)localObject1).add(((azkl)localObject3).e);
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
      this.this$0.jdField_a_of_type_Ajtg.notifyUI(116, true, new Object[] { localObject2, localObject1 });
      if (this.jdField_a_of_type_Azkk == null) {
        break;
      }
      this.jdField_a_of_type_Azkk.a(this.jdField_a_of_type_JavaLangString, (String)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopNameHelper.GenTroopNameTask
 * JD-Core Version:    0.7.0.1
 */