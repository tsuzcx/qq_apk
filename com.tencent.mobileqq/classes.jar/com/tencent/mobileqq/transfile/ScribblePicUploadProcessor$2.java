package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.StatictisInfo;

class ScribblePicUploadProcessor$2
  extends MessageObserver
{
  ScribblePicUploadProcessor$2(ScribblePicUploadProcessor paramScribblePicUploadProcessor) {}
  
  public void onNotifyResultAfterSendRich(boolean paramBoolean, long paramLong, StatictisInfo paramStatictisInfo)
  {
    this.this$0.logRichMediaEvent("sendMsgFinish", "success:" + paramBoolean);
    this.this$0.copyStatisInfo(this.this$0.mStepMsg, false, paramBoolean, paramStatictisInfo);
    if (paramBoolean)
    {
      this.this$0.onSuccess();
      return;
    }
    if (paramStatictisInfo != null) {
      this.this$0.shouldMsgReportSucc = paramStatictisInfo.d;
    }
    this.this$0.setError(-1, "MessageForScribble SEND FAIL", "", this.this$0.mStepTrans);
    this.this$0.onError();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ScribblePicUploadProcessor.2
 * JD-Core Version:    0.7.0.1
 */