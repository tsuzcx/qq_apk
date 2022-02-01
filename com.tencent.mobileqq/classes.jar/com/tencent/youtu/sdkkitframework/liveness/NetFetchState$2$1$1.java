package com.tencent.youtu.sdkkitframework.liveness;

import java.util.HashMap;

class NetFetchState$2$1$1
  extends HashMap<String, Object>
{
  NetFetchState$2$1$1(NetFetchState.2.1 param1, Exception paramException)
  {
    put("ui_error", this.val$error.getMessage());
    put("process_action", "failed");
    put("error_code", Integer.valueOf(2097153));
    put("message", "msg_net_error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.NetFetchState.2.1.1
 * JD-Core Version:    0.7.0.1
 */