package com.tencent.upload.network.session;

import android.os.Handler;
import android.util.SparseArray;
import com.tencent.upload.request.IActionRequest;
import com.tencent.upload.utils.UploadLog;

class UploadSession$9
  implements Runnable
{
  UploadSession$9(UploadSession paramUploadSession, int paramInt1, int paramInt2, IActionRequest paramIActionRequest) {}
  
  public void run()
  {
    if (UploadSession.access$1300(this.this$0) != 0L)
    {
      long l = System.currentTimeMillis() - UploadSession.access$1300(this.this$0);
      int i;
      if (l < this.val$responseTimeout) {
        i = 1;
      } else {
        i = 0;
      }
      int j = (int)(this.val$responseTimeout - l);
      if (i != 0)
      {
        UploadSession.access$1200(this.this$0).postDelayed(this, j);
        return;
      }
    }
    Object localObject = UploadSession.access$1100(this.this$0);
    UploadSession.RequestWrapper localRequestWrapper = (UploadSession.RequestWrapper)((SparseArray)localObject).get(this.val$requestSequence);
    if ((localRequestWrapper != null) && (localRequestWrapper.runnable == this))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ResponseTime! actionId=");
      localStringBuilder.append(localRequestWrapper.request.getTaskId());
      localStringBuilder.append(" reqId=");
      localStringBuilder.append(this.val$requestSequence);
      localStringBuilder.append(" cmd=");
      localStringBuilder.append(localRequestWrapper.request.getCmdId());
      localStringBuilder.append(" sid=");
      localStringBuilder.append(UploadSession.access$100(this.this$0));
      localStringBuilder.append(" currState=");
      localStringBuilder.append(UploadSession.access$200(this.this$0).toString());
      UploadLog.w("UploadSession", localStringBuilder.toString());
      ((SparseArray)localObject).remove(this.val$requestSequence);
      UploadSession.access$1200(this.this$0).removeCallbacks(localRequestWrapper.runnable);
      localRequestWrapper.runnable = null;
      if (UploadSession.access$200(this.this$0) == IUploadSession.SessionState.ESTABLISHED)
      {
        localObject = this.val$request;
        if ((localObject != null) && (((IActionRequest)localObject).getListener() != null)) {
          this.val$request.getListener().onRequestTimeout(this.val$request, this.this$0);
        }
      }
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("execute timeout runnable has been removed. reqId=");
    ((StringBuilder)localObject).append(this.val$requestSequence);
    ((StringBuilder)localObject).append(" sid=");
    ((StringBuilder)localObject).append(UploadSession.access$100(this.this$0));
    UploadLog.w("UploadSession", ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.upload.network.session.UploadSession.9
 * JD-Core Version:    0.7.0.1
 */