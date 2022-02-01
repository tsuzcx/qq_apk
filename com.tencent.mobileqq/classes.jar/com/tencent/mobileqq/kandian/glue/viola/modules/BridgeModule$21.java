package com.tencent.mobileqq.kandian.glue.viola.modules;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.tools.MemoryInfoRecordHelper;
import org.json.JSONObject;

class BridgeModule$21
  implements Runnable
{
  BridgeModule$21(BridgeModule paramBridgeModule, String paramString) {}
  
  public void run()
  {
    try
    {
      String str = MemoryInfoRecordHelper.c();
      localObject = new JSONObject();
      ((JSONObject)localObject).put("vmSizeInfo", str);
      this.this$0.invokeCallJS(this.a, localObject);
      return;
    }
    catch (Exception localException)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getVMSize error: ");
      ((StringBuilder)localObject).append(localException.getMessage());
      QLog.e("BridgeModule", 1, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModule.21
 * JD-Core Version:    0.7.0.1
 */