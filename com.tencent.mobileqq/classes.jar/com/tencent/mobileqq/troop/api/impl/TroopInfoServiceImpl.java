package com.tencent.mobileqq.troop.api.impl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
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
    try
    {
      if (this.commonlyUsedTroopCache != null) {
        break label179;
      }
      localObject1 = (ArrayList)this.em.query(CommonlyUsedTroop.class, false, null, null, null, null, null, null);
      j = 0;
      if (localObject1 == null) {
        break label199;
      }
      i = ((ArrayList)localObject1).size();
    }
    finally
    {
      for (;;)
      {
        Object localObject1;
        int j;
        for (;;)
        {
          label179:
          throw localObject2;
        }
        label199:
        int i = 0;
      }
    }
    this.commonlyUsedTroopCache = new QQConcurrentHashMap(1014, i, 25);
    while (j < i)
    {
      CommonlyUsedTroop localCommonlyUsedTroop = (CommonlyUsedTroop)((ArrayList)localObject1).get(j);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("init load groupcode = ");
        localStringBuilder.append(localCommonlyUsedTroop.troopUin);
        QLog.d("OpenTroopDebug", 2, localStringBuilder.toString());
      }
      this.commonlyUsedTroopCache.put(localCommonlyUsedTroop.troopUin, localCommonlyUsedTroop);
      j += 1;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("load CommonlyUsedTroop info: size = ");
      ((StringBuilder)localObject1).append(i);
      QLog.d("CommonlyUsedTroop", 2, ((StringBuilder)localObject1).toString());
    }
    localObject1 = this.commonlyUsedTroopCache;
    return localObject1;
  }
  
  private void initTroopListCache()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopInfoServiceImpl", 2, "initTroopListCache begin");
    }
    Object localObject2 = (ArrayList)this.em.query(TroopInfo.class, false, null, null, null, null, null, null);
    int j = 0;
    int i;
    if (localObject2 != null) {
      i = ((ArrayList)localObject2).size();
    } else {
      i = 0;
    }
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap(i);
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = new ArrayList();
      i = 0;
      while (i < ((ArrayList)localObject2).size())
      {
        TroopInfo localTroopInfo = (TroopInfo)((ArrayList)localObject2).get(i);
        if ((localTroopInfo.mCompareSpell == null) || (localTroopInfo.mCompareSpell.length() == 0))
        {
          TroopInfoSorter.a(localTroopInfo);
          ((ArrayList)localObject1).add(localTroopInfo);
        }
        if (!TextUtils.isEmpty(localTroopInfo.troopuin)) {
          localConcurrentHashMap.put(localTroopInfo.troopuin, localTroopInfo);
        }
        i += 1;
      }
      if (((ArrayList)localObject1).size() > 0) {
        localObject2 = this.em.getTransaction();
      }
    }
    try
    {
      try
      {
        ((EntityTransaction)localObject2).begin();
        i = j;
        while (i < ((ArrayList)localObject1).size())
        {
          updateEntity((Entity)((ArrayList)localObject1).get(i));
          i += 1;
        }
      }
      finally
      {
        ((EntityTransaction)localObject2).end();
      }
    }
    catch (Exception localException)
    {
      label230:
      break label230;
    }
    ((EntityTransaction)localObject2).end();
    ((ArrayList)localObject1).clear();
    this.troopListCache.putAll(localMap);
    this.isTroopCacheInited = true;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("initTroopListCache end: ");
      ((StringBuilder)localObject1).append(localMap.size());
      QLog.d("TroopInfoServiceImpl", 2, ((StringBuilder)localObject1).toString());
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
      return;
    }
    if ((paramCommonlyUsedTroop.addedTimestamp > 0L) && (paramCommonlyUsedTroop.addedTimestamp > 1558281600L) && (paramBoolean))
    {
      localRecentUser = new RecentUser(paramCommonlyUsedTroop.troopUin, 1);
      localRecentUser.showUpTime = paramCommonlyUsedTroop.addedTimestamp;
      localRecentUser.opTime = paramCommonlyUsedTroop.addedTimestamp;
      paramRecentUserProxy.b(localRecentUser);
    }
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" addCommonlyUsedTroop troopUin=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" troop.addedTimestamp");
      localStringBuilder.append(paramLong);
      QLog.d("TroopInfoServiceImpl", 4, localStringBuilder.toString());
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
    ConcurrentHashMap localConcurrentHashMap = this.troopListCache;
    if ((localConcurrentHashMap != null) && (!localConcurrentHashMap.containsKey(paramTroopInfo.troopuin))) {
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
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramITroopInfoCallback == null) {
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
  }
  
  public void buildTroopUI()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopInfoServiceImpl", 2, "buildTroopUI begin: ");
    }
    ArrayList localArrayList = new ArrayList();
    ??? = this.troopListCache;
    if (??? != null)
    {
      int i = ((ConcurrentHashMap)???).size();
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
            } else if (QLog.isColorLevel()) {
              QLog.d("TroopInfoServiceImpl", 2, String.format("buildTroopUI filter troop: %s, exitReason: %s", new Object[] { localTroopInfo.troopuin, Integer.valueOf(localTroopInfo.exitTroopReason) }));
            }
            synchronized (this.updateHeadList)
            {
              if ((localTroopInfo.isNewTroop()) && (!localTroopInfo.hasSetTroopHead()) && (!this.updateHeadList.contains(localTroopInfo.troopuin)))
              {
                TroopInfoServiceConfig.a(localTroopInfo.troopuin, false);
                this.updateHeadList.add(localTroopInfo.troopuin);
              }
            }
          }
        }
        if (i > 1) {
          Collections.sort(localList, TroopInfoSorter.a);
        }
      }
    }
    this.mUiTroopArrayList = localList;
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("buildTroopUI end: ");
      ((StringBuilder)???).append(localList.size());
      QLog.d("TroopInfoServiceImpl", 2, ((StringBuilder)???).toString());
    }
  }
  
  public boolean clearPassiveExitTroopInfo(String paramString)
  {
    Object localObject = findTroopInfo(paramString, true);
    if (localObject != null)
    {
      if (!((TroopInfo)localObject).isExited()) {
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopInfoServiceImpl", 2, String.format("clearPassiveExitTroopInfo, troopUin: %s, exit reason: %s", new Object[] { paramString, Integer.valueOf(((TroopInfo)localObject).exitTroopReason) }));
      }
      this.em.remove((Entity)localObject);
      localObject = this.troopListCache;
      if (localObject != null) {
        ((ConcurrentHashMap)localObject).remove(paramString);
      }
      return true;
    }
    return false;
  }
  
  public void deleteTroop(String paramString)
  {
    deleteTroop(paramString, false);
  }
  
  public boolean deleteTroop(String paramString, boolean paramBoolean)
  {
    Object localObject = findTroopInfo(paramString, paramBoolean);
    if (localObject == null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("deleteTroop  troopinfo is null,troopUin = ");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("TroopInfoServiceImpl", 2, ((StringBuilder)localObject).toString());
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopInfoServiceImpl", 2, String.format("deleteTroop, troopUin: %s, exitTroopReason: %s, isDelExit: %s", new Object[] { paramString, Integer.valueOf(((TroopInfo)localObject).exitTroopReason), Boolean.valueOf(paramBoolean) }));
    }
    ITroopMemberInfoService localITroopMemberInfoService = (ITroopMemberInfoService)this.app.getRuntimeService(ITroopMemberInfoService.class, "");
    if (localITroopMemberInfoService != null) {
      localITroopMemberInfoService.deleteTroopMembers(paramString);
    }
    this.em.remove((Entity)localObject);
    deleteTroopWithoutDB(paramString);
    return true;
  }
  
  /* Error */
  public void deleteTroopList(List<String> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +313 -> 314
    //   4: aload_1
    //   5: invokeinterface 448 1 0
    //   10: ifne +6 -> 16
    //   13: goto +301 -> 314
    //   16: aconst_null
    //   17: astore_2
    //   18: aconst_null
    //   19: astore_3
    //   20: aload_0
    //   21: getfield 81	com/tencent/mobileqq/troop/api/impl/TroopInfoServiceImpl:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   24: invokevirtual 180	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   27: astore 4
    //   29: aload 4
    //   31: astore_3
    //   32: aload 4
    //   34: astore_2
    //   35: aload 4
    //   37: invokevirtual 185	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   40: aload 4
    //   42: astore_3
    //   43: aload 4
    //   45: astore_2
    //   46: aload_1
    //   47: invokeinterface 298 1 0
    //   52: astore 5
    //   54: aload 4
    //   56: astore_3
    //   57: aload 4
    //   59: astore_2
    //   60: aload 5
    //   62: invokeinterface 303 1 0
    //   67: ifeq +101 -> 168
    //   70: aload 4
    //   72: astore_3
    //   73: aload 4
    //   75: astore_2
    //   76: aload 5
    //   78: invokeinterface 307 1 0
    //   83: checkcast 154	java/lang/String
    //   86: astore 6
    //   88: aload 4
    //   90: astore_3
    //   91: aload 4
    //   93: astore_2
    //   94: aload_0
    //   95: aload 6
    //   97: invokevirtual 451	com/tencent/mobileqq/troop/api/impl/TroopInfoServiceImpl:findTroopInfo	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/troop/TroopInfo;
    //   100: astore 7
    //   102: aload 7
    //   104: ifnull +22 -> 126
    //   107: aload 4
    //   109: astore_3
    //   110: aload 4
    //   112: astore_2
    //   113: aload_0
    //   114: getfield 81	com/tencent/mobileqq/troop/api/impl/TroopInfoServiceImpl:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   117: aload 7
    //   119: invokevirtual 422	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   122: pop
    //   123: goto -69 -> 54
    //   126: aload 4
    //   128: astore_3
    //   129: aload 4
    //   131: astore_2
    //   132: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   135: ifeq -81 -> 54
    //   138: aload 4
    //   140: astore_3
    //   141: aload 4
    //   143: astore_2
    //   144: ldc 10
    //   146: iconst_2
    //   147: ldc_w 453
    //   150: iconst_1
    //   151: anewarray 4	java/lang/Object
    //   154: dup
    //   155: iconst_0
    //   156: aload 6
    //   158: aastore
    //   159: invokestatic 390	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   162: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   165: goto -111 -> 54
    //   168: aload 4
    //   170: astore_3
    //   171: aload 4
    //   173: astore_2
    //   174: aload 4
    //   176: invokevirtual 194	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   179: aload 4
    //   181: ifnull +81 -> 262
    //   184: aload 4
    //   186: astore_2
    //   187: aload_2
    //   188: invokevirtual 197	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   191: goto +71 -> 262
    //   194: astore_1
    //   195: goto +109 -> 304
    //   198: astore 4
    //   200: aload_2
    //   201: astore_3
    //   202: aload 4
    //   204: invokevirtual 456	java/lang/Exception:printStackTrace	()V
    //   207: aload_2
    //   208: astore_3
    //   209: new 108	java/lang/StringBuilder
    //   212: dup
    //   213: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   216: astore 5
    //   218: aload_2
    //   219: astore_3
    //   220: aload 5
    //   222: ldc_w 458
    //   225: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: pop
    //   229: aload_2
    //   230: astore_3
    //   231: aload 5
    //   233: aload 4
    //   235: invokevirtual 461	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   238: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: pop
    //   242: aload_2
    //   243: astore_3
    //   244: ldc 10
    //   246: iconst_1
    //   247: aload 5
    //   249: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: invokestatic 248	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   255: aload_2
    //   256: ifnull +6 -> 262
    //   259: goto -72 -> 187
    //   262: aload_1
    //   263: invokeinterface 298 1 0
    //   268: astore_1
    //   269: aload_1
    //   270: invokeinterface 303 1 0
    //   275: ifeq +28 -> 303
    //   278: aload_1
    //   279: invokeinterface 307 1 0
    //   284: checkcast 154	java/lang/String
    //   287: astore_2
    //   288: aload_2
    //   289: invokestatic 176	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   292: ifne -23 -> 269
    //   295: aload_0
    //   296: aload_2
    //   297: invokevirtual 446	com/tencent/mobileqq/troop/api/impl/TroopInfoServiceImpl:deleteTroopWithoutDB	(Ljava/lang/String;)V
    //   300: goto -31 -> 269
    //   303: return
    //   304: aload_3
    //   305: ifnull +7 -> 312
    //   308: aload_3
    //   309: invokevirtual 197	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   312: aload_1
    //   313: athrow
    //   314: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   317: ifeq +12 -> 329
    //   320: ldc 10
    //   322: iconst_2
    //   323: ldc_w 463
    //   326: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   329: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	330	0	this	TroopInfoServiceImpl
    //   0	330	1	paramList	List<String>
    //   17	280	2	localObject1	Object
    //   19	290	3	localObject2	Object
    //   27	158	4	localEntityTransaction	EntityTransaction
    //   198	36	4	localException	Exception
    //   52	196	5	localObject3	Object
    //   86	71	6	str	String
    //   100	18	7	localTroopInfo	TroopInfo
    // Exception table:
    //   from	to	target	type
    //   20	29	194	finally
    //   35	40	194	finally
    //   46	54	194	finally
    //   60	70	194	finally
    //   76	88	194	finally
    //   94	102	194	finally
    //   113	123	194	finally
    //   132	138	194	finally
    //   144	165	194	finally
    //   174	179	194	finally
    //   202	207	194	finally
    //   209	218	194	finally
    //   220	229	194	finally
    //   231	242	194	finally
    //   244	255	194	finally
    //   20	29	198	java/lang/Exception
    //   35	40	198	java/lang/Exception
    //   46	54	198	java/lang/Exception
    //   60	70	198	java/lang/Exception
    //   76	88	198	java/lang/Exception
    //   94	102	198	java/lang/Exception
    //   113	123	198	java/lang/Exception
    //   132	138	198	java/lang/Exception
    //   144	165	198	java/lang/Exception
    //   174	179	198	java/lang/Exception
  }
  
  public void deleteTroopWithoutDB(String paramString)
  {
    ConcurrentHashMap localConcurrentHashMap = this.troopListCache;
    if (localConcurrentHashMap != null) {
      localConcurrentHashMap.remove(paramString);
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
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("findTroopInfo, troopUin isEmpty:");
        ((StringBuilder)localObject1).append(paramString);
        QLog.e("TroopInfoServiceImpl", 2, ((StringBuilder)localObject1).toString());
      }
      return null;
    }
    Object localObject2 = (TroopInfo)this.troopListCache.get(paramString);
    Object localObject1 = localObject2;
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
    if ((localObject2 == null) && (QLog.isColorLevel())) {
      QLog.d("TroopInfoServiceImpl", 2, String.format("findTroopInfo is null , troopUin: %s, containExited: %s, findDB: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) }));
    }
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
    Object localObject = this.troopListCache;
    if (localObject != null)
    {
      localObject = ((ConcurrentHashMap)localObject).values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Entity localEntity = (Entity)((Iterator)localObject).next();
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
  
  public long getInsertJoinTroopMsgTime(String paramString)
  {
    SharedPreferences localSharedPreferences = this.app.getPreferences();
    String str = this.app.getCurrentAccountUin();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("line_");
    localStringBuilder.append(str);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    return localSharedPreferences.getLong(localStringBuilder.toString(), -1L);
  }
  
  public String getTroopCodeByTroopUin(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject1 = null;
    if (bool) {
      return null;
    }
    Object localObject2;
    if (!this.troopUinPool.containsValue(paramString))
    {
      localObject2 = findTroopInfo(paramString, true);
      if (localObject2 == null) {
        return null;
      }
      if (((TroopInfo)localObject2).troopcode != null)
      {
        if (((TroopInfo)localObject2).troopuin == null) {
          return null;
        }
        this.troopUinPool.put(((TroopInfo)localObject2).troopcode, ((TroopInfo)localObject2).troopuin);
      }
      else
      {
        return null;
      }
    }
    Iterator localIterator = this.troopUinPool.keySet().iterator();
    while ((localIterator != null) && (localIterator.hasNext()))
    {
      localObject2 = (String)localIterator.next();
      String str = (String)this.troopUinPool.get(localObject2);
      if ((str != null) && (str.equals(paramString))) {
        localObject1 = localObject2;
      }
    }
    return localObject1;
  }
  
  public void getTroopCodeByTroopUinAsync(String paramString, ITroopInfoService.GetTroopCodeCallback paramGetTroopCodeCallback)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramGetTroopCodeCallback != null))
    {
      ThreadManager.post(new TroopInfoServiceImpl.2(this, paramString, paramGetTroopCodeCallback), 8, null, false);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("TroopInfoServiceImpl", 2, "getTroopCodeByTroopUinAsync, param is empty");
    }
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
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getTroopInfo, troopUin isEmpty:");
        ((StringBuilder)localObject2).append(paramString);
        QLog.e("TroopInfoServiceImpl", 2, ((StringBuilder)localObject2).toString());
        localObject2 = localObject1;
      }
    }
    else
    {
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
    if (QLog.isColorLevel()) {
      QLog.d("TroopInfoServiceImpl", 2, StringUtil.a(new Object[] { "TroopManger getTroopInfo()", paramString, Long.valueOf(((TroopInfo)localObject2).dwGroupFlagExt) }));
    }
    return localObject2;
  }
  
  public TroopInfo getTroopInfoFromCache(String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString))
    {
      TroopInfo localTroopInfo = new TroopInfo();
      localObject = localTroopInfo;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getTroopInfoFromCache, troopUin isEmpty:");
        ((StringBuilder)localObject).append(paramString);
        QLog.e("TroopInfoServiceImpl", 2, ((StringBuilder)localObject).toString());
        return localTroopInfo;
      }
    }
    else
    {
      localObject = (TroopInfo)this.troopListCache.get(paramString);
    }
    return localObject;
  }
  
  public ArrayList<String> getTroopMemberForTroopHead(String paramString)
  {
    Object localObject = getTroopInfo(paramString);
    paramString = new ArrayList();
    if ((localObject != null) && (((TroopInfo)localObject).mHeaderUinsNew != null))
    {
      if (((TroopInfo)localObject).mHeaderUinsNew == " ") {
        return paramString;
      }
      localObject = ((TroopInfo)localObject).mHeaderUinsNew.split(";");
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        CharSequence localCharSequence = localObject[i];
        if (!TextUtils.isEmpty(localCharSequence)) {
          paramString.add(localCharSequence);
        }
        i += 1;
      }
    }
    TroopCommonConfig.a(paramString);
    return paramString;
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
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return null;
      }
      if (this.mTroopCodeList == null) {
        this.mTroopCodeList = new ConcurrentHashMap();
      }
      if (this.mTroopCodeList.containsKey(paramString)) {
        return (String)this.mTroopCodeList.get(paramString);
      }
      Object localObject1 = this.troopListCache;
      if (localObject1 != null)
      {
        localObject1 = ((ConcurrentHashMap)localObject1).entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (TroopInfo)((Map.Entry)((Iterator)localObject1).next()).getValue();
          if ((localObject2 != null) && (((TroopInfo)localObject2).troopcode != null) && (((TroopInfo)localObject2).troopcode.equals(paramString)))
          {
            localObject2 = ((TroopInfo)localObject2).troopuin;
            if ((localObject2 != null) && (((String)localObject2).length() > 0))
            {
              this.mTroopCodeList.put(paramString, localObject2);
              return localObject2;
            }
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
      if (localTroopInfo.troopcode != null)
      {
        if (localTroopInfo.troopuin == null) {
          return null;
        }
        this.troopUinPool.put(localTroopInfo.troopcode, localTroopInfo.troopuin);
      }
      else
      {
        return null;
      }
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
    Object localObject = this.mUiTroopArrayList;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Entity localEntity = (Entity)((Iterator)localObject).next();
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
    Object localObject = this.troopListCache;
    if ((localObject != null) && (((ConcurrentHashMap)localObject).size() > 0)) {
      return false;
    }
    localObject = (ArrayList)this.em.query(TroopInfo.class, false, null, null, null, null, null, "1");
    return (localObject == null) || (((ArrayList)localObject).size() <= 0);
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
    boolean bool1 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    paramString = findTroopInfo(paramString);
    bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (paramString.isHomeworkTroop()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean isQidianPrivateTroop(String paramString)
  {
    boolean bool1 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    paramString = findTroopInfo(paramString);
    bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (TroopInfo.isQidianPrivateTroop(paramString.dwGroupFlagExt3)) {
        bool1 = true;
      }
    }
    return bool1;
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("queryTroops_");
    ((StringBuilder)localObject).append(paramArrayList.size());
    TraceUtils.traceBegin(((StringBuilder)localObject).toString());
    if (paramArrayList.size() > 0)
    {
      localObject = new StringBuilder("troopuin=? ");
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
    //   0: aload_0
    //   1: invokespecial 250	com/tencent/mobileqq/troop/api/impl/TroopInfoServiceImpl:getCommonlyUsedTroopLazyCache	()Ljava/util/concurrent/ConcurrentHashMap;
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 4
    //   9: aconst_null
    //   10: astore 5
    //   12: aload_0
    //   13: getfield 81	com/tencent/mobileqq/troop/api/impl/TroopInfoServiceImpl:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   16: invokevirtual 180	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   19: astore 6
    //   21: aload 6
    //   23: ifnull +937 -> 960
    //   26: aload 6
    //   28: astore 5
    //   30: aload 6
    //   32: astore 4
    //   34: aload 6
    //   36: invokevirtual 185	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   39: aload 6
    //   41: astore 5
    //   43: aload 6
    //   45: astore 4
    //   47: aload_0
    //   48: getfield 681	com/tencent/mobileqq/troop/api/impl/TroopInfoServiceImpl:prepareCommonlyUsedTroop	Ljava/util/Map;
    //   51: ifnonnull +22 -> 73
    //   54: aload 6
    //   56: astore 5
    //   58: aload 6
    //   60: astore 4
    //   62: aload_0
    //   63: new 62	java/util/HashMap
    //   66: dup
    //   67: invokespecial 711	java/util/HashMap:<init>	()V
    //   70: putfield 681	com/tencent/mobileqq/troop/api/impl/TroopInfoServiceImpl:prepareCommonlyUsedTroop	Ljava/util/Map;
    //   73: aload 6
    //   75: astore 5
    //   77: aload 6
    //   79: astore 4
    //   81: aload 7
    //   83: invokevirtual 520	java/util/concurrent/ConcurrentHashMap:keySet	()Ljava/util/Set;
    //   86: invokeinterface 523 1 0
    //   91: astore 8
    //   93: aload 6
    //   95: astore 5
    //   97: aload 6
    //   99: astore 4
    //   101: aload 8
    //   103: invokeinterface 303 1 0
    //   108: ifeq +220 -> 328
    //   111: aload 6
    //   113: astore 5
    //   115: aload 6
    //   117: astore 4
    //   119: aload 8
    //   121: invokeinterface 307 1 0
    //   126: checkcast 154	java/lang/String
    //   129: astore 9
    //   131: aload 6
    //   133: astore 5
    //   135: aload 6
    //   137: astore 4
    //   139: aload_0
    //   140: getfield 255	com/tencent/mobileqq/troop/api/impl/TroopInfoServiceImpl:app	Lmqq/app/AppRuntime;
    //   143: invokevirtual 715	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   146: invokevirtual 720	mqq/app/MobileQQ:getBaseContext	()Landroid/content/Context;
    //   149: aload_0
    //   150: getfield 255	com/tencent/mobileqq/troop/api/impl/TroopInfoServiceImpl:app	Lmqq/app/AppRuntime;
    //   153: invokevirtual 723	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   156: aload 9
    //   158: invokestatic 726	com/tencent/mobileqq/troop/api/config/TroopCommonConfig:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z
    //   161: ifeq -68 -> 93
    //   164: aload 6
    //   166: astore 5
    //   168: aload 6
    //   170: astore 4
    //   172: aload 7
    //   174: aload 9
    //   176: invokevirtual 253	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   179: checkcast 83	com/tencent/mobileqq/data/troop/CommonlyUsedTroop
    //   182: getfield 219	com/tencent/mobileqq/data/troop/CommonlyUsedTroop:addedTimestamp	J
    //   185: lstore_2
    //   186: aload 6
    //   188: astore 5
    //   190: aload 6
    //   192: astore 4
    //   194: aload_0
    //   195: getfield 681	com/tencent/mobileqq/troop/api/impl/TroopInfoServiceImpl:prepareCommonlyUsedTroop	Ljava/util/Map;
    //   198: aload 9
    //   200: lload_2
    //   201: invokestatic 574	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   204: invokeinterface 337 3 0
    //   209: pop
    //   210: aload 6
    //   212: astore 5
    //   214: aload 6
    //   216: astore 4
    //   218: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   221: ifeq -128 -> 93
    //   224: aload 6
    //   226: astore 5
    //   228: aload 6
    //   230: astore 4
    //   232: new 108	java/lang/StringBuilder
    //   235: dup
    //   236: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   239: astore 10
    //   241: aload 6
    //   243: astore 5
    //   245: aload 6
    //   247: astore 4
    //   249: aload 10
    //   251: ldc_w 728
    //   254: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: pop
    //   258: aload 6
    //   260: astore 5
    //   262: aload 6
    //   264: astore 4
    //   266: aload 10
    //   268: aload 9
    //   270: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: pop
    //   274: aload 6
    //   276: astore 5
    //   278: aload 6
    //   280: astore 4
    //   282: aload 10
    //   284: ldc_w 730
    //   287: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: pop
    //   291: aload 6
    //   293: astore 5
    //   295: aload 6
    //   297: astore 4
    //   299: aload 10
    //   301: lload_2
    //   302: invokevirtual 276	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   305: pop
    //   306: aload 6
    //   308: astore 5
    //   310: aload 6
    //   312: astore 4
    //   314: ldc 10
    //   316: iconst_4
    //   317: aload 10
    //   319: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   322: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   325: goto -232 -> 93
    //   328: aload 6
    //   330: astore 5
    //   332: aload 6
    //   334: astore 4
    //   336: aload_0
    //   337: getfield 255	com/tencent/mobileqq/troop/api/impl/TroopInfoServiceImpl:app	Lmqq/app/AppRuntime;
    //   340: ldc_w 257
    //   343: ldc_w 259
    //   346: invokevirtual 265	mqq/app/AppRuntime:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   349: checkcast 257	com/tencent/mobileqq/proxy/api/IRecentUserProxyService
    //   352: invokeinterface 269 1 0
    //   357: astore 8
    //   359: aload 6
    //   361: astore 5
    //   363: aload 6
    //   365: astore 4
    //   367: aload 7
    //   369: invokevirtual 520	java/util/concurrent/ConcurrentHashMap:keySet	()Ljava/util/Set;
    //   372: invokeinterface 523 1 0
    //   377: astore 9
    //   379: aload 6
    //   381: astore 5
    //   383: aload 6
    //   385: astore 4
    //   387: aload 9
    //   389: invokeinterface 303 1 0
    //   394: ifeq +65 -> 459
    //   397: aload 6
    //   399: astore 5
    //   401: aload 6
    //   403: astore 4
    //   405: aload 7
    //   407: aload 9
    //   409: invokeinterface 307 1 0
    //   414: checkcast 154	java/lang/String
    //   417: invokevirtual 253	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   420: checkcast 83	com/tencent/mobileqq/data/troop/CommonlyUsedTroop
    //   423: astore 10
    //   425: aload 6
    //   427: astore 5
    //   429: aload 6
    //   431: astore 4
    //   433: aload 10
    //   435: lconst_0
    //   436: putfield 219	com/tencent/mobileqq/data/troop/CommonlyUsedTroop:addedTimestamp	J
    //   439: aload 6
    //   441: astore 5
    //   443: aload 6
    //   445: astore 4
    //   447: aload_0
    //   448: aload 8
    //   450: aload 10
    //   452: iconst_0
    //   453: invokespecial 279	com/tencent/mobileqq/troop/api/impl/TroopInfoServiceImpl:updateRecentUser	(Lcom/tencent/mobileqq/app/proxy/RecentUserProxy;Lcom/tencent/mobileqq/data/troop/CommonlyUsedTroop;Z)V
    //   456: goto -77 -> 379
    //   459: aload 6
    //   461: astore 5
    //   463: aload 6
    //   465: astore 4
    //   467: aload_0
    //   468: getfield 81	com/tencent/mobileqq/troop/api/impl/TroopInfoServiceImpl:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   471: ldc 83
    //   473: invokevirtual 734	com/tencent/mobileqq/persistence/EntityManager:drop	(Ljava/lang/Class;)Z
    //   476: pop
    //   477: aload 6
    //   479: astore 5
    //   481: aload 6
    //   483: astore 4
    //   485: new 69	java/util/concurrent/ConcurrentHashMap
    //   488: dup
    //   489: aload 7
    //   491: invokespecial 736	java/util/concurrent/ConcurrentHashMap:<init>	(Ljava/util/Map;)V
    //   494: astore 9
    //   496: aload 6
    //   498: astore 5
    //   500: aload 6
    //   502: astore 4
    //   504: aload 7
    //   506: invokevirtual 737	java/util/concurrent/ConcurrentHashMap:clear	()V
    //   509: aload 6
    //   511: astore 5
    //   513: aload 6
    //   515: astore 4
    //   517: aload_0
    //   518: getfield 681	com/tencent/mobileqq/troop/api/impl/TroopInfoServiceImpl:prepareCommonlyUsedTroop	Ljava/util/Map;
    //   521: ifnull +426 -> 947
    //   524: aload 6
    //   526: astore 5
    //   528: aload 6
    //   530: astore 4
    //   532: aload_0
    //   533: getfield 681	com/tencent/mobileqq/troop/api/impl/TroopInfoServiceImpl:prepareCommonlyUsedTroop	Ljava/util/Map;
    //   536: invokeinterface 738 1 0
    //   541: invokeinterface 523 1 0
    //   546: astore 10
    //   548: aload 6
    //   550: astore 5
    //   552: aload 6
    //   554: astore 4
    //   556: aload 10
    //   558: invokeinterface 303 1 0
    //   563: ifeq +384 -> 947
    //   566: aload 6
    //   568: astore 5
    //   570: aload 6
    //   572: astore 4
    //   574: aload 10
    //   576: invokeinterface 307 1 0
    //   581: checkcast 154	java/lang/String
    //   584: astore 11
    //   586: aload 6
    //   588: astore 5
    //   590: aload 6
    //   592: astore 4
    //   594: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   597: ifeq +114 -> 711
    //   600: aload 6
    //   602: astore 5
    //   604: aload 6
    //   606: astore 4
    //   608: new 108	java/lang/StringBuilder
    //   611: dup
    //   612: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   615: astore 12
    //   617: aload 6
    //   619: astore 5
    //   621: aload 6
    //   623: astore 4
    //   625: aload 12
    //   627: ldc_w 740
    //   630: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   633: pop
    //   634: aload 6
    //   636: astore 5
    //   638: aload 6
    //   640: astore 4
    //   642: aload 12
    //   644: aload 11
    //   646: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   649: pop
    //   650: aload 6
    //   652: astore 5
    //   654: aload 6
    //   656: astore 4
    //   658: aload 12
    //   660: ldc_w 742
    //   663: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   666: pop
    //   667: aload 6
    //   669: astore 5
    //   671: aload 6
    //   673: astore 4
    //   675: aload 12
    //   677: aload_0
    //   678: getfield 681	com/tencent/mobileqq/troop/api/impl/TroopInfoServiceImpl:prepareCommonlyUsedTroop	Ljava/util/Map;
    //   681: aload 11
    //   683: invokeinterface 320 2 0
    //   688: invokevirtual 745	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   691: pop
    //   692: aload 6
    //   694: astore 5
    //   696: aload 6
    //   698: astore 4
    //   700: ldc 10
    //   702: iconst_4
    //   703: aload 12
    //   705: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   708: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   711: aload 6
    //   713: astore 5
    //   715: aload 6
    //   717: astore 4
    //   719: new 83	com/tencent/mobileqq/data/troop/CommonlyUsedTroop
    //   722: dup
    //   723: invokespecial 277	com/tencent/mobileqq/data/troop/CommonlyUsedTroop:<init>	()V
    //   726: astore 12
    //   728: aload 6
    //   730: astore 5
    //   732: aload 6
    //   734: astore 4
    //   736: aload 12
    //   738: aload 11
    //   740: putfield 118	com/tencent/mobileqq/data/troop/CommonlyUsedTroop:troopUin	Ljava/lang/String;
    //   743: aload 6
    //   745: astore 5
    //   747: aload 6
    //   749: astore 4
    //   751: aload 12
    //   753: aload_0
    //   754: getfield 681	com/tencent/mobileqq/troop/api/impl/TroopInfoServiceImpl:prepareCommonlyUsedTroop	Ljava/util/Map;
    //   757: aload 11
    //   759: invokeinterface 320 2 0
    //   764: checkcast 571	java/lang/Long
    //   767: invokevirtual 749	java/lang/Long:longValue	()J
    //   770: putfield 219	com/tencent/mobileqq/data/troop/CommonlyUsedTroop:addedTimestamp	J
    //   773: aload 6
    //   775: astore 5
    //   777: aload 6
    //   779: astore 4
    //   781: aload 7
    //   783: aload 11
    //   785: aload 12
    //   787: invokevirtual 132	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   790: pop
    //   791: aload 6
    //   793: astore 5
    //   795: aload 6
    //   797: astore 4
    //   799: aload 9
    //   801: invokevirtual 520	java/util/concurrent/ConcurrentHashMap:keySet	()Ljava/util/Set;
    //   804: invokeinterface 523 1 0
    //   809: astore 13
    //   811: aload 6
    //   813: astore 5
    //   815: aload 6
    //   817: astore 4
    //   819: aload 13
    //   821: invokeinterface 303 1 0
    //   826: ifeq +210 -> 1036
    //   829: aload 6
    //   831: astore 5
    //   833: aload 6
    //   835: astore 4
    //   837: aload 13
    //   839: invokeinterface 307 1 0
    //   844: checkcast 154	java/lang/String
    //   847: astore 14
    //   849: aload 6
    //   851: astore 5
    //   853: aload 6
    //   855: astore 4
    //   857: aload 14
    //   859: aload 11
    //   861: invokevirtual 312	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   864: ifeq -53 -> 811
    //   867: aload 6
    //   869: astore 5
    //   871: aload 6
    //   873: astore 4
    //   875: aload 9
    //   877: aload 14
    //   879: invokevirtual 424	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   882: pop
    //   883: iconst_1
    //   884: istore_1
    //   885: goto +3 -> 888
    //   888: iload_1
    //   889: ifeq +23 -> 912
    //   892: aload 6
    //   894: astore 5
    //   896: aload 6
    //   898: astore 4
    //   900: aload_0
    //   901: aload 8
    //   903: aload 12
    //   905: iconst_0
    //   906: invokespecial 279	com/tencent/mobileqq/troop/api/impl/TroopInfoServiceImpl:updateRecentUser	(Lcom/tencent/mobileqq/app/proxy/RecentUserProxy;Lcom/tencent/mobileqq/data/troop/CommonlyUsedTroop;Z)V
    //   909: goto +20 -> 929
    //   912: aload 6
    //   914: astore 5
    //   916: aload 6
    //   918: astore 4
    //   920: aload_0
    //   921: aload 8
    //   923: aload 12
    //   925: iconst_1
    //   926: invokespecial 279	com/tencent/mobileqq/troop/api/impl/TroopInfoServiceImpl:updateRecentUser	(Lcom/tencent/mobileqq/app/proxy/RecentUserProxy;Lcom/tencent/mobileqq/data/troop/CommonlyUsedTroop;Z)V
    //   929: aload 6
    //   931: astore 5
    //   933: aload 6
    //   935: astore 4
    //   937: aload_0
    //   938: aload 12
    //   940: invokevirtual 191	com/tencent/mobileqq/troop/api/impl/TroopInfoServiceImpl:updateEntity	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   943: pop
    //   944: goto -396 -> 548
    //   947: aload 6
    //   949: astore 5
    //   951: aload 6
    //   953: astore 4
    //   955: aload 6
    //   957: invokevirtual 194	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   960: aload 6
    //   962: ifnull +54 -> 1016
    //   965: aload 6
    //   967: astore 4
    //   969: aload 4
    //   971: invokevirtual 197	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   974: return
    //   975: astore 4
    //   977: goto +40 -> 1017
    //   980: astore 6
    //   982: aload 4
    //   984: astore 5
    //   986: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   989: ifeq +19 -> 1008
    //   992: aload 4
    //   994: astore 5
    //   996: ldc 10
    //   998: iconst_4
    //   999: aload 6
    //   1001: iconst_0
    //   1002: anewarray 4	java/lang/Object
    //   1005: invokestatic 752	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   1008: aload 4
    //   1010: ifnull +6 -> 1016
    //   1013: goto -44 -> 969
    //   1016: return
    //   1017: aload 5
    //   1019: ifnull +8 -> 1027
    //   1022: aload 5
    //   1024: invokevirtual 197	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   1027: goto +6 -> 1033
    //   1030: aload 4
    //   1032: athrow
    //   1033: goto -3 -> 1030
    //   1036: iconst_0
    //   1037: istore_1
    //   1038: goto -150 -> 888
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1041	0	this	TroopInfoServiceImpl
    //   884	154	1	i	int
    //   185	117	2	l	long
    //   7	963	4	localObject1	Object
    //   975	56	4	localObject2	Object
    //   10	1013	5	localObject3	Object
    //   19	947	6	localEntityTransaction	EntityTransaction
    //   980	20	6	localThrowable	java.lang.Throwable
    //   4	778	7	localConcurrentHashMap	ConcurrentHashMap
    //   91	831	8	localObject4	Object
    //   129	747	9	localObject5	Object
    //   239	336	10	localObject6	Object
    //   584	276	11	str1	String
    //   615	324	12	localObject7	Object
    //   809	29	13	localIterator	Iterator
    //   847	31	14	str2	String
    // Exception table:
    //   from	to	target	type
    //   12	21	975	finally
    //   34	39	975	finally
    //   47	54	975	finally
    //   62	73	975	finally
    //   81	93	975	finally
    //   101	111	975	finally
    //   119	131	975	finally
    //   139	164	975	finally
    //   172	186	975	finally
    //   194	210	975	finally
    //   218	224	975	finally
    //   232	241	975	finally
    //   249	258	975	finally
    //   266	274	975	finally
    //   282	291	975	finally
    //   299	306	975	finally
    //   314	325	975	finally
    //   336	359	975	finally
    //   367	379	975	finally
    //   387	397	975	finally
    //   405	425	975	finally
    //   433	439	975	finally
    //   447	456	975	finally
    //   467	477	975	finally
    //   485	496	975	finally
    //   504	509	975	finally
    //   517	524	975	finally
    //   532	548	975	finally
    //   556	566	975	finally
    //   574	586	975	finally
    //   594	600	975	finally
    //   608	617	975	finally
    //   625	634	975	finally
    //   642	650	975	finally
    //   658	667	975	finally
    //   675	692	975	finally
    //   700	711	975	finally
    //   719	728	975	finally
    //   736	743	975	finally
    //   751	773	975	finally
    //   781	791	975	finally
    //   799	811	975	finally
    //   819	829	975	finally
    //   837	849	975	finally
    //   857	867	975	finally
    //   875	883	975	finally
    //   900	909	975	finally
    //   920	929	975	finally
    //   937	944	975	finally
    //   955	960	975	finally
    //   986	992	975	finally
    //   996	1008	975	finally
    //   12	21	980	java/lang/Throwable
    //   34	39	980	java/lang/Throwable
    //   47	54	980	java/lang/Throwable
    //   62	73	980	java/lang/Throwable
    //   81	93	980	java/lang/Throwable
    //   101	111	980	java/lang/Throwable
    //   119	131	980	java/lang/Throwable
    //   139	164	980	java/lang/Throwable
    //   172	186	980	java/lang/Throwable
    //   194	210	980	java/lang/Throwable
    //   218	224	980	java/lang/Throwable
    //   232	241	980	java/lang/Throwable
    //   249	258	980	java/lang/Throwable
    //   266	274	980	java/lang/Throwable
    //   282	291	980	java/lang/Throwable
    //   299	306	980	java/lang/Throwable
    //   314	325	980	java/lang/Throwable
    //   336	359	980	java/lang/Throwable
    //   367	379	980	java/lang/Throwable
    //   387	397	980	java/lang/Throwable
    //   405	425	980	java/lang/Throwable
    //   433	439	980	java/lang/Throwable
    //   447	456	980	java/lang/Throwable
    //   467	477	980	java/lang/Throwable
    //   485	496	980	java/lang/Throwable
    //   504	509	980	java/lang/Throwable
    //   517	524	980	java/lang/Throwable
    //   532	548	980	java/lang/Throwable
    //   556	566	980	java/lang/Throwable
    //   574	586	980	java/lang/Throwable
    //   594	600	980	java/lang/Throwable
    //   608	617	980	java/lang/Throwable
    //   625	634	980	java/lang/Throwable
    //   642	650	980	java/lang/Throwable
    //   658	667	980	java/lang/Throwable
    //   675	692	980	java/lang/Throwable
    //   700	711	980	java/lang/Throwable
    //   719	728	980	java/lang/Throwable
    //   736	743	980	java/lang/Throwable
    //   751	773	980	java/lang/Throwable
    //   781	791	980	java/lang/Throwable
    //   799	811	980	java/lang/Throwable
    //   819	829	980	java/lang/Throwable
    //   837	849	980	java/lang/Throwable
    //   857	867	980	java/lang/Throwable
    //   875	883	980	java/lang/Throwable
    //   900	909	980	java/lang/Throwable
    //   920	929	980	java/lang/Throwable
    //   937	944	980	java/lang/Throwable
    //   955	960	980	java/lang/Throwable
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("removeCommonlyUsedTroop, troopUin=");
        localStringBuilder.append(paramString);
        QLog.e("TroopInfoServiceImpl", 2, localStringBuilder.toString());
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
    if ((paramTroopInfo != null) && (!TextUtils.isEmpty(paramTroopInfo.troopuin)))
    {
      if ("0".equals(paramTroopInfo.troopuin)) {
        return;
      }
      if (this.troopListCache == null) {
        this.troopListCache = new ConcurrentHashMap();
      }
      TroopInfoSorter.a(paramTroopInfo);
      Object localObject = this.troopListCache;
      if (localObject != null) {
        ((ConcurrentHashMap)localObject).put(paramTroopInfo.troopuin, paramTroopInfo);
      }
      if ((!updateEntity(paramTroopInfo)) && (QLog.isColorLevel())) {
        QLog.d("TroopInfoServiceImpl", 2, "saveTroopInfo failed.");
      }
      localObject = ((IRecentUserProxyService)this.app.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
      RecentUser localRecentUser = ((RecentUserProxy)localObject).a(paramTroopInfo.troopuin, 1);
      localRecentUser.displayName = paramTroopInfo.getTroopDisplayName();
      if (localRecentUser.getStatus() == 1001) {
        ((RecentUserProxy)localObject).b(localRecentUser);
      }
      buildTroopUI();
    }
  }
  
  public void saveTroopInfoOnlyCacheAndDB(TroopInfo paramTroopInfo)
  {
    if ((paramTroopInfo != null) && (!TextUtils.isEmpty(paramTroopInfo.troopuin)))
    {
      if ("0".equals(paramTroopInfo.troopuin)) {
        return;
      }
      if (this.troopListCache == null) {
        this.troopListCache = new ConcurrentHashMap();
      }
      TroopInfoSorter.a(paramTroopInfo);
      ConcurrentHashMap localConcurrentHashMap = this.troopListCache;
      if (localConcurrentHashMap != null) {
        localConcurrentHashMap.put(paramTroopInfo.troopuin, paramTroopInfo);
      }
      if ((!updateEntity(paramTroopInfo)) && (QLog.isColorLevel())) {
        QLog.d("TroopInfoServiceImpl", 2, "saveTroopInfoOnlyCacheAndDB failed.");
      }
    }
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
    paramString1 = this.troopListCache;
    if ((paramString1 != null) && (!paramString1.containsKey(localTroopInfo1.troopuin))) {
      this.troopListCache.put(localTroopInfo1.troopuin, localTroopInfo1);
    }
    TroopInfoSorter.a(localTroopInfo1);
    buildTroopUI();
    return localTroopInfo1;
  }
  
  /* Error */
  public void saveTroops(ArrayList<TroopInfo> paramArrayList)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 47	com/tencent/mobileqq/troop/api/impl/TroopInfoServiceImpl:troopListCache	Ljava/util/concurrent/ConcurrentHashMap;
    //   4: astore 4
    //   6: iconst_0
    //   7: istore_3
    //   8: aload 4
    //   10: ifnonnull +29 -> 39
    //   13: aload_1
    //   14: ifnull +11 -> 25
    //   17: aload_1
    //   18: invokevirtual 93	java/util/ArrayList:size	()I
    //   21: istore_2
    //   22: goto +5 -> 27
    //   25: iconst_0
    //   26: istore_2
    //   27: aload_0
    //   28: new 69	java/util/concurrent/ConcurrentHashMap
    //   31: dup
    //   32: iload_2
    //   33: invokespecial 149	java/util/concurrent/ConcurrentHashMap:<init>	(I)V
    //   36: putfield 47	com/tencent/mobileqq/troop/api/impl/TroopInfoServiceImpl:troopListCache	Ljava/util/concurrent/ConcurrentHashMap;
    //   39: aload_1
    //   40: ifnonnull +4 -> 44
    //   43: return
    //   44: aload_1
    //   45: invokevirtual 631	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   48: astore 4
    //   50: aload 4
    //   52: invokeinterface 303 1 0
    //   57: ifeq +45 -> 102
    //   60: aload 4
    //   62: invokeinterface 307 1 0
    //   67: checkcast 148	com/tencent/mobileqq/data/troop/TroopInfo
    //   70: astore 5
    //   72: aload 5
    //   74: ifnull +18 -> 92
    //   77: aload_0
    //   78: getfield 255	com/tencent/mobileqq/troop/api/impl/TroopInfoServiceImpl:app	Lmqq/app/AppRuntime;
    //   81: aload 5
    //   83: getfield 170	com/tencent/mobileqq/data/troop/TroopInfo:troopuin	Ljava/lang/String;
    //   86: invokestatic 775	com/tencent/mobileqq/troop/api/config/TroopCommonConfig:a	(Lmqq/app/AppRuntime;Ljava/lang/String;)Z
    //   89: ifeq -39 -> 50
    //   92: aload 4
    //   94: invokeinterface 777 1 0
    //   99: goto -49 -> 50
    //   102: aload_0
    //   103: getfield 81	com/tencent/mobileqq/troop/api/impl/TroopInfoServiceImpl:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   106: invokevirtual 180	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   109: astore 4
    //   111: aload 4
    //   113: invokevirtual 185	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   116: iload_3
    //   117: istore_2
    //   118: iload_2
    //   119: aload_1
    //   120: invokevirtual 93	java/util/ArrayList:size	()I
    //   123: if_icmpge +160 -> 283
    //   126: aload_1
    //   127: iload_2
    //   128: invokevirtual 100	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   131: checkcast 148	com/tencent/mobileqq/data/troop/TroopInfo
    //   134: astore 5
    //   136: aload 5
    //   138: ifnonnull +6 -> 144
    //   141: goto +182 -> 323
    //   144: aload 5
    //   146: getfield 170	com/tencent/mobileqq/data/troop/TroopInfo:troopuin	Ljava/lang/String;
    //   149: ifnonnull +14 -> 163
    //   152: aload 5
    //   154: getfield 516	com/tencent/mobileqq/data/troop/TroopInfo:troopcode	Ljava/lang/String;
    //   157: ifnonnull +6 -> 163
    //   160: goto +163 -> 323
    //   163: aload 5
    //   165: getfield 516	com/tencent/mobileqq/data/troop/TroopInfo:troopcode	Ljava/lang/String;
    //   168: ifnull +15 -> 183
    //   171: aload 5
    //   173: getfield 516	com/tencent/mobileqq/data/troop/TroopInfo:troopcode	Ljava/lang/String;
    //   176: invokevirtual 157	java/lang/String:length	()I
    //   179: iconst_1
    //   180: if_icmpgt +78 -> 258
    //   183: aload 5
    //   185: getfield 170	com/tencent/mobileqq/data/troop/TroopInfo:troopuin	Ljava/lang/String;
    //   188: ifnull +70 -> 258
    //   191: aload_0
    //   192: getfield 47	com/tencent/mobileqq/troop/api/impl/TroopInfoServiceImpl:troopListCache	Ljava/util/concurrent/ConcurrentHashMap;
    //   195: aload 5
    //   197: getfield 170	com/tencent/mobileqq/data/troop/TroopInfo:troopuin	Ljava/lang/String;
    //   200: invokevirtual 253	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   203: checkcast 187	com/tencent/mobileqq/persistence/Entity
    //   206: astore 6
    //   208: aload 6
    //   210: ifnull +48 -> 258
    //   213: aload 6
    //   215: instanceof 148
    //   218: ifeq +40 -> 258
    //   221: aload 6
    //   223: checkcast 148	com/tencent/mobileqq/data/troop/TroopInfo
    //   226: astore 6
    //   228: aload 6
    //   230: getfield 516	com/tencent/mobileqq/data/troop/TroopInfo:troopcode	Ljava/lang/String;
    //   233: ifnull +25 -> 258
    //   236: aload 6
    //   238: getfield 516	com/tencent/mobileqq/data/troop/TroopInfo:troopcode	Ljava/lang/String;
    //   241: invokevirtual 157	java/lang/String:length	()I
    //   244: iconst_1
    //   245: if_icmple +13 -> 258
    //   248: aload 5
    //   250: aload 6
    //   252: getfield 516	com/tencent/mobileqq/data/troop/TroopInfo:troopcode	Ljava/lang/String;
    //   255: putfield 516	com/tencent/mobileqq/data/troop/TroopInfo:troopcode	Ljava/lang/String;
    //   258: aload_0
    //   259: getfield 47	com/tencent/mobileqq/troop/api/impl/TroopInfoServiceImpl:troopListCache	Ljava/util/concurrent/ConcurrentHashMap;
    //   262: aload 5
    //   264: getfield 170	com/tencent/mobileqq/data/troop/TroopInfo:troopuin	Ljava/lang/String;
    //   267: aload 5
    //   269: invokevirtual 132	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   272: pop
    //   273: aload_0
    //   274: aload 5
    //   276: invokevirtual 191	com/tencent/mobileqq/troop/api/impl/TroopInfoServiceImpl:updateEntity	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   279: pop
    //   280: goto +43 -> 323
    //   283: aload 4
    //   285: invokevirtual 194	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   288: goto +12 -> 300
    //   291: astore_1
    //   292: goto +18 -> 310
    //   295: astore_1
    //   296: aload_1
    //   297: invokevirtual 456	java/lang/Exception:printStackTrace	()V
    //   300: aload 4
    //   302: invokevirtual 197	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   305: aload_0
    //   306: invokevirtual 290	com/tencent/mobileqq/troop/api/impl/TroopInfoServiceImpl:buildTroopUI	()V
    //   309: return
    //   310: aload 4
    //   312: invokevirtual 197	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   315: goto +5 -> 320
    //   318: aload_1
    //   319: athrow
    //   320: goto -2 -> 318
    //   323: iload_2
    //   324: iconst_1
    //   325: iadd
    //   326: istore_2
    //   327: goto -209 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	330	0	this	TroopInfoServiceImpl
    //   0	330	1	paramArrayList	ArrayList<TroopInfo>
    //   21	306	2	i	int
    //   7	110	3	j	int
    //   4	307	4	localObject1	Object
    //   70	205	5	localTroopInfo	TroopInfo
    //   206	45	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   111	116	291	finally
    //   118	136	291	finally
    //   144	160	291	finally
    //   163	183	291	finally
    //   183	208	291	finally
    //   213	258	291	finally
    //   258	280	291	finally
    //   283	288	291	finally
    //   296	300	291	finally
    //   111	116	295	java/lang/Exception
    //   118	136	295	java/lang/Exception
    //   144	160	295	java/lang/Exception
    //   163	183	295	java/lang/Exception
    //   183	208	295	java/lang/Exception
    //   213	258	295	java/lang/Exception
    //   258	280	295	java/lang/Exception
    //   283	288	295	java/lang/Exception
  }
  
  public void saveTroops(ArrayList<TroopInfo> paramArrayList, long paramLong)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.size() == 0) {
        return;
      }
      saveTroops(paramArrayList);
      buildTroopUI();
    }
  }
  
  public void setInsertJoinTroopMsgTime(String paramString, long paramLong)
  {
    SharedPreferences localSharedPreferences = this.app.getPreferences();
    String str = this.app.getCurrentAccountUin();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("line_");
    localStringBuilder.append(str);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    if (paramLong < 0L)
    {
      localSharedPreferences.edit().remove(paramString);
      return;
    }
    localSharedPreferences.edit().putLong(paramString, paramLong).commit();
  }
  
  public void setTroopEliminated(List<String> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("setTroopEliminated list is: ");
      ((StringBuilder)localObject1).append(paramList.toString());
      QLog.i("troop_ext", 1, ((StringBuilder)localObject1).toString());
      localObject1 = null;
      try
      {
        localObject2 = this.em.getTransaction();
        localObject1 = localObject2;
        ((EntityTransaction)localObject2).begin();
        localObject1 = localObject2;
        paramList = paramList.iterator();
        for (;;)
        {
          localObject1 = localObject2;
          if (!paramList.hasNext()) {
            break;
          }
          localObject1 = localObject2;
          TroopInfo localTroopInfo = findTroopInfo((String)paramList.next());
          if (localTroopInfo != null)
          {
            localObject1 = localObject2;
            localTroopInfo.eliminated = 1;
            localObject1 = localObject2;
            this.em.update(localTroopInfo);
          }
        }
        localObject1 = localObject2;
        ((EntityTransaction)localObject2).commit();
        localObject1 = localObject2;
        ((EntityTransaction)localObject2).end();
        return;
      }
      catch (Exception paramList)
      {
        paramList.printStackTrace();
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("troop_ext ");
        ((StringBuilder)localObject2).append(paramList.getMessage());
        QLog.e("TroopInfoServiceImpl", 1, ((StringBuilder)localObject2).toString());
        if (localObject1 != null) {
          ((EntityTransaction)localObject1).end();
        }
      }
    }
  }
  
  public boolean updateEntity(Entity paramEntity)
  {
    boolean bool2 = this.em.isOpen();
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    if (paramEntity.getStatus() == 1000)
    {
      this.em.persistOrReplace(paramEntity);
      if (paramEntity.getStatus() == 1001) {
        bool1 = true;
      }
      return bool1;
    }
    if ((paramEntity.getStatus() != 1001) && (paramEntity.getStatus() != 1002)) {
      return false;
    }
    return this.em.update(paramEntity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.impl.TroopInfoServiceImpl
 * JD-Core Version:    0.7.0.1
 */