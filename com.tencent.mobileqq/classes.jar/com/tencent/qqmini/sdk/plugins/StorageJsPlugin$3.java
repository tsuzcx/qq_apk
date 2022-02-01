package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.cache.Storage;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

class StorageJsPlugin$3
  implements StorageJsPlugin.StorageTask
{
  StorageJsPlugin$3(StorageJsPlugin paramStorageJsPlugin, String paramString, RequestEvent paramRequestEvent) {}
  
  public String run()
  {
    Object localObject1 = StorageJsPlugin.access$000(this.this$0).read(this.val$key_real);
    Object localObject2 = new JSONObject();
    if (localObject1 != null) {}
    for (;;)
    {
      try
      {
        if (localObject1.length == 2)
        {
          ((JSONObject)localObject2).put("data", localObject1[0]);
          ((JSONObject)localObject2).put("dataType", localObject1[1]);
          return this.val$req.ok((JSONObject)localObject2);
        }
        localObject2 = this.val$req;
        if (localObject1 == null)
        {
          localObject1 = "data is null";
          localObject1 = ((RequestEvent)localObject2).fail((String)localObject1);
          return localObject1;
        }
      }
      catch (Exception localException)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.val$req.event);
        ((StringBuilder)localObject2).append(" result error.");
        ((StringBuilder)localObject2).append(localException);
        QMLog.e("StorageJsPlugin", ((StringBuilder)localObject2).toString());
        return this.val$req.fail("json error");
      }
      String str = "data error";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.StorageJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */