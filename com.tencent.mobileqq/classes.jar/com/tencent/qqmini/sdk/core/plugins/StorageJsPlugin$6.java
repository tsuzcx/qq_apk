package com.tencent.qqmini.sdk.core.plugins;

import android.content.SharedPreferences;
import android.text.TextUtils;
import bekr;
import betc;
import org.json.JSONObject;

class StorageJsPlugin$6
  implements StorageJsPlugin.StorageTask
{
  StorageJsPlugin$6(StorageJsPlugin paramStorageJsPlugin, String paramString, bekr parambekr) {}
  
  public String run()
  {
    String str = StorageJsPlugin.access$100(this.this$0).getString(this.val$key_real, "");
    if (!TextUtils.isEmpty(str)) {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("data", str);
        str = this.val$req.a(localJSONObject);
        return str;
      }
      catch (Exception localException)
      {
        betc.d("StorageJsPlugin", this.val$req.a + " result error." + localException);
        return this.val$req.a("json error");
      }
    }
    return this.val$req.a("result is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.StorageJsPlugin.6
 * JD-Core Version:    0.7.0.1
 */