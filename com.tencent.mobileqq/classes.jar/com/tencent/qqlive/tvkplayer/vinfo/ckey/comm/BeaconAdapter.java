package com.tencent.qqlive.tvkplayer.vinfo.ckey.comm;

import android.content.Context;
import com.tencent.beacon.event.UserAction;
import com.tencent.beacon.upload.InitHandleListener;
import com.tencent.beacon.upload.TunnelInfo;
import com.tencent.beacon.upload.UploadHandleListener;
import java.util.Map;

public class BeaconAdapter
{
  private static boolean beaconEnable = false;
  
  public static void doUploadRecords()
  {
    if (!beaconEnable) {
      return;
    }
    UserAction.doUploadRecords();
  }
  
  public static void enablePagePath(boolean paramBoolean)
  {
    if (!beaconEnable) {
      return;
    }
    UserAction.enablePagePath(paramBoolean);
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
  
  public static String getSDKVersion()
  {
    if (!beaconEnable) {
      return "";
    }
    return UserAction.getSDKVersion();
  }
  
  public static void initUserAction(Context paramContext)
  {
    if (!beaconEnable) {
      return;
    }
    UserAction.initUserAction(paramContext);
  }
  
  public static void initUserAction(Context paramContext, boolean paramBoolean)
  {
    if (!beaconEnable) {
      return;
    }
    UserAction.initUserAction(paramContext, paramBoolean);
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
  
  public static boolean isBeaconEnable()
  {
    return beaconEnable;
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
  
  public static void onUserActionToTunnel(String paramString1, String paramString2, Map<String, String> paramMap, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!beaconEnable) {
      return;
    }
    UserAction.onUserActionToTunnel(paramString1, paramString2, paramMap, paramBoolean1, paramBoolean2);
  }
  
  public static void onUserActionToTunnel(String paramString1, String paramString2, boolean paramBoolean1, long paramLong1, long paramLong2, Map<String, String> paramMap, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (!beaconEnable) {
      return;
    }
    UserAction.onUserActionToTunnel(paramString1, paramString2, paramBoolean1, paramLong1, paramLong2, paramMap, paramBoolean2, paramBoolean3);
  }
  
  public static void registerTunnel(String paramString1, String paramString2, String paramString3)
  {
    if (!beaconEnable) {
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
  
  public static void setAppKey(String paramString)
  {
    if (!beaconEnable) {
      return;
    }
    UserAction.setAppKey(paramString);
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
    UserAction.setChannelID(paramString);
  }
  
  public static void setLogAble(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!beaconEnable) {
      return;
    }
    UserAction.setLogAble(paramBoolean1, paramBoolean2);
  }
  
  public static void setOmgId(String paramString)
  {
    if (!beaconEnable) {}
    while (!sdkVersionBiggerThanThat(UserAction.getSDKVersion(), "3.2.0")) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.ckey.comm.BeaconAdapter
 * JD-Core Version:    0.7.0.1
 */