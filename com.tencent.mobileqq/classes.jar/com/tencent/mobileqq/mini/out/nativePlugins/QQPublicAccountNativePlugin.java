package com.tencent.mobileqq.mini.out.nativePlugins;

import android.content.Intent;
import com.tencent.biz.subscribe.SubscribeLaucher;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Params;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Result;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.JSContext;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.vip.pb.vac_adv_get.VacFeedsAdvMetaReq;
import java.util.Arrays;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;

public class QQPublicAccountNativePlugin
  implements NativePlugin
{
  private static final String API_NAME = "api_name";
  public static final String API_OSUBSCRIBE_GET_DEVICE_INFO = "qsubscribe_getdeviceinfo";
  public static final String API_QSUBSCRIBE_OPEN_DETAIL = "qsubscribe_opendetail";
  public static final String API_QSUBSCRIBE_OPEN_DISCOVER = "qsubscribe_opendiscover";
  public static final String API_QSUBSCRIBE_OPEN_HOMEPAGE = "qsubscribe_openhomepage";
  private static final String DATA = "data";
  public static final String TAG = "QQPublicAccountNativePlugin";
  
  public void onDestroy() {}
  
  public void onInvoke(JSONObject paramJSONObject, JSContext paramJSContext)
  {
    if (paramJSContext != null) {}
    for (;;)
    {
      try
      {
        localObject = paramJSONObject.optString("api_name");
        bool = "qsubscribe_opendiscover".equals(localObject);
        int i;
        if (bool)
        {
          localObject = paramJSONObject.optJSONObject("data");
          if (localObject == null) {
            break label426;
          }
          paramJSONObject = ((JSONObject)localObject).optString("uin");
          i = ((JSONObject)localObject).optInt("shoptype");
          localObject = new Intent();
          ((Intent)localObject).putExtra("postUin", paramJSONObject);
          ((Intent)localObject).putExtra("sourceFrom", 1);
          if (i <= 1) {
            break label427;
          }
          bool = true;
          ((Intent)localObject).putExtra("has_shop", bool);
          ((Intent)localObject).addFlags(268435456);
          QZoneHelper.forwardToQQPublicAccountPublishPage(paramJSContext.getActivity(), (Intent)localObject, 0);
          paramJSContext.evaluateCallback(true, null, "");
          return;
        }
        if ("qsubscribe_opendetail".equals(localObject))
        {
          paramJSONObject = paramJSONObject.optJSONObject("data");
          if (paramJSONObject == null) {
            break label426;
          }
          localObject = paramJSONObject.optString("uin");
          i = paramJSONObject.optInt("type");
          String str = paramJSONObject.optString("feedid");
          long l = paramJSONObject.optLong("createtime");
          paramJSONObject = SubscribeLaucher.a(str, (String)localObject, i, paramJSONObject.optInt("width"), paramJSONObject.optInt("height"), l);
          SubscribeLaucher.a(paramJSContext.getActivity(), paramJSONObject, 9001);
          return;
        }
        if ("qsubscribe_openhomepage".equals(localObject))
        {
          paramJSONObject = paramJSONObject.optJSONObject("data");
          if (paramJSONObject == null) {
            break label426;
          }
          paramJSONObject = paramJSONObject.optString("uin");
          SubscribeLaucher.a(paramJSContext.getActivity(), paramJSONObject, 9001);
          return;
        }
        if (!"qsubscribe_getdeviceinfo".equals(localObject)) {
          break label426;
        }
        paramJSONObject = new GdtDeviceInfoHelper.Params();
        paramJSONObject.a = "1b0ad2";
        paramJSONObject = GdtDeviceInfoHelper.a(BaseApplication.getContext(), paramJSONObject);
        if ((paramJSONObject == null) || (paramJSONObject.a == null)) {
          break label426;
        }
        localObject = new vac_adv_get.VacFeedsAdvMetaReq();
        ((vac_adv_get.VacFeedsAdvMetaReq)localObject).device_info.set(paramJSONObject.a);
        paramJSONObject = Arrays.toString(((vac_adv_get.VacFeedsAdvMetaReq)localObject).toByteArray());
        localObject = new JSONObject();
        ((JSONObject)localObject).put("deviceinfo", paramJSONObject);
        paramJSContext.evaluateCallback(true, (JSONObject)localObject, "");
        return;
      }
      catch (Throwable paramJSONObject)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Handle QQPublicAccountNativePlugin failed! ");
        ((StringBuilder)localObject).append(QLog.getStackTraceString(paramJSONObject));
        QLog.e("QQPublicAccountNativePlugin", 2, ((StringBuilder)localObject).toString());
        paramJSContext.evaluateCallback(false, null, "parse param error!");
        return;
      }
      QLog.e("QQPublicAccountNativePlugin", 2, "Handle QQPublicAccountNativePlugin failed! jsContext is null!  ");
      label426:
      return;
      label427:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.nativePlugins.QQPublicAccountNativePlugin
 * JD-Core Version:    0.7.0.1
 */