package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.cache.Storage;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class StoragePlugin$3
  implements StoragePlugin.StorageTask
{
  StoragePlugin$3(StoragePlugin paramStoragePlugin, String paramString1, JsRuntime paramJsRuntime, String paramString2, int paramInt) {}
  
  public String run()
  {
    Object localObject1 = StoragePlugin.access$200(this.this$0).read(this.val$key_real);
    Object localObject2 = new JSONObject();
    if (localObject1 != null) {}
    try
    {
      if (localObject1.length == 2)
      {
        ((JSONObject)localObject2).put("data", localObject1[0]);
        ((JSONObject)localObject2).put("dataType", localObject1[1]);
        return StoragePlugin.access$000(this.this$0, this.val$webview, this.val$event, (JSONObject)localObject2, this.val$callbackId);
      }
      localObject2 = this.this$0;
      JsRuntime localJsRuntime = this.val$webview;
      String str = this.val$event;
      if (localObject1 == null) {}
      for (localObject1 = "data is null";; localObject1 = "data error") {
        return StoragePlugin.access$100((StoragePlugin)localObject2, localJsRuntime, str, null, (String)localObject1, this.val$callbackId);
      }
      return StoragePlugin.access$100(this.this$0, this.val$webview, this.val$event, null, "json error", this.val$callbackId);
    }
    catch (Exception localException)
    {
      QLog.e("[mini] StoragePlugin", 1, this.val$event + " result error." + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.StoragePlugin.3
 * JD-Core Version:    0.7.0.1
 */