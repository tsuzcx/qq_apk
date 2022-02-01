package com.tencent.mtt.abtestsdk.report;

import android.content.Context;
import com.tencent.beacon.event.UserAction;
import com.tencent.beacon.upload.TunnelInfo;
import com.tencent.mtt.abtestsdk.entity.BeaconExpEntity;
import com.tencent.mtt.abtestsdk.manager.ClientManager;
import com.tencent.mtt.abtestsdk.utils.ABTestLog;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class BeaconReport
{
  public static final String APP_KEY = "JS0B558T33E4YJ";
  private static final String TAG = "BeaconReport";
  private static boolean isBeaconEnable = false;
  private static boolean isSupportMultiChannel = false;
  private static String sdkVersion;
  
  static
  {
    try
    {
      Class.forName("com.tencent.beacon.event.UserAction");
      isBeaconEnable = true;
      sdkVersion = null;
      Object localObject1 = ClientManager.getInstance().getContext();
      try
      {
        sdkVersion = UserAction.getSDKVersion();
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        try
        {
          String str = localException2.getMessage();
          str = str.substring(str.indexOf("com"), str.indexOf("("));
          Object localObject2 = str.substring(0, str.lastIndexOf('.'));
          str = str.substring(str.lastIndexOf('.') + 1);
          localObject2 = Class.forName((String)localObject2);
          Constructor localConstructor = ((Class)localObject2).getConstructor(new Class[] { Context.class });
          localConstructor.setAccessible(true);
          localObject1 = localConstructor.newInstance(new Object[] { localObject1 });
          sdkVersion = (String)((Class)localObject2).getMethod(str, new Class[0]).invoke(localObject1, new Object[0]);
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
        }
      }
      if (sdkVersionBiggerThanThat(sdkVersion, "3.1.2")) {
        isSupportMultiChannel = true;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("static initializer -> QIMEI:");
      localStringBuilder.append(getQIMEI());
      localStringBuilder.append("  SDKVersion:");
      localStringBuilder.append(sdkVersion);
      ABTestLog.stepReport(localStringBuilder.toString(), new Object[0]);
      registerTunnel("JS0B558T33E4YJ", "3.0.14", "10000000");
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      ABTestLog.error(localClassNotFoundException.getMessage(), new Object[0]);
    }
  }
  
  public static String getQIMEI()
  {
    if (!isBeaconEnable) {
      return "";
    }
    return UserAction.getQIMEI();
  }
  
  public static boolean onUserAction(String paramString, boolean paramBoolean1, long paramLong1, long paramLong2, Map<String, String> paramMap, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (!isBeaconEnable) {
      return false;
    }
    return UserAction.onUserAction(paramString, paramBoolean1, paramLong1, paramLong2, paramMap, paramBoolean2, paramBoolean3);
  }
  
  private static boolean onUserActionToTunnel(String paramString, boolean paramBoolean1, long paramLong1, long paramLong2, Map<String, String> paramMap, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((isBeaconEnable) && (isSupportMultiChannel)) {
      return UserAction.onUserActionToTunnel("JS0B558T33E4YJ", paramString, paramBoolean1, paramLong1, paramLong2, paramMap, paramBoolean2, paramBoolean3);
    }
    return false;
  }
  
  public static void registerTunnel(String paramString1, String paramString2, String paramString3)
  {
    if (isBeaconEnable)
    {
      if (!isSupportMultiChannel) {
        return;
      }
      UserAction.registerTunnel(new TunnelInfo(paramString1, paramString2, paramString3));
    }
  }
  
  public static boolean reportApiEvent(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    ABTestLog.stepReport(String.format("apiName: %s, successFlag: %s, consumedTime: %s", new Object[] { paramString4, paramString5, paramString6 }), new Object[0]);
    if (isBeaconEnable)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("A70", paramString2);
      localHashMap.put("A71", paramString3);
      localHashMap.put("api_name", paramString4);
      localHashMap.put("success_flag", paramString5);
      localHashMap.put("consumed_time", paramString6);
      if (isSupportMultiChannel) {
        return onUserActionToTunnel(paramString1, true, -1L, -1L, localHashMap, true, true);
      }
      return onUserAction(paramString1, true, -1L, -1L, localHashMap, true, true);
    }
    return false;
  }
  
  public static boolean reportExpEvent(String paramString, BeaconExpEntity paramBeaconExpEntity)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("isBeaconEnable:");
    ((StringBuilder)localObject).append(isBeaconEnable);
    ((StringBuilder)localObject).append(" isSupportMultiChannel:");
    ((StringBuilder)localObject).append(isSupportMultiChannel);
    ABTestLog.stepReport(((StringBuilder)localObject).toString(), new Object[0]);
    if (isBeaconEnable)
    {
      localObject = new HashMap();
      ((Map)localObject).put("A70", paramBeaconExpEntity.getUserId());
      ((Map)localObject).put("A71", paramBeaconExpEntity.getAppId());
      ((Map)localObject).put("A148", paramBeaconExpEntity.getGrayId());
      ((Map)localObject).put("A149", paramBeaconExpEntity.getExpName());
      ((Map)localObject).put("reportFlag", paramBeaconExpEntity.getReportFlag());
      if (isSupportMultiChannel) {
        return onUserActionToTunnel(paramString, true, -1L, -1L, (Map)localObject, true, true);
      }
      return onUserAction(paramString, true, -1L, -1L, (Map)localObject, true, true);
    }
    return false;
  }
  
  private static boolean sdkVersionBiggerThanThat(String paramString1, String paramString2)
  {
    return paramString1.compareTo(paramString2) >= 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.abtestsdk.report.BeaconReport
 * JD-Core Version:    0.7.0.1
 */