package com.tencent.mobileqq.transfile;

import anyz;
import anza;

class ShortVideoForwardProcessor$6
  extends anyz
{
  ShortVideoForwardProcessor$6(ShortVideoForwardProcessor paramShortVideoForwardProcessor) {}
  
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
 * Qualified Name:     com.tencent.mobileqq.transfile.ShortVideoForwardProcessor.6
 * JD-Core Version:    0.7.0.1
 */