package com.tencent.mobileqq.profile.stickynote.publish.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import com.etrump.mixlayout.ETTextView;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.ScrollView;
import com.tencent.widget.XEditTextEx;

class StickyNotePublishFragment$3
  implements View.OnTouchListener
{
  StickyNotePublishFragment$3(StickyNotePublishFragment paramStickyNotePublishFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (StickyNotePublishFragment.e(this.a))
    {
      StickyNotePublishFragment.b(this.a).setVisibility(8);
      InputMethodUtil.b(StickyNotePublishFragment.a(this.a));
      return false;
    }
    if (StickyNotePublishFragment.f(this.a) == 0)
    {
      StickyNotePublishFragment.b(this.a).setVisibility(8);
      StickyNotePublishFragment.c(this.a).setVisibility(8);
      StickyNotePublishFragment.d(this.a).setVisibility(8);
      StickyNotePublishFragment.a(this.a).setVisibility(0);
      StickyNotePublishFragment.a(this.a).requestFocus();
      InputMethodUtil.a(StickyNotePublishFragment.a(this.a));
      return false;
    }
    StickyNotePublishFragment.b(this.a).setVisibility(8);
    StickyNotePublishFragment.a(this.a, 0);
    this.a.a(false);
    this.a.b(false);
    this.a.c(true);
    this.a.c(0, 0);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.stickynote.publish.ui.StickyNotePublishFragment.3
 * JD-Core Version:    0.7.0.1
 */