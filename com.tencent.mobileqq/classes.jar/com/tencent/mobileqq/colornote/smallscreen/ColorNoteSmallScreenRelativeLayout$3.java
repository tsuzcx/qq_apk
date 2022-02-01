package com.tencent.mobileqq.colornote.smallscreen;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

class ColorNoteSmallScreenRelativeLayout$3
  implements ViewTreeObserver.OnPreDrawListener
{
  ColorNoteSmallScreenRelativeLayout$3(ColorNoteSmallScreenRelativeLayout paramColorNoteSmallScreenRelativeLayout) {}
  
  public boolean onPreDraw()
  {
    this.a.getViewTreeObserver().removeOnPreDrawListener(this);
    ColorNoteSmallScreenRelativeLayout.a(this.a);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenRelativeLayout.3
 * JD-Core Version:    0.7.0.1
 */