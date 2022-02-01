package com.tencent.mobileqq.multicard;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View.OnLongClickListener;
import android.view.ViewParent;
import android.widget.RelativeLayout;

public class MultiCardCustomLayout
  extends RelativeLayout
{
  private View.OnLongClickListener a;
  private GestureDetector b;
  private boolean c = false;
  
  public MultiCardCustomLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public MultiCardCustomLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
    if ((this.c) && (this.b == null)) {
      this.b = new GestureDetector(getContext(), new MultiCardCustomLayout.1(this), new Handler(Looper.getMainLooper()));
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = super.dispatchTouchEvent(paramMotionEvent);
    boolean bool1 = bool2;
    if (this.c)
    {
      bool1 = bool2;
      if (this.a != null)
      {
        GestureDetector localGestureDetector = this.b;
        bool1 = bool2;
        if (localGestureDetector != null)
        {
          localGestureDetector.onTouchEvent(paramMotionEvent);
          int i = paramMotionEvent.getActionMasked();
          bool1 = true;
          if (i != 0) {
            return true;
          }
          getParent().requestDisallowInterceptTouchEvent(true);
        }
      }
    }
    return bool1;
  }
  
  public void setDispatchTouchEventOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.a = paramOnLongClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardCustomLayout
 * JD-Core Version:    0.7.0.1
 */