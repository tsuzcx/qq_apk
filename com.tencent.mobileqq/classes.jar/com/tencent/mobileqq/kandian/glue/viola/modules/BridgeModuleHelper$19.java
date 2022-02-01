package com.tencent.mobileqq.kandian.glue.viola.modules;

import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionCallback;

final class BridgeModuleHelper$19
  implements QQPermissionCallback
{
  BridgeModuleHelper$19(BridgeModule paramBridgeModule, String paramString1, String paramString2) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.d("BridgeModuleHelper", 1, "deny lbs permission");
    BridgeModuleHelper.b(this.a, this.c, "no authroized");
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    BridgeModuleHelper.a(this.a, this.b, this.c);
    QLog.d("BridgeModuleHelper", 1, "grant lbs permission");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModuleHelper.19
 * JD-Core Version:    0.7.0.1
 */