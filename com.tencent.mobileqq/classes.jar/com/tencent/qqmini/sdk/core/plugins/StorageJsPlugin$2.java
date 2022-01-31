package com.tencent.qqmini.sdk.core.plugins;

import bgiy;
import bgkd;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

class StorageJsPlugin$2
  implements StorageJsPlugin.StorageTask
{
  StorageJsPlugin$2(StorageJsPlugin paramStorageJsPlugin, String paramString, bgkd parambgkd) {}
  
  public String run()
  {
    String[] arrayOfString = StorageJsPlugin.access$000(this.this$0).a(this.val$key_real);
    JSONObject localJSONObject = new JSONObject();
    if (arrayOfString != null) {}
    try
    {
      if (arrayOfString.length == 2)
      {
        localJSONObject.put("data", arrayOfString[0]);
        localJSONObject.put("dataType", arrayOfString[1]);
      }
      for (;;)
      {
        return this.val$req.a(localJSONObject);
        localJSONObject.put("data", "");
        localJSONObject.put("dataType", "String");
      }
      return this.val$req.a("json error");
    }
    catch (Exception localException)
    {
      QMLog.e("StorageJsPlugin", this.val$req.a + " result error." + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.StorageJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */