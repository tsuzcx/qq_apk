package com.tencent.mobileqq.troop.troopapps;

import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarConfig;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import mqq.manager.Manager;

public class TroopAppShortcutMgr
  implements Manager
{
  private HashMap<Long, TroopAppShortcutMgr.LRUCacheInfo> a = new HashMap();
  
  public ArrayList<TroopAppShortcutContainer.TroopAppInfo> a(long paramLong)
  {
    TroopAppShortcutMgr.LRUCacheInfo localLRUCacheInfo = (TroopAppShortcutMgr.LRUCacheInfo)this.a.get(Long.valueOf(paramLong));
    if (localLRUCacheInfo != null)
    {
      localLRUCacheInfo.a = System.currentTimeMillis();
      return localLRUCacheInfo.b;
    }
    return null;
  }
  
  public void a()
  {
    if (this.a.size() > 20)
    {
      Object localObject1 = new ArrayList();
      Object localObject2 = this.a.values().iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((ArrayList)localObject1).add(Long.valueOf(((TroopAppShortcutMgr.LRUCacheInfo)((Iterator)localObject2).next()).a));
      }
      Collections.sort((List)localObject1, Collections.reverseOrder());
      long l = ((Long)((ArrayList)localObject1).get(19)).longValue();
      localObject1 = this.a.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        if (((TroopAppShortcutMgr.LRUCacheInfo)((Map.Entry)localObject2).getValue()).a < l)
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("eliminateAppInfoCache troopUin:");
            localStringBuilder.append(((Map.Entry)localObject2).getKey());
            QLog.d("TroopAppShortcutMgr", 2, localStringBuilder.toString());
          }
          ((Iterator)localObject1).remove();
        }
      }
    }
  }
  
  public void a(long paramLong, ArrayList<TroopAppShortcutContainer.TroopAppInfo> paramArrayList)
  {
    TroopAppShortcutMgr.LRUCacheInfo localLRUCacheInfo = (TroopAppShortcutMgr.LRUCacheInfo)this.a.get(Long.valueOf(paramLong));
    if (localLRUCacheInfo != null)
    {
      localLRUCacheInfo.a = System.currentTimeMillis();
      localLRUCacheInfo.b = paramArrayList;
      return;
    }
    this.a.put(Long.valueOf(paramLong), new TroopAppShortcutMgr.LRUCacheInfo(System.currentTimeMillis(), paramArrayList, null));
  }
  
  public ArrayList<TroopAppShortcutContainer.TroopAppInfo> b(long paramLong)
  {
    TroopAppShortcutMgr.LRUCacheInfo localLRUCacheInfo = (TroopAppShortcutMgr.LRUCacheInfo)this.a.get(Long.valueOf(paramLong));
    if (localLRUCacheInfo != null)
    {
      localLRUCacheInfo.a = System.currentTimeMillis();
      return localLRUCacheInfo.c;
    }
    return null;
  }
  
  public void b(long paramLong, ArrayList<TroopAppShortcutContainer.TroopAppInfo> paramArrayList)
  {
    TroopAppShortcutMgr.LRUCacheInfo localLRUCacheInfo = (TroopAppShortcutMgr.LRUCacheInfo)this.a.get(Long.valueOf(paramLong));
    if (localLRUCacheInfo != null)
    {
      localLRUCacheInfo.a = System.currentTimeMillis();
      localLRUCacheInfo.c = paramArrayList;
      return;
    }
    this.a.put(Long.valueOf(paramLong), new TroopAppShortcutMgr.LRUCacheInfo(System.currentTimeMillis(), null, paramArrayList));
  }
  
  public boolean b()
  {
    if (((IStudyModeManager)QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
      return false;
    }
    TroopShortcutBarConfig localTroopShortcutBarConfig = (TroopShortcutBarConfig)QConfigManager.b().b(590);
    if (localTroopShortcutBarConfig == null) {
      return false;
    }
    return localTroopShortcutBarConfig.a();
  }
  
  public void onDestroy()
  {
    this.a.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopapps.TroopAppShortcutMgr
 * JD-Core Version:    0.7.0.1
 */