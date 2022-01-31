package com.tencent.mobileqq.troop.utils;

import alto;
import amdu;
import android.text.TextUtils;
import bcox;
import bcoy;
import bcpg;
import bcpx;
import bdeu;
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
  bcox jdField_a_of_type_Bcox;
  String jdField_a_of_type_JavaLangString;
  
  TroopNameHelper$GenTroopNameTask(TroopNameHelper paramTroopNameHelper, String paramString, bcox parambcox)
  {
    super(paramTroopNameHelper);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Bcox = parambcox;
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
        this.this$0.jdField_a_of_type_Amdu.a(Long.parseLong(this.jdField_a_of_type_JavaLangString), 0L, 1, 0, 0);
        this.this$0.b.put(this.jdField_a_of_type_JavaLangString, this);
        return;
      }
      if ((localObject2 != null) && (((List)localObject2).size() != 0) && ((localTroopInfo.wMemberNum <= 1) || (((List)localObject2).size() > 1))) {
        break;
      }
      localObject1 = (Long)this.this$0.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(this.jdField_a_of_type_JavaLangString);
    } while ((localObject1 != null) && (System.currentTimeMillis() - ((Long)localObject1).longValue() <= 86400000L));
    this.this$0.jdField_a_of_type_Amdu.o(this.jdField_a_of_type_JavaLangString);
    this.this$0.b.put(this.jdField_a_of_type_JavaLangString, this);
    this.this$0.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(this.jdField_a_of_type_JavaLangString, Long.valueOf(System.currentTimeMillis()));
    return;
    bcpg localbcpg = (bcpg)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
    Iterator localIterator = ((List)localObject2).iterator();
    Object localObject3 = null;
    for (;;)
    {
      label262:
      if (localIterator.hasNext())
      {
        Object localObject4 = (TroopMemberInfo)localIterator.next();
        if ((bdeu.d(((TroopMemberInfo)localObject4).memberuin)) && (!localbcpg.b(((TroopMemberInfo)localObject4).memberuin)) && (!((TroopMemberInfo)localObject4).memberuin.equals("50000000")))
        {
          localObject2 = new bcoy(this);
          ((bcoy)localObject2).jdField_a_of_type_JavaLangString = ((TroopMemberInfo)localObject4).memberuin;
          ((bcoy)localObject2).jdField_b_of_type_JavaLangString = ((TroopMemberInfo)localObject4).friendnick;
          ((bcoy)localObject2).c = ((TroopMemberInfo)localObject4).troopnick;
          ((bcoy)localObject2).jdField_a_of_type_Boolean = bcpx.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, ((bcoy)localObject2).jdField_a_of_type_JavaLangString);
          ((bcoy)localObject2).jdField_b_of_type_Boolean = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(((bcoy)localObject2).jdField_a_of_type_JavaLangString);
          localObject4 = this.this$0.jdField_a_of_type_Alto.e(((bcoy)localObject2).jdField_a_of_type_JavaLangString);
          if ((localObject4 != null) && (((Friends)localObject4).isFriend()))
          {
            ((bcoy)localObject2).d = ((Friends)localObject4).remark;
            ((bcoy)localObject2).jdField_b_of_type_JavaLangString = ((Friends)localObject4).name;
          }
          if ((localObject4 != null) && (((bcoy)localObject2).jdField_b_of_type_Boolean)) {
            ((bcoy)localObject2).jdField_b_of_type_JavaLangString = ((Friends)localObject4).name;
          }
          if (!TextUtils.isEmpty(((bcoy)localObject2).c))
          {
            ((bcoy)localObject2).e = ((bcoy)localObject2).c;
            ((bcoy)localObject2).f = ChnToSpell.a(((bcoy)localObject2).c, 2);
            label498:
            if ((!((bcoy)localObject2).jdField_b_of_type_Boolean) && (!((bcoy)localObject2).jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(((bcoy)localObject2).e))) {
              localArrayList.add(localObject2);
            }
            if (((bcoy)localObject2).jdField_a_of_type_Boolean) {
              localObject3 = localObject2;
            }
            if (!((bcoy)localObject2).jdField_b_of_type_Boolean) {
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
      if (!TextUtils.isEmpty(((bcoy)localObject2).d))
      {
        ((bcoy)localObject2).e = ((bcoy)localObject2).d;
        ((bcoy)localObject2).f = ChnToSpell.a(((bcoy)localObject2).d, 2);
        break label498;
      }
      if (TextUtils.isEmpty(((bcoy)localObject2).jdField_b_of_type_JavaLangString)) {
        break label498;
      }
      ((bcoy)localObject2).e = ((bcoy)localObject2).jdField_b_of_type_JavaLangString;
      ((bcoy)localObject2).f = ChnToSpell.a(((bcoy)localObject2).jdField_b_of_type_JavaLangString, 2);
      break label498;
      Collections.sort(localArrayList);
      if ((localObject3 != null) && (localObject1 != null))
      {
        if (!((bcoy)localObject3).jdField_a_of_type_JavaLangString.equals(((bcoy)localObject1).jdField_a_of_type_JavaLangString)) {
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
          localObject3 = (bcoy)((Iterator)localObject2).next();
          if (!TextUtils.isEmpty(((bcoy)localObject3).e)) {
            ((ArrayList)localObject1).add(((bcoy)localObject3).e);
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
      this.this$0.jdField_a_of_type_Amdu.notifyUI(116, true, new Object[] { localObject2, localObject1 });
      if (this.jdField_a_of_type_Bcox == null) {
        break;
      }
      this.jdField_a_of_type_Bcox.a(this.jdField_a_of_type_JavaLangString, (String)localObject1);
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