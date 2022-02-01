package com.tencent.qqmini.nativePlugins;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import android.content.Intent;
import com.tencent.biz.subscribe.SubscribeLaucher;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Params;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Result;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import cooperation.qzone.QZoneHelper;
import cooperation.vip.pb.vac_adv_get.VacFeedsAdvMetaReq;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;

@JsPlugin(secondary=true)
public class QQPublicAccountNativePlugin
  extends BaseJsPlugin
{
  private JSONObject a(RequestEvent paramRequestEvent)
  {
    try
    {
      localObject = new JSONObject(paramRequestEvent.jsonParams);
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      Object localObject;
      label14:
      break label14;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Failed to parse jsonParams=");
    ((StringBuilder)localObject).append(paramRequestEvent.jsonParams);
    QLog.e("QQPublicAccountNativePlugin", 1, ((StringBuilder)localObject).toString());
    return null;
  }
  
  @JsEvent({"qsubscribe_getdeviceinfo"})
  public void qsubscribeGetdeviceinfo(RequestEvent paramRequestEvent)
  {
    try
    {
      a(paramRequestEvent);
      Object localObject = new GdtDeviceInfoHelper.Params();
      ((GdtDeviceInfoHelper.Params)localObject).a = "1b0ad2";
      localObject = GdtDeviceInfoHelper.a(BaseApplication.getContext(), (GdtDeviceInfoHelper.Params)localObject);
      if ((localObject != null) && (((GdtDeviceInfoHelper.Result)localObject).a != null))
      {
        vac_adv_get.VacFeedsAdvMetaReq localVacFeedsAdvMetaReq = new vac_adv_get.VacFeedsAdvMetaReq();
        localVacFeedsAdvMetaReq.device_info.set(((GdtDeviceInfoHelper.Result)localObject).a);
        localObject = Arrays.toString(localVacFeedsAdvMetaReq.toByteArray());
        new JSONObject().put("deviceinfo", localObject);
        paramRequestEvent.ok();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QQPublicAccountNativePlugin", 1, "Handle QQPublicAccountNativePlugin failed! ", localThrowable);
      paramRequestEvent.fail();
    }
  }
  
  @JsEvent({"qsubscribe_opendetail"})
  public void qsubscribeOpendetail(RequestEvent paramRequestEvent)
  {
    try
    {
      Object localObject = a(paramRequestEvent).optJSONObject("data");
      if (localObject != null)
      {
        String str1 = ((JSONObject)localObject).optString("uin");
        int i = ((JSONObject)localObject).optInt("type");
        String str2 = ((JSONObject)localObject).optString("feedid");
        long l = ((JSONObject)localObject).optLong("createtime");
        localObject = SubscribeLaucher.a(str2, str1, i, ((JSONObject)localObject).optInt("width"), ((JSONObject)localObject).optInt("height"), l);
        SubscribeLaucher.a(this.mMiniAppContext.getAttachedActivity(), (CertifiedAccountMeta.StFeed)localObject, 9001);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QQPublicAccountNativePlugin", 1, "Handle QQPublicAccountNativePlugin failed! ", localThrowable);
      paramRequestEvent.fail();
    }
  }
  
  @JsEvent({"qsubscribe_opendiscover"})
  public void qsubscribeOpendiscover(RequestEvent paramRequestEvent)
  {
    for (;;)
    {
      try
      {
        Object localObject = a(paramRequestEvent).optJSONObject("data");
        if (localObject != null)
        {
          String str = ((JSONObject)localObject).optString("uin");
          int i = ((JSONObject)localObject).optInt("shoptype");
          localObject = new Intent();
          ((Intent)localObject).putExtra("postUin", str);
          ((Intent)localObject).putExtra("sourceFrom", 1);
          if (i <= 1) {
            break label128;
          }
          bool = true;
          ((Intent)localObject).putExtra("has_shop", bool);
          ((Intent)localObject).addFlags(268435456);
          QZoneHelper.forwardToQQPublicAccountPublishPage(this.mMiniAppContext.getAttachedActivity(), (Intent)localObject, 0);
          paramRequestEvent.ok();
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("QQPublicAccountNativePlugin", 1, "Handle QQPublicAccountNativePlugin failed! ", localThrowable);
        paramRequestEvent.fail();
      }
      return;
      label128:
      boolean bool = false;
    }
  }
  
  @JsEvent({"qsubscribe_openhomepage"})
  public void qsubscribeOpenhomepage(RequestEvent paramRequestEvent)
  {
    try
    {
      Object localObject = a(paramRequestEvent).optJSONObject("data");
      if (localObject != null)
      {
        localObject = ((JSONObject)localObject).optString("uin");
        SubscribeLaucher.a(this.mMiniAppContext.getAttachedActivity(), (String)localObject, 9001);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QQPublicAccountNativePlugin", 1, "Handle QQPublicAccountNativePlugin failed! ", localThrowable);
      paramRequestEvent.fail();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.QQPublicAccountNativePlugin
 * JD-Core Version:    0.7.0.1
 */