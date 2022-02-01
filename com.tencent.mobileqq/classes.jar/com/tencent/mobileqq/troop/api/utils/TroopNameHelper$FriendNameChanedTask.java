package com.tencent.mobileqq.troop.api.utils;

import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class TroopNameHelper$FriendNameChanedTask
  extends TroopNameHelper.Task
{
  String a;
  
  public TroopNameHelper$FriendNameChanedTask(TroopNameHelper paramTroopNameHelper, String paramString)
  {
    super(paramTroopNameHelper);
    this.a = paramString;
  }
  
  public void a()
  {
    Object localObject2 = ((ITroopInfoService)this.this$0.a.getRuntimeService(ITroopInfoService.class, "")).getUiTroopList();
    Object localObject1 = new ArrayList();
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      TroopInfo localTroopInfo = (TroopInfo)((Iterator)localObject2).next();
      if ((localTroopInfo != null) && (!localTroopInfo.hasSetTroopName()))
      {
        Object localObject3 = ((ITroopMemberInfoService)this.this$0.a.getRuntimeService(ITroopMemberInfoService.class, "")).getAllTroopMembers(localTroopInfo.troopuin);
        if (localObject3 != null)
        {
          int j = 0;
          localObject3 = ((List)localObject3).iterator();
          TroopMemberInfo localTroopMemberInfo;
          do
          {
            i = j;
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            localTroopMemberInfo = (TroopMemberInfo)((Iterator)localObject3).next();
          } while (!this.a.equals(localTroopMemberInfo.memberuin));
          int i = 1;
          if (i != 0) {
            ((ArrayList)localObject1).add(localTroopInfo.troopuin);
          }
        }
      }
    }
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      this.this$0.a((String)localObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.utils.TroopNameHelper.FriendNameChanedTask
 * JD-Core Version:    0.7.0.1
 */