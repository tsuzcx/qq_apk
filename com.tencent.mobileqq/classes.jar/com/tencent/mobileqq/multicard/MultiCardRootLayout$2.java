package com.tencent.mobileqq.multicard;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.tencent.widget.FitSystemWindowsRelativeLayout.DispatchTouchEventListener;
import java.lang.ref.WeakReference;

class MultiCardRootLayout$2
  implements FitSystemWindowsRelativeLayout.DispatchTouchEventListener
{
  MultiCardRootLayout$2(MultiCardRootLayout paramMultiCardRootLayout) {}
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (MultiCardRootLayout.a(this.a) != null)
    {
      MultiCardRootLayout.MultiCardRootLayoutListener localMultiCardRootLayoutListener = (MultiCardRootLayout.MultiCardRootLayoutListener)MultiCardRootLayout.a(this.a).get();
      if ((localMultiCardRootLayoutListener != null) && (localMultiCardRootLayoutListener.a(i))) {
        return true;
      }
    }
    if (MultiCardRootLayout.a(this.a) != null) {
      MultiCardRootLayout.a(this.a).onTouchEvent(paramMotionEvent);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardRootLayout.2
 * JD-Core Version:    0.7.0.1
 */