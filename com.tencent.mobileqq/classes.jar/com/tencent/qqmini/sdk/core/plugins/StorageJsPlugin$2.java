package com.tencent.qqmini.sdk.core.plugins;

import beix;
import bekr;
import betc;
import org.json.JSONObject;

class StorageJsPlugin$2
  implements StorageJsPlugin.StorageTask
{
  StorageJsPlugin$2(StorageJsPlugin paramStorageJsPlugin, String paramString, bekr parambekr) {}
  
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
      betc.d("StorageJsPlugin", this.val$req.a + " result error." + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.StorageJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */