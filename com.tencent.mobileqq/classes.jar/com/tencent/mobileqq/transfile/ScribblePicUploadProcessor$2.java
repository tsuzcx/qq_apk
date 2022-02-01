package com.tencent.mobileqq.transfile;

import amwl;
import amwm;

class ScribblePicUploadProcessor$2
  extends amwl
{
  ScribblePicUploadProcessor$2(ScribblePicUploadProcessor paramScribblePicUploadProcessor) {}
  
  public void onNotifyResultAfterSendRich(boolean paramBoolean, long paramLong, amwm paramamwm)
  {
    this.this$0.logRichMediaEvent("sendMsgFinish", "success:" + paramBoolean);
    this.this$0.copyStatisInfo(this.this$0.mStepMsg, false, paramBoolean, paramamwm);
    if (paramBoolean)
    {
      this.this$0.onSuccess();
      return;
    }
    if (paramamwm != null) {
      this.this$0.shouldMsgReportSucc = paramamwm.d;
    }
    this.this$0.setError(-1, "MessageForScribble SEND FAIL", "", this.this$0.mStepTrans);
    this.this$0.onError();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ScribblePicUploadProcessor.2
 * JD-Core Version:    0.7.0.1
 */