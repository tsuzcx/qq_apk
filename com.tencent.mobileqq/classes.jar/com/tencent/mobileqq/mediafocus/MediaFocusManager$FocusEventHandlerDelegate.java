package com.tencent.mobileqq.mediafocus;

import android.os.Handler;
import android.os.Looper;

class MediaFocusManager$FocusEventHandlerDelegate
{
  private final Handler jdField_a_of_type_AndroidOsHandler;
  
  MediaFocusManager$FocusEventHandlerDelegate(MediaFocusManager paramMediaFocusManager)
  {
    Looper localLooper2 = Looper.myLooper();
    Looper localLooper1 = localLooper2;
    if (localLooper2 == null) {
      localLooper1 = Looper.getMainLooper();
    }
    if (localLooper1 != null)
    {
      this.jdField_a_of_type_AndroidOsHandler = new MediaFocusManager.FocusEventHandlerDelegate.1(this, localLooper1, paramMediaFocusManager);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler = null;
  }
  
  Handler a()
  {
    return this.jdField_a_of_type_AndroidOsHandler;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mediafocus.MediaFocusManager.FocusEventHandlerDelegate
 * JD-Core Version:    0.7.0.1
 */