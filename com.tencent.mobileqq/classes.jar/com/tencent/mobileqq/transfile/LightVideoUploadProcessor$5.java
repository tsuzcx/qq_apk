package com.tencent.mobileqq.transfile;

import baid;
import baie;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Map;

class LightVideoUploadProcessor$5
  implements Runnable
{
  LightVideoUploadProcessor$5(LightVideoUploadProcessor paramLightVideoUploadProcessor, baid parambaid) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoSend", 2, "onSendSliceFinish, info:" + this.val$info + " mSendingInfos:" + this.this$0.mSendingInfos.size() + " mReadyToSendInfos:" + this.this$0.mReadyToSendInfos.size());
    }
    this.this$0.mSendingInfos.remove(Integer.valueOf(this.val$info.d));
    if (this.this$0.mReadyToSendInfos.size() > 0) {
      this.this$0.sendSlice();
    }
    while ((this.this$0.mReadyToSendInfos.size() != 0) || (this.this$0.mSendingInfos.size() != 0) || (LightVideoUploadProcessor.access$400(this.this$0) == null) || (!LightVideoUploadProcessor.access$400(this.this$0).a())) {
      return;
    }
    this.this$0.sendAckToBDHServer();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.LightVideoUploadProcessor.5
 * JD-Core Version:    0.7.0.1
 */