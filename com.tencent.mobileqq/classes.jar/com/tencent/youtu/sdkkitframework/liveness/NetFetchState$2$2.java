package com.tencent.youtu.sdkkitframework.liveness;

import java.util.HashMap;

class NetFetchState$2$2
  extends HashMap<String, Object>
{
  NetFetchState$2$2(NetFetchState.2 param2, int paramInt, String paramString1, String paramString2)
  {
    put("ui_error", Integer.valueOf(this.val$code1));
    put("ui_tips", "net_fetch_failed");
    put("process_action", "failed");
    put("error_code", Integer.valueOf(2097153));
    put("message", "msg_net_error:" + this.val$tips1 + " " + this.val$howToFix1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.NetFetchState.2.2
 * JD-Core Version:    0.7.0.1
 */