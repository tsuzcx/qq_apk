package com.tencent.mobileqq.kandian.glue.viola.modules;

import com.tencent.mobileqq.startup.step.CheckPermission.SDCardPermissionCallback;
import org.json.JSONObject;

final class BridgeModuleHelper$13
  implements CheckPermission.SDCardPermissionCallback
{
  BridgeModuleHelper$13(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString) {}
  
  public void a()
  {
    BridgeModuleHelper.v(this.a, this.b, this.c);
  }
  
  public void b()
  {
    this.a.invokeErrorCallJS(this.c, "saveImage reject Permission");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModuleHelper.13
 * JD-Core Version:    0.7.0.1
 */