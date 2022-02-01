package com.tencent.mobileqq.troop.troopcreate.api.impl;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService;
import com.tencent.mobileqq.troop.troopcreate.api.ITroopSearchService.SearchResult;
import com.tencent.mobileqq.troop.troopcreate.api.ITroopSearchService.TroopSearchCallback;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ChnToSpell.ChnSpelling;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class TroopSearchServiceImpl$TroopSearchTask
  implements Runnable
{
  ITroopSearchService.TroopSearchCallback a;
  ArrayList<ResultRecord> b;
  
  TroopSearchServiceImpl$TroopSearchTask(ITroopSearchService.TroopSearchCallback paramTroopSearchCallback, ArrayList<ResultRecord> paramArrayList)
  {
    this.a = paramArrayList;
    Object localObject;
    this.b = localObject;
  }
  
  private void a(ArrayList<ITroopSearchService.SearchResult> paramArrayList)
  {
    ITroopSearchService.TroopSearchCallback localTroopSearchCallback = this.a;
    if (localTroopSearchCallback != null) {
      localTroopSearchCallback.a(paramArrayList);
    }
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (paramInt2 <= 5)
    {
      if (paramInt1 > 20) {
        return false;
      }
    }
    else if ((paramInt2 > 6) && (paramInt2 < 20) && (paramInt1 > 50))
    {
      if (paramInt1 > 50) {
        return false;
      }
    }
    else if ((paramInt2 >= 20) && (paramInt1 > 100)) {
      return false;
    }
    return true;
  }
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = new ArrayList(this.this$0.troopInfoService.getUiTroopList());
    if (((List)localObject1).size() == 0)
    {
      a(localArrayList);
      return;
    }
    int i = ((List)localObject1).size() - 1;
    TroopInfo localTroopInfo;
    while (i >= 0)
    {
      localTroopInfo = (TroopInfo)((List)localObject1).get(i);
      if (!a(localTroopInfo.wMemberNum, this.b.size())) {
        ((List)localObject1).remove(localTroopInfo);
      }
      i -= 1;
    }
    int k = this.b.size();
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localTroopInfo = (TroopInfo)((Iterator)localObject1).next();
      List localList = ((ITroopMemberInfoService)TroopSearchServiceImpl.access$000(this.this$0).getRuntimeService(ITroopMemberInfoService.class, "")).getAllTroopMembers(localTroopInfo.troopuin);
      if ((localList != null) && (localList.size() > 0) && (a(localList.size(), this.b.size())) && (this.b.size() == localList.size()))
      {
        Object localObject2 = this.b.iterator();
        i = 1;
        while (((Iterator)localObject2).hasNext())
        {
          ResultRecord localResultRecord = (ResultRecord)((Iterator)localObject2).next();
          Iterator localIterator = localList.iterator();
          while (localIterator.hasNext())
          {
            TroopMemberInfo localTroopMemberInfo = (TroopMemberInfo)localIterator.next();
            if (TextUtils.equals(localResultRecord.uin, localTroopMemberInfo.memberuin))
            {
              j = 1;
              break label327;
            }
          }
          int j = 0;
          label327:
          if (j == 0) {
            i = 0;
          }
        }
        if (i != 0)
        {
          localObject2 = new ITroopSearchService.SearchResult();
          ((ITroopSearchService.SearchResult)localObject2).a = localTroopInfo;
          ((ITroopSearchService.SearchResult)localObject2).b = localList.size();
          ((ITroopSearchService.SearchResult)localObject2).c = ChnToSpell.a(localTroopInfo.getTroopDisplayName(), 1).b;
          localTroopInfo.lastMsgTime = ((IRecentUserProxyService)TroopSearchServiceImpl.access$000(this.this$0).getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache().b(localTroopInfo.troopuin, 1).lastmsgtime;
          if (k == ((ITroopSearchService.SearchResult)localObject2).b)
          {
            ((ITroopSearchService.SearchResult)localObject2).d = 1;
            localArrayList.add(localObject2);
          }
        }
      }
    }
    Collections.sort(localArrayList);
    a(localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcreate.api.impl.TroopSearchServiceImpl.TroopSearchTask
 * JD-Core Version:    0.7.0.1
 */