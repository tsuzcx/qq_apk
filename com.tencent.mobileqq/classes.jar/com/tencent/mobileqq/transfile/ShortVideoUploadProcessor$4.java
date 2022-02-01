package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.app.MediaMessageObserver;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.mobileqq.utils.LogTag;
import com.tencent.qphone.base.util.QLog;

class ShortVideoUploadProcessor$4
  extends MediaMessageObserver
{
  ShortVideoUploadProcessor$4(ShortVideoUploadProcessor paramShortVideoUploadProcessor) {}
  
  public void onNotifyResultAfterSendRich(boolean paramBoolean, long paramLong, StatictisInfo paramStatictisInfo)
  {
    if (this.this$0.mUiRequest.mUinType == 10014)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onNotifyResultAfterSendRich seq:");
      ((StringBuilder)localObject).append(this.this$0.mUiRequest.mUniseq);
      QLog.i("ShortVideoUploadProcessor<gld>.video", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("success:");
    localStringBuilder.append(paramBoolean);
    ((ShortVideoUploadProcessor)localObject).logRichMediaEvent("sendMsgFinish", localStringBuilder.toString());
    paramLong = this.this$0.mUiRequest.mUniseq;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("sendMsgFinish isSuccess:");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(",mr = ");
    ((StringBuilder)localObject).append(this.this$0.mUiRequest.mRec.toString());
    LogTag.a(String.valueOf(paramLong), "message", ((StringBuilder)localObject).toString());
    this.this$0.mProcessorReport.copyStatisInfo(this.this$0.mProcessorReport.mStepMsg, false, paramBoolean, paramStatictisInfo);
    if (paramBoolean)
    {
      this.this$0.onSuccess();
      return;
    }
    this.this$0.onError();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ShortVideoUploadProcessor.4
 * JD-Core Version:    0.7.0.1
 */