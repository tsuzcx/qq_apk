package com.tencent.mobileqq.kandian.glue.viola.modules;

import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class BridgeModule$1
  extends ReadInJoyObserver
{
  BridgeModule$1(BridgeModule paramBridgeModule) {}
  
  public void a(int paramInt, String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("result", paramInt);
      localJSONObject.put("errorMsg", paramString1);
      localJSONObject.put("extra", paramJSONObject);
    }
    catch (JSONException paramString1)
    {
      QLog.e("BridgeModule", 1, paramString1, new Object[] { "json put has exception" });
    }
    this.a.invokeCallJS(paramString2, localJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModule.1
 * JD-Core Version:    0.7.0.1
 */