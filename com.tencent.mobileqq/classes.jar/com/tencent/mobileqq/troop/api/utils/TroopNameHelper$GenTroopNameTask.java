package com.tencent.mobileqq.troop.api.utils;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.troop.api.ITroopHandlerService;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService;
import com.tencent.mobileqq.troop.api.config.TroopCommonConfig;
import com.tencent.mobileqq.troop.handler.TroopMemberInfoHandler;
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
  
  public void a()
  {
    Object localObject1 = null;
    Object localObject2 = (ITroopMemberInfoService)this.this$0.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ITroopMemberInfoService.class, "");
    ITroopInfoService localITroopInfoService = (ITroopInfoService)this.this$0.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ITroopInfoService.class, "");
    Object localObject3 = ((ITroopMemberInfoService)localObject2).getAllTroopMembers(this.jdField_a_of_type_JavaLangString);
    localObject2 = ((ITroopMemberInfoService)localObject2).enhanceTroopMemberList(this.jdField_a_of_type_JavaLangString, (List)localObject3);
    ArrayList localArrayList = new ArrayList();
    TroopInfo localTroopInfo = localITroopInfoService.getTroopInfo(this.jdField_a_of_type_JavaLangString);
    if (localTroopInfo == null) {}
    do
    {
      return;
      if (TextUtils.isEmpty(localTroopInfo.troopowneruin))
      {
        ((ITroopHandlerService)this.this$0.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ITroopHandlerService.class, "")).send_oidb_0x899_0(Long.parseLong(this.jdField_a_of_type_JavaLangString), 0L, 1, 0, 0);
        this.this$0.b.put(this.jdField_a_of_type_JavaLangString, this);
        return;
      }
      if ((localObject2 != null) && (((List)localObject2).size() != 0) && ((localTroopInfo.wMemberNum <= 1) || (((List)localObject2).size() > 1))) {
        break;
      }
      localObject1 = (Long)this.this$0.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(this.jdField_a_of_type_JavaLangString);
    } while ((localObject1 != null) && (System.currentTimeMillis() - ((Long)localObject1).longValue() <= 86400000L));
    localObject1 = (TroopMemberInfoHandler)((AppInterface)this.this$0.jdField_a_of_type_MqqAppAppRuntime).getBusinessHandler(TroopMemberInfoHandler.class.getName());
    if (localObject1 != null) {
      ((TroopMemberInfoHandler)localObject1).a(this.jdField_a_of_type_JavaLangString);
    }
    this.this$0.b.put(this.jdField_a_of_type_JavaLangString, this);
    this.this$0.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(this.jdField_a_of_type_JavaLangString, Long.valueOf(System.currentTimeMillis()));
    return;
    Iterator localIterator = ((List)localObject2).iterator();
    localObject3 = null;
    label557:
    for (;;)
    {
      label302:
      if (localIterator.hasNext())
      {
        Object localObject4 = (TroopMemberInfo)localIterator.next();
        if ((Utils.d(((TroopMemberInfo)localObject4).memberuin)) && (!TroopCommonConfig.b(this.this$0.jdField_a_of_type_MqqAppAppRuntime, ((TroopMemberInfo)localObject4).memberuin)) && (!((TroopMemberInfo)localObject4).memberuin.equals("50000000")))
        {
          localObject2 = new TroopNameHelper.GenTroopNameTask.MemberInfo(this);
          ((TroopNameHelper.GenTroopNameTask.MemberInfo)localObject2).jdField_a_of_type_JavaLangString = ((TroopMemberInfo)localObject4).memberuin;
          ((TroopNameHelper.GenTroopNameTask.MemberInfo)localObject2).jdField_b_of_type_JavaLangString = ((TroopMemberInfo)localObject4).friendnick;
          ((TroopNameHelper.GenTroopNameTask.MemberInfo)localObject2).c = ((TroopMemberInfo)localObject4).troopnick;
          ((TroopNameHelper.GenTroopNameTask.MemberInfo)localObject2).jdField_a_of_type_Boolean = TroopInfoUtil.a(this.this$0.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_JavaLangString, ((TroopNameHelper.GenTroopNameTask.MemberInfo)localObject2).jdField_a_of_type_JavaLangString);
          ((TroopNameHelper.GenTroopNameTask.MemberInfo)localObject2).jdField_b_of_type_Boolean = this.this$0.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin().equals(((TroopNameHelper.GenTroopNameTask.MemberInfo)localObject2).jdField_a_of_type_JavaLangString);
          localObject4 = ((IFriendDataService)this.this$0.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IFriendDataService.class, "")).getFriend(((TroopNameHelper.GenTroopNameTask.MemberInfo)localObject2).jdField_a_of_type_JavaLangString, true, true);
          if ((localObject4 != null) && (((Friends)localObject4).isFriend()))
          {
            ((TroopNameHelper.GenTroopNameTask.MemberInfo)localObject2).d = ((Friends)localObject4).remark;
            ((TroopNameHelper.GenTroopNameTask.MemberInfo)localObject2).jdField_b_of_type_JavaLangString = ((Friends)localObject4).name;
          }
          if ((localObject4 != null) && (((TroopNameHelper.GenTroopNameTask.MemberInfo)localObject2).jdField_b_of_type_Boolean)) {
            ((TroopNameHelper.GenTroopNameTask.MemberInfo)localObject2).jdField_b_of_type_JavaLangString = ((Friends)localObject4).name;
          }
          if (!TextUtils.isEmpty(((TroopNameHelper.GenTroopNameTask.MemberInfo)localObject2).c))
          {
            ((TroopNameHelper.GenTroopNameTask.MemberInfo)localObject2).e = ((TroopNameHelper.GenTroopNameTask.MemberInfo)localObject2).c;
            ((TroopNameHelper.GenTroopNameTask.MemberInfo)localObject2).f = ChnToSpell.a(((TroopNameHelper.GenTroopNameTask.MemberInfo)localObject2).c, 2);
            if ((!((TroopNameHelper.GenTroopNameTask.MemberInfo)localObject2).jdField_b_of_type_Boolean) && (!((TroopNameHelper.GenTroopNameTask.MemberInfo)localObject2).jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(((TroopNameHelper.GenTroopNameTask.MemberInfo)localObject2).e))) {
              localArrayList.add(localObject2);
            }
            if (((TroopNameHelper.GenTroopNameTask.MemberInfo)localObject2).jdField_a_of_type_Boolean) {
              localObject3 = localObject2;
            }
            if (!((TroopNameHelper.GenTroopNameTask.MemberInfo)localObject2).jdField_b_of_type_Boolean) {
              break label897;
            }
            localObject1 = localObject2;
          }
        }
      }
    }
    label897:
    for (;;)
    {
      break label302;
      if (!TextUtils.isEmpty(((TroopNameHelper.GenTroopNameTask.MemberInfo)localObject2).d))
      {
        ((TroopNameHelper.GenTroopNameTask.MemberInfo)localObject2).e = ((TroopNameHelper.GenTroopNameTask.MemberInfo)localObject2).d;
        ((TroopNameHelper.GenTroopNameTask.MemberInfo)localObject2).f = ChnToSpell.a(((TroopNameHelper.GenTroopNameTask.MemberInfo)localObject2).d, 2);
        break label557;
      }
      if (TextUtils.isEmpty(((TroopNameHelper.GenTroopNameTask.MemberInfo)localObject2).jdField_b_of_type_JavaLangString)) {
        break label557;
      }
      ((TroopNameHelper.GenTroopNameTask.MemberInfo)localObject2).e = ((TroopNameHelper.GenTroopNameTask.MemberInfo)localObject2).jdField_b_of_type_JavaLangString;
      ((TroopNameHelper.GenTroopNameTask.MemberInfo)localObject2).f = ChnToSpell.a(((TroopNameHelper.GenTroopNameTask.MemberInfo)localObject2).jdField_b_of_type_JavaLangString, 2);
      break label557;
      Collections.sort(localArrayList);
      if ((localObject3 != null) && (localObject1 != null))
      {
        if (!((TroopNameHelper.GenTroopNameTask.MemberInfo)localObject3).jdField_a_of_type_JavaLangString.equals(((TroopNameHelper.GenTroopNameTask.MemberInfo)localObject1).jdField_a_of_type_JavaLangString)) {
          break label776;
        }
        localArrayList.add(localArrayList.size(), localObject3);
      }
      for (;;)
      {
        localObject1 = new ArrayList();
        localObject2 = localArrayList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (TroopNameHelper.GenTroopNameTask.MemberInfo)((Iterator)localObject2).next();
          if (!TextUtils.isEmpty(((TroopNameHelper.GenTroopNameTask.MemberInfo)localObject3).e)) {
            ((ArrayList)localObject1).add(((TroopNameHelper.GenTroopNameTask.MemberInfo)localObject3).e);
          }
        }
        label776:
        localArrayList.add(0, localObject3);
        localArrayList.add(localArrayList.size(), localObject1);
      }
      localObject1 = this.this$0.a((ArrayList)localObject1);
      localTroopInfo.newTroopName = ((String)localObject1);
      localTroopInfo.newTroopNameTimeStamp = System.currentTimeMillis();
      localITroopInfoService.saveTroopInfo(localTroopInfo);
      localObject2 = this.jdField_a_of_type_JavaLangString;
      ((ITroopHandlerService)this.this$0.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ITroopHandlerService.class, "")).notifyUI_genNewTroopName(true, new Object[] { localObject2, localObject1 });
      if (this.jdField_a_of_type_ComTencentMobileqqTroopApiUtilsTroopNameHelper$GenTroopNameCallback == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopApiUtilsTroopNameHelper$GenTroopNameCallback.a(this.jdField_a_of_type_JavaLangString, (String)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.utils.TroopNameHelper.GenTroopNameTask
 * JD-Core Version:    0.7.0.1
 */