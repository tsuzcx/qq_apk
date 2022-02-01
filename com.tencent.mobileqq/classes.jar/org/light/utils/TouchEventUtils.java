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
    int j = paramMotionEvent.getAction() & 0xFF;
    if (j != 0)
    {
      int i = 1;
      if (j != 1)
      {
        i = 2;
        if (j != 2)
        {
          if (j != 5)
          {
            if (j != 6) {
              return -1;
            }
            return 4;
          }
          return 3;
        }
      }
      return i;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.light.utils.TouchEventUtils
 * JD-Core Version:    0.7.0.1
 */