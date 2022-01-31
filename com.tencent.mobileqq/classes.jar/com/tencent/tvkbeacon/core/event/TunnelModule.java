package com.tencent.tvkbeacon.core.event;

import android.content.Context;
import com.tencent.tvkbeacon.core.b.h;
import com.tencent.tvkbeacon.core.c.i;
import com.tencent.tvkbeacon.core.info.e;
import com.tencent.tvkbeacon.core.strategy.StrategyQueryModule;
import com.tencent.tvkbeacon.upload.TunnelInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TunnelModule
  extends com.tencent.tvkbeacon.core.b
{
  private static volatile TunnelModule INSTANCE = null;
  private static List<com.tencent.tvkbeacon.event.a<Map<String, String>>> cacheAdditionInfo = Collections.synchronizedList(new ArrayList(5));
  private static List<c> cacheEvents;
  private static List<TunnelInfo> cacheTunnel = Collections.synchronizedList(new ArrayList(5));
  private static List<com.tencent.tvkbeacon.event.a<String>> cacheUserId = Collections.synchronizedList(new ArrayList(5));
  public static TunnelModule.b netConsumeUtil;
  private d appDefaultEventTunnel;
  private Context context;
  protected Runnable doUploadTask = new TunnelModule.4(this);
  public boolean isEnable;
  private Map<String, d> tunnelMap;
  
  static
  {
    cacheEvents = Collections.synchronizedList(new ArrayList(5));
  }
  
  public TunnelModule(Context paramContext)
  {
    super(paramContext);
    this.context = paramContext;
    this.appDefaultEventTunnel = new d(paramContext, com.tencent.tvkbeacon.core.info.b.a(paramContext).b());
    this.tunnelMap = new HashMap();
    dealCacheTunnel();
    dealCacheAdditionalInfo();
    dealCacheUserId();
  }
  
  private void addTunnel(TunnelInfo paramTunnelInfo)
  {
    for (;;)
    {
      try
      {
        if (paramTunnelInfo.appKey.equals(this.appDefaultEventTunnel.f()))
        {
          com.tencent.tvkbeacon.core.c.c.d("[event] can not register app default appkey: %s", new Object[] { paramTunnelInfo.appKey });
          return;
        }
        if ((d)this.tunnelMap.get(paramTunnelInfo.appKey) != null)
        {
          com.tencent.tvkbeacon.core.c.c.d("[event] registerTunnel failed. EventTunnel already exists :%s", new Object[] { paramTunnelInfo.appKey });
          continue;
        }
        locald = createTunnel(this.context, paramTunnelInfo);
      }
      finally {}
      d locald;
      this.tunnelMap.put(paramTunnelInfo.appKey, locald);
    }
  }
  
  private void allTunnel(TunnelModule.a parama)
  {
    if (parama == null) {}
    for (;;)
    {
      return;
      if (this.appDefaultEventTunnel != null) {
        parama.a(this.appDefaultEventTunnel);
      }
      Iterator localIterator = this.tunnelMap.values().iterator();
      while (localIterator.hasNext()) {
        parama.a((d)localIterator.next());
      }
    }
  }
  
  private d createTunnel(Context paramContext, TunnelInfo paramTunnelInfo)
  {
    paramTunnelInfo.channel = com.tencent.tvkbeacon.core.c.b.a(paramTunnelInfo.channel);
    d locald = new d(paramContext, paramTunnelInfo.appKey);
    locald.a(true);
    e.b(paramContext).a(paramTunnelInfo.appKey, paramTunnelInfo);
    return locald;
  }
  
  private void dealCacheAdditionalInfo()
  {
    Iterator localIterator = cacheAdditionInfo.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.tvkbeacon.event.a locala = (com.tencent.tvkbeacon.event.a)localIterator.next();
      setAdditionalInfoInstance(locala.a, (Map)locala.b);
    }
    cacheAdditionInfo.clear();
  }
  
  private void dealCacheTunnel()
  {
    Iterator localIterator = cacheTunnel.iterator();
    while (localIterator.hasNext())
    {
      TunnelInfo localTunnelInfo = (TunnelInfo)localIterator.next();
      d locald = createTunnel(this.context, localTunnelInfo);
      this.tunnelMap.put(localTunnelInfo.appKey, locald);
    }
    cacheTunnel.clear();
  }
  
  private void dealCacheUserId()
  {
    Iterator localIterator = cacheUserId.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.tvkbeacon.event.a locala = (com.tencent.tvkbeacon.event.a)localIterator.next();
      setUserIdInstance(locala.a, (String)locala.b);
    }
    cacheUserId.clear();
  }
  
  public static void doUploadAllEventsData()
  {
    TunnelModule localTunnelModule = getInstance();
    if ((localTunnelModule != null) && (isModuleAble())) {
      localTunnelModule.allTunnel(new TunnelModule.6());
    }
  }
  
  public static void doUploadRecentCommonData(boolean paramBoolean)
  {
    TunnelModule localTunnelModule = getInstance();
    if ((localTunnelModule == null) || (!isModuleAble())) {
      return;
    }
    localTunnelModule.allTunnel(new TunnelModule.5(paramBoolean));
  }
  
  public static void flushObjectsToDB(boolean paramBoolean)
  {
    TunnelModule localTunnelModule = getInstance();
    if (localTunnelModule != null) {
      localTunnelModule.allTunnel(new TunnelModule.7(paramBoolean));
    }
  }
  
  public static Map<String, String> getAdditionalInfo(String paramString)
  {
    Object localObject = getInstance();
    if (localObject == null)
    {
      com.tencent.tvkbeacon.core.c.c.d("getAdditionalInfo failed, sdk is not ready", new Object[0]);
      return null;
    }
    localObject = ((TunnelModule)localObject).getTunnelByAppKey(paramString);
    if (localObject == null)
    {
      com.tencent.tvkbeacon.core.c.c.d("getAdditionalInfo failed, tunnel of %s not found", new Object[] { paramString });
      return null;
    }
    return ((d)localObject).g();
  }
  
  public static TunnelModule getInstance()
  {
    return INSTANCE;
  }
  
  public static TunnelModule getInstance(Context paramContext)
  {
    if (INSTANCE == null) {}
    try
    {
      if (INSTANCE == null) {
        INSTANCE = new TunnelModule(paramContext);
      }
      return INSTANCE;
    }
    finally {}
  }
  
  private d getTunnelByAppKey(String paramString)
  {
    if ((i.a(paramString)) || (paramString.equals(this.appDefaultEventTunnel.f()))) {
      return this.appDefaultEventTunnel;
    }
    return (d)this.tunnelMap.get(paramString);
  }
  
  public static String getUserId(String paramString)
  {
    Object localObject = getInstance();
    if (localObject == null)
    {
      com.tencent.tvkbeacon.core.c.c.d("getUserId failed, sdk is not ready", new Object[0]);
      return null;
    }
    localObject = ((TunnelModule)localObject).getTunnelByAppKey(paramString);
    if (localObject == null)
    {
      com.tencent.tvkbeacon.core.c.c.d("getUserId failed, tunnel of %s not found", new Object[] { paramString });
      return null;
    }
    return ((d)localObject).h();
  }
  
  public static boolean isModuleAble()
  {
    Object localObject = getInstance();
    if (localObject == null)
    {
      com.tencent.tvkbeacon.core.c.c.d("[module] this module not ready!", new Object[0]);
      return false;
    }
    boolean bool2 = ((TunnelModule)localObject).isEnable;
    boolean bool1 = bool2;
    if (bool2) {
      bool1 = StrategyQueryModule.getInstance(((TunnelModule)localObject).context).isAtLeastAComQueryEnd();
    }
    if (bool1)
    {
      localObject = EventStrategyBean.getInstance();
      if ((localObject != null) && (netConsumeUtil != null) && (netConsumeUtil.a() >= ((EventStrategyBean)localObject).getDailyConsumeLimit()))
      {
        com.tencent.tvkbeacon.core.c.c.c("[strategy] reach daily consume limited! %d ", new Object[] { Integer.valueOf(((EventStrategyBean)localObject).getDailyConsumeLimit()) });
        return false;
      }
    }
    return bool1;
  }
  
  public static boolean onUserAction(String paramString1, String paramString2, boolean paramBoolean1, long paramLong1, long paramLong2, Map<String, String> paramMap, boolean paramBoolean2)
  {
    return onUserAction(paramString1, paramString2, paramBoolean1, paramLong1, paramLong2, paramMap, paramBoolean2, false);
  }
  
  public static boolean onUserAction(String paramString1, String paramString2, boolean paramBoolean1, long paramLong1, long paramLong2, Map<String, String> paramMap, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject = StrategyQueryModule.getInstance();
    if ((localObject == null) || (!((StrategyQueryModule)localObject).isAtLeastAComQueryEnd()))
    {
      com.tencent.tvkbeacon.core.c.c.a("[event] [%s] add to cache events list.", new Object[] { paramString2 });
      if (cacheEvents != null) {
        cacheEvents.add(new c(paramString1, paramString2, paramBoolean1, paramLong1, paramLong2, paramMap, paramBoolean2));
      }
      return true;
    }
    if (!isModuleAble())
    {
      com.tencent.tvkbeacon.core.c.c.d("[event] UserEventModule is disable (false).", new Object[0]);
      return false;
    }
    localObject = getInstance();
    if (localObject != null)
    {
      localObject = ((TunnelModule)localObject).getTunnelByAppKey(paramString1);
      if (localObject != null) {
        return ((d)localObject).a(paramString2, paramBoolean1, paramLong1, paramLong2, paramMap, paramBoolean2, paramBoolean3);
      }
      com.tencent.tvkbeacon.core.c.c.d("onUserAction failed, tunnel of %s not found", new Object[] { paramString1 });
    }
    return false;
  }
  
  public static void registerTunnel(TunnelInfo paramTunnelInfo)
  {
    if (i.a(paramTunnelInfo.appKey))
    {
      com.tencent.tvkbeacon.core.c.c.d("[event] registerTunnel failed. appKey is empty", new Object[0]);
      return;
    }
    TunnelModule localTunnelModule = getInstance();
    if (localTunnelModule == null)
    {
      cacheTunnel.add(paramTunnelInfo);
      return;
    }
    localTunnelModule.addTunnel(paramTunnelInfo);
  }
  
  public static void setAdditionalInfo(String paramString, Map<String, String> paramMap)
  {
    TunnelModule localTunnelModule = getInstance();
    if (localTunnelModule == null)
    {
      cacheAdditionInfo.add(new com.tencent.tvkbeacon.event.a(paramString, paramMap));
      return;
    }
    localTunnelModule.setAdditionalInfoInstance(paramString, paramMap);
  }
  
  private void setAdditionalInfoInstance(String paramString, Map<String, String> paramMap)
  {
    d locald = getTunnelByAppKey(paramString);
    if (locald == null)
    {
      com.tencent.tvkbeacon.core.c.c.d("setAdditionalInfo failed, tunnel of %s not found", new Object[] { paramString });
      return;
    }
    locald.a(paramMap);
  }
  
  public static void setNetConsumeProtocol(TunnelModule.b paramb)
  {
    netConsumeUtil = paramb;
  }
  
  public static void setUserId(String paramString1, String paramString2)
  {
    TunnelModule localTunnelModule = getInstance();
    if (localTunnelModule == null)
    {
      cacheUserId.add(new com.tencent.tvkbeacon.event.a(paramString1, paramString2));
      return;
    }
    String str1 = paramString2;
    if (i.a(paramString2)) {
      str1 = "10000";
    }
    String str2 = str1.replace('|', '_').trim();
    if (com.tencent.tvkbeacon.core.c.b.b(str2))
    {
      if (str2.length() < 5) {
        com.tencent.tvkbeacon.core.c.c.c("[core] userID length should < 5!", new Object[0]);
      }
      paramString2 = str2;
      if (str2.length() <= 128) {}
    }
    for (paramString2 = str2.substring(0, 128);; paramString2 = "10000")
    {
      localTunnelModule.setUserIdInstance(paramString1, paramString2);
      return;
      com.tencent.tvkbeacon.core.c.c.c("[core] userID should be ASCII code in 32-126! userID:".concat(String.valueOf(str1)), new Object[0]);
    }
  }
  
  private void setUserIdInstance(String paramString1, String paramString2)
  {
    d locald = getTunnelByAppKey(paramString1);
    if (locald == null)
    {
      com.tencent.tvkbeacon.core.c.c.d("setUserId failed, tunnel of %s not found", new Object[] { paramString1 });
      return;
    }
    locald.b(paramString2);
  }
  
  public void dealCacheEvent()
  {
    try
    {
      if ((cacheEvents != null) && (cacheEvents.size() > 0))
      {
        Iterator localIterator = cacheEvents.iterator();
        while (localIterator.hasNext())
        {
          c localc = (c)localIterator.next();
          onUserAction(localc.g, localc.a, localc.b, localc.c, localc.d, localc.e, localc.f);
        }
        cacheEvents.clear();
      }
    }
    finally {}
  }
  
  public void onAppFirstRun()
  {
    Context localContext = this.mContext;
    String str = this.appDefaultEventTunnel.f();
    com.tencent.tvkbeacon.core.c.c.b("[db] start", new Object[0]);
    com.tencent.tvkbeacon.core.c.c.e("[event] ua first clean :%d", new Object[] { Integer.valueOf(com.tencent.tvkbeacon.core.a.a.b.a(localContext, str, new int[] { 1, 2, 3, 4 })) });
    com.tencent.tvkbeacon.core.c.c.e("[event] ua remove strategy :%d", new Object[] { Integer.valueOf(com.tencent.tvkbeacon.core.strategy.c.b(this.mContext)) });
  }
  
  public void onModuleStrategyUpdated(int paramInt, Map<String, String> paramMap)
  {
    super.onModuleStrategyUpdated(paramInt, paramMap);
    if ((paramInt == 1) && (paramMap != null) && (paramMap.size() > 0) && (EventStrategyBean.getInstance() != null)) {
      EventStrategyBean.getInstance().updateConfig(paramMap);
    }
  }
  
  public void onSDKInit(Context paramContext)
  {
    super.onSDKInit(paramContext);
    setModuleUserEnable(true);
    com.tencent.tvkbeacon.core.a.d.a().a(paramContext, new TunnelModule.3(this));
  }
  
  public void onStrategyQueryFinished()
  {
    super.onStrategyQueryFinished();
    allTunnel(new TunnelModule.1(this));
    dealCacheEvent();
  }
  
  public void onStrategyUpdated(com.tencent.tvkbeacon.core.strategy.b paramb)
  {
    super.onStrategyUpdated(paramb);
    if (paramb != null)
    {
      paramb = paramb.f();
      if (paramb != null)
      {
        boolean bool = paramb.a();
        com.tencent.tvkbeacon.core.c.c.f("[strategy] setEnable: %b", new Object[] { Boolean.valueOf(bool) });
        setEnable(bool);
      }
    }
  }
  
  public void setAppKey(String paramString)
  {
    if (this.appDefaultEventTunnel != null) {
      this.appDefaultEventTunnel.a(paramString);
    }
  }
  
  public void setEnable(boolean paramBoolean)
  {
    try
    {
      this.isEnable = paramBoolean;
      allTunnel(new TunnelModule.2(this, paramBoolean));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setModuleUserEnable(boolean paramBoolean)
  {
    Object localObject = StrategyQueryModule.getInstance(this.mContext);
    if (localObject != null)
    {
      localObject = ((StrategyQueryModule)localObject).getStrategy().f();
      if ((localObject != null) && (((com.tencent.tvkbeacon.core.strategy.a)localObject).a() != paramBoolean))
      {
        ((com.tencent.tvkbeacon.core.strategy.a)localObject).a(paramBoolean);
        setEnable(paramBoolean);
      }
    }
  }
  
  public void setUploadMode(boolean paramBoolean)
  {
    if ((h.a(this.mContext) != null) && (paramBoolean != h.a(this.mContext).b()))
    {
      if (paramBoolean) {
        h.a(this.mContext).b(true);
      }
    }
    else {
      return;
    }
    h.a(this.mContext).b(false);
  }
  
  public void updateSchedule()
  {
    allTunnel(new TunnelModule.8(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.core.event.TunnelModule
 * JD-Core Version:    0.7.0.1
 */