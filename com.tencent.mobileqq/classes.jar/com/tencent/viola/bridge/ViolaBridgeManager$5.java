package com.tencent.viola.bridge;

import android.text.TextUtils;
import com.tencent.viola.core.BridgeModeManager;
import com.tencent.viola.utils.ViolaLogUtils;

class ViolaBridgeManager$5
  implements Runnable
{
  ViolaBridgeManager$5(ViolaBridgeManager paramViolaBridgeManager, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void run()
  {
    ViolaLogUtils.e("ViolaBridgeManager", "violaInstance createInstanceImpl ViolaJSBridgeThread post start!");
    BridgeModeManager localBridgeModeManager = ViolaBridgeManager.access$100(this.this$0);
    String str2 = this.val$runtimeName;
    String str3 = this.val$instanceId;
    String str4 = this.val$template;
    String str1;
    if (TextUtils.isEmpty(this.val$data)) {
      str1 = "";
    } else {
      str1 = this.val$data;
    }
    localBridgeModeManager.createInstance(str2, str3, str4, str1, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.bridge.ViolaBridgeManager.5
 * JD-Core Version:    0.7.0.1
 */