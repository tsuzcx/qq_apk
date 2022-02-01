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
import mqq.app.MobileQQ;

public final class ABTestController
{
  private static final ABTestController jdField_a_of_type_ComTencentMobileqqUtilsAbtestABTestController = new ABTestController();
  private Context jdField_a_of_type_AndroidContentContext;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString;
  private final List<ExpEntityInfo> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private final AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private final AtomicBoolean b = new AtomicBoolean(false);
  private final AtomicBoolean c = new AtomicBoolean(false);
  
  public static ABTestController a()
  {
    return jdField_a_of_type_ComTencentMobileqqUtilsAbtestABTestController;
  }
  
  @NonNull
  private ExpEntityInfo a(@NonNull String paramString, int paramInt)
  {
    if (!a()) {
      ThreadManagerV2.executeOnSubThread(new ABTestController.2(this));
    }
    if (TextUtils.isEmpty(paramString)) {
      return new ExpEntityInfo(paramString, "", paramInt);
    }
    ExpEntityInfo localExpEntityInfo2 = b(paramString);
    ExpEntityInfo localExpEntityInfo1 = localExpEntityInfo2;
    if (localExpEntityInfo2 == null)
    {
      localExpEntityInfo1 = new ExpEntityInfo(paramString, "", paramInt);
      a(localExpEntityInfo1);
    }
    if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (ABTestUtil.a(localExpEntityInfo1)))
    {
      paramString = a();
      ABTestApi.getExpByName(localExpEntityInfo1.getExpName(), paramString, 3000);
    }
    return localExpEntityInfo1;
  }
  
  private GetExperimentListener a()
  {
    return new ABTestController.3(this);
  }
  
  private void a(@NonNull ExpEntityInfo paramExpEntityInfo)
  {
    if (paramExpEntityInfo != null)
    {
      if (!ABTestUtil.a(paramExpEntityInfo.getExpName())) {
        return;
      }
      try
      {
        ExpEntityInfo localExpEntityInfo = b(paramExpEntityInfo.getExpName());
        if (localExpEntityInfo == null) {
          this.jdField_a_of_type_JavaUtilList.add(paramExpEntityInfo);
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
        int i = a(str);
        if (QConfigManager.a().a(i))
        {
          localArrayList.add(new QConReqExtraInfo(i, true));
        }
        else
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("id not support:");
          localStringBuilder.append(i);
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
        QConfigManager.a(localArrayList, this.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  private void a(List<ExpEntity> paramList)
  {
    Object localObject1 = String.format("%s_%s", new Object[] { "qqexp_content_record", this.jdField_a_of_type_JavaLangString });
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
        Object localObject4 = b(((ExpEntity)localObject3).getExpName());
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
            localStringBuilder.append(ABTestUtil.a((ExpEntity)localObject3, (String)localObject4));
            ABTestUtil.a("ABTestController", localStringBuilder.toString());
            localHashSet1.add(((ExpEntity)localObject3).getExpName());
          }
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("trace update:");
          localStringBuilder.append(ABTestUtil.a((ExpEntity)localObject3, (String)localObject4));
          ABTestUtil.a("ABTestController", localStringBuilder.toString());
          localHashSet1.add(((ExpEntity)localObject3).getExpName());
        }
        ((SharedPreferences.Editor)localObject1).putString(((ExpEntity)localObject3).getExpName().trim(), ((ExpEntity)localObject3).getAssignment().trim());
      }
    }
    paramList = ((SharedPreferences)localObject2).getAll();
    if ((this.c.get()) && (paramList != null) && (!paramList.isEmpty()))
    {
      this.c.set(false);
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
          localObject3 = b((String)((Map.Entry)localObject2).getKey());
          if (localObject3 != null) {
            ((ExpEntityInfo)localObject3).b();
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
  }
  
  private ExpEntityInfo b(@NonNull String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    label13:
    ExpEntityInfo localExpEntityInfo;
    for (Object localObject = null; localIterator.hasNext(); localObject = localExpEntityInfo)
    {
      localExpEntityInfo = (ExpEntityInfo)localIterator.next();
      if ((localExpEntityInfo == null) || (TextUtils.isEmpty(localExpEntityInfo.getExpName())) || (!TextUtils.equals(localExpEntityInfo.getExpName(), paramString))) {
        break label13;
      }
    }
    return localObject;
  }
  
  private void b()
  {
    a(new ExpEntityInfo("exp_qq_msg_marketface_gif_icon", "", 0));
    a(new ExpEntityInfo("exp_qq_msg_marketface_input_icon", "", 0));
    a(new ExpEntityInfo("exp_qq_message_reminder_dnd", "", 0));
    Object localObject = ABTestUtil.a();
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if (!TextUtils.isEmpty(str)) {
          a(new ExpEntityInfo(str, "", 0));
        }
      }
    }
  }
  
  public int a(String paramString)
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
  
  @NonNull
  public ExpEntityInfo a(int paramInt)
  {
    return a(a(paramInt), paramInt);
  }
  
  @NonNull
  public ExpEntityInfo a(@NonNull String paramString)
  {
    return a(paramString, 0);
  }
  
  public String a(int paramInt)
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
  
  public void a()
  {
    this.b.set(false);
    this.c.set(false);
    ConcurrentHashMap localConcurrentHashMap = ExpMgrListProcessor.a();
    if (localConcurrentHashMap != null) {
      localConcurrentHashMap.clear();
    }
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(Context paramContext, String paramString)
  {
    if ((paramContext != null) && (!TextUtils.isEmpty(paramString)))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("start initialize ABTestApi SDK. uinAccount:");
      localStringBuilder.append(paramString);
      ABTestUtil.a(localStringBuilder.toString());
      this.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_AndroidContentContext = paramContext;
      a("qqexp_content_record", this.jdField_a_of_type_JavaLangString);
      b(paramContext, paramString);
      if ((!this.jdField_a_of_type_JavaUtilList.isEmpty()) && (a()))
      {
        paramContext = a();
        this.c.set(true);
        ABTestApi.switchAccountId(paramString, paramContext);
      }
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("inited or params error: appContext:");
    localStringBuilder.append(paramContext);
    localStringBuilder.append(", uinAccount:");
    localStringBuilder.append(paramString);
    ABTestUtil.a(localStringBuilder.toString());
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      ABTestUtil.a("ABTestController", "[registerExpConfigInfo] current expName is empty.");
      return;
    }
    a(new ExpEntityInfo(paramString, "", 0));
  }
  
  protected void a(String paramString1, String paramString2)
  {
    if (this.b.get())
    {
      paramString1 = new StringBuilder();
      paramString1.append("initExpListCache when isTabExpCached:");
      paramString1.append(this.b.get());
      ABTestUtil.a("ABTestController", paramString1.toString());
      return;
    }
    this.b.set(true);
    ConcurrentHashMap localConcurrentHashMap = ExpMgrListProcessor.a();
    if ((localConcurrentHashMap == null) || (localConcurrentHashMap.isEmpty())) {
      ExpMgrListProcessor.a();
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
        int i = a((String)paramString2.getKey());
        a(new ExpEntityInfo((String)paramString2.getKey(), str, i));
        continue;
        ABTestUtil.a("ABTestController", "sp local data null -> from install boot");
      }
    }
    a(localConcurrentHashMap);
    b();
    if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {
      ABTestUtil.a("[initSDK] entityInfoList isEmpty after register");
    }
  }
  
  @Deprecated
  public void a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("eventUserId", this.jdField_a_of_type_JavaLangString);
    localHashMap.put("eventGrayId", paramString2);
    localHashMap.put("layerName", paramString1);
    localHashMap.put("eventType", String.valueOf(paramInt));
    localHashMap.put("eventName", paramString3);
    paramString1 = new StringBuilder();
    paramString1.append("report AbtestEvtExpose:");
    paramString1.append(localHashMap.toString());
    ABTestUtil.a(paramString1.toString());
    StatisticCollector.getInstance(this.jdField_a_of_type_AndroidContentContext).collectPerformance(this.jdField_a_of_type_JavaLangString, "AbtestEvtExpose", true, 0L, 0L, localHashMap, null);
  }
  
  public void a(ConcurrentHashMap<Integer, String> paramConcurrentHashMap)
  {
    if ((paramConcurrentHashMap != null) && (!paramConcurrentHashMap.isEmpty()))
    {
      paramConcurrentHashMap = paramConcurrentHashMap.entrySet().iterator();
      while (paramConcurrentHashMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramConcurrentHashMap.next();
        ExpEntityInfo localExpEntityInfo = b((String)localEntry.getValue());
        if (localExpEntityInfo != null) {
          localExpEntityInfo.a(((Integer)localEntry.getKey()).intValue());
        } else {
          a(new ExpEntityInfo((String)localEntry.getValue(), "", ((Integer)localEntry.getKey()).intValue()));
        }
      }
    }
  }
  
  public boolean a()
  {
    return (this.b.get()) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
  }
  
  protected void b(Context paramContext, String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      paramContext = new StringBuilder();
      paramContext.append("realInitTabSDK when isTabSdkInited:");
      paramContext.append(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.abtest.ABTestController
 * JD-Core Version:    0.7.0.1
 */