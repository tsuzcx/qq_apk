package com.tencent.viola.bridge;

import com.tencent.viola.core.ViolaBridge;

class ViolaBridgeManager$2
  implements Runnable
{
  ViolaBridgeManager$2(ViolaBridgeManager paramViolaBridgeManager, String paramString1, String paramString2) {}
  
  public void run()
  {
    ViolaBridgeManager.access$100(this.this$0).execJSFunc(this.val$callBackFunctionName, this.val$arg.getBytes(), this.val$arg.getBytes().length);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.bridge.ViolaBridgeManager.2
 * JD-Core Version:    0.7.0.1
 */