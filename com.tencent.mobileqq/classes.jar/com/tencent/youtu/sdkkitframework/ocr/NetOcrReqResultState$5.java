package com.tencent.youtu.sdkkitframework.ocr;

import java.util.HashMap;

class NetOcrReqResultState$5
  extends HashMap<String, String>
{
  NetOcrReqResultState$5(NetOcrReqResultState paramNetOcrReqResultState, String paramString)
  {
    put("Context-Type", "text/json");
    put("Host", "api.youtu.qq.com");
    put("Authorization", this.val$authString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.ocr.NetOcrReqResultState.5
 * JD-Core Version:    0.7.0.1
 */