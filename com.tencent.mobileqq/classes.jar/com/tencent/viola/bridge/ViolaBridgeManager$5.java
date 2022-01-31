package com.tencent.viola.bridge;

import android.text.TextUtils;
import com.tencent.viola.core.ViolaBridge;

class ViolaBridgeManager$5
  implements Runnable
{
  ViolaBridgeManager$5(ViolaBridgeManager paramViolaBridgeManager, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    ViolaBridge localViolaBridge = ViolaBridgeManager.access$100(this.this$0);
    String str2 = this.val$instanceId;
    byte[] arrayOfByte = this.val$template.getBytes();
    int i = this.val$template.getBytes().length;
    if (TextUtils.isEmpty(this.val$data)) {}
    for (String str1 = "";; str1 = this.val$data)
    {
      localViolaBridge.createInstance(str2, arrayOfByte, i, str1, "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.bridge.ViolaBridgeManager.5
 * JD-Core Version:    0.7.0.1
 */