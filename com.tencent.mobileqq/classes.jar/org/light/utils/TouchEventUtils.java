package org.light.utils;

import android.support.annotation.Keep;
import android.view.MotionEvent;

@Keep
public class TouchEventUtils
{
  @Keep
  public static final int ACTION_DOWN = 0;
  @Keep
  public static final int ACTION_ILLEGAL = -1;
  @Keep
  public static final int ACTION_MOVE = 2;
  @Keep
  public static final int ACTION_POINTER_DOWN = 3;
  @Keep
  public static final int ACTION_POINTER_UP = 4;
  @Keep
  public static final int ACTION_UP = 1;
  
  @Keep
  public static int getEventAction(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    case 3: 
    case 4: 
    default: 
      return -1;
    case 0: 
      return 0;
    case 1: 
      return 1;
    case 2: 
      return 2;
    case 5: 
      return 3;
    }
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.light.utils.TouchEventUtils
 * JD-Core Version:    0.7.0.1
 */