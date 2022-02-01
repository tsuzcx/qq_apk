package com.tencent.thumbplayer.tplayer.plugins.report;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.beacon.event.UserAction;
import com.tencent.beacon.event.open.BeaconConfig;
import com.tencent.beacon.event.open.BeaconEvent;
import com.tencent.beacon.event.open.BeaconEvent.Builder;
import com.tencent.beacon.event.open.BeaconReport;
import com.tencent.beacon.event.open.EventType;
import com.tencent.beacon.qimei.IAsyncQimeiListener;
import com.tencent.beacon.upload.InitHandleListener;
import com.tencent.beacon.upload.TunnelInfo;
import com.tencent.beacon.upload.UploadHandleListener;
import com.tencent.thumbplayer.utils.TPLogUtil;
import java.util.HashMap;
import java.util.Map;

public class BeaconAdapter
{
  private static String TAG = "BeaconAdapter";
  private static boolean beaconEnable = false;
  private static boolean is4XVersion = false;
  
  static
  {
    try
    {
      Class.forName("com.tencent.beacon.event.UserAction");
      if (sdkVersionBiggerThanThat(UserAction.getSDKVersion(), "3.1.2")) {
        beaconEnable = true;
      }
      if (sdkVersionBiggerThanThat(UserAction.getSDKVersion(), "4.1.0"))
      {
        is4XVersion = true;
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static void doUploadRecords()
  {
    if (!beaconEnable) {
      return;
    }
    UserAction.doUploadRecords();
  }
  
  public static void flushObjectsToDB(boolean paramBoolean)
  {
    if (!beaconEnable) {
      return;
    }
    UserAction.flushObjectsToDB(paramBoolean);
  }
  
  public static String getCloudParas(String paramString)
  {
    if (!beaconEnable) {
      return "";
    }
    return UserAction.getCloudParas(paramString);
  }
  
  public static String getQIMEI()
  {
    if (!beaconEnable) {
      return "";
    }
    return UserAction.getQIMEI();
  }
  
  public static void getQimei(IAsyncQimeiListener paramIAsyncQimeiListener)
  {
    if (!beaconEnable) {
      return;
    }
    if (!sdkVersionBiggerThanThat(UserAction.getSDKVersion(), "3.2.1")) {
      return;
    }
    UserAction.getQimei(paramIAsyncQimeiListener);
  }
  
  public static String getSDKVersion()
  {
    if (!beaconEnable) {
      return "";
    }
    return UserAction.getSDKVersion();
  }
  
  public static void initUserAction(Context paramContext, String paramString, BeaconConfig paramBeaconConfig)
  {
    if (!beaconEnable) {
      return;
    }
    if (is4XVersion)
    {
      BeaconReport.getInstance().start(paramContext, paramString, paramBeaconConfig);
      return;
    }
    UserAction.initUserAction(paramContext);
  }
  
  public static void initUserAction(Context paramContext, boolean paramBoolean, long paramLong)
  {
    if (!beaconEnable) {
      return;
    }
    UserAction.initUserAction(paramContext, paramBoolean, paramLong);
  }
  
  public static void initUserAction(Context paramContext, boolean paramBoolean, long paramLong, InitHandleListener paramInitHandleListener, UploadHandleListener paramUploadHandleListener)
  {
    if (!beaconEnable) {
      return;
    }
    UserAction.initUserAction(paramContext, paramBoolean, paramLong, paramInitHandleListener, paramUploadHandleListener);
  }
  
  public static boolean loginEvent(boolean paramBoolean, long paramLong, Map<String, String> paramMap)
  {
    if (!beaconEnable) {
      return false;
    }
    return UserAction.loginEvent(paramBoolean, paramLong, paramMap);
  }
  
  public static void onPageIn(String paramString)
  {
    if (!beaconEnable) {
      return;
    }
    UserAction.onPageIn(paramString);
  }
  
  public static void onPageOut(String paramString)
  {
    if (!beaconEnable) {
      return;
    }
    UserAction.onPageOut(paramString);
  }
  
  public static boolean onUserAction(String paramString, boolean paramBoolean1, long paramLong1, long paramLong2, Map<String, String> paramMap, boolean paramBoolean2)
  {
    if (!beaconEnable) {
      return false;
    }
    return UserAction.onUserAction(paramString, paramBoolean1, paramLong1, paramLong2, paramMap, paramBoolean2);
  }
  
  public static boolean onUserAction(String paramString, boolean paramBoolean1, long paramLong1, long paramLong2, Map<String, String> paramMap, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (!beaconEnable) {
      return false;
    }
    return UserAction.onUserAction(paramString, paramBoolean1, paramLong1, paramLong2, paramMap, paramBoolean2, paramBoolean3);
  }
  
  public static void onUserActionToTunnel(String paramString1, String paramString2, boolean paramBoolean1, long paramLong1, long paramLong2, Map<String, String> paramMap, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (!beaconEnable) {
      return;
    }
    if (is4XVersion)
    {
      BeaconEvent.Builder localBuilder = BeaconEvent.builder();
      if (!TextUtils.isEmpty(paramString1)) {
        localBuilder.withAppKey(paramString1);
      }
      paramString1 = paramMap;
      if (paramMap == null) {
        paramString1 = new HashMap();
      }
      localBuilder.withCode(paramString2);
      localBuilder.withIsSucceed(paramBoolean1);
      if (paramBoolean2) {
        localBuilder.withType(EventType.REALTIME);
      }
      localBuilder.withParams(paramString1);
      paramString1 = localBuilder.build();
      BeaconReport.getInstance().report(paramString1);
      return;
    }
    UserAction.onUserActionToTunnel(paramString1, paramString2, paramBoolean1, paramLong1, paramLong2, paramMap, paramBoolean2, paramBoolean3);
  }
  
  public static void registerTunnel(String paramString1, String paramString2, String paramString3)
  {
    if (!beaconEnable) {
      return;
    }
    if (is4XVersion)
    {
      TPLogUtil.w(TAG, "registerTunnel method is do nothing.");
      return;
    }
    UserAction.registerTunnel(new TunnelInfo(paramString1, paramString2, paramString3));
  }
  
  private static boolean sdkVersionBiggerThanThat(String paramString1, String paramString2)
  {
    return paramString1.compareTo(paramString2) >= 0;
  }
  
  public static void setAdditionalInfo(String paramString, Map<String, String> paramMap)
  {
    if (!beaconEnable) {
      return;
    }
    UserAction.setAdditionalInfo(paramString, paramMap);
  }
  
  public static void setAdditionalInfo(Map<String, String> paramMap)
  {
    if (!beaconEnable) {
      return;
    }
    UserAction.setAdditionalInfo(paramMap);
  }
  
  public static void setAppVersion(String paramString)
  {
    if (!beaconEnable) {
      return;
    }
    UserAction.setAppVersion(paramString);
  }
  
  public static void setChannelID(String paramString)
  {
    if (!beaconEnable) {
      return;
    }
    if (is4XVersion)
    {
      BeaconReport.getInstance().setChannelID(paramString);
      return;
    }
    UserAction.setChannelID(paramString);
  }
  
  public static void setLogAble(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!beaconEnable) {
      return;
    }
    if (is4XVersion)
    {
      BeaconReport.getInstance().setLogAble(paramBoolean1);
      return;
    }
    UserAction.setLogAble(paramBoolean1, paramBoolean2);
  }
  
  public static void setOmgId(String paramString)
  {
    if (!beaconEnable) {
      return;
    }
    if (!sdkVersionBiggerThanThat(UserAction.getSDKVersion(), "3.2.0")) {
      return;
    }
    UserAction.setOmgId(paramString);
  }
  
  public static void setQQ(String paramString)
  {
    if (!beaconEnable) {
      return;
    }
    UserAction.setQQ(paramString);
  }
  
  public static void setReportDomain(String paramString1, String paramString2)
  {
    if (!beaconEnable) {
      return;
    }
    if (is4XVersion)
    {
      TPLogUtil.w(TAG, "setReportDomain method is do nothing, please use initUserAction's param 'BeaconConfig'");
      return;
    }
    UserAction.setReportDomain(paramString1, paramString2);
  }
  
  public static void setUploadMode(boolean paramBoolean)
  {
    if (!beaconEnable) {
      return;
    }
    UserAction.setUploadMode(paramBoolean);
  }
  
  public static void setUserID(String paramString)
  {
    if (!beaconEnable) {
      return;
    }
    UserAction.setUserID(paramString);
  }
  
  public static void setUserID(String paramString1, String paramString2)
  {
    if (!beaconEnable) {
      return;
    }
    UserAction.setUserID(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.tplayer.plugins.report.BeaconAdapter
 * JD-Core Version:    0.7.0.1
 */