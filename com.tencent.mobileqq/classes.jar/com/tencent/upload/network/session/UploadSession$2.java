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
    Object localObject;
    if (this.val$callback != this.this$0)
    {
      localObject = (NetworkEngine)this.val$callback;
      UploadLog.d("[connect] UploadSession", "doAfterConnect. sid=" + UploadSession.access$100(this.this$0) + " succeed=" + this.val$isSuccess + " errorCode=" + this.val$errorCode + " ip=" + this.val$connectedIp + " The connection is invalid, close it!" + ((NetworkEngine)localObject).hashCode());
      ((NetworkEngine)localObject).stop();
    }
    do
    {
      do
      {
        do
        {
          return;
          UploadLog.d("[connect] UploadSession", "doAfterConnect. sid=" + UploadSession.access$100(this.this$0) + " succeed=" + this.val$isSuccess + " errorCode=" + this.val$errorCode + " ip=" + this.val$connectedIp + " currState=" + UploadSession.access$200(this.this$0).toString());
        } while (UploadSession.access$200(this.this$0) != IUploadSession.SessionState.CONNECTING);
        if (!this.val$isSuccess) {
          break;
        }
        this.this$0.recordLastActiveTime();
        UploadLog.d("[connect] UploadSession", "sid=" + UploadSession.access$100(this.this$0) + ", connect succeed:" + this.val$isSuccess + ", ip=" + this.val$connectedIp + ", currState=" + UploadSession.access$200(this.this$0).toString());
        UploadSession.access$302(this.this$0, this.val$connectedIp);
        UploadSession.access$202(this.this$0, IUploadSession.SessionState.ESTABLISHED);
        localObject = (IUploadSessionCallback)UploadSession.access$400(this.this$0).get();
      } while (localObject == null);
      ((IUploadSessionCallback)localObject).onOpenSucceed(this.this$0);
      return;
      localObject = (IUploadSessionCallback)UploadSession.access$400(this.this$0).get();
    } while (localObject == null);
    UploadSession.access$202(this.this$0, IUploadSession.SessionState.NO_CONNECT);
    ((IUploadSessionCallback)localObject).onOpenFailed(this.this$0, this.val$errorCode, "连接失败");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.network.session.UploadSession.2
 * JD-Core Version:    0.7.0.1
 */