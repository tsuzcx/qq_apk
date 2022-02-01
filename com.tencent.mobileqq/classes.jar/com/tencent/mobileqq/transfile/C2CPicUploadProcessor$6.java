package com.tencent.mobileqq.transfile;

import anyz;
import anza;

class C2CPicUploadProcessor$6
  extends anyz
{
  C2CPicUploadProcessor$6(C2CPicUploadProcessor paramC2CPicUploadProcessor) {}
  
  public void onNotifyResultAfterSendRich(boolean paramBoolean, long paramLong, anza paramanza)
  {
    this.this$0.logRichMediaEvent("sendMsgFinish", "success:" + paramBoolean);
    this.this$0.copyStatisInfo(this.this$0.mStepMsg, false, paramBoolean, paramanza);
    if (paramBoolean)
    {
      this.this$0.onSuccess();
      return;
    }
    if (paramanza != null) {
      this.this$0.shouldMsgReportSucc = paramanza.d;
    }
    this.this$0.onError();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.C2CPicUploadProcessor.6
 * JD-Core Version:    0.7.0.1
 */