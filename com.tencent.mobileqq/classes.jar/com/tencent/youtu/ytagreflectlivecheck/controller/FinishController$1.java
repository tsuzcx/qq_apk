package com.tencent.youtu.ytagreflectlivecheck.controller;

import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectSettings;
import com.tencent.youtu.ytagreflectlivecheck.data.YTActReflectData;
import com.tencent.youtu.ytagreflectlivecheck.jni.JNIUtils;
import com.tencent.youtu.ytagreflectlivecheck.jni.YTAGReflectLiveCheckJNIInterface;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.EncodeReflectData;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.FullPack;
import com.tencent.youtu.ytagreflectlivecheck.manager.ProcessManager;
import com.tencent.youtu.ytagreflectlivecheck.manager.ProcessManager.ProcessFinishResult;
import com.tencent.youtu.ytagreflectlivecheck.requester.UploadVideoRequesterV3;
import com.tencent.youtu.ytagreflectlivecheck.requester.UploadVideoRequesterV3.ActReflectResponse;
import com.tencent.youtu.ytagreflectlivecheck.worker.DataWorker;
import com.tencent.youtu.ytagreflectlivecheck.worker.TimeCounter;
import com.tencent.youtu.ytcommon.tools.YTLogger;

class FinishController$1
  implements UploadVideoRequesterV3.ActReflectResponse
{
  FinishController$1(FinishController paramFinishController, UploadVideoRequesterV3 paramUploadVideoRequesterV3, ProcessManager.ProcessFinishResult paramProcessFinishResult, long paramLong) {}
  
  public void onFailed(String paramString)
  {
    TimeCounter.ins("sdk请求动作图片信息").end(false);
    this.val$checkResult.onFailed(FinishController.access$300(), "Get ActReflectData failed", "received response: " + paramString, this.val$tag);
  }
  
  public void onSuccess(YTActReflectData paramYTActReflectData)
  {
    FullPack localFullPack = null;
    TimeCounter.ins("sdk请求动作图片信息").end(false);
    TimeCounter.ins("sdk处理反光数据").begin();
    if (YTAGReflectLiveCheckInterface.getAGSettings().isEncodeReflectData) {}
    for (EncodeReflectData localEncodeReflectData = YTAGReflectLiveCheckJNIInterface.getInstance().FRGetEncodeReflectData();; localEncodeReflectData = null)
    {
      TimeCounter.ins("sdk处理反光数据").end(false);
      if (ProcessManager.dataWorker() != null) {
        break;
      }
      YTLogger.e("YoutuLightLiveCheck", "On reflect success failed: dataworker is null");
      return;
      localFullPack = YTAGReflectLiveCheckJNIInterface.getInstance().FRGetAGin();
    }
    paramYTActReflectData = JNIUtils.getActionReflectLiveReq(localFullPack, localEncodeReflectData, paramYTActReflectData, ProcessManager.dataWorker().mRgbConfigCode);
    this.val$uploadVideoRequester.request(paramYTActReflectData, new FinishController.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.controller.FinishController.1
 * JD-Core Version:    0.7.0.1
 */