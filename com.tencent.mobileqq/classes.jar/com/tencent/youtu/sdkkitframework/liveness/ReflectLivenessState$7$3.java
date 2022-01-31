package com.tencent.youtu.sdkkitframework.liveness;

import com.tencent.youtu.ytagreflectlivecheck.requester.LightDiffResponse;
import java.util.HashMap;

class ReflectLivenessState$7$3
  extends HashMap<String, Object>
{
  ReflectLivenessState$7$3(ReflectLivenessState.7 param7, LightDiffResponse paramLightDiffResponse, String paramString)
  {
    put("ui_tips", "rst_failed");
    put("process_action", "failed");
    put("error_code", Integer.valueOf(4194304));
    put("error_reason_code", Integer.valueOf(this.val$lightDiffResponse.errorcode));
    put("message", this.val$info);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.ReflectLivenessState.7.3
 * JD-Core Version:    0.7.0.1
 */