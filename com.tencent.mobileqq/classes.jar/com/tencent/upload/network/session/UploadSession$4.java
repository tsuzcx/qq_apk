package com.tencent.upload.network.session;

import com.tencent.upload.network.base.IConnectionCallback;
import com.tencent.upload.utils.Const.UploadRetCode;
import com.tencent.upload.utils.UploadLog;

class UploadSession$4
  implements Runnable
{
  UploadSession$4(UploadSession paramUploadSession, int paramInt, IConnectionCallback paramIConnectionCallback) {}
  
  public void run()
  {
    int j = this.val$socketStatus;
    int i = j;
    if (SessionPool.isNetworkUnavailable(j)) {
      i = Const.UploadRetCode.NETWORK_NOT_AVAILABLE.getCode();
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Session Error. sid=");
    ((StringBuilder)localObject).append(UploadSession.access$100(this.this$0));
    ((StringBuilder)localObject).append(" socket_status=");
    ((StringBuilder)localObject).append(this.val$socketStatus);
    UploadLog.w("UploadSession", ((StringBuilder)localObject).toString());
    localObject = this.this$0;
    IConnectionCallback localIConnectionCallback = this.val$callback;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("NDK Network Error: ");
    localStringBuilder.append(i);
    UploadSession.access$600((UploadSession)localObject, localIConnectionCallback, i, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.upload.network.session.UploadSession.4
 * JD-Core Version:    0.7.0.1
 */