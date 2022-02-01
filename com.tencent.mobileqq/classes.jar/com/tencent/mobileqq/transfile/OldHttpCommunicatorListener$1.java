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
    if (QLog.isColorLevel())
    {
      Object localObject = this.val$req;
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
    OldHttpCommunicatorListener.access$000(this.this$0).innerSendReq(this.this$0.httpReq, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.OldHttpCommunicatorListener.1
 * JD-Core Version:    0.7.0.1
 */