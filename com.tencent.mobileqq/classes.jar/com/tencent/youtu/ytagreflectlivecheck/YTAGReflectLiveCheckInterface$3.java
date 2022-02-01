package com.tencent.youtu.ytagreflectlivecheck;

import com.tencent.youtu.ytagreflectlivecheck.requester.LightDiffResponse;

final class YTAGReflectLiveCheckInterface$3
  implements Runnable
{
  YTAGReflectLiveCheckInterface$3(boolean paramBoolean, LightDiffResponse paramLightDiffResponse, String paramString) {}
  
  public void run()
  {
    YTAGReflectLiveCheckInterface.access$300().onSuccess(this.val$isAlive, this.val$lightDiffResponse, this.val$response);
    YTAGReflectLiveCheckInterface.access$302(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface.3
 * JD-Core Version:    0.7.0.1
 */