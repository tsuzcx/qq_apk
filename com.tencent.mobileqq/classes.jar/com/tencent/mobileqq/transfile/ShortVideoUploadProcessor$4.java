package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.LogTag;

class ShortVideoUploadProcessor$4
  extends MessageObserver
{
  ShortVideoUploadProcessor$4(ShortVideoUploadProcessor paramShortVideoUploadProcessor) {}
  
  public void onNotifyResultAfterSendRich(boolean paramBoolean, long paramLong, StatictisInfo paramStatictisInfo)
  {
    this.this$0.logRichMediaEvent("sendMsgFinish", "success:" + paramBoolean);
    LogTag.a(String.valueOf(this.this$0.mUiRequest.mUniseq), "message", "sendMsgFinish isSuccess:" + paramBoolean + ",mr = " + this.this$0.mUiRequest.mRec.toString());
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
 * Qualified Name:     com.tencent.mobileqq.transfile.ShortVideoUploadProcessor.4
 * JD-Core Version:    0.7.0.1
 */