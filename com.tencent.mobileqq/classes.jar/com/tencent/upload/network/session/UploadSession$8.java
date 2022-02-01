package com.tencent.upload.network.session;

import android.os.Handler;
import android.util.SparseArray;
import com.tencent.upload.request.IActionRequest;
import com.tencent.upload.utils.UploadLog;

class UploadSession$8
  implements Runnable
{
  UploadSession$8(UploadSession paramUploadSession, int paramInt) {}
  
  public void run()
  {
    this.this$0.recordLastActiveTime();
    Object localObject = (IActionRequest)UploadSession.access$800(this.this$0).get(this.val$sendSequence);
    if (localObject == null)
    {
      UploadLog.w("[transfer] UploadSession", "doSendEnd request== null. reqId=" + this.val$sendSequence + ", sid=" + UploadSession.access$100(this.this$0));
      return;
    }
    UploadLog.d("[transfer] UploadSession", "Send Request End. sid=" + UploadSession.access$100(this.this$0) + ", taskId=" + ((IActionRequest)localObject).getTaskId() + ", reqId=" + ((IActionRequest)localObject).getRequestId());
    UploadSession.access$800(this.this$0).delete(this.val$sendSequence);
    if (((IActionRequest)localObject).getListener() != null) {
      ((IActionRequest)localObject).getListener().onRequestSended((IActionRequest)localObject);
    }
    localObject = (UploadSession.RequestWrapper)UploadSession.access$1100(this.this$0).get(this.val$sendSequence);
    if ((localObject != null) && (((UploadSession.RequestWrapper)localObject).request != null) && (!((UploadSession.RequestWrapper)localObject).request.needTimeout()))
    {
      if (((UploadSession.RequestWrapper)localObject).runnable != null) {
        UploadSession.access$1200(this.this$0).removeCallbacks(((UploadSession.RequestWrapper)localObject).runnable);
      }
      ((UploadSession.RequestWrapper)localObject).runnable = null;
    }
    UploadSession.access$000(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.upload.network.session.UploadSession.8
 * JD-Core Version:    0.7.0.1
 */