package com.tencent.mobileqq.shortvideo.util;

import android.os.Build.VERSION;
import android.view.MotionEvent;

public class MotionEventUtil
{
  public static int a(MotionEvent paramMotionEvent)
  {
    if (Build.VERSION.SDK_INT >= 5) {
      return paramMotionEvent.getAction() & 0xFF;
    }
    return paramMotionEvent.getAction();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.MotionEventUtil
 * JD-Core Version:    0.7.0.1
 */