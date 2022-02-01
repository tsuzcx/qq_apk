package com.tencent.open.business.base;

import com.tencent.open.base.LogUtility;
import org.json.JSONException;
import org.json.JSONObject;

class OpenConfig$1
  implements Runnable
{
  OpenConfig$1(OpenConfig paramOpenConfig) {}
  
  public void run()
  {
    Object localObject = this.this$0.a("com.tencent.open.config.json");
    try
    {
      this.this$0.a = new JSONObject((String)localObject);
      OpenConfig.a(this.this$0, true);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("config=");
      ((StringBuilder)localObject).append(this.this$0.a.toString());
      LogUtility.c("TAMST_WAKE", ((StringBuilder)localObject).toString());
      return;
    }
    catch (JSONException localJSONException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.business.base.OpenConfig.1
 * JD-Core Version:    0.7.0.1
 */