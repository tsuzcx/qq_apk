package eipc;

import android.os.Bundle;

class EIPCModuleManager$1$1
  implements Runnable
{
  EIPCModuleManager$1$1(EIPCModuleManager.1 param1, EIPCModule paramEIPCModule, String paramString, Bundle paramBundle, int paramInt) {}
  
  public void run()
  {
    this.val$finalModule.onCall(this.val$action, this.val$params, this.val$encodeCallbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     eipc.EIPCModuleManager.1.1
 * JD-Core Version:    0.7.0.1
 */