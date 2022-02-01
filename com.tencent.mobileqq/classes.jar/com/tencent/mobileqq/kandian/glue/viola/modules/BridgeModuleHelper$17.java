package com.tencent.mobileqq.kandian.glue.viola.modules;

import android.app.Activity;
import android.content.Context;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Params;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Result;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.bridge.ViolaBridgeManager;
import com.tencent.viola.core.ViolaInstance;
import org.json.JSONException;
import org.json.JSONObject;

final class BridgeModuleHelper$17
  implements Runnable
{
  BridgeModuleHelper$17(JSONObject paramJSONObject, boolean paramBoolean, BridgeModule paramBridgeModule, String paramString) {}
  
  public void run()
  {
    if (BridgeModuleHelper.e() == null) {
      return;
    }
    QLog.d("BridgeModuleHelper", 2, "getGdtDeviceInfo callback result");
    Object localObject = BridgeModuleHelper.e().getApplicationContext();
    JSONObject localJSONObject2 = new JSONObject();
    JSONObject localJSONObject1 = null;
    GdtDeviceInfoHelper.Params localParams = new GdtDeviceInfoHelper.Params();
    localParams.a = this.a.optString("businessIdForAidTicketAndTaidTicket", "ce2d9f");
    localObject = GdtDeviceInfoHelper.a((Context)localObject, localParams);
    if (localObject != null)
    {
      localObject = ((GdtDeviceInfoHelper.Result)localObject).a;
      if (localObject != null)
      {
        localObject = GdtJsonPbUtil.a((PBField)localObject);
        if ((localObject != null) && ((localObject instanceof JSONObject))) {
          localJSONObject1 = (JSONObject)localObject;
        }
      }
    }
    if ((localJSONObject1 != null) && (localJSONObject1 != JSONObject.NULL)) {
      try
      {
        localJSONObject2.put("deviceInfo", localJSONObject1);
      }
      catch (JSONException localJSONException)
      {
        GdtLog.d("BridgeModuleHelper", "handleJsCallRequest", localJSONException);
      }
    } else {
      GdtLog.d("BridgeModuleHelper", "handleJsCallRequest error");
    }
    if (this.b)
    {
      this.c.invokeCallJS(this.d, localJSONObject2);
      return;
    }
    ViolaBridgeManager.getInstance().callbackJavascript(this.c.getViolaInstance().getInstanceId(), this.c.getModuleName(), "callback", this.d, localJSONObject2, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModuleHelper.17
 * JD-Core Version:    0.7.0.1
 */