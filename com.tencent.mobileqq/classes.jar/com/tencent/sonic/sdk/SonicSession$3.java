package com.tencent.sonic.sdk;

import java.util.concurrent.atomic.AtomicBoolean;

class SonicSession$3
  implements Runnable
{
  SonicSession$3(SonicSession paramSonicSession, SonicRuntime paramSonicRuntime) {}
  
  public void run()
  {
    if ((this.this$0.clientIsReady.get()) && (!this.this$0.isDestroyedOrWaitingForDestroy())) {
      this.val$runtime.showToast(this.this$0.config.USE_SONIC_CACHE_IN_BAD_NETWORK_TOAST, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.sonic.sdk.SonicSession.3
 * JD-Core Version:    0.7.0.1
 */