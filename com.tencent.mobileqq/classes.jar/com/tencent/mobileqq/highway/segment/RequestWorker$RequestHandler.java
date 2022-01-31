package com.tencent.mobileqq.highway.segment;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.conn.ConnManager;
import com.tencent.mobileqq.highway.transaction.Transaction;

public class RequestWorker$RequestHandler
  extends Handler
{
  public static final int CANCEL = 3;
  public static final int CONN = 4;
  public static final int PRECONN = 5;
  public static final int QUIT = 2;
  public static final int SEND = 1;
  
  public RequestWorker$RequestHandler(RequestWorker paramRequestWorker, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i == 1) {
      RequestWorker.access$600(this.this$0);
    }
    do
    {
      return;
      if (i == 3)
      {
        RequestWorker.access$700(this.this$0, (Transaction)paramMessage.obj);
        return;
      }
      if (i == 2)
      {
        RequestWorker.access$800(this.this$0);
        return;
      }
      if (i == 4)
      {
        this.this$0.engine.mConnManager.wakeupConnectionToWrite(this.this$0.mCurrentRequests, false);
        return;
      }
    } while (i != 5);
    this.this$0.engine.mConnManager.wakeupConnectionToWrite(this.this$0.mCurrentRequests, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.segment.RequestWorker.RequestHandler
 * JD-Core Version:    0.7.0.1
 */