package com.tencent.mobileqq.mini.app;

import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class MiniAppClientQIPCModule$8
  implements MiniAppCmdInterface
{
  MiniAppClientQIPCModule$8(MiniAppClientQIPCModule paramMiniAppClientQIPCModule, BaseJsPluginEngine paramBaseJsPluginEngine, String paramString, int paramInt) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    Object localObject2 = new StringBuilder().append("createUpdatableMsg receive isSuc= ").append(paramBoolean).append(" ret=").append(String.valueOf(paramJSONObject)).append(", on ");
    Object localObject1;
    if (MiniAppClientQIPCModule.access$400(this.this$0)) {
      localObject1 = "miniGame";
    }
    for (;;)
    {
      QLog.i("MiniAppClientQIPCModule", 1, (String)localObject1);
      if (paramJSONObject == null) {
        break label238;
      }
      int i = paramJSONObject.optInt("retCode");
      localObject2 = paramJSONObject.optString("errMsg");
      localObject1 = new JSONObject();
      paramJSONObject = null;
      if (i == 0) {}
      try
      {
        ((JSONObject)localObject1).put("retCode", i);
        for (;;)
        {
          if (this.val$currentEngine == null) {
            break label229;
          }
          if (i != 0) {
            break label203;
          }
          this.val$currentEngine.callbackJsEventOK(this.val$currentEngine.getServiceRuntime(), this.val$event, (JSONObject)localObject1, this.val$callbackId);
          return;
          localObject1 = "miniApp";
          break;
          ((JSONObject)localObject1).put("retCode", 2);
          paramJSONObject = (String)localObject2 + "(" + i + ")";
        }
      }
      catch (Throwable paramJSONObject)
      {
        for (;;)
        {
          paramJSONObject.printStackTrace();
          paramJSONObject = null;
        }
        label203:
        this.val$currentEngine.callbackJsEventFail(this.val$currentEngine.getServiceRuntime(), this.val$event, (JSONObject)localObject1, paramJSONObject, this.val$callbackId);
        return;
      }
    }
    label229:
    QLog.i("MiniAppClientQIPCModule", 1, "createUpdatableMsg error, null jsPluginEngine");
    return;
    label238:
    QLog.i("MiniAppClientQIPCModule", 1, "createUpdatableMsg error, null ret");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.app.MiniAppClientQIPCModule.8
 * JD-Core Version:    0.7.0.1
 */