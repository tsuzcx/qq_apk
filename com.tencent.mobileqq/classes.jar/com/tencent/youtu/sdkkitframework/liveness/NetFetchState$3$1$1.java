package com.tencent.youtu.sdkkitframework.liveness;

import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import java.util.HashMap;

class NetFetchState$3$1$1
  extends HashMap<String, Object>
{
  NetFetchState$3$1$1(NetFetchState.3.1 param1, Exception paramException, String paramString)
  {
    put("ui_error", this.val$error.getMessage());
    put("process_action", "failed");
    put("error_code", Integer.valueOf(2097153));
    put("message", CommonUtils.makeMessageJson(2097153, "msg_net_error", this.val$finalResponse));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.NetFetchState.3.1.1
 * JD-Core Version:    0.7.0.1
 */