package com.tencent.mobileqq.search.fragment.searchresult;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Params;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Result;
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
    if (localObject != null) {}
    for (localObject = ((GdtDeviceInfoHelper.Result)localObject).a;; localObject = null)
    {
      a(localHashMap);
      localHashMap.put("imei", MobileInfoUtil.c());
      localHashMap.put("mac", DeviceInfoUtil.c(BaseApplication.getContext()));
      if (localObject != null)
      {
        localHashMap.put("android_id", ((qq_ad_get.QQAdGet.DeviceInfo)localObject).md5_android_id.get());
        localHashMap.put("oaid", ((qq_ad_get.QQAdGet.DeviceInfo)localObject).aid_ticket.get());
        localHashMap.put("taid", ((qq_ad_get.QQAdGet.DeviceInfo)localObject).taid_ticket.get());
        localHashMap.put("conn", ((qq_ad_get.QQAdGet.DeviceInfo)localObject).conn.get() + "");
        localHashMap.put("hostver", ((qq_ad_get.QQAdGet.DeviceInfo)localObject).qq_ver.get());
        b(localHashMap, (qq_ad_get.QQAdGet.DeviceInfo)localObject);
        a(localHashMap, (qq_ad_get.QQAdGet.DeviceInfo)localObject);
      }
      localHashMap.put("device", Build.MODEL);
      localHashMap.put("osver", Build.VERSION.RELEASE);
      return localHashMap;
    }
  }
  
  private static JSONArray a(qq_ad_get.QQAdGet.DeviceInfo paramDeviceInfo)
  {
    JSONArray localJSONArray = new JSONArray();
    JSONObject localJSONObject;
    String str1;
    if (paramDeviceInfo != null)
    {
      localJSONObject = new JSONObject();
      String str4 = paramDeviceInfo.carrier_code.get() + "";
      String str2 = "NULL";
      String str3 = "NULL";
      str1 = str3;
      paramDeviceInfo = str2;
      if (!TextUtils.isEmpty(str4))
      {
        str1 = str3;
        paramDeviceInfo = str2;
        if (str4.length() >= 5)
        {
          paramDeviceInfo = str4.substring(0, 3);
          str1 = str4.substring(3);
        }
      }
    }
    try
    {
      localJSONObject.put("mcc", paramDeviceInfo);
      localJSONObject.put("mnc", str1);
      localJSONArray.put(localJSONObject);
      return localJSONArray;
    }
    catch (JSONException paramDeviceInfo)
    {
      for (;;)
      {
        paramDeviceInfo.printStackTrace();
      }
    }
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
    if ((paramDeviceInfo != null) && (paramDeviceInfo.location != null)) {
      paramDeviceInfo = paramDeviceInfo.location;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.searchresult.KDSearchResultHeader
 * JD-Core Version:    0.7.0.1
 */