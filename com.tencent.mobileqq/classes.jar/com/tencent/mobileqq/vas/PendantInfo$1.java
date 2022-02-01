package com.tencent.mobileqq.vas;

import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.util.MqqWeakReferenceHandler;

class PendantInfo$1
  extends MqqWeakReferenceHandler
{
  PendantInfo$1(PendantInfo paramPendantInfo, Looper paramLooper, Handler.Callback paramCallback)
  {
    super(paramLooper, paramCallback);
  }
  
  public void handleMessage(Message paramMessage)
  {
    PendantInfo.a(this.a, paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.PendantInfo.1
 * JD-Core Version:    0.7.0.1
 */