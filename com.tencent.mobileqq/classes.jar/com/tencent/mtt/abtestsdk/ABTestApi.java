package com.tencent.mtt.abtestsdk;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mtt.abtestsdk.ABTest.ABTestManager;
import com.tencent.mtt.abtestsdk.entity.ABTestConfig;
import com.tencent.mtt.abtestsdk.entity.RomaExpEntity;
import com.tencent.mtt.abtestsdk.listener.GetExperimentListener;
import com.tencent.mtt.abtestsdk.utils.ABTestLog;
import com.tencent.mtt.abtestsdk.utils.ABTestUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class ABTestApi
{
  public static final String EXP_DEFAULT_ASSIGNMENT = "default";
  private static final String TAG = "ABTestApi";
  private static final boolean isDebug = false;
  
  private static void _getExpByName(@NonNull String paramString, @NonNull GetExperimentListener paramGetExperimentListener, int paramInt, boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    if (paramBoolean) {}
    for (String str = "getExpByNameWithExpose"; (paramGetExperimentListener == null) || (TextUtils.isEmpty(paramString)); str = "getExpByName")
    {
      ABTestLog.error("isExpose:" + paramBoolean + " expName:" + paramString + "  the listener is not null or expName must be not empty", new Object[0]);
      throw new NullPointerException("the listener is not null or expName must be not empty");
    }
    RomaExpEntity localRomaExpEntity = ABTestManager.getInstance().getCacheExpByName(paramString);
    boolean bool = localRomaExpEntity.isDefaultRomaExp();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localRomaExpEntity);
    if (!bool)
    {
      ABTestLog.debug("expose：" + paramBoolean + " get data successfully from cache", new Object[0]);
      paramGetExperimentListener.getExperimentSucceed(localArrayList);
      if (paramBoolean) {
        reportExpExpose(localRomaExpEntity);
      }
      long l2 = System.currentTimeMillis();
      ABTestManager.getInstance().reportBeaconApiEvent(str, true, l2 - l1);
      return;
    }
    paramGetExperimentListener = new ABTestApi.2(paramString, paramBoolean, localArrayList, l1, str, paramGetExperimentListener);
    ABTestManager.getInstance().doGetSourceExpByExpName(paramString, paramGetExperimentListener, paramInt);
  }
  
  private static RomaExpEntity _syncGetExpByName(@NonNull String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString))
    {
      ABTestLog.error("expose：" + paramBoolean + "  expName must be not empty", new Object[0]);
      throw new NullPointerException("expName must be not empty");
    }
    paramString = ABTestManager.getInstance().getCacheExpByName(paramString);
    if (!paramString.isDefaultRomaExp())
    {
      ABTestLog.debug("expose：" + paramBoolean + " get data successfully", new Object[0]);
      if (paramBoolean) {
        reportExpExpose(paramString);
      }
    }
    return paramString;
  }
  
  public static List<String> getAllExpIds()
  {
    List localList = ABTestManager.getInstance().getAllRomaExpDataFromCache();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < localList.size())
    {
      localArrayList.add(((RomaExpEntity)localList.get(i)).getGrayId());
      i += 1;
    }
    return localArrayList;
  }
  
  public static void getAllExperiments(GetExperimentListener paramGetExperimentListener, int paramInt)
  {
    if (paramGetExperimentListener == null)
    {
      ABTestLog.error("the listener is not null", new Object[0]);
      throw new NullPointerException("the listener is not null");
    }
    List localList = ABTestManager.getInstance().getAllRomaExpDataFromCache();
    if (!localList.isEmpty())
    {
      ABTestLog.debug("get all the data successfully from cache", new Object[0]);
      paramGetExperimentListener.getExperimentSucceed(localList);
      return;
    }
    paramGetExperimentListener = new ABTestApi.3(localList, paramGetExperimentListener);
    ABTestManager.getInstance().doGetSourceExperiments(paramGetExperimentListener, paramInt);
  }
  
  public static RomaExpEntity getExpById(String paramString)
  {
    RomaExpEntity localRomaExpEntity1 = new RomaExpEntity("");
    Object localObject;
    if (TextUtils.isEmpty(paramString))
    {
      localObject = localRomaExpEntity1;
      return localObject;
    }
    List localList = ABTestManager.getInstance().getAllRomaExpDataFromCache();
    int i = 0;
    for (;;)
    {
      if (i >= localList.size()) {
        return localRomaExpEntity1;
      }
      RomaExpEntity localRomaExpEntity2 = (RomaExpEntity)localList.get(i);
      localObject = localRomaExpEntity2;
      if (TextUtils.equals(paramString, localRomaExpEntity2.getGrayId())) {
        break;
      }
      i += 1;
    }
    return localRomaExpEntity1;
  }
  
  public static RomaExpEntity getExpByIdAndReport(String paramString)
  {
    paramString = getExpById(paramString);
    if (!TextUtils.equals("-1", paramString.getGrayId())) {
      reportExpExpose(paramString);
    }
    return paramString;
  }
  
  public static RomaExpEntity getExpByLayerCode(String paramString)
  {
    RomaExpEntity localRomaExpEntity1 = new RomaExpEntity("");
    Object localObject;
    if (TextUtils.isEmpty(paramString))
    {
      localObject = localRomaExpEntity1;
      return localObject;
    }
    List localList = ABTestManager.getInstance().getAllRomaExpDataFromCache();
    int i = 0;
    for (;;)
    {
      if (i >= localList.size()) {
        return localRomaExpEntity1;
      }
      RomaExpEntity localRomaExpEntity2 = (RomaExpEntity)localList.get(i);
      localObject = localRomaExpEntity2;
      if (TextUtils.equals(paramString, localRomaExpEntity2.getLayerCode())) {
        break;
      }
      i += 1;
    }
    return localRomaExpEntity1;
  }
  
  public static RomaExpEntity getExpByLayerCodeAndReport(String paramString)
  {
    paramString = getExpByLayerCode(paramString);
    if (!TextUtils.equals("default", paramString.getLayerCode())) {
      reportExpExpose(paramString);
    }
    return paramString;
  }
  
  public static void getExpByName(@NonNull String paramString, @NonNull GetExperimentListener paramGetExperimentListener, int paramInt)
  {
    _getExpByName(paramString, paramGetExperimentListener, paramInt, false);
  }
  
  public static void getExpByNameWithExpose(String paramString, GetExperimentListener paramGetExperimentListener, int paramInt)
  {
    _getExpByName(paramString, paramGetExperimentListener, paramInt, true);
  }
  
  public static void init(Context paramContext, ABTestConfig paramABTestConfig)
  {
    if (paramContext == null) {
      try
      {
        throw new Exception("[SDKInit] the context can't be null, please check the context!");
      }
      catch (Exception paramContext)
      {
        ABTestLog.error("[SDKInit] " + paramContext.getMessage(), new Object[0]);
      }
    }
    ABTestConfig localABTestConfig;
    do
    {
      return;
      localABTestConfig = paramABTestConfig;
      if (paramABTestConfig == null) {
        localABTestConfig = new ABTestConfig();
      }
      ABTestManager.getInstance();
      if (ABTestManager.IS_SDK_HAS_INIT)
      {
        ABTestLog.error("[SDKInit] Please do not repeat the initialization SDK", new Object[0]);
        return;
      }
      ABTestManager.getInstance().init(new WeakReference(paramContext), localABTestConfig);
    } while (!ABTestUtil.isAppKeyValid(paramContext, localABTestConfig));
    ABTestManager.getInstance();
    ABTestManager.IS_SDK_HAS_INIT = true;
  }
  
  public static void reportExpExpose(RomaExpEntity paramRomaExpEntity)
  {
    long l1 = System.currentTimeMillis();
    String str1 = paramRomaExpEntity.getExpName();
    String str2 = paramRomaExpEntity.getAssignment();
    paramRomaExpEntity = paramRomaExpEntity.getGrayId();
    if ((!TextUtils.isEmpty(str1)) && ("default".equals(str2)))
    {
      ABTestLog.stepReport("assignment is default and give up reporting", new Object[0]);
      return;
    }
    boolean bool = ABTestManager.getInstance().reportBeaconExpExpose(paramRomaExpEntity, str1);
    ABTestLog.debug("report beacon status: " + bool, new Object[0]);
    if (bool)
    {
      long l2 = System.currentTimeMillis();
      bool = ABTestManager.getInstance().reportBeaconApiEvent("reportExpExpose", true, l2 - l1);
      ABTestLog.debug("reportApiEvent result: " + bool, new Object[0]);
      return;
    }
    ABTestManager.getInstance().reportExpAttaExpose(paramRomaExpEntity);
    l1 = System.currentTimeMillis();
    ABTestManager.getInstance().reportBeaconApiEvent("reportExpExpose", false, l1);
  }
  
  public static void switchAccountId(String paramString, GetExperimentListener paramGetExperimentListener)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramGetExperimentListener == null)) {
      return;
    }
    ABTestManager localABTestManager = ABTestManager.getInstance();
    localABTestManager.getABTestConfig().setGuid(paramString);
    localABTestManager.doGetSourceExpByExpName(null, new ABTestApi.1(new ArrayList(), paramGetExperimentListener), 0);
  }
  
  public static RomaExpEntity syncGetExpByName(@NonNull String paramString)
  {
    return _syncGetExpByName(paramString, false);
  }
  
  public static RomaExpEntity syncGetExpByNameWithExpose(@NonNull String paramString)
  {
    return _syncGetExpByName(paramString, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.abtestsdk.ABTestApi
 * JD-Core Version:    0.7.0.1
 */