package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import bhos;
import com.tencent.mobileqq.mini.cache.Storage;
import com.tencent.mobileqq.mini.cache.Util;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

class StoragePlugin$4
  implements StoragePlugin.StorageTask
{
  StoragePlugin$4(StoragePlugin paramStoragePlugin, JsRuntime paramJsRuntime, String paramString, int paramInt) {}
  
  public String run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("limitSize", StoragePlugin.access$200(this.this$0).getLimitSize());
      localJSONObject.put("currentSize", StoragePlugin.access$200(this.this$0).getCurrentSize());
      Object localObject = StoragePlugin.access$200(this.this$0).keys();
      HashSet localHashSet = new HashSet();
      if (localObject != null)
      {
        localObject = ((Set)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          localHashSet.add(bhos.b((String)((Iterator)localObject).next()));
        }
      }
      localException.put("keys", Util.setToJSONArray(localHashSet));
    }
    catch (Exception localException)
    {
      QLog.e("[mini] StoragePlugin", 1, this.val$event + " result error." + localException);
      return StoragePlugin.access$100(this.this$0, this.val$webview, this.val$event, null, "json error", this.val$callbackId);
    }
    String str = StoragePlugin.access$000(this.this$0, this.val$webview, this.val$event, localException, this.val$callbackId);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.StoragePlugin.4
 * JD-Core Version:    0.7.0.1
 */