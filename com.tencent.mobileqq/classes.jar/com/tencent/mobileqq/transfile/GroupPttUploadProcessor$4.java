package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.qphone.base.util.QLog;

class GroupPttUploadProcessor$4
  extends MessageObserver
{
  GroupPttUploadProcessor$4(GroupPttUploadProcessor paramGroupPttUploadProcessor) {}
  
  public void onNotifyResultAfterSendRich(boolean paramBoolean, long paramLong, StatictisInfo paramStatictisInfo)
  {
    if ((this.this$0.mUiRequest.mUinType == 1026) && (QLog.isColorLevel())) {
      QLog.i("PttShow", 2, "onNotifyResultAfterSendRich, UIN_TYPE_HOTCHAT_TOPIC  " + paramBoolean);
    }
    this.this$0.logRichMediaEvent("sendMsgFinish", "success:" + paramBoolean);
    this.this$0.copyStatisInfo(this.this$0.mStepMsg, false, paramBoolean, paramStatictisInfo);
    if (paramBoolean)
    {
      this.this$0.onSuccess();
      return;
    }
    if (paramStatictisInfo != null) {
      this.this$0.shouldMsgReportSucc = paramStatictisInfo.d;
    }
    this.this$0.onError();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.GroupPttUploadProcessor.4
 * JD-Core Version:    0.7.0.1
 */