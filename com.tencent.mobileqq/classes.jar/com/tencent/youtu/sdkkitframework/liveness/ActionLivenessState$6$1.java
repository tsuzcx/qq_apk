package com.tencent.youtu.sdkkitframework.liveness;

import android.graphics.YuvImage;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon.StateNameHelper.StateClassName;
import com.tencent.youtu.ytposedetect.YTPoseDetectInterface.PoseDetectGetBestImage;
import java.util.HashMap;

class ActionLivenessState$6$1
  implements YTPoseDetectInterface.PoseDetectGetBestImage
{
  ActionLivenessState$6$1(ActionLivenessState.6 param6) {}
  
  public void onGetBestImage(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    YtLogger.d(ActionLivenessState.access$200(), "获取到最优图. width:" + paramInt1 + " height: " + paramInt2 + " bytes size: " + paramArrayOfByte.length);
    paramArrayOfByte = new YuvImage(paramArrayOfByte, 17, paramInt1, paramInt2, null);
    ActionLivenessState.access$1700(this.this$1.this$0).put("best_frame", paramArrayOfByte);
    ActionLivenessState.access$1802(this.this$1.this$0, YtSDKKitCommon.StateNameHelper.StateClassName.NET_LIVENESS_REQ_RESULT_STATE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.ActionLivenessState.6.1
 * JD-Core Version:    0.7.0.1
 */