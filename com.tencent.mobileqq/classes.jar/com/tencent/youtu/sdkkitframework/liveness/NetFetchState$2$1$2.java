package com.tencent.youtu.sdkkitframework.liveness;

import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import java.util.HashMap;

class NetFetchState$2$1$2
  extends HashMap<String, Object>
{
  NetFetchState$2$1$2(NetFetchState.2.1 param1, String paramString)
  {
    put("ui_error", "Response failed");
    put("ui_tips", "net_fetch_failed");
    put("process_action", "failed");
    put("error_code", Integer.valueOf(2097153));
    put("message", CommonUtils.makeMessageJson(2097153, "net_fetch_failed", this.val$finalResponse));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.NetFetchState.2.1.2
 * JD-Core Version:    0.7.0.1
 */