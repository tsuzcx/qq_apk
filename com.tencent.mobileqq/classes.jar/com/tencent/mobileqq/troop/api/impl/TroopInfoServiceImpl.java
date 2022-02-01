package com.tencent.mobileqq.troop.api.impl;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.commonsdk.cache.QQConcurrentHashMap;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.CommonlyUsedTroop;
import com.tencent.mobileqq.data.troop.ITroopInfoCallback;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopInfoService.GetTroopCodeCallback;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService;
import com.tencent.mobileqq.troop.api.ITroopSystemMsgUtilApi;
import com.tencent.mobileqq.troop.api.config.TroopCommonConfig;
import com.tencent.mobileqq.troop.api.config.TroopInfoServiceConfig;
import com.tencent.mobileqq.troop.api.utils.TroopInfoSorter;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.TraceUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

public class TroopInfoServiceImpl
  implements ITroopInfoService
{
  private static final String TAG = "TroopInfoServiceImpl";
  protected AppRuntime app;
  private ConcurrentHashMap<String, Entity> commonlyUsedTroopCache;
  protected EntityManager em;
  private boolean isTroopCacheInited = false;
  private ConcurrentHashMap<String, String> mTroopCodeList;
  private Map<String, List<WeakReference<ITroopInfoCallback>>> mTroopInfoCbRefMap = new HashMap(5);
  private ArrayList<Entity> mUiTroopArrayList = new ArrayList();
  protected Map<String, Long> prepareCommonlyUsedTroop;
  private ConcurrentHashMap<String, Entity> troopListCache = new QQConcurrentHashMap(1013, 1350);
  protected ConcurrentHashMap<String, String> troopUinPool = new ConcurrentHashMap();
  private List<String> updateHeadList = Collections.synchronizedList(new ArrayList());
  
  private ConcurrentHashMap<String, Entity> getCommonlyUsedTroopLazyCache()
  {
    for (;;)
    {
      try
      {
        if (this.commonlyUsedTroopCache == null)
        {
          localObject1 = (ArrayList)this.em.query(CommonlyUsedTroop.class, false, null, null, null, null, null, null);
          if (localObject1 == null) {
            break label174;
          }
          i = ((ArrayList)localObject1).size();
          this.commonlyUsedTroopCache = new QQConcurrentHashMap(1014, i, 25);
          int j = 0;
          if (j < i)
          {
            CommonlyUsedTroop localCommonlyUsedTroop = (CommonlyUsedTroop)((ArrayList)localObject1).get(j);
            if (QLog.isColorLevel()) {
              QLog.d("OpenTroopDebug", 2, "init load groupcode = " + localCommonlyUsedTroop.troopUin);
            }
            this.commonlyUsedTroopCache.put(localCommonlyUsedTroop.troopUin, localCommonlyUsedTroop);
            j += 1;
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("CommonlyUsedTroop", 2, "load CommonlyUsedTroop info: size = " + i);
          }
        }
        Object localObject1 = this.commonlyUsedTroopCache;
        return localObject1;
      }
      finally {}
      label174:
      int i = 0;
    }
  }
  
  private void initTroopListCache()
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d("TroopInfoServiceImpl", 2, "initTroopListCache begin");
    }
    localObject2 = (ArrayList)this.em.query(TroopInfo.class, false, null, null, null, null, null, null);
    if (localObject2 != null) {}
    ConcurrentHashMap localConcurrentHashMap;
    ArrayList localArrayList;
    for (int i = ((ArrayList)localObject2).size();; i = 0)
    {
      localConcurrentHashMap = new ConcurrentHashMap(i);
      if (localObject2 == null) {
        break label229;
      }
      localArrayList = new ArrayList();
      i = 0;
      while (i < ((ArrayList)localObject2).size())
      {
        TroopInfo localTroopInfo = (TroopInfo)((ArrayList)localObject2).get(i);
        if ((localTroopInfo.mCompareSpell == null) || (localTroopInfo.mCompareSpell.length() == 0))
        {
          TroopInfoSorter.a(localTroopInfo);
          localArrayList.add(localTroopInfo);
        }
        if (!TextUtils.isEmpty(localTroopInfo.troopuin)) {
          localConcurrentHashMap.put(localTroopInfo.troopuin, localTroopInfo);
        }
        i += 1;
      }
    }
    if (localArrayList.size() > 0) {
      localObject2 = this.em.getTransaction();
    }
    try
    {
      ((EntityTransaction)localObject2).begin();
      i = j;
      while (i < localArrayList.size())
      {
        updateEntity((Entity)localArrayList.get(i));
        i += 1;
      }
      ((EntityTransaction)localObject2).commit();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ((EntityTransaction)localObject2).end();
      }
    }
    finally
    {
      ((EntityTransaction)localObject2).end();
    }
    localArrayList.clear();
    label229:
    this.troopListCache.putAll(localConcurrentHashMap);
    this.isTroopCacheInited = true;
    if (QLog.isColorLevel()) {
      QLog.d("TroopInfoServiceImpl", 2, "initTroopListCache end: " + localConcurrentHashMap.size());
    }
  }
  
  private void updateRecentUser(RecentUserProxy paramRecentUserProxy, CommonlyUsedTroop paramCommonlyUsedTroop, boolean paramBoolean)
  {
    RecentUser localRecentUser = paramRecentUserProxy.b(paramCommonlyUsedTroop.troopUin, 1);
    if (localRecentUser != null)
    {
      localRecentUser.showUpTime = paramCommonlyUsedTroop.addedTimestamp;
      localRecentUser.opTime = Math.max(localRecentUser.opTime, paramCommonlyUsedTroop.addedTimestamp);
      paramRecentUserProxy.b(localRecentUser);
    }
    while ((paramCommonlyUsedTroop.addedTimestamp <= 0L) || (paramCommonlyUsedTroop.addedTimestamp <= 1558281600L) || (!paramBoolean)) {
      return;
    }
    localRecentUser = new RecentUser(paramCommonlyUsedTroop.troopUin, 1);
    localRecentUser.showUpTime = paramCommonlyUsedTroop.addedTimestamp;
    localRecentUser.opTime = paramCommonlyUsedTroop.addedTimestamp;
    paramRecentUserProxy.b(localRecentUser);
  }
  
  public boolean addCommonlyUsedTroop(String paramString, long paramLong)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopInfoServiceImpl", 2, "addCommonlyUsedTroop, troopUin is null");
      }
      return false;
    }
    ConcurrentHashMap localConcurrentHashMap = getCommonlyUsedTroopLazyCache();
    CommonlyUsedTroop localCommonlyUsedTroop = (CommonlyUsedTroop)localConcurrentHashMap.get(paramString);
    RecentUserProxy localRecentUserProxy = ((IRecentUserProxyService)this.app.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
    if (QLog.isColorLevel()) {
      QLog.d("TroopInfoServiceImpl", 4, " addCommonlyUsedTroop troopUin=" + paramString + " troop.addedTimestamp" + paramLong);
    }
    if (localCommonlyUsedTroop == null)
    {
      localCommonlyUsedTroop = new CommonlyUsedTroop();
      localCommonlyUsedTroop.troopUin = paramString;
      localCommonlyUsedTroop.addedTimestamp = paramLong;
      localConcurrentHashMap.put(paramString, localCommonlyUsedTroop);
      updateRecentUser(localRecentUserProxy, localCommonlyUsedTroop, true);
      updateEntity(localCommonlyUsedTroop);
      return true;
    }
    if (localCommonlyUsedTroop.addedTimestamp != paramLong)
    {
      localCommonlyUsedTroop.addedTimestamp = paramLong;
      updateRecentUser(localRecentUserProxy, localCommonlyUsedTroop, true);
      updateEntity(localCommonlyUsedTroop);
      return true;
    }
    return false;
  }
  
  public void addTroop(TroopInfo paramTroopInfo)
  {
    if (paramTroopInfo == null) {
      return;
    }
    clearPassiveExitTroopInfo(paramTroopInfo.troopuin);
    if (this.troopListCache == null) {
      this.troopListCache = new ConcurrentHashMap();
    }
    if ((this.troopListCache != null) && (!this.troopListCache.containsKey(paramTroopInfo.troopuin))) {
      this.troopListCache.put(paramTroopInfo.troopuin, paramTroopInfo);
    }
    updateEntity(paramTroopInfo);
    buildTroopUI();
  }
  
  public void addTroops(List<TroopInfo> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TroopInfo localTroopInfo = (TroopInfo)paramList.next();
      if ((localTroopInfo != null) && (!TextUtils.isEmpty(localTroopInfo.troopuin)) && (!"0".equals(localTroopInfo.troopuin)))
      {
        if (this.troopListCache == null) {
          this.troopListCache = new ConcurrentHashMap();
        }
        this.troopListCache.put(localTroopInfo.troopuin, localTroopInfo);
        if ((!updateEntity(localTroopInfo)) && (QLog.isColorLevel())) {
          QLog.d("TroopInfoServiceImpl", 2, "saveTroopInfo failed.");
        }
      }
    }
  }
  
  public void asyncGetTroopInfo(String paramString, ITroopInfoCallback paramITroopInfoCallback)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramITroopInfoCallback == null)) {
      return;
    }
    List localList = (List)this.mTroopInfoCbRefMap.get(paramString);
    Object localObject = (TroopInfo)this.troopListCache.get(paramString);
    if (localObject != null)
    {
      paramITroopInfoCallback.a((TroopInfo)localObject);
      return;
    }
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      localObject = (TroopInfo)this.em.find(TroopInfo.class, paramString);
      if (localObject != null) {
        this.troopListCache.put(paramString, localObject);
      }
      paramITroopInfoCallback.a((TroopInfo)localObject);
      return;
    }
    localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      this.mTroopInfoCbRefMap.put(paramString, localObject);
    }
    if (((List)localObject).isEmpty())
    {
      ((List)localObject).add(new WeakReference(paramITroopInfoCallback));
      ThreadManagerV2.excute(new TroopInfoServiceImpl.1(this, paramString), 32, null, true);
      return;
    }
    ((List)localObject).add(new WeakReference(paramITroopInfoCallback));
  }
  
  public void buildTroopUI()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopInfoServiceImpl", 2, "buildTroopUI begin: ");
    }
    ArrayList localArrayList = new ArrayList();
    if (this.troopListCache != null)
    {
      int i = this.troopListCache.size();
      if (i > 0)
      {
        localArrayList.ensureCapacity(i);
        Iterator localIterator = this.troopListCache.values().iterator();
        while (localIterator.hasNext())
        {
          TroopInfo localTroopInfo = (TroopInfo)localIterator.next();
          if (localTroopInfo.eliminated != 1)
          {
            if ((localTroopInfo.mCompareSpell == null) || (localTroopInfo.mCompareSpell.length() == 0)) {
              TroopInfoSorter.a(localTroopInfo);
            }
            if (!localTroopInfo.isExited()) {
              localArrayList.add(localTroopInfo);
            }
            for (;;)
            {
              synchronized (this.updateHeadList)
              {
                if ((localTroopInfo.isNewTroop()) && (!localTroopInfo.hasSetTroopHead()) && (!this.updateHeadList.contains(localTroopInfo.troopuin)))
                {
                  TroopInfoServiceConfig.a(localTroopInfo.troopuin, false);
                  this.updateHeadList.add(localTroopInfo.troopuin);
                }
              }
              if (QLog.isColorLevel()) {
                QLog.d("TroopInfoServiceImpl", 2, String.format("buildTroopUI filter troop: %s, exitReason: %s", new Object[] { localTroopInfo.troopuin, Integer.valueOf(localTroopInfo.exitTroopReason) }));
              }
            }
          }
        }
        if (i > 1) {
          Collections.sort(localList2, TroopInfoSorter.a);
        }
      }
    }
    this.mUiTroopArrayList = localList2;
    if (QLog.isColorLevel()) {
      QLog.d("TroopInfoServiceImpl", 2, "buildTroopUI end: " + localList2.size());
    }
  }
  
  public boolean clearPassiveExitTroopInfo(String paramString)
  {
    boolean bool = true;
    TroopInfo localTroopInfo = findTroopInfo(paramString, true);
    if ((localTroopInfo == null) || (!localTroopInfo.isExited())) {
      bool = false;
    }
    do
    {
      return bool;
      if (QLog.isColorLevel()) {
        QLog.d("TroopInfoServiceImpl", 2, String.format("clearPassiveExitTroopInfo, troopUin: %s, exit reason: %s", new Object[] { paramString, Integer.valueOf(localTroopInfo.exitTroopReason) }));
      }
      this.em.remove(localTroopInfo);
    } while (this.troopListCache == null);
    this.troopListCache.remove(paramString);
    return true;
  }
  
  public void deleteTroop(String paramString)
  {
    deleteTroop(paramString, false);
  }
  
  public boolean deleteTroop(String paramString, boolean paramBoolean)
  {
    TroopInfo localTroopInfo = findTroopInfo(paramString, paramBoolean);
    if (localTroopInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopInfoServiceImpl", 2, "deleteTroop  troopinfo is null,troopUin = " + paramString);
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopInfoServiceImpl", 2, String.format("deleteTroop, troopUin: %s, exitTroopReason: %s, isDelExit: %s", new Object[] { paramString, Integer.valueOf(localTroopInfo.exitTroopReason), Boolean.valueOf(paramBoolean) }));
    }
    ITroopMemberInfoService localITroopMemberInfoService = (ITroopMemberInfoService)this.app.getRuntimeService(ITroopMemberInfoService.class, "");
    if (localITroopMemberInfoService != null) {
      localITroopMemberInfoService.deleteTroopMembers(paramString);
    }
    this.em.remove(localTroopInfo);
    deleteTroopWithoutDB(paramString);
    return true;
  }
  
  public void deleteTroopList(List<String> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopInfoServiceImpl", 2, "deleteTroopList, uins is empty");
      }
      return;
    }
    Object localObject2 = null;
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        EntityTransaction localEntityTransaction = this.em.getTransaction();
        localObject1 = localEntityTransaction;
        localObject2 = localEntityTransaction;
        localEntityTransaction.begin();
        localObject1 = localEntityTransaction;
        localObject2 = localEntityTransaction;
        Iterator localIterator = paramList.iterator();
        localObject1 = localEntityTransaction;
        localObject2 = localEntityTransaction;
        if (localIterator.hasNext())
        {
          localObject1 = localEntityTransaction;
          localObject2 = localEntityTransaction;
          str = (String)localIterator.next();
          localObject1 = localEntityTransaction;
          localObject2 = localEntityTransaction;
          TroopInfo localTroopInfo = findTroopInfo(str);
          if (localTroopInfo != null)
          {
            localObject1 = localEntityTransaction;
            localObject2 = localEntityTransaction;
            this.em.remove(localTroopInfo);
            continue;
          }
        }
      }
      catch (Exception localException)
      {
        String str;
        localObject2 = localObject1;
        localException.printStackTrace();
        localObject2 = localObject1;
        QLog.e("TroopInfoServiceImpl", 1, "deleteTroopList exception: " + localException.getMessage());
        if (localObject1 != null) {
          ((EntityTransaction)localObject1).end();
        }
        paramList = paramList.iterator();
        if (!paramList.hasNext()) {
          break;
        }
        localObject1 = (String)paramList.next();
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          continue;
        }
        deleteTroopWithoutDB((String)localObject1);
        continue;
        localObject1 = localException;
        localObject2 = localException;
        if (!QLog.isColorLevel()) {
          continue;
        }
        localObject1 = localException;
        localObject2 = localException;
        QLog.d("TroopInfoServiceImpl", 2, String.format("deleteTroopList, troopUin: %s, troopInfo is empty", new Object[] { str }));
        continue;
      }
      finally
      {
        if (localObject2 != null) {
          localObject2.end();
        }
      }
      localObject1 = localException;
      localObject2 = localException;
      localException.commit();
      if (localException != null) {
        localException.end();
      }
    }
  }
  
  public void deleteTroopWithoutDB(String paramString)
  {
    if (this.troopListCache != null) {
      this.troopListCache.remove(paramString);
    }
    buildTroopUI();
    if (QLog.isColorLevel()) {
      QLog.d("TroopInfoServiceImpl", 2, "deleteTroopWithoutDB tm->deleteTroop-->delete troop");
    }
    TroopInfoServiceConfig.a(paramString);
  }
  
  public TroopInfo findTroopInfo(String paramString)
  {
    return findTroopInfo(paramString, false, true);
  }
  
  public TroopInfo findTroopInfo(String paramString, boolean paramBoolean)
  {
    return findTroopInfo(paramString, paramBoolean, true);
  }
  
  public TroopInfo findTroopInfo(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1;
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopInfoServiceImpl", 2, "findTroopInfo, troopUin isEmpty:" + paramString);
      }
      localObject1 = null;
    }
    Object localObject2;
    do
    {
      do
      {
        return localObject1;
        localObject2 = (TroopInfo)this.troopListCache.get(paramString);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          if (!this.isTroopCacheInited)
          {
            localObject1 = localObject2;
            if (paramBoolean2)
            {
              localObject2 = (TroopInfo)this.em.find(TroopInfo.class, paramString);
              localObject1 = localObject2;
              if (localObject2 != null)
              {
                this.troopListCache.put(paramString, localObject2);
                localObject1 = localObject2;
              }
            }
          }
        }
        localObject2 = localObject1;
        if (!paramBoolean1)
        {
          localObject2 = localObject1;
          if (localObject1 != null)
          {
            localObject2 = localObject1;
            if (((TroopInfo)localObject1).isExited()) {
              localObject2 = null;
            }
          }
        }
        localObject1 = localObject2;
      } while (localObject2 != null);
      localObject1 = localObject2;
    } while (!QLog.isColorLevel());
    QLog.d("TroopInfoServiceImpl", 2, String.format("findTroopInfo is null , troopUin: %s, containExited: %s, findDB: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) }));
    return localObject2;
  }
  
  public TroopInfo findTroopInfoInUI(String paramString)
  {
    return findTroopInfo(paramString, false, false);
  }
  
  public List<TroopInfo> getAllTroopList()
  {
    if (!this.isTroopCacheInited) {
      initTroopListCache();
    }
    ArrayList localArrayList = new ArrayList();
    if (this.troopListCache != null)
    {
      Iterator localIterator = this.troopListCache.values().iterator();
      while (localIterator.hasNext())
      {
        Entity localEntity = (Entity)localIterator.next();
        if ((localEntity instanceof TroopInfo)) {
          localArrayList.add((TroopInfo)localEntity);
        }
      }
    }
    return localArrayList;
  }
  
  public CommonlyUsedTroop getCommonlyUsedTroop(String paramString)
  {
    return (CommonlyUsedTroop)getCommonlyUsedTroopLazyCache().get(paramString);
  }
  
  public ConcurrentHashMap<String, Entity> getCommonlyUsedTroopCache()
  {
    return this.commonlyUsedTroopCache;
  }
  
  public List<CommonlyUsedTroop> getCommonlyUsedTroopList()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = getCommonlyUsedTroopLazyCache().values().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add((CommonlyUsedTroop)localIterator.next());
    }
    return localArrayList;
  }
  
  public EntityTransaction getEntityTransaction()
  {
    return this.em.getTransaction();
  }
  
  public String getTroopCodeByTroopUin(String paramString)
  {
    Object localObject1 = null;
    Iterator localIterator = null;
    if (TextUtils.isEmpty(paramString)) {
      localObject2 = localIterator;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return localObject2;
              if (this.troopUinPool.containsValue(paramString)) {
                break;
              }
              localObject3 = findTroopInfo(paramString, true);
              localObject2 = localIterator;
            } while (localObject3 == null);
            localObject2 = localIterator;
          } while (((TroopInfo)localObject3).troopcode == null);
          localObject2 = localIterator;
        } while (((TroopInfo)localObject3).troopuin == null);
        this.troopUinPool.put(((TroopInfo)localObject3).troopcode, ((TroopInfo)localObject3).troopuin);
        localIterator = this.troopUinPool.keySet().iterator();
        localObject2 = localObject1;
      } while (localIterator == null);
      localObject2 = localObject1;
    } while (!localIterator.hasNext());
    Object localObject2 = (String)localIterator.next();
    Object localObject3 = (String)this.troopUinPool.get(localObject2);
    if ((localObject3 != null) && (((String)localObject3).equals(paramString))) {
      localObject1 = localObject2;
    }
    for (;;)
    {
      break;
    }
  }
  
  public void getTroopCodeByTroopUinAsync(String paramString, ITroopInfoService.GetTroopCodeCallback paramGetTroopCodeCallback)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramGetTroopCodeCallback == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopInfoServiceImpl", 2, "getTroopCodeByTroopUinAsync, param is empty");
      }
      return;
    }
    ThreadManager.post(new TroopInfoServiceImpl.2(this, paramString, paramGetTroopCodeCallback), 8, null, false);
  }
  
  public TroopInfo getTroopInfo(String paramString)
  {
    Object localObject1;
    Object localObject2;
    if (TextUtils.isEmpty(paramString))
    {
      localObject1 = new TroopInfo();
      localObject2 = localObject1;
      if (QLog.isColorLevel())
      {
        QLog.e("TroopInfoServiceImpl", 2, "getTroopInfo, troopUin isEmpty:" + paramString);
        localObject2 = localObject1;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopInfoServiceImpl", 2, StringUtil.a(new Object[] { "TroopManger getTroopInfo()", paramString, Long.valueOf(((TroopInfo)localObject2).dwGroupFlagExt) }));
      }
      return localObject2;
      localObject2 = findTroopInfo(paramString);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new TroopInfo();
        localObject2 = (ITroopSystemMsgUtilApi)QRoute.api(ITroopSystemMsgUtilApi.class);
        ((TroopInfo)localObject1).troopname = ((ITroopSystemMsgUtilApi)localObject2).getTroopNameFromSP(this.app.getApplicationContext(), paramString);
        ((TroopInfo)localObject1).dwGroupFlagExt = ((ITroopSystemMsgUtilApi)localObject2).getTroopFlagExtFromSP(this.app.getApplicationContext(), paramString);
      }
      localObject2 = localObject1;
      if (TextUtils.isEmpty(((TroopInfo)localObject1).troopname))
      {
        ((TroopInfo)localObject1).troopname = paramString;
        localObject2 = localObject1;
      }
    }
  }
  
  public TroopInfo getTroopInfoFromCache(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      TroopInfo localTroopInfo = new TroopInfo();
      if (QLog.isColorLevel()) {
        QLog.e("TroopInfoServiceImpl", 2, "getTroopInfoFromCache, troopUin isEmpty:" + paramString);
      }
      return localTroopInfo;
    }
    return (TroopInfo)this.troopListCache.get(paramString);
  }
  
  public ArrayList<String> getTroopMemberForTroopHead(String paramString)
  {
    Object localObject = getTroopInfo(paramString);
    paramString = new ArrayList();
    if ((localObject == null) || (((TroopInfo)localObject).mHeaderUinsNew == null) || (((TroopInfo)localObject).mHeaderUinsNew == " ")) {}
    for (;;)
    {
      return paramString;
      localObject = ((TroopInfo)localObject).mHeaderUinsNew.split(";");
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        CharSequence localCharSequence = localObject[i];
        if ((!TextUtils.isEmpty(localCharSequence)) && (!TroopCommonConfig.b(this.app, localCharSequence))) {
          paramString.add(localCharSequence);
        }
        i += 1;
      }
    }
  }
  
  public String getTroopNameByID(String paramString)
  {
    TroopInfo localTroopInfo = findTroopInfo(paramString);
    String str = paramString;
    if (localTroopInfo != null)
    {
      str = paramString;
      if (localTroopInfo.getTroopDisplayName() != null) {
        str = localTroopInfo.getTroopDisplayName();
      }
    }
    return str;
  }
  
  public String getTroopUin(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    if (this.mTroopCodeList == null) {
      this.mTroopCodeList = new ConcurrentHashMap();
    }
    if (this.mTroopCodeList.containsKey(paramString)) {
      return (String)this.mTroopCodeList.get(paramString);
    }
    if (this.troopListCache != null)
    {
      Iterator localIterator = this.troopListCache.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (TroopInfo)((Map.Entry)localIterator.next()).getValue();
        if ((localObject != null) && (((TroopInfo)localObject).troopcode != null) && (((TroopInfo)localObject).troopcode.equals(paramString)))
        {
          localObject = ((TroopInfo)localObject).troopuin;
          if ((localObject != null) && (((String)localObject).length() > 0))
          {
            this.mTroopCodeList.put(paramString, localObject);
            return localObject;
          }
        }
      }
    }
    return null;
  }
  
  public String getTroopUinByTroopCode(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (!this.troopUinPool.containsKey(paramString))
    {
      TroopInfo localTroopInfo = (TroopInfo)this.em.find(TroopInfo.class, "troopcode=?", new String[] { paramString });
      if (localTroopInfo == null) {
        return null;
      }
      if ((localTroopInfo.troopcode == null) || (localTroopInfo.troopuin == null)) {
        return null;
      }
      this.troopUinPool.put(localTroopInfo.troopcode, localTroopInfo.troopuin);
    }
    return (String)this.troopUinPool.get(paramString);
  }
  
  public ArrayList<Entity> getUiTroopList()
  {
    if (!this.isTroopCacheInited) {
      initAndBuildTroopUI();
    }
    return this.mUiTroopArrayList;
  }
  
  public ArrayList<Entity> getUiTroopListWithoutBlockedTroop()
  {
    if (!this.isTroopCacheInited) {
      initAndBuildTroopUI();
    }
    ArrayList localArrayList = new ArrayList();
    if (this.mUiTroopArrayList != null)
    {
      Iterator localIterator = this.mUiTroopArrayList.iterator();
      while (localIterator.hasNext())
      {
        Entity localEntity = (Entity)localIterator.next();
        if (!((TroopInfo)localEntity).isTroopBlocked) {
          localArrayList.add(localEntity);
        }
      }
    }
    return localArrayList;
  }
  
  public List<Long> getUinList()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = getUiTroopList();
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Entity)((Iterator)localObject1).next();
        if ((localObject2 instanceof TroopInfo))
        {
          localObject2 = (TroopInfo)localObject2;
          try
          {
            localArrayList.add(Long.valueOf(((TroopInfo)localObject2).troopuin));
          }
          catch (NumberFormatException localNumberFormatException)
          {
            QLog.d("TroopInfoServiceImpl", 1, "convert uin exception", localNumberFormatException);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public boolean hasNoTroop()
  {
    if ((this.troopListCache != null) && (this.troopListCache.size() > 0)) {}
    ArrayList localArrayList;
    do
    {
      return false;
      localArrayList = (ArrayList)this.em.query(TroopInfo.class, false, null, null, null, null, null, String.valueOf("1"));
    } while ((localArrayList != null) && (localArrayList.size() > 0));
    return true;
  }
  
  public void initAndBuildTroopUI()
  {
    initTroopListCache();
    buildTroopUI();
  }
  
  public boolean isCommonlyUsedTroop(String paramString)
  {
    return getCommonlyUsedTroopLazyCache().get(paramString) != null;
  }
  
  public boolean isHomeworkTroop(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      paramString = findTroopInfo(paramString);
    } while ((paramString == null) || (!paramString.isHomeworkTroop()));
    return true;
  }
  
  public boolean isQidianPrivateTroop(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      paramString = findTroopInfo(paramString);
    } while ((paramString == null) || (!TroopInfo.isQidianPrivateTroop(paramString.dwGroupFlagExt3)));
    return true;
  }
  
  public boolean isTroopCacheInited()
  {
    return this.isTroopCacheInited;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.app = paramAppRuntime;
    this.em = this.app.getEntityManagerFactory().createEntityManager();
    try
    {
      TroopInfoServiceConfig.a();
      TroopCommonConfig.a();
      return;
    }
    catch (Exception paramAppRuntime)
    {
      paramAppRuntime.printStackTrace();
    }
  }
  
  public void onDestroy() {}
  
  public void prePareCommonlyUsedTroop(Map<String, Long> paramMap)
  {
    this.prepareCommonlyUsedTroop = paramMap;
  }
  
  public void preloadData(ArrayList<String> paramArrayList)
  {
    TraceUtils.traceBegin("queryTroops_" + paramArrayList.size());
    if (paramArrayList.size() > 0)
    {
      Object localObject = new StringBuilder("troopuin=? ");
      int i = 1;
      while (i < paramArrayList.size())
      {
        ((StringBuilder)localObject).append("or troopuin=? ");
        i += 1;
      }
      paramArrayList = this.em.query(TroopInfo.class, true, ((StringBuilder)localObject).toString(), (String[])paramArrayList.toArray(new String[paramArrayList.size()]), null, null, null, null);
      if (paramArrayList != null)
      {
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          localObject = (TroopInfo)paramArrayList.next();
          this.troopListCache.put(((TroopInfo)localObject).troopuin, localObject);
        }
      }
    }
    TraceUtils.traceEnd();
  }
  
  /* Error */
  public void refreshCommonlyUsedTroop()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: invokespecial 250	com/tencent/mobileqq/troop/api/impl/TroopInfoServiceImpl:getCommonlyUsedTroopLazyCache	()Ljava/util/concurrent/ConcurrentHashMap;
    //   7: astore 6
    //   9: aload_0
    //   10: getfield 81	com/tencent/mobileqq/troop/api/impl/TroopInfoServiceImpl:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   13: invokevirtual 180	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   16: astore 5
    //   18: aload 5
    //   20: astore 4
    //   22: aload 4
    //   24: ifnull +564 -> 588
    //   27: aload 4
    //   29: invokevirtual 185	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   32: aload_0
    //   33: getfield 664	com/tencent/mobileqq/troop/api/impl/TroopInfoServiceImpl:prepareCommonlyUsedTroop	Ljava/util/Map;
    //   36: ifnonnull +14 -> 50
    //   39: aload_0
    //   40: new 62	java/util/HashMap
    //   43: dup
    //   44: invokespecial 694	java/util/HashMap:<init>	()V
    //   47: putfield 664	com/tencent/mobileqq/troop/api/impl/TroopInfoServiceImpl:prepareCommonlyUsedTroop	Ljava/util/Map;
    //   50: aload 6
    //   52: invokevirtual 499	java/util/concurrent/ConcurrentHashMap:keySet	()Ljava/util/Set;
    //   55: invokeinterface 502 1 0
    //   60: astore 5
    //   62: aload 5
    //   64: invokeinterface 303 1 0
    //   69: ifeq +147 -> 216
    //   72: aload 5
    //   74: invokeinterface 307 1 0
    //   79: checkcast 154	java/lang/String
    //   82: astore 7
    //   84: aload_0
    //   85: getfield 255	com/tencent/mobileqq/troop/api/impl/TroopInfoServiceImpl:app	Lmqq/app/AppRuntime;
    //   88: invokevirtual 698	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   91: invokevirtual 703	mqq/app/MobileQQ:getBaseContext	()Landroid/content/Context;
    //   94: aload_0
    //   95: getfield 255	com/tencent/mobileqq/troop/api/impl/TroopInfoServiceImpl:app	Lmqq/app/AppRuntime;
    //   98: invokevirtual 706	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   101: aload 7
    //   103: invokestatic 709	com/tencent/mobileqq/troop/api/config/TroopCommonConfig:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z
    //   106: ifeq -44 -> 62
    //   109: aload 6
    //   111: aload 7
    //   113: invokevirtual 253	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   116: checkcast 83	com/tencent/mobileqq/data/troop/CommonlyUsedTroop
    //   119: getfield 219	com/tencent/mobileqq/data/troop/CommonlyUsedTroop:addedTimestamp	J
    //   122: lstore_2
    //   123: aload_0
    //   124: getfield 664	com/tencent/mobileqq/troop/api/impl/TroopInfoServiceImpl:prepareCommonlyUsedTroop	Ljava/util/Map;
    //   127: aload 7
    //   129: lload_2
    //   130: invokestatic 530	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   133: invokeinterface 337 3 0
    //   138: pop
    //   139: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   142: ifeq -80 -> 62
    //   145: ldc 10
    //   147: iconst_4
    //   148: new 110	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   155: ldc_w 711
    //   158: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: aload 7
    //   163: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: ldc_w 713
    //   169: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: lload_2
    //   173: invokevirtual 276	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   176: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   182: goto -120 -> 62
    //   185: astore 5
    //   187: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   190: ifeq +15 -> 205
    //   193: ldc 10
    //   195: iconst_4
    //   196: aload 5
    //   198: iconst_0
    //   199: anewarray 4	java/lang/Object
    //   202: invokestatic 716	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   205: aload 4
    //   207: ifnull +8 -> 215
    //   210: aload 4
    //   212: invokevirtual 197	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   215: return
    //   216: aload_0
    //   217: getfield 255	com/tencent/mobileqq/troop/api/impl/TroopInfoServiceImpl:app	Lmqq/app/AppRuntime;
    //   220: ldc_w 257
    //   223: ldc_w 259
    //   226: invokevirtual 265	mqq/app/AppRuntime:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   229: checkcast 257	com/tencent/mobileqq/proxy/api/IRecentUserProxyService
    //   232: invokeinterface 269 1 0
    //   237: astore 5
    //   239: aload 6
    //   241: invokevirtual 499	java/util/concurrent/ConcurrentHashMap:keySet	()Ljava/util/Set;
    //   244: invokeinterface 502 1 0
    //   249: astore 7
    //   251: aload 7
    //   253: invokeinterface 303 1 0
    //   258: ifeq +64 -> 322
    //   261: aload 6
    //   263: aload 7
    //   265: invokeinterface 307 1 0
    //   270: checkcast 154	java/lang/String
    //   273: invokevirtual 253	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   276: checkcast 83	com/tencent/mobileqq/data/troop/CommonlyUsedTroop
    //   279: astore 8
    //   281: aload 8
    //   283: lconst_0
    //   284: putfield 219	com/tencent/mobileqq/data/troop/CommonlyUsedTroop:addedTimestamp	J
    //   287: aload_0
    //   288: aload 5
    //   290: aload 8
    //   292: iconst_0
    //   293: invokespecial 279	com/tencent/mobileqq/troop/api/impl/TroopInfoServiceImpl:updateRecentUser	(Lcom/tencent/mobileqq/app/proxy/RecentUserProxy;Lcom/tencent/mobileqq/data/troop/CommonlyUsedTroop;Z)V
    //   296: goto -45 -> 251
    //   299: astore 6
    //   301: aload 4
    //   303: astore 5
    //   305: aload 6
    //   307: astore 4
    //   309: aload 5
    //   311: ifnull +8 -> 319
    //   314: aload 5
    //   316: invokevirtual 197	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   319: aload 4
    //   321: athrow
    //   322: aload_0
    //   323: getfield 81	com/tencent/mobileqq/troop/api/impl/TroopInfoServiceImpl:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   326: ldc 83
    //   328: invokevirtual 720	com/tencent/mobileqq/persistence/EntityManager:drop	(Ljava/lang/Class;)Z
    //   331: pop
    //   332: new 69	java/util/concurrent/ConcurrentHashMap
    //   335: dup
    //   336: aload 6
    //   338: invokespecial 722	java/util/concurrent/ConcurrentHashMap:<init>	(Ljava/util/Map;)V
    //   341: astore 7
    //   343: aload 6
    //   345: invokevirtual 723	java/util/concurrent/ConcurrentHashMap:clear	()V
    //   348: aload_0
    //   349: getfield 664	com/tencent/mobileqq/troop/api/impl/TroopInfoServiceImpl:prepareCommonlyUsedTroop	Ljava/util/Map;
    //   352: ifnull +231 -> 583
    //   355: aload_0
    //   356: getfield 664	com/tencent/mobileqq/troop/api/impl/TroopInfoServiceImpl:prepareCommonlyUsedTroop	Ljava/util/Map;
    //   359: invokeinterface 724 1 0
    //   364: invokeinterface 502 1 0
    //   369: astore 8
    //   371: aload 8
    //   373: invokeinterface 303 1 0
    //   378: ifeq +205 -> 583
    //   381: aload 8
    //   383: invokeinterface 307 1 0
    //   388: checkcast 154	java/lang/String
    //   391: astore 9
    //   393: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   396: ifeq +50 -> 446
    //   399: ldc 10
    //   401: iconst_4
    //   402: new 110	java/lang/StringBuilder
    //   405: dup
    //   406: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   409: ldc_w 726
    //   412: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: aload 9
    //   417: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: ldc_w 728
    //   423: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: aload_0
    //   427: getfield 664	com/tencent/mobileqq/troop/api/impl/TroopInfoServiceImpl:prepareCommonlyUsedTroop	Ljava/util/Map;
    //   430: aload 9
    //   432: invokeinterface 320 2 0
    //   437: invokevirtual 731	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   440: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   443: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   446: new 83	com/tencent/mobileqq/data/troop/CommonlyUsedTroop
    //   449: dup
    //   450: invokespecial 277	com/tencent/mobileqq/data/troop/CommonlyUsedTroop:<init>	()V
    //   453: astore 10
    //   455: aload 10
    //   457: aload 9
    //   459: putfield 120	com/tencent/mobileqq/data/troop/CommonlyUsedTroop:troopUin	Ljava/lang/String;
    //   462: aload 10
    //   464: aload_0
    //   465: getfield 664	com/tencent/mobileqq/troop/api/impl/TroopInfoServiceImpl:prepareCommonlyUsedTroop	Ljava/util/Map;
    //   468: aload 9
    //   470: invokeinterface 320 2 0
    //   475: checkcast 527	java/lang/Long
    //   478: invokevirtual 735	java/lang/Long:longValue	()J
    //   481: putfield 219	com/tencent/mobileqq/data/troop/CommonlyUsedTroop:addedTimestamp	J
    //   484: aload 6
    //   486: aload 9
    //   488: aload 10
    //   490: invokevirtual 132	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   493: pop
    //   494: aload 7
    //   496: invokevirtual 499	java/util/concurrent/ConcurrentHashMap:keySet	()Ljava/util/Set;
    //   499: invokeinterface 502 1 0
    //   504: astore 11
    //   506: aload 11
    //   508: invokeinterface 303 1 0
    //   513: ifeq +112 -> 625
    //   516: aload 11
    //   518: invokeinterface 307 1 0
    //   523: checkcast 154	java/lang/String
    //   526: astore 12
    //   528: aload 12
    //   530: aload 9
    //   532: invokevirtual 312	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   535: ifeq -29 -> 506
    //   538: aload 7
    //   540: aload 12
    //   542: invokevirtual 424	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   545: pop
    //   546: iconst_1
    //   547: istore_1
    //   548: iload_1
    //   549: ifeq +22 -> 571
    //   552: aload_0
    //   553: aload 5
    //   555: aload 10
    //   557: iconst_0
    //   558: invokespecial 279	com/tencent/mobileqq/troop/api/impl/TroopInfoServiceImpl:updateRecentUser	(Lcom/tencent/mobileqq/app/proxy/RecentUserProxy;Lcom/tencent/mobileqq/data/troop/CommonlyUsedTroop;Z)V
    //   561: aload_0
    //   562: aload 10
    //   564: invokevirtual 191	com/tencent/mobileqq/troop/api/impl/TroopInfoServiceImpl:updateEntity	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   567: pop
    //   568: goto -197 -> 371
    //   571: aload_0
    //   572: aload 5
    //   574: aload 10
    //   576: iconst_1
    //   577: invokespecial 279	com/tencent/mobileqq/troop/api/impl/TroopInfoServiceImpl:updateRecentUser	(Lcom/tencent/mobileqq/app/proxy/RecentUserProxy;Lcom/tencent/mobileqq/data/troop/CommonlyUsedTroop;Z)V
    //   580: goto -19 -> 561
    //   583: aload 4
    //   585: invokevirtual 194	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   588: aload 4
    //   590: ifnull -375 -> 215
    //   593: aload 4
    //   595: invokevirtual 197	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   598: return
    //   599: astore 4
    //   601: aconst_null
    //   602: astore 5
    //   604: goto -295 -> 309
    //   607: astore 6
    //   609: aload 4
    //   611: astore 5
    //   613: aload 6
    //   615: astore 4
    //   617: goto -308 -> 309
    //   620: astore 5
    //   622: goto -435 -> 187
    //   625: iconst_0
    //   626: istore_1
    //   627: goto -79 -> 548
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	630	0	this	TroopInfoServiceImpl
    //   547	80	1	i	int
    //   122	51	2	l	long
    //   1	593	4	localObject1	Object
    //   599	11	4	localObject2	Object
    //   615	1	4	localObject3	Object
    //   16	57	5	localObject4	Object
    //   185	12	5	localThrowable1	java.lang.Throwable
    //   237	375	5	localObject5	Object
    //   620	1	5	localThrowable2	java.lang.Throwable
    //   7	255	6	localConcurrentHashMap	ConcurrentHashMap
    //   299	186	6	localMap	Map
    //   607	7	6	localObject6	Object
    //   82	457	7	localObject7	Object
    //   279	103	8	localObject8	Object
    //   391	140	9	str1	String
    //   453	122	10	localCommonlyUsedTroop	CommonlyUsedTroop
    //   504	13	11	localIterator	Iterator
    //   526	15	12	str2	String
    // Exception table:
    //   from	to	target	type
    //   27	50	185	java/lang/Throwable
    //   50	62	185	java/lang/Throwable
    //   62	182	185	java/lang/Throwable
    //   216	251	185	java/lang/Throwable
    //   251	296	185	java/lang/Throwable
    //   322	371	185	java/lang/Throwable
    //   371	446	185	java/lang/Throwable
    //   446	506	185	java/lang/Throwable
    //   506	546	185	java/lang/Throwable
    //   552	561	185	java/lang/Throwable
    //   561	568	185	java/lang/Throwable
    //   571	580	185	java/lang/Throwable
    //   583	588	185	java/lang/Throwable
    //   27	50	299	finally
    //   50	62	299	finally
    //   62	182	299	finally
    //   216	251	299	finally
    //   251	296	299	finally
    //   322	371	299	finally
    //   371	446	299	finally
    //   446	506	299	finally
    //   506	546	299	finally
    //   552	561	299	finally
    //   561	568	299	finally
    //   571	580	299	finally
    //   583	588	299	finally
    //   9	18	599	finally
    //   187	205	607	finally
    //   9	18	620	java/lang/Throwable
  }
  
  public boolean removeCommonlyUsedTroop(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopInfoServiceImpl", 2, "removeCommonlyUsedTroop, troopUin is null");
      }
      return false;
    }
    CommonlyUsedTroop localCommonlyUsedTroop = (CommonlyUsedTroop)getCommonlyUsedTroopLazyCache().remove(paramString);
    if (localCommonlyUsedTroop != null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopInfoServiceImpl", 2, "removeCommonlyUsedTroop, troopUin=" + paramString);
      }
      localCommonlyUsedTroop.addedTimestamp = 0L;
      updateRecentUser(((IRecentUserProxyService)this.app.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache(), localCommonlyUsedTroop, false);
      this.em.remove(localCommonlyUsedTroop);
      return true;
    }
    return false;
  }
  
  public void saveTroopInfo(TroopInfo paramTroopInfo)
  {
    if ((paramTroopInfo == null) || (TextUtils.isEmpty(paramTroopInfo.troopuin)) || ("0".equals(paramTroopInfo.troopuin))) {
      return;
    }
    if (this.troopListCache == null) {
      this.troopListCache = new ConcurrentHashMap();
    }
    TroopInfoSorter.a(paramTroopInfo);
    if (this.troopListCache != null) {
      this.troopListCache.put(paramTroopInfo.troopuin, paramTroopInfo);
    }
    if ((!updateEntity(paramTroopInfo)) && (QLog.isColorLevel())) {
      QLog.d("TroopInfoServiceImpl", 2, "saveTroopInfo failed.");
    }
    RecentUserProxy localRecentUserProxy = ((IRecentUserProxyService)this.app.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
    RecentUser localRecentUser = localRecentUserProxy.a(paramTroopInfo.troopuin, 1);
    localRecentUser.displayName = paramTroopInfo.getTroopDisplayName();
    if (localRecentUser.getStatus() == 1001) {
      localRecentUserProxy.b(localRecentUser);
    }
    buildTroopUI();
  }
  
  public void saveTroopInfoOnlyCacheAndDB(TroopInfo paramTroopInfo)
  {
    if ((paramTroopInfo == null) || (TextUtils.isEmpty(paramTroopInfo.troopuin)) || ("0".equals(paramTroopInfo.troopuin))) {}
    do
    {
      return;
      if (this.troopListCache == null) {
        this.troopListCache = new ConcurrentHashMap();
      }
      TroopInfoSorter.a(paramTroopInfo);
      if (this.troopListCache != null) {
        this.troopListCache.put(paramTroopInfo.troopuin, paramTroopInfo);
      }
    } while ((updateEntity(paramTroopInfo)) || (!QLog.isColorLevel()));
    QLog.d("TroopInfoServiceImpl", 2, "saveTroopInfoOnlyCacheAndDB failed.");
  }
  
  public TroopInfo saveTroopName(String paramString1, String paramString2)
  {
    TroopInfo localTroopInfo2 = findTroopInfo(paramString1);
    TroopInfo localTroopInfo1 = localTroopInfo2;
    if (localTroopInfo2 == null)
    {
      localTroopInfo1 = new TroopInfo();
      localTroopInfo1.troopuin = paramString1;
    }
    localTroopInfo1.troopname = paramString2;
    if ((this.troopListCache != null) && (!this.troopListCache.containsKey(localTroopInfo1.troopuin))) {
      this.troopListCache.put(localTroopInfo1.troopuin, localTroopInfo1);
    }
    TroopInfoSorter.a(localTroopInfo1);
    buildTroopUI();
    return localTroopInfo1;
  }
  
  public void saveTroops(ArrayList<TroopInfo> paramArrayList)
  {
    if (this.troopListCache == null) {
      if (paramArrayList == null) {
        break label33;
      }
    }
    label33:
    for (int i = paramArrayList.size();; i = 0)
    {
      this.troopListCache = new ConcurrentHashMap(i);
      if (paramArrayList != null) {
        break;
      }
      return;
    }
    Object localObject1 = paramArrayList.iterator();
    TroopInfo localTroopInfo;
    while (((Iterator)localObject1).hasNext())
    {
      localTroopInfo = (TroopInfo)((Iterator)localObject1).next();
      if ((localTroopInfo == null) || (TroopCommonConfig.a(this.app, localTroopInfo.troopuin))) {
        ((Iterator)localObject1).remove();
      }
    }
    localObject1 = this.em.getTransaction();
    for (;;)
    {
      try
      {
        ((EntityTransaction)localObject1).begin();
        i = 0;
        if (i < paramArrayList.size())
        {
          localTroopInfo = (TroopInfo)paramArrayList.get(i);
          if ((localTroopInfo == null) || ((localTroopInfo.troopuin == null) && (localTroopInfo.troopcode == null))) {
            break label300;
          }
          if (((localTroopInfo.troopcode == null) || (localTroopInfo.troopcode.length() <= 1)) && (localTroopInfo.troopuin != null))
          {
            Object localObject2 = (Entity)this.troopListCache.get(localTroopInfo.troopuin);
            if ((localObject2 != null) && ((localObject2 instanceof TroopInfo)))
            {
              localObject2 = (TroopInfo)localObject2;
              if ((((TroopInfo)localObject2).troopcode != null) && (((TroopInfo)localObject2).troopcode.length() > 1)) {
                localTroopInfo.troopcode = ((TroopInfo)localObject2).troopcode;
              }
            }
          }
          this.troopListCache.put(localTroopInfo.troopuin, localTroopInfo);
          updateEntity(localTroopInfo);
        }
      }
      catch (Exception paramArrayList)
      {
        paramArrayList.printStackTrace();
        ((EntityTransaction)localObject1).end();
        buildTroopUI();
        return;
        ((EntityTransaction)localObject1).commit();
        ((EntityTransaction)localObject1).end();
        continue;
      }
      finally
      {
        ((EntityTransaction)localObject1).end();
      }
      label300:
      i += 1;
    }
  }
  
  public void saveTroops(ArrayList<TroopInfo> paramArrayList, long paramLong)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    saveTroops(paramArrayList);
    buildTroopUI();
  }
  
  public void setTroopEliminated(List<String> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    EntityTransaction localEntityTransaction;
    for (;;)
    {
      return;
      QLog.i("troop_ext", 1, "setTroopEliminated list is: " + paramList.toString());
      localObject = null;
      try
      {
        localEntityTransaction = this.em.getTransaction();
        localObject = localEntityTransaction;
        localEntityTransaction.begin();
        localObject = localEntityTransaction;
        paramList = paramList.iterator();
        for (;;)
        {
          localObject = localEntityTransaction;
          if (!paramList.hasNext()) {
            break;
          }
          localObject = localEntityTransaction;
          TroopInfo localTroopInfo = findTroopInfo((String)paramList.next());
          if (localTroopInfo != null)
          {
            localObject = localEntityTransaction;
            localTroopInfo.eliminated = 1;
            localObject = localEntityTransaction;
            this.em.update(localTroopInfo);
          }
        }
        if (localObject == null) {}
      }
      catch (Exception paramList)
      {
        paramList.printStackTrace();
        QLog.e("TroopInfoServiceImpl", 1, "troop_ext " + paramList.getMessage());
      }
    }
    localObject.end();
    return;
    Object localObject = localEntityTransaction;
    localEntityTransaction.commit();
    localObject = localEntityTransaction;
    localEntityTransaction.end();
  }
  
  public boolean updateEntity(Entity paramEntity)
  {
    if (!this.em.isOpen()) {}
    do
    {
      do
      {
        return false;
        if (paramEntity.getStatus() != 1000) {
          break;
        }
        this.em.persistOrReplace(paramEntity);
      } while (paramEntity.getStatus() != 1001);
      return true;
    } while ((paramEntity.getStatus() != 1001) && (paramEntity.getStatus() != 1002));
    return this.em.update(paramEntity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.impl.TroopInfoServiceImpl
 * JD-Core Version:    0.7.0.1
 */