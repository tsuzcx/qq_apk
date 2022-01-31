package com.tencent.youtu.sdkkitframework.liveness;

import java.util.HashMap;

class NetLivenessReqResultState$3
  extends HashMap<String, Object>
{
  NetLivenessReqResultState$3(NetLivenessReqResultState paramNetLivenessReqResultState, Exception paramException)
  {
    put("ui_action", "process_finished");
    put("ui_tips", "rst_failed");
    put("process_action", "failed");
    put("error_code", Integer.valueOf(2097153));
    put("message", this.val$error.getMessage());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.NetLivenessReqResultState.3
 * JD-Core Version:    0.7.0.1
 */