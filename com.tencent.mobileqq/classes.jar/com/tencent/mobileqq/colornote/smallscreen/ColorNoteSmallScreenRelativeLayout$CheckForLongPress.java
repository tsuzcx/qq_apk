package com.tencent.mobileqq.colornote.smallscreen;

import android.animation.ValueAnimator;

final class ColorNoteSmallScreenRelativeLayout$CheckForLongPress
  implements Runnable
{
  private ColorNoteSmallScreenRelativeLayout$CheckForLongPress(ColorNoteSmallScreenRelativeLayout paramColorNoteSmallScreenRelativeLayout) {}
  
  public void run()
  {
    if (ColorNoteSmallScreenRelativeLayout.a(this.this$0) != null)
    {
      ColorNoteSmallScreenRelativeLayout.a(this.this$0, true);
      ColorNoteSmallScreenRelativeLayout.b(this.this$0, true);
      ColorNoteSmallScreenRelativeLayout localColorNoteSmallScreenRelativeLayout = this.this$0;
      ColorNoteSmallScreenRelativeLayout.a(localColorNoteSmallScreenRelativeLayout, ColorNoteSmallScreenRelativeLayout.b(localColorNoteSmallScreenRelativeLayout));
      ColorNoteSmallScreenRelativeLayout.a(this.this$0).e();
      ColorNoteSmallScreenRelativeLayout.c(this.this$0).start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenRelativeLayout.CheckForLongPress
 * JD-Core Version:    0.7.0.1
 */