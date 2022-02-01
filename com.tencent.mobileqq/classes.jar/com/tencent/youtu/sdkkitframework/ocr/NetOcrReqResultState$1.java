package com.tencent.youtu.sdkkitframework.ocr;

import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import java.util.HashMap;
import org.json.JSONException;

class NetOcrReqResultState$1
  extends HashMap<String, Object>
{
  NetOcrReqResultState$1(NetOcrReqResultState paramNetOcrReqResultState, JSONException paramJSONException)
  {
    put("ui_action", "process_finished");
    put("ui_tips", "rst_failed");
    put("process_action", "failed");
    put("error_code", Integer.valueOf(3145729));
    put("message", CommonUtils.makeMessageJson(3145729, this.val$e.getMessage(), ""));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.ocr.NetOcrReqResultState.1
 * JD-Core Version:    0.7.0.1
 */