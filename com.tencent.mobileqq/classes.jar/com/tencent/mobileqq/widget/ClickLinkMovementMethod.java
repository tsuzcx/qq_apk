package com.tencent.mobileqq.widget;

import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import java.lang.reflect.Field;

public class ClickLinkMovementMethod
  extends LinkMovementMethod
{
  private static Field a;
  private static MovementMethod b;
  
  public static MovementMethod a()
  {
    if (b == null) {
      b = new ClickLinkMovementMethod();
    }
    return b;
  }
  
  public boolean onTouchEvent(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getActionMasked() == 1) {
      try
      {
        if (a == null) {
          a = View.class.getDeclaredField("mHasPerformedLongPress");
        }
        a.setAccessible(true);
        boolean bool = a.getBoolean(paramTextView);
        if (bool) {
          return true;
        }
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localIllegalAccessException.printStackTrace();
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        localNoSuchFieldException.printStackTrace();
      }
    }
    return super.onTouchEvent(paramTextView, paramSpannable, paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ClickLinkMovementMethod
 * JD-Core Version:    0.7.0.1
 */