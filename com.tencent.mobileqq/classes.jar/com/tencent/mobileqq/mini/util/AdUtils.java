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
import achn;
import acho;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
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
  public static final int AD_INTERSTITIAL_NEW_STYLE_EXP_ID = 101736;
  public static final int DEVICE_ORIENTATION_LANDSCAPE = 90;
  public static final int DEVICE_ORIENTATION_PORTRAIT = 0;
  public static final String MINI_BUSINESS_ID = "e8d69a";
  private static final String TAG = "AdUtils";
  
  public static List<GdtAd> convertJson2GdtAds(String paramString)
  {
    localObject2 = new ArrayList();
    try
    {
      paramString = ((qq_ad_get.QQAdGetRsp)qq_ad_get.QQAdGetRsp.class.cast(achn.a(new qq_ad_get.QQAdGetRsp(), new JSONObject(paramString)))).pos_ads_info.get();
      if ((paramString == null) || (paramString.isEmpty()))
      {
        acho.d("AdUtils", "convertJson2GdtAds() posAdInfos.isEmpty");
        return null;
      }
      if (localObject2 != null) {
        ((List)localObject2).clear();
      }
      Iterator localIterator1 = paramString.iterator();
      for (;;)
      {
        paramString = (String)localObject2;
        try
        {
          if (!localIterator1.hasNext()) {
            break label226;
          }
          paramString = (String)localObject2;
          List localList = ((qq_ad_get.QQAdGetRsp.PosAdInfo)localIterator1.next()).ads_info.get();
          if (localList != null)
          {
            paramString = (String)localObject2;
            if (!localList.isEmpty()) {
              break label147;
            }
          }
          paramString = (String)localObject2;
          acho.d("AdUtils", "convertJson2GdtAds() adInfos.isEmpty");
        }
        catch (Exception localException1) {}
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        Iterator localIterator2;
        Object localObject1;
        paramString = (String)localObject2;
      }
    }
    acho.d("AdUtils", "convertJson2GdtAds", localException1);
    return paramString;
    label147:
    paramString = (String)localObject2;
    localIterator2 = localException1.iterator();
    for (localObject1 = localObject2;; localObject1 = localObject2)
    {
      localObject2 = localObject1;
      paramString = localObject1;
      if (!localIterator2.hasNext()) {
        break;
      }
      paramString = localObject1;
      qq_ad_get.QQAdGetRsp.AdInfo localAdInfo = (qq_ad_get.QQAdGetRsp.AdInfo)localIterator2.next();
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        paramString = localObject1;
        localObject2 = new ArrayList();
      }
      paramString = (String)localObject2;
      ((List)localObject2).add(new GdtAd(localAdInfo));
    }
    label226:
    if (localObject2 != null)
    {
      paramString = (String)localObject2;
      acho.a("AdUtils", "convertJson2GdtAds() result = [" + Arrays.toString(((List)localObject2).toArray()) + "]");
    }
    return localObject2;
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
    ((GdtDeviceInfoHelper.Params)localObject1).businessIdForAidTicketAndTaidTicket = "e8d69a";
    long l = System.currentTimeMillis();
    localObject1 = GdtDeviceInfoHelper.create(paramContext, (GdtDeviceInfoHelper.Params)localObject1);
    boolean bool;
    label77:
    MiniAppAd.DeviceInfo localDeviceInfo;
    Object localObject3;
    if (localObject1 != null)
    {
      localObject1 = ((GdtDeviceInfoHelper.Result)localObject1).deviceInfo;
      localObject2 = new StringBuilder().append("get deviceInfo cost：").append(System.currentTimeMillis() - l).append(", result = ");
      if (localObject1 == null) {
        break label720;
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
        localObject3 = DeviceInfoUtil.getIMEI();
        PBStringField localPBStringField = localDeviceInfo.android_imei;
        localObject2 = localObject3;
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          localObject2 = "";
        }
        localPBStringField.set((String)localObject2);
        localObject2 = DeviceInfoUtil.getAndroidID();
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localDeviceInfo.android_id.set((String)localObject2);
          localObject2 = MD5Utils.toMD5((String)localObject2);
          localObject3 = localDeviceInfo.md5_android_id;
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            break label726;
          }
        }
      }
    }
    label720:
    label726:
    for (Object localObject2 = "";; localObject2 = ((String)localObject2).toLowerCase())
    {
      ((PBStringField)localObject3).set((String)localObject2);
      paramContext = DeviceInfoUtil.getMacAddress(paramContext);
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
      QLog.i("AdUtils", 1, "oaid = " + ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).oaid.get() + ", taid_ticket = " + ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).taid_ticket.get() + ", aid_ticket = " + ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).aid_ticket.get() + ", client_ipv4 = " + ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).client_ipv4.get());
      return localDeviceInfo;
      localObject1 = null;
      break;
      bool = false;
      break label77;
    }
  }
  
  public static INTERFACE.DeviceInfo getDeviceInfo(Context paramContext)
  {
    Object localObject1 = new GdtDeviceInfoHelper.Params();
    ((GdtDeviceInfoHelper.Params)localObject1).businessIdForAidTicketAndTaidTicket = "e8d69a";
    localObject1 = GdtDeviceInfoHelper.create(paramContext, (GdtDeviceInfoHelper.Params)localObject1);
    INTERFACE.DeviceInfo localDeviceInfo;
    Object localObject3;
    if (localObject1 != null)
    {
      localObject1 = ((GdtDeviceInfoHelper.Result)localObject1).deviceInfo;
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
        localObject3 = DeviceInfoUtil.getIMEI();
        PBStringField localPBStringField = localDeviceInfo.android_imei;
        localObject2 = localObject3;
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          localObject2 = "";
        }
        localPBStringField.set((String)localObject2);
        localObject2 = DeviceInfoUtil.getAndroidID();
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localDeviceInfo.android_id.set((String)localObject2);
          localObject2 = MD5Utils.toMD5((String)localObject2);
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
      paramContext = DeviceInfoUtil.getMacAddress(paramContext);
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
  
  public static boolean isHitExp(GdtAd paramGdtAd, int paramInt)
  {
    boolean bool = false;
    if (paramGdtAd != null) {}
    for (;;)
    {
      try
      {
        paramGdtAd = paramGdtAd.getExpMap();
        int i = 0;
        if (i < paramGdtAd.size())
        {
          if (((qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)paramGdtAd.get(i)).key.get() == paramInt)
          {
            bool = ((qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)paramGdtAd.get(i)).value.get().equals("1");
            if (bool)
            {
              bool = true;
              return bool;
            }
          }
          i += 1;
        }
        else
        {
          bool = false;
        }
      }
      catch (Throwable paramGdtAd)
      {
        QLog.e("AdUtils", 1, "exp_map error" + paramGdtAd);
        return false;
      }
    }
  }
  
  public static boolean isHitInterstitialAdNewStyle(GdtAd paramGdtAd)
  {
    boolean bool = isHitExp(paramGdtAd, 101736);
    QLog.i("AdUtils", 1, "interstitialAd new style hit=" + bool);
    return bool;
  }
  
  public static boolean isHitReport50ViewAndOneSecond(GdtAd paramGdtAd)
  {
    boolean bool = isHitExp(paramGdtAd, 95807);
    QLog.i("AdUtils", 1, "bannerad hit=" + bool);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.util.AdUtils
 * JD-Core Version:    0.7.0.1
 */