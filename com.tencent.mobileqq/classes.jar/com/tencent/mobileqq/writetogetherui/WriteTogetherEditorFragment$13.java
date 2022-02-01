package com.tencent.mobileqq.writetogetherui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

class WriteTogetherEditorFragment$13
  implements View.OnTouchListener
{
  WriteTogetherEditorFragment$13(WriteTogetherEditorFragment paramWriteTogetherEditorFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      WriteTogetherEditorFragment.a(this.a).setAlpha(0.5F);
    } else if (paramMotionEvent.getAction() == 1) {
      WriteTogetherEditorFragment.a(this.a).setAlpha(1.0F);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.writetogetherui.WriteTogetherEditorFragment.13
 * JD-Core Version:    0.7.0.1
 */