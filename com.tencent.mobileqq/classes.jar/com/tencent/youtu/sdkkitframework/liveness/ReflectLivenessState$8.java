package com.tencent.youtu.sdkkitframework.liveness;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.framework.YtFSM;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon.StateNameHelper.StateClassName;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtSDKPlatformContex;
import com.tencent.youtu.ytagreflectlivecheck.data.YTActReflectData;
import com.tencent.youtu.ytagreflectlivecheck.data.YTActReflectImage;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.ActionReflectReq;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.YTImageInfo;
import com.tencent.youtu.ytagreflectlivecheck.requester.UploadVideoRequesterV3;
import com.tencent.youtu.ytagreflectlivecheck.requester.UploadVideoRequesterV3.ActReflectResponse;
import com.tencent.youtu.ytagreflectlivecheck.requester.UploadVideoRequesterV3.UploadVideoResponse;
import com.tencent.youtu.ytposedetect.data.YTActRefData;
import com.tencent.youtu.ytposedetect.data.YTActRefImage;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;

class ReflectLivenessState$8
  implements UploadVideoRequesterV3
{
  ReflectLivenessState$8(ReflectLivenessState paramReflectLivenessState) {}
  
  public void getActReflectData(UploadVideoRequesterV3.ActReflectResponse paramActReflectResponse)
  {
    if (ReflectLivenessState.access$500(this.this$0) != null)
    {
      paramActReflectResponse.onSuccess(new YTActReflectData(new YTActReflectImage(ReflectLivenessState.access$500(this.this$0).best.image, ReflectLivenessState.access$500(this.this$0).best.xys), new YTActReflectImage(ReflectLivenessState.access$500(this.this$0).eye.image, ReflectLivenessState.access$500(this.this$0).eye.xys), new YTActReflectImage(ReflectLivenessState.access$500(this.this$0).mouth.image, ReflectLivenessState.access$500(this.this$0).mouth.xys), ReflectLivenessState.access$600(this.this$0)));
      return;
    }
    paramActReflectResponse.onFailed("actReflectData is nil");
  }
  
  public void request(ActionReflectReq paramActionReflectReq, UploadVideoRequesterV3.UploadVideoResponse paramUploadVideoResponse)
  {
    YtLogger.d(ReflectLivenessState.access$100(), "---> mode: " + paramActionReflectReq.mode);
    paramActionReflectReq.app_id = ReflectLivenessState.access$700(this.this$0);
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
        break label261;
      }
    }
    label261:
    for (int i = j;; i = k)
    {
      Bitmap localBitmap1 = localBitmap2;
      if (i > 640)
      {
        localBitmap1 = ReflectLivenessState.access$800(localBitmap2, j * 640 / i, k * 640 / i);
        YtLogger.d(ReflectLivenessState.access$100(), "resize image. from w:" + j + " h:" + k + " to w:" + localBitmap1.getWidth() + " h:" + localBitmap1.getHeight());
      }
      localBitmap1.compress(Bitmap.CompressFormat.JPEG, 95, localByteArrayOutputStream);
      paramActionReflectReq.compare_image = new YTImageInfo(new YTActReflectImage(localByteArrayOutputStream.toByteArray(), null));
      ReflectLivenessState.access$900(this.this$0).put("reflect_response_object", paramUploadVideoResponse);
      ReflectLivenessState.access$1000(this.this$0).put("reflect_request_object", paramActionReflectReq);
      ReflectLivenessState.access$1102(this.this$0, YtSDKKitCommon.StateNameHelper.StateClassName.NET_LIVENESS_REQ_RESULT_STATE);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.ReflectLivenessState.8
 * JD-Core Version:    0.7.0.1
 */