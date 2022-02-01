package com.tencent.mobileqq.transfile;

import anyz;
import anza;
import com.tencent.qphone.base.util.QLog;

class GroupPicUploadProcessor$5
  extends anyz
{
  GroupPicUploadProcessor$5(GroupPicUploadProcessor paramGroupPicUploadProcessor) {}
  
  public void onNotifyResultAfterSendRich(boolean paramBoolean, long paramLong, anza paramanza)
  {
    if ((this.this$0.mUiRequest.mUinType == 1026) && (QLog.isColorLevel())) {
      QLog.i("PttShow", 2, "onNotifyResultAfterSendRich, UIN_TYPE_HOTCHAT_TOPIC  " + paramBoolean);
    }
    this.this$0.logRichMediaEvent("sendMsgFinish", "success:" + paramBoolean);
    this.this$0.copyStatisInfo(this.this$0.mStepMsg, false, paramBoolean, paramanza);
    if (paramBoolean)
    {
      this.this$0.onSuccess();
      return;
    }
    if (paramanza != null) {
      this.this$0.shouldMsgReportSucc = paramanza.d;
    }
    this.this$0.onError();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.GroupPicUploadProcessor.5
 * JD-Core Version:    0.7.0.1
 */