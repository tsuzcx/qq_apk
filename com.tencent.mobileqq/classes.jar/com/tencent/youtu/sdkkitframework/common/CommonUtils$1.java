package com.tencent.youtu.sdkkitframework.common;

import java.util.HashMap;

final class CommonUtils$1
  extends HashMap<String, Object>
{
  CommonUtils$1(Exception paramException)
  {
    put("ui_action", "process_finished");
    put("ui_tips", "rst_failed");
    put("process_action", "failed");
    put("error_code", Integer.valueOf(3145728));
    put("message", CommonUtils.makeMessageJson(3145728, "rst_failed", this.val$e.getLocalizedMessage()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.common.CommonUtils.1
 * JD-Core Version:    0.7.0.1
 */