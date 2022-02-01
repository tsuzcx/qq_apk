package com.tencent.mobileqq.qwallet.utils.impl;

import android.os.Handler;
import android.text.TextUtils;
import com.qwallet.temp.IQWalletTemp.ICallBack;
import com.tencent.ark.ark;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqgamepub.api.IQQGameResService;
import com.tencent.mobileqq.qqgamepub.api.IQQGameTempRelyApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.report.impl.ReportUtils;
import com.tencent.mobileqq.qwallet.utils.IArkPubicEventWrap.ArkEvent;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import mqq.app.MobileQQ;
import org.json.JSONObject;

class ArkPubicEventWrapImpl$1
  implements IQWalletTemp.ICallBack
{
  ArkPubicEventWrapImpl$1(ArkPubicEventWrapImpl paramArkPubicEventWrapImpl) {}
  
  public boolean a(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ArkPubicEventWrap", 2, String.format(Locale.getDefault(), "appName:%1$s;eventName:%2$s;params:%3$s;", new Object[] { paramString1, paramString2, paramString3 }));
    }
    if ("ad_query_mute".equals(paramString2))
    {
      ArkPubicEventWrapImpl.access$000(this.a, paramString1);
      return true;
    }
    if ("event_query_package".equals(paramString2))
    {
      if (!TextUtils.isEmpty(paramString3)) {
        try
        {
          paramString2 = new JSONObject(paramString3).optString("packageName");
          paramString2 = PackageUtil.a(MobileQQ.getContext(), paramString2);
          paramString3 = new JSONObject();
          boolean bool = "0".equals(paramString2);
          if (bool)
          {
            paramString3.put("errCode", 0);
            paramString3.put("isInstall", false);
          }
          else
          {
            paramString3.put("errCode", 0);
            paramString3.put("isInstall", true);
            paramString3.put("version", paramString2);
          }
          ark.arkNotify(paramString1, "event_query_package_callback", paramString3.toString(), "json");
          return true;
        }
        catch (Throwable paramString2)
        {
          paramString2.printStackTrace();
          ark.arkNotify(paramString1, "event_query_package_callback", "", "json");
        }
      }
      return true;
    }
    if ("event_fullscreen_play".equals(paramString2))
    {
      if (!TextUtils.isEmpty(paramString3)) {
        try
        {
          paramString1 = new JSONObject(paramString3);
          paramString1.optString("videoUrl");
          paramString1.optString("playRate");
          paramString1.optString("totalRate");
          return true;
        }
        catch (Throwable paramString1)
        {
          paramString1.printStackTrace();
        }
      }
      return true;
    }
    if ("beacon_report".equals(paramString2)) {
      try
      {
        paramString1 = new JSONObject(paramString3);
        ReportUtils.a("000004B5DU3Q3LD1", paramString1.optString("event_name"), paramString1.optJSONObject("params"));
        return true;
      }
      catch (Throwable paramString1)
      {
        QLog.e("ArkPubicEventWrap", 1, paramString1, new Object[0]);
        return true;
      }
    }
    if ("get_view_location".equals(paramString2))
    {
      ThreadManagerV2.getUIHandlerV2().post(new ArkPubicEventWrapImpl.1.1(this, paramString1, paramString3));
      return true;
    }
    if ("gc_ark_msg_delete".equals(paramString2))
    {
      ((IQQGameTempRelyApi)QRoute.api(IQQGameTempRelyApi.class)).handleGcArkDeleteMsg(paramString3);
      return true;
    }
    if ("gc_ark_open_hippy".equals(paramString2))
    {
      paramString1 = new HippyMap();
      try
      {
        paramString1.pushJSONObject(new JSONObject(paramString3));
        new OpenHippyInfo(paramString1).openHippy(MobileQQ.sMobileQQ);
        if (QLog.isColorLevel())
        {
          paramString1 = new StringBuilder();
          paramString1.append("ARK_OPEN_HIPPY:");
          paramString1.append(paramString3);
          QLog.i("ArkPubicEventWrap", 2, paramString1.toString());
          return true;
        }
      }
      catch (Exception paramString1)
      {
        paramString2 = new StringBuilder();
        paramString2.append("ARK_OPEN_HIPPY...");
        paramString2.append(paramString1);
        QLog.e("ArkPubicEventWrap", 1, paramString2.toString());
      }
      return true;
    }
    if ("gc_ark_get_dsl_content".equals(paramString2))
    {
      try
      {
        long l = System.currentTimeMillis();
        paramString2 = new JSONObject(paramString3);
        String str = paramString2.optString("dslId");
        str = ((IQQGameResService)QRoute.api(IQQGameResService.class)).getActivityDSL(str, 0);
        if (!TextUtils.isEmpty(str)) {
          paramString2.put("dsl", str);
        }
        ark.arkNotify(paramString1, "gc_ark_get_dsl_content_callback", paramString2.toString(), "json");
        if (QLog.isColorLevel())
        {
          paramString1 = new StringBuilder();
          paramString1.append("ARK_GET_DSL_CONTENT:");
          paramString1.append(paramString3);
          paramString1.append(", jsonObject:");
          paramString1.append(paramString2);
          paramString1.append(",cost:");
          paramString1.append(System.currentTimeMillis() - l);
          QLog.i("ArkPubicEventWrap", 2, paramString1.toString());
          return true;
        }
      }
      catch (Exception paramString1)
      {
        paramString2 = new StringBuilder();
        paramString2.append("ARK_GET_DSL_CONTENT...");
        paramString2.append(paramString1);
        QLog.e("ArkPubicEventWrap", 1, paramString2.toString());
      }
      return true;
    }
    ArkPubicEventWrapImpl.access$200(this.a);
    this.a.notifyObservers(new IArkPubicEventWrap.ArkEvent(paramString1, paramString2, paramString3));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.utils.impl.ArkPubicEventWrapImpl.1
 * JD-Core Version:    0.7.0.1
 */