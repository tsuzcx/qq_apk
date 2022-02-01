package com.tencent.youtu.sdkkitframework.liveness;

import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.ytposedetect.YTPoseDetectInterface.PoseDetectResult;

class ActionLivenessState$7
  implements YTPoseDetectInterface.PoseDetectResult
{
  ActionLivenessState$7(ActionLivenessState paramActionLivenessState) {}
  
  public void onFailed(int paramInt, String paramString1, String paramString2) {}
  
  public void onSuccess()
  {
    YtLogger.d(ActionLivenessState.access$200(), "start success");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.ActionLivenessState.7
 * JD-Core Version:    0.7.0.1
 */