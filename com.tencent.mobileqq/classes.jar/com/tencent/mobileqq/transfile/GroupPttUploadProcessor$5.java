package com.tencent.mobileqq.transfile;

import amwl;
import amwm;
import com.tencent.qphone.base.util.QLog;

class GroupPttUploadProcessor$5
  extends amwl
{
  GroupPttUploadProcessor$5(GroupPttUploadProcessor paramGroupPttUploadProcessor) {}
  
  public void onNotifyResultAfterSendRich(boolean paramBoolean, long paramLong, amwm paramamwm)
  {
    if ((this.this$0.mUiRequest.mUinType == 1026) && (QLog.isColorLevel())) {
      QLog.i("PttShow", 2, "onNotifyResultAfterSendRich, UIN_TYPE_HOTCHAT_TOPIC  " + paramBoolean);
    }
    this.this$0.logRichMediaEvent("sendMsgFinish", "success:" + paramBoolean);
    this.this$0.copyStatisInfo(this.this$0.mStepMsg, false, paramBoolean, paramamwm);
    if (paramBoolean)
    {
      this.this$0.onSuccess();
      return;
    }
    if (paramamwm != null) {
      this.this$0.shouldMsgReportSucc = paramamwm.d;
    }
    this.this$0.onError();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.GroupPttUploadProcessor.5
 * JD-Core Version:    0.7.0.1
 */