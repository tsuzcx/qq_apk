package com.tencent.youtu.sdkkitframework.ocr;

import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import java.util.HashMap;
import org.json.JSONObject;

class NetOcrReqResultState$6$3
  extends HashMap<String, Object>
{
  NetOcrReqResultState$6$3(NetOcrReqResultState.6 param6, int paramInt, JSONObject paramJSONObject, HashMap paramHashMap)
  {
    put("ui_action", "process_finished");
    put("ui_tips", "rst_failed");
    put("process_action", "failed");
    put("error_code", Integer.valueOf(this.val$errorCode));
    put("message", CommonUtils.makeMessageJson(this.val$errorCode, this.val$jsonObject.getString("errormsg"), (String)this.val$result.get("response")));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.ocr.NetOcrReqResultState.6.3
 * JD-Core Version:    0.7.0.1
 */