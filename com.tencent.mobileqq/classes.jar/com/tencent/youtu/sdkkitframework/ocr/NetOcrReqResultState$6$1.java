package com.tencent.youtu.sdkkitframework.ocr;

import java.util.HashMap;

class NetOcrReqResultState$6$1
  extends HashMap<String, Object>
{
  NetOcrReqResultState$6$1(NetOcrReqResultState.6 param6, Exception paramException)
  {
    put("ui_action", "process_finished");
    put("ui_tips", "rst_failed");
    put("process_action", "failed");
    put("error_code", Integer.valueOf(4194304));
    put("message", this.val$error.getMessage());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.ocr.NetOcrReqResultState.6.1
 * JD-Core Version:    0.7.0.1
 */