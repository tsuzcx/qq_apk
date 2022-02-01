package com.tencent.youtu.sdkkitframework.liveness;

import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface.LightLiveCheckResult;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.FullPack;

class ReflectLivenessState$11
  implements YTAGReflectLiveCheckInterface.LightLiveCheckResult
{
  ReflectLivenessState$11(ReflectLivenessState paramReflectLivenessState) {}
  
  public void onFailed(int paramInt, String paramString1, String paramString2)
  {
    ReflectLivenessState.access$400(this.this$0, paramInt, paramString1, paramString2);
  }
  
  public void onSuccess(FullPack paramFullPack)
  {
    YtLogger.i(ReflectLivenessState.access$200(), "on start succeed!!!!!");
    ReflectLivenessState.access$300(this.this$0, paramFullPack);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.ReflectLivenessState.11
 * JD-Core Version:    0.7.0.1
 */