package com.tencent.mobileqq.kandian.glue.viola.modules;

import com.tencent.mobileqq.kandian.glue.viola.ViolaAccessHelper.ViolaSdkPermitlistener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

final class BridgeModuleHelper$6
  implements ViolaAccessHelper.ViolaSdkPermitlistener
{
  BridgeModuleHelper$6(BridgeModule paramBridgeModule, String paramString) {}
  
  public void a()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("result", false);
      this.a.invokeCallJS(this.b, localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("canOpenPage error");
        localStringBuilder.append(localException.getMessage());
        QLog.e("BridgeModuleHelper", 2, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModuleHelper.6
 * JD-Core Version:    0.7.0.1
 */