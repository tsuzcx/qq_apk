package com.tencent.qqmini.sdk.plugins;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

class StorageJsPlugin$7
  implements StorageJsPlugin.StorageTask
{
  StorageJsPlugin$7(StorageJsPlugin paramStorageJsPlugin, String paramString, RequestEvent paramRequestEvent) {}
  
  public String run()
  {
    String str = StorageJsPlugin.access$100(this.this$0).getString(this.val$key_real, "");
    if (!TextUtils.isEmpty(str)) {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("data", str);
        str = this.val$req.ok(localJSONObject);
        return str;
      }
      catch (Exception localException)
      {
        QMLog.e("StorageJsPlugin", this.val$req.event + " result error." + localException);
        return this.val$req.fail("json error");
      }
    }
    return this.val$req.fail("result is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.StorageJsPlugin.7
 * JD-Core Version:    0.7.0.1
 */