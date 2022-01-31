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
    int i;
    if (UploadSession.access$1300(this.this$0) != 0L)
    {
      long l = System.currentTimeMillis() - UploadSession.access$1300(this.this$0);
      if (l < this.val$responseTimeout)
      {
        i = 1;
        int j = (int)(this.val$responseTimeout - l);
        if (i == 0) {
          break label69;
        }
        UploadSession.access$1200(this.this$0).postDelayed(this, j);
      }
    }
    label69:
    do
    {
      return;
      i = 0;
      break;
      SparseArray localSparseArray = UploadSession.access$1100(this.this$0);
      UploadSession.RequestWrapper localRequestWrapper = (UploadSession.RequestWrapper)localSparseArray.get(this.val$requestSequence);
      if ((localRequestWrapper == null) || (localRequestWrapper.runnable != this))
      {
        UploadLog.w("UploadSession", "execute timeout runnable has been removed. reqId=" + this.val$requestSequence + " sid=" + UploadSession.access$100(this.this$0));
        return;
      }
      UploadLog.w("UploadSession", "ResponseTime! actionId=" + localRequestWrapper.request.getTaskId() + " reqId=" + this.val$requestSequence + " cmd=" + localRequestWrapper.request.getCmdId() + " sid=" + UploadSession.access$100(this.this$0) + " currState=" + UploadSession.access$200(this.this$0).toString());
      localSparseArray.remove(this.val$requestSequence);
      UploadSession.access$1200(this.this$0).removeCallbacks(localRequestWrapper.runnable);
      localRequestWrapper.runnable = null;
    } while ((UploadSession.access$200(this.this$0) != IUploadSession.SessionState.ESTABLISHED) || (this.val$request == null) || (this.val$request.getListener() == null));
    this.val$request.getListener().onRequestTimeout(this.val$request, this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.network.session.UploadSession.9
 * JD-Core Version:    0.7.0.1
 */