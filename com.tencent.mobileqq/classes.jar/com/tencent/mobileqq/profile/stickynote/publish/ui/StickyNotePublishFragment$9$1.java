package com.tencent.mobileqq.profile.stickynote.publish.ui;

import com.tencent.widget.XEditTextEx;

class StickyNotePublishFragment$9$1
  implements Runnable
{
  StickyNotePublishFragment$9$1(StickyNotePublishFragment.9 param9) {}
  
  public void run()
  {
    if (this.a.a.isAdded())
    {
      StickyNotePublishFragment.b(this.a.a, this.a.a.a());
      if (StickyNotePublishFragment.b(this.a.a) > 5) {
        StickyNotePublishFragment.a(this.a.a).setTextSize(24.0F);
      }
    }
    else
    {
      return;
    }
    StickyNotePublishFragment.a(this.a.a).setTextSize(28.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.stickynote.publish.ui.StickyNotePublishFragment.9.1
 * JD-Core Version:    0.7.0.1
 */