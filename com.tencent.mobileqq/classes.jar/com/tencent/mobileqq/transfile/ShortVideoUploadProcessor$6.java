package com.tencent.mobileqq.transfile;

import amwl;
import amwm;
import bfwl;
import com.tencent.mobileqq.data.MessageRecord;

class ShortVideoUploadProcessor$6
  extends amwl
{
  ShortVideoUploadProcessor$6(ShortVideoUploadProcessor paramShortVideoUploadProcessor) {}
  
  public void onNotifyResultAfterSendRich(boolean paramBoolean, long paramLong, amwm paramamwm)
  {
    this.this$0.logRichMediaEvent("sendMsgFinish", "success:" + paramBoolean);
    bfwl.a(String.valueOf(this.this$0.mUiRequest.mUniseq), "message", "sendMsgFinish isSuccess:" + paramBoolean + ",mr = " + this.this$0.mUiRequest.mRec.toString());
    this.this$0.copyStatisInfo(this.this$0.mStepMsg, false, paramBoolean, paramamwm);
    if (paramBoolean)
    {
      this.this$0.onSuccess();
      return;
    }
    this.this$0.onError();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ShortVideoUploadProcessor.6
 * JD-Core Version:    0.7.0.1
 */