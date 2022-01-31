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
    if (this.val$callback != this.this$0)
    {
      ((NetworkEngine)this.val$callback).stop();
      return;
    }
    UploadLog.d("UploadSession", "Session DisConnected. sid=" + UploadSession.access$100(this.this$0) + " currState=" + UploadSession.access$200(this.this$0).toString());
    IUploadSessionCallback localIUploadSessionCallback = (IUploadSessionCallback)UploadSession.access$400(this.this$0).get();
    if ((localIUploadSessionCallback != null) && (this.this$0.getState() == IUploadSession.SessionState.ESTABLISHED)) {
      localIUploadSessionCallback.onSessionClosed(this.this$0);
    }
    UploadSession.access$500(this.this$0, IUploadSession.SessionState.NO_CONNECT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.network.session.UploadSession.3
 * JD-Core Version:    0.7.0.1
 */