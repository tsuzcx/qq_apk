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
    paramActionLivenessState = new StringBuilder();
    paramActionLivenessState.append("Init YtPose SDK failed with ");
    paramActionLivenessState.append(this.val$initR);
    put("message", CommonUtils.makeMessageJson(5242882, "msg_param_error", paramActionLivenessState.toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.ActionLivenessState.4
 * JD-Core Version:    0.7.0.1
 */