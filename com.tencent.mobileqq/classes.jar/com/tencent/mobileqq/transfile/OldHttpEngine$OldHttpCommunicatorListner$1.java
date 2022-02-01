package com.tencent.mobileqq.transfile;

import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

class OldHttpEngine$OldHttpCommunicatorListner$1
  implements Runnable
{
  OldHttpEngine$OldHttpCommunicatorListner$1(OldHttpEngine.OldHttpCommunicatorListner paramOldHttpCommunicatorListner, HttpNetReq paramHttpNetReq) {}
  
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
    this.this$1.this$0.innerSendReq(this.this$1.httpReq, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.OldHttpEngine.OldHttpCommunicatorListner.1
 * JD-Core Version:    0.7.0.1
 */