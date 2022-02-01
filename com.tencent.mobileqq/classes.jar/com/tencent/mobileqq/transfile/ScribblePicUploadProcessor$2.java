package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.app.MediaMessageObserver;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.transfile.report.ProcessorReport;

class ScribblePicUploadProcessor$2
  extends MediaMessageObserver
{
  ScribblePicUploadProcessor$2(ScribblePicUploadProcessor paramScribblePicUploadProcessor) {}
  
  public void onNotifyResultAfterSendRich(boolean paramBoolean, long paramLong, StatictisInfo paramStatictisInfo)
  {
    ScribblePicUploadProcessor localScribblePicUploadProcessor = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("success:");
    localStringBuilder.append(paramBoolean);
    localScribblePicUploadProcessor.logRichMediaEvent("sendMsgFinish", localStringBuilder.toString());
    this.this$0.mProcessorReport.copyStatisInfo(this.this$0.mProcessorReport.mStepMsg, false, paramBoolean, paramStatictisInfo);
    if (paramBoolean)
    {
      this.this$0.onSuccess();
      return;
    }
    if (paramStatictisInfo != null) {
      this.this$0.shouldMsgReportSucc = paramStatictisInfo.f;
    }
    this.this$0.mProcessorReport.setError(-1, "MessageForScribble SEND FAIL", "", this.this$0.mProcessorReport.mStepTrans);
    this.this$0.onError();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ScribblePicUploadProcessor.2
 * JD-Core Version:    0.7.0.1
 */