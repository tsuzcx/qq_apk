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
import NS_MINI_AD.MiniAppAd.SpecifiedAdsItem;
import NS_MINI_AD.MiniAppAd.StGetAdReq;
import NS_MINI_AD.MiniAppAd.UserInfo;
import NS_MINI_INTERFACE.INTERFACE.DeviceInfo;
import NS_MINI_INTERFACE.INTERFACE.Location;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Params;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Result;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ExpParam;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo.Location;
import tencent.gdt.qq_ad_get.QQAdGetRsp;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ExpParam;
import tencent.gdt.qq_ad_get.QQAdGetRsp.PosAdInfo;

public class AdUtils
{
  public static final int AD_EXPOSURE_EXP_ID = 95807;
  public static final String AD_GDT_COOKIE_PRE = "gdt_cookie";
  public static final int AD_REWARD_SHOW_TIME_EXP_ID = 103300;
  public static final int DEVICE_ORIENTATION_LANDSCAPE = 90;
  public static final int DEVICE_ORIENTATION_PORTRAIT = 0;
  public static final String MINI_BUSINESS_ID = "e8d69a";
  private static final String TAG = "AdUtils";
  
  public static List<GdtAd> convertJson2GdtAds(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramString = ((qq_ad_get.QQAdGetRsp)qq_ad_get.QQAdGetRsp.class.cast(GdtJsonPbUtil.a(new qq_ad_get.QQAdGetRsp(), new JSONObject(paramString)))).pos_ads_info.get();
      if ((paramString != null) && (!paramString.isEmpty()))
      {
        localArrayList.clear();
        paramString = paramString.iterator();
        while (paramString.hasNext())
        {
          Object localObject = ((qq_ad_get.QQAdGetRsp.PosAdInfo)paramString.next()).ads_info.get();
          if ((localObject != null) && (!((List)localObject).isEmpty()))
          {
            localObject = ((List)localObject).iterator();
            while (((Iterator)localObject).hasNext()) {
              localArrayList.add(new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)((Iterator)localObject).next()));
            }
          }
          else
          {
            GdtLog.d("AdUtils", "convertJson2GdtAds() adInfos.isEmpty");
          }
        }
        paramString = new StringBuilder();
        paramString.append("convertJson2GdtAds() result = [");
        paramString.append(Arrays.toString(localArrayList.toArray()));
        paramString.append("]");
        GdtLog.a("AdUtils", paramString.toString());
        return localArrayList;
      }
      GdtLog.d("AdUtils", "convertJson2GdtAds() posAdInfos.isEmpty");
      return null;
    }
    catch (Exception paramString)
    {
      GdtLog.d("AdUtils", "convertJson2GdtAds", paramString);
    }
    return localArrayList;
  }
  
  public static MiniAppAd.StGetAdReq createAdRequest(Context paramContext, long paramLong, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    return createAdRequest(paramContext, paramLong, paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramString3, paramString4, paramString5, paramString6, paramString7, 1);
  }
  
  public static MiniAppAd.StGetAdReq createAdRequest(Context paramContext, long paramLong, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt4)
  {
    return createAdRequest(paramContext, paramLong, paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramString3, paramString4, paramString5, paramString6, paramString7, paramInt4, 0, null);
  }
  
  public static MiniAppAd.StGetAdReq createAdRequest(Context paramContext, long paramLong, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt4, int paramInt5, List<MiniAppAd.SpecifiedAdsItem> paramList)
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
    if (paramInt5 != 0)
    {
      ((MiniAppAd.PositionExt)localObject).get_ad_type.set(paramInt5, true);
      if ((paramInt5 == 2) && (paramList != null) && (paramList.size() > 0)) {
        ((MiniAppAd.PositionExt)localObject).specified_ads.addAll(paramList);
      }
    }
    localPositionInfo.ad_count.set(paramInt4, true);
    localPositionInfo.pos_ext.set((MessageMicro)localObject, true);
    paramContext = getDeviceInfo(paramContext, paramInt3);
    paramString1 = new MiniAppAd.ContextInfo();
    paramList = new MiniAppAd.DebugInfo();
    localObject = new MiniAppAd.StGetAdReq();
    ((MiniAppAd.StGetAdReq)localObject).user_info.set(localUserInfo);
    ((MiniAppAd.StGetAdReq)localObject).position_info.add(localPositionInfo);
    ((MiniAppAd.StGetAdReq)localObject).device_info.set(paramContext);
    ((MiniAppAd.StGetAdReq)localObject).context_info.set(paramString1);
    ((MiniAppAd.StGetAdReq)localObject).debug_info.set(paramList);
    ((MiniAppAd.StGetAdReq)localObject).appid.set(paramString2);
    ((MiniAppAd.StGetAdReq)localObject).ad_type.set(paramInt2);
    ((MiniAppAd.StGetAdReq)localObject).gdt_cookie.set(paramString3);
    ((MiniAppAd.StGetAdReq)localObject).extInfo.mapInfo.add(newEntry("queryData", paramString4));
    ((MiniAppAd.StGetAdReq)localObject).extInfo.mapInfo.add(newEntry("reportData", paramString5));
    ((MiniAppAd.StGetAdReq)localObject).extInfo.mapInfo.add(newEntry("refer", paramString6));
    ((MiniAppAd.StGetAdReq)localObject).extInfo.mapInfo.add(newEntry("via", paramString7));
    return localObject;
  }
  
  public static MiniAppAd.DeviceInfo getDeviceInfo(Context paramContext, int paramInt)
  {
    Object localObject1 = new GdtDeviceInfoHelper.Params();
    ((GdtDeviceInfoHelper.Params)localObject1).a = "e8d69a";
    long l = System.currentTimeMillis();
    localObject1 = GdtDeviceInfoHelper.a(paramContext, (GdtDeviceInfoHelper.Params)localObject1);
    if (localObject1 != null) {
      localObject1 = ((GdtDeviceInfoHelper.Result)localObject1).a;
    } else {
      localObject1 = null;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("get deviceInfo cost：");
    ((StringBuilder)localObject2).append(System.currentTimeMillis() - l);
    ((StringBuilder)localObject2).append(", result = ");
    boolean bool;
    if (localObject1 != null) {
      bool = true;
    } else {
      bool = false;
    }
    ((StringBuilder)localObject2).append(bool);
    QLog.i("AdUtils", 2, ((StringBuilder)localObject2).toString());
    MiniAppAd.DeviceInfo localDeviceInfo = new MiniAppAd.DeviceInfo();
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
      Object localObject3 = DeviceInfoUtil.a();
      PBStringField localPBStringField = localDeviceInfo.android_imei;
      localObject2 = localObject3;
      if (TextUtils.isEmpty((CharSequence)localObject3)) {
        localObject2 = "";
      }
      localPBStringField.set((String)localObject2);
      localObject2 = DeviceInfoUtil.f();
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localDeviceInfo.android_id.set((String)localObject2);
        localObject2 = MD5Utils.toMD5((String)localObject2);
        localObject3 = localDeviceInfo.md5_android_id;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject2 = "";
        } else {
          localObject2 = ((String)localObject2).toLowerCase();
        }
        ((PBStringField)localObject3).set((String)localObject2);
      }
      paramContext = DeviceInfoUtil.d(paramContext);
      if (!TextUtils.isEmpty(paramContext))
      {
        localDeviceInfo.mac.set(paramContext);
        localObject2 = MD5Utils.toMD5(paramContext.replace(":", "").toUpperCase()).toLowerCase();
        localObject3 = localDeviceInfo.md5_mac;
        paramContext = (Context)localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          paramContext = "";
        }
        ((PBStringField)localObject3).set(paramContext);
      }
      paramContext = ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).device_ext.get();
      if (!TextUtils.isEmpty(paramContext)) {
        localDeviceInfo.device_ext.set(paramContext);
      }
      paramContext = new StringBuilder();
      paramContext.append("oaid = ");
      paramContext.append(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).oaid.get());
      paramContext.append(", taid_ticket = ");
      paramContext.append(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).taid_ticket.get());
      paramContext.append(", aid_ticket = ");
      paramContext.append(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).aid_ticket.get());
      paramContext.append(", client_ipv4 = ");
      paramContext.append(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).client_ipv4.get());
      QLog.i("AdUtils", 1, paramContext.toString());
    }
    return localDeviceInfo;
  }
  
  public static INTERFACE.DeviceInfo getDeviceInfo(Context paramContext)
  {
    Object localObject1 = new GdtDeviceInfoHelper.Params();
    ((GdtDeviceInfoHelper.Params)localObject1).a = "e8d69a";
    localObject1 = GdtDeviceInfoHelper.a(paramContext, (GdtDeviceInfoHelper.Params)localObject1);
    if (localObject1 != null) {
      localObject1 = ((GdtDeviceInfoHelper.Result)localObject1).a;
    } else {
      localObject1 = null;
    }
    INTERFACE.DeviceInfo localDeviceInfo = new INTERFACE.DeviceInfo();
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
      Object localObject3 = DeviceInfoUtil.a();
      PBStringField localPBStringField = localDeviceInfo.android_imei;
      Object localObject2 = localObject3;
      if (TextUtils.isEmpty((CharSequence)localObject3)) {
        localObject2 = "";
      }
      localPBStringField.set((String)localObject2);
      localObject2 = DeviceInfoUtil.f();
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localDeviceInfo.android_id.set((String)localObject2);
        localObject2 = MD5Utils.toMD5((String)localObject2);
        localObject3 = localDeviceInfo.md5_android_id;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject2 = "";
        } else {
          localObject2 = ((String)localObject2).toLowerCase();
        }
        ((PBStringField)localObject3).set((String)localObject2);
      }
      paramContext = DeviceInfoUtil.d(paramContext);
      if (!TextUtils.isEmpty(paramContext))
      {
        localDeviceInfo.mac.set(paramContext);
        localObject2 = MD5Utils.toMD5(paramContext.replace(":", "").toUpperCase()).toLowerCase();
        localObject3 = localDeviceInfo.md5_mac;
        paramContext = (Context)localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          paramContext = "";
        }
        ((PBStringField)localObject3).set(paramContext);
      }
      paramContext = new StringBuilder();
      paramContext.append("oaid = ");
      paramContext.append(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).oaid.get());
      paramContext.append(", taid_ticket = ");
      paramContext.append(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).taid_ticket.get());
      paramContext.append(", aid_ticket = ");
      paramContext.append(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).aid_ticket.get());
      paramContext.append(", client_ipv4 = ");
      paramContext.append(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).client_ipv4.get());
      QLog.d("AdUtils", 1, paramContext.toString());
    }
    return localDeviceInfo;
  }
  
  public static List<AdProxy.ExpParam> getExpParam(GdtAd paramGdtAd)
  {
    if (paramGdtAd != null) {
      try
      {
        paramGdtAd = paramGdtAd.getExpMap();
        localObject = new ArrayList();
        int i = 0;
        while (i < paramGdtAd.size())
        {
          ((List)localObject).add(new AdProxy.ExpParam(((qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)paramGdtAd.get(i)).key.get(), ((qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)paramGdtAd.get(i)).value.get()));
          i += 1;
        }
        return localObject;
      }
      catch (Throwable paramGdtAd)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("exp_map error");
        ((StringBuilder)localObject).append(paramGdtAd);
        QLog.e("AdUtils", 1, ((StringBuilder)localObject).toString());
      }
    }
    return null;
  }
  
  public static String getExpValueByKey(GdtAd paramGdtAd, int paramInt)
  {
    if (paramGdtAd != null) {
      try
      {
        paramGdtAd = paramGdtAd.getExpMap();
        int i = 0;
        while (i < paramGdtAd.size())
        {
          if (((qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)paramGdtAd.get(i)).key.get() == paramInt)
          {
            paramGdtAd = ((qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)paramGdtAd.get(i)).value.get();
            return paramGdtAd;
          }
          i += 1;
        }
        StringBuilder localStringBuilder;
        return "";
      }
      catch (Throwable paramGdtAd)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("exp_map error");
        localStringBuilder.append(paramGdtAd);
        QLog.e("AdUtils", 1, localStringBuilder.toString());
      }
    }
  }
  
  private static String getGdtCookieSpKey(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("gdt_cookie_");
    localStringBuilder.append(BaseApplicationImpl.getApplication().getRuntime().getAccount());
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
  
  public static int getRewardVideoShowTimeFromExp(GdtAd paramGdtAd)
  {
    paramGdtAd = getExpValueByKey(paramGdtAd, 103300);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getRewardVideoShowTimeFromExp = ");
    localStringBuilder.append(paramGdtAd);
    QLog.i("AdUtils", 1, localStringBuilder.toString());
    if (TextUtils.isEmpty(paramGdtAd)) {
      return -1;
    }
    try
    {
      int i = Integer.valueOf(paramGdtAd).intValue();
      return i;
    }
    catch (NumberFormatException paramGdtAd)
    {
      QLog.i("AdUtils", 1, "getRewardVideoShowTimeFromExp error", paramGdtAd);
    }
    return -1;
  }
  
  public static String getSpAdGdtCookie(int paramInt)
  {
    String str = getGdtCookieSpKey(paramInt);
    return StorageUtil.getPreference().getString(str, "");
  }
  
  public static boolean isHitExp(GdtAd paramGdtAd, int paramInt)
  {
    if (paramGdtAd != null) {
      try
      {
        paramGdtAd = paramGdtAd.getExpMap();
        int i = 0;
        while (i < paramGdtAd.size())
        {
          if (((qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)paramGdtAd.get(i)).key.get() == paramInt)
          {
            boolean bool = ((qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)paramGdtAd.get(i)).value.get().equals("1");
            if (bool) {
              return true;
            }
          }
          i += 1;
        }
        StringBuilder localStringBuilder;
        return false;
      }
      catch (Throwable paramGdtAd)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("exp_map error");
        localStringBuilder.append(paramGdtAd);
        QLog.e("AdUtils", 1, localStringBuilder.toString());
      }
    }
  }
  
  public static boolean isHitReport50ViewAndOneSecond(GdtAd paramGdtAd)
  {
    boolean bool = isHitExp(paramGdtAd, 95807);
    paramGdtAd = new StringBuilder();
    paramGdtAd.append("bannerad hit=");
    paramGdtAd.append(bool);
    QLog.i("AdUtils", 1, paramGdtAd.toString());
    return bool;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.util.AdUtils
 * JD-Core Version:    0.7.0.1
 */