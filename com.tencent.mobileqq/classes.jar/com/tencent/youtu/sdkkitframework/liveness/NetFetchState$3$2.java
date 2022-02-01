package com.tencent.youtu.sdkkitframework.liveness;

import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import java.util.HashMap;

class NetFetchState$3$2
  extends HashMap<String, Object>
{
  NetFetchState$3$2(NetFetchState.3 param3, int paramInt, String paramString1, String paramString2)
  {
    put("ui_error", Integer.valueOf(this.val$code1));
    put("ui_tips", "net_fetch_failed");
    put("process_action", "failed");
    put("error_code", Integer.valueOf(2097153));
    param3 = new StringBuilder();
    param3.append("msg_net_error ");
    param3.append(this.val$tips1);
    param3.append(" ");
    param3.append(this.val$howToFix1);
    put("message", CommonUtils.makeMessageJson(2097153, "msg_net_error", param3.toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.NetFetchState.3.2
 * JD-Core Version:    0.7.0.1
 */