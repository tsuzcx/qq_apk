package com.tencent.open.business.base;

import org.json.JSONException;
import org.json.JSONObject;

class OpenConfig$1
  implements Runnable
{
  OpenConfig$1(OpenConfig paramOpenConfig) {}
  
  public void run()
  {
    String str = this.this$0.a("com.tencent.open.config.json");
    try
    {
      this.this$0.a = new JSONObject(str);
      OpenConfig.a(this.this$0, true);
      return;
    }
    catch (JSONException localJSONException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.business.base.OpenConfig.1
 * JD-Core Version:    0.7.0.1
 */