package com.tencent.youtu.sdkkitframework.ocr;

import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import java.util.HashMap;

class OcrCardAutoDetectState$1
  extends HashMap<String, Object>
{
  OcrCardAutoDetectState$1(OcrCardAutoDetectState paramOcrCardAutoDetectState, int paramInt)
  {
    put("process_action", "failed");
    put("error_code", Integer.valueOf(5242884));
    put("message", CommonUtils.makeMessageJson(5242884, "Init YTImageRefiner SDK failed with " + this.val$finalRet, ""));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.ocr.OcrCardAutoDetectState.1
 * JD-Core Version:    0.7.0.1
 */