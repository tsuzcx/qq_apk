package com.tencent.mobileqq.mini.out.nativePlugins;

import aaak;
import aaej;
import acwb;
import acwc;
import acwd;
import android.content.Intent;
import bmtd;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin.JSContext;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
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
  
  public void onInvoke(JSONObject paramJSONObject, NativePlugin.JSContext paramJSContext)
  {
    boolean bool = true;
    if (paramJSContext != null) {
      aaak.a().a(paramJSContext);
    }
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = paramJSONObject.optString("api_name");
        int i;
        if ("qsubscribe_opendiscover".equals(localObject))
        {
          localObject = paramJSONObject.optJSONObject("data");
          if (localObject == null) {
            break label416;
          }
          paramJSONObject = ((JSONObject)localObject).optString("uin");
          i = ((JSONObject)localObject).optInt("shoptype");
          localObject = new Intent();
          ((Intent)localObject).putExtra("postUin", paramJSONObject);
          ((Intent)localObject).putExtra("sourceFrom", 1);
          if (i <= 1) {
            break label417;
          }
          ((Intent)localObject).putExtra("has_shop", bool);
          ((Intent)localObject).addFlags(268435456);
          bmtd.a(paramJSContext.getActivity(), (Intent)localObject, 0);
          paramJSContext.evaluateCallback(true, null, "");
          return;
        }
        if ("qsubscribe_opendetail".equals(localObject))
        {
          paramJSONObject = paramJSONObject.optJSONObject("data");
          if (paramJSONObject == null) {
            break label416;
          }
          localObject = paramJSONObject.optString("uin");
          i = paramJSONObject.optInt("type");
          String str = paramJSONObject.optString("feedid");
          long l = paramJSONObject.optLong("createtime");
          paramJSONObject = aaej.a(str, (String)localObject, i, paramJSONObject.optInt("width"), paramJSONObject.optInt("height"), l);
          aaej.a(paramJSContext.getActivity(), paramJSONObject, 9001);
          return;
        }
      }
      catch (Throwable paramJSONObject)
      {
        QLog.e("QQPublicAccountNativePlugin", 2, "Handle QQPublicAccountNativePlugin failed! " + QLog.getStackTraceString(paramJSONObject));
        paramJSContext.evaluateCallback(false, null, "parse param error!");
        return;
      }
      if ("qsubscribe_openhomepage".equals(localObject))
      {
        paramJSONObject = paramJSONObject.optJSONObject("data");
        if (paramJSONObject != null)
        {
          paramJSONObject = paramJSONObject.optString("uin");
          aaej.a(paramJSContext.getActivity(), paramJSONObject, 9001);
        }
      }
      else if ("qsubscribe_getdeviceinfo".equals(localObject))
      {
        paramJSONObject = new acwc();
        paramJSONObject.a = "1b0ad2";
        paramJSONObject = acwb.a(BaseApplication.getContext(), paramJSONObject);
        if ((paramJSONObject != null) && (paramJSONObject.a != null))
        {
          localObject = new vac_adv_get.VacFeedsAdvMetaReq();
          ((vac_adv_get.VacFeedsAdvMetaReq)localObject).device_info.set(paramJSONObject.a);
          paramJSONObject = Arrays.toString(((vac_adv_get.VacFeedsAdvMetaReq)localObject).toByteArray());
          localObject = new JSONObject();
          ((JSONObject)localObject).put("deviceinfo", paramJSONObject);
          paramJSContext.evaluateCallback(true, (JSONObject)localObject, "");
          return;
          QLog.e("QQPublicAccountNativePlugin", 2, "Handle QQPublicAccountNativePlugin failed! jsContext is null!  ");
        }
      }
      label416:
      return;
      label417:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.nativePlugins.QQPublicAccountNativePlugin
 * JD-Core Version:    0.7.0.1
 */