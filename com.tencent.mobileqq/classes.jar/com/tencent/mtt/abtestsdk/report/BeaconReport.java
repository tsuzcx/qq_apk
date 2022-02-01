package com.tencent.mtt.abtestsdk.report;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.beacon.event.UserAction;
import com.tencent.beacon.upload.TunnelInfo;
import com.tencent.mtt.abtestsdk.ABTest.ABTestManager;
import com.tencent.mtt.abtestsdk.utils.ABTestLog;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class BeaconReport
{
  public static final String APP_KEY = "JS0B558T33E4YJ";
  private static final String TAG = "BeaconReport";
  public static boolean isBeaconEnable = false;
  public static boolean isSupportMultiChannel = false;
  private static String sdkVersion;
  
  static
  {
    try
    {
      Class.forName("com.tencent.beacon.event.UserAction");
      isBeaconEnable = true;
      sdkVersion = null;
      Object localObject1 = ABTestManager.getInstance().getContext();
      try
      {
        sdkVersion = UserAction.getSDKVersion();
        if (sdkVersionBiggerThanThat(sdkVersion, "3.1.2")) {
          isSupportMultiChannel = true;
        }
        ABTestLog.debug("static initializer -> QIMEI:" + getQIMEI() + "  SDKVersion:" + sdkVersion, new Object[0]);
        registerTunnel("JS0B558T33E4YJ", "1.1.0.9", "10000000");
        return;
      }
      catch (Exception localException2)
      {
        for (;;)
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
      }
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
    if ((!isBeaconEnable) || (!isSupportMultiChannel)) {
      return false;
    }
    return UserAction.onUserActionToTunnel("JS0B558T33E4YJ", paramString, paramBoolean1, paramLong1, paramLong2, paramMap, paramBoolean2, paramBoolean3);
  }
  
  public static void registerTunnel(String paramString1, String paramString2, String paramString3)
  {
    if ((!isBeaconEnable) || (!isSupportMultiChannel)) {
      return;
    }
    UserAction.registerTunnel(new TunnelInfo(paramString1, paramString2, paramString3));
  }
  
  public static boolean reportExpEvent(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    boolean bool = false;
    ABTestLog.debug("reportExpEvent: isBeaconEnable:" + isBeaconEnable + " isSupportMultiChannel:" + isSupportMultiChannel, new Object[0]);
    HashMap localHashMap;
    if (isBeaconEnable)
    {
      localHashMap = new HashMap();
      localHashMap.put("A70", paramString4);
      localHashMap.put("A71", paramString5);
      localHashMap.put("A148", paramString2);
      if (!TextUtils.isEmpty(paramString3)) {
        break label136;
      }
      localHashMap.put("A149", "null");
    }
    while (isSupportMultiChannel)
    {
      bool = onUserActionToTunnel(paramString1, true, -1L, -1L, localHashMap, true, true);
      return bool;
      label136:
      localHashMap.put("A149", paramString3);
    }
    return onUserAction(paramString1, true, -1L, -1L, localHashMap, true, true);
  }
  
  private static boolean sdkVersionBiggerThanThat(String paramString1, String paramString2)
  {
    return paramString1.compareTo(paramString2) >= 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.abtestsdk.report.BeaconReport
 * JD-Core Version:    0.7.0.1
 */