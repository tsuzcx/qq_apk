package com.tencent.mobileqq.kandian.repo.common;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.beacon.event.UserAction;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Params;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Result;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;

public class RIJUGJsonUtils
{
  public static String a = "";
  
  public static String a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      Object localObject = (QQAppInterface)RIJQQAppInterfaceUtil.e();
      localJSONObject.put("pos_id", 100402);
      localJSONObject.put("uin", ((QQAppInterface)localObject).getAccount());
      localJSONObject.put("imei", MobileInfoUtil.getImei());
      localJSONObject.put("Qom", UserAction.getQIMEI());
      localJSONObject.put("platform", "A");
      localJSONObject.put("qqver", "8.8.17");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HttpUtil.getNetWorkType());
      localStringBuilder.append("");
      localJSONObject.put("net_type", localStringBuilder.toString());
      localJSONObject.put("sUserKey", ((QQAppInterface)localObject).getAccount());
      localJSONObject.put("iUserKeyType", 6);
      localJSONObject.put("req_ext", URLEncoder.encode(URLEncoder.encode(b())));
      localObject = new JSONArray();
      if (!PackageUtil.b(BaseApplicationImpl.getContext(), "com.tencent.reading").equals("0")) {
        ((JSONArray)localObject).put("1");
      }
      if (!PackageUtil.b(BaseApplicationImpl.getContext(), "com.tencent.weishi").equals("0")) {
        ((JSONArray)localObject).put("3");
      }
      localJSONObject.put("app_list", localObject);
    }
    catch (Exception localException)
    {
      QLog.d("RIJUGJsonUtils", 1, localException.getMessage());
    }
    return localJSONObject.toString();
  }
  
  public static String b()
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        Object localObject1 = RIJQQAppInterfaceUtil.f();
        if ((localObject1 != null) && (!TextUtils.isEmpty((CharSequence)localObject1))) {
          localJSONObject.put("guid", localObject1);
        }
        localJSONObject.put("qua", c());
        localObject1 = new GdtDeviceInfoHelper.Params();
        ((GdtDeviceInfoHelper.Params)localObject1).a = "ce2d9f";
        localObject1 = GdtDeviceInfoHelper.a(BaseApplication.getContext(), (GdtDeviceInfoHelper.Params)localObject1);
        if (localObject1 == null) {
          break label144;
        }
        localObject1 = ((GdtDeviceInfoHelper.Result)localObject1).a;
        if (localObject1 != null) {
          localJSONObject.put("oaid", ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).aid_ticket.get());
        }
        localObject1 = Build.BRAND;
        localJSONObject.put("machine", Build.MODEL);
        localJSONObject.put("brand", localObject1);
        localJSONObject.put("qimei", UserAction.getQIMEI());
      }
      catch (Exception localException)
      {
        QLog.d("RIJUGJsonUtils", 1, localException.getMessage());
      }
      return localJSONObject.toString();
      label144:
      Object localObject2 = null;
    }
  }
  
  public static String c()
  {
    if (!a.isEmpty()) {
      return a;
    }
    int k = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
    int i = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;
    int m = k;
    int j = i;
    if (BaseApplication.getContext().getResources().getConfiguration().orientation == 2)
    {
      j = k;
      m = i;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(m);
    ((StringBuilder)localObject).append("*");
    ((StringBuilder)localObject).append(j);
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PR=QQ&PP=com.tencent.mobileqq&PPVN=8.8.17.5770&CO=SYS&PL=ADR&LCID=");
    localStringBuilder.append(AppSetting.f());
    localStringBuilder.append("&RL=");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("&DE=");
    localStringBuilder.append(Build.BRAND);
    localStringBuilder.append("&MO=");
    localStringBuilder.append(Build.MODEL);
    localStringBuilder.append("&REF=NA_0");
    a = localStringBuilder.toString();
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.common.RIJUGJsonUtils
 * JD-Core Version:    0.7.0.1
 */