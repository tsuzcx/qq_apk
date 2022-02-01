package com.tencent.youtu.sdkkitframework.liveness;

import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import java.util.HashMap;

class NetLivenessReqResultState$5
  extends HashMap<String, Object>
{
  NetLivenessReqResultState$5(NetLivenessReqResultState paramNetLivenessReqResultState, Exception paramException)
  {
    put("ui_action", "process_finished");
    put("ui_tips", "rst_failed");
    put("process_action", "failed");
    put("error_code", Integer.valueOf(3145728));
    put("message", CommonUtils.makeMessageJson(3145728, "rst_failed", this.val$e.getLocalizedMessage()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.NetLivenessReqResultState.5
 * JD-Core Version:    0.7.0.1
 */