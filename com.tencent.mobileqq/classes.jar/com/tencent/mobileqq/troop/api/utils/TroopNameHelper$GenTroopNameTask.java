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
  String a;
  TroopNameHelper.GenTroopNameCallback b;
  
  public TroopNameHelper$GenTroopNameTask(TroopNameHelper paramTroopNameHelper, String paramString, TroopNameHelper.GenTroopNameCallback paramGenTroopNameCallback)
  {
    super(paramTroopNameHelper);
    this.a = paramString;
    this.b = paramGenTroopNameCallback;
  }
  
  private void a(List<TroopMemberInfo> paramList, List<TroopNameHelper.GenTroopNameTask.MemberInfo> paramList1)
  {
    Iterator localIterator = paramList.iterator();
    Object localObject1 = null;
    paramList = null;
    while (localIterator.hasNext())
    {
      Object localObject2 = (TroopMemberInfo)localIterator.next();
      if ((Utils.e(((TroopMemberInfo)localObject2).memberuin)) && (!TroopCommonConfig.b(this.this$0.a, ((TroopMemberInfo)localObject2).memberuin)) && (!((TroopMemberInfo)localObject2).memberuin.equals("50000000")))
      {
        TroopNameHelper.GenTroopNameTask.MemberInfo localMemberInfo = new TroopNameHelper.GenTroopNameTask.MemberInfo(this);
        localMemberInfo.a = ((TroopMemberInfo)localObject2).memberuin;
        localMemberInfo.b = ((TroopMemberInfo)localObject2).friendnick;
        localMemberInfo.c = ((TroopMemberInfo)localObject2).troopnick;
        localMemberInfo.e = TroopInfoUtil.a(this.this$0.a, this.a, localMemberInfo.a);
        localMemberInfo.f = this.this$0.a.getCurrentAccountUin().equals(localMemberInfo.a);
        localObject2 = ((IFriendDataService)this.this$0.a.getRuntimeService(IFriendDataService.class, "")).getFriend(localMemberInfo.a, true, true);
        if ((localObject2 != null) && (((Friends)localObject2).isFriend()))
        {
          localMemberInfo.d = ((Friends)localObject2).remark;
          localMemberInfo.b = ((Friends)localObject2).name;
        }
        if ((localObject2 != null) && (localMemberInfo.f)) {
          localMemberInfo.b = ((Friends)localObject2).name;
        }
        if (!TextUtils.isEmpty(localMemberInfo.c))
        {
          localMemberInfo.g = localMemberInfo.c;
          localMemberInfo.h = ChnToSpell.b(localMemberInfo.c, 2);
        }
        else if (!TextUtils.isEmpty(localMemberInfo.d))
        {
          localMemberInfo.g = localMemberInfo.d;
          localMemberInfo.h = ChnToSpell.b(localMemberInfo.d, 2);
        }
        else if (!TextUtils.isEmpty(localMemberInfo.b))
        {
          localMemberInfo.g = localMemberInfo.b;
          localMemberInfo.h = ChnToSpell.b(localMemberInfo.b, 2);
        }
        if ((!localMemberInfo.f) && (!localMemberInfo.e) && (!TextUtils.isEmpty(localMemberInfo.g))) {
          paramList1.add(localMemberInfo);
        }
        localObject2 = localObject1;
        if (localMemberInfo.e) {
          localObject2 = localMemberInfo;
        }
        localObject1 = localObject2;
        if (localMemberInfo.f)
        {
          paramList = localMemberInfo;
          localObject1 = localObject2;
        }
      }
    }
    Collections.sort(paramList1);
    if ((localObject1 != null) && (paramList != null))
    {
      if (localObject1.a.equals(paramList.a))
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
    Object localObject2 = (ITroopMemberInfoService)this.this$0.a.getRuntimeService(ITroopMemberInfoService.class, "");
    Object localObject1 = (ITroopInfoService)this.this$0.a.getRuntimeService(ITroopInfoService.class, "");
    Object localObject3 = ((ITroopMemberInfoService)localObject2).getAllTroopMembers(this.a);
    localObject3 = ((ITroopMemberInfoService)localObject2).enhanceTroopMemberList(this.a, (List)localObject3);
    Object localObject4 = new ArrayList();
    localObject2 = ((ITroopInfoService)localObject1).getTroopInfo(this.a);
    if (localObject2 == null) {
      return;
    }
    if (TextUtils.isEmpty(((TroopInfo)localObject2).troopowneruin))
    {
      localObject1 = (TroopMemberListHandler)((AppInterface)this.this$0.a).getBusinessHandler(TroopMemberListHandler.class.getName());
      if (localObject1 != null) {
        ((TroopMemberListHandler)localObject1).a(Long.parseLong(this.a), 0L, 1, 0, 0);
      }
      this.this$0.e.put(this.a, this);
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
        if (!TextUtils.isEmpty(localMemberInfo.g)) {
          ((ArrayList)localObject3).add(localMemberInfo.g);
        }
      }
      localObject3 = this.this$0.a((ArrayList)localObject3);
      ((TroopInfo)localObject2).newTroopName = ((String)localObject3);
      ((TroopInfo)localObject2).newTroopNameTimeStamp = System.currentTimeMillis();
      ((ITroopInfoService)localObject1).saveTroopInfo((TroopInfo)localObject2);
      localObject1 = this.a;
      ((TroopInfoHandler)((AppInterface)this.this$0.a).getBusinessHandler(TroopInfoHandler.class.getName())).notifyUI(TroopObserver.TYPE_GEN_NEW_TROOP_NAME, true, new Object[] { localObject1, localObject3 });
      localObject1 = this.b;
      if (localObject1 != null) {
        ((TroopNameHelper.GenTroopNameCallback)localObject1).a(this.a, (String)localObject3);
      }
      return;
    }
    localObject1 = (Long)this.this$0.d.get(this.a);
    if ((localObject1 == null) || (System.currentTimeMillis() - ((Long)localObject1).longValue() > 86400000L))
    {
      localObject1 = (ITroopMemberListHandler)((AppInterface)this.this$0.a).getBusinessHandler(TroopMemberListHandler.class.getName());
      if (localObject1 != null) {
        ((ITroopMemberListHandler)localObject1).a(this.a);
      }
      this.this$0.e.put(this.a, this);
      this.this$0.d.put(this.a, Long.valueOf(System.currentTimeMillis()));
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof GenTroopNameTask)) {
      return ((GenTroopNameTask)paramObject).a.equals(this.a);
    }
    return super.equals(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.utils.TroopNameHelper.GenTroopNameTask
 * JD-Core Version:    0.7.0.1
 */