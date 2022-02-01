package com.tencent.mobileqq.multicard;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import java.lang.ref.WeakReference;

class MultiCardRootLayout$1
  extends GestureDetector.SimpleOnGestureListener
{
  MultiCardRootLayout$1(MultiCardRootLayout paramMultiCardRootLayout) {}
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if ((MultiCardRootLayout.a(this.a)) && (MultiCardRootLayout.a(this.a) != null))
    {
      MultiCardRootLayout.MultiCardRootLayoutListener localMultiCardRootLayoutListener = (MultiCardRootLayout.MultiCardRootLayoutListener)MultiCardRootLayout.a(this.a).get();
      if (localMultiCardRootLayoutListener != null) {
        localMultiCardRootLayoutListener.a(this.a);
      }
    }
    return super.onSingleTapConfirmed(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardRootLayout.1
 * JD-Core Version:    0.7.0.1
 */