package com.tencent.youtu.sdkkitframework.liveness;

import com.tencent.youtu.ytagreflectlivecheck.requester.RGBConfigRequester;
import com.tencent.youtu.ytagreflectlivecheck.requester.RGBConfigRequester.RGBConfigRequestCallBack;
import com.tencent.youtu.ytagreflectlivecheck.requester.RGBConfigRequester.RGBConfigRequestCallBackType;

class ReflectLivenessState$6
  implements RGBConfigRequester
{
  ReflectLivenessState$6(ReflectLivenessState paramReflectLivenessState) {}
  
  public void request(RGBConfigRequester.RGBConfigRequestCallBack paramRGBConfigRequestCallBack)
  {
    paramRGBConfigRequestCallBack.onSuccess(ReflectLivenessState.access$200(this.this$0), RGBConfigRequester.RGBConfigRequestCallBackType.RGB_OnlyRgbConfig);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.ReflectLivenessState.6
 * JD-Core Version:    0.7.0.1
 */