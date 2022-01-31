package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class StoragePlugin$7
  implements StoragePlugin.StorageTask
{
  StoragePlugin$7(StoragePlugin paramStoragePlugin, String paramString1, JsRuntime paramJsRuntime, String paramString2, int paramInt) {}
  
  public String run()
  {
    String str = StorageUtil.getPreference().getString(this.val$key_real, "");
    if (!TextUtils.isEmpty(str)) {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("data", str);
        str = StoragePlugin.access$000(this.this$0, this.val$webview, this.val$event, localJSONObject, this.val$callbackId);
        return str;
      }
      catch (Exception localException)
      {
        QLog.e("[mini] StoragePlugin", 1, this.val$event + " result error." + localException);
        return StoragePlugin.access$100(this.this$0, this.val$webview, this.val$event, null, "json error", this.val$callbackId);
      }
    }
    return StoragePlugin.access$100(this.this$0, this.val$webview, this.val$event, null, "result is null", this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.StoragePlugin.7
 * JD-Core Version:    0.7.0.1
 */