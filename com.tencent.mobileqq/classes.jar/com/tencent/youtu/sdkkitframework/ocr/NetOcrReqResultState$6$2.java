package com.tencent.youtu.sdkkitframework.ocr;

import java.util.HashMap;

class NetOcrReqResultState$6$2
  extends HashMap<String, Object>
{
  NetOcrReqResultState$6$2(NetOcrReqResultState.6 param6, HashMap paramHashMap)
  {
    put("ui_action", "process_finished");
    put("ui_tips", "rst_succeed");
    put("process_action", "succeed");
    put("error_code", Integer.valueOf(0));
    put("message", this.val$result.get("response"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.ocr.NetOcrReqResultState.6.2
 * JD-Core Version:    0.7.0.1
 */