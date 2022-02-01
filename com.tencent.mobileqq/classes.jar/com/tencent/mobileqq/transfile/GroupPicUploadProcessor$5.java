package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.app.MediaMessageObserver;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.transfile.report.ProcessorReport;

class GroupPicUploadProcessor$5
  extends MediaMessageObserver
{
  GroupPicUploadProcessor$5(GroupPicUploadProcessor paramGroupPicUploadProcessor) {}
  
  public void onNotifyResultAfterSendRich(boolean paramBoolean, long paramLong, StatictisInfo paramStatictisInfo)
  {
    GroupPicUploadProcessor localGroupPicUploadProcessor = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("success:");
    localStringBuilder.append(paramBoolean);
    localGroupPicUploadProcessor.logRichMediaEvent("sendMsgFinish", localStringBuilder.toString());
    this.this$0.mProcessorReport.copyStatisInfo(this.this$0.mProcessorReport.mStepMsg, false, paramBoolean, paramStatictisInfo);
    if (paramBoolean)
    {
      this.this$0.onSuccess();
      return;
    }
    if (paramStatictisInfo != null) {
      this.this$0.shouldMsgReportSucc = paramStatictisInfo.f;
    }
    this.this$0.onError();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.GroupPicUploadProcessor.5
 * JD-Core Version:    0.7.0.1
 */