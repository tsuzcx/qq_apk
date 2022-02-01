package com.tencent.mobileqq.troop.onlinemember.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.onlinemember.api.ITroopOnlineMemberService;
import com.tencent.mobileqq.troop.onlinemember.data.TroopAllOnlineData;
import com.tencent.mobileqq.troop.onlinemember.data.TroopDetailOnlineData;
import com.tencent.mobileqq.troop.onlinemember.data.TroopOnlineMemberItem;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

public class TroopOnlineMemberServiceImpl
  implements ITroopOnlineMemberService
{
  private static final int DEFAULT_CACHE_TIME = 10;
  private static final String TAG = "TroopOnlineMemberServiceImpl";
  protected AppRuntime mApp;
  private Map<String, TroopDetailOnlineData> mDetailOnlineDataMap = new ConcurrentHashMap();
  protected long mLastReqLocationTime;
  private Map<String, TroopAllOnlineData> troopAllGameOnlineDataMap = new ConcurrentHashMap();
  
  public long getAIOTipsNextReqTime(String paramString)
  {
    paramString = (TroopDetailOnlineData)this.mDetailOnlineDataMap.get(paramString);
    long l1;
    if (paramString != null) {
      l1 = paramString.c;
    } else {
      l1 = 0L;
    }
    long l2 = l1;
    if (l1 <= 0L) {
      l2 = NetConnInfoCenter.getServerTime();
    }
    return l2;
  }
  
  public List<String> getAllGameOnlineList(String paramString)
  {
    paramString = (TroopAllOnlineData)this.troopAllGameOnlineDataMap.get(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.memberUinList;
  }
  
  public long getAllGameOnlineNextReqTime(String paramString)
  {
    paramString = (TroopAllOnlineData)this.troopAllGameOnlineDataMap.get(paramString);
    long l1;
    if (paramString != null) {
      l1 = paramString.nextReqTime;
    } else {
      l1 = 0L;
    }
    long l2 = l1;
    if (l1 <= 0L) {
      l2 = NetConnInfoCenter.getServerTime();
    }
    return l2;
  }
  
  public long getAllNextReqTime(String paramString)
  {
    EntityManager localEntityManager = this.mApp.getEntityManagerFactory().createEntityManager();
    paramString = (TroopAllOnlineData)localEntityManager.find(TroopAllOnlineData.class, paramString);
    localEntityManager.close();
    long l1;
    if (paramString != null) {
      l1 = paramString.nextReqTime;
    } else {
      l1 = 0L;
    }
    long l2 = l1;
    if (l1 <= 0L) {
      l2 = NetConnInfoCenter.getServerTime();
    }
    return l2;
  }
  
  public List<String> getAllOnlineList(String paramString)
  {
    EntityManager localEntityManager = this.mApp.getEntityManagerFactory().createEntityManager();
    paramString = (TroopAllOnlineData)localEntityManager.find(TroopAllOnlineData.class, paramString);
    localEntityManager.close();
    if (paramString == null) {
      return null;
    }
    return paramString.memberUinList;
  }
  
  public List<TroopOnlineMemberItem> getDetailMemberListFromCache(String paramString)
  {
    paramString = (TroopDetailOnlineData)this.mDetailOnlineDataMap.get(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.a;
  }
  
  public long getDetailNextReqTime(String paramString)
  {
    paramString = (TroopDetailOnlineData)this.mDetailOnlineDataMap.get(paramString);
    long l1;
    if (paramString != null) {
      l1 = paramString.d;
    } else {
      l1 = 0L;
    }
    long l2 = l1;
    if (l1 <= 0L) {
      l2 = NetConnInfoCenter.getServerTime();
    }
    return l2;
  }
  
  public long getLastReqLocationTime()
  {
    return this.mLastReqLocationTime;
  }
  
  public int getOnlineCount(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    int i = 0;
    if (bool) {
      return 0;
    }
    paramString = (TroopDetailOnlineData)this.mDetailOnlineDataMap.get(paramString);
    if (paramString != null) {
      i = paramString.f;
    }
    return i;
  }
  
  public String getOnlineTip(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    TroopInfo localTroopInfo = ((ITroopInfoService)this.mApp.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(paramString);
    boolean bool;
    if (localTroopInfo != null) {
      bool = localTroopInfo.isKicked();
    } else {
      bool = true;
    }
    if (bool) {
      return "";
    }
    String str = null;
    TroopDetailOnlineData localTroopDetailOnlineData = (TroopDetailOnlineData)this.mDetailOnlineDataMap.get(paramString);
    int i;
    if (localTroopDetailOnlineData != null)
    {
      paramString = localTroopDetailOnlineData.b;
      i = localTroopDetailOnlineData.f;
    }
    else
    {
      i = 0;
      paramString = str;
    }
    if (paramString == null) {
      return "";
    }
    str = paramString;
    if (localTroopInfo != null)
    {
      str = paramString;
      if (localTroopInfo.wMemberNumClient > 0)
      {
        str = paramString;
        if (i > localTroopInfo.wMemberNumClient)
        {
          str = paramString;
          if (!TextUtils.isEmpty(paramString))
          {
            paramString = paramString.replace(String.valueOf(i), String.valueOf(localTroopInfo.wMemberNumClient));
            str = paramString;
            if (QLog.isColorLevel())
            {
              QLog.d("TroopOnlineMemberServiceImpl", 2, String.format("getOnlineTip onlineCount: %s, memberNum: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(localTroopInfo.wMemberNumClient) }));
              str = paramString;
            }
          }
        }
      }
    }
    return str;
  }
  
  public int getRequestListServiceType(String paramString)
  {
    paramString = (TroopDetailOnlineData)this.mDetailOnlineDataMap.get(paramString);
    if ((paramString != null) && (paramString.e > 0)) {
      return paramString.e;
    }
    return 1;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = paramAppRuntime;
  }
  
  public void onDestroy()
  {
    this.mDetailOnlineDataMap.clear();
  }
  
  public void removeDetailOnlineData(String paramString)
  {
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      this.mDetailOnlineDataMap.remove(paramString);
      return;
    }
    catch (Exception paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("removeDetailOnlineData: e = ");
      localStringBuilder.append(paramString.toString());
      QLog.i("TroopOnlineMemberServiceImpl", 1, localStringBuilder.toString());
    }
  }
  
  public void removeDetailOnlineList(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = (TroopDetailOnlineData)this.mDetailOnlineDataMap.get(paramString);
    if (paramString == null) {
      return;
    }
    paramString.a = null;
    paramString.d = NetConnInfoCenter.getServerTime();
  }
  
  public void setLastReqLocationTime(long paramLong)
  {
    this.mLastReqLocationTime = paramLong;
  }
  
  public void updateAIOTipsCache(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3)
  {
    int i = paramInt1;
    if (paramInt1 <= 0) {
      i = 10;
    }
    TroopDetailOnlineData localTroopDetailOnlineData2 = (TroopDetailOnlineData)this.mDetailOnlineDataMap.get(paramString1);
    TroopDetailOnlineData localTroopDetailOnlineData1 = localTroopDetailOnlineData2;
    if (localTroopDetailOnlineData2 == null)
    {
      localTroopDetailOnlineData1 = new TroopDetailOnlineData();
      this.mDetailOnlineDataMap.put(paramString1, localTroopDetailOnlineData1);
    }
    if ((i != 4) || (!TextUtils.isEmpty(paramString2)))
    {
      localTroopDetailOnlineData1.b = paramString2;
      localTroopDetailOnlineData1.f = paramInt3;
    }
    localTroopDetailOnlineData1.c = (NetConnInfoCenter.getServerTime() + i);
    if (paramInt2 != -1) {
      localTroopDetailOnlineData1.e = paramInt2;
    }
  }
  
  public void updateAllGameOnlineList(String paramString, List<String> paramList, int paramInt)
  {
    int i = paramInt;
    if (paramInt <= 0) {
      i = 10;
    }
    TroopAllOnlineData localTroopAllOnlineData2 = (TroopAllOnlineData)this.troopAllGameOnlineDataMap.get(paramString);
    TroopAllOnlineData localTroopAllOnlineData1 = localTroopAllOnlineData2;
    if (localTroopAllOnlineData2 == null)
    {
      localTroopAllOnlineData1 = new TroopAllOnlineData();
      this.troopAllGameOnlineDataMap.put(paramString, localTroopAllOnlineData1);
    }
    localTroopAllOnlineData1.troopUin = paramString;
    localTroopAllOnlineData1.memberUinList = paramList;
    localTroopAllOnlineData1.nextReqTime = (NetConnInfoCenter.getServerTime() + i);
  }
  
  public void updateAllOnlineList(String paramString, List<String> paramList, int paramInt)
  {
    int i = paramInt;
    if (paramInt <= 0) {
      i = 10;
    }
    TroopAllOnlineData localTroopAllOnlineData = new TroopAllOnlineData();
    localTroopAllOnlineData.troopUin = paramString;
    localTroopAllOnlineData.memberUinList = paramList;
    localTroopAllOnlineData.nextReqTime = (NetConnInfoCenter.getServerTime() + i);
    paramString = this.mApp.getEntityManagerFactory().createEntityManager();
    paramString.persistOrReplace(localTroopAllOnlineData);
    paramString.close();
  }
  
  public void updateDetailOnlineListCache(String paramString1, List<TroopOnlineMemberItem> paramList, int paramInt1, String paramString2, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt1 <= 0) {
      i = 10;
    }
    TroopDetailOnlineData localTroopDetailOnlineData2 = (TroopDetailOnlineData)this.mDetailOnlineDataMap.get(paramString1);
    TroopDetailOnlineData localTroopDetailOnlineData1 = localTroopDetailOnlineData2;
    if (localTroopDetailOnlineData2 == null)
    {
      localTroopDetailOnlineData1 = new TroopDetailOnlineData();
      this.mDetailOnlineDataMap.put(paramString1, localTroopDetailOnlineData1);
    }
    if (!TextUtils.isEmpty(paramString2))
    {
      localTroopDetailOnlineData1.b = paramString2;
      localTroopDetailOnlineData1.f = paramInt2;
    }
    if ((paramList != null) && (paramList.size() > 0)) {
      localTroopDetailOnlineData1.a = paramList;
    }
    localTroopDetailOnlineData1.d = (NetConnInfoCenter.getServerTime() + i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.onlinemember.api.impl.TroopOnlineMemberServiceImpl
 * JD-Core Version:    0.7.0.1
 */