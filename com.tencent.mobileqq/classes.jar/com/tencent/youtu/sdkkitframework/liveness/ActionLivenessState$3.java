package com.tencent.youtu.sdkkitframework.liveness;

import java.util.HashMap;

class ActionLivenessState$3
  extends HashMap<String, Object>
{
  ActionLivenessState$3(ActionLivenessState paramActionLivenessState, String paramString)
  {
    paramActionLivenessState = new StringBuilder();
    paramActionLivenessState.append("动作库版本过低！目标版本：");
    paramActionLivenessState.append(ActionLivenessState.access$000(this.this$0));
    paramActionLivenessState.append(" 当前版本：");
    paramActionLivenessState.append(this.val$realVersion);
    put("version_tips", paramActionLivenessState.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.ActionLivenessState.3
 * JD-Core Version:    0.7.0.1
 */