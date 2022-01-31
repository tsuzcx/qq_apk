package com.tencent.mobileqq.mini.util;

import NS_COMM.COMM.Entry;
import NS_COMM.COMM.StCommonExt;
import NS_MINI_AD.MiniAppAd.ContextInfo;
import NS_MINI_AD.MiniAppAd.DebugInfo;
import NS_MINI_AD.MiniAppAd.DeviceInfo;
import NS_MINI_AD.MiniAppAd.Location;
import NS_MINI_AD.MiniAppAd.PositionExt;
import NS_MINI_AD.MiniAppAd.PositionInfo;
import NS_MINI_AD.MiniAppAd.ShareInfo;
import NS_MINI_AD.MiniAppAd.StGetAdReq;
import NS_MINI_AD.MiniAppAd.UserInfo;
import NS_MINI_INTERFACE.INTERFACE.DeviceInfo;
import NS_MINI_INTERFACE.INTERFACE.Location;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import bbct;
import bdhv;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo.Location;
import yys;
import yyt;
import yyu;

public class AdUtils
{
  public static final String AD_GDT_COOKIE_PRE = "gdt_cookie";
  public static final int DEVICE_ORIENTATION_LANDSCAPE = 90;
  public static final int DEVICE_ORIENTATION_PORTRAIT = 0;
  public static final String MINI_BUSINESS_ID = "e8d69a";
  
  public static MiniAppAd.StGetAdReq createAdRequest(Context paramContext, long paramLong, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    MiniAppAd.UserInfo localUserInfo = new MiniAppAd.UserInfo();
    localUserInfo.qq.set(paramLong);
    MiniAppAd.PositionInfo localPositionInfo = new MiniAppAd.PositionInfo();
    Object localObject = new MiniAppAd.PositionExt();
    ((MiniAppAd.PositionExt)localObject).sub_position_id.set(paramString1, true);
    paramString1 = new MiniAppAd.ShareInfo();
    paramString1.share_rate.set(paramInt1);
    ((MiniAppAd.PositionExt)localObject).share_info.set(paramString1);
    ((MiniAppAd.PositionExt)localObject).deep_link_version.set(1, true);
    localPositionInfo.ad_count.set(1, true);
    localPositionInfo.pos_ext.set((MessageMicro)localObject, true);
    paramContext = getDeviceInfo(paramContext, paramInt3);
    paramString1 = new MiniAppAd.ContextInfo();
    localObject = new MiniAppAd.DebugInfo();
    MiniAppAd.StGetAdReq localStGetAdReq = new MiniAppAd.StGetAdReq();
    localStGetAdReq.user_info.set(localUserInfo);
    localStGetAdReq.position_info.add(localPositionInfo);
    localStGetAdReq.device_info.set(paramContext);
    localStGetAdReq.context_info.set(paramString1);
    localStGetAdReq.debug_info.set((MessageMicro)localObject);
    localStGetAdReq.appid.set(paramString2);
    localStGetAdReq.ad_type.set(paramInt2);
    localStGetAdReq.gdt_cookie.set(paramString3);
    localStGetAdReq.extInfo.mapInfo.add(newEntry("queryData", paramString4));
    localStGetAdReq.extInfo.mapInfo.add(newEntry("reportData", paramString5));
    localStGetAdReq.extInfo.mapInfo.add(newEntry("refer", paramString6));
    localStGetAdReq.extInfo.mapInfo.add(newEntry("via", paramString7));
    return localStGetAdReq;
  }
  
  public static MiniAppAd.DeviceInfo getDeviceInfo(Context paramContext, int paramInt)
  {
    Object localObject1 = new yyt();
    ((yyt)localObject1).a = "e8d69a";
    long l = System.currentTimeMillis();
    localObject1 = yys.a(paramContext, (yyt)localObject1);
    boolean bool;
    label75:
    MiniAppAd.DeviceInfo localDeviceInfo;
    Object localObject3;
    if (localObject1 != null)
    {
      localObject1 = ((yyu)localObject1).a;
      localObject2 = new StringBuilder().append("get deviceInfo cost：").append(System.currentTimeMillis() - l).append(", result = ");
      if (localObject1 == null) {
        break label693;
      }
      bool = true;
      QLog.i("AdUtils", 2, bool);
      localDeviceInfo = new MiniAppAd.DeviceInfo();
      if (localObject1 != null)
      {
        localDeviceInfo.muid.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).muid.get());
        localDeviceInfo.muid_type.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).muid_type.get());
        localDeviceInfo.conn.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).conn.get());
        localDeviceInfo.carrier_code.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).carrier_code.get());
        localDeviceInfo.os_ver.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).os_ver.get());
        localDeviceInfo.qq_ver.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).qq_ver.get());
        localDeviceInfo.os_type.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).os_type.get());
        localDeviceInfo.location.coordinates_type.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).location.coordinates_type.get());
        localDeviceInfo.location.latitude.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).location.latitude.get());
        localDeviceInfo.location.longitude.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).location.longitude.get());
        localDeviceInfo.manufacturer.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).manufacturer.get());
        localDeviceInfo.device_brand_and_model.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).device_brand_and_model.get());
        localDeviceInfo.qadid.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).qadid.get());
        localDeviceInfo.app_version_id.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).app_version_id.get());
        localDeviceInfo.device_orientation.set(paramInt);
        if (((qq_ad_get.QQAdGet.DeviceInfo)localObject1).taid_ticket.has()) {
          localDeviceInfo.taid_ticket.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).taid_ticket.get());
        }
        if (((qq_ad_get.QQAdGet.DeviceInfo)localObject1).aid_ticket.has()) {
          localDeviceInfo.aid_ticket.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).aid_ticket.get());
        }
        if (((qq_ad_get.QQAdGet.DeviceInfo)localObject1).client_ipv4.has()) {
          localDeviceInfo.client_ipv4.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).client_ipv4.get());
        }
        localObject3 = bbct.a();
        PBStringField localPBStringField = localDeviceInfo.android_imei;
        localObject2 = localObject3;
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          localObject2 = "";
        }
        localPBStringField.set((String)localObject2);
        localObject2 = bbct.f();
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localDeviceInfo.android_id.set((String)localObject2);
          localObject2 = bdhv.d((String)localObject2);
          localObject3 = localDeviceInfo.md5_android_id;
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            break label699;
          }
        }
      }
    }
    label693:
    label699:
    for (Object localObject2 = "";; localObject2 = ((String)localObject2).toLowerCase())
    {
      ((PBStringField)localObject3).set((String)localObject2);
      paramContext = bbct.d(paramContext);
      if (!TextUtils.isEmpty(paramContext))
      {
        localDeviceInfo.mac.set(paramContext);
        localObject2 = bdhv.d(paramContext.replace(":", "").toUpperCase()).toLowerCase();
        localObject3 = localDeviceInfo.md5_mac;
        paramContext = (Context)localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          paramContext = "";
        }
        ((PBStringField)localObject3).set(paramContext);
      }
      QLog.i("AdUtils", 1, "oaid = " + ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).oaid.get() + ", taid_ticket = " + ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).taid_ticket.get() + ", aid_ticket = " + ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).aid_ticket.get() + ", client_ipv4 = " + ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).client_ipv4.get());
      return localDeviceInfo;
      localObject1 = null;
      break;
      bool = false;
      break label75;
    }
  }
  
  public static INTERFACE.DeviceInfo getDeviceInfo(Context paramContext)
  {
    Object localObject1 = new yyt();
    ((yyt)localObject1).a = "e8d69a";
    localObject1 = yys.a(paramContext, (yyt)localObject1);
    INTERFACE.DeviceInfo localDeviceInfo;
    Object localObject3;
    if (localObject1 != null)
    {
      localObject1 = ((yyu)localObject1).a;
      localDeviceInfo = new INTERFACE.DeviceInfo();
      if (localObject1 != null)
      {
        localDeviceInfo.muid.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).muid.get());
        localDeviceInfo.muid_type.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).muid_type.get());
        localDeviceInfo.conn.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).conn.get());
        localDeviceInfo.carrier_code.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).carrier_code.get());
        localDeviceInfo.os_ver.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).os_ver.get());
        localDeviceInfo.qq_ver.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).qq_ver.get());
        localDeviceInfo.os_type.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).os_type.get());
        localDeviceInfo.location.coordinates_type.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).location.coordinates_type.get());
        localDeviceInfo.location.latitude.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).location.latitude.get());
        localDeviceInfo.location.longitude.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).location.longitude.get());
        localDeviceInfo.manufacturer.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).manufacturer.get());
        localDeviceInfo.device_brand_and_model.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).device_brand_and_model.get());
        localDeviceInfo.qadid.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).qadid.get());
        localDeviceInfo.app_version_id.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).app_version_id.get());
        localDeviceInfo.device_orientation.set(0);
        if (((qq_ad_get.QQAdGet.DeviceInfo)localObject1).taid_ticket.has()) {
          localDeviceInfo.taid_ticket.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).taid_ticket.get());
        }
        if (((qq_ad_get.QQAdGet.DeviceInfo)localObject1).aid_ticket.has()) {
          localDeviceInfo.aid_ticket.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).aid_ticket.get());
        }
        if (((qq_ad_get.QQAdGet.DeviceInfo)localObject1).client_ipv4.has()) {
          localDeviceInfo.client_ipv4.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).client_ipv4.get());
        }
        localObject3 = bbct.a();
        PBStringField localPBStringField = localDeviceInfo.android_imei;
        localObject2 = localObject3;
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          localObject2 = "";
        }
        localPBStringField.set((String)localObject2);
        localObject2 = bbct.f();
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localDeviceInfo.android_id.set((String)localObject2);
          localObject2 = bdhv.d((String)localObject2);
          localObject3 = localDeviceInfo.md5_android_id;
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            break label584;
          }
        }
      }
    }
    label584:
    for (Object localObject2 = "";; localObject2 = ((String)localObject2).toLowerCase())
    {
      ((PBStringField)localObject3).set((String)localObject2);
      paramContext = bbct.d(paramContext);
      if (!TextUtils.isEmpty(paramContext))
      {
        localDeviceInfo.mac.set(paramContext);
        localObject2 = bdhv.d(paramContext.replace(":", "").toUpperCase()).toLowerCase();
        localObject3 = localDeviceInfo.md5_mac;
        paramContext = (Context)localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          paramContext = "";
        }
        ((PBStringField)localObject3).set(paramContext);
      }
      QLog.d("AdUtils", 1, "oaid = " + ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).oaid.get() + ", taid_ticket = " + ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).taid_ticket.get() + ", aid_ticket = " + ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).aid_ticket.get() + ", client_ipv4 = " + ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).client_ipv4.get());
      return localDeviceInfo;
      localObject1 = null;
      break;
    }
  }
  
  private static String getGdtCookieSpKey(int paramInt)
  {
    return "gdt_cookie_" + BaseApplicationImpl.getApplication().getRuntime().getAccount() + "_" + paramInt;
  }
  
  public static String getSpAdGdtCookie(int paramInt)
  {
    String str = getGdtCookieSpKey(paramInt);
    return StorageUtil.getPreference().getString(str, "");
  }
  
  public static COMM.Entry newEntry(String paramString1, String paramString2)
  {
    COMM.Entry localEntry = new COMM.Entry();
    if (paramString1 != null) {
      localEntry.key.set(paramString1);
    }
    if (paramString2 != null) {
      localEntry.value.set(paramString2);
    }
    return localEntry;
  }
  
  public static void putSpAdGdtCookie(int paramInt, String paramString)
  {
    String str = getGdtCookieSpKey(paramInt);
    StorageUtil.getPreference().edit().putString(str, paramString).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.util.AdUtils
 * JD-Core Version:    0.7.0.1
 */