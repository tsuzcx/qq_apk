package com.tencent.youtu.sdkkitframework.liveness;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.util.Base64;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.framework.YtFSM;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon.StateNameHelper.StateClassName;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtSDKPlatformContex;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.ReflectLiveReq;
import com.tencent.youtu.ytagreflectlivecheck.requester.UploadVideoRequesterV2;
import com.tencent.youtu.ytagreflectlivecheck.requester.UploadVideoRequesterV2.UploadVideoResponse;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;

class ReflectLivenessState$9
  implements UploadVideoRequesterV2
{
  ReflectLivenessState$9(ReflectLivenessState paramReflectLivenessState) {}
  
  public void request(ReflectLiveReq paramReflectLiveReq, UploadVideoRequesterV2.UploadVideoResponse paramUploadVideoResponse)
  {
    Bitmap localBitmap2 = YtFSM.getInstance().getContext().imageToCompare;
    ByteArrayOutputStream localByteArrayOutputStream;
    int j;
    int k;
    if (localBitmap2 != null)
    {
      localByteArrayOutputStream = new ByteArrayOutputStream();
      j = localBitmap2.getWidth();
      k = localBitmap2.getHeight();
      if (j <= k) {
        break label249;
      }
    }
    label249:
    for (int i = j;; i = k)
    {
      Bitmap localBitmap1 = localBitmap2;
      if (i > 640)
      {
        localBitmap1 = ReflectLivenessState.access$800(localBitmap2, j * 640 / i, k * 640 / i);
        YtLogger.d(ReflectLivenessState.access$100(), "resize image. from w:" + j + " h:" + k + " to w:" + localBitmap1.getWidth() + " h:" + localBitmap1.getHeight());
      }
      localBitmap1.compress(Bitmap.CompressFormat.JPEG, 95, localByteArrayOutputStream);
      paramReflectLiveReq.compare_image = new String(Base64.encode(localByteArrayOutputStream.toByteArray(), 2));
      YtLogger.d(ReflectLivenessState.access$100(), "ref request best image length: " + paramReflectLiveReq.live_image.length());
      ReflectLivenessState.access$1200(this.this$0).put("reflect_response_object", paramUploadVideoResponse);
      ReflectLivenessState.access$1300(this.this$0).put("reflect_request_object", paramReflectLiveReq);
      ReflectLivenessState.access$1102(this.this$0, YtSDKKitCommon.StateNameHelper.StateClassName.NET_LIVENESS_REQ_RESULT_STATE);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.ReflectLivenessState.9
 * JD-Core Version:    0.7.0.1
 */