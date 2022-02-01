package com.tencent.mobileqq.flashshow.thread;

import android.os.Handler;
import android.os.Message;

final class FSThreadUtils$1
  extends Handler
{
  public void handleMessage(Message paramMessage)
  {
    FSThreadUtils.OnHandlerCallback localOnHandlerCallback = this.a;
    if (localOnHandlerCallback != null) {
      localOnHandlerCallback.a(paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.thread.FSThreadUtils.1
 * JD-Core Version:    0.7.0.1
 */