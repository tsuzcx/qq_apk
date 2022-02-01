package com.tencent.youtu.sdkkitframework.liveness;

import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import java.util.HashMap;

class NetLivenessReqResultState$9
  extends HashMap<String, Object>
{
  NetLivenessReqResultState$9(NetLivenessReqResultState paramNetLivenessReqResultState, Exception paramException)
  {
    put("ui_action", "process_finished");
    put("ui_tips", "rst_failed");
    put("process_action", "failed");
    put("error_code", Integer.valueOf(2097153));
    put("message", CommonUtils.makeMessageJson(2097153, "msg_net_error", this.val$e.getLocalizedMessage()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.NetLivenessReqResultState.9
 * JD-Core Version:    0.7.0.1
 */