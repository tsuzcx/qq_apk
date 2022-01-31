package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.content.Intent;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.sdk.MiniAppController.ActivityResultListener;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class MapJsPlugin$3
  implements MiniAppController.ActivityResultListener
{
  MapJsPlugin$3(MapJsPlugin paramMapJsPlugin, JsRuntime paramJsRuntime, String paramString, int paramInt) {}
  
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    QLog.d("MapJsPlugin", 2, "doOnActivityResult requestCode=" + paramInt1 + ",resultCode=" + paramInt2 + ",data=" + paramIntent);
    if (paramInt1 == 3)
    {
      String str1;
      String str2;
      double d1;
      double d2;
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        str1 = paramIntent.getStringExtra("name");
        str2 = paramIntent.getStringExtra("address");
        d1 = paramIntent.getIntExtra("latitude", 0) / 1000000.0D;
        d2 = paramIntent.getIntExtra("longitude", 0) / 1000000.0D;
        if (QLog.isColorLevel()) {
          QLog.d("MapJsPlugin", 2, "doOnActivityResult name=" + str1 + ",address=" + str2 + ",latitude=" + d1 + ",longitude=" + d2);
        }
        paramIntent = new JSONObject();
      }
      try
      {
        paramIntent.put("name", str1);
        paramIntent.put("address", str2);
        paramIntent.put("latitude", d1);
        paramIntent.put("longitude", d2);
        this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$eventName, paramIntent, this.val$callbackId);
        MiniAppController.getInstance().removeActivityResultListener(this);
        return true;
      }
      catch (JSONException paramIntent)
      {
        for (;;)
        {
          QLog.e("MapJsPlugin", 1, this.val$eventName + " error, ", paramIntent);
          this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$eventName, null, this.val$callbackId);
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.MapJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */