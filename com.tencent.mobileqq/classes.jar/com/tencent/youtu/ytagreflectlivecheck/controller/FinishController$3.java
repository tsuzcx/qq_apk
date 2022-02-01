package com.tencent.youtu.ytagreflectlivecheck.controller;

import com.tencent.youtu.ytagreflectlivecheck.manager.ProcessManager.ProcessFinishResult;
import com.tencent.youtu.ytagreflectlivecheck.requester.LightDiffResponse;
import com.tencent.youtu.ytagreflectlivecheck.requester.UploadVideoRequester.UploadVideoResponse;
import com.tencent.youtu.ytcommon.tools.YTException;
import com.tencent.youtu.ytcommon.tools.wejson.WeJson;

class FinishController$3
  implements UploadVideoRequester.UploadVideoResponse
{
  FinishController$3(FinishController paramFinishController, ProcessManager.ProcessFinishResult paramProcessFinishResult, long paramLong) {}
  
  public void onFailed(int paramInt, String paramString)
  {
    this.val$checkResult.onFailed(FinishController.access$200(), "Upload video failed.[" + paramInt + "]", "Maybe net error? return code: " + paramInt + " message: " + paramString, this.val$tag);
  }
  
  public void onSuccess(String paramString)
  {
    try
    {
      LightDiffResponse localLightDiffResponse = (LightDiffResponse)new WeJson().fromJson(paramString, LightDiffResponse.class);
      if (localLightDiffResponse != null)
      {
        if (localLightDiffResponse.getError_code() == 0)
        {
          this.val$checkResult.onSuccess(true, localLightDiffResponse, paramString, this.val$tag);
          return;
        }
        this.val$checkResult.onSuccess(false, localLightDiffResponse, paramString, this.val$tag);
        return;
      }
    }
    catch (Exception localException)
    {
      YTException.report(localException);
      this.val$checkResult.onFailed(FinishController.access$100(), "Upload video response json decode failed.", "received response: " + paramString, this.val$tag);
      return;
    }
    this.val$checkResult.onFailed(FinishController.access$000(), "Upload video call back decode return nil.", "received response: " + paramString, this.val$tag);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.controller.FinishController.3
 * JD-Core Version:    0.7.0.1
 */