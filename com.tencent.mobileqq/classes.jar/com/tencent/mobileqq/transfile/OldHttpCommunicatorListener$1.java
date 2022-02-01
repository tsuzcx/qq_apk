package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.transfile.api.impl.HttpEngineServiceImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

class OldHttpCommunicatorListener$1
  implements Runnable
{
  OldHttpCommunicatorListener$1(OldHttpCommunicatorListener paramOldHttpCommunicatorListener, HttpNetReq paramHttpNetReq) {}
  
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
    OldHttpCommunicatorListener.access$000(this.this$0).innerSendReq(this.this$0.httpReq, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.OldHttpCommunicatorListener.1
 * JD-Core Version:    0.7.0.1
 */