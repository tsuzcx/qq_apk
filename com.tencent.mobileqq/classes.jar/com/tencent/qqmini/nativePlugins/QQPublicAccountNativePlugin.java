package com.tencent.qqmini.nativePlugins;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import aatd;
import aate;
import aatf;
import android.content.Intent;
import bglv;
import bgok;
import bjdt;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqmini.sdk.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.log.QMLog;
import cooperation.vip.pb.vac_adv_get.VacFeedsAdvMetaReq;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;
import ybt;

public class QQPublicAccountNativePlugin
  extends BaseJsPlugin
{
  public static final String API_OSUBSCRIBE_GET_DEVICE_INFO = "qsubscribe_getdeviceinfo";
  public static final String API_QSUBSCRIBE_OPEN_DETAIL = "qsubscribe_opendetail";
  public static final String API_QSUBSCRIBE_OPEN_DISCOVER = "qsubscribe_opendiscover";
  public static final String API_QSUBSCRIBE_OPEN_HOMEPAGE = "qsubscribe_openhomepage";
  private static final String DATA = "data";
  public static final String TAG = "QQPublicAccountNativePlugin";
  
  private JSONObject getParam(bgok parambgok)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambgok.b);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("QQPublicAccountNativePlugin", "Failed to parse jsonParams=" + parambgok.b);
    }
    return null;
  }
  
  public void qsubscribeGetdeviceinfo(bgok parambgok)
  {
    try
    {
      getParam(parambgok);
      Object localObject = new aate();
      ((aate)localObject).a = "1b0ad2";
      localObject = aatd.a(BaseApplication.getContext(), (aate)localObject);
      if ((localObject != null) && (((aatf)localObject).a != null))
      {
        vac_adv_get.VacFeedsAdvMetaReq localVacFeedsAdvMetaReq = new vac_adv_get.VacFeedsAdvMetaReq();
        localVacFeedsAdvMetaReq.device_info.set(((aatf)localObject).a);
        localObject = Arrays.toString(localVacFeedsAdvMetaReq.toByteArray());
        new JSONObject().put("deviceinfo", localObject);
        parambgok.a();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("QQPublicAccountNativePlugin", "Handle QQPublicAccountNativePlugin failed! ", localThrowable);
      parambgok.b();
    }
  }
  
  public void qsubscribeOpendetail(bgok parambgok)
  {
    try
    {
      Object localObject = getParam(parambgok).optJSONObject("data");
      if (localObject != null)
      {
        String str1 = ((JSONObject)localObject).optString("uin");
        int i = ((JSONObject)localObject).optInt("type");
        String str2 = ((JSONObject)localObject).optString("feedid");
        long l = ((JSONObject)localObject).optLong("createtime");
        localObject = ybt.a(str2, str1, i, ((JSONObject)localObject).optInt("width"), ((JSONObject)localObject).optInt("height"), l);
        ybt.a(this.mMiniAppContext.a(), (CertifiedAccountMeta.StFeed)localObject, 9001);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("QQPublicAccountNativePlugin", "Handle QQPublicAccountNativePlugin failed! ", localThrowable);
      parambgok.b();
    }
  }
  
  public void qsubscribeOpendiscover(bgok parambgok)
  {
    boolean bool = true;
    try
    {
      Object localObject = getParam(parambgok).optJSONObject("data");
      if (localObject != null)
      {
        String str = ((JSONObject)localObject).optString("uin");
        int i = ((JSONObject)localObject).optInt("shoptype");
        localObject = new Intent();
        ((Intent)localObject).putExtra("postUin", str);
        ((Intent)localObject).putExtra("sourceFrom", 1);
        if (i <= 1) {
          break label107;
        }
      }
      for (;;)
      {
        ((Intent)localObject).putExtra("has_shop", bool);
        ((Intent)localObject).addFlags(268435456);
        bjdt.a(this.mMiniAppContext.a(), (Intent)localObject, 0);
        parambgok.a();
        return;
        label107:
        bool = false;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("QQPublicAccountNativePlugin", "Handle QQPublicAccountNativePlugin failed! ", localThrowable);
      parambgok.b();
    }
  }
  
  public void qsubscribeOpenhomepage(bgok parambgok)
  {
    try
    {
      Object localObject = getParam(parambgok).optJSONObject("data");
      if (localObject != null)
      {
        localObject = ((JSONObject)localObject).optString("uin");
        ybt.a(this.mMiniAppContext.a(), (String)localObject, 9001);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("QQPublicAccountNativePlugin", "Handle QQPublicAccountNativePlugin failed! ", localThrowable);
      parambgok.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.QQPublicAccountNativePlugin
 * JD-Core Version:    0.7.0.1
 */