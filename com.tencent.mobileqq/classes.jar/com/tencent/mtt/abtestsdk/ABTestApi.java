package com.tencent.mtt.abtestsdk;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mtt.abtestsdk.entity.ABTestConfig;
import com.tencent.mtt.abtestsdk.entity.ConfigValue;
import com.tencent.mtt.abtestsdk.entity.ExpEntity;
import com.tencent.mtt.abtestsdk.entity.FeatureEntity;
import com.tencent.mtt.abtestsdk.listener.ConfigValueChangeListener;
import com.tencent.mtt.abtestsdk.listener.ExpInitListener;
import com.tencent.mtt.abtestsdk.listener.FeatureInitListener;
import com.tencent.mtt.abtestsdk.listener.FeatureUpdateListener;
import com.tencent.mtt.abtestsdk.listener.GetExperimentListener;
import com.tencent.mtt.abtestsdk.listener.GetFeatureListener;
import com.tencent.mtt.abtestsdk.manager.ClientManager;
import com.tencent.mtt.abtestsdk.utils.ABTestLog;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;

public class ABTestApi
{
  public static final String EXP_DEFAULT_ASSIGNMENT = "default";
  
  public static List<String> getAllExpIds()
  {
    return ClientManager.getInstance().getAllExpIds();
  }
  
  public static void getAllExperiments(GetExperimentListener paramGetExperimentListener, int paramInt)
  {
    if (paramGetExperimentListener != null)
    {
      ClientManager.getInstance().getAllExperiments(paramGetExperimentListener, paramInt);
      return;
    }
    ABTestLog.error("the listener is not null", new Object[0]);
    throw new NullPointerException("the listener is not null");
  }
  
  public static boolean getConfigBoolean(String paramString, boolean paramBoolean)
  {
    return ClientManager.getInstance().getConfigValue(paramString, String.valueOf(paramBoolean)).asBoolean();
  }
  
  public static byte[] getConfigByteArray(String paramString, byte[] paramArrayOfByte)
  {
    paramArrayOfByte = String.valueOf(paramArrayOfByte);
    return ClientManager.getInstance().getConfigValue(paramString, paramArrayOfByte).asByteArray();
  }
  
  public static double getConfigDouble(String paramString, double paramDouble)
  {
    return ClientManager.getInstance().getConfigValue(paramString, String.valueOf(paramDouble)).asDouble();
  }
  
  public static int getConfigInt(String paramString, int paramInt)
  {
    return ClientManager.getInstance().getConfigValue(paramString, String.valueOf(paramInt)).asInt();
  }
  
  public static long getConfigLong(String paramString, long paramLong)
  {
    return ClientManager.getInstance().getConfigValue(paramString, String.valueOf(paramLong)).asLong();
  }
  
  public static String getConfigString(String paramString1, String paramString2)
  {
    return ClientManager.getInstance().getConfigValue(paramString1, paramString2).asString();
  }
  
  public static ExpEntity getExpById(String paramString)
  {
    ExpEntity localExpEntity = new ExpEntity("");
    if (TextUtils.isEmpty(paramString)) {
      return localExpEntity;
    }
    return ClientManager.getInstance().getExpById(paramString);
  }
  
  public static ExpEntity getExpByIdAndReport(String paramString)
  {
    paramString = getExpById(paramString);
    if (!TextUtils.equals("-1", paramString.getGrayId())) {
      reportExpExpose(paramString);
    }
    return paramString;
  }
  
  public static ExpEntity getExpByLayerCode(String paramString)
  {
    ExpEntity localExpEntity = new ExpEntity("");
    if (TextUtils.isEmpty(paramString)) {
      return localExpEntity;
    }
    return ClientManager.getInstance().getExpByLayerCode(paramString);
  }
  
  public static ExpEntity getExpByLayerCodeAndReport(String paramString)
  {
    paramString = getExpByLayerCode(paramString);
    if (!TextUtils.equals("default", paramString.getLayerCode())) {
      reportExpExpose(paramString);
    }
    return paramString;
  }
  
  public static void getExpByName(@NonNull String paramString, @NonNull GetExperimentListener paramGetExperimentListener, int paramInt)
  {
    if ((paramGetExperimentListener != null) && (!TextUtils.isEmpty(paramString)))
    {
      ClientManager.getInstance().getExpByName(paramString, paramGetExperimentListener, paramInt, false);
      return;
    }
    paramGetExperimentListener = new StringBuilder();
    paramGetExperimentListener.append("isExpose: false,  expName:");
    paramGetExperimentListener.append(paramString);
    paramGetExperimentListener.append("  the listener is not null or expName must be not empty");
    ABTestLog.error(paramGetExperimentListener.toString(), new Object[0]);
    throw new NullPointerException("the listener is not null or expName must be not empty");
  }
  
  public static void getExpByNameWithExpose(String paramString, GetExperimentListener paramGetExperimentListener, int paramInt)
  {
    if ((paramGetExperimentListener != null) && (!TextUtils.isEmpty(paramString)))
    {
      ClientManager.getInstance().getExpByName(paramString, paramGetExperimentListener, paramInt, true);
      return;
    }
    paramGetExperimentListener = new StringBuilder();
    paramGetExperimentListener.append("isExpose: true,  expName:");
    paramGetExperimentListener.append(paramString);
    paramGetExperimentListener.append("  the listener is not null or expName must be not empty");
    ABTestLog.error(paramGetExperimentListener.toString(), new Object[0]);
    throw new NullPointerException("the listener is not null or expName must be not empty");
  }
  
  public static void getFeatureByKey(String paramString, GetFeatureListener paramGetFeatureListener, int paramInt)
  {
    ClientManager.getInstance().getFeatureByKey(paramString, paramGetFeatureListener, paramInt);
  }
  
  public static void init(Context paramContext, ABTestConfig paramABTestConfig)
  {
    if ((paramContext == null) || (paramABTestConfig != null)) {}
    try
    {
      ClientManager.getInstance().init(new WeakReference(paramContext), paramABTestConfig);
      return;
    }
    catch (Exception paramContext)
    {
      paramABTestConfig = new StringBuilder();
      paramABTestConfig.append("[SDKInit] ");
      paramABTestConfig.append(paramContext.getMessage());
      ABTestLog.error(paramABTestConfig.toString(), new Object[0]);
    }
    throw new NullPointerException("config is not null!");
    throw new Exception("[SDKInit] the context can't be null, please check the context!");
  }
  
  public static void registerExpInitListener(ExpInitListener paramExpInitListener)
  {
    ClientManager.getInstance().registerExpInitListener(paramExpInitListener);
  }
  
  public static void registerFeatureInitListener(FeatureInitListener paramFeatureInitListener)
  {
    ClientManager.getInstance().registerFeatureInitListener(paramFeatureInitListener);
  }
  
  public static void registerFeatureUpdateListener(FeatureUpdateListener paramFeatureUpdateListener)
  {
    ClientManager.getInstance().registerFeatureUpdateListener(paramFeatureUpdateListener);
  }
  
  public static void registerValueChangeListener(String paramString, ConfigValueChangeListener paramConfigValueChangeListener)
  {
    ClientManager.getInstance().registerValueChangeListener(paramString, paramConfigValueChangeListener);
  }
  
  public static void reportExpExpose(ExpEntity paramExpEntity)
  {
    ClientManager.getInstance().reportExpExpose(paramExpEntity, "1");
  }
  
  public static void switchAccountId(String paramString, GetExperimentListener paramGetExperimentListener)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramGetExperimentListener != null))
    {
      ClientManager.getInstance().switchAccountId(paramString, paramGetExperimentListener);
      return;
    }
    ABTestLog.error("accountId is empty or listener is null", new Object[0]);
  }
  
  public static void switchFeatureUserID(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      ABTestLog.error("switch guid is empty, please check guid value", new Object[0]);
      return;
    }
    ClientManager.getInstance().switchFeatureUserID(paramString);
  }
  
  public static ExpEntity syncGetExpByName(@NonNull String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return ClientManager.getInstance().syncGetExpByName(paramString, false);
    }
    ABTestLog.error("expose：false  expName must be not empty", new Object[0]);
    throw new NullPointerException("expName must be not empty");
  }
  
  public static ExpEntity syncGetExpByNameWithExpose(@NonNull String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return ClientManager.getInstance().syncGetExpByName(paramString, true);
    }
    ABTestLog.error("expose：true  expName must be not empty", new Object[0]);
    throw new NullPointerException("expName must be not empty");
  }
  
  public static FeatureEntity syncGetFeatureByKey(String paramString)
  {
    return ClientManager.getInstance().syncGetFeatureByKey(paramString);
  }
  
  public static Map<String, FeatureEntity> syncGetFeatures()
  {
    return ClientManager.getInstance().syncGetFeatures();
  }
  
  public static void unregisterExpInitListener(ExpInitListener paramExpInitListener)
  {
    ClientManager.getInstance().unregisterExpInitListener(paramExpInitListener);
  }
  
  public static void unregisterFeatureInitListener(FeatureInitListener paramFeatureInitListener)
  {
    ClientManager.getInstance().unregisterFeatureInitListener(paramFeatureInitListener);
  }
  
  public static void unregisterFeatureUpdateListener(FeatureUpdateListener paramFeatureUpdateListener)
  {
    ClientManager.getInstance().unregisterFeatureUpdateListener(paramFeatureUpdateListener);
  }
  
  public static void unregisterValueChangeListener(String paramString)
  {
    ClientManager.getInstance().unregisterValueChangeListener(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.abtestsdk.ABTestApi
 * JD-Core Version:    0.7.0.1
 */