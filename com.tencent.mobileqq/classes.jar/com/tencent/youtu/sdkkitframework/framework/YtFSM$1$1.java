package com.tencent.youtu.sdkkitframework.framework;

import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import java.util.HashMap;

class YtFSM$1$1
  extends HashMap<String, Object>
{
  YtFSM$1$1(YtFSM.1 param1)
  {
    put("ui_action", "process_finished");
    put("ui_tips", "rst_failed");
    put("process_action", "failed");
    put("error_code", Integer.valueOf(4194307));
    put("message", CommonUtils.makeMessageJson(4194307, "msg_timeout_error", "Timeout"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.framework.YtFSM.1.1
 * JD-Core Version:    0.7.0.1
 */