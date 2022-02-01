package com.tencent.mobileqq.troop.api.utils;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService;
import com.tencent.mobileqq.troop.api.config.TroopCommonConfig;
import com.tencent.mobileqq.troop.api.handler.ITroopMemberListHandler;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.handler.TroopInfoHandler;
import com.tencent.mobileqq.troop.handler.TroopMemberListHandler;
import com.tencent.mobileqq.troop.util.TroopInfoUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

public class TroopNameHelper$GenTroopNameTask
  extends TroopNameHelper.Task
{
  TroopNameHelper.GenTroopNameCallback jdField_a_of_type_ComTencentMobileqqTroopApiUtilsTroopNameHelper$GenTroopNameCallback;
  String jdField_a_of_type_JavaLangString;
  
  public TroopNameHelper$GenTroopNameTask(TroopNameHelper paramTroopNameHelper, String paramString, TroopNameHelper.GenTroopNameCallback paramGenTroopNameCallback)
  {
    super(paramTroopNameHelper);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqTroopApiUtilsTroopNameHelper$GenTroopNameCallback = paramGenTroopNameCallback;
  }
  
  private void a(List<TroopMemberInfo> paramList, List<TroopNameHelper.GenTroopNameTask.MemberInfo> paramList1)
  {
    Iterator localIterator = paramList.iterator();
    Object localObject1 = null;
    paramList = null;
    while (localIterator.hasNext())
    {
      Object localObject2 = (TroopMemberInfo)localIterator.next();
      if ((Utils.d(((TroopMemberInfo)localObject2).memberuin)) && (!TroopCommonConfig.b(this.this$0.jdField_a_of_type_MqqAppAppRuntime, ((TroopMemberInfo)localObject2).memberuin)) && (!((TroopMemberInfo)localObject2).memberuin.equals("50000000")))
      {
        TroopNameHelper.GenTroopNameTask.MemberInfo localMemberInfo = new TroopNameHelper.GenTroopNameTask.MemberInfo(this);
        localMemberInfo.jdField_a_of_type_JavaLangString = ((TroopMemberInfo)localObject2).memberuin;
        localMemberInfo.jdField_b_of_type_JavaLangString = ((TroopMemberInfo)localObject2).friendnick;
        localMemberInfo.c = ((TroopMemberInfo)localObject2).troopnick;
        localMemberInfo.jdField_a_of_type_Boolean = TroopInfoUtil.a(this.this$0.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_JavaLangString, localMemberInfo.jdField_a_of_type_JavaLangString);
        localMemberInfo.jdField_b_of_type_Boolean = this.this$0.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin().equals(localMemberInfo.jdField_a_of_type_JavaLangString);
        localObject2 = ((IFriendDataService)this.this$0.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IFriendDataService.class, "")).getFriend(localMemberInfo.jdField_a_of_type_JavaLangString, true, true);
        if ((localObject2 != null) && (((Friends)localObject2).isFriend()))
        {
          localMemberInfo.d = ((Friends)localObject2).remark;
          localMemberInfo.jdField_b_of_type_JavaLangString = ((Friends)localObject2).name;
        }
        if ((localObject2 != null) && (localMemberInfo.jdField_b_of_type_Boolean)) {
          localMemberInfo.jdField_b_of_type_JavaLangString = ((Friends)localObject2).name;
        }
        if (!TextUtils.isEmpty(localMemberInfo.c))
        {
          localMemberInfo.e = localMemberInfo.c;
          localMemberInfo.f = ChnToSpell.a(localMemberInfo.c, 2);
        }
        else if (!TextUtils.isEmpty(localMemberInfo.d))
        {
          localMemberInfo.e = localMemberInfo.d;
          localMemberInfo.f = ChnToSpell.a(localMemberInfo.d, 2);
        }
        else if (!TextUtils.isEmpty(localMemberInfo.jdField_b_of_type_JavaLangString))
        {
          localMemberInfo.e = localMemberInfo.jdField_b_of_type_JavaLangString;
          localMemberInfo.f = ChnToSpell.a(localMemberInfo.jdField_b_of_type_JavaLangString, 2);
        }
        if ((!localMemberInfo.jdField_b_of_type_Boolean) && (!localMemberInfo.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(localMemberInfo.e))) {
          paramList1.add(localMemberInfo);
        }
        localObject2 = localObject1;
        if (localMemberInfo.jdField_a_of_type_Boolean) {
          localObject2 = localMemberInfo;
        }
        localObject1 = localObject2;
        if (localMemberInfo.jdField_b_of_type_Boolean)
        {
          paramList = localMemberInfo;
          localObject1 = localObject2;
        }
      }
    }
    Collections.sort(paramList1);
    if ((localObject1 != null) && (paramList != null))
    {
      if (localObject1.jdField_a_of_type_JavaLangString.equals(paramList.jdField_a_of_type_JavaLangString))
      {
        paramList1.add(paramList1.size(), localObject1);
        return;
      }
      paramList1.add(0, localObject1);
      paramList1.add(paramList1.size(), paramList);
    }
  }
  
  public void a()
  {
    Object localObject2 = (ITroopMemberInfoService)this.this$0.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ITroopMemberInfoService.class, "");
    Object localObject1 = (ITroopInfoService)this.this$0.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ITroopInfoService.class, "");
    Object localObject3 = ((ITroopMemberInfoService)localObject2).getAllTroopMembers(this.jdField_a_of_type_JavaLangString);
    localObject3 = ((ITroopMemberInfoService)localObject2).enhanceTroopMemberList(this.jdField_a_of_type_JavaLangString, (List)localObject3);
    Object localObject4 = new ArrayList();
    localObject2 = ((ITroopInfoService)localObject1).getTroopInfo(this.jdField_a_of_type_JavaLangString);
    if (localObject2 == null) {
      return;
    }
    if (TextUtils.isEmpty(((TroopInfo)localObject2).troopowneruin))
    {
      localObject1 = (TroopMemberListHandler)((AppInterface)this.this$0.jdField_a_of_type_MqqAppAppRuntime).getBusinessHandler(TroopMemberListHandler.class.getName());
      if (localObject1 != null) {
        ((TroopMemberListHandler)localObject1).a(Long.parseLong(this.jdField_a_of_type_JavaLangString), 0L, 1, 0, 0);
      }
      this.this$0.b.put(this.jdField_a_of_type_JavaLangString, this);
      return;
    }
    if ((localObject3 != null) && (((List)localObject3).size() != 0) && ((((TroopInfo)localObject2).wMemberNum <= 1) || (((List)localObject3).size() > 1)))
    {
      a((List)localObject3, (List)localObject4);
      localObject3 = new ArrayList();
      localObject4 = ((List)localObject4).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        TroopNameHelper.GenTroopNameTask.MemberInfo localMemberInfo = (TroopNameHelper.GenTroopNameTask.MemberInfo)((Iterator)localObject4).next();
        if (!TextUtils.isEmpty(localMemberInfo.e)) {
          ((ArrayList)localObject3).add(localMemberInfo.e);
        }
      }
      localObject3 = this.this$0.a((ArrayList)localObject3);
      ((TroopInfo)localObject2).newTroopName = ((String)localObject3);
      ((TroopInfo)localObject2).newTroopNameTimeStamp = System.currentTimeMillis();
      ((ITroopInfoService)localObject1).saveTroopInfo((TroopInfo)localObject2);
      localObject1 = this.jdField_a_of_type_JavaLangString;
      ((TroopInfoHandler)((AppInterface)this.this$0.jdField_a_of_type_MqqAppAppRuntime).getBusinessHandler(TroopInfoHandler.class.getName())).notifyUI(TroopObserver.TYPE_GEN_NEW_TROOP_NAME, true, new Object[] { localObject1, localObject3 });
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopApiUtilsTroopNameHelper$GenTroopNameCallback;
      if (localObject1 != null) {
        ((TroopNameHelper.GenTroopNameCallback)localObject1).a(this.jdField_a_of_type_JavaLangString, (String)localObject3);
      }
      return;
    }
    localObject1 = (Long)this.this$0.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(this.jdField_a_of_type_JavaLangString);
    if ((localObject1 == null) || (System.currentTimeMillis() - ((Long)localObject1).longValue() > 86400000L))
    {
      localObject1 = (ITroopMemberListHandler)((AppInterface)this.this$0.jdField_a_of_type_MqqAppAppRuntime).getBusinessHandler(TroopMemberListHandler.class.getName());
      if (localObject1 != null) {
        ((ITroopMemberListHandler)localObject1).a(this.jdField_a_of_type_JavaLangString);
      }
      this.this$0.b.put(this.jdField_a_of_type_JavaLangString, this);
      this.this$0.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(this.jdField_a_of_type_JavaLangString, Long.valueOf(System.currentTimeMillis()));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.utils.TroopNameHelper.GenTroopNameTask
 * JD-Core Version:    0.7.0.1
 */