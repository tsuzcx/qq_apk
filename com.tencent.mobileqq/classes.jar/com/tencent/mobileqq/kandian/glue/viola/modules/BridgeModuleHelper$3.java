package com.tencent.mobileqq.kandian.glue.viola.modules;

import com.tencent.mobileqq.kandian.biz.push.api.IPushNotifyDialogCallback;
import org.json.JSONException;
import org.json.JSONObject;

final class BridgeModuleHelper$3
  implements IPushNotifyDialogCallback
{
  BridgeModuleHelper$3(BridgeModule paramBridgeModule, String paramString) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("button", paramInt1);
      localJSONObject.put("result", paramInt2);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    this.a.invokeJS(this.b, localJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModuleHelper.3
 * JD-Core Version:    0.7.0.1
 */