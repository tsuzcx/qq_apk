package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

class OldHttpEngine$OldHttpCommunicatorListner$2
  extends TimerTask
{
  OldHttpEngine$OldHttpCommunicatorListner$2(OldHttpEngine.OldHttpCommunicatorListner paramOldHttpCommunicatorListner, HttpNetReq paramHttpNetReq) {}
  
  public void run()
  {
    boolean bool = true;
    int i;
    if ((QLog.isColorLevel()) && (this.val$req != null))
    {
      i = this.val$req.mBusiProtoType;
      if (this.val$req.mHttpMethod != 1) {
        break label94;
      }
    }
    for (;;)
    {
      RichMediaUtil.log(i, bool, this.val$req.mFileType, this.val$req.mMsgId, "scheduleRetry", "mIsCancelled:" + this.this$1.mIsCancelled);
      if (!this.this$1.mIsCancelled.get()) {
        break;
      }
      return;
      label94:
      bool = false;
    }
    this.this$1.httpMsg.setHttpErrorCode(9004, -1, "nonetwork");
    this.this$1.handleError(this.this$1.httpMsg, this.this$1.httpMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.OldHttpEngine.OldHttpCommunicatorListner.2
 * JD-Core Version:    0.7.0.1
 */