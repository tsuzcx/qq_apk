package com.tencent.youtu.sdkkitframework.liveness;

import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import java.util.HashMap;

class ActionLivenessState$4
  extends HashMap<String, Object>
{
  ActionLivenessState$4(ActionLivenessState paramActionLivenessState, int paramInt)
  {
    put("process_action", "failed");
    put("error_code", Integer.valueOf(5242882));
    put("message", CommonUtils.makeMessageJson(5242882, "msg_param_error", "Init YtPose SDK failed with " + this.val$initR));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.ActionLivenessState.4
 * JD-Core Version:    0.7.0.1
 */