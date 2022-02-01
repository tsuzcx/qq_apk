package com.tencent.mobileqq.utils.abtest;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.QConReqExtraInfo;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mtt.abtestsdk.ABTestApi;
import com.tencent.mtt.abtestsdk.entity.ABTestConfig;
import com.tencent.mtt.abtestsdk.entity.ExpEntity;
import com.tencent.mtt.abtestsdk.listener.GetExperimentListener;
import com.tencent.mtt.abtestsdk.utils.ABTestLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.MobileQQ;

public final class ABTestController
  extends QCommonOnlineExpProviderImpl
{
  private static final ABTestController i = new ABTestController();
  ABTestController.LoadListener a;
  private final List<ExpEntityInfo> b = new CopyOnWriteArrayList();
  private final AtomicInteger c = new AtomicInteger(0);
  private final AtomicBoolean d = new AtomicBoolean(false);
  private final AtomicBoolean e = new AtomicBoolean(false);
  private final Object f = new Object();
  private String g;
  private Context h;
  
  public static ABTestController a()
  {
    return i;
  }
  
  @NonNull
  private ExpEntityInfo a(@NonNull String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return new ExpEntityInfo(paramString, "", paramInt);
    }
    ExpEntityInfo localExpEntityInfo2 = d(paramString);
    ExpEntityInfo localExpEntityInfo1 = localExpEntityInfo2;
    if (localExpEntityInfo2 == null)
    {
      localExpEntityInfo1 = new ExpEntityInfo(paramString, "", paramInt);
      a(localExpEntityInfo1);
    }
    if ((b()) && (ABTestUtil.a(localExpEntityInfo1)))
    {
      paramString = e();
      ABTestApi.getExpByName(localExpEntityInfo1.c(), paramString, 3000);
    }
    return localExpEntityInfo1;
  }
  
  private void a(@NonNull ExpEntityInfo paramExpEntityInfo)
  {
    if (paramExpEntityInfo != null)
    {
      if (!ABTestUtil.a(paramExpEntityInfo.c())) {
        return;
      }
      try
      {
        ExpEntityInfo localExpEntityInfo = d(paramExpEntityInfo.c());
        if (localExpEntityInfo == null) {
          this.b.add(paramExpEntityInfo);
        } else {
          localExpEntityInfo.a(paramExpEntityInfo);
        }
        return;
      }
      finally {}
    }
  }
  
  private void a(HashSet<String> paramHashSet)
  {
    if (paramHashSet != null)
    {
      if (paramHashSet.isEmpty()) {
        return;
      }
      ArrayList localArrayList = new ArrayList();
      paramHashSet = paramHashSet.iterator();
      while (paramHashSet.hasNext())
      {
        String str = (String)paramHashSet.next();
        int j = b(str);
        if (QConfigManager.b().c(j))
        {
          localArrayList.add(new QConReqExtraInfo(j, true));
        }
        else
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("id not support:");
          localStringBuilder.append(j);
          localStringBuilder.append(" exp:");
          localStringBuilder.append(str);
          ABTestUtil.a("ABTestController", localStringBuilder.toString());
        }
      }
      if (!localArrayList.isEmpty())
      {
        paramHashSet = new StringBuilder();
        paramHashSet.append("forceUpdateList:");
        paramHashSet.append(localArrayList.toString());
        ABTestUtil.a("ABTestController", paramHashSet.toString());
        QConfigManager.a(localArrayList, this.g);
      }
    }
  }
  
  private void a(List<ExpEntity> paramList)
  {
    Object localObject1 = String.format("%s_%s", new Object[] { "qqexp_content_record", this.g });
    Object localObject2 = MobileQQ.sMobileQQ.getSharedPreferences((String)localObject1, 4);
    localObject1 = ((SharedPreferences)localObject2).edit();
    HashSet localHashSet1 = new HashSet();
    HashSet localHashSet2 = new HashSet();
    paramList = paramList.iterator();
    Object localObject3;
    while (paramList.hasNext())
    {
      localObject3 = (ExpEntity)paramList.next();
      if ((localObject3 != null) && (ABTestUtil.a(((ExpEntity)localObject3).getExpName())))
      {
        ABTestUtil.a("ABTestController", ((ExpEntity)localObject3).toString());
        localHashSet2.add(((ExpEntity)localObject3).getExpName());
        Object localObject4 = d(((ExpEntity)localObject3).getExpName());
        if (localObject4 != null) {
          ((ExpEntityInfo)localObject4).a((ExpEntity)localObject3);
        }
        localObject4 = ((SharedPreferences)localObject2).getString(((ExpEntity)localObject3).getExpName(), "");
        StringBuilder localStringBuilder;
        if ((localObject4 != null) && (!TextUtils.isEmpty((CharSequence)localObject4)))
        {
          if (TextUtils.equals((CharSequence)localObject4, ((ExpEntity)localObject3).getAssignment()))
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("trace update:");
            localStringBuilder.append(String.format("exp:%s. %s->%s", new Object[] { ((ExpEntity)localObject3).getExpName(), localObject4, ((ExpEntity)localObject3).getAssignment() }));
            ABTestUtil.a("ABTestController", localStringBuilder.toString());
            localHashSet1.add(((ExpEntity)localObject3).getExpName());
          }
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("trace update:");
          localStringBuilder.append(String.format("exp:%s. %s->%s", new Object[] { ((ExpEntity)localObject3).getExpName(), localObject4, ((ExpEntity)localObject3).getAssignment() }));
          ABTestUtil.a("ABTestController", localStringBuilder.toString());
          localHashSet1.add(((ExpEntity)localObject3).getExpName());
        }
        ((SharedPreferences.Editor)localObject1).putString(((ExpEntity)localObject3).getExpName().trim(), ((ExpEntity)localObject3).getAssignment().trim());
      }
    }
    paramList = ((SharedPreferences)localObject2).getAll();
    if ((this.e.get()) && (paramList != null) && (!paramList.isEmpty()))
    {
      this.e.set(false);
      paramList = paramList.entrySet().iterator();
      while (paramList.hasNext())
      {
        localObject2 = (Map.Entry)paramList.next();
        if (!localHashSet2.contains(((Map.Entry)localObject2).getKey()))
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("tabResponseHandler remove&update:");
          ((StringBuilder)localObject3).append((String)((Map.Entry)localObject2).getKey());
          ABTestUtil.a("ABTestController", ((StringBuilder)localObject3).toString());
          localObject3 = d((String)((Map.Entry)localObject2).getKey());
          if (localObject3 != null) {
            ((ExpEntityInfo)localObject3).j();
          }
          localHashSet1.add(((Map.Entry)localObject2).getKey());
          ((SharedPreferences.Editor)localObject1).remove((String)((Map.Entry)localObject2).getKey());
        }
      }
    }
    paramList = new StringBuilder();
    paramList.append("exp update id set:");
    paramList.append(localHashSet1.toString());
    ABTestUtil.a("ABTestController", paramList.toString());
    ((SharedPreferences.Editor)localObject1).apply();
    a(localHashSet1);
    paramList = this.a;
    if (paramList != null) {
      paramList.a();
    }
  }
  
  private ExpEntityInfo d(@NonNull String paramString)
  {
    Iterator localIterator = this.b.iterator();
    label13:
    ExpEntityInfo localExpEntityInfo;
    for (Object localObject = null; localIterator.hasNext(); localObject = localExpEntityInfo)
    {
      localExpEntityInfo = (ExpEntityInfo)localIterator.next();
      if ((localExpEntityInfo == null) || (TextUtils.isEmpty(localExpEntityInfo.c())) || (!TextUtils.equals(localExpEntityInfo.c(), paramString))) {
        break label13;
      }
    }
    return localObject;
  }
  
  private void d()
  {
    if (this.c.get() == 2) {
      return;
    }
    if (this.c.get() == 1) {
      return;
    }
    if (MobileQQ.sProcessId == 1) {
      return;
    }
    this.c.set(1);
    ThreadManagerV2.excute(new ABTestController.2(this), 16, new ABTestController.3(this), false);
  }
  
  private GetExperimentListener e()
  {
    return new ABTestController.4(this);
  }
  
  private void f()
  {
    Object localObject1 = ABTestUtil.a();
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("registerExpConfigInfoList:");
      ((StringBuilder)localObject2).append(localObject1.toString());
      ABTestUtil.a("ABTestController", ((StringBuilder)localObject2).toString());
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          a(new ExpEntityInfo((String)localObject2, "", 0));
        }
      }
    }
  }
  
  @NonNull
  public ExpEntityInfo a(int paramInt)
  {
    String str = b(paramInt);
    d();
    return a(str, paramInt);
  }
  
  @NonNull
  public ExpEntityInfo a(@NonNull String paramString)
  {
    d();
    return a(paramString, 0);
  }
  
  public void a(Context paramContext, String paramString)
  {
    if ((paramContext != null) && (!TextUtils.isEmpty(paramString)))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("start initialize ABTestApi SDK. uinAccount:");
      localStringBuilder.append(paramString);
      ABTestUtil.b(localStringBuilder.toString());
      this.g = paramString;
      this.h = paramContext;
      a("qqexp_content_record", this.g);
      b(paramContext, paramString);
      if ((!this.b.isEmpty()) && (b()))
      {
        paramContext = e();
        this.e.set(true);
        ABTestApi.switchAccountId(paramString, paramContext);
      }
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("inited or params error: appContext:");
    localStringBuilder.append(paramContext);
    localStringBuilder.append(", uinAccount:");
    localStringBuilder.append(paramString);
    ABTestUtil.b(localStringBuilder.toString());
    this.c.set(0);
  }
  
  protected void a(String paramString1, String paramString2)
  {
    if (this.d.get())
    {
      paramString1 = new StringBuilder();
      paramString1.append("initExpListCache when isTabExpCached:");
      paramString1.append(this.d.get());
      ABTestUtil.a("ABTestController", paramString1.toString());
      return;
    }
    this.d.set(true);
    ConcurrentHashMap localConcurrentHashMap = ExpMgrListProcessor.a();
    if ((localConcurrentHashMap == null) || (localConcurrentHashMap.isEmpty())) {
      ExpMgrListProcessor.b();
    }
    paramString1 = String.format("%s_%s", new Object[] { paramString1, paramString2 });
    paramString1 = MobileQQ.sMobileQQ.getSharedPreferences(paramString1, 4).getAll();
    if ((paramString1 != null) && (!paramString1.isEmpty())) {
      paramString1 = paramString1.entrySet().iterator();
    }
    while (paramString1.hasNext())
    {
      paramString2 = (Map.Entry)paramString1.next();
      if ((!TextUtils.isEmpty((CharSequence)paramString2.getKey())) && ((paramString2.getValue() instanceof String)))
      {
        String str = (String)paramString2.getValue();
        int j = b((String)paramString2.getKey());
        a(new ExpEntityInfo((String)paramString2.getKey(), str, j));
        continue;
        ABTestUtil.a("ABTestController", "sp local data null -> from install boot");
      }
    }
    a(localConcurrentHashMap);
    f();
    if (this.b.isEmpty()) {
      ABTestUtil.b("[initSDK] entityInfoList isEmpty after register");
    }
  }
  
  @Deprecated
  public void a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("eventUserId", this.g);
    localHashMap.put("eventGrayId", paramString2);
    localHashMap.put("layerName", paramString1);
    localHashMap.put("eventType", String.valueOf(paramInt));
    localHashMap.put("eventName", paramString3);
    paramString1 = new StringBuilder();
    paramString1.append("report AbtestEvtExpose:");
    paramString1.append(localHashMap.toString());
    ABTestUtil.b(paramString1.toString());
    StatisticCollector.getInstance(this.h).collectPerformance(this.g, "AbtestEvtExpose", true, 0L, 0L, localHashMap, null);
  }
  
  public void a(ConcurrentHashMap<Integer, String> paramConcurrentHashMap)
  {
    if ((paramConcurrentHashMap != null) && (!paramConcurrentHashMap.isEmpty()))
    {
      paramConcurrentHashMap = paramConcurrentHashMap.entrySet().iterator();
      while (paramConcurrentHashMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramConcurrentHashMap.next();
        ExpEntityInfo localExpEntityInfo = d((String)localEntry.getValue());
        if (localExpEntityInfo != null) {
          localExpEntityInfo.a(((Integer)localEntry.getKey()).intValue());
        } else {
          a(new ExpEntityInfo((String)localEntry.getValue(), "", ((Integer)localEntry.getKey()).intValue()));
        }
      }
    }
  }
  
  public int b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    Object localObject = ExpMgrListProcessor.a();
    if (localObject != null)
    {
      if (((ConcurrentHashMap)localObject).isEmpty()) {
        return 0;
      }
      localObject = ((ConcurrentHashMap)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        if (TextUtils.equals(paramString, (CharSequence)localEntry.getValue())) {
          return ((Integer)localEntry.getKey()).intValue();
        }
      }
    }
    return 0;
  }
  
  public String b(int paramInt)
  {
    ConcurrentHashMap localConcurrentHashMap = ExpMgrListProcessor.a();
    if (localConcurrentHashMap != null)
    {
      if (localConcurrentHashMap.isEmpty()) {
        return "";
      }
      if (localConcurrentHashMap.containsKey(Integer.valueOf(paramInt))) {
        return (String)localConcurrentHashMap.get(Integer.valueOf(paramInt));
      }
    }
    return "";
  }
  
  protected void b(Context paramContext, String paramString)
  {
    if (this.c.get() == 2)
    {
      paramContext = new StringBuilder();
      paramContext.append("realInitTabSDK when tabSdkInitState:");
      paramContext.append(this.c.get());
      ABTestUtil.a("ABTestController", paramContext.toString());
      return;
    }
    ABTestApi.registerExpInitListener(new ABTestController.1(this, paramString));
    ABTestLog.setUseFuncTag(false);
    ABTestLog.setLogAble(false);
    ABTestConfig localABTestConfig = new ABTestConfig();
    localABTestConfig.setGuid(paramString);
    localABTestConfig.setAppId("1505");
    localABTestConfig.setCurEnv("RELEASE");
    localABTestConfig.setAppKey("0c9ebb2ded806d7ffda75cd0b95eb70c");
    ABTestApi.init(paramContext, localABTestConfig);
  }
  
  public boolean b()
  {
    return (this.d.get()) && (this.c.get() == 2);
  }
  
  public void c()
  {
    this.d.set(false);
    this.e.set(false);
    ConcurrentHashMap localConcurrentHashMap = ExpMgrListProcessor.a();
    if (localConcurrentHashMap != null) {
      localConcurrentHashMap.clear();
    }
    this.b.clear();
  }
  
  public void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      ABTestUtil.a("ABTestController", "[registerExpConfigInfo] current expName is empty.");
      return;
    }
    a(new ExpEntityInfo(paramString, "", 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.abtest.ABTestController
 * JD-Core Version:    0.7.0.1
 */