package com.tencent.youtu.ytagreflectlivecheck.controller;

import com.tencent.youtu.ytagreflectlivecheck.jni.model.ColorSeqRes;
import com.tencent.youtu.ytagreflectlivecheck.manager.ProcessManager;
import com.tencent.youtu.ytagreflectlivecheck.manager.ProcessManager.ProcessResult;
import com.tencent.youtu.ytagreflectlivecheck.requester.RGBConfigRequester.RGBConfigRequestCallBack;
import com.tencent.youtu.ytagreflectlivecheck.requester.RGBConfigRequester.RGBConfigRequestCallBackType;
import com.tencent.youtu.ytcommon.YTCommonExInterface;
import com.tencent.youtu.ytcommon.tools.wejson.WeJson;
import com.tencent.youtu.ytcommon.tools.wejson.WeJsonException;

class InitController$1
  implements RGBConfigRequester.RGBConfigRequestCallBack
{
  InitController$1(InitController paramInitController, ProcessManager.ProcessResult paramProcessResult, long paramLong) {}
  
  public void onFailed(int paramInt)
  {
    this.val$checkResult.onFailed(InitController.access$500(), "Get rgbconfig failed.", "Check \"LightLiveCheck.setRGBConfigRequest()\" params. Or maybe net error?", this.val$tag);
  }
  
  public void onSuccess(String paramString, int paramInt)
  {
    if (paramString != null)
    {
      try
      {
        if (paramString.equals(""))
        {
          this.val$checkResult.onFailed(InitController.access$000(), "Get rgbconfig return string is null.", "Check \"RGBConfigRequester.RGBConfigRequestCallBack()\" return value. Is it null?", this.val$tag);
          return;
        }
        if (YTCommonExInterface.getBusinessCode() == 1)
        {
          ProcessManager.dataWorker().mRgbConfigCode = paramString;
          this.val$checkResult.onSuccess(this.val$tag);
          return;
        }
      }
      catch (WeJsonException paramString)
      {
        this.val$checkResult.onFailed(InitController.access$300(), "Parse rgbconfig json failed.", "Check rgbconfig json. Is it a valid json?", this.val$tag);
        paramString.printStackTrace();
        return;
      }
      if (paramInt == RGBConfigRequester.RGBConfigRequestCallBackType.RGB_FullResponse)
      {
        paramString = (ColorSeqRes)new WeJson().fromJson(paramString, ColorSeqRes.class);
        if (paramString.error_code == 0)
        {
          ProcessManager.dataWorker().mRgbConfigCode = paramString.color_data;
          this.val$checkResult.onSuccess(this.val$tag);
          return;
        }
        this.val$checkResult.onFailed(InitController.access$100(), "Get_rgbconfig youtu server return code not 0, current is: " + paramString.error_code, "Request rgbConfig youtu server return value not currect. Check request and response log for more details. tag: ", this.val$tag);
        return;
      }
      if (paramInt == RGBConfigRequester.RGBConfigRequestCallBackType.RGB_OnlyRgbConfig)
      {
        ProcessManager.dataWorker().mRgbConfigCode = paramString;
        this.val$checkResult.onSuccess(this.val$tag);
        return;
      }
      this.val$checkResult.onFailed(InitController.access$200(), "Input type is wrong.", "Type should be one of RGBConfigRequestCallBackType.", this.val$tag);
      return;
    }
    this.val$checkResult.onFailed(InitController.access$400(), "Get_rgbconfig return null.", "Server return value not currect.", this.val$tag);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.controller.InitController.1
 * JD-Core Version:    0.7.0.1
 */