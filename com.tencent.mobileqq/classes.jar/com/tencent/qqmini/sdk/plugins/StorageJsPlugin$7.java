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
        localObject = new JSONObject();
        ((JSONObject)localObject).put("data", str);
        str = this.val$req.ok((JSONObject)localObject);
        return str;
      }
      catch (Exception localException)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.val$req.event);
        ((StringBuilder)localObject).append(" result error.");
        ((StringBuilder)localObject).append(localException);
        QMLog.e("StorageJsPlugin", ((StringBuilder)localObject).toString());
        return this.val$req.fail("json error");
      }
    }
    return this.val$req.fail("result is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.StorageJsPlugin.7
 * JD-Core Version:    0.7.0.1
 */