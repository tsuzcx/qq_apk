package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.mini.out.activity.MapActivity;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.util.ApiUtil.OnLocationFinish;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;
import org.json.JSONObject;

public class MapJsPlugin
  extends BaseJsPlugin
{
  public static final String LOCATION_TYPE_02 = "gcj02";
  public static final String LOCATION_TYPE_84 = "wgs84";
  private static final Set<String> S_EVENT_MAP = new MapJsPlugin.1();
  private static final String TAG = "MapJsPlugin";
  
  public void getLocationJsonObject(Context paramContext, String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt, String paramString3, ApiUtil.OnLocationFinish paramOnLocationFinish)
  {
    if (paramContext == null)
    {
      QLog.e("MapJsPlugin", 1, "getLocationJsonObject context is null, return.");
      this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, ":invalid data", paramInt);
      return;
    }
    if ((!"gcj02".equals(paramString2)) && (!"wgs84".equals(paramString2)))
    {
      QLog.e("MapJsPlugin", 1, "getLocationJsonObject type is not support.");
      this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, ":invalid data,type error", paramInt);
      return;
    }
    boolean bool1;
    if ((TextUtils.isEmpty(paramString2)) || (paramString2.equals("wgs84")))
    {
      bool1 = true;
      if (TextUtils.isEmpty(paramString3)) {
        break label139;
      }
    }
    label139:
    for (boolean bool2 = true;; bool2 = false)
    {
      SosoInterface.a(new MapJsPlugin.4(this, 0, true, true, 5000L, false, false, "miniApp", bool1, bool2, paramOnLocationFinish, paramJsRuntime, paramString1, paramInt));
      return;
      bool1 = false;
      break;
    }
  }
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    QLog.d("MapJsPlugin", 2, "handleNativeRequest event=" + paramString1 + ",jsonParams=" + paramString2 + ",callbackId=" + paramInt + ",webview=" + paramJsRuntime);
    Object localObject;
    if ("getLocation".equals(paramString1)) {
      try
      {
        localObject = new JSONObject(paramString2);
        paramString2 = ((JSONObject)localObject).optString("type");
        localObject = ((JSONObject)localObject).optString("altitude");
        getLocationJsonObject(this.jsPluginEngine.getActivityContext(), paramString1, paramString2, paramJsRuntime, paramInt, (String)localObject, new MapJsPlugin.2(this, paramJsRuntime, paramString1, paramInt));
        return "";
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          QLog.e("MapJsPlugin", 1, paramString1 + " error, ", paramString2);
          this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, paramInt);
        }
      }
    }
    if ("openLocation".equals(paramString1)) {
      try
      {
        localObject = new JSONObject(paramString2);
        double d1 = ((JSONObject)localObject).optDouble("latitude");
        double d2 = ((JSONObject)localObject).optDouble("longitude");
        int i = ((JSONObject)localObject).optInt("scale", 18);
        paramString2 = ((JSONObject)localObject).optString("name");
        localObject = ((JSONObject)localObject).optString("address");
        Intent localIntent = new Intent(this.jsPluginEngine.getActivityContext(), MapActivity.class);
        localIntent.putExtra("key_type", 1);
        localIntent.putExtra("latitude", d1);
        localIntent.putExtra("longitude", d2);
        localIntent.putExtra("scale", i);
        localIntent.putExtra("name", paramString2);
        localIntent.putExtra("address", (String)localObject);
        this.jsPluginEngine.getActivityContext().startActivity(localIntent);
        this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString1, null, paramInt);
        return "";
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          QLog.e("MapJsPlugin", 1, paramString1 + " error, ", paramString2);
          this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, paramInt);
        }
      }
    }
    if ("chooseLocation".equals(paramString1))
    {
      MiniAppController.getInstance().setActivityResultListener(new MapJsPlugin.3(this, paramJsRuntime, paramString1, paramInt));
      paramString1 = new Intent(this.jsPluginEngine.getActivityContext(), MapActivity.class);
      paramString1.putExtra("key_type", 2);
      this.jsPluginEngine.getActivityContext().startActivityForResult(paramString1, 3);
    }
    return "";
  }
  
  @NonNull
  public Set<String> supportedEvents()
  {
    return S_EVENT_MAP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.MapJsPlugin
 * JD-Core Version:    0.7.0.1
 */