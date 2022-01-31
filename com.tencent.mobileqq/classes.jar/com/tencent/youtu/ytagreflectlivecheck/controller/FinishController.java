package com.tencent.youtu.ytagreflectlivecheck.controller;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectSettings;
import com.tencent.youtu.ytagreflectlivecheck.jni.JNIUtils;
import com.tencent.youtu.ytagreflectlivecheck.jni.YTAGReflectLiveCheckJNIInterface;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.EncodeReflectData;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.FullPack;
import com.tencent.youtu.ytagreflectlivecheck.manager.ProcessManager;
import com.tencent.youtu.ytagreflectlivecheck.manager.ProcessManager.ProcessFinishResult;
import com.tencent.youtu.ytagreflectlivecheck.requester.UploadVideoRequester;
import com.tencent.youtu.ytagreflectlivecheck.requester.UploadVideoRequesterV2;
import com.tencent.youtu.ytagreflectlivecheck.requester.UploadVideoRequesterV3;
import com.tencent.youtu.ytagreflectlivecheck.worker.DataWorker;
import com.tencent.youtu.ytagreflectlivecheck.worker.TimeCounter;
import com.tencent.youtu.ytcommon.tools.YTCameraSetting;
import com.tencent.youtu.ytcommon.tools.YTLogger;
import com.tencent.youtu.ytcommon.tools.wejson.WeJson;
import java.io.ByteArrayOutputStream;

public class FinishController
{
  private static int ERRCODE_GET_ACTREFLECTDATA_FAILED = 4;
  private static int ERRCODE_JNI_DETECT_FAILED = 0;
  private static int ERRCODE_JSON_DECODE_FAILED = 0;
  private static int ERRCODE_NET_RETURN_PARSE_NULL = 0;
  private static int ERRCODE_UPLOAD_VIDEO_FAILED = 1;
  private static final String TAG = "YoutuLightLiveCheck";
  
  static
  {
    ERRCODE_JSON_DECODE_FAILED = 2;
    ERRCODE_JNI_DETECT_FAILED = 3;
  }
  
  private byte[] Bitmap2Bytes(Bitmap paramBitmap)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
  
  private void checkUpload(UploadVideoRequester paramUploadVideoRequester, ProcessManager.ProcessFinishResult paramProcessFinishResult, long paramLong)
  {
    Object localObject = YTAGReflectLiveCheckJNIInterface.getInstance().FRGetAGin();
    if (ProcessManager.dataWorker() == null)
    {
      YTLogger.e("YoutuLightLiveCheck", "reflect checkupload() failed: dataworker is null");
      return;
    }
    localObject = JNIUtils.translation((FullPack)localObject, ProcessManager.dataWorker().mRgbConfigCode);
    paramUploadVideoRequester.request(new WeJson().toJson(localObject), new FinishController.3(this, paramProcessFinishResult, paramLong));
  }
  
  private void checkUploadV2(UploadVideoRequesterV2 paramUploadVideoRequesterV2, ProcessManager.ProcessFinishResult paramProcessFinishResult, long paramLong)
  {
    FullPack localFullPack = null;
    TimeCounter.ins("sdk处理反光数据").begin();
    if (YTAGReflectLiveCheckInterface.getAGSettings().isEncodeReflectData) {}
    for (EncodeReflectData localEncodeReflectData = YTAGReflectLiveCheckJNIInterface.getInstance().FRGetEncodeReflectData();; localEncodeReflectData = null)
    {
      TimeCounter.ins("sdk处理反光数据").end(false);
      if (ProcessManager.dataWorker() != null) {
        break;
      }
      YTLogger.e("YoutuLightLiveCheck", "On reflect checkuploadV2() failed: dataworker is null");
      return;
      localFullPack = YTAGReflectLiveCheckJNIInterface.getInstance().FRGetAGin();
    }
    paramUploadVideoRequesterV2.request(JNIUtils.getReflectLiveReq(localFullPack, localEncodeReflectData, ProcessManager.dataWorker().mRgbConfigCode), new FinishController.2(this, paramProcessFinishResult, paramLong));
  }
  
  private void checkUploadV3(UploadVideoRequesterV3 paramUploadVideoRequesterV3, ProcessManager.ProcessFinishResult paramProcessFinishResult, long paramLong)
  {
    TimeCounter.ins("sdk请求动作图片信息").begin();
    paramUploadVideoRequesterV3.getActReflectData(new FinishController.1(this, paramUploadVideoRequesterV3, paramProcessFinishResult, paramLong));
  }
  
  public void start(UploadVideoRequester paramUploadVideoRequester, ProcessManager.ProcessFinishResult paramProcessFinishResult, long paramLong)
  {
    if (ProcessManager.dataWorker() == null)
    {
      YTLogger.e("YoutuLightLiveCheck", "On reflect start failed: dataworker is null");
      return;
    }
    int i = YTCameraSetting.getRotateTag(ProcessManager.dataWorker().mCameraRotate, 1);
    i = YTAGReflectLiveCheckJNIInterface.getInstance().FRDoDetectionYuvs(false, i);
    if (i == 0)
    {
      checkUpload(paramUploadVideoRequester, paramProcessFinishResult, paramLong);
      return;
    }
    paramProcessFinishResult.onFailed(ERRCODE_JNI_DETECT_FAILED, "JNI return failed.[" + i + "]", "Please make sure you have called the YTAGReflectLiveCheckInterface.onPreviewFrame during the hole reflecting process. Check log for more information. code: " + i, paramLong);
  }
  
  public void start(UploadVideoRequesterV2 paramUploadVideoRequesterV2, ProcessManager.ProcessFinishResult paramProcessFinishResult, long paramLong)
  {
    if (ProcessManager.dataWorker() == null)
    {
      YTLogger.e("YoutuLightLiveCheck", "On reflect start() failed: dataworker is null");
      return;
    }
    int i = YTCameraSetting.getRotateTag(ProcessManager.dataWorker().mCameraRotate, 1);
    i = YTAGReflectLiveCheckJNIInterface.getInstance().FRDoDetectionYuvs(false, i);
    if (i == 0)
    {
      checkUploadV2(YTAGReflectLiveCheckInterface.mUploadVideoRequesterV2, paramProcessFinishResult, paramLong);
      return;
    }
    paramProcessFinishResult.onFailed(ERRCODE_JNI_DETECT_FAILED, "JNI return failed.[" + i + "]", "Please make sure you have called the YTAGReflectLiveCheckInterface.onPreviewFrame during the hole reflecting process. Check log for more information. code: " + i, paramLong);
  }
  
  public void start(UploadVideoRequesterV3 paramUploadVideoRequesterV3, ProcessManager.ProcessFinishResult paramProcessFinishResult, long paramLong)
  {
    int i = YTCameraSetting.getRotateTag(ProcessManager.dataWorker().mCameraRotate, 1);
    i = YTAGReflectLiveCheckJNIInterface.getInstance().FRDoDetectionYuvs(false, i);
    if (i == 0)
    {
      checkUploadV3(paramUploadVideoRequesterV3, paramProcessFinishResult, paramLong);
      return;
    }
    paramProcessFinishResult.onFailed(ERRCODE_JNI_DETECT_FAILED, "JNI return failed.[" + i + "]", "Please make sure you have called the YTAGReflectLiveCheckInterface.onPreviewFrame during the hole reflecting process. Check log for more information. code: " + i, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.controller.FinishController
 * JD-Core Version:    0.7.0.1
 */