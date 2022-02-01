package com.tencent.mobileqq.colornote.smallscreen;

import android.os.Build.VERSION;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class ColorNoteSmallScreenRelativeLayout$2
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  ColorNoteSmallScreenRelativeLayout$2(ColorNoteSmallScreenRelativeLayout paramColorNoteSmallScreenRelativeLayout) {}
  
  public void onGlobalLayout()
  {
    if (Build.VERSION.SDK_INT < 16) {
      this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
    for (;;)
    {
      ColorNoteSmallScreenRelativeLayout.a(this.a);
      return;
      this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenRelativeLayout.2
 * JD-Core Version:    0.7.0.1
 */