package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

class OldHttpCommunicatorListener$2
  extends TimerTask
{
  OldHttpCommunicatorListener$2(OldHttpCommunicatorListener paramOldHttpCommunicatorListener, HttpNetReq paramHttpNetReq) {}
  
  public void run()
  {
    boolean bool = true;
    String str;
    if ((QLog.isColorLevel()) && (this.val$req != null))
    {
      str = TransFileUtil.getUinDesc(this.val$req.mBusiProtoType);
      if (this.val$req.mHttpMethod != 1) {
        break label100;
      }
    }
    for (;;)
    {
      TransFileUtil.log(str, bool, String.valueOf(this.val$req.mFileType), this.val$req.mMsgId, "scheduleRetry", "mIsCancelled:" + this.this$0.mIsCancelled);
      if (!this.this$0.mIsCancelled.get()) {
        break;
      }
      return;
      label100:
      bool = false;
    }
    this.this$0.httpMsg.setHttpErrorCode(9004, -1, "nonetwork");
    this.this$0.handleError(this.this$0.httpMsg, this.this$0.httpMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.OldHttpCommunicatorListener.2
 * JD-Core Version:    0.7.0.1
 */