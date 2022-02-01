package com.tencent.mqq.shared_file_accessor;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class PrefEditQueueWork$WorkHandler
  extends Handler
{
  PrefEditQueueWork$WorkHandler(PrefEditQueueWork paramPrefEditQueueWork, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0) {
      PrefEditQueueWork.access$000(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mqq.shared_file_accessor.PrefEditQueueWork.WorkHandler
 * JD-Core Version:    0.7.0.1
 */