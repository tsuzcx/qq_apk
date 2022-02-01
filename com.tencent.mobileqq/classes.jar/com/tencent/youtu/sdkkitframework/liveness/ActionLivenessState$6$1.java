package com.tencent.youtu.sdkkitframework.liveness;

import android.graphics.YuvImage;
import com.tencent.youtu.YTFaceTracker;
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
    String str = ActionLivenessState.access$200();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("获取到最优图. width:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" height: ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" bytes size: ");
    localStringBuilder.append(paramArrayOfByte.length);
    YtLogger.d(str, localStringBuilder.toString());
    paramArrayOfByte = new YuvImage(paramArrayOfByte, 17, paramInt1, paramInt2, null);
    ActionLivenessState.access$1700(this.this$1.this$0).put("best_frame", paramArrayOfByte);
    ActionLivenessState.access$1802(this.this$1.this$0, YtSDKKitCommon.StateNameHelper.StateClassName.NET_LIVENESS_REQ_RESULT_STATE);
    ActionLivenessState.access$2000(this.this$1.this$0).setParam(ActionLivenessState.access$1900(this.this$1.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.ActionLivenessState.6.1
 * JD-Core Version:    0.7.0.1
 */