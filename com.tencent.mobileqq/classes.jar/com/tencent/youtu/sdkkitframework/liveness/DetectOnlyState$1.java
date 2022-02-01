package com.tencent.youtu.sdkkitframework.liveness;

import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import java.util.HashMap;

class DetectOnlyState$1
  extends HashMap<String, Object>
{
  DetectOnlyState$1(DetectOnlyState paramDetectOnlyState)
  {
    put("process_action", "failed");
    put("error_code", Integer.valueOf(5242881));
    put("message", CommonUtils.makeMessageJson(5242881, "msg_param_error", "检测初始化失败"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.DetectOnlyState.1
 * JD-Core Version:    0.7.0.1
 */