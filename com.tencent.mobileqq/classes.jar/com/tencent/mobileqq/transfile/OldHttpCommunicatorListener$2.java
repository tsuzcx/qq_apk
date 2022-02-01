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
    if (QLog.isColorLevel())
    {
      localObject = this.val$req;
      if (localObject != null)
      {
        localObject = TransFileUtil.getUinDesc(((HttpNetReq)localObject).mBusiProtoType);
        int i = this.val$req.mHttpMethod;
        boolean bool = true;
        if (i != 1) {
          bool = false;
        }
        i = this.val$req.mFileType;
        String str = this.val$req.mMsgId;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("mIsCancelled:");
        localStringBuilder.append(this.this$0.mIsCancelled);
        TransFileUtil.log((String)localObject, bool, String.valueOf(i), str, "scheduleRetry", localStringBuilder.toString());
      }
    }
    if (this.this$0.mIsCancelled.get()) {
      return;
    }
    this.this$0.httpMsg.setHttpErrorCode(9004, -1, "nonetwork");
    Object localObject = this.this$0;
    ((OldHttpCommunicatorListener)localObject).handleError(((OldHttpCommunicatorListener)localObject).httpMsg, this.this$0.httpMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.OldHttpCommunicatorListener.2
 * JD-Core Version:    0.7.0.1
 */