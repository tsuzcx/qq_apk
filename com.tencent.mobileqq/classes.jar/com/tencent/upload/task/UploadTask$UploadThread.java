package com.tencent.upload.task;

import com.tencent.upload.network.session.IUploadSession;
import com.tencent.upload.request.IActionRequest;
import com.tencent.upload.request.impl.FileUploadRequest;
import com.tencent.upload.utils.UploadLog;
import java.util.concurrent.Future;

class UploadTask$UploadThread
  implements Runnable
{
  AtomFile tFile;
  private boolean tFinish;
  Future tFuture;
  long tId;
  IUploadSession tSession;
  String tTAG;
  boolean tWaitFlag = true;
  
  public UploadTask$UploadThread(UploadTask paramUploadTask, AtomFile paramAtomFile, IUploadSession paramIUploadSession)
  {
    this.tFile = paramAtomFile;
    this.tSession = paramIUploadSession;
    this.tId = hashCode();
    paramUploadTask = new StringBuilder();
    paramUploadTask.append("[UploadThread-");
    paramUploadTask.append(this.tId);
    paramUploadTask.append("-");
    paramUploadTask.append(paramIUploadSession.getUploadRoute());
    paramUploadTask.append("]");
    this.tTAG = paramUploadTask.toString();
  }
  
  private void terminate()
  {
    try
    {
      boolean bool = this.tFinish;
      if (bool) {
        return;
      }
      this.tFinish = true;
      notify();
      return;
    }
    finally {}
  }
  
  private void terminateWithRetry()
  {
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.tTAG);
      ((StringBuilder)localObject1).append("terminateWithRetry --- ");
      UploadLog.w("UploadTask", ((StringBuilder)localObject1).toString());
      terminate();
      localObject1 = this.this$0;
      ((UploadTask)localObject1).mNetworkRetryCount += 1;
      this.this$0.postExecute(0, true);
      return;
    }
    finally
    {
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  void notifySendend()
  {
    try
    {
      this.tWaitFlag = false;
      notify();
      return;
    }
    finally {}
  }
  
  public void quit()
  {
    terminate();
  }
  
  public void run()
  {
    this.this$0.setTaskStatus(TaskState.SENDING);
    StringBuilder localStringBuilder;
    synchronized (this.tFile)
    {
      do
      {
        Object localObject3 = this.this$0.getFileUploadRequest(this.tFile);
        if (localObject3 != null)
        {
          this.this$0.mFileSendOffset = (((FileUploadRequest)localObject3).mOffset + ((FileUploadRequest)localObject3).getRealDataSize());
          this.this$0.mLastSliceSize = ((FileUploadRequest)localObject3).getRealDataSize();
          this.this$0.mLastSendOffset = ((FileUploadRequest)localObject3).mOffset;
          this.this$0.mDataPkgEndTime = System.currentTimeMillis();
          ((FileUploadRequest)localObject3).setTag(this);
        }
        if (localObject3 == null)
        {
          ??? = new StringBuilder();
          ((StringBuilder)???).append(this.tTAG);
          ((StringBuilder)???).append(" request == null, send over!!");
          UploadLog.d("UploadTask", ((StringBuilder)???).toString());
          break;
        }
        this.tWaitFlag = true;
        boolean bool = this.tSession.send((IActionRequest)localObject3, this.this$0);
        ??? = new StringBuilder();
        ((StringBuilder)???).append(this.tTAG);
        ((StringBuilder)???).append(" send result=");
        ((StringBuilder)???).append(bool);
        ((StringBuilder)???).append(" reqId=");
        ((StringBuilder)???).append(((FileUploadRequest)localObject3).getRequestId());
        UploadLog.d("[transfer] UploadTask", ((StringBuilder)???).toString());
        UploadTask.access$000(this.this$0);
        if (!bool)
        {
          terminateWithRetry();
          break;
        }
        try
        {
          try
          {
            if (this.tWaitFlag) {
              wait();
            }
          }
          finally {}
          if (this.tFinish) {
            break;
          }
        }
        catch (Exception localException)
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(this.tTAG);
          ((StringBuilder)localObject3).append("run tFinish: ");
          ((StringBuilder)localObject3).append(this.tFinish);
          ((StringBuilder)localObject3).append(" mFinish: ");
          ((StringBuilder)localObject3).append(this.this$0.mFinish);
          UploadLog.e("[transfer] UploadTask", ((StringBuilder)localObject3).toString(), localException);
        }
      } while (!this.this$0.mFinish);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.tTAG);
      localStringBuilder.append(" thread finish threadId=");
      localStringBuilder.append(this.tId);
      localStringBuilder.append(" mFinish=");
      localStringBuilder.append(this.this$0.mFinish);
      UploadLog.d("[transfer] UploadTask", localStringBuilder.toString());
      return;
    }
    for (;;)
    {
      throw localObject4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.upload.task.UploadTask.UploadThread
 * JD-Core Version:    0.7.0.1
 */