package com.tencent.mobileqq.minigame.api;

import com.tencent.mobileqq.triton.sdk.ITSubPackage;

class APIProxyImpl$2$2
  implements Runnable
{
  APIProxyImpl$2$2(APIProxyImpl.2 param2, float paramFloat, long paramLong) {}
  
  public void run()
  {
    if (this.this$1.val$subPackageInterface != null) {
      this.this$1.val$subPackageInterface.onProgressChange(this.this$1.val$task, this.val$progress * 100.0F, ((float)this.val$totalSize * this.val$progress), this.val$totalSize);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.api.APIProxyImpl.2.2
 * JD-Core Version:    0.7.0.1
 */