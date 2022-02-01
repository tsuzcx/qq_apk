package com.tencent.youtu.sdkkitframework.liveness;

import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import java.util.HashMap;

class NetLivenessReqResultState$10
  extends HashMap<String, Object>
{
  NetLivenessReqResultState$10(NetLivenessReqResultState paramNetLivenessReqResultState, Exception paramException)
  {
    put("ui_action", "process_finished");
    put("ui_tips", "rst_failed");
    put("process_action", "failed");
    put("error_code", Integer.valueOf(2097153));
    put("message", CommonUtils.makeMessageJson(2097153, "msg_net_error", this.val$e.getLocalizedMessage()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.NetLivenessReqResultState.10
 * JD-Core Version:    0.7.0.1
 */