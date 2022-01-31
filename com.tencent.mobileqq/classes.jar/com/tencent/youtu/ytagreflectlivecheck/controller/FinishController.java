package com.tencent.youtu.ytagreflectlivecheck.controller;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface;
import com.tencent.youtu.ytagreflectlivecheck.jni.JNIUtils;
import com.tencent.youtu.ytagreflectlivecheck.jni.YTAGReflectLiveCheckJNIInterface;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.PersonLiveReq;
import com.tencent.youtu.ytagreflectlivecheck.manager.ProcessManager;
import com.tencent.youtu.ytagreflectlivecheck.manager.ProcessManager.ProcessFinishResult;
import com.tencent.youtu.ytagreflectlivecheck.requester.UploadVideoRequester;
import com.tencent.youtu.ytagreflectlivecheck.requester.UploadVideoRequesterV2;
import com.tencent.youtu.ytagreflectlivecheck.worker.DataWorker;
import com.tencent.youtu.ytcommon.tools.YTCameraSetting;
import com.tencent.youtu.ytcommon.tools.wejson.WeJson;
import java.io.ByteArrayOutputStream;

public class FinishController
{
  private static int ERRCODE_JNI_DETECT_FAILED = 3;
  private static int ERRCODE_JSON_DECODE_FAILED = 0;
  private static int ERRCODE_NET_RETURN_PARSE_NULL = 0;
  private static int ERRCODE_UPLOAD_VIDEO_FAILED = 1;
  private static final String TAG = "YoutuLightLiveCheck";
  
  static
  {
    ERRCODE_JSON_DECODE_FAILED = 2;
  }
  
  private byte[] Bitmap2Bytes(Bitmap paramBitmap)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
  
  private void checkUpload(UploadVideoRequester paramUploadVideoRequester, ProcessManager.ProcessFinishResult paramProcessFinishResult, long paramLong)
  {
    PersonLiveReq localPersonLiveReq = JNIUtils.translation(YTAGReflectLiveCheckJNIInterface.getInstance().FRGetAGin(), ProcessManager.dataWorker().mRgbConfigCode);
    paramUploadVideoRequester.request(new WeJson().toJson(localPersonLiveReq), new FinishController.2(this, paramProcessFinishResult, paramLong));
  }
  
  private void checkUploadV2(UploadVideoRequesterV2 paramUploadVideoRequesterV2, ProcessManager.ProcessFinishResult paramProcessFinishResult, long paramLong)
  {
    paramUploadVideoRequesterV2.request(JNIUtils.getReflectLiveReq(YTAGReflectLiveCheckJNIInterface.getInstance().FRGetAGin(), ProcessManager.dataWorker().mRgbConfigCode), new FinishController.1(this, paramProcessFinishResult, paramLong));
  }
  
  public void start(UploadVideoRequester paramUploadVideoRequester, ProcessManager.ProcessFinishResult paramProcessFinishResult, long paramLong)
  {
    int i = YTCameraSetting.getRotateTag(ProcessManager.dataWorker().mCameraRotate);
    i = YTAGReflectLiveCheckJNIInterface.getInstance().FRDoDetectionYuvs(false, i);
    if (i == 0)
    {
      checkUpload(paramUploadVideoRequester, paramProcessFinishResult, paramLong);
      return;
    }
    paramProcessFinishResult.onFailed(ERRCODE_JNI_DETECT_FAILED, "JNI return failed.[" + i + "]", "Check log for more information. code: " + i, paramLong);
  }
  
  public void start(UploadVideoRequesterV2 paramUploadVideoRequesterV2, ProcessManager.ProcessFinishResult paramProcessFinishResult, long paramLong)
  {
    int i = YTCameraSetting.getRotateTag(ProcessManager.dataWorker().mCameraRotate);
    i = YTAGReflectLiveCheckJNIInterface.getInstance().FRDoDetectionYuvs(false, i);
    if (i == 0)
    {
      checkUploadV2(YTAGReflectLiveCheckInterface.mUploadVideoRequesterV2, paramProcessFinishResult, paramLong);
      return;
    }
    paramProcessFinishResult.onFailed(ERRCODE_JNI_DETECT_FAILED, "JNI return failed.[" + i + "]", "Check log for more information. code: " + i, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.controller.FinishController
 * JD-Core Version:    0.7.0.1
 */