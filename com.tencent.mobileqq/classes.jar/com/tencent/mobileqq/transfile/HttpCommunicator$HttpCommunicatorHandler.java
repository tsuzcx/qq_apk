package com.tencent.mobileqq.transfile;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import java.net.HttpURLConnection;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

class HttpCommunicator$HttpCommunicatorHandler
  extends Handler
{
  public static final int QUIT = 1;
  public static final int RUN = 0;
  public HttpMsg curReq;
  public AtomicBoolean forceFinish = new AtomicBoolean();
  public int index;
  public AtomicBoolean isProcReq = new AtomicBoolean();
  
  public HttpCommunicator$HttpCommunicatorHandler(HttpCommunicator paramHttpCommunicator, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message arg1)
  {
    if (???.what == 0)
    {
      if ((HttpCommunicator.access$300(this.this$0) != null) && (HttpCommunicator.access$400(this.this$0) != null)) {
        HttpCommunicator.access$300(this.this$0).removeCallbacks(HttpCommunicator.access$400(this.this$0));
      }
      if ((???.obj != null) && ((???.obj instanceof HttpMsg)))
      {
        HttpMsg localHttpMsg = (HttpMsg)???.obj;
        if (!localHttpMsg.mIsCancel.get())
        {
          this.this$0.run(localHttpMsg, this);
          if (localHttpMsg.lockForSyncSend != null)
          {
            localHttpMsg.hasFinished.set(true);
            synchronized (localHttpMsg.lockForSyncSend)
            {
              localHttpMsg.lockForSyncSend.notify();
            }
          }
          if (this.forceFinish.get())
          {
            getLooper().quit();
            return;
          }
          this.isProcReq.set(false);
          this.curReq = null;
          ???.obj = null;
          synchronized (HttpCommunicator.access$000(this.this$0))
          {
            HttpCommunicator.access$510(this.this$0);
            ??? = this.this$0;
            ??? = new StringBuilder();
            ((StringBuilder)???).append("handleMsgFin thread index:");
            ((StringBuilder)???).append(this.index);
            ???.disPatchMsg(((StringBuilder)???).toString());
          }
        }
        this.isProcReq.set(false);
        this.curReq = null;
        ???.obj = null;
      }
      if ((HttpCommunicator.access$600(this.this$0, false)) && (HttpCommunicator.access$300(this.this$0) != null))
      {
        HttpCommunicator.access$402(this.this$0, new HttpCommunicator.HttpCommunicatorHandler.1(this));
        HttpCommunicator.access$300(this.this$0).postDelayed(HttpCommunicator.access$400(this.this$0), 2000L);
      }
    }
    else if (???.what == 1)
    {
      getLooper().quit();
    }
  }
  
  public void interruptCurrentMsg()
  {
    try
    {
      if (this.curReq != null)
      {
        HttpCommunicator localHttpCommunicator = this.this$0;
        HttpMsg localHttpMsg = this.curReq;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("msgId:");
        localStringBuilder.append(this.curReq.msgId);
        localStringBuilder.append(" thread id:");
        localStringBuilder.append(this.index);
        localHttpCommunicator.logHttpCommunicator(localHttpMsg, "requeustInterupt", localStringBuilder.toString());
        this.curReq.mIsPreempted.set(true);
        if (this.curReq.mConn != null)
        {
          this.curReq.mConn.disconnect();
          getLooper().getThread().interrupt();
        }
        this.this$0.replaceNewThread(this);
        this.curReq.setHttpErrorCode(9361, 0, "preempted by higher msg");
        this.curReq.getProcessor().handleError(this.curReq, this.curReq);
        this.curReq = null;
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void sendRequestToProc(HttpMsg paramHttpMsg)
  {
    sendMessage(obtainMessage(0, paramHttpMsg));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.HttpCommunicator.HttpCommunicatorHandler
 * JD-Core Version:    0.7.0.1
 */