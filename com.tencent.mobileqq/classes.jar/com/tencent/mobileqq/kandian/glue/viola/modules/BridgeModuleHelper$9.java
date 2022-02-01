package com.tencent.mobileqq.kandian.glue.viola.modules;

import com.tencent.viola.bridge.ViolaBridgeManager;
import com.tencent.viola.core.ViolaInstance;
import org.json.JSONObject;

final class BridgeModuleHelper$9
  implements Runnable
{
  BridgeModuleHelper$9(boolean paramBoolean, BridgeModule paramBridgeModule, String paramString) {}
  
  public void run()
  {
    JSONObject localJSONObject = BridgeModuleHelper.b();
    if (this.a)
    {
      this.b.invokeCallJS(this.c, localJSONObject);
      return;
    }
    ViolaBridgeManager.getInstance().callbackJavascript(this.b.getViolaInstance().getInstanceId(), this.b.getModuleName(), "callback", this.c, localJSONObject, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModuleHelper.9
 * JD-Core Version:    0.7.0.1
 */