package com.tencent.youtu.sdkkitframework.framework;

import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import java.util.HashMap;

class TimeoutState$1
  extends HashMap<String, Object>
{
  TimeoutState$1(TimeoutState paramTimeoutState)
  {
    put("ui_action", "process_finished");
    put("ui_tips", "rst_failed");
    put("process_action", "failed");
    put("error_code", Integer.valueOf(4194307));
    put("message", CommonUtils.makeMessageJson(4194307, "msg_timeout_error", "Timeout"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.framework.TimeoutState.1
 * JD-Core Version:    0.7.0.1
 */