package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.app.MediaMessageObserver;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.transfile.report.ProcessorReport;

class ShortVideoForwardProcessor$4
  extends MediaMessageObserver
{
  ShortVideoForwardProcessor$4(ShortVideoForwardProcessor paramShortVideoForwardProcessor) {}
  
  public void onNotifyResultAfterSendRich(boolean paramBoolean, long paramLong, StatictisInfo paramStatictisInfo)
  {
    ShortVideoForwardProcessor localShortVideoForwardProcessor = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("success:");
    localStringBuilder.append(paramBoolean);
    localShortVideoForwardProcessor.logRichMediaEvent("sendMsgFinish", localStringBuilder.toString());
    this.this$0.mProcessorReport.copyStatisInfo(this.this$0.mProcessorReport.mStepMsg, false, paramBoolean, paramStatictisInfo);
    if (paramBoolean)
    {
      this.this$0.onSuccess();
      return;
    }
    this.this$0.onError();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ShortVideoForwardProcessor.4
 * JD-Core Version:    0.7.0.1
 */