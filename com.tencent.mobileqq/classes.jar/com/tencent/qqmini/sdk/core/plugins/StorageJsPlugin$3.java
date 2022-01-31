package com.tencent.qqmini.sdk.core.plugins;

import beif;
import beig;
import beka;
import beli;
import besl;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

class StorageJsPlugin$3
  implements StorageJsPlugin.StorageTask
{
  StorageJsPlugin$3(StorageJsPlugin paramStorageJsPlugin, beka parambeka) {}
  
  public String run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("limitSize", StorageJsPlugin.access$000(this.this$0).a());
      localJSONObject.put("currentSize", StorageJsPlugin.access$000(this.this$0).a());
      Object localObject = StorageJsPlugin.access$000(this.this$0).a();
      HashSet localHashSet = new HashSet();
      if (localObject != null)
      {
        localObject = ((Set)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          localHashSet.add(beli.b((String)((Iterator)localObject).next()));
        }
      }
      localException.put("keys", beif.a(localHashSet));
    }
    catch (Exception localException)
    {
      besl.d("StorageJsPlugin", this.val$req.a + " result error." + localException);
      return this.val$req.a("json error");
    }
    String str = this.val$req.a(localException);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.StorageJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */