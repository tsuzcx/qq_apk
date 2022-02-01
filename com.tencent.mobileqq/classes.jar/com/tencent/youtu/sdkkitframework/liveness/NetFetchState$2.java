package com.tencent.youtu.sdkkitframework.liveness;

import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import java.util.HashMap;

class NetFetchState$2
  extends HashMap<String, Object>
{
  NetFetchState$2(NetFetchState paramNetFetchState, String paramString)
  {
    paramNetFetchState = Integer.valueOf(4194304);
    put("ui_error", paramNetFetchState);
    put("ui_tips", "rst_failed");
    put("process_action", "failed");
    put("error_code", paramNetFetchState);
    put("message", CommonUtils.makeMessageJson(4194304, "msg_param_error", this.val$message));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.NetFetchState.2
 * JD-Core Version:    0.7.0.1
 */