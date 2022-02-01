package com.tencent.mobileqq.kandian.biz.search.searchresult;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Params;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Result;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo.Location;

public class KDSearchResultHeader
{
  public static Map<String, String> a()
  {
    HashMap localHashMap = new HashMap();
    Object localObject = new GdtDeviceInfoHelper.Params();
    ((GdtDeviceInfoHelper.Params)localObject).a = "ce2d9f";
    localObject = GdtDeviceInfoHelper.a(BaseApplicationImpl.getApplication(), (GdtDeviceInfoHelper.Params)localObject);
    if (localObject != null) {
      localObject = ((GdtDeviceInfoHelper.Result)localObject).a;
    } else {
      localObject = null;
    }
    a(localHashMap);
    localHashMap.put("imei", MobileInfoUtil.getImei());
    localHashMap.put("mac", DeviceInfoUtil.c(BaseApplication.getContext()));
    if (localObject != null)
    {
      localHashMap.put("md5_android_id", ((qq_ad_get.QQAdGet.DeviceInfo)localObject).md5_android_id.get());
      localHashMap.put("oaid", ((qq_ad_get.QQAdGet.DeviceInfo)localObject).aid_ticket.get());
      localHashMap.put("taid", ((qq_ad_get.QQAdGet.DeviceInfo)localObject).taid_ticket.get());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((qq_ad_get.QQAdGet.DeviceInfo)localObject).conn.get());
      localStringBuilder.append("");
      localHashMap.put("conn", localStringBuilder.toString());
      localHashMap.put("hostver", ((qq_ad_get.QQAdGet.DeviceInfo)localObject).qq_ver.get());
      localHashMap.put("device_ext", ((qq_ad_get.QQAdGet.DeviceInfo)localObject).device_ext.get());
      localHashMap.put("deivce_brand_and_model", ((qq_ad_get.QQAdGet.DeviceInfo)localObject).device_brand_and_model.get());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(((qq_ad_get.QQAdGet.DeviceInfo)localObject).is_googleplay_version.get());
      localStringBuilder.append("");
      localHashMap.put("is_googleplay_version", localStringBuilder.toString());
      localHashMap.put("client_ipv4", ((qq_ad_get.QQAdGet.DeviceInfo)localObject).client_ipv4.get());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(((qq_ad_get.QQAdGet.DeviceInfo)localObject).origin_network_type.get());
      localStringBuilder.append("");
      localHashMap.put("origin_network_type", localStringBuilder.toString());
      b(localHashMap, (qq_ad_get.QQAdGet.DeviceInfo)localObject);
      a(localHashMap, (qq_ad_get.QQAdGet.DeviceInfo)localObject);
    }
    localHashMap.put("device", Build.MODEL);
    localHashMap.put("osver", Build.VERSION.RELEASE);
    return localHashMap;
  }
  
  private static JSONArray a(qq_ad_get.QQAdGet.DeviceInfo paramDeviceInfo)
  {
    JSONArray localJSONArray = new JSONArray();
    if (paramDeviceInfo != null)
    {
      JSONObject localJSONObject = new JSONObject();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramDeviceInfo.carrier_code.get());
      ((StringBuilder)localObject).append("");
      String str = ((StringBuilder)localObject).toString();
      boolean bool = TextUtils.isEmpty(str);
      localObject = "NULL";
      if ((!bool) && (str.length() >= 5))
      {
        paramDeviceInfo = str.substring(0, 3);
        localObject = str.substring(3);
      }
      else
      {
        paramDeviceInfo = "NULL";
      }
      try
      {
        localJSONObject.put("mcc", paramDeviceInfo);
        localJSONObject.put("mnc", localObject);
      }
      catch (JSONException paramDeviceInfo)
      {
        paramDeviceInfo.printStackTrace();
      }
      localJSONArray.put(localJSONObject);
    }
    return localJSONArray;
  }
  
  private static void a(Map<String, String> paramMap)
  {
    String str2 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "NULL";
    }
    paramMap.put("QBID", str1);
  }
  
  private static void a(Map<String, String> paramMap, qq_ad_get.QQAdGet.DeviceInfo paramDeviceInfo)
  {
    paramMap.put("carrier", a(paramDeviceInfo).toString());
  }
  
  private static void b(Map<String, String> paramMap, qq_ad_get.QQAdGet.DeviceInfo paramDeviceInfo)
  {
    if ((paramDeviceInfo != null) && (paramDeviceInfo.location != null))
    {
      paramDeviceInfo = paramDeviceInfo.location;
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if (paramDeviceInfo != null)
        {
          localJSONObject.put("fLongitude", paramDeviceInfo.longitude.get());
          localJSONObject.put("fLatitude", paramDeviceInfo.latitude.get());
        }
        paramMap.put("POSITION", localJSONObject.toString());
        return;
      }
      catch (JSONException paramMap)
      {
        paramMap.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.search.searchresult.KDSearchResultHeader
 * JD-Core Version:    0.7.0.1
 */