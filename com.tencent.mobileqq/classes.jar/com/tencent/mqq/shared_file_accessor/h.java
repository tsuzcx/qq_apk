package com.tencent.mqq.shared_file_accessor;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class h
  extends Handler
{
  h(f paramf, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0) {
      f.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mqq.shared_file_accessor.h
 * JD-Core Version:    0.7.0.1
 */