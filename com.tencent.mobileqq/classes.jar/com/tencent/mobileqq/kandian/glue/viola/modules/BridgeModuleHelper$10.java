package com.tencent.mobileqq.kandian.glue.viola.modules;

import org.json.JSONObject;

final class BridgeModuleHelper$10
  implements Runnable
{
  BridgeModuleHelper$10(BridgeModule paramBridgeModule, String paramString) {}
  
  public void run()
  {
    JSONObject localJSONObject = BridgeModuleHelper.c();
    BridgeModule localBridgeModule = this.a;
    if (localBridgeModule != null) {
      localBridgeModule.invokeCallJS(this.b, localJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModuleHelper.10
 * JD-Core Version:    0.7.0.1
 */