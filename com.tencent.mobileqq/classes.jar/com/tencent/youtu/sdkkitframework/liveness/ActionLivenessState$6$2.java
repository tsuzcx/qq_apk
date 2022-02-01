package com.tencent.youtu.sdkkitframework.liveness;

import android.graphics.YuvImage;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon.StateNameHelper.StateClassName;
import com.tencent.youtu.ytposedetect.YTPoseDetectInterface.PoseDetectGetBestImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class ActionLivenessState$6$2
  implements YTPoseDetectInterface.PoseDetectGetBestImage
{
  ActionLivenessState$6$2(ActionLivenessState.6 param6) {}
  
  public void onGetBestImage(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    YtLogger.d(ActionLivenessState.access$200(), "获取到最优图. width:" + paramInt1 + " height: " + paramInt2 + " bytes size: " + paramArrayOfByte.length);
    paramArrayOfByte = new YuvImage(paramArrayOfByte, 17, paramInt1, paramInt2, null);
    ActionLivenessState.access$1900(this.this$1.this$0).put("best_frame", paramArrayOfByte);
    Collections.sort(ActionLivenessState.access$2000(this.this$1.this$0), new ActionLivenessState.BestFrameEyeRating(this.this$1.this$0));
    paramInt2 = Math.min(ActionLivenessState.access$2000(this.this$1.this$0).size(), 5);
    paramArrayOfByte = new ArrayList();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      paramArrayOfByte.add(ActionLivenessState.access$2000(this.this$1.this$0).get(paramInt1));
      paramInt1 += 1;
    }
    ActionLivenessState.access$2100(this.this$1.this$0).put("frame_list", paramArrayOfByte);
    ActionLivenessState.access$2200(this.this$1.this$0).put("act_reflect_data", ActionLivenessState.access$900(this.this$1.this$0));
    ActionLivenessState.access$1802(this.this$1.this$0, YtSDKKitCommon.StateNameHelper.StateClassName.REFLECT_STATE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.ActionLivenessState.6.2
 * JD-Core Version:    0.7.0.1
 */