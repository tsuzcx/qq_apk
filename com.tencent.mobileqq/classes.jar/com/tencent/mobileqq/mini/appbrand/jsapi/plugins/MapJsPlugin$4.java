package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import akgd;
import android.util.Log;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.mini.util.ApiUtil.OnLocationFinish;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class MapJsPlugin$4
  extends akgd
{
  MapJsPlugin$4(MapJsPlugin paramMapJsPlugin, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString1, boolean paramBoolean5, boolean paramBoolean6, ApiUtil.OnLocationFinish paramOnLocationFinish, JsRuntime paramJsRuntime, String paramString2, int paramInt2)
  {
    super(paramInt1, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString1);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if ((paramInt == 0) && (paramSosoLbsInfo != null))
    {
      paramSosoLbsInfo = paramSosoLbsInfo.a;
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if ((this.val$isWgs84) && (paramSosoLbsInfo.c != 0.0D) && (paramSosoLbsInfo.d != 0.0D))
        {
          localJSONObject.put("latitude", paramSosoLbsInfo.c);
          localJSONObject.put("longitude", paramSosoLbsInfo.d);
        }
        for (;;)
        {
          localJSONObject.put("speed", paramSosoLbsInfo.jdField_b_of_type_Float);
          localJSONObject.put("accuracy", paramSosoLbsInfo.jdField_a_of_type_Float);
          if (this.val$needAltitude) {
            localJSONObject.put("altitude", paramSosoLbsInfo.e);
          }
          localJSONObject.put("verticalAccuracy", 0.0D);
          localJSONObject.put("horizontalAccuracy", paramSosoLbsInfo.jdField_a_of_type_Float);
          this.val$onLocationFinish.onLocationFinishCallback(localJSONObject);
          return;
          localJSONObject.put("latitude", paramSosoLbsInfo.jdField_a_of_type_Double);
          localJSONObject.put("longitude", paramSosoLbsInfo.jdField_b_of_type_Double);
        }
        paramSosoLbsInfo = new JSONObject();
      }
      catch (JSONException paramSosoLbsInfo)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MapJsPlugin", 2, paramSosoLbsInfo, new Object[0]);
        }
        this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$eventName, null, this.val$callbackId);
        return;
      }
    }
    try
    {
      paramSosoLbsInfo.put("errCode", paramInt);
      this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$eventName, paramSosoLbsInfo, this.val$callbackId);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("MapJsPlugin", 1, new Object[] { "getLocationJsonObject exception:", Log.getStackTraceString(localJSONException) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.MapJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */