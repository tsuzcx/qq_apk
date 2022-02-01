package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.cache.DiskLruCacheUtil;
import com.tencent.qqmini.sdk.cache.Storage;
import com.tencent.qqmini.sdk.core.utils.URLUtil;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

class StorageJsPlugin$4
  implements StorageJsPlugin.StorageTask
{
  StorageJsPlugin$4(StorageJsPlugin paramStorageJsPlugin, RequestEvent paramRequestEvent) {}
  
  public String run()
  {
    try
    {
      Object localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("limitSize", StorageJsPlugin.access$000(this.this$0).getLimitSize());
      ((JSONObject)localObject1).put("currentSize", StorageJsPlugin.access$000(this.this$0).getCurrentSize());
      Object localObject3 = StorageJsPlugin.access$000(this.this$0).keys();
      localObject2 = new HashSet();
      if (localObject3 != null)
      {
        localObject3 = ((Set)localObject3).iterator();
        while (((Iterator)localObject3).hasNext()) {
          ((Set)localObject2).add(URLUtil.decodeUrl((String)((Iterator)localObject3).next()));
        }
      }
      ((JSONObject)localObject1).put("keys", DiskLruCacheUtil.setToJSONArray((Set)localObject2));
      localObject1 = this.val$req.ok((JSONObject)localObject1);
      return localObject1;
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.val$req.event);
      ((StringBuilder)localObject2).append(" result error.");
      ((StringBuilder)localObject2).append(localException);
      QMLog.e("StorageJsPlugin", ((StringBuilder)localObject2).toString());
    }
    return this.val$req.fail("json error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.StorageJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */