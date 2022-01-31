package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import absf;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

class DataJsPlugin$26$1
  implements absf
{
  DataJsPlugin$26$1(DataJsPlugin.26 param26) {}
  
  public void onComplete()
  {
    this.this$1.val$callback.onComplete();
  }
  
  public void onFailure(int paramInt, String paramString)
  {
    synchronized (DataJsPlugin.access$200(this.this$1.this$0))
    {
      DataJsPlugin.access$302(this.this$1.this$0, Long.valueOf(0L));
      Iterator localIterator = DataJsPlugin.access$200(this.this$1.this$0).iterator();
      if (localIterator.hasNext()) {
        ((absf)localIterator.next()).onFailure(paramInt, paramString);
      }
    }
    DataJsPlugin.access$200(this.this$1.this$0).clear();
  }
  
  public void onPermission(int paramInt)
  {
    synchronized (DataJsPlugin.access$200(this.this$1.this$0))
    {
      DataJsPlugin.access$302(this.this$1.this$0, Long.valueOf(0L));
      Iterator localIterator = DataJsPlugin.access$200(this.this$1.this$0).iterator();
      if (localIterator.hasNext()) {
        ((absf)localIterator.next()).onPermission(paramInt);
      }
    }
    DataJsPlugin.access$200(this.this$1.this$0).clear();
  }
  
  public void onSuccess(JSONObject paramJSONObject)
  {
    synchronized (DataJsPlugin.access$200(this.this$1.this$0))
    {
      DataJsPlugin.access$302(this.this$1.this$0, Long.valueOf(0L));
      Iterator localIterator = DataJsPlugin.access$200(this.this$1.this$0).iterator();
      if (localIterator.hasNext()) {
        ((absf)localIterator.next()).onSuccess(paramJSONObject);
      }
    }
    DataJsPlugin.access$200(this.this$1.this$0).clear();
  }
  
  public void onTrigger(JSONObject paramJSONObject)
  {
    this.this$1.val$callback.onTrigger(paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.DataJsPlugin.26.1
 * JD-Core Version:    0.7.0.1
 */