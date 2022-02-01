package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.StatictisInfo;

class ShortVideoForwardProcessor$4
  extends MessageObserver
{
  ShortVideoForwardProcessor$4(ShortVideoForwardProcessor paramShortVideoForwardProcessor) {}
  
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
 * Qualified Name:     com.tencent.mobileqq.transfile.ShortVideoForwardProcessor.4
 * JD-Core Version:    0.7.0.1
 */