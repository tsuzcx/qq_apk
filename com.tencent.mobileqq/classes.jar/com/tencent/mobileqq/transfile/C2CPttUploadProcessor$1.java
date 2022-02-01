package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.StatictisInfo;

class C2CPttUploadProcessor$1
  extends MessageObserver
{
  C2CPttUploadProcessor$1(C2CPttUploadProcessor paramC2CPttUploadProcessor) {}
  
  public void onNotifyResultAfterSendRich(boolean paramBoolean, long paramLong, StatictisInfo paramStatictisInfo)
  {
    this.this$0.logRichMediaEvent("sendMsgFinish", "success:" + paramBoolean);
    this.this$0.copyStatisInfo(this.this$0.mStepMsg, false, paramBoolean, paramStatictisInfo);
    if (paramBoolean)
    {
      this.this$0.onSuccess();
      return;
    }
    this.this$0.onError();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.C2CPttUploadProcessor.1
 * JD-Core Version:    0.7.0.1
 */