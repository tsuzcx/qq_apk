package com.tencent.upload.network.session;

import com.tencent.upload.network.base.IConnectionCallback;
import com.tencent.upload.network.base.NetworkEngine;
import com.tencent.upload.utils.UploadLog;
import java.lang.ref.WeakReference;

class UploadSession$3
  implements Runnable
{
  UploadSession$3(UploadSession paramUploadSession, IConnectionCallback paramIConnectionCallback) {}
  
  public void run()
  {
    Object localObject = this.val$callback;
    if (localObject != this.this$0)
    {
      ((NetworkEngine)localObject).stop();
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Session DisConnected. sid=");
    ((StringBuilder)localObject).append(UploadSession.access$100(this.this$0));
    ((StringBuilder)localObject).append(" currState=");
    ((StringBuilder)localObject).append(UploadSession.access$200(this.this$0).toString());
    UploadLog.d("UploadSession", ((StringBuilder)localObject).toString());
    localObject = (IUploadSessionCallback)UploadSession.access$400(this.this$0).get();
    if ((localObject != null) && (this.this$0.getState() == IUploadSession.SessionState.ESTABLISHED)) {
      ((IUploadSessionCallback)localObject).onSessionClosed(this.this$0);
    }
    UploadSession.access$500(this.this$0, IUploadSession.SessionState.NO_CONNECT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.upload.network.session.UploadSession.3
 * JD-Core Version:    0.7.0.1
 */