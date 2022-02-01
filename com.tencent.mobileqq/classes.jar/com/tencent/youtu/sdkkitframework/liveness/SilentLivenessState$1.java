package com.tencent.youtu.sdkkitframework.liveness;

import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import java.util.HashMap;

class SilentLivenessState$1
  extends HashMap<String, Object>
{
  SilentLivenessState$1(SilentLivenessState paramSilentLivenessState)
  {
    put("process_action", "failed");
    put("error_code", Integer.valueOf(5242881));
    put("message", CommonUtils.makeMessageJson(5242881, "msg_param_error", "Init YTFaceTrack SDK failed with "));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.SilentLivenessState.1
 * JD-Core Version:    0.7.0.1
 */