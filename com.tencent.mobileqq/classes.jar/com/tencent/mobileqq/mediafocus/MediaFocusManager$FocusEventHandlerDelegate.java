package com.tencent.mobileqq.mediafocus;

import android.os.Handler;
import android.os.Looper;

class MediaFocusManager$FocusEventHandlerDelegate
{
  private final Handler b;
  
  MediaFocusManager$FocusEventHandlerDelegate(MediaFocusManager paramMediaFocusManager)
  {
    Looper localLooper2 = Looper.myLooper();
    Looper localLooper1 = localLooper2;
    if (localLooper2 == null) {
      localLooper1 = Looper.getMainLooper();
    }
    if (localLooper1 != null)
    {
      this.b = new MediaFocusManager.FocusEventHandlerDelegate.1(this, localLooper1, paramMediaFocusManager);
      return;
    }
    this.b = null;
  }
  
  Handler a()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mediafocus.MediaFocusManager.FocusEventHandlerDelegate
 * JD-Core Version:    0.7.0.1
 */