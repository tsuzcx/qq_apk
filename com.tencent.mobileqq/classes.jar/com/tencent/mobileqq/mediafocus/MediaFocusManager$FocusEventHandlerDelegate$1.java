package com.tencent.mobileqq.mediafocus;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class MediaFocusManager$FocusEventHandlerDelegate$1
  extends Handler
{
  MediaFocusManager$FocusEventHandlerDelegate$1(MediaFocusManager.FocusEventHandlerDelegate paramFocusEventHandlerDelegate, Looper paramLooper, MediaFocusManager paramMediaFocusManager)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    synchronized (MediaFocusManager.a(this.b.a))
    {
      MediaFocusManager.OnMediaFocusChangeListener localOnMediaFocusChangeListener = MediaFocusManager.a(this.b.a, (String)paramMessage.obj);
      if (localOnMediaFocusChangeListener != null) {
        localOnMediaFocusChangeListener.a(paramMessage.what);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mediafocus.MediaFocusManager.FocusEventHandlerDelegate.1
 * JD-Core Version:    0.7.0.1
 */