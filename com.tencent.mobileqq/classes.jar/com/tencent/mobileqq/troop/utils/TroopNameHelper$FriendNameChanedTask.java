package com.tencent.mobileqq.troop.utils;

import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TroopNameHelper$FriendNameChanedTask
  extends TroopNameHelper.Task
{
  String a;
  
  TroopNameHelper$FriendNameChanedTask(TroopNameHelper paramTroopNameHelper, String paramString)
  {
    super(paramTroopNameHelper);
    this.a = paramString;
  }
  
  public void a()
  {
    Object localObject2 = this.this$0.a.a();
    Object localObject1 = new ArrayList();
    localObject2 = ((List)localObject2).iterator();
    label182:
    for (;;)
    {
      TroopInfo localTroopInfo;
      if (((Iterator)localObject2).hasNext())
      {
        localTroopInfo = (TroopInfo)((Iterator)localObject2).next();
        if ((localTroopInfo != null) && (!localTroopInfo.hasSetTroopName()))
        {
          Object localObject3 = this.this$0.a.b(localTroopInfo.troopuin);
          if (localObject3 != null)
          {
            localObject3 = ((List)localObject3).iterator();
            TroopMemberInfo localTroopMemberInfo;
            do
            {
              if (!((Iterator)localObject3).hasNext()) {
                break;
              }
              localTroopMemberInfo = (TroopMemberInfo)((Iterator)localObject3).next();
            } while (!this.a.equals(localTroopMemberInfo.memberuin));
          }
        }
      }
      else
      {
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label182;
          }
          ((ArrayList)localObject1).add(localTroopInfo.troopuin);
          break;
          localObject1 = ((ArrayList)localObject1).iterator();
          while (((Iterator)localObject1).hasNext()) {
            TroopNameHelper.a((String)((Iterator)localObject1).next());
          }
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopNameHelper.FriendNameChanedTask
 * JD-Core Version:    0.7.0.1
 */