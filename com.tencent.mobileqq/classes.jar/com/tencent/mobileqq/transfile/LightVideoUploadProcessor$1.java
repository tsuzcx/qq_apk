package com.tencent.mobileqq.transfile;

import anyz;
import anza;

class LightVideoUploadProcessor$1
  extends anyz
{
  LightVideoUploadProcessor$1(LightVideoUploadProcessor paramLightVideoUploadProcessor) {}
  
  public void onNotifyResultAfterSendRich(boolean paramBoolean, long paramLong, anza paramanza)
  {
    this.this$0.logRichMediaEvent("sendMsgFinish", "success:" + paramBoolean);
    this.this$0.copyStatisInfo(this.this$0.mStepMsg, false, paramBoolean, paramanza);
    if (paramBoolean)
    {
      this.this$0.onSuccess();
      return;
    }
    this.this$0.onError();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.LightVideoUploadProcessor.1
 * JD-Core Version:    0.7.0.1
 */