package com.tencent.upload.network.session;

import android.util.SparseArray;
import com.tencent.upload.network.base.IConnectionCallback;
import com.tencent.upload.network.base.NetworkEngine;
import com.tencent.upload.request.IActionRequest;
import com.tencent.upload.utils.Const.UploadRetCode;
import com.tencent.upload.utils.UploadLog;
import java.lang.ref.WeakReference;

class UploadSession$5
  implements Runnable
{
  UploadSession$5(UploadSession paramUploadSession, IConnectionCallback paramIConnectionCallback, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    Object localObject = this.val$callback;
    if (localObject != this.this$0)
    {
      ((NetworkEngine)localObject).stop();
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doSendTimeout! sid=");
    localStringBuilder.append(UploadSession.access$100(this.this$0));
    localStringBuilder.append(" seq:");
    localStringBuilder.append(this.val$sendSequence);
    localStringBuilder.append(" reason:");
    localStringBuilder.append(this.val$reason);
    localStringBuilder.append(" currState=");
    localStringBuilder.append(UploadSession.access$200(this.this$0).toString());
    localStringBuilder.append(" timeout route:");
    if (UploadSession.access$700(this.this$0) == null) {
      localObject = "null";
    } else {
      localObject = UploadSession.access$700(this.this$0);
    }
    localStringBuilder.append(localObject);
    UploadLog.w("UploadSession", localStringBuilder.toString());
    if (UploadSession.access$200(this.this$0) == IUploadSession.SessionState.ESTABLISHED)
    {
      localObject = (IActionRequest)UploadSession.access$800(this.this$0).get(this.val$sendSequence);
      if ((localObject != null) && (((IActionRequest)localObject).getListener() != null)) {
        ((IActionRequest)localObject).getListener().onRequestTimeout((IActionRequest)localObject, this.this$0);
      }
      localObject = (IUploadSessionCallback)UploadSession.access$400(this.this$0).get();
      if (localObject != null)
      {
        ((IUploadSessionCallback)localObject).onSessionError(this.this$0, Const.UploadRetCode.REQUEST_TIMEOUT.getCode(), Const.UploadRetCode.REQUEST_TIMEOUT.getDesc());
        UploadSession.access$202(this.this$0, IUploadSession.SessionState.NO_CONNECT);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.upload.network.session.UploadSession.5
 * JD-Core Version:    0.7.0.1
 */