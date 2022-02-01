package com.tencent.youtu.sdkkitframework.liveness;

import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import java.util.HashMap;

class ReflectLivenessState$4
  extends HashMap<String, Object>
{
  ReflectLivenessState$4(ReflectLivenessState paramReflectLivenessState, int paramInt)
  {
    put("process_action", "failed");
    put("error_code", Integer.valueOf(5242883));
    put("message", CommonUtils.makeMessageJson(5242883, "msg_param_error", "Init YTReflect SDK failed with " + this.val$initR));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.ReflectLivenessState.4
 * JD-Core Version:    0.7.0.1
 */