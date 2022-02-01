package com.tencent.upload.network.session;

import com.tencent.upload.network.base.IConnectionCallback;
import com.tencent.upload.network.base.NetworkEngine;
import com.tencent.upload.utils.UploadLog;
import java.lang.ref.WeakReference;

class UploadSession$2
  implements Runnable
{
  UploadSession$2(UploadSession paramUploadSession, IConnectionCallback paramIConnectionCallback, boolean paramBoolean, int paramInt, String paramString) {}
  
  public void run()
  {
    Object localObject = this.val$callback;
    if (localObject != this.this$0)
    {
      localObject = (NetworkEngine)localObject;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doAfterConnect. sid=");
      localStringBuilder.append(UploadSession.access$100(this.this$0));
      localStringBuilder.append(" succeed=");
      localStringBuilder.append(this.val$isSuccess);
      localStringBuilder.append(" errorCode=");
      localStringBuilder.append(this.val$errorCode);
      localStringBuilder.append(" ip=");
      localStringBuilder.append(this.val$connectedIp);
      localStringBuilder.append(" The connection is invalid, close it!");
      localStringBuilder.append(((NetworkEngine)localObject).hashCode());
      UploadLog.d("[connect] UploadSession", localStringBuilder.toString());
      ((NetworkEngine)localObject).stop();
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doAfterConnect. sid=");
    ((StringBuilder)localObject).append(UploadSession.access$100(this.this$0));
    ((StringBuilder)localObject).append(" succeed=");
    ((StringBuilder)localObject).append(this.val$isSuccess);
    ((StringBuilder)localObject).append(" errorCode=");
    ((StringBuilder)localObject).append(this.val$errorCode);
    ((StringBuilder)localObject).append(" ip=");
    ((StringBuilder)localObject).append(this.val$connectedIp);
    ((StringBuilder)localObject).append(" currState=");
    ((StringBuilder)localObject).append(UploadSession.access$200(this.this$0).toString());
    UploadLog.d("[connect] UploadSession", ((StringBuilder)localObject).toString());
    if ((UploadSession.access$200(this.this$0) == IUploadSession.SessionState.CONNECTING) || (UploadSession.access$200(this.this$0) == IUploadSession.SessionState.NO_CONNECT)) {
      if (this.val$isSuccess)
      {
        this.this$0.recordLastActiveTime();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("sid=");
        ((StringBuilder)localObject).append(UploadSession.access$100(this.this$0));
        ((StringBuilder)localObject).append(", connect succeed:");
        ((StringBuilder)localObject).append(this.val$isSuccess);
        ((StringBuilder)localObject).append(", ip=");
        ((StringBuilder)localObject).append(this.val$connectedIp);
        ((StringBuilder)localObject).append(", currState=");
        ((StringBuilder)localObject).append(UploadSession.access$200(this.this$0).toString());
        UploadLog.d("[connect] UploadSession", ((StringBuilder)localObject).toString());
        UploadSession.access$302(this.this$0, this.val$connectedIp);
        UploadSession.access$202(this.this$0, IUploadSession.SessionState.ESTABLISHED);
        localObject = (IUploadSessionCallback)UploadSession.access$400(this.this$0).get();
        if (localObject != null) {
          ((IUploadSessionCallback)localObject).onOpenSucceed(this.this$0);
        }
      }
      else
      {
        localObject = (IUploadSessionCallback)UploadSession.access$400(this.this$0).get();
        if (localObject != null)
        {
          UploadSession.access$202(this.this$0, IUploadSession.SessionState.NO_CONNECT);
          ((IUploadSessionCallback)localObject).onOpenFailed(this.this$0, this.val$errorCode, "连接失败");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.upload.network.session.UploadSession.2
 * JD-Core Version:    0.7.0.1
 */