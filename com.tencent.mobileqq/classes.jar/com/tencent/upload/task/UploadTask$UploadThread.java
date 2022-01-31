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
    this.tTAG = ("[UploadThread-" + this.tId + "-" + paramIUploadSession.getUploadRoute() + "]");
  }
  
  /* Error */
  private void terminate()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 75	com/tencent/upload/task/UploadTask$UploadThread:tFinish	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 75	com/tencent/upload/task/UploadTask$UploadThread:tFinish	Z
    //   19: aload_0
    //   20: invokevirtual 78	java/lang/Object:notify	()V
    //   23: goto -12 -> 11
    //   26: astore_2
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_2
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	UploadThread
    //   6	2	1	bool	boolean
    //   26	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	26	finally
    //   14	23	26	finally
  }
  
  private void terminateWithRetry()
  {
    try
    {
      UploadLog.w("UploadTask", this.tTAG + "terminateWithRetry --- ");
      terminate();
      UploadTask localUploadTask = this.this$0;
      localUploadTask.mNetworkRetryCount += 1;
      this.this$0.postExecute(0, true);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
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
    for (;;)
    {
      synchronized (this.tFile)
      {
        FileUploadRequest localFileUploadRequest = this.this$0.getFileUploadRequest(this.tFile);
        if (localFileUploadRequest != null)
        {
          this.this$0.mFileSendOffset = (localFileUploadRequest.mOffset + localFileUploadRequest.getRealDataSize());
          this.this$0.mLastSliceSize = localFileUploadRequest.getRealDataSize();
          this.this$0.mLastSendOffset = localFileUploadRequest.mOffset;
          this.this$0.mDataPkgEndTime = System.currentTimeMillis();
          localFileUploadRequest.setTag(this);
        }
        if (localFileUploadRequest == null)
        {
          UploadLog.d("UploadTask", this.tTAG + " request == null, send over!!");
          label120:
          UploadLog.d("[transfer] UploadTask", this.tTAG + " thread finish threadId=" + this.tId + " mFinish=" + this.this$0.mFinish);
          return;
        }
      }
      this.tWaitFlag = true;
      boolean bool = this.tSession.send(localIActionRequest, this.this$0);
      UploadLog.d("[transfer] UploadTask", this.tTAG + " send result=" + bool + " reqId=" + localIActionRequest.getRequestId());
      UploadTask.access$000(this.this$0);
      if (!bool)
      {
        terminateWithRetry();
        continue;
      }
      for (;;)
      {
        try {}catch (Exception localException)
        {
          UploadLog.e("[transfer] UploadTask", this.tTAG + "run tFinish: " + this.tFinish + " mFinish: " + this.this$0.mFinish, localException);
          continue;
        }
        try
        {
          if (this.tWaitFlag) {
            wait();
          }
          if (this.tFinish) {
            break label120;
          }
          if (!this.this$0.mFinish) {
            break;
          }
          break label120;
        }
        finally {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.upload.task.UploadTask.UploadThread
 * JD-Core Version:    0.7.0.1
 */