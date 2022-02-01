package com.tencent.youtu.sdkkitframework.liveness;

import java.util.HashMap;

class ReflectLivenessState$3
  extends HashMap<String, Object>
{
  ReflectLivenessState$3(ReflectLivenessState paramReflectLivenessState)
  {
    paramReflectLivenessState = new StringBuilder();
    paramReflectLivenessState.append("反光库版本过低！目标版本：");
    paramReflectLivenessState.append(ReflectLivenessState.access$000(this.this$0));
    paramReflectLivenessState.append(" 当前版本：");
    paramReflectLivenessState.append("3.6.8");
    put("version_tips", paramReflectLivenessState.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.ReflectLivenessState.3
 * JD-Core Version:    0.7.0.1
 */